package com.herb.lib.api.constants;


import lombok.Data;

/**
 * @author wuyang
 */
@Data
public class ResultDTO {
    private String system;

    private String msg;

    private Integer code;

    private Object data;

    public ResultDTO(int code, String msg) {
        this.system = "lib";
        this.msg = msg;
        this.code = code;
    }

    public ResultDTO(String system, String msg, int code, Object data) {
        this.system = "lib";
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResultDTO(int code, String msg, Object data) {
        this.system = "lib";
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
