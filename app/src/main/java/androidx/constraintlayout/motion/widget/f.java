package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.a.b;
import i0.e;
import i0.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n0.c;

public class f
  extends d
{
  private String g = null;
  private int h = 0;
  private int i = -1;
  private String j = null;
  private float k = (0.0F / 0.0F);
  private float l = 0.0F;
  private float m = 0.0F;
  private float n = (0.0F / 0.0F);
  private int o = -1;
  private float p = (0.0F / 0.0F);
  private float q = (0.0F / 0.0F);
  private float r = (0.0F / 0.0F);
  private float s = (0.0F / 0.0F);
  private float t = (0.0F / 0.0F);
  private float u = (0.0F / 0.0F);
  private float v = (0.0F / 0.0F);
  private float w = (0.0F / 0.0F);
  private float x = (0.0F / 0.0F);
  private float y = (0.0F / 0.0F);
  private float z = (0.0F / 0.0F);
  
  public f()
  {
    this.d = 4;
    this.e = new HashMap();
  }
  
  public void Y(HashMap<String, c> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if (((String)localObject1).startsWith("CUSTOM"))
      {
        Object localObject2 = ((String)localObject1).substring(7);
        localObject2 = (androidx.constraintlayout.widget.a)this.e.get(localObject2);
        if ((localObject2 != null) && (((androidx.constraintlayout.widget.a)localObject2).d() == a.b.b))
        {
          localObject1 = (c)paramHashMap.get(localObject1);
          if (localObject1 != null) {
            ((e)localObject1).e(this.a, this.i, this.j, this.o, this.k, this.l, this.m, ((androidx.constraintlayout.widget.a)localObject2).e(), localObject2);
          }
        }
      }
      else
      {
        float f = Z((String)localObject1);
        if (!Float.isNaN(f))
        {
          localObject1 = (c)paramHashMap.get(localObject1);
          if (localObject1 != null) {
            ((e)localObject1).d(this.a, this.i, this.j, this.o, this.k, this.l, this.m, f);
          }
        }
      }
    }
  }
  
  public float Z(String paramString)
  {
    paramString.hashCode();
    int i2 = paramString.hashCode();
    int i1 = -1;
    switch (i2)
    {
    default: 
      break;
    case 1530034690: 
      if (paramString.equals("wavePhase")) {
        i1 = 13;
      }
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i1 = 12;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i1 = 11;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i1 = 10;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i1 = 9;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i1 = 8;
      }
      break;
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i1 = 7;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i1 = 6;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i1 = 5;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i1 = 4;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i1 = 3;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i1 = 2;
      }
      break;
    case -1249320805: 
      if (paramString.equals("rotationY")) {
        i1 = 1;
      }
      break;
    case -1249320806: 
      if (paramString.equals("rotationX")) {
        i1 = 0;
      }
      break;
    }
    switch (i1)
    {
    default: 
      if (!paramString.startsWith("CUSTOM"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  UNKNOWN  ");
        localStringBuilder.append(paramString);
        Log.v("WARNING! KeyCycle", localStringBuilder.toString());
      }
      return (0.0F / 0.0F);
    case 13: 
      return this.m;
    case 12: 
      return this.l;
    case 11: 
      return this.p;
    case 10: 
      return this.s;
    case 9: 
      return this.q;
    case 8: 
      return this.r;
    case 7: 
      return this.w;
    case 6: 
      return this.v;
    case 5: 
      return this.n;
    case 4: 
      return this.z;
    case 3: 
      return this.y;
    case 2: 
      return this.x;
    case 1: 
      return this.u;
    }
    return this.t;
  }
  
  public void a(HashMap<String, n0.d> paramHashMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("add ");
    ((StringBuilder)localObject1).append(paramHashMap.size());
    ((StringBuilder)localObject1).append(" values");
    a.g("KeyCycle", ((StringBuilder)localObject1).toString(), 2);
    localObject1 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (j)paramHashMap.get(str);
      if (localObject2 != null)
      {
        str.hashCode();
        int i1 = -1;
        switch (str.hashCode())
        {
        default: 
          break;
        case 1530034690: 
          if (str.equals("wavePhase")) {
            i1 = 13;
          }
          break;
        case 156108012: 
          if (str.equals("waveOffset")) {
            i1 = 12;
          }
          break;
        case 92909918: 
          if (str.equals("alpha")) {
            i1 = 11;
          }
          break;
        case 37232917: 
          if (str.equals("transitionPathRotate")) {
            i1 = 10;
          }
          break;
        case -4379043: 
          if (str.equals("elevation")) {
            i1 = 9;
          }
          break;
        case -40300674: 
          if (str.equals("rotation")) {
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
        float f;
        switch (i1)
        {
        default: 
          if (!str.startsWith("CUSTOM"))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("  UNKNOWN  ");
            ((StringBuilder)localObject2).append(str);
            Log.v("WARNING KeyCycle", ((StringBuilder)localObject2).toString());
          }
          break;
        case 13: 
          i1 = this.a;
          f = this.m;
          break;
        case 12: 
          i1 = this.a;
          f = this.l;
          break;
        case 11: 
          i1 = this.a;
          f = this.p;
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
            ((j)localObject2).c(i1, f);
            break;
            i1 = this.a;
            f = this.s;
            continue;
            i1 = this.a;
            f = this.q;
            continue;
            i1 = this.a;
            f = this.r;
            continue;
            i1 = this.a;
            f = this.w;
            continue;
            i1 = this.a;
            f = this.v;
            continue;
            i1 = this.a;
            f = this.n;
            continue;
            i1 = this.a;
            f = this.z;
            continue;
            i1 = this.a;
            f = this.y;
            continue;
            i1 = this.a;
            f = this.x;
            continue;
            i1 = this.a;
            f = this.u;
            continue;
            i1 = this.a;
            f = this.t;
          }
        }
      }
    }
  }
  
  public d b()
  {
    return new f().c(this);
  }
  
  public d c(d paramd)
  {
    super.c(paramd);
    paramd = (f)paramd;
    this.g = paramd.g;
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
    this.x = paramd.x;
    this.y = paramd.y;
    this.z = paramd.z;
    return this;
  }
  
  public void d(HashSet<String> paramHashSet)
  {
    if (!Float.isNaN(this.p)) {
      paramHashSet.add("alpha");
    }
    if (!Float.isNaN(this.q)) {
      paramHashSet.add("elevation");
    }
    if (!Float.isNaN(this.r)) {
      paramHashSet.add("rotation");
    }
    if (!Float.isNaN(this.t)) {
      paramHashSet.add("rotationX");
    }
    if (!Float.isNaN(this.u)) {
      paramHashSet.add("rotationY");
    }
    if (!Float.isNaN(this.v)) {
      paramHashSet.add("scaleX");
    }
    if (!Float.isNaN(this.w)) {
      paramHashSet.add("scaleY");
    }
    if (!Float.isNaN(this.s)) {
      paramHashSet.add("transitionPathRotate");
    }
    if (!Float.isNaN(this.x)) {
      paramHashSet.add("translationX");
    }
    if (!Float.isNaN(this.y)) {
      paramHashSet.add("translationY");
    }
    if (!Float.isNaN(this.z)) {
      paramHashSet.add("translationZ");
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
    a.a(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyCycle));
  }
  
  private static class a
  {
    private static SparseIntArray a;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      a = localSparseIntArray;
      localSparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
      a.append(R.styleable.KeyCycle_framePosition, 2);
      a.append(R.styleable.KeyCycle_transitionEasing, 3);
      a.append(R.styleable.KeyCycle_curveFit, 4);
      a.append(R.styleable.KeyCycle_waveShape, 5);
      a.append(R.styleable.KeyCycle_wavePeriod, 6);
      a.append(R.styleable.KeyCycle_waveOffset, 7);
      a.append(R.styleable.KeyCycle_waveVariesBy, 8);
      a.append(R.styleable.KeyCycle_android_alpha, 9);
      a.append(R.styleable.KeyCycle_android_elevation, 10);
      a.append(R.styleable.KeyCycle_android_rotation, 11);
      a.append(R.styleable.KeyCycle_android_rotationX, 12);
      a.append(R.styleable.KeyCycle_android_rotationY, 13);
      a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
      a.append(R.styleable.KeyCycle_android_scaleX, 15);
      a.append(R.styleable.KeyCycle_android_scaleY, 16);
      a.append(R.styleable.KeyCycle_android_translationX, 17);
      a.append(R.styleable.KeyCycle_android_translationY, 18);
      a.append(R.styleable.KeyCycle_android_translationZ, 19);
      a.append(R.styleable.KeyCycle_motionProgress, 20);
      a.append(R.styleable.KeyCycle_wavePhase, 21);
    }
    
    private static void b(f paramf, TypedArray paramTypedArray)
    {
      int k = paramTypedArray.getIndexCount();
      int i = 0;
      while (i < k)
      {
        int j = paramTypedArray.getIndex(i);
        switch (a.get(j))
        {
        default: 
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unused attribute 0x");
          localStringBuilder.append(Integer.toHexString(j));
          localStringBuilder.append("   ");
          localStringBuilder.append(a.get(j));
          Log.e("KeyCycle", localStringBuilder.toString());
          break;
        case 21: 
          f.J(paramf, paramTypedArray.getFloat(j, f.I(paramf)) / 360.0F);
          break;
        case 20: 
          f.G(paramf, paramTypedArray.getFloat(j, f.F(paramf)));
          break;
        case 19: 
          f.E(paramf, paramTypedArray.getDimension(j, f.D(paramf)));
          break;
        case 18: 
          f.C(paramf, paramTypedArray.getDimension(j, f.B(paramf)));
          break;
        case 17: 
          f.A(paramf, paramTypedArray.getDimension(j, f.z(paramf)));
          break;
        case 16: 
          f.y(paramf, paramTypedArray.getFloat(j, f.x(paramf)));
          break;
        case 15: 
          f.w(paramf, paramTypedArray.getFloat(j, f.v(paramf)));
          break;
        case 14: 
          f.u(paramf, paramTypedArray.getFloat(j, f.t(paramf)));
          break;
        case 13: 
          f.s(paramf, paramTypedArray.getFloat(j, f.r(paramf)));
          break;
        case 12: 
          f.q(paramf, paramTypedArray.getFloat(j, f.p(paramf)));
          break;
        case 11: 
          f.n(paramf, paramTypedArray.getFloat(j, f.m(paramf)));
          break;
        case 10: 
          f.X(paramf, paramTypedArray.getDimension(j, f.W(paramf)));
          break;
        case 9: 
          f.V(paramf, paramTypedArray.getFloat(j, f.U(paramf)));
          break;
        case 8: 
          f.T(paramf, paramTypedArray.getInt(j, f.S(paramf)));
          break;
        case 7: 
          float f;
          if (paramTypedArray.peekValue(j).type == 5) {
            f = paramTypedArray.getDimension(j, f.Q(paramf));
          } else {
            f = paramTypedArray.getFloat(j, f.Q(paramf));
          }
          f.R(paramf, f);
          break;
        case 6: 
          f.P(paramf, paramTypedArray.getFloat(j, f.O(paramf)));
          break;
        case 5: 
          if (paramTypedArray.peekValue(j).type == 3)
          {
            f.L(paramf, paramTypedArray.getString(j));
            j = 7;
          }
          else
          {
            j = paramTypedArray.getInt(j, f.M(paramf));
          }
          f.N(paramf, j);
          break;
        case 4: 
          f.K(paramf, paramTypedArray.getInteger(j, f.H(paramf)));
          break;
        case 3: 
          f.o(paramf, paramTypedArray.getString(j));
          break;
        case 2: 
          paramf.a = paramTypedArray.getInt(j, paramf.a);
          break;
        case 1: 
          if (MotionLayout.d1)
          {
            int m = paramTypedArray.getResourceId(j, paramf.b);
            paramf.b = m;
            if (m != -1) {
              break;
            }
          }
          else
          {
            if (paramTypedArray.peekValue(j).type != 3) {
              break label673;
            }
          }
          paramf.c = paramTypedArray.getString(j);
          break;
          label673:
          paramf.b = paramTypedArray.getResourceId(j, paramf.b);
        }
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.f
 * JD-Core Version:    0.7.0.1
 */