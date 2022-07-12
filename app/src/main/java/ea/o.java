package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import l9.g0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class o
  extends f.a
{
  static final f.a a = new o();
  
  @Nullable
  public f<g0, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
  {
    if (f.a.b(paramType) != Optional.class) {
      return null;
    }
    return new a(paramu.h(f.a.a(0, (ParameterizedType)paramType), paramArrayOfAnnotation));
  }
  
  @IgnoreJRERequirement
  static final class a<T>
    implements f<g0, Optional<T>>
  {
    final f<g0, T> a;
    
    a(f<g0, T> paramf)
    {
      this.a = paramf;
    }
    
    public Optional<T> a(g0 paramg0)
    {
      return Optional.ofNullable(this.a.convert(paramg0));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.o
 * JD-Core Version:    0.7.0.1
 */