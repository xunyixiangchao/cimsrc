package z1;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class d
{
  private final byte[] a = new byte[256];
  private ByteBuffer b;
  private c c;
  private int d = 0;
  
  private boolean b()
  {
    return this.c.b != 0;
  }
  
  private int d()
  {
    try
    {
      int i = this.b.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    this.c.b = 1;
    return 0;
  }
  
  private void e()
  {
    this.c.d.a = n();
    this.c.d.b = n();
    this.c.d.c = n();
    this.c.d.d = n();
    int j = d();
    boolean bool = false;
    int i;
    if ((j & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int k = (int)Math.pow(2.0D, (j & 0x7) + 1);
    Object localObject = this.c.d;
    if ((j & 0x40) != 0) {
      bool = true;
    }
    ((b)localObject).e = bool;
    if (i != 0) {
      ((b)localObject).k = g(k);
    } else {
      ((b)localObject).k = null;
    }
    this.c.d.j = this.b.position();
    r();
    if (b()) {
      return;
    }
    localObject = this.c;
    ((c)localObject).c += 1;
    ((c)localObject).e.add(((c)localObject).d);
  }
  
  private void f()
  {
    int i = d();
    this.d = i;
    if (i > 0)
    {
      int j = 0;
      i = 0;
      for (;;)
      {
        int k = i;
        try
        {
          i = this.d;
          if (j < i)
          {
            i -= j;
            k = i;
            this.b.get(this.a, j, i);
            j += i;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error Reading Block n: ");
            localStringBuilder.append(j);
            localStringBuilder.append(" count: ");
            localStringBuilder.append(k);
            localStringBuilder.append(" blockSize: ");
            localStringBuilder.append(this.d);
            Log.d("GifHeaderParser", localStringBuilder.toString(), localException);
          }
          this.c.b = 1;
        }
      }
    }
  }
  
  private int[] g(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * 3];
    localObject = null;
    try
    {
      this.b.get(arrayOfByte);
      int[] arrayOfInt = new int[256];
      int i = 0;
      int j = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramInt) {
          break;
        }
        int k = j + 1;
        j = arrayOfByte[j];
        int m = k + 1;
        arrayOfInt[i] = ((j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        j = m + 1;
        i += 1;
      }
      return localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.c.b = 1;
    }
  }
  
  private void h()
  {
    i(2147483647);
  }
  
  private void i(int paramInt)
  {
    int i = 0;
    while ((i == 0) && (!b()) && (this.c.c <= paramInt))
    {
      int j = d();
      Object localObject;
      if (j != 33)
      {
        if (j != 44)
        {
          if (j != 59) {
            this.c.b = 1;
          } else {
            i = 1;
          }
        }
        else
        {
          localObject = this.c;
          if (((c)localObject).d == null) {
            ((c)localObject).d = new b();
          }
          e();
        }
      }
      else
      {
        j = d();
        if (j != 1) {
          if (j != 249)
          {
            if ((j != 254) && (j == 255))
            {
              f();
              localObject = new StringBuilder();
              j = 0;
              while (j < 11)
              {
                ((StringBuilder)localObject).append((char)this.a[j]);
                j += 1;
              }
              if (((StringBuilder)localObject).toString().equals("NETSCAPE2.0")) {
                m();
              }
            }
          }
          else
          {
            this.c.d = new b();
            j();
            continue;
          }
        }
        q();
      }
    }
  }
  
  private void j()
  {
    d();
    int i = d();
    b localb = this.c.d;
    int j = (i & 0x1C) >> 2;
    localb.g = j;
    boolean bool = true;
    if (j == 0) {
      localb.g = 1;
    }
    if ((i & 0x1) == 0) {
      bool = false;
    }
    localb.f = bool;
    j = n();
    i = j;
    if (j < 2) {
      i = 10;
    }
    localb = this.c.d;
    localb.i = (i * 10);
    localb.h = d();
    d();
  }
  
  private void k()
  {
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      ((StringBuilder)localObject).append((char)d());
      i += 1;
    }
    if (!((StringBuilder)localObject).toString().startsWith("GIF"))
    {
      this.c.b = 1;
      return;
    }
    l();
    if ((this.c.h) && (!b()))
    {
      localObject = this.c;
      ((c)localObject).a = g(((c)localObject).i);
      localObject = this.c;
      ((c)localObject).l = localObject.a[localObject.j];
    }
  }
  
  private void l()
  {
    this.c.f = n();
    this.c.g = n();
    int i = d();
    c localc = this.c;
    boolean bool;
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localc.h = bool;
    localc.i = ((int)Math.pow(2.0D, (i & 0x7) + 1));
    this.c.j = d();
    this.c.k = d();
  }
  
  private void m()
  {
    do
    {
      f();
      byte[] arrayOfByte = this.a;
      if (arrayOfByte[0] == 1)
      {
        int i = arrayOfByte[1];
        int j = arrayOfByte[2];
        this.c.m = ((j & 0xFF) << 8 | i & 0xFF);
      }
    } while ((this.d > 0) && (!b()));
  }
  
  private int n()
  {
    return this.b.getShort();
  }
  
  private void o()
  {
    this.b = null;
    Arrays.fill(this.a, (byte)0);
    this.c = new c();
    this.d = 0;
  }
  
  private void q()
  {
    int i;
    do
    {
      i = d();
      int j = Math.min(this.b.position() + i, this.b.limit());
      this.b.position(j);
    } while (i > 0);
  }
  
  private void r()
  {
    d();
    q();
  }
  
  public void a()
  {
    this.b = null;
    this.c = null;
  }
  
  public c c()
  {
    if (this.b != null)
    {
      if (b()) {
        return this.c;
      }
      k();
      if (!b())
      {
        h();
        c localc = this.c;
        if (localc.c < 0) {
          localc.b = 1;
        }
      }
      return this.c;
    }
    throw new IllegalStateException("You must call setData() before parseHeader()");
  }
  
  public d p(ByteBuffer paramByteBuffer)
  {
    o();
    paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    this.b = paramByteBuffer;
    paramByteBuffer.position(0);
    this.b.order(ByteOrder.LITTLE_ENDIAN);
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z1.d
 * JD-Core Version:    0.7.0.1
 */