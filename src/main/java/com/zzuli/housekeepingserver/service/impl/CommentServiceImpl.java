package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Comment;
import com.zzuli.housekeepingserver.bean.CommentExample;
import com.zzuli.housekeepingserver.bean.extend.CommentExtend;
import com.zzuli.housekeepingserver.dao.CommentMapper;
import com.zzuli.housekeepingserver.dao.extend.CommentExtendMapper;
import com.zzuli.housekeepingserver.service.CommentService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评价业务实现类
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CommentExtendMapper commentExtendMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.selectByExample(new CommentExample());
    }

    @Override
    public void deleteById(Long id) throws CustomerException{
        // 先判断该id对应的数据存在不？
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Comment comment) throws CustomerException {
        if (comment.getId() != null) {
            commentMapper.updateByPrimaryKey(comment);
        } else {
            commentMapper.insert(comment);
        }
    }

    @Override
    public List<CommentExtend> findAllWithChild() {
        return commentExtendMapper.selectAllWithChild();
    }
}
