package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Comment;
import com.zzuli.housekeepingserver.service.impl.CommentServiceImpl;
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
    private CommentServiceImpl commentService;

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", commentService.findAll());
    }

    /**
     * 查询所有评价，并且级联所属子评论
     *
     * @return Message
     */
    @ApiOperation(value = "findAllWithChild（查询所有评价，并且级联所属子评论）")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("success", commentService.findAllWithChild());
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Comment comment) {
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "deleteById（通过ID删除评价信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
