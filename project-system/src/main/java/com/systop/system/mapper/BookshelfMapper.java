package com.systop.system.mapper;

import com.systop.system.domain.Book;
import com.systop.system.domain.Bookshelf;
import com.systop.system.domain.Party;

import java.util.List;

/**
 * 书架Mapper接口
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
public interface BookshelfMapper 
{
    /**
     * 查询书架
     * 
     * @param id 书架主键
     * @return 书架
     */
    public List<Bookshelf> selectBookshelfById(Long id);
    int addUser(Bookshelf bookshelf);
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
     * 删除书架
     * 
     * @param id 书架主键
     * @return 结果
     */
    public int deleteBookshelfById(Long id);

    /**
     * 批量删除书架
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookshelfByIds(Long[] ids);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePartyByIds(Long[] ids);
    
    /**
     * 批量新增用户
     * 
     * @param partyList 用户列表
     * @return 结果
     */
    public int batchParty(List<Party> partyList);
    

    /**
     * 通过书架主键删除用户信息
     * 
     * @param id 书架ID
     * @return 结果
     */
    public int deletePartyById(Long id);
}
