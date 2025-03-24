package com.systop.web.controller.system;

import com.systop.common.annotation.Log;
import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.page.TableDataInfo;
import com.systop.common.enums.BusinessType;
import com.systop.common.utils.poi.ExcelUtil;
import com.systop.system.domain.Bookshelf;
import com.systop.system.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 书架Controller
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
@RestController
@RequestMapping("/system/bookshelf")
public class BookshelfController extends BaseController
{
    @Autowired
    private IBookshelfService bookshelfService;

    /**
     * 查询书架列表
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:list')")
    @GetMapping("/list")
    public TableDataInfo list(Bookshelf bookshelf)
    {
        startPage();
        List<Bookshelf> list = bookshelfService.selectBookshelfList(bookshelf);
        return getDataTable(list);
    }

    /**
     * 导出书架列表
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:export')")
    @Log(title = "书架", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Bookshelf bookshelf)
    {
        List<Bookshelf> list = bookshelfService.selectBookshelfList(bookshelf);
        ExcelUtil<Bookshelf> util = new ExcelUtil<Bookshelf>(Bookshelf.class);
        util.exportExcel(response, list, "书架数据");
    }

    /**
     * 获取书架详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bookshelfService.selectBookshelfById(id));
    }

    /**
     * 新增书架
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:add')")
    @Log(title = "书架", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Bookshelf bookshelf)
    {
        return toAjax(bookshelfService.insertBookshelf(bookshelf));
    }

    /**
     * 修改书架
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:edit')")
    @Log(title = "书架", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Bookshelf bookshelf)
    {
        return toAjax(bookshelfService.updateBookshelf(bookshelf));
    }

    /**
     * 删除书架
     */
    @PreAuthorize("@ss.hasPermi('system:bookshelf:remove')")
    @Log(title = "书架", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bookshelfService.deleteBookshelfByIds(ids));
    }
}
