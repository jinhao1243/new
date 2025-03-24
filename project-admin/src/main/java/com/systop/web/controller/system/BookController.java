package com.systop.system.controller;

import com.systop.common.annotation.Log;
import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.page.TableDataInfo;
import com.systop.common.enums.BusinessType;
import com.systop.common.utils.poi.ExcelUtil;
import com.systop.system.domain.Book;
import com.systop.system.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 小说Controller
 *
 * @author jinhaoyu
 * @date 2024-05-22
 */
@RestController
@RequestMapping("/system/book")
public class BookController extends BaseController
{
    @Autowired
    private IBookService bookService;

    /**
     * 查询小说列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(Book book)
    {
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

    /**
     * 导出小说列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:export')")
    @Log(title = "小说", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        util.exportExcel(response, list, "小说数据");
    }

    /**
     * 获取小说详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bookService.selectBookById(id));
    }

    /**
     * 新增小说
     */
    @PreAuthorize("@ss.hasPermi('system:book:add')")
    @Log(title = "小说", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Book book)
    {
        return toAjax(bookService.insertBook(book));
    }

    /**
     * 修改小说
     */
    @PreAuthorize("@ss.hasPermi('system:book:edit')")
    @Log(title = "小说", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除小说
     */
    @PreAuthorize("@ss.hasPermi('system:book:remove')")
    @Log(title = "小说", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bookService.deleteBookByIds(ids));
    }
}
