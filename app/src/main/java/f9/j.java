package f9;

import a9.f;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
  implements Serializable
{
  public static final a b = new a(null);
  private final Pattern a;
  
  public j(String paramString)
  {
    this(paramString);
  }
  
  public j(Pattern paramPattern)
  {
    this.a = paramPattern;
  }
  
  public final h a(CharSequence paramCharSequence, int paramInt)
  {
    f.f(paramCharSequence, "input");
    Matcher localMatcher = this.a.matcher(paramCharSequence);
    f.e(localMatcher, "nativePattern.matcher(input)");
    return k.a(localMatcher, paramInt, paramCharSequence);
  }
  
  public final boolean b(CharSequence paramCharSequence)
  {
    f.f(paramCharSequence, "input");
    return this.a.matcher(paramCharSequence).matches();
  }
  
  public final String c(CharSequence paramCharSequence, String paramString)
  {
    f.f(paramCharSequence, "input");
    f.f(paramString, "replacement");
    paramCharSequence = this.a.matcher(paramCharSequence).replaceAll(paramString);
    f.e(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    return paramCharSequence;
  }
  
  public String toString()
  {
    String str = this.a.toString();
    f.e(str, "nativePattern.toString()");
    return str;
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.j
 * JD-Core Version:    0.7.0.1
 */