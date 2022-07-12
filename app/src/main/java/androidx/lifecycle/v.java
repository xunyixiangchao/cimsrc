package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class v
{
  private static final Class[] e = { Boolean.TYPE, [Z.class, Double.TYPE, [D.class, Integer.TYPE, [I.class, Long.TYPE, [J.class, String.class, [Ljava.lang.String.class, Binder.class, Bundle.class, Byte.TYPE, [B.class, Character.TYPE, [C.class, CharSequence.class, [Ljava.lang.CharSequence.class, ArrayList.class, Float.TYPE, [F.class, Parcelable.class, [Landroid.os.Parcelable.class, Serializable.class, Short.TYPE, [S.class, SparseArray.class, Size.class, SizeF.class };
  final Map<String, Object> a;
  final Map<String, SavedStateRegistry.b> b = new HashMap();
  private final Map<String, Object> c = new HashMap();
  private final SavedStateRegistry.b d = new a();
  
  public v()
  {
    this.a = new HashMap();
  }
  
  public v(Map<String, Object> paramMap)
  {
    this.a = new HashMap(paramMap);
  }
  
  static v a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return new v();
    }
    HashMap localHashMap = new HashMap();
    if (paramBundle2 != null)
    {
      Iterator localIterator = paramBundle2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle2.get(str));
      }
    }
    if (paramBundle1 == null) {
      return new v(localHashMap);
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    if ((paramBundle2 != null) && (paramBundle1 != null) && (paramBundle2.size() == paramBundle1.size()))
    {
      int i = 0;
      while (i < paramBundle2.size())
      {
        localHashMap.put((String)paramBundle2.get(i), paramBundle1.get(i));
        i += 1;
      }
      return new v(localHashMap);
    }
    throw new IllegalStateException("Invalid bundle passed as restored state");
  }
  
  private static void d(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = e;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramObject)) {
        return;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't put value with type ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    ((StringBuilder)localObject).append(" into saved state");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  SavedStateRegistry.b b()
  {
    return this.d;
  }
  
  public <T> void c(String paramString, T paramT)
  {
    d(paramT);
    r localr = (r)this.c.get(paramString);
    if (localr != null)
    {
      localr.o(paramT);
      return;
    }
    this.a.put(paramString, paramT);
  }
  
  class a
    implements SavedStateRegistry.b
  {
    a() {}
    
    public Bundle a()
    {
      Object localObject1 = new HashMap(v.this.b).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = ((SavedStateRegistry.b)((Map.Entry)localObject2).getValue()).a();
        v.this.c((String)((Map.Entry)localObject2).getKey(), localObject3);
      }
      Object localObject3 = v.this.a.keySet();
      localObject1 = new ArrayList(((Set)localObject3).size());
      Object localObject2 = new ArrayList(((ArrayList)localObject1).size());
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        ((ArrayList)localObject1).add(str);
        ((ArrayList)localObject2).add(v.this.a.get(str));
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putParcelableArrayList("keys", (ArrayList)localObject1);
      ((Bundle)localObject3).putParcelableArrayList("values", (ArrayList)localObject2);
      return localObject3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.v
 * JD-Core Version:    0.7.0.1
 */