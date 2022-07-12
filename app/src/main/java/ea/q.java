package ea;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class q
{
  private static final q c = ;
  private final boolean a;
  @Nullable
  private final Constructor<MethodHandles.Lookup> b;
  
  q(boolean paramBoolean)
  {
    this.a = paramBoolean;
    Constructor localConstructor2 = null;
    Constructor localConstructor1 = null;
    if (paramBoolean) {
      localConstructor1 = localConstructor2;
    }
    try
    {
      localConstructor2 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, Integer.TYPE });
      localConstructor1 = localConstructor2;
      localConstructor2.setAccessible(true);
      localConstructor1 = localConstructor2;
    }
    catch (NoClassDefFoundError|NoSuchMethodException localNoClassDefFoundError)
    {
      label49:
      break label49;
    }
    this.b = localConstructor1;
  }
  
  private static q e()
  {
    if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
      return new a();
    }
    return new q(true);
  }
  
  static q f()
  {
    return c;
  }
  
  List<? extends c.a> a(@Nullable Executor paramExecutor)
  {
    paramExecutor = new g(paramExecutor);
    if (this.a) {
      return Arrays.asList(new c.a[] { e.a, paramExecutor });
    }
    return Collections.singletonList(paramExecutor);
  }
  
  @Nullable
  Executor b()
  {
    return null;
  }
  
  List<? extends f.a> c()
  {
    if (this.a) {
      return Collections.singletonList(o.a);
    }
    return Collections.emptyList();
  }
  
  int d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Nullable
  @IgnoreJRERequirement
  Object g(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = (MethodHandles.Lookup)((Constructor)localObject).newInstance(new Object[] { paramClass, Integer.valueOf(-1) });
    } else {
      localObject = MethodHandles.lookup();
    }
    return ((MethodHandles.Lookup)localObject).unreflectSpecial(paramMethod, paramClass).bindTo(paramObject).invokeWithArguments(paramVarArgs);
  }
  
  @IgnoreJRERequirement
  boolean h(Method paramMethod)
  {
    return (this.a) && (paramMethod.isDefault());
  }
  
  static final class a
    extends q
  {
    a()
    {
      super();
    }
    
    public Executor b()
    {
      return new a();
    }
    
    @Nullable
    Object g(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return super.g(paramMethod, paramClass, paramObject, paramVarArgs);
      }
      throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
    }
    
    static final class a
      implements Executor
    {
      private final Handler a = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable paramRunnable)
      {
        this.a.post(paramRunnable);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.q
 * JD-Core Version:    0.7.0.1
 */