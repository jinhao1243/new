package com.systop.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.systop.common.annotation.Excel;
import com.systop.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 章节对象 chapter
 *
 * @author jinhaoyu
 * @date 2024-05-15
 */
public class Chapter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 章节id */
    private Long id;

    /** 小说id */
    @Excel(name = "小说id")
    private Long bookId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String text;

    /** 章节数 */
    @Excel(name = "章节数")
    private Long count;

    private List<Book> bookList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBookId(Long bookId)
    {
        this.bookId = bookId;
    }

    public Long getBookId()
    {
        return bookId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }
    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getCount()
    {
        return count;
    }
    public List<Book> getBookList()
    {
        return bookList;
    }

    public void setBookList(List<Book> bookList)
    {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bookId", getBookId())
                .append("title", getTitle())
                .append("text", getText())
                .append("count", getCount())
                .append("bookList", getBookList())
                .toString();
    }
}