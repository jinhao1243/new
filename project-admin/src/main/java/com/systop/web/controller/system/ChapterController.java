package com.systop.web.controller.system;

import com.systop.common.annotation.Log;
import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.page.TableDataInfo;
import com.systop.common.enums.BusinessType;
import com.systop.common.utils.poi.ExcelUtil;
import com.systop.system.domain.Chapter;
import com.systop.system.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 章节Controller
 *
 * @author jinhaoyu
 * @date 2024-05-15
 */
@RestController
@RequestMapping("/system/chapter")
public class ChapterController extends BaseController
{
    @Autowired
    private IChapterService chapterService;

    /**
     * 查询章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:list')")
    @GetMapping("/list")
    public TableDataInfo list(Chapter chapter)
    {
        startPage();
        List<Chapter> list = chapterService.selectChapterList(chapter);
        return getDataTable(list);
    }

    /**
     * 导出章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:export')")
    @Log(title = "章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Chapter chapter)
    {
        List<Chapter> list = chapterService.selectChapterList(chapter);
        ExcelUtil<Chapter> util = new ExcelUtil<Chapter>(Chapter.class);
        util.exportExcel(response, list, "章节数据");
    }

    /**
     * 获取章节详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chapterService.selectChapterById(id));
    }

    /**
     * 新增章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:add')")
    @Log(title = "章节", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Chapter chapter)
    {
        return toAjax(chapterService.insertChapter(chapter));
    }

    /**
     * 修改章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:edit')")
    @Log(title = "章节", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Chapter chapter)
    {
        return toAjax(chapterService.updateChapter(chapter));
    }

    /**
     * 删除章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:remove')")
    @Log(title = "章节", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chapterService.deleteChapterByIds(ids));
    }
}