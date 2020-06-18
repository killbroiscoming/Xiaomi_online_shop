package com.xiaomi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应数据封装
 */
public class ResponseMessage {
    private String errorCode;
    private String errorMsg;

    //存放返回的数据
    private Map<String, Object> objectMap = new HashMap<String, Object>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }

    /**
     * 快捷往hash map 增加对象的方法
     * @param key
     * @param value
     * @return
     */
    public ResponseMessage addObject(String key,Object value){
        this.objectMap.put(key,value);
        return this;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", objectMap=" + objectMap +
                '}';
    }

    /**
     * 处理成功
     * @return
     */
    public static  ResponseMessage success(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("100");
        rm.setErrorMsg("处理成功");
        return rm;
    }

    /**
     * 处理失败
     * @return
     */
    public static  ResponseMessage error(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("200");
        rm.setErrorMsg("处理失败");
        return rm;
    }

}
