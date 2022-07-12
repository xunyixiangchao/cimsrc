package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.core.content.b;
import b1.a;
import b1.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class e0
  extends c
  implements View.OnClickListener
{
  private final SearchView l;
  private final SearchableInfo m;
  private final Context n;
  private final WeakHashMap<String, Drawable.ConstantState> o;
  private final int p;
  private boolean q = false;
  private int r = 1;
  private ColorStateList s;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private int y = -1;
  
  public e0(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.l = paramSearchView;
    this.m = paramSearchableInfo;
    this.p = paramSearchView.getSuggestionCommitIconResId();
    this.n = paramContext;
    this.o = paramWeakHashMap;
  }
  
  private void A(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.o.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private void B(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if (paramCursor != null) {
      paramCursor.getBoolean("in_progress");
    }
  }
  
  private Drawable k(String paramString)
  {
    paramString = (Drawable.ConstantState)this.o.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private CharSequence l(CharSequence paramCharSequence)
  {
    if (this.s == null)
    {
      localObject = new TypedValue();
      this.n.getTheme().resolveAttribute(R.attr.textColorSearchUrl, (TypedValue)localObject, true);
      this.s = this.n.getResources().getColorStateList(((TypedValue)localObject).resourceId);
    }
    Object localObject = new SpannableString(paramCharSequence);
    ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, 0, this.s, null), 0, paramCharSequence.length(), 33);
    return localObject;
  }
  
  private Drawable m(ComponentName paramComponentName)
  {
    Object localObject = this.n.getPackageManager();
    try
    {
      ActivityInfo localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      int i = localActivityInfo.getIconResource();
      if (i == 0) {
        return null;
      }
      localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
      if (localObject != null) {
        break label100;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid icon resource ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" for ");
      ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
      paramComponentName = ((StringBuilder)localObject).toString();
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      for (;;)
      {
        paramComponentName = paramComponentName.toString();
      }
    }
    Log.w("SuggestionsAdapter", paramComponentName);
    return null;
    label100:
    return localObject;
  }
  
  private Drawable n(ComponentName paramComponentName)
  {
    String str = paramComponentName.flattenToShortString();
    boolean bool = this.o.containsKey(str);
    Object localObject = null;
    if (bool)
    {
      paramComponentName = (Drawable.ConstantState)this.o.get(str);
      if (paramComponentName == null) {
        return null;
      }
      return paramComponentName.newDrawable(this.n.getResources());
    }
    Drawable localDrawable = m(paramComponentName);
    if (localDrawable == null) {
      paramComponentName = localObject;
    } else {
      paramComponentName = localDrawable.getConstantState();
    }
    this.o.put(str, paramComponentName);
    return localDrawable;
  }
  
  public static String o(Cursor paramCursor, String paramString)
  {
    return w(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable p()
  {
    Drawable localDrawable = n(this.m.getSearchActivity());
    if (localDrawable != null) {
      return localDrawable;
    }
    return this.n.getPackageManager().getDefaultActivityIcon();
  }
  
  private Drawable q(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (!bool) {}
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject1;
      label23:
      InputStream localInputStream;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Icon not found: ");
      localStringBuilder2.append(paramUri);
      localStringBuilder2.append(", ");
      localStringBuilder2.append(localFileNotFoundException.getMessage());
      Log.w("SuggestionsAdapter", localStringBuilder2.toString());
      return null;
    }
    try
    {
      localObject1 = r(paramUri);
      return localObject1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label23;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Resource does not exist: ");
    ((StringBuilder)localObject1).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject1).toString());
    localInputStream = this.n.getContentResolver().openInputStream(paramUri);
    if (localInputStream != null) {
      try
      {
        localObject1 = Drawable.createFromStream(localInputStream, null);
        StringBuilder localStringBuilder3;
        try
        {
          localInputStream.close();
          return localObject1;
        }
        catch (IOException localIOException1)
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("Error closing icon stream for ");
          localStringBuilder3.append(paramUri);
          Log.e("SuggestionsAdapter", localStringBuilder3.toString(), localIOException1);
          return localObject1;
        }
        localStringBuilder1 = new StringBuilder();
      }
      finally
      {
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("Error closing icon stream for ");
          localStringBuilder3.append(paramUri);
          Log.e("SuggestionsAdapter", localStringBuilder3.toString(), localIOException2);
        }
      }
    }
    localStringBuilder1.append("Failed to open ");
    localStringBuilder1.append(paramUri);
    throw new FileNotFoundException(localStringBuilder1.toString());
  }
  
  private Drawable s(String paramString)
  {
    Drawable localDrawable = null;
    Object localObject = localDrawable;
    if (paramString != null)
    {
      localObject = localDrawable;
      if (!paramString.isEmpty()) {
        if ("0".equals(paramString)) {
          return null;
        }
      }
    }
    try
    {
      int i = Integer.parseInt(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.n.getPackageName());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      localDrawable = k((String)localObject);
      if (localDrawable != null) {
        return localDrawable;
      }
      localDrawable = b.d(this.n, i);
      A((String)localObject, localDrawable);
      return localDrawable;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label153;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label119:
      break label119;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Icon resource not found: ");
    ((StringBuilder)localObject).append(paramString);
    Log.w("SuggestionsAdapter", ((StringBuilder)localObject).toString());
    return null;
    label153:
    localObject = k(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = q(Uri.parse(paramString));
    A(paramString, (Drawable)localObject);
    return localObject;
  }
  
  private Drawable t(Cursor paramCursor)
  {
    int i = this.w;
    if (i == -1) {
      return null;
    }
    paramCursor = s(paramCursor.getString(i));
    if (paramCursor != null) {
      return paramCursor;
    }
    return p();
  }
  
  private Drawable u(Cursor paramCursor)
  {
    int i = this.x;
    if (i == -1) {
      return null;
    }
    return s(paramCursor.getString(i));
  }
  
  private static String w(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  private void y(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void z(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    int i;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 8;
    } else {
      i = 0;
    }
    paramTextView.setVisibility(i);
  }
  
  public void a(Cursor paramCursor)
  {
    if (this.q)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    try
    {
      super.a(paramCursor);
      if (paramCursor != null)
      {
        this.t = paramCursor.getColumnIndex("suggest_text_1");
        this.u = paramCursor.getColumnIndex("suggest_text_2");
        this.v = paramCursor.getColumnIndex("suggest_text_2_url");
        this.w = paramCursor.getColumnIndex("suggest_icon_1");
        this.x = paramCursor.getColumnIndex("suggest_icon_2");
        this.y = paramCursor.getColumnIndex("suggest_flags");
        return;
      }
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
    }
  }
  
  public CharSequence c(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = o(paramCursor, "suggest_intent_query");
    if (str != null) {
      return str;
    }
    if (this.m.shouldRewriteQueryFromData())
    {
      str = o(paramCursor, "suggest_intent_data");
      if (str != null) {
        return str;
      }
    }
    if (this.m.shouldRewriteQueryFromText())
    {
      paramCursor = o(paramCursor, "suggest_text_1");
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  public Cursor d(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    if (this.l.getVisibility() == 0)
    {
      if (this.l.getWindowVisibility() != 0) {
        return null;
      }
      try
      {
        paramCharSequence = v(this.m, paramCharSequence, 50);
        if (paramCharSequence != null)
        {
          paramCharSequence.getCount();
          return paramCharSequence;
        }
      }
      catch (RuntimeException paramCharSequence)
      {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
      }
    }
    return null;
  }
  
  public void e(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramContext = (a)paramView.getTag();
    int i = this.y;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (paramContext.a != null)
    {
      paramView = w(paramCursor, this.t);
      z(paramContext.a, paramView);
    }
    if (paramContext.b != null)
    {
      paramView = w(paramCursor, this.v);
      if (paramView != null) {
        paramView = l(paramView);
      } else {
        paramView = w(paramCursor, this.u);
      }
      TextView localTextView;
      if (TextUtils.isEmpty(paramView))
      {
        localTextView = paramContext.a;
        if (localTextView != null)
        {
          localTextView.setSingleLine(false);
          paramContext.a.setMaxLines(2);
        }
      }
      else
      {
        localTextView = paramContext.a;
        if (localTextView != null)
        {
          localTextView.setSingleLine(true);
          paramContext.a.setMaxLines(1);
        }
      }
      z(paramContext.b, paramView);
    }
    paramView = paramContext.c;
    if (paramView != null) {
      y(paramView, t(paramCursor), 4);
    }
    paramView = paramContext.d;
    if (paramView != null) {
      y(paramView, u(paramCursor), 8);
    }
    int j = this.r;
    if ((j != 2) && ((j != 1) || ((i & 0x1) == 0)))
    {
      paramContext.e.setVisibility(8);
      return;
    }
    paramContext.e.setVisibility(0);
    paramContext.e.setTag(paramContext.a.getText());
    paramContext.e.setOnClickListener(this);
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = g(this.n, b(), paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = h(this.n, b(), paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public View h(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.h(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(this.p);
    return paramContext;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    B(b());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    B(b());
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.l.U((CharSequence)paramView);
    }
  }
  
  Drawable r(Uri paramUri)
  {
    Object localObject = paramUri.getAuthority();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localResources = this.n.getPackageManager().getResourcesForApplication((String)localObject);
      localList = paramUri.getPathSegments();
      if (localList != null)
      {
        i = localList.size();
        if (i != 1) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Resources localResources;
      List localList;
      int i;
      label67:
      break label248;
    }
    try
    {
      i = Integer.parseInt((String)localList.get(0));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label67;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Single path segment is not a resource ID: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    if (i == 2)
    {
      i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), (String)localObject);
      if (i != 0) {
        return localResources.getDrawable(i);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No resource found for: ");
      ((StringBuilder)localObject).append(paramUri);
      throw new FileNotFoundException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("More than two path segments: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No path: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    label248:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No package found for authority: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No authority: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  Cursor v(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (paramSearchableInfo == null) {
      return null;
    }
    Object localObject2 = paramSearchableInfo.getSuggestAuthority();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject2).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject2).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    else
    {
      ((Uri.Builder)localObject2).appendPath(paramString);
      paramSearchableInfo = localObject1;
    }
    if (paramInt > 0) {
      ((Uri.Builder)localObject2).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    paramString = ((Uri.Builder)localObject2).build();
    return this.n.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
  }
  
  public void x(int paramInt)
  {
    this.r = paramInt;
  }
  
  private static final class a
  {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    
    public a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(16908308));
      this.b = ((TextView)paramView.findViewById(16908309));
      this.c = ((ImageView)paramView.findViewById(16908295));
      this.d = ((ImageView)paramView.findViewById(16908296));
      this.e = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.e0
 * JD-Core Version:    0.7.0.1
 */