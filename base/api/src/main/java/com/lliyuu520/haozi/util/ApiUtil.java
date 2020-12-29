package com.lliyuu520.haozi.util;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

import java.io.File;

/**
 * ApiUtil
 *
 * @author lliyuu520
 * @since 2020/12/28:15:40
 */
public class ApiUtil {

    public static void initApDoc(String name) {


        DocsConfig config = new DocsConfig();

        final String projectPath = System.getProperty("user.dir");
        config.setProjectPath(projectPath + File.separator + name);
        config.setProjectName(name);
        config.setApiVersion("V1.0");
        config.setMvcFramework("spring");
        config.setDocsPath(projectPath + File.separator + name + File.separator + "doc");
        config.setAutoGenerate(Boolean.TRUE);
        Docs.buildHtmlDocs(config);
    }
}
