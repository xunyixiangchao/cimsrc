package o0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract interface a
  extends IInterface
{
  public static abstract class a
    extends Binder
    implements a
  {
    public static a g(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    private static class a
      implements a
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o0.a
 * JD-Core Version:    0.7.0.1
 */