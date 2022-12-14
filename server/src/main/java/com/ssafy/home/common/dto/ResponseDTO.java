package com.ssafy.home.common.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String msg;
    private String errMsg;
    private String status;
    private int statusCode;
    private Object body;
}
