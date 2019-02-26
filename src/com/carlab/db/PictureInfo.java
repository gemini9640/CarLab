package com.carlab.db;

import java.util.Date;

public class PictureInfo {
    private String id;

    private String nameOld;

    private String nameNew;

    private String path;

    private String reference;

    private Date createTime;

    public PictureInfo(String id, String nameOld, String nameNew, String path, String reference, Date createTime) {
        this.id = id;
        this.nameOld = nameOld;
        this.nameNew = nameNew;
        this.path = path;
        this.reference = reference;
        this.createTime = createTime;
    }

    public PictureInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNameOld() {
        return nameOld;
    }

    public void setNameOld(String nameOld) {
        this.nameOld = nameOld == null ? null : nameOld.trim();
    }

    public String getNameNew() {
        return nameNew;
    }

    public void setNameNew(String nameNew) {
        this.nameNew = nameNew == null ? null : nameNew.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nameOld=").append(nameOld);
        sb.append(", nameNew=").append(nameNew);
        sb.append(", path=").append(path);
        sb.append(", reference=").append(reference);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}