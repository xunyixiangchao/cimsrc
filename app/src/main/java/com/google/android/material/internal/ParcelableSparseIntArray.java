package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray
  extends SparseIntArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new a();
  
  public ParcelableSparseIntArray() {}
  
  public ParcelableSparseIntArray(int paramInt)
  {
    super(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = new int[size()];
    paramInt = 0;
    while (paramInt < size())
    {
      arrayOfInt1[paramInt] = keyAt(paramInt);
      arrayOfInt2[paramInt] = valueAt(paramInt);
      paramInt += 1;
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt1);
    paramParcel.writeIntArray(arrayOfInt2);
  }
  
  class a
    implements Parcelable.Creator<ParcelableSparseIntArray>
  {
    public ParcelableSparseIntArray a(Parcel paramParcel)
    {
      int j = paramParcel.readInt();
      ParcelableSparseIntArray localParcelableSparseIntArray = new ParcelableSparseIntArray(j);
      int[] arrayOfInt1 = new int[j];
      int[] arrayOfInt2 = new int[j];
      paramParcel.readIntArray(arrayOfInt1);
      paramParcel.readIntArray(arrayOfInt2);
      int i = 0;
      while (i < j)
      {
        localParcelableSparseIntArray.put(arrayOfInt1[i], arrayOfInt2[i]);
        i += 1;
      }
      return localParcelableSparseIntArray;
    }
    
    public ParcelableSparseIntArray[] b(int paramInt)
    {
      return new ParcelableSparseIntArray[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseIntArray
 * JD-Core Version:    0.7.0.1
 */