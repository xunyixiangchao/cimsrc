package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final ByteBuffer EMPTY_BYTE_BUFFER;
  public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
  static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    EMPTY_BYTE_BUFFER = ByteBuffer.wrap(arrayOfByte);
    EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(arrayOfByte);
  }
  
  public static byte[] byteArrayDefaultValue(String paramString)
  {
    return paramString.getBytes(ISO_8859_1);
  }
  
  public static ByteBuffer byteBufferDefaultValue(String paramString)
  {
    return ByteBuffer.wrap(byteArrayDefaultValue(paramString));
  }
  
  public static ByteString bytesDefaultValue(String paramString)
  {
    return ByteString.copyFrom(paramString.getBytes(ISO_8859_1));
  }
  
  public static ByteBuffer copyByteBuffer(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.clear();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity());
    localByteBuffer.put(paramByteBuffer);
    localByteBuffer.clear();
    return localByteBuffer;
  }
  
  public static boolean equals(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean equalsByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if (paramByteBuffer1.capacity() != paramByteBuffer2.capacity()) {
      return false;
    }
    return paramByteBuffer1.duplicate().clear().equals(paramByteBuffer2.duplicate().clear());
  }
  
  public static boolean equalsByteBuffer(List<ByteBuffer> paramList1, List<ByteBuffer> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!equalsByteBuffer((ByteBuffer)paramList1.get(i), (ByteBuffer)paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static <T extends MessageLite> T getDefaultInstance(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getMethod("getDefaultInstance", new Class[0]);
      localObject = (MessageLite)((Method)localObject).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get default instance for ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
  
  public static int hashBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int hashCode(List<byte[]> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = i * 31 + hashCode((byte[])paramList.next())) {}
    return i;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    return hashCode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static int hashCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = partialHash(paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public static int hashCodeByteBuffer(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      i = partialHash(paramByteBuffer.capacity(), paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
      if (i == 0) {
        return 1;
      }
      return i;
    }
    int j = paramByteBuffer.capacity();
    int i = 4096;
    if (j <= 4096) {
      i = paramByteBuffer.capacity();
    }
    byte[] arrayOfByte = new byte[i];
    ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
    localByteBuffer.clear();
    int k;
    for (j = paramByteBuffer.capacity(); localByteBuffer.remaining() > 0; j = partialHash(j, arrayOfByte, 0, k))
    {
      if (localByteBuffer.remaining() <= i) {
        k = localByteBuffer.remaining();
      } else {
        k = i;
      }
      localByteBuffer.get(arrayOfByte, 0, k);
    }
    if (j == 0) {
      return 1;
    }
    return j;
  }
  
  public static int hashCodeByteBuffer(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = i * 31 + hashCodeByteBuffer((ByteBuffer)paramList.next())) {}
    return i;
  }
  
  public static int hashEnum(EnumLite paramEnumLite)
  {
    return paramEnumLite.getNumber();
  }
  
  public static int hashEnumList(List<? extends EnumLite> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = i * 31 + hashEnum((EnumLite)paramList.next())) {}
    return i;
  }
  
  public static int hashLong(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static boolean isValidUtf8(ByteString paramByteString)
  {
    return paramByteString.isValidUtf8();
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return Utf8.isValidUtf8(paramArrayOfByte);
  }
  
  static int partialHash(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  public static String stringDefaultValue(String paramString)
  {
    return new String(paramString.getBytes(ISO_8859_1), UTF_8);
  }
  
  public static byte[] toByteArray(String paramString)
  {
    return paramString.getBytes(UTF_8);
  }
  
  public static String toStringUtf8(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  public static abstract interface BooleanList
    extends Internal.ProtobufList<Boolean>
  {
    public abstract void addBoolean(boolean paramBoolean);
    
    public abstract boolean getBoolean(int paramInt);
    
    public abstract BooleanList mutableCopyWithCapacity(int paramInt);
    
    public abstract boolean setBoolean(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface DoubleList
    extends Internal.ProtobufList<Double>
  {
    public abstract void addDouble(double paramDouble);
    
    public abstract double getDouble(int paramInt);
    
    public abstract DoubleList mutableCopyWithCapacity(int paramInt);
    
    public abstract double setDouble(int paramInt, double paramDouble);
  }
  
  public static abstract interface EnumLite
  {
    public abstract int getNumber();
  }
  
  public static abstract interface EnumLiteMap<T extends Internal.EnumLite>
  {
    public abstract T findValueByNumber(int paramInt);
  }
  
  public static abstract interface FloatList
    extends Internal.ProtobufList<Float>
  {
    public abstract void addFloat(float paramFloat);
    
    public abstract float getFloat(int paramInt);
    
    public abstract FloatList mutableCopyWithCapacity(int paramInt);
    
    public abstract float setFloat(int paramInt, float paramFloat);
  }
  
  public static abstract interface IntList
    extends Internal.ProtobufList<Integer>
  {
    public abstract void addInt(int paramInt);
    
    public abstract int getInt(int paramInt);
    
    public abstract IntList mutableCopyWithCapacity(int paramInt);
    
    public abstract int setInt(int paramInt1, int paramInt2);
  }
  
  public static class ListAdapter<F, T>
    extends AbstractList<T>
  {
    private final Converter<F, T> converter;
    private final List<F> fromList;
    
    public ListAdapter(List<F> paramList, Converter<F, T> paramConverter)
    {
      this.fromList = paramList;
      this.converter = paramConverter;
    }
    
    public T get(int paramInt)
    {
      return this.converter.convert(this.fromList.get(paramInt));
    }
    
    public int size()
    {
      return this.fromList.size();
    }
    
    public static abstract interface Converter<F, T>
    {
      public abstract T convert(F paramF);
    }
  }
  
  public static abstract interface LongList
    extends Internal.ProtobufList<Long>
  {
    public abstract void addLong(long paramLong);
    
    public abstract long getLong(int paramInt);
    
    public abstract LongList mutableCopyWithCapacity(int paramInt);
    
    public abstract long setLong(int paramInt, long paramLong);
  }
  
  public static class MapAdapter<K, V, RealValue>
    extends AbstractMap<K, V>
  {
    private final Map<K, RealValue> realMap;
    private final Converter<RealValue, V> valueConverter;
    
    public MapAdapter(Map<K, RealValue> paramMap, Converter<RealValue, V> paramConverter)
    {
      this.realMap = paramMap;
      this.valueConverter = paramConverter;
    }
    
    public static <T extends Internal.EnumLite> Converter<Integer, T> newEnumConverter(Internal.EnumLiteMap<T> paramEnumLiteMap, final T paramT)
    {
      new Converter()
      {
        public Integer doBackward(T paramAnonymousT)
        {
          return Integer.valueOf(paramAnonymousT.getNumber());
        }
        
        public T doForward(Integer paramAnonymousInteger)
        {
          Internal.EnumLite localEnumLite = this.val$enumMap.findValueByNumber(paramAnonymousInteger.intValue());
          paramAnonymousInteger = localEnumLite;
          if (localEnumLite == null) {
            paramAnonymousInteger = paramT;
          }
          return paramAnonymousInteger;
        }
      };
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      return new SetAdapter(this.realMap.entrySet());
    }
    
    public V get(Object paramObject)
    {
      paramObject = this.realMap.get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return this.valueConverter.doForward(paramObject);
    }
    
    public V put(K paramK, V paramV)
    {
      paramK = this.realMap.put(paramK, this.valueConverter.doBackward(paramV));
      if (paramK == null) {
        return null;
      }
      return this.valueConverter.doForward(paramK);
    }
    
    public static abstract interface Converter<A, B>
    {
      public abstract A doBackward(B paramB);
      
      public abstract B doForward(A paramA);
    }
    
    private class EntryAdapter
      implements Map.Entry<K, V>
    {
      private final Map.Entry<K, RealValue> realEntry;
      
      public EntryAdapter()
      {
        Object localObject;
        this.realEntry = localObject;
      }
      
      public K getKey()
      {
        return this.realEntry.getKey();
      }
      
      public V getValue()
      {
        return Internal.MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
      }
      
      public V setValue(V paramV)
      {
        paramV = this.realEntry.setValue(Internal.MapAdapter.this.valueConverter.doBackward(paramV));
        if (paramV == null) {
          return null;
        }
        return Internal.MapAdapter.this.valueConverter.doForward(paramV);
      }
    }
    
    private class IteratorAdapter
      implements Iterator<Map.Entry<K, V>>
    {
      private final Iterator<Map.Entry<K, RealValue>> realIterator;
      
      public IteratorAdapter()
      {
        Object localObject;
        this.realIterator = localObject;
      }
      
      public boolean hasNext()
      {
        return this.realIterator.hasNext();
      }
      
      public Map.Entry<K, V> next()
      {
        return new Internal.MapAdapter.EntryAdapter(Internal.MapAdapter.this, (Map.Entry)this.realIterator.next());
      }
      
      public void remove()
      {
        this.realIterator.remove();
      }
    }
    
    private class SetAdapter
      extends AbstractSet<Map.Entry<K, V>>
    {
      private final Set<Map.Entry<K, RealValue>> realSet;
      
      public SetAdapter()
      {
        Object localObject;
        this.realSet = localObject;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return new Internal.MapAdapter.IteratorAdapter(Internal.MapAdapter.this, this.realSet.iterator());
      }
      
      public int size()
      {
        return this.realSet.size();
      }
    }
  }
  
  public static abstract interface ProtobufList<E>
    extends List<E>, RandomAccess
  {
    public abstract boolean isModifiable();
    
    public abstract void makeImmutable();
    
    public abstract ProtobufList<E> mutableCopyWithCapacity(int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.Internal
 * JD-Core Version:    0.7.0.1
 */