package com.example.testprovider.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wenkr
 * @date 2023/2/15
 * @apinote
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ExcelTarget("users")
public class User implements Serializable {

    @Excel(name = "编号")
    private String id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "生日")
    private Date bir;
}
