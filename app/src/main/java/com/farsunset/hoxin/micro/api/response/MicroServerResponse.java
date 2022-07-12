package com.farsunset.hoxin.micro.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import u3.l;

public class MicroServerResponse
  extends BaseResult
{
  public Object content;
  public byte format;
  
  public String getContent()
  {
    Object localObject = this.content;
    if ((localObject instanceof String)) {
      return localObject.toString();
    }
    return l.H0(localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.api.response.MicroServerResponse
 * JD-Core Version:    0.7.0.1
 */