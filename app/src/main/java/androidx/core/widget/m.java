package androidx.core.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.c;
import androidx.core.view.s;

public final class m
  implements s
{
  private static CharSequence b(Context paramContext, ClipData.Item paramItem, int paramInt)
  {
    return a.a(paramContext, paramItem, paramInt);
  }
  
  private static void c(Editable paramEditable, CharSequence paramCharSequence)
  {
    int j = Selection.getSelectionStart(paramEditable);
    int k = Selection.getSelectionEnd(paramEditable);
    int i = Math.max(0, Math.min(j, k));
    j = Math.max(0, Math.max(j, k));
    Selection.setSelection(paramEditable, j);
    paramEditable.replace(i, j, paramCharSequence);
  }
  
  public c a(View paramView, c paramc)
  {
    if (Log.isLoggable("ReceiveContent", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive: ");
      ((StringBuilder)localObject).append(paramc);
      Log.d("ReceiveContent", ((StringBuilder)localObject).toString());
    }
    if (paramc.d() == 2) {
      return paramc;
    }
    Object localObject = paramc.b();
    int m = paramc.c();
    paramc = (TextView)paramView;
    paramView = (Editable)paramc.getText();
    paramc = paramc.getContext();
    int i = 0;
    int k;
    for (int j = 0; i < ((ClipData)localObject).getItemCount(); j = k)
    {
      CharSequence localCharSequence = b(paramc, ((ClipData)localObject).getItemAt(i), m);
      k = j;
      if (localCharSequence != null) {
        if (j == 0)
        {
          c(paramView, localCharSequence);
          k = 1;
        }
        else
        {
          paramView.insert(Selection.getSelectionEnd(paramView), "\n");
          paramView.insert(Selection.getSelectionEnd(paramView), localCharSequence);
          k = j;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static final class a
  {
    static CharSequence a(Context paramContext, ClipData.Item paramItem, int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        paramItem = paramItem.coerceToText(paramContext);
        paramContext = paramItem;
        if ((paramItem instanceof Spanned)) {
          paramContext = paramItem.toString();
        }
        return paramContext;
      }
      return paramItem.coerceToStyledText(paramContext);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.m
 * JD-Core Version:    0.7.0.1
 */