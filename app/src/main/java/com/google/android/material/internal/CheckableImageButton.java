package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.a;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import y0.d;

public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] g = { 16842912 };
  private boolean d;
  private boolean e = true;
  private boolean f = true;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    x.q0(this, new a());
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean isChecked()
  {
    return this.d;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.d)
    {
      int[] arrayOfInt = g;
      return ImageButton.mergeDrawableStates(super.onCreateDrawableState(paramInt + arrayOfInt.length), arrayOfInt);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    setChecked(paramParcelable.c);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = this.d;
    return localSavedState;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      sendAccessibilityEvent(0);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((this.e) && (this.d != paramBoolean))
    {
      this.d = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setPressable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (this.f) {
      super.setPressed(paramBoolean);
    }
  }
  
  public void toggle()
  {
    setChecked(this.d ^ true);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      h(paramParcel);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void h(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.c = bool;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<CheckableImageButton.SavedState>
    {
      public CheckableImageButton.SavedState a(Parcel paramParcel)
      {
        return new CheckableImageButton.SavedState(paramParcel, null);
      }
      
      public CheckableImageButton.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new CheckableImageButton.SavedState(paramParcel, paramClassLoader);
      }
      
      public CheckableImageButton.SavedState[] c(int paramInt)
      {
        return new CheckableImageButton.SavedState[paramInt];
      }
    }
  }
  
  class a
    extends a
  {
    a() {}
    
    public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.f(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
    }
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramd.a0(CheckableImageButton.this.a());
      paramd.b0(CheckableImageButton.this.isChecked());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */