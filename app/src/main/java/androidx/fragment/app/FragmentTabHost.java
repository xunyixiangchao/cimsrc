package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> a = new ArrayList();
  private Context b;
  private FragmentManager c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private a f;
  private boolean g;
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  private q a(String paramString, q paramq)
  {
    a locala = b(paramString);
    paramString = paramq;
    if (this.f != locala)
    {
      paramString = paramq;
      if (paramq == null) {
        paramString = this.c.m();
      }
      paramq = this.f;
      if (paramq != null)
      {
        paramq = paramq.d;
        if (paramq != null) {
          paramString.k(paramq);
        }
      }
      if (locala != null)
      {
        paramq = locala.d;
        if (paramq == null)
        {
          paramq = this.c.r0().a(this.b.getClassLoader(), locala.b.getName());
          locala.d = paramq;
          paramq.setArguments(locala.c);
          paramString.b(this.d, locala.d, locala.a);
        }
        else
        {
          paramString.f(paramq);
        }
      }
      this.f = locala;
    }
    return paramString;
  }
  
  private a b(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.a.get(i);
      if (locala.a.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.d = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    int j = this.a.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.a.get(i);
      Fragment localFragment = this.c.j0(locala.a);
      locala.d = localFragment;
      Object localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (!localFragment.isDetached()) {
          if (locala.a.equals(str))
          {
            this.f = locala;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = this.c.m();
            }
            ((q)localObject2).k(locala.d);
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    this.g = true;
    localObject1 = a(str, (q)localObject1);
    if (localObject1 != null)
    {
      ((q)localObject1).g();
      this.c.f0();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = false;
  }
  
  @Deprecated
  protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.a);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.g)
    {
      localObject = a(paramString, null);
      if (localObject != null) {
        ((q)localObject).g();
      }
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((TabHost.OnTabChangeListener)localObject).onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.e = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    String a;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentTabHost.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" curTab=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
    }
    
    class a
      implements Parcelable.Creator<FragmentTabHost.SavedState>
    {
      public FragmentTabHost.SavedState a(Parcel paramParcel)
      {
        return new FragmentTabHost.SavedState(paramParcel);
      }
      
      public FragmentTabHost.SavedState[] b(int paramInt)
      {
        return new FragmentTabHost.SavedState[paramInt];
      }
    }
  }
  
  static final class a
  {
    final String a;
    final Class<?> b;
    final Bundle c;
    Fragment d;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */