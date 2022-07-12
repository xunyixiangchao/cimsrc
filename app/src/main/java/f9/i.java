package f9;

import e9.d;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import p8.a;
import p8.l;

final class i
  implements h
{
  private final Matcher a;
  private final CharSequence b;
  private final g c;
  private List<String> d;
  
  public i(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    this.a = paramMatcher;
    this.b = paramCharSequence;
    this.c = new b(this);
  }
  
  private final MatchResult e()
  {
    return this.a;
  }
  
  public List<String> a()
  {
    if (this.d == null) {
      this.d = new a(this);
    }
    List localList = this.d;
    a9.f.c(localList);
    return localList;
  }
  
  public g b()
  {
    return this.c;
  }
  
  public c9.c c()
  {
    return k.b(e());
  }
  
  public static final class a
    extends p8.b<String>
  {
    a(i parami) {}
    
    public int a()
    {
      return i.d(this.b).groupCount() + 1;
    }
    
    public String c(int paramInt)
    {
      String str2 = i.d(this.b).group(paramInt);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      return str1;
    }
  }
  
  public static final class b
    extends a<f>
    implements g
  {
    b(i parami) {}
    
    public int a()
    {
      return i.d(this.a).groupCount() + 1;
    }
    
    public f get(int paramInt)
    {
      c9.c localc = k.c(i.d(this.a), paramInt);
      if (localc.h().intValue() >= 0)
      {
        String str = i.d(this.a).group(paramInt);
        a9.f.e(str, "matchResult.group(index)");
        return new f(str, localc);
      }
      return null;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<f> iterator()
    {
      return d.f(l.u(l.i(this)), new a(this)).iterator();
    }
    
    static final class a
      extends a9.g
      implements z8.b<Integer, f>
    {
      a(i.b paramb)
      {
        super();
      }
      
      public final f d(int paramInt)
      {
        return this.b.get(paramInt);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.i
 * JD-Core Version:    0.7.0.1
 */