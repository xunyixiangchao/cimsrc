package com.farsunset.hoxin.common.model;

import java.io.Serializable;
import java.util.Objects;
import u3.b0;

public class CloudVideo
  implements Serializable
{
  public static final transient byte HORIZONTAL = 0;
  public static final transient byte VERTICAL = 1;
  private static final transient long serialVersionUID = 1L;
  public String bucket;
  public float duration;
  public String image;
  public byte mode;
  public long size;
  public String uri;
  public String video;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof CloudVideo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (CloudVideo)paramObject;
      bool1 = bool2;
      if (Objects.equals(this.video, paramObject.video))
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
 * Qualified Name:     com.farsunset.hoxin.common.model.CloudVideo
 * JD-Core Version:    0.7.0.1
 */