package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class s
{
  private static final boolean a;
  private static final boolean b;
  private static final boolean c;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    a = true;
    b = true;
    if (i < 28) {
      bool = false;
    }
    c = bool;
  }
  
  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    b0.j(paramView1, localMatrix);
    b0.k(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int i = Math.round(localRectF.left);
    int j = Math.round(localRectF.top);
    int k = Math.round(localRectF.right);
    int m = Math.round(localRectF.bottom);
    paramView2 = new ImageView(paramView1.getContext());
    paramView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup = b(paramView1, localMatrix, localRectF, paramViewGroup);
    if (paramViewGroup != null) {
      paramView2.setImageBitmap(paramViewGroup);
    }
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    paramView2.layout(i, j, k, m);
    return paramView2;
  }
  
  private static Bitmap b(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup)
  {
    boolean bool2;
    boolean bool1;
    if (a)
    {
      bool2 = paramView.isAttachedToWindow() ^ true;
      if (paramViewGroup == null) {
        bool1 = false;
      } else {
        bool1 = paramViewGroup.isAttachedToWindow();
      }
    }
    else
    {
      bool2 = false;
      bool1 = bool2;
    }
    boolean bool3 = b;
    Object localObject2 = null;
    ViewGroup localViewGroup;
    int i;
    if ((bool3) && (bool2))
    {
      if (!bool1) {
        return null;
      }
      localViewGroup = (ViewGroup)paramView.getParent();
      i = localViewGroup.indexOfChild(paramView);
      paramViewGroup.getOverlay().add(paramView);
    }
    else
    {
      i = 0;
      localViewGroup = null;
    }
    int k = Math.round(paramRectF.width());
    int j = Math.round(paramRectF.height());
    Object localObject1 = localObject2;
    if (k > 0)
    {
      localObject1 = localObject2;
      if (j > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (k * j));
        k = Math.round(k * f);
        j = Math.round(j * f);
        paramMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
        paramMatrix.postScale(f, f);
        if (c)
        {
          paramRectF = new Picture();
          localObject1 = paramRectF.beginRecording(k, j);
          ((Canvas)localObject1).concat(paramMatrix);
          paramView.draw((Canvas)localObject1);
          paramRectF.endRecording();
          localObject1 = Bitmap.createBitmap(paramRectF);
        }
        else
        {
          localObject1 = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
          paramRectF = new Canvas((Bitmap)localObject1);
          paramRectF.concat(paramMatrix);
          paramView.draw(paramRectF);
        }
      }
    }
    if ((bool3) && (bool2))
    {
      paramViewGroup.getOverlay().remove(paramView);
      localViewGroup.addView(paramView, i);
    }
    return localObject1;
  }
  
  static Animator c(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null) {
      return paramAnimator2;
    }
    if (paramAnimator2 == null) {
      return paramAnimator1;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  static class a
    implements TypeEvaluator<Matrix>
  {
    final float[] a = new float[9];
    final float[] b = new float[9];
    final Matrix c = new Matrix();
    
    public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      paramMatrix1.getValues(this.a);
      paramMatrix2.getValues(this.b);
      int i = 0;
      while (i < 9)
      {
        paramMatrix1 = this.b;
        float f1 = paramMatrix1[i];
        paramMatrix2 = this.a;
        float f2 = paramMatrix2[i];
        paramMatrix2[i] += (f1 - f2) * paramFloat;
        i += 1;
      }
      this.c.setValues(this.b);
      return this.c;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.s
 * JD-Core Version:    0.7.0.1
 */