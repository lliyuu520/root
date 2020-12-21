package com.lliyuu520.haozi.core.init;

import com.lliyuu520.haozi.modular.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * LoadDefaultUser
 *
 * @author lliyuu520
 * @since 2020/11/10:15:33
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class LoadDefaultUser  implements CommandLineRunner {
private final SysUserService sysUserService;
    @Override
    public void run(String... args) throws Exception {
        sysUserService.loadDefaultUser();
    }
}
