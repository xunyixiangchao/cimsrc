package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.a;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.d;
import com.baidu.mapsdkplatform.comapi.map.d.c;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.y;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.x;
import com.baidu.platform.comapi.util.h;
import java.io.File;
import javax.microedition.khronos.opengles.GL10;

public final class TextureMapView
  extends ViewGroup
{
  private static final SparseArray<Integer> A;
  private static final String x = TextureMapView.class.getSimpleName();
  private static String y;
  private static int z = 0;
  private MapTextureView a;
  private BaiduMap b;
  private ImageView c;
  private Bitmap d;
  private y e;
  private Point f;
  private Point g;
  private RelativeLayout h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private Context l;
  private float m;
  private int n = LogoPosition.logoPostionleftBottom.ordinal();
  private boolean o = true;
  private boolean p = true;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private boolean w = false;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    A = localSparseArray;
    localSparseArray.append(3, Integer.valueOf(2000000));
    localSparseArray.append(4, Integer.valueOf(1000000));
    localSparseArray.append(5, Integer.valueOf(500000));
    localSparseArray.append(6, Integer.valueOf(200000));
    localSparseArray.append(7, Integer.valueOf(100000));
    localSparseArray.append(8, Integer.valueOf(50000));
    localSparseArray.append(9, Integer.valueOf(25000));
    localSparseArray.append(10, Integer.valueOf(20000));
    localSparseArray.append(11, Integer.valueOf(10000));
    localSparseArray.append(12, Integer.valueOf(5000));
    localSparseArray.append(13, Integer.valueOf(2000));
    localSparseArray.append(14, Integer.valueOf(1000));
    localSparseArray.append(15, Integer.valueOf(500));
    localSparseArray.append(16, Integer.valueOf(200));
    localSparseArray.append(17, Integer.valueOf(100));
    localSparseArray.append(18, Integer.valueOf(50));
    localSparseArray.append(19, Integer.valueOf(20));
    localSparseArray.append(20, Integer.valueOf(10));
    localSparseArray.append(21, Integer.valueOf(5));
    localSparseArray.append(22, Integer.valueOf(2));
  }
  
  public TextureMapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    super(paramContext);
    a(paramContext, paramBaiduMapOptions);
  }
  
  private void a(Context paramContext)
  {
    int i1 = SysOSUtil.getDensityDpi();
    Object localObject;
    if (i1 < 180) {
      localObject = "logo_l.png";
    } else {
      localObject = "logo_h.png";
    }
    Bitmap localBitmap = a.a((String)localObject, paramContext);
    if (i1 > 480) {
      localObject = new Matrix();
    }
    for (float f1 = 2.0F;; f1 = 1.5F)
    {
      ((Matrix)localObject).postScale(f1, f1);
      this.d = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      break label118;
      if ((i1 <= 320) || (i1 > 480)) {
        break;
      }
      localObject = new Matrix();
    }
    this.d = localBitmap;
    label118:
    if (this.d != null)
    {
      paramContext = new ImageView(paramContext);
      this.c = paramContext;
      paramContext.setImageBitmap(this.d);
      addView(this.c);
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    setBackgroundColor(-1);
    this.l = paramContext;
    f.b();
    BMapManager.init();
    a(paramContext, paramBaiduMapOptions, y, z);
    a(paramContext);
    c(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h)) {
      this.e.setVisibility(4);
    }
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i)) {
      this.h.setVisibility(4);
    }
    if (paramBaiduMapOptions != null)
    {
      paramContext = paramBaiduMapOptions.j;
      if (paramContext != null) {
        this.n = paramContext.ordinal();
      }
    }
    if (paramBaiduMapOptions != null)
    {
      paramContext = paramBaiduMapOptions.l;
      if (paramContext != null) {
        this.g = paramContext;
      }
    }
    if (paramBaiduMapOptions != null)
    {
      paramContext = paramBaiduMapOptions.k;
      if (paramContext != null) {
        this.f = paramContext;
      }
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions, String paramString, int paramInt)
  {
    paramString = new MapTextureView(paramContext);
    this.a = paramString;
    addView(paramString);
    if (paramBaiduMapOptions != null) {
      this.b = new BaiduMap(paramContext, this.a, paramBaiduMapOptions.a());
    } else {
      this.b = new BaiduMap(paramContext, this.a, null);
    }
    paramContext = new b();
    this.a.getBaseMap().a(paramContext);
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
    }
    int i1 = localLayoutParams1.width;
    if (i1 > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    int i2 = localLayoutParams1.height;
    if (i2 > 0) {
      i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    } else {
      i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i1, i2);
  }
  
  private void a(String paramString, MapCustomStyleOptions paramMapCustomStyleOptions)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      a(paramString, "");
      setMapCustomStyleEnable(true);
      return;
      paramString = paramMapCustomStyleOptions.getLocalCustomStyleFilePath();
    } while (!TextUtils.isEmpty(paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    MapTextureView localMapTextureView = this.a;
    if (localMapTextureView != null)
    {
      if (localMapTextureView.getBaseMap() == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        Log.e(x, "customStyleFilePath is empty or null, please check!");
        return;
      }
      if (!paramString1.endsWith(".sty"))
      {
        Log.e(x, "customStyleFile format is incorrect , please check!");
        return;
      }
      if (!new File(paramString1).exists())
      {
        Log.e(x, "customStyleFile does not exist , please check!");
        return;
      }
      this.a.getBaseMap().a(paramString1, paramString2);
    }
  }
  
  private void b()
  {
    y localy = this.e;
    if (localy != null)
    {
      if (!localy.c()) {
        return;
      }
      float f1 = this.a.getBaseMap().t().a;
      localy = this.e;
      float f2 = this.a.getBaseMap().b;
      boolean bool2 = true;
      boolean bool1;
      if (f1 > f2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localy.b(bool1);
      localy = this.e;
      if (f1 < this.a.getBaseMap().a) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localy.a(bool1);
    }
  }
  
  private void b(Context paramContext)
  {
    this.h = new RelativeLayout(paramContext);
    Object localObject = new ViewGroup.LayoutParams(-2, -2);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.i = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.i.setTextColor(Color.parseColor("#FFFFFF"));
    this.i.setTextSize(2, 11.0F);
    TextView localTextView = this.i;
    localTextView.setTypeface(localTextView.getTypeface(), 1);
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.i.setId(2147483647);
    this.h.addView(this.i);
    this.j = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.j.setTextColor(Color.parseColor("#000000"));
    this.j.setTextSize(2, 11.0F);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h.addView(this.j);
    this.k = new ImageView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.i.getId());
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext = a.a("icon_scale.9.png", paramContext);
    localObject = paramContext.getNinePatchChunk();
    NinePatch.isNinePatchChunk((byte[])localObject);
    paramContext = new NinePatchDrawable(paramContext, (byte[])localObject, new Rect(), null);
    this.k.setBackgroundDrawable(paramContext);
    this.h.addView(this.k);
    addView(this.h);
  }
  
  private void c(Context paramContext)
  {
    paramContext = new y(paramContext);
    this.e = paramContext;
    if (!paramContext.c()) {
      return;
    }
    this.e.b(new c());
    this.e.a(new d());
    addView(this.e);
  }
  
  private boolean c()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  @Deprecated
  public static void setCustomMapStylePath(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (new File(paramString).exists())
      {
        y = paramString;
        return;
      }
      throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
    }
    throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
  }
  
  @Deprecated
  public static void setIconCustom(int paramInt)
  {
    z = paramInt;
  }
  
  @Deprecated
  public static void setLoadCustomMapStyleFileMode(int paramInt) {}
  
  @Deprecated
  public static void setMapCustomEnable(boolean paramBoolean) {}
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams))
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  public final LogoPosition getLogoPosition()
  {
    int i1 = this.n;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return LogoPosition.logoPostionleftBottom;
            }
            return LogoPosition.logoPostionRightTop;
          }
          return LogoPosition.logoPostionRightBottom;
        }
        return LogoPosition.logoPostionCenterTop;
      }
      return LogoPosition.logoPostionCenterBottom;
    }
    return LogoPosition.logoPostionleftTop;
  }
  
  public final BaiduMap getMap()
  {
    BaiduMap localBaiduMap = this.b;
    localBaiduMap.M = this;
    return localBaiduMap;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.a.getBaseMap().t().a;
    return ((Integer)A.get((int)f1)).intValue();
  }
  
  public Point getScaleControlPosition()
  {
    return this.f;
  }
  
  public int getScaleControlViewHeight()
  {
    return this.v;
  }
  
  public int getScaleControlViewWidth()
  {
    return this.v;
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    MapStatus localMapStatus = (MapStatus)paramBundle.getParcelable("mapstatus");
    if (this.f != null) {
      this.f = ((Point)paramBundle.getParcelable("scalePosition"));
    }
    if (this.g != null) {
      this.g = ((Point)paramBundle.getParcelable("zoomPosition"));
    }
    this.o = paramBundle.getBoolean("mZoomControlEnabled");
    this.p = paramBundle.getBoolean("mScaleControlEnabled");
    this.n = paramBundle.getInt("logoPosition");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    if (this.l != null) {
      this.a.onDestroy();
    }
    Bitmap localBitmap = this.d;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.d.recycle();
    }
    this.e.d();
    BMapManager.destroy();
    f.a();
    this.l = null;
  }
  
  @SuppressLint({"NewApi"})
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getChildCount();
    a(this.c);
    paramInt1 = getWidth();
    paramInt2 = this.q;
    paramInt3 = this.r;
    paramInt4 = this.c.getMeasuredWidth();
    float f2 = 1.0F;
    float f1;
    if ((paramInt1 - paramInt2 - paramInt3 - paramInt4 > 0) && (getHeight() - this.s - this.t - this.c.getMeasuredHeight() > 0))
    {
      f2 = (getWidth() - this.q - this.r) / getWidth();
      f1 = (getHeight() - this.s - this.t) / getHeight();
    }
    else
    {
      this.q = 0;
      this.r = 0;
      this.t = 0;
      this.s = 0;
      f1 = 1.0F;
    }
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = getChildAt(i1);
      if (localObject2 != null)
      {
        Object localObject1 = this.a;
        if (localObject2 == localObject1)
        {
          ((TextureView)localObject1).layout(0, 0, getWidth(), getHeight());
        }
        else
        {
          localObject1 = this.c;
          float f3;
          float f4;
          int i3;
          if (localObject2 == localObject1)
          {
            f3 = this.q;
            f4 = f2 * 5.0F;
            paramInt4 = (int)(f3 + f4);
            paramInt2 = (int)(this.r + f4);
            f3 = this.s;
            f4 = 5.0F * f1;
            paramInt3 = (int)(f3 + f4);
            paramInt1 = (int)(this.t + f4);
            i3 = this.n;
            if (i3 != 1)
            {
              if (i3 != 2)
              {
                if (i3 != 3)
                {
                  if (i3 != 4)
                  {
                    if (i3 != 5)
                    {
                      paramInt1 = getHeight() - paramInt1;
                      paramInt2 = this.c.getMeasuredWidth() + paramInt4;
                      paramInt3 = paramInt1 - this.c.getMeasuredHeight();
                      break label510;
                    }
                    paramInt1 = paramInt3 + ((ImageView)localObject1).getMeasuredHeight();
                  }
                  else
                  {
                    paramInt1 = getHeight() - paramInt1;
                    paramInt3 = paramInt1 - this.c.getMeasuredHeight();
                  }
                  paramInt2 = getWidth() - paramInt2;
                  paramInt4 = paramInt2 - this.c.getMeasuredWidth();
                  break label510;
                }
                paramInt1 = paramInt3 + ((ImageView)localObject1).getMeasuredHeight();
              }
              else
              {
                paramInt1 = getHeight() - paramInt1;
                paramInt3 = paramInt1 - this.c.getMeasuredHeight();
              }
              paramInt4 = (getWidth() - this.c.getMeasuredWidth() + this.q - this.r) / 2;
              paramInt2 = (getWidth() + this.c.getMeasuredWidth() + this.q - this.r) / 2;
            }
            else
            {
              paramInt1 = ((ImageView)localObject1).getMeasuredHeight() + paramInt3;
              paramInt2 = this.c.getMeasuredWidth() + paramInt4;
            }
            label510:
            this.c.layout(paramInt4, paramInt3, paramInt2, paramInt1);
          }
          else
          {
            localObject1 = this.e;
            if (localObject2 == localObject1)
            {
              if (((y)localObject1).c())
              {
                a(this.e);
                localObject1 = this.g;
                if (localObject1 == null)
                {
                  paramInt4 = (int)((getHeight() - 15) * f1 + this.s);
                  i3 = (int)((getWidth() - 15) * f2 + this.q);
                  int i4 = this.e.getMeasuredWidth();
                  paramInt3 = paramInt4 - this.e.getMeasuredHeight();
                  paramInt2 = paramInt4;
                  paramInt1 = paramInt3;
                  if (this.n == 4)
                  {
                    paramInt2 = paramInt4 - this.c.getMeasuredHeight();
                    paramInt1 = paramInt3 - this.c.getMeasuredHeight();
                  }
                  this.e.layout(i3 - i4, paramInt1, i3, paramInt2);
                }
                else
                {
                  localObject2 = this.e;
                  paramInt1 = ((Point)localObject1).x;
                  ((LinearLayout)localObject2).layout(paramInt1, ((Point)localObject1).y, ((LinearLayout)localObject2).getMeasuredWidth() + paramInt1, this.g.y + this.e.getMeasuredHeight());
                }
              }
            }
            else
            {
              localObject1 = this.h;
              if (localObject2 == localObject1)
              {
                a((View)localObject1);
                localObject1 = this.f;
                if (localObject1 == null)
                {
                  paramInt2 = (int)(this.t + f1 * 5.0F + 56.0F);
                  this.v = this.h.getMeasuredWidth();
                  this.u = this.h.getMeasuredHeight();
                  paramInt1 = (int)(this.q + 5.0F * f2);
                  paramInt2 = getHeight() - paramInt2 - this.c.getMeasuredHeight();
                  paramInt3 = this.v;
                  paramInt4 = this.u;
                  this.h.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
                }
                else
                {
                  localObject2 = this.h;
                  paramInt1 = ((Point)localObject1).x;
                  ((RelativeLayout)localObject2).layout(paramInt1, ((Point)localObject1).y, ((RelativeLayout)localObject2).getMeasuredWidth() + paramInt1, this.f.y + this.h.getMeasuredHeight());
                }
              }
              else
              {
                localObject1 = ((View)localObject2).getLayoutParams();
                if ((localObject1 instanceof MapViewLayoutParams))
                {
                  MapViewLayoutParams localMapViewLayoutParams = (MapViewLayoutParams)localObject1;
                  if (localMapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode)
                  {
                    localObject1 = localMapViewLayoutParams.b;
                  }
                  else
                  {
                    localObject1 = CoordUtil.ll2mc(localMapViewLayoutParams.a);
                    if (this.a.getBaseMap() != null) {
                      localObject1 = this.a.getBaseMap().a((GeoPoint)localObject1);
                    } else {
                      localObject1 = new Point();
                    }
                  }
                  a((View)localObject2);
                  paramInt1 = ((View)localObject2).getMeasuredWidth();
                  paramInt2 = ((View)localObject2).getMeasuredHeight();
                  f3 = localMapViewLayoutParams.d;
                  f4 = localMapViewLayoutParams.e;
                  paramInt3 = (int)(((Point)localObject1).x - f3 * paramInt1);
                  paramInt4 = (int)(((Point)localObject1).y - f4 * paramInt2) + localMapViewLayoutParams.f;
                  ((View)localObject2).layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
                }
              }
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public final void onPause()
  {
    this.a.onPause();
  }
  
  public final void onResume()
  {
    this.a.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      paramBundle.putParcelable("mapstatus", ((BaiduMap)localObject).getMapStatus());
      localObject = this.f;
      if (localObject != null) {
        paramBundle.putParcelable("scalePosition", (Parcelable)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        paramBundle.putParcelable("zoomPosition", (Parcelable)localObject);
      }
      paramBundle.putBoolean("mZoomControlEnabled", this.o);
      paramBundle.putBoolean("mScaleControlEnabled", this.p);
      paramBundle.putInt("logoPosition", this.n);
      paramBundle.putInt("paddingLeft", this.q);
      paramBundle.putInt("paddingTop", this.s);
      paramBundle.putInt("paddingRight", this.r);
      paramBundle.putInt("paddingBottom", this.t);
    }
  }
  
  public void removeView(final View paramView)
  {
    if (paramView == this.c) {
      return;
    }
    if (c())
    {
      super.removeView(paramView);
      return;
    }
    h.a(new e(paramView), 0L);
  }
  
  public void setCustomStyleFilePathAndMode(String paramString, int paramInt) {}
  
  public final void setLogoPosition(LogoPosition paramLogoPosition)
  {
    LogoPosition localLogoPosition = paramLogoPosition;
    if (paramLogoPosition == null) {
      localLogoPosition = LogoPosition.logoPostionleftBottom;
    }
    this.n = localLogoPosition.ordinal();
    requestLayout();
  }
  
  public void setMapCustomStyle(final MapCustomStyleOptions paramMapCustomStyleOptions, final CustomMapStyleCallBack paramCustomMapStyleCallBack)
  {
    if (paramMapCustomStyleOptions == null) {
      return;
    }
    String str = paramMapCustomStyleOptions.getCustomMapStyleId();
    if ((str != null) && (!str.isEmpty()))
    {
      d.a().a(this.l, str, new a(paramCustomMapStyleCallBack, paramMapCustomStyleOptions));
      return;
    }
    paramMapCustomStyleOptions = paramMapCustomStyleOptions.getLocalCustomStyleFilePath();
    if ((paramMapCustomStyleOptions != null) && (!paramMapCustomStyleOptions.isEmpty())) {
      a(paramMapCustomStyleOptions, "");
    }
  }
  
  public void setMapCustomStyleEnable(boolean paramBoolean)
  {
    MapTextureView localMapTextureView = this.a;
    if (localMapTextureView == null) {
      return;
    }
    localMapTextureView.getBaseMap().k(paramBoolean);
  }
  
  public void setMapCustomStylePath(String paramString)
  {
    a(paramString, "");
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.q = paramInt1;
    this.s = paramInt2;
    this.r = paramInt3;
    this.t = paramInt4;
  }
  
  public void setScaleControlPosition(Point paramPoint)
  {
    if (paramPoint == null) {
      return;
    }
    int i1 = paramPoint.x;
    if ((i1 >= 0) && (paramPoint.y >= 0) && (i1 <= getWidth()) && (paramPoint.y <= getHeight()))
    {
      this.f = paramPoint;
      requestLayout();
    }
  }
  
  public void setZoomControlsPosition(Point paramPoint)
  {
    if (paramPoint == null) {
      return;
    }
    int i1 = paramPoint.x;
    if ((i1 >= 0) && (paramPoint.y >= 0) && (i1 <= getWidth()) && (paramPoint.y <= getHeight()))
    {
      this.g = paramPoint;
      requestLayout();
    }
  }
  
  public void showScaleControl(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.h;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localRelativeLayout.setVisibility(i1);
    this.p = paramBoolean;
  }
  
  public void showZoomControls(boolean paramBoolean)
  {
    if (this.e.c())
    {
      y localy = this.e;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localy.setVisibility(i1);
      this.o = paramBoolean;
    }
  }
  
  class a
    implements d.c
  {
    a(CustomMapStyleCallBack paramCustomMapStyleCallBack, MapCustomStyleOptions paramMapCustomStyleOptions) {}
    
    public void onCustomMapStyleLoadFailed(int paramInt, String paramString1, String paramString2)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onCustomMapStyleLoadFailed(paramInt, paramString1, paramString2))) {
        return;
      }
      if (TextureMapView.a(TextureMapView.this)) {
        return;
      }
      TextureMapView.a(TextureMapView.this, paramString2, paramMapCustomStyleOptions);
    }
    
    public void onCustomMapStyleLoadSuccess(boolean paramBoolean, String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onCustomMapStyleLoadSuccess(paramBoolean, paramString))) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        TextureMapView.a(TextureMapView.this, paramString, "");
        TextureMapView.this.setMapCustomStyleEnable(true);
      }
    }
    
    public void onPreLoadLastCustomMapStyle(String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onPreLoadLastCustomMapStyle(paramString))) {
        return;
      }
      TextureMapView.a(TextureMapView.this, paramString, paramMapCustomStyleOptions);
      TextureMapView.a(TextureMapView.this, true);
    }
  }
  
  class b
    implements x
  {
    b() {}
    
    public void a() {}
    
    public void a(MotionEvent paramMotionEvent) {}
    
    public void a(s params) {}
    
    public void a(GeoPoint paramGeoPoint) {}
    
    public void a(GL10 paramGL10, s params) {}
    
    public void a(boolean paramBoolean) {}
    
    public void a(boolean paramBoolean, int paramInt) {}
    
    public boolean a(String paramString)
    {
      return false;
    }
    
    public void b() {}
    
    public void b(s params)
    {
      if (TextureMapView.b(TextureMapView.this) != null)
      {
        if (TextureMapView.b(TextureMapView.this).getController() == null) {
          return;
        }
        float f2 = TextureMapView.b(TextureMapView.this).getZoomLevel();
        float f1;
        if (f2 < TextureMapView.b(TextureMapView.this).getController().mMinZoomLevel)
        {
          f1 = TextureMapView.b(TextureMapView.this).getController().mMinZoomLevel;
        }
        else
        {
          f1 = f2;
          if (f2 > TextureMapView.b(TextureMapView.this).getController().mMaxZoomLevel) {
            f1 = TextureMapView.b(TextureMapView.this).getController().mMaxZoomLevel;
          }
        }
        if (Math.abs(TextureMapView.c(TextureMapView.this) - f1) > 0.0F)
        {
          int i = ((Integer)TextureMapView.a().get(Math.round(f1))).intValue();
          int j = (int)(i / TextureMapView.b(TextureMapView.this).getController().getZoomUnitsInMeter());
          if (TextureMapView.d(TextureMapView.this) != null)
          {
            params = TextureMapView.d(TextureMapView.this);
            j /= 2;
            params.setPadding(j, 0, j, 0);
          }
          params = new Object[1];
          if (i >= 1000)
          {
            params[0] = Integer.valueOf(i / 1000);
            params = String.format(" %d公里 ", params);
          }
          else
          {
            params[0] = Integer.valueOf(i);
            params = String.format(" %d米 ", params);
          }
          if (TextureMapView.e(TextureMapView.this) != null) {
            TextureMapView.e(TextureMapView.this).setText(params);
          }
          if (TextureMapView.f(TextureMapView.this) != null) {
            TextureMapView.f(TextureMapView.this).setText(params);
          }
          TextureMapView.a(TextureMapView.this, f1);
        }
        TextureMapView.g(TextureMapView.this);
        TextureMapView.this.requestLayout();
      }
    }
    
    public void b(GeoPoint paramGeoPoint) {}
    
    public void b(String paramString) {}
    
    public void c() {}
    
    public void c(s params) {}
    
    public void c(GeoPoint paramGeoPoint) {}
    
    public void d() {}
    
    public void d(GeoPoint paramGeoPoint) {}
    
    public void e(GeoPoint paramGeoPoint) {}
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      float f2 = TextureMapView.b(TextureMapView.this).getZoomLevel();
      float f1 = f2 - 1.0F;
      double d = f2;
      if (Math.floor(d) != d) {
        f1 = (float)Math.floor(d);
      }
      f1 = Math.max(f1, TextureMapView.b(TextureMapView.this).getController().mMinZoomLevel);
      BaiduMap.mapStatusReason |= 0x10;
      TextureMapView.b(TextureMapView.this).setZoomLevel(f1);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      float f2 = TextureMapView.b(TextureMapView.this).getZoomLevel();
      float f1 = 1.0F + f2;
      double d = f2;
      if ((int)Math.ceil(d) != (int)f2) {
        f1 = (float)Math.ceil(d);
      }
      f1 = Math.min(f1, TextureMapView.b(TextureMapView.this).getController().mMaxZoomLevel);
      BaiduMap.mapStatusReason |= 0x10;
      TextureMapView.b(TextureMapView.this).setZoomLevel(f1);
    }
  }
  
  class e
    implements Runnable
  {
    e(View paramView) {}
    
    public void run()
    {
      TextureMapView.this.removeView(paramView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.TextureMapView
 * JD-Core Version:    0.7.0.1
 */