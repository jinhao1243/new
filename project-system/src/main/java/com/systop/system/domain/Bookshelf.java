package com.systop.system.domain;

import com.systop.common.annotation.Excel;
import com.systop.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 书架对象 bookshelf
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
public class Bookshelf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 书架id */
    private Long id;

    /** 小说id */
    @Excel(name = "小说id")
    private Long bookId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户信息 */
    private List<Party> partyList;

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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public List<Party> getPartyList()
    {
        return partyList;
    }

    public void setPartyList(List<Party> partyList)
    {
        this.partyList = partyList;
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
            .append("userId", getUserId())
            .append("partyList", getPartyList())
            .append("bookList", getBookList())
            .toString();
    }
}
