package d2;

import android.util.Log;
import b2.a;
import b2.f;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class q
  extends Exception
{
  private static final StackTraceElement[] g = new StackTraceElement[0];
  private final List<Throwable> a;
  private f b;
  private a c;
  private Class<?> d;
  private String e;
  private Exception f;
  
  public q(String paramString)
  {
    this(paramString, Collections.emptyList());
  }
  
  public q(String paramString, Throwable paramThrowable)
  {
    this(paramString, Collections.singletonList(paramThrowable));
  }
  
  public q(String paramString, List<Throwable> paramList)
  {
    this.e = paramString;
    setStackTrace(g);
    this.a = paramList;
  }
  
  private void a(Throwable paramThrowable, List<Throwable> paramList)
  {
    if ((paramThrowable instanceof q))
    {
      paramThrowable = ((q)paramThrowable).e().iterator();
      while (paramThrowable.hasNext()) {
        a((Throwable)paramThrowable.next(), paramList);
      }
    }
    paramList.add(paramThrowable);
  }
  
  private static void b(List<Throwable> paramList, Appendable paramAppendable)
  {
    try
    {
      c(paramList, paramAppendable);
      return;
    }
    catch (IOException paramList)
    {
      throw new RuntimeException(paramList);
    }
  }
  
  private static void c(List<Throwable> paramList, Appendable paramAppendable)
  {
    int k = paramList.size();
    int j;
    for (int i = 0; i < k; i = j)
    {
      Object localObject = paramAppendable.append("Cause (");
      j = i + 1;
      ((Appendable)localObject).append(String.valueOf(j)).append(" of ").append(String.valueOf(k)).append("): ");
      localObject = (Throwable)paramList.get(i);
      if ((localObject instanceof q)) {
        ((q)localObject).h(paramAppendable);
      } else {
        d((Throwable)localObject, paramAppendable);
      }
    }
  }
  
  private static void d(Throwable paramThrowable, Appendable paramAppendable)
  {
    try
    {
      paramAppendable.append(paramThrowable.getClass().toString()).append(": ").append(paramThrowable.getMessage()).append('\n');
      return;
    }
    catch (IOException paramAppendable)
    {
      label38:
      break label38;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  private void h(Appendable paramAppendable)
  {
    d(this, paramAppendable);
    b(e(), new a(paramAppendable));
  }
  
  public List<Throwable> e()
  {
    return this.a;
  }
  
  public List<Throwable> f()
  {
    ArrayList localArrayList = new ArrayList();
    a(this, localArrayList);
    return localArrayList;
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
  
  public void g(String paramString)
  {
    List localList = f();
    int k = localList.size();
    int j;
    for (int i = 0; i < k; i = j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Root cause (");
      j = i + 1;
      localStringBuilder.append(j);
      localStringBuilder.append(" of ");
      localStringBuilder.append(k);
      localStringBuilder.append(")");
      Log.i(paramString, localStringBuilder.toString(), (Throwable)localList.get(i));
    }
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder(71);
    localStringBuilder.append(this.e);
    Object localObject1 = this.d;
    Object localObject2 = "";
    if (localObject1 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.d);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    if (this.c != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.c);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localObject2;
    if (this.b != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.b);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localStringBuilder.append((String)localObject1);
    localObject2 = f();
    if (((List)localObject2).isEmpty()) {
      return localStringBuilder.toString();
    }
    if (((List)localObject2).size() == 1)
    {
      localObject1 = "\nThere was 1 root cause:";
    }
    else
    {
      localStringBuilder.append("\nThere were ");
      localStringBuilder.append(((List)localObject2).size());
      localObject1 = " root causes:";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Throwable)((Iterator)localObject1).next();
      localStringBuilder.append('\n');
      localStringBuilder.append(localObject2.getClass().getName());
      localStringBuilder.append('(');
      localStringBuilder.append(((Throwable)localObject2).getMessage());
      localStringBuilder.append(')');
    }
    localStringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
    return localStringBuilder.toString();
  }
  
  void i(f paramf, a parama)
  {
    j(paramf, parama, null);
  }
  
  void j(f paramf, a parama, Class<?> paramClass)
  {
    this.b = paramf;
    this.c = parama;
    this.d = paramClass;
  }
  
  public void k(Exception paramException)
  {
    this.f = paramException;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    h(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    h(paramPrintWriter);
  }
  
  private static final class a
    implements Appendable
  {
    private final Appendable a;
    private boolean b = true;
    
    a(Appendable paramAppendable)
    {
      this.a = paramAppendable;
    }
    
    private CharSequence a(CharSequence paramCharSequence)
    {
      Object localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      return localObject;
    }
    
    public Appendable append(char paramChar)
    {
      boolean bool2 = this.b;
      boolean bool1 = false;
      if (bool2)
      {
        this.b = false;
        this.a.append("  ");
      }
      if (paramChar == '\n') {
        bool1 = true;
      }
      this.b = bool1;
      this.a.append(paramChar);
      return this;
    }
    
    public Appendable append(CharSequence paramCharSequence)
    {
      paramCharSequence = a(paramCharSequence);
      return append(paramCharSequence, 0, paramCharSequence.length());
    }
    
    public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      paramCharSequence = a(paramCharSequence);
      boolean bool1 = this.b;
      boolean bool2 = false;
      if (bool1)
      {
        this.b = false;
        this.a.append("  ");
      }
      bool1 = bool2;
      if (paramCharSequence.length() > 0)
      {
        bool1 = bool2;
        if (paramCharSequence.charAt(paramInt2 - 1) == '\n') {
          bool1 = true;
        }
      }
      this.b = bool1;
      this.a.append(paramCharSequence, paramInt1, paramInt2);
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.q
 * JD-Core Version:    0.7.0.1
 */