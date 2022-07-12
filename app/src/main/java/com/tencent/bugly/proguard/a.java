package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private static Proxy e;
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected String b;
  h c;
  private HashMap<String, Object> d;
  
  a()
  {
    new HashMap();
    this.d = new HashMap();
    this.b = "GBK";
    this.c = new h();
  }
  
  public static ActivityManager.ProcessErrorStateInfo a(ActivityManager paramActivityManager, long paramLong)
  {
    if (paramActivityManager == null)
    {
      y.c("get anr state, ActivityManager is null", new Object[0]);
      return null;
    }
    y.c("get anr state, timeout:%d", new Object[] { Long.valueOf(paramLong) });
    paramLong /= 500L;
    int j;
    for (int i = 0;; i = j)
    {
      Object localObject = paramActivityManager.getProcessesInErrorState();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        j = Process.myPid();
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (ActivityManager.ProcessErrorStateInfo)localIterator.next();
          if (((ActivityManager.ProcessErrorStateInfo)localObject).pid == j)
          {
            y.c("found current proc in the error state", new Object[0]);
            break label150;
          }
        }
        y.c("current proc not in the error state", new Object[0]);
      }
      else
      {
        y.c("error state info list is null", new Object[0]);
      }
      localObject = null;
      label150:
      if (localObject == null)
      {
        y.c("found proc state is null", new Object[0]);
      }
      else
      {
        j = ((ActivityManager.ProcessErrorStateInfo)localObject).condition;
        if (j == 2)
        {
          y.c("found proc state is anr! proc:%s", new Object[] { ((ActivityManager.ProcessErrorStateInfo)localObject).processName });
          return localObject;
        }
        if (j == 1)
        {
          y.c("found proc state is crashed!", new Object[0]);
          return null;
        }
      }
      j = i + 1;
      if (i >= paramLong) {
        break;
      }
      y.c("try the %s times:", new Object[] { Integer.valueOf(j) });
      ab.b(500L);
    }
    paramActivityManager = new ActivityManager.ProcessErrorStateInfo();
    paramActivityManager.pid = Process.myPid();
    paramActivityManager.processName = AppInfo.a(Process.myPid());
    paramActivityManager.shortMsg = "Find process anr, but unable to get anr message.";
    return paramActivityManager;
  }
  
  public static an a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    StrategyBean localStrategyBean = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    an localan;
    if ((locala != null) && (localStrategyBean != null)) {
      try
      {
        localan = new an();
        try
        {
          localan.a = 1;
          localan.b = locala.f();
          localan.c = locala.c;
          localan.d = locala.i;
          localan.e = locala.k;
          localan.f = locala.f;
          localan.g = paramInt;
          Object localObject = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            localObject = "".getBytes();
          }
          localan.h = ((byte[])localObject);
          localan.i = locala.l();
          localan.j = locala.g;
          localan.k = new HashMap();
          localan.l = locala.e();
          localan.m = localStrategyBean.n;
          localan.o = locala.k();
          localan.p = com.tencent.bugly.crashreport.common.info.b.b(paramContext);
          localan.q = System.currentTimeMillis();
          localan.r = locala.m();
          paramContext = new StringBuilder();
          paramContext.append(locala.k());
          localan.s = paramContext.toString();
          localan.t = localan.p;
          localan.n = "com.tencent.bugly";
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.w());
          paramContext.put("A26", paramArrayOfByte.toString());
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(com.tencent.bugly.crashreport.common.info.a.H());
          paramContext.put("A62", paramArrayOfByte.toString());
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(com.tencent.bugly.crashreport.common.info.a.I());
          paramContext.put("A63", paramArrayOfByte.toString());
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.z);
          paramContext.put("F11", paramArrayOfByte.toString());
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.y);
          paramContext.put("F12", paramArrayOfByte.toString());
          paramContext = localan.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.j);
          paramContext.put("D3", paramArrayOfByte.toString());
          paramContext = com.tencent.bugly.b.b;
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              localObject = (com.tencent.bugly.a)paramContext.next();
              paramArrayOfByte = ((com.tencent.bugly.a)localObject).versionKey;
              if (paramArrayOfByte != null)
              {
                localObject = ((com.tencent.bugly.a)localObject).version;
                if (localObject != null) {
                  localan.k.put(paramArrayOfByte, localObject);
                }
              }
            }
          }
          localan.k.put("G15", ab.c("G15", ""));
          localan.k.put("G10", ab.c("G10", ""));
          localan.k.put("D4", ab.c("D4", "0"));
          paramContext = locala.B();
          if (paramContext == null) {
            break label729;
          }
          paramContext = paramContext.entrySet().iterator();
          while (paramContext.hasNext())
          {
            paramArrayOfByte = (Map.Entry)paramContext.next();
            if (!TextUtils.isEmpty((CharSequence)paramArrayOfByte.getValue())) {
              localan.k.put(paramArrayOfByte.getKey(), paramArrayOfByte.getValue());
            }
          }
          paramContext = finally;
        }
        finally {}
        y.e("Can not create request pkg for parameters is invalid.", new Object[0]);
      }
      finally
      {
        if (!y.b(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
    } else {
      return null;
    }
    label729:
    return localan;
  }
  
  public static ar a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    ar localar = new ar();
    localar.a = paramUserInfoBean.e;
    localar.e = paramUserInfoBean.j;
    localar.d = paramUserInfoBean.c;
    localar.c = paramUserInfoBean.d;
    boolean bool;
    if (paramUserInfoBean.o == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localar.g = bool;
    int i = paramUserInfoBean.b;
    if (i != 1)
    {
      byte b1 = 4;
      if (i != 2) {
        if (i != 3)
        {
          if (i != 4)
          {
            b1 = 8;
            if (i != 8)
            {
              if ((i >= 10) && (i < 20))
              {
                localar.b = ((byte)i);
                break label183;
              }
              y.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(i) });
              return null;
            }
          }
          else
          {
            localar.b = 3;
            break label183;
          }
        }
        else
        {
          localar.b = 2;
          break label183;
        }
      }
      localar.b = b1;
    }
    else
    {
      localar.b = 1;
    }
    label183:
    Object localObject1 = new HashMap();
    localar.f = ((Map)localObject1);
    if (paramUserInfoBean.p >= 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.p);
      ((Map)localObject1).put("C01", ((StringBuilder)localObject2).toString());
    }
    if (paramUserInfoBean.q >= 0)
    {
      localObject1 = localar.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.q);
      ((Map)localObject1).put("C02", ((StringBuilder)localObject2).toString());
    }
    localObject1 = paramUserInfoBean.r;
    Map localMap;
    StringBuilder localStringBuilder;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = paramUserInfoBean.r.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localar.f;
        localStringBuilder = new StringBuilder("C03_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    localObject1 = paramUserInfoBean.s;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = paramUserInfoBean.s.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localar.f;
        localStringBuilder = new StringBuilder("C04_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    localObject1 = localar.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.l ^ true);
    ((Map)localObject1).put("A36", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.g);
    ((Map)localObject1).put("F02", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.h);
    ((Map)localObject1).put("F03", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.j);
    ((Map)localObject1).put("F04", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.i);
    ((Map)localObject1).put("F05", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.m);
    ((Map)localObject1).put("F06", ((StringBuilder)localObject2).toString());
    localObject1 = localar.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.k);
    ((Map)localObject1).put("F10", ((StringBuilder)localObject2).toString());
    y.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localar.b), Integer.valueOf(localar.f.size()) });
    return localar;
  }
  
  public static as a(List<UserInfoBean> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (localObject1 == null) {
        return null;
      }
      ((com.tencent.bugly.crashreport.common.info.a)localObject1).s();
      as localas = new as();
      localas.b = ((com.tencent.bugly.crashreport.common.info.a)localObject1).d;
      localas.c = ((com.tencent.bugly.crashreport.common.info.a)localObject1).k();
      Object localObject2 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = a((UserInfoBean)paramList.next());
        if (localObject3 != null) {
          ((ArrayList)localObject2).add(localObject3);
        }
      }
      localas.d = ((ArrayList)localObject2);
      paramList = new HashMap();
      localas.e = paramList;
      paramList.put("A7", new StringBuilder().toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(com.tencent.bugly.crashreport.common.info.a.r());
      paramList.put("A6", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).q());
      paramList.put("A5", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).o());
      paramList.put("A2", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).o());
      paramList.put("A1", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).g);
      paramList.put("A24", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).p());
      paramList.put("A17", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).u());
      paramList.put("A15", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).v());
      paramList.put("A13", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).u);
      paramList.put("F08", ((StringBuilder)localObject2).toString());
      paramList = localas.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).v);
      paramList.put("F09", ((StringBuilder)localObject2).toString());
      paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject1).C();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject1 = (Map.Entry)paramList.next();
          localObject2 = localas.e;
          localObject3 = new StringBuilder("C04_");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject1).getKey());
          ((Map)localObject2).put(((StringBuilder)localObject3).toString(), ((Map.Entry)localObject1).getValue());
        }
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          y.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
          return null;
        }
        localas.a = 2;
        return localas;
      }
      localas.a = 1;
      return localas;
    }
    return null;
  }
  
  public static <T extends j> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      try
      {
        paramClass = (j)paramClass.newInstance();
        paramArrayOfByte = new h(paramArrayOfByte);
        paramArrayOfByte.a("utf-8");
        paramClass.a(paramArrayOfByte);
        return paramClass;
      }
      finally
      {
        if (!y.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = paramArrayList.size();
      localObject = "map";
      if (i >= j) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      if ((!str.equals("java.lang.Integer")) && (!str.equals("int")))
      {
        if ((!str.equals("java.lang.Boolean")) && (!str.equals("boolean")))
        {
          if ((!str.equals("java.lang.Byte")) && (!str.equals("byte")))
          {
            if ((!str.equals("java.lang.Double")) && (!str.equals("double")))
            {
              if ((!str.equals("java.lang.Float")) && (!str.equals("float")))
              {
                if ((!str.equals("java.lang.Long")) && (!str.equals("long")))
                {
                  if ((!str.equals("java.lang.Short")) && (!str.equals("short")))
                  {
                    if (!str.equals("java.lang.Character"))
                    {
                      if (str.equals("java.lang.String")) {
                        localObject = "string";
                      } else if (str.equals("java.util.List")) {
                        localObject = "list";
                      } else if (!str.equals("java.util.Map")) {
                        localObject = str;
                      }
                    }
                    else {
                      throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                  }
                  else {
                    localObject = "short";
                  }
                }
                else {
                  localObject = "int64";
                }
              }
              else {
                localObject = "float";
              }
            }
            else {
              localObject = "double";
            }
          }
          else {
            localObject = "char";
          }
        }
        else {
          localObject = "bool";
        }
      }
      else {
        localObject = "int32";
      }
      paramArrayList.set(i, localObject);
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
      }
      for (;;)
      {
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
        break;
        if (((String)localObject).equals("map"))
        {
          j = i - 1;
          localObject = new StringBuilder("<");
          ((StringBuilder)localObject).append((String)paramArrayList.get(j));
          ((StringBuilder)localObject).append(",");
          paramArrayList.set(j, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
        }
        else
        {
          if (!((String)localObject).equals("Array")) {
            break;
          }
          j = i - 1;
          localObject = new StringBuilder("<");
          ((StringBuilder)localObject).append((String)paramArrayList.get(j));
          paramArrayList.set(j, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
        }
      }
      i += 1;
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      e = null;
      return;
    }
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  public static void a(InetAddress paramInetAddress, int paramInt)
  {
    if (paramInetAddress == null)
    {
      e = null;
      return;
    }
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (paramObject.getClass().getComponentType().toString().equals("byte"))
      {
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          a(paramArrayList, Array.get(paramObject, 0));
          return;
        }
        paramArrayList.add("Array");
        paramArrayList.add("?");
        return;
      }
      throw new IllegalArgumentException("only byte[] is supported");
    }
    if (!(paramObject instanceof Array))
    {
      if ((paramObject instanceof List))
      {
        paramArrayList.add("java.util.List");
        paramObject = (List)paramObject;
        if (paramObject.size() > 0) {
          paramObject = paramObject.get(0);
        }
      }
      for (;;)
      {
        a(paramArrayList, paramObject);
        return;
        paramArrayList.add("?");
        return;
        if (!(paramObject instanceof Map)) {
          break label229;
        }
        paramArrayList.add("java.util.Map");
        paramObject = (Map)paramObject;
        if (paramObject.size() <= 0) {
          break;
        }
        Object localObject = paramObject.keySet().iterator().next();
        paramObject = paramObject.get(localObject);
        paramArrayList.add(localObject.getClass().getName());
      }
      paramArrayList.add("?");
      paramArrayList.add("?");
      return;
      label229:
      paramArrayList.add(paramObject.getClass().getName());
      return;
    }
    throw new IllegalArgumentException("can not support Array, please use List");
  }
  
  public static boolean a(ActivityManager paramActivityManager)
  {
    int i;
    if (paramActivityManager == null)
    {
      y.c("is proc running, ActivityManager is null", new Object[0]);
      i = 1;
    }
    else
    {
      Object localObject = paramActivityManager.getRunningAppProcesses();
      if (localObject == null) {
        y.c("running proc info list is empty, my proc not running.", new Object[0]);
      }
      for (;;)
      {
        i = 0;
        break label109;
        i = Process.myPid();
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext()) {
            if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid == i)
            {
              y.c("my proc is running.", new Object[0]);
              break;
            }
          }
        }
        y.c("proc not in running proc info list, my proc not running.", new Object[0]);
      }
    }
    label109:
    if (i != 0) {
      return false;
    }
    return a(paramActivityManager, 0L) != null;
  }
  
  public static byte[] a(j paramj)
  {
    try
    {
      i locali = new i();
      locali.a("utf-8");
      paramj.a(locali);
      paramj = locali.b();
      return paramj;
    }
    finally
    {
      if (!y.b(paramj)) {
        paramj.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      d locald = new d();
      locald.c();
      locald.a("utf-8");
      locald.a(1);
      locald.b("RqdServer");
      locald.c("sync");
      locald.a("detail", paramObject);
      paramObject = locald.a();
      return paramObject;
    }
    finally
    {
      if (!y.b(paramObject)) {
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static ao b(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject2 = new d();
        ((d)localObject2).c();
        ((c)localObject2).a("utf-8");
        ((d)localObject2).a(paramArrayOfByte);
        localObject2 = ((c)localObject2).b("detail", new ao());
        paramArrayOfByte = localObject1;
        if (ao.class.isInstance(localObject2)) {
          paramArrayOfByte = (ao)ao.class.cast(localObject2);
        }
        return paramArrayOfByte;
      }
      finally
      {
        if (!y.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static Proxy b()
  {
    return e;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
          Object localObject = new i();
          ((i)localObject).a(this.b);
          ((i)localObject).a(paramT, 0);
          localObject = k.a(((i)localObject).a());
          HashMap localHashMap = new HashMap(1);
          ArrayList localArrayList = new ArrayList(1);
          a(localArrayList, paramT);
          localHashMap.put(a(localArrayList), localObject);
          this.d.remove(paramString);
          this.a.put(paramString, localHashMap);
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.b);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.c.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    i locali = new i(0);
    locali.a(this.b);
    locali.a(this.a, 0);
    return k.a(locali.a());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.a
 * JD-Core Version:    0.7.0.1
 */