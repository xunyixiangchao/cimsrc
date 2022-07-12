package g1;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import x0.h;

public final class a
{
  private final b a;
  private int b = 2147483647;
  private int c = 0;
  
  public a(EditText paramEditText, boolean paramBoolean)
  {
    h.h(paramEditText, "editText cannot be null");
    this.a = new a(paramEditText, paramBoolean);
  }
  
  public KeyListener a(KeyListener paramKeyListener)
  {
    return this.a.a(paramKeyListener);
  }
  
  public InputConnection b(InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    if (paramInputConnection == null) {
      return null;
    }
    return this.a.b(paramInputConnection, paramEditorInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  private static class a
    extends a.b
  {
    private final EditText a;
    private final g b;
    
    a(EditText paramEditText, boolean paramBoolean)
    {
      this.a = paramEditText;
      g localg = new g(paramEditText, paramBoolean);
      this.b = localg;
      paramEditText.addTextChangedListener(localg);
      paramEditText.setEditableFactory(b.getInstance());
    }
    
    KeyListener a(KeyListener paramKeyListener)
    {
      if ((paramKeyListener instanceof e)) {
        return paramKeyListener;
      }
      if (paramKeyListener == null) {
        return null;
      }
      return new e(paramKeyListener);
    }
    
    InputConnection b(InputConnection paramInputConnection, EditorInfo paramEditorInfo)
    {
      if ((paramInputConnection instanceof c)) {
        return paramInputConnection;
      }
      return new c(this.a, paramInputConnection, paramEditorInfo);
    }
    
    void c(boolean paramBoolean)
    {
      this.b.c(paramBoolean);
    }
  }
  
  static class b
  {
    KeyListener a(KeyListener paramKeyListener)
    {
      throw null;
    }
    
    InputConnection b(InputConnection paramInputConnection, EditorInfo paramEditorInfo)
    {
      throw null;
    }
    
    void c(boolean paramBoolean)
    {
      throw null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.a
 * JD-Core Version:    0.7.0.1
 */