package com.bank.Services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class StandardJsonResponseImpl implements StandardJsonResponse {
	private boolean success = false;

    private HashMap<String, String> messages;

    private Object data;

    private int httpResponseCode;

    public StandardJsonResponseImpl() {

        messages = new HashMap<String, String>();
    }

	@Override
	public void setSuccess(boolean success, String msg) {
		this.success = success;
        messages.put(DEFAULT_MSG_NAME_FIELD, (msg == null || msg.isEmpty()) ? "" : msg);
	}

	@Override
	public boolean isSuccess() {
		return this.success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
        if (!success) {
            messages.put(DEFAULT_MSG_NAME_FIELD, DEFAULT_MSG_NAME_VALUE);
            messages.put(DEFAULT_MSG_TITLE_FIELD, DEFAULT_MSG_TITLE_VALUE);
        }
	}

	@Override
	public HashMap<String, String> getMessages() {
		return messages;
	}

	@Override
	public void setMessages(HashMap<String, String> messages) {
		this.messages = messages;
		
	}

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int getHttpResponseCode() {
		return httpResponseCode;
	}

	@Override
	public void setHttpResponseCode(int code) {
		httpResponseCode = code;
		
	}

    
}
