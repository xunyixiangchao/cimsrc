package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;

public class a
{
  public static double a(Point paramPoint1, Point paramPoint2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putDouble("x1", paramPoint1.x);
    localBundle.putDouble("y1", paramPoint1.y);
    localBundle.putDouble("x2", paramPoint2.x);
    localBundle.putDouble("y2", paramPoint2.y);
    JNITools.GetDistanceByMC(localBundle);
    return localBundle.getDouble("distance");
  }
  
  public static com.baidu.platform.comapi.basestruct.a a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("strkey", paramString);
      JNITools.TransGeoStr2ComplexPt(localBundle1);
      paramString = new com.baidu.platform.comapi.basestruct.a();
      Object localObject1 = localBundle1.getBundle("map_bound");
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getBundle("ll");
        if (localObject2 != null) {
          paramString.b = new Point((int)((Bundle)localObject2).getDouble("ptx"), (int)((Bundle)localObject2).getDouble("pty"));
        }
        localObject1 = ((Bundle)localObject1).getBundle("ru");
        if (localObject1 != null) {
          paramString.c = new Point((int)((Bundle)localObject1).getDouble("ptx"), (int)((Bundle)localObject1).getDouble("pty"));
        }
      }
      localObject1 = (ParcelItem[])localBundle1.getParcelableArray("poly_line");
      int i = 0;
      while (i < localObject1.length)
      {
        if (paramString.d == null) {
          paramString.d = new ArrayList();
        }
        localObject2 = localObject1[i].getBundle();
        if (localObject2 != null)
        {
          localObject2 = (ParcelItem[])((Bundle)localObject2).getParcelableArray("point_array");
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < localObject2.length)
          {
            Bundle localBundle2 = localObject2[j].getBundle();
            if (localBundle2 != null) {
              localArrayList.add(new Point((int)localBundle2.getDouble("ptx"), (int)localBundle2.getDouble("pty")));
            }
            j += 1;
          }
          localArrayList.trimToSize();
          paramString.d.add(localArrayList);
        }
        i += 1;
      }
      paramString.d.trimToSize();
      paramString.a = ((int)localBundle1.getDouble("type"));
      return paramString;
    }
    return null;
  }
  
  public static void a()
  {
    JNITools.initClass(new Bundle(), 0);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    JNITools.openLogEnable(paramBoolean, paramInt);
  }
  
  public static String b()
  {
    return JNITools.GetToken();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comjni.tools.a
 * JD-Core Version:    0.7.0.1
 */