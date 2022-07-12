package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import com.google.android.material.badge.b;
import com.google.android.material.internal.ParcelableSparseArray;

public class NavigationBarPresenter
  implements j
{
  private e a;
  private c b;
  private boolean c = false;
  private int d;
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(e parame, boolean paramBoolean) {}
  
  public void c(c paramc)
  {
    this.b = paramc;
  }
  
  public void d(Context paramContext, e parame)
  {
    this.a = parame;
    this.b.b(parame);
  }
  
  public void e(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      c localc = this.b;
      paramParcelable = (SavedState)paramParcelable;
      localc.o(paramParcelable.a);
      paramParcelable = b.b(this.b.getContext(), paramParcelable.b);
      this.b.n(paramParcelable);
    }
  }
  
  public boolean f(m paramm)
  {
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.c) {
      return;
    }
    if (paramBoolean)
    {
      this.b.d();
      return;
    }
    this.b.p();
  }
  
  public int getId()
  {
    return this.d;
  }
  
  public void h(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Parcelable j()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.a = this.b.getSelectedItemId();
    localSavedState.b = b.c(this.b.getBadgeDrawables());
    return localSavedState;
  }
  
  public boolean k(e parame, g paramg)
  {
    return false;
  }
  
  public boolean l(e parame, g paramg)
  {
    return false;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int a;
    ParcelableSparseArray b;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = ((ParcelableSparseArray)paramParcel.readParcelable(getClass().getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeParcelable(this.b, 0);
    }
    
    class a
      implements Parcelable.Creator<NavigationBarPresenter.SavedState>
    {
      public NavigationBarPresenter.SavedState a(Parcel paramParcel)
      {
        return new NavigationBarPresenter.SavedState(paramParcel);
      }
      
      public NavigationBarPresenter.SavedState[] b(int paramInt)
      {
        return new NavigationBarPresenter.SavedState[paramInt];
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.NavigationBarPresenter
 * JD-Core Version:    0.7.0.1
 */