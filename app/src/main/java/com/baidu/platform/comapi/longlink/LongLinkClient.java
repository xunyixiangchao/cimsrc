package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

public class LongLinkClient
{
  private int a;
  private long b;
  private int c;
  
  private LongLinkClient(long paramLong)
  {
    this.b = paramLong;
  }
  
  private LongLinkClient(long paramLong, int paramInt)
  {
    this.b = paramLong;
    this.a = paramInt;
  }
  
  public static LongLinkClient create()
  {
    long l = NALongLink.create();
    if (l != 0L) {
      return new LongLinkClient(l);
    }
    throw new ComInitException("LongLink Component created failed!");
  }
  
  public static LongLinkClient create(int paramInt)
  {
    long l = NALongLink.create();
    if (l != 0L) {
      return new LongLinkClient(l, paramInt);
    }
    throw new ComInitException("LongLink Component created failed!");
  }
  
  public int getRequestId()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean init(String paramString1, String paramString2)
  {
    if (isValid()) {
      return NALongLink.init(this.b, paramString1, paramString2);
    }
    throw new InvalidComException();
  }
  
  public boolean isValid()
  {
    return this.b != 0L;
  }
  
  public boolean register(LongLinkDataCallback paramLongLinkDataCallback)
  {
    try
    {
      if (isValid())
      {
        boolean bool = NALongLink.register(this.b, this.a, paramLongLinkDataCallback);
        return bool;
      }
      throw new InvalidComException();
    }
    finally {}
  }
  
  public int release()
  {
    if ((isValid()) && (NALongLink.release(this.b) <= 0)) {
      this.b = 0L;
    }
    return -1;
  }
  
  public ELongLinkStatus sendData(byte[] paramArrayOfByte)
  {
    try
    {
      if (isValid())
      {
        this.c += 1;
        paramArrayOfByte = ELongLinkStatus.values()[NALongLink.sendData(this.b, this.a, this.c, paramArrayOfByte)];
        paramArrayOfByte.setRequestId(this.c);
        return paramArrayOfByte;
      }
      throw new InvalidComException();
    }
    finally {}
  }
  
  public ELongLinkStatus sendFileData(String paramString, ArrayList<LongLinkFileData> paramArrayList)
  {
    try
    {
      if (isValid())
      {
        this.c += 1;
        paramString = ELongLinkStatus.values()[NALongLink.sendFileData(this.b, this.a, this.c, paramString, paramArrayList)];
        paramString.setRequestId(this.c);
        return paramString;
      }
      throw new InvalidComException();
    }
    finally {}
  }
  
  public void setModuleId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean start()
  {
    if (isValid()) {
      return NALongLink.start(this.b);
    }
    throw new InvalidComException();
  }
  
  public void stop()
  {
    if (isValid())
    {
      NALongLink.stop(this.b);
      return;
    }
    throw new InvalidComException();
  }
  
  public boolean unRegister(LongLinkDataCallback paramLongLinkDataCallback)
  {
    try
    {
      if (isValid())
      {
        boolean bool = NALongLink.unRegister(this.b, this.a, paramLongLinkDataCallback);
        return bool;
      }
      throw new InvalidComException();
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.longlink.LongLinkClient
 * JD-Core Version:    0.7.0.1
 */