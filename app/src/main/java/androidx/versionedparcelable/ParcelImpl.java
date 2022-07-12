package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
  private final u1.a a;
  
  protected ParcelImpl(Parcel paramParcel)
  {
    this.a = new b(paramParcel).u();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new b(paramParcel).L(this.a);
  }
  
  static final class a
    implements Parcelable.Creator<ParcelImpl>
  {
    public ParcelImpl a(Parcel paramParcel)
    {
      return new ParcelImpl(paramParcel);
    }
    
    public ParcelImpl[] b(int paramInt)
    {
      return new ParcelImpl[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * JD-Core Version:    0.7.0.1
 */