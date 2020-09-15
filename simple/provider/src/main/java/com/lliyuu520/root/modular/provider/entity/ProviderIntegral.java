package com.lliyuu520.root.modular.provider.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 *
 * @author lliyuu520*/
@Data
@Entity
public class ProviderIntegral implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * name
     */
    private String name;
    /**
     * 积分
     */
    private Integer score;




}
