package androidx.core.app;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

class j
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  
  static Bundle a(f paramf)
  {
    Bundle localBundle = new Bundle();
    Object localObject = paramf.d();
    int i;
    if (localObject != null) {
      i = ((IconCompat)localObject).c();
    } else {
      i = 0;
    }
    localBundle.putInt("icon", i);
    localBundle.putCharSequence("title", paramf.h());
    localBundle.putParcelable("actionIntent", paramf.a());
    if (paramf.c() != null) {
      localObject = new Bundle(paramf.c());
    } else {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramf.b());
    localBundle.putBundle("extras", (Bundle)localObject);
    localBundle.putParcelableArray("remoteInputs", c(paramf.e()));
    localBundle.putBoolean("showsUserInterface", paramf.g());
    localBundle.putInt("semanticAction", paramf.f());
    return localBundle;
  }
  
  private static Bundle b(m paramm)
  {
    new Bundle();
    throw null;
  }
  
  private static Bundle[] c(m[] paramArrayOfm)
  {
    if (paramArrayOfm == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfm.length];
    int i = 0;
    while (i < paramArrayOfm.length)
    {
      m localm = paramArrayOfm[i];
      arrayOfBundle[i] = b(null);
      i += 1;
    }
    return arrayOfBundle;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.j
 * JD-Core Version:    0.7.0.1
 */