package androidx.room;

import java.util.concurrent.Executor;
import p1.g;
import p1.h;

final class y
  implements h, i
{
  private final h a;
  private final f0.f b;
  private final Executor c;
  
  y(h paramh, f0.f paramf, Executor paramExecutor)
  {
    this.a = paramh;
    this.b = paramf;
    this.c = paramExecutor;
  }
  
  public g X()
  {
    return new x(this.a.X(), this.b, this.c);
  }
  
  public h a()
  {
    return this.a;
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String getDatabaseName()
  {
    return this.a.getDatabaseName();
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    this.a.setWriteAheadLoggingEnabled(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.y
 * JD-Core Version:    0.7.0.1
 */