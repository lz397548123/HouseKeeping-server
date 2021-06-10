package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.Comment;
import com.zzuli.housekeepingserver.bean.extend.CommentExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评价扩展接口
 */

public interface CommentExtendMapper {
    List<CommentExtend> selectAllWithChild();

    List<Comment> selectById(Long id);
}
