package f1;

import java.nio.ByteBuffer;

public class c
{
  protected int a;
  protected ByteBuffer b;
  private int c;
  private int d;
  d e = d.a();
  
  protected int a(int paramInt)
  {
    return paramInt + this.b.getInt(paramInt);
  }
  
  protected int b(int paramInt)
  {
    if (paramInt < this.d) {
      return this.b.getShort(this.c + paramInt);
    }
    return 0;
  }
  
  protected void c(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.b = paramByteBuffer;
    if (paramByteBuffer != null)
    {
      this.a = paramInt;
      paramInt -= paramByteBuffer.getInt(paramInt);
      this.c = paramInt;
      paramInt = this.b.getShort(paramInt);
    }
    else
    {
      paramInt = 0;
      this.a = 0;
      this.c = 0;
    }
    this.d = paramInt;
  }
  
  protected int d(int paramInt)
  {
    paramInt += this.a;
    return paramInt + this.b.getInt(paramInt) + 4;
  }
  
  protected int e(int paramInt)
  {
    paramInt += this.a;
    int i = this.b.getInt(paramInt);
    return this.b.getInt(paramInt + i);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f1.c
 * JD-Core Version:    0.7.0.1
 */