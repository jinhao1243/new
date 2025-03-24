package com.systop.web.controller.api;

import com.systop.common.core.controller.BaseController;
import com.systop.common.core.page.TableDataInfo;
import com.systop.system.domain.Banner;
import com.systop.system.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/banner")
public class BannerAPIController extends BaseController {
    @Autowired
    private IBannerService bannerService;

    /**
     * 查询轮播图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Banner banner)
    {
        startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
        return getDataTable(list);
    }
}
