package com.lliyuu520.haozi.modular.system.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象构造器
 * @author Binary Wang(https://github.com/binarywang)
 */
public abstract class AbstractBuilder {
    /**
     * 构造返回信息
     * @param content
     * @param wxMessage
     * @param service
     * @return
     */
    public abstract WxMpXmlOutMessage build(String content,
                                            WxMpXmlMessage wxMessage, WxMpService service);
}
