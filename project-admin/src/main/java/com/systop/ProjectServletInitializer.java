package com.systop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>ClassName: ProjectServletInitializer</p>
 * <p>Description: web容器中进行部署</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/22 8:39
 */
public class ProjectServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectApplication.class);
    }

}
