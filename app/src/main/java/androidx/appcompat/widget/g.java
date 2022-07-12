package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.drawable;

public final class g
{
  private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
  private static g c;
  private a0 a;
  
  public static g b()
  {
    try
    {
      if (c == null) {
        h();
      }
      g localg = c;
      return localg;
    }
    finally {}
  }
  
  public static PorterDuffColorFilter e(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      paramMode = a0.l(paramInt, paramMode);
      return paramMode;
    }
    finally
    {
      paramMode = finally;
      throw paramMode;
    }
  }
  
  public static void h()
  {
    try
    {
      if (c == null)
      {
        g localg = new g();
        c = localg;
        localg.a = a0.h();
        c.a.u(new a());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void i(Drawable paramDrawable, i0 parami0, int[] paramArrayOfInt)
  {
    a0.w(paramDrawable, parami0, paramArrayOfInt);
  }
  
  public Drawable c(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = this.a.j(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramContext = this.a.k(paramContext, paramInt, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  ColorStateList f(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = this.a.m(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void g(Context paramContext)
  {
    try
    {
      this.a.s(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  class a
    implements a0.f
  {
    private final int[] a = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
    private final int[] b = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
    private final int[] c = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl };
    private final int[] d = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
    private final int[] e = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
    private final int[] f = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim };
    
    private boolean f(int[] paramArrayOfInt, int paramInt)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private ColorStateList g(Context paramContext)
    {
      return h(paramContext, 0);
    }
    
    private ColorStateList h(Context paramContext, int paramInt)
    {
      int k = f0.c(paramContext, R.attr.colorControlHighlight);
      int i = f0.b(paramContext, R.attr.colorButtonNormal);
      paramContext = f0.b;
      int[] arrayOfInt1 = f0.e;
      int j = q0.a.j(k, paramInt);
      int[] arrayOfInt2 = f0.c;
      k = q0.a.j(k, paramInt);
      return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, f0.i }, new int[] { i, j, k, paramInt });
    }
    
    private ColorStateList i(Context paramContext)
    {
      return h(paramContext, f0.c(paramContext, R.attr.colorAccent));
    }
    
    private ColorStateList j(Context paramContext)
    {
      return h(paramContext, f0.c(paramContext, R.attr.colorButtonNormal));
    }
    
    private ColorStateList k(Context paramContext)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      int i = R.attr.colorSwitchThumbNormal;
      ColorStateList localColorStateList = f0.e(paramContext, i);
      if ((localColorStateList != null) && (localColorStateList.isStateful()))
      {
        arrayOfInt[0] = f0.b;
        arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
        arrayOfInt[1] = f0.f;
        arrayOfInt1[1] = f0.c(paramContext, R.attr.colorControlActivated);
        arrayOfInt[2] = f0.i;
        arrayOfInt1[2] = localColorStateList.getDefaultColor();
      }
      else
      {
        arrayOfInt[0] = f0.b;
        arrayOfInt1[0] = f0.b(paramContext, i);
        arrayOfInt[1] = f0.f;
        arrayOfInt1[1] = f0.c(paramContext, R.attr.colorControlActivated);
        arrayOfInt[2] = f0.i;
        arrayOfInt1[2] = f0.c(paramContext, i);
      }
      return new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    
    private LayerDrawable l(a0 parama0, Context paramContext, int paramInt)
    {
      paramInt = paramContext.getResources().getDimensionPixelSize(paramInt);
      Object localObject2 = parama0.j(paramContext, R.drawable.abc_star_black_48dp);
      Object localObject1 = parama0.j(paramContext, R.drawable.abc_star_half_black_48dp);
      if (((localObject2 instanceof BitmapDrawable)) && (((Drawable)localObject2).getIntrinsicWidth() == paramInt) && (((Drawable)localObject2).getIntrinsicHeight() == paramInt))
      {
        parama0 = (BitmapDrawable)localObject2;
        paramContext = new BitmapDrawable(parama0.getBitmap());
      }
      else
      {
        paramContext = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        parama0 = new Canvas(paramContext);
        ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
        ((Drawable)localObject2).draw(parama0);
        parama0 = new BitmapDrawable(paramContext);
        paramContext = new BitmapDrawable(paramContext);
      }
      paramContext.setTileModeX(Shader.TileMode.REPEAT);
      if (((localObject1 instanceof BitmapDrawable)) && (((Drawable)localObject1).getIntrinsicWidth() == paramInt) && (((Drawable)localObject1).getIntrinsicHeight() == paramInt))
      {
        localObject1 = (BitmapDrawable)localObject1;
      }
      else
      {
        localObject2 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject2);
        ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
        ((Drawable)localObject1).draw(localCanvas);
        localObject1 = new BitmapDrawable((Bitmap)localObject2);
      }
      parama0 = new LayerDrawable(new Drawable[] { parama0, localObject1, paramContext });
      parama0.setId(0, 16908288);
      parama0.setId(1, 16908303);
      parama0.setId(2, 16908301);
      return parama0;
    }
    
    private void m(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
    {
      Drawable localDrawable = paramDrawable;
      if (t.a(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      paramDrawable = paramMode;
      if (paramMode == null) {
        paramDrawable = g.a();
      }
      localDrawable.setColorFilter(g.e(paramInt, paramDrawable));
    }
    
    public boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
    {
      PorterDuff.Mode localMode = g.a();
      boolean bool = f(this.a, paramInt);
      int i = 16842801;
      if (bool) {
        paramInt = R.attr.colorControlNormal;
      }
      for (;;)
      {
        for (i = -1;; i = Math.round(40.799999F))
        {
          j = 1;
          k = paramInt;
          break label130;
          if (f(this.c, paramInt))
          {
            paramInt = R.attr.colorControlActivated;
            break;
          }
          if (f(this.d, paramInt))
          {
            localMode = PorterDuff.Mode.MULTIPLY;
            paramInt = i;
            break;
          }
          if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
            break label106;
          }
          paramInt = 16842800;
        }
        label106:
        if (paramInt != R.drawable.abc_dialog_material_background) {
          break;
        }
        paramInt = i;
      }
      i = -1;
      paramInt = 0;
      int k = paramInt;
      int j = paramInt;
      label130:
      if (j != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (t.a(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(g.e(f0.c(paramContext, k), localMode));
        if (i != -1) {
          localDrawable.setAlpha(i);
        }
        return true;
      }
      return false;
    }
    
    public PorterDuff.Mode b(int paramInt)
    {
      if (paramInt == R.drawable.abc_switch_thumb_material) {
        return PorterDuff.Mode.MULTIPLY;
      }
      return null;
    }
    
    public Drawable c(a0 parama0, Context paramContext, int paramInt)
    {
      if (paramInt == R.drawable.abc_cab_background_top_material) {
        return new LayerDrawable(new Drawable[] { parama0.j(paramContext, R.drawable.abc_cab_background_internal_bg), parama0.j(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) });
      }
      if (paramInt == R.drawable.abc_ratingbar_material) {
        paramInt = R.dimen.abc_star_big;
      }
      for (;;)
      {
        return l(parama0, paramContext, paramInt);
        if (paramInt == R.drawable.abc_ratingbar_indicator_material)
        {
          paramInt = R.dimen.abc_star_medium;
        }
        else
        {
          if (paramInt != R.drawable.abc_ratingbar_small_material) {
            break;
          }
          paramInt = R.dimen.abc_star_small;
        }
      }
      return null;
    }
    
    public ColorStateList d(Context paramContext, int paramInt)
    {
      if (paramInt == R.drawable.abc_edit_text_material) {
        return c.a.a(paramContext, R.color.abc_tint_edittext);
      }
      if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        return c.a.a(paramContext, R.color.abc_tint_switch_track);
      }
      if (paramInt == R.drawable.abc_switch_thumb_material) {
        return k(paramContext);
      }
      if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
        return j(paramContext);
      }
      if (paramInt == R.drawable.abc_btn_borderless_material) {
        return g(paramContext);
      }
      if (paramInt == R.drawable.abc_btn_colored_material) {
        return i(paramContext);
      }
      if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
      {
        if (f(this.b, paramInt)) {
          return f0.e(paramContext, R.attr.colorControlNormal);
        }
        if (f(this.e, paramInt)) {
          return c.a.a(paramContext, R.color.abc_tint_default);
        }
        if (f(this.f, paramInt)) {
          return c.a.a(paramContext, R.color.abc_tint_btn_checkable);
        }
        if (paramInt == R.drawable.abc_seekbar_thumb_material) {
          return c.a.a(paramContext, R.color.abc_tint_seek_thumb);
        }
        return null;
      }
      return c.a.a(paramContext, R.color.abc_tint_spinner);
    }
    
    public boolean e(Context paramContext, int paramInt, Drawable paramDrawable)
    {
      Drawable localDrawable;
      if (paramInt == R.drawable.abc_seekbar_track_material)
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        localDrawable = paramDrawable.findDrawableByLayerId(16908288);
        paramInt = R.attr.colorControlNormal;
        m(localDrawable, f0.c(paramContext, paramInt), g.a());
        m(paramDrawable.findDrawableByLayerId(16908303), f0.c(paramContext, paramInt), g.a());
        paramDrawable = paramDrawable.findDrawableByLayerId(16908301);
        paramInt = f0.c(paramContext, R.attr.colorControlActivated);
      }
      for (paramContext = paramDrawable;; paramContext = paramDrawable)
      {
        m(paramContext, paramInt, g.a());
        return true;
        if ((paramInt != R.drawable.abc_ratingbar_material) && (paramInt != R.drawable.abc_ratingbar_indicator_material) && (paramInt != R.drawable.abc_ratingbar_small_material)) {
          return false;
        }
        paramDrawable = (LayerDrawable)paramDrawable;
        m(paramDrawable.findDrawableByLayerId(16908288), f0.b(paramContext, R.attr.colorControlNormal), g.a());
        localDrawable = paramDrawable.findDrawableByLayerId(16908303);
        paramInt = R.attr.colorControlActivated;
        m(localDrawable, f0.c(paramContext, paramInt), g.a());
        paramDrawable = paramDrawable.findDrawableByLayerId(16908301);
        paramInt = f0.c(paramContext, paramInt);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.g
 * JD-Core Version:    0.7.0.1
 */