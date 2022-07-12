package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f
{
  private static boolean a = false;
  private static Method b;
  private static boolean c = false;
  private static Field d;
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!a) {}
    try
    {
      b = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label27:
      a = true;
      Method localMethod = b;
      if (localMethod != null) {}
      try
      {
        boolean bool = ((Boolean)localMethod.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (IllegalAccessException|InvocationTargetException paramActionBar) {}
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
    return false;
  }
  
  private static boolean b(Activity paramActivity, KeyEvent paramKeyEvent)
  {
    paramActivity.onUserInteraction();
    Object localObject = paramActivity.getWindow();
    if (((Window)localObject).hasFeature(8))
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      if ((paramKeyEvent.getKeyCode() == 82) && (localActionBar != null) && (a(localActionBar, paramKeyEvent))) {
        return true;
      }
    }
    if (((Window)localObject).superDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    localObject = ((Window)localObject).getDecorView();
    if (x.h((View)localObject, paramKeyEvent)) {
      return true;
    }
    if (localObject != null) {
      localObject = ((View)localObject).getKeyDispatcherState();
    } else {
      localObject = null;
    }
    return paramKeyEvent.dispatch(paramActivity, (KeyEvent.DispatcherState)localObject, paramActivity);
  }
  
  private static boolean c(Dialog paramDialog, KeyEvent paramKeyEvent)
  {
    Object localObject = f(paramDialog);
    if ((localObject != null) && (((DialogInterface.OnKeyListener)localObject).onKey(paramDialog, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
      return true;
    }
    localObject = paramDialog.getWindow();
    if (((Window)localObject).superDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    localObject = ((Window)localObject).getDecorView();
    if (x.h((View)localObject, paramKeyEvent)) {
      return true;
    }
    if (localObject != null) {
      localObject = ((View)localObject).getKeyDispatcherState();
    } else {
      localObject = null;
    }
    return paramKeyEvent.dispatch(paramDialog, (KeyEvent.DispatcherState)localObject, paramDialog);
  }
  
  public static boolean d(View paramView, KeyEvent paramKeyEvent)
  {
    return x.i(paramView, paramKeyEvent);
  }
  
  public static boolean e(a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (parama == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      return parama.superDispatchKeyEvent(paramKeyEvent);
    }
    if ((paramCallback instanceof Activity)) {
      return b((Activity)paramCallback, paramKeyEvent);
    }
    if ((paramCallback instanceof Dialog)) {
      return c((Dialog)paramCallback, paramKeyEvent);
    }
    if (((paramView != null) && (x.h(paramView, paramKeyEvent))) || (parama.superDispatchKeyEvent(paramKeyEvent))) {
      bool = true;
    }
    return bool;
  }
  
  private static DialogInterface.OnKeyListener f(Dialog paramDialog)
  {
    if (!c) {}
    try
    {
      Field localField = Dialog.class.getDeclaredField("mOnKeyListener");
      d = localField;
      localField.setAccessible(true);
      label23:
      c = true;
      localField = d;
      if (localField != null) {}
      try
      {
        paramDialog = (DialogInterface.OnKeyListener)localField.get(paramDialog);
        return paramDialog;
      }
      catch (IllegalAccessException paramDialog)
      {
        label46:
        break label46;
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.f
 * JD-Core Version:    0.7.0.1
 */