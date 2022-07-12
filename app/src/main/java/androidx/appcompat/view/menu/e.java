package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import s0.a;

public class e
  implements a
{
  private static final int[] A = { 1, 4, 5, 3, 2, 0 };
  private final Context a;
  private final Resources b;
  private boolean c;
  private boolean d;
  private a e;
  private ArrayList<g> f;
  private ArrayList<g> g;
  private boolean h;
  private ArrayList<g> i;
  private ArrayList<g> j;
  private boolean k;
  private int l = 0;
  private ContextMenu.ContextMenuInfo m;
  CharSequence n;
  Drawable o;
  View p;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private ArrayList<g> v = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<j>> w = new CopyOnWriteArrayList();
  private g x;
  private boolean y = false;
  private boolean z;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getResources();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = true;
    this.i = new ArrayList();
    this.j = new ArrayList();
    this.k = true;
    f0(true);
  }
  
  private static int D(int paramInt)
  {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if (i1 >= 0)
    {
      int[] arrayOfInt = A;
      if (i1 < arrayOfInt.length) {
        return paramInt & 0xFFFF | arrayOfInt[i1] << 16;
      }
    }
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  private void P(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.f.size()) {
        return;
      }
      this.f.remove(paramInt);
      if (paramBoolean) {
        M(true);
      }
    }
  }
  
  private void a0(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = E();
    if (paramView != null)
    {
      this.p = paramView;
      this.n = null;
      this.o = null;
    }
    else
    {
      if (paramInt1 > 0) {
        this.n = localResources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        this.n = paramCharSequence;
      }
      if (paramInt2 > 0) {
        this.o = androidx.core.content.b.d(w(), paramInt2);
      } else if (paramDrawable != null) {
        this.o = paramDrawable;
      }
      this.p = null;
    }
    M(false);
  }
  
  private void f0(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.b.getConfiguration().keyboard != 1) && (z.e(ViewConfiguration.get(this.a), this.a))) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    this.d = paramBoolean;
  }
  
  private g g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new g(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.w.isEmpty()) {
      return;
    }
    h0();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      j localj = (j)localWeakReference.get();
      if (localj == null) {
        this.w.remove(localWeakReference);
      } else {
        localj.g(paramBoolean);
      }
    }
    g0();
  }
  
  private void j(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if (paramBundle != null)
    {
      if (this.w.isEmpty()) {
        return;
      }
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        j localj = (j)((WeakReference)localObject).get();
        if (localj == null)
        {
          this.w.remove(localObject);
        }
        else
        {
          int i1 = localj.getId();
          if (i1 > 0)
          {
            localObject = (Parcelable)paramBundle.get(i1);
            if (localObject != null) {
              localj.e((Parcelable)localObject);
            }
          }
        }
      }
    }
  }
  
  private void k(Bundle paramBundle)
  {
    if (this.w.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      j localj = (j)((WeakReference)localObject).get();
      if (localj == null)
      {
        this.w.remove(localObject);
      }
      else
      {
        int i1 = localj.getId();
        if (i1 > 0)
        {
          localObject = localj.j();
          if (localObject != null) {
            localSparseArray.put(i1, localObject);
          }
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }
  
  private boolean l(m paramm, j paramj)
  {
    boolean bool2 = this.w.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramj != null) {
      bool1 = paramj.f(paramm);
    }
    paramj = this.w.iterator();
    while (paramj.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramj.next();
      j localj = (j)localWeakReference.get();
      if (localj == null) {
        this.w.remove(localWeakReference);
      } else if (!bool1) {
        bool1 = localj.f(paramm);
      }
    }
    return bool1;
  }
  
  private static int p(ArrayList<g> paramArrayList, int paramInt)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (((g)paramArrayList.get(i1)).f() <= paramInt) {
        return i1 + 1;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  public View A()
  {
    return this.p;
  }
  
  public ArrayList<g> B()
  {
    t();
    return this.j;
  }
  
  boolean C()
  {
    return this.t;
  }
  
  Resources E()
  {
    return this.b;
  }
  
  public e F()
  {
    return this;
  }
  
  public ArrayList<g> G()
  {
    if (!this.h) {
      return this.g;
    }
    this.g.clear();
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      g localg = (g)this.f.get(i1);
      if (localg.isVisible()) {
        this.g.add(localg);
      }
      i1 += 1;
    }
    this.h = false;
    this.k = true;
    return this.g;
  }
  
  public boolean H()
  {
    return this.y;
  }
  
  boolean I()
  {
    return this.c;
  }
  
  public boolean J()
  {
    return this.d;
  }
  
  void K(g paramg)
  {
    this.k = true;
    M(true);
  }
  
  void L(g paramg)
  {
    this.h = true;
    M(true);
  }
  
  public void M(boolean paramBoolean)
  {
    if (!this.q)
    {
      if (paramBoolean)
      {
        this.h = true;
        this.k = true;
      }
      i(paramBoolean);
      return;
    }
    this.r = true;
    if (paramBoolean) {
      this.s = true;
    }
  }
  
  public boolean N(MenuItem paramMenuItem, int paramInt)
  {
    return O(paramMenuItem, null, paramInt);
  }
  
  public boolean O(MenuItem paramMenuItem, j paramj, int paramInt)
  {
    Object localObject = (g)paramMenuItem;
    if (localObject != null)
    {
      if (!((g)localObject).isEnabled()) {
        return false;
      }
      boolean bool2 = ((g)localObject).k();
      paramMenuItem = ((g)localObject).b();
      int i1;
      if ((paramMenuItem != null) && (paramMenuItem.b())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      boolean bool1;
      if (((g)localObject).j())
      {
        bool2 |= ((g)localObject).expandActionView();
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      else
      {
        for (;;)
        {
          e(true);
          return bool1;
          if ((!((g)localObject).hasSubMenu()) && (i1 == 0))
          {
            bool1 = bool2;
            if ((paramInt & 0x1) != 0) {
              break;
            }
            bool1 = bool2;
          }
          else
          {
            if ((paramInt & 0x4) == 0) {
              e(false);
            }
            if (!((g)localObject).hasSubMenu()) {
              ((g)localObject).x(new m(w(), this, (g)localObject));
            }
            localObject = (m)((g)localObject).getSubMenu();
            if (i1 != 0) {
              paramMenuItem.g((SubMenu)localObject);
            }
            bool2 |= l((m)localObject, paramj);
            bool1 = bool2;
            if (bool2) {
              break;
            }
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    return false;
  }
  
  public void Q(j paramj)
  {
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      j localj = (j)localWeakReference.get();
      if ((localj == null) || (localj == paramj)) {
        this.w.remove(localWeakReference);
      }
    }
  }
  
  public void R(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(v());
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1)) {
        localView.restoreHierarchyState(localSparseArray);
      }
      if (localMenuItem.hasSubMenu()) {
        ((m)localMenuItem.getSubMenu()).R(paramBundle);
      }
      i1 += 1;
    }
    i1 = paramBundle.getInt("android:menu:expandedactionview");
    if (i1 > 0)
    {
      paramBundle = findItem(i1);
      if (paramBundle != null) {
        paramBundle.expandActionView();
      }
    }
  }
  
  public void S(Bundle paramBundle)
  {
    j(paramBundle);
  }
  
  public void T(Bundle paramBundle)
  {
    int i2 = size();
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = localMenuItem.getActionView();
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (localMenuItem.isActionViewExpanded())
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((m)localMenuItem.getSubMenu()).T(paramBundle);
      }
      i1 += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(v(), localObject1);
    }
  }
  
  public void U(Bundle paramBundle)
  {
    k(paramBundle);
  }
  
  public void V(a parama)
  {
    this.e = parama;
  }
  
  public e W(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  void X(MenuItem paramMenuItem)
  {
    int i2 = paramMenuItem.getGroupId();
    int i3 = this.f.size();
    h0();
    int i1 = 0;
    while (i1 < i3)
    {
      g localg = (g)this.f.get(i1);
      if ((localg.getGroupId() == i2) && (localg.m()) && (localg.isCheckable()))
      {
        boolean bool;
        if (localg == paramMenuItem) {
          bool = true;
        } else {
          bool = false;
        }
        localg.s(bool);
      }
      i1 += 1;
    }
    g0();
  }
  
  protected e Y(int paramInt)
  {
    a0(0, null, paramInt, null, null);
    return this;
  }
  
  protected e Z(Drawable paramDrawable)
  {
    a0(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = D(paramInt3);
    paramCharSequence = g(paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.l);
    Object localObject = this.m;
    if (localObject != null) {
      paramCharSequence.v((ContextMenu.ContextMenuInfo)localObject);
    }
    localObject = this.f;
    ((ArrayList)localObject).add(p((ArrayList)localObject, i1), paramCharSequence);
    M(true);
    return paramCharSequence;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.b.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.b.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.a.getPackageManager();
    int i3 = 0;
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    if (localList != null) {
      i1 = localList.size();
    } else {
      i1 = 0;
    }
    int i2 = i3;
    if ((paramInt4 & 0x1) == 0)
    {
      removeGroup(paramInt1);
      i2 = i3;
    }
    while (i2 < i1)
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i2);
      paramInt4 = localResolveInfo.specificIndex;
      if (paramInt4 < 0) {
        paramComponentName = paramIntent;
      } else {
        paramComponentName = paramArrayOfIntent[paramInt4];
      }
      paramComponentName = new Intent(paramComponentName);
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      paramComponentName.setComponent(new ComponentName(localActivityInfo.applicationInfo.packageName, localActivityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if (paramArrayOfMenuItem != null)
      {
        paramInt4 = localResolveInfo.specificIndex;
        if (paramInt4 >= 0) {
          paramArrayOfMenuItem[paramInt4] = paramComponentName;
        }
      }
      i2 += 1;
    }
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.b.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.b.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (g)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    m localm = new m(this.a, this, paramCharSequence);
    paramCharSequence.x(localm);
    return localm;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public void b(j paramj)
  {
    c(paramj, this.a);
  }
  
  protected e b0(int paramInt)
  {
    a0(paramInt, null, 0, null, null);
    return this;
  }
  
  public void c(j paramj, Context paramContext)
  {
    this.w.add(new WeakReference(paramj));
    paramj.d(paramContext, this);
    this.k = true;
  }
  
  protected e c0(CharSequence paramCharSequence)
  {
    a0(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  public void clear()
  {
    g localg = this.x;
    if (localg != null) {
      f(localg);
    }
    this.f.clear();
    M(true);
  }
  
  public void clearHeader()
  {
    this.o = null;
    this.n = null;
    this.p = null;
    M(false);
  }
  
  public void close()
  {
    e(true);
  }
  
  public void d()
  {
    a locala = this.e;
    if (locala != null) {
      locala.b(this);
    }
  }
  
  protected e d0(View paramView)
  {
    a0(0, null, 0, null, paramView);
    return this;
  }
  
  public final void e(boolean paramBoolean)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      j localj = (j)localWeakReference.get();
      if (localj == null) {
        this.w.remove(localWeakReference);
      } else {
        localj.b(this, paramBoolean);
      }
    }
    this.u = false;
  }
  
  public void e0(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public boolean f(g paramg)
  {
    boolean bool3 = this.w.isEmpty();
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bool3)
    {
      if (this.x != paramg) {
        return false;
      }
      h0();
      Iterator localIterator = this.w.iterator();
      bool1 = bool2;
      do
      {
        j localj;
        for (;;)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break label111;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localj = (j)localWeakReference.get();
          if (localj != null) {
            break;
          }
          this.w.remove(localWeakReference);
        }
        bool2 = localj.k(this, paramg);
        bool1 = bool2;
      } while (!bool2);
      label111:
      g0();
      bool1 = bool2;
      if (bool2)
      {
        this.x = null;
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (g)this.f.get(i1);
      if (((g)localObject).getItemId() == paramInt) {
        return localObject;
      }
      if (((g)localObject).hasSubMenu())
      {
        localObject = ((g)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null) {
          return localObject;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public void g0()
  {
    this.q = false;
    if (this.r)
    {
      this.r = false;
      M(this.s);
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.f.get(paramInt);
  }
  
  boolean h(e parame, MenuItem paramMenuItem)
  {
    a locala = this.e;
    return (locala != null) && (locala.a(parame, paramMenuItem));
  }
  
  public void h0()
  {
    if (!this.q)
    {
      this.q = true;
      this.r = false;
      this.s = false;
    }
  }
  
  public boolean hasVisibleItems()
  {
    if (this.z) {
      return true;
    }
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((g)this.f.get(i1)).isVisible()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return r(paramInt, paramKeyEvent) != null;
  }
  
  public boolean m(g paramg)
  {
    boolean bool2 = this.w.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    h0();
    Iterator localIterator = this.w.iterator();
    do
    {
      j localj;
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break label97;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        localj = (j)localWeakReference.get();
        if (localj != null) {
          break;
        }
        this.w.remove(localWeakReference);
      }
      bool2 = localj.l(this, paramg);
      bool1 = bool2;
    } while (!bool2);
    label97:
    g0();
    if (bool2) {
      this.x = paramg;
    }
    return bool2;
  }
  
  public int n(int paramInt)
  {
    return o(paramInt, 0);
  }
  
  public int o(int paramInt1, int paramInt2)
  {
    int i2 = size();
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    while (i1 < i2)
    {
      if (((g)this.f.get(i1)).getGroupId() == paramInt1) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return N(findItem(paramInt1), paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = r(paramInt1, paramKeyEvent);
    boolean bool;
    if (paramKeyEvent != null) {
      bool = N(paramKeyEvent, paramInt2);
    } else {
      bool = false;
    }
    if ((paramInt2 & 0x2) != 0) {
      e(true);
    }
    return bool;
  }
  
  public int q(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((g)this.f.get(i1)).getItemId() == paramInt) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  g r(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.v;
    localArrayList.clear();
    s(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty()) {
      return null;
    }
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i4 = localArrayList.size();
    if (i4 == 1) {
      return (g)localArrayList.get(0);
    }
    boolean bool = I();
    int i1 = 0;
    while (i1 < i4)
    {
      paramKeyEvent = (g)localArrayList.get(i1);
      int i2;
      if (bool) {
        i2 = paramKeyEvent.getAlphabeticShortcut();
      } else {
        i2 = paramKeyEvent.getNumericShortcut();
      }
      char[] arrayOfChar = localKeyData.meta;
      if (((i2 == arrayOfChar[0]) && ((i3 & 0x2) == 0)) || ((i2 == arrayOfChar[2]) && ((i3 & 0x2) != 0)) || ((bool) && (i2 == 8) && (paramInt == 67))) {
        return paramKeyEvent;
      }
      i1 += 1;
    }
    return null;
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = n(paramInt);
    if (i2 >= 0)
    {
      int i3 = this.f.size();
      int i1 = 0;
      while ((i1 < i3 - i2) && (((g)this.f.get(i2)).getGroupId() == paramInt))
      {
        P(i2, false);
        i1 += 1;
      }
      M(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    P(q(paramInt), true);
  }
  
  void s(List<g> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = I();
    int i4 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i5 = this.f.size();
    int i1 = 0;
    while (i1 < i5)
    {
      g localg = (g)this.f.get(i1);
      if (localg.hasSubMenu()) {
        ((e)localg.getSubMenu()).s(paramList, paramInt, paramKeyEvent);
      }
      int i2;
      if (bool) {
        i2 = localg.getAlphabeticShortcut();
      } else {
        i2 = localg.getNumericShortcut();
      }
      int i3;
      if (bool) {
        i3 = localg.getAlphabeticModifiers();
      } else {
        i3 = localg.getNumericModifiers();
      }
      if ((i4 & 0x1100F) == (i3 & 0x1100F)) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if ((i3 != 0) && (i2 != 0))
      {
        char[] arrayOfChar = localKeyData.meta;
        if (((i2 == arrayOfChar[0]) || (i2 == arrayOfChar[2]) || ((bool) && (i2 == 8) && (paramInt == 67))) && (localg.isEnabled())) {
          paramList.add(localg);
        }
      }
      i1 += 1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      g localg = (g)this.f.get(i1);
      if (localg.getGroupId() == paramInt)
      {
        localg.t(paramBoolean2);
        localg.setCheckable(paramBoolean1);
      }
      i1 += 1;
    }
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      g localg = (g)this.f.get(i1);
      if (localg.getGroupId() == paramInt) {
        localg.setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i4 = this.f.size();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      g localg = (g)this.f.get(i1);
      i3 = i2;
      if (localg.getGroupId() == paramInt)
      {
        i3 = i2;
        if (localg.y(paramBoolean)) {
          i3 = 1;
        }
      }
      i1 += 1;
    }
    if (i2 != 0) {
      M(true);
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.c = paramBoolean;
    M(false);
  }
  
  public int size()
  {
    return this.f.size();
  }
  
  public void t()
  {
    ArrayList localArrayList = G();
    if (!this.k) {
      return;
    }
    Object localObject1 = this.w.iterator();
    int i1 = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      j localj = (j)((WeakReference)localObject2).get();
      if (localj == null) {
        this.w.remove(localObject2);
      } else {
        i1 |= localj.i();
      }
    }
    if (i1 != 0)
    {
      this.i.clear();
      this.j.clear();
      int i3 = localArrayList.size();
      i1 = 0;
      while (i1 < i3)
      {
        localObject2 = (g)localArrayList.get(i1);
        if (((g)localObject2).l()) {
          localObject1 = this.i;
        } else {
          localObject1 = this.j;
        }
        ((ArrayList)localObject1).add(localObject2);
        int i2;
        i1 += 1;
      }
    }
    this.i.clear();
    this.j.clear();
    this.j.addAll(G());
    this.k = false;
  }
  
  public ArrayList<g> u()
  {
    t();
    return this.i;
  }
  
  protected String v()
  {
    return "android:menu:actionviewstates";
  }
  
  public Context w()
  {
    return this.a;
  }
  
  public g x()
  {
    return this.x;
  }
  
  public Drawable y()
  {
    return this.o;
  }
  
  public CharSequence z()
  {
    return this.n;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(e parame, MenuItem paramMenuItem);
    
    public abstract void b(e parame);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(g paramg);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.e
 * JD-Core Version:    0.7.0.1
 */