package com.systop.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.systop.common.annotation.Excel;
import com.systop.common.core.domain.BaseEntity;

/**
 * 轮播图对象 banner
 * 
 * @author jinhaoyu
 * @date 2024-05-10
 */
public class Banner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图id */
    private Long id;

    /** 图片 */
    @Excel(name = "图片")
    private String bannerImage;

    /** 轮播图备注 */
    @Excel(name = "轮播图备注")
    private String bannerName;

    /** 轮播图状态 */
    @Excel(name = "轮播图状态")
    private Long bannerStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBannerImage(String bannerImage) 
    {
        this.bannerImage = bannerImage;
    }

    public String getBannerImage() 
    {
        return bannerImage;
    }
    public void setBannerName(String bannerName) 
    {
        this.bannerName = bannerName;
    }

    public String getBannerName() 
    {
        return bannerName;
    }
    public void setBannerStatus(Long bannerStatus) 
    {
        this.bannerStatus = bannerStatus;
    }

    public Long getBannerStatus() 
    {
        return bannerStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bannerImage", getBannerImage())
            .append("bannerName", getBannerName())
            .append("bannerStatus", getBannerStatus())
            .toString();
    }
}
