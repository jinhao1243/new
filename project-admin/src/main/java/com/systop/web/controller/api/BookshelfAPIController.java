package com.systop.web.controller.api;

import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.core.page.TableDataInfo;
import com.systop.system.domain.Bookshelf;
import com.systop.system.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookshelf")
public class BookshelfAPIController extends BaseController {
    @Autowired
    private IBookshelfService bookshelfService;

    /**
     * 查询书架列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Bookshelf bookshelf) {
        startPage();
        List<Bookshelf> list = bookshelfService.selectBookshelfList(bookshelf);
        return getDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookshelfService.selectBookshelfById(id));
    }

    @PostMapping("/register")
    public String register(@RequestBody Bookshelf bookshelf) {
        return bookshelfService.register(bookshelf);
    }
}
