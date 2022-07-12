package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import b1.a;
import g.c;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final n r0;
  private Rect A = new Rect();
  private int[] B = new int[2];
  private int[] C = new int[2];
  private final ImageView E;
  private final Drawable F;
  private final int G;
  private final int H;
  private final Intent I;
  private final Intent J;
  private final CharSequence K;
  private l L;
  private k M;
  View.OnFocusChangeListener N;
  private m O;
  private View.OnClickListener P;
  private boolean Q;
  private boolean R;
  a S;
  private boolean T;
  private CharSequence U;
  private boolean V;
  private boolean W;
  private int a0;
  private boolean b0;
  private CharSequence c0;
  private CharSequence d0;
  private boolean e0;
  private int f0;
  SearchableInfo g0;
  private Bundle h0;
  private final Runnable i0 = new b();
  private Runnable j0 = new c();
  private final WeakHashMap<String, Drawable.ConstantState> k0 = new WeakHashMap();
  private final View.OnClickListener l0;
  View.OnKeyListener m0;
  private final TextView.OnEditorActionListener n0;
  private final AdapterView.OnItemClickListener o0;
  final SearchAutoComplete p;
  private final AdapterView.OnItemSelectedListener p0;
  private final View q;
  private TextWatcher q0;
  private final View r;
  private final View s;
  final ImageView t;
  final ImageView u;
  final ImageView v;
  final ImageView w;
  private final View x;
  private o y;
  private Rect z = new Rect();
  
  static
  {
    n localn;
    if (Build.VERSION.SDK_INT < 29) {
      localn = new n();
    } else {
      localn = null;
    }
    r0 = localn;
  }
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f localf = new f();
    this.l0 = localf;
    this.m0 = new g();
    h localh = new h();
    this.n0 = localh;
    i locali = new i();
    this.o0 = locali;
    j localj = new j();
    this.p0 = localj;
    this.q0 = new a();
    Object localObject = R.styleable.SearchView;
    k0 localk0 = k0.v(paramContext, paramAttributeSet, (int[])localObject, paramInt, 0);
    x.o0(this, paramContext, (int[])localObject, paramAttributeSet, localk0.r(), paramInt, 0);
    LayoutInflater.from(paramContext).inflate(localk0.n(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    paramContext = (SearchAutoComplete)findViewById(R.id.search_src_text);
    this.p = paramContext;
    paramContext.setSearchView(this);
    this.q = findViewById(R.id.search_edit_frame);
    paramAttributeSet = findViewById(R.id.search_plate);
    this.r = paramAttributeSet;
    localObject = findViewById(R.id.submit_area);
    this.s = ((View)localObject);
    ImageView localImageView1 = (ImageView)findViewById(R.id.search_button);
    this.t = localImageView1;
    ImageView localImageView2 = (ImageView)findViewById(R.id.search_go_btn);
    this.u = localImageView2;
    ImageView localImageView3 = (ImageView)findViewById(R.id.search_close_btn);
    this.v = localImageView3;
    ImageView localImageView4 = (ImageView)findViewById(R.id.search_voice_btn);
    this.w = localImageView4;
    ImageView localImageView5 = (ImageView)findViewById(R.id.search_mag_icon);
    this.E = localImageView5;
    x.u0(paramAttributeSet, localk0.g(R.styleable.SearchView_queryBackground));
    x.u0((View)localObject, localk0.g(R.styleable.SearchView_submitBackground));
    paramInt = R.styleable.SearchView_searchIcon;
    localImageView1.setImageDrawable(localk0.g(paramInt));
    localImageView2.setImageDrawable(localk0.g(R.styleable.SearchView_goIcon));
    localImageView3.setImageDrawable(localk0.g(R.styleable.SearchView_closeIcon));
    localImageView4.setImageDrawable(localk0.g(R.styleable.SearchView_voiceIcon));
    localImageView5.setImageDrawable(localk0.g(paramInt));
    this.F = localk0.g(R.styleable.SearchView_searchHintIcon);
    n0.a(localImageView1, getResources().getString(R.string.abc_searchview_description_search));
    this.G = localk0.n(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    this.H = localk0.n(R.styleable.SearchView_commitIcon, 0);
    localImageView1.setOnClickListener(localf);
    localImageView3.setOnClickListener(localf);
    localImageView2.setOnClickListener(localf);
    localImageView4.setOnClickListener(localf);
    paramContext.setOnClickListener(localf);
    paramContext.addTextChangedListener(this.q0);
    paramContext.setOnEditorActionListener(localh);
    paramContext.setOnItemClickListener(locali);
    paramContext.setOnItemSelectedListener(localj);
    paramContext.setOnKeyListener(this.m0);
    paramContext.setOnFocusChangeListener(new d());
    setIconifiedByDefault(localk0.a(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = localk0.f(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.K = localk0.p(R.styleable.SearchView_defaultQueryHint);
    this.U = localk0.p(R.styleable.SearchView_queryHint);
    paramInt = localk0.k(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = localk0.k(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(localk0.a(R.styleable.SearchView_android_focusable, true));
    localk0.w();
    paramAttributeSet = new Intent("android.speech.action.WEB_SEARCH");
    this.I = paramAttributeSet;
    paramAttributeSet.addFlags(268435456);
    paramAttributeSet.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    paramAttributeSet = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.J = paramAttributeSet;
    paramAttributeSet.addFlags(268435456);
    paramContext = findViewById(paramContext.getDropDownAnchor());
    this.x = paramContext;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new e());
    }
    k0(this.Q);
    g0();
  }
  
  private Intent C(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.d0);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    paramUri = this.h0;
    if (paramUri != null) {
      paramString1.putExtra("app_data", paramUri);
    }
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    paramString1.setComponent(this.g0.getSearchActivity());
    return paramString1;
  }
  
  private Intent D(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      localObject2 = e0.o(paramCursor, "suggest_intent_action");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label230;
      }
      localObject1 = this.g0.getSuggestIntentAction();
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        try
        {
          String str;
          paramInt = paramCursor.getPosition();
        }
        catch (RuntimeException paramCursor)
        {
          continue;
        }
        paramInt = -1;
        paramCursor = new StringBuilder();
        paramCursor.append("Search suggestions cursor at row ");
        paramCursor.append(paramInt);
        paramCursor.append(" returned exception.");
        Log.w("SearchView", paramCursor.toString(), paramString);
        return null;
        label230:
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = "android.intent.action.SEARCH";
          continue;
          label247:
          if (localObject3 == null) {
            localObject1 = null;
          }
        }
      }
    }
    localObject3 = e0.o(paramCursor, "suggest_intent_data");
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.g0.getSuggestIntentData();
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      str = e0.o(paramCursor, "suggest_intent_data_id");
      localObject3 = localObject1;
      if (str != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append(Uri.encode(str));
        localObject3 = ((StringBuilder)localObject3).toString();
        break label247;
        localObject1 = Uri.parse((String)localObject3);
        localObject3 = e0.o(paramCursor, "suggest_intent_query");
        paramString = C((String)localObject2, (Uri)localObject1, e0.o(paramCursor, "suggest_intent_extra_data"), (String)localObject3, paramInt, paramString);
        return paramString;
      }
    }
  }
  
  private Intent E(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1107296256);
    Bundle localBundle = new Bundle();
    localObject1 = this.h0;
    if (localObject1 != null) {
      localBundle.putParcelable("app_data", (Parcelable)localObject1);
    }
    Intent localIntent = new Intent(paramIntent);
    int i = 1;
    Object localObject2 = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
    } else {
      paramIntent = "free_form";
    }
    int j = paramSearchableInfo.getVoicePromptTextId();
    Object localObject3 = null;
    if (j != 0) {
      localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());
    } else {
      localObject1 = null;
    }
    if (paramSearchableInfo.getVoiceLanguageId() != 0) {
      localObject2 = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());
    } else {
      localObject2 = null;
    }
    if (paramSearchableInfo.getVoiceMaxResults() != 0) {
      i = paramSearchableInfo.getVoiceMaxResults();
    }
    localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
    localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
    localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
    localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (localComponentName == null) {
      paramIntent = localObject3;
    } else {
      paramIntent = localComponentName.flattenToShortString();
    }
    localIntent.putExtra("calling_package", paramIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
    return localIntent;
  }
  
  private Intent F(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    paramIntent = paramSearchableInfo.getSearchActivity();
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.flattenToShortString();
    }
    localIntent.putExtra("calling_package", paramIntent);
    return localIntent;
  }
  
  private void G()
  {
    this.p.dismissDropDown();
  }
  
  private void I(View paramView, Rect paramRect)
  {
    paramView.getLocationInWindow(this.B);
    getLocationInWindow(this.C);
    int[] arrayOfInt1 = this.B;
    int i = arrayOfInt1[1];
    int[] arrayOfInt2 = this.C;
    i -= arrayOfInt2[1];
    int j = arrayOfInt1[0] - arrayOfInt2[0];
    paramRect.set(j, i, paramView.getWidth() + j, paramView.getHeight() + i);
  }
  
  private CharSequence J(CharSequence paramCharSequence)
  {
    if (this.Q)
    {
      if (this.F == null) {
        return paramCharSequence;
      }
      int i = (int)(this.p.getTextSize() * 1.25D);
      this.F.setBounds(0, 0, i, i);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
      localSpannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
    }
    return paramCharSequence;
  }
  
  private boolean K()
  {
    Object localObject = this.g0;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((SearchableInfo)localObject).getVoiceSearchEnabled())
      {
        localObject = null;
        if (this.g0.getVoiceSearchLaunchWebSearch()) {
          localObject = this.I;
        } else if (this.g0.getVoiceSearchLaunchRecognizer()) {
          localObject = this.J;
        }
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (getContext().getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  static boolean M(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private boolean N()
  {
    return ((this.T) || (this.b0)) && (!L());
  }
  
  private void O(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed launch activity: ");
      localStringBuilder.append(paramIntent);
      Log.e("SearchView", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  private boolean Q(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.S.b();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      O(D(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }
  
  private void b0()
  {
    post(this.i0);
  }
  
  private void c0(int paramInt)
  {
    Editable localEditable = this.p.getText();
    Object localObject = this.S.b();
    if (localObject == null) {
      return;
    }
    if (((Cursor)localObject).moveToPosition(paramInt))
    {
      localObject = this.S.c((Cursor)localObject);
      if (localObject != null)
      {
        setQuery((CharSequence)localObject);
        return;
      }
    }
    setQuery(localEditable);
  }
  
  private void e0()
  {
    boolean bool = TextUtils.isEmpty(this.p.getText());
    int k = 1;
    int m = bool ^ true;
    int j = 0;
    int i = k;
    if (m == 0) {
      if ((this.Q) && (!this.e0)) {
        i = k;
      } else {
        i = 0;
      }
    }
    Object localObject = this.v;
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    Drawable localDrawable = this.v.getDrawable();
    if (localDrawable != null)
    {
      if (m != 0) {
        localObject = ViewGroup.ENABLED_STATE_SET;
      } else {
        localObject = ViewGroup.EMPTY_STATE_SET;
      }
      localDrawable.setState((int[])localObject);
    }
  }
  
  private void g0()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.p;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(J((CharSequence)localObject));
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private void h0()
  {
    this.p.setThreshold(this.g0.getSuggestThreshold());
    this.p.setImeOptions(this.g0.getImeOptions());
    int k = this.g0.getInputType();
    int j = 1;
    int i = k;
    if ((k & 0xF) == 1)
    {
      k &= 0xFFFEFFFF;
      i = k;
      if (this.g0.getSuggestAuthority() != null) {
        i = k | 0x10000 | 0x80000;
      }
    }
    this.p.setInputType(i);
    Object localObject = this.S;
    if (localObject != null) {
      ((a)localObject).a(null);
    }
    if (this.g0.getSuggestAuthority() != null)
    {
      localObject = new e0(getContext(), this, this.g0, this.k0);
      this.S = ((a)localObject);
      this.p.setAdapter((ListAdapter)localObject);
      localObject = (e0)this.S;
      i = j;
      if (this.V) {
        i = 2;
      }
      ((e0)localObject).x(i);
    }
  }
  
  private void i0()
  {
    int i;
    if ((N()) && ((this.u.getVisibility() == 0) || (this.w.getVisibility() == 0))) {
      i = 0;
    } else {
      i = 8;
    }
    this.s.setVisibility(i);
  }
  
  private void j0(boolean paramBoolean)
  {
    int i;
    if ((this.T) && (N()) && (hasFocus()) && ((paramBoolean) || (!this.b0))) {
      i = 0;
    } else {
      i = 8;
    }
    this.u.setVisibility(i);
  }
  
  private void k0(boolean paramBoolean)
  {
    this.R = paramBoolean;
    int j = 0;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    boolean bool = TextUtils.isEmpty(this.p.getText()) ^ true;
    this.t.setVisibility(i);
    j0(bool);
    View localView = this.q;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    if (this.E.getDrawable() != null)
    {
      i = j;
      if (!this.Q) {}
    }
    else
    {
      i = 8;
    }
    this.E.setVisibility(i);
    e0();
    l0(bool ^ true);
    i0();
  }
  
  private void l0(boolean paramBoolean)
  {
    boolean bool = this.b0;
    int j = 8;
    int i = j;
    if (bool)
    {
      i = j;
      if (!L())
      {
        i = j;
        if (paramBoolean)
        {
          this.u.setVisibility(8);
          i = 0;
        }
      }
    }
    this.w.setVisibility(i);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.p.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.p;
    int i;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 0;
    } else {
      i = paramCharSequence.length();
    }
    localSearchAutoComplete.setSelection(i);
  }
  
  void B()
  {
    if (this.x.getWidth() > 1)
    {
      Resources localResources = getContext().getResources();
      int k = this.r.getPaddingLeft();
      Rect localRect = new Rect();
      boolean bool = r0.b(this);
      int i;
      if (this.Q) {
        i = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
      } else {
        i = 0;
      }
      this.p.getDropDownBackground().getPadding(localRect);
      int j = localRect.left;
      if (bool) {
        j = -j;
      } else {
        j = k - (j + i);
      }
      this.p.setDropDownHorizontalOffset(j);
      j = this.x.getWidth();
      int m = localRect.left;
      int n = localRect.right;
      this.p.setDropDownWidth(j + m + n + i - k);
    }
  }
  
  void H()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.p.refreshAutoCompleteResults();
      return;
    }
    n localn = r0;
    localn.b(this.p);
    localn.a(this.p);
  }
  
  public boolean L()
  {
    return this.R;
  }
  
  void P(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = C("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  void R()
  {
    if (TextUtils.isEmpty(this.p.getText()))
    {
      if (this.Q)
      {
        k localk = this.M;
        if ((localk == null) || (!localk.a()))
        {
          clearFocus();
          k0(true);
        }
      }
    }
    else
    {
      this.p.setText("");
      this.p.requestFocus();
      this.p.setImeVisibility(true);
    }
  }
  
  boolean S(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.O;
    if ((paramString != null) && (paramString.b(paramInt1))) {
      return false;
    }
    Q(paramInt1, 0, null);
    this.p.setImeVisibility(false);
    G();
    return true;
  }
  
  boolean T(int paramInt)
  {
    m localm = this.O;
    if ((localm != null) && (localm.a(paramInt))) {
      return false;
    }
    c0(paramInt);
    return true;
  }
  
  void U(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  void V()
  {
    k0(false);
    this.p.requestFocus();
    this.p.setImeVisibility(true);
    View.OnClickListener localOnClickListener = this.P;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  void W()
  {
    Editable localEditable = this.p.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      l locall = this.L;
      if ((locall == null) || (!locall.b(localEditable.toString())))
      {
        if (this.g0 != null) {
          P(0, null, localEditable.toString());
        }
        this.p.setImeVisibility(false);
        G();
      }
    }
  }
  
  boolean X(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.g0 == null) {
      return false;
    }
    if (this.S == null) {
      return false;
    }
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.hasNoModifiers())) {
      if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61))
      {
        if ((paramInt != 21) && (paramInt != 22))
        {
          if (paramInt == 19)
          {
            this.p.getListSelection();
            return false;
          }
        }
        else
        {
          if (paramInt == 21) {
            paramInt = 0;
          } else {
            paramInt = this.p.length();
          }
          this.p.setSelection(paramInt);
          this.p.setListSelection(0);
          this.p.clearListSelection();
          this.p.b();
          return true;
        }
      }
      else {
        return S(this.p.getListSelection(), 0, null);
      }
    }
    return false;
  }
  
  void Y(CharSequence paramCharSequence)
  {
    Editable localEditable = this.p.getText();
    this.d0 = localEditable;
    boolean bool = TextUtils.isEmpty(localEditable) ^ true;
    j0(bool);
    l0(bool ^ true);
    e0();
    i0();
    if ((this.L != null) && (!TextUtils.equals(paramCharSequence, this.c0))) {
      this.L.a(paramCharSequence.toString());
    }
    this.c0 = paramCharSequence.toString();
  }
  
  void Z()
  {
    k0(L());
    b0();
    if (this.p.hasFocus()) {
      H();
    }
  }
  
  void a0()
  {
    Object localObject = this.g0;
    if (localObject == null) {
      return;
    }
    try
    {
      if (((SearchableInfo)localObject).getVoiceSearchLaunchWebSearch()) {}
      for (localObject = F(this.I, (SearchableInfo)localObject);; localObject = E(this.J, (SearchableInfo)localObject))
      {
        getContext().startActivity((Intent)localObject);
        return;
        if (!((SearchableInfo)localObject).getVoiceSearchLaunchRecognizer()) {
          break;
        }
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      label56:
      break label56;
    }
    Log.w("SearchView", "Could not find voice search activity");
  }
  
  public void c()
  {
    if (this.e0) {
      return;
    }
    this.e0 = true;
    int i = this.p.getImeOptions();
    this.f0 = i;
    this.p.setImeOptions(i | 0x2000000);
    this.p.setText("");
    setIconified(false);
  }
  
  public void clearFocus()
  {
    this.W = true;
    super.clearFocus();
    this.p.clearFocus();
    this.p.setImeVisibility(false);
    this.W = false;
  }
  
  public void d0(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.p.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      SearchAutoComplete localSearchAutoComplete = this.p;
      localSearchAutoComplete.setSelection(localSearchAutoComplete.length());
      this.d0 = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      W();
    }
  }
  
  public void e()
  {
    d0("", false);
    clearFocus();
    k0(true);
    this.p.setImeOptions(this.f0);
    this.e0 = false;
  }
  
  void f0()
  {
    int[] arrayOfInt;
    if (this.p.hasFocus()) {
      arrayOfInt = ViewGroup.FOCUSED_STATE_SET;
    } else {
      arrayOfInt = ViewGroup.EMPTY_STATE_SET;
    }
    Drawable localDrawable = this.r.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    localDrawable = this.s.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getImeOptions()
  {
    return this.p.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.p.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.a0;
  }
  
  public CharSequence getQuery()
  {
    return this.p.getText();
  }
  
  public CharSequence getQueryHint()
  {
    Object localObject = this.U;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.g0;
    if ((localObject != null) && (((SearchableInfo)localObject).getHintId() != 0)) {
      return getContext().getText(this.g0.getHintId());
    }
    return this.K;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.H;
  }
  
  int getSuggestionRowLayout()
  {
    return this.G;
  }
  
  public a getSuggestionsAdapter()
  {
    return this.S;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.i0);
    post(this.j0);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      I(this.p, this.z);
      Object localObject = this.A;
      Rect localRect = this.z;
      ((Rect)localObject).set(localRect.left, 0, localRect.right, paramInt4 - paramInt2);
      localObject = this.y;
      if (localObject == null)
      {
        localObject = new o(this.A, this.z, this.p);
        this.y = ((o)localObject);
        setTouchDelegate((TouchDelegate)localObject);
        return;
      }
      ((o)localObject).a(this.A, this.z);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (L())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j != -2147483648)
    {
      if (j != 0)
      {
        if (j != 1073741824)
        {
          paramInt1 = i;
          break label113;
        }
        j = this.a0;
        paramInt1 = i;
        if (j <= 0) {
          break label113;
        }
        paramInt1 = j;
      }
      else
      {
        paramInt1 = this.a0;
        if (paramInt1 > 0) {
          break label113;
        }
        paramInt1 = getPreferredWidth();
        break label113;
      }
    }
    else
    {
      paramInt1 = this.a0;
      if (paramInt1 > 0) {
        break label107;
      }
    }
    paramInt1 = getPreferredWidth();
    label107:
    paramInt1 = Math.min(paramInt1, i);
    label113:
    i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != -2147483648)
    {
      if (i == 0) {
        paramInt2 = getPreferredHeight();
      }
    }
    else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    k0(paramParcelable.c);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = L();
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    b0();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.W) {
      return false;
    }
    if (!isFocusable()) {
      return false;
    }
    if (!L())
    {
      boolean bool = this.p.requestFocus(paramInt, paramRect);
      if (bool) {
        k0(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.h0 = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      R();
      return;
    }
    V();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.Q == paramBoolean) {
      return;
    }
    this.Q = paramBoolean;
    k0(paramBoolean);
    g0();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.p.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.p.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.a0 = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(k paramk)
  {
    this.M = paramk;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.N = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(l paraml)
  {
    this.L = paraml;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.P = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(m paramm)
  {
    this.O = paramm;
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.U = paramCharSequence;
    g0();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.V = paramBoolean;
    Object localObject = this.S;
    if ((localObject instanceof e0))
    {
      localObject = (e0)localObject;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((e0)localObject).x(i);
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.g0 = paramSearchableInfo;
    if (paramSearchableInfo != null)
    {
      h0();
      g0();
    }
    boolean bool = K();
    this.b0 = bool;
    if (bool) {
      this.p.setPrivateImeOptions("nm");
    }
    k0(L());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.T = paramBoolean;
    k0(L());
  }
  
  public void setSuggestionsAdapter(a parama)
  {
    this.S = parama;
    this.p.setAdapter(parama);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SearchView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" isIconified=");
      localStringBuilder.append(this.c);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.c));
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<SearchView.SavedState>
    {
      public SearchView.SavedState a(Parcel paramParcel)
      {
        return new SearchView.SavedState(paramParcel, null);
      }
      
      public SearchView.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new SearchView.SavedState(paramParcel, paramClassLoader);
      }
      
      public SearchView.SavedState[] c(int paramInt)
      {
        return new SearchView.SavedState[paramInt];
      }
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private int e = getThreshold();
    private SearchView f;
    private boolean g;
    final Runnable h = new a();
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
        return 256;
      }
      if ((i < 600) && ((i < 640) || (j < 480))) {
        return 160;
      }
      return 192;
    }
    
    void b()
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        setInputMethodMode(1);
        if (enoughToFilter()) {
          showDropDown();
        }
      }
      else
      {
        SearchView.r0.c(this);
      }
    }
    
    boolean c()
    {
      return TextUtils.getTrimmedLength(getText()) == 0;
    }
    
    void d()
    {
      if (this.g)
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        this.g = false;
      }
    }
    
    public boolean enoughToFilter()
    {
      return (this.e <= 0) || (super.enoughToFilter());
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.g)
      {
        removeCallbacks(this.h);
        post(this.h);
      }
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.f.Z();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.f.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.f.hasFocus()) && (getVisibility() == 0))
      {
        this.g = true;
        if (SearchView.M(getContext())) {
          b();
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.g = false;
        removeCallbacks(this.h);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.g = false;
        removeCallbacks(this.h);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.g = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.f = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.e = paramInt;
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        SearchView.SearchAutoComplete.this.d();
      }
    }
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SearchView.this.Y(paramCharSequence);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      SearchView.this.f0();
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      a locala = SearchView.this.S;
      if ((locala instanceof e0)) {
        locala.a(null);
      }
    }
  }
  
  class d
    implements View.OnFocusChangeListener
  {
    d() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramView = SearchView.this;
      View.OnFocusChangeListener localOnFocusChangeListener = paramView.N;
      if (localOnFocusChangeListener != null) {
        localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
      }
    }
  }
  
  class e
    implements View.OnLayoutChangeListener
  {
    e() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      SearchView.this.B();
    }
  }
  
  class f
    implements View.OnClickListener
  {
    f() {}
    
    public void onClick(View paramView)
    {
      SearchView localSearchView = SearchView.this;
      if (paramView == localSearchView.t)
      {
        localSearchView.V();
        return;
      }
      if (paramView == localSearchView.v)
      {
        localSearchView.R();
        return;
      }
      if (paramView == localSearchView.u)
      {
        localSearchView.W();
        return;
      }
      if (paramView == localSearchView.w)
      {
        localSearchView.a0();
        return;
      }
      if (paramView == localSearchView.p) {
        localSearchView.H();
      }
    }
  }
  
  class g
    implements View.OnKeyListener
  {
    g() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      SearchView localSearchView = SearchView.this;
      if (localSearchView.g0 == null) {
        return false;
      }
      if ((localSearchView.p.isPopupShowing()) && (SearchView.this.p.getListSelection() != -1)) {
        return SearchView.this.X(paramView, paramInt, paramKeyEvent);
      }
      if ((!SearchView.this.p.c()) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
      {
        paramView.cancelLongPress();
        paramView = SearchView.this;
        paramView.P(0, null, paramView.p.getText().toString());
        return true;
      }
      return false;
    }
  }
  
  class h
    implements TextView.OnEditorActionListener
  {
    h() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      SearchView.this.W();
      return true;
    }
  }
  
  class i
    implements AdapterView.OnItemClickListener
  {
    i() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      SearchView.this.S(paramInt, 0, null);
    }
  }
  
  class j
    implements AdapterView.OnItemSelectedListener
  {
    j() {}
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      SearchView.this.T(paramInt);
    }
    
    public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  }
  
  public static abstract interface k
  {
    public abstract boolean a();
  }
  
  public static abstract interface l
  {
    public abstract boolean a(String paramString);
    
    public abstract boolean b(String paramString);
  }
  
  public static abstract interface m
  {
    public abstract boolean a(int paramInt);
    
    public abstract boolean b(int paramInt);
  }
  
  private static class n
  {
    private Method a = null;
    private Method b = null;
    private Method c = null;
    
    @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
    n()
    {
      d();
      try
      {
        localMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.a = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          for (;;)
          {
            Method localMethod = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b = localMethod;
            localMethod.setAccessible(true);
            try
            {
              label66:
              localMethod = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
              this.c = localMethod;
              localMethod.setAccessible(true);
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException3) {}
            localNoSuchMethodException1 = localNoSuchMethodException1;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label66;
        }
      }
    }
    
    private static void d()
    {
      if (Build.VERSION.SDK_INT < 29) {
        return;
      }
      throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
    }
    
    void a(AutoCompleteTextView paramAutoCompleteTextView)
    {
      d();
      Method localMethod = this.b;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      d();
      Method localMethod = this.a;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      d();
      Method localMethod = this.c;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
  }
  
  private static class o
    extends TouchDelegate
  {
    private final View a;
    private final Rect b;
    private final Rect c;
    private final Rect d;
    private final int e;
    private boolean f;
    
    public o(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.b = new Rect();
      this.d = new Rect();
      this.c = new Rect();
      a(paramRect1, paramRect2);
      this.a = paramView;
    }
    
    public void a(Rect paramRect1, Rect paramRect2)
    {
      this.b.set(paramRect1);
      this.d.set(paramRect1);
      paramRect1 = this.d;
      int i = this.e;
      paramRect1.inset(-i, -i);
      this.c.set(paramRect2);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      boolean bool1 = true;
      boolean bool3 = false;
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3) {
            break label132;
          }
          bool1 = this.f;
          this.f = false;
        }
        else
        {
          bool2 = this.f;
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (!this.d.contains(j, k))
            {
              bool1 = bool2;
              i = 0;
              break label137;
            }
          }
        }
        i = 1;
        break label137;
      }
      else if (this.b.contains(j, k))
      {
        this.f = true;
        i = 1;
        break label137;
      }
      label132:
      i = 1;
      bool1 = false;
      label137:
      boolean bool2 = bool3;
      if (bool1)
      {
        float f1;
        if ((i != 0) && (!this.c.contains(j, k)))
        {
          f1 = this.a.getWidth() / 2;
          i = this.a.getHeight() / 2;
        }
        else
        {
          Rect localRect = this.c;
          f1 = j - localRect.left;
          i = k - localRect.top;
        }
        paramMotionEvent.setLocation(f1, i);
        bool2 = this.a.dispatchTouchEvent(paramMotionEvent);
      }
      return bool2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */