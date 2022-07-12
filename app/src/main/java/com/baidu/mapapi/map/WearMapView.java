package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.view.WindowManager;
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
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(20)
public class WearMapView
  extends ViewGroup
  implements View.OnApplyWindowInsetsListener
{
  private static final String A = MapView.class.getSimpleName();
  private static String B;
  public static final int BT_INVIEW = 1;
  private static int C = 0;
  private static int D = 0;
  private static int E = 10;
  private static final SparseArray<Integer> F;
  private MapSurfaceView a;
  private BaiduMap b;
  private ImageView c;
  private Bitmap d;
  private y e;
  private boolean f = true;
  private Point g;
  private Point h;
  private RelativeLayout i;
  private SwipeDismissView j;
  private TextView k;
  private TextView l;
  private ImageView m;
  public AnimationTask mTask;
  public Timer mTimer;
  public f mTimerHandler;
  private boolean n = true;
  private Context o;
  ScreenShape p = ScreenShape.ROUND;
  private boolean q = true;
  private boolean r = true;
  private float s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private boolean z = false;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    F = localSparseArray;
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
  
  public WearMapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    super(paramContext);
    a(paramContext, paramBaiduMapOptions);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - (int)Math.sqrt(Math.pow(paramInt1, 2.0D) - Math.pow(paramInt2, 2.0D));
  }
  
  private void a()
  {
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView == null) {
      return;
    }
    localMapSurfaceView.onBackground();
  }
  
  private void a(int paramInt)
  {
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      localMapSurfaceView.onResume();
      e();
      return;
    }
    localMapSurfaceView.onPause();
    d();
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
    e(paramContext);
    setOnApplyWindowInsetsListener(this);
    this.o = paramContext;
    this.mTimerHandler = new f(paramContext);
    this.mTimer = new Timer();
    AnimationTask localAnimationTask = this.mTask;
    if (localAnimationTask != null) {
      localAnimationTask.cancel();
    }
    localAnimationTask = new AnimationTask();
    this.mTask = localAnimationTask;
    this.mTimer.schedule(localAnimationTask, 5000L);
    f.b();
    BMapManager.init();
    a(paramContext, paramBaiduMapOptions, B);
    this.a.getController().set3DGestureEnable(false);
    this.a.getController().setOverlookGestureEnable(false);
    a(paramContext);
    d(paramContext);
    c(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h)) {
      this.e.setVisibility(4);
    }
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i)) {
      this.i.setVisibility(4);
    }
    if (paramBaiduMapOptions != null)
    {
      paramContext = paramBaiduMapOptions.l;
      if (paramContext != null) {
        this.h = paramContext;
      }
    }
    if (paramBaiduMapOptions != null)
    {
      paramContext = paramBaiduMapOptions.k;
      if (paramContext != null) {
        this.g = paramContext;
      }
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions, String paramString)
  {
    this.a = new MapSurfaceView(paramContext);
    if (paramBaiduMapOptions != null) {
      this.b = new BaiduMap(paramContext, this.a, paramBaiduMapOptions.a());
    } else {
      this.b = new BaiduMap(paramContext, this.a, null);
    }
    addView(this.a);
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
  
  private void a(final View paramView, boolean paramBoolean)
  {
    AnimatorSet localAnimatorSet;
    if (paramBoolean)
    {
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "TranslationY", new float[] { 0.0F, -50.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
      localAnimatorSet.addListener(new e(paramView));
      paramView = localAnimatorSet;
    }
    else
    {
      paramView.setVisibility(0);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "TranslationY", new float[] { -50.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
      paramView = localAnimatorSet;
    }
    paramView.setDuration(1200L);
    paramView.start();
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
    paramString2 = this.a;
    if (paramString2 != null)
    {
      if (paramString2.getBaseMap() == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        Log.e(A, "customStyleFilePath is empty or null, please check!");
        return;
      }
      if (!paramString1.endsWith(".sty"))
      {
        Log.e(A, "customStyleFile format is incorrect , please check!");
        return;
      }
      if (!new File(paramString1).exists())
      {
        Log.e(A, "customStyleFile does not exist , please check!");
        return;
      }
      this.a.getBaseMap().a(paramString1, "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.f) {
      return;
    }
    a(this.e, paramBoolean);
  }
  
  private void b()
  {
    MapSurfaceView localMapSurfaceView = this.a;
    if (localMapSurfaceView == null) {
      return;
    }
    localMapSurfaceView.onForeground();
  }
  
  private void b(Context paramContext)
  {
    this.i = new RelativeLayout(paramContext);
    Object localObject = new ViewGroup.LayoutParams(-2, -2);
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.k.setTextColor(Color.parseColor("#FFFFFF"));
    this.k.setTextSize(2, 11.0F);
    TextView localTextView = this.k;
    localTextView.setTypeface(localTextView.getTypeface(), 1);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k.setId(2147483647);
    this.i.addView(this.k);
    this.l = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.l.setTextColor(Color.parseColor("#000000"));
    this.l.setTextSize(2, 11.0F);
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.i.addView(this.l);
    this.m = new ImageView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.k.getId());
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext = a.a("icon_scale.9.png", paramContext);
    localObject = paramContext.getNinePatchChunk();
    NinePatch.isNinePatchChunk((byte[])localObject);
    paramContext = new NinePatchDrawable(paramContext, (byte[])localObject, new Rect(), null);
    this.m.setBackgroundDrawable(paramContext);
    this.i.addView(this.m);
    addView(this.i);
  }
  
  private void c(Context paramContext)
  {
    this.j = new SwipeDismissView(paramContext, this);
    paramContext = new ViewGroup.LayoutParams((int)(paramContext.getResources().getDisplayMetrics().density * 34.0F + 0.5F), D);
    this.j.setBackgroundColor(Color.argb(0, 0, 0, 0));
    this.j.setLayoutParams(paramContext);
    addView(this.j);
  }
  
  private void d()
  {
    if (this.a == null) {
      return;
    }
    if (!this.n)
    {
      a();
      this.n = true;
    }
  }
  
  private void d(Context paramContext)
  {
    paramContext = new y(paramContext, true);
    this.e = paramContext;
    if (!paramContext.c()) {
      return;
    }
    this.e.b(new c());
    this.e.a(new d());
    addView(this.e);
  }
  
  private void e()
  {
    if (this.a == null) {
      return;
    }
    if (this.n)
    {
      b();
      this.n = false;
    }
  }
  
  private static void e(Context paramContext)
  {
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  @Deprecated
  public static void setCustomMapStylePath(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (new File(paramString).exists())
      {
        B = paramString;
        return;
      }
      throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
    }
    throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
  }
  
  @Deprecated
  public static void setIconCustom(int paramInt) {}
  
  @Deprecated
  public static void setLoadCustomMapStyleFileMode(int paramInt) {}
  
  @Deprecated
  public static void setMapCustomEnable(boolean paramBoolean) {}
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  public final BaiduMap getMap()
  {
    BaiduMap localBaiduMap = this.b;
    localBaiduMap.N = this;
    return localBaiduMap;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.a.getZoomLevel();
    return ((Integer)F.get((int)f1)).intValue();
  }
  
  public int getScaleControlViewHeight()
  {
    return this.x;
  }
  
  public int getScaleControlViewWidth()
  {
    return this.y;
  }
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    if (paramWindowInsets.isRound()) {
      paramView = ScreenShape.ROUND;
    } else {
      paramView = ScreenShape.RECTANGLE;
    }
    this.p = paramView;
    return paramWindowInsets;
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    MapStatus localMapStatus = (MapStatus)paramBundle.getParcelable("mapstatus");
    if (this.g != null) {
      this.g = ((Point)paramBundle.getParcelable("scalePosition"));
    }
    if (this.h != null) {
      this.h = ((Point)paramBundle.getParcelable("zoomPosition"));
    }
    this.q = paramBundle.getBoolean("mZoomControlEnabled");
    this.r = paramBundle.getBoolean("mScaleControlEnabled");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    if (this.o != null) {
      this.a.unInit();
    }
    Object localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
    this.e.d();
    BMapManager.destroy();
    f.a();
    localObject = this.mTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.o = null;
  }
  
  public final void onDismiss()
  {
    removeAllViews();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    a(0);
  }
  
  public void onExitAmbient()
  {
    a(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    Object localObject;
    if (i1 != 0)
    {
      if (i1 == 1)
      {
        this.mTimer = new Timer();
        localObject = this.mTask;
        if (localObject != null) {
          ((TimerTask)localObject).cancel();
        }
        localObject = new AnimationTask();
        this.mTask = ((AnimationTask)localObject);
        this.mTimer.schedule((TimerTask)localObject, 5000L);
      }
    }
    else if (this.e.getVisibility() == 0)
    {
      localObject = this.mTimer;
      if (localObject != null)
      {
        if (this.mTask != null)
        {
          ((Timer)localObject).cancel();
          this.mTask.cancel();
        }
        this.mTimer = null;
        this.mTask = null;
      }
    }
    else if (this.e.getVisibility() == 4)
    {
      if (this.mTimer != null)
      {
        localObject = this.mTask;
        if (localObject != null) {
          ((TimerTask)localObject).cancel();
        }
        this.mTimer.cancel();
        this.mTask = null;
        this.mTimer = null;
      }
      a(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(20)
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    a(this.c);
    paramInt1 = getWidth();
    paramInt2 = this.t;
    paramInt3 = this.u;
    int i1 = this.c.getMeasuredWidth();
    float f2 = 1.0F;
    float f1;
    if ((paramInt1 - paramInt2 - paramInt3 - i1 > 0) && (getHeight() - this.v - this.w - this.c.getMeasuredHeight() > 0))
    {
      f1 = (getWidth() - this.t - this.u) / getWidth();
      f2 = (getHeight() - this.v - this.w) / getHeight();
    }
    else
    {
      this.t = 0;
      this.u = 0;
      this.w = 0;
      this.v = 0;
      f1 = 1.0F;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      Object localObject2 = getChildAt(paramInt1);
      Object localObject1 = this.a;
      if (localObject2 == localObject1)
      {
        ((SurfaceView)localObject1).layout(0, 0, getWidth(), getHeight());
      }
      else
      {
        int i2;
        if (localObject2 == this.c)
        {
          i1 = (int)(this.w + 12.0F * f2);
          if (this.p == ScreenShape.ROUND)
          {
            a(this.e);
            paramInt2 = C / 2;
            paramInt3 = a(paramInt2, this.e.getMeasuredWidth() / 2);
            paramInt2 = C / 2 - a(paramInt2, paramInt2 - paramInt3) + E;
          }
          else
          {
            paramInt3 = 0;
            paramInt2 = paramInt3;
          }
          paramInt3 = D - paramInt3 - i1;
          i1 = this.c.getMeasuredHeight();
          paramInt2 = C - paramInt2;
          i2 = this.c.getMeasuredWidth();
          this.c.layout(paramInt2 - i2, paramInt3 - i1, paramInt2, paramInt3);
        }
        else
        {
          localObject1 = this.e;
          if (localObject2 == localObject1)
          {
            if (((y)localObject1).c())
            {
              a(this.e);
              localObject1 = this.h;
              if (localObject1 == null)
              {
                if (this.p == ScreenShape.ROUND) {
                  paramInt2 = a(D / 2, this.e.getMeasuredWidth() / 2);
                } else {
                  paramInt2 = 0;
                }
                paramInt2 = (int)(12.0F * f2 + this.v + paramInt2);
                paramInt3 = (C - this.e.getMeasuredWidth()) / 2;
                i1 = this.e.getMeasuredWidth();
                i2 = this.e.getMeasuredHeight();
                this.e.layout(paramInt3, paramInt2, i1 + paramInt3, i2 + paramInt2);
              }
              else
              {
                localObject2 = this.e;
                paramInt2 = ((Point)localObject1).x;
                ((LinearLayout)localObject2).layout(paramInt2, ((Point)localObject1).y, ((LinearLayout)localObject2).getMeasuredWidth() + paramInt2, this.h.y + this.e.getMeasuredHeight());
              }
            }
          }
          else if (localObject2 == this.i)
          {
            if (this.p == ScreenShape.ROUND)
            {
              a((View)localObject1);
              paramInt3 = C / 2;
              paramInt2 = a(paramInt3, this.e.getMeasuredWidth() / 2);
              paramInt3 = C / 2 - a(paramInt3, paramInt3 - paramInt2) + E;
            }
            else
            {
              paramInt2 = 0;
              paramInt3 = paramInt2;
            }
            a(this.i);
            localObject1 = this.g;
            if (localObject1 == null)
            {
              i1 = (int)(this.w + 12.0F * f2);
              this.y = this.i.getMeasuredWidth();
              this.x = this.i.getMeasuredHeight();
              paramInt3 = (int)(this.t + 5.0F * f1 + paramInt3);
              paramInt2 = D - i1 - paramInt2;
              i1 = this.y;
              i2 = this.i.getMeasuredHeight();
              this.i.layout(paramInt3, paramInt2 - i2, i1 + paramInt3, paramInt2);
            }
            else
            {
              localObject2 = this.i;
              paramInt2 = ((Point)localObject1).x;
              ((RelativeLayout)localObject2).layout(paramInt2, ((Point)localObject1).y, ((RelativeLayout)localObject2).getMeasuredWidth() + paramInt2, this.g.y + this.i.getMeasuredHeight());
            }
          }
          else
          {
            localObject1 = this.j;
            if (localObject2 == localObject1)
            {
              a((View)localObject1);
              paramInt2 = this.j.getMeasuredWidth();
              paramInt3 = D;
              this.j.layout(0, 0, paramInt2, paramInt3);
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
                paramInt2 = ((View)localObject2).getMeasuredWidth();
                paramInt3 = ((View)localObject2).getMeasuredHeight();
                float f3 = localMapViewLayoutParams.d;
                float f4 = localMapViewLayoutParams.e;
                i1 = (int)(((Point)localObject1).x - f3 * paramInt2);
                i2 = (int)(((Point)localObject1).y - f4 * paramInt3) + localMapViewLayoutParams.f;
                ((View)localObject2).layout(i1, i2, paramInt2 + i1, paramInt3 + i2);
              }
            }
          }
        }
      }
      paramInt1 += 1;
    }
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
      localObject = this.g;
      if (localObject != null) {
        paramBundle.putParcelable("scalePosition", (Parcelable)localObject);
      }
      localObject = this.h;
      if (localObject != null) {
        paramBundle.putParcelable("zoomPosition", (Parcelable)localObject);
      }
      paramBundle.putBoolean("mZoomControlEnabled", this.q);
      paramBundle.putBoolean("mScaleControlEnabled", this.r);
      paramBundle.putInt("paddingLeft", this.t);
      paramBundle.putInt("paddingTop", this.v);
      paramBundle.putInt("paddingRight", this.u);
      paramBundle.putInt("paddingBottom", this.w);
    }
  }
  
  public void removeView(View paramView)
  {
    if (paramView == this.c) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setCustomStyleFilePathAndMode(String paramString, int paramInt) {}
  
  public void setMapCustomStyle(final MapCustomStyleOptions paramMapCustomStyleOptions, final CustomMapStyleCallBack paramCustomMapStyleCallBack)
  {
    if (paramMapCustomStyleOptions == null) {
      return;
    }
    String str = paramMapCustomStyleOptions.getCustomMapStyleId();
    if ((str != null) && (!str.isEmpty()))
    {
      d.a().a(this.o, str, new a(paramCustomMapStyleCallBack, paramMapCustomStyleOptions));
      return;
    }
    paramMapCustomStyleOptions = paramMapCustomStyleOptions.getLocalCustomStyleFilePath();
    if ((paramMapCustomStyleOptions != null) && (!paramMapCustomStyleOptions.isEmpty())) {
      a(paramMapCustomStyleOptions, "");
    }
  }
  
  public void setMapCustomStyleEnable(boolean paramBoolean) {}
  
  public void setMapCustomStylePath(String paramString)
  {
    a(paramString, "");
  }
  
  public void setOnDismissCallbackListener(OnDismissCallback paramOnDismissCallback)
  {
    SwipeDismissView localSwipeDismissView = this.j;
    if (localSwipeDismissView == null) {
      return;
    }
    localSwipeDismissView.setCallback(paramOnDismissCallback);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.t = paramInt1;
    this.v = paramInt2;
    this.u = paramInt3;
    this.w = paramInt4;
  }
  
  public void setScaleControlPosition(Point paramPoint)
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
  
  public void setShape(ScreenShape paramScreenShape)
  {
    this.p = paramScreenShape;
  }
  
  public void setViewAnimitionEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setZoomControlsPosition(Point paramPoint)
  {
    if (paramPoint == null) {
      return;
    }
    int i1 = paramPoint.x;
    if ((i1 >= 0) && (paramPoint.y >= 0) && (i1 <= getWidth()) && (paramPoint.y <= getHeight()))
    {
      this.h = paramPoint;
      requestLayout();
    }
  }
  
  public void showScaleControl(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.i;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localRelativeLayout.setVisibility(i1);
    this.r = paramBoolean;
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
      this.q = paramBoolean;
    }
  }
  
  public class AnimationTask
    extends TimerTask
  {
    public AnimationTask() {}
    
    public void run()
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      WearMapView.this.mTimerHandler.sendMessage(localMessage);
    }
  }
  
  public static abstract interface OnDismissCallback
  {
    public abstract void onDismiss();
    
    public abstract void onNotify();
  }
  
  public static enum ScreenShape
  {
    static
    {
      ScreenShape localScreenShape1 = new ScreenShape("ROUND", 0);
      ROUND = localScreenShape1;
      ScreenShape localScreenShape2 = new ScreenShape("RECTANGLE", 1);
      RECTANGLE = localScreenShape2;
      ScreenShape localScreenShape3 = new ScreenShape("UNDETECTED", 2);
      UNDETECTED = localScreenShape3;
      a = new ScreenShape[] { localScreenShape1, localScreenShape2, localScreenShape3 };
    }
    
    private ScreenShape() {}
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
      if (WearMapView.a(WearMapView.this)) {
        return;
      }
      WearMapView.a(WearMapView.this, paramString2, paramMapCustomStyleOptions);
    }
    
    public void onCustomMapStyleLoadSuccess(boolean paramBoolean, String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onCustomMapStyleLoadSuccess(paramBoolean, paramString))) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        WearMapView.a(WearMapView.this, paramString, "");
        WearMapView.this.setMapCustomStyleEnable(true);
      }
    }
    
    public void onPreLoadLastCustomMapStyle(String paramString)
    {
      CustomMapStyleCallBack localCustomMapStyleCallBack = paramCustomMapStyleCallBack;
      if ((localCustomMapStyleCallBack != null) && (localCustomMapStyleCallBack.onPreLoadLastCustomMapStyle(paramString))) {
        return;
      }
      WearMapView.a(WearMapView.this, true);
      WearMapView.a(WearMapView.this, paramString, paramMapCustomStyleOptions);
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
      if (WearMapView.b(WearMapView.this) != null)
      {
        if (WearMapView.b(WearMapView.this).getBaseMap() == null) {
          return;
        }
        float f2 = WearMapView.b(WearMapView.this).getZoomLevel();
        float f1;
        if (f2 < WearMapView.b(WearMapView.this).getController().mMinZoomLevel)
        {
          f1 = WearMapView.b(WearMapView.this).getController().mMinZoomLevel;
        }
        else
        {
          f1 = f2;
          if (f2 > WearMapView.b(WearMapView.this).getController().mMaxZoomLevel) {
            f1 = WearMapView.b(WearMapView.this).getController().mMaxZoomLevel;
          }
        }
        if (Math.abs(WearMapView.c(WearMapView.this) - f1) > 0.0F)
        {
          int i = ((Integer)WearMapView.c().get(Math.round(f1))).intValue();
          int j = (int)(i / WearMapView.b(WearMapView.this).getController().getZoomUnitsInMeter());
          params = WearMapView.d(WearMapView.this);
          j /= 2;
          params.setPadding(j, 0, j, 0);
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
          WearMapView.e(WearMapView.this).setText(params);
          WearMapView.f(WearMapView.this).setText(params);
          WearMapView.a(WearMapView.this, f1);
        }
        WearMapView.this.requestLayout();
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
      paramView = WearMapView.b(WearMapView.this).getBaseMap().t();
      paramView.a -= 1.0F;
      WearMapView.b(WearMapView.this).getBaseMap().a(paramView, 300);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      paramView = WearMapView.b(WearMapView.this).getBaseMap().t();
      paramView.a += 1.0F;
      WearMapView.b(WearMapView.this).getBaseMap().a(paramView, 300);
    }
  }
  
  class e
    extends AnimatorListenerAdapter
  {
    e(View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramView.setVisibility(4);
      super.onAnimationEnd(paramAnimator);
    }
  }
  
  private class f
    extends Handler
  {
    private final WeakReference<Context> a;
    
    public f(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((Context)this.a.get() == null) {
        return;
      }
      super.handleMessage(paramMessage);
      if (paramMessage.what != 1) {
        return;
      }
      if (WearMapView.g(WearMapView.this) == null) {
        return;
      }
      WearMapView.b(WearMapView.this, true);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.WearMapView
 * JD-Core Version:    0.7.0.1
 */