package com.farsunset.hoxin.common.api.response;

public class BaseResult {
    public int code;
    public String message;
    public long timestamp;

    public boolean isSuccess() {
        return 200 == this.code;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.api.response.BaseResult

 * JD-Core Version:    0.7.0.1

 */