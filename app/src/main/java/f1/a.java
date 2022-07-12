package f1;

import java.nio.ByteBuffer;

public final class a
  extends c
{
  public a f(int paramInt, ByteBuffer paramByteBuffer)
  {
    g(paramInt, paramByteBuffer);
    return this;
  }
  
  public void g(int paramInt, ByteBuffer paramByteBuffer)
  {
    c(paramInt, paramByteBuffer);
  }
  
  public int h(int paramInt)
  {
    int i = b(16);
    if (i != 0) {
      return this.b.getInt(d(i) + paramInt * 4);
    }
    return 0;
  }
  
  public int i()
  {
    int i = b(16);
    if (i != 0) {
      return e(i);
    }
    return 0;
  }
  
  public boolean j()
  {
    int i = b(6);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.b.get(i + this.a) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public short k()
  {
    int i = b(14);
    if (i != 0) {
      return this.b.getShort(i + this.a);
    }
    return 0;
  }
  
  public int l()
  {
    int i = b(4);
    if (i != 0) {
      return this.b.getInt(i + this.a);
    }
    return 0;
  }
  
  public short m()
  {
    int i = b(8);
    if (i != 0) {
      return this.b.getShort(i + this.a);
    }
    return 0;
  }
  
  public short n()
  {
    int i = b(12);
    if (i != 0) {
      return this.b.getShort(i + this.a);
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f1.a
 * JD-Core Version:    0.7.0.1
 */