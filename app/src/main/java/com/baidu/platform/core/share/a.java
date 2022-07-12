package com.baidu.platform.core.share;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.comapi.basestruct.Point;

public class a
  extends com.baidu.platform.base.c
{
  public a(LocationShareURLOption paramLocationShareURLOption)
  {
    a(paramLocationShareURLOption);
  }
  
  private void a(LocationShareURLOption paramLocationShareURLOption)
  {
    this.c.a("qt", "cs");
    Point localPoint = CoordUtil.ll2point(paramLocationShareURLOption.mLocation);
    com.baidu.platform.util.a locala = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localPoint.x);
    localStringBuilder.append("|");
    localStringBuilder.append(localPoint.y);
    locala.a("geo", localStringBuilder.toString());
    this.c.a("t", paramLocationShareURLOption.mName);
    this.c.a("cnt", paramLocationShareURLOption.mSnippet);
    b(false);
    a(false);
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.h();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.a
 * JD-Core Version:    0.7.0.1
 */