package com.systop.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.systop.common.annotation.Log;
import com.systop.common.core.controller.BaseController;
import com.systop.common.core.domain.AjaxResult;
import com.systop.common.enums.BusinessType;
import com.systop.system.domain.Party;
import com.systop.system.service.IPartyService;
import com.systop.common.utils.poi.ExcelUtil;
import com.systop.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
@RestController
@RequestMapping("/system/party")
public class PartyController extends BaseController
{
    @Autowired
    private IPartyService partyService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:party:list')")
    @GetMapping("/list")
    public TableDataInfo list(Party party)
    {
        startPage();
        List<Party> list = partyService.selectPartyList(party);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:party:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Party party)
    {
        List<Party> list = partyService.selectPartyList(party);
        ExcelUtil<Party> util = new ExcelUtil<Party>(Party.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:party:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(partyService.selectPartyById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:party:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Party party)
    {
        return toAjax(partyService.insertParty(party));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:party:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Party party)
    {
        return toAjax(partyService.updateParty(party));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:party:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(partyService.deletePartyByIds(ids));
    }
}
