package ea;

import aa.b;
import aa.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import l9.g0;

final class y
{
  static final Type[] a = new Type[0];
  
  static g0 a(g0 paramg0)
  {
    b localb = new b();
    paramg0.e0().T(localb);
    return g0.d0(paramg0.B(), paramg0.i(), localb);
  }
  
  static void b(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      if (!((Class)paramType).isPrimitive()) {
        return;
      }
      throw new IllegalArgumentException();
    }
  }
  
  @Nullable
  private static Class<?> c(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  static boolean d(Type paramType1, Type paramType2)
  {
    if (paramType1 == paramType2) {
      return true;
    }
    if ((paramType1 instanceof Class)) {
      return paramType1.equals(paramType2);
    }
    if ((paramType1 instanceof ParameterizedType))
    {
      if (!(paramType2 instanceof ParameterizedType)) {
        return false;
      }
      paramType1 = (ParameterizedType)paramType1;
      paramType2 = (ParameterizedType)paramType2;
      Type localType1 = paramType1.getOwnerType();
      Type localType2 = paramType2.getOwnerType();
      return ((localType1 == localType2) || ((localType1 != null) && (localType1.equals(localType2)))) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()));
    }
    if ((paramType1 instanceof GenericArrayType))
    {
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      return d(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      return (Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()));
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      return (paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()));
    }
    return false;
  }
  
  static Type e(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return e(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i += 1;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return e(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  static Type f(int paramInt, ParameterizedType paramParameterizedType)
  {
    Type localType = paramParameterizedType.getActualTypeArguments()[paramInt];
    paramParameterizedType = localType;
    if ((localType instanceof WildcardType)) {
      paramParameterizedType = ((WildcardType)localType).getLowerBounds()[0];
    }
    return paramParameterizedType;
  }
  
  static Type g(int paramInt, ParameterizedType paramParameterizedType)
  {
    Object localObject = paramParameterizedType.getActualTypeArguments();
    if ((paramInt >= 0) && (paramInt < localObject.length))
    {
      localObject = localObject[paramInt];
      paramParameterizedType = (ParameterizedType)localObject;
      if ((localObject instanceof WildcardType)) {
        paramParameterizedType = ((WildcardType)localObject).getUpperBounds()[0];
      }
      return paramParameterizedType;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" not in range [0,");
    localStringBuilder.append(localObject.length);
    localStringBuilder.append(") for ");
    localStringBuilder.append(paramParameterizedType);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Class<?> h(Type paramType)
  {
    Objects.requireNonNull(paramType, "type == null");
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      throw new IllegalArgumentException();
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(h(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return h(((WildcardType)paramType).getUpperBounds()[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(paramType.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Type i(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isAssignableFrom(paramClass1)) {
      return q(paramType, paramClass1, e(paramType, paramClass1, paramClass2));
    }
    throw new IllegalArgumentException();
  }
  
  static boolean j(@Nullable Type paramType)
  {
    if ((paramType instanceof Class)) {
      return false;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      int j = paramType.length;
      int i = 0;
      while (i < j)
      {
        if (j(paramType[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    if ((paramType instanceof GenericArrayType)) {
      return j(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof TypeVariable)) {
      return true;
    }
    if ((paramType instanceof WildcardType)) {
      return true;
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static int k(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  static boolean l(Annotation[] paramArrayOfAnnotation, Class<? extends Annotation> paramClass)
  {
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass.isInstance(paramArrayOfAnnotation[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static RuntimeException m(Method paramMethod, String paramString, Object... paramVarArgs)
  {
    return n(paramMethod, null, paramString, paramVarArgs);
  }
  
  static RuntimeException n(Method paramMethod, @Nullable Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(paramString);
    paramVarArgs.append("\n    for method ");
    paramVarArgs.append(paramMethod.getDeclaringClass().getSimpleName());
    paramVarArgs.append(".");
    paramVarArgs.append(paramMethod.getName());
    return new IllegalArgumentException(paramVarArgs.toString(), paramThrowable);
  }
  
  static RuntimeException o(Method paramMethod, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return m(paramMethod, localStringBuilder.toString(), paramVarArgs);
  }
  
  static RuntimeException p(Method paramMethod, Throwable paramThrowable, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return n(paramMethod, paramThrowable, localStringBuilder.toString(), paramVarArgs);
  }
  
  static Type q(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      paramType2 = r(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 == localObject1) {
        return paramType2;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramType1 = q(paramType1, paramClass, paramType2);
        if (paramType2 == paramType1) {
          return localObject1;
        }
        return new a(paramType1);
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = q(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1) {
        return paramType2;
      }
      return new a(paramType1);
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int k = 0;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = q(paramType1, paramClass, paramType2);
      int i;
      if (localObject3 != paramType2) {
        i = 1;
      } else {
        i = 0;
      }
      paramType2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      int m = paramType2.length;
      while (k < m)
      {
        Type localType = q(paramType1, paramClass, paramType2[k]);
        int j = i;
        localObject1 = paramType2;
        if (localType != paramType2[k])
        {
          j = i;
          localObject1 = paramType2;
          if (i == 0)
          {
            localObject1 = (Type[])paramType2.clone();
            j = 1;
          }
          localObject1[k] = localType;
        }
        k += 1;
        i = j;
        paramType2 = (Type)localObject1;
      }
      paramType1 = (Type)localObject2;
      if (i != 0) {
        paramType1 = new b((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject1 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject2 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = q(paramType1, paramClass, localObject3[0]);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0]) {
          return new c(new Type[] { Object.class }, new Type[] { paramType1 });
        }
      }
      else
      {
        localObject1 = paramType2;
        if (localObject2.length == 1) {
          localObject1 = localObject2[0];
        }
      }
    }
    try
    {
      paramType1 = q(paramType1, paramClass, (Type)localObject1);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0])
      {
        paramClass = a;
        return new c(new Type[] { paramType1 }, paramClass);
      }
      return localObject1;
    }
    finally {}
  }
  
  private static Type r(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = c(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = e(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = k(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  static void s(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
  
  static String t(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  private static final class a
    implements GenericArrayType
  {
    private final Type a;
    
    a(Type paramType)
    {
      this.a = paramType;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (y.d(this, (GenericArrayType)paramObject));
    }
    
    public Type getGenericComponentType()
    {
      return this.a;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y.t(this.a));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    implements ParameterizedType
  {
    @Nullable
    private final Type a;
    private final Type b;
    private final Type[] c;
    
    b(@Nullable Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool = paramType2 instanceof Class;
      int k = 0;
      if (bool)
      {
        j = 1;
        if (paramType1 == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (((Class)paramType2).getEnclosingClass() != null) {
          j = 0;
        }
        if (i != j) {
          throw new IllegalArgumentException();
        }
      }
      int j = paramVarArgs.length;
      int i = k;
      while (i < j)
      {
        Type localType = paramVarArgs[i];
        Objects.requireNonNull(localType, "typeArgument == null");
        y.b(localType);
        i += 1;
      }
      this.a = paramType1;
      this.b = paramType2;
      this.c = ((Type[])paramVarArgs.clone());
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (y.d(this, (ParameterizedType)paramObject));
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.c.clone();
    }
    
    @Nullable
    public Type getOwnerType()
    {
      return this.a;
    }
    
    public Type getRawType()
    {
      return this.b;
    }
    
    public int hashCode()
    {
      int j = Arrays.hashCode(this.c);
      int k = this.b.hashCode();
      Type localType = this.a;
      int i;
      if (localType != null) {
        i = localType.hashCode();
      } else {
        i = 0;
      }
      return j ^ k ^ i;
    }
    
    public String toString()
    {
      Object localObject = this.c;
      if (localObject.length == 0) {
        return y.t(this.b);
      }
      int j = localObject.length;
      int i = 1;
      localObject = new StringBuilder((j + 1) * 30);
      ((StringBuilder)localObject).append(y.t(this.b));
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append(y.t(this.c[0]));
      while (i < this.c.length)
      {
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(y.t(this.c[i]));
        i += 1;
      }
      ((StringBuilder)localObject).append(">");
      return ((StringBuilder)localObject).toString();
    }
  }
  
  private static final class c
    implements WildcardType
  {
    private final Type a;
    @Nullable
    private final Type b;
    
    c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= 1)
      {
        if (paramArrayOfType1.length == 1)
        {
          if (paramArrayOfType2.length == 1)
          {
            Objects.requireNonNull(paramArrayOfType2[0]);
            y.b(paramArrayOfType2[0]);
            if (paramArrayOfType1[0] == Object.class)
            {
              this.b = paramArrayOfType2[0];
              this.a = Object.class;
              return;
            }
            throw new IllegalArgumentException();
          }
          Objects.requireNonNull(paramArrayOfType1[0]);
          y.b(paramArrayOfType1[0]);
          this.b = null;
          this.a = paramArrayOfType1[0];
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (y.d(this, (WildcardType)paramObject));
    }
    
    public Type[] getLowerBounds()
    {
      Type localType = this.b;
      if (localType != null) {
        return new Type[] { localType };
      }
      return y.a;
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.a };
    }
    
    public int hashCode()
    {
      Type localType = this.b;
      int i;
      if (localType != null) {
        i = localType.hashCode() + 31;
      } else {
        i = 1;
      }
      return i ^ this.a.hashCode() + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder;
      if (this.b != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("? super ");
      }
      for (Type localType = this.b;; localType = this.a)
      {
        localStringBuilder.append(y.t(localType));
        return localStringBuilder.toString();
        if (this.a == Object.class) {
          return "?";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("? extends ");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.y
 * JD-Core Version:    0.7.0.1
 */