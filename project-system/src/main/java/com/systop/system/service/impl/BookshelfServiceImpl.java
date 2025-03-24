package com.systop.system.service.impl;

import com.systop.common.utils.StringUtils;
import com.systop.system.domain.Book;
import com.systop.system.domain.Bookshelf;
import com.systop.system.domain.Party;
import com.systop.system.mapper.BookMapper;
import com.systop.system.mapper.BookshelfMapper;
import com.systop.system.mapper.PartyMapper;
import com.systop.system.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 书架Service业务层处理
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
@Service
public class BookshelfServiceImpl implements IBookshelfService 
{
    @Autowired
    private BookshelfMapper bookshelfMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PartyMapper partyMapper;
    /**
     * 查询书架
     * 
     * @param id 书架主键
     * @return 书架
     */
    @Override
    public List<Bookshelf> selectBookshelfById(Long id)
    {
        return bookshelfMapper.selectBookshelfById(id);
    }
    /**
     * 注册方法   （添加用户名字的区别）
     * @param bookshelf
     * @return
     */
    @Override
    public String register(Bookshelf bookshelf) {
        int rows = bookshelfMapper.addUser(bookshelf);
        if (rows <= 0) {
            return "注册失败";
        }
        return "添加成功";
    }
    /**
     * 查询书架列表
     * 
     * @param bookshelf 书架
     * @return 书架
     */
    @Override
    public List<Bookshelf> selectBookshelfList(Bookshelf bookshelf)
    {
        return bookshelfMapper.selectBookshelfList(bookshelf);
    }
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }
    @Override
    public List<Party> selectPartyList(Party party)
    {
        return partyMapper.selectPartyList(party);
    }
    /**
     * 新增书架
     * 
     * @param bookshelf 书架
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBookshelf(Bookshelf bookshelf)
    {
        int rows = bookshelfMapper.insertBookshelf(bookshelf);
        insertParty(bookshelf);
        return rows;
    }

    /**
     * 修改书架
     * 
     * @param bookshelf 书架
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBookshelf(Bookshelf bookshelf)
    {
        bookshelfMapper.deletePartyById(bookshelf.getId());
        insertParty(bookshelf);
        return bookshelfMapper.updateBookshelf(bookshelf);
    }

    /**
     * 批量删除书架
     * 
     * @param ids 需要删除的书架主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBookshelfByIds(Long[] ids)
    {
        bookshelfMapper.deletePartyByIds(ids);
        return bookshelfMapper.deleteBookshelfByIds(ids);
    }

    /**
     * 删除书架信息
     * 
     * @param id 书架主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBookshelfById(Long id)
    {
        bookshelfMapper.deletePartyById(id);
        return bookshelfMapper.deleteBookshelfById(id);
    }

    /**
     * 新增用户信息
     * 
     * @param bookshelf 书架对象
     */
    public void insertParty(Bookshelf bookshelf)
    {
        List<Party> partyList = bookshelf.getPartyList();
        Long id = bookshelf.getId();
        if (StringUtils.isNotNull(partyList))
        {
            List<Party> list = new ArrayList<Party>();
            for (Party party : partyList)
            {
                party.setId(id);
                list.add(party);
            }
            if (list.size() > 0)
            {
                bookshelfMapper.batchParty(list);
            }
        }
    }
}
