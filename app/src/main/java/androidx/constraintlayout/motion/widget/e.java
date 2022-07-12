package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.a;
import i0.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n0.d.b;

public class e
  extends d
{
  private String g;
  private int h = -1;
  private boolean i = false;
  private float j = (0.0F / 0.0F);
  private float k = (0.0F / 0.0F);
  private float l = (0.0F / 0.0F);
  private float m = (0.0F / 0.0F);
  private float n = (0.0F / 0.0F);
  private float o = (0.0F / 0.0F);
  private float p = (0.0F / 0.0F);
  private float q = (0.0F / 0.0F);
  private float r = (0.0F / 0.0F);
  private float s = (0.0F / 0.0F);
  private float t = (0.0F / 0.0F);
  private float u = (0.0F / 0.0F);
  private float v = (0.0F / 0.0F);
  private float w = (0.0F / 0.0F);
  
  public e()
  {
    this.d = 1;
    this.e = new HashMap();
  }
  
  public void R(String paramString, Object paramObject)
  {
    paramString.hashCode();
    int i2 = paramString.hashCode();
    int i1 = -1;
    switch (i2)
    {
    default: 
      break;
    case 1941332754: 
      if (paramString.equals("visibility")) {
        i1 = 16;
      }
      break;
    case 579057826: 
      if (paramString.equals("curveFit")) {
        i1 = 15;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i1 = 14;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i1 = 13;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i1 = 12;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i1 = 11;
      }
      break;
    case -760884509: 
      if (paramString.equals("transformPivotY")) {
        i1 = 10;
      }
      break;
    case -760884510: 
      if (paramString.equals("transformPivotX")) {
        i1 = 9;
      }
      break;
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i1 = 8;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i1 = 7;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i1 = 6;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i1 = 5;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i1 = 4;
      }
      break;
    case -1249320805: 
      if (paramString.equals("rotationY")) {
        i1 = 3;
      }
      break;
    case -1249320806: 
      if (paramString.equals("rotationX")) {
        i1 = 2;
      }
      break;
    case -1812823328: 
      if (paramString.equals("transitionEasing")) {
        i1 = 1;
      }
      break;
    case -1913008125: 
      if (paramString.equals("motionProgress")) {
        i1 = 0;
      }
      break;
    }
    switch (i1)
    {
    default: 
      return;
    case 16: 
      this.i = j(paramObject);
      return;
    case 15: 
      this.h = l(paramObject);
      return;
    case 14: 
      this.j = k(paramObject);
      return;
    case 13: 
      this.q = k(paramObject);
      return;
    case 12: 
      this.k = k(paramObject);
      return;
    case 11: 
      this.l = k(paramObject);
      return;
    case 10: 
      this.p = k(paramObject);
      return;
    case 9: 
      this.o = k(paramObject);
      return;
    case 8: 
      this.s = k(paramObject);
      return;
    case 7: 
      this.r = k(paramObject);
      return;
    case 6: 
      this.v = k(paramObject);
      return;
    case 5: 
      this.u = k(paramObject);
      return;
    case 4: 
      this.t = k(paramObject);
      return;
    case 3: 
      this.n = k(paramObject);
      return;
    case 2: 
      this.m = k(paramObject);
      return;
    case 1: 
      this.g = paramObject.toString();
      return;
    }
    this.w = k(paramObject);
  }
  
  public void a(HashMap<String, n0.d> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = (j)paramHashMap.get(localObject);
      if (localj != null)
      {
        boolean bool = ((String)localObject).startsWith("CUSTOM");
        int i1 = 7;
        if (bool)
        {
          localObject = ((String)localObject).substring(7);
          localObject = (a)this.e.get(localObject);
          if (localObject != null) {
            ((d.b)localj).i(this.a, (a)localObject);
          }
        }
        else
        {
          switch (((String)localObject).hashCode())
          {
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    i1 = -1;
                                    break;
                                  } while (!((String)localObject).equals("alpha"));
                                  i1 = 13;
                                  break;
                                } while (!((String)localObject).equals("transitionPathRotate"));
                                i1 = 12;
                                break;
                              } while (!((String)localObject).equals("elevation"));
                              i1 = 11;
                              break;
                            } while (!((String)localObject).equals("rotation"));
                            i1 = 10;
                            break;
                          } while (!((String)localObject).equals("transformPivotY"));
                          i1 = 9;
                          break;
                        } while (!((String)localObject).equals("transformPivotX"));
                        i1 = 8;
                        break;
                        if (((String)localObject).equals("scaleY")) {
                          break;
                        }
                      } while ((goto 240) || (!((String)localObject).equals("scaleX")));
                      i1 = 6;
                      break;
                    } while (!((String)localObject).equals("progress"));
                    i1 = 5;
                    break;
                  } while (!((String)localObject).equals("translationZ"));
                  i1 = 4;
                  break;
                } while (!((String)localObject).equals("translationY"));
                i1 = 3;
                break;
              } while (!((String)localObject).equals("translationX"));
              i1 = 2;
              break;
            } while (!((String)localObject).equals("rotationY"));
            i1 = 1;
            break;
          } while (!((String)localObject).equals("rotationX"));
          i1 = 0;
          float f;
          switch (i1)
          {
          default: 
            break;
          case 13: 
            if (!Float.isNaN(this.j))
            {
              i1 = this.a;
              f = this.j;
            }
            break;
          case 12: 
          case 11: 
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
              localj.c(i1, f);
              break;
              if (Float.isNaN(this.q)) {
                break;
              }
              i1 = this.a;
              f = this.q;
              continue;
              if (Float.isNaN(this.k)) {
                break;
              }
              i1 = this.a;
              f = this.k;
              continue;
              if (Float.isNaN(this.l)) {
                break;
              }
              i1 = this.a;
              f = this.l;
              continue;
              if (Float.isNaN(this.n)) {
                break;
              }
              i1 = this.a;
              f = this.p;
              continue;
              if (Float.isNaN(this.m)) {
                break;
              }
              i1 = this.a;
              f = this.o;
              continue;
              if (Float.isNaN(this.s)) {
                break;
              }
              i1 = this.a;
              f = this.s;
              continue;
              if (Float.isNaN(this.r)) {
                break;
              }
              i1 = this.a;
              f = this.r;
              continue;
              if (Float.isNaN(this.w)) {
                break;
              }
              i1 = this.a;
              f = this.w;
              continue;
              if (Float.isNaN(this.v)) {
                break;
              }
              i1 = this.a;
              f = this.v;
              continue;
              if (Float.isNaN(this.u)) {
                break;
              }
              i1 = this.a;
              f = this.u;
              continue;
              if (Float.isNaN(this.t)) {
                break;
              }
              i1 = this.a;
              f = this.t;
              continue;
              if (Float.isNaN(this.n)) {
                break;
              }
              i1 = this.a;
              f = this.n;
              continue;
              if (Float.isNaN(this.m)) {
                break;
              }
              i1 = this.a;
              f = this.m;
            }
          }
        }
      }
    }
  }
  
  public d b()
  {
    return new e().c(this);
  }
  
  public d c(d paramd)
  {
    super.c(paramd);
    paramd = (e)paramd;
    this.h = paramd.h;
    this.i = paramd.i;
    this.j = paramd.j;
    this.k = paramd.k;
    this.l = paramd.l;
    this.m = paramd.m;
    this.n = paramd.n;
    this.o = paramd.o;
    this.p = paramd.p;
    this.q = paramd.q;
    this.r = paramd.r;
    this.s = paramd.s;
    this.t = paramd.t;
    this.u = paramd.u;
    this.v = paramd.v;
    this.w = paramd.w;
    return this;
  }
  
  public void d(HashSet<String> paramHashSet)
  {
    if (!Float.isNaN(this.j)) {
      paramHashSet.add("alpha");
    }
    if (!Float.isNaN(this.k)) {
      paramHashSet.add("elevation");
    }
    if (!Float.isNaN(this.l)) {
      paramHashSet.add("rotation");
    }
    if (!Float.isNaN(this.m)) {
      paramHashSet.add("rotationX");
    }
    if (!Float.isNaN(this.n)) {
      paramHashSet.add("rotationY");
    }
    if (!Float.isNaN(this.o)) {
      paramHashSet.add("transformPivotX");
    }
    if (!Float.isNaN(this.p)) {
      paramHashSet.add("transformPivotY");
    }
    if (!Float.isNaN(this.t)) {
      paramHashSet.add("translationX");
    }
    if (!Float.isNaN(this.u)) {
      paramHashSet.add("translationY");
    }
    if (!Float.isNaN(this.v)) {
      paramHashSet.add("translationZ");
    }
    if (!Float.isNaN(this.q)) {
      paramHashSet.add("transitionPathRotate");
    }
    if (!Float.isNaN(this.r)) {
      paramHashSet.add("scaleX");
    }
    if (!Float.isNaN(this.s)) {
      paramHashSet.add("scaleY");
    }
    if (!Float.isNaN(this.w)) {
      paramHashSet.add("progress");
    }
    if (this.e.size() > 0)
    {
      Iterator localIterator = this.e.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CUSTOM,");
        localStringBuilder.append(str);
        paramHashSet.add(localStringBuilder.toString());
      }
    }
  }
  
  public void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    a.a(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyAttribute));
  }
  
  public void h(HashMap<String, Integer> paramHashMap)
  {
    if (this.h == -1) {
      return;
    }
    if (!Float.isNaN(this.j)) {
      paramHashMap.put("alpha", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.k)) {
      paramHashMap.put("elevation", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.l)) {
      paramHashMap.put("rotation", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.m)) {
      paramHashMap.put("rotationX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.n)) {
      paramHashMap.put("rotationY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.o)) {
      paramHashMap.put("transformPivotX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.p)) {
      paramHashMap.put("transformPivotY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.t)) {
      paramHashMap.put("translationX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.u)) {
      paramHashMap.put("translationY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.v)) {
      paramHashMap.put("translationZ", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.q)) {
      paramHashMap.put("transitionPathRotate", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.r)) {
      paramHashMap.put("scaleX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.s)) {
      paramHashMap.put("scaleY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.w)) {
      paramHashMap.put("progress", Integer.valueOf(this.h));
    }
    if (this.e.size() > 0)
    {
      Iterator localIterator = this.e.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CUSTOM,");
        localStringBuilder.append(str);
        paramHashMap.put(localStringBuilder.toString(), Integer.valueOf(this.h));
      }
    }
  }
  
  private static class a
  {
    private static SparseIntArray a;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      a = localSparseIntArray;
      localSparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
      a.append(R.styleable.KeyAttribute_android_elevation, 2);
      a.append(R.styleable.KeyAttribute_android_rotation, 4);
      a.append(R.styleable.KeyAttribute_android_rotationX, 5);
      a.append(R.styleable.KeyAttribute_android_rotationY, 6);
      a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
      a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
      a.append(R.styleable.KeyAttribute_android_scaleX, 7);
      a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
      a.append(R.styleable.KeyAttribute_transitionEasing, 9);
      a.append(R.styleable.KeyAttribute_motionTarget, 10);
      a.append(R.styleable.KeyAttribute_framePosition, 12);
      a.append(R.styleable.KeyAttribute_curveFit, 13);
      a.append(R.styleable.KeyAttribute_android_scaleY, 14);
      a.append(R.styleable.KeyAttribute_android_translationX, 15);
      a.append(R.styleable.KeyAttribute_android_translationY, 16);
      a.append(R.styleable.KeyAttribute_android_translationZ, 17);
      a.append(R.styleable.KeyAttribute_motionProgress, 18);
    }
    
    public static void a(e parame, TypedArray paramTypedArray)
    {
      int j = paramTypedArray.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramTypedArray.getIndex(i);
        switch (a.get(k))
        {
        case 3: 
        case 11: 
        default: 
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unused attribute 0x");
          localStringBuilder.append(Integer.toHexString(k));
          localStringBuilder.append("   ");
          localStringBuilder.append(a.get(k));
          Log.e("KeyAttribute", localStringBuilder.toString());
          break;
        case 20: 
          e.P(parame, paramTypedArray.getDimension(k, e.O(parame)));
          break;
        case 19: 
          e.N(parame, paramTypedArray.getDimension(k, e.M(parame)));
          break;
        case 18: 
          e.B(parame, paramTypedArray.getFloat(k, e.A(parame)));
          break;
        case 17: 
          e.z(parame, paramTypedArray.getDimension(k, e.y(parame)));
          break;
        case 16: 
          e.x(parame, paramTypedArray.getDimension(k, e.w(parame)));
          break;
        case 15: 
          e.v(parame, paramTypedArray.getDimension(k, e.u(parame)));
          break;
        case 14: 
          e.q(parame, paramTypedArray.getFloat(k, e.p(parame)));
          break;
        case 13: 
          e.F(parame, paramTypedArray.getInteger(k, e.E(parame)));
          break;
        case 12: 
          parame.a = paramTypedArray.getInt(k, parame.a);
          break;
        case 10: 
          if (MotionLayout.d1)
          {
            int m = paramTypedArray.getResourceId(k, parame.b);
            parame.b = m;
            if (m != -1) {
              break;
            }
          }
          else
          {
            if (paramTypedArray.peekValue(k).type != 3) {
              break label404;
            }
          }
          parame.c = paramTypedArray.getString(k);
          break;
          parame.b = paramTypedArray.getResourceId(k, parame.b);
          break;
        case 9: 
          e.Q(parame, paramTypedArray.getString(k));
          break;
        case 8: 
          e.t(parame, paramTypedArray.getFloat(k, e.s(parame)));
          break;
        case 7: 
          e.H(parame, paramTypedArray.getFloat(k, e.G(parame)));
          break;
        case 6: 
          e.L(parame, paramTypedArray.getFloat(k, e.K(parame)));
          break;
        case 5: 
          e.J(parame, paramTypedArray.getFloat(k, e.I(parame)));
          break;
        case 4: 
          e.D(parame, paramTypedArray.getFloat(k, e.C(parame)));
          break;
        case 2: 
          e.r(parame, paramTypedArray.getDimension(k, e.o(parame)));
          break;
        case 1: 
          label404:
          e.n(parame, paramTypedArray.getFloat(k, e.m(parame)));
        }
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.e
 * JD-Core Version:    0.7.0.1
 */