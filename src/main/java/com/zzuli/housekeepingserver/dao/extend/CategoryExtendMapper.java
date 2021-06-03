package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       栏目接口扩展
 */

public interface CategoryExtendMapper {
    List<CategoryExtend> selectAllWithChild();
}
