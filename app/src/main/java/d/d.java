package d;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

@SuppressLint({"RestrictedAPI"})
class d
  extends b
{
  private a m;
  private boolean n;
  
  d(a parama)
  {
    if (parama != null) {
      h(parama);
    }
  }
  
  d(a parama, Resources paramResources)
  {
    h(new a(parama, this, paramResources));
    onStateChange(getState());
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  void h(b.d paramd)
  {
    super.h(paramd);
    if ((paramd instanceof a)) {
      this.m = ((a)paramd);
    }
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  a j()
  {
    return new a(this.m, this, null);
  }
  
  int[] k(AttributeSet paramAttributeSet)
  {
    int i2 = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[i2];
    int i = 0;
    int k;
    for (int j = i; i < i2; j = k)
    {
      int i1 = paramAttributeSet.getAttributeNameResource(i);
      k = j;
      if (i1 != 0)
      {
        k = j;
        if (i1 != 16842960)
        {
          k = j;
          if (i1 != 16843161)
          {
            if (paramAttributeSet.getAttributeBooleanValue(i, false)) {
              k = i1;
            } else {
              k = -i1;
            }
            arrayOfInt[j] = k;
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return StateSet.trimStateSet(arrayOfInt, j);
  }
  
  public Drawable mutate()
  {
    if ((!this.n) && (super.mutate() == this))
    {
      this.m.r();
      this.n = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.m.A(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.m.A(StateSet.WILD_CARD);
    }
    return (g(i)) || (bool);
  }
  
  static class a
    extends b.d
  {
    int[][] J;
    
    a(a parama, d paramd, Resources paramResources)
    {
      super(paramd, paramResources);
      if (parama != null)
      {
        this.J = parama.J;
        return;
      }
      this.J = new int[f()][];
    }
    
    int A(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.J;
      int j = h();
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public Drawable newDrawable()
    {
      return new d(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new d(this, paramResources);
    }
    
    public void o(int paramInt1, int paramInt2)
    {
      super.o(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.J, 0, arrayOfInt, 0, paramInt1);
      this.J = arrayOfInt;
    }
    
    void r()
    {
      Object localObject = this.J;
      int[][] arrayOfInt = new int[localObject.length][];
      int i = localObject.length - 1;
      while (i >= 0)
      {
        localObject = this.J;
        if (localObject[i] != null) {
          localObject = (int[])localObject[i].clone();
        } else {
          localObject = null;
        }
        arrayOfInt[i] = localObject;
        i -= 1;
      }
      this.J = arrayOfInt;
    }
    
    int z(int[] paramArrayOfInt, Drawable paramDrawable)
    {
      int i = a(paramDrawable);
      this.J[i] = paramArrayOfInt;
      return i;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d.d
 * JD-Core Version:    0.7.0.1
 */