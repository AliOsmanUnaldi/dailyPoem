package com.aliunaldi.dailyPoem.service.responses.baseResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {

    private ResponseHeader responseHeader;

    public BaseResponse() {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setSuccess(true);
        responseHeader.setMessage("No message set here.");
        this.responseHeader = responseHeader;
    }
}
