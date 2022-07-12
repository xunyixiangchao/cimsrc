package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface a
  extends IInterface
{
  public abstract void a(b paramb);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a a()
    {
      return a.b;
    }
    
    public static a b(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    private static class a
      implements a
    {
      public static a b;
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public void a(b paramb)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.baidu.mapframework.open.aidl.IMapOpenService");
            if (paramb != null)
            {
              localIBinder = paramb.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if ((!this.a.transact(1, localParcel1, localParcel2, 0)) && (a.a.a() != null))
              {
                a.a.a().a(paramb);
                return;
              }
              localParcel2.readException();
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapframework.open.aidl.a
 * JD-Core Version:    0.7.0.1
 */