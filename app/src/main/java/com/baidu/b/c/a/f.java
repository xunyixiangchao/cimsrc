package com.baidu.b.c.a;

abstract class f
{
  final b b;
  final int c;
  byte[] d;
  
  f(b paramb)
  {
    this.b = paramb;
    this.c = paramb.a();
  }
  
  abstract void a();
  
  abstract void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  abstract void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  abstract void b();
  
  abstract void b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  abstract void c();
  
  void c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
  
  void d(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    b(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.f
 * JD-Core Version:    0.7.0.1
 */