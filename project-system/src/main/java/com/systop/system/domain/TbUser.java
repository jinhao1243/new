package com.systop.system.domain;

import com.systop.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户实体类
 * @author 孙伟光
 * @date 2024-03-29
 */

public class TbUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private  Integer status;

    private String name;

    private String picture;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("status", getStatus())
                .append("name", getName())
                .append("picture", getPicture())
                .toString();
    }

}
