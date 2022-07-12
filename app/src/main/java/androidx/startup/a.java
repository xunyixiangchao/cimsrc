package androidx.startup;

import android.content.Context;
import java.lang.Class<+Lr1.a<*>;>;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static volatile a d;
  private static final Object e = new Object();
  final Map<Class<?>, Object> a;
  final Set<Class<? extends r1.a<?>>> b;
  final Context c;
  
  a(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.b = new HashSet();
    this.a = new HashMap();
  }
  
  public static a c(Context paramContext)
  {
    if (d == null) {
      synchronized (e)
      {
        if (d == null) {
          d = new a(paramContext);
        }
      }
    }
    return d;
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 59	s1/a:a	(Ljava/lang/String;)V
    //   5: new 61	android/content/ComponentName
    //   8: dup
    //   9: aload_0
    //   10: getfield 33	androidx/startup/a:c	Landroid/content/Context;
    //   13: invokevirtual 65	android/content/Context:getPackageName	()Ljava/lang/String;
    //   16: ldc 67
    //   18: invokevirtual 72	java/lang/Class:getName	()Ljava/lang/String;
    //   21: invokespecial 75	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 33	androidx/startup/a:c	Landroid/content/Context;
    //   29: invokevirtual 79	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   32: aload_1
    //   33: sipush 128
    //   36: invokevirtual 85	android/content/pm/PackageManager:getProviderInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ProviderInfo;
    //   39: getfield 91	android/content/pm/ProviderInfo:metaData	Landroid/os/Bundle;
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 33	androidx/startup/a:c	Landroid/content/Context;
    //   47: getstatic 97	androidx/startup/R$string:androidx_startup	I
    //   50: invokevirtual 101	android/content/Context:getString	(I)Ljava/lang/String;
    //   53: astore_2
    //   54: aload_1
    //   55: ifnull +98 -> 153
    //   58: new 35	java/util/HashSet
    //   61: dup
    //   62: invokespecial 36	java/util/HashSet:<init>	()V
    //   65: astore_3
    //   66: aload_1
    //   67: invokevirtual 107	android/os/Bundle:keySet	()Ljava/util/Set;
    //   70: invokeinterface 113 1 0
    //   75: astore 4
    //   77: aload 4
    //   79: invokeinterface 119 1 0
    //   84: ifeq +69 -> 153
    //   87: aload 4
    //   89: invokeinterface 123 1 0
    //   94: checkcast 125	java/lang/String
    //   97: astore 5
    //   99: aload_2
    //   100: aload_1
    //   101: aload 5
    //   103: aconst_null
    //   104: invokevirtual 128	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifeq -33 -> 77
    //   113: aload 5
    //   115: invokestatic 136	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   118: astore 5
    //   120: ldc 138
    //   122: aload 5
    //   124: invokevirtual 142	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   127: ifeq -50 -> 77
    //   130: aload_0
    //   131: getfield 38	androidx/startup/a:b	Ljava/util/Set;
    //   134: aload 5
    //   136: invokeinterface 145 2 0
    //   141: pop
    //   142: aload_0
    //   143: aload 5
    //   145: aload_3
    //   146: invokevirtual 148	androidx/startup/a:b	(Ljava/lang/Class;Ljava/util/Set;)Ljava/lang/Object;
    //   149: pop
    //   150: goto -73 -> 77
    //   153: invokestatic 150	s1/a:b	()V
    //   156: return
    //   157: astore_1
    //   158: goto +17 -> 175
    //   161: astore_1
    //   162: goto +4 -> 166
    //   165: astore_1
    //   166: new 152	r1/b
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 155	r1/b:<init>	(Ljava/lang/Throwable;)V
    //   174: athrow
    //   175: invokestatic 150	s1/a:b	()V
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	a
    //   24	77	1	localObject1	Object
    //   157	1	1	localObject2	Object
    //   161	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   165	14	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   53	47	2	str	String
    //   65	81	3	localHashSet	HashSet
    //   75	13	4	localIterator	Iterator
    //   97	47	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	54	157	finally
    //   58	77	157	finally
    //   77	150	157	finally
    //   166	175	157	finally
    //   0	54	161	java/lang/ClassNotFoundException
    //   58	77	161	java/lang/ClassNotFoundException
    //   77	150	161	java/lang/ClassNotFoundException
    //   0	54	165	android/content/pm/PackageManager$NameNotFoundException
    //   58	77	165	android/content/pm/PackageManager$NameNotFoundException
    //   77	150	165	android/content/pm/PackageManager$NameNotFoundException
  }
  
  <T> T b(Class<? extends r1.a<?>> paramClass, Set<Class<?>> paramSet)
  {
    synchronized (e)
    {
      boolean bool = s1.a.d();
      if (bool) {}
      try
      {
        s1.a.a(paramClass.getSimpleName());
        if (!paramSet.contains(paramClass))
        {
          if (!this.a.containsKey(paramClass))
          {
            paramSet.add(paramClass);
            try
            {
              Object localObject1 = (r1.a)paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
              Object localObject3 = ((r1.a)localObject1).a();
              if (!((List)localObject3).isEmpty())
              {
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  Class localClass = (Class)((Iterator)localObject3).next();
                  if (!this.a.containsKey(localClass)) {
                    b(localClass, paramSet);
                  }
                }
              }
              localObject1 = ((r1.a)localObject1).b(this.c);
              paramSet.remove(paramClass);
              this.a.put(paramClass, localObject1);
              paramClass = (Class<? extends r1.a<?>>)localObject1;
              break label210;
            }
            finally {}
          }
          else
          {
            paramClass = this.a.get(paramClass);
          }
          label210:
          s1.a.b();
          return paramClass;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[] { paramClass.getName() }));
      }
      finally
      {
        s1.a.b();
      }
    }
  }
  
  public <T> T d(Class<? extends r1.a<T>> paramClass)
  {
    return b(paramClass, new HashSet());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.startup.a
 * JD-Core Version:    0.7.0.1
 */