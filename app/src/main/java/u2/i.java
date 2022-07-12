package u2;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.R.id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t2.e;
import x2.k;

@Deprecated
public abstract class i<T extends View, Z>
  extends a<Z>
{
  private static boolean f;
  private static int g = R.id.glide_custom_view_target_tag;
  protected final T a;
  private final a b;
  private View.OnAttachStateChangeListener c;
  private boolean d;
  private boolean e;
  
  public i(T paramT)
  {
    this.a = ((View)k.d(paramT));
    this.b = new a(paramT);
  }
  
  private Object e()
  {
    return this.a.getTag(g);
  }
  
  private void m()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.c;
    if (localOnAttachStateChangeListener != null)
    {
      if (this.e) {
        return;
      }
      this.a.addOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.e = true;
    }
  }
  
  private void n()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.c;
    if (localOnAttachStateChangeListener != null)
    {
      if (!this.e) {
        return;
      }
      this.a.removeOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.e = false;
    }
  }
  
  private void o(Object paramObject)
  {
    f = true;
    this.a.setTag(g, paramObject);
  }
  
  public void b(g paramg)
  {
    this.b.k(paramg);
  }
  
  public void g(Drawable paramDrawable)
  {
    super.g(paramDrawable);
    m();
  }
  
  public T h()
  {
    return this.a;
  }
  
  public void i(g paramg)
  {
    this.b.d(paramg);
  }
  
  public e j()
  {
    Object localObject = e();
    if (localObject != null)
    {
      if ((localObject instanceof e)) {
        return (e)localObject;
      }
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
    return null;
  }
  
  public void k(Drawable paramDrawable)
  {
    super.k(paramDrawable);
    this.b.b();
    if (!this.d) {
      n();
    }
  }
  
  public void l(e parame)
  {
    o(parame);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Target for: ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  static final class a
  {
    static Integer e;
    private final View a;
    private final List<g> b = new ArrayList();
    boolean c;
    private a d;
    
    a(View paramView)
    {
      this.a = paramView;
    }
    
    private static int c(Context paramContext)
    {
      if (e == null)
      {
        paramContext = ((WindowManager)k.d((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
        Point localPoint = new Point();
        paramContext.getSize(localPoint);
        e = Integer.valueOf(Math.max(localPoint.x, localPoint.y));
      }
      return e.intValue();
    }
    
    private int e(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt2 - paramInt3;
      if (i > 0) {
        return i;
      }
      if ((this.c) && (this.a.isLayoutRequested())) {
        return 0;
      }
      paramInt1 -= paramInt3;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      if ((!this.a.isLayoutRequested()) && (paramInt2 == -2))
      {
        if (Log.isLoggable("ViewTarget", 4)) {
          Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        return c(this.a.getContext());
      }
      return 0;
    }
    
    private int f()
    {
      int j = this.a.getPaddingTop();
      int k = this.a.getPaddingBottom();
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      int i;
      if (localLayoutParams != null) {
        i = localLayoutParams.height;
      } else {
        i = 0;
      }
      return e(this.a.getHeight(), i, j + k);
    }
    
    private int g()
    {
      int j = this.a.getPaddingLeft();
      int k = this.a.getPaddingRight();
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      int i;
      if (localLayoutParams != null) {
        i = localLayoutParams.width;
      } else {
        i = 0;
      }
      return e(this.a.getWidth(), i, j + k);
    }
    
    private boolean h(int paramInt)
    {
      return (paramInt > 0) || (paramInt == -2147483648);
    }
    
    private boolean i(int paramInt1, int paramInt2)
    {
      return (h(paramInt1)) && (h(paramInt2));
    }
    
    private void j(int paramInt1, int paramInt2)
    {
      Iterator localIterator = new ArrayList(this.b).iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).e(paramInt1, paramInt2);
      }
    }
    
    void a()
    {
      if (this.b.isEmpty()) {
        return;
      }
      int i = g();
      int j = f();
      if (!i(i, j)) {
        return;
      }
      j(i, j);
      b();
    }
    
    void b()
    {
      ViewTreeObserver localViewTreeObserver = this.a.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnPreDrawListener(this.d);
      }
      this.d = null;
      this.b.clear();
    }
    
    void d(g paramg)
    {
      int i = g();
      int j = f();
      if (i(i, j))
      {
        paramg.e(i, j);
        return;
      }
      if (!this.b.contains(paramg)) {
        this.b.add(paramg);
      }
      if (this.d == null)
      {
        paramg = this.a.getViewTreeObserver();
        a locala = new a(this);
        this.d = locala;
        paramg.addOnPreDrawListener(locala);
      }
    }
    
    void k(g paramg)
    {
      this.b.remove(paramg);
    }
    
    private static final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final WeakReference<i.a> a;
      
      a(i.a parama)
      {
        this.a = new WeakReference(parama);
      }
      
      public boolean onPreDraw()
      {
        if (Log.isLoggable("ViewTarget", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OnGlobalLayoutListener called attachStateListener=");
          ((StringBuilder)localObject).append(this);
          Log.v("ViewTarget", ((StringBuilder)localObject).toString());
        }
        Object localObject = (i.a)this.a.get();
        if (localObject != null) {
          ((i.a)localObject).a();
        }
        return true;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u2.i
 * JD-Core Version:    0.7.0.1
 */