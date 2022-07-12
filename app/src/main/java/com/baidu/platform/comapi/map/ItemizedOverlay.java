package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.c;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
  implements Comparator<Integer>
{
  protected ArrayList<OverlayItem> a;
  protected Drawable b;
  protected MapSurfaceView c;
  protected MapTextureView d;
  protected boolean e;
  protected Drawable f;
  protected OverlayItem g;
  protected int h = 0;
  protected int i;
  
  public ItemizedOverlay(Drawable paramDrawable, MapSurfaceView paramMapSurfaceView)
  {
    this.mType = 27;
    this.b = paramDrawable;
    this.a = new ArrayList();
    new ArrayList();
    this.c = paramMapSurfaceView;
    this.mLayerID = 0L;
  }
  
  public ItemizedOverlay(Drawable paramDrawable, MapTextureView paramMapTextureView)
  {
    this.mType = 27;
    this.b = paramDrawable;
    this.a = new ArrayList();
    new ArrayList();
    this.d = paramMapTextureView;
    this.mLayerID = 0L;
  }
  
  private int a()
  {
    int j = this.i;
    if (j < 2147483647)
    {
      j += 1;
      this.i = j;
      return j;
    }
    return 0;
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/baidu/platform/comapi/map/ItemizedOverlay:a	Ljava/util/ArrayList;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 41	com/baidu/platform/comapi/map/ItemizedOverlay:a	Ljava/util/ArrayList;
    //   15: invokevirtual 59	java/util/ArrayList:size	()I
    //   18: ifne +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: monitorenter
    //   27: new 38	java/util/ArrayList
    //   30: dup
    //   31: aload_0
    //   32: getfield 41	com/baidu/platform/comapi/map/ItemizedOverlay:a	Ljava/util/ArrayList;
    //   35: invokespecial 62	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   38: astore 8
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: monitorexit
    //   44: ldc 63
    //   46: istore 5
    //   48: ldc 55
    //   50: istore 4
    //   52: aload 8
    //   54: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   57: astore 8
    //   59: aload 8
    //   61: invokeinterface 73 1 0
    //   66: ifne +9 -> 75
    //   69: iload 5
    //   71: iload 4
    //   73: isub
    //   74: ireturn
    //   75: aload 8
    //   77: invokeinterface 77 1 0
    //   82: checkcast 79	com/baidu/platform/comapi/map/OverlayItem
    //   85: invokevirtual 83	com/baidu/platform/comapi/map/OverlayItem:getPoint	()Lcom/baidu/platform/comapi/basestruct/GeoPoint;
    //   88: astore 9
    //   90: iload_1
    //   91: ifeq +12 -> 103
    //   94: aload 9
    //   96: invokevirtual 89	com/baidu/platform/comapi/basestruct/GeoPoint:getLatitude	()D
    //   99: dstore_2
    //   100: goto +9 -> 109
    //   103: aload 9
    //   105: invokevirtual 92	com/baidu/platform/comapi/basestruct/GeoPoint:getLongitude	()D
    //   108: dstore_2
    //   109: dload_2
    //   110: d2i
    //   111: istore 6
    //   113: iload 5
    //   115: istore 7
    //   117: iload 6
    //   119: iload 5
    //   121: if_icmple +7 -> 128
    //   124: iload 6
    //   126: istore 7
    //   128: iload 7
    //   130: istore 5
    //   132: iload 6
    //   134: iload 4
    //   136: if_icmpge -77 -> 59
    //   139: iload 6
    //   141: istore 4
    //   143: iload 7
    //   145: istore 5
    //   147: goto -88 -> 59
    //   150: astore 8
    //   152: aload_0
    //   153: monitorexit
    //   154: aload 8
    //   156: athrow
    //   157: astore 8
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 8
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ItemizedOverlay
    //   0	164	1	paramBoolean	boolean
    //   99	11	2	d1	double
    //   50	92	4	j	int
    //   46	100	5	k	int
    //   111	29	6	m	int
    //   115	29	7	n	int
    //   38	38	8	localObject1	Object
    //   150	5	8	localObject2	Object
    //   157	5	8	localObject3	Object
    //   88	16	9	localGeoPoint	GeoPoint
    // Exception table:
    //   from	to	target	type
    //   27	42	150	finally
    //   152	154	150	finally
    //   11	23	157	finally
    //   25	27	157	finally
    //   42	44	157	finally
    //   154	157	157	finally
    //   159	161	157	finally
  }
  
  private void a(List<OverlayItem> paramList, boolean paramBoolean)
  {
    a(paramList, paramBoolean, false);
  }
  
  private void a(List<OverlayItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean2) {
      try
      {
        localObject1 = this.a;
        if (localObject1 != null) {
          ((ArrayList)localObject1).clear();
        }
      }
      finally {}
    }
    if (this.mLayerID == 0L)
    {
      if (!paramBoolean1) {
        try
        {
          localObject1 = this.a;
          if ((localObject1 != null) && (paramList != null)) {
            ((ArrayList)localObject1).addAll(paramList);
          }
          return;
        }
        finally {}
      }
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.clear();
    ArrayList localArrayList = new ArrayList();
    localBundle1.putLong("itemaddr", this.mLayerID);
    localBundle1.putInt("bshow", 1);
    if (paramBoolean1) {
      localBundle1.putString("extparam", "update");
    }
    int j = 0;
    while (j < paramList.size())
    {
      OverlayItem localOverlayItem = (OverlayItem)paramList.get(j);
      if (localOverlayItem.getMarker() == null) {
        localOverlayItem.setMarker(this.b);
      }
      if (TextUtils.isEmpty(localOverlayItem.getId())) {
        localOverlayItem.setId(q.a());
      }
      ParcelItem localParcelItem = new ParcelItem();
      Object localObject2 = localOverlayItem.getMarker();
      byte[] arrayOfByte = localOverlayItem.getGifData();
      if ((localObject2 != null) || (arrayOfByte != null))
      {
        Bundle localBundle2 = new Bundle();
        if (localOverlayItem.getCoordType() == OverlayItem.CoordType.CoordType_BD09LL) {
          localObject1 = m.a(localOverlayItem.getPoint());
        } else {
          localObject1 = localOverlayItem.getPoint();
        }
        localBundle2.putDouble("x", ((GeoPoint)localObject1).getLongitude());
        localBundle2.putDouble("y", ((GeoPoint)localObject1).getLatitude());
        localBundle2.putFloat("geoz", localOverlayItem.getGeoZ());
        localBundle2.putInt("indoorpoi", localOverlayItem.getIndoorPoi());
        localBundle2.putInt("showLR", 1);
        localBundle2.putInt("iconwidth", 0);
        localBundle2.putInt("iconlayer", 1);
        localBundle2.putFloat("ax", localOverlayItem.getAnchorX());
        localBundle2.putFloat("ay", localOverlayItem.getAnchorY());
        localBundle2.putInt("bound", localOverlayItem.getBound());
        localBundle2.putInt("level", localOverlayItem.getLevel());
        localBundle2.putInt("mask", localOverlayItem.getMask());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localOverlayItem.getId());
        localBundle2.putString("popname", ((StringBuilder)localObject1).toString());
        if (arrayOfByte != null)
        {
          localBundle2.putFloat("gifscale", localOverlayItem.getScale());
          localBundle2.putInt("gifsize", arrayOfByte.length);
          localBundle2.putByteArray("imgdata", arrayOfByte);
          localBundle2.putInt("imgindex", a());
        }
        else
        {
          localObject1 = c.a((Drawable)localObject2);
          if (localObject1 == null) {
            break label701;
          }
          localBundle2.putInt("imgindex", localOverlayItem.getResId());
          localBundle2.putInt("imgW", ((Bitmap)localObject1).getWidth());
          localBundle2.putInt("imgH", ((Bitmap)localObject1).getHeight());
          if ((!paramBoolean1) && (a(localOverlayItem)))
          {
            localBundle2.putByteArray("imgdata", null);
          }
          else
          {
            localObject2 = ByteBuffer.allocate(((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight() * 4);
            ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
            localBundle2.putByteArray("imgdata", ((ByteBuffer)localObject2).array());
          }
        }
        localObject1 = a(localOverlayItem.getClickRect());
        if ((localObject1 != null) && (localObject1.length > 0)) {
          localBundle2.putStringArray("clickrect", (String[])localObject1);
        }
        localBundle2.putBundle("animate", localOverlayItem.getAnimate());
        localBundle2.putBundle("delay", localOverlayItem.getDelay());
        localParcelItem.setBundle(localBundle2);
        localArrayList.add(localParcelItem);
        if (!paramBoolean1) {
          this.a.add(localOverlayItem);
        }
      }
      label701:
      j += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramList = new ParcelItem[localArrayList.size()];
      j = 0;
      while (j < localArrayList.size())
      {
        paramList[j] = ((ParcelItem)localArrayList.get(j));
        j += 1;
      }
      localBundle1.putParcelableArray("itemdatas", paramList);
      this.c.getController().getBaseMap().AddItemData(localBundle1, paramBoolean2);
    }
    try
    {
      this.e = true;
      return;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.a;
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        return paramInt;
      }
      return -1;
    }
    finally {}
  }
  
  protected boolean a(OverlayItem paramOverlayItem)
  {
    try
    {
      Object localObject = new ArrayList(this.a);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        OverlayItem localOverlayItem = (OverlayItem)((Iterator)localObject).next();
        if (paramOverlayItem.getResId() == -1) {
          return false;
        }
        if ((localOverlayItem.getResId() != -1) && (paramOverlayItem.getResId() == localOverlayItem.getResId())) {
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  protected String[] a(ArrayList<Bundle> paramArrayList)
  {
    String[] arrayOfString;
    int j;
    JSONObject localJSONObject;
    Bundle localBundle;
    Iterator localIterator;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int k = paramArrayList.size();
      arrayOfString = new String[k];
      j = 0;
      if (j < k)
      {
        localJSONObject = new JSONObject();
        localBundle = (Bundle)paramArrayList.get(j);
        localIterator = localBundle.keySet().iterator();
      }
    }
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        localJSONObject.put(str, localBundle.get(str));
      }
      catch (JSONException localJSONException) {}
      arrayOfString[j] = localJSONObject.toString();
      j += 1;
      break;
      return arrayOfString;
      return null;
    }
  }
  
  public void addItem(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem != null)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramOverlayItem);
      addItem(localArrayList);
    }
  }
  
  public void addItem(List<OverlayItem> paramList)
  {
    a(paramList, false, false);
  }
  
  public void addItemsByReplace(List<OverlayItem> paramList)
  {
    a(paramList, false, true);
  }
  
  void b(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean b()
  {
    return this.e;
  }
  
  void c()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.a);
      removeAll();
      addItem(localArrayList);
      return;
    }
    finally {}
  }
  
  public int compare(Integer paramInteger1, Integer paramInteger2)
  {
    try
    {
      paramInteger1 = ((OverlayItem)this.a.get(paramInteger1.intValue())).getPoint();
      paramInteger2 = ((OverlayItem)this.a.get(paramInteger2.intValue())).getPoint();
      if (paramInteger1.getLatitude() > paramInteger2.getLatitude()) {
        return -1;
      }
      double d1 = paramInteger1.getLatitude();
      double d2 = paramInteger2.getLatitude();
      int j = 1;
      if (d1 < d2) {
        return 1;
      }
      if (paramInteger1.getLongitude() < paramInteger2.getLongitude()) {
        return -1;
      }
      if (paramInteger1.getLongitude() == paramInteger2.getLongitude()) {
        j = 0;
      }
      return j;
    }
    finally {}
  }
  
  public ArrayList<OverlayItem> getAllItem()
  {
    return this.a;
  }
  
  public GeoPoint getCenter()
  {
    int j = a(0);
    if (j == -1) {
      return null;
    }
    return getItem(j).getPoint();
  }
  
  public final OverlayItem getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(this.a);
      if ((localArrayList.size() > paramInt) && (paramInt >= 0)) {
        return (OverlayItem)localArrayList.get(paramInt);
      }
      return null;
    }
    finally {}
  }
  
  public int getLatSpanE6()
  {
    return a(true);
  }
  
  public int getLonSpanE6()
  {
    return a(false);
  }
  
  public int getUpdateType()
  {
    return this.h;
  }
  
  public void initLayer()
  {
    long l = this.c.getController().getBaseMap().AddLayer(0, 0, "item");
    this.mLayerID = l;
    if (l != 0L) {
      return;
    }
    throw new RuntimeException("can not add new layer");
  }
  
  public boolean onTap(int paramInt)
  {
    return false;
  }
  
  public boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapSurfaceView paramMapSurfaceView)
  {
    return false;
  }
  
  /* Error */
  public boolean removeAll()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/baidu/platform/comapi/map/ItemizedOverlay:a	Ljava/util/ArrayList;
    //   6: invokevirtual 450	java/util/ArrayList:isEmpty	()Z
    //   9: ifeq +7 -> 16
    //   12: aload_0
    //   13: monitorexit
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 43	com/baidu/platform/comapi/map/ItemizedOverlay:c	Lcom/baidu/platform/comapi/map/MapSurfaceView;
    //   22: invokevirtual 354	com/baidu/platform/comapi/map/MapSurfaceView:getController	()Lcom/baidu/platform/comapi/map/MapController;
    //   25: ifnull +33 -> 58
    //   28: aload_0
    //   29: getfield 43	com/baidu/platform/comapi/map/ItemizedOverlay:c	Lcom/baidu/platform/comapi/map/MapSurfaceView;
    //   32: invokevirtual 354	com/baidu/platform/comapi/map/MapSurfaceView:getController	()Lcom/baidu/platform/comapi/map/MapController;
    //   35: invokevirtual 360	com/baidu/platform/comapi/map/MapController:getBaseMap	()Lcom/baidu/platform/comjni/map/basemap/AppBaseMap;
    //   38: ifnull +20 -> 58
    //   41: aload_0
    //   42: getfield 43	com/baidu/platform/comapi/map/ItemizedOverlay:c	Lcom/baidu/platform/comapi/map/MapSurfaceView;
    //   45: invokevirtual 354	com/baidu/platform/comapi/map/MapSurfaceView:getController	()Lcom/baidu/platform/comapi/map/MapController;
    //   48: invokevirtual 360	com/baidu/platform/comapi/map/MapController:getBaseMap	()Lcom/baidu/platform/comjni/map/basemap/AppBaseMap;
    //   51: aload_0
    //   52: getfield 47	com/baidu/platform/comapi/map/Overlay:mLayerID	J
    //   55: invokevirtual 454	com/baidu/platform/comjni/map/basemap/AppBaseMap:ClearLayer	(J)V
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 41	com/baidu/platform/comapi/map/ItemizedOverlay:a	Ljava/util/ArrayList;
    //   64: invokevirtual 101	java/util/ArrayList:clear	()V
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 368	com/baidu/platform/comapi/map/ItemizedOverlay:e	Z
    //   72: aload_0
    //   73: monitorexit
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ItemizedOverlay
    //   76	4	1	localObject1	Object
    //   81	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   60	74	76	finally
    //   77	79	76	finally
    //   2	14	81	finally
    //   16	18	81	finally
    //   82	84	81	finally
  }
  
  public boolean removeItem(OverlayItem paramOverlayItem)
  {
    if (this.mLayerID == 0L) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("itemaddr", this.mLayerID);
    if (paramOverlayItem.getId().equals("")) {
      return false;
    }
    localBundle.putString("id", paramOverlayItem.getId());
    if (!this.c.getController().getBaseMap().RemoveItemData(localBundle)) {
      return false;
    }
    try
    {
      this.a.remove(paramOverlayItem);
      this.e = true;
      return true;
    }
    finally {}
  }
  
  public boolean removeOneItem(Iterator<OverlayItem> paramIterator, OverlayItem paramOverlayItem)
  {
    if (this.mLayerID == 0L) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("itemaddr", this.mLayerID);
    if (paramOverlayItem.getId().equals("")) {
      return false;
    }
    localBundle.putString("id", paramOverlayItem.getId());
    if (!this.c.getController().getBaseMap().RemoveItemData(localBundle)) {
      return false;
    }
    paramIterator.remove();
    try
    {
      this.e = true;
      return true;
    }
    finally {}
  }
  
  public void setFocus(int paramInt, boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    Object localObject1 = getItem(paramInt);
    if (localObject1 != null)
    {
      if (paramBoolean)
      {
        this.g.setGeoPoint(new GeoPoint(((OverlayItem)localObject1).getPoint().getLatitude(), ((OverlayItem)localObject1).getPoint().getLongitude()));
        try
        {
          localObject1 = new ArrayList(this.a);
          if (((ArrayList)localObject1).contains(this.g)) {
            updateItem(this.g);
          } else {
            addItem(this.g);
          }
        }
        finally {}
      }
      else
      {
        removeItem(this.g);
      }
      MapSurfaceView localMapSurfaceView = this.c;
      if (localMapSurfaceView != null) {
        localMapSurfaceView.refresh(this);
      }
    }
  }
  
  public void setFocusMarker(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    if (this.g == null) {
      this.g = new OverlayItem(null, "", "");
    }
    this.g.setMarker(this.f);
  }
  
  public void setFocusMarker(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    this.f = paramDrawable;
    if (this.g == null)
    {
      paramDrawable = new OverlayItem(null, "", "");
      this.g = paramDrawable;
      paramDrawable.setAnchor(paramFloat1, paramFloat2);
    }
    this.g.setMarker(this.f);
  }
  
  public void setUpdateType(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setmMarker(Drawable paramDrawable)
  {
    this.b = paramDrawable;
  }
  
  public int size()
  {
    try
    {
      ArrayList localArrayList = this.a;
      int j;
      if (localArrayList == null) {
        j = 0;
      } else {
        j = localArrayList.size();
      }
      return j;
    }
    finally {}
  }
  
  public boolean updateItem(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      return false;
    }
    if (paramOverlayItem.getId().equals("")) {
      return false;
    }
    try
    {
      Object localObject = new ArrayList(this.a);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        OverlayItem localOverlayItem = (OverlayItem)((Iterator)localObject).next();
        if (paramOverlayItem.getId().equals(localOverlayItem.getId()))
        {
          j = 1;
          break label83;
        }
      }
      int j = 0;
      label83:
      if (j == 0) {
        return false;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramOverlayItem);
      a((List)localObject, true);
      return true;
    }
    finally {}
  }
  
  public boolean updateItem(List<OverlayItem> paramList)
  {
    if (paramList == null) {
      return false;
    }
    a(paramList, true);
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.ItemizedOverlay
 * JD-Core Version:    0.7.0.1
 */