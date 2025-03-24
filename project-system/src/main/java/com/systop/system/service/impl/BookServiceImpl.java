package com.systop.system.service.impl;

import com.systop.common.utils.StringUtils;
import com.systop.system.domain.Book;
import com.systop.system.domain.Chapter;
import com.systop.system.mapper.BookMapper;
import com.systop.system.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 小说Service业务层处理
 *
 * @author jinhaoyu
 * @date 2024-05-22
 */
@Service
public class BookServiceImpl implements IBookService
{
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询小说
     *
     * @param id 小说主键
     * @return 小说
     */
    @Override
    public Book selectBookById(Long id)
    {
        return bookMapper.selectBookById(id);
    }

    /**
     * 查询小说列表
     *
     * @param book 小说
     * @return 小说
     */
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增小说
     *
     * @param book 小说
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBook(Book book)
    {
        int rows = bookMapper.insertBook(book);
        insertChapter(book);
        return rows;
    }

    /**
     * 修改小说
     *
     * @param book 小说
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBook(Book book)
    {
        bookMapper.deleteChapterByBookId(book.getId());
        insertChapter(book);
        return bookMapper.updateBook(book);
    }

    /**
     * 批量删除小说
     *
     * @param ids 需要删除的小说主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBookByIds(Long[] ids)
    {
        bookMapper.deleteChapterByBookIds(ids);
        return bookMapper.deleteBookByIds(ids);
    }

    /**
     * 删除小说信息
     *
     * @param id 小说主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBookById(Long id)
    {
        bookMapper.deleteChapterByBookId(id);
        return bookMapper.deleteBookById(id);
    }

    /**
     * 新增章节信息
     *
     * @param book 小说对象
     */
    public void insertChapter(Book book)
    {
        List<Chapter> chapterList = book.getChapterList();
        Long id = book.getId();
        if (StringUtils.isNotNull(chapterList))
        {
            List<Chapter> list = new ArrayList<Chapter>();
            for (Chapter chapter : chapterList)
            {
                chapter.setBookId(id);
                list.add(chapter);
            }
            if (list.size() > 0)
            {
                bookMapper.batchChapter(list);
            }
        }
    }
}
