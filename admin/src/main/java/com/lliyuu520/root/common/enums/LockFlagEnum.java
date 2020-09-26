package com.lliyuu520.root.common.enums;

/**
 * 锁定状态
 *
 * @author liliagnyu
 */
public enum LockFlagEnum {


    /**
     * 锁定
     */
    LOCK(1, "锁定"),
    /**
     * 未锁定
     */
    UN_LOCK(0, "未锁定");


    private Integer key;

    private String value;

    LockFlagEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 获得值
     *
     * @param key
     * @return
     */
    public static String valueOf(Integer key) {
        if (key == null) {
            return "";
        } else {
            for (LockFlagEnum s : LockFlagEnum.values()) {
                if (s.getKey().equals(key)) {
                    return s.getValue();
                }
            }
            return "";
        }
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
