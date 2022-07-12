package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class IntArrayList
  extends AbstractProtobufList<Integer>
  implements Internal.IntList, RandomAccess
{
  private static final IntArrayList EMPTY_LIST;
  private int[] array;
  private int size;
  
  static
  {
    IntArrayList localIntArrayList = new IntArrayList();
    EMPTY_LIST = localIntArrayList;
    localIntArrayList.makeImmutable();
  }
  
  IntArrayList()
  {
    this(new int[10], 0);
  }
  
  private IntArrayList(int[] paramArrayOfInt, int paramInt)
  {
    this.array = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void addInt(int paramInt1, int paramInt2)
  {
    ensureIsMutable();
    if (paramInt1 >= 0)
    {
      int i = this.size;
      if (paramInt1 <= i)
      {
        int[] arrayOfInt1 = this.array;
        if (i < arrayOfInt1.length)
        {
          System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt1, paramInt1 + 1, i - paramInt1);
        }
        else
        {
          int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
          System.arraycopy(this.array, paramInt1, arrayOfInt2, paramInt1 + 1, this.size - paramInt1);
          this.array = arrayOfInt2;
        }
        this.array[paramInt1] = paramInt2;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt1));
  }
  
  public static IntArrayList emptyList()
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
  
  public void add(int paramInt, Integer paramInteger)
  {
    addInt(paramInt, paramInteger.intValue());
  }
  
  public boolean addAll(Collection<? extends Integer> paramCollection)
  {
    ensureIsMutable();
    Objects.requireNonNull(paramCollection);
    if (!(paramCollection instanceof IntArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (IntArrayList)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (2147483647 - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = this.array;
      if (i > arrayOfInt.length) {
        this.array = Arrays.copyOf(arrayOfInt, i);
      }
      System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public void addInt(int paramInt)
  {
    addInt(this.size, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof IntArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (IntArrayList)paramObject;
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
  
  public Integer get(int paramInt)
  {
    return Integer.valueOf(getInt(paramInt));
  }
  
  public int getInt(int paramInt)
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
      j = j * 31 + this.array[i];
      i += 1;
    }
    return j;
  }
  
  public Internal.IntList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= this.size) {
      return new IntArrayList(Arrays.copyOf(this.array, paramInt), this.size);
    }
    throw new IllegalArgumentException();
  }
  
  public Integer remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt];
    System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Integer.valueOf(i);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Integer.valueOf(this.array[i])))
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
  
  public Integer set(int paramInt, Integer paramInteger)
  {
    return Integer.valueOf(setInt(paramInt, paramInteger.intValue()));
  }
  
  public int setInt(int paramInt1, int paramInt2)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt1);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = paramInt2;
    return i;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.IntArrayList
 * JD-Core Version:    0.7.0.1
 */