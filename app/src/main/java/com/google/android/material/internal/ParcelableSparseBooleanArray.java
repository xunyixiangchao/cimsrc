package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;

public class ParcelableSparseBooleanArray
  extends SparseBooleanArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new a();
  
  public ParcelableSparseBooleanArray() {}
  
  public ParcelableSparseBooleanArray(int paramInt)
  {
    super(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt = new int[size()];
    boolean[] arrayOfBoolean = new boolean[size()];
    paramInt = 0;
    while (paramInt < size())
    {
      arrayOfInt[paramInt] = keyAt(paramInt);
      arrayOfBoolean[paramInt] = valueAt(paramInt);
      paramInt += 1;
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
  
  class a
    implements Parcelable.Creator<ParcelableSparseBooleanArray>
  {
    public ParcelableSparseBooleanArray a(Parcel paramParcel)
    {
      int j = paramParcel.readInt();
      ParcelableSparseBooleanArray localParcelableSparseBooleanArray = new ParcelableSparseBooleanArray(j);
      int[] arrayOfInt = new int[j];
      boolean[] arrayOfBoolean = new boolean[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel.readBooleanArray(arrayOfBoolean);
      int i = 0;
      while (i < j)
      {
        localParcelableSparseBooleanArray.put(arrayOfInt[i], arrayOfBoolean[i]);
        i += 1;
      }
      return localParcelableSparseBooleanArray;
    }
    
    public ParcelableSparseBooleanArray[] b(int paramInt)
    {
      return new ParcelableSparseBooleanArray[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseBooleanArray
 * JD-Core Version:    0.7.0.1
 */