package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c.a;
import androidx.constraintlayout.widget.c.c;
import androidx.constraintlayout.widget.c.d;
import androidx.constraintlayout.widget.c.e;
import i0.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import n0.d;
import n0.d.b;

class l
  implements Comparable<l>
{
  static String[] E = { "position", "x", "y", "width", "height", "pathRotate" };
  int A = 0;
  double[] B = new double[18];
  double[] C = new double[18];
  private float a = 1.0F;
  int b = 0;
  int c;
  private boolean d = false;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  public float h = 0.0F;
  private float i = 1.0F;
  private float j = 1.0F;
  private float k = (0.0F / 0.0F);
  private float l = (0.0F / 0.0F);
  private float m = 0.0F;
  private float n = 0.0F;
  private float o = 0.0F;
  private i0.c p;
  private int q = 0;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w = (0.0F / 0.0F);
  private float x = (0.0F / 0.0F);
  private int y = -1;
  LinkedHashMap<String, a> z = new LinkedHashMap();
  
  private boolean e(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat1 - paramFloat2) > 1.0E-006F;
    }
    return Float.isNaN(paramFloat1) != Float.isNaN(paramFloat2);
  }
  
  public void a(HashMap<String, d> paramHashMap, int paramInt)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = (d)paramHashMap.get(str);
      str.hashCode();
      int i1 = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 92909918: 
        if (str.equals("alpha")) {
          i1 = 13;
        }
        break;
      case 37232917: 
        if (str.equals("transitionPathRotate")) {
          i1 = 12;
        }
        break;
      case -4379043: 
        if (str.equals("elevation")) {
          i1 = 11;
        }
        break;
      case -40300674: 
        if (str.equals("rotation")) {
          i1 = 10;
        }
        break;
      case -760884509: 
        if (str.equals("transformPivotY")) {
          i1 = 9;
        }
        break;
      case -760884510: 
        if (str.equals("transformPivotX")) {
          i1 = 8;
        }
        break;
      case -908189617: 
        if (str.equals("scaleY")) {
          i1 = 7;
        }
        break;
      case -908189618: 
        if (str.equals("scaleX")) {
          i1 = 6;
        }
        break;
      case -1001078227: 
        if (str.equals("progress")) {
          i1 = 5;
        }
        break;
      case -1225497655: 
        if (str.equals("translationZ")) {
          i1 = 4;
        }
        break;
      case -1225497656: 
        if (str.equals("translationY")) {
          i1 = 3;
        }
        break;
      case -1225497657: 
        if (str.equals("translationX")) {
          i1 = 2;
        }
        break;
      case -1249320805: 
        if (str.equals("rotationY")) {
          i1 = 1;
        }
        break;
      case -1249320806: 
        if (str.equals("rotationX")) {
          i1 = 0;
        }
        break;
      }
      float f1 = 1.0F;
      float f2 = 0.0F;
      switch (i1)
      {
      default: 
        StringBuilder localStringBuilder;
        if (str.startsWith("CUSTOM"))
        {
          Object localObject2 = str.split(",")[1];
          if (this.z.containsKey(localObject2))
          {
            localObject2 = (a)this.z.get(localObject2);
            if ((localObject1 instanceof d.b))
            {
              ((d.b)localObject1).i(paramInt, (a)localObject2);
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(str);
              localStringBuilder.append(" ViewSpline not a CustomSet frame = ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", value");
              localStringBuilder.append(((a)localObject2).e());
              localStringBuilder.append(localObject1);
            }
          }
        }
        else
        {
          for (str = localStringBuilder.toString();; str = ((StringBuilder)localObject1).toString())
          {
            Log.e("MotionPaths", str);
            break;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("UNKNOWN spline ");
            ((StringBuilder)localObject1).append(str);
          }
        }
        break;
      case 13: 
        if (!Float.isNaN(this.a)) {
          f1 = this.a;
        }
        ((j)localObject1).c(paramInt, f1);
        break;
      case 12: 
        if (Float.isNaN(this.w)) {
          f1 = f2;
        } else {
          f1 = this.w;
        }
        break;
      case 11: 
        if (Float.isNaN(this.e)) {
          f1 = f2;
        } else {
          f1 = this.e;
        }
      case 10: 
      case 9: 
      case 8: 
      case 7: 
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
      case 1: 
      case 0: 
        for (;;)
        {
          label731:
          ((j)localObject1).c(paramInt, f1);
          break;
          if (Float.isNaN(this.f))
          {
            f1 = f2;
          }
          else
          {
            f1 = this.f;
            continue;
            if (Float.isNaN(this.l))
            {
              f1 = f2;
            }
            else
            {
              f1 = this.l;
              continue;
              if (Float.isNaN(this.k))
              {
                f1 = f2;
              }
              else
              {
                f1 = this.k;
                continue;
                if (Float.isNaN(this.j)) {
                  break label731;
                }
                f1 = this.j;
                break label731;
                if (Float.isNaN(this.i)) {
                  break label731;
                }
                f1 = this.i;
                break label731;
                if (Float.isNaN(this.x))
                {
                  f1 = f2;
                }
                else
                {
                  f1 = this.x;
                  continue;
                  if (Float.isNaN(this.o))
                  {
                    f1 = f2;
                  }
                  else
                  {
                    f1 = this.o;
                    continue;
                    if (Float.isNaN(this.n))
                    {
                      f1 = f2;
                    }
                    else
                    {
                      f1 = this.n;
                      continue;
                      if (Float.isNaN(this.m))
                      {
                        f1 = f2;
                      }
                      else
                      {
                        f1 = this.m;
                        continue;
                        if (Float.isNaN(this.h))
                        {
                          f1 = f2;
                        }
                        else
                        {
                          f1 = this.h;
                          continue;
                          if (Float.isNaN(this.g)) {
                            f1 = f2;
                          } else {
                            f1 = this.g;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void b(View paramView)
  {
    this.c = paramView.getVisibility();
    float f1;
    if (paramView.getVisibility() != 0) {
      f1 = 0.0F;
    } else {
      f1 = paramView.getAlpha();
    }
    this.a = f1;
    this.d = false;
    this.e = paramView.getElevation();
    this.f = paramView.getRotation();
    this.g = paramView.getRotationX();
    this.h = paramView.getRotationY();
    this.i = paramView.getScaleX();
    this.j = paramView.getScaleY();
    this.k = paramView.getPivotX();
    this.l = paramView.getPivotY();
    this.m = paramView.getTranslationX();
    this.n = paramView.getTranslationY();
    this.o = paramView.getTranslationZ();
  }
  
  public void c(c.a parama)
  {
    Object localObject = parama.c;
    int i1 = ((c.d)localObject).c;
    this.b = i1;
    int i2 = ((c.d)localObject).b;
    this.c = i2;
    float f1;
    if ((i2 != 0) && (i1 == 0)) {
      f1 = 0.0F;
    } else {
      f1 = ((c.d)localObject).d;
    }
    this.a = f1;
    localObject = parama.f;
    this.d = ((c.e)localObject).m;
    this.e = ((c.e)localObject).n;
    this.f = ((c.e)localObject).b;
    this.g = ((c.e)localObject).c;
    this.h = ((c.e)localObject).d;
    this.i = ((c.e)localObject).e;
    this.j = ((c.e)localObject).f;
    this.k = ((c.e)localObject).g;
    this.l = ((c.e)localObject).h;
    this.m = ((c.e)localObject).j;
    this.n = ((c.e)localObject).k;
    this.o = ((c.e)localObject).l;
    this.p = i0.c.c(parama.d.d);
    localObject = parama.d;
    this.w = ((c.c)localObject).i;
    this.q = ((c.c)localObject).f;
    this.y = ((c.c)localObject).b;
    this.x = parama.c.e;
    localObject = parama.g.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      a locala = (a)parama.g.get(str);
      if (locala.g()) {
        this.z.put(str, locala);
      }
    }
  }
  
  public int d(l paraml)
  {
    return Float.compare(this.r, paraml.r);
  }
  
  void f(l paraml, HashSet<String> paramHashSet)
  {
    if (e(this.a, paraml.a)) {
      paramHashSet.add("alpha");
    }
    if (e(this.e, paraml.e)) {
      paramHashSet.add("elevation");
    }
    int i1 = this.c;
    int i2 = paraml.c;
    if ((i1 != i2) && (this.b == 0) && ((i1 == 0) || (i2 == 0))) {
      paramHashSet.add("alpha");
    }
    if (e(this.f, paraml.f)) {
      paramHashSet.add("rotation");
    }
    if ((!Float.isNaN(this.w)) || (!Float.isNaN(paraml.w))) {
      paramHashSet.add("transitionPathRotate");
    }
    if ((!Float.isNaN(this.x)) || (!Float.isNaN(paraml.x))) {
      paramHashSet.add("progress");
    }
    if (e(this.g, paraml.g)) {
      paramHashSet.add("rotationX");
    }
    if (e(this.h, paraml.h)) {
      paramHashSet.add("rotationY");
    }
    if (e(this.k, paraml.k)) {
      paramHashSet.add("transformPivotX");
    }
    if (e(this.l, paraml.l)) {
      paramHashSet.add("transformPivotY");
    }
    if (e(this.i, paraml.i)) {
      paramHashSet.add("scaleX");
    }
    if (e(this.j, paraml.j)) {
      paramHashSet.add("scaleY");
    }
    if (e(this.m, paraml.m)) {
      paramHashSet.add("translationX");
    }
    if (e(this.n, paraml.n)) {
      paramHashSet.add("translationY");
    }
    if (e(this.o, paraml.o)) {
      paramHashSet.add("translationZ");
    }
  }
  
  void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.s = paramFloat1;
    this.t = paramFloat2;
    this.u = paramFloat3;
    this.v = paramFloat4;
  }
  
  public void h(Rect paramRect, View paramView, int paramInt, float paramFloat)
  {
    g(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    b(paramView);
    this.k = (0.0F / 0.0F);
    this.l = (0.0F / 0.0F);
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      paramFloat += 90.0F;
    }
    else
    {
      paramFloat -= 90.0F;
    }
    this.f = paramFloat;
  }
  
  public void i(Rect paramRect, androidx.constraintlayout.widget.c paramc, int paramInt1, int paramInt2)
  {
    g(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    c(paramc.z(paramInt2));
    float f2 = 90.0F;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          break label93;
        }
        if (paramInt1 != 4) {
          return;
        }
      }
      f1 = this.f + 90.0F;
      this.f = f1;
      if (f1 <= 180.0F) {
        return;
      }
      f2 = 360.0F;
      break label99;
    }
    label93:
    float f1 = this.f;
    label99:
    this.f = (f1 - f2);
  }
  
  public void j(View paramView)
  {
    g(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    b(paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.l
 * JD-Core Version:    0.7.0.1
 */