package com.lliyuu520.haozi;


import com.lliyuu520.haozi.utils.StartCommand;
import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
@EnableTransactionManagement
@MapperScan("com/lliyuu520/haozi/modular/**/mapper")
public class AreaApplication {

    public static void main(String[] args) {
        new StartCommand(args);
//        DocsConfig config = new DocsConfig();
//        config.setProjectPath("/Users/liliangyu/Documents/github/haozi/area");
//        config.setProjectName("ProjectName");
//        config.setApiVersion("V1.0");
//        config.setDocsPath("/Users/liliangyu/Documents/github/haozi/area/apidocs");
//        config.setAutoGenerate(Boolean.TRUE);
//        Docs.buildHtmlDocs(config);

        SpringApplication.run(AreaApplication.class, args);
    }


}
