package com.systop.system.service.impl;

import com.systop.system.domain.Book;
import com.systop.system.domain.Chapter;
import com.systop.system.mapper.ChapterMapper;
import com.systop.system.mapper.BookMapper;
import com.systop.system.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 章节Service业务层处理
 *
 * @author jinhaoyu
 * @date 2024-05-15
 */
@Service
public class ChapterServiceImpl implements IChapterService
{
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询章节
     *
     * @param id 章节主键
     * @return 章节
     */
    @Override
    public Chapter selectChapterById(Long id)
    {
        return chapterMapper.selectChapterById(id);
    }
    @Override
    public Chapter selectChapterByBid(Long bookId,Long count)
    {
        return chapterMapper.selectChapterByBid(bookId,count);
    }
    /**
     * 查询章节列表
     *
     * @param chapter 章节
     * @return 章节
     */
    @Override
    public List<Chapter> selectChapterList(Chapter chapter)
    {
        return chapterMapper.selectChapterList(chapter);
    }
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增章节
     *
     * @param chapter 章节
     * @return 结果
     */
    @Override
    public int insertChapter(Chapter chapter)
    {
        return chapterMapper.insertChapter(chapter);
    }

    /**
     * 修改章节
     *
     * @param chapter 章节
     * @return 结果
     */
    @Override
    public int updateChapter(Chapter chapter)
    {
        return chapterMapper.updateChapter(chapter);
    }

    /**
     * 批量删除章节
     *
     * @param ids 需要删除的章节主键
     * @return 结果
     */
    @Override
    public int deleteChapterByIds(Long[] ids)
    {
        return chapterMapper.deleteChapterByIds(ids);
    }

    /**
     * 删除章节信息
     *
     * @param id 章节主键
     * @return 结果
     */
    @Override
    public int deleteChapterById(Long id)
    {
        return chapterMapper.deleteChapterById(id);
    }
}