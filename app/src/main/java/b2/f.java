package b2;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public abstract interface f
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public abstract void b(MessageDigest paramMessageDigest);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.f
 * JD-Core Version:    0.7.0.1
 */