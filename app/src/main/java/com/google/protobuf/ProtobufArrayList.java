package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class ProtobufArrayList<E>
  extends AbstractProtobufList<E>
{
  private static final ProtobufArrayList<Object> EMPTY_LIST;
  private final List<E> list;
  
  static
  {
    ProtobufArrayList localProtobufArrayList = new ProtobufArrayList();
    EMPTY_LIST = localProtobufArrayList;
    localProtobufArrayList.makeImmutable();
  }
  
  ProtobufArrayList()
  {
    this(new ArrayList(10));
  }
  
  private ProtobufArrayList(List<E> paramList)
  {
    this.list = paramList;
  }
  
  public static <E> ProtobufArrayList<E> emptyList()
  {
    return EMPTY_LIST;
  }
  
  public void add(int paramInt, E paramE)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramE);
    this.modCount += 1;
  }
  
  public E get(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public ProtobufArrayList<E> mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= size())
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      localArrayList.addAll(this.list);
      return new ProtobufArrayList(localArrayList);
    }
    throw new IllegalArgumentException();
  }
  
  public E remove(int paramInt)
  {
    ensureIsMutable();
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return localObject;
  }
  
  public E set(int paramInt, E paramE)
  {
    ensureIsMutable();
    paramE = this.list.set(paramInt, paramE);
    this.modCount += 1;
    return paramE;
  }
  
  public int size()
  {
    return this.list.size();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ProtobufArrayList
 * JD-Core Version:    0.7.0.1
 */