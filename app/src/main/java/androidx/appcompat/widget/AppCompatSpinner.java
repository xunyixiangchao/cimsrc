package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R.attr;
import androidx.appcompat.app.b;
import androidx.appcompat.app.b.a;
import androidx.core.view.x;
import c.a;

public class AppCompatSpinner
  extends Spinner
{
  private static final int[] i = { 16843505 };
  private final d a;
  private final Context b;
  private w c;
  private SpinnerAdapter d;
  private final boolean e;
  private f f;
  int g;
  final Rect h;
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 70	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 72	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 74	android/graphics/Rect:<init>	()V
    //   15: putfield 76	androidx/appcompat/widget/AppCompatSpinner:h	Landroid/graphics/Rect;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 80	android/widget/Spinner:getContext	()Landroid/content/Context;
    //   23: invokestatic 85	androidx/appcompat/widget/f0:a	(Landroid/view/View;Landroid/content/Context;)V
    //   26: aload_1
    //   27: aload_2
    //   28: getstatic 90	androidx/appcompat/R$styleable:Spinner	[I
    //   31: iload_3
    //   32: iconst_0
    //   33: invokestatic 96	androidx/appcompat/widget/k0:v	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/k0;
    //   36: astore 9
    //   38: aload_0
    //   39: new 98	androidx/appcompat/widget/d
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 101	androidx/appcompat/widget/d:<init>	(Landroid/view/View;)V
    //   47: putfield 103	androidx/appcompat/widget/AppCompatSpinner:a	Landroidx/appcompat/widget/d;
    //   50: aload 5
    //   52: ifnull +24 -> 76
    //   55: new 105	g/d
    //   58: dup
    //   59: aload_1
    //   60: aload 5
    //   62: invokespecial 108	g/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   65: astore 5
    //   67: aload_0
    //   68: aload 5
    //   70: putfield 110	androidx/appcompat/widget/AppCompatSpinner:b	Landroid/content/Context;
    //   73: goto +39 -> 112
    //   76: aload 9
    //   78: getstatic 113	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   81: iconst_0
    //   82: invokevirtual 117	androidx/appcompat/widget/k0:n	(II)I
    //   85: istore 6
    //   87: iload 6
    //   89: ifeq +18 -> 107
    //   92: new 105	g/d
    //   95: dup
    //   96: aload_1
    //   97: iload 6
    //   99: invokespecial 120	g/d:<init>	(Landroid/content/Context;I)V
    //   102: astore 5
    //   104: goto -37 -> 67
    //   107: aload_0
    //   108: aload_1
    //   109: putfield 110	androidx/appcompat/widget/AppCompatSpinner:b	Landroid/content/Context;
    //   112: aconst_null
    //   113: astore 7
    //   115: iload 4
    //   117: istore 6
    //   119: iload 4
    //   121: iconst_m1
    //   122: if_icmpne +122 -> 244
    //   125: aload_1
    //   126: aload_2
    //   127: getstatic 50	androidx/appcompat/widget/AppCompatSpinner:i	[I
    //   130: iload_3
    //   131: iconst_0
    //   132: invokevirtual 126	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   135: astore 5
    //   137: iload 4
    //   139: istore 6
    //   141: aload 5
    //   143: astore 8
    //   145: aload 5
    //   147: astore 7
    //   149: aload 5
    //   151: iconst_0
    //   152: invokevirtual 132	android/content/res/TypedArray:hasValue	(I)Z
    //   155: ifeq +20 -> 175
    //   158: aload 5
    //   160: astore 7
    //   162: aload 5
    //   164: iconst_0
    //   165: iconst_0
    //   166: invokevirtual 135	android/content/res/TypedArray:getInt	(II)I
    //   169: istore 6
    //   171: aload 5
    //   173: astore 8
    //   175: aload 8
    //   177: invokevirtual 138	android/content/res/TypedArray:recycle	()V
    //   180: goto +64 -> 244
    //   183: astore 8
    //   185: goto +12 -> 197
    //   188: astore_1
    //   189: goto +43 -> 232
    //   192: astore 8
    //   194: aconst_null
    //   195: astore 5
    //   197: aload 5
    //   199: astore 7
    //   201: ldc 140
    //   203: ldc 142
    //   205: aload 8
    //   207: invokestatic 147	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   210: pop
    //   211: iload 4
    //   213: istore 6
    //   215: aload 5
    //   217: ifnull +27 -> 244
    //   220: iload 4
    //   222: istore 6
    //   224: aload 5
    //   226: astore 8
    //   228: goto -53 -> 175
    //   231: astore_1
    //   232: aload 7
    //   234: ifnull +8 -> 242
    //   237: aload 7
    //   239: invokevirtual 138	android/content/res/TypedArray:recycle	()V
    //   242: aload_1
    //   243: athrow
    //   244: iload 6
    //   246: ifeq +112 -> 358
    //   249: iload 6
    //   251: iconst_1
    //   252: if_icmpeq +6 -> 258
    //   255: goto +134 -> 389
    //   258: new 21	androidx/appcompat/widget/AppCompatSpinner$e
    //   261: dup
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 110	androidx/appcompat/widget/AppCompatSpinner:b	Landroid/content/Context;
    //   267: aload_2
    //   268: iload_3
    //   269: invokespecial 150	androidx/appcompat/widget/AppCompatSpinner$e:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   272: astore 5
    //   274: aload_0
    //   275: getfield 110	androidx/appcompat/widget/AppCompatSpinner:b	Landroid/content/Context;
    //   278: aload_2
    //   279: getstatic 90	androidx/appcompat/R$styleable:Spinner	[I
    //   282: iload_3
    //   283: iconst_0
    //   284: invokestatic 96	androidx/appcompat/widget/k0:v	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/k0;
    //   287: astore 7
    //   289: aload_0
    //   290: aload 7
    //   292: getstatic 153	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   295: bipush 254
    //   297: invokevirtual 156	androidx/appcompat/widget/k0:m	(II)I
    //   300: putfield 158	androidx/appcompat/widget/AppCompatSpinner:g	I
    //   303: aload 5
    //   305: aload 7
    //   307: getstatic 161	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   310: invokevirtual 164	androidx/appcompat/widget/k0:g	(I)Landroid/graphics/drawable/Drawable;
    //   313: invokevirtual 169	androidx/appcompat/widget/ListPopupWindow:b	(Landroid/graphics/drawable/Drawable;)V
    //   316: aload 5
    //   318: aload 9
    //   320: getstatic 172	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   323: invokevirtual 176	androidx/appcompat/widget/k0:o	(I)Ljava/lang/String;
    //   326: invokevirtual 179	androidx/appcompat/widget/AppCompatSpinner$e:i	(Ljava/lang/CharSequence;)V
    //   329: aload 7
    //   331: invokevirtual 182	androidx/appcompat/widget/k0:w	()V
    //   334: aload_0
    //   335: aload 5
    //   337: putfield 184	androidx/appcompat/widget/AppCompatSpinner:f	Landroidx/appcompat/widget/AppCompatSpinner$f;
    //   340: aload_0
    //   341: new 11	androidx/appcompat/widget/AppCompatSpinner$a
    //   344: dup
    //   345: aload_0
    //   346: aload_0
    //   347: aload 5
    //   349: invokespecial 187	androidx/appcompat/widget/AppCompatSpinner$a:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$e;)V
    //   352: putfield 189	androidx/appcompat/widget/AppCompatSpinner:c	Landroidx/appcompat/widget/w;
    //   355: goto +34 -> 389
    //   358: new 15	androidx/appcompat/widget/AppCompatSpinner$c
    //   361: dup
    //   362: aload_0
    //   363: invokespecial 192	androidx/appcompat/widget/AppCompatSpinner$c:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   366: astore 5
    //   368: aload_0
    //   369: aload 5
    //   371: putfield 184	androidx/appcompat/widget/AppCompatSpinner:f	Landroidx/appcompat/widget/AppCompatSpinner$f;
    //   374: aload 5
    //   376: aload 9
    //   378: getstatic 172	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   381: invokevirtual 176	androidx/appcompat/widget/k0:o	(I)Ljava/lang/String;
    //   384: invokeinterface 193 2 0
    //   389: aload 9
    //   391: getstatic 196	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   394: invokevirtual 200	androidx/appcompat/widget/k0:q	(I)[Ljava/lang/CharSequence;
    //   397: astore 5
    //   399: aload 5
    //   401: ifnull +28 -> 429
    //   404: new 202	android/widget/ArrayAdapter
    //   407: dup
    //   408: aload_1
    //   409: ldc 203
    //   411: aload 5
    //   413: invokespecial 206	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   416: astore_1
    //   417: aload_1
    //   418: getstatic 211	androidx/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   421: invokevirtual 215	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   424: aload_0
    //   425: aload_1
    //   426: invokevirtual 219	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   429: aload 9
    //   431: invokevirtual 182	androidx/appcompat/widget/k0:w	()V
    //   434: aload_0
    //   435: iconst_1
    //   436: putfield 221	androidx/appcompat/widget/AppCompatSpinner:e	Z
    //   439: aload_0
    //   440: getfield 223	androidx/appcompat/widget/AppCompatSpinner:d	Landroid/widget/SpinnerAdapter;
    //   443: astore_1
    //   444: aload_1
    //   445: ifnull +13 -> 458
    //   448: aload_0
    //   449: aload_1
    //   450: invokevirtual 219	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   453: aload_0
    //   454: aconst_null
    //   455: putfield 223	androidx/appcompat/widget/AppCompatSpinner:d	Landroid/widget/SpinnerAdapter;
    //   458: aload_0
    //   459: getfield 103	androidx/appcompat/widget/AppCompatSpinner:a	Landroidx/appcompat/widget/d;
    //   462: aload_2
    //   463: iload_3
    //   464: invokevirtual 226	androidx/appcompat/widget/d:e	(Landroid/util/AttributeSet;I)V
    //   467: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AppCompatSpinner
    //   0	468	1	paramContext	Context
    //   0	468	2	paramAttributeSet	AttributeSet
    //   0	468	3	paramInt1	int
    //   0	468	4	paramInt2	int
    //   0	468	5	paramTheme	Resources.Theme
    //   85	168	6	j	int
    //   113	217	7	localObject	Object
    //   143	33	8	localTheme1	Resources.Theme
    //   183	1	8	localException1	java.lang.Exception
    //   192	14	8	localException2	java.lang.Exception
    //   226	1	8	localTheme2	Resources.Theme
    //   36	394	9	localk0	k0
    // Exception table:
    //   from	to	target	type
    //   149	158	183	java/lang/Exception
    //   162	171	183	java/lang/Exception
    //   125	137	188	finally
    //   125	137	192	java/lang/Exception
    //   149	158	231	finally
    //   162	171	231	finally
    //   201	211	231	finally
  }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int m = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int j = Math.max(0, getSelectedItemPosition());
    int i4 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
    int k = Math.max(0, j - (15 - (i4 - j)));
    View localView = null;
    j = 0;
    while (k < i4)
    {
      int i1 = paramSpinnerAdapter.getItemViewType(k);
      int n = m;
      if (i1 != m)
      {
        localView = null;
        n = i1;
      }
      localView = paramSpinnerAdapter.getView(k, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i2, i3);
      j = Math.max(j, localView.getMeasuredWidth());
      k += 1;
      m = n;
    }
    k = j;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.h);
      paramSpinnerAdapter = this.h;
      k = j + (paramSpinnerAdapter.left + paramSpinnerAdapter.right);
    }
    return k;
  }
  
  void b()
  {
    this.f.m(getTextDirection(), getTextAlignment());
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    d locald = this.a;
    if (locald != null) {
      locald.b();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    f localf = this.f;
    if (localf != null) {
      return localf.d();
    }
    return super.getDropDownHorizontalOffset();
  }
  
  public int getDropDownVerticalOffset()
  {
    f localf = this.f;
    if (localf != null) {
      return localf.n();
    }
    return super.getDropDownVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    if (this.f != null) {
      return this.g;
    }
    return super.getDropDownWidth();
  }
  
  final f getInternalPopup()
  {
    return this.f;
  }
  
  public Drawable getPopupBackground()
  {
    f localf = this.f;
    if (localf != null) {
      return localf.g();
    }
    return super.getPopupBackground();
  }
  
  public Context getPopupContext()
  {
    return this.b;
  }
  
  public CharSequence getPrompt()
  {
    f localf = this.f;
    if (localf != null) {
      return localf.o();
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f localf = this.f;
    if ((localf != null) && (localf.c())) {
      this.f.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.f != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.a)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new b());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    f localf = this.f;
    boolean bool;
    if ((localf != null) && (localf.c())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.a = bool;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    w localw = this.c;
    if ((localw != null) && (localw.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    f localf = this.f;
    if (localf != null)
    {
      if (!localf.c()) {
        b();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.e)
    {
      this.d = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.f != null)
    {
      Context localContext2 = this.b;
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      this.f.p(new d(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.a;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.a;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    f localf = this.f;
    if (localf != null)
    {
      localf.k(paramInt);
      this.f.l(paramInt);
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    f localf = this.f;
    if (localf != null)
    {
      localf.j(paramInt);
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.f != null)
    {
      this.g = paramInt;
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    f localf = this.f;
    if (localf != null)
    {
      localf.b(paramDrawable);
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.b(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    f localf = this.f;
    if (localf != null)
    {
      localf.i(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.a;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.a;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean a;
    
    SavedState(Parcel paramParcel)
    {
      super();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeByte((byte)this.a);
    }
    
    class a
      implements Parcelable.Creator<AppCompatSpinner.SavedState>
    {
      public AppCompatSpinner.SavedState a(Parcel paramParcel)
      {
        return new AppCompatSpinner.SavedState(paramParcel);
      }
      
      public AppCompatSpinner.SavedState[] b(int paramInt)
      {
        return new AppCompatSpinner.SavedState[paramInt];
      }
    }
  }
  
  class a
    extends w
  {
    a(View paramView, AppCompatSpinner.e parame)
    {
      super();
    }
    
    public h.e b()
    {
      return paramTheme;
    }
    
    @SuppressLint({"SyntheticAccessor"})
    public boolean c()
    {
      if (!AppCompatSpinner.this.getInternalPopup().c()) {
        AppCompatSpinner.this.b();
      }
      return true;
    }
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      if (!AppCompatSpinner.this.getInternalPopup().c()) {
        AppCompatSpinner.this.b();
      }
      ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
  }
  
  class c
    implements AppCompatSpinner.f, DialogInterface.OnClickListener
  {
    b a;
    private ListAdapter b;
    private CharSequence c;
    
    c() {}
    
    public void b(Drawable paramDrawable)
    {
      Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }
    
    public boolean c()
    {
      b localb = this.a;
      if (localb != null) {
        return localb.isShowing();
      }
      return false;
    }
    
    public int d()
    {
      return 0;
    }
    
    public void dismiss()
    {
      b localb = this.a;
      if (localb != null)
      {
        localb.dismiss();
        this.a = null;
      }
    }
    
    public Drawable g()
    {
      return null;
    }
    
    public void i(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
    }
    
    public void j(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
    
    public void k(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
    
    public void l(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }
    
    public void m(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      Object localObject = new b.a(AppCompatSpinner.this.getPopupContext());
      CharSequence localCharSequence = this.c;
      if (localCharSequence != null) {
        ((b.a)localObject).h(localCharSequence);
      }
      localObject = ((b.a)localObject).g(this.b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
      this.a = ((b)localObject);
      localObject = ((b)localObject).e();
      ((ListView)localObject).setTextDirection(paramInt1);
      ((ListView)localObject).setTextAlignment(paramInt2);
      this.a.show();
    }
    
    public int n()
    {
      return 0;
    }
    
    public CharSequence o()
    {
      return this.c;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppCompatSpinner.this.setSelection(paramInt);
      if (AppCompatSpinner.this.getOnItemClickListener() != null) {
        AppCompatSpinner.this.performItemClick(null, paramInt, this.b.getItemId(paramInt));
      }
      dismiss();
    }
    
    public void p(ListAdapter paramListAdapter)
    {
      this.b = paramListAdapter;
    }
  }
  
  private static class d
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter a;
    private ListAdapter b;
    
    public d(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.a = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.b = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null) {
        if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
        else if ((paramSpinnerAdapter instanceof g0))
        {
          paramSpinnerAdapter = (g0)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return 0;
      }
      return localSpinnerAdapter.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return -1L;
      }
      return localSpinnerAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  class e
    extends ListPopupWindow
    implements AppCompatSpinner.f
  {
    private CharSequence K;
    ListAdapter L;
    private final Rect M = new Rect();
    private int N;
    
    public e(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      D(AppCompatSpinner.this);
      J(true);
      O(0);
      L(new a(AppCompatSpinner.this));
    }
    
    void S()
    {
      Object localObject = g();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.h);
        if (r0.b(AppCompatSpinner.this)) {
          i = AppCompatSpinner.this.h.right;
        } else {
          i = -AppCompatSpinner.this.h.left;
        }
      }
      else
      {
        localObject = AppCompatSpinner.this.h;
        ((Rect)localObject).right = 0;
        ((Rect)localObject).left = 0;
      }
      int n = AppCompatSpinner.this.getPaddingLeft();
      int i1 = AppCompatSpinner.this.getPaddingRight();
      int i2 = AppCompatSpinner.this.getWidth();
      localObject = AppCompatSpinner.this;
      int j = ((AppCompatSpinner)localObject).g;
      if (j == -2)
      {
        int k = ((AppCompatSpinner)localObject).a((SpinnerAdapter)this.L, g());
        j = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
        localObject = AppCompatSpinner.this.h;
        int m = j - ((Rect)localObject).left - ((Rect)localObject).right;
        j = k;
        if (k > m) {
          j = m;
        }
        j = Math.max(j, i2 - n - i1);
      }
      else
      {
        if (j != -1) {
          break label238;
        }
        j = i2 - n - i1;
      }
      F(j);
      break label243;
      label238:
      F(j);
      label243:
      if (r0.b(AppCompatSpinner.this)) {
        i += i2 - i1 - z() - T();
      } else {
        i += n + T();
      }
      l(i);
    }
    
    public int T()
    {
      return this.N;
    }
    
    boolean U(View paramView)
    {
      return (x.T(paramView)) && (paramView.getGlobalVisibleRect(this.M));
    }
    
    public void i(CharSequence paramCharSequence)
    {
      this.K = paramCharSequence;
    }
    
    public void k(int paramInt)
    {
      this.N = paramInt;
    }
    
    public void m(int paramInt1, int paramInt2)
    {
      boolean bool = c();
      S();
      I(2);
      super.a();
      Object localObject = h();
      ((ListView)localObject).setChoiceMode(1);
      ((ListView)localObject).setTextDirection(paramInt1);
      ((ListView)localObject).setTextAlignment(paramInt2);
      P(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {
        return;
      }
      localObject = AppCompatSpinner.this.getViewTreeObserver();
      if (localObject != null)
      {
        final b localb = new b();
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(localb);
        K(new c(localb));
      }
    }
    
    public CharSequence o()
    {
      return this.K;
    }
    
    public void p(ListAdapter paramListAdapter)
    {
      super.p(paramListAdapter);
      this.L = paramListAdapter;
    }
    
    class a
      implements AdapterView.OnItemClickListener
    {
      a(AppCompatSpinner paramAppCompatSpinner) {}
      
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        AppCompatSpinner.this.setSelection(paramInt);
        if (AppCompatSpinner.this.getOnItemClickListener() != null)
        {
          paramAdapterView = AppCompatSpinner.e.this;
          paramAdapterView.O.performItemClick(paramView, paramInt, paramAdapterView.L.getItemId(paramInt));
        }
        AppCompatSpinner.e.this.dismiss();
      }
    }
    
    class b
      implements ViewTreeObserver.OnGlobalLayoutListener
    {
      b() {}
      
      public void onGlobalLayout()
      {
        AppCompatSpinner.e locale = AppCompatSpinner.e.this;
        if (!locale.U(locale.O))
        {
          AppCompatSpinner.e.this.dismiss();
          return;
        }
        AppCompatSpinner.e.this.S();
        AppCompatSpinner.e.R(AppCompatSpinner.e.this);
      }
    }
    
    class c
      implements PopupWindow.OnDismissListener
    {
      c(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
      
      public void onDismiss()
      {
        ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
        if (localViewTreeObserver != null) {
          localViewTreeObserver.removeGlobalOnLayoutListener(localb);
        }
      }
    }
  }
  
  static abstract interface f
  {
    public abstract void b(Drawable paramDrawable);
    
    public abstract boolean c();
    
    public abstract int d();
    
    public abstract void dismiss();
    
    public abstract Drawable g();
    
    public abstract void i(CharSequence paramCharSequence);
    
    public abstract void j(int paramInt);
    
    public abstract void k(int paramInt);
    
    public abstract void l(int paramInt);
    
    public abstract void m(int paramInt1, int paramInt2);
    
    public abstract int n();
    
    public abstract CharSequence o();
    
    public abstract void p(ListAdapter paramListAdapter);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */