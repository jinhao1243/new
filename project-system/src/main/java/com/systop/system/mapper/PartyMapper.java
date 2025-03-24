package com.systop.system.mapper;

import com.systop.system.domain.Party;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 用户Mapper接口
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
public interface PartyMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public Party selectPartyById(Long id);

    /**
     * 查询用户列表
     * 
     * @param party 用户
     * @return 用户集合
     */
    public List<Party> selectPartyList(Party party);

    /**
     * 新增用户
     * 
     * @param party 用户
     * @return 结果
     */
    public int insertParty(Party party);
    /**
     * 用户添加
     * @param party
     * @return
     */
    int addUser(Party party);
    /**
     * 用户登录
     * @param username
     * @return
     */
    public  Party login(@Param("name") String username);
    /**
     * 修改用户
     * 
     * @param party 用户
     * @return 结果
     */
    public int updateParty(Party party);

    /**
     * 删除用户
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deletePartyById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePartyByIds(Long[] ids);
}
