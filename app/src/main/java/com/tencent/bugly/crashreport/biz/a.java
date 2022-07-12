package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.j;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.crashreport.biz.UserInfoBean;>;

public final class a
{
  private Context a;
  private long b;
  private int c;
  private boolean d;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static int a(List<UserInfoBean> paramList, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      UserInfoBean localUserInfoBean = (UserInfoBean)paramList.next();
      if (localUserInfoBean.e > paramLong - 600000L)
      {
        int j = localUserInfoBean.b;
        if ((j == 1) || (j == 4) || (j == 3)) {
          i += 1;
        }
      }
    }
    return i;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      long l = paramUserInfoBean.a;
      if (l > 0L) {
        localContentValues.put("_id", Long.valueOf(l));
      }
      localContentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
      localContentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
      localContentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
      localContentValues.put("_pc", paramUserInfoBean.c);
      localContentValues.put("_dt", ab.a(paramUserInfoBean));
      return localContentValues;
    }
    finally
    {
      if (!y.a(paramUserInfoBean)) {
        paramUserInfoBean.printStackTrace();
      }
    }
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null) {
        return null;
      }
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      paramCursor = (UserInfoBean)ab.a(arrayOfByte, UserInfoBean.CREATOR);
      if (paramCursor != null) {
        paramCursor.a = l;
      }
      return paramCursor;
    }
    finally
    {
      if (!y.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private static void a(List<UserInfoBean> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < paramList.size()) && (i < 50))
      {
        localObject = (UserInfoBean)paramList.get(i);
        localStringBuilder.append(" or _id");
        localStringBuilder.append(" = ");
        localStringBuilder.append(((UserInfoBean)localObject).a);
        i += 1;
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<UserInfoBean>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        y.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(o.a().a("t_ui", paramList, null, null, true)) });
        return;
      }
      finally
      {
        if (!y.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private static void a(List<UserInfoBean> paramList1, List<UserInfoBean> paramList2)
  {
    int n = paramList1.size() - 20;
    if (n > 0)
    {
      int m = 0;
      int j;
      for (int i = 0;; i = j)
      {
        j = m;
        if (i >= paramList1.size() - 1) {
          break;
        }
        j = i + 1;
        int k = j;
        while (k < paramList1.size())
        {
          if (((UserInfoBean)paramList1.get(i)).e > ((UserInfoBean)paramList1.get(k)).e)
          {
            UserInfoBean localUserInfoBean = (UserInfoBean)paramList1.get(i);
            paramList1.set(i, paramList1.get(k));
            paramList1.set(k, localUserInfoBean);
          }
          k += 1;
        }
      }
      while (j < n)
      {
        paramList2.add(paramList1.get(j));
        j += 1;
      }
    }
  }
  
  private static void b(List<UserInfoBean> paramList1, List<UserInfoBean> paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      UserInfoBean localUserInfoBean = (UserInfoBean)paramList1.next();
      if (localUserInfoBean.f != -1L)
      {
        paramList1.remove();
        if (localUserInfoBean.e < ab.b()) {
          paramList2.add(localUserInfoBean);
        }
      }
    }
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (this.d)
        {
          Object localObject1 = v.a();
          if (localObject1 != null)
          {
            Object localObject3 = com.tencent.bugly.crashreport.common.strategy.a.a();
            if (localObject3 != null) {
              if (((com.tencent.bugly.crashreport.common.strategy.a)localObject3).b())
              {
                bool = ((v)localObject1).b(1001);
                if (!bool) {}
              }
              else
              {
                i = 1;
                if (i == 0) {
                  return;
                }
                localObject1 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
                Object localObject4 = new ArrayList();
                localObject3 = a((String)localObject1);
                if (localObject3 != null)
                {
                  a((List)localObject3, (List)localObject4);
                  b((List)localObject3, (List)localObject4);
                  i = a((List)localObject3, 600000L);
                  localObject1 = localObject3;
                  if (i <= 15) {
                    break label408;
                  }
                  y.d("[UserInfo] Upload user info too many times in 10 min: %d", new Object[] { Integer.valueOf(i) });
                  i = 0;
                  localObject1 = localObject3;
                }
                else
                {
                  localObject1 = new ArrayList();
                  break label408;
                }
                if (((List)localObject4).size() > 0) {
                  a((List)localObject4);
                }
                if ((i != 0) && (((List)localObject1).size() != 0))
                {
                  y.c("[UserInfo] Upload user info(size: %d)", new Object[] { Integer.valueOf(((List)localObject1).size()) });
                  if (this.c != 1) {
                    break label413;
                  }
                  i = 1;
                  localObject3 = com.tencent.bugly.proguard.a.a((List)localObject1, i);
                  if (localObject3 == null)
                  {
                    y.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                    return;
                  }
                  localObject3 = com.tencent.bugly.proguard.a.a((j)localObject3);
                  if (localObject3 == null)
                  {
                    y.d("[UserInfo] Failed to encode data.", new Object[0]);
                    return;
                  }
                  localObject3 = com.tencent.bugly.proguard.a.a(this.a, 840, (byte[])localObject3);
                  if (localObject3 == null)
                  {
                    y.d("[UserInfo] Request package is null.", new Object[0]);
                    return;
                  }
                  localObject1 = new a((List)localObject1);
                  localObject4 = com.tencent.bugly.crashreport.common.strategy.a.a().c().p;
                  String str = StrategyBean.a;
                  v localv = v.a();
                  if (this.c != 1) {
                    break label418;
                  }
                  bool = true;
                  localv.a(1001, (an)localObject3, (String)localObject4, str, (u)localObject1, bool);
                  return;
                }
                y.c("[UserInfo] There is no user info in local database.", new Object[0]);
                return;
              }
            }
          }
        }
      }
      finally {}
      int i = 0;
      continue;
      label408:
      i = 1;
      continue;
      label413:
      i = 2;
      continue;
      label418:
      boolean bool = false;
    }
  }
  
  public final List<UserInfoBean> a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (ab.a(paramString))
        {
          paramString = null;
        }
        else
        {
          localObject1 = new StringBuilder("_pc = '");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("'");
          paramString = ((StringBuilder)localObject1).toString();
        }
        paramString = o.a().a("t_ui", null, paramString, null, null, true);
        if (paramString == null)
        {
          if (paramString != null) {
            paramString.close();
          }
          return null;
        }
        try
        {
          localObject4 = new StringBuilder();
          localObject1 = new ArrayList();
          if (paramString.moveToNext())
          {
            UserInfoBean localUserInfoBean = a(paramString);
            if (localUserInfoBean != null) {
              ((List)localObject1).add(localUserInfoBean);
            }
          }
        }
        finally
        {
          Object localObject4;
          long l;
        }
      }
      finally
      {
        paramString = null;
      }
      try
      {
        l = paramString.getLong(paramString.getColumnIndex("_id"));
        ((StringBuilder)localObject4).append(" or _id");
        ((StringBuilder)localObject4).append(" = ");
        ((StringBuilder)localObject4).append(l);
        continue;
      }
      finally {}
      y.d("[Database] unknown id.", new Object[0]);
      continue;
      localObject4 = ((StringBuilder)localObject4).toString();
      if (((String)localObject4).length() > 0)
      {
        localObject4 = ((String)localObject4).substring(4);
        y.d("[Database] deleted %s error data %d", new Object[] { "t_ui", Integer.valueOf(o.a().a("t_ui", (String)localObject4, null, null, true)) });
      }
      paramString.close();
      return localObject1;
    }
    try
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public final void a()
  {
    this.b = (ab.b() + 86400000L);
    x.a().a(new d(), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject = com.tencent.bugly.crashreport.common.strategy.a.a();
    int i = 0;
    if ((localObject != null) && (!((com.tencent.bugly.crashreport.common.strategy.a)localObject).c().f) && (paramInt != 1) && (paramInt != 3))
    {
      y.e("UserInfo is disable", new Object[0]);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3)) {
      this.c += 1;
    }
    localObject = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean localUserInfoBean = new UserInfoBean();
    localUserInfoBean.b = paramInt;
    localUserInfoBean.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localUserInfoBean.d = ((com.tencent.bugly.crashreport.common.info.a)localObject).g();
    localUserInfoBean.e = System.currentTimeMillis();
    localUserInfoBean.f = -1L;
    localUserInfoBean.n = ((com.tencent.bugly.crashreport.common.info.a)localObject).i;
    if (paramInt == 1) {
      i = 1;
    }
    localUserInfoBean.o = i;
    localUserInfoBean.l = ((com.tencent.bugly.crashreport.common.info.a)localObject).a();
    localUserInfoBean.m = ((com.tencent.bugly.crashreport.common.info.a)localObject).o;
    localUserInfoBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).p;
    localUserInfoBean.h = ((com.tencent.bugly.crashreport.common.info.a)localObject).q;
    localUserInfoBean.i = ((com.tencent.bugly.crashreport.common.info.a)localObject).r;
    localUserInfoBean.k = ((com.tencent.bugly.crashreport.common.info.a)localObject).s;
    localUserInfoBean.r = ((com.tencent.bugly.crashreport.common.info.a)localObject).x();
    localUserInfoBean.s = ((com.tencent.bugly.crashreport.common.info.a)localObject).C();
    localUserInfoBean.p = ((com.tencent.bugly.crashreport.common.info.a)localObject).D();
    localUserInfoBean.q = ((com.tencent.bugly.crashreport.common.info.a)localObject).E();
    x.a().a(new c(localUserInfoBean, paramBoolean), 0L);
  }
  
  public final void b()
  {
    x localx = x.a();
    if (localx != null) {
      localx.a(new b());
    }
  }
  
  final class a
    implements u
  {
    a(List paramList) {}
    
    public final void a(boolean paramBoolean, String paramString)
    {
      if (paramBoolean)
      {
        y.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
        long l = System.currentTimeMillis();
        paramString = this.a.iterator();
        while (paramString.hasNext())
        {
          UserInfoBean localUserInfoBean = (UserInfoBean)paramString.next();
          localUserInfoBean.f = l;
          a.a(a.this, localUserInfoBean, true);
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      try
      {
        a.a(a.this);
        return;
      }
      finally
      {
        y.a(localThrowable);
      }
    }
  }
  
  final class c
    implements Runnable
  {
    private boolean a;
    private UserInfoBean b;
    
    public c(UserInfoBean paramUserInfoBean, boolean paramBoolean)
    {
      this.b = paramUserInfoBean;
      this.a = paramBoolean;
    }
    
    public final void run()
    {
      try
      {
        Object localObject = this.b;
        if (localObject != null)
        {
          a.a(a.this, (UserInfoBean)localObject);
          y.c("[UserInfo] Record user info.", new Object[0]);
          a.a(a.this, this.b, false);
        }
        if (this.a)
        {
          localObject = a.this;
          x localx = x.a();
          if (localx != null) {
            localx.a(new a.b((a)localObject));
          }
        }
        return;
      }
      finally
      {
        if (!y.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  final class d
    implements Runnable
  {
    d() {}
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      if (l < a.b(a.this))
      {
        x.a().a(new d(a.this), a.b(a.this) - l + 5000L);
        return;
      }
      a.this.a(3, false, 0L);
      a.this.a();
    }
  }
  
  final class e
    implements Runnable
  {
    private long a;
    
    public e(long paramLong)
    {
      this.a = paramLong;
    }
    
    public final void run()
    {
      a locala = a.this;
      x localx = x.a();
      if (localx != null) {
        localx.a(new a.b(locala));
      }
      locala = a.this;
      long l = this.a;
      x.a().a(new e(locala, l), l);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a
 * JD-Core Version:    0.7.0.1
 */