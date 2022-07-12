package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.h0;
import androidx.core.view.x;
import g.d;
import g0.g;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f
{
  private static final Class<?>[] b = { Context.class, AttributeSet.class };
  private static final int[] c = { 16843375 };
  private static final int[] d = { 16844160 };
  private static final int[] e = { 16844156 };
  private static final int[] f = { 16844148 };
  private static final String[] g = { "android.widget.", "android.view.", "android.webkit." };
  private static final g<String, Constructor<? extends View>> h = new g();
  private final Object[] a = new Object[2];
  
  private void a(Context paramContext, View paramView, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT > 28) {
      return;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, d);
    if (localTypedArray.hasValue(0)) {
      x.r0(paramView, localTypedArray.getBoolean(0, false));
    }
    localTypedArray.recycle();
    localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, e);
    if (localTypedArray.hasValue(0)) {
      x.t0(paramView, localTypedArray.getString(0));
    }
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f);
    if (paramContext.hasValue(0)) {
      x.H0(paramView, paramContext.getBoolean(0, false));
    }
    paramContext.recycle();
  }
  
  private void b(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if ((localObject instanceof ContextWrapper))
    {
      if (!x.P(paramView)) {
        return;
      }
      paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, c);
      localObject = paramAttributeSet.getString(0);
      if (localObject != null) {
        paramView.setOnClickListener(new a(paramView, (String)localObject));
      }
      paramAttributeSet.recycle();
    }
  }
  
  private View s(Context paramContext, String paramString1, String paramString2)
  {
    g localg = h;
    Constructor localConstructor = (Constructor)localg.get(paramString1);
    Object localObject = localConstructor;
    if ((localConstructor != null) || (paramString2 != null)) {}
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(paramString1);
        paramString2 = ((StringBuilder)localObject).toString();
        localObject = Class.forName(paramString2, false, paramContext.getClassLoader()).asSubclass(View.class).getConstructor(b);
        localg.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.a);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return null;
      paramString2 = paramString1;
    }
  }
  
  /* Error */
  private View t(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 178
    //   6: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: aconst_null
    //   14: ldc 184
    //   16: invokeinterface 188 3 0
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   27: astore_2
    //   28: aload_2
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aload_2
    //   33: iconst_1
    //   34: aload_3
    //   35: aastore
    //   36: iconst_m1
    //   37: aload 5
    //   39: bipush 46
    //   41: invokevirtual 192	java/lang/String:indexOf	(I)I
    //   44: if_icmpne +72 -> 116
    //   47: iconst_0
    //   48: istore 4
    //   50: getstatic 53	androidx/appcompat/app/f:g	[Ljava/lang/String;
    //   53: astore_2
    //   54: iload 4
    //   56: aload_2
    //   57: arraylength
    //   58: if_icmpge +43 -> 101
    //   61: aload_0
    //   62: aload_1
    //   63: aload 5
    //   65: aload_2
    //   66: iload 4
    //   68: aaload
    //   69: invokespecial 194	androidx/appcompat/app/f:s	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +18 -> 92
    //   77: aload_0
    //   78: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   81: astore_1
    //   82: aload_1
    //   83: iconst_0
    //   84: aconst_null
    //   85: aastore
    //   86: aload_1
    //   87: iconst_1
    //   88: aconst_null
    //   89: aastore
    //   90: aload_2
    //   91: areturn
    //   92: iload 4
    //   94: iconst_1
    //   95: iadd
    //   96: istore 4
    //   98: goto -48 -> 50
    //   101: aload_0
    //   102: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   105: astore_1
    //   106: aload_1
    //   107: iconst_0
    //   108: aconst_null
    //   109: aastore
    //   110: aload_1
    //   111: iconst_1
    //   112: aconst_null
    //   113: aastore
    //   114: aconst_null
    //   115: areturn
    //   116: aload_0
    //   117: aload_1
    //   118: aload 5
    //   120: aconst_null
    //   121: invokespecial 194	androidx/appcompat/app/f:s	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   129: astore_2
    //   130: aload_2
    //   131: iconst_0
    //   132: aconst_null
    //   133: aastore
    //   134: aload_2
    //   135: iconst_1
    //   136: aconst_null
    //   137: aastore
    //   138: aload_1
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   145: astore_2
    //   146: aload_2
    //   147: iconst_0
    //   148: aconst_null
    //   149: aastore
    //   150: aload_2
    //   151: iconst_1
    //   152: aconst_null
    //   153: aastore
    //   154: aload_1
    //   155: athrow
    //   156: aload_0
    //   157: getfield 64	androidx/appcompat/app/f:a	[Ljava/lang/Object;
    //   160: astore_1
    //   161: aload_1
    //   162: iconst_0
    //   163: aconst_null
    //   164: aastore
    //   165: aload_1
    //   166: iconst_1
    //   167: aconst_null
    //   168: aastore
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: goto -16 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	f
    //   0	175	1	paramContext	Context
    //   0	175	2	paramString	String
    //   0	175	3	paramAttributeSet	AttributeSet
    //   48	49	4	i	int
    //   1	118	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	28	140	finally
    //   36	47	140	finally
    //   50	73	140	finally
    //   116	125	140	finally
    //   23	28	171	java/lang/Exception
    //   36	47	171	java/lang/Exception
    //   50	73	171	java/lang/Exception
    //   116	125	171	java/lang/Exception
  }
  
  private static Context u(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i;
    if (paramBoolean1) {
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    } else {
      i = 0;
    }
    int j = i;
    if (paramBoolean2)
    {
      j = i;
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0)
        {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        }
      }
    }
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (j != 0) {
      if ((paramContext instanceof d))
      {
        paramAttributeSet = paramContext;
        if (((d)paramContext).c() == j) {}
      }
      else
      {
        paramAttributeSet = new d(paramContext, j);
      }
    }
    return paramAttributeSet;
  }
  
  private void v(View paramView, String paramString)
  {
    if (paramView != null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append(getClass().getName());
    paramView.append(" asked to inflate view for <");
    paramView.append(paramString);
    paramView.append(">, but returned null");
    throw new IllegalStateException(paramView.toString());
  }
  
  protected AppCompatAutoCompleteTextView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatButton d(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatCheckBox e(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckBox(paramContext, paramAttributeSet);
  }
  
  protected AppCompatCheckedTextView f(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckedTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatEditText g(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatEditText(paramContext, paramAttributeSet);
  }
  
  protected AppCompatImageButton h(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatImageView i(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatMultiAutoCompleteTextView j(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatRadioButton k(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRadioButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatRatingBar l(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRatingBar(paramContext, paramAttributeSet);
  }
  
  protected AppCompatSeekBar m(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSeekBar(paramContext, paramAttributeSet);
  }
  
  protected AppCompatSpinner n(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSpinner(paramContext, paramAttributeSet);
  }
  
  protected AppCompatTextView o(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatToggleButton p(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatToggleButton(paramContext, paramAttributeSet);
  }
  
  protected View q(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  final View r(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (paramView != null)) {
      localObject = paramView.getContext();
    } else {
      localObject = paramContext;
    }
    if (!paramBoolean2)
    {
      paramView = (View)localObject;
      if (!paramBoolean3) {}
    }
    else
    {
      paramView = u((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    Object localObject = paramView;
    if (paramBoolean4) {
      localObject = h0.b(paramView);
    }
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        i = 13;
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        i = 12;
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        i = 11;
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        i = 10;
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        i = 9;
      }
      break;
    case 799298502: 
      if (paramString.equals("ToggleButton")) {
        i = 8;
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        i = 7;
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        i = 6;
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        i = 5;
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        i = 4;
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        i = 3;
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        i = 2;
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        i = 1;
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramView = q((Context)localObject, paramString, paramAttributeSet);
      break;
    case 13: 
      paramView = d((Context)localObject, paramAttributeSet);
      break;
    case 12: 
      paramView = g((Context)localObject, paramAttributeSet);
      break;
    case 11: 
      paramView = e((Context)localObject, paramAttributeSet);
      break;
    case 10: 
      paramView = c((Context)localObject, paramAttributeSet);
      break;
    case 9: 
      paramView = i((Context)localObject, paramAttributeSet);
      break;
    case 8: 
      paramView = p((Context)localObject, paramAttributeSet);
      break;
    case 7: 
      paramView = k((Context)localObject, paramAttributeSet);
      break;
    case 6: 
      paramView = n((Context)localObject, paramAttributeSet);
      break;
    case 5: 
      paramView = m((Context)localObject, paramAttributeSet);
      break;
    case 4: 
      paramView = h((Context)localObject, paramAttributeSet);
      break;
    case 3: 
      paramView = o((Context)localObject, paramAttributeSet);
    }
    for (;;)
    {
      v(paramView, paramString);
      break;
      paramView = j((Context)localObject, paramAttributeSet);
      continue;
      paramView = f((Context)localObject, paramAttributeSet);
      continue;
      paramView = l((Context)localObject, paramAttributeSet);
    }
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramView;
      if (paramContext != localObject) {
        localView = t((Context)localObject, paramString, paramAttributeSet);
      }
    }
    if (localView != null)
    {
      b(localView, paramAttributeSet);
      a((Context)localObject, localView, paramAttributeSet);
    }
    return localView;
  }
  
  private static class a
    implements View.OnClickListener
  {
    private final View a;
    private final String b;
    private Method c;
    private Context d;
    
    public a(View paramView, String paramString)
    {
      this.a = paramView;
      this.b = paramString;
    }
    
    private void a(Context paramContext)
    {
      while (paramContext != null)
      {
        try
        {
          if (!paramContext.isRestricted())
          {
            localObject = paramContext.getClass().getMethod(this.b, new Class[] { View.class });
            if (localObject != null)
            {
              this.c = ((Method)localObject);
              this.d = paramContext;
              return;
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Object localObject;
          label47:
          int i;
          break label47;
        }
        if ((paramContext instanceof ContextWrapper)) {
          paramContext = ((ContextWrapper)paramContext).getBaseContext();
        } else {
          paramContext = null;
        }
      }
      i = this.a.getId();
      if (i == -1)
      {
        paramContext = "";
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(" with id '");
        paramContext.append(this.a.getContext().getResources().getResourceEntryName(i));
        paramContext.append("'");
        paramContext = paramContext.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find method ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
      ((StringBuilder)localObject).append(this.a.getClass());
      ((StringBuilder)localObject).append(paramContext);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    public void onClick(View paramView)
    {
      if (this.c == null) {
        a(this.a.getContext());
      }
      try
      {
        this.c.invoke(this.d, new Object[] { paramView });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new IllegalStateException("Could not execute method for android:onClick", paramView);
      }
      catch (IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.f
 * JD-Core Version:    0.7.0.1
 */