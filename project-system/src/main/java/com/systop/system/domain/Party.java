package com.systop.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.systop.common.annotation.Excel;
import com.systop.common.core.domain.BaseEntity;

/**
 * 用户对象 party
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
public class Party extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 作者 */
    @Excel(name = "作者")
    private Long status;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 头像 */
    @Excel(name = "头像")
    private String picture;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("name", getName())
            .append("picture", getPicture())
            .toString();
    }
}
