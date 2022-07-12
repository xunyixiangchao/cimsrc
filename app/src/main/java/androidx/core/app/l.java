package androidx.core.app;

import android.app.Person;
import android.app.Person.Builder;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;

public class l
{
  CharSequence a;
  IconCompat b;
  String c;
  String d;
  boolean e;
  boolean f;
  
  public IconCompat a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public CharSequence c()
  {
    return this.a;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String g()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    if (this.a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("name:");
      ((StringBuilder)localObject).append(this.a);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public Person h()
  {
    Person.Builder localBuilder = new Person.Builder().setName(c());
    Icon localIcon;
    if (a() != null) {
      localIcon = a().l();
    } else {
      localIcon = null;
    }
    return localBuilder.setIcon(localIcon).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.l
 * JD-Core Version:    0.7.0.1
 */