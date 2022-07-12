package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class FloatArrayList
  extends AbstractProtobufList<Float>
  implements Internal.FloatList, RandomAccess
{
  private static final FloatArrayList EMPTY_LIST;
  private float[] array;
  private int size;
  
  static
  {
    FloatArrayList localFloatArrayList = new FloatArrayList();
    EMPTY_LIST = localFloatArrayList;
    localFloatArrayList.makeImmutable();
  }
  
  FloatArrayList()
  {
    this(new float[10], 0);
  }
  
  private FloatArrayList(float[] paramArrayOfFloat, int paramInt)
  {
    this.array = paramArrayOfFloat;
    this.size = paramInt;
  }
  
  private void addFloat(int paramInt, float paramFloat)
  {
    ensureIsMutable();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        float[] arrayOfFloat1 = this.array;
        if (i < arrayOfFloat1.length)
        {
          System.arraycopy(arrayOfFloat1, paramInt, arrayOfFloat1, paramInt + 1, i - paramInt);
        }
        else
        {
          float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfFloat2, paramInt + 1, this.size - paramInt);
          this.array = arrayOfFloat2;
        }
        this.array[paramInt] = paramFloat;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static FloatArrayList emptyList()
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
  
  public void add(int paramInt, Float paramFloat)
  {
    addFloat(paramInt, paramFloat.floatValue());
  }
  
  public boolean addAll(Collection<? extends Float> paramCollection)
  {
    ensureIsMutable();
    Objects.requireNonNull(paramCollection);
    if (!(paramCollection instanceof FloatArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (FloatArrayList)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (2147483647 - j >= i)
    {
      i = j + i;
      float[] arrayOfFloat = this.array;
      if (i > arrayOfFloat.length) {
        this.array = Arrays.copyOf(arrayOfFloat, i);
      }
      System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public void addFloat(float paramFloat)
  {
    addFloat(this.size, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FloatArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (FloatArrayList)paramObject;
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
  
  public Float get(int paramInt)
  {
    return Float.valueOf(getFloat(paramInt));
  }
  
  public float getFloat(int paramInt)
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
      j = j * 31 + Float.floatToIntBits(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.FloatList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt >= this.size) {
      return new FloatArrayList(Arrays.copyOf(this.array, paramInt), this.size);
    }
    throw new IllegalArgumentException();
  }
  
  public Float remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Float.valueOf(f);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Float.valueOf(this.array[i])))
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
  
  public Float set(int paramInt, Float paramFloat)
  {
    return Float.valueOf(setFloat(paramInt, paramFloat.floatValue()));
  }
  
  public float setFloat(int paramInt, float paramFloat)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    arrayOfFloat[paramInt] = paramFloat;
    return f;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.FloatArrayList
 * JD-Core Version:    0.7.0.1
 */