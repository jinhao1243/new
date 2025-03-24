package com.systop.system.service;

import com.systop.system.domain.Book;
import com.systop.system.domain.Bookshelf;
import com.systop.system.domain.Party;

import java.util.List;

/**
 * 书架Service接口
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
public interface IBookshelfService 
{
    String register(Bookshelf bookshelf);
    /**
     * 查询书架
     * 
     * @param id 书架主键
     * @return 书架
     */
    public List<Bookshelf> selectBookshelfById(Long id);

    /**
     * 查询书架列表
     * 
     * @param bookshelf 书架
     * @return 书架集合
     */
    public List<Bookshelf> selectBookshelfList(Bookshelf bookshelf);
    public List<Book> selectBookList(Book book);
    public List<Party> selectPartyList(Party party);
    /**
     * 新增书架
     * 
     * @param bookshelf 书架
     * @return 结果
     */
    public int insertBookshelf(Bookshelf bookshelf);

    /**
     * 修改书架
     * 
     * @param bookshelf 书架
     * @return 结果
     */
    public int updateBookshelf(Bookshelf bookshelf);

    /**
     * 批量删除书架
     * 
     * @param ids 需要删除的书架主键集合
     * @return 结果
     */
    public int deleteBookshelfByIds(Long[] ids);

    /**
     * 删除书架信息
     * 
     * @param id 书架主键
     * @return 结果
     */
    public int deleteBookshelfById(Long id);
}
