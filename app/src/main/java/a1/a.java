package a1;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import x0.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class a
{
  private static final String[] a = new String[0];
  
  public static String[] a(EditorInfo paramEditorInfo)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo = paramEditorInfo.contentMimeTypes;
      if (paramEditorInfo != null) {
        return paramEditorInfo;
      }
      return a;
    }
    Object localObject = paramEditorInfo.extras;
    if (localObject == null) {
      return a;
    }
    String[] arrayOfString = ((Bundle)localObject).getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    localObject = arrayOfString;
    if (arrayOfString == null) {
      localObject = paramEditorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    }
    if (localObject != null) {
      return localObject;
    }
    return a;
  }
  
  private static boolean b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return false;
      }
      return Character.isHighSurrogate(paramCharSequence.charAt(paramInt1));
    }
    return Character.isLowSurrogate(paramCharSequence.charAt(paramInt1));
  }
  
  private static boolean c(int paramInt)
  {
    paramInt &= 0xFFF;
    return (paramInt == 129) || (paramInt == 225) || (paramInt == 18);
  }
  
  public static void d(EditorInfo paramEditorInfo, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo.contentMimeTypes = paramArrayOfString;
      return;
    }
    if (paramEditorInfo.extras == null) {
      paramEditorInfo.extras = new Bundle();
    }
    paramEditorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
    paramEditorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
  }
  
  public static void e(EditorInfo paramEditorInfo, CharSequence paramCharSequence, int paramInt)
  {
    h.g(paramCharSequence);
    if (Build.VERSION.SDK_INT >= 30)
    {
      a.a(paramEditorInfo, paramCharSequence, paramInt);
      return;
    }
    int j = paramEditorInfo.initialSelStart;
    int k = paramEditorInfo.initialSelEnd;
    int i;
    if (j > k) {
      i = k - paramInt;
    } else {
      i = j - paramInt;
    }
    if (j > k) {
      j -= paramInt;
    } else {
      j = k - paramInt;
    }
    k = paramCharSequence.length();
    if ((paramInt >= 0) && (i >= 0) && (j <= k))
    {
      if (c(paramEditorInfo.inputType))
      {
        g(paramEditorInfo, null, 0, 0);
        return;
      }
      if (k <= 2048)
      {
        g(paramEditorInfo, paramCharSequence, i, j);
        return;
      }
      h(paramEditorInfo, paramCharSequence, i, j);
      return;
    }
    g(paramEditorInfo, null, 0, 0);
  }
  
  public static void f(EditorInfo paramEditorInfo, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      a.a(paramEditorInfo, paramCharSequence, 0);
      return;
    }
    e(paramEditorInfo, paramCharSequence, 0);
  }
  
  private static void g(EditorInfo paramEditorInfo, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramEditorInfo.extras == null) {
      paramEditorInfo.extras = new Bundle();
    }
    if (paramCharSequence != null) {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    } else {
      paramCharSequence = null;
    }
    paramEditorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", paramCharSequence);
    paramEditorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", paramInt1);
    paramEditorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", paramInt2);
  }
  
  private static void h(EditorInfo paramEditorInfo, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int m = paramInt2 - paramInt1;
    int i;
    if (m > 1024) {
      i = 0;
    } else {
      i = m;
    }
    int k = paramCharSequence.length();
    int j = 2048 - i;
    int n = Math.min(k - paramInt2, j - Math.min(paramInt1, (int)(j * 0.8D)));
    k = Math.min(paramInt1, j - n);
    int i1 = paramInt1 - k;
    j = k;
    paramInt1 = i1;
    if (b(paramCharSequence, i1, 0))
    {
      paramInt1 = i1 + 1;
      j = k - 1;
    }
    k = n;
    if (b(paramCharSequence, paramInt2 + n - 1, 1)) {
      k = n - 1;
    }
    if (i != m) {
      paramCharSequence = TextUtils.concat(new CharSequence[] { paramCharSequence.subSequence(paramInt1, paramInt1 + j), paramCharSequence.subSequence(paramInt2, k + paramInt2) });
    } else {
      paramCharSequence = paramCharSequence.subSequence(paramInt1, j + i + k + paramInt1);
    }
    paramInt1 = j + 0;
    g(paramEditorInfo, paramCharSequence, paramInt1, i + paramInt1);
  }
  
  private static class a
  {
    static void a(EditorInfo paramEditorInfo, CharSequence paramCharSequence, int paramInt)
    {
      paramEditorInfo.setInitialSurroundingSubText(paramCharSequence, paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a1.a
 * JD-Core Version:    0.7.0.1
 */