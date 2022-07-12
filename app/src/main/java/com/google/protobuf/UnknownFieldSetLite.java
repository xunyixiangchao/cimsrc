package com.google.protobuf;

import java.util.Arrays;

public final class UnknownFieldSetLite
{
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  private static final int MIN_CAPACITY = 8;
  private int count;
  private boolean isMutable;
  private int memoizedSerializedSize = -1;
  private Object[] objects;
  private int[] tags;
  
  private UnknownFieldSetLite()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.tags = paramArrayOfInt;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  private void ensureCapacity()
  {
    int j = this.count;
    int[] arrayOfInt = this.tags;
    if (j == arrayOfInt.length)
    {
      if (j < 4) {
        i = 8;
      } else {
        i = j >> 1;
      }
      int i = j + i;
      this.tags = Arrays.copyOf(arrayOfInt, i);
      this.objects = Arrays.copyOf(this.objects, i);
    }
  }
  
  public static UnknownFieldSetLite getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream)
  {
    int i;
    do
    {
      i = paramCodedInputStream.readTag();
    } while ((i != 0) && (mergeFieldFrom(i, paramCodedInputStream)));
    return this;
  }
  
  static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
  {
    int i = paramUnknownFieldSetLite1.count + paramUnknownFieldSetLite2.count;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.tags, i);
    System.arraycopy(paramUnknownFieldSetLite2.tags, 0, arrayOfInt, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.objects, i);
    System.arraycopy(paramUnknownFieldSetLite2.objects, 0, arrayOfObject, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  static UnknownFieldSetLite newInstance()
  {
    return new UnknownFieldSetLite();
  }
  
  private void storeField(int paramInt, Object paramObject)
  {
    ensureCapacity();
    int[] arrayOfInt = this.tags;
    int i = this.count;
    arrayOfInt[i] = paramInt;
    this.objects[i] = paramObject;
    this.count = (i + 1);
  }
  
  void checkMutable()
  {
    if (this.isMutable) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof UnknownFieldSetLite)) {
      return false;
    }
    paramObject = (UnknownFieldSetLite)paramObject;
    if ((this.count == paramObject.count) && (Arrays.equals(this.tags, paramObject.tags))) {
      return Arrays.deepEquals(this.objects, paramObject.objects);
    }
    return false;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.count)
    {
      int m = this.tags[j];
      i = WireFormat.getTagFieldNumber(m);
      m = WireFormat.getTagWireType(m);
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 5) {
                i = CodedOutputStream.computeFixed32Size(i, ((Integer)this.objects[j]).intValue());
              } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
              }
            }
            else {
              i = CodedOutputStream.computeTagSize(i) * 2 + ((UnknownFieldSetLite)this.objects[j]).getSerializedSize();
            }
          }
          else {
            i = CodedOutputStream.computeBytesSize(i, (ByteString)this.objects[j]);
          }
        }
        else {
          i = CodedOutputStream.computeFixed64Size(i, ((Long)this.objects[j]).longValue());
        }
      }
      else {
        i = CodedOutputStream.computeUInt64Size(i, ((Long)this.objects[j]).longValue());
      }
      k += i;
      j += 1;
    }
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public int hashCode()
  {
    return ((527 + this.count) * 31 + Arrays.hashCode(this.tags)) * 31 + Arrays.deepHashCode(this.objects);
  }
  
  public void makeImmutable()
  {
    this.isMutable = false;
  }
  
  boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream)
  {
    checkMutable();
    int i = WireFormat.getTagFieldNumber(paramInt);
    int j = WireFormat.getTagWireType(paramInt);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5)
              {
                storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          UnknownFieldSetLite localUnknownFieldSetLite = new UnknownFieldSetLite();
          localUnknownFieldSetLite.mergeFrom(paramCodedInputStream);
          paramCodedInputStream.checkLastTagWas(WireFormat.makeTag(i, 4));
          storeField(paramInt, localUnknownFieldSetLite);
          return true;
        }
        storeField(paramInt, paramCodedInputStream.readBytes());
        return true;
      }
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
      return true;
    }
    storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
    return true;
  }
  
  UnknownFieldSetLite mergeLengthDelimitedField(int paramInt, ByteString paramByteString)
  {
    checkMutable();
    if (paramInt != 0)
    {
      storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
      return this;
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  UnknownFieldSetLite mergeVarintField(int paramInt1, int paramInt2)
  {
    checkMutable();
    if (paramInt1 != 0)
    {
      storeField(WireFormat.makeTag(paramInt1, 0), Long.valueOf(paramInt2));
      return this;
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.count)
    {
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i])), this.objects[i]);
      i += 1;
    }
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.count)
    {
      int k = this.tags[i];
      int j = WireFormat.getTagFieldNumber(k);
      k = WireFormat.getTagWireType(k);
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k == 5) {
                paramCodedOutputStream.writeFixed32(j, ((Integer)this.objects[i]).intValue());
              } else {
                throw InvalidProtocolBufferException.invalidWireType();
              }
            }
            else
            {
              paramCodedOutputStream.writeTag(j, 3);
              ((UnknownFieldSetLite)this.objects[i]).writeTo(paramCodedOutputStream);
              paramCodedOutputStream.writeTag(j, 4);
            }
          }
          else {
            paramCodedOutputStream.writeBytes(j, (ByteString)this.objects[i]);
          }
        }
        else {
          paramCodedOutputStream.writeFixed64(j, ((Long)this.objects[i]).longValue());
        }
      }
      else {
        paramCodedOutputStream.writeUInt64(j, ((Long)this.objects[i]).longValue());
      }
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.UnknownFieldSetLite
 * JD-Core Version:    0.7.0.1
 */