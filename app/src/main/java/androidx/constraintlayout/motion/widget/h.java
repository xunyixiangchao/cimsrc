package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;

public class h
  extends i
{
  String h = null;
  int i = d.f;
  int j = 0;
  float k = (0.0F / 0.0F);
  float l = (0.0F / 0.0F);
  float m = (0.0F / 0.0F);
  float n = (0.0F / 0.0F);
  float o = (0.0F / 0.0F);
  float p = (0.0F / 0.0F);
  int q = 0;
  private float r = (0.0F / 0.0F);
  private float s = (0.0F / 0.0F);
  
  public h()
  {
    this.d = 2;
  }
  
  public void a(HashMap<String, n0.d> paramHashMap) {}
  
  public d b()
  {
    return new h().c(this);
  }
  
  public d c(d paramd)
  {
    super.c(paramd);
    paramd = (h)paramd;
    this.h = paramd.h;
    this.i = paramd.i;
    this.j = paramd.j;
    this.k = paramd.k;
    this.l = (0.0F / 0.0F);
    this.m = paramd.m;
    this.n = paramd.n;
    this.o = paramd.o;
    this.p = paramd.p;
    this.r = paramd.r;
    this.s = paramd.s;
    return this;
  }
  
  public void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    a.a(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyPosition));
  }
  
  public void m(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void n(String paramString, Object paramObject)
  {
    paramString.hashCode();
    int i2 = paramString.hashCode();
    int i1 = -1;
    switch (i2)
    {
    default: 
      break;
    case 428090548: 
      if (paramString.equals("percentY")) {
        i1 = 6;
      }
      break;
    case 428090547: 
      if (paramString.equals("percentX")) {
        i1 = 5;
      }
      break;
    case -200259324: 
      if (paramString.equals("sizePercent")) {
        i1 = 4;
      }
      break;
    case -827014263: 
      if (paramString.equals("drawPath")) {
        i1 = 3;
      }
      break;
    case -1017587252: 
      if (paramString.equals("percentHeight")) {
        i1 = 2;
      }
      break;
    case -1127236479: 
      if (paramString.equals("percentWidth")) {
        i1 = 1;
      }
      break;
    case -1812823328: 
      if (paramString.equals("transitionEasing")) {
        i1 = 0;
      }
      break;
    }
    float f;
    switch (i1)
    {
    default: 
      return;
    case 6: 
      this.n = k(paramObject);
      return;
    case 5: 
      this.m = k(paramObject);
      return;
    case 4: 
      f = k(paramObject);
      this.k = f;
      break;
    case 3: 
      this.j = l(paramObject);
      return;
    case 2: 
      f = k(paramObject);
      this.l = f;
      return;
    case 1: 
      this.k = k(paramObject);
      return;
    }
    this.h = paramObject.toString();
  }
  
  private static class a
  {
    private static SparseIntArray a;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      a = localSparseIntArray;
      localSparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
      a.append(R.styleable.KeyPosition_framePosition, 2);
      a.append(R.styleable.KeyPosition_transitionEasing, 3);
      a.append(R.styleable.KeyPosition_curveFit, 4);
      a.append(R.styleable.KeyPosition_drawPath, 5);
      a.append(R.styleable.KeyPosition_percentX, 6);
      a.append(R.styleable.KeyPosition_percentY, 7);
      a.append(R.styleable.KeyPosition_keyPositionType, 9);
      a.append(R.styleable.KeyPosition_sizePercent, 8);
      a.append(R.styleable.KeyPosition_percentWidth, 11);
      a.append(R.styleable.KeyPosition_percentHeight, 12);
      a.append(R.styleable.KeyPosition_pathMotionArc, 10);
    }
    
    private static void b(h paramh, TypedArray paramTypedArray)
    {
      int j = paramTypedArray.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramTypedArray.getIndex(i);
        Object localObject;
        float f;
        switch (a.get(k))
        {
        default: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unused attribute 0x");
          ((StringBuilder)localObject).append(Integer.toHexString(k));
          ((StringBuilder)localObject).append("   ");
          ((StringBuilder)localObject).append(a.get(k));
          Log.e("KeyPosition", ((StringBuilder)localObject).toString());
          break;
        case 12: 
          f = paramTypedArray.getFloat(k, paramh.l);
          break;
        case 11: 
          paramh.k = paramTypedArray.getFloat(k, paramh.k);
          break;
        case 10: 
          paramh.i = paramTypedArray.getInt(k, paramh.i);
          break;
        case 9: 
          paramh.q = paramTypedArray.getInt(k, paramh.q);
          break;
        case 8: 
          f = paramTypedArray.getFloat(k, paramh.l);
          paramh.k = f;
          paramh.l = f;
          break;
        case 7: 
          paramh.n = paramTypedArray.getFloat(k, paramh.n);
          break;
        case 6: 
          paramh.m = paramTypedArray.getFloat(k, paramh.m);
          break;
        case 5: 
          paramh.j = paramTypedArray.getInt(k, paramh.j);
          break;
        case 4: 
          paramh.g = paramTypedArray.getInteger(k, paramh.g);
          break;
        case 3: 
          if (paramTypedArray.peekValue(k).type == 3) {
            localObject = paramTypedArray.getString(k);
          } else {
            localObject = i0.c.c[paramTypedArray.getInteger(k, 0)];
          }
          paramh.h = ((String)localObject);
          break;
        case 2: 
          paramh.a = paramTypedArray.getInt(k, paramh.a);
          break;
        }
        if (MotionLayout.d1)
        {
          int m = paramTypedArray.getResourceId(k, paramh.b);
          paramh.b = m;
          if (m != -1) {
            break label449;
          }
        }
        else
        {
          if (paramTypedArray.peekValue(k).type != 3) {
            break label435;
          }
        }
        paramh.c = paramTypedArray.getString(k);
        break label449;
        label435:
        paramh.b = paramTypedArray.getResourceId(k, paramh.b);
        label449:
        i += 1;
      }
      if (paramh.a == -1) {
        Log.e("KeyPosition", "no frame position");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.h
 * JD-Core Version:    0.7.0.1
 */