package com.systop.system.service.impl;

import com.systop.common.utils.TokenUtils;
import com.systop.common.utils.sign.Md5Utils;
import com.systop.system.domain.Party;
import com.systop.system.mapper.PartyMapper;
import com.systop.system.service.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service业务层处理
 * 
 * @author jinhaoyu
 * @date 2024-05-28
 */
@Service
public class PartyServiceImpl implements IPartyService 
{
    @Autowired
    private PartyMapper partyMapper;
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public boolean checkUserByName(String username){
        return true;
    }

    /**
     * 注册方法   （添加用户名字的区别）
     * @param party
     * @return
     */
    @Override
    public String register(Party party) {
        //1-检查用户名是否存在
//        boolean flag = checkUserByName(party.getUsername());
//        if (flag) {
//            return "用户名已存在";
//            //正规方式 抛出自定义异常，使用统一异常捕获进行处理返回  return new myException("xxxx");
//        }
        //2-检查数据准确性（有效性） 比如：用户名长度，密码长度，密码是否有特殊符号等...

        //3-加密
        party.setPassword(Md5Utils.inputPassToFormPass(party.getPassword()));
        //4-添加用户
        int rows = partyMapper.addUser(party);
        //5-添加岗位信息

        //6-添加角色信息

        //7-添加操作日志信息

        //判断是否失败
        if (rows <= 0) {
            return "注册失败";
        }
        //返回成功
        return "注册成功";
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {  //同步项目进展完成  320ms    //异步220ms
        //1-验证码  redis比对  10ms

        //2-检查数据准确性（有效性） 比如：用户名长度，密码长度，密码是否有特殊符号等...  10ms

        //3-根据用户名密码查询用户
        Party party = partyMapper.login(username);  //50ms
        //4-各种判断是否失败
        if (party == null) {
            return "用户名错误";
        }
        if (!party.getPassword().equals(Md5Utils.inputPassToFormPass(password))) {
            return "密码错误";
        }
        //5-权限获取   100ms

        //6-登录日志记录  100ms
        //新线程或者异步方式调用

        //7-生产token返回
        String token = TokenUtils.createToken(party.getId());  //50ms
        //返回成功
        return token;
    }

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public Party selectPartyById(Long id)
    {
        return partyMapper.selectPartyById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param party 用户
     * @return 用户
     */
    @Override
    public List<Party> selectPartyList(Party party)
    {
        return partyMapper.selectPartyList(party);
    }

    /**
     * 新增用户
     * 
     * @param party 用户
     * @return 结果
     */
    @Override
    public int insertParty(Party party)
    {
        return partyMapper.insertParty(party);
    }

    /**
     * 修改用户
     * 
     * @param party 用户
     * @return 结果
     */
    @Override
    public int updateParty(Party party)
    {
        return partyMapper.updateParty(party);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deletePartyByIds(Long[] ids)
    {
        return partyMapper.deletePartyByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deletePartyById(Long id)
    {
        return partyMapper.deletePartyById(id);
    }
}
