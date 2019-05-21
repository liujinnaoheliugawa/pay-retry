package com.liugawaheliujinnao.singleFunction.payRetry.controller.common;

import java.io.Serializable;

public class Response<T> implements Serializable {
    
    private Integer status; //API狀態
    
    private T result; //業務處理結果
    
    private String message; //API回傳狀態相關信息
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public T getResult() {
        return result;
    }
    
    public void setResult(T result) {
        this.result = result;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Response() {
        this.status = 0;
        this.message = "SUCCESS";
    }
    
    public Response(T result) {
        this.status = 0;
        this.result = result;
        this.message = "SUCCESS";
    }
    
    public Response(Integer status, String message) {
        this.status = status;
        this.result = null;
        this.message = message;
    }
    
    public Response(Integer status, T result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }
}
