package com.lliyuu520.haozi;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.CharsetUtil;
import com.lliyuu520.haozi.utils.StartCommand;
import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
public class AreaApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        DocsConfig config = new DocsConfig();
        final String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath + File.separator + "area");
        config.setProjectPath(projectPath + File.separator + "area");
        config.setProjectName("area");
        config.setApiVersion("V1.0");
        config.setMvcFramework("spring");
        config.setDocsPath(projectPath + File.separator + "doc");
        config.setAutoGenerate(Boolean.TRUE);
        Docs.buildHtmlDocs(config);

        SpringApplication.run(AreaApplication.class, args);
    }


}
