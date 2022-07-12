package androidx.appcompat.widget;

import a1.a;
import a1.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R.attr;
import androidx.core.view.c;
import androidx.core.view.t;
import androidx.core.view.x;
import androidx.core.widget.l;

public class AppCompatEditText
  extends EditText
  implements t
{
  private final d a;
  private final p b;
  private final o c;
  private final androidx.core.widget.m d;
  private final h e;
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.b = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    paramContext.b();
    this.c = new o(this);
    this.d = new androidx.core.widget.m();
    paramContext = new h(this);
    this.e = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public c a(c paramc)
  {
    return this.d.a(this, paramc);
  }
  
  void b(h paramh)
  {
    KeyListener localKeyListener = getKeyListener();
    if (paramh.b(localKeyListener))
    {
      boolean bool = super.isFocusable();
      int i = super.getInputType();
      paramh = paramh.a(localKeyListener);
      if (paramh == localKeyListener) {
        return;
      }
      super.setKeyListener(paramh);
      super.setRawInputType(i);
      super.setFocusable(bool);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.b;
    if (localObject != null) {
      ((p)localObject).b();
    }
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return l.q(super.getCustomSelectionActionModeCallback());
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public Editable getText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return super.getText();
    }
    return super.getEditableText();
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      o localo = this.c;
      if (localo != null) {
        return localo.a();
      }
    }
    return super.getTextClassifier();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    Object localObject = super.onCreateInputConnection(paramEditorInfo);
    this.b.r(this, (InputConnection)localObject, paramEditorInfo);
    InputConnection localInputConnection = j.a((InputConnection)localObject, paramEditorInfo, this);
    localObject = localInputConnection;
    if (localInputConnection != null)
    {
      localObject = localInputConnection;
      if (Build.VERSION.SDK_INT <= 30)
      {
        String[] arrayOfString = x.E(this);
        localObject = localInputConnection;
        if (arrayOfString != null)
        {
          a.d(paramEditorInfo, arrayOfString);
          localObject = b.b(this, localInputConnection, paramEditorInfo);
        }
      }
    }
    return this.e.d((InputConnection)localObject, paramEditorInfo);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (m.a(this, paramDragEvent)) {
      return true;
    }
    return super.onDragEvent(paramDragEvent);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (m.b(this, paramInt)) {
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.a;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.a;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(l.r(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    this.e.e(paramBoolean);
  }
  
  public void setKeyListener(KeyListener paramKeyListener)
  {
    super.setKeyListener(this.e.a(paramKeyListener));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.a;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.a;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    p localp = this.b;
    if (localp != null) {
      localp.q(paramContext, paramInt);
    }
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      o localo = this.c;
      if (localo != null)
      {
        localo.b(paramTextClassifier);
        return;
      }
    }
    super.setTextClassifier(paramTextClassifier);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatEditText
 * JD-Core Version:    0.7.0.1
 */