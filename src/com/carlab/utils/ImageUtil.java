package com.carlab.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.carlab.db.UserCarPicture;
import com.carlab.exception.UploadImgException;

public class ImageUtil {
	final public static String allow_suffix_List="jpg,gif,png,jpeg";  
	
	private static boolean checkFileSuffix(String suffix){  
        return allow_suffix_List.contains(suffix.trim().toLowerCase());
	}  
	
	public static void showByImageIO(String filePath, OutputStream ops) throws IOException{
		File file = new File(filePath);
		BufferedImage image = ImageIO.read(file);
		ImageIO.write(image, "png", ops);
	}
	
	public static void showByIOStream(String filePath, OutputStream ops) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
        int count = 0;
        byte[] buffer = new byte[1024 * 1024];
        while ((count = fis.read(buffer)) != -1) {
	        	ops.write(buffer, 0, count);
	        	ops.flush();
        }
	}
	
	public static List<UserCarPicture> uploadImageByThumbnails(MultipartHttpServletRequest request, String uploadPath) throws UploadImgException, IOException {
		return uploadImage(request, uploadPath, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException {
				Thumbnails.of(multipartFile.getInputStream()).scale(1.0).toFile(uploadPath);
            } 
		});
	}

	public static List<UserCarPicture> uploadImageByImageIO(MultipartHttpServletRequest request, String uploadPath) throws UploadImgException, IOException {
		return uploadImage(request, uploadPath, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException {
                BufferedImage img = ImageIO.read(multipartFile.getInputStream());
                BufferedImage inputbig = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
                Graphics2D g = (Graphics2D) inputbig.getGraphics();
                g.drawImage(img, 0, 0,img.getWidth(),img.getHeight(),null); //画图
                g.dispose();
                inputbig.flush();
                ImageIO.write(inputbig, "JPEG", new File(uploadPath));
            }
		});
	}
	
	@SuppressWarnings("resource")
	public static List<UserCarPicture> uploadImageByIOStream(MultipartHttpServletRequest request, String uploadPath) throws UploadImgException, IOException {
		return uploadImage(request, uploadPath, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException  {
				InputStream is = null;  
	            OutputStream os = null;  
	            is = multipartFile.getInputStream();  
	            os = new FileOutputStream(uploadPath);  
	            byte[] buffer = new byte[1024];  
	            int len = 0;  
	                
	            while((len = is.read(buffer))>0){  
	              os.write(buffer, 0, len);  
	              os.flush();
	            } 
			}
		});
	}
	
	private static List<UserCarPicture> uploadImage(MultipartHttpServletRequest request, String uploadPath, UploadMethod method) throws IOException, UploadImgException{
		List<UserCarPicture> userCarPictures = new ArrayList<UserCarPicture>();
		List<MultipartFile> multipartFiles = request.getFiles("file"); 
	    	for(MultipartFile multipartFile : multipartFiles) { 
	        if (StringUtils.isNotEmpty(multipartFile.getOriginalFilename())) {  
	            String filename = multipartFile.getOriginalFilename();  
	            String suffix = filename.substring(filename.lastIndexOf(".")+1, filename.length());
	            if(checkFileSuffix(suffix)) {
	            		String dateStr = DateUtils.fmtyyyyMMddHHmmss(new Date());
	                String newFileName = dateStr + "_"+filename;
	                newFileName.replace(" ", "");
	                method.upload(multipartFile, uploadPath+newFileName);
	                UserCarPicture userCarPicture = CarlabHelper.assembleUserCarPicture(null, filename, newFileName, uploadPath+newFileName);
	                userCarPictures.add(userCarPicture);
	            } else 
	            		throw new UploadImgException("picture type must be \"jpg,gif,png,jpeg\"");
	        } else 
	        		throw new UploadImgException("picture must have a name");
	    	}
	    	return userCarPictures;
	}
	
	private interface UploadMethod {
		void upload(MultipartFile multipartFile, String uploadPath) throws IOException;
	}
}
