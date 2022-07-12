package g1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.d.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class g
  implements TextWatcher
{
  private final EditText a;
  private final boolean b;
  private d.e c;
  private int d = 2147483647;
  private int e = 0;
  private boolean f;
  
  g(EditText paramEditText, boolean paramBoolean)
  {
    this.a = paramEditText;
    this.b = paramBoolean;
    this.f = true;
  }
  
  private d.e a()
  {
    if (this.c == null) {
      this.c = new a(this.a);
    }
    return this.c;
  }
  
  static void b(EditText paramEditText, int paramInt)
  {
    if ((paramInt == 1) && (paramEditText != null) && (paramEditText.isAttachedToWindow()))
    {
      paramEditText = paramEditText.getEditableText();
      paramInt = Selection.getSelectionStart(paramEditText);
      int i = Selection.getSelectionEnd(paramEditText);
      androidx.emoji2.text.d.b().o(paramEditText);
      d.b(paramEditText, paramInt, i);
    }
  }
  
  private boolean d()
  {
    return (!this.f) || ((!this.b) && (!androidx.emoji2.text.d.h()));
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      if (this.c != null) {
        androidx.emoji2.text.d.b().t(this.c);
      }
      this.f = paramBoolean;
      if (paramBoolean) {
        b(this.a, androidx.emoji2.text.d.b().d());
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.a.isInEditMode())
    {
      if (d()) {
        return;
      }
      if ((paramInt2 <= paramInt3) && ((paramCharSequence instanceof Spannable)))
      {
        paramInt2 = androidx.emoji2.text.d.b().d();
        if (paramInt2 != 0) {
          if (paramInt2 != 1)
          {
            if (paramInt2 == 3) {}
          }
          else
          {
            paramCharSequence = (Spannable)paramCharSequence;
            androidx.emoji2.text.d.b().r(paramCharSequence, paramInt1, paramInt1 + paramInt3, this.d, this.e);
            return;
          }
        }
        androidx.emoji2.text.d.b().s(a());
      }
    }
  }
  
  private static class a
    extends d.e
  {
    private final Reference<EditText> a;
    
    a(EditText paramEditText)
    {
      this.a = new WeakReference(paramEditText);
    }
    
    public void b()
    {
      super.b();
      g.b((EditText)this.a.get(), 1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.g
 * JD-Core Version:    0.7.0.1
 */