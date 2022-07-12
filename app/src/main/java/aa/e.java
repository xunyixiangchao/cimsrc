package aa;

import f9.l;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;

public class e
  implements Serializable, Comparable<e>
{
  public static final a d = new a(null);
  public static final e e = new e(new byte[0]);
  private final byte[] a;
  private transient int b;
  private transient String c;
  
  public e(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public String a()
  {
    return a0.b(e(), null, 1, null);
  }
  
  public int b(e parame)
  {
    a9.f.f(parame, "other");
    int j = r();
    int k = parame.r();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = d(i) & 0xFF;
      int i1 = parame.d(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n >= i1) {
          break label95;
        }
        break label93;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      label93:
      return -1;
    }
    label95:
    return 1;
  }
  
  public e c(String paramString)
  {
    a9.f.f(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(e(), 0, r());
    paramString = paramString.digest();
    a9.f.e(paramString, "digestBytes");
    return new e(paramString);
  }
  
  public final byte d(int paramInt)
  {
    return k(paramInt);
  }
  
  public final byte[] e()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      if ((paramObject.r() == e().length) && (paramObject.m(0, e(), 0, e().length))) {
        return true;
      }
    }
    return false;
  }
  
  public final int f()
  {
    return this.b;
  }
  
  public int g()
  {
    return e().length;
  }
  
  public final String h()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    int i = f();
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(e());
    n(i);
    return i;
  }
  
  public String i()
  {
    char[] arrayOfChar = new char[e().length * 2];
    byte[] arrayOfByte = e();
    int k = arrayOfByte.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      int m = arrayOfByte[j];
      j += 1;
      int n = i + 1;
      arrayOfChar[i] = ba.b.f()[(m >> 4 & 0xF)];
      i = n + 1;
      arrayOfChar[n] = ba.b.f()[(m & 0xF)];
    }
    return l.h(arrayOfChar);
  }
  
  public byte[] j()
  {
    return e();
  }
  
  public byte k(int paramInt)
  {
    return e()[paramInt];
  }
  
  public boolean l(int paramInt1, e parame, int paramInt2, int paramInt3)
  {
    a9.f.f(parame, "other");
    return parame.m(paramInt2, e(), paramInt1, paramInt3);
  }
  
  public boolean m(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    a9.f.f(paramArrayOfByte, "other");
    return (paramInt1 >= 0) && (paramInt1 <= e().length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (c0.a(e(), paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public final void n(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void o(String paramString)
  {
    this.c = paramString;
  }
  
  public final e p()
  {
    return c("SHA-1");
  }
  
  public final e q()
  {
    return c("SHA-256");
  }
  
  public final int r()
  {
    return g();
  }
  
  public final boolean s(e parame)
  {
    a9.f.f(parame, "prefix");
    return l(0, parame, 0, parame.r());
  }
  
  public e t()
  {
    int i = 0;
    while (i < e().length)
    {
      int n = e()[i];
      int k = (byte)65;
      if (n >= k)
      {
        int m = (byte)90;
        if (n <= m)
        {
          byte[] arrayOfByte = e();
          arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
          a9.f.e(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          arrayOfByte[i] = ((byte)(n + 32));
          i = j;
          while (i < arrayOfByte.length)
          {
            j = arrayOfByte[i];
            if ((j >= k) && (j <= m)) {
              arrayOfByte[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          return new e(arrayOfByte);
        }
      }
      i += 1;
    }
    return this;
  }
  
  public String toString()
  {
    int i = e().length;
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    for (Object localObject1 = "[size=0]";; localObject1 = ((StringBuilder)localObject1).toString())
    {
      return localObject1;
      i = ba.b.a(e(), 64);
      if (i != -1) {
        break label307;
      }
      if (e().length > 64) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[hex=");
      ((StringBuilder)localObject1).append(i());
      ((StringBuilder)localObject1).append(']');
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[size=");
    ((StringBuilder)localObject2).append(e().length);
    ((StringBuilder)localObject2).append(" hex=");
    int k = c0.c(this, 64);
    if (k <= e().length) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (k + 0 >= 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (k == e().length) {
          localObject1 = this;
        } else {
          localObject1 = new e(p8.f.h(e(), 0, k));
        }
        ((StringBuilder)localObject2).append(((e)localObject1).i());
        localObject1 = localObject2;
        ((StringBuilder)localObject1).append("…]");
      }
    }
    for (;;)
    {
      return ((StringBuilder)localObject1).toString();
      throw new IllegalArgumentException("endIndex < beginIndex".toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("endIndex > length(");
      ((StringBuilder)localObject1).append(e().length);
      ((StringBuilder)localObject1).append(')');
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString().toString());
      label307:
      localObject1 = u();
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type java.lang.String");
      localObject2 = ((String)localObject1).substring(0, i);
      a9.f.e(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = l.t(l.t(l.t((String)localObject2, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
      if (i < ((String)localObject1).length())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[size=");
        ((StringBuilder)localObject1).append(e().length);
        ((StringBuilder)localObject1).append(" text=");
        ((StringBuilder)localObject1).append((String)localObject2);
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[text=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(']');
    }
  }
  
  public String u()
  {
    String str2 = h();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = b0.b(j());
      o(str1);
    }
    return str1;
  }
  
  public void v(b paramb, int paramInt1, int paramInt2)
  {
    a9.f.f(paramb, "buffer");
    ba.b.d(this, paramb, paramInt1, paramInt2);
  }
  
  public static final class a
  {
    public final e a(String paramString)
    {
      a9.f.f(paramString, "<this>");
      int i = paramString.length();
      int j = 0;
      if (i % 2 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = paramString.length() / 2;
        byte[] arrayOfByte = new byte[i];
        int k = i - 1;
        if (k >= 0) {
          for (i = j;; i = j)
          {
            j = i + 1;
            int m = i * 2;
            arrayOfByte[i] = ((byte)((ba.b.b(paramString.charAt(m)) << 4) + ba.b.b(paramString.charAt(m + 1))));
            if (j > k) {
              break;
            }
          }
        }
        return new e(arrayOfByte);
      }
      throw new IllegalArgumentException(a9.f.m("Unexpected hex string: ", paramString).toString());
    }
    
    public final e b(String paramString, Charset paramCharset)
    {
      a9.f.f(paramString, "<this>");
      a9.f.f(paramCharset, "charset");
      paramString = paramString.getBytes(paramCharset);
      a9.f.e(paramString, "(this as java.lang.String).getBytes(charset)");
      return new e(paramString);
    }
    
    public final e c(String paramString)
    {
      a9.f.f(paramString, "<this>");
      e locale = new e(b0.a(paramString));
      locale.o(paramString);
      return locale;
    }
    
    public final e d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      a9.f.f(paramArrayOfByte, "<this>");
      c0.b(paramArrayOfByte.length, paramInt1, paramInt2);
      return new e(p8.f.h(paramArrayOfByte, paramInt1, paramInt2 + paramInt1));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.e
 * JD-Core Version:    0.7.0.1
 */