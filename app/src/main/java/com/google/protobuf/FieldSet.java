package com.google.protobuf;

import TFieldDescriptorType;;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Objects;
import java.util.Set;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>>
{
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  private final SmallSortedMap<FieldDescriptorType, Object> fields;
  private boolean hasLazyField = false;
  private boolean isImmutable;
  
  private FieldSet()
  {
    this.fields = SmallSortedMap.newFieldMap(16);
  }
  
  private FieldSet(boolean paramBoolean)
  {
    this.fields = SmallSortedMap.newFieldMap(0);
    makeImmutable();
  }
  
  private void cloneFieldEntry(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    paramEntry = localObject;
    if ((localObject instanceof LazyField)) {
      paramEntry = ((LazyField)localObject).getValue();
    }
    paramMap.put(localFieldDescriptorLite, paramEntry);
  }
  
  private Object cloneIfMutable(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  static int computeElementSize(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    int i = CodedOutputStream.computeTagSize(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramInt = i * 2;
    }
    return paramInt + computeElementSizeNoTag(paramFieldType, paramObject);
  }
  
  static int computeElementSizeNoTag(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof Internal.EnumLite)) {
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)paramObject).getNumber());
      }
      return CodedOutputStream.computeEnumSizeNoTag(((Integer)paramObject).intValue());
    case 17: 
      return CodedOutputStream.computeSInt64SizeNoTag(((Long)paramObject).longValue());
    case 16: 
      return CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramObject).intValue());
    case 15: 
      return CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramObject).longValue());
    case 14: 
      return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramObject).intValue());
    case 13: 
      return CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
      }
      return CodedOutputStream.computeByteArraySizeNoTag((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
      }
      return CodedOutputStream.computeStringSizeNoTag((String)paramObject);
    case 10: 
      if ((paramObject instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)paramObject);
      }
      return CodedOutputStream.computeMessageSizeNoTag((MessageLite)paramObject);
    case 9: 
      return CodedOutputStream.computeGroupSizeNoTag((MessageLite)paramObject);
    case 8: 
      return CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramObject).booleanValue());
    case 7: 
      return CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputStream.computeFixed64SizeNoTag(((Long)paramObject).longValue());
    case 5: 
      return CodedOutputStream.computeInt32SizeNoTag(((Integer)paramObject).intValue());
    case 4: 
      return CodedOutputStream.computeUInt64SizeNoTag(((Long)paramObject).longValue());
    case 3: 
      return CodedOutputStream.computeInt64SizeNoTag(((Long)paramObject).longValue());
    case 2: 
      return CodedOutputStream.computeFloatSizeNoTag(((Float)paramObject).floatValue());
    }
    return CodedOutputStream.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
  }
  
  public static int computeFieldSize(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int k = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      boolean bool = paramFieldDescriptorLite.isPacked();
      int j = 0;
      int i = 0;
      paramFieldDescriptorLite = (List)paramObject;
      if (bool)
      {
        paramFieldDescriptorLite = paramFieldDescriptorLite.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        return CodedOutputStream.computeTagSize(k) + i + CodedOutputStream.computeRawVarint32Size(i);
      }
      paramFieldDescriptorLite = paramFieldDescriptorLite.iterator();
      i = j;
      while (paramFieldDescriptorLite.hasNext()) {
        i += computeElementSize(localFieldType, k, paramFieldDescriptorLite.next());
      }
      return i;
    }
    return computeElementSize(localFieldType, k, paramObject);
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet()
  {
    return DEFAULT_INSTANCE;
  }
  
  private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.isRepeated()) && (!localFieldDescriptorLite.isPacked()))
    {
      boolean bool = localObject instanceof LazyField;
      int i = ((FieldDescriptorLite)paramEntry.getKey()).getNumber();
      if (bool) {
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(i, (LazyField)localObject);
      }
      return CodedOutputStream.computeMessageSetExtensionSize(i, (MessageLite)localObject);
    }
    return computeFieldSize(localFieldDescriptorLite, localObject);
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.getWireType();
  }
  
  private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      boolean bool = localFieldDescriptorLite.isRepeated();
      paramEntry = paramEntry.getValue();
      if (bool)
      {
        paramEntry = ((List)paramEntry).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((MessageLite)paramEntry.next()).isInitialized());
        return false;
      }
      if ((paramEntry instanceof MessageLite))
      {
        if (!((MessageLite)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof LazyField)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private void mergeFromField(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof LazyField)) {
      paramEntry = ((LazyField)localObject1).getValue();
    }
    if (localFieldDescriptorLite.isRepeated())
    {
      localObject2 = getField(localFieldDescriptorLite);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(cloneIfMutable(localObject2));
      }
      this.fields.put(localFieldDescriptorLite, localObject1);
      return;
    }
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      localObject1 = getField(localFieldDescriptorLite);
      if (localObject1 != null)
      {
        localObject1 = localFieldDescriptorLite.internalMergeFrom(((MessageLite)localObject1).toBuilder(), (MessageLite)paramEntry).build();
        paramEntry = this.fields;
        break label196;
      }
    }
    Object localObject2 = this.fields;
    localObject1 = cloneIfMutable(paramEntry);
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject2;
    label196:
    paramEntry.put(localFieldDescriptorLite, localObject1);
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet()
  {
    return new FieldSet();
  }
  
  public static Object readPrimitiveField(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (WireFormat.Utf8Validation localUtf8Validation = WireFormat.Utf8Validation.STRICT;; localUtf8Validation = WireFormat.Utf8Validation.LOOSE) {
      return WireFormat.readPrimitiveField(paramCodedInputStream, paramFieldType, localUtf8Validation);
    }
  }
  
  private static void verifyType(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    int i = 1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramFieldType.getJavaType().ordinal()];
    boolean bool2 = true;
    boolean bool1 = false;
    switch (i)
    {
    default: 
      break;
    case 9: 
      bool1 = bool2;
      if (!(paramObject instanceof MessageLite)) {
        if ((paramObject instanceof LazyField)) {
          bool1 = bool2;
        }
      }
      break;
    case 8: 
      bool1 = bool2;
      if (!(paramObject instanceof Integer)) {
        if ((paramObject instanceof Internal.EnumLite)) {
          bool1 = bool2;
        }
      }
      break;
    case 7: 
      bool1 = bool2;
      if (!(paramObject instanceof ByteString)) {
        if ((paramObject instanceof byte[])) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      break;
    case 6: 
      bool1 = paramObject instanceof String;
      break;
    case 5: 
      bool1 = paramObject instanceof Boolean;
      break;
    case 4: 
      bool1 = paramObject instanceof Double;
      break;
    case 3: 
      bool1 = paramObject instanceof Float;
      break;
    case 2: 
      bool1 = paramObject instanceof Long;
      break;
    }
    bool1 = paramObject instanceof Integer;
    if (bool1) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  static void writeElement(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    if (paramFieldType == WireFormat.FieldType.GROUP)
    {
      paramCodedOutputStream.writeGroup(paramInt, (MessageLite)paramObject);
      return;
    }
    paramCodedOutputStream.writeTag(paramInt, getWireFormatForFieldType(paramFieldType, false));
    writeElementNoTag(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  static void writeElementNoTag(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()])
    {
    default: 
      return;
    case 18: 
      int i;
      if ((paramObject instanceof Internal.EnumLite)) {
        i = ((Internal.EnumLite)paramObject).getNumber();
      } else {
        i = ((Integer)paramObject).intValue();
      }
      paramCodedOutputStream.writeEnumNoTag(i);
      return;
    case 17: 
      paramCodedOutputStream.writeSInt64NoTag(((Long)paramObject).longValue());
      return;
    case 16: 
      paramCodedOutputStream.writeSInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramCodedOutputStream.writeSFixed64NoTag(((Long)paramObject).longValue());
      return;
    case 14: 
      paramCodedOutputStream.writeSFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramCodedOutputStream.writeUInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 12: 
      if (!(paramObject instanceof ByteString))
      {
        paramCodedOutputStream.writeByteArrayNoTag((byte[])paramObject);
        return;
      }
    case 11: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.writeStringNoTag((String)paramObject);
      return;
    case 10: 
      paramCodedOutputStream.writeMessageNoTag((MessageLite)paramObject);
      return;
    case 9: 
      paramCodedOutputStream.writeGroupNoTag((MessageLite)paramObject);
      return;
    case 8: 
      paramCodedOutputStream.writeBoolNoTag(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramCodedOutputStream.writeFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramCodedOutputStream.writeFixed64NoTag(((Long)paramObject).longValue());
      return;
    case 5: 
      paramCodedOutputStream.writeInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramCodedOutputStream.writeUInt64NoTag(((Long)paramObject).longValue());
      return;
    case 3: 
      paramCodedOutputStream.writeInt64NoTag(((Long)paramObject).longValue());
      return;
    case 2: 
      paramCodedOutputStream.writeFloatNoTag(((Float)paramObject).floatValue());
      return;
    }
    paramCodedOutputStream.writeDoubleNoTag(((Double)paramObject).doubleValue());
  }
  
  public static void writeField(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      paramObject = (List)paramObject;
      if (paramFieldDescriptorLite.isPacked())
      {
        paramCodedOutputStream.writeTag(i, 2);
        i = 0;
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        paramCodedOutputStream.writeRawVarint32(i);
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          writeElementNoTag(paramCodedOutputStream, localFieldType, paramFieldDescriptorLite.next());
        }
      }
      paramFieldDescriptorLite = paramObject.iterator();
      while (paramFieldDescriptorLite.hasNext()) {
        writeElement(paramCodedOutputStream, localFieldType, i, paramFieldDescriptorLite.next());
      }
    }
    if ((paramObject instanceof LazyField))
    {
      writeElement(paramCodedOutputStream, localFieldType, i, ((LazyField)paramObject).getValue());
      return;
    }
    writeElement(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> paramEntry, CodedOutputStream paramCodedOutputStream)
  {
    Object localObject1 = (FieldDescriptorLite)paramEntry.getKey();
    if ((((FieldDescriptorLite)localObject1).getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!((FieldDescriptorLite)localObject1).isRepeated()) && (!((FieldDescriptorLite)localObject1).isPacked()))
    {
      Object localObject2 = paramEntry.getValue();
      localObject1 = localObject2;
      if ((localObject2 instanceof LazyField)) {
        localObject1 = ((LazyField)localObject2).getValue();
      }
      paramCodedOutputStream.writeMessageSetExtension(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (MessageLite)localObject1);
      return;
    }
    writeField((FieldDescriptorLite)localObject1, paramEntry.getValue(), paramCodedOutputStream);
  }
  
  public void addRepeatedField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
      Object localObject = getField(paramFieldDescriptorType);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.fields.put(paramFieldDescriptorType, localObject);
        paramFieldDescriptorType = (TFieldDescriptorType)localObject;
      }
      else
      {
        paramFieldDescriptorType = (List)localObject;
      }
      paramFieldDescriptorType.add(paramObject);
      return;
    }
    throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
  }
  
  public void clear()
  {
    this.fields.clear();
    this.hasLazyField = false;
  }
  
  public void clearField(FieldDescriptorType paramFieldDescriptorType)
  {
    this.fields.remove(paramFieldDescriptorType);
    if (this.fields.isEmpty()) {
      this.hasLazyField = false;
    }
  }
  
  public FieldSet<FieldDescriptorType> clone()
  {
    FieldSet localFieldSet = newFieldSet();
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(i);
      localFieldSet.setField((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localFieldSet.setField((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    localFieldSet.hasLazyField = this.hasLazyField;
    return localFieldSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FieldSet)) {
      return false;
    }
    paramObject = (FieldSet)paramObject;
    return this.fields.equals(paramObject.fields);
  }
  
  public Map<FieldDescriptorType, Object> getAllFields()
  {
    if (this.hasLazyField)
    {
      SmallSortedMap localSmallSortedMap = SmallSortedMap.newFieldMap(16);
      int i = 0;
      while (i < this.fields.getNumArrayEntries())
      {
        cloneFieldEntry(localSmallSortedMap, this.fields.getArrayEntryAt(i));
        i += 1;
      }
      Iterator localIterator = this.fields.getOverflowEntries().iterator();
      while (localIterator.hasNext()) {
        cloneFieldEntry(localSmallSortedMap, (Map.Entry)localIterator.next());
      }
      if (this.fields.isImmutable()) {
        localSmallSortedMap.makeImmutable();
      }
      return localSmallSortedMap;
    }
    if (this.fields.isImmutable()) {
      return this.fields;
    }
    return Collections.unmodifiableMap(this.fields);
  }
  
  public Object getField(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.fields.get(paramFieldDescriptorType);
    paramFieldDescriptorType = localObject;
    if ((localObject instanceof LazyField)) {
      paramFieldDescriptorType = ((LazyField)localObject).getValue();
    }
    return paramFieldDescriptorType;
  }
  
  public int getMessageSetSerializedSize()
  {
    int j = 0;
    int i = 0;
    while (j < this.fields.getNumArrayEntries())
    {
      i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(j));
      j += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      i += getMessageSetSerializedSize((Map.Entry)localIterator.next());
    }
    return i;
  }
  
  public Object getRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      paramFieldDescriptorType = getField(paramFieldDescriptorType);
      if (paramFieldDescriptorType != null) {
        return ((List)paramFieldDescriptorType).get(paramInt);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getRepeatedFieldCount(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      paramFieldDescriptorType = getField(paramFieldDescriptorType);
      if (paramFieldDescriptorType == null) {
        return 0;
      }
      return ((List)paramFieldDescriptorType).size();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    int i = 0;
    while (j < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(j);
      i += computeFieldSize((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += computeFieldSize((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public boolean hasField(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      return this.fields.get(paramFieldDescriptorType) != null;
    }
    throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
  }
  
  public int hashCode()
  {
    return this.fields.hashCode();
  }
  
  public boolean isImmutable()
  {
    return this.isImmutable;
  }
  
  public boolean isInitialized()
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      if (!isInitialized(this.fields.getArrayEntryAt(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      if (!isInitialized((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.hasLazyField) {
      return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    }
    return this.fields.entrySet().iterator();
  }
  
  public void makeImmutable()
  {
    if (this.isImmutable) {
      return;
    }
    this.fields.makeImmutable();
    this.isImmutable = true;
  }
  
  public void mergeFrom(FieldSet<FieldDescriptorType> paramFieldSet)
  {
    int i = 0;
    while (i < paramFieldSet.fields.getNumArrayEntries())
    {
      mergeFromField(paramFieldSet.fields.getArrayEntryAt(i));
      i += 1;
    }
    paramFieldSet = paramFieldSet.fields.getOverflowEntries().iterator();
    while (paramFieldSet.hasNext()) {
      mergeFromField((Map.Entry)paramFieldSet.next());
    }
  }
  
  public void setField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        paramObject = localArrayList.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          verifyType(paramFieldDescriptorType.getLiteType(), localObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    }
    if ((paramObject instanceof LazyField)) {
      this.hasLazyField = true;
    }
    this.fields.put(paramFieldDescriptorType, paramObject);
  }
  
  public void setRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      Object localObject = getField(paramFieldDescriptorType);
      if (localObject != null)
      {
        verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
        ((List)localObject).set(paramInt, paramObject);
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public void writeMessageSetTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      writeMessageSetTo(this.fields.getArrayEntryAt(i), paramCodedOutputStream);
      i += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      writeMessageSetTo((Map.Entry)localIterator.next(), paramCodedOutputStream);
    }
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(i);
      writeField((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue(), paramCodedOutputStream);
      i += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      writeField((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue(), paramCodedOutputStream);
    }
  }
  
  public static abstract interface FieldDescriptorLite<T extends FieldDescriptorLite<T>>
    extends Comparable<T>
  {
    public abstract Internal.EnumLiteMap<?> getEnumType();
    
    public abstract WireFormat.JavaType getLiteJavaType();
    
    public abstract WireFormat.FieldType getLiteType();
    
    public abstract int getNumber();
    
    public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
    
    public abstract boolean isPacked();
    
    public abstract boolean isRepeated();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.FieldSet
 * JD-Core Version:    0.7.0.1
 */