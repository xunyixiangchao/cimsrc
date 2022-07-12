package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R.attr;

public class AppCompatRatingBar
  extends RatingBar
{
  private final l a;
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ratingBarStyle);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new l(this);
    this.a = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.a.b();
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatRatingBar
 * JD-Core Version:    0.7.0.1
 */