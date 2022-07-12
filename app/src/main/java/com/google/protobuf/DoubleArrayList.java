package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class DoubleArrayList
  extends AbstractProtobufList<Double>
  implements Internal.DoubleList, RandomAccess
{
  private static final DoubleArrayList EMPTY_LIST;
  private double[] array;
  private int size;
  
  static
  {
    DoubleArrayList localDoubleArrayList = new DoubleArrayList();
    EMPTY_LIST = localDoubleArrayList;
    localDoubleArrayList.makeImmutable();
  }
  
  DoubleArrayList()
  {
    this(new double[10], 0);
  }
  
  private DoubleArrayList(double[] paramArrayOfDouble, int paramInt)
  {
    this.array = paramArrayOfDouble;
    this.size = paramInt;
  }
  
  private void addDouble(int paramInt, double paramDouble)
  {
    ensureIsMutable();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        double[] arrayOfDouble1 = this.array;
        if (i < arrayOfDouble1.length)
        {
          System.arraycopy(arrayOfDouble1, paramInt, arrayOfDouble1, paramInt + 1, i - paramInt);
        }
        else
        {
          double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfDouble2, paramInt + 1, this.size - paramInt);
          this.array = arrayOfDouble2;
        }
        this.array[paramInt] = paramDouble;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static DoubleArrayList emptyList()
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
  
  public void add(int paramInt, Double paramDouble)
  {
    addDouble(paramInt, paramDouble.doubleValue());
  }
  
  public boolean addAll(Collection<? extends Double> paramCollection)
  {
    ensureIsMutable();
    Objects.requireNonNull(paramCollection);
    if (!(paramCollection instanceof DoubleArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (DoubleArrayList)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (2147483647 - j >= i)
    {
      i = j + i;
      double[] arrayOfDouble = this.array;
      if (i > arrayOfDouble.length) {
        this.array = Arrays.copyOf(arrayOfDouble, i);
      }
      System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public void addDouble(double paramDouble)
  {
    addDouble(this.size, paramDouble);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DoubleArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (DoubleArrayList)paramObject;
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
  
  public Double get(int paramInt)
  {
    return Double.valueOf(getDouble(paramInt));
  }
  
  public double getDouble(int paramInt)
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
      j = j * 31 + Internal.hashLong(Double.doubleToLongBits(this.array[i]));
      i += 1;
    }
    return j;
  }
  
  public Internal.DoubleList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= this.size) {
      return new DoubleArrayList(Arrays.copyOf(this.array, paramInt), this.size);
    }
    throw new IllegalArgumentException();
  }
  
  public Double remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    System.arraycopy(arrayOfDouble, paramInt + 1, arrayOfDouble, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Double.valueOf(d);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Double.valueOf(this.array[i])))
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
  
  public Double set(int paramInt, Double paramDouble)
  {
    return Double.valueOf(setDouble(paramInt, paramDouble.doubleValue()));
  }
  
  public double setDouble(int paramInt, double paramDouble)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    arrayOfDouble[paramInt] = paramDouble;
    return d;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.DoubleArrayList
 * JD-Core Version:    0.7.0.1
 */