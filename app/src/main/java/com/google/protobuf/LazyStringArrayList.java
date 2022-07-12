package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractProtobufList<String>
  implements LazyStringList, RandomAccess
{
  public static final LazyStringList EMPTY;
  private static final LazyStringArrayList EMPTY_LIST;
  private final List<Object> list;
  
  static
  {
    LazyStringArrayList localLazyStringArrayList = new LazyStringArrayList();
    EMPTY_LIST = localLazyStringArrayList;
    localLazyStringArrayList.makeImmutable();
    EMPTY = localLazyStringArrayList;
  }
  
  public LazyStringArrayList()
  {
    this(10);
  }
  
  public LazyStringArrayList(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList)
  {
    this.list = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  private LazyStringArrayList(ArrayList<Object> paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  public LazyStringArrayList(List<String> paramList)
  {
    this(new ArrayList(paramList));
  }
  
  private void add(int paramInt, ByteString paramByteString)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramByteString);
    this.modCount += 1;
  }
  
  private void add(int paramInt, byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramArrayOfByte);
    this.modCount += 1;
  }
  
  private static byte[] asByteArray(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return Internal.toByteArray((String)paramObject);
    }
    return ((ByteString)paramObject).toByteArray();
  }
  
  private static ByteString asByteString(Object paramObject)
  {
    if ((paramObject instanceof ByteString)) {
      return (ByteString)paramObject;
    }
    if ((paramObject instanceof String)) {
      return ByteString.copyFromUtf8((String)paramObject);
    }
    return ByteString.copyFrom((byte[])paramObject);
  }
  
  private static String asString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof ByteString)) {
      return ((ByteString)paramObject).toStringUtf8();
    }
    return Internal.toStringUtf8((byte[])paramObject);
  }
  
  static LazyStringArrayList emptyList()
  {
    return EMPTY_LIST;
  }
  
  private Object setAndReturn(int paramInt, ByteString paramByteString)
  {
    ensureIsMutable();
    return this.list.set(paramInt, paramByteString);
  }
  
  private Object setAndReturn(int paramInt, byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    return this.list.set(paramInt, paramArrayOfByte);
  }
  
  public void add(int paramInt, String paramString)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public void add(ByteString paramByteString)
  {
    ensureIsMutable();
    this.list.add(paramByteString);
    this.modCount += 1;
  }
  
  public void add(byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    this.list.add(paramArrayOfByte);
    this.modCount += 1;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    ensureIsMutable();
    Object localObject = paramCollection;
    if ((paramCollection instanceof LazyStringList)) {
      localObject = ((LazyStringList)paramCollection).getUnderlyingElements();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public boolean addAllByteArray(Collection<byte[]> paramCollection)
  {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAllByteString(Collection<? extends ByteString> paramCollection)
  {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public List<byte[]> asByteArrayList()
  {
    return new ByteArrayListView(this);
  }
  
  public List<ByteString> asByteStringList()
  {
    return new ByteStringListView(this);
  }
  
  public void clear()
  {
    ensureIsMutable();
    this.list.clear();
    this.modCount += 1;
  }
  
  public String get(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if ((localObject instanceof ByteString))
    {
      localObject = (ByteString)localObject;
      str = ((ByteString)localObject).toStringUtf8();
      if (((ByteString)localObject).isValidUtf8()) {
        this.list.set(paramInt, str);
      }
      return str;
    }
    localObject = (byte[])localObject;
    String str = Internal.toStringUtf8((byte[])localObject);
    if (Internal.isValidUtf8((byte[])localObject)) {
      this.list.set(paramInt, str);
    }
    return str;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    byte[] arrayOfByte = asByteArray(localObject);
    if (arrayOfByte != localObject) {
      this.list.set(paramInt, arrayOfByte);
    }
    return arrayOfByte;
  }
  
  public ByteString getByteString(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    ByteString localByteString = asByteString(localObject);
    if (localByteString != localObject) {
      this.list.set(paramInt, localByteString);
    }
    return localByteString;
  }
  
  public Object getRaw(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public List<?> getUnderlyingElements()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public LazyStringList getUnmodifiableView()
  {
    if (isModifiable()) {
      return new UnmodifiableLazyStringList(this);
    }
    return this;
  }
  
  public void mergeFrom(LazyStringList paramLazyStringList)
  {
    ensureIsMutable();
    paramLazyStringList = paramLazyStringList.getUnderlyingElements().iterator();
    while (paramLazyStringList.hasNext())
    {
      Object localObject = paramLazyStringList.next();
      if ((localObject instanceof byte[]))
      {
        localObject = (byte[])localObject;
        this.list.add(Arrays.copyOf((byte[])localObject, localObject.length));
      }
      else
      {
        this.list.add(localObject);
      }
    }
  }
  
  public LazyStringArrayList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= size())
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      localArrayList.addAll(this.list);
      return new LazyStringArrayList(localArrayList);
    }
    throw new IllegalArgumentException();
  }
  
  public String remove(int paramInt)
  {
    ensureIsMutable();
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return asString(localObject);
  }
  
  public String set(int paramInt, String paramString)
  {
    ensureIsMutable();
    return asString(this.list.set(paramInt, paramString));
  }
  
  public void set(int paramInt, ByteString paramByteString)
  {
    setAndReturn(paramInt, paramByteString);
  }
  
  public void set(int paramInt, byte[] paramArrayOfByte)
  {
    setAndReturn(paramInt, paramArrayOfByte);
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  private static class ByteArrayListView
    extends AbstractList<byte[]>
    implements RandomAccess
  {
    private final LazyStringArrayList list;
    
    ByteArrayListView(LazyStringArrayList paramLazyStringArrayList)
    {
      this.list = paramLazyStringArrayList;
    }
    
    public void add(int paramInt, byte[] paramArrayOfByte)
    {
      this.list.add(paramInt, paramArrayOfByte);
      this.modCount += 1;
    }
    
    public byte[] get(int paramInt)
    {
      return this.list.getByteArray(paramInt);
    }
    
    public byte[] remove(int paramInt)
    {
      String str = this.list.remove(paramInt);
      this.modCount += 1;
      return LazyStringArrayList.asByteArray(str);
    }
    
    public byte[] set(int paramInt, byte[] paramArrayOfByte)
    {
      paramArrayOfByte = this.list.setAndReturn(paramInt, paramArrayOfByte);
      this.modCount += 1;
      return LazyStringArrayList.asByteArray(paramArrayOfByte);
    }
    
    public int size()
    {
      return this.list.size();
    }
  }
  
  private static class ByteStringListView
    extends AbstractList<ByteString>
    implements RandomAccess
  {
    private final LazyStringArrayList list;
    
    ByteStringListView(LazyStringArrayList paramLazyStringArrayList)
    {
      this.list = paramLazyStringArrayList;
    }
    
    public void add(int paramInt, ByteString paramByteString)
    {
      this.list.add(paramInt, paramByteString);
      this.modCount += 1;
    }
    
    public ByteString get(int paramInt)
    {
      return this.list.getByteString(paramInt);
    }
    
    public ByteString remove(int paramInt)
    {
      String str = this.list.remove(paramInt);
      this.modCount += 1;
      return LazyStringArrayList.asByteString(str);
    }
    
    public ByteString set(int paramInt, ByteString paramByteString)
    {
      paramByteString = this.list.setAndReturn(paramInt, paramByteString);
      this.modCount += 1;
      return LazyStringArrayList.asByteString(paramByteString);
    }
    
    public int size()
    {
      return this.list.size();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.LazyStringArrayList
 * JD-Core Version:    0.7.0.1
 */