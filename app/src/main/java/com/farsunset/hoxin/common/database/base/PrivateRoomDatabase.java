package com.farsunset.hoxin.common.database.base;

import androidx.room.e0;
import androidx.room.f0;
import androidx.room.f0.a;
import com.farsunset.hoxin.HoxinApplication;

public abstract class PrivateRoomDatabase
  extends f0
{
  private static PrivateRoomDatabase o;
  
  public static void N(long paramLong)
  {
    Object localObject = o;
    if (localObject != null) {
      ((f0)localObject).f();
    }
    localObject = String.format("%s.db", new Object[] { Long.valueOf(paramLong) });
    localObject = (PrivateRoomDatabase)e0.a(HoxinApplication.h(), PrivateRoomDatabase.class, (String)localObject).a(new n1.b[] { new a(300, 330) }).a(new n1.b[] { new a(310, 330) }).a(new n1.b[] { new a(320, 330) }).a(new n1.b[] { new a(325, 330) }).a(new n1.b[] { new a(326, 330) }).a(new n1.b[] { new a(327, 330) }).b().c();
    o = (PrivateRoomDatabase)localObject;
    g6.a.i(((PrivateRoomDatabase)localObject).E());
    i4.a.r(o.J());
    p4.a.m(o.M());
    p4.b.q(o.L());
    g6.b.m(o.R());
    g6.c.f(o.S());
    x5.a.g(o.Q());
    x5.b.d(o.P());
    w4.a.e(o.U());
    j5.b.A(o.O());
    a4.a.j(o.I());
    a4.b.c(o.H());
    x6.a.d(o.K());
    j5.a.u(o.D());
    p6.c.g(o.T());
    p6.a.j(o.G());
    p6.b.h(o.F());
  }
  
  abstract k5.a D();
  
  abstract h6.a E();
  
  abstract q6.a F();
  
  abstract q6.c G();
  
  abstract b4.a H();
  
  abstract b4.c I();
  
  abstract j4.a J();
  
  abstract y6.a K();
  
  abstract q4.a L();
  
  abstract q4.c M();
  
  abstract k5.c O();
  
  abstract y5.a P();
  
  abstract y5.c Q();
  
  abstract h6.c R();
  
  abstract h6.e S();
  
  abstract q6.e T();
  
  abstract x4.a U();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.database.base.PrivateRoomDatabase
 * JD-Core Version:    0.7.0.1
 */