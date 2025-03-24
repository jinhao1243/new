package com.systop.system.mapper;

import com.systop.system.domain.SysNotice;

import java.util.List;

/**
 * <p>ClassName: SysNoticeMapper</p>
 * <p>Description: 通知公告表 数据层</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2023/12/20 16:08
 */
public interface SysNoticeMapper {
    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除公告
     *
     * @param noticeId 公告ID
     * @return 结果
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * 批量删除公告信息
     *
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}
