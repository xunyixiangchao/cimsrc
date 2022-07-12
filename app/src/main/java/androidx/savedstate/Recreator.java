package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
final class Recreator
  implements j
{
  private final b a;
  
  Recreator(b paramb)
  {
    this.a = paramb;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: ldc 2
    //   4: invokevirtual 34	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: invokestatic 38	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   10: ldc 40
    //   12: invokevirtual 44	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_0
    //   18: anewarray 30	java/lang/Class
    //   21: invokevirtual 48	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   24: astore_3
    //   25: aload_3
    //   26: iconst_1
    //   27: invokevirtual 54	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   30: aload_3
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokevirtual 58	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 40	androidx/savedstate/SavedStateRegistry$a
    //   41: astore_2
    //   42: aload_2
    //   43: aload_0
    //   44: getfield 20	androidx/savedstate/Recreator:a	Landroidx/savedstate/b;
    //   47: invokeinterface 60 2 0
    //   52: return
    //   53: astore_2
    //   54: new 62	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: ldc 65
    //   65: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: new 71	java/lang/RuntimeException
    //   78: dup
    //   79: aload_3
    //   80: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokespecial 78	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: astore_1
    //   89: new 62	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   96: astore_3
    //   97: aload_3
    //   98: ldc 80
    //   100: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: aload_2
    //   106: invokevirtual 83	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: ldc 85
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 87	java/lang/IllegalStateException
    //   123: dup
    //   124: aload_3
    //   125: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_1
    //   129: invokespecial 88	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: athrow
    //   133: astore_2
    //   134: new 62	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   141: astore_3
    //   142: aload_3
    //   143: ldc 90
    //   145: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_3
    //   150: aload_1
    //   151: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: ldc 92
    //   158: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: new 71	java/lang/RuntimeException
    //   165: dup
    //   166: aload_3
    //   167: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_2
    //   171: invokespecial 78	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	Recreator
    //   0	175	1	paramString	String
    //   15	28	2	localObject1	Object
    //   53	53	2	localException	java.lang.Exception
    //   133	38	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   24	143	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	42	53	java/lang/Exception
    //   16	25	88	java/lang/NoSuchMethodException
    //   0	16	133	java/lang/ClassNotFoundException
  }
  
  public void d(l paraml, h.b paramb)
  {
    if (paramb == h.b.ON_CREATE)
    {
      paraml.getLifecycle().c(this);
      paraml = this.a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
      if (paraml == null) {
        return;
      }
      paraml = paraml.getStringArrayList("classes_to_restore");
      if (paraml != null)
      {
        paraml = paraml.iterator();
        while (paraml.hasNext()) {
          a((String)paraml.next());
        }
        return;
      }
      throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    }
    throw new AssertionError("Next event must be ON_CREATE");
  }
  
  static final class a
    implements SavedStateRegistry.b
  {
    final Set<String> a = new HashSet();
    
    a(SavedStateRegistry paramSavedStateRegistry)
    {
      paramSavedStateRegistry.d("androidx.savedstate.Restarter", this);
    }
    
    public Bundle a()
    {
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("classes_to_restore", new ArrayList(this.a));
      return localBundle;
    }
    
    void b(String paramString)
    {
      this.a.add(paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.savedstate.Recreator
 * JD-Core Version:    0.7.0.1
 */