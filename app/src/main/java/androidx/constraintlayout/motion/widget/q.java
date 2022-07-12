package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.R.styleable;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;
import org.xmlpull.v1.XmlPullParser;

class q
{
  private static final float[][] G = { { 0.5F, 0.0F }, { 0.0F, 0.5F }, { 1.0F, 0.5F }, { 0.5F, 1.0F }, { 0.5F, 0.5F }, { 0.0F, 0.5F }, { 1.0F, 0.5F } };
  private static final float[][] H;
  private float A = 10.0F;
  private float B = 1.0F;
  private float C = (0.0F / 0.0F);
  private float D = (0.0F / 0.0F);
  private int E = 0;
  private int F = 0;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private float g = 0.5F;
  private float h = 0.5F;
  float i = 0.5F;
  float j = 0.5F;
  private int k = -1;
  boolean l = false;
  private float m = 0.0F;
  private float n = 1.0F;
  private boolean o = false;
  private float[] p = new float[2];
  private int[] q = new int[2];
  private float r;
  private float s;
  private final MotionLayout t;
  private float u = 4.0F;
  private float v = 1.2F;
  private boolean w = true;
  private float x = 1.0F;
  private int y = 0;
  private float z = 10.0F;
  
  static
  {
    float[] arrayOfFloat1 = { 0.0F, 1.0F };
    float[] arrayOfFloat2 = { -1.0F, 0.0F };
    float[] arrayOfFloat3 = { 1.0F, 0.0F };
    float[] arrayOfFloat4 = { -1.0F, 0.0F };
    float[] arrayOfFloat5 = { 1.0F, 0.0F };
    H = new float[][] { { 0.0F, -1.0F }, arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4, arrayOfFloat5 };
  }
  
  q(Context paramContext, MotionLayout paramMotionLayout, XmlPullParser paramXmlPullParser)
  {
    this.t = paramMotionLayout;
    c(paramContext, Xml.asAttributeSet(paramXmlPullParser));
  }
  
  private void b(TypedArray paramTypedArray)
  {
    int i2 = paramTypedArray.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramTypedArray.getIndex(i1);
      if (i3 == R.styleable.OnSwipe_touchAnchorId)
      {
        this.d = paramTypedArray.getResourceId(i3, this.d);
      }
      else
      {
        float[][] arrayOfFloat;
        if (i3 == R.styleable.OnSwipe_touchAnchorSide)
        {
          i3 = paramTypedArray.getInt(i3, this.a);
          this.a = i3;
          arrayOfFloat = G;
          this.h = arrayOfFloat[i3][0];
          this.g = arrayOfFloat[i3][1];
        }
        else if (i3 == R.styleable.OnSwipe_dragDirection)
        {
          i3 = paramTypedArray.getInt(i3, this.b);
          this.b = i3;
          arrayOfFloat = H;
          if (i3 < arrayOfFloat.length)
          {
            this.m = arrayOfFloat[i3][0];
            this.n = arrayOfFloat[i3][1];
          }
          else
          {
            this.n = (0.0F / 0.0F);
            this.m = (0.0F / 0.0F);
            this.l = true;
          }
        }
        else if (i3 == R.styleable.OnSwipe_maxVelocity)
        {
          this.u = paramTypedArray.getFloat(i3, this.u);
        }
        else if (i3 == R.styleable.OnSwipe_maxAcceleration)
        {
          this.v = paramTypedArray.getFloat(i3, this.v);
        }
        else if (i3 == R.styleable.OnSwipe_moveWhenScrollAtTop)
        {
          this.w = paramTypedArray.getBoolean(i3, this.w);
        }
        else if (i3 == R.styleable.OnSwipe_dragScale)
        {
          this.x = paramTypedArray.getFloat(i3, this.x);
        }
        else if (i3 == R.styleable.OnSwipe_dragThreshold)
        {
          this.z = paramTypedArray.getFloat(i3, this.z);
        }
        else if (i3 == R.styleable.OnSwipe_touchRegionId)
        {
          this.e = paramTypedArray.getResourceId(i3, this.e);
        }
        else if (i3 == R.styleable.OnSwipe_onTouchUp)
        {
          this.c = paramTypedArray.getInt(i3, this.c);
        }
        else if (i3 == R.styleable.OnSwipe_nestedScrollFlags)
        {
          this.y = paramTypedArray.getInteger(i3, 0);
        }
        else if (i3 == R.styleable.OnSwipe_limitBoundsTo)
        {
          this.f = paramTypedArray.getResourceId(i3, 0);
        }
        else if (i3 == R.styleable.OnSwipe_rotationCenterId)
        {
          this.k = paramTypedArray.getResourceId(i3, this.k);
        }
        else if (i3 == R.styleable.OnSwipe_springDamping)
        {
          this.A = paramTypedArray.getFloat(i3, this.A);
        }
        else if (i3 == R.styleable.OnSwipe_springMass)
        {
          this.B = paramTypedArray.getFloat(i3, this.B);
        }
        else if (i3 == R.styleable.OnSwipe_springStiffness)
        {
          this.C = paramTypedArray.getFloat(i3, this.C);
        }
        else if (i3 == R.styleable.OnSwipe_springStopThreshold)
        {
          this.D = paramTypedArray.getFloat(i3, this.D);
        }
        else if (i3 == R.styleable.OnSwipe_springBoundary)
        {
          this.E = paramTypedArray.getInt(i3, this.E);
        }
        else if (i3 == R.styleable.OnSwipe_autoCompleteMode)
        {
          this.F = paramTypedArray.getInt(i3, this.F);
        }
      }
      i1 += 1;
    }
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.OnSwipe);
    b(paramContext);
    paramContext.recycle();
  }
  
  void A()
  {
    int i1 = this.d;
    Object localObject;
    if (i1 != -1)
    {
      View localView = this.t.findViewById(i1);
      localObject = localView;
      if (localView == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cannot find TouchAnchorId @id/");
        ((StringBuilder)localObject).append(a.c(this.t.getContext(), this.d));
        Log.e("TouchResponse", ((StringBuilder)localObject).toString());
        localObject = localView;
      }
    }
    else
    {
      localObject = null;
    }
    if ((localObject instanceof NestedScrollView))
    {
      localObject = (NestedScrollView)localObject;
      ((FrameLayout)localObject).setOnTouchListener(new a());
      ((NestedScrollView)localObject).setOnScrollChangeListener(new b());
    }
  }
  
  float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * this.m + paramFloat2 * this.n;
  }
  
  public int d()
  {
    return this.F;
  }
  
  public int e()
  {
    return this.y;
  }
  
  RectF f(ViewGroup paramViewGroup, RectF paramRectF)
  {
    int i1 = this.f;
    if (i1 == -1) {
      return null;
    }
    paramViewGroup = paramViewGroup.findViewById(i1);
    if (paramViewGroup == null) {
      return null;
    }
    paramRectF.set(paramViewGroup.getLeft(), paramViewGroup.getTop(), paramViewGroup.getRight(), paramViewGroup.getBottom());
    return paramRectF;
  }
  
  float g()
  {
    return this.v;
  }
  
  public float h()
  {
    return this.u;
  }
  
  boolean i()
  {
    return this.w;
  }
  
  float j(float paramFloat1, float paramFloat2)
  {
    float f1 = this.t.getProgress();
    this.t.l0(this.d, f1, this.h, this.g, this.p);
    f1 = this.m;
    if (f1 != 0.0F)
    {
      arrayOfFloat = this.p;
      if (arrayOfFloat[0] == 0.0F) {
        arrayOfFloat[0] = 1.0E-007F;
      }
      return paramFloat1 * f1 / arrayOfFloat[0];
    }
    float[] arrayOfFloat = this.p;
    if (arrayOfFloat[1] == 0.0F) {
      arrayOfFloat[1] = 1.0E-007F;
    }
    return paramFloat2 * this.n / arrayOfFloat[1];
  }
  
  public int k()
  {
    return this.E;
  }
  
  public float l()
  {
    return this.A;
  }
  
  public float m()
  {
    return this.B;
  }
  
  public float n()
  {
    return this.C;
  }
  
  public float o()
  {
    return this.D;
  }
  
  RectF p(ViewGroup paramViewGroup, RectF paramRectF)
  {
    int i1 = this.e;
    if (i1 == -1) {
      return null;
    }
    paramViewGroup = paramViewGroup.findViewById(i1);
    if (paramViewGroup == null) {
      return null;
    }
    paramRectF.set(paramViewGroup.getLeft(), paramViewGroup.getTop(), paramViewGroup.getRight(), paramViewGroup.getBottom());
    return paramRectF;
  }
  
  int q()
  {
    return this.e;
  }
  
  boolean r()
  {
    return this.o;
  }
  
  void s(MotionEvent paramMotionEvent, MotionLayout.g paramg, int paramInt, p paramp)
  {
    if (this.l)
    {
      t(paramMotionEvent, paramg, paramInt, paramp);
      return;
    }
    paramg.b(paramMotionEvent);
    paramInt = paramMotionEvent.getAction();
    if (paramInt != 0)
    {
      float f1;
      float f3;
      float f2;
      float f4;
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        f1 = paramMotionEvent.getRawY() - this.s;
        f3 = paramMotionEvent.getRawX() - this.r;
        if ((Math.abs(this.m * f3 + this.n * f1) > this.z) || (this.o))
        {
          f2 = this.t.getProgress();
          if (!this.o)
          {
            this.o = true;
            this.t.setProgress(f2);
          }
          paramInt = this.d;
          if (paramInt != -1)
          {
            this.t.l0(paramInt, f2, this.h, this.g, this.p);
          }
          else
          {
            f4 = Math.min(this.t.getWidth(), this.t.getHeight());
            paramp = this.p;
            paramp[1] = (this.n * f4);
            paramp[0] = (f4 * this.m);
          }
          f4 = this.m;
          paramp = this.p;
          if (Math.abs((f4 * paramp[0] + this.n * paramp[1]) * this.x) < 0.01D)
          {
            paramp = this.p;
            paramp[0] = 0.01F;
            paramp[1] = 0.01F;
          }
          if (this.m != 0.0F) {
            f1 = f3 / this.p[0];
          } else {
            f1 /= this.p[1];
          }
          f2 = Math.max(Math.min(f2 + f1, 1.0F), 0.0F);
          f1 = f2;
          if (this.c == 6) {
            f1 = Math.max(f2, 0.01F);
          }
          f2 = f1;
          if (this.c == 7) {
            f2 = Math.min(f1, 0.99F);
          }
          f1 = this.t.getProgress();
          if (f2 != f1)
          {
            paramInt = f1 < 0.0F;
            if ((paramInt == 0) || (f1 == 1.0F))
            {
              paramp = this.t;
              boolean bool;
              if (paramInt == 0) {
                bool = true;
              } else {
                bool = false;
              }
              paramp.f0(bool);
            }
            this.t.setProgress(f2);
            paramg.e(1000);
            f1 = paramg.d();
            f2 = paramg.c();
            if (this.m != 0.0F) {
              f1 /= this.p[0];
            } else {
              f1 = f2 / this.p[1];
            }
            this.t.B = f1;
          }
          else
          {
            this.t.B = 0.0F;
          }
          this.r = paramMotionEvent.getRawX();
          this.s = paramMotionEvent.getRawY();
        }
      }
      else
      {
        this.o = false;
        paramg.e(1000);
        f1 = paramg.d();
        f2 = paramg.c();
        f4 = this.t.getProgress();
        paramInt = this.d;
        if (paramInt != -1)
        {
          this.t.l0(paramInt, f4, this.h, this.g, this.p);
        }
        else
        {
          f3 = Math.min(this.t.getWidth(), this.t.getHeight());
          paramMotionEvent = this.p;
          paramMotionEvent[1] = (this.n * f3);
          paramMotionEvent[0] = (f3 * this.m);
        }
        f3 = this.m;
        paramMotionEvent = this.p;
        float f5 = paramMotionEvent[0];
        f5 = paramMotionEvent[1];
        if (f3 != 0.0F) {
          f1 /= paramMotionEvent[0];
        } else {
          f1 = f2 / paramMotionEvent[1];
        }
        if (!Float.isNaN(f1)) {
          f2 = f1 / 3.0F + f4;
        } else {
          f2 = f4;
        }
        if ((f2 != 0.0F) && (f2 != 1.0F))
        {
          paramInt = this.c;
          if (paramInt != 3)
          {
            if (f2 < 0.5D) {
              f3 = 0.0F;
            } else {
              f3 = 1.0F;
            }
            f2 = f1;
            if (paramInt == 6)
            {
              f2 = f1;
              if (f4 + f1 < 0.0F) {
                f2 = Math.abs(f1);
              }
              f3 = 1.0F;
            }
            f1 = f2;
            if (this.c == 7)
            {
              f1 = f2;
              if (f4 + f2 > 1.0F) {
                f1 = -Math.abs(f2);
              }
              f3 = 0.0F;
            }
            this.t.C0(this.c, f3, f1);
            if (0.0F >= f4) {
              break label889;
            }
            if (1.0F > f4) {
              return;
            }
            break label889;
          }
        }
        if ((0.0F >= f2) || (1.0F <= f2)) {
          label889:
          this.t.setState(MotionLayout.k.d);
        }
      }
    }
    else
    {
      this.r = paramMotionEvent.getRawX();
      this.s = paramMotionEvent.getRawY();
      this.o = false;
    }
  }
  
  void t(MotionEvent paramMotionEvent, MotionLayout.g paramg, int paramInt, p paramp)
  {
    paramg.b(paramMotionEvent);
    paramInt = paramMotionEvent.getAction();
    boolean bool = false;
    if (paramInt != 0)
    {
      float f3;
      float f4;
      float f1;
      float f2;
      float f5;
      double d1;
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramMotionEvent.getRawY();
        paramMotionEvent.getRawX();
        f3 = this.t.getWidth() / 2.0F;
        f4 = this.t.getHeight() / 2.0F;
        paramInt = this.k;
        if (paramInt != -1)
        {
          paramp = this.t.findViewById(paramInt);
          this.t.getLocationOnScreen(this.q);
          f1 = this.q[0];
          f3 = (paramp.getLeft() + paramp.getRight()) / 2.0F;
          f2 = this.q[1];
          f2 = (paramp.getTop() + paramp.getBottom()) / 2.0F + f2;
          f1 += f3;
        }
        else
        {
          paramInt = this.d;
          f1 = f3;
          f2 = f4;
          if (paramInt != -1)
          {
            paramp = this.t.n0(paramInt);
            paramp = this.t.findViewById(paramp.h());
            if (paramp == null)
            {
              Log.e("TouchResponse", "could not find view to animate to");
              f1 = f3;
              f2 = f4;
            }
            else
            {
              this.t.getLocationOnScreen(this.q);
              f1 = this.q[0] + (paramp.getLeft() + paramp.getRight()) / 2.0F;
              f2 = this.q[1] + (paramp.getTop() + paramp.getBottom()) / 2.0F;
            }
          }
        }
        f5 = paramMotionEvent.getRawX();
        float f6 = paramMotionEvent.getRawY();
        d1 = Math.atan2(paramMotionEvent.getRawY() - f2, paramMotionEvent.getRawX() - f1);
        f4 = (float)((d1 - Math.atan2(this.s - f2, this.r - f1)) * 180.0D / 3.141592653589793D);
        if (f4 > 330.0F)
        {
          f3 = f4 - 360.0F;
        }
        else
        {
          f3 = f4;
          if (f4 < -330.0F) {
            f3 = f4 + 360.0F;
          }
        }
        if ((Math.abs(f3) > 0.01D) || (this.o))
        {
          f4 = this.t.getProgress();
          if (!this.o)
          {
            this.o = true;
            this.t.setProgress(f4);
          }
          paramInt = this.d;
          if (paramInt != -1)
          {
            this.t.l0(paramInt, f4, this.h, this.g, this.p);
            paramp = this.p;
            paramp[1] = ((float)Math.toDegrees(paramp[1]));
          }
          else
          {
            this.p[1] = 360.0F;
          }
          f3 = Math.max(Math.min(f4 + f3 * this.x / this.p[1], 1.0F), 0.0F);
          f4 = this.t.getProgress();
          if (f3 != f4)
          {
            paramInt = f4 < 0.0F;
            if ((paramInt == 0) || (f4 == 1.0F))
            {
              paramp = this.t;
              if (paramInt == 0) {
                bool = true;
              }
              paramp.f0(bool);
            }
            this.t.setProgress(f3);
            paramg.e(1000);
            f3 = paramg.d();
            double d2 = paramg.c();
            double d3 = f3;
            f1 = (float)(Math.hypot(d2, d3) * Math.sin(Math.atan2(d2, d3) - d1) / Math.hypot(f5 - f1, f6 - f2));
            this.t.B = ((float)Math.toDegrees(f1));
          }
          else
          {
            this.t.B = 0.0F;
          }
          this.r = paramMotionEvent.getRawX();
          this.s = paramMotionEvent.getRawY();
        }
      }
      else
      {
        this.o = false;
        paramg.e(16);
        f3 = paramg.d();
        f4 = paramg.c();
        f5 = this.t.getProgress();
        f1 = this.t.getWidth() / 2.0F;
        f2 = this.t.getHeight() / 2.0F;
        paramInt = this.k;
        if (paramInt != -1)
        {
          paramg = this.t.findViewById(paramInt);
          this.t.getLocationOnScreen(this.q);
          f1 = this.q[0] + (paramg.getLeft() + paramg.getRight()) / 2.0F;
        }
        for (paramInt = this.q[1];; paramInt = this.q[1])
        {
          f2 = paramInt + (paramg.getTop() + paramg.getBottom()) / 2.0F;
          break;
          paramInt = this.d;
          if (paramInt == -1) {
            break;
          }
          paramg = this.t.n0(paramInt);
          paramg = this.t.findViewById(paramg.h());
          this.t.getLocationOnScreen(this.q);
          f1 = this.q[0] + (paramg.getLeft() + paramg.getRight()) / 2.0F;
        }
        f1 = paramMotionEvent.getRawX() - f1;
        f2 = paramMotionEvent.getRawY() - f2;
        d1 = Math.toDegrees(Math.atan2(f2, f1));
        paramInt = this.d;
        if (paramInt != -1)
        {
          this.t.l0(paramInt, f5, this.h, this.g, this.p);
          paramMotionEvent = this.p;
          paramMotionEvent[1] = ((float)Math.toDegrees(paramMotionEvent[1]));
        }
        else
        {
          this.p[1] = 360.0F;
        }
        f2 = (float)(Math.toDegrees(Math.atan2(f4 + f2, f3 + f1)) - d1) * 62.5F;
        if (!Float.isNaN(f2)) {
          f1 = f2 * 3.0F * this.x / this.p[1] + f5;
        } else {
          f1 = f5;
        }
        if ((f1 != 0.0F) && (f1 != 1.0F))
        {
          paramInt = this.c;
          if (paramInt != 3)
          {
            f3 = f2 * this.x / this.p[1];
            if (f1 < 0.5D) {
              f2 = 0.0F;
            } else {
              f2 = 1.0F;
            }
            f1 = f3;
            if (paramInt == 6)
            {
              f1 = f3;
              if (f5 + f3 < 0.0F) {
                f1 = Math.abs(f3);
              }
              f2 = 1.0F;
            }
            f3 = f1;
            f4 = f2;
            if (this.c == 7)
            {
              f2 = f1;
              if (f5 + f1 > 1.0F) {
                f2 = -Math.abs(f1);
              }
              f4 = 0.0F;
              f3 = f2;
            }
            this.t.C0(this.c, f4, f3 * 3.0F);
            if (0.0F >= f5) {
              break label1269;
            }
            if (1.0F > f5) {
              return;
            }
            break label1269;
          }
        }
        if ((0.0F >= f1) || (1.0F <= f1)) {
          label1269:
          this.t.setState(MotionLayout.k.d);
        }
      }
    }
    else
    {
      this.r = paramMotionEvent.getRawX();
      this.s = paramMotionEvent.getRawY();
      this.o = false;
    }
  }
  
  public String toString()
  {
    if (Float.isNaN(this.m)) {
      return "rotation";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.n);
    return localStringBuilder.toString();
  }
  
  void u(float paramFloat1, float paramFloat2)
  {
    float f1 = this.t.getProgress();
    if (!this.o)
    {
      this.o = true;
      this.t.setProgress(f1);
    }
    this.t.l0(this.d, f1, this.h, this.g, this.p);
    float f2 = this.m;
    float[] arrayOfFloat = this.p;
    if (Math.abs(f2 * arrayOfFloat[0] + this.n * arrayOfFloat[1]) < 0.01D)
    {
      arrayOfFloat = this.p;
      arrayOfFloat[0] = 0.01F;
      arrayOfFloat[1] = 0.01F;
    }
    f2 = this.m;
    if (f2 != 0.0F) {
      paramFloat1 = paramFloat1 * f2 / this.p[0];
    } else {
      paramFloat1 = paramFloat2 * this.n / this.p[1];
    }
    paramFloat1 = Math.max(Math.min(f1 + paramFloat1, 1.0F), 0.0F);
    if (paramFloat1 != this.t.getProgress()) {
      this.t.setProgress(paramFloat1);
    }
  }
  
  void v(float paramFloat1, float paramFloat2)
  {
    int i2 = 0;
    this.o = false;
    float f1 = this.t.getProgress();
    this.t.l0(this.d, f1, this.h, this.g, this.p);
    float f3 = this.m;
    Object localObject = this.p;
    float f2 = localObject[0];
    float f4 = this.n;
    f2 = localObject[1];
    f2 = 0.0F;
    if (f3 != 0.0F) {
      paramFloat1 = paramFloat1 * f3 / localObject[0];
    } else {
      paramFloat1 = paramFloat2 * f4 / localObject[1];
    }
    paramFloat2 = f1;
    if (!Float.isNaN(paramFloat1)) {
      paramFloat2 = f1 + paramFloat1 / 3.0F;
    }
    if (paramFloat2 != 0.0F)
    {
      int i1;
      if (paramFloat2 != 1.0F) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i3 = this.c;
      if (i3 != 3) {
        i2 = 1;
      }
      if ((i2 & i1) != 0)
      {
        localObject = this.t;
        if (paramFloat2 < 0.5D) {
          paramFloat2 = f2;
        } else {
          paramFloat2 = 1.0F;
        }
        ((MotionLayout)localObject).C0(i3, paramFloat2, paramFloat1);
      }
    }
  }
  
  void w(float paramFloat1, float paramFloat2)
  {
    this.r = paramFloat1;
    this.s = paramFloat2;
  }
  
  public void x(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      arrayOfFloat = H;
      arrayOfFloat[4] = arrayOfFloat[3];
      arrayOfFloat[5] = arrayOfFloat[2];
      arrayOfFloat = G;
      arrayOfFloat[5] = arrayOfFloat[2];
      arrayOfFloat[6] = arrayOfFloat[1];
    }
    else
    {
      arrayOfFloat = H;
      arrayOfFloat[4] = arrayOfFloat[2];
      arrayOfFloat[5] = arrayOfFloat[3];
      arrayOfFloat = G;
      arrayOfFloat[5] = arrayOfFloat[1];
      arrayOfFloat[6] = arrayOfFloat[2];
    }
    float[][] arrayOfFloat = G;
    int i1 = this.a;
    this.h = arrayOfFloat[i1][0];
    this.g = arrayOfFloat[i1][1];
    i1 = this.b;
    arrayOfFloat = H;
    if (i1 >= arrayOfFloat.length) {
      return;
    }
    this.m = arrayOfFloat[i1][0];
    this.n = arrayOfFloat[i1][1];
  }
  
  public void y(int paramInt)
  {
    this.c = paramInt;
  }
  
  void z(float paramFloat1, float paramFloat2)
  {
    this.r = paramFloat1;
    this.s = paramFloat2;
    this.o = false;
  }
  
  class a
    implements View.OnTouchListener
  {
    a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  class b
    implements NestedScrollView.b
  {
    b() {}
    
    public void a(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.q
 * JD-Core Version:    0.7.0.1
 */