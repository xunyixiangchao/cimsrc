package da;

import java.io.Serializable;
import java.io.Writer;

public class b
  extends Writer
  implements Serializable
{
  private final StringBuilder a;
  
  public b(int paramInt)
  {
    this.a = new StringBuilder(paramInt);
  }
  
  public Writer append(char paramChar)
  {
    this.a.append(paramChar);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
  {
    this.a.append(paramCharSequence);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.a.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public void write(String paramString)
  {
    if (paramString != null) {
      this.a.append(paramString);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar != null) {
      this.a.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     da.b
 * JD-Core Version:    0.7.0.1
 */