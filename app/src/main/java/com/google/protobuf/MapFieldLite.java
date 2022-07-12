package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapFieldLite<K, V>
  extends LinkedHashMap<K, V>
{
  private static final MapFieldLite EMPTY_MAP_FIELD;
  private boolean isMutable = true;
  
  static
  {
    MapFieldLite localMapFieldLite = new MapFieldLite(Collections.emptyMap());
    EMPTY_MAP_FIELD = localMapFieldLite;
    localMapFieldLite.makeImmutable();
  }
  
  private MapFieldLite() {}
  
  private MapFieldLite(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  static <K, V> int calculateHashCodeForMap(Map<K, V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int j = calculateHashCodeForObject(localEntry.getKey());
      i += (calculateHashCodeForObject(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  private static int calculateHashCodeForObject(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return Internal.hashCode((byte[])paramObject);
    }
    if (!(paramObject instanceof Internal.EnumLite)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  private static Object copy(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      localObject = Arrays.copyOf(paramObject, paramObject.length);
    }
    return localObject;
  }
  
  static <K, V> Map<K, V> copy(Map<K, V> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), copy(localEntry.getValue()));
    }
    return localLinkedHashMap;
  }
  
  public static <K, V> MapFieldLite<K, V> emptyMapField()
  {
    return EMPTY_MAP_FIELD;
  }
  
  private void ensureMutable()
  {
    if (isMutable()) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {
      return true;
    }
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(localEntry.getKey())) {
        return false;
      }
      if (!equals(localEntry.getValue(), paramMap2.get(localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public void clear()
  {
    ensureMutable();
    clear();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (equals(this, (Map)paramObject));
  }
  
  public int hashCode()
  {
    return calculateHashCodeForMap(this);
  }
  
  public boolean isMutable()
  {
    return this.isMutable;
  }
  
  public void makeImmutable()
  {
    this.isMutable = false;
  }
  
  public void mergeFrom(MapFieldLite<K, V> paramMapFieldLite)
  {
    ensureMutable();
    if (!paramMapFieldLite.isEmpty()) {
      putAll(paramMapFieldLite);
    }
  }
  
  public MapFieldLite<K, V> mutableCopy()
  {
    if (isEmpty()) {
      return new MapFieldLite();
    }
    return new MapFieldLite(this);
  }
  
  public V put(K paramK, V paramV)
  {
    ensureMutable();
    return super.put(paramK, paramV);
  }
  
  public V put(Map.Entry<K, V> paramEntry)
  {
    return put(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureMutable();
    super.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    ensureMutable();
    return super.remove(paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.MapFieldLite
 * JD-Core Version:    0.7.0.1
 */