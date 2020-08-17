package com.demo.meatball.common.response;

public class ResultUtil {
    /**成功且带数据**/
    public static RespResult<Object> success(Object object){
        RespResult<Object> result = new RespResult<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static RespResult<Object> success(){
        
        return success(null);
    }
    /**失败**/
    public static RespResult error(Integer code, String msg){
        RespResult result = new RespResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
