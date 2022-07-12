package g1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.d;

final class c
  extends InputConnectionWrapper
{
  private final TextView a;
  private final a b;
  
  c(TextView paramTextView, InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    this(paramTextView, paramInputConnection, paramEditorInfo, new a());
  }
  
  c(TextView paramTextView, InputConnection paramInputConnection, EditorInfo paramEditorInfo, a parama)
  {
    super(paramInputConnection, false);
    this.a = paramTextView;
    this.b = parama;
    parama.b(paramEditorInfo);
  }
  
  private Editable a()
  {
    return this.a.getEditableText();
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    return (this.b.a(this, a(), paramInt1, paramInt2, false)) || (super.deleteSurroundingText(paramInt1, paramInt2));
  }
  
  public boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    return (this.b.a(this, a(), paramInt1, paramInt2, true)) || (super.deleteSurroundingTextInCodePoints(paramInt1, paramInt2));
  }
  
  public static class a
  {
    public boolean a(InputConnection paramInputConnection, Editable paramEditable, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return d.e(paramInputConnection, paramEditable, paramInt1, paramInt2, paramBoolean);
    }
    
    public void b(EditorInfo paramEditorInfo)
    {
      if (d.h()) {
        d.b().u(paramEditorInfo);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.c
 * JD-Core Version:    0.7.0.1
 */