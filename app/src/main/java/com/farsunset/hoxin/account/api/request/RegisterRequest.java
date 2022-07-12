package com.farsunset.hoxin.account.api.request;

import java.io.Serializable;

public class RegisterRequest
  implements Serializable
{
  private String code;
  private String gender;
  private String name;
  private String password;
  private String telephone;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getTelephone()
  {
    return this.telephone;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setTelephone(String paramString)
  {
    this.telephone = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.account.api.request.RegisterRequest
 * JD-Core Version:    0.7.0.1
 */