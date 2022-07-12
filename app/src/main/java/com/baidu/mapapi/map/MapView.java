package com.baidu.mapapi.map;

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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
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
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.x;
import com.baidu.platform.comapi.util.h;
import java.io.File;
import javax.microedition.khronos.opengles.GL10;

public final class MapView
  extends ViewGroup
{
  private static final SparseIntArray A;
  private static final String x = MapView.class.getSimpleName();
  private static String y;
  private static int z = 0;
  private MapSurfaceView a;
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
  private int m = LogoPosition.logoPostionleftBottom.ordinal();
  private boolean n = true;
  private boolean o = true;
  private float p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private boolean w = false;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    A = localSparseIntArray;
    localSparseIntArray.append(3, 2000000);
    localSparseIntArray.append(4, 1000000);
    localSparseIntArray.append(5, 500000);
    localSparseIntArray.append(6, 200000);
    localSparseIntArray.append(7, 100000);
    localSparseIntArray.append(8, 50000);
    localSparseIntArray.append(9, 25000);
    localSparseIntArray.append(10, 20000);
    localSparseIntArray.append(11, 10000);
    localSparseIntArray.append(12, 5000);
    localSparseIntArray.append(13, 2000);
    localSparseIntArray.append(14, 1000);
    localSparseIntArray.append(15, 500);
    localSparseIntArray.append(16, 200);
    localSparseIntArray.append(17, 100);
    localSparseIntArray.append(18, 50);
    localSparseIntArray.append(19, 20);
    localSparseIntArray.append(20, 10);
    localSparseIntArray.append(21, 5);
    localSparseIntArray.append(22, 2);
    localSparseIntArray.append(23, 2);
    localSparseIntArray.append(24, 2);
    localSparseIntArray.append(25, 2);
    localSparseIntArray.append(26, 2);
  }
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
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
    if (localBitmap == null) {
      return;
    }
    if (i1 > 480) {
      localObject = new Matrix();
    }
    for (float f1 = 2.0F;; f1 = 1.5F)
    {
      ((Matrix)localObject).postScale(f1, f1);
      this.d = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      break label117;
      if (i1 <= 320) {
        break;
      }
      localObject = new Matrix();
    }
    this.d = localBitmap;
    label117:
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
        this.m = paramContext.ordinal();
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
    this.a = new MapSurfaceView(paramContext);
    if (paramBaiduMapOptions != null) {
      this.b = new BaiduMap(paramContext, this.a, paramBaiduMapOptions.a());
    } else {
      this.b = new BaiduMap(paramContext, this.a, null);
    }
    addView(this.a);
    paramContext = new b();
    if (this.a.getBaseMap() != null) {
      this.a.getBaseMap().a(paramContext);
    }
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
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView != null)
    {
      if (localMapSurfaceView.getBaseMap() == null) {
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
    if ((localy != null) && (localy.c()))
    {
      if (this.a.getBaseMap() == null) {
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
    Object localObject1 = new ViewGroup.LayoutParams(-2, -2);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.i = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    this.i.setTextColor(Color.parseColor("#FFFFFF"));
    this.i.setTextSize(2, 11.0F);
    Object localObject2 = this.i;
    ((TextView)localObject2).setTypeface(((TextView)localObject2).getTypeface(), 1);
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.i.setId(2147483647);
    this.h.addView(this.i);
    this.j = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    this.j.setTextColor(Color.parseColor("#000000"));
    this.j.setTextSize(2, 11.0F);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.h.addView(this.j);
    this.k = new ImageView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.i.getId());
    localObject2 = this.k;
    if (localObject2 != null)
    {
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramContext = a.a("icon_scale.9.png", paramContext);
      if (paramContext != null)
      {
        localObject1 = paramContext.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk((byte[])localObject1))
        {
          paramContext = new NinePatchDrawable(paramContext, (byte[])localObject1, new Rect(), null);
          this.k.setBackgroundDrawable(paramContext);
        }
      }
      this.h.addView(this.k);
    }
    addView(this.h);
  }
  
  private void c(Context paramContext)
  {
    paramContext = new y(paramContext, false);
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
  public static void setIconCustom(int paramInt) {}
  
  @Deprecated
  public static void setLoadCustomMapStyleFileMode(int paramInt)
  {
    z = paramInt;
  }
  
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
  
  public void cancelRenderMap() {}
  
  public final LogoPosition getLogoPosition()
  {
    int i1 = this.m;
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
    localBaiduMap.L = this;
    return localBaiduMap;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.a.getZoomLevel();
    return A.get(Math.round(f1));
  }
  
  public Point getScaleControlPosition()
  {
    return this.f;
  }
  
  public int getScaleControlViewHeight()
  {
    return this.u;
  }
  
  public int getScaleControlViewWidth()
  {
    return this.v;
  }
  
  public Point getZoomControlsPosition()
  {
    return this.g;
  }
  
  public boolean handleMultiTouch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return false;
  }
  
  public void handleTouchDown(float paramFloat1, float paramFloat2) {}
  
  public boolean handleTouchMove(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean handleTouchUp(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean inRangeOfView(float paramFloat1, float paramFloat2)
  {
    MapSurfaceView localMapSurfaceView = this.a;
    return (localMapSurfaceView != null) && (localMapSurfaceView.inRangeOfView(paramFloat1, paramFloat2));
  }
  
  public boolean isShowScaleControl()
  {
    return this.o;
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
    this.n = paramBundle.getBoolean("mZoomControlEnabled");
    this.o = paramBundle.getBoolean("mScaleControlEnabled");
    this.m = paramBundle.getInt("logoPosition");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((BaiduMap)localObject).c();
    }
    localObject = this.a;
    if (localObject != null) {
      ((MapSurfaceView)localObject).unInit();
    }
    localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
    if (y != null) {
      y = null;
    }
    this.e.d();
    BMapManager.destroy();
    f.a();
    this.l = null;
  }
  
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
          ((SurfaceView)localObject1).layout(0, 0, getWidth(), getHeight());
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
            i3 = this.m;
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
                  if (this.m == 4)
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
      BaiduMap localBaiduMap = this.b;
      if (localBaiduMap == null) {
        return;
      }
      paramBundle.putParcelable("mapstatus", localBaiduMap.getMapStatus());
      paramBundle.putBoolean("mZoomControlEnabled", this.n);
      paramBundle.putBoolean("mScaleControlEnabled", this.o);
      paramBundle.putInt("logoPosition", this.m);
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
  
  public void renderMap() {}
  
  public void setCustomStyleFilePathAndMode(String paramString, int paramInt) {}
  
  public final void setLogoPosition(LogoPosition paramLogoPosition)
  {
    LogoPosition localLogoPosition = paramLogoPosition;
    if (paramLogoPosition == null) {
      localLogoPosition = LogoPosition.logoPostionleftBottom;
    }
    this.m = localLogoPosition.ordinal();
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
    if ((paramMapCustomStyleOptions != null) && (!paramMapCustomStyleOptions.isEmpty()))
    {
      a(paramMapCustomStyleOptions, "");
      setMapCustomStyleEnable(true);
    }
  }
  
  public void setMapCustomStyleEnable(boolean paramBoolean)
  {
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView != null)
    {
      if (localMapSurfaceView.getBaseMap() == null) {
        return;
      }
      this.a.getBaseMap().k(paramBoolean);
    }
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
  
  public void setUpViewEventToMapView(MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean)
  {
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView == null) {
      return;
    }
    localMapSurfaceView.setZOrderMediaOverlay(paramBoolean);
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
    this.o = paramBoolean;
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
      this.n = paramBoolean;
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
      if (MapView.a(MapView.this)) {
        return;
      }
      MapView.a(MapView.this, paramString2, paramMapCustomStyleOptions);
    }
    
    public void onCustomMapStyleLoadSuccess(boolean paramBoolean, String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onCustomMapStyleLoadSuccess(paramBoolean, paramString))) {
        return;
      }
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
      {
        MapView.a(MapView.this, paramString, "");
        MapView.this.setMapCustomStyleEnable(true);
      }
    }
    
    public void onPreLoadLastCustomMapStyle(String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onPreLoadLastCustomMapStyle(paramString))) {
        return;
      }
      MapView.a(MapView.this, paramString, paramMapCustomStyleOptions);
      MapView.a(MapView.this, true);
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
      if (MapView.b(MapView.this) != null)
      {
        if (MapView.b(MapView.this).getController() == null) {
          return;
        }
        float f2 = MapView.b(MapView.this).getZoomLevel();
        float f1;
        if (f2 < MapView.b(MapView.this).getController().mMinZoomLevel)
        {
          f1 = MapView.b(MapView.this).getController().mMinZoomLevel;
        }
        else
        {
          f1 = f2;
          if (f2 > MapView.b(MapView.this).getController().mMaxZoomLevel) {
            f1 = MapView.b(MapView.this).getController().mMaxZoomLevel;
          }
        }
        if (Math.abs(MapView.c(MapView.this) - f1) > 0.0F)
        {
          int i = MapView.a().get(Math.round(f1));
          int j = (int)(i / MapView.b(MapView.this).getController().getZoomUnitsInMeter());
          if (MapView.d(MapView.this) != null)
          {
            params = MapView.d(MapView.this);
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
          if (MapView.e(MapView.this) != null) {
            MapView.e(MapView.this).setText(params);
          }
          if (MapView.f(MapView.this) != null) {
            MapView.f(MapView.this).setText(params);
          }
          MapView.a(MapView.this, f1);
        }
        MapView.g(MapView.this);
        MapView.this.requestLayout();
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
      float f2 = MapView.b(MapView.this).getZoomLevel();
      float f1 = f2 - 1.0F;
      double d = f2;
      if (Math.floor(d) != d) {
        f1 = (float)Math.floor(d);
      }
      f1 = Math.max(f1, MapView.b(MapView.this).getController().mMinZoomLevel);
      BaiduMap.mapStatusReason |= 0x10;
      MapView.b(MapView.this).setZoomLevel(f1);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      float f2 = MapView.b(MapView.this).getZoomLevel();
      float f1 = 1.0F + f2;
      double d = f2;
      if ((int)Math.ceil(d) != (int)f2) {
        f1 = (float)Math.ceil(d);
      }
      f1 = Math.min(f1, MapView.b(MapView.this).getController().mMaxZoomLevel);
      BaiduMap.mapStatusReason |= 0x10;
      MapView.b(MapView.this).setZoomLevel(f1);
    }
  }
  
  class e
    implements Runnable
  {
    e(View paramView) {}
    
    public void run()
    {
      MapView.this.removeView(paramView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapView
 * JD-Core Version:    0.7.0.1
 */