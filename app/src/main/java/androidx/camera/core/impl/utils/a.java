package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

class a
  extends FilterOutputStream
{
  final OutputStream a;
  private ByteOrder b;
  
  a(OutputStream paramOutputStream, ByteOrder paramByteOrder)
  {
    super(paramOutputStream);
    this.a = paramOutputStream;
    this.b = paramByteOrder;
  }
  
  public void B(long paramLong)
  {
    h((int)paramLong);
  }
  
  public void a(ByteOrder paramByteOrder)
  {
    this.b = paramByteOrder;
  }
  
  public void d0(int paramInt)
  {
    i((short)paramInt);
  }
  
  public void g(int paramInt)
  {
    this.a.write(paramInt);
  }
  
  public void h(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == ByteOrder.LITTLE_ENDIAN)
    {
      this.a.write(paramInt >>> 0 & 0xFF);
      this.a.write(paramInt >>> 8 & 0xFF);
      this.a.write(paramInt >>> 16 & 0xFF);
      localObject = this.a;
      paramInt >>>= 24;
    }
    for (;;)
    {
      ((OutputStream)localObject).write(paramInt & 0xFF);
      return;
      if (localObject != ByteOrder.BIG_ENDIAN) {
        break;
      }
      this.a.write(paramInt >>> 24 & 0xFF);
      this.a.write(paramInt >>> 16 & 0xFF);
      this.a.write(paramInt >>> 8 & 0xFF);
      localObject = this.a;
      paramInt >>>= 0;
    }
  }
  
  public void i(short paramShort)
  {
    Object localObject = this.b;
    if (localObject == ByteOrder.LITTLE_ENDIAN)
    {
      this.a.write(paramShort >>> 0 & 0xFF);
      localObject = this.a;
      paramShort >>>= 8;
    }
    for (;;)
    {
      ((OutputStream)localObject).write(paramShort & 0xFF);
      return;
      if (localObject != ByteOrder.BIG_ENDIAN) {
        break;
      }
      this.a.write(paramShort >>> 8 & 0xFF);
      localObject = this.a;
      paramShort >>>= 0;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    this.a.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.a
 * JD-Core Version:    0.7.0.1
 */