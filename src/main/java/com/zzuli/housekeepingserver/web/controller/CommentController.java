package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Comment;
import com.zzuli.housekeepingserver.service.CommentService;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       评价控制器
 */

@RestController
@RequestMapping("/comment")
@Api(description = "评价管理接口")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/commit")
    @ApiOperation("提交评价")
    public Message commit(@RequestBody Comment comment) {
        commentService.commit(comment);
        return MessageUtil.success("提交成功");
    }

    @ApiOperation(value = "查询所有评价")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", commentService.findAll());
    }

    @GetMapping("/auditing")//通过
    public Message auditing(Long id) {
        commentService.deleteById(id);
        return MessageUtil.success("审核成功");
    }

    @GetMapping("/refuseauditing")//拒绝
    public Message refuseauditing(Long id) {
        commentService.deleteById(id);
        return MessageUtil.success("已拒绝审核");
    }

    @ApiOperation(value = "查询所有评论,级联获得评论")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("success", commentService.findAllWithChild());
    }

    @ApiOperation(value = "通过id查询评论")
    @GetMapping("/findById")
    public Comment findById(Long id) {
        return commentService.selectById(id);
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Comment comment) {
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
