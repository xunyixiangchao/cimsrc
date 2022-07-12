package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final String[] L = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  private static final TypeEvaluator<Matrix> M = new a();
  private static final Property<ImageView, Matrix> N = new b(Matrix.class, "animatedTransform");
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void l0(t paramt)
  {
    View localView = paramt.b;
    if ((localView instanceof ImageView))
    {
      if (localView.getVisibility() != 0) {
        return;
      }
      ImageView localImageView = (ImageView)localView;
      if (localImageView.getDrawable() == null) {
        return;
      }
      paramt = paramt.a;
      paramt.put("android:changeImageTransform:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramt.put("android:changeImageTransform:matrix", n0(localImageView));
    }
  }
  
  private static Matrix m0(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    int i = localDrawable.getIntrinsicWidth();
    float f1 = paramImageView.getWidth();
    float f2 = i;
    float f5 = f1 / f2;
    i = localDrawable.getIntrinsicHeight();
    float f3 = paramImageView.getHeight();
    float f4 = i;
    f5 = Math.max(f5, f3 / f4);
    i = Math.round((f1 - f2 * f5) / 2.0F);
    int j = Math.round((f3 - f4 * f5) / 2.0F);
    paramImageView = new Matrix();
    paramImageView.postScale(f5, f5);
    paramImageView.postTranslate(i, j);
    return paramImageView;
  }
  
  private static Matrix n0(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable.getIntrinsicWidth() > 0) && (localDrawable.getIntrinsicHeight() > 0))
    {
      int i = c.a[paramImageView.getScaleType().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return m0(paramImageView);
        }
      }
      else {
        return q0(paramImageView);
      }
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  private ObjectAnimator o0(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return ObjectAnimator.ofObject(paramImageView, N, new s.a(), new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  private ObjectAnimator p0(ImageView paramImageView)
  {
    Property localProperty = N;
    TypeEvaluator localTypeEvaluator = M;
    Matrix localMatrix = k.a;
    return ObjectAnimator.ofObject(paramImageView, localProperty, localTypeEvaluator, new Matrix[] { localMatrix, localMatrix });
  }
  
  private static Matrix q0(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramImageView.getWidth() / localDrawable.getIntrinsicWidth(), paramImageView.getHeight() / localDrawable.getIntrinsicHeight());
    return localMatrix;
  }
  
  public String[] I()
  {
    return L;
  }
  
  public void j(t paramt)
  {
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    l0(paramt);
  }
  
  public Animator q(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    Matrix localMatrix = null;
    paramViewGroup = localMatrix;
    if (paramt1 != null)
    {
      if (paramt2 == null) {
        return null;
      }
      Rect localRect1 = (Rect)paramt1.a.get("android:changeImageTransform:bounds");
      Rect localRect2 = (Rect)paramt2.a.get("android:changeImageTransform:bounds");
      paramViewGroup = localMatrix;
      if (localRect1 != null)
      {
        if (localRect2 == null) {
          return null;
        }
        paramt1 = (Matrix)paramt1.a.get("android:changeImageTransform:matrix");
        localMatrix = (Matrix)paramt2.a.get("android:changeImageTransform:matrix");
        if (((paramt1 == null) && (localMatrix == null)) || ((paramt1 != null) && (paramt1.equals(localMatrix)))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((localRect1.equals(localRect2)) && (i != 0)) {
          return null;
        }
        paramt2 = (ImageView)paramt2.b;
        paramViewGroup = paramt2.getDrawable();
        int i = paramViewGroup.getIntrinsicWidth();
        int j = paramViewGroup.getIntrinsicHeight();
        if ((i > 0) && (j > 0))
        {
          paramViewGroup = paramt1;
          if (paramt1 == null) {
            paramViewGroup = k.a;
          }
          paramt1 = localMatrix;
          if (localMatrix == null) {
            paramt1 = k.a;
          }
          N.set(paramt2, paramViewGroup);
          return o0(paramt2, paramViewGroup, paramt1);
        }
        paramViewGroup = p0(paramt2);
      }
    }
    return paramViewGroup;
  }
  
  static final class a
    implements TypeEvaluator<Matrix>
  {
    public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      return null;
    }
  }
  
  static final class b
    extends Property<ImageView, Matrix>
  {
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Matrix a(ImageView paramImageView)
    {
      return null;
    }
    
    public void b(ImageView paramImageView, Matrix paramMatrix)
    {
      j.a(paramImageView, paramMatrix);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */