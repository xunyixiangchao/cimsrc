package com.farsunset.hoxin.common.model;

import java.io.Serializable;
import java.util.Objects;
import u3.b0;
import w7.a;

public class CloudImage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @a(serialize=false)
  public String bucket;
  public String image;
  public int oh;
  public int ow;
  public int th;
  public String thumb;
  public int tw;
  public String uri;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof CloudImage;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (CloudImage)paramObject;
      bool1 = bool2;
      if (Objects.equals(this.image, paramObject.image))
      {
        bool1 = bool2;
        if (Objects.equals(this.bucket, paramObject.bucket)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String getFileUri()
  {
    String str = this.uri;
    if (str != null) {
      return str;
    }
    return b0.f(this.bucket, this.image);
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.CloudImage
 * JD-Core Version:    0.7.0.1
 */