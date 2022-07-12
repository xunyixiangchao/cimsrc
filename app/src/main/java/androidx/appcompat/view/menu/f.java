package androidx.appcompat.view.menu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import androidx.appcompat.R.layout;
import androidx.appcompat.app.b;
import androidx.appcompat.app.b.a;

class f
  implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a
{
  private e a;
  private b b;
  c c;
  private j.a d;
  
  public f(e parame)
  {
    this.a = parame;
  }
  
  public void a()
  {
    b localb = this.b;
    if (localb != null) {
      localb.dismiss();
    }
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    if ((paramBoolean) || (parame == this.a)) {
      a();
    }
    j.a locala = this.d;
    if (locala != null) {
      locala.b(parame, paramBoolean);
    }
  }
  
  public boolean c(e parame)
  {
    j.a locala = this.d;
    if (locala != null) {
      return locala.c(parame);
    }
    return false;
  }
  
  public void d(IBinder paramIBinder)
  {
    Object localObject1 = this.a;
    b.a locala = new b.a(((e)localObject1).w());
    Object localObject2 = new c(locala.b(), R.layout.abc_list_menu_item_layout);
    this.c = ((c)localObject2);
    ((c)localObject2).m(this);
    this.a.b(this.c);
    locala.c(this.c.a(), this);
    localObject2 = ((e)localObject1).A();
    if (localObject2 != null) {
      locala.d((View)localObject2);
    } else {
      locala.e(((e)localObject1).y()).h(((e)localObject1).z());
    }
    locala.f(this);
    localObject1 = locala.a();
    this.b = ((b)localObject1);
    ((Dialog)localObject1).setOnDismissListener(this);
    localObject1 = this.b.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).type = 1003;
    if (paramIBinder != null) {
      ((WindowManager.LayoutParams)localObject1).token = paramIBinder;
    }
    ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
    this.b.show();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.N((g)this.c.a().getItem(paramInt), 0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.c.b(this.a, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.b.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.b.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.a.e(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.a.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.f
 * JD-Core Version:    0.7.0.1
 */