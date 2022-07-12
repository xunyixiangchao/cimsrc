package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a h;
  private NAFavorite a = null;
  private boolean b = false;
  private boolean c = false;
  private Vector<String> d = null;
  private Vector<String> e = null;
  private d f = new d(null);
  private c g = new c(null);
  
  public static a f()
  {
    if (h == null) {
      try
      {
        if (h == null)
        {
          a locala = new a();
          h = locala;
          locala.g();
        }
      }
      finally {}
    }
    return h;
  }
  
  private boolean g()
  {
    if (this.a == null)
    {
      NAFavorite localNAFavorite = new NAFavorite();
      this.a = localNAFavorite;
      if (localNAFavorite.b() == 0L)
      {
        this.a = null;
        return false;
      }
      h();
      i();
    }
    return true;
  }
  
  private void h()
  {
    this.b = false;
    this.c = false;
  }
  
  private boolean i()
  {
    if (this.a == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SysOSUtil.getModuleFileName());
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    this.a.a(1);
    return this.a.a((String)localObject, "fav_poi", "fifo", 10, 501, -1);
  }
  
  public static boolean j()
  {
    Object localObject = h;
    if (localObject != null)
    {
      localObject = ((a)localObject).a;
      if ((localObject != null) && (((NAFavorite)localObject).d())) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public int a(String paramString, FavSyncPoi paramFavSyncPoi)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/baidu/mapsdkplatform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/NAFavorite;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_1
    //   18: ifnull +417 -> 435
    //   21: aload_1
    //   22: ldc 105
    //   24: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +408 -> 435
    //   30: aload_2
    //   31: ifnonnull +6 -> 37
    //   34: goto +401 -> 435
    //   37: aload_0
    //   38: invokespecial 66	com/baidu/mapsdkplatform/comapi/favrite/a:h	()V
    //   41: aload_0
    //   42: invokevirtual 114	com/baidu/mapsdkplatform/comapi/favrite/a:d	()Ljava/util/ArrayList;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +12 -> 61
    //   52: aload 5
    //   54: invokevirtual 120	java/util/ArrayList:size	()I
    //   57: istore_3
    //   58: goto +5 -> 63
    //   61: iconst_0
    //   62: istore_3
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: sipush 500
    //   69: if_icmple +8 -> 77
    //   72: aload_0
    //   73: monitorexit
    //   74: bipush 254
    //   76: ireturn
    //   77: aload 5
    //   79: ifnull +72 -> 151
    //   82: aload 5
    //   84: invokevirtual 120	java/util/ArrayList:size	()I
    //   87: ifle +64 -> 151
    //   90: aload 5
    //   92: invokevirtual 124	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   95: astore 5
    //   97: aload 5
    //   99: invokeinterface 129 1 0
    //   104: ifeq +47 -> 151
    //   107: aload_0
    //   108: aload 5
    //   110: invokeinterface 133 1 0
    //   115: checkcast 107	java/lang/String
    //   118: invokevirtual 136	com/baidu/mapsdkplatform/comapi/favrite/a:b	(Ljava/lang/String;)Lcom/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi;
    //   121: astore 6
    //   123: aload 6
    //   125: ifnonnull +6 -> 131
    //   128: goto -31 -> 97
    //   131: aload_1
    //   132: aload 6
    //   134: getfield 141	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   137: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: istore 4
    //   142: iload 4
    //   144: ifeq -47 -> 97
    //   147: aload_0
    //   148: monitorexit
    //   149: iconst_m1
    //   150: ireturn
    //   151: new 143	org/json/JSONObject
    //   154: dup
    //   155: invokespecial 144	org/json/JSONObject:<init>	()V
    //   158: astore 5
    //   160: aload_2
    //   161: aload_1
    //   162: putfield 141	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   165: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   168: invokestatic 153	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   171: astore 6
    //   173: new 71	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   180: astore_1
    //   181: aload_1
    //   182: aload 6
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: ldc 155
    //   191: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload_2
    //   197: invokevirtual 158	java/lang/Object:hashCode	()I
    //   200: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore_1
    //   209: aload_2
    //   210: aload 6
    //   212: putfield 163	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:h	Ljava/lang/String;
    //   215: aload_2
    //   216: aload_1
    //   217: putfield 165	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:a	Ljava/lang/String;
    //   220: aload 5
    //   222: ldc 167
    //   224: aload_2
    //   225: getfield 169	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:i	Z
    //   228: invokevirtual 173	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload 5
    //   234: ldc 175
    //   236: aload_2
    //   237: getfield 141	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   240: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: new 143	org/json/JSONObject
    //   247: dup
    //   248: invokespecial 144	org/json/JSONObject:<init>	()V
    //   251: astore 6
    //   253: aload 6
    //   255: ldc 180
    //   257: aload_2
    //   258: getfield 183	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:c	Lcom/baidu/platform/comapi/basestruct/Point;
    //   261: invokevirtual 189	com/baidu/platform/comapi/basestruct/Point:getDoubleX	()D
    //   264: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload 6
    //   270: ldc 194
    //   272: aload_2
    //   273: getfield 183	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:c	Lcom/baidu/platform/comapi/basestruct/Point;
    //   276: invokevirtual 197	com/baidu/platform/comapi/basestruct/Point:getDoubleY	()D
    //   279: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload 5
    //   285: ldc 199
    //   287: aload 6
    //   289: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 5
    //   295: ldc 201
    //   297: aload_2
    //   298: getfield 203	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:e	Ljava/lang/String;
    //   301: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload 5
    //   307: ldc 205
    //   309: aload_2
    //   310: getfield 208	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:g	I
    //   313: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 5
    //   319: ldc 213
    //   321: aload_2
    //   322: getfield 215	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:f	Ljava/lang/String;
    //   325: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload 5
    //   331: ldc 217
    //   333: aload_2
    //   334: getfield 219	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:d	Ljava/lang/String;
    //   337: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   340: pop
    //   341: aload 5
    //   343: ldc 221
    //   345: aload_2
    //   346: getfield 163	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:h	Ljava/lang/String;
    //   349: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   352: pop
    //   353: new 143	org/json/JSONObject
    //   356: dup
    //   357: invokespecial 144	org/json/JSONObject:<init>	()V
    //   360: astore 6
    //   362: aload 6
    //   364: ldc 223
    //   366: aload 5
    //   368: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload 6
    //   374: ldc 225
    //   376: aload_2
    //   377: getfield 227	com/baidu/mapsdkplatform/comapi/favrite/FavSyncPoi:j	Ljava/lang/String;
    //   380: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload_0
    //   385: getfield 35	com/baidu/mapsdkplatform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/NAFavorite;
    //   388: aload_1
    //   389: aload 6
    //   391: invokevirtual 228	org/json/JSONObject:toString	()Ljava/lang/String;
    //   394: invokevirtual 231	com/baidu/platform/comjni/map/favorite/NAFavorite:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   397: ifeq +15 -> 412
    //   400: aload_0
    //   401: invokespecial 66	com/baidu/mapsdkplatform/comapi/favrite/a:h	()V
    //   404: invokestatic 233	com/baidu/mapsdkplatform/comapi/favrite/a:j	()Z
    //   407: pop
    //   408: aload_0
    //   409: monitorexit
    //   410: iconst_1
    //   411: ireturn
    //   412: invokestatic 233	com/baidu/mapsdkplatform/comapi/favrite/a:j	()Z
    //   415: pop
    //   416: aload_0
    //   417: monitorexit
    //   418: iconst_0
    //   419: ireturn
    //   420: astore_1
    //   421: invokestatic 233	com/baidu/mapsdkplatform/comapi/favrite/a:j	()Z
    //   424: pop
    //   425: aload_1
    //   426: athrow
    //   427: invokestatic 233	com/baidu/mapsdkplatform/comapi/favrite/a:j	()Z
    //   430: pop
    //   431: aload_0
    //   432: monitorexit
    //   433: iconst_0
    //   434: ireturn
    //   435: aload_0
    //   436: monitorexit
    //   437: iconst_m1
    //   438: ireturn
    //   439: astore_1
    //   440: aload_0
    //   441: monitorexit
    //   442: aload_1
    //   443: athrow
    //   444: astore_1
    //   445: goto -18 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	a
    //   0	448	1	paramString	String
    //   0	448	2	paramFavSyncPoi	FavSyncPoi
    //   57	9	3	i	int
    //   140	3	4	bool	boolean
    //   6	361	5	localObject1	Object
    //   121	269	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   151	220	420	finally
    //   220	232	420	finally
    //   232	253	420	finally
    //   253	268	420	finally
    //   268	293	420	finally
    //   293	305	420	finally
    //   305	317	420	finally
    //   317	329	420	finally
    //   329	341	420	finally
    //   341	372	420	finally
    //   372	404	420	finally
    //   2	8	439	finally
    //   21	30	439	finally
    //   37	47	439	finally
    //   52	58	439	finally
    //   82	97	439	finally
    //   97	123	439	finally
    //   131	142	439	finally
    //   404	408	439	finally
    //   412	416	439	finally
    //   421	427	439	finally
    //   427	431	439	finally
    //   151	220	444	org/json/JSONException
    //   220	232	444	org/json/JSONException
    //   232	253	444	org/json/JSONException
    //   253	268	444	org/json/JSONException
    //   268	293	444	org/json/JSONException
    //   293	305	444	org/json/JSONException
    //   305	317	444	org/json/JSONException
    //   317	329	444	org/json/JSONException
    //   329	341	444	org/json/JSONException
    //   341	372	444	org/json/JSONException
    //   372	404	444	org/json/JSONException
  }
  
  public boolean a()
  {
    try
    {
      NAFavorite localNAFavorite = this.a;
      if (localNAFavorite == null) {
        return false;
      }
      h();
      boolean bool = this.a.a();
      j();
      return bool;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    try
    {
      NAFavorite localNAFavorite = this.a;
      if (localNAFavorite == null) {
        return false;
      }
      if ((paramString != null) && (!paramString.equals("")))
      {
        boolean bool = c(paramString);
        if (!bool) {
          return false;
        }
        h();
        bool = this.a.c(paramString);
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public FavSyncPoi b(String paramString)
  {
    if ((this.a != null) && (paramString != null))
    {
      if (paramString.equals("")) {
        return null;
      }
      try
      {
        if (!c(paramString)) {
          return null;
        }
        FavSyncPoi localFavSyncPoi = new FavSyncPoi();
        Object localObject1 = this.a.a(paramString);
        if (localObject1 != null)
        {
          if (((String)localObject1).equals("")) {
            return null;
          }
          Object localObject2 = new JSONObject((String)localObject1);
          localObject1 = ((JSONObject)localObject2).optJSONObject("Fav_Sync");
          localObject2 = ((JSONObject)localObject2).optString("Fav_Content");
          localFavSyncPoi.b = ((JSONObject)localObject1).optString("uspoiname");
          JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("pt");
          localFavSyncPoi.c = new Point(localJSONObject.optInt("x"), localJSONObject.optInt("y"));
          localFavSyncPoi.e = ((JSONObject)localObject1).optString("ncityid");
          localFavSyncPoi.f = ((JSONObject)localObject1).optString("uspoiuid");
          localFavSyncPoi.g = ((JSONObject)localObject1).optInt("npoitype");
          localFavSyncPoi.d = ((JSONObject)localObject1).optString("addr");
          localFavSyncPoi.h = ((JSONObject)localObject1).optString("addtimesec");
          localFavSyncPoi.i = ((JSONObject)localObject1).optBoolean("bdetail");
          localFavSyncPoi.j = ((String)localObject2);
          localFavSyncPoi.a = paramString;
          return localFavSyncPoi;
        }
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = h;
    if (localObject != null)
    {
      localObject = ((a)localObject).a;
      if (localObject != null)
      {
        ((NAFavorite)localObject).c();
        h.a = null;
      }
      h = null;
    }
  }
  
  public boolean b(String paramString, FavSyncPoi paramFavSyncPoi)
  {
    Object localObject1;
    boolean bool2;
    boolean bool1;
    Object localObject2;
    label274:
    try
    {
      localObject1 = this.a;
      bool2 = false;
      if ((localObject1 != null) && (paramString != null) && (!paramString.equals("")) && (paramFavSyncPoi != null))
      {
        bool1 = c(paramString);
        if (!bool1) {
          return false;
        }
      }
    }
    finally {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uspoiname", paramFavSyncPoi.b);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("x", paramFavSyncPoi.c.getDoubleX());
      ((JSONObject)localObject2).put("y", paramFavSyncPoi.c.getDoubleY());
      ((JSONObject)localObject1).put("pt", localObject2);
      ((JSONObject)localObject1).put("ncityid", paramFavSyncPoi.e);
      ((JSONObject)localObject1).put("npoitype", paramFavSyncPoi.g);
      ((JSONObject)localObject1).put("uspoiuid", paramFavSyncPoi.f);
      ((JSONObject)localObject1).put("addr", paramFavSyncPoi.d);
      localObject2 = String.valueOf(System.currentTimeMillis());
      paramFavSyncPoi.h = ((String)localObject2);
      ((JSONObject)localObject1).put("addtimesec", localObject2);
      ((JSONObject)localObject1).put("bdetail", false);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("Fav_Sync", localObject1);
      ((JSONObject)localObject2).put("Fav_Content", paramFavSyncPoi.j);
      h();
      paramFavSyncPoi = this.a;
      bool1 = bool2;
      if (paramFavSyncPoi != null)
      {
        boolean bool3 = paramFavSyncPoi.b(paramString, ((JSONObject)localObject2).toString());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (JSONException paramString)
    {
      break label274;
    }
    return false;
    return false;
  }
  
  public String c()
  {
    if ((c.a(this.g)) && (!d.a(this.f)) && (!d.b(this.f))) {
      return d.c(this.f);
    }
    c.b(this.g);
    if (this.a == null) {
      return null;
    }
    Object localObject2 = e();
    Object localObject1 = new JSONObject();
    if (localObject2 != null) {}
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((str != null) && (!str.equals("data_version")))
        {
          Object localObject3 = this.a.a(str);
          if ((localObject3 != null) && (!((String)localObject3).equals("")))
          {
            localObject3 = new JSONObject((String)localObject3).optJSONObject("Fav_Sync");
            ((JSONObject)localObject3).put("key", str);
            localJSONArray.put(i, localObject3);
            i += 1;
          }
        }
      }
      if (i > 0)
      {
        ((JSONObject)localObject1).put("favcontents", localJSONArray);
        ((JSONObject)localObject1).put("favpoinum", i);
      }
      c.c(this.g);
      d.a(this.f, ((JSONObject)localObject1).toString());
      localObject1 = d.c(this.f);
      return localObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public boolean c(String paramString)
  {
    return (this.a != null) && (paramString != null) && (!paramString.equals("")) && (this.a.b(paramString));
  }
  
  public ArrayList<String> d()
  {
    Object localObject = this.a;
    ArrayList localArrayList = null;
    if (localObject == null) {
      return null;
    }
    if ((this.b) && (this.d != null)) {
      return new ArrayList(this.d);
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new Bundle();
        this.a.a((Bundle)localObject);
        localObject = ((Bundle)localObject).getStringArray("rstString");
        if (localObject != null)
        {
          Vector localVector2 = this.d;
          if (localVector2 == null) {
            this.d = new Vector();
          } else {
            localVector2.clear();
          }
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            localVector2 = localObject[i];
            if (localVector2.equals("data_version")) {
              break label250;
            }
            this.d.add(localVector2);
            break label250;
          }
          i = this.d.size();
          if (i > 0)
          {
            try
            {
              Collections.sort(this.d, new b());
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            this.b = true;
          }
        }
        else
        {
          localVector1 = this.d;
          if (localVector1 != null)
          {
            localVector1.clear();
            this.d = null;
          }
        }
        Vector localVector1 = this.d;
        if (localVector1 != null)
        {
          if (localVector1.size() == 0) {
            return null;
          }
          localArrayList = new ArrayList(this.d);
        }
        return localArrayList;
      }
      catch (Exception localException1)
      {
        return null;
      }
      label250:
      i += 1;
    }
  }
  
  public ArrayList<String> e()
  {
    Object localObject1 = this.a;
    ArrayList localArrayList = null;
    if (localObject1 == null) {
      return null;
    }
    if ((this.c) && (this.e != null)) {
      return new ArrayList(this.e);
    }
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        this.a.a((Bundle)localObject1);
        localObject1 = ((Bundle)localObject1).getStringArray("rstString");
        if (localObject1 != null)
        {
          Object localObject2 = this.e;
          if (localObject2 == null)
          {
            this.e = new Vector();
            break label259;
          }
          ((Vector)localObject2).clear();
          break label259;
          if (i < localObject1.length)
          {
            if (localObject1[i].equals("data_version")) {
              break label264;
            }
            localObject2 = this.a.a(localObject1[i]);
            if ((localObject2 == null) || (((String)localObject2).equals(""))) {
              break label264;
            }
            this.e.add(localObject1[i]);
            break label264;
          }
          i = this.e.size();
          if (i > 0)
          {
            try
            {
              Collections.sort(this.e, new b());
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            this.c = true;
          }
        }
        else
        {
          localVector = this.e;
          if (localVector != null)
          {
            localVector.clear();
            this.e = null;
          }
        }
        Vector localVector = this.e;
        if (localVector != null)
        {
          if (localVector.isEmpty()) {
            return null;
          }
          localArrayList = new ArrayList(this.e);
        }
        return localArrayList;
      }
      catch (Exception localException1)
      {
        return null;
      }
      label259:
      int i = 0;
      continue;
      label264:
      i += 1;
    }
  }
  
  class b
    implements Comparator<String>
  {
    b() {}
    
    public int a(String paramString1, String paramString2)
    {
      return paramString2.compareTo(paramString1);
    }
  }
  
  private class c
  {
    private long a;
    private long b;
    
    private c() {}
    
    private boolean a()
    {
      return this.b - this.a > 1000L;
    }
    
    private void b()
    {
      this.b = System.currentTimeMillis();
    }
    
    private void c()
    {
      this.a = System.currentTimeMillis();
    }
  }
  
  private class d
  {
    private String a;
    
    private d() {}
    
    private String a()
    {
      return this.a;
    }
    
    private void a(String paramString)
    {
      this.a = paramString;
    }
    
    private boolean b()
    {
      return TextUtils.isEmpty(this.a);
    }
    
    private boolean c()
    {
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.favrite.a
 * JD-Core Version:    0.7.0.1
 */