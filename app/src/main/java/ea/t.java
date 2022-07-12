package ea;

import java.util.Objects;
import javax.annotation.Nullable;
import l9.f0;
import l9.g0;

public final class t<T>
{
  private final f0 a;
  @Nullable
  private final T b;
  @Nullable
  private final g0 c;
  
  private t(f0 paramf0, @Nullable T paramT, @Nullable g0 paramg0)
  {
    this.a = paramf0;
    this.b = paramT;
    this.c = paramg0;
  }
  
  public static <T> t<T> c(g0 paramg0, f0 paramf0)
  {
    Objects.requireNonNull(paramg0, "body == null");
    Objects.requireNonNull(paramf0, "rawResponse == null");
    if (!paramf0.j0()) {
      return new t(paramf0, null, paramg0);
    }
    throw new IllegalArgumentException("rawResponse should not be successful response");
  }
  
  public static <T> t<T> f(@Nullable T paramT, f0 paramf0)
  {
    Objects.requireNonNull(paramf0, "rawResponse == null");
    if (paramf0.j0()) {
      return new t(paramf0, paramT, null);
    }
    throw new IllegalArgumentException("rawResponse must be successful response");
  }
  
  @Nullable
  public T a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a.B();
  }
  
  public boolean d()
  {
    return this.a.j0();
  }
  
  public String e()
  {
    return this.a.k0();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.t
 * JD-Core Version:    0.7.0.1
 */