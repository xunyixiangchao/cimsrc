package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
  final boolean a = false;
  final Handler b = null;
  a c;
  
  ResultReceiver(Parcel paramParcel)
  {
    this.c = a.a.g(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void g(int paramInt, Bundle paramBundle) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.c == null) {
        this.c = new b();
      }
      paramParcel.writeStrongBinder(this.c.asBinder());
      return;
    }
    finally {}
  }
  
  class a
    implements Parcelable.Creator<ResultReceiver>
  {
    public ResultReceiver a(Parcel paramParcel)
    {
      return new ResultReceiver(paramParcel);
    }
    
    public ResultReceiver[] b(int paramInt)
    {
      return new ResultReceiver[paramInt];
    }
  }
  
  class b
    extends a.a
  {
    b() {}
    
    public void f(int paramInt, Bundle paramBundle)
    {
      ResultReceiver localResultReceiver = ResultReceiver.this;
      Handler localHandler = localResultReceiver.b;
      if (localHandler != null)
      {
        localHandler.post(new ResultReceiver.c(localResultReceiver, paramInt, paramBundle));
        return;
      }
      localResultReceiver.g(paramInt, paramBundle);
    }
  }
  
  class c
    implements Runnable
  {
    final int a;
    final Bundle b;
    
    c(int paramInt, Bundle paramBundle)
    {
      this.a = paramInt;
      this.b = paramBundle;
    }
    
    public void run()
    {
      ResultReceiver.this.g(this.a, this.b);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */