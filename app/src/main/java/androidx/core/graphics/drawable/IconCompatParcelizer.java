package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.a = parama.p(localIconCompat.a, 1);
    localIconCompat.c = parama.j(localIconCompat.c, 2);
    localIconCompat.d = parama.r(localIconCompat.d, 3);
    localIconCompat.e = parama.p(localIconCompat.e, 4);
    localIconCompat.f = parama.p(localIconCompat.f, 5);
    localIconCompat.g = ((ColorStateList)parama.r(localIconCompat.g, 6));
    localIconCompat.i = parama.t(localIconCompat.i, 7);
    localIconCompat.j = parama.t(localIconCompat.j, 8);
    localIconCompat.j();
    return localIconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    parama.x(true, true);
    paramIconCompat.k(parama.f());
    int i = paramIconCompat.a;
    if (-1 != i) {
      parama.F(i, 1);
    }
    Object localObject = paramIconCompat.c;
    if (localObject != null) {
      parama.B((byte[])localObject, 2);
    }
    localObject = paramIconCompat.d;
    if (localObject != null) {
      parama.H((Parcelable)localObject, 3);
    }
    i = paramIconCompat.e;
    if (i != 0) {
      parama.F(i, 4);
    }
    i = paramIconCompat.f;
    if (i != 0) {
      parama.F(i, 5);
    }
    localObject = paramIconCompat.g;
    if (localObject != null) {
      parama.H((Parcelable)localObject, 6);
    }
    localObject = paramIconCompat.i;
    if (localObject != null) {
      parama.J((String)localObject, 7);
    }
    paramIconCompat = paramIconCompat.j;
    if (paramIconCompat != null) {
      parama.J(paramIconCompat, 8);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */