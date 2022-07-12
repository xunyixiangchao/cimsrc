package ea;

import java.lang.annotation.Annotation;

final class x
  implements w
{
  private static final w a = new x();
  
  static Annotation[] a(Annotation[] paramArrayOfAnnotation)
  {
    if (y.l(paramArrayOfAnnotation, w.class)) {
      return paramArrayOfAnnotation;
    }
    Annotation[] arrayOfAnnotation = new Annotation[paramArrayOfAnnotation.length + 1];
    arrayOfAnnotation[0] = a;
    System.arraycopy(paramArrayOfAnnotation, 0, arrayOfAnnotation, 1, paramArrayOfAnnotation.length);
    return arrayOfAnnotation;
  }
  
  public Class<? extends Annotation> annotationType()
  {
    return w.class;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof w;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(w.class.getName());
    localStringBuilder.append("()");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.x
 * JD-Core Version:    0.7.0.1
 */