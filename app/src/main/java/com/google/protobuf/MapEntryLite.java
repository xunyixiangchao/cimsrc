package com.google.protobuf;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class MapEntryLite<K, V>
{
  private static final int KEY_FIELD_NUMBER = 1;
  private static final int VALUE_FIELD_NUMBER = 2;
  private final K key;
  private final Metadata<K, V> metadata;
  private final V value;
  
  private MapEntryLite(Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    this.metadata = paramMetadata;
    this.key = paramK;
    this.value = paramV;
  }
  
  private MapEntryLite(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    this.metadata = new Metadata(paramFieldType1, paramK, paramFieldType2, paramV);
    this.key = paramK;
    this.value = paramV;
  }
  
  static <K, V> int computeSerializedSize(Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    return FieldSet.computeElementSize(paramMetadata.keyType, 1, paramK) + FieldSet.computeElementSize(paramMetadata.valueType, 2, paramV);
  }
  
  public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    return new MapEntryLite(paramFieldType1, paramK, paramFieldType2, paramV);
  }
  
  static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream paramCodedInputStream, Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    Object localObject2 = paramMetadata.defaultKey;
    Object localObject1 = paramMetadata.defaultValue;
    int i;
    do
    {
      for (;;)
      {
        i = paramCodedInputStream.readTag();
        if (i == 0) {
          break label94;
        }
        if (i == WireFormat.makeTag(1, paramMetadata.keyType.getWireType()))
        {
          localObject2 = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.keyType, localObject2);
        }
        else
        {
          if (i != WireFormat.makeTag(2, paramMetadata.valueType.getWireType())) {
            break;
          }
          localObject1 = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.valueType, localObject1);
        }
      }
    } while (paramCodedInputStream.skipField(i));
    label94:
    return new AbstractMap.SimpleImmutableEntry(localObject2, localObject1);
  }
  
  static <T> T parseField(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, WireFormat.FieldType paramFieldType, T paramT)
  {
    int i = 1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return FieldSet.readPrimitiveField(paramCodedInputStream, paramFieldType, true);
        }
        throw new RuntimeException("Groups are not allowed in maps.");
      }
      return Integer.valueOf(paramCodedInputStream.readEnum());
    }
    paramFieldType = ((MessageLite)paramT).toBuilder();
    paramCodedInputStream.readMessage(paramFieldType, paramExtensionRegistryLite);
    return paramFieldType.buildPartial();
  }
  
  static <K, V> void writeTo(CodedOutputStream paramCodedOutputStream, Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.keyType, 1, paramK);
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.valueType, 2, paramV);
  }
  
  public int computeMessageSize(int paramInt, K paramK, V paramV)
  {
    return CodedOutputStream.computeTagSize(paramInt) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, paramK, paramV));
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public Map.Entry<K, V> parseEntry(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return parseEntry(paramByteString.newCodedInput(), this.metadata, paramExtensionRegistryLite);
  }
  
  public void parseInto(MapFieldLite<K, V> paramMapFieldLite, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
    Object localObject2 = this.metadata;
    Object localObject1 = ((Metadata)localObject2).defaultKey;
    localObject2 = ((Metadata)localObject2).defaultValue;
    int j;
    do
    {
      for (;;)
      {
        j = paramCodedInputStream.readTag();
        if (j == 0) {
          break label129;
        }
        if (j == WireFormat.makeTag(1, this.metadata.keyType.getWireType()))
        {
          localObject1 = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.keyType, localObject1);
        }
        else
        {
          if (j != WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
            break;
          }
          localObject2 = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.valueType, localObject2);
        }
      }
    } while (paramCodedInputStream.skipField(j));
    label129:
    paramCodedInputStream.checkLastTagWas(0);
    paramCodedInputStream.popLimit(i);
    paramMapFieldLite.put(localObject1, localObject2);
  }
  
  public void serializeTo(CodedOutputStream paramCodedOutputStream, int paramInt, K paramK, V paramV)
  {
    paramCodedOutputStream.writeTag(paramInt, 2);
    paramCodedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, paramK, paramV));
    writeTo(paramCodedOutputStream, this.metadata, paramK, paramV);
  }
  
  static class Metadata<K, V>
  {
    public final K defaultKey;
    public final V defaultValue;
    public final WireFormat.FieldType keyType;
    public final WireFormat.FieldType valueType;
    
    public Metadata(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
    {
      this.keyType = paramFieldType1;
      this.defaultKey = paramK;
      this.valueType = paramFieldType2;
      this.defaultValue = paramV;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.MapEntryLite
 * JD-Core Version:    0.7.0.1
 */