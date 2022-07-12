package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface b
  extends IInterface
{
  public abstract void a(IBinder paramIBinder);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.baidu.mapframework.open.aidl.IOpenClientCallback");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.baidu.mapframework.open.aidl.IOpenClientCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
      a(paramParcel1.readStrongBinder());
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapframework.open.aidl.b
 * JD-Core Version:    0.7.0.1
 */