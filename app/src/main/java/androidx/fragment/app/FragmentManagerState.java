package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();
  ArrayList<FragmentState> a;
  ArrayList<String> b;
  BackStackState[] c;
  int d;
  String e = null;
  ArrayList<String> f = new ArrayList();
  ArrayList<Bundle> g = new ArrayList();
  ArrayList<FragmentManager.LaunchedFragmentInfo> h;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.a = paramParcel.createTypedArrayList(FragmentState.CREATOR);
    this.b = paramParcel.createStringArrayList();
    this.c = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.createStringArrayList();
    this.g = paramParcel.createTypedArrayList(Bundle.CREATOR);
    this.h = paramParcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeStringList(this.b);
    paramParcel.writeTypedArray(this.c, paramInt);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeStringList(this.f);
    paramParcel.writeTypedList(this.g);
    paramParcel.writeTypedList(this.h);
  }
  
  class a
    implements Parcelable.Creator<FragmentManagerState>
  {
    public FragmentManagerState a(Parcel paramParcel)
    {
      return new FragmentManagerState(paramParcel);
    }
    
    public FragmentManagerState[] b(int paramInt)
    {
      return new FragmentManagerState[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */