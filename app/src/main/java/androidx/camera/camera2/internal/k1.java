package androidx.camera.camera2.internal;

import androidx.camera.core.n1;
import androidx.camera.core.u;
import androidx.camera.core.u.a;
import androidx.camera.core.u.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import java.util.Objects;
import s.g0.a;
import s.j0;

class k1
{
  private final j0 a;
  private final r<u> b;
  
  k1(j0 paramj0)
  {
    this.a = paramj0;
    paramj0 = new r();
    this.b = paramj0;
    paramj0.m(u.a(u.b.e));
  }
  
  private u b()
  {
    u.b localb;
    if (this.a.a()) {
      localb = u.b.b;
    } else {
      localb = u.b.a;
    }
    return u.a(localb);
  }
  
  public LiveData<u> a()
  {
    return this.b;
  }
  
  public void c(g0.a parama, u.a parama1)
  {
    switch (a.a[parama.ordinal()])
    {
    default: 
      parama1 = new StringBuilder();
      parama1.append("Unknown internal camera state: ");
      parama1.append(parama);
      throw new IllegalStateException(parama1.toString());
    case 6: 
    case 7: 
      localObject = u.b.e;
      break;
    case 4: 
    case 5: 
      localObject = u.b.d;
      break;
    case 3: 
      localObject = u.b.c;
      break;
    case 2: 
      localObject = u.b.b;
      localObject = u.b((u.b)localObject, parama1);
      break;
    }
    Object localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("New public camera state ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(" from ");
    localStringBuilder.append(parama);
    localStringBuilder.append(" and ");
    localStringBuilder.append(parama1);
    n1.a("CameraStateMachine", localStringBuilder.toString());
    if (!Objects.equals((u)this.b.f(), localObject))
    {
      parama = new StringBuilder();
      parama.append("Publishing new public camera state ");
      parama.append(localObject);
      n1.a("CameraStateMachine", parama.toString());
      this.b.m(localObject);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.k1
 * JD-Core Version:    0.7.0.1
 */