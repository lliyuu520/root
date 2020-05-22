package com.lliyuu520.root.modular.stock.controller;


import com.lliyuu520.root.modular.stock.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class InvertoryController {

    @Autowired
    private InventoryService accountService;

    /**
     * try 写入冻结 加
     *
     * @param integralId
     * @param frozen
     * @return
     */

    @PostMapping(value = "/add")
    @Transactional(rollbackFor = Exception.class)
    public void addIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {

    }


}
