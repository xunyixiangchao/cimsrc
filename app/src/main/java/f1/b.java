package f1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
  extends c
{
  public static b h(ByteBuffer paramByteBuffer)
  {
    return i(paramByteBuffer, new b());
  }
  
  public static b i(ByteBuffer paramByteBuffer, b paramb)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return paramb.f(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }
  
  public b f(int paramInt, ByteBuffer paramByteBuffer)
  {
    g(paramInt, paramByteBuffer);
    return this;
  }
  
  public void g(int paramInt, ByteBuffer paramByteBuffer)
  {
    c(paramInt, paramByteBuffer);
  }
  
  public a j(a parama, int paramInt)
  {
    int i = b(6);
    if (i != 0) {
      return parama.f(a(d(i) + paramInt * 4), this.b);
    }
    return null;
  }
  
  public int k()
  {
    int i = b(6);
    if (i != 0) {
      return e(i);
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
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f1.b
 * JD-Core Version:    0.7.0.1
 */