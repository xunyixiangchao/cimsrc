package o0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface b
  extends IInterface
{
  public abstract void a(a parama);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
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
        paramParcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        return true;
      }
      paramParcel1.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
      a(a.a.g(paramParcel1.readStrongBinder()));
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o0.b
 * JD-Core Version:    0.7.0.1
 */