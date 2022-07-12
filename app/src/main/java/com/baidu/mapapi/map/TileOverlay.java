package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.map.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public final class TileOverlay
{
  private static final String f = "TileOverlay";
  private static int g;
  BaiduMap a;
  private ExecutorService b;
  private HashMap<String, Tile> c;
  private HashSet<String> d;
  private TileProvider e;
  
  public TileOverlay(BaiduMap paramBaiduMap, TileProvider paramTileProvider)
  {
    this.a = paramBaiduMap;
    this.e = paramTileProvider;
    this.c = new HashMap();
    this.d = new HashSet();
    this.b = Executors.newFixedThreadPool(1);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.d.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(String paramString, Tile paramTile)
  {
    try
    {
      this.c.put(paramString, paramTile);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private Tile b(String paramString)
  {
    try
    {
      if (this.c.containsKey(paramString))
      {
        Tile localTile = (Tile)this.c.get(paramString);
        this.c.remove(paramString);
        return localTile;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean c(String paramString)
  {
    try
    {
      boolean bool = this.d.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  Tile a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = b((String)localObject1);
    if (localObject2 != null) {
      return localObject2;
    }
    localObject2 = this.a;
    if ((localObject2 != null) && (g == 0))
    {
      localObject2 = ((BaiduMap)localObject2).getMapStatus().c.j;
      g = ((((WinRound)localObject2).right - ((WinRound)localObject2).left) / 256 + 2) * ((((WinRound)localObject2).bottom - ((WinRound)localObject2).top) / 256 + 2);
    }
    if (this.c.size() > g) {
      b();
    }
    if ((!c((String)localObject1)) && (!this.b.isShutdown())) {}
    try
    {
      a((String)localObject1);
      this.b.execute(new a(paramInt1, paramInt2, paramInt3, (String)localObject1));
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      break label218;
    }
    catch (Exception localException)
    {
      label206:
      break label206;
    }
    localObject1 = f;
    localObject2 = "fileDir is not legal";
    break label227;
    label218:
    localObject1 = f;
    localObject2 = "ThreadPool excepiton";
    label227:
    Log.e((String)localObject1, (String)localObject2);
    return null;
  }
  
  void b()
  {
    try
    {
      Logger.logE(f, "clearTaskSet");
      this.d.clear();
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void c()
  {
    this.b.shutdownNow();
  }
  
  public boolean clearTileCache()
  {
    BaiduMap localBaiduMap = this.a;
    if (localBaiduMap == null) {
      return false;
    }
    return localBaiduMap.a();
  }
  
  public void removeTileOverlay()
  {
    BaiduMap localBaiduMap = this.a;
    if (localBaiduMap == null) {
      return;
    }
    localBaiduMap.a(this);
  }
  
  class a
    implements Runnable
  {
    a(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
    
    public void run()
    {
      Object localObject1 = ((FileTileProvider)TileOverlay.a(TileOverlay.this)).getTile(paramInt1, paramInt2, paramInt3);
      Object localObject2;
      if (localObject1 != null)
      {
        if ((((Tile)localObject1).width == 256) && (((Tile)localObject1).height == 256))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(paramInt2);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(paramInt3);
          localObject2 = ((StringBuilder)localObject2).toString();
          TileOverlay.a(TileOverlay.this, (String)localObject2, (Tile)localObject1);
          break label139;
        }
        localObject1 = TileOverlay.a();
        localObject2 = "FileTile pic must be 256 * 256";
      }
      else
      {
        localObject1 = TileOverlay.a();
        localObject2 = "FileTile pic is null";
      }
      Log.e((String)localObject1, (String)localObject2);
      label139:
      TileOverlay.b(TileOverlay.this).remove(this.d);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.TileOverlay
 * JD-Core Version:    0.7.0.1
 */