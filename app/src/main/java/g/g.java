package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R.styleable;
import androidx.core.view.b;
import androidx.core.view.j;
import h.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class g
  extends MenuInflater
{
  static final Class<?>[] e;
  static final Class<?>[] f;
  final Object[] a;
  final Object[] b;
  Context c;
  private Object d;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    e = arrayOfClass;
    f = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    this.a = arrayOfObject;
    this.b = arrayOfObject;
  }
  
  private Object a(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {
      return paramObject;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ContextWrapper)) {
      localObject = a(((ContextWrapper)paramObject).getBaseContext());
    }
    return localObject;
  }
  
  private void c(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    do
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu"))
        {
          i = paramXmlPullParser.next();
          break;
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append("Expecting menu, got ");
        paramXmlPullParser.append(paramMenu);
        throw new RuntimeException(paramXmlPullParser.toString());
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    i = j;
    Object localObject = null;
    int j = 0;
    int k = j;
    while (j == 0) {
      if (i != 1)
      {
        int m;
        if (i != 2)
        {
          if (i != 3)
          {
            m = j;
            i = k;
            paramMenu = (Menu)localObject;
          }
          else
          {
            String str = paramXmlPullParser.getName();
            if ((k != 0) && (str.equals(localObject)))
            {
              paramMenu = null;
              i = 0;
              m = j;
            }
            else if (str.equals("group"))
            {
              localb.h();
              m = j;
              i = k;
              paramMenu = (Menu)localObject;
            }
            else if (str.equals("item"))
            {
              m = j;
              i = k;
              paramMenu = (Menu)localObject;
              if (!localb.d())
              {
                paramMenu = localb.A;
                if ((paramMenu != null) && (paramMenu.b()))
                {
                  localb.b();
                  m = j;
                  i = k;
                  paramMenu = (Menu)localObject;
                }
                else
                {
                  localb.a();
                  m = j;
                  i = k;
                  paramMenu = (Menu)localObject;
                }
              }
            }
            else
            {
              m = j;
              i = k;
              paramMenu = (Menu)localObject;
              if (str.equals("menu"))
              {
                m = 1;
                i = k;
                paramMenu = (Menu)localObject;
              }
            }
          }
        }
        else if (k != 0)
        {
          m = j;
          i = k;
          paramMenu = (Menu)localObject;
        }
        else
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            localb.f(paramAttributeSet);
            m = j;
            i = k;
            paramMenu = (Menu)localObject;
          }
          else if (paramMenu.equals("item"))
          {
            localb.g(paramAttributeSet);
            m = j;
            i = k;
            paramMenu = (Menu)localObject;
          }
          else if (paramMenu.equals("menu"))
          {
            c(paramXmlPullParser, paramAttributeSet, localb.b());
            m = j;
            i = k;
            paramMenu = (Menu)localObject;
          }
          else
          {
            i = 1;
            m = j;
          }
        }
        int n = paramXmlPullParser.next();
        j = m;
        k = i;
        localObject = paramMenu;
        i = n;
      }
      else
      {
        throw new RuntimeException("Unexpected end of document");
      }
    }
  }
  
  Object b()
  {
    if (this.d == null) {
      this.d = a(this.c);
    }
    return this.d;
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 140
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 142	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 36	g/g:c	Landroid/content/Context;
    //   26: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 152	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore_3
    //   38: aload 6
    //   40: astore 4
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 158	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 127	g/g:c	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull +10 -> 70
    //   63: aload 6
    //   65: invokeinterface 163 1 0
    //   70: return
    //   71: astore_2
    //   72: goto +33 -> 105
    //   75: astore_2
    //   76: aload 4
    //   78: astore_3
    //   79: new 165	android/view/InflateException
    //   82: dup
    //   83: ldc 167
    //   85: aload_2
    //   86: invokespecial 170	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_2
    //   91: aload 5
    //   93: astore_3
    //   94: new 165	android/view/InflateException
    //   97: dup
    //   98: ldc 167
    //   100: aload_2
    //   101: invokespecial 170	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 163 1 0
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	g
    //   0	117	1	paramInt	int
    //   0	117	2	paramMenu	Menu
    //   21	89	3	localObject1	Object
    //   15	62	4	localObject2	Object
    //   18	74	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	finally
    //   46	58	71	finally
    //   79	90	71	finally
    //   94	105	71	finally
    //   22	35	75	java/io/IOException
    //   46	58	75	java/io/IOException
    //   22	35	90	org/xmlpull/v1/XmlPullParserException
    //   46	58	90	org/xmlpull/v1/XmlPullParserException
  }
  
  private static class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] c = { MenuItem.class };
    private Object a;
    private Method b;
    
    public a(Object paramObject, String paramString)
    {
      this.a = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.b = localClass.getMethod(paramString, c);
        return;
      }
      catch (Exception paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Couldn't resolve menu item onClick handler ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" in class ");
        localStringBuilder.append(localClass.getName());
        paramString = new InflateException(localStringBuilder.toString());
        paramString.initCause(paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.b.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.b.invoke(this.a, new Object[] { paramMenuItem })).booleanValue();
        }
        this.b.invoke(this.a, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private class b
  {
    b A;
    private CharSequence B;
    private CharSequence C;
    private ColorStateList D = null;
    private PorterDuff.Mode E = null;
    private Menu a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private CharSequence k;
    private CharSequence l;
    private int m;
    private char n;
    private int o;
    private char p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private String x;
    private String y;
    private String z;
    
    public b(Menu paramMenu)
    {
      this.a = paramMenu;
      h();
    }
    
    private char c(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T e(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = Class.forName(paramString, false, g.this.c.getClassLoader()).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("Cannot instantiate class: ");
        paramArrayOfObject.append(paramString);
        Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
      }
      return null;
    }
    
    private void i(MenuItem paramMenuItem)
    {
      Object localObject = paramMenuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u);
      int i2 = this.r;
      int i1 = 0;
      boolean bool;
      if (i2 >= 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.l).setIcon(this.m);
      i2 = this.v;
      if (i2 >= 0) {
        paramMenuItem.setShowAsAction(i2);
      }
      if (this.z != null) {
        if (!g.this.c.isRestricted()) {
          paramMenuItem.setOnMenuItemClickListener(new g.a(g.this.b(), this.z));
        } else {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
      }
      if (this.r >= 2) {
        if ((paramMenuItem instanceof androidx.appcompat.view.menu.g)) {
          ((androidx.appcompat.view.menu.g)paramMenuItem).t(true);
        } else if ((paramMenuItem instanceof c)) {
          ((c)paramMenuItem).h(true);
        }
      }
      localObject = this.x;
      if (localObject != null)
      {
        paramMenuItem.setActionView((View)e((String)localObject, g.e, g.this.a));
        i1 = 1;
      }
      i2 = this.w;
      if (i2 > 0) {
        if (i1 == 0) {
          paramMenuItem.setActionView(i2);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
      }
      localObject = this.A;
      if (localObject != null) {
        j.a(paramMenuItem, (b)localObject);
      }
      j.c(paramMenuItem, this.B);
      j.g(paramMenuItem, this.C);
      j.b(paramMenuItem, this.n, this.o);
      j.f(paramMenuItem, this.p, this.q);
      localObject = this.E;
      if (localObject != null) {
        j.e(paramMenuItem, (PorterDuff.Mode)localObject);
      }
      localObject = this.D;
      if (localObject != null) {
        j.d(paramMenuItem, (ColorStateList)localObject);
      }
    }
    
    public void a()
    {
      this.h = true;
      i(this.a.add(this.b, this.i, this.j, this.k));
    }
    
    public SubMenu b()
    {
      this.h = true;
      SubMenu localSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
      i(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean d()
    {
      return this.h;
    }
    
    public void f(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = g.this.c.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
      this.b = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.c = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.d = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.e = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.f = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.g = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public void g(AttributeSet paramAttributeSet)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public void h()
    {
      this.b = 0;
      this.c = 0;
      this.d = 0;
      this.e = 0;
      this.f = true;
      this.g = true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.g
 * JD-Core Version:    0.7.0.1
 */