package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R.attr;

public class AppCompatSeekBar
  extends SeekBar
{
  private final n a;
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new n(this);
    this.a = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.a.h();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    this.a.i();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      this.a.g(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatSeekBar
 * JD-Core Version:    0.7.0.1
 */