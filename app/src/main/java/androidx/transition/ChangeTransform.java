package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final String[] O = { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
  private static final Property<e, float[]> P = new a([F.class, "nonTranslations");
  private static final Property<e, PointF> Q = new b(PointF.class, "translations");
  private static final boolean R = true;
  boolean L = true;
  private boolean M = true;
  private Matrix N = new Matrix();
  
  public ChangeTransform() {}
  
  @SuppressLint({"RestrictedApi"})
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.g);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    this.L = p0.i.a(paramContext, paramAttributeSet, "reparentWithOverlay", 1, true);
    this.M = p0.i.a(paramContext, paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private void l0(t paramt)
  {
    View localView = paramt.b;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramt.a.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new f(localView);
    paramt.a.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject != null) && (!((Matrix)localObject).isIdentity())) {
      localObject = new Matrix((Matrix)localObject);
    } else {
      localObject = null;
    }
    paramt.a.put("android:changeTransform:matrix", localObject);
    if (this.M)
    {
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      b0.j(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramt.a.put("android:changeTransform:parentMatrix", localObject);
      paramt.a.put("android:changeTransform:intermediateMatrix", localView.getTag(R.id.transition_transform));
      paramt.a.put("android:changeTransform:intermediateParentMatrix", localView.getTag(R.id.parent_matrix));
    }
  }
  
  private void m0(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    View localView = paramt2.b;
    Object localObject = new Matrix((Matrix)paramt2.a.get("android:changeTransform:parentMatrix"));
    b0.k(paramViewGroup, (Matrix)localObject);
    e locale = i.a(localView, paramViewGroup, (Matrix)localObject);
    if (locale == null) {
      return;
    }
    locale.a((ViewGroup)paramt1.a.get("android:changeTransform:parent"), paramt1.b);
    for (paramViewGroup = this;; paramViewGroup = (ViewGroup)localObject)
    {
      localObject = paramViewGroup.r;
      if (localObject == null) {
        break;
      }
    }
    paramViewGroup.a(new d(localView, locale));
    if (R)
    {
      paramViewGroup = paramt1.b;
      if (paramViewGroup != paramt2.b) {
        b0.h(paramViewGroup, 0.0F);
      }
      b0.h(localView, 1.0F);
    }
  }
  
  private ObjectAnimator n0(final t paramt1, final t paramt2, final boolean paramBoolean)
  {
    paramt1 = (Matrix)paramt1.a.get("android:changeTransform:matrix");
    Object localObject2 = (Matrix)paramt2.a.get("android:changeTransform:matrix");
    Object localObject1 = paramt1;
    if (paramt1 == null) {
      localObject1 = k.a;
    }
    paramt1 = (t)localObject2;
    if (localObject2 == null) {
      paramt1 = k.a;
    }
    if (((Matrix)localObject1).equals(paramt1)) {
      return null;
    }
    localObject2 = (f)paramt2.a.get("android:changeTransform:transforms");
    paramt2 = paramt2.b;
    p0(paramt2);
    Object localObject3 = new float[9];
    ((Matrix)localObject1).getValues((float[])localObject3);
    float[] arrayOfFloat = new float[9];
    paramt1.getValues(arrayOfFloat);
    localObject1 = new e(paramt2, (float[])localObject3);
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofObject(P, new c(new float[9]), new float[][] { localObject3, arrayOfFloat });
    localObject3 = z().a(localObject3[2], localObject3[5], arrayOfFloat[2], arrayOfFloat[5]);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(localObject1, new PropertyValuesHolder[] { localPropertyValuesHolder, m.a(Q, (Path)localObject3) });
    paramt1 = new c(paramBoolean, paramt1, paramt2, (f)localObject2, (e)localObject1);
    ((ObjectAnimator)localObject3).addListener(paramt1);
    a.a((Animator)localObject3, paramt1);
    return localObject3;
  }
  
  private boolean o0(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    boolean bool3 = M(paramViewGroup1);
    boolean bool2 = true;
    boolean bool1 = false;
    if ((bool3) && (M(paramViewGroup2)))
    {
      paramViewGroup1 = x(paramViewGroup1, true);
      if (paramViewGroup1 == null) {
        return bool1;
      }
      if (paramViewGroup2 == paramViewGroup1.b) {
        return bool2;
      }
    }
    else if (paramViewGroup1 == paramViewGroup2)
    {
      return bool2;
    }
    bool1 = false;
    return bool1;
  }
  
  static void p0(View paramView)
  {
    r0(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void q0(t paramt1, t paramt2)
  {
    Matrix localMatrix1 = (Matrix)paramt2.a.get("android:changeTransform:parentMatrix");
    paramt2.b.setTag(R.id.parent_matrix, localMatrix1);
    Matrix localMatrix2 = this.N;
    localMatrix2.reset();
    localMatrix1.invert(localMatrix2);
    localMatrix1 = (Matrix)paramt1.a.get("android:changeTransform:matrix");
    paramt2 = localMatrix1;
    if (localMatrix1 == null)
    {
      paramt2 = new Matrix();
      paramt1.a.put("android:changeTransform:matrix", paramt2);
    }
    paramt2.postConcat((Matrix)paramt1.a.get("android:changeTransform:parentMatrix"));
    paramt2.postConcat(localMatrix2);
  }
  
  static void r0(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    x.L0(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  public String[] I()
  {
    return O;
  }
  
  public void j(t paramt)
  {
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    l0(paramt);
    if (!R) {
      ((ViewGroup)paramt.b.getParent()).startViewTransition(paramt.b);
    }
  }
  
  public Animator q(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    if ((paramt1 != null) && (paramt2 != null) && (paramt1.a.containsKey("android:changeTransform:parent")) && (paramt2.a.containsKey("android:changeTransform:parent")))
    {
      ViewGroup localViewGroup = (ViewGroup)paramt1.a.get("android:changeTransform:parent");
      Object localObject = (ViewGroup)paramt2.a.get("android:changeTransform:parent");
      boolean bool;
      if ((this.M) && (!o0(localViewGroup, (ViewGroup)localObject))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = (Matrix)paramt1.a.get("android:changeTransform:intermediateMatrix");
      if (localObject != null) {
        paramt1.a.put("android:changeTransform:matrix", localObject);
      }
      localObject = (Matrix)paramt1.a.get("android:changeTransform:intermediateParentMatrix");
      if (localObject != null) {
        paramt1.a.put("android:changeTransform:parentMatrix", localObject);
      }
      if (bool) {
        q0(paramt1, paramt2);
      }
      localObject = n0(paramt1, paramt2, bool);
      if ((bool) && (localObject != null) && (this.L))
      {
        m0(paramViewGroup, paramt1, paramt2);
        return localObject;
      }
      if (!R) {
        localViewGroup.endViewTransition(paramt1.b);
      }
      return localObject;
    }
    return null;
  }
  
  static final class a
    extends Property<ChangeTransform.e, float[]>
  {
    a(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public float[] a(ChangeTransform.e parame)
    {
      return null;
    }
    
    public void b(ChangeTransform.e parame, float[] paramArrayOfFloat)
    {
      parame.d(paramArrayOfFloat);
    }
  }
  
  static final class b
    extends Property<ChangeTransform.e, PointF>
  {
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(ChangeTransform.e parame)
    {
      return null;
    }
    
    public void b(ChangeTransform.e parame, PointF paramPointF)
    {
      parame.c(paramPointF);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    private boolean a;
    private Matrix b = new Matrix();
    
    c(boolean paramBoolean, Matrix paramMatrix, View paramView, ChangeTransform.f paramf, ChangeTransform.e parame) {}
    
    private void a(Matrix paramMatrix)
    {
      this.b.set(paramMatrix);
      paramt2.setTag(R.id.transition_transform, this.b);
      this.f.a(paramt2);
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.a) {
        if ((paramBoolean) && (ChangeTransform.this.L))
        {
          a(paramt1);
        }
        else
        {
          paramt2.setTag(R.id.transition_transform, null);
          paramt2.setTag(R.id.parent_matrix, null);
        }
      }
      b0.f(paramt2, null);
      this.f.a(paramt2);
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      a(this.g.a());
    }
    
    public void onAnimationResume(Animator paramAnimator)
    {
      ChangeTransform.p0(paramt2);
    }
  }
  
  private static class d
    extends q
  {
    private View a;
    private e b;
    
    d(View paramView, e parame)
    {
      this.a = paramView;
      this.b = parame;
    }
    
    public void c(Transition paramTransition)
    {
      this.b.setVisibility(4);
    }
    
    public void d(Transition paramTransition)
    {
      this.b.setVisibility(0);
    }
    
    public void e(Transition paramTransition)
    {
      paramTransition.W(this);
      i.b(this.a);
      this.a.setTag(R.id.transition_transform, null);
      this.a.setTag(R.id.parent_matrix, null);
    }
  }
  
  private static class e
  {
    private final Matrix a = new Matrix();
    private final View b;
    private final float[] c;
    private float d;
    private float e;
    
    e(View paramView, float[] paramArrayOfFloat)
    {
      this.b = paramView;
      paramView = (float[])paramArrayOfFloat.clone();
      this.c = paramView;
      this.d = paramView[2];
      this.e = paramView[5];
      b();
    }
    
    private void b()
    {
      float[] arrayOfFloat = this.c;
      arrayOfFloat[2] = this.d;
      arrayOfFloat[5] = this.e;
      this.a.setValues(arrayOfFloat);
      b0.f(this.b, this.a);
    }
    
    Matrix a()
    {
      return this.a;
    }
    
    void c(PointF paramPointF)
    {
      this.d = paramPointF.x;
      this.e = paramPointF.y;
      b();
    }
    
    void d(float[] paramArrayOfFloat)
    {
      System.arraycopy(paramArrayOfFloat, 0, this.c, 0, paramArrayOfFloat.length);
      b();
    }
  }
  
  private static class f
  {
    final float a;
    final float b;
    final float c;
    final float d;
    final float e;
    final float f;
    final float g;
    final float h;
    
    f(View paramView)
    {
      this.a = paramView.getTranslationX();
      this.b = paramView.getTranslationY();
      this.c = x.L(paramView);
      this.d = paramView.getScaleX();
      this.e = paramView.getScaleY();
      this.f = paramView.getRotationX();
      this.g = paramView.getRotationY();
      this.h = paramView.getRotation();
    }
    
    public void a(View paramView)
    {
      ChangeTransform.r0(paramView, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof f;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (f)paramObject;
      bool1 = bool2;
      if (paramObject.a == this.a)
      {
        bool1 = bool2;
        if (paramObject.b == this.b)
        {
          bool1 = bool2;
          if (paramObject.c == this.c)
          {
            bool1 = bool2;
            if (paramObject.d == this.d)
            {
              bool1 = bool2;
              if (paramObject.e == this.e)
              {
                bool1 = bool2;
                if (paramObject.f == this.f)
                {
                  bool1 = bool2;
                  if (paramObject.g == this.g)
                  {
                    bool1 = bool2;
                    if (paramObject.h == this.h) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      float f1 = this.a;
      int i3 = 0;
      int i;
      if (f1 != 0.0F) {
        i = Float.floatToIntBits(f1);
      } else {
        i = 0;
      }
      f1 = this.b;
      int j;
      if (f1 != 0.0F) {
        j = Float.floatToIntBits(f1);
      } else {
        j = 0;
      }
      f1 = this.c;
      int k;
      if (f1 != 0.0F) {
        k = Float.floatToIntBits(f1);
      } else {
        k = 0;
      }
      f1 = this.d;
      int m;
      if (f1 != 0.0F) {
        m = Float.floatToIntBits(f1);
      } else {
        m = 0;
      }
      f1 = this.e;
      int n;
      if (f1 != 0.0F) {
        n = Float.floatToIntBits(f1);
      } else {
        n = 0;
      }
      f1 = this.f;
      int i1;
      if (f1 != 0.0F) {
        i1 = Float.floatToIntBits(f1);
      } else {
        i1 = 0;
      }
      f1 = this.g;
      int i2;
      if (f1 != 0.0F) {
        i2 = Float.floatToIntBits(f1);
      } else {
        i2 = 0;
      }
      f1 = this.h;
      if (f1 != 0.0F) {
        i3 = Float.floatToIntBits(f1);
      }
      return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */