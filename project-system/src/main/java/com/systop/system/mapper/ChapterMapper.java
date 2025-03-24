package com.systop.system.mapper;

import com.systop.system.domain.Book;
import com.systop.system.domain.Chapter;

import java.util.List;

/**
 * 章节Mapper接口
 *
 * @author jinhaoyu
 * @date 2024-05-15
 */
public interface ChapterMapper
{
    /**
     * 查询章节
     *
     * @param id 章节主键
     * @return 章节
     */
    public Chapter selectChapterById(Long id);
    public Chapter selectChapterByBid(Long bookId,Long count);

    /**
     * 查询章节列表
     *
     * @param chapter 章节
     * @return 章节集合
     */
    public List<Chapter> selectChapterList(Chapter chapter);
    public List<Book> selectBookList(Book book);
    /**
     * 新增章节
     *
     * @param chapter 章节
     * @return 结果
     */
    public int insertChapter(Chapter chapter);

    /**
     * 修改章节
     *
     * @param chapter 章节
     * @return 结果
     */
    public int updateChapter(Chapter chapter);

    /**
     * 删除章节
     *
     * @param id 章节主键
     * @return 结果
     */
    public int deleteChapterById(Long id);

    /**
     * 批量删除章节
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChapterByIds(Long[] ids);
}