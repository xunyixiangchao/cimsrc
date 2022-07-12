package com.baidu.platform.comapi.longlink;

public enum ELongLinkStatus
{
  private int a;
  private int b;
  
  static
  {
    ELongLinkStatus localELongLinkStatus1 = new ELongLinkStatus("OK", 0, 0);
    OK = localELongLinkStatus1;
    ELongLinkStatus localELongLinkStatus2 = new ELongLinkStatus("SendFormatError", 1, localELongLinkStatus1.getStatusCode() + 1);
    SendFormatError = localELongLinkStatus2;
    ELongLinkStatus localELongLinkStatus3 = new ELongLinkStatus("SendUnRegistered", 2, localELongLinkStatus1.getStatusCode() + 2);
    SendUnRegistered = localELongLinkStatus3;
    ELongLinkStatus localELongLinkStatus4 = new ELongLinkStatus("SendLimited", 3, localELongLinkStatus1.getStatusCode() + 3);
    SendLimited = localELongLinkStatus4;
    ELongLinkStatus localELongLinkStatus5 = new ELongLinkStatus("SendDataLenLimited", 4, localELongLinkStatus1.getStatusCode() + 4);
    SendDataLenLimited = localELongLinkStatus5;
    ELongLinkStatus localELongLinkStatus6 = new ELongLinkStatus("SendInvalidReqID", 5, localELongLinkStatus1.getStatusCode() + 5);
    SendInvalidReqID = localELongLinkStatus6;
    ELongLinkStatus localELongLinkStatus7 = new ELongLinkStatus("ResultConnectError", 6, localELongLinkStatus1.getStatusCode() + 6);
    ResultConnectError = localELongLinkStatus7;
    ELongLinkStatus localELongLinkStatus8 = new ELongLinkStatus("ResultSendError", 7, localELongLinkStatus1.getStatusCode() + 7);
    ResultSendError = localELongLinkStatus8;
    ELongLinkStatus localELongLinkStatus9 = new ELongLinkStatus("ResultTimeout", 8, localELongLinkStatus1.getStatusCode() + 8);
    ResultTimeout = localELongLinkStatus9;
    ELongLinkStatus localELongLinkStatus10 = new ELongLinkStatus("ResultServerError", 9, localELongLinkStatus1.getStatusCode() + 9);
    ResultServerError = localELongLinkStatus10;
    ELongLinkStatus localELongLinkStatus11 = new ELongLinkStatus("CloudStop", 10, localELongLinkStatus1.getStatusCode() + 10);
    CloudStop = localELongLinkStatus11;
    ELongLinkStatus localELongLinkStatus12 = new ELongLinkStatus("CloudRestart", 11, localELongLinkStatus1.getStatusCode() + 11);
    CloudRestart = localELongLinkStatus12;
    $VALUES = new ELongLinkStatus[] { localELongLinkStatus1, localELongLinkStatus2, localELongLinkStatus3, localELongLinkStatus4, localELongLinkStatus5, localELongLinkStatus6, localELongLinkStatus7, localELongLinkStatus8, localELongLinkStatus9, localELongLinkStatus10, localELongLinkStatus11, localELongLinkStatus12 };
  }
  
  private ELongLinkStatus(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getRequestId()
  {
    return this.b;
  }
  
  public int getStatusCode()
  {
    return this.a;
  }
  
  public void setRequestId(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.longlink.ELongLinkStatus
 * JD-Core Version:    0.7.0.1
 */