package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import androidx.camera.core.i3;
import androidx.camera.core.i3.a;
import androidx.camera.core.n1;
import androidx.camera.core.r1;
import androidx.camera.core.u2;
import androidx.camera.core.w1.d;
import androidx.core.content.b;
import androidx.lifecycle.LiveData;
import e0.c;
import e0.d;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import s.e0;
import s.g0;
import s.w1;
import s.w1.a;

public final class PreviewView
  extends FrameLayout
{
  private static final d n = d.b;
  d a;
  k b;
  final f c;
  boolean d;
  final androidx.lifecycle.r<g> e;
  final AtomicReference<e> f;
  l g;
  private final ScaleGestureDetector h;
  e0 i;
  private MotionEvent j;
  private final c k;
  private final View.OnLayoutChangeListener l;
  final w1.d m;
  
  public PreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public PreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d locald = n;
    this.a = locald;
    f localf = new f();
    this.c = localf;
    this.d = true;
    this.e = new androidx.lifecycle.r(g.a);
    this.f = new AtomicReference();
    this.g = new l(localf);
    this.k = new c();
    this.l = new g(this);
    this.m = new a();
    androidx.camera.core.impl.utils.l.a();
    Object localObject = paramContext.getTheme();
    int[] arrayOfInt = R.styleable.PreviewView;
    localObject = ((Resources.Theme)localObject).obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt1, paramInt2);
    androidx.core.view.x.o0(this, paramContext, arrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt1, paramInt2);
    try
    {
      setScaleType(f.a(((TypedArray)localObject).getInteger(R.styleable.PreviewView_scaleType, localf.f().b())));
      setImplementationMode(d.a(((TypedArray)localObject).getInteger(R.styleable.PreviewView_implementationMode, locald.b())));
      ((TypedArray)localObject).recycle();
      this.h = new ScaleGestureDetector(paramContext, new e());
      if (getBackground() == null) {
        setBackgroundColor(b.b(getContext(), 17170444));
      }
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    androidx.camera.core.impl.utils.l.a();
    getDisplay();
    getViewPort();
  }
  
  static boolean f(u2 paramu2, d paramd)
  {
    boolean bool = paramu2.j().i().d().equals("androidx.camera.camera2.legacy");
    int i1;
    if ((e0.a.a(d.class) == null) && (e0.a.a(c.class) == null)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((!paramu2.m()) && (Build.VERSION.SDK_INT > 24) && (!bool))
    {
      if (i1 != 0) {
        return true;
      }
      i1 = b.b[paramd.ordinal()];
      if (i1 != 1)
      {
        if (i1 == 2) {
          return false;
        }
        paramu2 = new StringBuilder();
        paramu2.append("Invalid implementation mode: ");
        paramu2.append(paramd);
        throw new IllegalArgumentException(paramu2.toString());
      }
    }
    return true;
  }
  
  private void g()
  {
    DisplayManager localDisplayManager = getDisplayManager();
    if (localDisplayManager == null) {
      return;
    }
    localDisplayManager.registerDisplayListener(this.k, new Handler(Looper.getMainLooper()));
  }
  
  private DisplayManager getDisplayManager()
  {
    Context localContext = getContext();
    if (localContext == null) {
      return null;
    }
    return (DisplayManager)localContext.getApplicationContext().getSystemService("display");
  }
  
  private int getViewPortScaleType()
  {
    switch (b.a[getScaleType().ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected scale type: ");
      localStringBuilder.append(getScaleType());
      throw new IllegalStateException(localStringBuilder.toString());
    case 4: 
    case 5: 
    case 6: 
      return 3;
    case 3: 
      return 0;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  private void h()
  {
    DisplayManager localDisplayManager = getDisplayManager();
    if (localDisplayManager == null) {
      return;
    }
    localDisplayManager.unregisterDisplayListener(this.k);
  }
  
  @SuppressLint({"WrongConstant"})
  public i3 c(int paramInt)
  {
    
    if ((getWidth() != 0) && (getHeight() != 0)) {
      return new i3.a(new Rational(getWidth(), getHeight()), paramInt).c(getViewPortScaleType()).b(getLayoutDirection()).a();
    }
    return null;
  }
  
  void e()
  {
    androidx.camera.core.impl.utils.l.a();
    k localk = this.b;
    if (localk != null) {
      localk.h();
    }
    this.g.a(new Size(getWidth(), getHeight()), getLayoutDirection());
  }
  
  public Bitmap getBitmap()
  {
    androidx.camera.core.impl.utils.l.a();
    k localk = this.b;
    if (localk == null) {
      return null;
    }
    return localk.a();
  }
  
  public a getController()
  {
    androidx.camera.core.impl.utils.l.a();
    return null;
  }
  
  public d getImplementationMode()
  {
    androidx.camera.core.impl.utils.l.a();
    return this.a;
  }
  
  public r1 getMeteringPointFactory()
  {
    androidx.camera.core.impl.utils.l.a();
    return this.g;
  }
  
  public f0.a getOutputTransform()
  {
    
    try
    {
      localMatrix = this.c.h(new Size(getWidth(), getHeight()), getLayoutDirection());
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Matrix localMatrix;
      label33:
      Rect localRect;
      break label33;
    }
    localMatrix = null;
    localRect = this.c.g();
    if ((localMatrix != null) && (localRect != null))
    {
      localMatrix.preConcat(x.a(localRect));
      if ((this.b instanceof w)) {
        localMatrix.postConcat(getMatrix());
      } else {
        n1.k("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
      }
      return new f0.a(localMatrix, new Size(localRect.width(), localRect.height()));
    }
    n1.a("PreviewView", "Transform info is not ready");
    return null;
  }
  
  public LiveData<g> getPreviewStreamState()
  {
    return this.e;
  }
  
  public f getScaleType()
  {
    androidx.camera.core.impl.utils.l.a();
    return this.c.f();
  }
  
  public w1.d getSurfaceProvider()
  {
    androidx.camera.core.impl.utils.l.a();
    return this.m;
  }
  
  public i3 getViewPort()
  {
    
    if (getDisplay() == null) {
      return null;
    }
    return c(getDisplay().getRotation());
  }
  
  void i()
  {
    if (this.d)
    {
      Display localDisplay = getDisplay();
      if (localDisplay != null)
      {
        e0 locale0 = this.i;
        if (locale0 != null) {
          this.c.m(locale0.e(localDisplay.getRotation()), localDisplay.getRotation());
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i();
    g();
    addOnLayoutChangeListener(this.l);
    k localk = this.b;
    if (localk != null) {
      localk.d();
    }
    b(true);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeOnLayoutChangeListener(this.l);
    k localk = this.b;
    if (localk != null) {
      localk.e();
    }
    h();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    this.j = null;
    return super.performClick();
  }
  
  public void setController(a parama)
  {
    androidx.camera.core.impl.utils.l.a();
    b(false);
  }
  
  public void setImplementationMode(d paramd)
  {
    androidx.camera.core.impl.utils.l.a();
    this.a = paramd;
  }
  
  public void setScaleType(f paramf)
  {
    androidx.camera.core.impl.utils.l.a();
    this.c.o(paramf);
    e();
    b(false);
  }
  
  class a
    implements w1.d
  {
    a() {}
    
    public void a(u2 paramu2)
    {
      if (!androidx.camera.core.impl.utils.l.b())
      {
        b.g(PreviewView.this.getContext()).execute(new j(this, paramu2));
        return;
      }
      n1.a("PreviewView", "Surface requested by Preview.");
      g0 localg0 = paramu2.j();
      PreviewView.this.i = localg0.i();
      paramu2.w(b.g(PreviewView.this.getContext()), new h(this, localg0, paramu2));
      PreviewView localPreviewView = PreviewView.this;
      if (PreviewView.f(paramu2, localPreviewView.a))
      {
        localObject = PreviewView.this;
        localObject = new w((FrameLayout)localObject, ((PreviewView)localObject).c);
      }
      else
      {
        localObject = PreviewView.this;
        localObject = new p((FrameLayout)localObject, ((PreviewView)localObject).c);
      }
      localPreviewView.b = ((k)localObject);
      Object localObject = localg0.i();
      localPreviewView = PreviewView.this;
      localObject = new e((e0)localObject, localPreviewView.e, localPreviewView.b);
      PreviewView.this.f.set(localObject);
      localg0.l().b(b.g(PreviewView.this.getContext()), (w1.a)localObject);
      PreviewView.this.b.g(paramu2, new i(this, (e)localObject, localg0));
    }
  }
  
  class c
    implements DisplayManager.DisplayListener
  {
    c() {}
    
    public void onDisplayAdded(int paramInt) {}
    
    public void onDisplayChanged(int paramInt)
    {
      Display localDisplay = PreviewView.this.getDisplay();
      if ((localDisplay != null) && (localDisplay.getDisplayId() == paramInt))
      {
        PreviewView.this.i();
        PreviewView.this.e();
      }
    }
    
    public void onDisplayRemoved(int paramInt) {}
  }
  
  public static enum d
  {
    private final int a;
    
    static
    {
      d locald1 = new d("PERFORMANCE", 0, 0);
      b = locald1;
      d locald2 = new d("COMPATIBLE", 1, 1);
      c = locald2;
      d = new d[] { locald1, locald2 };
    }
    
    private d(int paramInt)
    {
      this.a = paramInt;
    }
    
    static d a(int paramInt)
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        d locald = localObject[i];
        if (locald.a == paramInt) {
          return locald;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown implementation mode id ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    int b()
    {
      return this.a;
    }
  }
  
  class e
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    e() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      Objects.requireNonNull(PreviewView.this);
      return true;
    }
  }
  
  public static enum f
  {
    private final int a;
    
    static
    {
      f localf1 = new f("FILL_START", 0, 0);
      b = localf1;
      f localf2 = new f("FILL_CENTER", 1, 1);
      c = localf2;
      f localf3 = new f("FILL_END", 2, 2);
      d = localf3;
      f localf4 = new f("FIT_START", 3, 3);
      e = localf4;
      f localf5 = new f("FIT_CENTER", 4, 4);
      f = localf5;
      f localf6 = new f("FIT_END", 5, 5);
      g = localf6;
      h = new f[] { localf1, localf2, localf3, localf4, localf5, localf6 };
    }
    
    private f(int paramInt)
    {
      this.a = paramInt;
    }
    
    static f a(int paramInt)
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        f localf = localObject[i];
        if (localf.a == paramInt) {
          return localf;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown scale type id ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    int b()
    {
      return this.a;
    }
  }
  
  public static enum g
  {
    static
    {
      g localg1 = new g("IDLE", 0);
      a = localg1;
      g localg2 = new g("STREAMING", 1);
      b = localg2;
      c = new g[] { localg1, localg2 };
    }
    
    private g() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.PreviewView
 * JD-Core Version:    0.7.0.1
 */