package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class LongArrayList
  extends AbstractProtobufList<Long>
  implements Internal.LongList, RandomAccess
{
  private static final LongArrayList EMPTY_LIST;
  private long[] array;
  private int size;
  
  static
  {
    LongArrayList localLongArrayList = new LongArrayList();
    EMPTY_LIST = localLongArrayList;
    localLongArrayList.makeImmutable();
  }
  
  LongArrayList()
  {
    this(new long[10], 0);
  }
  
  private LongArrayList(long[] paramArrayOfLong, int paramInt)
  {
    this.array = paramArrayOfLong;
    this.size = paramInt;
  }
  
  private void addLong(int paramInt, long paramLong)
  {
    ensureIsMutable();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        long[] arrayOfLong1 = this.array;
        if (i < arrayOfLong1.length)
        {
          System.arraycopy(arrayOfLong1, paramInt, arrayOfLong1, paramInt + 1, i - paramInt);
        }
        else
        {
          long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfLong2, paramInt + 1, this.size - paramInt);
          this.array = arrayOfLong2;
        }
        this.array[paramInt] = paramLong;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static LongArrayList emptyList()
  {
    return EMPTY_LIST;
  }
  
  private void ensureIndexInRange(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return;
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  private String makeOutOfBoundsExceptionMessage(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(this.size);
    return localStringBuilder.toString();
  }
  
  public void add(int paramInt, Long paramLong)
  {
    addLong(paramInt, paramLong.longValue());
  }
  
  public boolean addAll(Collection<? extends Long> paramCollection)
  {
    ensureIsMutable();
    Objects.requireNonNull(paramCollection);
    if (!(paramCollection instanceof LongArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (LongArrayList)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (2147483647 - j >= i)
    {
      i = j + i;
      long[] arrayOfLong = this.array;
      if (i > arrayOfLong.length) {
        this.array = Arrays.copyOf(arrayOfLong, i);
      }
      System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public void addLong(long paramLong)
  {
    addLong(this.size, paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LongArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (LongArrayList)paramObject;
    if (this.size != paramObject.size) {
      return false;
    }
    paramObject = paramObject.array;
    int i = 0;
    while (i < this.size)
    {
      if (this.array[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Long get(int paramInt)
  {
    return Long.valueOf(getLong(paramInt));
  }
  
  public long getLong(int paramInt)
  {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + Internal.hashLong(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.LongList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= this.size) {
      return new LongArrayList(Arrays.copyOf(this.array, paramInt), this.size);
    }
    throw new IllegalArgumentException();
  }
  
  public Long remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Long.valueOf(l);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Long.valueOf(this.array[i])))
      {
        paramObject = this.array;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public Long set(int paramInt, Long paramLong)
  {
    return Long.valueOf(setLong(paramInt, paramLong.longValue()));
  }
  
  public long setLong(int paramInt, long paramLong)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    arrayOfLong[paramInt] = paramLong;
    return l;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.LongArrayList
 * JD-Core Version:    0.7.0.1
 */