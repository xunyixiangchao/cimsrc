package g1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.d.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class d
  implements InputFilter
{
  private final TextView a;
  private d.e b;
  
  d(TextView paramTextView)
  {
    this.a = paramTextView;
  }
  
  private d.e a()
  {
    if (this.b == null) {
      this.b = new a(this.a, this);
    }
    return this.b;
  }
  
  static void b(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      Selection.setSelection(paramSpannable, paramInt1, paramInt2);
      return;
    }
    if (paramInt1 >= 0)
    {
      Selection.setSelection(paramSpannable, paramInt1);
      return;
    }
    if (paramInt2 >= 0) {
      Selection.setSelection(paramSpannable, paramInt2);
    }
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.a.isInEditMode()) {
      return paramCharSequence;
    }
    int i = androidx.emoji2.text.d.b().d();
    if (i != 0)
    {
      int j = 1;
      if (i != 1)
      {
        if (i != 3) {
          return paramCharSequence;
        }
      }
      else
      {
        i = j;
        if (paramInt4 == 0)
        {
          i = j;
          if (paramInt3 == 0)
          {
            i = j;
            if (paramSpanned.length() == 0)
            {
              i = j;
              if (paramCharSequence == this.a.getText()) {
                i = 0;
              }
            }
          }
        }
        paramSpanned = paramCharSequence;
        if (i != 0)
        {
          paramSpanned = paramCharSequence;
          if (paramCharSequence != null)
          {
            if ((paramInt1 != 0) || (paramInt2 != paramCharSequence.length())) {
              paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
            }
            paramSpanned = androidx.emoji2.text.d.b().p(paramCharSequence, 0, paramCharSequence.length());
          }
        }
        return paramSpanned;
      }
    }
    androidx.emoji2.text.d.b().s(a());
    return paramCharSequence;
  }
  
  private static class a
    extends d.e
  {
    private final Reference<TextView> a;
    private final Reference<d> b;
    
    a(TextView paramTextView, d paramd)
    {
      this.a = new WeakReference(paramTextView);
      this.b = new WeakReference(paramd);
    }
    
    private boolean c(TextView paramTextView, InputFilter paramInputFilter)
    {
      if (paramInputFilter != null)
      {
        if (paramTextView == null) {
          return false;
        }
        paramTextView = paramTextView.getFilters();
        if (paramTextView == null) {
          return false;
        }
        int i = 0;
        while (i < paramTextView.length)
        {
          if (paramTextView[i] == paramInputFilter) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    
    public void b()
    {
      super.b();
      TextView localTextView = (TextView)this.a.get();
      if (!c(localTextView, (InputFilter)this.b.get())) {
        return;
      }
      if (localTextView.isAttachedToWindow())
      {
        CharSequence localCharSequence = androidx.emoji2.text.d.b().o(localTextView.getText());
        int i = Selection.getSelectionStart(localCharSequence);
        int j = Selection.getSelectionEnd(localCharSequence);
        localTextView.setText(localCharSequence);
        if ((localCharSequence instanceof Spannable)) {
          d.b((Spannable)localCharSequence, i, j);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.d
 * JD-Core Version:    0.7.0.1
 */