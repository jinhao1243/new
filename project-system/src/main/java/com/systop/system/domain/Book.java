package com.systop.system.domain;

import com.systop.common.annotation.Excel;
import com.systop.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 小说对象 book
 *
 * @author jinhaoyu
 * @date 2024-05-22
 */
public class Book extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小说id */
    private Long id;

    /** 书名 */
    @Excel(name = "书名")
    private String name;

    /** 封皮 */
    @Excel(name = "封皮")
    private String headerImg;

    /** 介绍 */
    @Excel(name = "介绍")
    private String introduction;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 作者id */
    @Excel(name = "作者id")
    private Long authorIdn;

    /** 类型 */
    @Excel(name = "类型")
    private String types;

    /** 字数 */
    @Excel(name = "字数")
    private String words;

    /** 章节信息 */
    private List<Chapter> chapterList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setHeaderImg(String headerImg)
    {
        this.headerImg = headerImg;
    }

    public String getHeaderImg()
    {
        return headerImg;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setAuthorIdn(Long authorIdn)
    {
        this.authorIdn = authorIdn;
    }

    public Long getAuthorIdn()
    {
        return authorIdn;
    }
    public void setTypes(String types)
    {
        this.types = types;
    }

    public String getTypes()
    {
        return types;
    }
    public void setWords(String words)
    {
        this.words = words;
    }

    public String getWords()
    {
        return words;
    }

    public List<Chapter> getChapterList()
    {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList)
    {
        this.chapterList = chapterList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("headerImg", getHeaderImg())
                .append("introduction", getIntroduction())
                .append("status", getStatus())
                .append("authorIdn", getAuthorIdn())
                .append("types", getTypes())
                .append("words", getWords())
                .append("chapterList", getChapterList())
                .toString();
    }
}
