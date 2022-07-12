package com.tencent.bugly.proguard;

public final class ak
  extends j
  implements Cloneable
{
  private static byte[] d;
  private byte a;
  private String b;
  private byte[] c;
  
  public ak()
  {
    this.a = 0;
    this.b = "";
    this.c = null;
  }
  
  public ak(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramByte;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    if (d == null)
    {
      byte[] arrayOfByte = new byte[1];
      d = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.c = paramh.c(2, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      parami.a(arrayOfByte, 2);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ak
 * JD-Core Version:    0.7.0.1
 */