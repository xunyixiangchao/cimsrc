package com.baidu.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  private com.baidu.b.c.d.d a;
  private List b;
  
  public c()
  {
    a();
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      String str1 = "";
      while (i < paramArrayOfByte.length)
      {
        String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        StringBuilder localStringBuilder;
        if (str2.length() == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          str1 = "0";
        }
        else
        {
          localStringBuilder = new StringBuilder();
        }
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        str1 = localStringBuilder.toString();
        i += 1;
      }
      return str1.toLowerCase();
    }
    throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
  }
  
  private void a()
  {
    this.a = new com.baidu.b.c.d.e(e.a(), e.b());
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null))
    {
      if (paramArrayOfString1.length != paramArrayOfString2.length) {
        return false;
      }
      HashSet localHashSet = new HashSet();
      int k = paramArrayOfString1.length;
      int i = 0;
      while (i < k)
      {
        localHashSet.add(paramArrayOfString1[i]);
        i += 1;
      }
      paramArrayOfString1 = new HashSet();
      k = paramArrayOfString2.length;
      i = j;
      while (i < k)
      {
        paramArrayOfString1.add(paramArrayOfString2[i]);
        i += 1;
      }
      return localHashSet.equals(paramArrayOfString1);
    }
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, com.baidu.b.c.d.d paramd)
  {
    com.baidu.b.c.d.a locala = com.baidu.b.c.d.a.a();
    locala.a(2, paramd);
    return locala.a(paramArrayOfByte);
  }
  
  private String[] a(Signature[] paramArrayOfSignature)
  {
    int j = paramArrayOfSignature.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = a(com.baidu.b.d.c.a(paramArrayOfSignature[i].toByteArray()));
      i += 1;
    }
    return arrayOfString;
  }
  
  List a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramIntent = localPackageManager.queryBroadcastReceivers(paramIntent, 0);
    Object localObject2;
    Object localObject1;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.iterator();
      do
      {
        if (!paramIntent.hasNext()) {
          break;
        }
        localObject2 = (ResolveInfo)paramIntent.next();
        localObject1 = ((ResolveInfo)localObject2).activityInfo;
      } while ((localObject1 == null) || (((ActivityInfo)localObject1).applicationInfo == null));
    }
    for (;;)
    {
      try
      {
        localObject1 = ((ResolveInfo)localObject2).activityInfo;
        Object localObject3 = localPackageManager.getReceiverInfo(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name), 128).metaData;
        if (localObject3 == null) {
          break;
        }
        localObject1 = ((Bundle)localObject3).getString("galaxy_data");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        byte[] arrayOfByte = com.baidu.b.d.a.a(((String)localObject1).getBytes("utf-8"));
        Object localObject4 = new JSONObject(new String(arrayOfByte));
        localObject1 = new b();
        ((b)localObject1).b = ((JSONObject)localObject4).getInt("priority");
        ((b)localObject1).a = ((ResolveInfo)localObject2).activityInfo.applicationInfo;
        if (paramContext.getPackageName().equals(((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName)) {
          ((b)localObject1).d = true;
        }
        if (paramBoolean)
        {
          localObject3 = ((Bundle)localObject3).getString("galaxy_sf");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = localPackageManager.getPackageInfo(((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName, 64);
            localObject4 = ((JSONObject)localObject4).getJSONArray("sigs");
            int j = ((JSONArray)localObject4).length();
            String[] arrayOfString = new String[j];
            i = 0;
            if (i < j)
            {
              arrayOfString[i] = ((JSONArray)localObject4).getString(i);
              i += 1;
              continue;
            }
            if (a(arrayOfString, a(((PackageInfo)localObject2).signatures)))
            {
              localObject2 = a(com.baidu.b.d.a.a(((String)localObject3).getBytes()), this.a);
              arrayOfByte = com.baidu.b.d.c.a(arrayOfByte);
              if ((localObject2 == null) || (!Arrays.equals((byte[])localObject2, arrayOfByte))) {
                break label433;
              }
              i = 1;
              if (i != 0) {
                ((b)localObject1).c = true;
              }
            }
          }
        }
        localArrayList.add(localObject1);
      }
      catch (Exception localException) {}
      Collections.sort(localArrayList, new d(this));
      return localArrayList;
      break;
      label433:
      int i = 0;
    }
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = a(paramContext, new Intent("com.baidu.intent.action.GALAXY").setPackage(paramContext.getPackageName()), true);
    int i = 0;
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      boolean bool = ((b)paramContext.get(0)).c;
      if (!bool) {
        while (i < 3)
        {
          Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
          i += 1;
        }
      }
      return bool;
    }
    i = 0;
    while (i < 3)
    {
      Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
      i += 1;
    }
    return false;
  }
  
  List b(Context paramContext)
  {
    List localList = this.b;
    if (localList != null) {
      return localList;
    }
    a(paramContext);
    paramContext = a(paramContext, new Intent("com.baidu.intent.action.GALAXY"), true);
    this.b = paramContext;
    return paramContext;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c
 * JD-Core Version:    0.7.0.1
 */