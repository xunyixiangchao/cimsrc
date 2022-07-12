package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();
  private final IntentSender a;
  private final Intent b;
  private final int c;
  private final int d;
  
  IntentSenderRequest(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.a = paramIntentSender;
    this.b = paramIntent;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  IntentSenderRequest(Parcel paramParcel)
  {
    this.a = ((IntentSender)paramParcel.readParcelable(IntentSender.class.getClassLoader()));
    this.b = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Intent g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.c;
  }
  
  public int i()
  {
    return this.d;
  }
  
  public IntentSender m()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
  
  class a
    implements Parcelable.Creator<IntentSenderRequest>
  {
    public IntentSenderRequest a(Parcel paramParcel)
    {
      return new IntentSenderRequest(paramParcel);
    }
    
    public IntentSenderRequest[] b(int paramInt)
    {
      return new IntentSenderRequest[paramInt];
    }
  }
  
  public static final class b
  {
    private IntentSender a;
    private Intent b;
    private int c;
    private int d;
    
    public b(IntentSender paramIntentSender)
    {
      this.a = paramIntentSender;
    }
    
    public IntentSenderRequest a()
    {
      return new IntentSenderRequest(this.a, this.b, this.c, this.d);
    }
    
    public b b(Intent paramIntent)
    {
      this.b = paramIntent;
      return this;
    }
    
    public b c(int paramInt1, int paramInt2)
    {
      this.d = paramInt1;
      this.c = paramInt2;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.result.IntentSenderRequest
 * JD-Core Version:    0.7.0.1
 */