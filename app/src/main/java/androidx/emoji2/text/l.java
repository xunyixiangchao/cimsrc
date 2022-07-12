package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import f1.b;
import java.nio.ByteBuffer;
import x0.h;

public final class l
{
  private final b a;
  private final char[] b;
  private final a c;
  private final Typeface d;
  
  private l(Typeface paramTypeface, b paramb)
  {
    this.d = paramTypeface;
    this.a = paramb;
    this.c = new a(1024);
    this.b = new char[paramb.k() * 2];
    a(paramb);
  }
  
  private void a(b paramb)
  {
    int j = paramb.k();
    int i = 0;
    while (i < j)
    {
      paramb = new f(this, i);
      Character.toChars(paramb.f(), this.b, i * 2);
      h(paramb);
      i += 1;
    }
  }
  
  public static l b(Typeface paramTypeface, ByteBuffer paramByteBuffer)
  {
    try
    {
      u0.f.a("EmojiCompat.MetadataRepo.create");
      paramTypeface = new l(paramTypeface, k.b(paramByteBuffer));
      return paramTypeface;
    }
    finally
    {
      u0.f.b();
    }
  }
  
  public char[] c()
  {
    return this.b;
  }
  
  public b d()
  {
    return this.a;
  }
  
  int e()
  {
    return this.a.l();
  }
  
  a f()
  {
    return this.c;
  }
  
  Typeface g()
  {
    return this.d;
  }
  
  void h(f paramf)
  {
    h.h(paramf, "emoji metadata cannot be null");
    boolean bool;
    if (paramf.c() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    h.b(bool, "invalid metadata codepoint length");
    this.c.c(paramf, 0, paramf.c() - 1);
  }
  
  static class a
  {
    private final SparseArray<a> a;
    private f b;
    
    private a()
    {
      this(1);
    }
    
    a(int paramInt)
    {
      this.a = new SparseArray(paramInt);
    }
    
    a a(int paramInt)
    {
      SparseArray localSparseArray = this.a;
      if (localSparseArray == null) {
        return null;
      }
      return (a)localSparseArray.get(paramInt);
    }
    
    final f b()
    {
      return this.b;
    }
    
    void c(f paramf, int paramInt1, int paramInt2)
    {
      a locala2 = a(paramf.b(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.a.put(paramf.b(paramInt1), locala1);
      }
      if (paramInt2 > paramInt1)
      {
        locala1.c(paramf, paramInt1 + 1, paramInt2);
        return;
      }
      locala1.b = paramf;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.l
 * JD-Core Version:    0.7.0.1
 */