package com.github.fishfly233.accountsystem.controller;

import com.github.fishfly233.accountsystem.datamodels.SQL;
import com.github.fishfly233.accountsystem.datamodels.SimpleResponse;
import com.github.fishfly233.accountsystem.service.SQLService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/sql")
public class SQLController {

    SQLService sqlService;

    @Autowired
    public SQLController(SQLService sqlService) {
        this.sqlService = sqlService;
    }

    @PostMapping("/execute")
    @ResponseBody
    public SimpleResponse execute(@RequestBody SQL sql, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return SimpleResponse.error("请先登录！");
        }
        try {
            sqlService.executeSQL(sql.getSql());
            return SimpleResponse.ok();
        }
        catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
            return SimpleResponse.error("数据库错误");
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
            return SimpleResponse.error("未知内部错误");
        }
    }
}
