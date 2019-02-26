package com.carlab.db;

public class SysProperty {
    private String key;

    private String value;

    private String describe;

    public SysProperty(String key, String value, String describe) {
        this.key = key;
        this.value = value;
        this.describe = describe;
    }

    public SysProperty() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append(", describe=").append(describe);
        sb.append("]");
        return sb.toString();
    }
}