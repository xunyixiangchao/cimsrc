package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.util.SparseIntArray;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.s;
import g0.d;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class HeatMap
{
  public static final Gradient DEFAULT_GRADIENT;
  public static final double DEFAULT_OPACITY = 0.6D;
  public static final int DEFAULT_RADIUS = 12;
  private static final SparseIntArray n;
  private static final int[] o;
  private static final float[] p;
  private static int q = 0;
  private b<WeightedLatLng> a;
  private Collection<WeightedLatLng> b;
  private int c;
  private Gradient d;
  private double e;
  private a f;
  private int[] g;
  private double[] h;
  private double[] i;
  private HashMap<String, Tile> j = new HashMap();
  private ExecutorService k = Executors.newFixedThreadPool(1);
  private HashSet<String> l = new HashSet();
  BaiduMap m;
  
  static
  {
    Object localObject = new SparseIntArray();
    n = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(3, 8388608);
    ((SparseIntArray)localObject).put(4, 4194304);
    ((SparseIntArray)localObject).put(5, 2097152);
    ((SparseIntArray)localObject).put(6, 1048576);
    ((SparseIntArray)localObject).put(7, 524288);
    ((SparseIntArray)localObject).put(8, 262144);
    ((SparseIntArray)localObject).put(9, 131072);
    ((SparseIntArray)localObject).put(10, 65536);
    ((SparseIntArray)localObject).put(11, 32768);
    ((SparseIntArray)localObject).put(12, 16384);
    ((SparseIntArray)localObject).put(13, 8192);
    ((SparseIntArray)localObject).put(14, 4096);
    ((SparseIntArray)localObject).put(15, 2048);
    ((SparseIntArray)localObject).put(16, 1024);
    ((SparseIntArray)localObject).put(17, 512);
    ((SparseIntArray)localObject).put(18, 256);
    ((SparseIntArray)localObject).put(19, 128);
    ((SparseIntArray)localObject).put(20, 64);
    localObject = new int[3];
    localObject[0] = Color.rgb(0, 0, 200);
    localObject[1] = Color.rgb(0, 225, 0);
    localObject[2] = Color.rgb(255, 0, 0);
    o = (int[])localObject;
    float[] arrayOfFloat = new float[3];
    float[] tmp207_206 = arrayOfFloat;
    tmp207_206[0] = 0.08F;
    float[] tmp212_207 = tmp207_206;
    tmp212_207[1] = 0.4F;
    float[] tmp217_212 = tmp212_207;
    tmp217_212[2] = 1.0F;
    tmp217_212;
    p = arrayOfFloat;
    DEFAULT_GRADIENT = new Gradient((int[])localObject, arrayOfFloat);
  }
  
  private HeatMap(Builder paramBuilder)
  {
    this.b = Builder.a(paramBuilder);
    this.c = Builder.b(paramBuilder);
    this.d = Builder.c(paramBuilder);
    this.e = Builder.d(paramBuilder);
    int i1 = this.c;
    this.h = a(i1, i1 / 3.0D);
    a(this.d);
    c(this.b);
  }
  
  private static double a(Collection<WeightedLatLng> paramCollection, a parama, int paramInt1, int paramInt2)
  {
    double d3 = parama.a;
    double d1 = parama.c;
    double d4 = parama.b;
    double d2 = parama.d;
    d1 -= d3;
    d2 -= d4;
    if (d1 <= d2) {
      d1 = d2;
    }
    double d5 = (int)(paramInt2 / (paramInt1 * 2) + 0.5D) / d1;
    parama = new d();
    Iterator localIterator = paramCollection.iterator();
    d2 = 0.0D;
    d1 = d3;
    paramCollection = parama;
    while (localIterator.hasNext())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)localIterator.next();
      d3 = localWeightedLatLng.a().x;
      double d6 = localWeightedLatLng.a().y;
      paramInt1 = (int)((d3 - d1) * d5);
      paramInt2 = (int)((d6 - d4) * d5);
      long l1 = paramInt1;
      Object localObject = (d)paramCollection.e(l1);
      parama = (a)localObject;
      if (localObject == null)
      {
        parama = new d();
        paramCollection.l(l1, parama);
      }
      l1 = paramInt2;
      Double localDouble = (Double)parama.e(l1);
      localObject = localDouble;
      if (localDouble == null) {
        localObject = Double.valueOf(0.0D);
      }
      localObject = Double.valueOf(((Double)localObject).doubleValue() + localWeightedLatLng.intensity);
      parama.l(l1, localObject);
      d3 = d2;
      if (((Double)localObject).doubleValue() > d2) {
        d3 = ((Double)localObject).doubleValue();
      }
      d2 = d3;
    }
    return d2;
  }
  
  private static Bitmap a(double[][] paramArrayOfDouble, int[] paramArrayOfInt, double paramDouble)
  {
    int i3 = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    paramDouble = (paramArrayOfInt.length - 1) / paramDouble;
    int i4 = paramArrayOfDouble.length;
    int[] arrayOfInt = new int[i4 * i4];
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      while (i2 < i4)
      {
        double d1 = paramArrayOfDouble[i2][i1];
        int i5 = i1 * i4 + i2;
        int i6 = (int)(d1 * paramDouble);
        if (d1 != 0.0D)
        {
          if (i6 < paramArrayOfInt.length) {
            arrayOfInt[i5] = paramArrayOfInt[i6];
          } else {
            arrayOfInt[i5] = i3;
          }
        }
        else {
          arrayOfInt[i5] = 0;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    paramArrayOfDouble = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    paramArrayOfDouble.setPixels(arrayOfInt, 0, i4, 0, 0, i4, i4);
    return paramArrayOfDouble;
  }
  
  private static Tile a(Bitmap paramBitmap)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    return new Tile(256, 256, localByteBuffer.array());
  }
  
  private void a(Gradient paramGradient)
  {
    this.d = paramGradient;
    this.g = paramGradient.a(this.e);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.l.add(paramString);
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
      this.j.put(paramString, paramTile);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private double[] a(int paramInt)
  {
    double[] arrayOfDouble = new double[20];
    int i1 = 5;
    int i2;
    for (;;)
    {
      i2 = 11;
      if (i1 >= 11) {
        break;
      }
      arrayOfDouble[i1] = a(this.b, this.f, paramInt, (int)(Math.pow(2.0D, i1 - 3) * 1280.0D));
      if (i1 == 5)
      {
        i2 = 0;
        while (i2 < i1)
        {
          arrayOfDouble[i2] = arrayOfDouble[i1];
          i2 += 1;
        }
      }
      i1 += 1;
    }
    while (i2 < 20)
    {
      arrayOfDouble[i2] = arrayOfDouble[10];
      i2 += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[] a(int paramInt, double paramDouble)
  {
    double[] arrayOfDouble = new double[paramInt * 2 + 1];
    int i1 = -paramInt;
    while (i1 <= paramInt)
    {
      arrayOfDouble[(i1 + paramInt)] = Math.exp(-i1 * i1 / (2.0D * paramDouble * paramDouble));
      i1 += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[][] a(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1)
  {
    int i1 = (int)Math.floor(paramArrayOfDouble1.length / 2.0D);
    int i8 = paramArrayOfDouble.length;
    int i9 = i8 - i1 * 2;
    int i3 = i1 + i9 - 1;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i8, i8 });
    int i4 = 0;
    int i5;
    double d1;
    int i2;
    int i6;
    int i7;
    double[] arrayOfDouble1;
    while (i4 < i8)
    {
      i5 = 0;
      while (i5 < i8)
      {
        d1 = paramArrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          i2 = i4 + i1;
          i6 = i2;
          if (i3 < i2) {
            i6 = i3;
          }
          i7 = i4 - i1;
          if (i1 > i7) {
            i2 = i1;
          } else {
            i2 = i7;
          }
          while (i2 < i6 + 1)
          {
            arrayOfDouble1 = arrayOfDouble[i2];
            arrayOfDouble1[i5] += paramArrayOfDouble1[(i2 - i7)] * d1;
            i2 += 1;
          }
        }
        i5 += 1;
      }
      i4 += 1;
    }
    paramArrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i9, i9 });
    i4 = i1;
    while (i4 < i3 + 1)
    {
      i5 = 0;
      while (i5 < i8)
      {
        d1 = arrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          i2 = i5 + i1;
          i6 = i2;
          if (i3 < i2) {
            i6 = i3;
          }
          i7 = i5 - i1;
          if (i1 > i7) {
            i2 = i1;
          } else {
            i2 = i7;
          }
          while (i2 < i6 + 1)
          {
            arrayOfDouble1 = paramArrayOfDouble[(i4 - i1)];
            i9 = i2 - i1;
            arrayOfDouble1[i9] += paramArrayOfDouble1[(i2 - i7)] * d1;
            i2 += 1;
          }
        }
        i5 += 1;
      }
      i4 += 1;
    }
    return paramArrayOfDouble;
  }
  
  private Tile b(String paramString)
  {
    try
    {
      if (this.j.containsKey(paramString))
      {
        Tile localTile = (Tile)this.j.get(paramString);
        this.j.remove(paramString);
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
  
  private static a b(Collection<WeightedLatLng> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
    double d4 = localWeightedLatLng.a().x;
    double d3 = localWeightedLatLng.a().x;
    double d2 = localWeightedLatLng.a().y;
    double d1 = localWeightedLatLng.a().y;
    double d7 = d4;
    while (paramCollection.hasNext())
    {
      localWeightedLatLng = (WeightedLatLng)paramCollection.next();
      double d8 = localWeightedLatLng.a().x;
      d4 = localWeightedLatLng.a().y;
      double d5 = d7;
      if (d8 < d7) {
        d5 = d8;
      }
      double d6 = d3;
      if (d8 > d3) {
        d6 = d8;
      }
      d8 = d2;
      if (d4 < d2) {
        d8 = d4;
      }
      d7 = d5;
      d3 = d6;
      d2 = d8;
      if (d4 > d1)
      {
        d1 = d4;
        d7 = d5;
        d3 = d6;
        d2 = d8;
      }
    }
    return new a(d7, d3, d2, d1);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    double d4 = n.get(paramInt3);
    int i1 = this.c;
    double d5 = i1 * d4 / 256.0D;
    double d2 = (2.0D * d5 + d4) / (i1 * 2 + 256);
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      double d3 = paramInt1 * d4 - d5;
      double d6 = paramInt1 + 1;
      double d7 = paramInt2;
      double d1 = (paramInt2 + 1) * d4 + d5;
      Object localObject1 = new a(d3, d6 * d4 + d5, d7 * d4 - d5, d1);
      Object localObject2 = this.f;
      if (!((a)localObject1).b(new a(((a)localObject2).a - d5, ((a)localObject2).c + d5, ((a)localObject2).b - d5, ((a)localObject2).d + d5))) {
        return;
      }
      localObject2 = this.a.a((a)localObject1);
      if (((Collection)localObject2).isEmpty()) {
        return;
      }
      i1 = this.c * 2 + 256;
      localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { i1, i1 });
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WeightedLatLng localWeightedLatLng = (WeightedLatLng)((Iterator)localObject2).next();
        Point localPoint = localWeightedLatLng.a();
        int i2 = (int)((localPoint.x - d3) / d2);
        int i3 = (int)((d1 - localPoint.y) / d2);
        int i4 = this.c * 2 + 256;
        i1 = i2;
        if (i2 >= i4) {
          i1 = i4 - 1;
        }
        i2 = i3;
        if (i3 >= i4) {
          i2 = i4 - 1;
        }
        localPoint = localObject1[i1];
        localPoint[i2] += localWeightedLatLng.intensity;
      }
      localObject2 = a(a((double[][])localObject1, this.h), this.g, this.i[(paramInt3 - 1)]);
      localObject1 = a((Bitmap)localObject2);
      ((Bitmap)localObject2).recycle();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt3);
      a(((StringBuilder)localObject2).toString(), (Tile)localObject1);
      if (this.j.size() > q) {
        b();
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((BaiduMap)localObject1).d();
      }
    }
  }
  
  private void c()
  {
    try
    {
      this.j.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(Collection<WeightedLatLng> paramCollection)
  {
    this.b = paramCollection;
    if (!paramCollection.isEmpty())
    {
      paramCollection = b(this.b);
      this.f = paramCollection;
      this.a = new b(paramCollection);
      paramCollection = this.b.iterator();
      while (paramCollection.hasNext())
      {
        WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
        this.a.a(localWeightedLatLng);
      }
      this.i = a(this.c);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: No input points.");
  }
  
  private boolean c(String paramString)
  {
    try
    {
      boolean bool = this.l.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static Collection<WeightedLatLng> d(Collection<LatLng> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramCollection.next()));
    }
    return localArrayList;
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
    if (!c((String)localObject1))
    {
      localObject2 = this.m;
      if ((localObject2 != null) && (q == 0))
      {
        localObject2 = ((BaiduMap)localObject2).getMapStatus().c.j;
        q = ((((WinRound)localObject2).right - ((WinRound)localObject2).left) / 256 + 2) * ((((WinRound)localObject2).bottom - ((WinRound)localObject2).top) / 256 + 2) * 4;
      }
      if (this.j.size() > q) {
        b();
      }
      if (!this.k.isShutdown()) {
        try
        {
          this.k.execute(new a(paramInt1, paramInt2, paramInt3));
          a((String)localObject1);
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          localRejectedExecutionException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  void a()
  {
    c();
  }
  
  void b()
  {
    try
    {
      this.l.clear();
      this.j.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void d()
  {
    this.k.shutdownNow();
  }
  
  public void removeHeatMap()
  {
    BaiduMap localBaiduMap = this.m;
    if (localBaiduMap != null) {
      localBaiduMap.a(this);
    }
  }
  
  public static class Builder
  {
    private Collection<WeightedLatLng> a;
    private int b = 12;
    private Gradient c = HeatMap.DEFAULT_GRADIENT;
    private double d = 0.6D;
    
    public HeatMap build()
    {
      if (this.a != null) {
        return new HeatMap(this, null);
      }
      throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
    }
    
    public Builder data(Collection<LatLng> paramCollection)
    {
      if ((paramCollection != null) && (!paramCollection.isEmpty()))
      {
        if (!paramCollection.contains(null)) {
          return weightedData(HeatMap.a(paramCollection));
        }
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
      }
      throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }
    
    public Builder gradient(Gradient paramGradient)
    {
      if (paramGradient != null)
      {
        this.c = paramGradient;
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
    }
    
    public Builder opacity(double paramDouble)
    {
      this.d = paramDouble;
      if ((paramDouble >= 0.0D) && (paramDouble <= 1.0D)) {
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: Opacity must be in range [0, 1]");
    }
    
    public Builder radius(int paramInt)
    {
      this.b = paramInt;
      if ((paramInt >= 10) && (paramInt <= 50)) {
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: Radius not within bounds.");
    }
    
    public Builder weightedData(Collection<WeightedLatLng> paramCollection)
    {
      if ((paramCollection != null) && (!paramCollection.isEmpty()))
      {
        if (!paramCollection.contains(null))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramCollection.iterator();
          while (localIterator.hasNext())
          {
            WeightedLatLng localWeightedLatLng = (WeightedLatLng)localIterator.next();
            LatLng localLatLng = localWeightedLatLng.latLng;
            double d1 = localLatLng.latitude;
            if ((d1 >= 0.37532D) && (d1 <= 54.562494999999998D))
            {
              d1 = localLatLng.longitude;
              if ((d1 >= 72.508319D) && (d1 <= 135.94219799999999D)) {}
            }
            else
            {
              localArrayList.add(localWeightedLatLng);
            }
          }
          paramCollection.removeAll(localArrayList);
          this.a = paramCollection;
          return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
      }
      throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }
  }
  
  class a
    implements Runnable
  {
    a(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void run()
    {
      HeatMap.a(HeatMap.this, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.HeatMap
 * JD-Core Version:    0.7.0.1
 */