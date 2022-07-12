package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.a;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BitmapDescriptorFactory
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaiduMapSDK-");
    localStringBuilder.append(BitmapDescriptorFactory.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      paramString = a.a(paramString, (Context)localObject);
      localObject = fromBitmap(paramString);
      if ((!b) && (paramString == null)) {
        throw new AssertionError();
      }
      paramString.recycle();
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static BitmapDescriptor fromAssetWithDpi(String paramString)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = a.a(paramString, (Context)localObject);
      if (localBitmap == null) {
        return null;
      }
      int i = SysOSUtil.getDensityDpi();
      if (i > 480)
      {
        paramString = new Matrix();
        paramString.postScale(2.0F, 2.0F);
      }
      for (paramString = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);; paramString = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true))
      {
        localObject = fromBitmap(paramString);
        break label124;
        if (i <= 320) {
          break;
        }
        paramString = new Matrix();
        paramString.postScale(1.5F, 1.5F);
      }
      localObject = fromBitmap(localBitmap);
      paramString = null;
      label124:
      localBitmap.recycle();
      if (paramString != null) {
        paramString.recycle();
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapDescriptor(paramBitmap);
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return null;
      }
      Object localObject = BMapManager.getContext();
      if (localObject == null) {
        return null;
      }
      try
      {
        localObject = ((Context)localObject).openFileInput(paramString);
        paramString = BitmapFactory.decodeStream((InputStream)localObject);
        ((FileInputStream)localObject).close();
        if (paramString == null) {
          break label81;
        }
        localObject = fromBitmap(paramString);
        paramString.recycle();
        return localObject;
      }
      catch (IOException localIOException)
      {
        paramString = a;
        localObject = "IOException happened";
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString = a;
        localObject = "FileNotFoundException happened";
      }
      Log.e(paramString, (String)localObject, localFileNotFoundException);
    }
    label81:
    return null;
  }
  
  public static BitmapDescriptor fromFileWithDpi(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return null;
      }
      Object localObject = BMapManager.getContext();
      if (localObject == null) {
        return null;
      }
      String str;
      try
      {
        localObject = ((Context)localObject).openFileInput(paramString);
        paramString = BitmapFactory.decodeStream((InputStream)localObject);
        ((FileInputStream)localObject).close();
        if (paramString == null) {
          break label99;
        }
        int i = paramInt;
        if (paramInt <= 0) {
          i = SysOSUtil.getDensityDpi();
        }
        paramString.setDensity(i);
        localObject = fromBitmap(paramString);
        paramString.recycle();
        return localObject;
      }
      catch (IOException localIOException)
      {
        str = a;
        paramString = "IOException happened";
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        str = a;
        paramString = "FileNotFoundException happened";
      }
      Log.e(str, paramString, localFileNotFoundException);
    }
    label99:
    return null;
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return null;
    }
    BitmapDescriptor localBitmapDescriptor = fromBitmap(paramString);
    paramString.recycle();
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromPathWithDpi(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return null;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = SysOSUtil.getDensityDpi();
    }
    paramString.setDensity(i);
    BitmapDescriptor localBitmapDescriptor = fromBitmap(paramString);
    paramString.recycle();
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    localObject = BitmapFactory.decodeResource(((Context)localObject).getResources(), paramInt);
    if (localObject == null) {
      return null;
    }
    BitmapDescriptor localBitmapDescriptor = fromBitmap((Bitmap)localObject);
    ((Bitmap)localObject).recycle();
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromResourceWithDpi(int paramInt1, int paramInt2)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    localObject = BitmapFactory.decodeResource(((Context)localObject).getResources(), paramInt1);
    if (localObject == null) {
      return null;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = SysOSUtil.getDensityDpi();
    }
    ((Bitmap)localObject).setDensity(paramInt1);
    BitmapDescriptor localBitmapDescriptor = fromBitmap((Bitmap)localObject);
    ((Bitmap)localObject).recycle();
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      paramView.destroyDrawingCache();
      return localBitmapDescriptor;
    }
    catch (Exception paramView) {}
    return null;
  }
  
  public static BitmapDescriptor fromViewWithDpi(View paramView, int paramInt)
  {
    if (paramView == null) {
      return null;
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.buildDrawingCache();
    Bitmap localBitmap = paramView.getDrawingCache();
    if (localBitmap == null)
    {
      Log.e(a, "Get bitmap failed");
      return null;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = SysOSUtil.getDensityDpi();
    }
    localBitmap.setDensity(i);
    BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
    localBitmap.recycle();
    paramView.destroyDrawingCache();
    return localBitmapDescriptor;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */