package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import n1.a;
import p1.h.c;

public class h
{
  public final h.c a;
  public final Context b;
  public final String c;
  public final f0.d d;
  public final List<f0.b> e;
  public final List<Object> f;
  public final List<a> g;
  public final boolean h;
  public final f0.c i;
  public final Executor j;
  public final Executor k;
  public final boolean l;
  public final Intent m;
  public final boolean n;
  public final boolean o;
  private final Set<Integer> p;
  public final String q;
  public final File r;
  public final Callable<InputStream> s;
  
  @SuppressLint({"LambdaLast"})
  public h(Context paramContext, String paramString1, h.c paramc, f0.d paramd, List<f0.b> paramList, boolean paramBoolean1, f0.c paramc1, Executor paramExecutor1, Executor paramExecutor2, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, Set<Integer> paramSet, String paramString2, File paramFile, Callable<InputStream> paramCallable, f0.e parame, List<Object> paramList1, List<a> paramList2)
  {
    this.a = paramc;
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramd;
    this.e = paramList;
    this.h = paramBoolean1;
    this.i = paramc1;
    this.j = paramExecutor1;
    this.k = paramExecutor2;
    this.m = paramIntent;
    if (paramIntent != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.l = paramBoolean1;
    this.n = paramBoolean2;
    this.o = paramBoolean3;
    this.p = paramSet;
    this.q = paramString2;
    this.r = paramFile;
    this.s = paramCallable;
    if (paramList1 == null) {
      paramList1 = Collections.emptyList();
    }
    this.f = paramList1;
    if (paramList2 == null) {
      paramList2 = Collections.emptyList();
    }
    this.g = paramList2;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 > paramInt2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt2 != 0) && (this.o)) {
      return false;
    }
    if (this.n)
    {
      Set localSet = this.p;
      if (localSet == null) {
        return bool;
      }
      if (!localSet.contains(Integer.valueOf(paramInt1))) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.h
 * JD-Core Version:    0.7.0.1
 */