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

public final class ReplyBodyProto
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Model
    extends GeneratedMessageLite<Model, Builder>
    implements ReplyBodyProto.ModelOrBuilder
  {
    public static final int CODE_FIELD_NUMBER = 2;
    public static final int DATA_FIELD_NUMBER = 5;
    private static final Model DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile Parser<Model> PARSER;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private int bitField0_;
    private String code_ = "";
    private MapFieldLite<String, String> data_ = MapFieldLite.emptyMapField();
    private String key_ = "";
    private String message_ = "";
    private long timestamp_;
    
    static
    {
      Model localModel = new Model();
      DEFAULT_INSTANCE = localModel;
      localModel.makeImmutable();
    }
    
    private void clearCode()
    {
      this.code_ = getDefaultInstance().getCode();
    }
    
    private void clearKey()
    {
      this.key_ = getDefaultInstance().getKey();
    }
    
    private void clearMessage()
    {
      this.message_ = getDefaultInstance().getMessage();
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
    
    private void setCode(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.code_ = paramString;
    }
    
    private void setCodeBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.code_ = paramByteString.toStringUtf8();
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
    
    private void setMessage(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.message_ = paramString;
    }
    
    private void setMessageBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.message_ = paramByteString.toStringUtf8();
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
      //   0: getstatic 253	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 259	java/lang/Enum:ordinal	()I
      //   7: iaload
      //   8: istore 5
      //   10: iconst_0
      //   11: istore 4
      //   13: iload 5
      //   15: tableswitch	default:+45 -> 60, 1:+546->561, 2:+542->557, 3:+533->548, 4:+524->539, 5:+304->319, 6:+97->112, 7:+300->315, 8:+53->68
      //   61: aconst_null
      //   62: iconst_2
      //   63: dup
      //   64: invokespecial 262	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: getstatic 264	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   71: ifnonnull +37 -> 108
      //   74: ldc 2
      //   76: monitorenter
      //   77: getstatic 264	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   80: ifnonnull +16 -> 96
      //   83: new 266	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: dup
      //   87: getstatic 49	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model;
      //   90: invokespecial 269	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   93: putstatic 264	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   96: ldc 2
      //   98: monitorexit
      //   99: goto +9 -> 108
      //   102: astore_1
      //   103: ldc 2
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      //   108: getstatic 264	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   111: areturn
      //   112: aload_2
      //   113: checkcast 271	com/google/protobuf/CodedInputStream
      //   116: astore_1
      //   117: aload_3
      //   118: checkcast 273	com/google/protobuf/ExtensionRegistryLite
      //   121: astore_2
      //   122: iload 4
      //   124: ifne +191 -> 315
      //   127: aload_1
      //   128: invokevirtual 276	com/google/protobuf/CodedInputStream:readTag	()I
      //   131: istore 5
      //   133: iload 5
      //   135: ifeq +130 -> 265
      //   138: iload 5
      //   140: bipush 10
      //   142: if_icmpeq +112 -> 254
      //   145: iload 5
      //   147: bipush 18
      //   149: if_icmpeq +94 -> 243
      //   152: iload 5
      //   154: bipush 26
      //   156: if_icmpeq +76 -> 232
      //   159: iload 5
      //   161: bipush 32
      //   163: if_icmpeq +58 -> 221
      //   166: iload 5
      //   168: bipush 42
      //   170: if_icmpeq +15 -> 185
      //   173: aload_1
      //   174: iload 5
      //   176: invokevirtual 280	com/google/protobuf/CodedInputStream:skipField	(I)Z
      //   179: ifne -57 -> 122
      //   182: goto +83 -> 265
      //   185: aload_0
      //   186: getfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   189: invokevirtual 155	com/google/protobuf/MapFieldLite:isMutable	()Z
      //   192: ifne +14 -> 206
      //   195: aload_0
      //   196: aload_0
      //   197: getfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   200: invokevirtual 158	com/google/protobuf/MapFieldLite:mutableCopy	()Lcom/google/protobuf/MapFieldLite;
      //   203: putfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   206: getstatic 284	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model$DataDefaultEntryHolder:defaultEntry	Lcom/google/protobuf/MapEntryLite;
      //   209: aload_0
      //   210: getfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   213: aload_1
      //   214: aload_2
      //   215: invokevirtual 290	com/google/protobuf/MapEntryLite:parseInto	(Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
      //   218: goto -96 -> 122
      //   221: aload_0
      //   222: aload_1
      //   223: invokevirtual 294	com/google/protobuf/CodedInputStream:readInt64	()J
      //   226: putfield 144	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:timestamp_	J
      //   229: goto -107 -> 122
      //   232: aload_0
      //   233: aload_1
      //   234: invokevirtual 297	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   237: putfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   240: goto -118 -> 122
      //   243: aload_0
      //   244: aload_1
      //   245: invokevirtual 297	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   248: putfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   251: goto -129 -> 122
      //   254: aload_0
      //   255: aload_1
      //   256: invokevirtual 297	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   259: putfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   262: goto -140 -> 122
      //   265: iconst_1
      //   266: istore 4
      //   268: goto -146 -> 122
      //   271: astore_1
      //   272: goto +41 -> 313
      //   275: astore_1
      //   276: new 299	java/lang/RuntimeException
      //   279: dup
      //   280: new 245	com/google/protobuf/InvalidProtocolBufferException
      //   283: dup
      //   284: aload_1
      //   285: invokevirtual 300	java/io/IOException:getMessage	()Ljava/lang/String;
      //   288: invokespecial 302	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   291: aload_0
      //   292: invokevirtual 306	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   295: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   298: athrow
      //   299: astore_1
      //   300: new 299	java/lang/RuntimeException
      //   303: dup
      //   304: aload_1
      //   305: aload_0
      //   306: invokevirtual 306	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   309: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   312: athrow
      //   313: aload_1
      //   314: athrow
      //   315: getstatic 49	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model;
      //   318: areturn
      //   319: aload_2
      //   320: checkcast 311	com/google/protobuf/GeneratedMessageLite$Visitor
      //   323: astore_1
      //   324: aload_3
      //   325: checkcast 2	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model
      //   328: astore_2
      //   329: aload_0
      //   330: aload_1
      //   331: aload_0
      //   332: getfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   335: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   338: iconst_1
      //   339: ixor
      //   340: aload_0
      //   341: getfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   344: aload_2
      //   345: getfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   348: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   351: iconst_1
      //   352: ixor
      //   353: aload_2
      //   354: getfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   357: invokeinterface 320 5 0
      //   362: putfield 66	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:key_	Ljava/lang/String;
      //   365: aload_0
      //   366: aload_1
      //   367: aload_0
      //   368: getfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   371: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   374: iconst_1
      //   375: ixor
      //   376: aload_0
      //   377: getfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   380: aload_2
      //   381: getfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   384: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   387: iconst_1
      //   388: ixor
      //   389: aload_2
      //   390: getfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   393: invokeinterface 320 5 0
      //   398: putfield 68	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:code_	Ljava/lang/String;
      //   401: aload_0
      //   402: aload_1
      //   403: aload_0
      //   404: getfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   407: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   410: iconst_1
      //   411: ixor
      //   412: aload_0
      //   413: getfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   416: aload_2
      //   417: getfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   420: invokevirtual 316	java/lang/String:isEmpty	()Z
      //   423: iconst_1
      //   424: ixor
      //   425: aload_2
      //   426: getfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   429: invokeinterface 320 5 0
      //   434: putfield 70	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:message_	Ljava/lang/String;
      //   437: aload_0
      //   438: getfield 144	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:timestamp_	J
      //   441: lstore 6
      //   443: lload 6
      //   445: lconst_0
      //   446: lcmp
      //   447: ifeq +9 -> 456
      //   450: iconst_1
      //   451: istore 10
      //   453: goto +6 -> 459
      //   456: iconst_0
      //   457: istore 10
      //   459: aload_2
      //   460: getfield 144	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:timestamp_	J
      //   463: lstore 8
      //   465: lload 8
      //   467: lconst_0
      //   468: lcmp
      //   469: ifeq +9 -> 478
      //   472: iconst_1
      //   473: istore 11
      //   475: goto +6 -> 481
      //   478: iconst_0
      //   479: istore 11
      //   481: aload_0
      //   482: aload_1
      //   483: iload 10
      //   485: lload 6
      //   487: iload 11
      //   489: lload 8
      //   491: invokeinterface 324 7 0
      //   496: putfield 144	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:timestamp_	J
      //   499: aload_0
      //   500: aload_1
      //   501: aload_0
      //   502: getfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   505: aload_2
      //   506: invokespecial 235	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:internalGetData	()Lcom/google/protobuf/MapFieldLite;
      //   509: invokeinterface 328 3 0
      //   514: putfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   517: aload_1
      //   518: getstatic 334	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   521: if_acmpne +16 -> 537
      //   524: aload_0
      //   525: aload_0
      //   526: getfield 336	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:bitField0_	I
      //   529: aload_2
      //   530: getfield 336	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:bitField0_	I
      //   533: ior
      //   534: putfield 336	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:bitField0_	I
      //   537: aload_0
      //   538: areturn
      //   539: new 12	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model$Builder
      //   542: dup
      //   543: aconst_null
      //   544: invokespecial 339	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model$Builder:<init>	(Lcom/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$1;)V
      //   547: areturn
      //   548: aload_0
      //   549: getfield 62	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:data_	Lcom/google/protobuf/MapFieldLite;
      //   552: invokevirtual 340	com/google/protobuf/MapFieldLite:makeImmutable	()V
      //   555: aconst_null
      //   556: areturn
      //   557: getstatic 49	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model;
      //   560: areturn
      //   561: new 2	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model
      //   564: dup
      //   565: invokespecial 47	com/farsunset/cim/sdk/android/model/proto/ReplyBodyProto$Model:<init>	()V
      //   568: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	569	0	this	Model
      //   0	569	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	569	2	paramObject1	Object
      //   0	569	3	paramObject2	Object
      //   11	256	4	i	int
      //   8	167	5	j	int
      //   441	45	6	l1	long
      //   463	27	8	l2	long
      //   451	33	10	bool1	boolean
      //   473	15	11	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   77	96	102	finally
      //   96	99	102	finally
      //   103	106	102	finally
      //   127	133	271	finally
      //   173	182	271	finally
      //   185	206	271	finally
      //   206	218	271	finally
      //   221	229	271	finally
      //   232	240	271	finally
      //   243	251	271	finally
      //   254	262	271	finally
      //   276	299	271	finally
      //   300	313	271	finally
      //   127	133	275	java/io/IOException
      //   173	182	275	java/io/IOException
      //   185	206	275	java/io/IOException
      //   206	218	275	java/io/IOException
      //   221	229	275	java/io/IOException
      //   232	240	275	java/io/IOException
      //   243	251	275	java/io/IOException
      //   254	262	275	java/io/IOException
      //   127	133	299	com/google/protobuf/InvalidProtocolBufferException
      //   173	182	299	com/google/protobuf/InvalidProtocolBufferException
      //   185	206	299	com/google/protobuf/InvalidProtocolBufferException
      //   206	218	299	com/google/protobuf/InvalidProtocolBufferException
      //   221	229	299	com/google/protobuf/InvalidProtocolBufferException
      //   232	240	299	com/google/protobuf/InvalidProtocolBufferException
      //   243	251	299	com/google/protobuf/InvalidProtocolBufferException
      //   254	262	299	com/google/protobuf/InvalidProtocolBufferException
    }
    
    public String getCode()
    {
      return this.code_;
    }
    
    public ByteString getCodeBytes()
    {
      return ByteString.copyFromUtf8(this.code_);
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
    
    public String getMessage()
    {
      return this.message_;
    }
    
    public ByteString getMessageBytes()
    {
      return ByteString.copyFromUtf8(this.message_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (!this.key_.isEmpty()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getKey());
      }
      i = j;
      if (!this.code_.isEmpty()) {
        i = j + CodedOutputStream.computeStringSize(2, getCode());
      }
      j = i;
      if (!this.message_.isEmpty()) {
        j = i + CodedOutputStream.computeStringSize(3, getMessage());
      }
      long l = this.timestamp_;
      i = j;
      if (l != 0L) {
        i = j + CodedOutputStream.computeInt64Size(4, l);
      }
      Iterator localIterator = internalGetData().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        i += DataDefaultEntryHolder.defaultEntry.computeMessageSize(5, localEntry.getKey(), localEntry.getValue());
      }
      this.memoizedSerializedSize = i;
      return i;
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
      if (!this.code_.isEmpty()) {
        paramCodedOutputStream.writeString(2, getCode());
      }
      if (!this.message_.isEmpty()) {
        paramCodedOutputStream.writeString(3, getMessage());
      }
      long l = this.timestamp_;
      if (l != 0L) {
        paramCodedOutputStream.writeInt64(4, l);
      }
      Iterator localIterator = internalGetData().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        DataDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 5, localEntry.getKey(), localEntry.getValue());
      }
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<ReplyBodyProto.Model, Builder>
      implements ReplyBodyProto.ModelOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearCode()
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).clearCode();
        return this;
      }
      
      public Builder clearData()
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).getMutableDataMap().clear();
        return this;
      }
      
      public Builder clearKey()
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).clearKey();
        return this;
      }
      
      public Builder clearMessage()
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).clearMessage();
        return this;
      }
      
      public Builder clearTimestamp()
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).clearTimestamp();
        return this;
      }
      
      public boolean containsData(String paramString)
      {
        Objects.requireNonNull(paramString);
        return ((ReplyBodyProto.Model)this.instance).getDataMap().containsKey(paramString);
      }
      
      public String getCode()
      {
        return ((ReplyBodyProto.Model)this.instance).getCode();
      }
      
      public ByteString getCodeBytes()
      {
        return ((ReplyBodyProto.Model)this.instance).getCodeBytes();
      }
      
      @Deprecated
      public Map<String, String> getData()
      {
        return getDataMap();
      }
      
      public int getDataCount()
      {
        return ((ReplyBodyProto.Model)this.instance).getDataMap().size();
      }
      
      public Map<String, String> getDataMap()
      {
        return Collections.unmodifiableMap(((ReplyBodyProto.Model)this.instance).getDataMap());
      }
      
      public String getDataOrDefault(String paramString1, String paramString2)
      {
        Objects.requireNonNull(paramString1);
        Map localMap = ((ReplyBodyProto.Model)this.instance).getDataMap();
        if (localMap.containsKey(paramString1)) {
          paramString2 = (String)localMap.get(paramString1);
        }
        return paramString2;
      }
      
      public String getDataOrThrow(String paramString)
      {
        Objects.requireNonNull(paramString);
        Map localMap = ((ReplyBodyProto.Model)this.instance).getDataMap();
        if (localMap.containsKey(paramString)) {
          return (String)localMap.get(paramString);
        }
        throw new IllegalArgumentException();
      }
      
      public String getKey()
      {
        return ((ReplyBodyProto.Model)this.instance).getKey();
      }
      
      public ByteString getKeyBytes()
      {
        return ((ReplyBodyProto.Model)this.instance).getKeyBytes();
      }
      
      public String getMessage()
      {
        return ((ReplyBodyProto.Model)this.instance).getMessage();
      }
      
      public ByteString getMessageBytes()
      {
        return ((ReplyBodyProto.Model)this.instance).getMessageBytes();
      }
      
      public long getTimestamp()
      {
        return ((ReplyBodyProto.Model)this.instance).getTimestamp();
      }
      
      public Builder putAllData(Map<String, String> paramMap)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).getMutableDataMap().putAll(paramMap);
        return this;
      }
      
      public Builder putData(String paramString1, String paramString2)
      {
        Objects.requireNonNull(paramString1);
        Objects.requireNonNull(paramString2);
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).getMutableDataMap().put(paramString1, paramString2);
        return this;
      }
      
      public Builder removeData(String paramString)
      {
        Objects.requireNonNull(paramString);
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).getMutableDataMap().remove(paramString);
        return this;
      }
      
      public Builder setCode(String paramString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setCode(paramString);
        return this;
      }
      
      public Builder setCodeBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setCodeBytes(paramByteString);
        return this;
      }
      
      public Builder setKey(String paramString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setKey(paramString);
        return this;
      }
      
      public Builder setKeyBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setKeyBytes(paramByteString);
        return this;
      }
      
      public Builder setMessage(String paramString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setMessage(paramString);
        return this;
      }
      
      public Builder setMessageBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setMessageBytes(paramByteString);
        return this;
      }
      
      public Builder setTimestamp(long paramLong)
      {
        copyOnWrite();
        ((ReplyBodyProto.Model)this.instance).setTimestamp(paramLong);
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
    
    public abstract String getCode();
    
    public abstract ByteString getCodeBytes();
    
    @Deprecated
    public abstract Map<String, String> getData();
    
    public abstract int getDataCount();
    
    public abstract Map<String, String> getDataMap();
    
    public abstract String getDataOrDefault(String paramString1, String paramString2);
    
    public abstract String getDataOrThrow(String paramString);
    
    public abstract String getKey();
    
    public abstract ByteString getKeyBytes();
    
    public abstract String getMessage();
    
    public abstract ByteString getMessageBytes();
    
    public abstract long getTimestamp();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.proto.ReplyBodyProto
 * JD-Core Version:    0.7.0.1
 */