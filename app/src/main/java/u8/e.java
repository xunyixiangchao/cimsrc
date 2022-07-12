package u8;

import a9.f;
import java.lang.reflect.Field;

public final class e
{
  private static final void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Debug metadata version mismatch. Expected: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", got ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(". Please update the Kotlin standard library.");
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  private static final d b(a parama)
  {
    return (d)parama.getClass().getAnnotation(d.class);
  }
  
  private static final int c(a parama)
  {
    try
    {
      Field localField = parama.getClass().getDeclaredField("label");
      localField.setAccessible(true);
      parama = localField.get(parama);
      if (!(parama instanceof Integer)) {
        break label60;
      }
      parama = (Integer)parama;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        int i;
        continue;
        label60:
        parama = null;
      }
    }
    if (parama != null) {
      i = parama.intValue();
    } else {
      i = 0;
    }
    return i - 1;
    return -1;
  }
  
  public static final StackTraceElement d(a parama)
  {
    f.f(parama, "<this>");
    d locald = b(parama);
    if (locald == null) {
      return null;
    }
    a(1, locald.v());
    int i = c(parama);
    if (i < 0) {
      i = -1;
    } else {
      i = locald.l()[i];
    }
    parama = g.a.b(parama);
    if (parama == null)
    {
      parama = locald.c();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama);
      localStringBuilder.append('/');
      localStringBuilder.append(locald.c());
      parama = localStringBuilder.toString();
    }
    return new StackTraceElement(parama, locald.m(), locald.f(), i);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.e
 * JD-Core Version:    0.7.0.1
 */