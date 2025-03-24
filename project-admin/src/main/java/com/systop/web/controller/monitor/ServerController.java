package com.systop.web.controller.monitor;

import com.systop.common.core.domain.AjaxResult;
import com.systop.framework.web.domain.Server;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: ServerController</p>
 * <p>Description: 服务器监控</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/22 9:06
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController {
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public AjaxResult getInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        return AjaxResult.success(server);
    }
}
