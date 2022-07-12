package e2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class m
  implements k
{
  private static final Bitmap.Config[] d;
  private static final Bitmap.Config[] e;
  private static final Bitmap.Config[] f = { Bitmap.Config.RGB_565 };
  private static final Bitmap.Config[] g = { Bitmap.Config.ARGB_4444 };
  private static final Bitmap.Config[] h = { Bitmap.Config.ALPHA_8 };
  private final c a = new c();
  private final g<b, Bitmap> b = new g();
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();
  
  static
  {
    Bitmap.Config[] arrayOfConfig2 = new Bitmap.Config[2];
    arrayOfConfig2[0] = Bitmap.Config.ARGB_8888;
    arrayOfConfig2[1] = null;
    Bitmap.Config[] arrayOfConfig1 = arrayOfConfig2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      arrayOfConfig1 = (Bitmap.Config[])Arrays.copyOf(arrayOfConfig2, 3);
      arrayOfConfig1[(arrayOfConfig1.length - 1)] = Bitmap.Config.RGBA_F16;
    }
    d = arrayOfConfig1;
    e = arrayOfConfig1;
  }
  
  private void g(Integer paramInteger, Bitmap paramBitmap)
  {
    Object localObject = k(paramBitmap.getConfig());
    Integer localInteger = (Integer)((NavigableMap)localObject).get(paramInteger);
    if (localInteger != null)
    {
      if (localInteger.intValue() == 1)
      {
        ((NavigableMap)localObject).remove(paramInteger);
        return;
      }
      ((NavigableMap)localObject).put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Tried to decrement empty size, size: ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", removed: ");
    ((StringBuilder)localObject).append(f(paramBitmap));
    ((StringBuilder)localObject).append(", this: ");
    ((StringBuilder)localObject).append(this);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  private b h(int paramInt, Bitmap.Config paramConfig)
  {
    b localb = this.a.e(paramInt, paramConfig);
    Bitmap.Config[] arrayOfConfig = j(paramConfig);
    int j = arrayOfConfig.length;
    int i = 0;
    while (i < j)
    {
      Bitmap.Config localConfig = arrayOfConfig[i];
      Integer localInteger = (Integer)k(localConfig).ceilingKey(Integer.valueOf(paramInt));
      if ((localInteger != null) && (localInteger.intValue() <= paramInt * 8))
      {
        if ((localInteger.intValue() == paramInt) && (localConfig == null ? paramConfig == null : localConfig.equals(paramConfig))) {
          break;
        }
        this.a.c(localb);
        return this.a.e(localInteger.intValue(), localConfig);
      }
      i += 1;
    }
    return localb;
  }
  
  static String i(int paramInt, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("](");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private static Bitmap.Config[] j(Bitmap.Config paramConfig)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramConfig))) {
      return e;
    }
    int i = a.a[paramConfig.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return new Bitmap.Config[] { paramConfig };
          }
          return h;
        }
        return g;
      }
      return f;
    }
    return d;
  }
  
  private NavigableMap<Integer, Integer> k(Bitmap.Config paramConfig)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.c.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.c.put(paramConfig, localObject);
    }
    return localObject;
  }
  
  public String a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return i(x2.l.g(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public int b(Bitmap paramBitmap)
  {
    return x2.l.h(paramBitmap);
  }
  
  public Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    b localb = h(x2.l.g(paramInt1, paramInt2, paramConfig), paramConfig);
    Bitmap localBitmap = (Bitmap)this.b.a(localb);
    if (localBitmap != null)
    {
      g(Integer.valueOf(localb.b), localBitmap);
      localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap;
  }
  
  public void d(Bitmap paramBitmap)
  {
    int i = x2.l.h(paramBitmap);
    b localb = this.a.e(i, paramBitmap.getConfig());
    this.b.d(localb, paramBitmap);
    paramBitmap = k(paramBitmap.getConfig());
    Integer localInteger = (Integer)paramBitmap.get(Integer.valueOf(localb.b));
    int j = localb.b;
    i = 1;
    if (localInteger != null) {
      i = 1 + localInteger.intValue();
    }
    paramBitmap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public Bitmap e()
  {
    Bitmap localBitmap = (Bitmap)this.b.f();
    if (localBitmap != null) {
      g(Integer.valueOf(x2.l.h(localBitmap)), localBitmap);
    }
    return localBitmap;
  }
  
  public String f(Bitmap paramBitmap)
  {
    return i(x2.l.h(paramBitmap), paramBitmap.getConfig());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SizeConfigStrategy{groupedMap=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sortedSizes=(");
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append('[');
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("], ");
    }
    if (!this.c.isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    localStringBuilder.append(")}");
    return localStringBuilder.toString();
  }
  
  static final class b
    implements l
  {
    private final m.c a;
    int b;
    private Bitmap.Config c;
    
    public b(m.c paramc)
    {
      this.a = paramc;
    }
    
    public void a()
    {
      this.a.c(this);
    }
    
    public void b(int paramInt, Bitmap.Config paramConfig)
    {
      this.b = paramInt;
      this.c = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool3 = paramObject instanceof b;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        paramObject = (b)paramObject;
        bool1 = bool2;
        if (this.b == paramObject.b)
        {
          bool1 = bool2;
          if (x2.l.d(this.c, paramObject.c)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int j = this.b;
      Bitmap.Config localConfig = this.c;
      int i;
      if (localConfig != null) {
        i = localConfig.hashCode();
      } else {
        i = 0;
      }
      return j * 31 + i;
    }
    
    public String toString()
    {
      return m.i(this.b, this.c);
    }
  }
  
  static class c
    extends c<m.b>
  {
    protected m.b d()
    {
      return new m.b(this);
    }
    
    public m.b e(int paramInt, Bitmap.Config paramConfig)
    {
      m.b localb = (m.b)b();
      localb.b(paramInt, paramConfig);
      return localb;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.m
 * JD-Core Version:    0.7.0.1
 */