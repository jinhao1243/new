package com.systop.web.controller.system;

import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.domain.model.RegisterBody;
import com.systop.common.utils.StringUtils;
import com.systop.framework.web.service.SysRegisterService;
import com.systop.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: SysRegisterController</p>
 * <p>Description: 注册验证</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/22 9:49
 */
@RestController
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
