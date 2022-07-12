package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p0.i;

public class c
  extends g
  implements Animatable
{
  private b b;
  private Context c;
  private ArgbEvaluator d = null;
  private Animator.AnimatorListener e = null;
  ArrayList<b> f = null;
  final Drawable.Callback g;
  
  c()
  {
    this(null, null, null);
  }
  
  private c(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  private c(Context paramContext, b paramb, Resources paramResources)
  {
    a locala = new a();
    this.g = locala;
    this.c = paramContext;
    if (paramb != null)
    {
      this.b = paramb;
      return;
    }
    this.b = new b(paramContext, paramb, locala, paramResources);
  }
  
  public static c a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void b(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.b.b.d(paramString));
    b localb = this.b;
    if (localb.d == null)
    {
      localb.d = new ArrayList();
      this.b.e = new g0.a();
    }
    this.b.d.add(paramAnimator);
    this.b.e.put(paramAnimator, paramString);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      r0.a.a(localDrawable, paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.b(localDrawable);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    this.b.b.draw(paramCanvas);
    if (this.b.c.isStarted()) {
      invalidateSelf();
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.d(localDrawable);
    }
    return this.b.b.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.b.a;
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.e(localDrawable);
    }
    return this.b.b.getColorFilter();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.a != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new c(this.a.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return this.b.b.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.b.b.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return this.b.b.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      r0.a.g((Drawable)localObject1, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        TypedArray localTypedArray;
        Object localObject2;
        if ("animated-vector".equals(localObject1))
        {
          localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, a.e);
          i = localTypedArray.getResourceId(0, 0);
          localObject1 = localTypedArray;
          if (i != 0)
          {
            localObject1 = h.b(paramResources, i, paramTheme);
            ((h)localObject1).h(false);
            ((Drawable)localObject1).setCallback(this.g);
            localObject2 = this.b.b;
            if (localObject2 != null) {
              ((Drawable)localObject2).setCallback(null);
            }
            this.b.b = ((h)localObject1);
            localObject1 = localTypedArray;
          }
        }
        for (;;)
        {
          ((TypedArray)localObject1).recycle();
          break label276;
          if (!"target".equals(localObject1)) {
            break label276;
          }
          localTypedArray = paramResources.obtainAttributes(paramAttributeSet, a.f);
          localObject2 = localTypedArray.getString(0);
          i = localTypedArray.getResourceId(1, 0);
          localObject1 = localTypedArray;
          if (i != 0)
          {
            localObject1 = this.c;
            if (localObject1 == null) {
              break;
            }
            b((String)localObject2, e.i((Context)localObject1, i));
            localObject1 = localTypedArray;
          }
        }
        localTypedArray.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
      }
      label276:
      i = paramXmlPullParser.next();
    }
    this.b.a();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.h(localDrawable);
    }
    return this.b.b.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return ((AnimatedVectorDrawable)localDrawable).isRunning();
    }
    return this.b.c.isRunning();
  }
  
  public boolean isStateful()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.isStateful();
    }
    return this.b.b.isStateful();
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    this.b.b.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return this.b.b.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return this.b.b.setState(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    this.b.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.j(localDrawable, paramBoolean);
      return;
    }
    this.b.b.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.b.b.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.n(localDrawable, paramInt);
      return;
    }
    this.b.b.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.o(localDrawable, paramColorStateList);
      return;
    }
    this.b.b.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.p(localDrawable, paramMode);
      return;
    }
    this.b.b.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    this.b.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).start();
      return;
    }
    if (this.b.c.isStarted()) {
      return;
    }
    this.b.c.start();
    invalidateSelf();
  }
  
  public void stop()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).stop();
      return;
    }
    this.b.c.end();
  }
  
  class a
    implements Drawable.Callback
  {
    a() {}
    
    public void invalidateDrawable(Drawable paramDrawable)
    {
      c.this.invalidateSelf();
    }
    
    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      c.this.scheduleSelf(paramRunnable, paramLong);
    }
    
    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      c.this.unscheduleSelf(paramRunnable);
    }
  }
  
  private static class b
    extends Drawable.ConstantState
  {
    int a;
    h b;
    AnimatorSet c;
    ArrayList<Animator> d;
    g0.a<Animator, String> e;
    
    public b(Context paramContext, b paramb, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (paramb != null)
      {
        this.a = paramb.a;
        paramContext = paramb.b;
        int i = 0;
        if (paramContext != null)
        {
          paramContext = paramContext.getConstantState();
          if (paramResources != null) {
            paramContext = paramContext.newDrawable(paramResources);
          } else {
            paramContext = paramContext.newDrawable();
          }
          this.b = ((h)paramContext);
          paramContext = (h)this.b.mutate();
          this.b = paramContext;
          paramContext.setCallback(paramCallback);
          this.b.setBounds(paramb.b.getBounds());
          this.b.h(false);
        }
        paramContext = paramb.d;
        if (paramContext != null)
        {
          int j = paramContext.size();
          this.d = new ArrayList(j);
          this.e = new g0.a(j);
          while (i < j)
          {
            paramCallback = (Animator)paramb.d.get(i);
            paramContext = paramCallback.clone();
            paramCallback = (String)paramb.e.get(paramCallback);
            paramContext.setTarget(this.b.d(paramCallback));
            this.d.add(paramContext);
            this.e.put(paramContext, paramCallback);
            i += 1;
          }
          a();
        }
      }
    }
    
    public void a()
    {
      if (this.c == null) {
        this.c = new AnimatorSet();
      }
      this.c.playTogether(this.d);
    }
    
    public int getChangingConfigurations()
    {
      return this.a;
    }
    
    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
  }
  
  private static class c
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public c(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      c localc = new c();
      Drawable localDrawable = this.a.newDrawable();
      localc.a = localDrawable;
      localDrawable.setCallback(localc.g);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      paramResources = this.a.newDrawable(paramResources);
      localc.a = paramResources;
      paramResources.setCallback(localc.g);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      paramResources = this.a.newDrawable(paramResources, paramTheme);
      localc.a = paramResources;
      paramResources.setCallback(localc.g);
      return localc;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.c
 * JD-Core Version:    0.7.0.1
 */