package x7;

import b8.a;
import b8.c;
import b8.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import v7.m;
import v7.t;
import v7.v;

public final class l
{
  public static v7.l a(a parama)
  {
    try
    {
      parama.u0();
      int i = 0;
      try
      {
        parama = (v7.l)y7.n.X.b(parama);
        return parama;
      }
      catch (EOFException parama) {}
      if (i == 0) {
        break label65;
      }
    }
    catch (NumberFormatException parama)
    {
      throw new t(parama);
    }
    catch (IOException parama)
    {
      throw new m(parama);
    }
    catch (d parama)
    {
      throw new t(parama);
    }
    catch (EOFException parama)
    {
      i = 1;
    }
    return v7.n.a;
    label65:
    throw new t(parama);
  }
  
  public static void b(v7.l paraml, c paramc)
  {
    y7.n.X.d(paramc, paraml);
  }
  
  public static Writer c(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new a(paramAppendable);
  }
  
  private static final class a
    extends Writer
  {
    private final Appendable a;
    private final a b = new a();
    
    a(Appendable paramAppendable)
    {
      this.a = paramAppendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int paramInt)
    {
      this.a.append((char)paramInt);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      a locala = this.b;
      locala.a = paramArrayOfChar;
      this.a.append(locala, paramInt1, paramInt2 + paramInt1);
    }
    
    static class a
      implements CharSequence
    {
      char[] a;
      
      public char charAt(int paramInt)
      {
        return this.a[paramInt];
      }
      
      public int length()
      {
        return this.a.length;
      }
      
      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.a, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.l
 * JD-Core Version:    0.7.0.1
 */