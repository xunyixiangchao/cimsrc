package com.farsunset.cim.sdk.android.model.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.util.Objects;

public final class MessageProto
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Model
    extends GeneratedMessageLite<Model, Builder>
    implements MessageProto.ModelOrBuilder
  {
    public static final int ACTION_FIELD_NUMBER = 2;
    public static final int CONTENT_FIELD_NUMBER = 3;
    private static final Model DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 6;
    public static final int FORMAT_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<Model> PARSER;
    public static final int RECEIVER_FIELD_NUMBER = 5;
    public static final int SENDER_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 9;
    public static final int TITLE_FIELD_NUMBER = 7;
    private String action_ = "";
    private String content_ = "";
    private String extra_ = "";
    private String format_ = "";
    private long id_;
    private String receiver_ = "";
    private String sender_ = "";
    private long timestamp_;
    private String title_ = "";
    
    static
    {
      Model localModel = new Model();
      DEFAULT_INSTANCE = localModel;
      localModel.makeImmutable();
    }
    
    private void clearAction()
    {
      this.action_ = getDefaultInstance().getAction();
    }
    
    private void clearContent()
    {
      this.content_ = getDefaultInstance().getContent();
    }
    
    private void clearExtra()
    {
      this.extra_ = getDefaultInstance().getExtra();
    }
    
    private void clearFormat()
    {
      this.format_ = getDefaultInstance().getFormat();
    }
    
    private void clearId()
    {
      this.id_ = 0L;
    }
    
    private void clearReceiver()
    {
      this.receiver_ = getDefaultInstance().getReceiver();
    }
    
    private void clearSender()
    {
      this.sender_ = getDefaultInstance().getSender();
    }
    
    private void clearTimestamp()
    {
      this.timestamp_ = 0L;
    }
    
    private void clearTitle()
    {
      this.title_ = getDefaultInstance().getTitle();
    }
    
    public static Model getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
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
    
    private void setAction(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.action_ = paramString;
    }
    
    private void setActionBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.action_ = paramByteString.toStringUtf8();
    }
    
    private void setContent(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.content_ = paramString;
    }
    
    private void setContentBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.content_ = paramByteString.toStringUtf8();
    }
    
    private void setExtra(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.extra_ = paramString;
    }
    
    private void setExtraBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.extra_ = paramByteString.toStringUtf8();
    }
    
    private void setFormat(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.format_ = paramString;
    }
    
    private void setFormatBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.format_ = paramByteString.toStringUtf8();
    }
    
    private void setId(long paramLong)
    {
      this.id_ = paramLong;
    }
    
    private void setReceiver(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.receiver_ = paramString;
    }
    
    private void setReceiverBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.receiver_ = paramByteString.toStringUtf8();
    }
    
    private void setSender(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.sender_ = paramString;
    }
    
    private void setSenderBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.sender_ = paramByteString.toStringUtf8();
    }
    
    private void setTimestamp(long paramLong)
    {
      this.timestamp_ = paramLong;
    }
    
    private void setTitle(String paramString)
    {
      Objects.requireNonNull(paramString);
      this.title_ = paramString;
    }
    
    private void setTitleBytes(ByteString paramByteString)
    {
      Objects.requireNonNull(paramByteString);
      AbstractMessageLite.checkByteStringIsUtf8(paramByteString);
      this.title_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 300	com/farsunset/cim/sdk/android/model/proto/MessageProto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 306	java/lang/Enum:ordinal	()I
      //   7: iaload
      //   8: istore 5
      //   10: iconst_0
      //   11: istore 4
      //   13: iload 5
      //   15: tableswitch	default:+45 -> 60, 1:+758->773, 2:+754->769, 3:+752->767, 4:+743->758, 5:+351->366, 6:+97->112, 7:+347->362, 8:+53->68
      //   61: aconst_null
      //   62: caload
      //   63: dup
      //   64: invokespecial 309	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: getstatic 311	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   71: ifnonnull +37 -> 108
      //   74: ldc 2
      //   76: monitorenter
      //   77: getstatic 311	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   80: ifnonnull +16 -> 96
      //   83: new 313	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: dup
      //   87: getstatic 55	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/MessageProto$Model;
      //   90: invokespecial 316	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   93: putstatic 311	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   96: ldc 2
      //   98: monitorexit
      //   99: goto +9 -> 108
      //   102: astore_1
      //   103: ldc 2
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      //   108: getstatic 311	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:PARSER	Lcom/google/protobuf/Parser;
      //   111: areturn
      //   112: aload_2
      //   113: checkcast 318	com/google/protobuf/CodedInputStream
      //   116: astore_1
      //   117: aload_3
      //   118: checkcast 320	com/google/protobuf/ExtensionRegistryLite
      //   121: astore_2
      //   122: iload 4
      //   124: ifne +238 -> 362
      //   127: aload_1
      //   128: invokevirtual 323	com/google/protobuf/CodedInputStream:readTag	()I
      //   131: istore 5
      //   133: iload 5
      //   135: ifeq +177 -> 312
      //   138: iload 5
      //   140: bipush 8
      //   142: if_icmpeq +159 -> 301
      //   145: iload 5
      //   147: bipush 18
      //   149: if_icmpeq +141 -> 290
      //   152: iload 5
      //   154: bipush 26
      //   156: if_icmpeq +123 -> 279
      //   159: iload 5
      //   161: bipush 34
      //   163: if_icmpeq +105 -> 268
      //   166: iload 5
      //   168: bipush 42
      //   170: if_icmpeq +87 -> 257
      //   173: iload 5
      //   175: bipush 50
      //   177: if_icmpeq +69 -> 246
      //   180: iload 5
      //   182: bipush 58
      //   184: if_icmpeq +51 -> 235
      //   187: iload 5
      //   189: bipush 66
      //   191: if_icmpeq +33 -> 224
      //   194: iload 5
      //   196: bipush 72
      //   198: if_icmpeq +15 -> 213
      //   201: aload_1
      //   202: iload 5
      //   204: invokevirtual 327	com/google/protobuf/CodedInputStream:skipField	(I)Z
      //   207: ifne -85 -> 122
      //   210: goto +102 -> 312
      //   213: aload_0
      //   214: aload_1
      //   215: invokevirtual 331	com/google/protobuf/CodedInputStream:readInt64	()J
      //   218: putfield 211	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:timestamp_	J
      //   221: goto -99 -> 122
      //   224: aload_0
      //   225: aload_1
      //   226: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   229: putfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   232: goto -110 -> 122
      //   235: aload_0
      //   236: aload_1
      //   237: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   240: putfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   243: goto -121 -> 122
      //   246: aload_0
      //   247: aload_1
      //   248: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   251: putfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   254: goto -132 -> 122
      //   257: aload_0
      //   258: aload_1
      //   259: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   262: putfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   265: goto -143 -> 122
      //   268: aload_0
      //   269: aload_1
      //   270: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   273: putfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   276: goto -154 -> 122
      //   279: aload_0
      //   280: aload_1
      //   281: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   284: putfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   287: goto -165 -> 122
      //   290: aload_0
      //   291: aload_1
      //   292: invokevirtual 334	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
      //   295: putfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   298: goto -176 -> 122
      //   301: aload_0
      //   302: aload_1
      //   303: invokevirtual 331	com/google/protobuf/CodedInputStream:readInt64	()J
      //   306: putfield 203	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:id_	J
      //   309: goto -187 -> 122
      //   312: iconst_1
      //   313: istore 4
      //   315: goto -193 -> 122
      //   318: astore_1
      //   319: goto +41 -> 360
      //   322: astore_1
      //   323: new 336	java/lang/RuntimeException
      //   326: dup
      //   327: new 292	com/google/protobuf/InvalidProtocolBufferException
      //   330: dup
      //   331: aload_1
      //   332: invokevirtual 339	java/io/IOException:getMessage	()Ljava/lang/String;
      //   335: invokespecial 341	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   338: aload_0
      //   339: invokevirtual 345	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   342: invokespecial 348	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   345: athrow
      //   346: astore_1
      //   347: new 336	java/lang/RuntimeException
      //   350: dup
      //   351: aload_1
      //   352: aload_0
      //   353: invokevirtual 345	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   356: invokespecial 348	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   359: athrow
      //   360: aload_1
      //   361: athrow
      //   362: getstatic 55	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/MessageProto$Model;
      //   365: areturn
      //   366: aload_2
      //   367: checkcast 350	com/google/protobuf/GeneratedMessageLite$Visitor
      //   370: astore_1
      //   371: aload_3
      //   372: checkcast 2	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model
      //   375: astore_2
      //   376: aload_0
      //   377: getfield 203	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:id_	J
      //   380: lstore 6
      //   382: lload 6
      //   384: lconst_0
      //   385: lcmp
      //   386: ifeq +9 -> 395
      //   389: iconst_1
      //   390: istore 10
      //   392: goto +6 -> 398
      //   395: iconst_0
      //   396: istore 10
      //   398: aload_2
      //   399: getfield 203	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:id_	J
      //   402: lstore 8
      //   404: lload 8
      //   406: lconst_0
      //   407: lcmp
      //   408: ifeq +9 -> 417
      //   411: iconst_1
      //   412: istore 11
      //   414: goto +6 -> 420
      //   417: iconst_0
      //   418: istore 11
      //   420: aload_0
      //   421: aload_1
      //   422: iload 10
      //   424: lload 6
      //   426: iload 11
      //   428: lload 8
      //   430: invokeinterface 354 7 0
      //   435: putfield 203	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:id_	J
      //   438: aload_0
      //   439: aload_1
      //   440: aload_0
      //   441: getfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   444: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   447: iconst_1
      //   448: ixor
      //   449: aload_0
      //   450: getfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   453: aload_2
      //   454: getfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   457: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   460: iconst_1
      //   461: ixor
      //   462: aload_2
      //   463: getfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   466: invokeinterface 364 5 0
      //   471: putfield 64	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:action_	Ljava/lang/String;
      //   474: aload_0
      //   475: aload_1
      //   476: aload_0
      //   477: getfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   480: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   483: iconst_1
      //   484: ixor
      //   485: aload_0
      //   486: getfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   489: aload_2
      //   490: getfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   493: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   496: iconst_1
      //   497: ixor
      //   498: aload_2
      //   499: getfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   502: invokeinterface 364 5 0
      //   507: putfield 66	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:content_	Ljava/lang/String;
      //   510: aload_0
      //   511: aload_1
      //   512: aload_0
      //   513: getfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   516: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   519: iconst_1
      //   520: ixor
      //   521: aload_0
      //   522: getfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   525: aload_2
      //   526: getfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   529: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   532: iconst_1
      //   533: ixor
      //   534: aload_2
      //   535: getfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   538: invokeinterface 364 5 0
      //   543: putfield 68	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:sender_	Ljava/lang/String;
      //   546: aload_0
      //   547: aload_1
      //   548: aload_0
      //   549: getfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   552: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   555: iconst_1
      //   556: ixor
      //   557: aload_0
      //   558: getfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   561: aload_2
      //   562: getfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   565: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   568: iconst_1
      //   569: ixor
      //   570: aload_2
      //   571: getfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   574: invokeinterface 364 5 0
      //   579: putfield 70	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:receiver_	Ljava/lang/String;
      //   582: aload_0
      //   583: aload_1
      //   584: aload_0
      //   585: getfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   588: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   591: iconst_1
      //   592: ixor
      //   593: aload_0
      //   594: getfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   597: aload_2
      //   598: getfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   601: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   604: iconst_1
      //   605: ixor
      //   606: aload_2
      //   607: getfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   610: invokeinterface 364 5 0
      //   615: putfield 72	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:extra_	Ljava/lang/String;
      //   618: aload_0
      //   619: aload_1
      //   620: aload_0
      //   621: getfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   624: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   627: iconst_1
      //   628: ixor
      //   629: aload_0
      //   630: getfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   633: aload_2
      //   634: getfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   637: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   640: iconst_1
      //   641: ixor
      //   642: aload_2
      //   643: getfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   646: invokeinterface 364 5 0
      //   651: putfield 74	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:title_	Ljava/lang/String;
      //   654: aload_0
      //   655: aload_1
      //   656: aload_0
      //   657: getfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   660: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   663: iconst_1
      //   664: ixor
      //   665: aload_0
      //   666: getfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   669: aload_2
      //   670: getfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   673: invokevirtual 360	java/lang/String:isEmpty	()Z
      //   676: iconst_1
      //   677: ixor
      //   678: aload_2
      //   679: getfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   682: invokeinterface 364 5 0
      //   687: putfield 76	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:format_	Ljava/lang/String;
      //   690: aload_0
      //   691: getfield 211	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:timestamp_	J
      //   694: lstore 6
      //   696: lload 6
      //   698: lconst_0
      //   699: lcmp
      //   700: ifeq +9 -> 709
      //   703: iconst_1
      //   704: istore 10
      //   706: goto +6 -> 712
      //   709: iconst_0
      //   710: istore 10
      //   712: aload_2
      //   713: getfield 211	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:timestamp_	J
      //   716: lstore 8
      //   718: lload 8
      //   720: lconst_0
      //   721: lcmp
      //   722: ifeq +9 -> 731
      //   725: iconst_1
      //   726: istore 11
      //   728: goto +6 -> 734
      //   731: iconst_0
      //   732: istore 11
      //   734: aload_0
      //   735: aload_1
      //   736: iload 10
      //   738: lload 6
      //   740: iload 11
      //   742: lload 8
      //   744: invokeinterface 354 7 0
      //   749: putfield 211	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:timestamp_	J
      //   752: getstatic 370	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   755: astore_1
      //   756: aload_0
      //   757: areturn
      //   758: new 12	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model$Builder
      //   761: dup
      //   762: aconst_null
      //   763: invokespecial 373	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model$Builder:<init>	(Lcom/farsunset/cim/sdk/android/model/proto/MessageProto$1;)V
      //   766: areturn
      //   767: aconst_null
      //   768: areturn
      //   769: getstatic 55	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:DEFAULT_INSTANCE	Lcom/farsunset/cim/sdk/android/model/proto/MessageProto$Model;
      //   772: areturn
      //   773: new 2	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model
      //   776: dup
      //   777: invokespecial 53	com/farsunset/cim/sdk/android/model/proto/MessageProto$Model:<init>	()V
      //   780: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	781	0	this	Model
      //   0	781	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	781	2	paramObject1	Object
      //   0	781	3	paramObject2	Object
      //   11	303	4	i	int
      //   8	195	5	j	int
      //   380	359	6	l1	long
      //   402	341	8	l2	long
      //   390	347	10	bool1	boolean
      //   412	329	11	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   77	96	102	finally
      //   96	99	102	finally
      //   103	106	102	finally
      //   127	133	318	finally
      //   201	210	318	finally
      //   213	221	318	finally
      //   224	232	318	finally
      //   235	243	318	finally
      //   246	254	318	finally
      //   257	265	318	finally
      //   268	276	318	finally
      //   279	287	318	finally
      //   290	298	318	finally
      //   301	309	318	finally
      //   323	346	318	finally
      //   347	360	318	finally
      //   127	133	322	java/io/IOException
      //   201	210	322	java/io/IOException
      //   213	221	322	java/io/IOException
      //   224	232	322	java/io/IOException
      //   235	243	322	java/io/IOException
      //   246	254	322	java/io/IOException
      //   257	265	322	java/io/IOException
      //   268	276	322	java/io/IOException
      //   279	287	322	java/io/IOException
      //   290	298	322	java/io/IOException
      //   301	309	322	java/io/IOException
      //   127	133	346	com/google/protobuf/InvalidProtocolBufferException
      //   201	210	346	com/google/protobuf/InvalidProtocolBufferException
      //   213	221	346	com/google/protobuf/InvalidProtocolBufferException
      //   224	232	346	com/google/protobuf/InvalidProtocolBufferException
      //   235	243	346	com/google/protobuf/InvalidProtocolBufferException
      //   246	254	346	com/google/protobuf/InvalidProtocolBufferException
      //   257	265	346	com/google/protobuf/InvalidProtocolBufferException
      //   268	276	346	com/google/protobuf/InvalidProtocolBufferException
      //   279	287	346	com/google/protobuf/InvalidProtocolBufferException
      //   290	298	346	com/google/protobuf/InvalidProtocolBufferException
      //   301	309	346	com/google/protobuf/InvalidProtocolBufferException
    }
    
    public String getAction()
    {
      return this.action_;
    }
    
    public ByteString getActionBytes()
    {
      return ByteString.copyFromUtf8(this.action_);
    }
    
    public String getContent()
    {
      return this.content_;
    }
    
    public ByteString getContentBytes()
    {
      return ByteString.copyFromUtf8(this.content_);
    }
    
    public String getExtra()
    {
      return this.extra_;
    }
    
    public ByteString getExtraBytes()
    {
      return ByteString.copyFromUtf8(this.extra_);
    }
    
    public String getFormat()
    {
      return this.format_;
    }
    
    public ByteString getFormatBytes()
    {
      return ByteString.copyFromUtf8(this.format_);
    }
    
    public long getId()
    {
      return this.id_;
    }
    
    public String getReceiver()
    {
      return this.receiver_;
    }
    
    public ByteString getReceiverBytes()
    {
      return ByteString.copyFromUtf8(this.receiver_);
    }
    
    public String getSender()
    {
      return this.sender_;
    }
    
    public ByteString getSenderBytes()
    {
      return ByteString.copyFromUtf8(this.sender_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      long l = this.id_;
      if (l != 0L) {
        j = 0 + CodedOutputStream.computeInt64Size(1, l);
      }
      i = j;
      if (!this.action_.isEmpty()) {
        i = j + CodedOutputStream.computeStringSize(2, getAction());
      }
      j = i;
      if (!this.content_.isEmpty()) {
        j = i + CodedOutputStream.computeStringSize(3, getContent());
      }
      i = j;
      if (!this.sender_.isEmpty()) {
        i = j + CodedOutputStream.computeStringSize(4, getSender());
      }
      j = i;
      if (!this.receiver_.isEmpty()) {
        j = i + CodedOutputStream.computeStringSize(5, getReceiver());
      }
      i = j;
      if (!this.extra_.isEmpty()) {
        i = j + CodedOutputStream.computeStringSize(6, getExtra());
      }
      j = i;
      if (!this.title_.isEmpty()) {
        j = i + CodedOutputStream.computeStringSize(7, getTitle());
      }
      i = j;
      if (!this.format_.isEmpty()) {
        i = j + CodedOutputStream.computeStringSize(8, getFormat());
      }
      l = this.timestamp_;
      j = i;
      if (l != 0L) {
        j = i + CodedOutputStream.computeInt64Size(9, l);
      }
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public long getTimestamp()
    {
      return this.timestamp_;
    }
    
    public String getTitle()
    {
      return this.title_;
    }
    
    public ByteString getTitleBytes()
    {
      return ByteString.copyFromUtf8(this.title_);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
    {
      long l = this.id_;
      if (l != 0L) {
        paramCodedOutputStream.writeInt64(1, l);
      }
      if (!this.action_.isEmpty()) {
        paramCodedOutputStream.writeString(2, getAction());
      }
      if (!this.content_.isEmpty()) {
        paramCodedOutputStream.writeString(3, getContent());
      }
      if (!this.sender_.isEmpty()) {
        paramCodedOutputStream.writeString(4, getSender());
      }
      if (!this.receiver_.isEmpty()) {
        paramCodedOutputStream.writeString(5, getReceiver());
      }
      if (!this.extra_.isEmpty()) {
        paramCodedOutputStream.writeString(6, getExtra());
      }
      if (!this.title_.isEmpty()) {
        paramCodedOutputStream.writeString(7, getTitle());
      }
      if (!this.format_.isEmpty()) {
        paramCodedOutputStream.writeString(8, getFormat());
      }
      l = this.timestamp_;
      if (l != 0L) {
        paramCodedOutputStream.writeInt64(9, l);
      }
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<MessageProto.Model, Builder>
      implements MessageProto.ModelOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearAction()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearAction();
        return this;
      }
      
      public Builder clearContent()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearContent();
        return this;
      }
      
      public Builder clearExtra()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearExtra();
        return this;
      }
      
      public Builder clearFormat()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearFormat();
        return this;
      }
      
      public Builder clearId()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearId();
        return this;
      }
      
      public Builder clearReceiver()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearReceiver();
        return this;
      }
      
      public Builder clearSender()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearSender();
        return this;
      }
      
      public Builder clearTimestamp()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearTimestamp();
        return this;
      }
      
      public Builder clearTitle()
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).clearTitle();
        return this;
      }
      
      public String getAction()
      {
        return ((MessageProto.Model)this.instance).getAction();
      }
      
      public ByteString getActionBytes()
      {
        return ((MessageProto.Model)this.instance).getActionBytes();
      }
      
      public String getContent()
      {
        return ((MessageProto.Model)this.instance).getContent();
      }
      
      public ByteString getContentBytes()
      {
        return ((MessageProto.Model)this.instance).getContentBytes();
      }
      
      public String getExtra()
      {
        return ((MessageProto.Model)this.instance).getExtra();
      }
      
      public ByteString getExtraBytes()
      {
        return ((MessageProto.Model)this.instance).getExtraBytes();
      }
      
      public String getFormat()
      {
        return ((MessageProto.Model)this.instance).getFormat();
      }
      
      public ByteString getFormatBytes()
      {
        return ((MessageProto.Model)this.instance).getFormatBytes();
      }
      
      public long getId()
      {
        return ((MessageProto.Model)this.instance).getId();
      }
      
      public String getReceiver()
      {
        return ((MessageProto.Model)this.instance).getReceiver();
      }
      
      public ByteString getReceiverBytes()
      {
        return ((MessageProto.Model)this.instance).getReceiverBytes();
      }
      
      public String getSender()
      {
        return ((MessageProto.Model)this.instance).getSender();
      }
      
      public ByteString getSenderBytes()
      {
        return ((MessageProto.Model)this.instance).getSenderBytes();
      }
      
      public long getTimestamp()
      {
        return ((MessageProto.Model)this.instance).getTimestamp();
      }
      
      public String getTitle()
      {
        return ((MessageProto.Model)this.instance).getTitle();
      }
      
      public ByteString getTitleBytes()
      {
        return ((MessageProto.Model)this.instance).getTitleBytes();
      }
      
      public Builder setAction(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setAction(paramString);
        return this;
      }
      
      public Builder setActionBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setActionBytes(paramByteString);
        return this;
      }
      
      public Builder setContent(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setContent(paramString);
        return this;
      }
      
      public Builder setContentBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setContentBytes(paramByteString);
        return this;
      }
      
      public Builder setExtra(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setExtra(paramString);
        return this;
      }
      
      public Builder setExtraBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setExtraBytes(paramByteString);
        return this;
      }
      
      public Builder setFormat(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setFormat(paramString);
        return this;
      }
      
      public Builder setFormatBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setFormatBytes(paramByteString);
        return this;
      }
      
      public Builder setId(long paramLong)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setId(paramLong);
        return this;
      }
      
      public Builder setReceiver(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setReceiver(paramString);
        return this;
      }
      
      public Builder setReceiverBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setReceiverBytes(paramByteString);
        return this;
      }
      
      public Builder setSender(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setSender(paramString);
        return this;
      }
      
      public Builder setSenderBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setSenderBytes(paramByteString);
        return this;
      }
      
      public Builder setTimestamp(long paramLong)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setTimestamp(paramLong);
        return this;
      }
      
      public Builder setTitle(String paramString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setTitle(paramString);
        return this;
      }
      
      public Builder setTitleBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((MessageProto.Model)this.instance).setTitleBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface ModelOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getAction();
    
    public abstract ByteString getActionBytes();
    
    public abstract String getContent();
    
    public abstract ByteString getContentBytes();
    
    public abstract String getExtra();
    
    public abstract ByteString getExtraBytes();
    
    public abstract String getFormat();
    
    public abstract ByteString getFormatBytes();
    
    public abstract long getId();
    
    public abstract String getReceiver();
    
    public abstract ByteString getReceiverBytes();
    
    public abstract String getSender();
    
    public abstract ByteString getSenderBytes();
    
    public abstract long getTimestamp();
    
    public abstract String getTitle();
    
    public abstract ByteString getTitleBytes();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.proto.MessageProto
 * JD-Core Version:    0.7.0.1
 */