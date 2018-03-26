package com.xsr.utils;


import org.apache.log4j.Logger;

/**
 * Created by 145811 on 2018/3/26.
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(BusinessException.class);
    private String code;
    private String message;
    private String type;

    public BusinessException(String code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
        logger.error(this.code + this.type + message);
    }

    public BusinessException(ReturnType returnType, String message) {
        this.code = returnType.getCode();
        this.type = returnType.getType();
        this.message = message;
        logger.error(this.code + this.type + message);
    }

    public BusinessException(ReturnType returnType, String message, Exception e) {
        this.code = returnType.getCode();
        this.type = returnType.getType();
        this.message = message;
        logger.error(this.code + this.type + message, e);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        BusinessException.logger = logger;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
