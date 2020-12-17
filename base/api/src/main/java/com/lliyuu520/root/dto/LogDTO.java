package com.lliyuu520.root.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * account
 *
 * @author lliyuu520
 */
@Data
public class LogDTO implements Serializable {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
