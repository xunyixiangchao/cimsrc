package com.google.protobuf;

import java.util.Objects;

public class LazyFieldLite
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  private ByteString delayedBytes;
  private ExtensionRegistryLite extensionRegistry;
  private volatile ByteString memoizedBytes;
  protected volatile MessageLite value;
  
  public LazyFieldLite() {}
  
  public LazyFieldLite(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.extensionRegistry = paramExtensionRegistryLite;
    this.delayedBytes = paramByteString;
  }
  
  private static void checkArguments(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    Objects.requireNonNull(paramExtensionRegistryLite, "found null ExtensionRegistry");
    Objects.requireNonNull(paramByteString, "found null ByteString");
  }
  
  public static LazyFieldLite fromValue(MessageLite paramMessageLite)
  {
    LazyFieldLite localLazyFieldLite = new LazyFieldLite();
    localLazyFieldLite.setValue(paramMessageLite);
    return localLazyFieldLite;
  }
  
  private static MessageLite mergeValueAndBytes(MessageLite paramMessageLite, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramByteString = paramMessageLite.toBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite).build();
      return paramByteString;
    }
    catch (InvalidProtocolBufferException paramByteString) {}
    return paramMessageLite;
  }
  
  public void clear()
  {
    this.delayedBytes = null;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public boolean containsDefaultInstance()
  {
    ByteString localByteString2 = this.memoizedBytes;
    ByteString localByteString1 = ByteString.EMPTY;
    if (localByteString2 != localByteString1) {
      if (this.value == null)
      {
        localByteString2 = this.delayedBytes;
        if ((localByteString2 == null) || (localByteString2 == localByteString1)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  protected void ensureInitialized(MessageLite paramMessageLite)
  {
    if (this.value != null) {
      return;
    }
    ByteString localByteString;
    label58:
    label78:
    label90:
    try
    {
      if (this.value != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.delayedBytes != null)
      {
        this.value = ((MessageLite)paramMessageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry));
        localByteString = this.delayedBytes;
        this.memoizedBytes = localByteString;
        break label90;
      }
      this.value = paramMessageLite;
      localByteString = ByteString.EMPTY;
      break label58;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      break label78;
    }
    this.value = paramMessageLite;
    this.memoizedBytes = ByteString.EMPTY;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LazyFieldLite)) {
      return false;
    }
    paramObject = (LazyFieldLite)paramObject;
    MessageLite localMessageLite1 = this.value;
    MessageLite localMessageLite2 = paramObject.value;
    if ((localMessageLite1 == null) && (localMessageLite2 == null)) {
      return toByteString().equals(paramObject.toByteString());
    }
    if ((localMessageLite1 != null) && (localMessageLite2 != null)) {
      return localMessageLite1.equals(localMessageLite2);
    }
    if (localMessageLite1 != null) {
      return localMessageLite1.equals(paramObject.getValue(localMessageLite1.getDefaultInstanceForType()));
    }
    return getValue(localMessageLite2.getDefaultInstanceForType()).equals(localMessageLite2);
  }
  
  public int getSerializedSize()
  {
    if (this.memoizedBytes != null) {
      return this.memoizedBytes.size();
    }
    ByteString localByteString = this.delayedBytes;
    if (localByteString != null) {
      return localByteString.size();
    }
    if (this.value != null) {
      return this.value.getSerializedSize();
    }
    return 0;
  }
  
  public MessageLite getValue(MessageLite paramMessageLite)
  {
    ensureInitialized(paramMessageLite);
    return this.value;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public void merge(LazyFieldLite paramLazyFieldLite)
  {
    if (paramLazyFieldLite.containsDefaultInstance()) {
      return;
    }
    if (containsDefaultInstance())
    {
      set(paramLazyFieldLite);
      return;
    }
    if (this.extensionRegistry == null) {
      this.extensionRegistry = paramLazyFieldLite.extensionRegistry;
    }
    ByteString localByteString1 = this.delayedBytes;
    if (localByteString1 != null)
    {
      ByteString localByteString2 = paramLazyFieldLite.delayedBytes;
      if (localByteString2 != null)
      {
        this.delayedBytes = localByteString1.concat(localByteString2);
        return;
      }
    }
    if ((this.value == null) && (paramLazyFieldLite.value != null))
    {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
      return;
    }
    if ((this.value != null) && (paramLazyFieldLite.value == null))
    {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.delayedBytes, paramLazyFieldLite.extensionRegistry));
      return;
    }
    if (paramLazyFieldLite.extensionRegistry != null)
    {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), paramLazyFieldLite.extensionRegistry));
      return;
    }
    if (this.extensionRegistry != null)
    {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, toByteString(), this.extensionRegistry));
      return;
    }
    setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), EMPTY_REGISTRY));
  }
  
  public void mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (containsDefaultInstance()) {
      paramCodedInputStream = paramCodedInputStream.readBytes();
    }
    for (;;)
    {
      setByteString(paramCodedInputStream, paramExtensionRegistryLite);
      return;
      if (this.extensionRegistry == null) {
        this.extensionRegistry = paramExtensionRegistryLite;
      }
      ByteString localByteString = this.delayedBytes;
      if (localByteString == null) {
        break;
      }
      paramCodedInputStream = localByteString.concat(paramCodedInputStream.readBytes());
      paramExtensionRegistryLite = this.extensionRegistry;
    }
    try
    {
      setValue(this.value.toBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).build());
      return;
    }
    catch (InvalidProtocolBufferException paramCodedInputStream) {}
  }
  
  public void set(LazyFieldLite paramLazyFieldLite)
  {
    this.delayedBytes = paramLazyFieldLite.delayedBytes;
    this.value = paramLazyFieldLite.value;
    this.memoizedBytes = paramLazyFieldLite.memoizedBytes;
    paramLazyFieldLite = paramLazyFieldLite.extensionRegistry;
    if (paramLazyFieldLite != null) {
      this.extensionRegistry = paramLazyFieldLite;
    }
  }
  
  public void setByteString(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.delayedBytes = paramByteString;
    this.extensionRegistry = paramExtensionRegistryLite;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public MessageLite setValue(MessageLite paramMessageLite)
  {
    MessageLite localMessageLite = this.value;
    this.delayedBytes = null;
    this.memoizedBytes = null;
    this.value = paramMessageLite;
    return localMessageLite;
  }
  
  public ByteString toByteString()
  {
    if (this.memoizedBytes != null) {
      return this.memoizedBytes;
    }
    ByteString localByteString = this.delayedBytes;
    if (localByteString != null) {
      return localByteString;
    }
    try
    {
      if (this.memoizedBytes != null)
      {
        localByteString = this.memoizedBytes;
        return localByteString;
      }
      if (this.value == null) {}
      for (localByteString = ByteString.EMPTY;; localByteString = this.value.toByteString())
      {
        this.memoizedBytes = localByteString;
        break;
      }
      localByteString = this.memoizedBytes;
      return localByteString;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.LazyFieldLite
 * JD-Core Version:    0.7.0.1
 */