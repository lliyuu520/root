package com.lliyuu520.haozi.core.log;

/**
 * 业务操作类型
 *
 * @author csy
 */
public enum LogType {


    /**
     * 其它
     */
    OTHER(0, "其他"),

    /**
     * 新增
     */
    INSERT(1, "新增"),

    /**
     * 修改
     */
    EDIT(2, "编辑"),

    /**
     * 删除
     */
    DELETE(4, "删除"),
    /**
     * 查看列表
     */
    LIST(6, "查看列表"),
    /**
     * 查看详情
     */
    DETAIL(7, "查看详情"),


    /**
     * 登录
     */
    LOGIN(8, "登录"),

    /**
     * 登出
     */
    LOGOUT(9, "登出"),
    /**
     * 重置密码
     */
    RESET_PASSWORD(10, "重置密码"),

    /**
     * 重置密码
     */
    CHANGE_PASSWORD(11, "修改密码"),
    /**
     * 锁定账户
     */
    LOCK_USER(12, "锁定用户"),
    /**
     * 解锁账户
     */
    UN_LOCK_USER(13, "解锁用户");
    /**
     * key
     */
    private Integer key;
    /**
     * value
     */
    private String value;

    LogType(Integer key, String value) {
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
            for (LogType s : LogType.values()) {
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
