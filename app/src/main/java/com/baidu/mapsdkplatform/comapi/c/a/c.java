package com.baidu.mapsdkplatform.comapi.c.a;

import java.io.File;
import java.util.Comparator;

public class c
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (File)paramObject1;
    paramObject2 = (File)paramObject2;
    try
    {
      paramObject1 = paramObject1.getName().split("_");
      int i = paramObject2.getName().split("_")[2].compareTo(paramObject1[2]);
      return i;
    }
    catch (Exception paramObject1)
    {
      label40:
      break label40;
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.c.a.c
 * JD-Core Version:    0.7.0.1
 */