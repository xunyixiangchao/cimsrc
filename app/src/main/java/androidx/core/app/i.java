package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import g0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import u0.a;

class i
{
  private final Context a;
  private final Notification.Builder b;
  private final h c;
  private RemoteViews d;
  private RemoteViews e;
  private final List<Bundle> f = new ArrayList();
  private final Bundle g = new Bundle();
  private int h;
  private RemoteViews i;
  
  i(h paramh)
  {
    this.c = paramh;
    this.a = paramh.a;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = new Notification.Builder(paramh.a, paramh.J);
    } else {
      localObject1 = new Notification.Builder(paramh.a);
    }
    this.b = ((Notification.Builder)localObject1);
    Notification localNotification = paramh.Q;
    Object localObject1 = this.b.setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, paramh.i).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
    boolean bool;
    if ((localNotification.flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = ((Notification.Builder)localObject1).setOngoing(bool);
    if ((localNotification.flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = ((Notification.Builder)localObject1).setOnlyAlertOnce(bool);
    if ((localNotification.flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = ((Notification.Builder)localObject1).setAutoCancel(bool).setDefaults(localNotification.defaults).setContentTitle(paramh.e).setContentText(paramh.f).setContentInfo(paramh.k).setContentIntent(paramh.g).setDeleteIntent(localNotification.deleteIntent);
    Object localObject2 = paramh.h;
    if ((localNotification.flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((Notification.Builder)localObject1).setFullScreenIntent((PendingIntent)localObject2, bool).setLargeIcon(paramh.j).setNumber(paramh.l).setProgress(paramh.s, paramh.t, paramh.u);
    this.b.setSubText(paramh.p).setUsesChronometer(paramh.o).setPriority(paramh.m);
    localObject1 = paramh.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((f)((Iterator)localObject1).next());
    }
    localObject1 = paramh.C;
    if (localObject1 != null) {
      this.g.putAll((Bundle)localObject1);
    }
    int j = Build.VERSION.SDK_INT;
    this.d = paramh.G;
    this.e = paramh.H;
    this.b.setShowWhen(paramh.n);
    this.b.setLocalOnly(paramh.y).setGroup(paramh.v).setGroupSummary(paramh.w).setSortKey(paramh.x);
    this.h = paramh.N;
    this.b.setCategory(paramh.B).setColor(paramh.D).setVisibility(paramh.E).setPublicVersion(paramh.F).setSound(localNotification.sound, localNotification.audioAttributes);
    if (j < 28) {
      localObject1 = d(e(paramh.c), paramh.T);
    } else {
      localObject1 = paramh.T;
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.b.addPerson((String)localObject2);
      }
    }
    this.i = paramh.I;
    if (paramh.d.size() > 0)
    {
      localObject2 = paramh.b().getBundle("android.car.EXTENSIONS");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = new Bundle((Bundle)localObject1);
      Bundle localBundle = new Bundle();
      j = 0;
      while (j < paramh.d.size())
      {
        localBundle.putBundle(Integer.toString(j), j.a((f)paramh.d.get(j)));
        j += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", localBundle);
      ((Bundle)localObject2).putBundle("invisible_actions", localBundle);
      paramh.b().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.g.putBundle("android.car.EXTENSIONS", (Bundle)localObject2);
    }
    j = Build.VERSION.SDK_INT;
    localObject1 = paramh.S;
    if (localObject1 != null) {
      this.b.setSmallIcon((Icon)localObject1);
    }
    if (j >= 24)
    {
      this.b.setExtras(paramh.C).setRemoteInputHistory(paramh.r);
      localObject1 = paramh.G;
      if (localObject1 != null) {
        this.b.setCustomContentView((RemoteViews)localObject1);
      }
      localObject1 = paramh.H;
      if (localObject1 != null) {
        this.b.setCustomBigContentView((RemoteViews)localObject1);
      }
      localObject1 = paramh.I;
      if (localObject1 != null) {
        this.b.setCustomHeadsUpContentView((RemoteViews)localObject1);
      }
    }
    if (j >= 26)
    {
      this.b.setBadgeIconType(paramh.K).setSettingsText(paramh.q).setShortcutId(paramh.L).setTimeoutAfter(paramh.M).setGroupAlertBehavior(paramh.N);
      if (paramh.A) {
        this.b.setColorized(paramh.z);
      }
      if (!TextUtils.isEmpty(paramh.J)) {
        this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
    if (j >= 28)
    {
      localObject1 = paramh.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        this.b.addPerson(((l)localObject2).h());
      }
    }
    j = Build.VERSION.SDK_INT;
    if (j >= 29)
    {
      this.b.setAllowSystemGeneratedContextualActions(paramh.P);
      this.b.setBubbleMetadata(g.a(null));
    }
    int k;
    if (a.c())
    {
      k = paramh.O;
      if (k != 0) {
        this.b.setForegroundServiceBehavior(k);
      }
    }
    if (paramh.R)
    {
      if (this.c.w) {
        this.h = 2;
      } else {
        this.h = 1;
      }
      this.b.setVibrate(null);
      this.b.setSound(null);
      k = localNotification.defaults & 0xFFFFFFFE & 0xFFFFFFFD;
      localNotification.defaults = k;
      this.b.setDefaults(k);
      if (j >= 26)
      {
        if (TextUtils.isEmpty(this.c.v)) {
          this.b.setGroup("silent");
        }
        this.b.setGroupAlertBehavior(this.h);
      }
    }
  }
  
  private void a(f paramf)
  {
    Object localObject = paramf.d();
    if (localObject != null) {
      localObject = ((IconCompat)localObject).l();
    } else {
      localObject = null;
    }
    Notification.Action.Builder localBuilder = new Notification.Action.Builder((Icon)localObject, paramf.h(), paramf.a());
    if (paramf.e() != null)
    {
      localObject = m.b(paramf.e());
      int k = localObject.length;
      j = 0;
      while (j < k)
      {
        localBuilder.addRemoteInput(localObject[j]);
        j += 1;
      }
    }
    if (paramf.c() != null) {
      localObject = new Bundle(paramf.c());
    } else {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramf.b());
    int j = Build.VERSION.SDK_INT;
    if (j >= 24) {
      localBuilder.setAllowGeneratedReplies(paramf.b());
    }
    ((Bundle)localObject).putInt("android.support.action.semanticAction", paramf.f());
    if (j >= 28) {
      localBuilder.setSemanticAction(paramf.f());
    }
    if (j >= 29) {
      localBuilder.setContextual(paramf.i());
    }
    ((Bundle)localObject).putBoolean("android.support.action.showsUserInterface", paramf.g());
    localBuilder.addExtras((Bundle)localObject);
    this.b.addAction(localBuilder.build());
  }
  
  private static List<String> d(List<String> paramList1, List<String> paramList2)
  {
    if (paramList1 == null) {
      return paramList2;
    }
    if (paramList2 == null) {
      return paramList1;
    }
    b localb = new b(paramList1.size() + paramList2.size());
    localb.addAll(paramList1);
    localb.addAll(paramList2);
    return new ArrayList(localb);
  }
  
  private static List<String> e(List<l> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((l)paramList.next()).g());
    }
    return localArrayList;
  }
  
  private void f(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults = (paramNotification.defaults & 0xFFFFFFFE & 0xFFFFFFFD);
  }
  
  public Notification b()
  {
    Objects.requireNonNull(this.c);
    Notification localNotification = c();
    RemoteViews localRemoteViews = this.c.G;
    if (localRemoteViews != null) {
      localNotification.contentView = localRemoteViews;
    }
    return localNotification;
  }
  
  protected Notification c()
  {
    int j = Build.VERSION.SDK_INT;
    if (j >= 26) {
      return this.b.build();
    }
    if (j >= 24)
    {
      localNotification = this.b.build();
      if (this.h != 0)
      {
        if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (this.h == 2)) {
          f(localNotification);
        }
        if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) == 0) && (this.h == 1)) {
          f(localNotification);
        }
      }
      return localNotification;
    }
    this.b.setExtras(this.g);
    Notification localNotification = this.b.build();
    RemoteViews localRemoteViews = this.d;
    if (localRemoteViews != null) {
      localNotification.contentView = localRemoteViews;
    }
    localRemoteViews = this.e;
    if (localRemoteViews != null) {
      localNotification.bigContentView = localRemoteViews;
    }
    localRemoteViews = this.i;
    if (localRemoteViews != null) {
      localNotification.headsUpContentView = localRemoteViews;
    }
    if (this.h != 0)
    {
      if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (this.h == 2)) {
        f(localNotification);
      }
      if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) == 0) && (this.h == 1)) {
        f(localNotification);
      }
    }
    return localNotification;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.i
 * JD-Core Version:    0.7.0.1
 */