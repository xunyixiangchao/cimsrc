package com.farsunset.cim.sdk.android.model.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat.FieldType;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public final class SentBodyProto
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Model
    extends GeneratedMessageLite<Model, Builder>
    implements SentBodyProto.ModelOrBuilder
  {
    public static final int DATA_FIELD_NUMBER = 3;
    private static final Model DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile Parser<Model> PARSER;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private int bitField0_;
    private MapFieldLite<String, String> data_ = MapFieldLite.emptyMapField();
    private String key_ = "";
    private long timestamp_;
    
    static
    {
      Model localModel = new Model();
      DEFAULT_INSTANCE = localModel;
      localModel.makeImmutable();
    }
    
    private void clearKey()
    {
      this.key_ = getDefaultInstance().getKey();
    }
    
    private void clearTimestamp()
    {
      this.timestamp_ = 0L;
    }
    
    public static Model getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private Map<String, String> getMutableDataMap()
    {
      return internalGetMutableData();
    }
    
    private MapFieldLite<String, String> internalGetData()
    {
      return this.data_;
    }
    
    private MapFieldLite<String, String> internalGetMutableData()
    {
      if (!this.data_.isMutable()) {
        this.data_ = this.data_.mutableCopy();
      }
      return this.data_;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Model paramModel)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramModel);
    }
    
    public static Model parseDelimitedFrom(InputStream paramInputStream)
    {
      return (Model)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Model parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return (Model)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Model parseFrom(ByteString paramByteString)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static Model parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static Model parseFrom(CodedInputStream paramCodedInputStream)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static Model parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static Model parseFrom(InputStream paramInputStream)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Model parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Model parseFrom(byte[] paramArrayOfByte)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static Model parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return (Model)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<Model> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setKey(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.key_ = paramString;
    }
    
    private void setKeyBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.key_ = paramByteString.toStringUtf8();
    }
    
    private void setTimestamp(long paramLong)
    {
      this.timestamp_ = paramLong;
    }
    
    public boolean containsData(String paramString)
    {
      Objects.requireNonNull(paramString);
      return internalGetData().containsKey(paramString);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 213	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 219	java/lang/Enum:ordinal	()I
      //   7: iaload
      //   8: istore 5
      //   10: iconst_0
      //   11: istore 4
      //   13: iload 5
      //   15: tableswitch	default:+45 -> 60, 1:+438->453, 2:+434->449, 3:+425->440, 4:+416->431, 5:+268->283, 6:+97->112, 7:+264->279, 8:+53->68
      //   61: nop
      //   62: <illegal opcode>
      //   63: dup
      //   64: invokespecial 222	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: getstatic 224	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   71: ifnonnull +37 -> 108
      //   74: ldc 2
      //   76: monitorenter
      //   77: getstatic 224	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   80: ifnonnull +16 -> 96
      //   83: new 226	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: dup
      //   87: getstatic 43	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model;
      //   90: invokespecial 229	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   93: putstatic 224	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   96: ldc 2
      //   98: monitorexit
      //   99: goto +9 -> 108
      //   102: astore_1
      //   103: ldc 2
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      //   108: getstatic 224	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   111: areturn
      //   112: aload_2
      //   113: checkcast 231	com/google/protobuf/CodedInputStream
      //   116: astore_1
      //   117: aload_3
      //   118: checkcast 233	com/google/protobuf/ExtensionRegistryLite
      //   121: astore_2
      //   122: iload 4
      //   124: ifne +155 -> 279
      //   127: aload_1
      //   128: invokevirtual 236	com/google/protobuf/CodedInputStream:readTag	()I
      //   131: istore 5
      //   133: iload 5
      //   135: ifeq +94 -> 229
      //   138: iload 5
      //   140: bipush 10
      //   142: if_icmpeq +76 -> 218
      //   145: iload 5
      //   147: bipush 16
      //   149: if_icmpeq +58 -> 207
      //   152: iload 5
      //   154: bipush 26
      //   156: if_icmpeq +15 -> 171
      //   159: aload_1
      //   160: iload 5
      //   162: invokevirtual 240	com/google/protobuf/CodedInputStream:skipField	(I)Z
      //   165: ifne -43 -> 122
      //   168: goto +61 -> 229
      //   171: aload_0
      //   172: getfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   175: invokevirtual 115	com/google/protobuf/MapFieldLite:isMutable	()Z
      //   178: ifne +14 -> 192
      //   181: aload_0
      //   182: aload_0
      //   183: getfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   186: invokevirtual 118	com/google/protobuf/MapFieldLite:mutableCopy	()Lcom/google/protobuf/MapFieldLite;
      //   189: putfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   192: getstatic 244	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model$DataDefaultEntryHolder:defaultEntry	Lcom/google/protobuf/MapEntryLite;
      //   195: aload_0
      //   196: getfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   199: aload_1
      //   200: aload_2
      //   201: invokevirtual 250	com/google/protobuf/MapEntryLite:parseInto	(Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
      //   204: goto -82 -> 122
      //   207: aload_0
      //   208: aload_1
      //   209: invokevirtual 254	com/google/protobuf/CodedInputStream:readInt64	()J
      //   212: putfield 104	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:timestamp_	J
      //   215: goto -93 -> 122
      //   218: aload_0
      //   219: aload_1
      //   220: invokevirtual 257	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   223: putfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   226: goto -104 -> 122
      //   229: iconst_1
      //   230: istore 4
      //   232: goto -110 -> 122
      //   235: astore_1
      //   236: goto +41 -> 277
      //   239: astore_1
      //   240: new 259	java/lang/RuntimeException
      //   243: dup
      //   244: new 205	com/google/protobuf/InvalidProtocolBufferException
      //   247: dup
      //   248: aload_1
      //   249: invokevirtual 262	java/io/IOException:getMessage	()Ljava/lang/String;
      //   252: invokespecial 264	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   255: aload_0
      //   256: invokevirtual 268	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   259: invokespecial 271	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   262: athrow
      //   263: astore_1
      //   264: new 259	java/lang/RuntimeException
      //   267: dup
      //   268: aload_1
      //   269: aload_0
      //   270: invokevirtual 268	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   273: invokespecial 271	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   276: athrow
      //   277: aload_1
      //   278: athrow
      //   279: getstatic 43	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model;
      //   282: areturn
      //   283: aload_2
      //   284: checkcast 273	com/google/protobuf/GeneratedMessageLite$Visitor
      //   287: astore_1
      //   288: aload_3
      //   289: checkcast 2	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model
      //   292: astore_2
      //   293: aload_0
      //   294: aload_1
      //   295: aload_0
      //   296: getfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   299: invokevirtual 278	java/lang/String:isEmpty	()Z
      //   302: iconst_1
      //   303: ixor
      //   304: aload_0
      //   305: getfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   308: aload_2
      //   309: getfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   312: invokevirtual 278	java/lang/String:isEmpty	()Z
      //   315: iconst_1
      //   316: ixor
      //   317: aload_2
      //   318: getfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   321: invokeinterface 282 5 0
      //   326: putfield 60	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:key_	Ljava/lang/String;
      //   329: aload_0
      //   330: getfield 104	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:timestamp_	J
      //   333: lstore 6
      //   335: lload 6
      //   337: lconst_0
      //   338: lcmp
      //   339: ifeq +9 -> 348
      //   342: iconst_1
      //   343: istore 10
      //   345: goto +6 -> 351
      //   348: iconst_0
      //   349: istore 10
      //   351: aload_2
      //   352: getfield 104	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:timestamp_	J
      //   355: lstore 8
      //   357: lload 8
      //   359: lconst_0
      //   360: lcmp
      //   361: ifeq +9 -> 370
      //   364: iconst_1
      //   365: istore 11
      //   367: goto +6 -> 373
      //   370: iconst_0
      //   371: istore 11
      //   373: aload_0
      //   374: aload_1
      //   375: iload 10
      //   377: lload 6
      //   379: iload 11
      //   381: lload 8
      //   383: invokeinterface 286 7 0
      //   388: putfield 104	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:timestamp_	J
      //   391: aload_0
      //   392: aload_1
      //   393: aload_0
      //   394: getfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   397: aload_2
      //   398: invokespecial 195	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:internalGetData	()Lcom/google/protobuf/MapFieldLite;
      //   401: invokeinterface 290 3 0
      //   406: putfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   409: aload_1
      //   410: getstatic 296	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   413: if_acmpne +16 -> 429
      //   416: aload_0
      //   417: aload_0
      //   418: getfield 298	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:bitField0_	I
      //   421: aload_2
      //   422: getfield 298	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:bitField0_	I
      //   425: ior
      //   426: putfield 298	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:bitField0_	I
      //   429: aload_0
      //   430: areturn
      //   431: new 12	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model$Builder
      //   434: dup
      //   435: aconst_null
      //   436: invokespecial 301	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model$Builder:<init>	(Lcom/farsunset/cim/sdk/android/model/proto/SentBodyProto$1;)V
      //   439: areturn
      //   440: aload_0
      //   441: getfield 56	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   444: invokevirtual 302	com/google/protobuf/MapFieldLite:makeImmutable	()V
      //   447: aconst_null
      //   448: areturn
      //   449: getstatic 43	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model;
      //   452: areturn
      //   453: new 2	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model
      //   456: dup
      //   457: invokespecial 41	com/farsunset/cim/sdk/android/model/proto/SentBodyProto$Model:<init>	()V
      //   460: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	461	0	this	Model
      //   0	461	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	461	2	paramObject1	Object
      //   0	461	3	paramObject2	Object
      //   11	220	4	i	int
      //   8	153	5	j	int
      //   333	45	6	l1	long
      //   355	27	8	l2	long
      //   343	33	10	bool1	boolean
      //   365	15	11	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   77	96	102	finally
      //   96	99	102	finally
      //   103	106	102	finally
      //   127	133	235	finally
      //   159	168	235	finally
      //   171	192	235	finally
      //   192	204	235	finally
      //   207	215	235	finally
      //   218	226	235	finally
      //   240	263	235	finally
      //   264	277	235	finally
      //   127	133	239	java/io/IOException
      //   159	168	239	java/io/IOException
      //   171	192	239	java/io/IOException
      //   192	204	239	java/io/IOException
      //   207	215	239	java/io/IOException
      //   218	226	239	java/io/IOException
      //   127	133	263	com/google/protobuf/InvalidProtocolBufferException
      //   159	168	263	com/google/protobuf/InvalidProtocolBufferException
      //   171	192	263	com/google/protobuf/InvalidProtocolBufferException
      //   192	204	263	com/google/protobuf/InvalidProtocolBufferException
      //   207	215	263	com/google/protobuf/InvalidProtocolBufferException
      //   218	226	263	com/google/protobuf/InvalidProtocolBufferException
    }
    
    @Deprecated
    public Map<String, String> getData()
    {
      return getDataMap();
    }
    
    public int getDataCount()
    {
      return internalGetData().size();
    }
    
    public Map<String, String> getDataMap()
    {
      return Collections.unmodifiableMap(internalGetData());
    }
    
    public String getDataOrDefault(String paramString1, String paramString2)
    {
      Objects.requireNonNull(paramString1);
      MapFieldLite localMapFieldLite = internalGetData();
      if (localMapFieldLite.containsKey(paramString1)) {
        paramString2 = (String)localMapFieldLite.get(paramString1);
      }
      return paramString2;
    }
    
    public String getDataOrThrow(String paramString)
    {
      Objects.requireNonNull(paramString);
      MapFieldLite localMapFieldLite = internalGetData();
      if (localMapFieldLite.containsKey(paramString)) {
        return (String)localMapFieldLite.get(paramString);
      }
      throw new IllegalArgumentException();
    }
    
    public String getKey()
    {
      return this.key_;
    }
    
    public ByteString getKeyBytes()
    {
      return ByteString.copyFromUtf8(this.key_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (!this.key_.isEmpty()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getKey());
      }
      long l = this.timestamp_;
      int j = i;
      if (l != 0L) {
        j = i + CodedOutputStream.computeInt64Size(2, l);
      }
      Iterator localIterator = internalGetData().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        j += DataDefaultEntryHolder.defaultEntry.computeMessageSize(3, localEntry.getKey(), localEntry.getValue());
      }
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public long getTimestamp()
    {
      return this.timestamp_;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
    {
      if (!this.key_.isEmpty()) {
        paramCodedOutputStream.writeString(1, getKey());
      }
      long l = this.timestamp_;
      if (l != 0L) {
        paramCodedOutputStream.writeInt64(2, l);
      }
      Iterator localIterator = internalGetData().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        DataDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 3, localEntry.getKey(), localEntry.getValue());
      }
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<SentBodyProto.Model, Builder>
      implements SentBodyProto.ModelOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearData()
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).getMutableDataMap().clear();
        return this;
      }
      
      public Builder clearKey()
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).clearKey();
        return this;
      }
      
      public Builder clearTimestamp()
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).clearTimestamp();
        return this;
      }
      
      public boolean containsData(String paramString)
      {
        Objects.requireNonNull(paramString);
        return ((SentBodyProto.Model)this.instance).getDataMap().containsKey(paramString);
      }
      
      @Deprecated
      public Map<String, String> getData()
      {
        return getDataMap();
      }
      
      public int getDataCount()
      {
        return ((SentBodyProto.Model)this.instance).getDataMap().size();
      }
      
      public Map<String, String> getDataMap()
      {
        return Collections.unmodifiableMap(((SentBodyProto.Model)this.instance).getDataMap());
      }
      
      public String getDataOrDefault(String paramString1, String paramString2)
      {
        Objects.requireNonNull(paramString1);
        Map localMap = ((SentBodyProto.Model)this.instance).getDataMap();
        if (localMap.containsKey(paramString1)) {
          paramString2 = (String)localMap.get(paramString1);
        }
        return paramString2;
      }
      
      public String getDataOrThrow(String paramString)
      {
        Objects.requireNonNull(paramString);
        Map localMap = ((SentBodyProto.Model)this.instance).getDataMap();
        if (localMap.containsKey(paramString)) {
          return (String)localMap.get(paramString);
        }
        throw new IllegalArgumentException();
      }
      
      public String getKey()
      {
        return ((SentBodyProto.Model)this.instance).getKey();
      }
      
      public ByteString getKeyBytes()
      {
        return ((SentBodyProto.Model)this.instance).getKeyBytes();
      }
      
      public long getTimestamp()
      {
        return ((SentBodyProto.Model)this.instance).getTimestamp();
      }
      
      public Builder putAllData(Map<String, String> paramMap)
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).getMutableDataMap().putAll(paramMap);
        return this;
      }
      
      public Builder putData(String paramString1, String paramString2)
      {
        Objects.requireNonNull(paramString1);
        Objects.requireNonNull(paramString2);
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).getMutableDataMap().put(paramString1, paramString2);
        return this;
      }
      
      public Builder removeData(String paramString)
      {
        Objects.requireNonNull(paramString);
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).getMutableDataMap().remove(paramString);
        return this;
      }
      
      public Builder setKey(String paramString)
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).setKey(paramString);
        return this;
      }
      
      public Builder setKeyBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).setKeyBytes(paramByteString);
        return this;
      }
      
      public Builder setTimestamp(long paramLong)
      {
        copyOnWrite();
        ((SentBodyProto.Model)this.instance).setTimestamp(paramLong);
        return this;
      }
    }
    
    private static final class DataDefaultEntryHolder
    {
      static final MapEntryLite<String, String> defaultEntry;
      
      static
      {
        WireFormat.FieldType localFieldType = WireFormat.FieldType.STRING;
        defaultEntry = MapEntryLite.newDefaultInstance(localFieldType, "", localFieldType, "");
      }
    }
  }
  
  public static abstract interface ModelOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract boolean containsData(String paramString);
    
    @Deprecated
    public abstract Map<String, String> getData();
    
    public abstract int getDataCount();
    
    public abstract Map<String, String> getDataMap();
    
    public abstract String getDataOrDefault(String paramString1, String paramString2);
    
    public abstract String getDataOrThrow(String paramString);
    
    public abstract String getKey();
    
    public abstract ByteString getKeyBytes();
    
    public abstract long getTimestamp();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.proto.SentBodyProto
 * JD-Core Version:    0.7.0.1
 */