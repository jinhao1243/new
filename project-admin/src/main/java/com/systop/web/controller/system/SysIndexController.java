package com.systop.web.controller.system;

import com.systop.common.config.ProjectConfig;
import com.systop.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: SysIndexController</p>
 * <p>Description: 首页</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/22 9:24
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private ProjectConfig projectConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", projectConfig.getName(), projectConfig.getVersion());
    }
}
