package com.systop.web.controller.api;

import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.page.TableDataInfo;
import com.systop.system.domain.Chapter;
import com.systop.system.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/chapter")
public class ChapterAPLController extends BaseController {
    @Autowired
    private IChapterService chapterService;

    /**
     * 查询章节列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Chapter chapter)
    {
        startPage();
        List<Chapter> list = chapterService.selectChapterList(chapter);
        return getDataTable(list);
    }

    @GetMapping(value = "/{arg0}/{arg1}")
    public AjaxResult getInfo(@PathVariable("arg0") Long bookId, @PathVariable("arg1") Long count)
    {
        return success(chapterService.selectChapterByBid(bookId,count));
    }



}
