package com.google.gson.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import x7.b;

public class a<T>
{
  final int hashCode;
  final Class<? super T> rawType;
  final Type type;
  
  protected a()
  {
    Type localType = getSuperclassTypeParameter(getClass());
    this.type = localType;
    this.rawType = b.k(localType);
    this.hashCode = localType.hashCode();
  }
  
  a(Type paramType)
  {
    paramType = b.b((Type)x7.a.b(paramType));
    this.type = paramType;
    this.rawType = b.k(paramType);
    this.hashCode = paramType.hashCode();
  }
  
  private static AssertionError buildUnexpectedTypeError(Type paramType, Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i].getName());
      localStringBuilder.append(", ");
      i += 1;
    }
    localStringBuilder.append("but got: ");
    localStringBuilder.append(paramType.getClass().getName());
    localStringBuilder.append(", for type token: ");
    localStringBuilder.append(paramType.toString());
    localStringBuilder.append('.');
    return new AssertionError(localStringBuilder.toString());
  }
  
  public static <T> a<T> get(Class<T> paramClass)
  {
    return new a(paramClass);
  }
  
  public static a<?> get(Type paramType)
  {
    return new a(paramType);
  }
  
  public static a<?> getArray(Type paramType)
  {
    return new a(b.a(paramType));
  }
  
  public static a<?> getParameterized(Type paramType, Type... paramVarArgs)
  {
    return new a(b.o(null, paramType, paramVarArgs));
  }
  
  static Type getSuperclassTypeParameter(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if (!(paramClass instanceof Class)) {
      return b.b(((ParameterizedType)paramClass).getActualTypeArguments()[0]);
    }
    throw new RuntimeException("Missing type parameter.");
  }
  
  private static boolean isAssignableFrom(Type paramType, GenericArrayType paramGenericArrayType)
  {
    Type localType = paramGenericArrayType.getGenericComponentType();
    if ((localType instanceof ParameterizedType))
    {
      if ((paramType instanceof GenericArrayType))
      {
        paramGenericArrayType = ((GenericArrayType)paramType).getGenericComponentType();
      }
      else
      {
        paramGenericArrayType = paramType;
        if ((paramType instanceof Class)) {
          for (paramType = (Class)paramType;; paramType = paramType.getComponentType())
          {
            paramGenericArrayType = paramType;
            if (!paramType.isArray()) {
              break;
            }
          }
        }
      }
      return isAssignableFrom(paramGenericArrayType, (ParameterizedType)localType, new HashMap());
    }
    return true;
  }
  
  private static boolean isAssignableFrom(Type paramType, ParameterizedType paramParameterizedType, Map<String, Type> paramMap)
  {
    int j = 0;
    if (paramType == null) {
      return false;
    }
    if (paramParameterizedType.equals(paramType)) {
      return true;
    }
    Class localClass = b.k(paramType);
    ParameterizedType localParameterizedType = null;
    if ((paramType instanceof ParameterizedType)) {
      localParameterizedType = (ParameterizedType)paramType;
    }
    if (localParameterizedType != null)
    {
      Type[] arrayOfType = localParameterizedType.getActualTypeArguments();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      i = 0;
      while (i < arrayOfType.length)
      {
        paramType = arrayOfType[i];
        TypeVariable localTypeVariable = arrayOfTypeVariable[i];
        while ((paramType instanceof TypeVariable)) {
          paramType = (Type)paramMap.get(((TypeVariable)paramType).getName());
        }
        paramMap.put(localTypeVariable.getName(), paramType);
        i += 1;
      }
      if (typeEquals(localParameterizedType, paramParameterizedType, paramMap)) {
        return true;
      }
    }
    paramType = localClass.getGenericInterfaces();
    int k = paramType.length;
    int i = j;
    while (i < k)
    {
      if (isAssignableFrom(paramType[i], paramParameterizedType, new HashMap(paramMap))) {
        return true;
      }
      i += 1;
    }
    return isAssignableFrom(localClass.getGenericSuperclass(), paramParameterizedType, new HashMap(paramMap));
  }
  
  private static boolean matches(Type paramType1, Type paramType2, Map<String, Type> paramMap)
  {
    return (paramType2.equals(paramType1)) || (((paramType1 instanceof TypeVariable)) && (paramType2.equals(paramMap.get(((TypeVariable)paramType1).getName()))));
  }
  
  private static boolean typeEquals(ParameterizedType paramParameterizedType1, ParameterizedType paramParameterizedType2, Map<String, Type> paramMap)
  {
    if (paramParameterizedType1.getRawType().equals(paramParameterizedType2.getRawType()))
    {
      paramParameterizedType1 = paramParameterizedType1.getActualTypeArguments();
      paramParameterizedType2 = paramParameterizedType2.getActualTypeArguments();
      int i = 0;
      while (i < paramParameterizedType1.length)
      {
        if (!matches(paramParameterizedType1[i], paramParameterizedType2[i], paramMap)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (b.f(this.type, ((a)paramObject).type));
  }
  
  public final Class<? super T> getRawType()
  {
    return this.rawType;
  }
  
  public final Type getType()
  {
    return this.type;
  }
  
  public final int hashCode()
  {
    return this.hashCode;
  }
  
  @Deprecated
  public boolean isAssignableFrom(a<?> parama)
  {
    return isAssignableFrom(parama.getType());
  }
  
  @Deprecated
  public boolean isAssignableFrom(Class<?> paramClass)
  {
    return isAssignableFrom(paramClass);
  }
  
  @Deprecated
  public boolean isAssignableFrom(Type paramType)
  {
    boolean bool2 = false;
    if (paramType == null) {
      return false;
    }
    if (this.type.equals(paramType)) {
      return true;
    }
    Type localType = this.type;
    if ((localType instanceof Class)) {
      return this.rawType.isAssignableFrom(b.k(paramType));
    }
    if ((localType instanceof ParameterizedType)) {
      return isAssignableFrom(paramType, (ParameterizedType)localType, new HashMap());
    }
    if ((localType instanceof GenericArrayType))
    {
      boolean bool1 = bool2;
      if (this.rawType.isAssignableFrom(b.k(paramType)))
      {
        bool1 = bool2;
        if (isAssignableFrom(paramType, (GenericArrayType)this.type)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw buildUnexpectedTypeError(localType, new Class[] { Class.class, ParameterizedType.class, GenericArrayType.class });
  }
  
  public final String toString()
  {
    return b.u(this.type);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.gson.reflect.a
 * JD-Core Version:    0.7.0.1
 */