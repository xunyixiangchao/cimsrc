package w0;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
  static final c d;
  private static final String e;
  private static final String f;
  static final a g;
  static final a h;
  private final boolean a;
  private final int b;
  private final c c;
  
  static
  {
    c localc = d.c;
    d = localc;
    e = Character.toString('‎');
    f = Character.toString('‏');
    g = new a(false, 2, localc);
    h = new a(true, 2, localc);
  }
  
  a(boolean paramBoolean, int paramInt, c paramc)
  {
    this.a = paramBoolean;
    this.b = paramInt;
    this.c = paramc;
  }
  
  private static int a(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence, false).d();
  }
  
  private static int b(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence, false).e();
  }
  
  public static a c()
  {
    return new a().a();
  }
  
  static boolean e(Locale paramLocale)
  {
    return e.a(paramLocale) == 1;
  }
  
  private String f(CharSequence paramCharSequence, c paramc)
  {
    boolean bool = paramc.a(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.a) && ((bool) || (b(paramCharSequence) == 1))) {
      return e;
    }
    if ((this.a) && ((!bool) || (b(paramCharSequence) == -1))) {
      return f;
    }
    return "";
  }
  
  private String g(CharSequence paramCharSequence, c paramc)
  {
    boolean bool = paramc.a(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.a) && ((bool) || (a(paramCharSequence) == 1))) {
      return e;
    }
    if ((this.a) && ((!bool) || (a(paramCharSequence) == -1))) {
      return f;
    }
    return "";
  }
  
  public boolean d()
  {
    return (this.b & 0x2) != 0;
  }
  
  public CharSequence h(CharSequence paramCharSequence)
  {
    return i(paramCharSequence, this.c, true);
  }
  
  public CharSequence i(CharSequence paramCharSequence, c paramc, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return null;
    }
    boolean bool = paramc.a(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((d()) && (paramBoolean))
    {
      if (bool) {
        paramc = d.b;
      } else {
        paramc = d.a;
      }
      localSpannableStringBuilder.append(g(paramCharSequence, paramc));
    }
    if (bool != this.a)
    {
      int i;
      if (bool) {
        i = 8235;
      } else {
        i = 8234;
      }
      localSpannableStringBuilder.append(i);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
    }
    else
    {
      localSpannableStringBuilder.append(paramCharSequence);
    }
    if (paramBoolean)
    {
      if (bool) {
        paramc = d.b;
      } else {
        paramc = d.a;
      }
      localSpannableStringBuilder.append(f(paramCharSequence, paramc));
    }
    return localSpannableStringBuilder;
  }
  
  public String j(String paramString)
  {
    return k(paramString, this.c, true);
  }
  
  public String k(String paramString, c paramc, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    return i(paramString, paramc, paramBoolean).toString();
  }
  
  public static final class a
  {
    private boolean a;
    private int b;
    private c c;
    
    public a()
    {
      c(a.e(Locale.getDefault()));
    }
    
    private static a b(boolean paramBoolean)
    {
      if (paramBoolean) {
        return a.h;
      }
      return a.g;
    }
    
    private void c(boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.c = a.d;
      this.b = 2;
    }
    
    public a a()
    {
      if ((this.b == 2) && (this.c == a.d)) {
        return b(this.a);
      }
      return new a(this.a, this.b, this.c);
    }
  }
  
  private static class b
  {
    private static final byte[] f = new byte[1792];
    private final CharSequence a;
    private final boolean b;
    private final int c;
    private int d;
    private char e;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        f[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    b(CharSequence paramCharSequence, boolean paramBoolean)
    {
      this.a = paramCharSequence;
      this.b = paramBoolean;
      this.c = paramCharSequence.length();
    }
    
    private static byte c(char paramChar)
    {
      if (paramChar < '܀') {
        return f[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte f()
    {
      int i = this.d;
      char c1;
      do
      {
        int j = this.d;
        if (j <= 0) {
          break;
        }
        CharSequence localCharSequence = this.a;
        j -= 1;
        this.d = j;
        c1 = localCharSequence.charAt(j);
        this.e = c1;
        if (c1 == '&') {
          return 12;
        }
      } while (c1 != ';');
      this.d = i;
      this.e = ';';
      return 13;
    }
    
    private byte g()
    {
      char c1;
      do
      {
        int i = this.d;
        if (i >= this.c) {
          break;
        }
        CharSequence localCharSequence = this.a;
        this.d = (i + 1);
        c1 = localCharSequence.charAt(i);
        this.e = c1;
      } while (c1 != ';');
      return 12;
    }
    
    private byte h()
    {
      int i = this.d;
      int j;
      CharSequence localCharSequence;
      char c1;
      do
      {
        j = this.d;
        if (j <= 0) {
          break;
        }
        localCharSequence = this.a;
        j -= 1;
        this.d = j;
        c1 = localCharSequence.charAt(j);
        this.e = c1;
        if (c1 == '<') {
          return 12;
        }
        if (c1 == '>') {
          break;
        }
      } while ((c1 != '"') && (c1 != '\''));
      for (;;)
      {
        j = this.d;
        if (j <= 0) {
          break;
        }
        localCharSequence = this.a;
        j -= 1;
        this.d = j;
        char c2 = localCharSequence.charAt(j);
        this.e = c2;
        if (c2 == c1) {
          break;
        }
      }
      this.d = i;
      this.e = '>';
      return 13;
    }
    
    private byte i()
    {
      int i = this.d;
      int j;
      CharSequence localCharSequence;
      char c1;
      do
      {
        j = this.d;
        if (j >= this.c) {
          break;
        }
        localCharSequence = this.a;
        this.d = (j + 1);
        c1 = localCharSequence.charAt(j);
        this.e = c1;
        if (c1 == '>') {
          return 12;
        }
      } while ((c1 != '"') && (c1 != '\''));
      for (;;)
      {
        j = this.d;
        if (j >= this.c) {
          break;
        }
        localCharSequence = this.a;
        this.d = (j + 1);
        char c2 = localCharSequence.charAt(j);
        this.e = c2;
        if (c2 == c1) {
          break;
        }
      }
      this.d = i;
      this.e = '<';
      return 13;
    }
    
    byte a()
    {
      char c1 = this.a.charAt(this.d - 1);
      this.e = c1;
      int i;
      if (Character.isLowSurrogate(c1))
      {
        i = Character.codePointBefore(this.a, this.d);
        this.d -= Character.charCount(i);
        return Character.getDirectionality(i);
      }
      this.d -= 1;
      byte b2 = c(this.e);
      byte b1 = b2;
      if (this.b)
      {
        i = this.e;
        if (i == 62) {
          return h();
        }
        b1 = b2;
        if (i == 59) {
          b1 = f();
        }
      }
      return b1;
    }
    
    byte b()
    {
      char c1 = this.a.charAt(this.d);
      this.e = c1;
      int i;
      if (Character.isHighSurrogate(c1))
      {
        i = Character.codePointAt(this.a, this.d);
        this.d += Character.charCount(i);
        return Character.getDirectionality(i);
      }
      this.d += 1;
      byte b2 = c(this.e);
      byte b1 = b2;
      if (this.b)
      {
        i = this.e;
        if (i == 60) {
          return i();
        }
        b1 = b2;
        if (i == 38) {
          b1 = g();
        }
      }
      return b1;
    }
    
    int d()
    {
      this.d = 0;
      int k = 0;
      int j = k;
      int i = j;
      while ((this.d < this.c) && (k == 0))
      {
        int m = b();
        if (m != 0)
        {
          if ((m != 1) && (m != 2))
          {
            if (m == 9) {}
          }
          else {
            switch (m)
            {
            default: 
              break;
            case 18: 
              i -= 1;
              j = 0;
              break;
            case 16: 
            case 17: 
              i += 1;
              j = 1;
              break;
            case 14: 
            case 15: 
              i += 1;
              j = -1;
              continue;
              if (i != 0) {
                break label134;
              }
              return 1;
            }
          }
        }
        else
        {
          if (i == 0) {
            return -1;
          }
          label134:
          k = i;
        }
      }
      if (k == 0) {
        return 0;
      }
      if (j != 0) {
        return j;
      }
      while (this.d > 0) {
        switch (a())
        {
        default: 
          break;
        case 18: 
          i += 1;
          break;
        case 16: 
        case 17: 
          if (k == i) {
            return 1;
          }
        case 14: 
        case 15: 
          if (k == i) {
            return -1;
          }
          i -= 1;
        }
      }
      return 0;
    }
    
    int e()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a2\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.Ir2JRegAssignTransformer.transform(Ir2JRegAssignTransformer.java:182)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:164)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:89)\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w0.a
 * JD-Core Version:    0.7.0.1
 */