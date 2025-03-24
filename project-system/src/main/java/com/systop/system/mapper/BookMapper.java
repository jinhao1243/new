package com.systop.system.mapper;

import com.systop.system.domain.Book;
import com.systop.system.domain.Chapter;

import java.util.List;

/**
 * 小说Mapper接口
 *
 * @author jinhaoyu
 * @date 2024-05-22
 */
public interface BookMapper
{
    /**
     * 查询小说
     *
     * @param id 小说主键
     * @return 小说
     */
    public Book selectBookById(Long id);

    /**
     * 查询小说列表
     *
     * @param book 小说
     * @return 小说集合
     */
    public List<Book> selectBookList(Book book);

    /**
     * 新增小说
     *
     * @param book 小说
     * @return 结果
     */
    public int insertBook(Book book);

    /**
     * 修改小说
     *
     * @param book 小说
     * @return 结果
     */
    public int updateBook(Book book);

    /**
     * 删除小说
     *
     * @param id 小说主键
     * @return 结果
     */
    public int deleteBookById(Long id);

    /**
     * 批量删除小说
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookByIds(Long[] ids);

    /**
     * 批量删除章节
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChapterByBookIds(Long[] ids);

    /**
     * 批量新增章节
     *
     * @param chapterList 章节列表
     * @return 结果
     */
    public int batchChapter(List<Chapter> chapterList);


    /**
     * 通过小说主键删除章节信息
     *
     * @param id 小说ID
     * @return 结果
     */
    public int deleteChapterByBookId(Long id);
}
