package aa;

public final class s
{
  public static final a h = new a(null);
  public final byte[] a;
  public int b;
  public int c;
  public boolean d;
  public boolean e;
  public s f;
  public s g;
  
  public s()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  public s(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public final void a()
  {
    s locals = this.g;
    int j = 0;
    int i;
    if (locals != this) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      a9.f.c(locals);
      if (!locals.e) {
        return;
      }
      int k = this.c - this.b;
      locals = this.g;
      a9.f.c(locals);
      int m = locals.c;
      locals = this.g;
      a9.f.c(locals);
      if (locals.d)
      {
        i = j;
      }
      else
      {
        locals = this.g;
        a9.f.c(locals);
        i = locals.b;
      }
      if (k > 8192 - m + i) {
        return;
      }
      locals = this.g;
      a9.f.c(locals);
      f(locals, k);
      b();
      t.b(this);
      return;
    }
    throw new IllegalStateException("cannot compact".toString());
  }
  
  public final s b()
  {
    s locals1 = this.f;
    if (locals1 == this) {
      locals1 = null;
    }
    s locals2 = this.g;
    a9.f.c(locals2);
    locals2.f = this.f;
    locals2 = this.f;
    a9.f.c(locals2);
    locals2.g = this.g;
    this.f = null;
    this.g = null;
    return locals1;
  }
  
  public final s c(s params)
  {
    a9.f.f(params, "segment");
    params.g = this;
    params.f = this.f;
    s locals = this.f;
    a9.f.c(locals);
    locals.g = params;
    this.f = params;
    return params;
  }
  
  public final s d()
  {
    this.d = true;
    return new s(this.a, this.b, this.c, true, false);
  }
  
  public final s e(int paramInt)
  {
    int i;
    if ((paramInt > 0) && (paramInt <= this.c - this.b)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      s locals;
      if (paramInt >= 1024)
      {
        locals = d();
      }
      else
      {
        locals = t.c();
        localObject = this.a;
        byte[] arrayOfByte = locals.a;
        i = this.b;
        p8.f.f((byte[])localObject, arrayOfByte, 0, i, i + paramInt, 2, null);
      }
      locals.c = (locals.b + paramInt);
      this.b += paramInt;
      Object localObject = this.g;
      a9.f.c(localObject);
      ((s)localObject).c(locals);
      return locals;
    }
    throw new IllegalArgumentException("byteCount out of range".toString());
  }
  
  public final void f(s params, int paramInt)
  {
    a9.f.f(params, "sink");
    if (params.e)
    {
      int i = params.c;
      if (i + paramInt > 8192) {
        if (!params.d)
        {
          j = params.b;
          if (i + paramInt - j <= 8192)
          {
            arrayOfByte1 = params.a;
            p8.f.f(arrayOfByte1, arrayOfByte1, 0, j, i, 2, null);
            params.c -= params.b;
            params.b = 0;
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else
        {
          throw new IllegalArgumentException();
        }
      }
      byte[] arrayOfByte1 = this.a;
      byte[] arrayOfByte2 = params.a;
      i = params.c;
      int j = this.b;
      p8.f.d(arrayOfByte1, arrayOfByte2, i, j, j + paramInt);
      params.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalStateException("only owner can write".toString());
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.s
 * JD-Core Version:    0.7.0.1
 */