package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w0.b;
import w0.b.a;
import w0.b.a.a;
import x0.h;

public final class l
{
  public static Drawable[] a(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawablesRelative();
  }
  
  public static int b(TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - paramTextView.getPaint().getFontMetricsInt().top;
  }
  
  public static int c(TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + paramTextView.getPaint().getFontMetricsInt().bottom;
  }
  
  public static int d(TextView paramTextView)
  {
    return paramTextView.getMaxLines();
  }
  
  private static int e(TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
      return 2;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
      return 3;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
      return 4;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
      return 5;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 6;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 7;
    }
    return 1;
  }
  
  private static TextDirectionHeuristic f(TextView paramTextView)
  {
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i != 1) && (i != 2)) {
        return TextDirectionHeuristics.LTR;
      }
      return TextDirectionHeuristics.RTL;
    }
    if (paramTextView.getLayoutDirection() == 1) {
      i = 1;
    }
    switch (paramTextView.getTextDirection())
    {
    default: 
      if (i != 0) {
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
      break;
    case 7: 
      return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    case 6: 
      return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    case 5: 
      return TextDirectionHeuristics.LOCALE;
    case 4: 
      return TextDirectionHeuristics.RTL;
    case 3: 
      return TextDirectionHeuristics.LTR;
    case 2: 
      return TextDirectionHeuristics.ANYRTL_LTR;
    }
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
  }
  
  public static b.a g(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new b.a(paramTextView.getTextMetricsParams());
    }
    b.a.a locala = new b.a.a(new TextPaint(paramTextView.getPaint()));
    locala.b(paramTextView.getBreakStrategy());
    locala.c(paramTextView.getHyphenationFrequency());
    locala.d(f(paramTextView));
    return locala.a();
  }
  
  public static void h(TextView paramTextView, ColorStateList paramColorStateList)
  {
    h.g(paramTextView);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramTextView.setCompoundDrawableTintList(paramColorStateList);
      return;
    }
    if ((paramTextView instanceof n)) {
      ((n)paramTextView).setSupportCompoundDrawablesTintList(paramColorStateList);
    }
  }
  
  public static void i(TextView paramTextView, PorterDuff.Mode paramMode)
  {
    h.g(paramTextView);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramTextView.setCompoundDrawableTintMode(paramMode);
      return;
    }
    if ((paramTextView instanceof n)) {
      ((n)paramTextView).setSupportCompoundDrawablesTintMode(paramMode);
    }
  }
  
  public static void j(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void k(TextView paramTextView, int paramInt)
  {
    h.d(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i;
    if (paramTextView.getIncludeFontPadding()) {
      i = localFontMetricsInt.top;
    } else {
      i = localFontMetricsInt.ascent;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt + i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    }
  }
  
  public static void l(TextView paramTextView, int paramInt)
  {
    h.d(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i;
    if (paramTextView.getIncludeFontPadding()) {
      i = localFontMetricsInt.bottom;
    } else {
      i = localFontMetricsInt.descent;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
    }
  }
  
  public static void m(TextView paramTextView, int paramInt)
  {
    h.d(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  public static void n(TextView paramTextView, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      paramb = paramb.b();
    }
    while (g(paramTextView).a(paramb.a()))
    {
      paramTextView.setText(paramb);
      return;
    }
    throw new IllegalArgumentException("Given text can not be applied to TextView.");
  }
  
  public static void o(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextAppearance(paramInt);
  }
  
  public static void p(TextView paramTextView, b.a parama)
  {
    paramTextView.setTextDirection(e(parama.d()));
    paramTextView.getPaint().set(parama.e());
    paramTextView.setBreakStrategy(parama.b());
    paramTextView.setHyphenationFrequency(parama.c());
  }
  
  public static ActionMode.Callback q(ActionMode.Callback paramCallback)
  {
    ActionMode.Callback localCallback = paramCallback;
    if ((paramCallback instanceof a))
    {
      localCallback = paramCallback;
      if (Build.VERSION.SDK_INT >= 26) {
        localCallback = ((a)paramCallback).d();
      }
    }
    return localCallback;
  }
  
  public static ActionMode.Callback r(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 26) && (i <= 27) && (!(paramCallback instanceof a)))
    {
      if (paramCallback == null) {
        return paramCallback;
      }
      return new a(paramCallback, paramTextView);
    }
    return paramCallback;
  }
  
  private static class a
    implements ActionMode.Callback
  {
    private final ActionMode.Callback a;
    private final TextView b;
    private Class<?> c;
    private Method d;
    private boolean e;
    private boolean f;
    
    a(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.a = paramCallback;
      this.b = paramTextView;
      this.f = false;
    }
    
    private Intent a()
    {
      return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }
    
    private Intent b(ResolveInfo paramResolveInfo, TextView paramTextView)
    {
      paramTextView = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", e(paramTextView) ^ true);
      paramResolveInfo = paramResolveInfo.activityInfo;
      return paramTextView.setClassName(paramResolveInfo.packageName, paramResolveInfo.name);
    }
    
    private List<ResolveInfo> c(Context paramContext, PackageManager paramPackageManager)
    {
      ArrayList localArrayList = new ArrayList();
      if (!(paramContext instanceof Activity)) {
        return localArrayList;
      }
      paramPackageManager = paramPackageManager.queryIntentActivities(a(), 0).iterator();
      while (paramPackageManager.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramPackageManager.next();
        if (f(localResolveInfo, paramContext)) {
          localArrayList.add(localResolveInfo);
        }
      }
      return localArrayList;
    }
    
    private boolean e(TextView paramTextView)
    {
      return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
    }
    
    private boolean f(ResolveInfo paramResolveInfo, Context paramContext)
    {
      boolean bool2 = paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName);
      boolean bool1 = true;
      if (bool2) {
        return true;
      }
      paramResolveInfo = paramResolveInfo.activityInfo;
      if (!paramResolveInfo.exported) {
        return false;
      }
      paramResolveInfo = paramResolveInfo.permission;
      if (paramResolveInfo != null)
      {
        if (paramContext.checkSelfPermission(paramResolveInfo) == 0) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    
    private void g(Menu paramMenu)
    {
      Object localObject2 = this.b.getContext();
      PackageManager localPackageManager = ((Context)localObject2).getPackageManager();
      if (!this.f) {
        this.f = true;
      }
      try
      {
        localObject1 = Class.forName("com.android.internal.view.menu.MenuBuilder");
        this.c = ((Class)localObject1);
        this.d = ((Class)localObject1).getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
        this.e = true;
      }
      catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
      {
        for (;;)
        {
          try
          {
            if ((this.e) && (this.c.isInstance(paramMenu))) {
              localObject1 = this.d;
            } else {
              localObject1 = paramMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
            }
            int i = paramMenu.size() - 1;
            if (i >= 0)
            {
              MenuItem localMenuItem = paramMenu.getItem(i);
              if ((localMenuItem.getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(localMenuItem.getIntent().getAction()))) {
                ((Method)localObject1).invoke(paramMenu, new Object[] { Integer.valueOf(i) });
              }
              i -= 1;
              continue;
            }
            Object localObject1 = c((Context)localObject2, localPackageManager);
            i = 0;
            if (i < ((List)localObject1).size())
            {
              localObject2 = (ResolveInfo)((List)localObject1).get(i);
              paramMenu.add(0, 0, i + 100, ((ResolveInfo)localObject2).loadLabel(localPackageManager)).setIntent(b((ResolveInfo)localObject2, this.b)).setShowAsAction(1);
              i += 1;
              continue;
            }
            return;
          }
          catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramMenu) {}
          localClassNotFoundException = localClassNotFoundException;
        }
      }
      this.c = null;
      this.d = null;
      this.e = false;
    }
    
    ActionMode.Callback d()
    {
      return this.a;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.a.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.a.onDestroyActionMode(paramActionMode);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      g(paramMenu);
      return this.a.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.l
 * JD-Core Version:    0.7.0.1
 */