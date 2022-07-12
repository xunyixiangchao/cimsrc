package a0;

import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class o
  implements Comparable<o>
{
  public static final o a = b(1, 0, 0, "");
  public static final o b = b(1, 1, 0, "");
  public static final o c = b(1, 2, 0, "");
  private static final Pattern d = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:\\-(.+))?");
  
  public static o b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return new f(paramInt1, paramInt2, paramInt3, paramString);
  }
  
  private static BigInteger c(o paramo)
  {
    return BigInteger.valueOf(paramo.e()).shiftLeft(32).or(BigInteger.valueOf(paramo.f())).shiftLeft(32).or(BigInteger.valueOf(paramo.g()));
  }
  
  public static o h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = d.matcher(paramString);
    if (!paramString.matches()) {
      return null;
    }
    int i = Integer.parseInt(paramString.group(1));
    int j = Integer.parseInt(paramString.group(2));
    int k = Integer.parseInt(paramString.group(3));
    if (paramString.group(4) != null) {
      paramString = paramString.group(4);
    } else {
      paramString = "";
    }
    return b(i, j, k, paramString);
  }
  
  public int a(o paramo)
  {
    return c(this).compareTo(c(paramo));
  }
  
  abstract String d();
  
  public abstract int e();
  
  public final boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof o;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (o)paramObject;
    bool1 = bool2;
    if (Objects.equals(Integer.valueOf(e()), Integer.valueOf(paramObject.e())))
    {
      bool1 = bool2;
      if (Objects.equals(Integer.valueOf(f()), Integer.valueOf(paramObject.f())))
      {
        bool1 = bool2;
        if (Objects.equals(Integer.valueOf(g()), Integer.valueOf(paramObject.g()))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  abstract int f();
  
  abstract int g();
  
  public final int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(e()), Integer.valueOf(f()), Integer.valueOf(g()) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(e());
    localStringBuilder1.append(".");
    localStringBuilder1.append(f());
    localStringBuilder1.append(".");
    localStringBuilder1.append(g());
    localStringBuilder1 = new StringBuilder(localStringBuilder1.toString());
    if (!TextUtils.isEmpty(d()))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("-");
      localStringBuilder2.append(d());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.o
 * JD-Core Version:    0.7.0.1
 */