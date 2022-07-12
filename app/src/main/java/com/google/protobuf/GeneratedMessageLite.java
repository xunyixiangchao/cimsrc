package com.google.protobuf;

import TMessageType;;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
  extends AbstractMessageLite<MessageType, BuilderType>
{
  protected int memoizedSerializedSize = -1;
  protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();
  
  private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> paramExtensionLite)
  {
    if (paramExtensionLite.isLite()) {
      return (GeneratedExtension)paramExtensionLite;
    }
    throw new IllegalArgumentException("Expected a lite extension.");
  }
  
  private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T paramT)
  {
    if (paramT != null)
    {
      if (paramT.isInitialized()) {
        return paramT;
      }
      throw paramT.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(paramT);
    }
    return paramT;
  }
  
  protected static Internal.BooleanList emptyBooleanList()
  {
    return BooleanArrayList.emptyList();
  }
  
  protected static Internal.DoubleList emptyDoubleList()
  {
    return DoubleArrayList.emptyList();
  }
  
  protected static Internal.FloatList emptyFloatList()
  {
    return FloatArrayList.emptyList();
  }
  
  protected static Internal.IntList emptyIntList()
  {
    return IntArrayList.emptyList();
  }
  
  protected static Internal.LongList emptyLongList()
  {
    return LongArrayList.emptyList();
  }
  
  protected static <E> Internal.ProtobufList<E> emptyProtobufList()
  {
    return ProtobufArrayList.emptyList();
  }
  
  private final void ensureUnknownFieldsInitialized()
  {
    if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
      this.unknownFields = UnknownFieldSetLite.newInstance();
    }
  }
  
  static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Generated message class \"");
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append("\" missing method \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\".");
      throw new RuntimeException(localStringBuilder.toString(), paramVarArgs);
    }
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T paramT, boolean paramBoolean)
  {
    return paramT.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(paramBoolean)) != null;
  }
  
  protected static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T paramT)
  {
    paramT.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
  }
  
  protected static Internal.BooleanList mutableCopy(Internal.BooleanList paramBooleanList)
  {
    int i = paramBooleanList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramBooleanList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.DoubleList mutableCopy(Internal.DoubleList paramDoubleList)
  {
    int i = paramDoubleList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramDoubleList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.FloatList mutableCopy(Internal.FloatList paramFloatList)
  {
    int i = paramFloatList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramFloatList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.IntList mutableCopy(Internal.IntList paramIntList)
  {
    int i = paramIntList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramIntList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.LongList mutableCopy(Internal.LongList paramLongList)
  {
    int i = paramLongList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramLongList.mutableCopyWithCapacity(i);
  }
  
  protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> paramProtobufList)
  {
    int i = paramProtobufList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramProtobufList.mutableCopyWithCapacity(i);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType paramContainingType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean, Class paramClass)
  {
    return new GeneratedExtension(paramContainingType, Collections.emptyList(), paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, true, paramBoolean), paramClass);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, Class paramClass)
  {
    return new GeneratedExtension(paramContainingType, paramType, paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, false, false), paramClass);
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T paramT, InputStream paramInputStream)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramT, paramInputStream, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramT, paramInputStream, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, ByteString paramByteString)
  {
    return checkMessageInitialized(parseFrom(paramT, paramByteString, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, paramByteString, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, CodedInputStream paramCodedInputStream)
  {
    return parseFrom(paramT, paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, InputStream paramInputStream)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, CodedInputStream.newInstance(paramInputStream), ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, CodedInputStream.newInstance(paramInputStream), paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, byte[] paramArrayOfByte)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, paramArrayOfByte, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramT, paramArrayOfByte, paramExtensionRegistryLite));
  }
  
  /* Error */
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 357	java/io/InputStream:read	()I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_m1
    //   7: if_icmpne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: iload_3
    //   13: aload_1
    //   14: invokestatic 361	com/google/protobuf/CodedInputStream:readRawVarint32	(ILjava/io/InputStream;)I
    //   17: istore_3
    //   18: new 363	com/google/protobuf/AbstractMessageLite$Builder$LimitedInputStream
    //   21: dup
    //   22: aload_1
    //   23: iload_3
    //   24: invokespecial 366	com/google/protobuf/AbstractMessageLite$Builder$LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   27: invokestatic 344	com/google/protobuf/CodedInputStream:newInstance	(Ljava/io/InputStream;)Lcom/google/protobuf/CodedInputStream;
    //   30: astore_1
    //   31: aload_0
    //   32: aload_1
    //   33: aload_2
    //   34: invokestatic 338	com/google/protobuf/GeneratedMessageLite:parsePartialFrom	(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;
    //   37: astore_0
    //   38: aload_1
    //   39: iconst_0
    //   40: invokevirtual 370	com/google/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: aload_1
    //   47: aload_0
    //   48: invokevirtual 112	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   51: athrow
    //   52: astore_0
    //   53: new 108	com/google/protobuf/InvalidProtocolBufferException
    //   56: dup
    //   57: aload_0
    //   58: invokevirtual 373	java/io/IOException:getMessage	()Ljava/lang/String;
    //   61: invokespecial 374	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramT	T
    //   0	65	1	paramInputStream	InputStream
    //   0	65	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   4	20	3	i	int
    // Exception table:
    //   from	to	target	type
    //   38	43	45	com/google/protobuf/InvalidProtocolBufferException
    //   0	5	52	java/io/IOException
    //   12	18	52	java/io/IOException
  }
  
  /* Error */
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 380	com/google/protobuf/ByteString:newCodedInput	()Lcom/google/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokestatic 338	com/google/protobuf/GeneratedMessageLite:parsePartialFrom	(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;
    //   11: astore_0
    //   12: aload_1
    //   13: iconst_0
    //   14: invokevirtual 370	com/google/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   17: aload_0
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 112	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   25: athrow
    //   26: astore_0
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	paramT	T
    //   0	29	1	paramByteString	ByteString
    //   0	29	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   12	17	19	com/google/protobuf/InvalidProtocolBufferException
    //   0	12	26	com/google/protobuf/InvalidProtocolBufferException
    //   20	26	26	com/google/protobuf/InvalidProtocolBufferException
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, CodedInputStream paramCodedInputStream)
  {
    return parsePartialFrom(paramT, paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramT = (GeneratedMessageLite)paramT.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    try
    {
      paramT.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, paramCodedInputStream, paramExtensionRegistryLite);
      paramT.makeImmutable();
      return paramT;
    }
    catch (RuntimeException paramT)
    {
      if ((paramT.getCause() instanceof InvalidProtocolBufferException)) {
        throw ((InvalidProtocolBufferException)paramT.getCause());
      }
      throw paramT;
    }
  }
  
  /* Error */
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 395	com/google/protobuf/CodedInputStream:newInstance	([B)Lcom/google/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokestatic 338	com/google/protobuf/GeneratedMessageLite:parsePartialFrom	(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;
    //   11: astore_0
    //   12: aload_1
    //   13: iconst_0
    //   14: invokevirtual 370	com/google/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   17: aload_0
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 112	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   25: athrow
    //   26: astore_0
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	paramT	T
    //   0	29	1	paramArrayOfByte	byte[]
    //   0	29	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   12	17	19	com/google/protobuf/InvalidProtocolBufferException
    //   0	12	26	com/google/protobuf/InvalidProtocolBufferException
    //   20	26	26	com/google/protobuf/InvalidProtocolBufferException
  }
  
  protected Object dynamicMethod(MethodToInvoke paramMethodToInvoke)
  {
    return dynamicMethod(paramMethodToInvoke, null, null);
  }
  
  protected Object dynamicMethod(MethodToInvoke paramMethodToInvoke, Object paramObject)
  {
    return dynamicMethod(paramMethodToInvoke, paramObject, null);
  }
  
  protected abstract Object dynamicMethod(MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2);
  
  boolean equals(EqualsVisitor paramEqualsVisitor, MessageLite paramMessageLite)
  {
    if (this == paramMessageLite) {
      return true;
    }
    if (!getDefaultInstanceForType().getClass().isInstance(paramMessageLite)) {
      return false;
    }
    visit(paramEqualsVisitor, (GeneratedMessageLite)paramMessageLite);
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!getDefaultInstanceForType().getClass().isInstance(paramObject)) {
      return false;
    }
    try
    {
      visit(EqualsVisitor.INSTANCE, (GeneratedMessageLite)paramObject);
      return true;
    }
    catch (GeneratedMessageLite.EqualsVisitor.NotEqualsException paramObject) {}
    return false;
  }
  
  public final MessageType getDefaultInstanceForType()
  {
    return (GeneratedMessageLite)dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
  }
  
  public final Parser<MessageType> getParserForType()
  {
    return (Parser)dynamicMethod(MethodToInvoke.GET_PARSER);
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode == 0)
    {
      HashCodeVisitor localHashCodeVisitor = new HashCodeVisitor(null);
      visit(localHashCodeVisitor, this);
      this.memoizedHashCode = localHashCodeVisitor.hashCode;
    }
    return this.memoizedHashCode;
  }
  
  int hashCode(HashCodeVisitor paramHashCodeVisitor)
  {
    if (this.memoizedHashCode == 0)
    {
      int i = paramHashCodeVisitor.hashCode;
      HashCodeVisitor.access$102(paramHashCodeVisitor, 0);
      visit(paramHashCodeVisitor, this);
      this.memoizedHashCode = paramHashCodeVisitor.hashCode;
      HashCodeVisitor.access$102(paramHashCodeVisitor, i);
    }
    return this.memoizedHashCode;
  }
  
  public final boolean isInitialized()
  {
    return dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
  }
  
  protected void makeImmutable()
  {
    dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    this.unknownFields.makeImmutable();
  }
  
  protected void mergeLengthDelimitedField(int paramInt, ByteString paramByteString)
  {
    ensureUnknownFieldsInitialized();
    this.unknownFields.mergeLengthDelimitedField(paramInt, paramByteString);
  }
  
  protected final void mergeUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, paramUnknownFieldSetLite);
  }
  
  protected void mergeVarintField(int paramInt1, int paramInt2)
  {
    ensureUnknownFieldsInitialized();
    this.unknownFields.mergeVarintField(paramInt1, paramInt2);
  }
  
  public final BuilderType newBuilderForType()
  {
    return (Builder)dynamicMethod(MethodToInvoke.NEW_BUILDER);
  }
  
  protected boolean parseUnknownField(int paramInt, CodedInputStream paramCodedInputStream)
  {
    if (WireFormat.getTagWireType(paramInt) == 4) {
      return false;
    }
    ensureUnknownFieldsInitialized();
    return this.unknownFields.mergeFieldFrom(paramInt, paramCodedInputStream);
  }
  
  public final BuilderType toBuilder()
  {
    Builder localBuilder = (Builder)dynamicMethod(MethodToInvoke.NEW_BUILDER);
    localBuilder.mergeFrom(this);
    return localBuilder;
  }
  
  public String toString()
  {
    return MessageLiteToString.toString(this, super.toString());
  }
  
  void visit(Visitor paramVisitor, MessageType paramMessageType)
  {
    dynamicMethod(MethodToInvoke.VISIT, paramVisitor, paramMessageType);
    this.unknownFields = paramVisitor.visitUnknownFields(this.unknownFields, paramMessageType.unknownFields);
  }
  
  public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
    extends AbstractMessageLite.Builder<MessageType, BuilderType>
  {
    private final MessageType defaultInstance;
    protected MessageType instance;
    protected boolean isBuilt;
    
    protected Builder(MessageType paramMessageType)
    {
      this.defaultInstance = paramMessageType;
      this.instance = ((GeneratedMessageLite)paramMessageType.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE));
      this.isBuilt = false;
    }
    
    public final MessageType build()
    {
      GeneratedMessageLite localGeneratedMessageLite = buildPartial();
      if (localGeneratedMessageLite.isInitialized()) {
        return localGeneratedMessageLite;
      }
      throw AbstractMessageLite.Builder.newUninitializedMessageException(localGeneratedMessageLite);
    }
    
    public MessageType buildPartial()
    {
      if (this.isBuilt) {
        return this.instance;
      }
      this.instance.makeImmutable();
      this.isBuilt = true;
      return this.instance;
    }
    
    public final BuilderType clear()
    {
      this.instance = ((GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE));
      return this;
    }
    
    public BuilderType clone()
    {
      Builder localBuilder = getDefaultInstanceForType().newBuilderForType();
      localBuilder.mergeFrom(buildPartial());
      return localBuilder;
    }
    
    protected void copyOnWrite()
    {
      if (this.isBuilt)
      {
        GeneratedMessageLite localGeneratedMessageLite = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
        localGeneratedMessageLite.visit(GeneratedMessageLite.MergeFromVisitor.INSTANCE, this.instance);
        this.instance = localGeneratedMessageLite;
        this.isBuilt = false;
      }
    }
    
    public MessageType getDefaultInstanceForType()
    {
      return this.defaultInstance;
    }
    
    protected BuilderType internalMergeFrom(MessageType paramMessageType)
    {
      return mergeFrom(paramMessageType);
    }
    
    public final boolean isInitialized()
    {
      return GeneratedMessageLite.isInitialized(this.instance, false);
    }
    
    public BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      copyOnWrite();
      try
      {
        this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM, paramCodedInputStream, paramExtensionRegistryLite);
        return this;
      }
      catch (RuntimeException paramCodedInputStream)
      {
        if ((paramCodedInputStream.getCause() instanceof IOException)) {
          throw ((IOException)paramCodedInputStream.getCause());
        }
        throw paramCodedInputStream;
      }
    }
    
    public BuilderType mergeFrom(MessageType paramMessageType)
    {
      copyOnWrite();
      this.instance.visit(GeneratedMessageLite.MergeFromVisitor.INSTANCE, paramMessageType);
      return this;
    }
  }
  
  protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>>
    extends AbstractParser<T>
  {
    private T defaultInstance;
    
    public DefaultInstanceBasedParser(T paramT)
    {
      this.defaultInstance = paramT;
    }
    
    public T parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, paramCodedInputStream, paramExtensionRegistryLite);
    }
  }
  
  static class EqualsVisitor
    implements GeneratedMessageLite.Visitor
  {
    static final EqualsVisitor INSTANCE = new EqualsVisitor();
    static final NotEqualsException NOT_EQUALS = new NotEqualsException();
    
    public boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      if ((paramBoolean1 == paramBoolean3) && (paramBoolean2 == paramBoolean4)) {
        return paramBoolean2;
      }
      throw NOT_EQUALS;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList paramBooleanList1, Internal.BooleanList paramBooleanList2)
    {
      if (paramBooleanList1.equals(paramBooleanList2)) {
        return paramBooleanList1;
      }
      throw NOT_EQUALS;
    }
    
    public ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramByteString1.equals(paramByteString2))) {
        return paramByteString1;
      }
      throw NOT_EQUALS;
    }
    
    public double visitDouble(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramDouble1 == paramDouble2)) {
        return paramDouble1;
      }
      throw NOT_EQUALS;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList paramDoubleList1, Internal.DoubleList paramDoubleList2)
    {
      if (paramDoubleList1.equals(paramDoubleList2)) {
        return paramDoubleList1;
      }
      throw NOT_EQUALS;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet2)
    {
      if (paramFieldSet1.equals(paramFieldSet2)) {
        return paramFieldSet1;
      }
      throw NOT_EQUALS;
    }
    
    public float visitFloat(boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramFloat1 == paramFloat2)) {
        return paramFloat1;
      }
      throw NOT_EQUALS;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList paramFloatList1, Internal.FloatList paramFloatList2)
    {
      if (paramFloatList1.equals(paramFloatList2)) {
        return paramFloatList1;
      }
      throw NOT_EQUALS;
    }
    
    public int visitInt(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramInt1 == paramInt2)) {
        return paramInt1;
      }
      throw NOT_EQUALS;
    }
    
    public Internal.IntList visitIntList(Internal.IntList paramIntList1, Internal.IntList paramIntList2)
    {
      if (paramIntList1.equals(paramIntList2)) {
        return paramIntList1;
      }
      throw NOT_EQUALS;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite paramLazyFieldLite1, LazyFieldLite paramLazyFieldLite2)
    {
      if ((paramLazyFieldLite1 == null) && (paramLazyFieldLite2 == null)) {
        return null;
      }
      if ((paramLazyFieldLite1 != null) && (paramLazyFieldLite2 != null))
      {
        if (paramLazyFieldLite1.equals(paramLazyFieldLite2)) {
          return paramLazyFieldLite1;
        }
        throw NOT_EQUALS;
      }
      throw NOT_EQUALS;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> paramProtobufList1, Internal.ProtobufList<T> paramProtobufList2)
    {
      if (paramProtobufList1.equals(paramProtobufList2)) {
        return paramProtobufList1;
      }
      throw NOT_EQUALS;
    }
    
    public long visitLong(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramLong1 == paramLong2)) {
        return paramLong1;
      }
      throw NOT_EQUALS;
    }
    
    public Internal.LongList visitLongList(Internal.LongList paramLongList1, Internal.LongList paramLongList2)
    {
      if (paramLongList1.equals(paramLongList2)) {
        return paramLongList1;
      }
      throw NOT_EQUALS;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> paramMapFieldLite1, MapFieldLite<K, V> paramMapFieldLite2)
    {
      if (paramMapFieldLite1.equals(paramMapFieldLite2)) {
        return paramMapFieldLite1;
      }
      throw NOT_EQUALS;
    }
    
    public <T extends MessageLite> T visitMessage(T paramT1, T paramT2)
    {
      if ((paramT1 == null) && (paramT2 == null)) {
        return null;
      }
      if ((paramT1 != null) && (paramT2 != null))
      {
        ((GeneratedMessageLite)paramT1).equals(this, paramT2);
        return paramT1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofBoolean(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofByteString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofDouble(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofFloat(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofInt(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofLazyMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofLong(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (((GeneratedMessageLite)paramObject1).equals(this, (MessageLite)paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public void visitOneofNotSet(boolean paramBoolean)
    {
      if (!paramBoolean) {
        return;
      }
      throw NOT_EQUALS;
    }
    
    public Object visitOneofString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
        return paramObject1;
      }
      throw NOT_EQUALS;
    }
    
    public String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      if ((paramBoolean1 == paramBoolean2) && (paramString1.equals(paramString2))) {
        return paramString1;
      }
      throw NOT_EQUALS;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
    {
      if (paramUnknownFieldSetLite1.equals(paramUnknownFieldSetLite2)) {
        return paramUnknownFieldSetLite1;
      }
      throw NOT_EQUALS;
    }
    
    static final class NotEqualsException
      extends RuntimeException
    {}
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
    extends GeneratedMessageLite.Builder<MessageType, BuilderType>
    implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType, BuilderType>
  {
    protected ExtendableBuilder(MessageType paramMessageType)
    {
      super();
      paramMessageType = this.instance;
      ((GeneratedMessageLite.ExtendableMessage)paramMessageType).extensions = ((GeneratedMessageLite.ExtendableMessage)paramMessageType).extensions.clone();
    }
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
        return;
      }
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
    
    public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, Type paramType)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.addRepeatedField(paramExtensionLite.descriptor, paramExtensionLite.singularToFieldSetType(paramType));
      return this;
    }
    
    public final MessageType buildPartial()
    {
      if (this.isBuilt) {}
      for (GeneratedMessageLite localGeneratedMessageLite = this.instance;; localGeneratedMessageLite = super.buildPartial())
      {
        return (GeneratedMessageLite.ExtendableMessage)localGeneratedMessageLite;
        ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.makeImmutable();
      }
    }
    
    public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> paramExtensionLite)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.clearField(paramExtensionLite.descriptor);
      return this;
    }
    
    public BuilderType clone()
    {
      return (ExtendableBuilder)super.clone();
    }
    
    protected void copyOnWrite()
    {
      if (!this.isBuilt) {
        return;
      }
      super.copyOnWrite();
      GeneratedMessageLite localGeneratedMessageLite = this.instance;
      ((GeneratedMessageLite.ExtendableMessage)localGeneratedMessageLite).extensions = ((GeneratedMessageLite.ExtendableMessage)localGeneratedMessageLite).extensions.clone();
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
    {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).getExtension(paramExtensionLite);
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, int paramInt)
    {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).getExtension(paramExtensionLite, paramInt);
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> paramExtensionLite)
    {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).getExtensionCount(paramExtensionLite);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
    {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).hasExtension(paramExtensionLite);
    }
    
    void internalSetExtensionSet(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
    {
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions = paramFieldSet;
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, int paramInt, Type paramType)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.setRepeatedField(paramExtensionLite.descriptor, paramInt, paramExtensionLite.singularToFieldSetType(paramType));
      return this;
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> paramExtensionLite, Type paramType)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.setField(paramExtensionLite.descriptor, paramExtensionLite.toFieldSetType(paramType));
      return this;
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends GeneratedMessageLite.ExtendableBuilder<MessageType, BuilderType>>
    extends GeneratedMessageLite<MessageType, BuilderType>
    implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType, BuilderType>
  {
    protected FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.newFieldSet();
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
        return;
      }
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
    
    protected boolean extensionsAreInitialized()
    {
      return this.extensions.isInitialized();
    }
    
    protected int extensionsSerializedSize()
    {
      return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet()
    {
      return this.extensions.getMessageSetSerializedSize();
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      Object localObject = this.extensions.getField(paramExtensionLite.descriptor);
      if (localObject == null) {
        return paramExtensionLite.defaultValue;
      }
      return paramExtensionLite.fromFieldSetType(localObject);
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, int paramInt)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      return paramExtensionLite.singularFromFieldSetType(this.extensions.getRepeatedField(paramExtensionLite.descriptor, paramInt));
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> paramExtensionLite)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      return this.extensions.getRepeatedFieldCount(paramExtensionLite.descriptor);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
    {
      paramExtensionLite = GeneratedMessageLite.checkIsLite(paramExtensionLite);
      verifyExtensionContainingType(paramExtensionLite);
      return this.extensions.hasField(paramExtensionLite.descriptor);
    }
    
    protected final void makeImmutable()
    {
      super.makeImmutable();
      this.extensions.makeImmutable();
    }
    
    protected final void mergeExtensionFields(MessageType paramMessageType)
    {
      if (this.extensions.isImmutable()) {
        this.extensions = this.extensions.clone();
      }
      this.extensions.mergeFrom(paramMessageType.extensions);
    }
    
    protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter()
    {
      return new ExtensionWriter(false, null);
    }
    
    protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter()
    {
      return new ExtensionWriter(true, null);
    }
    
    protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType paramMessageType, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
    {
      int i = WireFormat.getTagWireType(paramInt);
      int k = WireFormat.getTagFieldNumber(paramInt);
      GeneratedMessageLite.GeneratedExtension localGeneratedExtension = paramExtensionRegistryLite.findLiteExtensionByNumber(paramMessageType, k);
      if (localGeneratedExtension == null) {}
      do
      {
        j = 0;
        i = 1;
        break;
        if (i == FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), false))
        {
          i = 0;
          j = i;
          break;
        }
        paramMessageType = localGeneratedExtension.descriptor;
      } while ((!paramMessageType.isRepeated) || (!paramMessageType.type.isPackable()) || (i != FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), true)));
      i = 0;
      int j = 1;
      if (i != 0) {
        return parseUnknownField(paramInt, paramCodedInputStream);
      }
      if (j != 0)
      {
        paramInt = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
        if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
          while (paramCodedInputStream.getBytesUntilLimit() > 0)
          {
            i = paramCodedInputStream.readEnum();
            paramMessageType = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(i);
            if (paramMessageType == null) {
              return true;
            }
            this.extensions.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
          }
        }
        while (paramCodedInputStream.getBytesUntilLimit() > 0)
        {
          paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
          this.extensions.addRepeatedField(localGeneratedExtension.descriptor, paramMessageType);
        }
        paramCodedInputStream.popLimit(paramInt);
        return true;
      }
      paramInt = GeneratedMessageLite.1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[localGeneratedExtension.descriptor.getLiteJavaType().ordinal()];
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
        }
        else
        {
          paramInt = paramCodedInputStream.readEnum();
          paramMessageType = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(paramInt);
          if (paramMessageType == null)
          {
            mergeVarintField(k, paramInt);
            return true;
          }
        }
      }
      else
      {
        Object localObject = null;
        paramMessageType = (TMessageType)localObject;
        if (!localGeneratedExtension.descriptor.isRepeated())
        {
          MessageLite localMessageLite = (MessageLite)this.extensions.getField(localGeneratedExtension.descriptor);
          paramMessageType = (TMessageType)localObject;
          if (localMessageLite != null) {
            paramMessageType = localMessageLite.toBuilder();
          }
        }
        localObject = paramMessageType;
        if (paramMessageType == null) {
          localObject = localGeneratedExtension.getMessageDefaultInstance().newBuilderForType();
        }
        if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
          paramCodedInputStream.readGroup(localGeneratedExtension.getNumber(), (MessageLite.Builder)localObject, paramExtensionRegistryLite);
        } else {
          paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
        }
        paramMessageType = ((MessageLite.Builder)localObject).build();
      }
      if (localGeneratedExtension.descriptor.isRepeated())
      {
        this.extensions.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
        return true;
      }
      this.extensions.setField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
      return true;
    }
    
    final void visit(GeneratedMessageLite.Visitor paramVisitor, MessageType paramMessageType)
    {
      super.visit(paramVisitor, paramMessageType);
      this.extensions = paramVisitor.visitExtensions(this.extensions, paramMessageType.extensions);
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter;
      private final boolean messageSetWireFormat;
      private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
      
      private ExtensionWriter(boolean paramBoolean)
      {
        this$1 = GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
        this.iter = GeneratedMessageLite.ExtendableMessage.this;
        if (GeneratedMessageLite.ExtendableMessage.this.hasNext()) {
          this.next = ((Map.Entry)GeneratedMessageLite.ExtendableMessage.this.next());
        }
        this.messageSetWireFormat = paramBoolean;
      }
      
      public void writeUntil(int paramInt, CodedOutputStream paramCodedOutputStream)
      {
        for (;;)
        {
          Object localObject = this.next;
          if ((localObject == null) || (((GeneratedMessageLite.ExtensionDescriptor)((Map.Entry)localObject).getKey()).getNumber() >= paramInt)) {
            break;
          }
          localObject = (GeneratedMessageLite.ExtensionDescriptor)this.next.getKey();
          if ((this.messageSetWireFormat) && (((GeneratedMessageLite.ExtensionDescriptor)localObject).getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!((GeneratedMessageLite.ExtensionDescriptor)localObject).isRepeated())) {
            paramCodedOutputStream.writeMessageSetExtension(((GeneratedMessageLite.ExtensionDescriptor)localObject).getNumber(), (MessageLite)this.next.getValue());
          } else {
            FieldSet.writeField((FieldSet.FieldDescriptorLite)localObject, this.next.getValue(), paramCodedOutputStream);
          }
          if (this.iter.hasNext()) {
            localObject = (Map.Entry)this.iter.next();
          } else {
            localObject = null;
          }
          this.next = ((Map.Entry)localObject);
        }
      }
    }
  }
  
  public static abstract interface ExtendableMessageOrBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>, BuilderType extends GeneratedMessageLite.ExtendableBuilder<MessageType, BuilderType>>
    extends MessageLiteOrBuilder
  {
    public abstract <Type> Type getExtension(ExtensionLite<MessageType, Type> paramExtensionLite);
    
    public abstract <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, int paramInt);
    
    public abstract <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> paramExtensionLite);
    
    public abstract <Type> boolean hasExtension(ExtensionLite<MessageType, Type> paramExtensionLite);
  }
  
  static final class ExtensionDescriptor
    implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
  {
    final Internal.EnumLiteMap<?> enumTypeMap;
    final boolean isPacked;
    final boolean isRepeated;
    final int number;
    final WireFormat.FieldType type;
    
    ExtensionDescriptor(Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.enumTypeMap = paramEnumLiteMap;
      this.number = paramInt;
      this.type = paramFieldType;
      this.isRepeated = paramBoolean1;
      this.isPacked = paramBoolean2;
    }
    
    public int compareTo(ExtensionDescriptor paramExtensionDescriptor)
    {
      return this.number - paramExtensionDescriptor.number;
    }
    
    public Internal.EnumLiteMap<?> getEnumType()
    {
      return this.enumTypeMap;
    }
    
    public WireFormat.JavaType getLiteJavaType()
    {
      return this.type.getJavaType();
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return this.type;
    }
    
    public int getNumber()
    {
      return this.number;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
    {
      return ((GeneratedMessageLite.Builder)paramBuilder).mergeFrom((GeneratedMessageLite)paramMessageLite);
    }
    
    public boolean isPacked()
    {
      return this.isPacked;
    }
    
    public boolean isRepeated()
    {
      return this.isRepeated;
    }
  }
  
  public static class GeneratedExtension<ContainingType extends MessageLite, Type>
    extends ExtensionLite<ContainingType, Type>
  {
    final ContainingType containingTypeDefaultInstance;
    final Type defaultValue;
    final GeneratedMessageLite.ExtensionDescriptor descriptor;
    final MessageLite messageDefaultInstance;
    
    GeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, GeneratedMessageLite.ExtensionDescriptor paramExtensionDescriptor, Class paramClass)
    {
      if (paramContainingType != null)
      {
        if ((paramExtensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE) && (paramMessageLite == null)) {
          throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.containingTypeDefaultInstance = paramContainingType;
        this.defaultValue = paramType;
        this.messageDefaultInstance = paramMessageLite;
        this.descriptor = paramExtensionDescriptor;
        return;
      }
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
    
    Object fromFieldSetType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
        {
          ArrayList localArrayList = new ArrayList();
          paramObject = ((List)paramObject).iterator();
          while (paramObject.hasNext()) {
            localArrayList.add(singularFromFieldSetType(paramObject.next()));
          }
          return localArrayList;
        }
        return paramObject;
      }
      return singularFromFieldSetType(paramObject);
    }
    
    public ContainingType getContainingTypeDefaultInstance()
    {
      return this.containingTypeDefaultInstance;
    }
    
    public Type getDefaultValue()
    {
      return this.defaultValue;
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return this.descriptor.getLiteType();
    }
    
    public MessageLite getMessageDefaultInstance()
    {
      return this.messageDefaultInstance;
    }
    
    public int getNumber()
    {
      return this.descriptor.getNumber();
    }
    
    public boolean isRepeated()
    {
      return this.descriptor.isRepeated;
    }
    
    Object singularFromFieldSetType(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
        localObject = this.descriptor.enumTypeMap.findValueByNumber(((Integer)paramObject).intValue());
      }
      return localObject;
    }
    
    Object singularToFieldSetType(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
        localObject = Integer.valueOf(((Internal.EnumLite)paramObject).getNumber());
      }
      return localObject;
    }
    
    Object toFieldSetType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
        {
          ArrayList localArrayList = new ArrayList();
          paramObject = ((List)paramObject).iterator();
          while (paramObject.hasNext()) {
            localArrayList.add(singularToFieldSetType(paramObject.next()));
          }
          return localArrayList;
        }
        return paramObject;
      }
      return singularToFieldSetType(paramObject);
    }
  }
  
  private static class HashCodeVisitor
    implements GeneratedMessageLite.Visitor
  {
    private int hashCode = 0;
    
    public boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashBoolean(paramBoolean2));
      return paramBoolean2;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList paramBooleanList1, Internal.BooleanList paramBooleanList2)
    {
      this.hashCode = (this.hashCode * 53 + paramBooleanList1.hashCode());
      return paramBooleanList1;
    }
    
    public ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2)
    {
      this.hashCode = (this.hashCode * 53 + paramByteString1.hashCode());
      return paramByteString1;
    }
    
    public double visitDouble(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashLong(Double.doubleToLongBits(paramDouble1)));
      return paramDouble1;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList paramDoubleList1, Internal.DoubleList paramDoubleList2)
    {
      this.hashCode = (this.hashCode * 53 + paramDoubleList1.hashCode());
      return paramDoubleList1;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet2)
    {
      this.hashCode = (this.hashCode * 53 + paramFieldSet1.hashCode());
      return paramFieldSet1;
    }
    
    public float visitFloat(boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2)
    {
      this.hashCode = (this.hashCode * 53 + Float.floatToIntBits(paramFloat1));
      return paramFloat1;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList paramFloatList1, Internal.FloatList paramFloatList2)
    {
      this.hashCode = (this.hashCode * 53 + paramFloatList1.hashCode());
      return paramFloatList1;
    }
    
    public int visitInt(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      this.hashCode = (this.hashCode * 53 + paramInt1);
      return paramInt1;
    }
    
    public Internal.IntList visitIntList(Internal.IntList paramIntList1, Internal.IntList paramIntList2)
    {
      this.hashCode = (this.hashCode * 53 + paramIntList1.hashCode());
      return paramIntList1;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite paramLazyFieldLite1, LazyFieldLite paramLazyFieldLite2)
    {
      int i;
      if (paramLazyFieldLite1 != null) {
        i = paramLazyFieldLite1.hashCode();
      } else {
        i = 37;
      }
      this.hashCode = (this.hashCode * 53 + i);
      return paramLazyFieldLite1;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> paramProtobufList1, Internal.ProtobufList<T> paramProtobufList2)
    {
      this.hashCode = (this.hashCode * 53 + paramProtobufList1.hashCode());
      return paramProtobufList1;
    }
    
    public long visitLong(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashLong(paramLong1));
      return paramLong1;
    }
    
    public Internal.LongList visitLongList(Internal.LongList paramLongList1, Internal.LongList paramLongList2)
    {
      this.hashCode = (this.hashCode * 53 + paramLongList1.hashCode());
      return paramLongList1;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> paramMapFieldLite1, MapFieldLite<K, V> paramMapFieldLite2)
    {
      this.hashCode = (this.hashCode * 53 + paramMapFieldLite1.hashCode());
      return paramMapFieldLite1;
    }
    
    public <T extends MessageLite> T visitMessage(T paramT1, T paramT2)
    {
      int i;
      if (paramT1 != null)
      {
        if ((paramT1 instanceof GeneratedMessageLite)) {
          i = ((GeneratedMessageLite)paramT1).hashCode(this);
        } else {
          i = paramT1.hashCode();
        }
      }
      else {
        i = 37;
      }
      this.hashCode = (this.hashCode * 53 + i);
      return paramT1;
    }
    
    public Object visitOneofBoolean(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashBoolean(((Boolean)paramObject1).booleanValue()));
      return paramObject1;
    }
    
    public Object visitOneofByteString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + paramObject1.hashCode());
      return paramObject1;
    }
    
    public Object visitOneofDouble(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashLong(Double.doubleToLongBits(((Double)paramObject1).doubleValue())));
      return paramObject1;
    }
    
    public Object visitOneofFloat(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + Float.floatToIntBits(((Float)paramObject1).floatValue()));
      return paramObject1;
    }
    
    public Object visitOneofInt(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + ((Integer)paramObject1).intValue());
      return paramObject1;
    }
    
    public Object visitOneofLazyMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + paramObject1.hashCode());
      return paramObject1;
    }
    
    public Object visitOneofLong(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + Internal.hashLong(((Long)paramObject1).longValue()));
      return paramObject1;
    }
    
    public Object visitOneofMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return visitMessage((MessageLite)paramObject1, (MessageLite)paramObject2);
    }
    
    public void visitOneofNotSet(boolean paramBoolean)
    {
      if (!paramBoolean) {
        return;
      }
      throw new IllegalStateException();
    }
    
    public Object visitOneofString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      this.hashCode = (this.hashCode * 53 + paramObject1.hashCode());
      return paramObject1;
    }
    
    public String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      this.hashCode = (this.hashCode * 53 + paramString1.hashCode());
      return paramString1;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
    {
      this.hashCode = (this.hashCode * 53 + paramUnknownFieldSetLite1.hashCode());
      return paramUnknownFieldSetLite1;
    }
  }
  
  protected static class MergeFromVisitor
    implements GeneratedMessageLite.Visitor
  {
    public static final MergeFromVisitor INSTANCE = new MergeFromVisitor();
    
    public boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      if (paramBoolean3) {
        paramBoolean2 = paramBoolean4;
      }
      return paramBoolean2;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList paramBooleanList1, Internal.BooleanList paramBooleanList2)
    {
      int i = paramBooleanList1.size();
      int j = paramBooleanList2.size();
      Internal.BooleanList localBooleanList = paramBooleanList1;
      if (i > 0)
      {
        localBooleanList = paramBooleanList1;
        if (j > 0)
        {
          localBooleanList = paramBooleanList1;
          if (!paramBooleanList1.isModifiable()) {
            localBooleanList = paramBooleanList1.mutableCopyWithCapacity(j + i);
          }
          localBooleanList.addAll(paramBooleanList2);
        }
      }
      if (i > 0) {
        paramBooleanList2 = localBooleanList;
      }
      return paramBooleanList2;
    }
    
    public ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2)
    {
      if (paramBoolean2) {
        paramByteString1 = paramByteString2;
      }
      return paramByteString1;
    }
    
    public double visitDouble(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
    {
      if (paramBoolean2) {
        paramDouble1 = paramDouble2;
      }
      return paramDouble1;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList paramDoubleList1, Internal.DoubleList paramDoubleList2)
    {
      int i = paramDoubleList1.size();
      int j = paramDoubleList2.size();
      Internal.DoubleList localDoubleList = paramDoubleList1;
      if (i > 0)
      {
        localDoubleList = paramDoubleList1;
        if (j > 0)
        {
          localDoubleList = paramDoubleList1;
          if (!paramDoubleList1.isModifiable()) {
            localDoubleList = paramDoubleList1.mutableCopyWithCapacity(j + i);
          }
          localDoubleList.addAll(paramDoubleList2);
        }
      }
      if (i > 0) {
        paramDoubleList2 = localDoubleList;
      }
      return paramDoubleList2;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet2)
    {
      Object localObject = paramFieldSet1;
      if (paramFieldSet1.isImmutable()) {
        localObject = paramFieldSet1.clone();
      }
      ((FieldSet)localObject).mergeFrom(paramFieldSet2);
      return localObject;
    }
    
    public float visitFloat(boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2)
    {
      if (paramBoolean2) {
        paramFloat1 = paramFloat2;
      }
      return paramFloat1;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList paramFloatList1, Internal.FloatList paramFloatList2)
    {
      int i = paramFloatList1.size();
      int j = paramFloatList2.size();
      Internal.FloatList localFloatList = paramFloatList1;
      if (i > 0)
      {
        localFloatList = paramFloatList1;
        if (j > 0)
        {
          localFloatList = paramFloatList1;
          if (!paramFloatList1.isModifiable()) {
            localFloatList = paramFloatList1.mutableCopyWithCapacity(j + i);
          }
          localFloatList.addAll(paramFloatList2);
        }
      }
      if (i > 0) {
        paramFloatList2 = localFloatList;
      }
      return paramFloatList2;
    }
    
    public int visitInt(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      if (paramBoolean2) {
        paramInt1 = paramInt2;
      }
      return paramInt1;
    }
    
    public Internal.IntList visitIntList(Internal.IntList paramIntList1, Internal.IntList paramIntList2)
    {
      int i = paramIntList1.size();
      int j = paramIntList2.size();
      Internal.IntList localIntList = paramIntList1;
      if (i > 0)
      {
        localIntList = paramIntList1;
        if (j > 0)
        {
          localIntList = paramIntList1;
          if (!paramIntList1.isModifiable()) {
            localIntList = paramIntList1.mutableCopyWithCapacity(j + i);
          }
          localIntList.addAll(paramIntList2);
        }
      }
      if (i > 0) {
        paramIntList2 = localIntList;
      }
      return paramIntList2;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite paramLazyFieldLite1, LazyFieldLite paramLazyFieldLite2)
    {
      LazyFieldLite localLazyFieldLite = paramLazyFieldLite1;
      if (paramLazyFieldLite2 != null)
      {
        localLazyFieldLite = paramLazyFieldLite1;
        if (paramLazyFieldLite1 == null) {
          localLazyFieldLite = new LazyFieldLite();
        }
        localLazyFieldLite.merge(paramLazyFieldLite2);
      }
      return localLazyFieldLite;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> paramProtobufList1, Internal.ProtobufList<T> paramProtobufList2)
    {
      int i = paramProtobufList1.size();
      int j = paramProtobufList2.size();
      Object localObject = paramProtobufList1;
      if (i > 0)
      {
        localObject = paramProtobufList1;
        if (j > 0)
        {
          localObject = paramProtobufList1;
          if (!paramProtobufList1.isModifiable()) {
            localObject = paramProtobufList1.mutableCopyWithCapacity(j + i);
          }
          ((List)localObject).addAll(paramProtobufList2);
        }
      }
      if (i > 0) {
        paramProtobufList2 = (Internal.ProtobufList<T>)localObject;
      }
      return paramProtobufList2;
    }
    
    public long visitLong(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
    {
      if (paramBoolean2) {
        paramLong1 = paramLong2;
      }
      return paramLong1;
    }
    
    public Internal.LongList visitLongList(Internal.LongList paramLongList1, Internal.LongList paramLongList2)
    {
      int i = paramLongList1.size();
      int j = paramLongList2.size();
      Internal.LongList localLongList = paramLongList1;
      if (i > 0)
      {
        localLongList = paramLongList1;
        if (j > 0)
        {
          localLongList = paramLongList1;
          if (!paramLongList1.isModifiable()) {
            localLongList = paramLongList1.mutableCopyWithCapacity(j + i);
          }
          localLongList.addAll(paramLongList2);
        }
      }
      if (i > 0) {
        paramLongList2 = localLongList;
      }
      return paramLongList2;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> paramMapFieldLite1, MapFieldLite<K, V> paramMapFieldLite2)
    {
      Object localObject = paramMapFieldLite1;
      if (!paramMapFieldLite2.isEmpty())
      {
        localObject = paramMapFieldLite1;
        if (!paramMapFieldLite1.isMutable()) {
          localObject = paramMapFieldLite1.mutableCopy();
        }
        ((MapFieldLite)localObject).mergeFrom(paramMapFieldLite2);
      }
      return localObject;
    }
    
    public <T extends MessageLite> T visitMessage(T paramT1, T paramT2)
    {
      if ((paramT1 != null) && (paramT2 != null)) {
        return paramT1.toBuilder().mergeFrom(paramT2).build();
      }
      if (paramT1 != null) {
        return paramT1;
      }
      return paramT2;
    }
    
    public Object visitOneofBoolean(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofByteString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofDouble(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofFloat(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofInt(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofLazyMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if (paramBoolean) {
        paramObject1 = (LazyFieldLite)paramObject1;
      } else {
        paramObject1 = new LazyFieldLite();
      }
      paramObject1.merge((LazyFieldLite)paramObject2);
      return paramObject1;
    }
    
    public Object visitOneofLong(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public Object visitOneofMessage(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      if (paramBoolean) {
        return visitMessage((MessageLite)paramObject1, (MessageLite)paramObject2);
      }
      return paramObject2;
    }
    
    public void visitOneofNotSet(boolean paramBoolean) {}
    
    public Object visitOneofString(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      return paramObject2;
    }
    
    public String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      if (paramBoolean2) {
        paramString1 = paramString2;
      }
      return paramString1;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
    {
      if (paramUnknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance()) {
        return paramUnknownFieldSetLite1;
      }
      return UnknownFieldSetLite.mutableCopyOf(paramUnknownFieldSetLite1, paramUnknownFieldSetLite2);
    }
  }
  
  public static enum MethodToInvoke
  {
    static
    {
      MethodToInvoke localMethodToInvoke1 = new MethodToInvoke("IS_INITIALIZED", 0);
      IS_INITIALIZED = localMethodToInvoke1;
      MethodToInvoke localMethodToInvoke2 = new MethodToInvoke("VISIT", 1);
      VISIT = localMethodToInvoke2;
      MethodToInvoke localMethodToInvoke3 = new MethodToInvoke("MERGE_FROM_STREAM", 2);
      MERGE_FROM_STREAM = localMethodToInvoke3;
      MethodToInvoke localMethodToInvoke4 = new MethodToInvoke("MAKE_IMMUTABLE", 3);
      MAKE_IMMUTABLE = localMethodToInvoke4;
      MethodToInvoke localMethodToInvoke5 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 4);
      NEW_MUTABLE_INSTANCE = localMethodToInvoke5;
      MethodToInvoke localMethodToInvoke6 = new MethodToInvoke("NEW_BUILDER", 5);
      NEW_BUILDER = localMethodToInvoke6;
      MethodToInvoke localMethodToInvoke7 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 6);
      GET_DEFAULT_INSTANCE = localMethodToInvoke7;
      MethodToInvoke localMethodToInvoke8 = new MethodToInvoke("GET_PARSER", 7);
      GET_PARSER = localMethodToInvoke8;
      $VALUES = new MethodToInvoke[] { localMethodToInvoke1, localMethodToInvoke2, localMethodToInvoke3, localMethodToInvoke4, localMethodToInvoke5, localMethodToInvoke6, localMethodToInvoke7, localMethodToInvoke8 };
    }
    
    private MethodToInvoke() {}
  }
  
  protected static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final byte[] asBytes;
    private final String messageClassName;
    
    SerializedForm(MessageLite paramMessageLite)
    {
      this.messageClassName = paramMessageLite.getClass().getName();
      this.asBytes = paramMessageLite.toByteArray();
    }
    
    public static SerializedForm of(MessageLite paramMessageLite)
    {
      return new SerializedForm(paramMessageLite);
    }
    
    @Deprecated
    private Object readResolveFallback()
    {
      try
      {
        Object localObject = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
        ((Field)localObject).setAccessible(true);
        localObject = ((MessageLite)((Field)localObject).get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        return localObject;
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (SecurityException localSecurityException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to call defaultInstance in ");
        localStringBuilder.append(this.messageClassName);
        throw new RuntimeException(localStringBuilder.toString(), localSecurityException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to find defaultInstance in ");
        localStringBuilder.append(this.messageClassName);
        throw new RuntimeException(localStringBuilder.toString(), localNoSuchFieldException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to find proto buffer class: ");
        localStringBuilder.append(this.messageClassName);
        throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
      }
    }
    
    protected Object readResolve()
    {
      try
      {
        Object localObject = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
        ((Field)localObject).setAccessible(true);
        localObject = ((MessageLite)((Field)localObject).get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        return localObject;
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (SecurityException localSecurityException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to call DEFAULT_INSTANCE in ");
        localStringBuilder.append(this.messageClassName);
        throw new RuntimeException(localStringBuilder.toString(), localSecurityException);
        return readResolveFallback();
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to find proto buffer class: ");
        localStringBuilder.append(this.messageClassName);
        throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label110:
        break label110;
      }
    }
  }
  
  protected static abstract interface Visitor
  {
    public abstract boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
    
    public abstract Internal.BooleanList visitBooleanList(Internal.BooleanList paramBooleanList1, Internal.BooleanList paramBooleanList2);
    
    public abstract ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2);
    
    public abstract double visitDouble(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2);
    
    public abstract Internal.DoubleList visitDoubleList(Internal.DoubleList paramDoubleList1, Internal.DoubleList paramDoubleList2);
    
    public abstract FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet2);
    
    public abstract float visitFloat(boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2);
    
    public abstract Internal.FloatList visitFloatList(Internal.FloatList paramFloatList1, Internal.FloatList paramFloatList2);
    
    public abstract int visitInt(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2);
    
    public abstract Internal.IntList visitIntList(Internal.IntList paramIntList1, Internal.IntList paramIntList2);
    
    public abstract LazyFieldLite visitLazyMessage(LazyFieldLite paramLazyFieldLite1, LazyFieldLite paramLazyFieldLite2);
    
    public abstract <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> paramProtobufList1, Internal.ProtobufList<T> paramProtobufList2);
    
    public abstract long visitLong(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2);
    
    public abstract Internal.LongList visitLongList(Internal.LongList paramLongList1, Internal.LongList paramLongList2);
    
    public abstract <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> paramMapFieldLite1, MapFieldLite<K, V> paramMapFieldLite2);
    
    public abstract <T extends MessageLite> T visitMessage(T paramT1, T paramT2);
    
    public abstract Object visitOneofBoolean(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofByteString(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofDouble(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofFloat(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofInt(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofLazyMessage(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofLong(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract Object visitOneofMessage(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract void visitOneofNotSet(boolean paramBoolean);
    
    public abstract Object visitOneofString(boolean paramBoolean, Object paramObject1, Object paramObject2);
    
    public abstract String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2);
    
    public abstract UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite
 * JD-Core Version:    0.7.0.1
 */