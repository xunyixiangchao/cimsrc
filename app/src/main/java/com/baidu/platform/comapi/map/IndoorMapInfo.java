package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class IndoorMapInfo
  implements Serializable
{
  private String a;
  private String b;
  private String[] c;
  private int[] d;
  private int e;
  private int f;
  private String g;
  
  public IndoorMapInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    this(paramString1, paramString2, paramArrayOfString, paramArrayOfInt, paramInt, 0, "");
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramArrayOfString, paramArrayOfInt, paramInt1, paramInt2, "");
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramInt1;
    this.f = paramInt2;
    if (paramArrayOfString != null)
    {
      paramString1 = (String[])Array.newInstance(String.class, paramArrayOfString.length);
      this.c = paramString1;
      System.arraycopy(paramArrayOfString, 0, paramString1, 0, paramArrayOfString.length);
    }
    if (paramArrayOfInt != null)
    {
      paramString1 = new int[paramArrayOfInt.length];
      this.d = paramString1;
      System.arraycopy(paramArrayOfInt, 0, paramString1, 0, paramArrayOfInt.length);
    }
    this.g = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof IndoorMapInfo)) {
      return false;
    }
    String str = this.a;
    paramObject = (IndoorMapInfo)paramObject;
    if (!TextUtils.equals(str, paramObject.a)) {
      return false;
    }
    if (!TextUtils.equals(this.b, paramObject.b)) {
      return false;
    }
    if (!Arrays.equals(this.c, paramObject.c)) {
      return false;
    }
    return Arrays.equals(this.d, paramObject.d);
  }
  
  public String getBuildingId()
  {
    return this.a;
  }
  
  public final int[] getFloorAttribute()
  {
    return this.d;
  }
  
  public String getFloorId()
  {
    return this.b;
  }
  
  public final String[] getFloorList()
  {
    return this.c;
  }
  
  public String getIdrSearch()
  {
    return this.g;
  }
  
  public int getIdrguide()
  {
    return this.f;
  }
  
  public int getIndoorType()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndoorMapInfo:building_id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(";floor_id:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(";indoor_type:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(";floor_list:");
    localStringBuilder.append(Arrays.toString(this.c));
    localStringBuilder.append(";floor_attribute:");
    localStringBuilder.append(Arrays.toString(this.d));
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.IndoorMapInfo
 * JD-Core Version:    0.7.0.1
 */