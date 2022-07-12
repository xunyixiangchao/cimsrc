package org.webrtc;

public class Size
{
  public int height;
  public int width;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Size;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Size)paramObject;
    bool1 = bool2;
    if (this.width == paramObject.width)
    {
      bool1 = bool2;
      if (this.height == paramObject.height) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.width * 65537 + 1 + this.height;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.width);
    localStringBuilder.append("x");
    localStringBuilder.append(this.height);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Size
 * JD-Core Version:    0.7.0.1
 */