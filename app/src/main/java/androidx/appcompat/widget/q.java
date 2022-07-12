package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class q
{
  private static final RectF l = new RectF();
  @SuppressLint({"BanConcurrentHashMap"})
  private static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap();
  @SuppressLint({"BanConcurrentHashMap"})
  private static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap();
  private int a = 0;
  private boolean b = false;
  private float c = -1.0F;
  private float d = -1.0F;
  private float e = -1.0F;
  private int[] f = new int[0];
  private boolean g = false;
  private TextPaint h;
  private final TextView i;
  private final Context j;
  private final c k;
  
  q(TextView paramTextView)
  {
    this.i = paramTextView;
    this.j = paramTextView.getContext();
    if (Build.VERSION.SDK_INT >= 29) {}
    for (paramTextView = new b();; paramTextView = new a())
    {
      this.k = paramTextView;
      return;
    }
  }
  
  private void A(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          this.a = 1;
          this.d = paramFloat1;
          this.e = paramFloat2;
          this.c = paramFloat3;
          this.g = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private int[] b(int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    if (i3 == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      int i4 = paramArrayOfInt[i1];
      if ((i4 > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(i4)) < 0)) {
        localArrayList.add(Integer.valueOf(i4));
      }
      i1 += 1;
    }
    if (i3 == localArrayList.size()) {
      return paramArrayOfInt;
    }
    i3 = localArrayList.size();
    paramArrayOfInt = new int[i3];
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfInt[i1] = ((Integer)localArrayList.get(i1)).intValue();
      i1 += 1;
    }
    return paramArrayOfInt;
  }
  
  private void c()
  {
    this.a = 0;
    this.d = -1.0F;
    this.e = -1.0F;
    this.c = -1.0F;
    this.f = new int[0];
    this.b = false;
  }
  
  private StaticLayout e(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.h, paramInt1);
    paramAlignment = paramCharSequence.setAlignment(paramAlignment).setLineSpacing(this.i.getLineSpacingExtra(), this.i.getLineSpacingMultiplier()).setIncludePad(this.i.getIncludeFontPadding()).setBreakStrategy(this.i.getBreakStrategy()).setHyphenationFrequency(this.i.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    paramAlignment.setMaxLines(paramInt1);
    try
    {
      this.k.a(paramCharSequence, this.i);
    }
    catch (ClassCastException paramAlignment)
    {
      label103:
      break label103;
    }
    Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
    return paramCharSequence.build();
  }
  
  private int f(RectF paramRectF)
  {
    int i3 = this.f.length;
    if (i3 != 0)
    {
      int i2 = 0;
      int i1 = 1;
      i3 -= 1;
      while (i1 <= i3)
      {
        i2 = (i1 + i3) / 2;
        if (y(this.f[i2], paramRectF))
        {
          int i4 = i2 + 1;
          i2 = i1;
          i1 = i4;
        }
        else
        {
          i2 -= 1;
          i3 = i2;
        }
      }
      return this.f[i2];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  private static Method l(String paramString)
  {
    try
    {
      localObject2 = (Method)m.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Method)localObject2).setAccessible(true);
          m.put(paramString, localObject2);
          localObject1 = localObject2;
        }
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject2).toString(), localException);
    }
    return null;
  }
  
  /* Error */
  static <T> T n(Object paramObject, String paramString, T paramT)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 279	androidx/appcompat/widget/q:l	(Ljava/lang/String;)Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokevirtual 283	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: astore_0
    //   16: goto +47 -> 63
    //   19: astore_0
    //   20: new 96	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: ldc_w 285
    //   32: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc_w 273
    //   46: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 225
    //   52: aload_3
    //   53: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aload_0
    //   57: invokestatic 276	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   60: pop
    //   61: aload_2
    //   62: areturn
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramObject	Object
    //   0	65	1	paramString	String
    //   0	65	2	paramT	T
    //   27	26	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	13	15	finally
    //   20	61	15	finally
    //   0	13	19	java/lang/Exception
  }
  
  private void t(float paramFloat)
  {
    if (paramFloat != this.i.getPaint().getTextSize())
    {
      this.i.getPaint().setTextSize(paramFloat);
      boolean bool = this.i.isInLayout();
      if (this.i.getLayout() != null)
      {
        this.b = false;
        try
        {
          Method localMethod = l("nullLayouts");
          if (localMethod != null) {
            localMethod.invoke(this.i, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
        }
        if (!bool) {
          this.i.requestLayout();
        } else {
          this.i.forceLayout();
        }
        this.i.invalidate();
      }
    }
  }
  
  private boolean v()
  {
    boolean bool = z();
    int i1 = 0;
    if ((bool) && (this.a == 1))
    {
      if ((!this.g) || (this.f.length == 0))
      {
        int i2 = (int)Math.floor((this.e - this.d) / this.c) + 1;
        int[] arrayOfInt = new int[i2];
        while (i1 < i2)
        {
          arrayOfInt[i1] = Math.round(this.d + i1 * this.c);
          i1 += 1;
        }
        this.f = b(arrayOfInt);
      }
      this.b = true;
    }
    else
    {
      this.b = false;
    }
    return this.b;
  }
  
  private void w(TypedArray paramTypedArray)
  {
    int i2 = paramTypedArray.length();
    int[] arrayOfInt = new int[i2];
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfInt[i1] = paramTypedArray.getDimensionPixelSize(i1, -1);
        i1 += 1;
      }
      this.f = b(arrayOfInt);
      x();
    }
  }
  
  private boolean x()
  {
    int[] arrayOfInt = this.f;
    int i1 = arrayOfInt.length;
    boolean bool;
    if (i1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    if (bool)
    {
      this.a = 1;
      this.d = arrayOfInt[0];
      this.e = arrayOfInt[(i1 - 1)];
      this.c = -1.0F;
    }
    return bool;
  }
  
  private boolean y(int paramInt, RectF paramRectF)
  {
    Object localObject2 = this.i.getText();
    Object localObject3 = this.i.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.i);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i1 = this.i.getMaxLines();
    m(paramInt);
    localObject2 = d(localObject1, (Layout.Alignment)n(this.i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(paramRectF.right), i1);
    if ((i1 != -1) && ((((StaticLayout)localObject2).getLineCount() > i1) || (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) != localObject1.length()))) {
      return false;
    }
    return ((StaticLayout)localObject2).getHeight() <= paramRectF.bottom;
  }
  
  private boolean z()
  {
    return this.i instanceof AppCompatEditText ^ true;
  }
  
  void a()
  {
    if (!o()) {
      return;
    }
    if (this.b)
    {
      if (this.i.getMeasuredHeight() > 0)
      {
        if (this.i.getMeasuredWidth() <= 0) {
          return;
        }
        int i1;
        if (this.k.b(this.i)) {
          i1 = 1048576;
        } else {
          i1 = this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft() - this.i.getTotalPaddingRight();
        }
        int i2 = this.i.getHeight() - this.i.getCompoundPaddingBottom() - this.i.getCompoundPaddingTop();
        if (i1 > 0)
        {
          if (i2 <= 0) {
            return;
          }
          synchronized (l)
          {
            ???.setEmpty();
            ???.right = i1;
            ???.bottom = i2;
            float f1 = f(???);
            if (f1 != this.i.getTextSize()) {
              u(0, f1);
            }
          }
        }
      }
      return;
    }
    this.b = true;
  }
  
  StaticLayout d(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    return e(paramCharSequence, paramAlignment, paramInt1, paramInt2);
  }
  
  int g()
  {
    return Math.round(this.e);
  }
  
  int h()
  {
    return Math.round(this.d);
  }
  
  int i()
  {
    return Math.round(this.c);
  }
  
  int[] j()
  {
    return this.f;
  }
  
  int k()
  {
    return this.a;
  }
  
  void m(int paramInt)
  {
    TextPaint localTextPaint = this.h;
    if (localTextPaint == null) {
      this.h = new TextPaint();
    } else {
      localTextPaint.reset();
    }
    this.h.set(this.i.getPaint());
    this.h.setTextSize(paramInt);
  }
  
  boolean o()
  {
    return (z()) && (this.a != 0);
  }
  
  void p(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = this.j;
    int[] arrayOfInt = R.styleable.AppCompatTextView;
    localObject = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    TextView localTextView = this.i;
    x.o0(localTextView, localTextView.getContext(), arrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
    paramInt = R.styleable.AppCompatTextView_autoSizeTextType;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      this.a = ((TypedArray)localObject).getInt(paramInt, 0);
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeStepGranularity;
    float f1;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f1 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f1 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeMinTextSize;
    float f2;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f2 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f2 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
    float f3;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f3 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f3 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizePresetSizes;
    if (((TypedArray)localObject).hasValue(paramInt))
    {
      paramInt = ((TypedArray)localObject).getResourceId(paramInt, 0);
      if (paramInt > 0)
      {
        paramAttributeSet = ((TypedArray)localObject).getResources().obtainTypedArray(paramInt);
        w(paramAttributeSet);
        paramAttributeSet.recycle();
      }
    }
    ((TypedArray)localObject).recycle();
    if (z())
    {
      if (this.a == 1)
      {
        if (!this.g)
        {
          paramAttributeSet = this.j.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          A(f4, f2, f3);
        }
        v();
      }
    }
    else {
      this.a = 0;
    }
  }
  
  void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (z())
    {
      DisplayMetrics localDisplayMetrics = this.j.getResources().getDisplayMetrics();
      A(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (v()) {
        a();
      }
    }
  }
  
  void r(int[] paramArrayOfInt, int paramInt)
  {
    if (z())
    {
      int i2 = paramArrayOfInt.length;
      int i1 = 0;
      if (i2 > 0)
      {
        int[] arrayOfInt = new int[i2];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, i2);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.j.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (i1 >= i2) {
              break;
            }
            arrayOfInt[i1] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i1], localDisplayMetrics));
            i1 += 1;
          }
        }
        this.f = b((int[])localObject);
        if (!x())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.g = false;
      }
      if (v()) {
        a();
      }
    }
  }
  
  void s(int paramInt)
  {
    if (z()) {
      if (paramInt != 0)
      {
        Object localObject;
        if (paramInt == 1)
        {
          localObject = this.j.getResources().getDisplayMetrics();
          A(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
          if (v()) {
            a();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown auto-size text type: ");
          ((StringBuilder)localObject).append(paramInt);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        c();
      }
    }
  }
  
  void u(int paramInt, float paramFloat)
  {
    Object localObject = this.j;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    t(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
  
  private static class a
    extends q.c
  {
    void a(StaticLayout.Builder paramBuilder, TextView paramTextView)
    {
      paramBuilder.setTextDirection((TextDirectionHeuristic)q.n(paramTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
  }
  
  private static class b
    extends q.a
  {
    void a(StaticLayout.Builder paramBuilder, TextView paramTextView)
    {
      paramBuilder.setTextDirection(paramTextView.getTextDirectionHeuristic());
    }
    
    boolean b(TextView paramTextView)
    {
      return paramTextView.isHorizontallyScrollable();
    }
  }
  
  private static class c
  {
    void a(StaticLayout.Builder paramBuilder, TextView paramTextView)
    {
      throw null;
    }
    
    boolean b(TextView paramTextView)
    {
      return ((Boolean)q.n(paramTextView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.q
 * JD-Core Version:    0.7.0.1
 */