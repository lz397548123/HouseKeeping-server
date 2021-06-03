package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.CommentExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评论接口的扩展类
 */

public interface CommentExtendMapper {
    List<CommentExtend> selectAllWithChild();
}
