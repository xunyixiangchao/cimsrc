package ea;

import ga.b;
import ga.c;
import ga.d;
import ga.e;
import ga.f;
import ga.g;
import ga.h;
import ga.i;
import ga.j;
import ga.k;
import ga.m;
import ga.n;
import ga.o;
import ga.q;
import ga.t;
import ga.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import l9.a0.c;
import l9.d0;
import l9.d0.a;
import l9.w;
import l9.w.a;
import l9.z;

final class s
{
  private final Method a;
  private final l9.x b;
  final String c;
  @Nullable
  private final String d;
  @Nullable
  private final w e;
  @Nullable
  private final z f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final p<?>[] j;
  final boolean k;
  
  s(a parama)
  {
    this.a = parama.b;
    this.b = parama.a.c;
    this.c = parama.n;
    this.d = parama.r;
    this.e = parama.s;
    this.f = parama.t;
    this.g = parama.o;
    this.h = parama.p;
    this.i = parama.q;
    this.j = parama.v;
    this.k = parama.w;
  }
  
  static s b(u paramu, Method paramMethod)
  {
    return new a(paramu, paramMethod).b();
  }
  
  d0 a(Object[] paramArrayOfObject)
  {
    p[] arrayOfp = this.j;
    int n = paramArrayOfObject.length;
    if (n == arrayOfp.length)
    {
      r localr = new r(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i);
      int m = n;
      if (this.k) {
        m = n - 1;
      }
      ArrayList localArrayList = new ArrayList(m);
      n = 0;
      while (n < m)
      {
        localArrayList.add(paramArrayOfObject[n]);
        arrayOfp[n].a(localr, paramArrayOfObject[n]);
        n += 1;
      }
      return localr.k().n(l.class, new l(this.a, localArrayList)).b();
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Argument count (");
    paramArrayOfObject.append(n);
    paramArrayOfObject.append(") doesn't match expected count (");
    paramArrayOfObject.append(arrayOfp.length);
    paramArrayOfObject.append(")");
    throw new IllegalArgumentException(paramArrayOfObject.toString());
  }
  
  static final class a
  {
    private static final Pattern x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private static final Pattern y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    final u a;
    final Method b;
    final Annotation[] c;
    final Annotation[][] d;
    final Type[] e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    @Nullable
    String n;
    boolean o;
    boolean p;
    boolean q;
    @Nullable
    String r;
    @Nullable
    w s;
    @Nullable
    z t;
    @Nullable
    Set<String> u;
    @Nullable
    p<?>[] v;
    boolean w;
    
    a(u paramu, Method paramMethod)
    {
      this.a = paramu;
      this.b = paramMethod;
      this.c = paramMethod.getAnnotations();
      this.e = paramMethod.getGenericParameterTypes();
      this.d = paramMethod.getParameterAnnotations();
    }
    
    private static Class<?> a(Class<?> paramClass)
    {
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      Object localObject = paramClass;
      if (Short.TYPE == paramClass) {
        localObject = Short.class;
      }
      return localObject;
    }
    
    private w c(String[] paramArrayOfString)
    {
      w.a locala = new w.a();
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str2 = paramArrayOfString[i1];
        int i3 = str2.indexOf(':');
        if ((i3 != -1) && (i3 != 0) && (i3 != str2.length() - 1))
        {
          String str1 = str2.substring(0, i3);
          str2 = str2.substring(i3 + 1).trim();
          if ("Content-Type".equalsIgnoreCase(str1)) {
            try
            {
              this.t = z.b(str2);
            }
            catch (IllegalArgumentException paramArrayOfString)
            {
              throw y.n(this.b, paramArrayOfString, "Malformed content type: %s", new Object[] { str2 });
            }
          } else {
            locala.a(str1, str2);
          }
          i1 += 1;
        }
        else
        {
          throw y.m(this.b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[] { str2 });
        }
      }
      return locala.f();
    }
    
    private void d(String paramString1, String paramString2, boolean paramBoolean)
    {
      String str = this.n;
      if (str == null)
      {
        this.n = paramString1;
        this.o = paramBoolean;
        if (paramString2.isEmpty()) {
          return;
        }
        int i1 = paramString2.indexOf('?');
        if ((i1 != -1) && (i1 < paramString2.length() - 1))
        {
          paramString1 = paramString2.substring(i1 + 1);
          if (x.matcher(paramString1).find()) {
            throw y.m(this.b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[] { paramString1 });
          }
        }
        this.r = paramString2;
        this.u = h(paramString2);
        return;
      }
      throw y.m(this.b, "Only one HTTP method is allowed. Found: %s and %s.", new Object[] { str, paramString1 });
    }
    
    private void e(Annotation paramAnnotation)
    {
      String str;
      if ((paramAnnotation instanceof b))
      {
        str = ((b)paramAnnotation).value();
        paramAnnotation = "DELETE";
      }
      for (;;)
      {
        d(paramAnnotation, str, false);
        return;
        if ((paramAnnotation instanceof f))
        {
          str = ((f)paramAnnotation).value();
          paramAnnotation = "GET";
        }
        else if ((paramAnnotation instanceof g))
        {
          str = ((g)paramAnnotation).value();
          paramAnnotation = "HEAD";
        }
        else
        {
          if ((paramAnnotation instanceof n))
          {
            str = ((n)paramAnnotation).value();
            paramAnnotation = "PATCH";
          }
          for (;;)
          {
            d(paramAnnotation, str, true);
            return;
            if ((paramAnnotation instanceof o))
            {
              str = ((o)paramAnnotation).value();
              paramAnnotation = "POST";
            }
            else
            {
              if (!(paramAnnotation instanceof ga.p)) {
                break;
              }
              str = ((ga.p)paramAnnotation).value();
              paramAnnotation = "PUT";
            }
          }
          if (!(paramAnnotation instanceof m)) {
            break;
          }
          str = ((m)paramAnnotation).value();
          paramAnnotation = "OPTIONS";
        }
      }
      if ((paramAnnotation instanceof h))
      {
        paramAnnotation = (h)paramAnnotation;
        d(paramAnnotation.method(), paramAnnotation.path(), paramAnnotation.hasBody());
        return;
      }
      if ((paramAnnotation instanceof k))
      {
        paramAnnotation = ((k)paramAnnotation).value();
        if (paramAnnotation.length != 0)
        {
          this.s = c(paramAnnotation);
          return;
        }
        throw y.m(this.b, "@Headers annotation is empty.", new Object[0]);
      }
      if ((paramAnnotation instanceof ga.l))
      {
        if (!this.p)
        {
          this.q = true;
          return;
        }
        throw y.m(this.b, "Only one encoding annotation is allowed.", new Object[0]);
      }
      if ((paramAnnotation instanceof e))
      {
        if (!this.q)
        {
          this.p = true;
          return;
        }
        throw y.m(this.b, "Only one encoding annotation is allowed.", new Object[0]);
      }
    }
    
    @Nullable
    private p<?> f(int paramInt, Type paramType, @Nullable Annotation[] paramArrayOfAnnotation, boolean paramBoolean)
    {
      if (paramArrayOfAnnotation != null)
      {
        int i2 = paramArrayOfAnnotation.length;
        Object localObject1 = null;
        int i1 = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i1 >= i2) {
            break label83;
          }
          localObject2 = g(paramInt, paramType, paramArrayOfAnnotation, paramArrayOfAnnotation[i1]);
          if (localObject2 != null)
          {
            if (localObject1 != null) {
              break;
            }
            localObject1 = localObject2;
          }
          i1 += 1;
        }
        throw y.o(this.b, paramInt, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
      }
      Object localObject2 = null;
      label83:
      if ((localObject2 != null) || (paramBoolean)) {}
      try
      {
        if (y.h(paramType) == s8.a.class)
        {
          this.w = true;
          return null;
        }
      }
      catch (NoClassDefFoundError paramType)
      {
        label110:
        break label110;
      }
      throw y.o(this.b, paramInt, "No Retrofit annotation found.", new Object[0]);
      return localObject2;
    }
    
    @Nullable
    private p<?> g(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation, Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof ga.y))
      {
        j(paramInt, paramType);
        if (!this.m)
        {
          if (!this.i)
          {
            if (!this.j)
            {
              if (!this.k)
              {
                if (!this.l)
                {
                  if (this.r == null)
                  {
                    this.m = true;
                    if ((paramType != l9.x.class) && (paramType != String.class) && (paramType != URI.class) && ((!(paramType instanceof Class)) || (!"android.net.Uri".equals(((Class)paramType).getName())))) {
                      throw y.o(this.b, paramInt, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                    }
                    return new p.p(this.b, paramInt);
                  }
                  throw y.o(this.b, paramInt, "@Url cannot be used with @%s URL", new Object[] { this.n });
                }
                throw y.o(this.b, paramInt, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
              }
              throw y.o(this.b, paramInt, "A @Url parameter must not come after a @QueryName.", new Object[0]);
            }
            throw y.o(this.b, paramInt, "A @Url parameter must not come after a @Query.", new Object[0]);
          }
          throw y.o(this.b, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "Multiple @Url method annotations found.", new Object[0]);
      }
      Object localObject;
      if ((paramAnnotation instanceof ga.s))
      {
        j(paramInt, paramType);
        if (!this.j)
        {
          if (!this.k)
          {
            if (!this.l)
            {
              if (!this.m)
              {
                if (this.r != null)
                {
                  this.i = true;
                  paramAnnotation = (ga.s)paramAnnotation;
                  localObject = paramAnnotation.value();
                  i(paramInt, (String)localObject);
                  paramType = this.a.i(paramType, paramArrayOfAnnotation);
                  return new p.k(this.b, paramInt, (String)localObject, paramType, paramAnnotation.encoded());
                }
                throw y.o(this.b, paramInt, "@Path can only be used with relative url on @%s", new Object[] { this.n });
              }
              throw y.o(this.b, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
            }
            throw y.o(this.b, paramInt, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
          }
          throw y.o(this.b, paramInt, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "A @Path parameter must not come after a @Query.", new Object[0]);
      }
      boolean bool;
      if ((paramAnnotation instanceof t))
      {
        j(paramInt, paramType);
        localObject = (t)paramAnnotation;
        paramAnnotation = ((t)localObject).value();
        bool = ((t)localObject).encoded();
        localObject = y.h(paramType);
        this.j = true;
        if (Iterable.class.isAssignableFrom((Class)localObject))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = y.g(0, (ParameterizedType)paramType);
            return new p.l(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool).c();
          }
          paramType = this.b;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (((Class)localObject).isArray())
        {
          paramType = a(((Class)localObject).getComponentType());
          return new p.l(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool).b();
        }
        return new p.l(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof v))
      {
        j(paramInt, paramType);
        bool = ((v)paramAnnotation).encoded();
        paramAnnotation = y.h(paramType);
        this.k = true;
        if (Iterable.class.isAssignableFrom(paramAnnotation))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = y.g(0, (ParameterizedType)paramType);
            return new p.n(this.a.i(paramType, paramArrayOfAnnotation), bool).c();
          }
          paramType = this.b;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (paramAnnotation.isArray())
        {
          paramType = a(paramAnnotation.getComponentType());
          return new p.n(this.a.i(paramType, paramArrayOfAnnotation), bool).b();
        }
        return new p.n(this.a.i(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof ga.u))
      {
        j(paramInt, paramType);
        localObject = y.h(paramType);
        this.l = true;
        if (Map.class.isAssignableFrom((Class)localObject))
        {
          paramType = y.i(paramType, (Class)localObject, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            localObject = (ParameterizedType)paramType;
            paramType = y.g(0, (ParameterizedType)localObject);
            if (String.class == paramType)
            {
              paramType = y.g(1, (ParameterizedType)localObject);
              paramType = this.a.i(paramType, paramArrayOfAnnotation);
              return new p.m(this.b, paramInt, paramType, ((ga.u)paramAnnotation).encoded());
            }
            paramArrayOfAnnotation = this.b;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@QueryMap keys must be of type String: ");
            paramAnnotation.append(paramType);
            throw y.o(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          throw y.o(this.b, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@QueryMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof i))
      {
        j(paramInt, paramType);
        paramAnnotation = ((i)paramAnnotation).value();
        localObject = y.h(paramType);
        if (Iterable.class.isAssignableFrom((Class)localObject))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = y.g(0, (ParameterizedType)paramType);
            return new p.f(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation)).c();
          }
          paramType = this.b;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (((Class)localObject).isArray())
        {
          paramType = a(((Class)localObject).getComponentType());
          return new p.f(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation)).b();
        }
        return new p.f(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation));
      }
      if ((paramAnnotation instanceof j))
      {
        if (paramType == w.class) {
          return new p.h(this.b, paramInt);
        }
        j(paramInt, paramType);
        paramAnnotation = y.h(paramType);
        if (Map.class.isAssignableFrom(paramAnnotation))
        {
          paramType = y.i(paramType, paramAnnotation, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            paramAnnotation = (ParameterizedType)paramType;
            paramType = y.g(0, paramAnnotation);
            if (String.class == paramType)
            {
              paramType = y.g(1, paramAnnotation);
              paramType = this.a.i(paramType, paramArrayOfAnnotation);
              return new p.g(this.b, paramInt, paramType);
            }
            paramArrayOfAnnotation = this.b;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@HeaderMap keys must be of type String: ");
            paramAnnotation.append(paramType);
            throw y.o(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          throw y.o(this.b, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@HeaderMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof c))
      {
        j(paramInt, paramType);
        if (this.p)
        {
          localObject = (c)paramAnnotation;
          paramAnnotation = ((c)localObject).value();
          bool = ((c)localObject).encoded();
          this.f = true;
          localObject = y.h(paramType);
          if (Iterable.class.isAssignableFrom((Class)localObject))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = y.g(0, (ParameterizedType)paramType);
              return new p.d(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool).c();
            }
            paramType = this.b;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (((Class)localObject).isArray())
          {
            paramType = a(((Class)localObject).getComponentType());
            return new p.d(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool).b();
          }
          return new p.d(paramAnnotation, this.a.i(paramType, paramArrayOfAnnotation), bool);
        }
        throw y.o(this.b, paramInt, "@Field parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof d))
      {
        j(paramInt, paramType);
        if (this.p)
        {
          localObject = y.h(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = y.i(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = y.g(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = y.g(1, (ParameterizedType)localObject);
                paramType = this.a.i(paramType, paramArrayOfAnnotation);
                this.f = true;
                return new p.e(this.b, paramInt, paramType, ((d)paramAnnotation).encoded());
              }
              paramArrayOfAnnotation = this.b;
              paramAnnotation = new StringBuilder();
              paramAnnotation.append("@FieldMap keys must be of type String: ");
              paramAnnotation.append(paramType);
              throw y.o(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
            }
            throw y.o(this.b, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw y.o(this.b, paramInt, "@FieldMap parameter type must be Map.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof q))
      {
        j(paramInt, paramType);
        if (this.q)
        {
          localObject = (q)paramAnnotation;
          this.g = true;
          String str = ((q)localObject).value();
          paramAnnotation = y.h(paramType);
          if (str.isEmpty())
          {
            if (Iterable.class.isAssignableFrom(paramAnnotation))
            {
              if ((paramType instanceof ParameterizedType))
              {
                if (a0.c.class.isAssignableFrom(y.h(y.g(0, (ParameterizedType)paramType)))) {
                  return p.o.a.c();
                }
                throw y.o(this.b, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
              }
              paramType = this.b;
              paramArrayOfAnnotation = new StringBuilder();
              paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
              paramArrayOfAnnotation.append(" must include generic type (e.g., ");
              paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
              paramArrayOfAnnotation.append("<String>)");
              throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
            }
            if (paramAnnotation.isArray())
            {
              if (a0.c.class.isAssignableFrom(paramAnnotation.getComponentType())) {
                return p.o.a.b();
              }
              throw y.o(this.b, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            }
            if (a0.c.class.isAssignableFrom(paramAnnotation)) {
              return p.o.a;
            }
            throw y.o(this.b, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("form-data; name=\"");
          localStringBuilder.append(str);
          localStringBuilder.append("\"");
          localObject = w.e(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", ((q)localObject).encoding() });
          if (Iterable.class.isAssignableFrom(paramAnnotation))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = y.g(0, (ParameterizedType)paramType);
              if (!a0.c.class.isAssignableFrom(y.h(paramType)))
              {
                paramType = this.a.g(paramType, paramArrayOfAnnotation, this.c);
                return new p.i(this.b, paramInt, (w)localObject, paramType).c();
              }
              throw y.o(this.b, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
            }
            paramType = this.b;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw y.o(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (paramAnnotation.isArray())
          {
            paramType = a(paramAnnotation.getComponentType());
            if (!a0.c.class.isAssignableFrom(paramType))
            {
              paramType = this.a.g(paramType, paramArrayOfAnnotation, this.c);
              return new p.i(this.b, paramInt, (w)localObject, paramType).b();
            }
            throw y.o(this.b, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
          }
          if (!a0.c.class.isAssignableFrom(paramAnnotation))
          {
            paramType = this.a.g(paramType, paramArrayOfAnnotation, this.c);
            return new p.i(this.b, paramInt, (w)localObject, paramType);
          }
          throw y.o(this.b, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@Part parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof ga.r))
      {
        j(paramInt, paramType);
        if (this.q)
        {
          this.g = true;
          localObject = y.h(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = y.i(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = y.g(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = y.g(1, (ParameterizedType)localObject);
                if (!a0.c.class.isAssignableFrom(y.h(paramType)))
                {
                  paramType = this.a.g(paramType, paramArrayOfAnnotation, this.c);
                  paramArrayOfAnnotation = (ga.r)paramAnnotation;
                  return new p.j(this.b, paramInt, paramType, paramArrayOfAnnotation.encoding());
                }
                throw y.o(this.b, paramInt, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
              }
              paramArrayOfAnnotation = this.b;
              paramAnnotation = new StringBuilder();
              paramAnnotation.append("@PartMap keys must be of type String: ");
              paramAnnotation.append(paramType);
              throw y.o(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
            }
            throw y.o(this.b, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw y.o(this.b, paramInt, "@PartMap parameter type must be Map.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof ga.a))
      {
        j(paramInt, paramType);
        if ((!this.p) && (!this.q))
        {
          if (!this.h) {
            try
            {
              paramArrayOfAnnotation = this.a.g(paramType, paramArrayOfAnnotation, this.c);
              this.h = true;
              return new p.c(this.b, paramInt, paramArrayOfAnnotation);
            }
            catch (RuntimeException paramArrayOfAnnotation)
            {
              throw y.p(this.b, paramArrayOfAnnotation, paramInt, "Unable to create @Body converter for %s", new Object[] { paramType });
            }
          }
          throw y.o(this.b, paramInt, "Multiple @Body method annotations found.", new Object[0]);
        }
        throw y.o(this.b, paramInt, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof ga.x))
      {
        j(paramInt, paramType);
        paramType = y.h(paramType);
        int i1 = paramInt - 1;
        while (i1 >= 0)
        {
          paramArrayOfAnnotation = this.v[i1];
          if (((paramArrayOfAnnotation instanceof p.q)) && (((p.q)paramArrayOfAnnotation).a.equals(paramType)))
          {
            paramArrayOfAnnotation = this.b;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@Tag type ");
            paramAnnotation.append(paramType.getName());
            paramAnnotation.append(" is duplicate of parameter #");
            paramAnnotation.append(i1 + 1);
            paramAnnotation.append(" and would always overwrite its value.");
            throw y.o(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          i1 -= 1;
        }
        return new p.q(paramType);
      }
      return null;
    }
    
    static Set<String> h(String paramString)
    {
      paramString = x.matcher(paramString);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      while (paramString.find()) {
        localLinkedHashSet.add(paramString.group(1));
      }
      return localLinkedHashSet;
    }
    
    private void i(int paramInt, String paramString)
    {
      if (y.matcher(paramString).matches())
      {
        if (this.u.contains(paramString)) {
          return;
        }
        throw y.o(this.b, paramInt, "URL \"%s\" does not contain \"{%s}\".", new Object[] { this.r, paramString });
      }
      throw y.o(this.b, paramInt, "@Path parameter name must match %s. Found: %s", new Object[] { x.pattern(), paramString });
    }
    
    private void j(int paramInt, Type paramType)
    {
      if (!y.j(paramType)) {
        return;
      }
      throw y.o(this.b, paramInt, "Parameter type must not include a type variable or wildcard: %s", new Object[] { paramType });
    }
    
    s b()
    {
      Object localObject = this.c;
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        e(localObject[i1]);
        i1 += 1;
      }
      if (this.n != null)
      {
        if (!this.o) {
          if (!this.q)
          {
            if (this.p) {
              throw y.m(this.b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
          }
          else {
            throw y.m(this.b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
          }
        }
        i2 = this.d.length;
        this.v = new p[i2];
        i1 = 0;
        for (;;)
        {
          bool = true;
          if (i1 >= i2) {
            break;
          }
          localObject = this.v;
          Type localType = this.e[i1];
          Annotation[] arrayOfAnnotation = this.d[i1];
          if (i1 != i2 - 1) {
            bool = false;
          }
          localObject[i1] = f(i1, localType, arrayOfAnnotation, bool);
          i1 += 1;
        }
        if ((this.r == null) && (!this.m)) {
          throw y.m(this.b, "Missing either @%s URL or @Url parameter.", new Object[] { this.n });
        }
        boolean bool = this.p;
        if ((!bool) && (!this.q) && (!this.o) && (this.h)) {
          throw y.m(this.b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if ((bool) && (!this.f)) {
          throw y.m(this.b, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if ((this.q) && (!this.g)) {
          throw y.m(this.b, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        return new s(this);
      }
      throw y.m(this.b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.s
 * JD-Core Version:    0.7.0.1
 */