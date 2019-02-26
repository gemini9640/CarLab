package com.carlab.db;

import java.util.Date;

public class WebStatic {
    private String id;

    private String parentid;

    private String type;

    private String mainTitle;

    private String subTitle;

    private String content;

    private String pictureId;

    private String operator;

    private String ip;

    private Date createtime;

    private String status;

    public WebStatic(String id, String parentid, String type, String mainTitle, String subTitle, String content, String pictureId, String operator, String ip, Date createtime, String status) {
        this.id = id;
        this.parentid = parentid;
        this.type = type;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.content = content;
        this.pictureId = pictureId;
        this.operator = operator;
        this.ip = ip;
        this.createtime = createtime;
        this.status = status;
    }

    public WebStatic() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId == null ? null : pictureId.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentid=").append(parentid);
        sb.append(", type=").append(type);
        sb.append(", mainTitle=").append(mainTitle);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", content=").append(content);
        sb.append(", pictureId=").append(pictureId);
        sb.append(", operator=").append(operator);
        sb.append(", ip=").append(ip);
        sb.append(", createtime=").append(createtime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}