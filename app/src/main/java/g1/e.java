package g1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.d;

final class e
  implements KeyListener
{
  private final KeyListener a;
  private final a b;
  
  e(KeyListener paramKeyListener)
  {
    this(paramKeyListener, new a());
  }
  
  e(KeyListener paramKeyListener, a parama)
  {
    this.a = paramKeyListener;
    this.b = parama;
  }
  
  public void clearMetaKeyState(View paramView, Editable paramEditable, int paramInt)
  {
    this.a.clearMetaKeyState(paramView, paramEditable, paramInt);
  }
  
  public int getInputType()
  {
    return this.a.getInputType();
  }
  
  public boolean onKeyDown(View paramView, Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.b.a(paramEditable, paramInt, paramKeyEvent)) || (this.a.onKeyDown(paramView, paramEditable, paramInt, paramKeyEvent));
  }
  
  public boolean onKeyOther(View paramView, Editable paramEditable, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyOther(paramView, paramEditable, paramKeyEvent);
  }
  
  public boolean onKeyUp(View paramView, Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyUp(paramView, paramEditable, paramInt, paramKeyEvent);
  }
  
  public static class a
  {
    public boolean a(Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
    {
      return d.f(paramEditable, paramInt, paramKeyEvent);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.e
 * JD-Core Version:    0.7.0.1
 */