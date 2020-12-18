package com.lliyuu520.root;


import com.lliyuu520.root.utils.StartCommand;
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
@MapperScan("com/lliyuu520/root/modular/**/mapper")
public class AreaApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        DocsConfig config = new DocsConfig();
        config.setProjectPath("/Users/liliangyu/Documents/github/root/area");
        config.setProjectName("ProjectName");
        config.setApiVersion("V1.0");
        config.setDocsPath("/Users/liliangyu/Documents/github/root/area/apidocs");
//        config.setResourcePath("/Users/yeguozhong/Desktop/gitLibrary/JApiDocs/library/src/main/resources");

        config.setAutoGenerate(Boolean.TRUE);
        Docs.buildHtmlDocs(config);

        SpringApplication.run(AreaApplication.class, args);
    }


}
