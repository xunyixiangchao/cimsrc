package x7;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b
{
  static final Type[] a = new Type[0];
  
  public static GenericArrayType a(Type paramType)
  {
    return new a(paramType);
  }
  
  public static Type b(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      paramType = localClass;
      if (localClass.isArray()) {
        paramType = new a(b(localClass.getComponentType()));
      }
      return paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new a(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new c(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  static void c(Type paramType)
  {
    boolean bool;
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      bool = false;
    } else {
      bool = true;
    }
    a.a(bool);
  }
  
  private static Class<?> d(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  static boolean e(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean f(Type paramType1, Type paramType2)
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
      return (e(paramType1.getOwnerType(), paramType2.getOwnerType())) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()));
    }
    if ((paramType1 instanceof GenericArrayType))
    {
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      return f(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
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
  
  public static Type g(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  public static Type h(Type paramType, Class<?> paramClass)
  {
    paramClass = l(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments()[0];
    }
    return Object.class;
  }
  
  static Type i(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
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
          return i(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
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
          return i(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  public static Type[] j(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class) {
      return new Type[] { String.class, String.class };
    }
    paramType = l(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return new Type[] { Object.class, Object.class };
  }
  
  public static Class<?> k(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      a.a(paramType instanceof Class);
      return (Class)paramType;
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(k(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return k(((WildcardType)paramType).getUpperBounds()[0]);
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
  
  static Type l(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    a.a(paramClass2.isAssignableFrom(paramClass1));
    return p(localType, paramClass1, i(localType, paramClass1, paramClass2));
  }
  
  static int m(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  private static int n(Object[] paramArrayOfObject, Object paramObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  public static ParameterizedType o(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new b(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type p(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    return q(paramType1, paramClass, paramType2, new HashSet());
  }
  
  private static Type q(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection)
  {
    Object localObject2;
    while ((paramType2 instanceof TypeVariable))
    {
      localObject2 = (TypeVariable)paramType2;
      if (paramCollection.contains(localObject2)) {
        return paramType2;
      }
      paramCollection.add(localObject2);
      localObject1 = r(paramType1, paramClass, (TypeVariable)localObject2);
      paramType2 = (Type)localObject1;
      if (localObject1 == localObject2) {
        return localObject1;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramType1 = q(paramType1, paramClass, paramType2, paramCollection);
        if (paramType2 == paramType1) {
          return localObject1;
        }
        return a(paramType1);
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = q(paramType1, paramClass, (Type)localObject1, paramCollection);
      if (localObject1 == paramType1) {
        return paramType2;
      }
      return a(paramType1);
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int k = 0;
    Object localObject3;
    if (bool)
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = q(paramType1, paramClass, paramType2, paramCollection);
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
        Type localType = q(paramType1, paramClass, paramType2[k], paramCollection);
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
        paramType1 = o((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
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
        paramType1 = q(paramType1, paramClass, localObject3[0], paramCollection);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0]) {
          return t(paramType1);
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
      paramType1 = q(paramType1, paramClass, (Type)localObject1, paramCollection);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0]) {
        return s(paramType1);
      }
      return localObject1;
    }
    finally {}
  }
  
  static Type r(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = d(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = i(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = n(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  public static WildcardType s(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ((WildcardType)paramType).getUpperBounds();
    } else {
      paramType = new Type[] { paramType };
    }
    return new c(paramType, a);
  }
  
  public static WildcardType t(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ((WildcardType)paramType).getLowerBounds();
    } else {
      paramType = new Type[] { paramType };
    }
    return new c(new Type[] { Object.class }, paramType);
  }
  
  public static String u(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  private static final class a
    implements GenericArrayType, Serializable
  {
    private final Type a;
    
    public a(Type paramType)
    {
      this.a = b.b(paramType);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (b.f(this, (GenericArrayType)paramObject));
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
      localStringBuilder.append(b.u(this.a));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  private static final class b
    implements ParameterizedType, Serializable
  {
    private final Type a;
    private final Type b;
    private final Type[] c;
    
    public b(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1 = paramType2 instanceof Class;
      int j = 0;
      if (bool1)
      {
        Class localClass = (Class)paramType2;
        bool1 = Modifier.isStatic(localClass.getModifiers());
        boolean bool2 = true;
        if ((!bool1) && (localClass.getEnclosingClass() != null)) {
          i = 0;
        } else {
          i = 1;
        }
        bool1 = bool2;
        if (paramType1 == null) {
          if (i != 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        a.a(bool1);
      }
      if (paramType1 == null) {
        paramType1 = null;
      } else {
        paramType1 = b.b(paramType1);
      }
      this.a = paramType1;
      this.b = b.b(paramType2);
      paramType1 = (Type[])paramVarArgs.clone();
      this.c = paramType1;
      int k = paramType1.length;
      int i = j;
      while (i < k)
      {
        a.b(this.c[i]);
        b.c(this.c[i]);
        paramType1 = this.c;
        paramType1[i] = b.b(paramType1[i]);
        i += 1;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (b.f(this, (ParameterizedType)paramObject));
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.c.clone();
    }
    
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
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ b.m(this.a);
    }
    
    public String toString()
    {
      int j = this.c.length;
      if (j == 0) {
        return b.u(this.b);
      }
      StringBuilder localStringBuilder = new StringBuilder((j + 1) * 30);
      localStringBuilder.append(b.u(this.b));
      localStringBuilder.append("<");
      localStringBuilder.append(b.u(this.c[0]));
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(b.u(this.c[i]));
        i += 1;
      }
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
  
  private static final class c
    implements WildcardType, Serializable
  {
    private final Type a;
    private final Type b;
    
    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      int i = paramArrayOfType2.length;
      boolean bool2 = true;
      boolean bool1;
      if (i <= 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a.a(bool1);
      if (paramArrayOfType1.length == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a.a(bool1);
      if (paramArrayOfType2.length == 1)
      {
        a.b(paramArrayOfType2[0]);
        b.c(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] == Object.class) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        a.a(bool1);
        this.b = b.b(paramArrayOfType2[0]);
        this.a = Object.class;
        return;
      }
      a.b(paramArrayOfType1[0]);
      b.c(paramArrayOfType1[0]);
      this.b = null;
      this.a = b.b(paramArrayOfType1[0]);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (b.f(this, (WildcardType)paramObject));
    }
    
    public Type[] getLowerBounds()
    {
      Type localType = this.b;
      if (localType != null) {
        return new Type[] { localType };
      }
      return b.a;
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
        localStringBuilder.append(b.u(localType));
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
 * Qualified Name:     x7.b
 * JD-Core Version:    0.7.0.1
 */