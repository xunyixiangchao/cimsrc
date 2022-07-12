package d4;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.z;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
  implements c
{
  private static b c = new b();
  private Pattern a;
  private List<EmoticonItem> b = new ArrayList();
  
  private b()
  {
    g();
    h();
  }
  
  private Pattern c()
  {
    if (this.b == null) {
      g();
    }
    if (this.a == null) {
      h();
    }
    return this.a;
  }
  
  public static b d()
  {
    return c;
  }
  
  private void g()
  {
    this.b.clear();
    Object localObject = new z(HoxinApplication.h(), null);
    Menu localMenu = ((z)localObject).a();
    ((z)localObject).b().inflate(2131492867, localMenu);
    int i = 0;
    while (i < localMenu.size())
    {
      localObject = localMenu.getItem(i);
      EmoticonItem localEmoticonItem = new EmoticonItem();
      localEmoticonItem.name = ((MenuItem)localObject).getTitle().toString();
      localEmoticonItem.image = ((MenuItem)localObject).getIcon();
      this.b.add(localEmoticonItem);
      i += 1;
    }
  }
  
  private void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(Pattern.quote(((EmoticonItem)localIterator.next()).name));
      localStringBuilder.append('|');
    }
    localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), ")");
    this.a = Pattern.compile(localStringBuilder.toString());
  }
  
  public int a(long paramLong)
  {
    return 6;
  }
  
  public List<EmoticonItem> b(long paramLong)
  {
    return this.b;
  }
  
  public Drawable e(String paramString)
  {
    EmoticonItem localEmoticonItem = new EmoticonItem();
    localEmoticonItem.name = paramString;
    return (Drawable)f(localEmoticonItem);
  }
  
  public Object f(EmoticonItem paramEmoticonItem)
  {
    Iterator localIterator = this.b.iterator();
    do
    {
      boolean bool = localIterator.hasNext();
      localObject = null;
      if (!bool) {
        break;
      }
      localObject = (EmoticonItem)localIterator.next();
    } while (!Objects.equals(paramEmoticonItem.name, ((EmoticonItem)localObject).name));
    paramEmoticonItem = (Drawable)((EmoticonItem)localObject).image;
    if (paramEmoticonItem.getConstantState() == null) {
      return null;
    }
    Object localObject = paramEmoticonItem.getConstantState().newDrawable().mutate();
    return localObject;
  }
  
  public Matcher i(CharSequence paramCharSequence)
  {
    return c().matcher(paramCharSequence);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d4.b
 * JD-Core Version:    0.7.0.1
 */