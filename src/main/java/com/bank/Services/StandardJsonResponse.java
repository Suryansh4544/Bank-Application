package com.bank.Services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface StandardJsonResponse {
	String DEFAULT_MSG_NAME_FIELD = "message";
    String DEFAULT_MSG_TITLE_FIELD = "title";
    String DEFAULT_MSG_TITLE_VALUE = "Internal Server Error";
    String DEFAULT_MSG_NAME_VALUE = "The server encountered an unexpected condition which prevented it from fulfilling the request.";
    String RESOURCE_NOT_FOUND_MSG = "The resource requested is not found. Please check your resource ID.";
    
    void setSuccess(boolean success, String msg);
    
    boolean isSuccess();
    
    void setSuccess(boolean success);
    
    HashMap<String, String> getMessages();
    
    void setMessages(HashMap<String, String> messages);
    
    
    Object getData();
    
    void setData(Object data);
    
    int getHttpResponseCode();
    
    void setHttpResponseCode(int code);
}
