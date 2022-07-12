package com.farsunset.hoxin.micro.entity;

import com.farsunset.hoxin.common.model.MessageSource;
import java.util.List;
import u3.b0;

public class MicroServer
  extends MessageSource
{
  public static final long serialVersionUID = 1L;
  public String account;
  public String description;
  public String greet;
  public long id;
  public List<MicroServerMenu> menuList;
  public String name;
  public String url;
  public String website;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MicroServer;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((MicroServer)paramObject).id == this.id) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAction()
  {
    return "200";
  }
  
  public int getDefaultIconRID()
  {
    return 2131165602;
  }
  
  public Long getId()
  {
    return Long.valueOf(this.id);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public String getWebIcon()
  {
    return b0.j(this.id);
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".");
    localStringBuilder.append(this.id);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.entity.MicroServer
 * JD-Core Version:    0.7.0.1
 */