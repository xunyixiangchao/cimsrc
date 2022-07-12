package b8;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class c
  implements Closeable, Flushable
{
  private static final String[] j = new String[''];
  private static final String[] k;
  private final Writer a;
  private int[] b = new int[32];
  private int c = 0;
  private String d;
  private String e;
  private boolean f;
  private boolean g;
  private String h;
  private boolean i;
  
  static
  {
    int m = 0;
    while (m <= 31)
    {
      j[m] = String.format("\\u%04x", new Object[] { Integer.valueOf(m) });
      m += 1;
    }
    String[] arrayOfString = j;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    arrayOfString = (String[])arrayOfString.clone();
    k = arrayOfString;
    arrayOfString[60] = "\\u003c";
    arrayOfString[62] = "\\u003e";
    arrayOfString[38] = "\\u0026";
    arrayOfString[61] = "\\u003d";
    arrayOfString[39] = "\\u0027";
  }
  
  public c(Writer paramWriter)
  {
    n0(6);
    this.e = ":";
    this.i = true;
    Objects.requireNonNull(paramWriter, "out == null");
    this.a = paramWriter;
  }
  
  private c B(int paramInt1, int paramInt2, String paramString)
  {
    int m = m0();
    if ((m != paramInt2) && (m != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.h == null)
    {
      this.c -= 1;
      if (m == paramInt2) {
        j0();
      }
      this.a.write(paramString);
      return this;
    }
    paramString = new StringBuilder();
    paramString.append("Dangling name: ");
    paramString.append(this.h);
    throw new IllegalStateException(paramString.toString());
  }
  
  private void a()
  {
    int m = m0();
    if (m == 5) {
      this.a.write(44);
    } else {
      if (m != 3) {
        break label37;
      }
    }
    j0();
    o0(4);
    return;
    label37:
    throw new IllegalStateException("Nesting problem.");
  }
  
  private void g()
  {
    int m = m0();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 4)
        {
          if (m != 6) {
            if (m == 7)
            {
              if (!this.f) {
                throw new IllegalStateException("JSON must have only one top-level value.");
              }
            }
            else {
              throw new IllegalStateException("Nesting problem.");
            }
          }
          o0(7);
          return;
        }
        this.a.append(this.e);
        o0(5);
        return;
      }
      this.a.append(',');
    }
    else
    {
      o0(2);
    }
    j0();
  }
  
  private void j0()
  {
    if (this.d == null) {
      return;
    }
    this.a.write("\n");
    int n = this.c;
    int m = 1;
    while (m < n)
    {
      this.a.write(this.d);
      m += 1;
    }
  }
  
  private c l0(int paramInt, String paramString)
  {
    g();
    n0(paramInt);
    this.a.write(paramString);
    return this;
  }
  
  private int m0()
  {
    int m = this.c;
    if (m != 0) {
      return this.b[(m - 1)];
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  private void n0(int paramInt)
  {
    int m = this.c;
    int[] arrayOfInt1 = this.b;
    if (m == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[m * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, m);
      this.b = arrayOfInt2;
    }
    arrayOfInt1 = this.b;
    m = this.c;
    this.c = (m + 1);
    arrayOfInt1[m] = paramInt;
  }
  
  private void o0(int paramInt)
  {
    this.b[(this.c - 1)] = paramInt;
  }
  
  private void t0(String paramString)
  {
    String[] arrayOfString;
    if (this.g) {
      arrayOfString = k;
    } else {
      arrayOfString = j;
    }
    this.a.write("\"");
    int i2 = paramString.length();
    int m = 0;
    int i1;
    for (int n = 0; m < i2; n = i1)
    {
      int i3 = paramString.charAt(m);
      String str1;
      if (i3 < 128)
      {
        String str2 = arrayOfString[i3];
        str1 = str2;
        if (str2 == null)
        {
          i1 = n;
          break label143;
        }
      }
      else if (i3 == 8232)
      {
        str1 = "\\u2028";
      }
      else
      {
        i1 = n;
        if (i3 != 8233) {
          break label143;
        }
        str1 = "\\u2029";
      }
      if (n < m) {
        this.a.write(paramString, n, m - n);
      }
      this.a.write(str1);
      i1 = m + 1;
      label143:
      m += 1;
    }
    if (n < i2) {
      this.a.write(paramString, n, i2 - n);
    }
    this.a.write("\"");
  }
  
  private void z0()
  {
    if (this.h != null)
    {
      a();
      t0(this.h);
      this.h = null;
    }
  }
  
  public void close()
  {
    this.a.close();
    int m = this.c;
    if ((m <= 1) && ((m != 1) || (this.b[(m - 1)] == 7)))
    {
      this.c = 0;
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public c d0()
  {
    return B(1, 2, "]");
  }
  
  public c e0()
  {
    return B(3, 5, "}");
  }
  
  public final boolean f0()
  {
    return this.i;
  }
  
  public void flush()
  {
    if (this.c != 0)
    {
      this.a.flush();
      return;
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  public final boolean g0()
  {
    return this.g;
  }
  
  public c h()
  {
    z0();
    return l0(1, "[");
  }
  
  public boolean h0()
  {
    return this.f;
  }
  
  public c i()
  {
    z0();
    return l0(3, "{");
  }
  
  public c i0(String paramString)
  {
    Objects.requireNonNull(paramString, "name == null");
    if (this.h == null)
    {
      if (this.c != 0)
      {
        this.h = paramString;
        return this;
      }
      throw new IllegalStateException("JsonWriter is closed.");
    }
    throw new IllegalStateException();
  }
  
  public c k0()
  {
    if (this.h != null) {
      if (this.i)
      {
        z0();
      }
      else
      {
        this.h = null;
        return this;
      }
    }
    g();
    this.a.write("null");
    return this;
  }
  
  public final void p0(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void q0(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.d = null;
      paramString = ":";
    }
    else
    {
      this.d = paramString;
      paramString = ": ";
    }
    this.e = paramString;
  }
  
  public final void r0(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void s0(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public c u0(long paramLong)
  {
    z0();
    g();
    this.a.write(Long.toString(paramLong));
    return this;
  }
  
  public c v0(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return k0();
    }
    z0();
    g();
    Writer localWriter = this.a;
    if (paramBoolean.booleanValue()) {
      paramBoolean = "true";
    } else {
      paramBoolean = "false";
    }
    localWriter.write(paramBoolean);
    return this;
  }
  
  public c w0(Number paramNumber)
  {
    if (paramNumber == null) {
      return k0();
    }
    z0();
    Object localObject = paramNumber.toString();
    if ((!this.f) && ((((String)localObject).equals("-Infinity")) || (((String)localObject).equals("Infinity")) || (((String)localObject).equals("NaN"))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Numeric values must be finite, but was ");
      ((StringBuilder)localObject).append(paramNumber);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    g();
    this.a.append((CharSequence)localObject);
    return this;
  }
  
  public c x0(String paramString)
  {
    if (paramString == null) {
      return k0();
    }
    z0();
    g();
    t0(paramString);
    return this;
  }
  
  public c y0(boolean paramBoolean)
  {
    z0();
    g();
    Writer localWriter = this.a;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localWriter.write(str);
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b8.c
 * JD-Core Version:    0.7.0.1
 */