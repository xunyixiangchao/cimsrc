package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AppBaseMap
{
  private long a = 0L;
  private NABaseMap b = null;
  private final ReadWriteLock c = new ReentrantReadWriteLock(true);
  
  public static void renderClearShaderCache(String paramString)
  {
    NABaseMap.g(paramString);
  }
  
  public void AddItemData(Bundle paramBundle)
  {
    AddItemData(paramBundle, false);
  }
  
  public void AddItemData(Bundle paramBundle, boolean paramBoolean)
  {
    this.b.a(paramBundle, paramBoolean);
  }
  
  public long AddLayer(int paramInt1, int paramInt2, String paramString)
  {
    return this.b.a(paramInt1, paramInt2, paramString);
  }
  
  public void AddPopupData(Bundle paramBundle)
  {
    this.b.b(paramBundle);
  }
  
  public void AddRtPopData(Bundle paramBundle)
  {
    this.b.c(paramBundle);
  }
  
  public void AddStreetCustomMarker(Bundle paramBundle, Bitmap paramBitmap)
  {
    if (this.a != 0L) {
      this.b.a(paramBundle, paramBitmap);
    }
  }
  
  public void BeginLocationLayerAnimation()
  {
    this.b.a();
  }
  
  public boolean CleanCache(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void ClearLayer(long paramLong)
  {
    this.b.b(paramLong);
  }
  
  public void ClearLocationLayerData(Bundle paramBundle)
  {
    this.b.d(paramBundle);
  }
  
  public void ClearMistmapLayer()
  {
    this.b.c();
  }
  
  public void ClearSDKLayer(long paramLong)
  {
    this.b.c(paramLong);
  }
  
  public boolean CloseCache()
  {
    return this.b.e();
  }
  
  public boolean Create()
  {
    try
    {
      this.c.writeLock().lock();
      this.a = this.b.create();
      return true;
    }
    finally
    {
      this.c.writeLock().unlock();
    }
  }
  
  public boolean CreateByDuplicate(long paramLong)
  {
    paramLong = this.b.d(paramLong);
    this.a = paramLong;
    return paramLong != 0L;
  }
  
  public long CreateDuplicate()
  {
    return this.b.f();
  }
  
  public int Draw()
  {
    if (this.a != 0L) {
      return this.b.g();
    }
    return 0;
  }
  
  public String GeoPtToScrPoint(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
  
  public float GetAdapterZoomUnitsEx()
  {
    return this.b.k();
  }
  
  public int GetCacheSize(int paramInt)
  {
    return this.b.b(paramInt);
  }
  
  public String GetCityInfoByID(int paramInt)
  {
    return this.b.c(paramInt);
  }
  
  public Bundle GetDrawingMapStatus()
  {
    return this.b.n();
  }
  
  public float GetFZoomToBoundF(Bundle paramBundle1, Bundle paramBundle2)
  {
    return this.b.a(paramBundle1, paramBundle2);
  }
  
  public String GetFocusedBaseIndoorMapInfo()
  {
    if (this.a != 0L) {
      return this.b.o();
    }
    return null;
  }
  
  public long GetId()
  {
    return this.a;
  }
  
  public int GetMapRenderType()
  {
    return this.b.r();
  }
  
  public Bundle GetMapStatus()
  {
    return this.b.b(true);
  }
  
  public Bundle GetMapStatus(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public String GetNearlyObjID(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.b.a(paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public int GetVMPMapCityInfo(Bundle paramBundle)
  {
    return this.b.f(paramBundle);
  }
  
  public float GetZoomToBound(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    return this.b.a(paramBundle, paramInt1, paramInt2);
  }
  
  public float GetZoomToBoundF(Bundle paramBundle)
  {
    return this.b.g(paramBundle);
  }
  
  @Deprecated
  public boolean Init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.a != 0L) && (this.b.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean1, paramBoolean2));
  }
  
  public boolean IsBaseIndoorMapMode()
  {
    return (this.a != 0L) && (this.b.x());
  }
  
  public boolean IsPointInFocusBarBorder(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (this.a != 0L) && (this.b.a(paramDouble1, paramDouble2, paramDouble3));
  }
  
  public boolean IsPointInFocusIDRBorder(double paramDouble1, double paramDouble2)
  {
    return (this.a != 0L) && (this.b.a(paramDouble1, paramDouble2));
  }
  
  public boolean IsStreetArrowShown()
  {
    return this.b.A();
  }
  
  public boolean IsStreetCustomMarkerShown()
  {
    return this.b.B();
  }
  
  public boolean IsStreetPOIMarkerShown()
  {
    return (this.a != 0L) && (this.b.C());
  }
  
  public boolean IsStreetRoadClickable()
  {
    return this.b.D();
  }
  
  public boolean LayersIsShow(long paramLong)
  {
    return this.b.f(paramLong);
  }
  
  public void MoveToScrPoint(int paramInt1, int paramInt2)
  {
    this.b.c(paramInt1, paramInt2);
  }
  
  public void OnBackground()
  {
    try
    {
      this.c.readLock().lock();
      if (this.a != 0L) {
        this.b.E();
      }
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void OnForeground()
  {
    try
    {
      this.c.readLock().lock();
      if (this.a != 0L) {
        this.b.F();
      }
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public String OnHotcityGet()
  {
    return this.b.G();
  }
  
  public void OnPause()
  {
    try
    {
      this.c.readLock().lock();
      if (this.a != 0L) {
        this.b.H();
      }
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public boolean OnRecordAdd(int paramInt)
  {
    return this.b.e(paramInt);
  }
  
  public String OnRecordGetAll()
  {
    return this.b.I();
  }
  
  public String OnRecordGetAt(int paramInt)
  {
    return this.b.f(paramInt);
  }
  
  public boolean OnRecordImport(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.b.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean OnRecordReload(int paramInt, boolean paramBoolean)
  {
    return this.b.a(paramInt, paramBoolean);
  }
  
  public boolean OnRecordRemove(int paramInt, boolean paramBoolean)
  {
    return this.b.b(paramInt, paramBoolean);
  }
  
  public boolean OnRecordStart(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.b.a(paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean OnRecordSuspend(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.b.b(paramInt1, paramBoolean, paramInt2);
  }
  
  public void OnResume()
  {
    try
    {
      this.c.readLock().lock();
      if (this.a != 0L) {
        this.b.J();
      }
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public String OnSchcityGet(String paramString)
  {
    return this.b.d(paramString);
  }
  
  public boolean OnUsrcityMsgInterval(int paramInt)
  {
    return this.b.g(paramInt);
  }
  
  public int OnWifiRecordAdd(int paramInt)
  {
    return this.b.h(paramInt);
  }
  
  public boolean Release()
  {
    try
    {
      this.c.writeLock().lock();
      long l = this.a;
      if (l != 0L)
      {
        BaseMapCallback.release(l);
        this.b.dispose();
        this.a = 0L;
        return true;
      }
      return false;
    }
    finally
    {
      this.c.writeLock().unlock();
    }
  }
  
  public void Remo() {}
  
  public boolean RemoveItemData(Bundle paramBundle)
  {
    return this.b.h(paramBundle);
  }
  
  public void RemoveLayer(long paramLong)
  {
    this.b.h(paramLong);
  }
  
  public void RemoveStreetAllCustomMarker()
  {
    this.b.K();
  }
  
  public void RemoveStreetCustomMaker(String paramString)
  {
    this.b.f(paramString);
  }
  
  public void ResetImageRes()
  {
    if (this.a != 0L) {
      this.b.N();
    }
  }
  
  public boolean ResumeCache()
  {
    return this.b.O();
  }
  
  public boolean SaveCache()
  {
    try
    {
      boolean bool = this.b.P();
      return bool;
    }
    finally
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public void SaveScreenToLocal(String paramString1, String paramString2)
  {
    this.b.b(paramString1, paramString2);
  }
  
  public String ScrPtToGeoPoint(int paramInt1, int paramInt2)
  {
    return this.b.e(paramInt1, paramInt2);
  }
  
  public void SetAllStreetCustomMarkerVisibility(boolean paramBoolean)
  {
    if (this.a != 0L) {
      this.b.d(paramBoolean);
    }
  }
  
  public boolean SetCallback(a parama)
  {
    if (parama != null)
    {
      long l = this.a;
      if ((l != 0L) && (BaseMapCallback.setMapCallback(l, parama))) {
        return true;
      }
    }
    return false;
  }
  
  public void SetFocus(long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle)
  {
    this.b.a(paramLong1, paramLong2, paramBoolean, paramBundle);
  }
  
  public boolean SetItsPreTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.b.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean SetLayerSceneMode(long paramLong, int paramInt)
  {
    return this.b.b(paramLong, paramInt);
  }
  
  public void SetLayersClickable(long paramLong, boolean paramBoolean)
  {
    this.b.a(paramLong, paramBoolean);
  }
  
  public void SetLocationLayerData(Bundle paramBundle)
  {
    this.b.j(paramBundle);
  }
  
  public int SetMapControlMode(int paramInt)
  {
    return this.b.k(paramInt);
  }
  
  public void SetMapStatus(Bundle paramBundle)
  {
    this.b.k(paramBundle);
  }
  
  public void SetNewMapStatus(Bundle paramBundle)
  {
    this.b.n(paramBundle);
  }
  
  public boolean SetSDKLayerCallback(MapSDKLayerDataInterface paramMapSDKLayerDataInterface)
  {
    if (paramMapSDKLayerDataInterface != null)
    {
      long l = this.a;
      if ((l != 0L) && (BaseMapCallback.setMapSDKCallback(l, paramMapSDKLayerDataInterface))) {
        return true;
      }
    }
    return false;
  }
  
  public void SetStreetArrowShow(boolean paramBoolean)
  {
    this.b.i(paramBoolean);
  }
  
  public void SetStreetMarkerClickable(String paramString, boolean paramBoolean)
  {
    this.b.a(paramString, paramBoolean);
  }
  
  public void SetStreetRoadClickable(boolean paramBoolean)
  {
    this.b.j(paramBoolean);
  }
  
  public void SetStyleMode(int paramInt)
  {
    this.b.p(paramInt);
  }
  
  public void SetTargetStreetCustomMarkerVisibility(boolean paramBoolean, String paramString)
  {
    if (this.a != 0L) {
      this.b.a(paramBoolean, paramString);
    }
  }
  
  public void ShowBaseIndoorMap(boolean paramBoolean)
  {
    this.b.l(paramBoolean);
  }
  
  public void ShowHotMap(boolean paramBoolean, int paramInt)
  {
    this.b.a(paramBoolean, paramInt);
  }
  
  public void ShowHotMap(boolean paramBoolean, int paramInt, String paramString)
  {
    this.b.a(paramBoolean, paramInt, paramString);
  }
  
  public void ShowLayers(long paramLong, boolean paramBoolean)
  {
    if (this.a != 0L) {
      this.b.b(paramLong, paramBoolean);
    }
  }
  
  public void ShowMistMap(boolean paramBoolean, String paramString)
  {
    this.b.c(paramBoolean, paramString);
  }
  
  public void ShowSatelliteMap(boolean paramBoolean)
  {
    this.b.m(paramBoolean);
  }
  
  public void ShowStreetPOIMarker(boolean paramBoolean)
  {
    if (this.a != 0L) {
      this.b.n(paramBoolean);
    }
  }
  
  public void ShowStreetRoadMap(boolean paramBoolean)
  {
    this.b.o(paramBoolean);
  }
  
  public void ShowTrafficMap(boolean paramBoolean)
  {
    this.b.p(paramBoolean);
  }
  
  public void StartIndoorAnimation()
  {
    this.b.Q();
  }
  
  public boolean SwitchBaseIndoorMapFloor(String paramString1, String paramString2)
  {
    return this.b.c(paramString1, paramString2);
  }
  
  public boolean SwitchLayer(long paramLong1, long paramLong2)
  {
    return this.b.a(paramLong1, paramLong2);
  }
  
  public void UpdateLayers(long paramLong)
  {
    this.b.i(paramLong);
  }
  
  public boolean addBmLayerBelow(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return this.b.a(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public void addOneOverlayItem(Bundle paramBundle)
  {
    this.b.a(paramBundle);
  }
  
  public void addOverlayItems(Bundle[] paramArrayOfBundle, int paramInt)
  {
    this.b.a(paramArrayOfBundle, paramInt);
  }
  
  public boolean addSDKTileData(Bundle paramBundle)
  {
    return this.b.nativeAddTileOverlay(this.a, paramBundle);
  }
  
  public boolean cleanSDKTileDataCache(long paramLong)
  {
    return this.b.nativeCleanSDKTileDataCache(this.a, paramLong);
  }
  
  public void clearHeatMapLayerCache(long paramLong)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.a(paramLong);
  }
  
  public void clearUniversalLayer()
  {
    this.b.d();
  }
  
  public void closeParticleEffect(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void enablePOIAnimation(boolean paramBoolean)
  {
    try
    {
      this.c.readLock().lock();
      this.b.a(paramBoolean);
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void entryFeedTopic(int paramInt, String paramString1, String paramString2)
  {
    this.b.a(paramInt, paramString1, paramString2);
  }
  
  public void entrySearchTopic(int paramInt)
  {
    this.b.a(paramInt, "", "");
  }
  
  public void exitSearchTopic()
  {
    this.b.h();
  }
  
  public void focusTrafficUGCLabel()
  {
    this.b.i();
  }
  
  public boolean get3DModelEnable()
  {
    return this.b.j();
  }
  
  public boolean getDEMEnable()
  {
    return this.b.l();
  }
  
  public boolean getDrawHouseHeightEnable()
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return false;
    }
    return localNABaseMap.m();
  }
  
  public int getFontSizeLevel()
  {
    return this.b.p();
  }
  
  public long getLayerIDByTag(String paramString)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return 0L;
    }
    return localNABaseMap.b(paramString);
  }
  
  public boolean getMapBarData(Bundle paramBundle)
  {
    return this.b.e(paramBundle);
  }
  
  public int getMapLanguage()
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return 0;
    }
    return localNABaseMap.q();
  }
  
  public int getMapScene()
  {
    return this.b.s();
  }
  
  public Bundle getMapStatusLimits()
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return null;
    }
    return localNABaseMap.t();
  }
  
  public boolean getMapStatusLimitsLevel(int[] paramArrayOfInt)
  {
    return this.b.a(paramArrayOfInt);
  }
  
  public int getMapTheme()
  {
    return this.b.u();
  }
  
  public float[] getProjectionMatrix()
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return null;
    }
    float[] arrayOfFloat = new float[16];
    localNABaseMap.a(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public String getProjectionPt(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public int getScaleLevel(int paramInt1, int paramInt2)
  {
    return this.b.b(paramInt1, paramInt2);
  }
  
  public int getSkyboxStyle()
  {
    return this.b.v();
  }
  
  public float[] getViewMatrix()
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return null;
    }
    float[] arrayOfFloat = new float[16];
    localNABaseMap.b(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public boolean importMapTheme(int paramInt)
  {
    return this.b.d(paramInt);
  }
  
  public boolean initCustomStyle(String paramString1, String paramString2)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return false;
    }
    return localNABaseMap.a(paramString1, paramString2);
  }
  
  public boolean initWithOptions(Bundle paramBundle, boolean paramBoolean)
  {
    return (this.a != 0L) && (this.b.b(paramBundle, paramBoolean));
  }
  
  public boolean isAnimationRunning()
  {
    return this.b.w();
  }
  
  public boolean isEnableIndoor3D()
  {
    return this.b.y();
  }
  
  public boolean isNaviMode()
  {
    return this.b.z();
  }
  
  public boolean moveLayerBelowTo(long paramLong, int paramInt)
  {
    return this.b.a(paramLong, paramInt);
  }
  
  public boolean performAction(String paramString)
  {
    return this.b.e(paramString);
  }
  
  public void recycleMemory(int paramInt)
  {
    this.b.i(paramInt);
  }
  
  public boolean releaseFromOfflineMap()
  {
    try
    {
      this.c.writeLock().lock();
      if (this.a != 0L)
      {
        this.b.dispose();
        this.a = 0L;
        return true;
      }
      return false;
    }
    finally
    {
      this.c.writeLock().unlock();
    }
  }
  
  public void removeBmLayer(long paramLong)
  {
    this.b.g(paramLong);
  }
  
  public void removeOneOverlayItem(Bundle paramBundle)
  {
    this.b.i(paramBundle);
  }
  
  public void removeOverlayItems(Bundle[] paramArrayOfBundle)
  {
    this.b.a(paramArrayOfBundle);
  }
  
  public void renderDone()
  {
    try
    {
      this.c.readLock().lock();
      this.b.L();
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void renderInit(int paramInt1, int paramInt2, Surface paramSurface, int paramInt3)
  {
    try
    {
      this.c.readLock().lock();
      this.b.a(paramInt1, paramInt2, paramSurface, paramInt3);
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public int renderRender()
  {
    try
    {
      this.c.readLock().lock();
      int i = this.b.M();
      return i;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void renderResize(int paramInt1, int paramInt2)
  {
    try
    {
      this.c.readLock().lock();
      this.b.d(paramInt1, paramInt2);
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    if (this.a != 0L) {
      this.b.d(paramInt1, paramInt2);
    }
  }
  
  public void set3DModelEnable(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public void setCustomStyleEnable(boolean paramBoolean)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.e(paramBoolean);
  }
  
  public void setDEMEnable(boolean paramBoolean)
  {
    this.b.f(paramBoolean);
  }
  
  public void setDpiScale(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public void setDrawHouseHeightEnable(boolean paramBoolean)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.g(paramBoolean);
  }
  
  public void setEnableIndoor3D(boolean paramBoolean)
  {
    this.b.h(paramBoolean);
  }
  
  public void setFontSizeLevel(int paramInt)
  {
    this.b.j(paramInt);
  }
  
  public void setMapLanguage(int paramInt)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.l(paramInt);
  }
  
  public void setMapScene(int paramInt)
  {
    this.b.m(paramInt);
  }
  
  public void setMapStatusLimits(Bundle paramBundle)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.l(paramBundle);
  }
  
  public boolean setMapStatusLimitsLevel(int paramInt1, int paramInt2)
  {
    return this.b.f(paramInt1, paramInt2);
  }
  
  public boolean setMapTheme(int paramInt, Bundle paramBundle)
  {
    return this.b.a(paramInt, paramBundle);
  }
  
  public boolean setMapThemeScene(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.b.a(paramInt1, paramInt2, paramBundle);
  }
  
  public void setMaxAndMinZoomLevel(Bundle paramBundle)
  {
    NABaseMap localNABaseMap = this.b;
    if (localNABaseMap == null) {
      return;
    }
    localNABaseMap.m(paramBundle);
  }
  
  public void setRecommendPOIScene(int paramInt)
  {
    this.b.n(paramInt);
  }
  
  public void setSkyboxStyle(int paramInt)
  {
    this.b.o(paramInt);
  }
  
  public boolean setTestSwitch(boolean paramBoolean)
  {
    return this.b.k(paramBoolean);
  }
  
  public void setTrafficUGCData(String paramString)
  {
    this.b.h(paramString);
  }
  
  public void setUniversalFilter(String paramString)
  {
    this.b.i(paramString);
  }
  
  public void showFootMarkGrid(boolean paramBoolean, String paramString)
  {
    this.b.b(paramBoolean, paramString);
  }
  
  public boolean showParticleEffect(int paramInt)
  {
    return this.b.q(paramInt);
  }
  
  public boolean showParticleEffectByName(String paramString, boolean paramBoolean)
  {
    return this.b.b(paramString, paramBoolean);
  }
  
  public boolean showParticleEffectByType(int paramInt)
  {
    return this.b.r(paramInt);
  }
  
  public void showTrafficUGCMap(boolean paramBoolean)
  {
    this.b.q(paramBoolean);
  }
  
  public void showUniversalLayer(Bundle paramBundle)
  {
    this.b.o(paramBundle);
  }
  
  public void surfaceDestroyed(Surface paramSurface)
  {
    try
    {
      this.c.readLock().lock();
      this.b.a(paramSurface);
      return;
    }
    finally
    {
      this.c.readLock().unlock();
    }
  }
  
  public void unFocusTrafficUGCLabel()
  {
    this.b.S();
  }
  
  public void updateBaseLayers()
  {
    this.b.T();
  }
  
  public void updateDrawFPS()
  {
    this.b.U();
  }
  
  public void updateFootMarkGrid()
  {
    this.b.V();
  }
  
  public void updateOneOverlayItem(Bundle paramBundle)
  {
    this.b.p(paramBundle);
  }
  
  public boolean updateSDKTile(Bundle paramBundle)
  {
    return this.b.nativeUpdateSDKTile(this.a, paramBundle);
  }
  
  public String worldPointToScreenPoint(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return this.b.a(paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.AppBaseMap
 * JD-Core Version:    0.7.0.1
 */