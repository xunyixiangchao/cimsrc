package t8;

import a9.f;
import s8.a;

class c
{
  public static <T> a<T> a(a<? super T> parama)
  {
    f.f(parama, "<this>");
    u8.c localc;
    if ((parama instanceof u8.c)) {
      localc = (u8.c)parama;
    } else {
      localc = null;
    }
    Object localObject = parama;
    if (localc != null)
    {
      localObject = localc.f();
      if (localObject == null) {
        return parama;
      }
    }
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t8.c
 * JD-Core Version:    0.7.0.1
 */