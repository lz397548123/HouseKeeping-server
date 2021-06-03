package com.zzuli.housekeepingserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/1       Mybatis配置类
 */

@Configuration
@MapperScan("com.zzuli.housekeepingserver.dao")
public class MybatisConfig {
}
