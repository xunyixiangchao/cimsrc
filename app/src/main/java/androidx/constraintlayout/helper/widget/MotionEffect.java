package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.d;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.motion.widget.h;
import androidx.constraintlayout.motion.widget.m;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;

public class MotionEffect
  extends MotionHelper
{
  private float n = 0.1F;
  private int o = 49;
  private int p = 50;
  private int q = 0;
  private int r = 0;
  private boolean s = true;
  private int t = -1;
  private int u = -1;
  
  public MotionEffect(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    F(paramContext, paramAttributeSet);
  }
  
  public MotionEffect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    F(paramContext, paramAttributeSet);
  }
  
  private void F(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MotionEffect);
      int j = paramContext.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.MotionEffect_motionEffect_start)
        {
          k = paramContext.getInt(k, this.o);
          this.o = k;
          this.o = Math.max(Math.min(k, 99), 0);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_end)
        {
          k = paramContext.getInt(k, this.p);
          this.p = k;
          this.p = Math.max(Math.min(k, 99), 0);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_translationX)
        {
          this.q = paramContext.getDimensionPixelOffset(k, this.q);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_translationY)
        {
          this.r = paramContext.getDimensionPixelOffset(k, this.r);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_alpha)
        {
          this.n = paramContext.getFloat(k, this.n);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_move)
        {
          this.u = paramContext.getInt(k, this.u);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_strict)
        {
          this.s = paramContext.getBoolean(k, this.s);
        }
        else if (k == R.styleable.MotionEffect_motionEffect_viewTransition)
        {
          this.t = paramContext.getResourceId(k, this.t);
        }
        i += 1;
      }
      i = this.o;
      j = this.p;
      if (i == j) {
        if (i > 0) {
          this.o = (i - 1);
        } else {
          this.p = (j + 1);
        }
      }
      paramContext.recycle();
    }
  }
  
  public void D(MotionLayout paramMotionLayout, HashMap<View, m> paramHashMap)
  {
    View[] arrayOfView = n((ConstraintLayout)getParent());
    if (arrayOfView == null)
    {
      paramMotionLayout = new StringBuilder();
      paramMotionLayout.append(a.a());
      paramMotionLayout.append(" views = null");
      Log.v("FadeMove", paramMotionLayout.toString());
      return;
    }
    e locale5 = new e();
    e locale6 = new e();
    locale5.R("alpha", Float.valueOf(this.n));
    locale6.R("alpha", Float.valueOf(this.n));
    locale5.g(this.o);
    locale6.g(this.p);
    h localh1 = new h();
    localh1.g(this.o);
    localh1.m(0);
    localh1.n("percentX", Integer.valueOf(0));
    localh1.n("percentY", Integer.valueOf(0));
    h localh2 = new h();
    localh2.g(this.p);
    localh2.m(0);
    localh2.n("percentX", Integer.valueOf(1));
    localh2.n("percentY", Integer.valueOf(1));
    int i = this.q;
    e locale3 = null;
    e locale1;
    e locale2;
    if (i > 0)
    {
      locale1 = new e();
      locale2 = new e();
      locale1.R("translationX", Integer.valueOf(this.q));
      locale1.g(this.p);
      locale2.R("translationX", Integer.valueOf(0));
      locale2.g(this.p - 1);
    }
    else
    {
      locale1 = null;
      locale2 = locale1;
    }
    e locale4;
    if (this.r > 0)
    {
      locale3 = new e();
      locale4 = new e();
      locale3.R("translationY", Integer.valueOf(this.r));
      locale3.g(this.p);
      locale4.R("translationY", Integer.valueOf(0));
      locale4.g(this.p - 1);
    }
    else
    {
      locale4 = null;
    }
    i = this.u;
    int k = i;
    Object localObject;
    float f1;
    float f2;
    int j;
    if (i == -1)
    {
      localObject = new int[4];
      i = 0;
      while (i < arrayOfView.length)
      {
        m localm = (m)paramHashMap.get(arrayOfView[i]);
        if (localm != null)
        {
          f1 = localm.n() - localm.t();
          f2 = localm.o() - localm.u();
          if (f2 < 0.0F) {
            localObject[1] += 1;
          }
          if (f2 > 0.0F) {
            localObject[0] += 1;
          }
          if (f1 > 0.0F) {
            localObject[3] += 1;
          }
          if (f1 < 0.0F) {
            localObject[2] += 1;
          }
        }
        i += 1;
      }
      int m = localObject[0];
      j = 0;
      i = 1;
      for (;;)
      {
        k = j;
        if (i >= 4) {
          break;
        }
        k = m;
        if (m < localObject[i])
        {
          k = localObject[i];
          j = i;
        }
        i += 1;
        m = k;
      }
    }
    i = 0;
    while (i < arrayOfView.length)
    {
      localObject = (m)paramHashMap.get(arrayOfView[i]);
      if (localObject != null)
      {
        label735:
        label764:
        label767:
        do
        {
          f1 = ((m)localObject).n() - ((m)localObject).t();
          f2 = ((m)localObject).o() - ((m)localObject).u();
          if (k == 0) {
            if ((f2 <= 0.0F) || ((this.s) && (f1 != 0.0F))) {}
          }
          do
          {
            for (;;)
            {
              j = 0;
              break label767;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      break label764;
                      if (k != 1) {
                        break;
                      }
                    } while (f2 >= 0.0F);
                    if (!this.s) {
                      break;
                    }
                  } while (f1 != 0.0F);
                  break;
                  if (k != 2) {
                    break label735;
                  }
                } while (f1 >= 0.0F);
                if (!this.s) {
                  break;
                }
              } while (f2 != 0.0F);
            }
          } while ((k == 3) && (f1 > 0.0F) && ((!this.s) || (f2 == 0.0F)));
          j = 1;
        } while (j == 0);
        j = this.t;
        if (j == -1)
        {
          ((m)localObject).a(locale5);
          ((m)localObject).a(locale6);
          ((m)localObject).a(localh1);
          ((m)localObject).a(localh2);
          if (this.q > 0)
          {
            ((m)localObject).a(locale1);
            ((m)localObject).a(locale2);
          }
          if (this.r > 0)
          {
            ((m)localObject).a(locale3);
            ((m)localObject).a(locale4);
          }
        }
        else
        {
          paramMotionLayout.Z(j, (m)localObject);
        }
      }
      i += 1;
    }
  }
  
  public boolean x()
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.helper.widget.MotionEffect
 * JD-Core Version:    0.7.0.1
 */