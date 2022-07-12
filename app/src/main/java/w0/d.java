package w0;

import java.util.Locale;

public final class d
{
  public static final c a = new e(null, false);
  public static final c b = new e(null, true);
  public static final c c;
  public static final c d;
  public static final c e = new e(a.b, false);
  public static final c f = f.b;
  
  static
  {
    b localb = b.a;
    c = new e(localb, false);
    d = new e(localb, true);
  }
  
  static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  static int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {}
      switch (paramInt)
      {
      default: 
        return 2;
      case 16: 
      case 17: 
        return 0;
      }
    }
    return 1;
  }
  
  private static class a
    implements d.c
  {
    static final a b = new a(true);
    private final boolean a;
    
    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  private static class b
    implements d.c
  {
    static final b a = new b();
    
    public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int j = 2;
      int i = paramInt1;
      while ((i < paramInt2 + paramInt1) && (j == 2))
      {
        j = d.b(Character.getDirectionality(paramCharSequence.charAt(i)));
        i += 1;
      }
      return j;
    }
  }
  
  private static abstract interface c
  {
    public abstract int a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }
  
  private static abstract class d
    implements c
  {
    private final d.c a;
    
    d(d.c paramc)
    {
      this.a = paramc;
    }
    
    private boolean c(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      paramInt1 = this.a.a(paramCharSequence, paramInt1, paramInt2);
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1) {
          return b();
        }
        return false;
      }
      return true;
    }
    
    public boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramCharSequence.length() - paramInt2 >= paramInt1))
      {
        if (this.a == null) {
          return b();
        }
        return c(paramCharSequence, paramInt1, paramInt2);
      }
      throw new IllegalArgumentException();
    }
    
    protected abstract boolean b();
  }
  
  private static class e
    extends d.d
  {
    private final boolean b;
    
    e(d.c paramc, boolean paramBoolean)
    {
      super();
      this.b = paramBoolean;
    }
    
    protected boolean b()
    {
      return this.b;
    }
  }
  
  private static class f
    extends d.d
  {
    static final f b = new f();
    
    f()
    {
      super();
    }
    
    protected boolean b()
    {
      return e.a(Locale.getDefault()) == 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w0.d
 * JD-Core Version:    0.7.0.1
 */