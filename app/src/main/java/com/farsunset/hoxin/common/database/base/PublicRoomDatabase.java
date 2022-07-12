package com.farsunset.hoxin.common.database.base;

import androidx.room.e0;
import androidx.room.f0;
import androidx.room.f0.a;
import com.farsunset.hoxin.HoxinApplication;
import n1.b;
import q3.c;

public abstract class PublicRoomDatabase
  extends f0
{
  private static final PublicRoomDatabase o = (PublicRoomDatabase)e0.a(HoxinApplication.h(), PublicRoomDatabase.class, "common.db").b().a(new b[] { new a(300, 330) }).a(new b[] { new a(310, 330) }).a(new b[] { new a(320, 330) }).a(new b[] { new a(325, 330) }).a(new b[] { new a(326, 330) }).a(new b[] { new a(327, 330) }).c();
  
  public static q3.a E()
  {
    return o.D();
  }
  
  public static c F()
  {
    return o.G();
  }
  
  abstract q3.a D();
  
  abstract c G();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.database.base.PublicRoomDatabase
 * JD-Core Version:    0.7.0.1
 */