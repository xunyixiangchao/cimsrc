package v7;

import b8.c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class l
{
  public i a()
  {
    if (d()) {
      return (i)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Array: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public o b()
  {
    if (f()) {
      return (o)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Object: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public q c()
  {
    if (g()) {
      return (q)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Primitive: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean d()
  {
    return this instanceof i;
  }
  
  public boolean e()
  {
    return this instanceof n;
  }
  
  public boolean f()
  {
    return this instanceof o;
  }
  
  public boolean g()
  {
    return this instanceof q;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      c localc = new c((Writer)localObject);
      localc.r0(true);
      x7.l.b(this, localc);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.l
 * JD-Core Version:    0.7.0.1
 */