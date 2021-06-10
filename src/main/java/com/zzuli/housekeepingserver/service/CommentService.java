package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Comment;
import com.zzuli.housekeepingserver.bean.extend.CommentExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评价业务接口
 */

public interface CommentService {
    List<Comment> findAll();

    List<CommentExtend> findAllWithChild();

    Comment selectById(Long id);

    void saveOrUpdate(Comment comment) throws CustomerException;

    void commit(Comment comment)throws CustomerException;

    void deleteById(Long id) throws CustomerException;
}
