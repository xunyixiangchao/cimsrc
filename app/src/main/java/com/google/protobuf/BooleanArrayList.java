package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class BooleanArrayList
  extends AbstractProtobufList<Boolean>
  implements Internal.BooleanList, RandomAccess
{
  private static final BooleanArrayList EMPTY_LIST;
  private boolean[] array;
  private int size;
  
  static
  {
    BooleanArrayList localBooleanArrayList = new BooleanArrayList();
    EMPTY_LIST = localBooleanArrayList;
    localBooleanArrayList.makeImmutable();
  }
  
  BooleanArrayList()
  {
    this(new boolean[10], 0);
  }
  
  private BooleanArrayList(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.array = paramArrayOfBoolean;
    this.size = paramInt;
  }
  
  private void addBoolean(int paramInt, boolean paramBoolean)
  {
    ensureIsMutable();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        boolean[] arrayOfBoolean1 = this.array;
        if (i < arrayOfBoolean1.length)
        {
          System.arraycopy(arrayOfBoolean1, paramInt, arrayOfBoolean1, paramInt + 1, i - paramInt);
        }
        else
        {
          boolean[] arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfBoolean2, paramInt + 1, this.size - paramInt);
          this.array = arrayOfBoolean2;
        }
        this.array[paramInt] = paramBoolean;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static BooleanArrayList emptyList()
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
  
  public void add(int paramInt, Boolean paramBoolean)
  {
    addBoolean(paramInt, paramBoolean.booleanValue());
  }
  
  public boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    ensureIsMutable();
    Objects.requireNonNull(paramCollection);
    if (!(paramCollection instanceof BooleanArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (BooleanArrayList)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (2147483647 - j >= i)
    {
      i = j + i;
      boolean[] arrayOfBoolean = this.array;
      if (i > arrayOfBoolean.length) {
        this.array = Arrays.copyOf(arrayOfBoolean, i);
      }
      System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public void addBoolean(boolean paramBoolean)
  {
    addBoolean(this.size, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BooleanArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (BooleanArrayList)paramObject;
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
  
  public Boolean get(int paramInt)
  {
    return Boolean.valueOf(getBoolean(paramInt));
  }
  
  public boolean getBoolean(int paramInt)
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
      j = j * 31 + Internal.hashBoolean(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.BooleanList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= this.size) {
      return new BooleanArrayList(Arrays.copyOf(this.array, paramInt), this.size);
    }
    throw new IllegalArgumentException();
  }
  
  public Boolean remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    int i = arrayOfBoolean[paramInt];
    System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Boolean.valueOf(i);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Boolean.valueOf(this.array[i])))
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
  
  public Boolean set(int paramInt, Boolean paramBoolean)
  {
    return Boolean.valueOf(setBoolean(paramInt, paramBoolean.booleanValue()));
  }
  
  public boolean setBoolean(int paramInt, boolean paramBoolean)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    int i = arrayOfBoolean[paramInt];
    arrayOfBoolean[paramInt] = paramBoolean;
    return i;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.BooleanArrayList
 * JD-Core Version:    0.7.0.1
 */