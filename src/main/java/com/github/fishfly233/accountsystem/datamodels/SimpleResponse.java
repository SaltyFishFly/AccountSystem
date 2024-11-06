package com.github.fishfly233.accountsystem.datamodels;

import lombok.Data;

@Data
public class SimpleResponse {
    int code;
    long timeStamp;
    String message;

    public static SimpleResponse ok() {
        var res = new SimpleResponse();
        res.setCode(200);
        res.setTimeStamp(System.currentTimeMillis());
        res.setMessage("OK");
        return res;
    }

    public static SimpleResponse error() {
        var res = new SimpleResponse();
        res.setCode(500);
        res.setTimeStamp(System.currentTimeMillis());
        res.setMessage("Internal Error");
        return res;
    }
}
