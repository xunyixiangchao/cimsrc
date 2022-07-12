package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import androidx.customview.view.AbsSavedState;
import g0.g;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();
  public final g<String, Bundle> c;
  
  private ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.c = new g(j);
    int i = 0;
    while (i < j)
    {
      this.c.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    this.c = new g();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtendableSavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" states=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.c.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.c.i(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.c.m(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
  
  class a
    implements Parcelable.ClassLoaderCreator<ExtendableSavedState>
  {
    public ExtendableSavedState a(Parcel paramParcel)
    {
      return new ExtendableSavedState(paramParcel, null, null);
    }
    
    public ExtendableSavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new ExtendableSavedState(paramParcel, paramClassLoader, null);
    }
    
    public ExtendableSavedState[] c(int paramInt)
    {
      return new ExtendableSavedState[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.stateful.ExtendableSavedState
 * JD-Core Version:    0.7.0.1
 */