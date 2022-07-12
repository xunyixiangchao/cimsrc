package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface IComOpenClient
  extends IInterface
{
  public abstract String a(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements IComOpenClient
  {
    public static IComOpenClient a()
    {
      return a.b;
    }
    
    public static IComOpenClient b(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
      if ((localIInterface != null) && ((localIInterface instanceof IComOpenClient))) {
        return (IComOpenClient)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    private static class a
      implements IComOpenClient
    {
      public static IComOpenClient b;
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      /* Error */
      public String a(String paramString)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 19	com/baidu/mapframework/open/aidl/IComOpenClient$a$a:a	Landroid/os/IBinder;
        //   23: iconst_1
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 42 5 0
        //   32: ifne +29 -> 61
        //   35: invokestatic 45	com/baidu/mapframework/open/aidl/IComOpenClient$a:a	()Lcom/baidu/mapframework/open/aidl/IComOpenClient;
        //   38: ifnull +23 -> 61
        //   41: invokestatic 45	com/baidu/mapframework/open/aidl/IComOpenClient$a:a	()Lcom/baidu/mapframework/open/aidl/IComOpenClient;
        //   44: aload_1
        //   45: invokeinterface 47 2 0
        //   50: astore_1
        //   51: aload_3
        //   52: invokevirtual 50	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 50	android/os/Parcel:recycle	()V
        //   59: aload_1
        //   60: areturn
        //   61: aload_3
        //   62: invokevirtual 53	android/os/Parcel:readException	()V
        //   65: aload_3
        //   66: invokevirtual 57	android/os/Parcel:readString	()Ljava/lang/String;
        //   69: astore_1
        //   70: goto -19 -> 51
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramString	String
        //   3	76	2	localParcel1	Parcel
        //   7	68	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	51	73	finally
        //   61	70	73	finally
      }
      
      public boolean a(String paramString1, String paramString2, Bundle paramBundle)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          boolean bool = true;
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          if ((!this.a.transact(2, localParcel1, localParcel2, 0)) && (IComOpenClient.a.a() != null))
          {
            bool = IComOpenClient.a.a().a(paramString1, paramString2, paramBundle);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i == 0) {
            bool = false;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
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
 * Qualified Name:     com.baidu.mapframework.open.aidl.IComOpenClient
 * JD-Core Version:    0.7.0.1
 */