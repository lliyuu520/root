package com.lliyuu520.root.modular.system.controller;


import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.modular.system.dto.AuthDTO;
import com.lliyuu520.root.modular.system.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权
 *
 * @author liliangyu
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    /**
     * @param authDTO 登录模型
     *                登录
     */
    @BusinessLog(model = LogModel.SYSTEM, type = LogType.LOGIN)
    @PostMapping(value = "/auth")
    public String auth(@RequestBody AuthDTO authDTO) {
        // 登录成功会返回Token给用户
        String username = authDTO.getUsername();
        String password = authDTO.getPassword();
        String login = authService.login(username, password);
        return login;


    }


}
