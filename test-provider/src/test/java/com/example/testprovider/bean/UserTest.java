package com.example.testprovider.bean;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenkr
 * @date 2023/2/15
 * @apinote
 */
class UserTest {
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i + "");
            user.setName("name: " + i);
            user.setAge(i * 10);
            user.setBir(new Date());
            list.add(user);
        }
        return list;
    }

    @Test
    void testExcel() throws IOException {
        List<User> users = getUsers();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户表标题", "用户表信息"), User.class, users);
        FileOutputStream outputStream = new FileOutputStream("C:/mydata/user.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

}