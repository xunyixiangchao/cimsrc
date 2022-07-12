package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.a;
import i0.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n0.f;
import n0.f.b;

public class j
  extends d
{
  private String g;
  private int h = -1;
  private float i = (0.0F / 0.0F);
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
  private int u = 0;
  private String v = null;
  private float w = (0.0F / 0.0F);
  private float x = 0.0F;
  
  public j()
  {
    this.d = 3;
    this.e = new HashMap();
  }
  
  public void U(HashMap<String, f> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = (f)paramHashMap.get(localObject2);
      if (localObject1 != null)
      {
        boolean bool = ((String)localObject2).startsWith("CUSTOM");
        int i1 = 7;
        if (bool)
        {
          localObject2 = ((String)localObject2).substring(7);
          localObject2 = (a)this.e.get(localObject2);
          if (localObject2 != null) {
            ((f.b)localObject1).j(this.a, (a)localObject2, this.w, this.u, this.x);
          }
        }
        else
        {
          switch (((String)localObject2).hashCode())
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
                                i1 = -1;
                                break;
                              } while (!((String)localObject2).equals("alpha"));
                              i1 = 11;
                              break;
                            } while (!((String)localObject2).equals("transitionPathRotate"));
                            i1 = 10;
                            break;
                          } while (!((String)localObject2).equals("elevation"));
                          i1 = 9;
                          break;
                        } while (!((String)localObject2).equals("rotation"));
                        i1 = 8;
                        break;
                        if (((String)localObject2).equals("scaleY")) {
                          break;
                        }
                      } while ((goto 236) || (!((String)localObject2).equals("scaleX")));
                      i1 = 6;
                      break;
                    } while (!((String)localObject2).equals("progress"));
                    i1 = 5;
                    break;
                  } while (!((String)localObject2).equals("translationZ"));
                  i1 = 4;
                  break;
                } while (!((String)localObject2).equals("translationY"));
                i1 = 3;
                break;
              } while (!((String)localObject2).equals("translationX"));
              i1 = 2;
              break;
            } while (!((String)localObject2).equals("rotationY"));
            i1 = 1;
            break;
          } while (!((String)localObject2).equals("rotationX"));
          i1 = 0;
          float f;
          switch (i1)
          {
          default: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("UNKNOWN addValues \"");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("\"");
            Log.e("KeyTimeCycles", ((StringBuilder)localObject1).toString());
            break;
          case 11: 
            if (!Float.isNaN(this.i))
            {
              i1 = this.a;
              f = this.i;
            }
            break;
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
              ((o)localObject1).b(i1, f, this.w, this.u, this.x);
              break;
              if (Float.isNaN(this.n)) {
                break;
              }
              i1 = this.a;
              f = this.n;
              continue;
              if (Float.isNaN(this.j)) {
                break;
              }
              i1 = this.a;
              f = this.j;
              continue;
              if (Float.isNaN(this.k)) {
                break;
              }
              i1 = this.a;
              f = this.k;
              continue;
              if (Float.isNaN(this.p)) {
                break;
              }
              i1 = this.a;
              f = this.p;
              continue;
              if (Float.isNaN(this.o)) {
                break;
              }
              i1 = this.a;
              f = this.o;
              continue;
              if (Float.isNaN(this.t)) {
                break;
              }
              i1 = this.a;
              f = this.t;
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
              if (Float.isNaN(this.q)) {
                break;
              }
              i1 = this.a;
              f = this.q;
              continue;
              if (Float.isNaN(this.m)) {
                break;
              }
              i1 = this.a;
              f = this.m;
              continue;
              if (Float.isNaN(this.l)) {
                break;
              }
              i1 = this.a;
              f = this.l;
            }
          }
        }
      }
    }
  }
  
  public void a(HashMap<String, n0.d> paramHashMap)
  {
    throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
  }
  
  public d b()
  {
    return new j().c(this);
  }
  
  public d c(d paramd)
  {
    super.c(paramd);
    paramd = (j)paramd;
    this.g = paramd.g;
    this.h = paramd.h;
    this.u = paramd.u;
    this.w = paramd.w;
    this.x = paramd.x;
    this.t = paramd.t;
    this.i = paramd.i;
    this.j = paramd.j;
    this.k = paramd.k;
    this.n = paramd.n;
    this.l = paramd.l;
    this.m = paramd.m;
    this.o = paramd.o;
    this.p = paramd.p;
    this.q = paramd.q;
    this.r = paramd.r;
    this.s = paramd.s;
    return this;
  }
  
  public void d(HashSet<String> paramHashSet)
  {
    if (!Float.isNaN(this.i)) {
      paramHashSet.add("alpha");
    }
    if (!Float.isNaN(this.j)) {
      paramHashSet.add("elevation");
    }
    if (!Float.isNaN(this.k)) {
      paramHashSet.add("rotation");
    }
    if (!Float.isNaN(this.l)) {
      paramHashSet.add("rotationX");
    }
    if (!Float.isNaN(this.m)) {
      paramHashSet.add("rotationY");
    }
    if (!Float.isNaN(this.q)) {
      paramHashSet.add("translationX");
    }
    if (!Float.isNaN(this.r)) {
      paramHashSet.add("translationY");
    }
    if (!Float.isNaN(this.s)) {
      paramHashSet.add("translationZ");
    }
    if (!Float.isNaN(this.n)) {
      paramHashSet.add("transitionPathRotate");
    }
    if (!Float.isNaN(this.o)) {
      paramHashSet.add("scaleX");
    }
    if (!Float.isNaN(this.p)) {
      paramHashSet.add("scaleY");
    }
    if (!Float.isNaN(this.t)) {
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
    a.a(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyTimeCycle));
  }
  
  public void h(HashMap<String, Integer> paramHashMap)
  {
    if (this.h == -1) {
      return;
    }
    if (!Float.isNaN(this.i)) {
      paramHashMap.put("alpha", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.j)) {
      paramHashMap.put("elevation", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.k)) {
      paramHashMap.put("rotation", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.l)) {
      paramHashMap.put("rotationX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.m)) {
      paramHashMap.put("rotationY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.q)) {
      paramHashMap.put("translationX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.r)) {
      paramHashMap.put("translationY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.s)) {
      paramHashMap.put("translationZ", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.n)) {
      paramHashMap.put("transitionPathRotate", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.o)) {
      paramHashMap.put("scaleX", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.o)) {
      paramHashMap.put("scaleY", Integer.valueOf(this.h));
    }
    if (!Float.isNaN(this.t)) {
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
      localSparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
      a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
      a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
      a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
      a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
      a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
      a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
      a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
      a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
      a.append(R.styleable.KeyTimeCycle_framePosition, 12);
      a.append(R.styleable.KeyTimeCycle_curveFit, 13);
      a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
      a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
      a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
      a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
      a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
      a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
      a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
      a.append(R.styleable.KeyTimeCycle_waveShape, 19);
    }
    
    public static void a(j paramj, TypedArray paramTypedArray)
    {
      int k = paramTypedArray.getIndexCount();
      int i = 0;
      while (i < k)
      {
        int j = paramTypedArray.getIndex(i);
        switch (a.get(j))
        {
        case 3: 
        case 11: 
        default: 
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unused attribute 0x");
          localStringBuilder.append(Integer.toHexString(j));
          localStringBuilder.append("   ");
          localStringBuilder.append(a.get(j));
          Log.e("KeyTimeCycle", localStringBuilder.toString());
          break;
        case 21: 
          float f;
          if (paramTypedArray.peekValue(j).type == 5) {
            f = paramTypedArray.getDimension(j, j.O(paramj));
          } else {
            f = paramTypedArray.getFloat(j, j.O(paramj));
          }
          j.P(paramj, f);
          break;
        case 20: 
          j.N(paramj, paramTypedArray.getFloat(j, j.M(paramj)));
          break;
        case 19: 
          if (paramTypedArray.peekValue(j).type == 3)
          {
            j.J(paramj, paramTypedArray.getString(j));
            j = 7;
          }
          else
          {
            j = paramTypedArray.getInt(j, j.K(paramj));
          }
          j.L(paramj, j);
          break;
        case 18: 
          j.E(paramj, paramTypedArray.getFloat(j, j.D(paramj)));
          break;
        case 17: 
          j.C(paramj, paramTypedArray.getDimension(j, j.B(paramj)));
          break;
        case 16: 
          j.A(paramj, paramTypedArray.getDimension(j, j.z(paramj)));
          break;
        case 15: 
          j.y(paramj, paramTypedArray.getDimension(j, j.x(paramj)));
          break;
        case 14: 
          j.u(paramj, paramTypedArray.getFloat(j, j.t(paramj)));
          break;
        case 13: 
          j.I(paramj, paramTypedArray.getInteger(j, j.H(paramj)));
          break;
        case 12: 
          paramj.a = paramTypedArray.getInt(j, paramj.a);
          break;
        case 10: 
          if (MotionLayout.d1)
          {
            int m = paramTypedArray.getResourceId(j, paramj.b);
            paramj.b = m;
            if (m != -1) {
              break;
            }
          }
          else
          {
            if (paramTypedArray.peekValue(j).type != 3) {
              break label494;
            }
          }
          paramj.c = paramTypedArray.getString(j);
          break;
          paramj.b = paramTypedArray.getResourceId(j, paramj.b);
          break;
        case 9: 
          j.s(paramj, paramTypedArray.getString(j));
          break;
        case 8: 
          j.w(paramj, paramTypedArray.getFloat(j, j.v(paramj)));
          break;
        case 7: 
          j.R(paramj, paramTypedArray.getFloat(j, j.Q(paramj)));
          break;
        case 6: 
          j.q(paramj, paramTypedArray.getFloat(j, j.p(paramj)));
          break;
        case 5: 
          j.T(paramj, paramTypedArray.getFloat(j, j.S(paramj)));
          break;
        case 4: 
          j.G(paramj, paramTypedArray.getFloat(j, j.F(paramj)));
          break;
        case 2: 
          j.r(paramj, paramTypedArray.getDimension(j, j.o(paramj)));
          break;
        case 1: 
          label494:
          j.n(paramj, paramTypedArray.getFloat(j, j.m(paramj)));
        }
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.j
 * JD-Core Version:    0.7.0.1
 */