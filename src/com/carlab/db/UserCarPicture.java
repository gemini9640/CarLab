package com.carlab.db;

public class UserCarPicture {
    private Integer id;

    private Integer userCarId;

    private String nameOld;

    private String nameNew;

    private String path;

    public UserCarPicture(Integer id, Integer userCarId, String nameOld, String nameNew, String path) {
        this.id = id;
        this.userCarId = userCarId;
        this.nameOld = nameOld;
        this.nameNew = nameNew;
        this.path = path;
    }

    public UserCarPicture() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userCarId=").append(userCarId);
        sb.append(", nameOld=").append(nameOld);
        sb.append(", nameNew=").append(nameNew);
        sb.append(", path=").append(path);
        sb.append("]");
        return sb.toString();
    }
}