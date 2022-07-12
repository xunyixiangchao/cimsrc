package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface j
  extends IInterface
{
  public abstract void b(String[] paramArrayOfString);
  
  public static abstract class a
    extends Binder
    implements j
  {
    public a()
    {
      attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
    }
    
    public static j g(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
      if ((localIInterface != null) && ((localIInterface instanceof j))) {
        return (j)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static j h()
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
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
        return true;
      }
      paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
      b(paramParcel1.createStringArray());
      return true;
    }
    
    private static class a
      implements j
    {
      public static j b;
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public void b(String[] paramArrayOfString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
          localParcel.writeStringArray(paramArrayOfString);
          if ((!this.a.transact(1, localParcel, null, 1)) && (j.a.h() != null))
          {
            j.a.h().b(paramArrayOfString);
            return;
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.j
 * JD-Core Version:    0.7.0.1
 */