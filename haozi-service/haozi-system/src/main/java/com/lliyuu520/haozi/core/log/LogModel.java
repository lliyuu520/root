package com.lliyuu520.haozi.core.log;

/**
 * 业务操作类型
 *
 * @author csy
 */
public enum LogModel {
    /**
     * 系统
     */
    OTHER(-1, "其他"),

    /**
     * 系统
     */
    SYSTEM(0, "系统"),

    /**
     * 用户
     */
    USER(1, "用户"),

    /**
     * 修改
     */
    ROLE(2, "角色"),

    /**
     * 字典
     */
    DICT(4, "字典"),
    /**
     * 部门
     */
    DEPT(5, "部门");


    /**
     * key
     */
    private Integer key;
    /**
     * value
     */
    private String value;

    LogModel(Integer key, String value) {
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
            for (LogModel s : LogModel.values()) {
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
