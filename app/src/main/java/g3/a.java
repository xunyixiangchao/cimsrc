package g3;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.widget.z;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.model.Region;
import g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
{
  private static a c = new a();
  private List<Region> a = new ArrayList();
  private g0.a<String, Country> b = new g0.a();
  
  private a()
  {
    Object localObject = new z(HoxinApplication.h(), null);
    Menu localMenu = ((z)localObject).a();
    ((z)localObject).b().inflate(2131492866, localMenu);
    int i = 0;
    while (i < localMenu.size())
    {
      localObject = localMenu.getItem(i);
      Region localRegion = new Region();
      localRegion.name = ((MenuItem)localObject).getTitle().toString();
      localRegion.countryList = new LinkedList();
      int j = 0;
      while (j < ((MenuItem)localObject).getSubMenu().size())
      {
        MenuItem localMenuItem = ((MenuItem)localObject).getSubMenu().getItem(j);
        String[] arrayOfString = localMenuItem.getTitleCondensed().toString().split("_");
        Country localCountry = new Country();
        localCountry.id = arrayOfString[0];
        localCountry.code = arrayOfString[1];
        localCountry.name = localMenuItem.getTitle().toString();
        localCountry.icon = Country.getIcon(localCountry.id);
        localRegion.countryList.add(localCountry);
        this.b.put(localCountry.code, localCountry);
        j += 1;
      }
      this.a.add(localRegion);
      i += 1;
    }
  }
  
  public static a a()
  {
    return c;
  }
  
  public List<Region> b()
  {
    return this.a;
  }
  
  public Country c(String paramString)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.startsWith(str)) {
        return (Country)this.b.get(str);
      }
    }
    return Country.NORMAL;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g3.a
 * JD-Core Version:    0.7.0.1
 */