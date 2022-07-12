package k1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class a
{
  private static final Object f = new Object();
  private static a g;
  private final Context a;
  private final HashMap<BroadcastReceiver, ArrayList<c>> b = new HashMap();
  private final HashMap<String, ArrayList<c>> c = new HashMap();
  private final ArrayList<b> d = new ArrayList();
  private final Handler e;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
    this.e = new a(paramContext.getMainLooper());
  }
  
  public static a b(Context paramContext)
  {
    synchronized (f)
    {
      if (g == null) {
        g = new a(paramContext.getApplicationContext());
      }
      paramContext = g;
      return paramContext;
    }
  }
  
  void a()
  {
    synchronized (this.b)
    {
      int k;
      b[] arrayOfb;
      int i;
      do
      {
        k = this.d.size();
        if (k <= 0) {
          return;
        }
        arrayOfb = new b[k];
        this.d.toArray(arrayOfb);
        this.d.clear();
        i = 0;
      } while (i >= k);
      ??? = arrayOfb[i];
      int m = ???.b.size();
      int j = 0;
      while (j < m)
      {
        c localc = (c)???.b.get(j);
        if (!localc.d) {
          localc.b.onReceive(this.a, ???.a);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public void c(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.b)
    {
      c localc = new c(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.b.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.b.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localc);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.c.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.c.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localc);
        i += 1;
      }
      return;
    }
  }
  
  public boolean d(Intent paramIntent)
  {
    for (;;)
    {
      Object localObject1;
      int k;
      synchronized (this.b)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.a.getContentResolver());
        Uri localUri = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((paramIntent.getFlags() & 0x8) != 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Resolving type ");
            ((StringBuilder)localObject1).append(str2);
            ((StringBuilder)localObject1).append(" scheme ");
            ((StringBuilder)localObject1).append(str3);
            ((StringBuilder)localObject1).append(" of intent ");
            ((StringBuilder)localObject1).append(paramIntent);
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
          }
          ArrayList localArrayList = (ArrayList)this.c.get(paramIntent.getAction());
          if (localArrayList != null)
          {
            if (i == 0) {
              break label521;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Action list: ");
            ((StringBuilder)localObject1).append(localArrayList);
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
            break label521;
            if (j >= localArrayList.size()) {
              break label612;
            }
            Object localObject3 = (c)localArrayList.get(j);
            if (i != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Matching against filter ");
              ((StringBuilder)localObject1).append(((c)localObject3).a);
              Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
            }
            if (((c)localObject3).c)
            {
              if (i == 0) {
                break label529;
              }
              Log.v("LocalBroadcastManager", "  Filter's target already added");
              break label529;
            }
            IntentFilter localIntentFilter = ((c)localObject3).a;
            localObject1 = localObject2;
            k = localIntentFilter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
            if (k < 0) {
              break label539;
            }
            if (i != 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("  Filter matched!  match=0x");
              ((StringBuilder)localObject2).append(Integer.toHexString(k));
              Log.v("LocalBroadcastManager", ((StringBuilder)localObject2).toString());
            }
            if (localObject1 != null) {
              break label532;
            }
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject3);
            ((c)localObject3).c = true;
            break label605;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("  Filter did not match: ");
            ((StringBuilder)localObject3).append((String)localObject1);
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject3).toString());
            break label605;
            if (i < ((ArrayList)localObject2).size())
            {
              ((c)((ArrayList)localObject2).get(i)).c = false;
              i += 1;
              continue;
            }
            this.d.add(new b(paramIntent, (ArrayList)localObject2));
            if (!this.e.hasMessages(1)) {
              this.e.sendEmptyMessage(1);
            }
            return true;
          }
          return false;
        }
      }
      int i = 0;
      continue;
      label521:
      Object localObject2 = null;
      int j = 0;
      continue;
      label529:
      break label605;
      label532:
      localObject2 = localObject1;
      continue;
      label539:
      if (i != 0)
      {
        if (k != -4)
        {
          if (k != -3)
          {
            if (k != -2)
            {
              if (k != -1) {
                localObject1 = "unknown reason";
              } else {
                localObject1 = "type";
              }
            }
            else {
              localObject1 = "data";
            }
          }
          else {
            localObject1 = "action";
          }
        }
        else {
          localObject1 = "category";
        }
      }
      else
      {
        label605:
        j += 1;
        continue;
        label612:
        if (localObject2 != null) {
          i = 0;
        }
      }
    }
  }
  
  public void e(BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.b)
      {
        ArrayList localArrayList1 = (ArrayList)this.b.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          c localc1 = (c)localArrayList1.get(i);
          localc1.d = true;
          j = 0;
          if (j >= localc1.a.countActions()) {
            break label203;
          }
          String str = localc1.a.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.c.get(str);
          if (localArrayList2 == null) {
            break label196;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            c localc2 = (c)localArrayList2.get(k);
            if (localc2.b == paramBroadcastReceiver)
            {
              localc2.d = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label196;
            }
            this.c.remove(str);
            break label196;
          }
        }
        else
        {
          return;
        }
      }
      k -= 1;
      continue;
      label196:
      j += 1;
      continue;
      label203:
      i -= 1;
    }
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1)
      {
        super.handleMessage(paramMessage);
        return;
      }
      a.this.a();
    }
  }
  
  private static final class b
  {
    final Intent a;
    final ArrayList<a.c> b;
    
    b(Intent paramIntent, ArrayList<a.c> paramArrayList)
    {
      this.a = paramIntent;
      this.b = paramArrayList;
    }
  }
  
  private static final class c
  {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;
    boolean d;
    
    c(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.a = paramIntentFilter;
      this.b = paramBroadcastReceiver;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("Receiver{");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" filter=");
      localStringBuilder.append(this.a);
      if (this.d) {
        localStringBuilder.append(" DEAD");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k1.a
 * JD-Core Version:    0.7.0.1
 */