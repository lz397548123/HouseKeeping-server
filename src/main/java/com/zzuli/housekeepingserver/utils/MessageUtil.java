package com.zzuli.housekeepingserver.utils;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       消息工具类
 */

import java.util.Date;

public class MessageUtil {
    /**
     * 返回失败消息，一般用于增删改操作的结果返回
     *
     * @param msg 信息
     * @return Message
     */
    public static Message error(String msg) {
        Message message = new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功消息，一般用于增删改操作的结果返回
     *
     * @param msg 信息
     * @return Message
     */
    public static Message success(String msg) {
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     *
     * @param msg  信息
     * @param data 操作结果，查询结构
     * @return Message
     */
    public static Message success(String msg, Object data) {
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     *
     * @param data 操作结果，查询结构
     * @return Message
     */
    public static Message success(Object data) {
        Message message = new Message();
        message.setStatus(200);
        message.setMessage("success");
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 权限不足
     *
     * @param msg 信息
     * @return Message
     */
    public static Message forbidden(String msg) {
        Message message = new Message();
        message.setStatus(403);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 未授权
     *
     * @param msg 信息
     * @return Message
     */
    public static Message unAuthorized(String msg) {
        Message message = new Message();
        message.setStatus(401);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }


}

