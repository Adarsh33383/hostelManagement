package com.example.hostel.exception;

public class ErrorResponse {
    private int msgCode;
    private String msg;

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "msgCode=" + msgCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}