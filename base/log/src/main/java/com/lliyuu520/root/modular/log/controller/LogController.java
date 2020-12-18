package com.lliyuu520.root.modular.log.controller;


import com.lliyuu520.root.modular.log.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/seataAccount")
@Slf4j
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;


}
