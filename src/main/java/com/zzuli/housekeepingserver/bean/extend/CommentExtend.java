package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Comment;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评论的扩展类
 */

public class CommentExtend extends Comment {
    private List<Comment> children;

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }
}
