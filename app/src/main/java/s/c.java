package s;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

final class c
  extends k0
{
  private final Executor a;
  private final Handler b;
  
  c(Executor paramExecutor, Handler paramHandler)
  {
    Objects.requireNonNull(paramExecutor, "Null cameraExecutor");
    this.a = paramExecutor;
    Objects.requireNonNull(paramHandler, "Null schedulerHandler");
    this.b = paramHandler;
  }
  
  public Executor b()
  {
    return this.a;
  }
  
  public Handler c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof k0))
    {
      paramObject = (k0)paramObject;
      return (this.a.equals(paramObject.b())) && (this.b.equals(paramObject.c()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraThreadConfig{cameraExecutor=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", schedulerHandler=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.c
 * JD-Core Version:    0.7.0.1
 */