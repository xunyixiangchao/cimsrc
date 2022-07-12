package com.baidu.location.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.a;
import com.baidu.location.e.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class h
{
  public static String c;
  public com.baidu.location.c.h a = null;
  public a b = null;
  final Handler d = new a();
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private long h = 0L;
  private String i = null;
  private String j = null;
  private boolean k = false;
  private long l = 0L;
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/baidu/location/b/h:i	Ljava/lang/String;
    //   4: ifnonnull +13 -> 17
    //   7: aload_0
    //   8: invokestatic 65	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   11: invokestatic 70	com/baidu/location/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   14: putfield 51	com/baidu/location/b/h:i	Ljava/lang/String;
    //   17: aload_0
    //   18: getfield 53	com/baidu/location/b/h:j	Ljava/lang/String;
    //   21: ifnonnull +13 -> 34
    //   24: aload_0
    //   25: invokestatic 65	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   28: invokestatic 72	com/baidu/location/a/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   31: putfield 53	com/baidu/location/b/h:j	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 77	com/baidu/location/c/a:a	()Z
    //   47: ifne +13 -> 60
    //   50: aload_0
    //   51: invokestatic 82	com/baidu/location/c/b:a	()Lcom/baidu/location/c/b;
    //   54: invokevirtual 85	com/baidu/location/c/b:f	()Lcom/baidu/location/c/a;
    //   57: putfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   60: aload_0
    //   61: getfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +10 -> 76
    //   69: aload_1
    //   70: invokevirtual 89	com/baidu/location/c/h:j	()Z
    //   73: ifne +13 -> 86
    //   76: aload_0
    //   77: invokestatic 94	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   80: invokevirtual 98	com/baidu/location/c/i:o	()Lcom/baidu/location/c/h;
    //   83: putfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   86: invokestatic 103	com/baidu/location/c/d:a	()Lcom/baidu/location/c/d;
    //   89: invokevirtual 104	com/baidu/location/c/d:j	()Z
    //   92: ifeq +14 -> 106
    //   95: invokestatic 103	com/baidu/location/c/d:a	()Lcom/baidu/location/c/d;
    //   98: invokevirtual 107	com/baidu/location/c/d:g	()Landroid/location/Location;
    //   101: astore 4
    //   103: goto +6 -> 109
    //   106: aconst_null
    //   107: astore 4
    //   109: aload_0
    //   110: getfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +20 -> 135
    //   118: aload_1
    //   119: invokevirtual 109	com/baidu/location/c/a:d	()Z
    //   122: ifne +13 -> 135
    //   125: aload_0
    //   126: getfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   129: invokevirtual 111	com/baidu/location/c/a:c	()Z
    //   132: ifeq +26 -> 158
    //   135: aload_0
    //   136: getfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +10 -> 151
    //   144: aload_1
    //   145: invokevirtual 114	com/baidu/location/c/h:a	()I
    //   148: ifne +10 -> 158
    //   151: aload 4
    //   153: ifnonnull +5 -> 158
    //   156: aconst_null
    //   157: areturn
    //   158: aload_0
    //   159: invokevirtual 117	com/baidu/location/b/h:b	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload_1
    //   164: astore_3
    //   165: invokestatic 122	com/baidu/location/b/g:a	()Lcom/baidu/location/b/g;
    //   168: invokevirtual 124	com/baidu/location/b/g:d	()I
    //   171: bipush 254
    //   173: if_icmpne +29 -> 202
    //   176: new 126	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   183: astore_3
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_3
    //   191: ldc 133
    //   193: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore_3
    //   202: invokestatic 65	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   205: invokestatic 141	com/baidu/location/e/h:b	(Landroid/content/Context;)I
    //   208: istore_2
    //   209: aload_3
    //   210: astore_1
    //   211: iload_2
    //   212: iflt +111 -> 323
    //   215: new 126	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   222: astore_1
    //   223: aload_1
    //   224: aload_3
    //   225: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: ldc 143
    //   232: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: iload_2
    //   238: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore_3
    //   247: aload_3
    //   248: astore_1
    //   249: getstatic 152	android/os/Build$VERSION:SDK_INT	I
    //   252: bipush 28
    //   254: if_icmplt +69 -> 323
    //   257: aload_3
    //   258: astore_1
    //   259: aload_0
    //   260: getfield 55	com/baidu/location/b/h:k	Z
    //   263: ifne +60 -> 323
    //   266: aload_0
    //   267: iconst_1
    //   268: putfield 55	com/baidu/location/b/h:k	Z
    //   271: aload_3
    //   272: astore_1
    //   273: invokestatic 65	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   276: invokevirtual 158	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   279: ldc 160
    //   281: invokevirtual 166	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   284: ifeq +39 -> 323
    //   287: new 126	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   294: astore_1
    //   295: aload_1
    //   296: aload_3
    //   297: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: ldc 168
    //   304: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore_1
    //   313: goto +10 -> 323
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   321: aload_3
    //   322: astore_1
    //   323: aload_0
    //   324: getfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   327: astore 5
    //   329: aload 5
    //   331: ifnull +13 -> 344
    //   334: aload_1
    //   335: astore_3
    //   336: aload 5
    //   338: invokevirtual 114	com/baidu/location/c/h:a	()I
    //   341: ifne +44 -> 385
    //   344: invokestatic 94	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   347: invokevirtual 175	com/baidu/location/c/i:l	()Ljava/lang/String;
    //   350: astore 5
    //   352: aload_1
    //   353: astore_3
    //   354: aload 5
    //   356: ifnull +29 -> 385
    //   359: new 126	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   366: astore_3
    //   367: aload_3
    //   368: aload 5
    //   370: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_3
    //   375: aload_1
    //   376: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_3
    //   381: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore_3
    //   385: aload_0
    //   386: getfield 40	com/baidu/location/b/h:f	Z
    //   389: ifeq +25 -> 414
    //   392: aload_0
    //   393: iconst_0
    //   394: putfield 40	com/baidu/location/b/h:f	Z
    //   397: aload_0
    //   398: getfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   401: aload_0
    //   402: getfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   405: aload 4
    //   407: aload_3
    //   408: iconst_0
    //   409: iconst_1
    //   410: invokestatic 178	com/baidu/location/e/h:a	(Lcom/baidu/location/c/a;Lcom/baidu/location/c/h;Landroid/location/Location;Ljava/lang/String;IZ)Ljava/lang/String;
    //   413: areturn
    //   414: aload_0
    //   415: getfield 36	com/baidu/location/b/h:b	Lcom/baidu/location/c/a;
    //   418: aload_0
    //   419: getfield 34	com/baidu/location/b/h:a	Lcom/baidu/location/c/h;
    //   422: aload 4
    //   424: aload_3
    //   425: iconst_0
    //   426: invokestatic 181	com/baidu/location/e/h:a	(Lcom/baidu/location/c/a;Lcom/baidu/location/c/h;Landroid/location/Location;Ljava/lang/String;I)Ljava/lang/String;
    //   429: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	h
    //   0	430	1	paramString	String
    //   208	30	2	m	int
    //   164	261	3	localObject1	Object
    //   101	322	4	localLocation	android.location.Location
    //   327	42	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   273	313	316	finally
  }
  
  public abstract void a();
  
  public abstract void a(Message paramMessage);
  
  public String b()
  {
    String str1 = b.a().c();
    Object localObject2;
    if (com.baidu.location.c.i.a().i()) {
      localObject2 = "&cn=32";
    } else {
      localObject2 = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(com.baidu.location.c.b.a().e()) });
    }
    Object localObject1 = localObject2;
    String str2;
    if (System.currentTimeMillis() - this.l > 60000L)
    {
      this.l = System.currentTimeMillis();
      str2 = com.baidu.location.e.h.c();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&qcip6c=");
        ((StringBuilder)localObject1).append(str2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    if (this.e)
    {
      this.e = false;
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = localObject1;
      if (!this.g)
      {
        str2 = r.e();
        localObject2 = localObject1;
        if (str2 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(str2);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        this.g = true;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(str1);
    return ((StringBuilder)localObject1).toString();
  }
  
  public class a
    extends Handler
  {
    public a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!com.baidu.location.f.isServing) {
        return;
      }
      int i = paramMessage.what;
      if (i != 21)
      {
        if ((i != 62) && (i != 63)) {
          return;
        }
        h.this.a();
        return;
      }
      h.this.a(paramMessage);
    }
  }
  
  class b
    extends com.baidu.location.e.f
  {
    String a = null;
    String b = null;
    long c = 0L;
    long d = 0L;
    
    public b()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      if (((com.baidu.location.e.h.g) || (com.baidu.location.e.h.i)) && (h.a(h.this) != null) && (h.b(h.this) != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[] { h.a(h.this), h.b(h.this) }));
        this.b = ((StringBuilder)localObject).toString();
      }
      if (i.a().b())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("&enc=2");
        this.b = ((StringBuilder)localObject).toString();
      }
      Object localObject = Jni.encodeTp4(this.b);
      this.b = null;
      if (this.a == null) {
        this.a = r.b();
      }
      this.j.put("bloc", localObject);
      localObject = this.a;
      if (localObject != null) {
        this.j.put("up", localObject);
      }
      localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.j.put("trtm", localObject);
    }
    
    public void a(String paramString, long paramLong)
    {
      this.b = paramString;
      this.d = System.currentTimeMillis();
      this.c = paramLong;
      paramString = p.a().b();
      if (com.baidu.location.e.h.b())
      {
        a(paramString, false, null);
        return;
      }
      if (paramString != null)
      {
        a(paramString, d.c);
        return;
      }
      b(d.c);
    }
    
    public void a(boolean paramBoolean)
    {
      Object localObject4;
      if (paramBoolean)
      {
        localObject4 = this.i;
        if (localObject4 == null) {}
      }
      try
      {
        h.c = (String)localObject4;
        Object localObject1 = localObject4;
        Object localObject2;
        if (((String)localObject4).contains("enc"))
        {
          paramBoolean = i.a().b();
          localObject1 = localObject4;
          if (paramBoolean) {
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject4);
              localObject1 = localObject4;
              if (localJSONObject.has("enc"))
              {
                localObject1 = localJSONObject.getString("enc");
                localObject1 = i.a().b((String)localObject1);
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              localObject2 = localObject4;
            }
          }
        }
        try
        {
          localObject4 = new BDLocation(localObject2);
          if (((BDLocation)localObject4).getLocType() == 161) {
            g.a().a(localObject2);
          }
          ((BDLocation)localObject4).setOperators(com.baidu.location.c.b.a().h());
          localObject2 = localObject4;
          if (m.a().d())
          {
            ((BDLocation)localObject4).setDirection(m.a().e());
            localObject2 = localObject4;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localObject3 = new BDLocation();
          ((BDLocation)localObject3).setLocType(0);
        }
        this.a = null;
        if ((((BDLocation)localObject3).getLocType() == 0) && (((BDLocation)localObject3).getLatitude() == 4.9E-324D) && (((BDLocation)localObject3).getLongitude() == 4.9E-324D))
        {
          localObject3 = h.this.d.obtainMessage(63);
          ((Message)localObject3).obj = "HttpStatus error";
        }
        for (;;)
        {
          ((Message)localObject3).sendToTarget();
          break;
          long l2 = (System.currentTimeMillis() - this.d) / 1000L;
          long l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.c < 0L) {
            this.c = 0L;
          }
          ((BDLocation)localObject3).setDelayTime(this.c + l1);
          localObject4 = h.this.d.obtainMessage(21);
          ((Message)localObject4).obj = localObject3;
          localObject3 = localObject4;
        }
      }
      catch (Exception localException3)
      {
        Object localObject3;
        label346:
        break label346;
      }
      localObject3 = h.this.d.obtainMessage(63);
      ((Message)localObject3).obj = "HttpStatus error";
      ((Message)localObject3).sendToTarget();
      localObject3 = this.j;
      if (localObject3 != null) {
        ((Map)localObject3).clear();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.h
 * JD-Core Version:    0.7.0.1
 */