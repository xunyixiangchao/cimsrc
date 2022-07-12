package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import k0.e;
import k0.j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c
{
  private static final int[] h = { 0, 4, 8 };
  private static SparseIntArray i = new SparseIntArray();
  private static SparseIntArray j = new SparseIntArray();
  private boolean a;
  public String b;
  public String c = "";
  public int d = 0;
  private HashMap<String, a> e = new HashMap();
  private boolean f = true;
  private HashMap<Integer, a> g = new HashMap();
  
  static
  {
    i.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
    i.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
    i.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
    i.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
    i.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
    i.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
    i.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
    i.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
    i.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
    i.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
    i.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
    i.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
    i.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
    i.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
    i.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
    i.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
    i.append(R.styleable.Constraint_guidelineUseRtl, 99);
    i.append(R.styleable.Constraint_android_orientation, 27);
    i.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
    i.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
    i.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
    i.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
    i.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
    i.append(R.styleable.Constraint_layout_goneMarginTop, 16);
    i.append(R.styleable.Constraint_layout_goneMarginRight, 14);
    i.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
    i.append(R.styleable.Constraint_layout_goneMarginStart, 15);
    i.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
    i.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
    i.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
    i.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
    i.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
    i.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
    i.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
    i.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
    i.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
    i.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
    i.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
    i.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
    i.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
    i.append(R.styleable.Constraint_android_layout_marginLeft, 24);
    i.append(R.styleable.Constraint_android_layout_marginRight, 28);
    i.append(R.styleable.Constraint_android_layout_marginStart, 31);
    i.append(R.styleable.Constraint_android_layout_marginEnd, 8);
    i.append(R.styleable.Constraint_android_layout_marginTop, 34);
    i.append(R.styleable.Constraint_android_layout_marginBottom, 2);
    i.append(R.styleable.Constraint_android_layout_width, 23);
    i.append(R.styleable.Constraint_android_layout_height, 21);
    i.append(R.styleable.Constraint_layout_constraintWidth, 95);
    i.append(R.styleable.Constraint_layout_constraintHeight, 96);
    i.append(R.styleable.Constraint_android_visibility, 22);
    i.append(R.styleable.Constraint_android_alpha, 43);
    i.append(R.styleable.Constraint_android_elevation, 44);
    i.append(R.styleable.Constraint_android_rotationX, 45);
    i.append(R.styleable.Constraint_android_rotationY, 46);
    i.append(R.styleable.Constraint_android_rotation, 60);
    i.append(R.styleable.Constraint_android_scaleX, 47);
    i.append(R.styleable.Constraint_android_scaleY, 48);
    i.append(R.styleable.Constraint_android_transformPivotX, 49);
    i.append(R.styleable.Constraint_android_transformPivotY, 50);
    i.append(R.styleable.Constraint_android_translationX, 51);
    i.append(R.styleable.Constraint_android_translationY, 52);
    i.append(R.styleable.Constraint_android_translationZ, 53);
    i.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
    i.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
    i.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
    i.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
    i.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
    i.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
    i.append(R.styleable.Constraint_layout_constraintCircle, 61);
    i.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
    i.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
    i.append(R.styleable.Constraint_animateRelativeTo, 64);
    i.append(R.styleable.Constraint_transitionEasing, 65);
    i.append(R.styleable.Constraint_drawPath, 66);
    i.append(R.styleable.Constraint_transitionPathRotate, 67);
    i.append(R.styleable.Constraint_motionStagger, 79);
    i.append(R.styleable.Constraint_android_id, 38);
    i.append(R.styleable.Constraint_motionProgress, 68);
    i.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
    i.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
    i.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
    i.append(R.styleable.Constraint_chainUseRtl, 71);
    i.append(R.styleable.Constraint_barrierDirection, 72);
    i.append(R.styleable.Constraint_barrierMargin, 73);
    i.append(R.styleable.Constraint_constraint_referenced_ids, 74);
    i.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
    i.append(R.styleable.Constraint_pathMotionArc, 76);
    i.append(R.styleable.Constraint_layout_constraintTag, 77);
    i.append(R.styleable.Constraint_visibilityMode, 78);
    i.append(R.styleable.Constraint_layout_constrainedWidth, 80);
    i.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    i.append(R.styleable.Constraint_polarRelativeTo, 82);
    i.append(R.styleable.Constraint_transformPivotTarget, 83);
    i.append(R.styleable.Constraint_quantizeMotionSteps, 84);
    i.append(R.styleable.Constraint_quantizeMotionPhase, 85);
    i.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
    SparseIntArray localSparseIntArray = j;
    int k = R.styleable.ConstraintOverride_layout_editor_absoluteY;
    localSparseIntArray.append(k, 6);
    j.append(k, 7);
    j.append(R.styleable.ConstraintOverride_android_orientation, 27);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
    j.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
    j.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
    j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
    j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
    j.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
    j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
    j.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
    j.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
    j.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
    j.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
    j.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
    j.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
    j.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
    j.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
    j.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
    j.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
    j.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
    j.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
    j.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
    j.append(R.styleable.ConstraintOverride_android_layout_width, 23);
    j.append(R.styleable.ConstraintOverride_android_layout_height, 21);
    j.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
    j.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
    j.append(R.styleable.ConstraintOverride_android_visibility, 22);
    j.append(R.styleable.ConstraintOverride_android_alpha, 43);
    j.append(R.styleable.ConstraintOverride_android_elevation, 44);
    j.append(R.styleable.ConstraintOverride_android_rotationX, 45);
    j.append(R.styleable.ConstraintOverride_android_rotationY, 46);
    j.append(R.styleable.ConstraintOverride_android_rotation, 60);
    j.append(R.styleable.ConstraintOverride_android_scaleX, 47);
    j.append(R.styleable.ConstraintOverride_android_scaleY, 48);
    j.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
    j.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
    j.append(R.styleable.ConstraintOverride_android_translationX, 51);
    j.append(R.styleable.ConstraintOverride_android_translationY, 52);
    j.append(R.styleable.ConstraintOverride_android_translationZ, 53);
    j.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
    j.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
    j.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
    j.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
    j.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
    j.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
    j.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
    j.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
    j.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
    j.append(R.styleable.ConstraintOverride_transitionEasing, 65);
    j.append(R.styleable.ConstraintOverride_drawPath, 66);
    j.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
    j.append(R.styleable.ConstraintOverride_motionStagger, 79);
    j.append(R.styleable.ConstraintOverride_android_id, 38);
    j.append(R.styleable.ConstraintOverride_motionTarget, 98);
    j.append(R.styleable.ConstraintOverride_motionProgress, 68);
    j.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
    j.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
    j.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
    j.append(R.styleable.ConstraintOverride_barrierDirection, 72);
    j.append(R.styleable.ConstraintOverride_barrierMargin, 73);
    j.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
    j.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
    j.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
    j.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
    j.append(R.styleable.ConstraintOverride_visibilityMode, 78);
    j.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
    j.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
    j.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
    j.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
    j.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
    j.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
    j.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
    j.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
  }
  
  private static int F(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int k = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = k;
    if (k == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  static void G(Object paramObject, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    if (paramObject == null) {
      return;
    }
    int m = paramTypedArray.peekValue(paramInt1).type;
    if (m != 3)
    {
      int k = -2;
      boolean bool = false;
      if (m != 5)
      {
        paramInt1 = paramTypedArray.getInt(paramInt1, 0);
        if (paramInt1 != -4)
        {
          if ((paramInt1 == -3) || ((paramInt1 != -2) && (paramInt1 != -1))) {
            paramInt1 = 0;
          }
        }
        else
        {
          bool = true;
          paramInt1 = k;
        }
      }
      else
      {
        paramInt1 = paramTypedArray.getDimensionPixelSize(paramInt1, 0);
      }
      if ((paramObject instanceof ConstraintLayout.LayoutParams))
      {
        paramObject = (ConstraintLayout.LayoutParams)paramObject;
        if (paramInt2 == 0)
        {
          paramObject.width = paramInt1;
          paramObject.a0 = bool;
          return;
        }
        paramObject.height = paramInt1;
        paramObject.b0 = bool;
        return;
      }
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (paramInt2 == 0)
        {
          paramObject.d = paramInt1;
          paramObject.n0 = bool;
          return;
        }
        paramObject.e = paramInt1;
        paramObject.o0 = bool;
        return;
      }
      if ((paramObject instanceof c.a.a))
      {
        paramObject = (c.a.a)paramObject;
        if (paramInt2 == 0)
        {
          paramObject.b(23, paramInt1);
          paramInt1 = 80;
        }
        else
        {
          paramObject.b(21, paramInt1);
          paramInt1 = 81;
        }
        paramObject.d(paramInt1, bool);
      }
      return;
    }
    H(paramObject, paramTypedArray.getString(paramInt1), paramInt2);
  }
  
  static void H(Object paramObject, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    int k = paramString.indexOf('=');
    int m = paramString.length();
    String str;
    if ((k > 0) && (k < m - 1))
    {
      str = paramString.substring(0, k);
      paramString = paramString.substring(k + 1);
      if (paramString.length() > 0)
      {
        str = str.trim();
        paramString = paramString.trim();
        if ("ratio".equalsIgnoreCase(str))
        {
          if ((paramObject instanceof ConstraintLayout.LayoutParams))
          {
            paramObject = (ConstraintLayout.LayoutParams)paramObject;
            if (paramInt == 0) {
              paramObject.width = 0;
            } else {
              paramObject.height = 0;
            }
            I(paramObject, paramString);
            return;
          }
          if ((paramObject instanceof b))
          {
            ((b)paramObject).A = paramString;
            return;
          }
          if ((paramObject instanceof c.a.a)) {
            ((c.a.a)paramObject).c(5, paramString);
          }
        }
        else if (!"weight".equalsIgnoreCase(str)) {}
      }
    }
    try
    {
      float f1 = Float.parseFloat(paramString);
      if ((paramObject instanceof ConstraintLayout.LayoutParams))
      {
        paramObject = (ConstraintLayout.LayoutParams)paramObject;
        if (paramInt == 0)
        {
          paramObject.width = 0;
          paramObject.L = f1;
          return;
        }
        paramObject.height = 0;
        paramObject.M = f1;
        return;
      }
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (paramInt == 0)
        {
          paramObject.d = 0;
          paramObject.W = f1;
          return;
        }
        paramObject.e = 0;
        paramObject.V = f1;
        return;
      }
      if ((paramObject instanceof c.a.a))
      {
        paramObject = (c.a.a)paramObject;
        if (paramInt == 0) {
          paramObject.b(23, 0);
        }
        for (paramInt = 39;; paramInt = 40)
        {
          paramObject.a(paramInt, f1);
          return;
          paramObject.b(21, 0);
        }
        if ("parent".equalsIgnoreCase(str))
        {
          f1 = Math.max(0.0F, Math.min(1.0F, Float.parseFloat(paramString)));
          if ((paramObject instanceof ConstraintLayout.LayoutParams))
          {
            paramObject = (ConstraintLayout.LayoutParams)paramObject;
            if (paramInt == 0)
            {
              paramObject.width = 0;
              paramObject.V = f1;
              paramObject.P = 2;
              return;
            }
            paramObject.height = 0;
            paramObject.W = f1;
            paramObject.Q = 2;
            return;
          }
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (paramInt == 0)
            {
              paramObject.d = 0;
              paramObject.f0 = f1;
              paramObject.Z = 2;
              return;
            }
            paramObject.e = 0;
            paramObject.g0 = f1;
            paramObject.a0 = 2;
            return;
          }
          if ((paramObject instanceof c.a.a))
          {
            paramObject = (c.a.a)paramObject;
            if (paramInt == 0) {
              paramObject.b(23, 0);
            }
            for (paramInt = 54;; paramInt = 55)
            {
              paramObject.b(paramInt, 2);
              return;
              paramObject.b(21, 0);
            }
          }
        }
      }
      return;
    }
    catch (NumberFormatException paramObject) {}
  }
  
  static void I(ConstraintLayout.LayoutParams paramLayoutParams, String paramString)
  {
    f2 = (0.0F / 0.0F);
    int m = -1;
    f1 = f2;
    n = m;
    String str2;
    if (paramString != null)
    {
      int i2 = paramString.length();
      int i3 = paramString.indexOf(',');
      int i1 = 0;
      k = m;
      n = i1;
      if (i3 > 0)
      {
        k = m;
        n = i1;
        if (i3 < i2 - 1)
        {
          str1 = paramString.substring(0, i3);
          if (str1.equalsIgnoreCase("W"))
          {
            k = 0;
          }
          else
          {
            k = m;
            if (str1.equalsIgnoreCase("H")) {
              k = 1;
            }
          }
          n = i3 + 1;
        }
      }
      m = paramString.indexOf(':');
      if ((m >= 0) && (m < i2 - 1))
      {
        str1 = paramString.substring(n, m);
        str2 = paramString.substring(m + 1);
        f1 = f2;
        n = k;
        if (str1.length() <= 0) {
          break label294;
        }
        f1 = f2;
        n = k;
        if (str2.length() <= 0) {
          break label294;
        }
      }
    }
    try
    {
      float f3 = Float.parseFloat(str1);
      float f4 = Float.parseFloat(str2);
      f1 = f2;
      n = k;
      if (f3 <= 0.0F) {
        break label294;
      }
      f1 = f2;
      n = k;
      if (f4 <= 0.0F) {
        break label294;
      }
      if (k == 1)
      {
        f1 = Math.abs(f4 / f3);
        n = k;
      }
      else
      {
        f1 = Math.abs(f3 / f4);
        n = k;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        f1 = f2;
        n = k;
      }
    }
    String str1 = paramString.substring(n);
    f1 = f2;
    n = k;
    if (str1.length() > 0)
    {
      f1 = Float.parseFloat(str1);
      n = k;
    }
    label294:
    paramLayoutParams.I = paramString;
    paramLayoutParams.J = f1;
    paramLayoutParams.K = n;
  }
  
  private void J(Context paramContext, a parama, TypedArray paramTypedArray, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      K(paramContext, parama, paramTypedArray);
      return;
    }
    int m = paramTypedArray.getIndexCount();
    int k = 0;
    while (k < m)
    {
      int n = paramTypedArray.getIndex(k);
      if ((n != R.styleable.Constraint_android_id) && (R.styleable.Constraint_android_layout_marginStart != n) && (R.styleable.Constraint_android_layout_marginEnd != n))
      {
        parama.d.a = true;
        parama.e.b = true;
        parama.c.a = true;
        parama.f.a = true;
      }
      Object localObject;
      switch (i.get(n))
      {
      case 88: 
      case 89: 
      case 90: 
      default: 
        paramContext = new StringBuilder();
        localObject = "Unknown attribute 0x";
        break;
      case 97: 
        paramContext = parama.e;
        paramContext.q0 = paramTypedArray.getInt(n, paramContext.q0);
        break;
      case 96: 
        G(parama.e, paramTypedArray, n, 1);
        break;
      case 95: 
        G(parama.e, paramTypedArray, n, 0);
        break;
      case 94: 
        paramContext = parama.e;
        paramContext.U = paramTypedArray.getDimensionPixelSize(n, paramContext.U);
        break;
      case 93: 
        paramContext = parama.e;
        paramContext.N = paramTypedArray.getDimensionPixelSize(n, paramContext.N);
        break;
      case 92: 
        paramContext = parama.e;
        paramContext.t = F(paramTypedArray, n, paramContext.t);
        break;
      case 91: 
        paramContext = parama.e;
        paramContext.s = F(paramTypedArray, n, paramContext.s);
        break;
      case 87: 
        paramContext = new StringBuilder();
        localObject = "unused attribute 0x";
        paramContext.append((String)localObject);
        paramContext.append(Integer.toHexString(n));
        paramContext.append("   ");
        paramContext.append(i.get(n));
        Log.w("ConstraintSet", paramContext.toString());
        break;
      case 86: 
        int i1 = paramTypedArray.peekValue(n).type;
        if (i1 == 1)
        {
          parama.d.n = paramTypedArray.getResourceId(n, -1);
          paramContext = parama.d;
          if (paramContext.n == -1) {}
        }
        else
        {
          for (;;)
          {
            paramContext.m = -2;
            break label2742;
            if (i1 != 3) {
              break label844;
            }
            parama.d.l = paramTypedArray.getString(n);
            if (parama.d.l.indexOf("/") <= 0) {
              break;
            }
            parama.d.n = paramTypedArray.getResourceId(n, -1);
            paramContext = parama.d;
          }
          parama.d.m = -1;
          break label2742;
          paramContext = parama.d;
          paramContext.m = paramTypedArray.getInteger(n, paramContext.n);
        }
        break;
      case 85: 
        paramContext = parama.d;
        paramContext.j = paramTypedArray.getFloat(n, paramContext.j);
        break;
      case 84: 
        paramContext = parama.d;
        paramContext.k = paramTypedArray.getInteger(n, paramContext.k);
        break;
      case 83: 
        paramContext = parama.f;
        paramContext.i = F(paramTypedArray, n, paramContext.i);
        break;
      case 82: 
        paramContext = parama.d;
        paramContext.c = paramTypedArray.getInteger(n, paramContext.c);
        break;
      case 81: 
        paramContext = parama.e;
        paramContext.o0 = paramTypedArray.getBoolean(n, paramContext.o0);
        break;
      case 80: 
        paramContext = parama.e;
        paramContext.n0 = paramTypedArray.getBoolean(n, paramContext.n0);
        break;
      case 79: 
        paramContext = parama.d;
        paramContext.g = paramTypedArray.getFloat(n, paramContext.g);
        break;
      case 78: 
        paramContext = parama.c;
        paramContext.c = paramTypedArray.getInt(n, paramContext.c);
        break;
      case 77: 
        parama.e.m0 = paramTypedArray.getString(n);
        break;
      case 76: 
        paramContext = parama.d;
        paramContext.e = paramTypedArray.getInt(n, paramContext.e);
        break;
      case 75: 
        paramContext = parama.e;
        paramContext.p0 = paramTypedArray.getBoolean(n, paramContext.p0);
        break;
      case 74: 
        parama.e.l0 = paramTypedArray.getString(n);
        break;
      case 73: 
        paramContext = parama.e;
        paramContext.i0 = paramTypedArray.getDimensionPixelSize(n, paramContext.i0);
        break;
      case 72: 
        paramContext = parama.e;
        paramContext.h0 = paramTypedArray.getInt(n, paramContext.h0);
        break;
      case 71: 
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        break;
      case 70: 
        parama.e.g0 = paramTypedArray.getFloat(n, 1.0F);
        break;
      case 69: 
        parama.e.f0 = paramTypedArray.getFloat(n, 1.0F);
        break;
      case 68: 
        paramContext = parama.c;
        paramContext.e = paramTypedArray.getFloat(n, paramContext.e);
        break;
      case 67: 
        paramContext = parama.d;
        paramContext.i = paramTypedArray.getFloat(n, paramContext.i);
        break;
      case 66: 
        parama.d.f = paramTypedArray.getInt(n, 0);
        break;
      case 65: 
        if (paramTypedArray.peekValue(n).type == 3)
        {
          localObject = parama.d;
          paramContext = paramTypedArray.getString(n);
        }
        else
        {
          localObject = parama.d;
          paramContext = i0.c.c[paramTypedArray.getInteger(n, 0)];
        }
        ((c)localObject).d = paramContext;
        break;
      case 64: 
        paramContext = parama.d;
        paramContext.b = F(paramTypedArray, n, paramContext.b);
        break;
      case 63: 
        paramContext = parama.e;
        paramContext.D = paramTypedArray.getFloat(n, paramContext.D);
        break;
      case 62: 
        paramContext = parama.e;
        paramContext.C = paramTypedArray.getDimensionPixelSize(n, paramContext.C);
        break;
      case 61: 
        paramContext = parama.e;
        paramContext.B = F(paramTypedArray, n, paramContext.B);
        break;
      case 60: 
        paramContext = parama.f;
        paramContext.b = paramTypedArray.getFloat(n, paramContext.b);
        break;
      case 59: 
        paramContext = parama.e;
        paramContext.e0 = paramTypedArray.getDimensionPixelSize(n, paramContext.e0);
        break;
      case 58: 
        paramContext = parama.e;
        paramContext.d0 = paramTypedArray.getDimensionPixelSize(n, paramContext.d0);
        break;
      case 57: 
        paramContext = parama.e;
        paramContext.c0 = paramTypedArray.getDimensionPixelSize(n, paramContext.c0);
        break;
      case 56: 
        paramContext = parama.e;
        paramContext.b0 = paramTypedArray.getDimensionPixelSize(n, paramContext.b0);
        break;
      case 55: 
        paramContext = parama.e;
        paramContext.a0 = paramTypedArray.getInt(n, paramContext.a0);
        break;
      case 54: 
        paramContext = parama.e;
        paramContext.Z = paramTypedArray.getInt(n, paramContext.Z);
        break;
      case 53: 
        paramContext = parama.f;
        paramContext.l = paramTypedArray.getDimension(n, paramContext.l);
        break;
      case 52: 
        paramContext = parama.f;
        paramContext.k = paramTypedArray.getDimension(n, paramContext.k);
        break;
      case 51: 
        paramContext = parama.f;
        paramContext.j = paramTypedArray.getDimension(n, paramContext.j);
        break;
      case 50: 
        paramContext = parama.f;
        paramContext.h = paramTypedArray.getDimension(n, paramContext.h);
        break;
      case 49: 
        paramContext = parama.f;
        paramContext.g = paramTypedArray.getDimension(n, paramContext.g);
        break;
      case 48: 
        paramContext = parama.f;
        paramContext.f = paramTypedArray.getFloat(n, paramContext.f);
        break;
      case 47: 
        paramContext = parama.f;
        paramContext.e = paramTypedArray.getFloat(n, paramContext.e);
        break;
      case 46: 
        paramContext = parama.f;
        paramContext.d = paramTypedArray.getFloat(n, paramContext.d);
        break;
      case 45: 
        paramContext = parama.f;
        paramContext.c = paramTypedArray.getFloat(n, paramContext.c);
        break;
      case 44: 
        paramContext = parama.f;
        paramContext.m = true;
        paramContext.n = paramTypedArray.getDimension(n, paramContext.n);
        break;
      case 43: 
        paramContext = parama.c;
        paramContext.d = paramTypedArray.getFloat(n, paramContext.d);
        break;
      case 42: 
        paramContext = parama.e;
        paramContext.Y = paramTypedArray.getInt(n, paramContext.Y);
        break;
      case 41: 
        paramContext = parama.e;
        paramContext.X = paramTypedArray.getInt(n, paramContext.X);
        break;
      case 40: 
        paramContext = parama.e;
        paramContext.V = paramTypedArray.getFloat(n, paramContext.V);
        break;
      case 39: 
        paramContext = parama.e;
        paramContext.W = paramTypedArray.getFloat(n, paramContext.W);
        break;
      case 38: 
        parama.a = paramTypedArray.getResourceId(n, parama.a);
        break;
      case 37: 
        paramContext = parama.e;
        paramContext.z = paramTypedArray.getFloat(n, paramContext.z);
        break;
      case 36: 
        paramContext = parama.e;
        paramContext.n = F(paramTypedArray, n, paramContext.n);
        break;
      case 35: 
        paramContext = parama.e;
        paramContext.o = F(paramTypedArray, n, paramContext.o);
        break;
      case 34: 
        paramContext = parama.e;
        paramContext.J = paramTypedArray.getDimensionPixelSize(n, paramContext.J);
        break;
      case 33: 
        paramContext = parama.e;
        paramContext.v = F(paramTypedArray, n, paramContext.v);
        break;
      case 32: 
        paramContext = parama.e;
        paramContext.u = F(paramTypedArray, n, paramContext.u);
        break;
      case 31: 
        paramContext = parama.e;
        paramContext.M = paramTypedArray.getDimensionPixelSize(n, paramContext.M);
        break;
      case 30: 
        paramContext = parama.e;
        paramContext.m = F(paramTypedArray, n, paramContext.m);
        break;
      case 29: 
        paramContext = parama.e;
        paramContext.l = F(paramTypedArray, n, paramContext.l);
        break;
      case 28: 
        paramContext = parama.e;
        paramContext.I = paramTypedArray.getDimensionPixelSize(n, paramContext.I);
        break;
      case 27: 
        paramContext = parama.e;
        paramContext.G = paramTypedArray.getInt(n, paramContext.G);
        break;
      case 26: 
        paramContext = parama.e;
        paramContext.k = F(paramTypedArray, n, paramContext.k);
        break;
      case 25: 
        paramContext = parama.e;
        paramContext.j = F(paramTypedArray, n, paramContext.j);
        break;
      case 24: 
        paramContext = parama.e;
        paramContext.H = paramTypedArray.getDimensionPixelSize(n, paramContext.H);
        break;
      case 23: 
        paramContext = parama.e;
        paramContext.d = paramTypedArray.getLayoutDimension(n, paramContext.d);
        break;
      case 22: 
        paramContext = parama.c;
        paramContext.b = paramTypedArray.getInt(n, paramContext.b);
        paramContext = parama.c;
        paramContext.b = h[paramContext.b];
        break;
      case 21: 
        paramContext = parama.e;
        paramContext.e = paramTypedArray.getLayoutDimension(n, paramContext.e);
        break;
      case 20: 
        paramContext = parama.e;
        paramContext.y = paramTypedArray.getFloat(n, paramContext.y);
        break;
      case 19: 
        paramContext = parama.e;
        paramContext.h = paramTypedArray.getFloat(n, paramContext.h);
        break;
      case 18: 
        paramContext = parama.e;
        paramContext.g = paramTypedArray.getDimensionPixelOffset(n, paramContext.g);
        break;
      case 17: 
        paramContext = parama.e;
        paramContext.f = paramTypedArray.getDimensionPixelOffset(n, paramContext.f);
        break;
      case 16: 
        paramContext = parama.e;
        paramContext.P = paramTypedArray.getDimensionPixelSize(n, paramContext.P);
        break;
      case 15: 
        paramContext = parama.e;
        paramContext.T = paramTypedArray.getDimensionPixelSize(n, paramContext.T);
        break;
      case 14: 
        paramContext = parama.e;
        paramContext.Q = paramTypedArray.getDimensionPixelSize(n, paramContext.Q);
        break;
      case 13: 
        paramContext = parama.e;
        paramContext.O = paramTypedArray.getDimensionPixelSize(n, paramContext.O);
        break;
      case 12: 
        paramContext = parama.e;
        paramContext.S = paramTypedArray.getDimensionPixelSize(n, paramContext.S);
        break;
      case 11: 
        paramContext = parama.e;
        paramContext.R = paramTypedArray.getDimensionPixelSize(n, paramContext.R);
        break;
      case 10: 
        paramContext = parama.e;
        paramContext.w = F(paramTypedArray, n, paramContext.w);
        break;
      case 9: 
        paramContext = parama.e;
        paramContext.x = F(paramTypedArray, n, paramContext.x);
        break;
      case 8: 
        paramContext = parama.e;
        paramContext.L = paramTypedArray.getDimensionPixelSize(n, paramContext.L);
        break;
      case 7: 
        paramContext = parama.e;
        paramContext.F = paramTypedArray.getDimensionPixelOffset(n, paramContext.F);
        break;
      case 6: 
        paramContext = parama.e;
        paramContext.E = paramTypedArray.getDimensionPixelOffset(n, paramContext.E);
        break;
      case 5: 
        parama.e.A = paramTypedArray.getString(n);
        break;
      case 4: 
        paramContext = parama.e;
        paramContext.p = F(paramTypedArray, n, paramContext.p);
        break;
      case 3: 
        paramContext = parama.e;
        paramContext.q = F(paramTypedArray, n, paramContext.q);
        break;
      case 2: 
        label844:
        paramContext = parama.e;
        paramContext.K = paramTypedArray.getDimensionPixelSize(n, paramContext.K);
        break;
      }
      paramContext = parama.e;
      paramContext.r = F(paramTypedArray, n, paramContext.r);
      label2742:
      k += 1;
    }
    paramContext = parama.e;
    if (paramContext.l0 != null) {
      paramContext.k0 = null;
    }
  }
  
  private static void K(Context paramContext, a parama, TypedArray paramTypedArray)
  {
    int i1 = paramTypedArray.getIndexCount();
    c.a.a locala = new c.a.a();
    parama.h = locala;
    parama.d.a = false;
    parama.e.b = false;
    parama.c.a = false;
    parama.f.a = false;
    int n = 0;
    while (n < i1)
    {
      int i2 = paramTypedArray.getIndex(n);
      int k = j.get(i2);
      float f1 = 1.0F;
      boolean bool;
      switch (k)
      {
      case 3: 
      case 4: 
      case 9: 
      case 10: 
      case 25: 
      case 26: 
      case 29: 
      case 30: 
      case 32: 
      case 33: 
      case 35: 
      case 36: 
      case 61: 
      case 88: 
      case 89: 
      case 90: 
      case 91: 
      case 92: 
      default: 
        paramContext = new StringBuilder();
      case 99: 
      case 98: 
      case 97: 
      case 96: 
      case 95: 
      case 94: 
      case 93: 
      case 87: 
        for (String str = "Unknown attribute 0x";; str = "unused attribute 0x")
        {
          paramContext.append(str);
          paramContext.append(Integer.toHexString(i2));
          paramContext.append("   ");
          paramContext.append(i.get(i2));
          Log.w("ConstraintSet", paramContext.toString());
          break label2192;
          k = 99;
          bool = parama.e.i;
          break;
          if (MotionLayout.d1)
          {
            k = paramTypedArray.getResourceId(i2, parama.a);
            parama.a = k;
            if (k != -1) {
              break label2192;
            }
          }
          else
          {
            if (paramTypedArray.peekValue(i2).type != 3) {
              break label632;
            }
          }
          parama.b = paramTypedArray.getString(i2);
          break label2192;
          parama.a = paramTypedArray.getResourceId(i2, parama.a);
          break label2192;
          k = 97;
          m = parama.e.q0;
          break label1813;
          G(locala, paramTypedArray, i2, 1);
          break label2192;
          G(locala, paramTypedArray, i2, 0);
          break label2192;
          k = 94;
          m = parama.e.U;
          break label2173;
          k = 93;
          m = parama.e.N;
          break label2173;
          paramContext = new StringBuilder();
        }
      case 86: 
        k = paramTypedArray.peekValue(i2).type;
        if (k == 1)
        {
          parama.d.n = paramTypedArray.getResourceId(i2, -1);
          locala.b(89, parama.d.n);
          paramContext = parama.d;
          if (paramContext.n == -1) {}
        }
        else
        {
          for (;;)
          {
            paramContext.m = -2;
            locala.b(88, -2);
            break label2192;
            if (k != 3) {
              break label917;
            }
            parama.d.l = paramTypedArray.getString(i2);
            locala.c(90, parama.d.l);
            if (parama.d.l.indexOf("/") <= 0) {
              break;
            }
            parama.d.n = paramTypedArray.getResourceId(i2, -1);
            locala.b(89, parama.d.n);
            paramContext = parama.d;
          }
          parama.d.m = -1;
          locala.b(88, -1);
          break label2192;
          paramContext = parama.d;
          paramContext.m = paramTypedArray.getInteger(i2, paramContext.n);
          locala.b(88, parama.d.m);
        }
        break;
      case 85: 
        k = 85;
        f1 = parama.d.j;
        break;
      case 84: 
        k = 84;
        m = parama.d.k;
        break;
      case 83: 
        k = 83;
        m = parama.f.i;
        break;
      case 82: 
        k = 82;
        m = parama.d.c;
        m = paramTypedArray.getInteger(i2, m);
        break;
      case 81: 
        k = 81;
        bool = parama.e.o0;
        break;
      case 80: 
        k = 80;
        bool = parama.e.n0;
        break;
      case 79: 
        k = 79;
        f1 = parama.d.g;
        break;
      case 78: 
        k = 78;
        m = parama.c.c;
        break;
      case 77: 
        k = 77;
        break;
      case 76: 
        k = 76;
        m = parama.d.e;
        break;
      case 75: 
        k = 75;
        bool = parama.e.p0;
        locala.d(k, paramTypedArray.getBoolean(i2, bool));
        break;
      case 74: 
        k = 74;
        break;
      case 73: 
        k = 73;
        m = parama.e.i0;
        break;
      case 72: 
        k = 72;
        m = parama.e.h0;
        break;
      case 71: 
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        break;
      case 70: 
        k = 70;
        break;
      case 69: 
        k = 69;
        break;
      case 68: 
        k = 68;
        f1 = parama.c.e;
        break;
      case 67: 
        k = 67;
        f1 = parama.d.i;
        break;
      case 66: 
        k = 66;
        m = paramTypedArray.getInt(i2, 0);
        break;
      case 65: 
        if (paramTypedArray.peekValue(i2).type == 3) {
          paramContext = paramTypedArray.getString(i2);
        } else {
          paramContext = i0.c.c[paramTypedArray.getInteger(i2, 0)];
        }
        locala.c(65, paramContext);
        break;
      case 64: 
        k = 64;
        m = parama.d.b;
        m = F(paramTypedArray, i2, m);
        break;
      case 63: 
        k = 63;
        f1 = parama.e.D;
        break;
      case 62: 
        k = 62;
        m = parama.e.C;
        break;
      case 60: 
        k = 60;
        f1 = parama.f.b;
        break;
      case 59: 
        k = 59;
        m = parama.e.e0;
        break;
      case 58: 
        k = 58;
        m = parama.e.d0;
        break;
      case 57: 
        k = 57;
        m = parama.e.c0;
        break;
      case 56: 
        k = 56;
        m = parama.e.b0;
        break;
      case 55: 
        k = 55;
        m = parama.e.a0;
        break;
      case 54: 
        k = 54;
        m = parama.e.Z;
        break;
      case 53: 
        k = 53;
        f1 = parama.f.l;
        break;
      case 52: 
        k = 52;
        f1 = parama.f.k;
        break;
      case 51: 
        k = 51;
        f1 = parama.f.j;
        break;
      case 50: 
        k = 50;
        f1 = parama.f.h;
        break;
      case 49: 
        k = 49;
      case 48: 
      case 47: 
      case 46: 
      case 45: 
      case 44: 
        for (f1 = parama.f.g;; f1 = parama.f.n)
        {
          f1 = paramTypedArray.getDimension(i2, f1);
          break label1945;
          k = 48;
          f1 = parama.f.f;
          break;
          k = 47;
          f1 = parama.f.e;
          break;
          k = 46;
          f1 = parama.f.d;
          break;
          k = 45;
          f1 = parama.f.c;
          break;
          k = 44;
          locala.d(44, true);
        }
      case 43: 
        k = 43;
        f1 = parama.c.d;
        break;
      case 42: 
        k = 42;
        m = parama.e.Y;
        break;
      case 41: 
        k = 41;
        m = parama.e.X;
        break;
      case 40: 
        k = 40;
        f1 = parama.e.V;
        break;
      case 39: 
        k = 39;
        f1 = parama.e.W;
        break;
      case 38: 
        m = paramTypedArray.getResourceId(i2, parama.a);
        parama.a = m;
        k = 38;
        break;
      case 37: 
        k = 37;
        f1 = parama.e.z;
        break;
      case 34: 
        k = 34;
        m = parama.e.J;
        break;
      case 31: 
        k = 31;
        m = parama.e.M;
        break;
      case 28: 
        k = 28;
        m = parama.e.I;
        break;
      case 27: 
        k = 27;
        m = parama.e.G;
        m = paramTypedArray.getInt(i2, m);
        break;
      case 24: 
        k = 24;
        m = parama.e.H;
        break;
      case 23: 
        k = 23;
        m = parama.e.d;
        break;
      case 22: 
        k = 22;
        m = h[paramTypedArray.getInt(i2, parama.c.b)];
        break;
      case 21: 
        k = 21;
        m = parama.e.e;
        m = paramTypedArray.getLayoutDimension(i2, m);
        break;
      case 20: 
        k = 20;
        f1 = parama.e.y;
        break;
      case 19: 
        k = 19;
        f1 = parama.e.h;
        f1 = paramTypedArray.getFloat(i2, f1);
        locala.a(k, f1);
        break;
      case 18: 
        k = 18;
        m = parama.e.g;
        break;
      case 17: 
        k = 17;
        m = parama.e.f;
        break;
      case 16: 
        k = 16;
        m = parama.e.P;
        break;
      case 15: 
        k = 15;
        m = parama.e.T;
        break;
      case 14: 
        k = 14;
        m = parama.e.Q;
        break;
      case 13: 
        k = 13;
        m = parama.e.O;
        break;
      case 12: 
        k = 12;
        m = parama.e.S;
        break;
      case 11: 
        k = 11;
        m = parama.e.R;
        break;
      case 8: 
        k = 8;
        m = parama.e.L;
        break;
      case 7: 
        k = 7;
        m = parama.e.F;
        break;
      case 6: 
        k = 6;
        m = parama.e.E;
        m = paramTypedArray.getDimensionPixelOffset(i2, m);
        break;
      case 5: 
        label632:
        k = 5;
        label917:
        label1945:
        locala.c(k, paramTypedArray.getString(i2));
        label1813:
        break;
      }
      k = 2;
      int m = parama.e.K;
      label2173:
      m = paramTypedArray.getDimensionPixelSize(i2, m);
      locala.b(k, m);
      label2192:
      n += 1;
    }
  }
  
  private static void N(a parama, int paramInt, float paramFloat)
  {
    if (paramInt != 19)
    {
      if (paramInt != 20)
      {
        if (paramInt != 37)
        {
          if (paramInt != 60)
          {
            if (paramInt != 63)
            {
              if (paramInt != 79)
              {
                if (paramInt != 85)
                {
                  if (paramInt != 87)
                  {
                    if (paramInt != 39)
                    {
                      if (paramInt != 40)
                      {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            return;
                          case 70: 
                            parama.e.g0 = paramFloat;
                            return;
                          case 69: 
                            parama.e.f0 = paramFloat;
                            return;
                          case 68: 
                            parama.c.e = paramFloat;
                            return;
                          }
                          parama.d.i = paramFloat;
                          return;
                        case 53: 
                          parama.f.l = paramFloat;
                          return;
                        case 52: 
                          parama.f.k = paramFloat;
                          return;
                        case 51: 
                          parama.f.j = paramFloat;
                          return;
                        case 50: 
                          parama.f.h = paramFloat;
                          return;
                        case 49: 
                          parama.f.g = paramFloat;
                          return;
                        case 48: 
                          parama.f.f = paramFloat;
                          return;
                        case 47: 
                          parama.f.e = paramFloat;
                          return;
                        case 46: 
                          parama.f.d = paramFloat;
                          return;
                        case 45: 
                          parama.f.c = paramFloat;
                          return;
                        case 44: 
                          parama = parama.f;
                          parama.n = paramFloat;
                          parama.m = true;
                          return;
                        }
                        parama.c.d = paramFloat;
                        return;
                      }
                      parama.e.V = paramFloat;
                      return;
                    }
                    parama.e.W = paramFloat;
                  }
                }
                else {
                  parama.d.j = paramFloat;
                }
              }
              else {
                parama.d.g = paramFloat;
              }
            }
            else {
              parama.e.D = paramFloat;
            }
          }
          else {
            parama.f.b = paramFloat;
          }
        }
        else {
          parama.e.z = paramFloat;
        }
      }
      else {
        parama.e.y = paramFloat;
      }
    }
    else {
      parama.e.h = paramFloat;
    }
  }
  
  private static void O(a parama, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 6)
    {
      if (paramInt1 != 7)
      {
        if (paramInt1 != 8)
        {
          if (paramInt1 != 27)
          {
            if (paramInt1 != 28)
            {
              if (paramInt1 != 41)
              {
                if (paramInt1 != 42)
                {
                  if (paramInt1 != 61)
                  {
                    if (paramInt1 != 62)
                    {
                      if (paramInt1 != 72)
                      {
                        if (paramInt1 != 73)
                        {
                          switch (paramInt1)
                          {
                          default: 
                            switch (paramInt1)
                            {
                            default: 
                              switch (paramInt1)
                              {
                              default: 
                                switch (paramInt1)
                                {
                                default: 
                                  switch (paramInt1)
                                  {
                                  default: 
                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                    return;
                                  case 89: 
                                    parama.d.n = paramInt2;
                                    return;
                                  case 88: 
                                    parama.d.m = paramInt2;
                                    return;
                                  }
                                case 84: 
                                  parama.d.k = paramInt2;
                                  return;
                                case 83: 
                                  parama.f.i = paramInt2;
                                  return;
                                }
                                parama.d.c = paramInt2;
                                return;
                              case 59: 
                                parama.e.e0 = paramInt2;
                                return;
                              case 58: 
                                parama.e.d0 = paramInt2;
                                return;
                              case 57: 
                                parama.e.c0 = paramInt2;
                                return;
                              case 56: 
                                parama.e.b0 = paramInt2;
                                return;
                              case 55: 
                                parama.e.a0 = paramInt2;
                                return;
                              }
                              parama.e.Z = paramInt2;
                              return;
                            case 24: 
                              parama.e.H = paramInt2;
                              return;
                            case 23: 
                              parama.e.d = paramInt2;
                              return;
                            case 22: 
                              parama.c.b = paramInt2;
                              return;
                            }
                            parama.e.e = paramInt2;
                            return;
                          case 97: 
                            parama.e.q0 = paramInt2;
                            return;
                          case 94: 
                            parama.e.U = paramInt2;
                            return;
                          case 93: 
                            parama.e.N = paramInt2;
                            return;
                          case 78: 
                            parama.c.c = paramInt2;
                            return;
                          case 76: 
                            parama.d.e = paramInt2;
                            return;
                          case 66: 
                            parama.d.f = paramInt2;
                            return;
                          case 64: 
                            parama.d.b = paramInt2;
                            return;
                          case 38: 
                            parama.a = paramInt2;
                            return;
                          case 34: 
                            parama.e.J = paramInt2;
                            return;
                          case 31: 
                            parama.e.M = paramInt2;
                            return;
                          case 18: 
                            parama.e.g = paramInt2;
                            return;
                          case 17: 
                            parama.e.f = paramInt2;
                            return;
                          case 16: 
                            parama.e.P = paramInt2;
                            return;
                          case 15: 
                            parama.e.T = paramInt2;
                            return;
                          case 14: 
                            parama.e.Q = paramInt2;
                            return;
                          case 13: 
                            parama.e.O = paramInt2;
                            return;
                          case 12: 
                            parama.e.S = paramInt2;
                            return;
                          case 11: 
                            parama.e.R = paramInt2;
                            return;
                          }
                          parama.e.K = paramInt2;
                          return;
                        }
                        parama.e.i0 = paramInt2;
                        return;
                      }
                      parama.e.h0 = paramInt2;
                      return;
                    }
                    parama.e.C = paramInt2;
                    return;
                  }
                  parama.e.B = paramInt2;
                  return;
                }
                parama.e.Y = paramInt2;
                return;
              }
              parama.e.X = paramInt2;
              return;
            }
            parama.e.I = paramInt2;
            return;
          }
          parama.e.G = paramInt2;
          return;
        }
        parama.e.L = paramInt2;
        return;
      }
      parama.e.F = paramInt2;
      return;
    }
    parama.e.E = paramInt2;
  }
  
  private static void P(a parama, int paramInt, String paramString)
  {
    if (paramInt != 5)
    {
      if (paramInt != 65)
      {
        if (paramInt != 74)
        {
          if (paramInt != 77)
          {
            if (paramInt != 87)
            {
              if (paramInt != 90)
              {
                Log.w("ConstraintSet", "Unknown attribute 0x");
                return;
              }
              parama.d.l = paramString;
            }
          }
          else {
            parama.e.m0 = paramString;
          }
        }
        else
        {
          parama = parama.e;
          parama.l0 = paramString;
          parama.k0 = null;
        }
      }
      else {
        parama.d.d = paramString;
      }
    }
    else {
      parama.e.A = paramString;
    }
  }
  
  private static void Q(a parama, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 44)
    {
      if (paramInt != 75)
      {
        if (paramInt != 87)
        {
          if (paramInt != 80)
          {
            if (paramInt != 81)
            {
              Log.w("ConstraintSet", "Unknown attribute 0x");
              return;
            }
            parama.e.o0 = paramBoolean;
            return;
          }
          parama.e.n0 = paramBoolean;
        }
      }
      else {
        parama.e.p0 = paramBoolean;
      }
    }
    else {
      parama.f.m = paramBoolean;
    }
  }
  
  public static a m(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    Object localObject = Xml.asAttributeSet(paramXmlPullParser);
    paramXmlPullParser = new a();
    localObject = paramContext.obtainStyledAttributes((AttributeSet)localObject, R.styleable.ConstraintOverride);
    K(paramContext, paramXmlPullParser, (TypedArray)localObject);
    ((TypedArray)localObject).recycle();
    return paramXmlPullParser;
  }
  
  private int[] t(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    Context localContext = paramView.getContext();
    paramString = new int[arrayOfString.length];
    int i1 = 0;
    int n = i1;
    while (i1 < arrayOfString.length)
    {
      Object localObject = arrayOfString[i1].trim();
      try
      {
        m = R.id.class.getField((String)localObject).getInt(null);
      }
      catch (Exception localException)
      {
        int m;
        label63:
        int k;
        break label63;
      }
      m = 0;
      k = m;
      if (m == 0) {
        k = localContext.getResources().getIdentifier((String)localObject, "id", localContext.getPackageName());
      }
      m = k;
      if (k == 0)
      {
        m = k;
        if (paramView.isInEditMode())
        {
          m = k;
          if ((paramView.getParent() instanceof ConstraintLayout))
          {
            localObject = ((ConstraintLayout)paramView.getParent()).h(0, localObject);
            m = k;
            if (localObject != null)
            {
              m = k;
              if ((localObject instanceof Integer)) {
                m = ((Integer)localObject).intValue();
              }
            }
          }
        }
      }
      paramString[n] = m;
      i1 += 1;
      n += 1;
    }
    paramView = paramString;
    if (n != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, n);
    }
    return paramView;
  }
  
  private a u(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    a locala = new a();
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = R.styleable.ConstraintOverride;
    } else {
      arrayOfInt = R.styleable.Constraint;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    J(paramContext, locala, paramAttributeSet, paramBoolean);
    paramAttributeSet.recycle();
    return locala;
  }
  
  private a v(int paramInt)
  {
    if (!this.g.containsKey(Integer.valueOf(paramInt))) {
      this.g.put(Integer.valueOf(paramInt), new a());
    }
    return (a)this.g.get(Integer.valueOf(paramInt));
  }
  
  public int A(int paramInt)
  {
    return v(paramInt).c.b;
  }
  
  public int B(int paramInt)
  {
    return v(paramInt).c.c;
  }
  
  public int C(int paramInt)
  {
    return v(paramInt).e.d;
  }
  
  public void D(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      paramInt = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      String str;
      a locala;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    str = localXmlResourceParser.getName();
    locala = u(paramContext, Xml.asAttributeSet(localXmlResourceParser), false);
    if (str.equalsIgnoreCase("Guideline")) {
      locala.e.a = true;
    }
    this.g.put(Integer.valueOf(locala.a), locala);
    break label87;
    label80:
    localXmlResourceParser.getName();
    for (;;)
    {
      label87:
      paramInt = localXmlResourceParser.next();
      while (paramInt == 1) {
        return;
      }
      if (paramInt == 0) {
        break label80;
      }
      if (paramInt == 2) {
        break;
      }
    }
  }
  
  public void E(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    int k;
    try
    {
      k = paramXmlPullParser.getEventType();
      localObject1 = null;
    }
    catch (IOException paramContext)
    {
      Object localObject1;
      Object localObject2;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    localObject2 = paramXmlPullParser.getName().toLowerCase(Locale.ROOT);
    int m;
    switch (((String)localObject2).hashCode())
    {
    case 2146106725: 
      k = m;
      if (((String)localObject2).equals("constraintset")) {
        k = 0;
      }
      break;
    case 426575017: 
      k = m;
      if (((String)localObject2).equals("constraintoverride")) {
        k = 2;
      }
      break;
    case -190376483: 
      k = m;
      if (((String)localObject2).equals("constraint")) {
        k = 1;
      }
      break;
    case -2075718416: 
      k = m;
      if (((String)localObject2).equals("guideline"))
      {
        k = 3;
        break label977;
        label152:
        this.g.put(Integer.valueOf(((a)localObject1).a), localObject1);
        localObject1 = null;
        break;
        label176:
        localObject2 = paramXmlPullParser.getName();
        switch (((String)localObject2).hashCode())
        {
        case 1803088381: 
          k = m;
          if (((String)localObject2).equals("Constraint")) {
            k = 0;
          }
          break;
        case 1791837707: 
          k = m;
          if (((String)localObject2).equals("CustomAttribute")) {
            k = 8;
          }
          break;
        case 1331510167: 
          k = m;
          if (((String)localObject2).equals("Barrier")) {
            k = 3;
          }
          break;
        case 366511058: 
          k = m;
          if (((String)localObject2).equals("CustomMethod")) {
            k = 9;
          }
          break;
        case -71750448: 
          k = m;
          if (((String)localObject2).equals("Guideline")) {
            k = 2;
          }
          break;
        case -1238332596: 
          k = m;
          if (((String)localObject2).equals("Transform")) {
            k = 5;
          }
          break;
        case -1269513683: 
          k = m;
          if (((String)localObject2).equals("PropertySet")) {
            k = 4;
          }
          break;
        case -1962203927: 
          k = m;
          if (((String)localObject2).equals("ConstraintOverride")) {
            k = 1;
          }
          break;
        case -1984451626: 
          k = m;
          if (((String)localObject2).equals("Motion")) {
            k = 7;
          }
          break;
        case -2025855158: 
          boolean bool = ((String)localObject2).equals("Layout");
          k = m;
          if (bool) {
            k = 6;
          }
          switch (k)
          {
          default: 
            break;
          case 8: 
          case 9: 
            if (localObject1 != null)
            {
              a.i(paramContext, paramXmlPullParser, ((a)localObject1).g);
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 7: 
            if (localObject1 != null)
            {
              ((a)localObject1).d.b(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 6: 
            if (localObject1 != null)
            {
              ((a)localObject1).e.b(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 5: 
            if (localObject1 != null)
            {
              ((a)localObject1).f.b(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 4: 
            if (localObject1 != null)
            {
              ((a)localObject1).c.b(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 3: 
            localObject1 = u(paramContext, Xml.asAttributeSet(paramXmlPullParser), false);
            ((a)localObject1).e.j0 = 1;
            break;
          case 2: 
            localObject1 = u(paramContext, Xml.asAttributeSet(paramXmlPullParser), false);
            localObject2 = ((a)localObject1).e;
            ((b)localObject2).a = true;
            ((b)localObject2).b = true;
            break;
          case 1: 
            localObject1 = u(paramContext, Xml.asAttributeSet(paramXmlPullParser), true);
            break;
          case 0: 
            label475:
            localObject1 = u(paramContext, Xml.asAttributeSet(paramXmlPullParser), false);
            break label1006;
            label920:
            paramXmlPullParser.getName();
          }
          break;
        }
      }
      break;
    }
    label977:
    label1006:
    for (;;)
    {
      k = paramXmlPullParser.next();
      while (k == 1) {
        return;
      }
      if (k == 0) {
        break label920;
      }
      m = -1;
      if (k == 2) {
        break label176;
      }
      if (k == 3) {
        break;
      }
      continue;
      k = m;
      if (k != 0)
      {
        if ((k == 1) || (k == 2) || (k == 3)) {
          break label152;
        }
        continue;
      }
      return;
      k = m;
      break label475;
    }
  }
  
  public void L(ConstraintLayout paramConstraintLayout)
  {
    int m = paramConstraintLayout.getChildCount();
    int k = 0;
    while (k < m)
    {
      View localView = paramConstraintLayout.getChildAt(k);
      Object localObject2 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int n = localView.getId();
      if ((this.f) && (n == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.g.containsKey(Integer.valueOf(n))) {
        this.g.put(Integer.valueOf(n), new a());
      }
      Object localObject1 = (a)this.g.get(Integer.valueOf(n));
      if (localObject1 != null)
      {
        if (!((a)localObject1).e.b)
        {
          a.a((a)localObject1, n, (ConstraintLayout.LayoutParams)localObject2);
          if ((localView instanceof ConstraintHelper))
          {
            ((a)localObject1).e.k0 = ((ConstraintHelper)localView).getReferencedIds();
            if ((localView instanceof Barrier))
            {
              localObject2 = (Barrier)localView;
              ((a)localObject1).e.p0 = ((Barrier)localObject2).getAllowsGoneWidget();
              ((a)localObject1).e.h0 = ((Barrier)localObject2).getType();
              ((a)localObject1).e.i0 = ((Barrier)localObject2).getMargin();
            }
          }
          ((a)localObject1).e.b = true;
        }
        localObject2 = ((a)localObject1).c;
        if (!((d)localObject2).a)
        {
          ((d)localObject2).b = localView.getVisibility();
          ((a)localObject1).c.d = localView.getAlpha();
          ((a)localObject1).c.a = true;
        }
        localObject2 = ((a)localObject1).f;
        if (!((e)localObject2).a)
        {
          ((e)localObject2).a = true;
          ((e)localObject2).b = localView.getRotation();
          ((a)localObject1).f.c = localView.getRotationX();
          ((a)localObject1).f.d = localView.getRotationY();
          ((a)localObject1).f.e = localView.getScaleX();
          ((a)localObject1).f.f = localView.getScaleY();
          float f1 = localView.getPivotX();
          float f2 = localView.getPivotY();
          if ((f1 != 0.0D) || (f2 != 0.0D))
          {
            localObject2 = ((a)localObject1).f;
            ((e)localObject2).g = f1;
            ((e)localObject2).h = f2;
          }
          ((a)localObject1).f.j = localView.getTranslationX();
          ((a)localObject1).f.k = localView.getTranslationY();
          ((a)localObject1).f.l = localView.getTranslationZ();
          localObject1 = ((a)localObject1).f;
          if (((e)localObject1).m) {
            ((e)localObject1).n = localView.getElevation();
          }
        }
      }
      k += 1;
    }
  }
  
  public void M(c paramc)
  {
    Iterator localIterator = paramc.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Integer)localIterator.next();
      int k = ((Integer)localObject1).intValue();
      localObject1 = (a)paramc.g.get(localObject1);
      if (!this.g.containsKey(Integer.valueOf(k))) {
        this.g.put(Integer.valueOf(k), new a());
      }
      a locala = (a)this.g.get(Integer.valueOf(k));
      if (locala != null)
      {
        Object localObject2 = locala.e;
        if (!((b)localObject2).b) {
          ((b)localObject2).a(((a)localObject1).e);
        }
        localObject2 = locala.c;
        if (!((d)localObject2).a) {
          ((d)localObject2).a(((a)localObject1).c);
        }
        localObject2 = locala.f;
        if (!((e)localObject2).a) {
          ((e)localObject2).a(((a)localObject1).f);
        }
        localObject2 = locala.d;
        if (!((c)localObject2).a) {
          ((c)localObject2).a(((a)localObject1).d);
        }
        localObject2 = ((a)localObject1).g.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!locala.g.containsKey(str)) {
            locala.g.put(str, (a)((a)localObject1).g.get(str));
          }
        }
      }
    }
  }
  
  public void R(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void S(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void g(ConstraintLayout paramConstraintLayout)
  {
    int m = paramConstraintLayout.getChildCount();
    int k = 0;
    while (k < m)
    {
      View localView = paramConstraintLayout.getChildAt(k);
      int n = localView.getId();
      Object localObject;
      if (!this.g.containsKey(Integer.valueOf(n)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id unknown ");
        ((StringBuilder)localObject).append(androidx.constraintlayout.motion.widget.a.d(localView));
        Log.w("ConstraintSet", ((StringBuilder)localObject).toString());
      }
      else
      {
        if ((this.f) && (n == -1)) {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
        if (this.g.containsKey(Integer.valueOf(n)))
        {
          localObject = (a)this.g.get(Integer.valueOf(n));
          if (localObject != null) {
            a.j(localView, ((a)localObject).g);
          }
        }
      }
      k += 1;
    }
  }
  
  public void h(c paramc)
  {
    paramc = paramc.g.values().iterator();
    while (paramc.hasNext())
    {
      a locala1 = (a)paramc.next();
      if (locala1.h != null)
      {
        Object localObject;
        if (locala1.b != null)
        {
          localObject = this.g.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala2 = w(((Integer)((Iterator)localObject).next()).intValue());
            String str = locala2.e.m0;
            if ((str != null) && (locala1.b.matches(str)))
            {
              locala1.h.e(locala2);
              locala2.g.putAll((HashMap)locala1.g.clone());
            }
          }
        }
        else
        {
          localObject = w(locala1.a);
          locala1.h.e((a)localObject);
        }
      }
    }
  }
  
  public void i(ConstraintLayout paramConstraintLayout)
  {
    k(paramConstraintLayout, true);
    paramConstraintLayout.setConstraintSet(null);
    paramConstraintLayout.requestLayout();
  }
  
  public void j(ConstraintHelper paramConstraintHelper, e parame, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<e> paramSparseArray)
  {
    int k = paramConstraintHelper.getId();
    if (this.g.containsKey(Integer.valueOf(k)))
    {
      a locala = (a)this.g.get(Integer.valueOf(k));
      if ((locala != null) && ((parame instanceof j))) {
        paramConstraintHelper.p(locala, (j)parame, paramLayoutParams, paramSparseArray);
      }
    }
  }
  
  void k(ConstraintLayout paramConstraintLayout, boolean paramBoolean)
  {
    int n = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.g.keySet());
    int m = 0;
    int k = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    while (k < n)
    {
      localObject2 = paramConstraintLayout.getChildAt(k);
      int i1 = ((View)localObject2).getId();
      if (!this.g.containsKey(Integer.valueOf(i1)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("id unknown ");
        ((StringBuilder)localObject3).append(androidx.constraintlayout.motion.widget.a.d((View)localObject2));
        Log.w("ConstraintSet", ((StringBuilder)localObject3).toString());
      }
      else
      {
        if ((this.f) && (i1 == -1)) {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
        if (i1 != -1) {
          if (this.g.containsKey(Integer.valueOf(i1)))
          {
            ((HashSet)localObject1).remove(Integer.valueOf(i1));
            localObject3 = (a)this.g.get(Integer.valueOf(i1));
            if (localObject3 != null)
            {
              if ((localObject2 instanceof Barrier))
              {
                ((a)localObject3).e.j0 = 1;
                localObject4 = (Barrier)localObject2;
                ((View)localObject4).setId(i1);
                ((Barrier)localObject4).setType(((a)localObject3).e.h0);
                ((Barrier)localObject4).setMargin(((a)localObject3).e.i0);
                ((Barrier)localObject4).setAllowsGoneWidget(((a)localObject3).e.p0);
                localObject5 = ((a)localObject3).e;
                localObject6 = ((b)localObject5).k0;
                if (localObject6 != null)
                {
                  ((ConstraintHelper)localObject4).setReferencedIds((int[])localObject6);
                }
                else
                {
                  localObject6 = ((b)localObject5).l0;
                  if (localObject6 != null)
                  {
                    ((b)localObject5).k0 = t((View)localObject4, (String)localObject6);
                    ((ConstraintHelper)localObject4).setReferencedIds(((a)localObject3).e.k0);
                  }
                }
              }
              localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
              ((ConstraintLayout.LayoutParams)localObject4).c();
              ((a)localObject3).e((ConstraintLayout.LayoutParams)localObject4);
              if (paramBoolean) {
                a.j((View)localObject2, ((a)localObject3).g);
              }
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              localObject4 = ((a)localObject3).c;
              if (((d)localObject4).c == 0) {
                ((View)localObject2).setVisibility(((d)localObject4).b);
              }
              ((View)localObject2).setAlpha(((a)localObject3).c.d);
              ((View)localObject2).setRotation(((a)localObject3).f.b);
              ((View)localObject2).setRotationX(((a)localObject3).f.c);
              ((View)localObject2).setRotationY(((a)localObject3).f.d);
              ((View)localObject2).setScaleX(((a)localObject3).f.e);
              ((View)localObject2).setScaleY(((a)localObject3).f.f);
              localObject4 = ((a)localObject3).f;
              if (((e)localObject4).i != -1)
              {
                localObject4 = ((View)((View)localObject2).getParent()).findViewById(((a)localObject3).f.i);
                if (localObject4 != null)
                {
                  float f1 = (((View)localObject4).getTop() + ((View)localObject4).getBottom()) / 2.0F;
                  float f2 = (((View)localObject4).getLeft() + ((View)localObject4).getRight()) / 2.0F;
                  if ((((View)localObject2).getRight() - ((View)localObject2).getLeft() > 0) && (((View)localObject2).getBottom() - ((View)localObject2).getTop() > 0))
                  {
                    float f3 = ((View)localObject2).getLeft();
                    float f4 = ((View)localObject2).getTop();
                    ((View)localObject2).setPivotX(f2 - f3);
                    ((View)localObject2).setPivotY(f1 - f4);
                  }
                }
              }
              else
              {
                if (!Float.isNaN(((e)localObject4).g)) {
                  ((View)localObject2).setPivotX(((a)localObject3).f.g);
                }
                if (!Float.isNaN(((a)localObject3).f.h)) {
                  ((View)localObject2).setPivotY(((a)localObject3).f.h);
                }
              }
              ((View)localObject2).setTranslationX(((a)localObject3).f.j);
              ((View)localObject2).setTranslationY(((a)localObject3).f.k);
              ((View)localObject2).setTranslationZ(((a)localObject3).f.l);
              localObject3 = ((a)localObject3).f;
              if (((e)localObject3).m) {
                ((View)localObject2).setElevation(((e)localObject3).n);
              }
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WARNING NO CONSTRAINTS for view ");
            ((StringBuilder)localObject2).append(i1);
            Log.v("ConstraintSet", ((StringBuilder)localObject2).toString());
          }
        }
      }
      k += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    for (;;)
    {
      k = m;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (a)this.g.get(localObject3);
      if (localObject2 != null)
      {
        if (((a)localObject2).e.j0 == 1)
        {
          localObject4 = new Barrier(paramConstraintLayout.getContext());
          ((View)localObject4).setId(((Integer)localObject3).intValue());
          localObject5 = ((a)localObject2).e;
          localObject6 = ((b)localObject5).k0;
          if (localObject6 != null)
          {
            ((ConstraintHelper)localObject4).setReferencedIds((int[])localObject6);
          }
          else
          {
            localObject6 = ((b)localObject5).l0;
            if (localObject6 != null)
            {
              ((b)localObject5).k0 = t((View)localObject4, (String)localObject6);
              ((ConstraintHelper)localObject4).setReferencedIds(((a)localObject2).e.k0);
            }
          }
          ((Barrier)localObject4).setType(((a)localObject2).e.h0);
          ((Barrier)localObject4).setMargin(((a)localObject2).e.i0);
          localObject5 = paramConstraintLayout.f();
          ((ConstraintHelper)localObject4).w();
          ((a)localObject2).e((ConstraintLayout.LayoutParams)localObject5);
          paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        }
        if (((a)localObject2).e.a)
        {
          localObject4 = new Guideline(paramConstraintLayout.getContext());
          ((View)localObject4).setId(((Integer)localObject3).intValue());
          localObject3 = paramConstraintLayout.f();
          ((a)localObject2).e((ConstraintLayout.LayoutParams)localObject3);
          paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    while (k < n)
    {
      localObject1 = paramConstraintLayout.getChildAt(k);
      if ((localObject1 instanceof ConstraintHelper)) {
        ((ConstraintHelper)localObject1).j(paramConstraintLayout);
      }
      k += 1;
    }
  }
  
  public void l(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    if (this.g.containsKey(Integer.valueOf(paramInt)))
    {
      a locala = (a)this.g.get(Integer.valueOf(paramInt));
      if (locala != null) {
        locala.e(paramLayoutParams);
      }
    }
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    if (this.g.containsKey(Integer.valueOf(paramInt1)))
    {
      Object localObject = (a)this.g.get(Integer.valueOf(paramInt1));
      if (localObject == null) {
        return;
      }
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("unknown constraint");
      case 8: 
        localObject = ((a)localObject).e;
        ((b)localObject).D = -1.0F;
        ((b)localObject).C = -1;
        ((b)localObject).B = -1;
        return;
      case 7: 
        localObject = ((a)localObject).e;
        ((b)localObject).w = -1;
        ((b)localObject).x = -1;
        ((b)localObject).L = 0;
        ((b)localObject).S = -2147483648;
        return;
      case 6: 
        localObject = ((a)localObject).e;
        ((b)localObject).u = -1;
        ((b)localObject).v = -1;
        ((b)localObject).M = 0;
        ((b)localObject).T = -2147483648;
        return;
      case 5: 
        localObject = ((a)localObject).e;
        ((b)localObject).r = -1;
        ((b)localObject).s = -1;
        ((b)localObject).t = -1;
        ((b)localObject).N = 0;
        ((b)localObject).U = -2147483648;
        return;
      case 4: 
        localObject = ((a)localObject).e;
        ((b)localObject).p = -1;
        ((b)localObject).q = -1;
        ((b)localObject).K = 0;
        ((b)localObject).R = -2147483648;
        return;
      case 3: 
        localObject = ((a)localObject).e;
        ((b)localObject).o = -1;
        ((b)localObject).n = -1;
        ((b)localObject).J = 0;
        ((b)localObject).P = -2147483648;
        return;
      case 2: 
        localObject = ((a)localObject).e;
        ((b)localObject).m = -1;
        ((b)localObject).l = -1;
        ((b)localObject).I = -1;
        ((b)localObject).Q = -2147483648;
        return;
      }
      localObject = ((a)localObject).e;
      ((b)localObject).k = -1;
      ((b)localObject).j = -1;
      ((b)localObject).H = -1;
      ((b)localObject).O = -2147483648;
    }
  }
  
  public void o(Context paramContext, int paramInt)
  {
    p((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void p(ConstraintLayout paramConstraintLayout)
  {
    int m = paramConstraintLayout.getChildCount();
    this.g.clear();
    int k = 0;
    while (k < m)
    {
      Object localObject1 = paramConstraintLayout.getChildAt(k);
      Object localObject2 = (ConstraintLayout.LayoutParams)((View)localObject1).getLayoutParams();
      int n = ((View)localObject1).getId();
      if ((this.f) && (n == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.g.containsKey(Integer.valueOf(n))) {
        this.g.put(Integer.valueOf(n), new a());
      }
      a locala = (a)this.g.get(Integer.valueOf(n));
      if (locala != null)
      {
        locala.g = a.b(this.e, (View)localObject1);
        a.a(locala, n, (ConstraintLayout.LayoutParams)localObject2);
        locala.c.b = ((View)localObject1).getVisibility();
        locala.c.d = ((View)localObject1).getAlpha();
        locala.f.b = ((View)localObject1).getRotation();
        locala.f.c = ((View)localObject1).getRotationX();
        locala.f.d = ((View)localObject1).getRotationY();
        locala.f.e = ((View)localObject1).getScaleX();
        locala.f.f = ((View)localObject1).getScaleY();
        float f1 = ((View)localObject1).getPivotX();
        float f2 = ((View)localObject1).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          localObject2 = locala.f;
          ((e)localObject2).g = f1;
          ((e)localObject2).h = f2;
        }
        locala.f.j = ((View)localObject1).getTranslationX();
        locala.f.k = ((View)localObject1).getTranslationY();
        locala.f.l = ((View)localObject1).getTranslationZ();
        localObject2 = locala.f;
        if (((e)localObject2).m) {
          ((e)localObject2).n = ((View)localObject1).getElevation();
        }
        if ((localObject1 instanceof Barrier))
        {
          localObject1 = (Barrier)localObject1;
          locala.e.p0 = ((Barrier)localObject1).getAllowsGoneWidget();
          locala.e.k0 = ((ConstraintHelper)localObject1).getReferencedIds();
          locala.e.h0 = ((Barrier)localObject1).getType();
          locala.e.i0 = ((Barrier)localObject1).getMargin();
        }
      }
      k += 1;
    }
  }
  
  public void q(c paramc)
  {
    this.g.clear();
    Iterator localIterator = paramc.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      a locala = (a)paramc.g.get(localInteger);
      if (locala != null) {
        this.g.put(localInteger, locala.f());
      }
    }
  }
  
  public void r(Constraints paramConstraints)
  {
    int m = paramConstraints.getChildCount();
    this.g.clear();
    int k = 0;
    while (k < m)
    {
      View localView = paramConstraints.getChildAt(k);
      Constraints.LayoutParams localLayoutParams = (Constraints.LayoutParams)localView.getLayoutParams();
      int n = localView.getId();
      if ((this.f) && (n == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.g.containsKey(Integer.valueOf(n))) {
        this.g.put(Integer.valueOf(n), new a());
      }
      a locala = (a)this.g.get(Integer.valueOf(n));
      if (locala != null)
      {
        if ((localView instanceof ConstraintHelper)) {
          a.b(locala, (ConstraintHelper)localView, n, localLayoutParams);
        }
        a.c(locala, n, localLayoutParams);
      }
      k += 1;
    }
  }
  
  public void s(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    b localb = v(paramInt1).e;
    localb.B = paramInt2;
    localb.C = paramInt3;
    localb.D = paramFloat;
  }
  
  public a w(int paramInt)
  {
    if (this.g.containsKey(Integer.valueOf(paramInt))) {
      return (a)this.g.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public int x(int paramInt)
  {
    return v(paramInt).e.e;
  }
  
  public int[] y()
  {
    Object localObject = this.g.keySet();
    int k = 0;
    localObject = (Integer[])((Set)localObject).toArray(new Integer[0]);
    int m = localObject.length;
    int[] arrayOfInt = new int[m];
    while (k < m)
    {
      arrayOfInt[k] = localObject[k].intValue();
      k += 1;
    }
    return arrayOfInt;
  }
  
  public a z(int paramInt)
  {
    return v(paramInt);
  }
  
  public static class a
  {
    int a;
    String b;
    public final c.d c = new c.d();
    public final c.c d = new c.c();
    public final c.b e = new c.b();
    public final c.e f = new c.e();
    public HashMap<String, a> g = new HashMap();
    a h;
    
    private void g(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      this.a = paramInt;
      c.b localb = this.e;
      localb.j = paramLayoutParams.e;
      localb.k = paramLayoutParams.f;
      localb.l = paramLayoutParams.g;
      localb.m = paramLayoutParams.h;
      localb.n = paramLayoutParams.i;
      localb.o = paramLayoutParams.j;
      localb.p = paramLayoutParams.k;
      localb.q = paramLayoutParams.l;
      localb.r = paramLayoutParams.m;
      localb.s = paramLayoutParams.n;
      localb.t = paramLayoutParams.o;
      localb.u = paramLayoutParams.s;
      localb.v = paramLayoutParams.t;
      localb.w = paramLayoutParams.u;
      localb.x = paramLayoutParams.v;
      localb.y = paramLayoutParams.G;
      localb.z = paramLayoutParams.H;
      localb.A = paramLayoutParams.I;
      localb.B = paramLayoutParams.p;
      localb.C = paramLayoutParams.q;
      localb.D = paramLayoutParams.r;
      localb.E = paramLayoutParams.X;
      localb.F = paramLayoutParams.Y;
      localb.G = paramLayoutParams.Z;
      localb.h = paramLayoutParams.c;
      localb.f = paramLayoutParams.a;
      localb.g = paramLayoutParams.b;
      localb.d = paramLayoutParams.width;
      localb.e = paramLayoutParams.height;
      localb.H = paramLayoutParams.leftMargin;
      localb.I = paramLayoutParams.rightMargin;
      localb.J = paramLayoutParams.topMargin;
      localb.K = paramLayoutParams.bottomMargin;
      localb.N = paramLayoutParams.D;
      localb.V = paramLayoutParams.M;
      localb.W = paramLayoutParams.L;
      localb.Y = paramLayoutParams.O;
      localb.X = paramLayoutParams.N;
      localb.n0 = paramLayoutParams.a0;
      localb.o0 = paramLayoutParams.b0;
      localb.Z = paramLayoutParams.P;
      localb.a0 = paramLayoutParams.Q;
      localb.b0 = paramLayoutParams.T;
      localb.c0 = paramLayoutParams.U;
      localb.d0 = paramLayoutParams.R;
      localb.e0 = paramLayoutParams.S;
      localb.f0 = paramLayoutParams.V;
      localb.g0 = paramLayoutParams.W;
      localb.m0 = paramLayoutParams.c0;
      localb.P = paramLayoutParams.x;
      localb.R = paramLayoutParams.z;
      localb.O = paramLayoutParams.w;
      localb.Q = paramLayoutParams.y;
      localb.T = paramLayoutParams.A;
      localb.S = paramLayoutParams.B;
      localb.U = paramLayoutParams.C;
      localb.q0 = paramLayoutParams.d0;
      localb.L = paramLayoutParams.getMarginEnd();
      this.e.M = paramLayoutParams.getMarginStart();
    }
    
    private void h(int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      g(paramInt, paramLayoutParams);
      this.c.d = paramLayoutParams.x0;
      c.e locale = this.f;
      locale.b = paramLayoutParams.A0;
      locale.c = paramLayoutParams.B0;
      locale.d = paramLayoutParams.C0;
      locale.e = paramLayoutParams.D0;
      locale.f = paramLayoutParams.E0;
      locale.g = paramLayoutParams.F0;
      locale.h = paramLayoutParams.G0;
      locale.j = paramLayoutParams.H0;
      locale.k = paramLayoutParams.I0;
      locale.l = paramLayoutParams.J0;
      locale.n = paramLayoutParams.z0;
      locale.m = paramLayoutParams.y0;
    }
    
    private void i(ConstraintHelper paramConstraintHelper, int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      h(paramInt, paramLayoutParams);
      if ((paramConstraintHelper instanceof Barrier))
      {
        paramLayoutParams = this.e;
        paramLayoutParams.j0 = 1;
        paramConstraintHelper = (Barrier)paramConstraintHelper;
        paramLayoutParams.h0 = paramConstraintHelper.getType();
        this.e.k0 = paramConstraintHelper.getReferencedIds();
        this.e.i0 = paramConstraintHelper.getMargin();
      }
    }
    
    public void d(a parama)
    {
      a locala = this.h;
      if (locala != null) {
        locala.e(parama);
      }
    }
    
    public void e(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      c.b localb = this.e;
      paramLayoutParams.e = localb.j;
      paramLayoutParams.f = localb.k;
      paramLayoutParams.g = localb.l;
      paramLayoutParams.h = localb.m;
      paramLayoutParams.i = localb.n;
      paramLayoutParams.j = localb.o;
      paramLayoutParams.k = localb.p;
      paramLayoutParams.l = localb.q;
      paramLayoutParams.m = localb.r;
      paramLayoutParams.n = localb.s;
      paramLayoutParams.o = localb.t;
      paramLayoutParams.s = localb.u;
      paramLayoutParams.t = localb.v;
      paramLayoutParams.u = localb.w;
      paramLayoutParams.v = localb.x;
      paramLayoutParams.leftMargin = localb.H;
      paramLayoutParams.rightMargin = localb.I;
      paramLayoutParams.topMargin = localb.J;
      paramLayoutParams.bottomMargin = localb.K;
      paramLayoutParams.A = localb.T;
      paramLayoutParams.B = localb.S;
      paramLayoutParams.x = localb.P;
      paramLayoutParams.z = localb.R;
      paramLayoutParams.G = localb.y;
      paramLayoutParams.H = localb.z;
      paramLayoutParams.p = localb.B;
      paramLayoutParams.q = localb.C;
      paramLayoutParams.r = localb.D;
      paramLayoutParams.I = localb.A;
      paramLayoutParams.X = localb.E;
      paramLayoutParams.Y = localb.F;
      paramLayoutParams.M = localb.V;
      paramLayoutParams.L = localb.W;
      paramLayoutParams.O = localb.Y;
      paramLayoutParams.N = localb.X;
      paramLayoutParams.a0 = localb.n0;
      paramLayoutParams.b0 = localb.o0;
      paramLayoutParams.P = localb.Z;
      paramLayoutParams.Q = localb.a0;
      paramLayoutParams.T = localb.b0;
      paramLayoutParams.U = localb.c0;
      paramLayoutParams.R = localb.d0;
      paramLayoutParams.S = localb.e0;
      paramLayoutParams.V = localb.f0;
      paramLayoutParams.W = localb.g0;
      paramLayoutParams.Z = localb.G;
      paramLayoutParams.c = localb.h;
      paramLayoutParams.a = localb.f;
      paramLayoutParams.b = localb.g;
      paramLayoutParams.width = localb.d;
      paramLayoutParams.height = localb.e;
      String str = localb.m0;
      if (str != null) {
        paramLayoutParams.c0 = str;
      }
      paramLayoutParams.d0 = localb.q0;
      paramLayoutParams.setMarginStart(localb.M);
      paramLayoutParams.setMarginEnd(this.e.L);
      paramLayoutParams.c();
    }
    
    public a f()
    {
      a locala = new a();
      locala.e.a(this.e);
      locala.d.a(this.d);
      locala.c.a(this.c);
      locala.f.a(this.f);
      locala.a = this.a;
      locala.h = this.h;
      return locala;
    }
    
    static class a
    {
      int[] a = new int[10];
      int[] b = new int[10];
      int c = 0;
      int[] d = new int[10];
      float[] e = new float[10];
      int f = 0;
      int[] g = new int[5];
      String[] h = new String[5];
      int i = 0;
      int[] j = new int[4];
      boolean[] k = new boolean[4];
      int l = 0;
      
      void a(int paramInt, float paramFloat)
      {
        int m = this.f;
        Object localObject = this.d;
        if (m >= localObject.length)
        {
          this.d = Arrays.copyOf((int[])localObject, localObject.length * 2);
          localObject = this.e;
          this.e = Arrays.copyOf((float[])localObject, localObject.length * 2);
        }
        localObject = this.d;
        m = this.f;
        localObject[m] = paramInt;
        localObject = this.e;
        this.f = (m + 1);
        localObject[m] = paramFloat;
      }
      
      void b(int paramInt1, int paramInt2)
      {
        int m = this.c;
        int[] arrayOfInt = this.a;
        if (m >= arrayOfInt.length)
        {
          this.a = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
          arrayOfInt = this.b;
          this.b = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
        }
        arrayOfInt = this.a;
        m = this.c;
        arrayOfInt[m] = paramInt1;
        arrayOfInt = this.b;
        this.c = (m + 1);
        arrayOfInt[m] = paramInt2;
      }
      
      void c(int paramInt, String paramString)
      {
        int m = this.i;
        Object localObject = this.g;
        if (m >= localObject.length)
        {
          this.g = Arrays.copyOf((int[])localObject, localObject.length * 2);
          localObject = this.h;
          this.h = ((String[])Arrays.copyOf((Object[])localObject, localObject.length * 2));
        }
        localObject = this.g;
        m = this.i;
        localObject[m] = paramInt;
        localObject = this.h;
        this.i = (m + 1);
        localObject[m] = paramString;
      }
      
      void d(int paramInt, boolean paramBoolean)
      {
        int m = this.l;
        Object localObject = this.j;
        if (m >= localObject.length)
        {
          this.j = Arrays.copyOf((int[])localObject, localObject.length * 2);
          localObject = this.k;
          this.k = Arrays.copyOf((boolean[])localObject, localObject.length * 2);
        }
        localObject = this.j;
        m = this.l;
        localObject[m] = paramInt;
        localObject = this.k;
        this.l = (m + 1);
        localObject[m] = paramBoolean;
      }
      
      void e(c.a parama)
      {
        int i1 = 0;
        int m = 0;
        while (m < this.c)
        {
          c.c(parama, this.a[m], this.b[m]);
          m += 1;
        }
        m = 0;
        while (m < this.f)
        {
          c.d(parama, this.d[m], this.e[m]);
          m += 1;
        }
        m = 0;
        int n;
        for (;;)
        {
          n = i1;
          if (m >= this.i) {
            break;
          }
          c.e(parama, this.g[m], this.h[m]);
          m += 1;
        }
        while (n < this.l)
        {
          c.f(parama, this.j[n], this.k[n]);
          n += 1;
        }
      }
    }
  }
  
  public static class b
  {
    private static SparseIntArray r0;
    public String A = null;
    public int B = -1;
    public int C = 0;
    public float D = 0.0F;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = -2147483648;
    public int P = -2147483648;
    public int Q = -2147483648;
    public int R = -2147483648;
    public int S = -2147483648;
    public int T = -2147483648;
    public int U = -2147483648;
    public float V = -1.0F;
    public float W = -1.0F;
    public int X = 0;
    public int Y = 0;
    public int Z = 0;
    public boolean a = false;
    public int a0 = 0;
    public boolean b = false;
    public int b0 = 0;
    public boolean c = false;
    public int c0 = 0;
    public int d;
    public int d0 = 0;
    public int e;
    public int e0 = 0;
    public int f = -1;
    public float f0 = 1.0F;
    public int g = -1;
    public float g0 = 1.0F;
    public float h = -1.0F;
    public int h0 = -1;
    public boolean i = true;
    public int i0 = 0;
    public int j = -1;
    public int j0 = -1;
    public int k = -1;
    public int[] k0;
    public int l = -1;
    public String l0;
    public int m = -1;
    public String m0;
    public int n = -1;
    public boolean n0 = false;
    public int o = -1;
    public boolean o0 = false;
    public int p = -1;
    public boolean p0 = true;
    public int q = -1;
    public int q0 = 0;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public float y = 0.5F;
    public float z = 0.5F;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      r0 = localSparseIntArray;
      localSparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
      r0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
      r0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
      r0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
      r0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
      r0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
      r0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
      r0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
      r0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
      r0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
      r0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
      r0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
      r0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
      r0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
      r0.append(R.styleable.Layout_guidelineUseRtl, 90);
      r0.append(R.styleable.Layout_android_orientation, 26);
      r0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
      r0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
      r0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
      r0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
      r0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
      r0.append(R.styleable.Layout_layout_goneMarginTop, 16);
      r0.append(R.styleable.Layout_layout_goneMarginRight, 14);
      r0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
      r0.append(R.styleable.Layout_layout_goneMarginStart, 15);
      r0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
      r0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
      r0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
      r0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
      r0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
      r0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
      r0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
      r0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
      r0.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
      r0.append(R.styleable.Layout_layout_constraintTop_creator, 91);
      r0.append(R.styleable.Layout_layout_constraintRight_creator, 91);
      r0.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
      r0.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
      r0.append(R.styleable.Layout_android_layout_marginLeft, 23);
      r0.append(R.styleable.Layout_android_layout_marginRight, 27);
      r0.append(R.styleable.Layout_android_layout_marginStart, 30);
      r0.append(R.styleable.Layout_android_layout_marginEnd, 8);
      r0.append(R.styleable.Layout_android_layout_marginTop, 33);
      r0.append(R.styleable.Layout_android_layout_marginBottom, 2);
      r0.append(R.styleable.Layout_android_layout_width, 22);
      r0.append(R.styleable.Layout_android_layout_height, 21);
      r0.append(R.styleable.Layout_layout_constraintWidth, 41);
      r0.append(R.styleable.Layout_layout_constraintHeight, 42);
      r0.append(R.styleable.Layout_layout_constrainedWidth, 41);
      r0.append(R.styleable.Layout_layout_constrainedHeight, 42);
      r0.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
      r0.append(R.styleable.Layout_layout_constraintCircle, 61);
      r0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
      r0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
      r0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
      r0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
      r0.append(R.styleable.Layout_chainUseRtl, 71);
      r0.append(R.styleable.Layout_barrierDirection, 72);
      r0.append(R.styleable.Layout_barrierMargin, 73);
      r0.append(R.styleable.Layout_constraint_referenced_ids, 74);
      r0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
    }
    
    public void a(b paramb)
    {
      this.a = paramb.a;
      this.d = paramb.d;
      this.b = paramb.b;
      this.e = paramb.e;
      this.f = paramb.f;
      this.g = paramb.g;
      this.h = paramb.h;
      this.i = paramb.i;
      this.j = paramb.j;
      this.k = paramb.k;
      this.l = paramb.l;
      this.m = paramb.m;
      this.n = paramb.n;
      this.o = paramb.o;
      this.p = paramb.p;
      this.q = paramb.q;
      this.r = paramb.r;
      this.s = paramb.s;
      this.t = paramb.t;
      this.u = paramb.u;
      this.v = paramb.v;
      this.w = paramb.w;
      this.x = paramb.x;
      this.y = paramb.y;
      this.z = paramb.z;
      this.A = paramb.A;
      this.B = paramb.B;
      this.C = paramb.C;
      this.D = paramb.D;
      this.E = paramb.E;
      this.F = paramb.F;
      this.G = paramb.G;
      this.H = paramb.H;
      this.I = paramb.I;
      this.J = paramb.J;
      this.K = paramb.K;
      this.L = paramb.L;
      this.M = paramb.M;
      this.N = paramb.N;
      this.O = paramb.O;
      this.P = paramb.P;
      this.Q = paramb.Q;
      this.R = paramb.R;
      this.S = paramb.S;
      this.T = paramb.T;
      this.U = paramb.U;
      this.V = paramb.V;
      this.W = paramb.W;
      this.X = paramb.X;
      this.Y = paramb.Y;
      this.Z = paramb.Z;
      this.a0 = paramb.a0;
      this.b0 = paramb.b0;
      this.c0 = paramb.c0;
      this.d0 = paramb.d0;
      this.e0 = paramb.e0;
      this.f0 = paramb.f0;
      this.g0 = paramb.g0;
      this.h0 = paramb.h0;
      this.i0 = paramb.i0;
      this.j0 = paramb.j0;
      this.m0 = paramb.m0;
      int[] arrayOfInt = paramb.k0;
      if ((arrayOfInt != null) && (paramb.l0 == null)) {
        this.k0 = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
      } else {
        this.k0 = null;
      }
      this.l0 = paramb.l0;
      this.n0 = paramb.n0;
      this.o0 = paramb.o0;
      this.p0 = paramb.p0;
      this.q0 = paramb.q0;
    }
    
    void b(Context paramContext, AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Layout);
      this.b = true;
      int i2 = localTypedArray.getIndexCount();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = localTypedArray.getIndex(i1);
        int i4 = r0.get(i3);
        switch (i4)
        {
        default: 
          switch (i4)
          {
          default: 
            switch (i4)
            {
            default: 
              paramContext = new StringBuilder();
            case 91: 
              for (paramAttributeSet = "Unknown attribute 0x";; paramAttributeSet = "unused attribute 0x")
              {
                paramContext.append(paramAttributeSet);
                paramContext.append(Integer.toHexString(i3));
                paramContext.append("   ");
                paramContext.append(r0.get(i3));
                Log.w("ConstraintSet", paramContext.toString());
                break;
                paramContext = new StringBuilder();
              }
            case 90: 
              this.i = localTypedArray.getBoolean(i3, this.i);
              break;
            case 89: 
              this.m0 = localTypedArray.getString(i3);
              break;
            case 88: 
              this.o0 = localTypedArray.getBoolean(i3, this.o0);
              break;
            case 87: 
              this.n0 = localTypedArray.getBoolean(i3, this.n0);
              break;
            case 86: 
              this.d0 = localTypedArray.getDimensionPixelSize(i3, this.d0);
              break;
            case 85: 
              this.e0 = localTypedArray.getDimensionPixelSize(i3, this.e0);
              break;
            case 84: 
              this.b0 = localTypedArray.getDimensionPixelSize(i3, this.b0);
              break;
            case 83: 
              this.c0 = localTypedArray.getDimensionPixelSize(i3, this.c0);
              break;
            case 82: 
              this.a0 = localTypedArray.getInt(i3, this.a0);
              break;
            case 81: 
              this.Z = localTypedArray.getInt(i3, this.Z);
              break;
            case 80: 
              this.N = localTypedArray.getDimensionPixelSize(i3, this.N);
              break;
            case 79: 
              this.U = localTypedArray.getDimensionPixelSize(i3, this.U);
              break;
            case 78: 
              this.t = c.a(localTypedArray, i3, this.t);
              break;
            case 77: 
              this.s = c.a(localTypedArray, i3, this.s);
              break;
            case 76: 
              this.q0 = localTypedArray.getInt(i3, this.q0);
              break;
            case 75: 
              this.p0 = localTypedArray.getBoolean(i3, this.p0);
              break;
            case 74: 
              this.l0 = localTypedArray.getString(i3);
              break;
            case 73: 
              this.i0 = localTypedArray.getDimensionPixelSize(i3, this.i0);
              break;
            case 72: 
              this.h0 = localTypedArray.getInt(i3, this.h0);
              break;
            case 71: 
              Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
              break;
            case 70: 
              this.g0 = localTypedArray.getFloat(i3, 1.0F);
              break;
            case 69: 
              this.f0 = localTypedArray.getFloat(i3, 1.0F);
            }
            break;
          case 63: 
            this.D = localTypedArray.getFloat(i3, this.D);
            break;
          case 62: 
            this.C = localTypedArray.getDimensionPixelSize(i3, this.C);
            break;
          case 61: 
            this.B = c.a(localTypedArray, i3, this.B);
          }
          break;
        case 42: 
          c.G(this, localTypedArray, i3, 1);
          break;
        case 41: 
          c.G(this, localTypedArray, i3, 0);
          break;
        case 40: 
          this.Y = localTypedArray.getInt(i3, this.Y);
          break;
        case 39: 
          this.X = localTypedArray.getInt(i3, this.X);
          break;
        case 38: 
          this.V = localTypedArray.getFloat(i3, this.V);
          break;
        case 37: 
          this.W = localTypedArray.getFloat(i3, this.W);
          break;
        case 36: 
          this.z = localTypedArray.getFloat(i3, this.z);
          break;
        case 35: 
          this.n = c.a(localTypedArray, i3, this.n);
          break;
        case 34: 
          this.o = c.a(localTypedArray, i3, this.o);
          break;
        case 33: 
          this.J = localTypedArray.getDimensionPixelSize(i3, this.J);
          break;
        case 32: 
          this.v = c.a(localTypedArray, i3, this.v);
          break;
        case 31: 
          this.u = c.a(localTypedArray, i3, this.u);
          break;
        case 30: 
          this.M = localTypedArray.getDimensionPixelSize(i3, this.M);
          break;
        case 29: 
          this.m = c.a(localTypedArray, i3, this.m);
          break;
        case 28: 
          this.l = c.a(localTypedArray, i3, this.l);
          break;
        case 27: 
          this.I = localTypedArray.getDimensionPixelSize(i3, this.I);
          break;
        case 26: 
          this.G = localTypedArray.getInt(i3, this.G);
          break;
        case 25: 
          this.k = c.a(localTypedArray, i3, this.k);
          break;
        case 24: 
          this.j = c.a(localTypedArray, i3, this.j);
          break;
        case 23: 
          this.H = localTypedArray.getDimensionPixelSize(i3, this.H);
          break;
        case 22: 
          this.d = localTypedArray.getLayoutDimension(i3, this.d);
          break;
        case 21: 
          this.e = localTypedArray.getLayoutDimension(i3, this.e);
          break;
        case 20: 
          this.y = localTypedArray.getFloat(i3, this.y);
          break;
        case 19: 
          this.h = localTypedArray.getFloat(i3, this.h);
          break;
        case 18: 
          this.g = localTypedArray.getDimensionPixelOffset(i3, this.g);
          break;
        case 17: 
          this.f = localTypedArray.getDimensionPixelOffset(i3, this.f);
          break;
        case 16: 
          this.P = localTypedArray.getDimensionPixelSize(i3, this.P);
          break;
        case 15: 
          this.T = localTypedArray.getDimensionPixelSize(i3, this.T);
          break;
        case 14: 
          this.Q = localTypedArray.getDimensionPixelSize(i3, this.Q);
          break;
        case 13: 
          this.O = localTypedArray.getDimensionPixelSize(i3, this.O);
          break;
        case 12: 
          this.S = localTypedArray.getDimensionPixelSize(i3, this.S);
          break;
        case 11: 
          this.R = localTypedArray.getDimensionPixelSize(i3, this.R);
          break;
        case 10: 
          this.w = c.a(localTypedArray, i3, this.w);
          break;
        case 9: 
          this.x = c.a(localTypedArray, i3, this.x);
          break;
        case 8: 
          this.L = localTypedArray.getDimensionPixelSize(i3, this.L);
          break;
        case 7: 
          this.F = localTypedArray.getDimensionPixelOffset(i3, this.F);
          break;
        case 6: 
          this.E = localTypedArray.getDimensionPixelOffset(i3, this.E);
          break;
        case 5: 
          this.A = localTypedArray.getString(i3);
          break;
        case 4: 
          this.p = c.a(localTypedArray, i3, this.p);
          break;
        case 3: 
          this.q = c.a(localTypedArray, i3, this.q);
          break;
        case 2: 
          this.K = localTypedArray.getDimensionPixelSize(i3, this.K);
          break;
        case 1: 
          this.r = c.a(localTypedArray, i3, this.r);
        }
        i1 += 1;
      }
      localTypedArray.recycle();
    }
  }
  
  public static class c
  {
    private static SparseIntArray o;
    public boolean a = false;
    public int b = -1;
    public int c = 0;
    public String d = null;
    public int e = -1;
    public int f = 0;
    public float g = (0.0F / 0.0F);
    public int h = -1;
    public float i = (0.0F / 0.0F);
    public float j = (0.0F / 0.0F);
    public int k = -1;
    public String l = null;
    public int m = -3;
    public int n = -1;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      o = localSparseIntArray;
      localSparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
      o.append(R.styleable.Motion_pathMotionArc, 2);
      o.append(R.styleable.Motion_transitionEasing, 3);
      o.append(R.styleable.Motion_drawPath, 4);
      o.append(R.styleable.Motion_animateRelativeTo, 5);
      o.append(R.styleable.Motion_animateCircleAngleTo, 6);
      o.append(R.styleable.Motion_motionStagger, 7);
      o.append(R.styleable.Motion_quantizeMotionSteps, 8);
      o.append(R.styleable.Motion_quantizeMotionPhase, 9);
      o.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
    }
    
    public void a(c paramc)
    {
      this.a = paramc.a;
      this.b = paramc.b;
      this.d = paramc.d;
      this.e = paramc.e;
      this.f = paramc.f;
      this.i = paramc.i;
      this.g = paramc.g;
      this.h = paramc.h;
    }
    
    void b(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Motion);
      this.a = true;
      int i2 = paramAttributeSet.getIndexCount();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramAttributeSet.getIndex(i1);
        switch (o.get(i3))
        {
        default: 
          break;
        case 10: 
          int i4 = paramAttributeSet.peekValue(i3).type;
          if (i4 == 1)
          {
            i3 = paramAttributeSet.getResourceId(i3, -1);
            this.n = i3;
            if (i3 == -1) {
              break;
            }
          }
          else
          {
            for (;;)
            {
              this.m = -2;
              break label385;
              if (i4 != 3) {
                break label195;
              }
              paramContext = paramAttributeSet.getString(i3);
              this.l = paramContext;
              if (paramContext.indexOf("/") <= 0) {
                break;
              }
              this.n = paramAttributeSet.getResourceId(i3, -1);
            }
            this.m = -1;
            break;
            this.m = paramAttributeSet.getInteger(i3, this.n);
          }
          break;
        case 9: 
          this.j = paramAttributeSet.getFloat(i3, this.j);
          break;
        case 8: 
          this.k = paramAttributeSet.getInteger(i3, this.k);
          break;
        case 7: 
          this.g = paramAttributeSet.getFloat(i3, this.g);
          break;
        case 6: 
          this.c = paramAttributeSet.getInteger(i3, this.c);
          break;
        case 5: 
          this.b = c.a(paramAttributeSet, i3, this.b);
          break;
        case 4: 
          this.f = paramAttributeSet.getInt(i3, 0);
          break;
        case 3: 
          if (paramAttributeSet.peekValue(i3).type == 3) {
            paramContext = paramAttributeSet.getString(i3);
          } else {
            paramContext = i0.c.c[paramAttributeSet.getInteger(i3, 0)];
          }
          this.d = paramContext;
          break;
        case 2: 
          this.e = paramAttributeSet.getInt(i3, this.e);
          break;
        case 1: 
          label195:
          this.i = paramAttributeSet.getFloat(i3, this.i);
        }
        label385:
        i1 += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public static class d
  {
    public boolean a = false;
    public int b = 0;
    public int c = 0;
    public float d = 1.0F;
    public float e = (0.0F / 0.0F);
    
    public void a(d paramd)
    {
      this.a = paramd.a;
      this.b = paramd.b;
      this.d = paramd.d;
      this.e = paramd.e;
      this.c = paramd.c;
    }
    
    void b(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PropertySet);
      this.a = true;
      int j = paramContext.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.PropertySet_android_alpha)
        {
          this.d = paramContext.getFloat(k, this.d);
        }
        else if (k == R.styleable.PropertySet_android_visibility)
        {
          this.b = paramContext.getInt(k, this.b);
          this.b = c.b()[this.b];
        }
        else if (k == R.styleable.PropertySet_visibilityMode)
        {
          this.c = paramContext.getInt(k, this.c);
        }
        else if (k == R.styleable.PropertySet_motionProgress)
        {
          this.e = paramContext.getFloat(k, this.e);
        }
        i += 1;
      }
      paramContext.recycle();
    }
  }
  
  public static class e
  {
    private static SparseIntArray o;
    public boolean a = false;
    public float b = 0.0F;
    public float c = 0.0F;
    public float d = 0.0F;
    public float e = 1.0F;
    public float f = 1.0F;
    public float g = (0.0F / 0.0F);
    public float h = (0.0F / 0.0F);
    public int i = -1;
    public float j = 0.0F;
    public float k = 0.0F;
    public float l = 0.0F;
    public boolean m = false;
    public float n = 0.0F;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      o = localSparseIntArray;
      localSparseIntArray.append(R.styleable.Transform_android_rotation, 1);
      o.append(R.styleable.Transform_android_rotationX, 2);
      o.append(R.styleable.Transform_android_rotationY, 3);
      o.append(R.styleable.Transform_android_scaleX, 4);
      o.append(R.styleable.Transform_android_scaleY, 5);
      o.append(R.styleable.Transform_android_transformPivotX, 6);
      o.append(R.styleable.Transform_android_transformPivotY, 7);
      o.append(R.styleable.Transform_android_translationX, 8);
      o.append(R.styleable.Transform_android_translationY, 9);
      o.append(R.styleable.Transform_android_translationZ, 10);
      o.append(R.styleable.Transform_android_elevation, 11);
      o.append(R.styleable.Transform_transformPivotTarget, 12);
    }
    
    public void a(e parame)
    {
      this.a = parame.a;
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
      this.e = parame.e;
      this.f = parame.f;
      this.g = parame.g;
      this.h = parame.h;
      this.i = parame.i;
      this.j = parame.j;
      this.k = parame.k;
      this.l = parame.l;
      this.m = parame.m;
      this.n = parame.n;
    }
    
    void b(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Transform);
      this.a = true;
      int i2 = paramContext.getIndexCount();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramContext.getIndex(i1);
        switch (o.get(i3))
        {
        default: 
          break;
        case 12: 
          this.i = c.a(paramContext, i3, this.i);
          break;
        case 11: 
          this.m = true;
          this.n = paramContext.getDimension(i3, this.n);
          break;
        case 10: 
          this.l = paramContext.getDimension(i3, this.l);
          break;
        case 9: 
          this.k = paramContext.getDimension(i3, this.k);
          break;
        case 8: 
          this.j = paramContext.getDimension(i3, this.j);
          break;
        case 7: 
          this.h = paramContext.getDimension(i3, this.h);
          break;
        case 6: 
          this.g = paramContext.getDimension(i3, this.g);
          break;
        case 5: 
          this.f = paramContext.getFloat(i3, this.f);
          break;
        case 4: 
          this.e = paramContext.getFloat(i3, this.e);
          break;
        case 3: 
          this.d = paramContext.getFloat(i3, this.d);
          break;
        case 2: 
          this.c = paramContext.getFloat(i3, this.c);
          break;
        case 1: 
          this.b = paramContext.getFloat(i3, this.b);
        }
        i1 += 1;
      }
      paramContext.recycle();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.c
 * JD-Core Version:    0.7.0.1
 */