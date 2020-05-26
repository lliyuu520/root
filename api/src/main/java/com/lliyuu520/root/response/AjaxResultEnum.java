package com.lliyuu520.root.response;

/**
 * 自定义返回枚举
 * @author lliyuu520* @date 2019/6/18
 */
enum AjaxResultEnum {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 服务器异常
     */
    SERVER_EXCEPTION(500, "服务器异常"),
    /**
     * 服务器异常
     */
    SIGNATURE_EXCEPTION(501, "JWT密钥错误"),
    /**
     * 权限异常
     */
    ACCESS_DENIED_EXCEPTION(403, "权限不足"),
    /**
     * 账号密码不匹配
     */
    ACCOUNT_NOT_MATCH(1001, "账号密码不匹配"),
    /**
     * 账号密码不匹配
     */
    REPEAT_PASSWORD(1002, "新密码与老密码不能相同"),
    /**
     * 账号被锁定
     */
    LOCKED_ACCOUNT(1003, "账号被锁定"),
    /**
     * 账号被使用
     */
    REPEAT_ACCOUNT(1004, "账号被使用"),
    /**
     * 电话号码错误
     */
    ERROR_PHONE(1005, "电话格式错误"),
    /**
     * 邮箱格式错误
     */
    ERROR_MAIL(1007, "邮箱格式错误"),
    /**
     * 未登录
     */
    NO_AUTH(1008, "未登录"),
    /**
     * 角色名称被使用
     */
    REPEAT_ROLE_NAME(1009, "角色名称被使用"),
    /**
     * 登陆过期
     */
    AUTH_EXPIRED(1010, "登陆过期"),
    /**
     * token格式错误
     */
    MALFORMED_JWT(1011, "token格式错误"),
    /**
     * token格式错误
     */
    NO_DATA(1012, "无数据"),
    /**
     * 权限异常
     */
    ACCESS_EXCEPTION(1013, "权限不足");
    /**
     * key
     */
    private Integer key;
    /**
     * value
     */
    private String value;

    AjaxResultEnum(Integer key, String value) {
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
}
