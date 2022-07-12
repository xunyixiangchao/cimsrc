package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityResult> CREATOR = new a();
  private final int a;
  private final Intent b;
  
  public ActivityResult(int paramInt, Intent paramIntent)
  {
    this.a = paramInt;
    this.b = paramIntent;
  }
  
  ActivityResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      paramParcel = null;
    } else {
      paramParcel = (Intent)Intent.CREATOR.createFromParcel(paramParcel);
    }
    this.b = paramParcel;
  }
  
  public static String i(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0) {
        return String.valueOf(paramInt);
      }
      return "RESULT_CANCELED";
    }
    return "RESULT_OK";
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
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityResult{resultCode=");
    localStringBuilder.append(i(this.a));
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    int i;
    if (this.b == null) {
      i = 0;
    } else {
      i = 1;
    }
    paramParcel.writeInt(i);
    Intent localIntent = this.b;
    if (localIntent != null) {
      localIntent.writeToParcel(paramParcel, paramInt);
    }
  }
  
  class a
    implements Parcelable.Creator<ActivityResult>
  {
    public ActivityResult a(Parcel paramParcel)
    {
      return new ActivityResult(paramParcel);
    }
    
    public ActivityResult[] b(int paramInt)
    {
      return new ActivityResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.result.ActivityResult
 * JD-Core Version:    0.7.0.1
 */