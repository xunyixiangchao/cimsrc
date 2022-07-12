package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import com.google.android.material.internal.ParcelableSparseArray;

public class b
{
  public static final boolean a = false;
  
  public static void a(a parama, View paramView, FrameLayout paramFrameLayout)
  {
    e(parama, paramView, paramFrameLayout);
    if (parama.h() != null)
    {
      parama.h().setForeground(parama);
      return;
    }
    if (!a)
    {
      paramView.getOverlay().add(parama);
      return;
    }
    throw new IllegalArgumentException("Trying to reference null customBadgeParent");
  }
  
  public static SparseArray<a> b(Context paramContext, ParcelableSparseArray paramParcelableSparseArray)
  {
    SparseArray localSparseArray = new SparseArray(paramParcelableSparseArray.size());
    int i = 0;
    while (i < paramParcelableSparseArray.size())
    {
      int j = paramParcelableSparseArray.keyAt(i);
      BadgeState.State localState = (BadgeState.State)paramParcelableSparseArray.valueAt(i);
      if (localState != null)
      {
        localSparseArray.put(j, a.d(paramContext, localState));
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
      }
    }
    return localSparseArray;
  }
  
  public static ParcelableSparseArray c(SparseArray<a> paramSparseArray)
  {
    ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      a locala = (a)paramSparseArray.valueAt(i);
      if (locala != null)
      {
        localParcelableSparseArray.put(j, locala.l());
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("badgeDrawable cannot be null");
      }
    }
    return localParcelableSparseArray;
  }
  
  public static void d(a parama, View paramView)
  {
    if (parama == null) {
      return;
    }
    if ((!a) && (parama.h() == null))
    {
      paramView.getOverlay().remove(parama);
      return;
    }
    parama.h().setForeground(null);
  }
  
  public static void e(a parama, View paramView, FrameLayout paramFrameLayout)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    parama.setBounds(localRect);
    parama.G(paramView, paramFrameLayout);
  }
  
  public static void f(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramRect.set((int)(paramFloat1 - paramFloat3), (int)(paramFloat2 - paramFloat4), (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.badge.b
 * JD-Core Version:    0.7.0.1
 */