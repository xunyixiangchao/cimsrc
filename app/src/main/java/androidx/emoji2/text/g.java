package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;
import q0.c;

final class g
{
  private final d.i a;
  private final l b;
  private d.d c;
  private final boolean d;
  private final int[] e;
  
  g(l paraml, d.i parami, d.d paramd, boolean paramBoolean, int[] paramArrayOfInt)
  {
    this.a = parami;
    this.b = paraml;
    this.c = paramd;
    this.d = paramBoolean;
    this.e = paramArrayOfInt;
  }
  
  private void a(Spannable paramSpannable, f paramf, int paramInt1, int paramInt2)
  {
    paramSpannable.setSpan(this.a.a(paramf), paramInt1, paramInt2, 33);
  }
  
  private static boolean b(Editable paramEditable, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (g(paramKeyEvent)) {
      return false;
    }
    int j = Selection.getSelectionStart(paramEditable);
    int i = Selection.getSelectionEnd(paramEditable);
    if (f(j, i)) {
      return false;
    }
    paramKeyEvent = (h[])paramEditable.getSpans(j, i, h.class);
    if ((paramKeyEvent != null) && (paramKeyEvent.length > 0))
    {
      int k = paramKeyEvent.length;
      i = 0;
      while (i < k)
      {
        Object localObject = paramKeyEvent[i];
        int m = paramEditable.getSpanStart(localObject);
        int n = paramEditable.getSpanEnd(localObject);
        if (((paramBoolean) && (m == j)) || ((!paramBoolean) && (n == j)) || ((j > m) && (j < n)))
        {
          paramEditable.delete(m, n);
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  static boolean c(InputConnection paramInputConnection, Editable paramEditable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramEditable != null)
    {
      if (paramInputConnection == null) {
        return false;
      }
      if (paramInt1 >= 0)
      {
        if (paramInt2 < 0) {
          return false;
        }
        int j = Selection.getSelectionStart(paramEditable);
        int i = Selection.getSelectionEnd(paramEditable);
        if (f(j, i)) {
          return false;
        }
        if (paramBoolean)
        {
          paramInt1 = a.a(paramEditable, j, Math.max(paramInt1, 0));
          i = a.b(paramEditable, i, Math.max(paramInt2, 0));
          if (paramInt1 != -1)
          {
            paramInt2 = i;
            if (i != -1) {}
          }
          else
          {
            return false;
          }
        }
        else
        {
          paramInt1 = Math.max(j - paramInt1, 0);
          paramInt2 = Math.min(i + paramInt2, paramEditable.length());
        }
        h[] arrayOfh = (h[])paramEditable.getSpans(paramInt1, paramInt2, h.class);
        if ((arrayOfh != null) && (arrayOfh.length > 0))
        {
          int k = arrayOfh.length;
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          while (paramInt1 < k)
          {
            h localh = arrayOfh[paramInt1];
            int m = paramEditable.getSpanStart(localh);
            j = paramEditable.getSpanEnd(localh);
            i = Math.min(m, i);
            paramInt2 = Math.max(j, paramInt2);
            paramInt1 += 1;
          }
          paramInt1 = Math.max(i, 0);
          paramInt2 = Math.min(paramInt2, paramEditable.length());
          paramInputConnection.beginBatchEdit();
          paramEditable.delete(paramInt1, paramInt2);
          paramInputConnection.endBatchEdit();
          return true;
        }
      }
    }
    return false;
  }
  
  static boolean d(Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt != 67)
    {
      if (paramInt != 112) {
        bool = false;
      } else {
        bool = b(paramEditable, paramKeyEvent, true);
      }
    }
    else {
      bool = b(paramEditable, paramKeyEvent, false);
    }
    if (bool)
    {
      MetaKeyKeyListener.adjustMetaAfterKeypress(paramEditable);
      return true;
    }
    return false;
  }
  
  private boolean e(CharSequence paramCharSequence, int paramInt1, int paramInt2, f paramf)
  {
    if (paramf.d() == 0) {
      paramf.k(this.c.a(paramCharSequence, paramInt1, paramInt2, paramf.h()));
    }
    return paramf.d() == 2;
  }
  
  private static boolean f(int paramInt1, int paramInt2)
  {
    return (paramInt1 == -1) || (paramInt2 == -1) || (paramInt1 != paramInt2);
  }
  
  private static boolean g(KeyEvent paramKeyEvent)
  {
    return KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState()) ^ true;
  }
  
  CharSequence h(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = paramCharSequence instanceof m;
    if (bool) {
      ((m)paramCharSequence).a();
    }
    Object localObject3 = null;
    if (!bool) {}
    for (;;)
    {
      int i;
      int n;
      try
      {
        Object localObject1;
        if (!(paramCharSequence instanceof Spannable))
        {
          localObject1 = localObject3;
          if ((paramCharSequence instanceof Spanned))
          {
            localObject1 = localObject3;
            if (((Spanned)paramCharSequence).nextSpanTransition(paramInt1 - 1, paramInt2 + 1, h.class) <= paramInt2) {
              localObject1 = new SpannableString(paramCharSequence);
            }
          }
        }
        else
        {
          localObject1 = (Spannable)paramCharSequence;
        }
        i = paramInt1;
        int j = paramInt2;
        int k;
        Object localObject4;
        if (localObject1 != null)
        {
          localObject3 = (h[])((Spannable)localObject1).getSpans(paramInt1, paramInt2, h.class);
          i = paramInt1;
          j = paramInt2;
          if (localObject3 != null)
          {
            i = paramInt1;
            j = paramInt2;
            if (localObject3.length > 0)
            {
              m = localObject3.length;
              k = 0;
              i = paramInt1;
              j = paramInt2;
              if (k < m)
              {
                localObject4 = localObject3[k];
                j = ((Spannable)localObject1).getSpanStart(localObject4);
                i = ((Spannable)localObject1).getSpanEnd(localObject4);
                if (j != paramInt2) {
                  ((Spannable)localObject1).removeSpan(localObject4);
                }
                paramInt1 = Math.min(j, paramInt1);
                paramInt2 = Math.max(i, paramInt2);
                k += 1;
                continue;
              }
            }
          }
        }
        if ((i != j) && (i < paramCharSequence.length()))
        {
          k = paramInt3;
          if (paramInt3 != 2147483647)
          {
            k = paramInt3;
            if (localObject1 != null) {
              k = paramInt3 - ((h[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), h.class)).length;
            }
          }
          localObject4 = new c(this.b.f(), this.d, this.e);
          n = Character.codePointAt(paramCharSequence, i);
          paramInt3 = 0;
          break label656;
          if ((paramInt2 < j) && (paramInt3 < k))
          {
            i = ((c)localObject4).a(paramInt1);
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3) {
                  continue;
                }
                if (!paramBoolean)
                {
                  n = paramInt1;
                  i = paramInt2;
                  if (e(paramCharSequence, m, paramInt2, ((c)localObject4).c())) {}
                }
                else
                {
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = new SpannableString(paramCharSequence);
                  }
                  a((Spannable)localObject3, ((c)localObject4).c(), m, paramInt2);
                  paramInt3 += 1;
                  localObject1 = localObject3;
                  n = paramInt1;
                  i = paramInt2;
                }
              }
              else
              {
                i = paramInt2 + Character.charCount(paramInt1);
                paramInt2 = i;
                if (i >= j) {
                  continue;
                }
                paramInt1 = Character.codePointAt(paramCharSequence, i);
                paramInt2 = i;
              }
            }
            else
            {
              m += Character.charCount(Character.codePointAt(paramCharSequence, m));
              if (m >= j) {
                break label669;
              }
              paramInt1 = Character.codePointAt(paramCharSequence, m);
              break label669;
            }
          }
          else
          {
            localObject3 = localObject1;
            if (((c)localObject4).e())
            {
              localObject3 = localObject1;
              if (paramInt3 < k) {
                if (!paramBoolean)
                {
                  localObject3 = localObject1;
                  if (e(paramCharSequence, m, paramInt2, ((c)localObject4).b())) {}
                }
                else
                {
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = new SpannableString(paramCharSequence);
                  }
                  a((Spannable)localObject3, ((c)localObject4).b(), m, paramInt2);
                }
              }
            }
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = paramCharSequence;
            }
            return localObject1;
          }
        }
        else
        {
          return paramCharSequence;
        }
      }
      finally
      {
        if (bool) {
          ((m)paramCharSequence).d();
        }
      }
      label656:
      int m = i;
      paramInt1 = n;
      paramInt2 = i;
      continue;
      label669:
      paramInt2 = m;
    }
  }
  
  private static final class a
  {
    static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int i = paramCharSequence.length();
      if (paramInt1 >= 0)
      {
        if (i < paramInt1) {
          return -1;
        }
        if (paramInt2 < 0) {
          return -1;
        }
        i = 0;
        for (;;)
        {
          if (paramInt2 == 0) {
            return paramInt1;
          }
          paramInt1 -= 1;
          if (paramInt1 < 0)
          {
            if (i != 0) {
              return -1;
            }
            return 0;
          }
          char c = paramCharSequence.charAt(paramInt1);
          if (i != 0)
          {
            if (!Character.isHighSurrogate(c)) {
              return -1;
            }
            paramInt2 -= 1;
            break;
          }
          if (!Character.isSurrogate(c))
          {
            paramInt2 -= 1;
          }
          else
          {
            if (Character.isHighSurrogate(c)) {
              return -1;
            }
            i = 1;
          }
        }
      }
      return -1;
    }
    
    static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int j = paramCharSequence.length();
      if (paramInt1 >= 0)
      {
        if (j < paramInt1) {
          return -1;
        }
        if (paramInt2 < 0) {
          return -1;
        }
        int i = 0;
        for (;;)
        {
          if (paramInt2 == 0) {
            return paramInt1;
          }
          if (paramInt1 >= j)
          {
            if (i != 0) {
              return -1;
            }
            return j;
          }
          char c = paramCharSequence.charAt(paramInt1);
          if (i != 0)
          {
            if (!Character.isLowSurrogate(c)) {
              return -1;
            }
            paramInt2 -= 1;
            paramInt1 += 1;
            break;
          }
          if (!Character.isSurrogate(c))
          {
            paramInt2 -= 1;
            paramInt1 += 1;
          }
          else
          {
            if (Character.isLowSurrogate(c)) {
              return -1;
            }
            paramInt1 += 1;
            i = 1;
          }
        }
      }
      return -1;
    }
  }
  
  public static class b
    implements d.d
  {
    private static final ThreadLocal<StringBuilder> b = new ThreadLocal();
    private final TextPaint a;
    
    b()
    {
      TextPaint localTextPaint = new TextPaint();
      this.a = localTextPaint;
      localTextPaint.setTextSize(10.0F);
    }
    
    private static StringBuilder b()
    {
      ThreadLocal localThreadLocal = b;
      if (localThreadLocal.get() == null) {
        localThreadLocal.set(new StringBuilder());
      }
      return (StringBuilder)localThreadLocal.get();
    }
    
    public boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      StringBuilder localStringBuilder = b();
      localStringBuilder.setLength(0);
      while (paramInt1 < paramInt2)
      {
        localStringBuilder.append(paramCharSequence.charAt(paramInt1));
        paramInt1 += 1;
      }
      return c.a(this.a, localStringBuilder.toString());
    }
  }
  
  static final class c
  {
    private int a = 1;
    private final l.a b;
    private l.a c;
    private l.a d;
    private int e;
    private int f;
    private final boolean g;
    private final int[] h;
    
    c(l.a parama, boolean paramBoolean, int[] paramArrayOfInt)
    {
      this.b = parama;
      this.c = parama;
      this.g = paramBoolean;
      this.h = paramArrayOfInt;
    }
    
    private static boolean d(int paramInt)
    {
      return paramInt == 65039;
    }
    
    private static boolean f(int paramInt)
    {
      return paramInt == 65038;
    }
    
    private int g()
    {
      this.a = 1;
      this.c = this.b;
      this.f = 0;
      return 1;
    }
    
    private boolean h()
    {
      if (this.c.b().j()) {
        return true;
      }
      if (d(this.e)) {
        return true;
      }
      if (this.g)
      {
        if (this.h == null) {
          return true;
        }
        int i = this.c.b().b(0);
        if (Arrays.binarySearch(this.h, i) < 0) {
          return true;
        }
      }
      return false;
    }
    
    int a(int paramInt)
    {
      l.a locala = this.c.a(paramInt);
      int j = this.a;
      int i = 3;
      if (j != 2) {
        if (locala != null) {}
      }
      do
      {
        i = g();
        break;
        this.a = 2;
        this.c = locala;
        this.f = 1;
        do
        {
          for (;;)
          {
            i = 2;
            break label138;
            if (locala == null) {
              break;
            }
            this.c = locala;
            this.f += 1;
          }
          if (f(paramInt)) {
            break;
          }
        } while (d(paramInt));
      } while ((this.c.b() == null) || ((this.f == 1) && (!h())));
      this.d = this.c;
      g();
      label138:
      this.e = paramInt;
      return i;
    }
    
    f b()
    {
      return this.c.b();
    }
    
    f c()
    {
      return this.d.b();
    }
    
    boolean e()
    {
      int i = this.a;
      boolean bool = true;
      if ((i == 2) && (this.c.b() != null))
      {
        if (this.f > 1) {
          return bool;
        }
        if (h()) {
          return true;
        }
      }
      bool = false;
      return bool;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.g
 * JD-Core Version:    0.7.0.1
 */