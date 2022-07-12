package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface k
  extends IInterface
{
  public abstract int c(j paramj, String paramString);
  
  public abstract void d(int paramInt, String[] paramArrayOfString);
  
  public abstract void e(j paramj, int paramInt);
  
  public static abstract class a
    extends Binder
    implements k
  {
    public a()
    {
      attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }
    
    public static k g(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
      if ((localIInterface != null) && ((localIInterface instanceof k))) {
        return (k)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static k h()
    {
      return a.b;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 1598968902) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            paramParcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
          }
          paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
          d(paramParcel1.readInt(), paramParcel1.createStringArray());
          return true;
        }
        paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        e(j.a.g(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
      paramInt1 = c(j.a.g(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class a
      implements k
    {
      public static k b;
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public int c(j paramj, String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            if (paramj != null)
            {
              localIBinder = paramj.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              localParcel1.writeString(paramString);
              if ((!this.a.transact(1, localParcel1, localParcel2, 0)) && (k.a.h() != null))
              {
                i = k.a.h().c(paramj, paramString);
                return i;
              }
              localParcel2.readException();
              int i = localParcel2.readInt();
              return i;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }
      
      public void d(int paramInt, String[] paramArrayOfString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
          localParcel.writeInt(paramInt);
          localParcel.writeStringArray(paramArrayOfString);
          if ((!this.a.transact(3, localParcel, null, 1)) && (k.a.h() != null))
          {
            k.a.h().d(paramInt, paramArrayOfString);
            return;
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void e(j paramj, int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            if (paramj != null)
            {
              localIBinder = paramj.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              localParcel1.writeInt(paramInt);
              if ((!this.a.transact(2, localParcel1, localParcel2, 0)) && (k.a.h() != null))
              {
                k.a.h().e(paramj, paramInt);
                return;
              }
              localParcel2.readException();
              return;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.k
 * JD-Core Version:    0.7.0.1
 */