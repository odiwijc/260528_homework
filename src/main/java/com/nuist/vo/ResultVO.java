package com.nuist.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    private String code;
    private String message;
    private T data;

    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode("200");
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static <T> ResultVO<T> success(T data, String message) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode("200");
        resultVO.setMessage(message);
        resultVO.setData(data);
        return resultVO;
    }

    public static <T> ResultVO<T> error(Integer code, String message){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(code.toString());
        resultVO.setMessage(message);
        return resultVO;
    }

    public static <T> ResultVO<T> error(String message){
        return error(500, message);
    }
}
