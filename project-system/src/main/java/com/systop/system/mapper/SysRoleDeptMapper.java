package com.systop.system.mapper;

import com.systop.system.domain.SysRoleDept;

import java.util.List;

/**
 * <p>ClassName: SysRoleDeptMapper</p>
 * <p>Description: 角色与部门关联表 数据层</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/20 16:10
 */
public interface SysRoleDeptMapper {
    /**
     * 通过角色ID删除角色和部门关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * 批量删除角色部门关联信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * 查询部门使用数量
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * 批量新增角色部门信息
     *
     * @param roleDeptList 角色部门列表
     * @return 结果
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
