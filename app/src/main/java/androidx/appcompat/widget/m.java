package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.c.a;
import androidx.core.view.x;

final class m
{
  static boolean a(View paramView, DragEvent paramDragEvent)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 31) && (i >= 24) && (paramDragEvent.getLocalState() == null))
    {
      if (x.E(paramView) == null) {
        return false;
      }
      Activity localActivity = c(paramView);
      if (localActivity == null)
      {
        paramDragEvent = new StringBuilder();
        paramDragEvent.append("Can't handle drop: no activity: view=");
        paramDragEvent.append(paramView);
        Log.i("ReceiveContent", paramDragEvent.toString());
        return false;
      }
      if (paramDragEvent.getAction() == 1) {
        return paramView instanceof TextView ^ true;
      }
      if (paramDragEvent.getAction() == 3)
      {
        if ((paramView instanceof TextView)) {
          return a.a(paramDragEvent, (TextView)paramView, localActivity);
        }
        return a.b(paramDragEvent, paramView, localActivity);
      }
    }
    return false;
  }
  
  static boolean b(TextView paramTextView, int paramInt)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j < 31) && (x.E(paramTextView) != null))
    {
      if ((paramInt != 16908322) && (paramInt != 16908337)) {
        return false;
      }
      Object localObject = (ClipboardManager)paramTextView.getContext().getSystemService("clipboard");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
      }
      if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
      {
        localObject = new c.a((ClipData)localObject, 1);
        if (paramInt == 16908322) {
          paramInt = i;
        } else {
          paramInt = 1;
        }
        x.g0(paramTextView, ((c.a)localObject).c(paramInt).a());
      }
      return true;
    }
    return false;
  }
  
  static Activity c(View paramView)
  {
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return (Activity)paramView;
      }
    }
    return null;
  }
  
  private static final class a
  {
    static boolean a(DragEvent paramDragEvent, TextView paramTextView, Activity paramActivity)
    {
      paramActivity.requestDragAndDropPermissions(paramDragEvent);
      int i = paramTextView.getOffsetForPosition(paramDragEvent.getX(), paramDragEvent.getY());
      paramTextView.beginBatchEdit();
      try
      {
        Selection.setSelection((Spannable)paramTextView.getText(), i);
        x.g0(paramTextView, new c.a(paramDragEvent.getClipData(), 3).a());
        return true;
      }
      finally
      {
        paramTextView.endBatchEdit();
      }
    }
    
    static boolean b(DragEvent paramDragEvent, View paramView, Activity paramActivity)
    {
      paramActivity.requestDragAndDropPermissions(paramDragEvent);
      x.g0(paramView, new c.a(paramDragEvent.getClipData(), 3).a());
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.m
 * JD-Core Version:    0.7.0.1
 */