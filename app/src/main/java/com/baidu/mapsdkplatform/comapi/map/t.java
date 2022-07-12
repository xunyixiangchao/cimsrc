package com.baidu.mapsdkplatform.comapi.map;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.SysOSAPI;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import java.util.ArrayList;

public class t
{
  private String a(String paramString)
  {
    String str2 = SysOSAPI.authToken;
    if (TextUtils.isEmpty(str2)) {
      return null;
    }
    String str1 = JNITools.getAESSaltKey(str2);
    str2 = JNITools.getAESViKey(str2);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramString))) {
      paramString = e(paramString);
    }
    try
    {
      paramString = new String(AlgorithmUtil.getDecryptInfo(str2, str1, paramString)).trim();
      return paramString;
    }
    catch (Exception paramString)
    {
      label69:
      break label69;
    }
    Log.e("PrismBuildingInfo", "getBuildingCenter Decrypt failed");
    return null;
  }
  
  private String b(String paramString)
  {
    String str2 = SysOSAPI.authToken;
    if (TextUtils.isEmpty(str2)) {
      return null;
    }
    String str1 = JNITools.getAESSaltKey(str2);
    str2 = JNITools.getAESViKey(str2);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramString))) {
      paramString = e(paramString);
    }
    try
    {
      paramString = new String(AlgorithmUtil.getDecryptInfo(str2, str1, paramString)).trim();
      return paramString;
    }
    catch (Exception paramString)
    {
      label69:
      break label69;
    }
    Log.e("PrismBuildingInfo", "getBuildingGeom Decrypt failed");
    return null;
  }
  
  private byte[] e(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = k + 1;
      arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(k, m), 16) * 16 + Integer.parseInt(paramString.substring(m, k + 2), 16)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public LatLng c(String paramString)
  {
    Object localObject2 = a(paramString);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    Object localObject1 = null;
    paramString = null;
    if (!bool)
    {
      localObject2 = ((String)localObject2).split(",");
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localObject2.length) {
          break;
        }
        localObject1 = localObject2[0];
        String str = localObject2[1];
        try
        {
          double d = Double.parseDouble((String)localObject1);
          localObject1 = new LatLng(Double.parseDouble(str), d);
          paramString = (String)localObject1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        i += 1;
      }
    }
    return localNumberFormatException;
  }
  
  public ArrayList<LatLng> d(String paramString)
  {
    Object localObject = b(paramString);
    paramString = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      int i = 0;
      while (i < localObject.length)
      {
        String[] arrayOfString = localObject[i].split(",");
        int j = 0;
        while (j < arrayOfString.length)
        {
          String str1 = arrayOfString[0];
          String str2 = arrayOfString[1];
          try
          {
            double d = Double.parseDouble(str1);
            paramString.add(new LatLng(Double.parseDouble(str2), d));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
          j += 1;
        }
        i += 1;
      }
    }
    return paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.t
 * JD-Core Version:    0.7.0.1
 */