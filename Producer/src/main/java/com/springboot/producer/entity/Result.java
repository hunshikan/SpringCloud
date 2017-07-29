package com.springboot.producer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";
    public static final String ERROR_CODE = "-1";
    public static final String ERROR_MESG = "系统异常";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;
    @ApiModelProperty(value = "处理结果数据信息")
    private T data;

    public Result(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }


    public Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    public static Result success() {
        return new Result(SUCCESSFUL_CODE, SUCCESSFUL_MESG);
    }

    public static Result fail() {
        return new Result(ERROR_CODE, ERROR_MESG);
    }

    public static Result fail(Object data) {
        return new Result(ERROR_CODE, ERROR_MESG, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}