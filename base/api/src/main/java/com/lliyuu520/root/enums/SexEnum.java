package com.lliyuu520.root.enums;

/**
 * 性别状态
 *
 * @author liliagnyu
 */
public enum SexEnum {
    /**
     * 锁定
     */
    NONE(0, "未知"),

    /**
     * 锁定
     */
    MALE(1, "男"),
    /**
     * 未锁定
     */
    FEMALE(2, "女");

    /**
     * key
     */
    private Integer key;
    /**
     * value
     */
    private String value;

    SexEnum(Integer key, String value) {
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
            for (SexEnum s : SexEnum.values()) {
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
