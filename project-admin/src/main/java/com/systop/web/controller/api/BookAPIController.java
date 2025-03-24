package com.systop.web.controller.api;

import com.systop.common.core.controller.BaseController;
import com.systop.common.core.page.TableDataInfo;
import com.systop.system.domain.Book;
import com.systop.system.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookAPIController extends BaseController {
    @Autowired
    private IBookService bookService;

    /**
     * 查询小说列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Book book)
    {
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

}
