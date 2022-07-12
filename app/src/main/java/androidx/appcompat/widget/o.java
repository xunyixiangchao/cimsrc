package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import x0.h;

final class o
{
  private TextView a;
  private TextClassifier b;
  
  o(TextView paramTextView)
  {
    this.a = ((TextView)h.g(paramTextView));
  }
  
  public TextClassifier a()
  {
    TextClassifier localTextClassifier = this.b;
    Object localObject = localTextClassifier;
    if (localTextClassifier == null)
    {
      localObject = (TextClassificationManager)this.a.getContext().getSystemService(TextClassificationManager.class);
      if (localObject != null) {
        return ((TextClassificationManager)localObject).getTextClassifier();
      }
      localObject = TextClassifier.NO_OP;
    }
    return localObject;
  }
  
  public void b(TextClassifier paramTextClassifier)
  {
    this.b = paramTextClassifier;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.o
 * JD-Core Version:    0.7.0.1
 */