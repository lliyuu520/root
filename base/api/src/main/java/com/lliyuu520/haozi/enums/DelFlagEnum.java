package com.lliyuu520.haozi.enums;

/**
 * 删除枚举
 *
 * @author liliagnyu
 */
public enum DelFlagEnum {


    /**
     * 删除
     *
     */
    DELETE(1, "删除"),
    /**
     * 正常
     */
    NONE(0, "正常");



    private Integer key;

    private String value;

    DelFlagEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
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

    /**
     * 获得值
     * @param key
     * @return
     */
    public static String valueOf(Integer key) {
        if (key == null) {
            return "";
        } else {
            for (DelFlagEnum s : DelFlagEnum.values()) {
                if (s.getKey().equals(key)) {
                    return s.getValue();
                }
            }
            return "";
        }
    }
}
