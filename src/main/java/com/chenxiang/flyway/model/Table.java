package com.chenxiang.flyway.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/21 16:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Table extends BaseRowModel {

    @ExcelProperty(value = "姓名", index = 0)
    private String name ;

    @ExcelProperty(value = "年龄", index = 0)
    private Integer age ;

    @ExcelProperty(value = "学校", index = 0)
    private String  school;

}
