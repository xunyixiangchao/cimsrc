package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.baidu.platform.comjni.NativeComponent;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NABaseMap
  extends NativeComponent
{
  private ThreadPoolExecutor a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private long b;
  private volatile boolean c = false;
  private final ReadWriteLock d = new ReentrantReadWriteLock(true);
  private final Set<Long> e = new CopyOnWriteArraySet();
  
  private void R()
  {
    try
    {
      ThreadPoolExecutor localThreadPoolExecutor = this.a;
      if (localThreadPoolExecutor != null)
      {
        if (localThreadPoolExecutor.getQueue() != null) {
          this.a.getQueue().clear();
        }
        this.a.shutdown();
        this.a.awaitTermination(100L, TimeUnit.MILLISECONDS);
        this.a.shutdownNow();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean b()
  {
    return (!this.a.isShutdown()) && (!this.a.isTerminated());
  }
  
  private boolean e(long paramLong)
  {
    return (this.e.contains(Long.valueOf(paramLong))) && (paramLong != 0L);
  }
  
  public static void g(String paramString)
  {
    nativeRenderClearShaderCache(paramString);
  }
  
  private native boolean nativeAddBmLayerBelow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
  
  private native void nativeAddItemData(long paramLong, Bundle paramBundle, boolean paramBoolean);
  
  private native long nativeAddLayer(long paramLong, int paramInt1, int paramInt2, String paramString);
  
  private native void nativeAddPopupData(long paramLong, Bundle paramBundle);
  
  private native void nativeAddRtPopData(long paramLong, Bundle paramBundle);
  
  private native void nativeAddStreetCustomMarker(long paramLong, Bundle paramBundle, Bitmap paramBitmap);
  
  private native void nativeAttachDC(long paramLong1, long paramLong2);
  
  private native boolean nativeBeginLocationLayerAnimation(long paramLong);
  
  private native boolean nativeCleanCache(long paramLong, int paramInt);
  
  private native void nativeClearHeatMapLayerCache(long paramLong1, long paramLong2);
  
  private native void nativeClearLayer(long paramLong1, long paramLong2);
  
  private native void nativeClearLocationLayerData(long paramLong, Bundle paramBundle);
  
  private native void nativeClearMistmapLayer(long paramLong);
  
  private native void nativeClearUniversalLayer(long paramLong);
  
  private native boolean nativeCloseCache(long paramLong);
  
  private native void nativeCloseParticleEffect(long paramLong, String paramString);
  
  private native long nativeCreate();
  
  private native long nativeCreateDuplicate(long paramLong);
  
  private native int nativeDraw(long paramLong);
  
  private native void nativeEnablePOIAnimation(long paramLong, boolean paramBoolean);
  
  private native void nativeEntrySearchTopic(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeExitSearchTopic(long paramLong);
  
  private native void nativeFocusTrafficUGCLabel(long paramLong);
  
  private native String nativeGeoPtToScrPoint(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativeGet3DModelEnable(long paramLong);
  
  private native float nativeGetAdapterZoomUnitsEx(long paramLong);
  
  private native int nativeGetCacheSize(long paramLong, int paramInt);
  
  private native String nativeGetCityInfoByID(long paramLong, int paramInt);
  
  private static native boolean nativeGetDEMEnable(long paramLong);
  
  private static native boolean nativeGetDrawHouseHeightEnable(long paramLong);
  
  private native Bundle nativeGetDrawingMapStatus(long paramLong);
  
  private native float nativeGetFZoomToBoundF(long paramLong, Bundle paramBundle1, Bundle paramBundle2);
  
  private native String nativeGetFocusedBaseIndoorMapInfo(long paramLong);
  
  private native int nativeGetFontSizeLevel(long paramLong);
  
  private static native long nativeGetLayerIDByTag(long paramLong, String paramString);
  
  private native int nativeGetLayerPos(long paramLong1, long paramLong2);
  
  private native boolean nativeGetMapBarData(long paramLong, Bundle paramBundle);
  
  private native int nativeGetMapLanguage(long paramLong);
  
  private native int nativeGetMapRenderType(long paramLong);
  
  private native int nativeGetMapScene(long paramLong);
  
  private native Bundle nativeGetMapStatus(long paramLong, boolean paramBoolean);
  
  private static native Bundle nativeGetMapStatusLimits(long paramLong);
  
  private native boolean nativeGetMapStatusLimitsLevel(long paramLong, int[] paramArrayOfInt);
  
  private native int nativeGetMapTheme(long paramLong);
  
  private native String nativeGetNearlyObjID(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeGetProjectionMatrix(long paramLong, float[] paramArrayOfFloat);
  
  private native String nativeGetProjectionPt(long paramLong, String paramString);
  
  private native int nativeGetScaleLevel(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetSkyboxStyle(long paramLong);
  
  private native int nativeGetVMPMapCityInfo(long paramLong, Bundle paramBundle);
  
  private static native void nativeGetViewMatrix(long paramLong, float[] paramArrayOfFloat);
  
  private native float nativeGetZoomToBound(long paramLong, Bundle paramBundle, int paramInt1, int paramInt2);
  
  private native float nativeGetZoomToBoundF(long paramLong, Bundle paramBundle);
  
  private native boolean nativeImportMapTheme(long paramLong, int paramInt);
  
  private native boolean nativeInit(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2);
  
  private native boolean nativeInitCustomStyle(long paramLong, String paramString1, String paramString2);
  
  private native int nativeInitLayerCallback(long paramLong);
  
  private native boolean nativeInitWithBundle(long paramLong, Bundle paramBundle, boolean paramBoolean);
  
  private native long nativeInsertLayerAt(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  private native boolean nativeIsAnimationRunning(long paramLong);
  
  private native boolean nativeIsBaseIndoorMapMode(long paramLong);
  
  private native boolean nativeIsEnableIndoor3D(long paramLong);
  
  private native boolean nativeIsNaviMode(long paramLong);
  
  private native boolean nativeIsPointInFocusBarBorder(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  private native boolean nativeIsPointInFocusIDRBorder(long paramLong, double paramDouble1, double paramDouble2);
  
  private native boolean nativeIsStreetArrowShown(long paramLong);
  
  private native boolean nativeIsStreetCustomMarkerShown(long paramLong);
  
  private native boolean nativeIsStreetPOIMarkerShown(long paramLong);
  
  private native boolean nativeIsStreetRoadClickable(long paramLong);
  
  private native boolean nativeLayersIsShow(long paramLong1, long paramLong2);
  
  private native boolean nativeMoveLayerBelowTo(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeMoveToScrPoint(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeNewSetMapStatus(long paramLong, Bundle paramBundle);
  
  private native void nativeOnBackground(long paramLong);
  
  private native void nativeOnForeground(long paramLong);
  
  private native String nativeOnHotcityGet(long paramLong);
  
  private native void nativeOnPause(long paramLong);
  
  private native boolean nativeOnRecordAdd(long paramLong, int paramInt);
  
  private native String nativeOnRecordGetAll(long paramLong);
  
  private native String nativeOnRecordGetAt(long paramLong, int paramInt);
  
  private native boolean nativeOnRecordImport(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private native boolean nativeOnRecordReload(long paramLong, int paramInt, boolean paramBoolean);
  
  private native boolean nativeOnRecordRemove(long paramLong, int paramInt, boolean paramBoolean);
  
  private native boolean nativeOnRecordStart(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  private native boolean nativeOnRecordSuspend(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  private native void nativeOnResume(long paramLong);
  
  private native String nativeOnSchcityGet(long paramLong, String paramString);
  
  private native boolean nativeOnUsrcityMsgInterval(long paramLong, int paramInt);
  
  private native int nativeOnWifiRecordAdd(long paramLong, int paramInt);
  
  private native boolean nativePerformAction(long paramLong, String paramString);
  
  private native int nativeQueryInterface(long paramLong);
  
  private native void nativeRecycleMemory(long paramLong, int paramInt);
  
  private native int nativeRelease(long paramLong);
  
  private native boolean nativeRemoveBmLayer(long paramLong1, long paramLong2);
  
  private native boolean nativeRemoveItemData(long paramLong, Bundle paramBundle);
  
  private native int nativeRemoveLayer(long paramLong1, long paramLong2);
  
  private native void nativeRemoveStreetAllCustomMarker(long paramLong);
  
  private native void nativeRemoveStreetCustomMaker(long paramLong, String paramString);
  
  private static native void nativeRenderClearShaderCache(String paramString);
  
  private static native void nativeRenderInit(long paramLong, int paramInt1, int paramInt2, Surface paramSurface, int paramInt3);
  
  private native void nativeRenderResize(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeResetImageRes(long paramLong);
  
  private native boolean nativeResumeCache(long paramLong);
  
  private native boolean nativeSaveCache(long paramLong);
  
  private native void nativeSaveScreenToLocal(long paramLong, String paramString1, String paramString2);
  
  private native String nativeScrPtToGeoPoint(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nativeSet3DModelEnable(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAllStreetCustomMarkerVisibility(long paramLong, boolean paramBoolean);
  
  private native void nativeSetCustomStyleEnable(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetDEMEnable(long paramLong, boolean paramBoolean);
  
  private native void nativeSetDpiScale(long paramLong, float paramFloat);
  
  private static native void nativeSetDrawHouseHeightEnable(long paramLong, boolean paramBoolean);
  
  private native void nativeSetEnableIndoor3D(long paramLong, boolean paramBoolean);
  
  private native String nativeSetFocus(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle);
  
  private native void nativeSetFontSizeLevel(long paramLong, int paramInt);
  
  private native boolean nativeSetItsPreTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native boolean nativeSetLayerSceneMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetLayersClickable(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void nativeSetLocationLayerData(long paramLong, Bundle paramBundle);
  
  private native int nativeSetMapControlMode(long paramLong, int paramInt);
  
  private native void nativeSetMapLanguage(long paramLong, int paramInt);
  
  private native boolean nativeSetMapScene(long paramLong, int paramInt);
  
  private native void nativeSetMapStatus(long paramLong, Bundle paramBundle);
  
  private static native void nativeSetMapStatusLimits(long paramLong, Bundle paramBundle);
  
  private native boolean nativeSetMapStatusLimitsLevel(long paramLong, int paramInt1, int paramInt2);
  
  private native boolean nativeSetMapTheme(long paramLong, int paramInt, Bundle paramBundle);
  
  private native boolean nativeSetMapThemeScene(long paramLong, int paramInt1, int paramInt2, Bundle paramBundle);
  
  private static native void nativeSetMaxAndMinZoomLevel(long paramLong, Bundle paramBundle);
  
  private native void nativeSetRecommendPOIScene(long paramLong, int paramInt);
  
  private static native void nativeSetSkyboxStyle(long paramLong, int paramInt);
  
  private native void nativeSetStreetArrowShow(long paramLong, boolean paramBoolean);
  
  private native void nativeSetStreetMarkerClickable(long paramLong, String paramString, boolean paramBoolean);
  
  private native void nativeSetStreetRoadClickable(long paramLong, boolean paramBoolean);
  
  private native void nativeSetStyleMode(long paramLong, int paramInt);
  
  private native void nativeSetTargetStreetCustomMarkerVisibility(long paramLong, boolean paramBoolean, String paramString);
  
  private native boolean nativeSetTestSwitch(long paramLong, boolean paramBoolean);
  
  private native void nativeSetTrafficUGCData(long paramLong, String paramString);
  
  private native void nativeSetUniversalFilter(long paramLong, String paramString);
  
  private native void nativeShowBaseIndoorMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowFootMarkGrid(long paramLong, boolean paramBoolean, String paramString);
  
  private native void nativeShowHotMap(long paramLong, boolean paramBoolean, int paramInt);
  
  private native void nativeShowHotMapWithUid(long paramLong, boolean paramBoolean, int paramInt, String paramString);
  
  private native void nativeShowLayers(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void nativeShowMistMap(long paramLong, boolean paramBoolean, String paramString);
  
  private native boolean nativeShowParticleEffect(long paramLong, int paramInt);
  
  private native boolean nativeShowParticleEffectByName(long paramLong, String paramString, boolean paramBoolean);
  
  private native boolean nativeShowParticleEffectByType(long paramLong, int paramInt);
  
  private native void nativeShowSatelliteMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowStreetPOIMarker(long paramLong, boolean paramBoolean);
  
  private native void nativeShowStreetRoadMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowTrafficMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowTrafficUGCMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowUniversalLayer(long paramLong, Bundle paramBundle);
  
  private native void nativeStartIndoorAnimation(long paramLong);
  
  private native void nativeSurfaceDestroyed(long paramLong, Surface paramSurface);
  
  private native boolean nativeSwitchBaseIndoorMapFloor(long paramLong, String paramString1, String paramString2);
  
  private native boolean nativeSwitchLayer(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeSyncClearLayer(long paramLong1, long paramLong2);
  
  private native void nativeUnFocusTrafficUGCLabel(long paramLong);
  
  private native void nativeUpdateBaseLayers(long paramLong);
  
  private native void nativeUpdateDrawFPS(long paramLong);
  
  private native void nativeUpdateFootMarkGrid(long paramLong);
  
  private native void nativeUpdateLayers(long paramLong1, long paramLong2);
  
  private native String nativeworldPointToScreenPoint(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public boolean A()
  {
    return nativeIsStreetArrowShown(this.b);
  }
  
  public boolean B()
  {
    return nativeIsStreetCustomMarkerShown(this.b);
  }
  
  public boolean C()
  {
    long l = this.b;
    return (l != 0L) && (nativeIsStreetPOIMarkerShown(l));
  }
  
  public boolean D()
  {
    return nativeIsStreetRoadClickable(this.b);
  }
  
  public void E()
  {
    long l = this.b;
    if (l != 0L) {
      nativeOnBackground(l);
    }
  }
  
  public void F()
  {
    long l = this.b;
    if (l != 0L) {
      nativeOnForeground(l);
    }
  }
  
  public String G()
  {
    return nativeOnHotcityGet(this.b);
  }
  
  public void H()
  {
    long l = this.b;
    if (l != 0L) {
      nativeOnPause(l);
    }
  }
  
  public String I()
  {
    return nativeOnRecordGetAll(this.b);
  }
  
  public void J()
  {
    long l = this.b;
    if (l != 0L) {
      nativeOnResume(l);
    }
  }
  
  public void K()
  {
    nativeRemoveStreetAllCustomMarker(this.b);
  }
  
  @Deprecated
  public void L() {}
  
  @Deprecated
  public int M()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeDraw(l);
    }
    return 0;
  }
  
  public void N()
  {
    long l = this.b;
    if (l != 0L) {
      nativeResetImageRes(l);
    }
  }
  
  public boolean O()
  {
    return nativeResumeCache(this.b);
  }
  
  public boolean P()
  {
    try
    {
      boolean bool = nativeSaveCache(this.b);
      return bool;
    }
    finally
    {
      label11:
      break label11;
    }
    return false;
  }
  
  public void Q()
  {
    nativeStartIndoorAnimation(this.b);
  }
  
  public void S()
  {
    nativeUnFocusTrafficUGCLabel(this.b);
  }
  
  public void T()
  {
    nativeUpdateBaseLayers(this.b);
  }
  
  public void U()
  {
    long l = this.b;
    if (l != 0L) {
      nativeUpdateDrawFPS(l);
    }
  }
  
  public void V()
  {
    nativeUpdateFootMarkGrid(this.b);
  }
  
  public float a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    return nativeGetZoomToBound(this.b, paramBundle, paramInt1, paramInt2);
  }
  
  public float a(Bundle paramBundle1, Bundle paramBundle2)
  {
    return nativeGetFZoomToBoundF(this.b, paramBundle1, paramBundle2);
  }
  
  public long a(int paramInt1, int paramInt2, String paramString)
  {
    long l = nativeAddLayer(this.b, paramInt1, paramInt2, paramString);
    this.e.remove(Long.valueOf(l));
    return l;
  }
  
  public String a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return nativeworldPointToScreenPoint(this.b, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return nativeGeoPtToScrPoint(this.b, paramInt1, paramInt2);
  }
  
  /* Error */
  public String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   10: invokeinterface 485 1 0
    //   15: ldc2_w 486
    //   18: getstatic 57	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   21: invokeinterface 492 4 0
    //   26: istore 7
    //   28: iload 7
    //   30: ifeq +92 -> 122
    //   33: iload 7
    //   35: istore 6
    //   37: iload 7
    //   39: istore 8
    //   41: aload_0
    //   42: lload_1
    //   43: invokespecial 130	com/baidu/platform/comjni/map/basemap/NABaseMap:e	(J)Z
    //   46: istore 9
    //   48: iload 9
    //   50: ifeq +26 -> 76
    //   53: iload 7
    //   55: ifeq +17 -> 72
    //   58: aload_0
    //   59: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   62: invokeinterface 485 1 0
    //   67: invokeinterface 495 1 0
    //   72: ldc_w 497
    //   75: areturn
    //   76: iload 7
    //   78: istore 6
    //   80: iload 7
    //   82: istore 8
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 164	com/baidu/platform/comjni/map/basemap/NABaseMap:b	J
    //   89: lload_1
    //   90: iload_3
    //   91: iload 4
    //   93: iload 5
    //   95: invokespecial 499	com/baidu/platform/comjni/map/basemap/NABaseMap:nativeGetNearlyObjID	(JJIII)Ljava/lang/String;
    //   98: astore 10
    //   100: iload 7
    //   102: ifeq +17 -> 119
    //   105: aload_0
    //   106: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   109: invokeinterface 485 1 0
    //   114: invokeinterface 495 1 0
    //   119: aload 10
    //   121: areturn
    //   122: iload 7
    //   124: ifeq +17 -> 141
    //   127: aload_0
    //   128: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   131: invokeinterface 485 1 0
    //   136: invokeinterface 495 1 0
    //   141: ldc_w 497
    //   144: areturn
    //   145: astore 10
    //   147: iload 6
    //   149: ifeq +17 -> 166
    //   152: aload_0
    //   153: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   156: invokeinterface 485 1 0
    //   161: invokeinterface 495 1 0
    //   166: aload 10
    //   168: athrow
    //   169: iload 8
    //   171: ifeq +17 -> 188
    //   174: aload_0
    //   175: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   178: invokeinterface 485 1 0
    //   183: invokeinterface 495 1 0
    //   188: ldc_w 497
    //   191: areturn
    //   192: astore 10
    //   194: goto -25 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	NABaseMap
    //   0	197	1	paramLong	long
    //   0	197	3	paramInt1	int
    //   0	197	4	paramInt2	int
    //   0	197	5	paramInt3	int
    //   4	144	6	i	int
    //   26	97	7	bool1	boolean
    //   1	169	8	j	int
    //   46	3	9	bool2	boolean
    //   98	22	10	str	String
    //   145	22	10	localObject	Object
    //   192	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	28	145	finally
    //   41	48	145	finally
    //   84	100	145	finally
    //   6	28	192	java/lang/Exception
    //   41	48	192	java/lang/Exception
    //   84	100	192	java/lang/Exception
  }
  
  public void a()
  {
    nativeBeginLocationLayerAnimation(this.b);
  }
  
  public void a(float paramFloat)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetDpiScale(l, paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Surface paramSurface, int paramInt3)
  {
    long l = this.b;
    if (l != 0L) {
      nativeRenderInit(l, paramInt1, paramInt2, paramSurface, paramInt3);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l = this.b;
    if (l != 0L) {
      nativeEntrySearchTopic(l, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    long l = this.b;
    if (l != 0L) {
      nativeClearHeatMapLayerCache(l, paramLong);
    }
  }
  
  public void a(final long paramLong1, long paramLong2, final boolean paramBoolean, Bundle paramBundle)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new n(paramLong1, paramLong2, paramBoolean, paramBundle));
  }
  
  public void a(final long paramLong, boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new h(paramLong, paramBoolean));
  }
  
  public void a(final Bundle paramBundle)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new b(paramBundle));
  }
  
  public void a(Bundle paramBundle, Bitmap paramBitmap)
  {
    long l = this.b;
    if (l != 0L) {
      nativeAddStreetCustomMarker(l, paramBundle, paramBitmap);
    }
  }
  
  public void a(final Bundle paramBundle, final boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new o(paramBundle, paramBoolean));
  }
  
  public void a(Surface paramSurface)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSurfaceDestroyed(l, paramSurface);
    }
  }
  
  public void a(String paramString)
  {
    nativeCloseParticleEffect(this.b, paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    nativeSetStreetMarkerClickable(this.b, paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeEnablePOIAnimation(l, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    nativeShowHotMap(this.b, paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    nativeShowHotMapWithUid(this.b, paramBoolean, paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetTargetStreetCustomMarkerVisibility(l, paramBoolean, paramString);
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    long l = this.b;
    if (l != 0L) {
      nativeGetProjectionMatrix(l, paramArrayOfFloat);
    }
  }
  
  public void a(final Bundle[] paramArrayOfBundle)
  {
    if (paramArrayOfBundle != null)
    {
      if (!b()) {
        return;
      }
      this.a.submit(new f(paramArrayOfBundle));
    }
  }
  
  public void a(final Bundle[] paramArrayOfBundle, final int paramInt)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new c(paramArrayOfBundle, paramInt));
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    long l = this.b;
    return (l != 0L) && (nativeIsPointInFocusIDRBorder(l, paramDouble1, paramDouble2));
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    long l = this.b;
    return (l != 0L) && (nativeIsPointInFocusBarBorder(l, paramDouble1, paramDouble2, paramDouble3));
  }
  
  public boolean a(int paramInt)
  {
    return nativeCleanCache(this.b, paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeSetItsPreTime(this.b, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return nativeSetMapThemeScene(this.b, paramInt1, paramInt2, paramBundle);
  }
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    return nativeSetMapTheme(this.b, paramInt, paramBundle);
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return nativeOnRecordReload(this.b, paramInt, paramBoolean);
  }
  
  public boolean a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return nativeOnRecordStart(this.b, paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeMoveLayerBelowTo(l, paramLong, paramInt);
    }
    return false;
  }
  
  public boolean a(final long paramLong1, long paramLong2)
  {
    if (!b()) {
      return false;
    }
    this.a.submit(new k(paramLong1, paramLong2));
    return true;
  }
  
  public boolean a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return nativeAddBmLayerBelow(this.b, paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeInitCustomStyle(l, paramString1, paramString2);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = this.b;
    return (l != 0L) && (nativeInit(l, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean1, paramBoolean2));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return nativeOnRecordImport(this.b, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetMapStatusLimitsLevel(l, paramArrayOfInt);
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    return nativeGetCacheSize(this.b, paramInt);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetScaleLevel(l, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public long b(String paramString)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetLayerIDByTag(l, paramString);
    }
    return 0L;
  }
  
  public Bundle b(boolean paramBoolean)
  {
    return nativeGetMapStatus(this.b, paramBoolean);
  }
  
  public void b(final long paramLong)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new m(paramLong));
  }
  
  public void b(final long paramLong, boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new g(paramLong, paramBoolean));
  }
  
  public void b(Bundle paramBundle)
  {
    nativeAddPopupData(this.b, paramBundle);
  }
  
  public void b(String paramString1, String paramString2)
  {
    nativeSaveScreenToLocal(this.b, paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    long l = this.b;
    if (l != 0L) {
      nativeShowFootMarkGrid(l, paramBoolean, paramString);
    }
  }
  
  public void b(float[] paramArrayOfFloat)
  {
    long l = this.b;
    if (l != 0L) {
      nativeGetViewMatrix(l, paramArrayOfFloat);
    }
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    return nativeOnRecordRemove(this.b, paramInt, paramBoolean);
  }
  
  public boolean b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return nativeOnRecordSuspend(this.b, paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean b(long paramLong, int paramInt)
  {
    return nativeSetLayerSceneMode(this.b, paramLong, paramInt);
  }
  
  public boolean b(Bundle paramBundle, boolean paramBoolean)
  {
    long l = this.b;
    return (l != 0L) && (nativeInitWithBundle(l, paramBundle, paramBoolean));
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    return nativeShowParticleEffectByName(this.b, paramString, paramBoolean);
  }
  
  public String c(int paramInt)
  {
    return nativeGetCityInfoByID(this.b, paramInt);
  }
  
  public String c(String paramString)
  {
    return nativeGetProjectionPt(this.b, paramString);
  }
  
  public void c()
  {
    nativeClearMistmapLayer(this.b);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    nativeMoveToScrPoint(this.b, paramInt1, paramInt2);
  }
  
  public void c(final long paramLong)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new l(paramLong));
  }
  
  public void c(Bundle paramBundle)
  {
    nativeAddRtPopData(this.b, paramBundle);
  }
  
  public void c(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSet3DModelEnable(l, paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    nativeShowMistMap(this.b, paramBoolean, paramString);
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return nativeSwitchBaseIndoorMapFloor(this.b, paramString1, paramString2);
  }
  
  public long create()
  {
    long l = nativeCreate();
    this.b = l;
    nativeInitLayerCallback(l);
    return this.b;
  }
  
  public long d(long paramLong)
  {
    paramLong = nativeCreateDuplicate(paramLong);
    this.b = paramLong;
    if (paramLong != 0L) {
      nativeInitLayerCallback(paramLong);
    }
    return this.b;
  }
  
  public String d(String paramString)
  {
    return nativeOnSchcityGet(this.b, paramString);
  }
  
  public void d()
  {
    nativeClearUniversalLayer(this.b);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    long l = this.b;
    if (l != 0L) {
      nativeRenderResize(l, paramInt1, paramInt2);
    }
  }
  
  public void d(Bundle paramBundle)
  {
    nativeClearLocationLayerData(this.b, paramBundle);
  }
  
  public void d(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetAllStreetCustomMarkerVisibility(l, paramBoolean);
    }
  }
  
  public boolean d(int paramInt)
  {
    return nativeImportMapTheme(this.b, paramInt);
  }
  
  public int dispose()
  {
    if (this.b != 0L)
    {
      this.c = true;
      R();
      int i = nativeRelease(this.b);
      this.b = 0L;
      return i;
    }
    return 0;
  }
  
  public String e(int paramInt1, int paramInt2)
  {
    return nativeScrPtToGeoPoint(this.b, paramInt1, paramInt2);
  }
  
  public void e(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetCustomStyleEnable(l, paramBoolean);
    }
  }
  
  public boolean e()
  {
    return nativeCloseCache(this.b);
  }
  
  public boolean e(int paramInt)
  {
    return nativeOnRecordAdd(this.b, paramInt);
  }
  
  public boolean e(Bundle paramBundle)
  {
    return nativeGetMapBarData(this.b, paramBundle);
  }
  
  public boolean e(String paramString)
  {
    return nativePerformAction(this.b, paramString);
  }
  
  public int f(Bundle paramBundle)
  {
    return nativeGetVMPMapCityInfo(this.b, paramBundle);
  }
  
  public long f()
  {
    return nativeCreateDuplicate(this.b);
  }
  
  public String f(int paramInt)
  {
    return nativeOnRecordGetAt(this.b, paramInt);
  }
  
  public void f(String paramString)
  {
    nativeRemoveStreetCustomMaker(this.b, paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetDEMEnable(l, paramBoolean);
    }
  }
  
  public boolean f(int paramInt1, int paramInt2)
  {
    long l = this.b;
    if (l != 0L) {
      return nativeSetMapStatusLimitsLevel(l, paramInt1, paramInt2);
    }
    return false;
  }
  
  /* Error */
  public boolean f(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   7: invokeinterface 485 1 0
    //   12: ldc2_w 486
    //   15: getstatic 57	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   18: invokeinterface 492 4 0
    //   23: istore_3
    //   24: iload_3
    //   25: ifeq +72 -> 97
    //   28: aload_0
    //   29: lload_1
    //   30: invokespecial 130	com/baidu/platform/comjni/map/basemap/NABaseMap:e	(J)Z
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +23 -> 60
    //   40: iload_3
    //   41: ifeq +17 -> 58
    //   44: aload_0
    //   45: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   48: invokeinterface 485 1 0
    //   53: invokeinterface 495 1 0
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 164	com/baidu/platform/comjni/map/basemap/NABaseMap:b	J
    //   65: lload_1
    //   66: invokespecial 717	com/baidu/platform/comjni/map/basemap/NABaseMap:nativeLayersIsShow	(JJ)Z
    //   69: istore 4
    //   71: iload_3
    //   72: ifeq +17 -> 89
    //   75: aload_0
    //   76: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   79: invokeinterface 485 1 0
    //   84: invokeinterface 495 1 0
    //   89: iload 4
    //   91: ireturn
    //   92: astore 5
    //   94: goto +28 -> 122
    //   97: iload_3
    //   98: ifeq +17 -> 115
    //   101: aload_0
    //   102: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   105: invokeinterface 485 1 0
    //   110: invokeinterface 495 1 0
    //   115: iconst_0
    //   116: ireturn
    //   117: astore 5
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: ifeq +17 -> 140
    //   126: aload_0
    //   127: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   130: invokeinterface 485 1 0
    //   135: invokeinterface 495 1 0
    //   140: aload 5
    //   142: athrow
    //   143: iconst_0
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +17 -> 163
    //   149: aload_0
    //   150: getfield 74	com/baidu/platform/comjni/map/basemap/NABaseMap:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   153: invokeinterface 485 1 0
    //   158: invokeinterface 495 1 0
    //   163: iconst_0
    //   164: ireturn
    //   165: astore 5
    //   167: goto -24 -> 143
    //   170: astore 5
    //   172: goto -27 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	NABaseMap
    //   0	175	1	paramLong	long
    //   23	123	3	bool1	boolean
    //   1	119	4	bool2	boolean
    //   92	1	5	localObject1	Object
    //   117	24	5	localObject2	Object
    //   165	1	5	localException1	Exception
    //   170	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	35	92	finally
    //   60	71	92	finally
    //   3	24	117	finally
    //   3	24	165	java/lang/Exception
    //   28	35	170	java/lang/Exception
    //   60	71	170	java/lang/Exception
  }
  
  public float g(Bundle paramBundle)
  {
    return nativeGetZoomToBoundF(this.b, paramBundle);
  }
  
  public int g()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeDraw(l);
    }
    return 0;
  }
  
  public void g(long paramLong)
  {
    nativeRemoveBmLayer(this.b, paramLong);
  }
  
  public void g(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetDrawHouseHeightEnable(l, paramBoolean);
    }
  }
  
  public boolean g(int paramInt)
  {
    return nativeOnUsrcityMsgInterval(this.b, paramInt);
  }
  
  public int h(int paramInt)
  {
    return nativeOnWifiRecordAdd(this.b, paramInt);
  }
  
  public void h()
  {
    long l = this.b;
    if (l != 0L) {
      nativeExitSearchTopic(l);
    }
  }
  
  public void h(final long paramLong)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new j(paramLong));
  }
  
  public void h(String paramString)
  {
    nativeSetTrafficUGCData(this.b, paramString);
  }
  
  public void h(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetEnableIndoor3D(l, paramBoolean);
    }
  }
  
  public boolean h(final Bundle paramBundle)
  {
    if (!b()) {
      return false;
    }
    this.a.submit(new a(paramBundle));
    return true;
  }
  
  public void i()
  {
    nativeFocusTrafficUGCLabel(this.b);
  }
  
  public void i(int paramInt)
  {
    long l = this.b;
    if (l != 0L) {
      nativeRecycleMemory(l, paramInt);
    }
  }
  
  public void i(final long paramLong)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new i(paramLong));
  }
  
  public void i(final Bundle paramBundle)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new e(paramBundle));
  }
  
  public void i(String paramString)
  {
    nativeSetUniversalFilter(this.b, paramString);
  }
  
  public void i(boolean paramBoolean)
  {
    nativeSetStreetArrowShow(this.b, paramBoolean);
  }
  
  public void j(int paramInt)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetFontSizeLevel(l, paramInt);
    }
  }
  
  public void j(Bundle paramBundle)
  {
    nativeSetLocationLayerData(this.b, paramBundle);
  }
  
  public void j(boolean paramBoolean)
  {
    nativeSetStreetRoadClickable(this.b, paramBoolean);
  }
  
  public boolean j()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGet3DModelEnable(l);
    }
    return false;
  }
  
  public float k()
  {
    return nativeGetAdapterZoomUnitsEx(this.b);
  }
  
  public int k(int paramInt)
  {
    return nativeSetMapControlMode(this.b, paramInt);
  }
  
  public void k(Bundle paramBundle)
  {
    nativeSetMapStatus(this.b, paramBundle);
  }
  
  public boolean k(boolean paramBoolean)
  {
    return nativeSetTestSwitch(this.b, paramBoolean);
  }
  
  public void l(int paramInt)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetMapLanguage(l, paramInt);
    }
  }
  
  public void l(Bundle paramBundle)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetMapStatusLimits(l, paramBundle);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    nativeShowBaseIndoorMap(this.b, paramBoolean);
  }
  
  public boolean l()
  {
    long l = this.b;
    if (l != 0L) {
      nativeGetDEMEnable(l);
    }
    return false;
  }
  
  public void m(int paramInt)
  {
    nativeSetMapScene(this.b, paramInt);
  }
  
  public void m(Bundle paramBundle)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetMaxAndMinZoomLevel(l, paramBundle);
    }
  }
  
  public void m(boolean paramBoolean)
  {
    nativeShowSatelliteMap(this.b, paramBoolean);
  }
  
  public boolean m()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetDrawHouseHeightEnable(l);
    }
    return false;
  }
  
  public Bundle n()
  {
    return nativeGetDrawingMapStatus(this.b);
  }
  
  public void n(int paramInt)
  {
    nativeSetRecommendPOIScene(this.b, paramInt);
  }
  
  public void n(Bundle paramBundle)
  {
    nativeNewSetMapStatus(this.b, paramBundle);
  }
  
  public void n(boolean paramBoolean)
  {
    long l = this.b;
    if (l != 0L) {
      nativeShowStreetPOIMarker(l, paramBoolean);
    }
  }
  
  public native void nativeAddOneOverlayItem(long paramLong, Bundle paramBundle);
  
  public native void nativeAddOverlayItems(long paramLong, Bundle[] paramArrayOfBundle, int paramInt);
  
  public native boolean nativeAddTileOverlay(long paramLong, Bundle paramBundle);
  
  public native boolean nativeCleanSDKTileDataCache(long paramLong1, long paramLong2);
  
  public native void nativeRemoveOneOverlayItem(long paramLong, Bundle paramBundle);
  
  public native void nativeUpdateOneOverlayItem(long paramLong, Bundle paramBundle);
  
  public native boolean nativeUpdateSDKTile(long paramLong, Bundle paramBundle);
  
  public String o()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetFocusedBaseIndoorMapInfo(l);
    }
    return null;
  }
  
  public void o(int paramInt)
  {
    long l = this.b;
    if (l != 0L) {
      nativeSetSkyboxStyle(l, paramInt);
    }
  }
  
  public void o(Bundle paramBundle)
  {
    nativeShowUniversalLayer(this.b, paramBundle);
  }
  
  public void o(boolean paramBoolean)
  {
    nativeShowStreetRoadMap(this.b, paramBoolean);
  }
  
  public int p()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetFontSizeLevel(l);
    }
    return 1;
  }
  
  public void p(int paramInt)
  {
    nativeSetStyleMode(this.b, paramInt);
  }
  
  public void p(final Bundle paramBundle)
  {
    if (!b()) {
      return;
    }
    this.a.submit(new d(paramBundle));
  }
  
  public void p(boolean paramBoolean)
  {
    nativeShowTrafficMap(this.b, paramBoolean);
  }
  
  public int q()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetMapLanguage(l);
    }
    return 0;
  }
  
  public void q(boolean paramBoolean)
  {
    nativeShowTrafficUGCMap(this.b, paramBoolean);
  }
  
  public boolean q(int paramInt)
  {
    return nativeShowParticleEffect(this.b, paramInt);
  }
  
  public int r()
  {
    return nativeGetMapRenderType(this.b);
  }
  
  public boolean r(int paramInt)
  {
    return nativeShowParticleEffectByType(this.b, paramInt);
  }
  
  public int s()
  {
    return nativeGetMapScene(this.b);
  }
  
  public Bundle t()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetMapStatusLimits(l);
    }
    return null;
  }
  
  public int u()
  {
    return nativeGetMapTheme(this.b);
  }
  
  public int v()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeGetSkyboxStyle(l);
    }
    return 0;
  }
  
  public boolean w()
  {
    return nativeIsAnimationRunning(this.b);
  }
  
  public boolean x()
  {
    long l = this.b;
    return (l != 0L) && (nativeIsBaseIndoorMapMode(l));
  }
  
  public boolean y()
  {
    long l = this.b;
    if (l != 0L) {
      return nativeIsEnableIndoor3D(l);
    }
    return true;
  }
  
  public boolean z()
  {
    return nativeIsNaviMode(this.b);
  }
  
  class a
    implements Runnable
  {
    a(Bundle paramBundle) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool1 = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool1)
          {
            i = bool1;
            j = bool1;
            Object localObject1 = paramBundle;
            if (localObject1 != null)
            {
              i = bool1;
              j = bool1;
              long l = ((Bundle)localObject1).getLong("itemaddr", 0L);
              i = bool1;
              j = bool1;
              boolean bool2 = NABaseMap.a(NABaseMap.this, l);
              if (bool2) {
                return;
              }
            }
            i = bool1;
            j = bool1;
            localObject1 = NABaseMap.this;
            i = bool1;
            j = bool1;
            NABaseMap.a((NABaseMap)localObject1, NABaseMap.d((NABaseMap)localObject1), paramBundle);
          }
          if (!bool1) {
            break label186;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label165:
        label186:
        break label165;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(Bundle paramBundle) {}
    
    public void run()
    {
      if (!NABaseMap.b(NABaseMap.this)) {
        return;
      }
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            NABaseMap localNABaseMap = NABaseMap.this;
            i = bool;
            j = bool;
            localNABaseMap.nativeAddOneOverlayItem(NABaseMap.d(localNABaseMap), paramBundle);
          }
          if (!bool) {
            break label125;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label104:
        break label104;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
      label125:
    }
  }
  
  class c
    implements Runnable
  {
    c(Bundle[] paramArrayOfBundle, int paramInt) {}
    
    public void run()
    {
      if (!NABaseMap.b(NABaseMap.this)) {
        return;
      }
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            NABaseMap localNABaseMap = NABaseMap.this;
            i = bool;
            j = bool;
            localNABaseMap.nativeAddOverlayItems(NABaseMap.d(localNABaseMap), paramArrayOfBundle, paramInt);
          }
          if (!bool) {
            break label129;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label108:
        break label108;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
      label129:
    }
  }
  
  class d
    implements Runnable
  {
    d(Bundle paramBundle) {}
    
    public void run()
    {
      if (!NABaseMap.b(NABaseMap.this)) {
        return;
      }
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            NABaseMap localNABaseMap = NABaseMap.this;
            i = bool;
            j = bool;
            localNABaseMap.nativeUpdateOneOverlayItem(NABaseMap.d(localNABaseMap), paramBundle);
          }
          if (!bool) {
            break label125;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label104:
        break label104;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
      label125:
    }
  }
  
  class e
    implements Runnable
  {
    e(Bundle paramBundle) {}
    
    public void run()
    {
      if (!NABaseMap.b(NABaseMap.this)) {
        return;
      }
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            NABaseMap localNABaseMap = NABaseMap.this;
            i = bool;
            j = bool;
            localNABaseMap.nativeRemoveOneOverlayItem(NABaseMap.d(localNABaseMap), paramBundle);
          }
          if (!bool) {
            break label125;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label104:
        break label104;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
      label125:
    }
  }
  
  class f
    implements Runnable
  {
    f(Bundle[] paramArrayOfBundle) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   4: invokestatic 30	com/baidu/platform/comjni/map/basemap/NABaseMap:b	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)Z
      //   7: ifne +4 -> 11
      //   10: return
      //   11: iconst_0
      //   12: istore 4
      //   14: iconst_0
      //   15: istore_1
      //   16: aload_0
      //   17: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   20: invokestatic 33	com/baidu/platform/comjni/map/basemap/NABaseMap:a	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)Ljava/util/concurrent/locks/ReadWriteLock;
      //   23: invokeinterface 39 1 0
      //   28: ldc2_w 40
      //   31: getstatic 47	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   34: invokeinterface 53 4 0
      //   39: istore_3
      //   40: iload_3
      //   41: ifeq +70 -> 111
      //   44: aload_0
      //   45: getfield 20	com/baidu/platform/comjni/map/basemap/NABaseMap$f:a	[Landroid/os/Bundle;
      //   48: astore 5
      //   50: aload 5
      //   52: arraylength
      //   53: istore_2
      //   54: iload_1
      //   55: iload_2
      //   56: if_icmpge +55 -> 111
      //   59: aload 5
      //   61: iload_1
      //   62: aaload
      //   63: astore 6
      //   65: aload_0
      //   66: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   69: invokestatic 56	com/baidu/platform/comjni/map/basemap/NABaseMap:c	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)Z
      //   72: ifeq +6 -> 78
      //   75: goto +36 -> 111
      //   78: aload_0
      //   79: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   82: astore 7
      //   84: aload 7
      //   86: aload 7
      //   88: invokestatic 60	com/baidu/platform/comjni/map/basemap/NABaseMap:d	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)J
      //   91: aload 6
      //   93: invokevirtual 64	com/baidu/platform/comjni/map/basemap/NABaseMap:nativeRemoveOneOverlayItem	(JLandroid/os/Bundle;)V
      //   96: iload_1
      //   97: iconst_1
      //   98: iadd
      //   99: istore_1
      //   100: goto -46 -> 54
      //   103: astore 5
      //   105: goto +17 -> 122
      //   108: goto +38 -> 146
      //   111: iload_3
      //   112: ifeq +55 -> 167
      //   115: goto +35 -> 150
      //   118: astore 5
      //   120: iconst_0
      //   121: istore_3
      //   122: iload_3
      //   123: ifeq +20 -> 143
      //   126: aload_0
      //   127: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   130: invokestatic 33	com/baidu/platform/comjni/map/basemap/NABaseMap:a	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)Ljava/util/concurrent/locks/ReadWriteLock;
      //   133: invokeinterface 39 1 0
      //   138: invokeinterface 67 1 0
      //   143: aload 5
      //   145: athrow
      //   146: iload_3
      //   147: ifeq +20 -> 167
      //   150: aload_0
      //   151: getfield 18	com/baidu/platform/comjni/map/basemap/NABaseMap$f:b	Lcom/baidu/platform/comjni/map/basemap/NABaseMap;
      //   154: invokestatic 33	com/baidu/platform/comjni/map/basemap/NABaseMap:a	(Lcom/baidu/platform/comjni/map/basemap/NABaseMap;)Ljava/util/concurrent/locks/ReadWriteLock;
      //   157: invokeinterface 39 1 0
      //   162: invokeinterface 67 1 0
      //   167: return
      //   168: astore 5
      //   170: iload 4
      //   172: istore_3
      //   173: goto -27 -> 146
      //   176: astore 5
      //   178: goto -70 -> 108
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	this	f
      //   15	85	1	i	int
      //   53	4	2	j	int
      //   39	134	3	bool1	boolean
      //   12	159	4	bool2	boolean
      //   48	12	5	arrayOfBundle	Bundle[]
      //   103	1	5	localObject1	Object
      //   118	26	5	localObject2	Object
      //   168	1	5	localException1	Exception
      //   176	1	5	localException2	Exception
      //   63	29	6	localBundle	Bundle
      //   82	5	7	localNABaseMap	NABaseMap
      // Exception table:
      //   from	to	target	type
      //   44	54	103	finally
      //   65	75	103	finally
      //   78	96	103	finally
      //   16	40	118	finally
      //   16	40	168	java/lang/Exception
      //   44	54	176	java/lang/Exception
      //   65	75	176	java/lang/Exception
      //   78	96	176	java/lang/Exception
    }
  }
  
  class g
    implements Runnable
  {
    g(long paramLong, boolean paramBoolean) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label136:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.a(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong, this.b);
            }
          }
          if (!bool) {
            break label136;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label115:
        break label115;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class h
    implements Runnable
  {
    h(long paramLong, boolean paramBoolean) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label136:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.b(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong, this.b);
            }
          }
          if (!bool) {
            break label136;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label115:
        break label115;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class i
    implements Runnable
  {
    i(long paramLong) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label132:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.b(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong);
            }
          }
          if (!bool) {
            break label132;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label111:
        break label111;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class j
    implements Runnable
  {
    j(long paramLong) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label139:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).writeLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            NABaseMap.e(NABaseMap.this).add(Long.valueOf(paramLong));
            i = bool;
            j = bool;
            NABaseMap localNABaseMap = NABaseMap.this;
            i = bool;
            j = bool;
            NABaseMap.c(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong);
          }
          if (!bool) {
            break label139;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).writeLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label118:
        break label118;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).writeLock().unlock();
      }
    }
  }
  
  class k
    implements Runnable
  {
    k(long paramLong1, long paramLong2) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong1))
            {
              i = bool;
              j = bool;
              if (!NABaseMap.a(NABaseMap.this, this.b))
              {
                i = bool;
                j = bool;
                NABaseMap localNABaseMap = NABaseMap.this;
                i = bool;
                j = bool;
                NABaseMap.a(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong1, this.b);
              }
            }
          }
          if (!bool) {
            break label155;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label134:
        label155:
        break label134;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class l
    implements Runnable
  {
    l(long paramLong) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label132:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.d(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong);
            }
          }
          if (!bool) {
            break label132;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label111:
        break label111;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class m
    implements Runnable
  {
    m(long paramLong) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label132:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.a(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong);
            }
          }
          if (!bool) {
            break label132;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label111:
        break label111;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class n
    implements Runnable
  {
    n(long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      label145:
      try
      {
        try
        {
          boolean bool = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool)
          {
            i = bool;
            j = bool;
            if (!NABaseMap.a(NABaseMap.this, paramLong1))
            {
              i = bool;
              j = bool;
              NABaseMap localNABaseMap = NABaseMap.this;
              i = bool;
              j = bool;
              NABaseMap.a(localNABaseMap, NABaseMap.d(localNABaseMap), paramLong1, paramBoolean, this.c, this.d);
            }
          }
          if (!bool) {
            break label145;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label124:
        break label124;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
  
  class o
    implements Runnable
  {
    o(Bundle paramBundle, boolean paramBoolean) {}
    
    public void run()
    {
      int j = 0;
      int i = 0;
      try
      {
        try
        {
          boolean bool1 = NABaseMap.a(NABaseMap.this).readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
          if (bool1)
          {
            i = bool1;
            j = bool1;
            Object localObject1 = paramBundle;
            if (localObject1 != null)
            {
              i = bool1;
              j = bool1;
              long l = ((Bundle)localObject1).getLong("itemaddr", 0L);
              i = bool1;
              j = bool1;
              boolean bool2 = NABaseMap.a(NABaseMap.this, l);
              if (bool2) {
                return;
              }
            }
            i = bool1;
            j = bool1;
            localObject1 = NABaseMap.this;
            i = bool1;
            j = bool1;
            NABaseMap.a((NABaseMap)localObject1, NABaseMap.d((NABaseMap)localObject1), paramBundle, paramBoolean);
          }
          if (!bool1) {
            break label189;
          }
        }
        finally
        {
          if (i != 0) {
            NABaseMap.a(NABaseMap.this).readLock().unlock();
          }
        }
      }
      catch (Exception localException)
      {
        label168:
        label189:
        break label168;
      }
      if (j != 0) {
        NABaseMap.a(NABaseMap.this).readLock().unlock();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.NABaseMap
 * JD-Core Version:    0.7.0.1
 */