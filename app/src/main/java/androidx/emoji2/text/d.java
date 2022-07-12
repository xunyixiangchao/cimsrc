package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import g0.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class d
{
  private static final Object n = new Object();
  private static final Object o = new Object();
  private static volatile d p;
  private final ReadWriteLock a = new ReentrantReadWriteLock();
  private final Set<e> b;
  private volatile int c = 3;
  private final Handler d;
  private final b e;
  final g f;
  final boolean g;
  final boolean h;
  final int[] i;
  private final boolean j;
  private final int k;
  private final int l;
  private final d m;
  
  private d(c paramc)
  {
    this.g = paramc.b;
    this.h = paramc.c;
    this.i = paramc.d;
    this.j = paramc.f;
    this.k = paramc.g;
    this.f = paramc.a;
    this.l = paramc.h;
    this.m = paramc.i;
    this.d = new Handler(Looper.getMainLooper());
    b localb = new b();
    this.b = localb;
    Set localSet = paramc.e;
    if ((localSet != null) && (!localSet.isEmpty())) {
      localb.addAll(paramc.e);
    }
    this.e = new a(this);
    l();
  }
  
  public static d b()
  {
    for (;;)
    {
      synchronized (n)
      {
        d locald = p;
        if (locald != null)
        {
          bool = true;
          x0.h.j(bool, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
          return locald;
        }
      }
      boolean bool = false;
    }
  }
  
  public static boolean e(InputConnection paramInputConnection, Editable paramEditable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return g.c(paramInputConnection, paramEditable, paramInt1, paramInt2, paramBoolean);
  }
  
  public static boolean f(Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    return g.d(paramEditable, paramInt, paramKeyEvent);
  }
  
  public static d g(c paramc)
  {
    Object localObject1 = p;
    if (localObject1 == null) {
      synchronized (n)
      {
        d locald = p;
        localObject1 = locald;
        if (locald == null)
        {
          localObject1 = new d(paramc);
          p = (d)localObject1;
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public static boolean h()
  {
    return p != null;
  }
  
  private boolean j()
  {
    return d() == 1;
  }
  
  private void l()
  {
    this.a.writeLock().lock();
    try
    {
      if (this.l == 0) {
        this.c = 0;
      }
      this.a.writeLock().unlock();
      if (d() == 0) {
        this.e.a();
      }
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public int c()
  {
    return this.k;
  }
  
  public int d()
  {
    this.a.readLock().lock();
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      this.a.readLock().unlock();
    }
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public void k()
  {
    int i1 = this.l;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    x0.h.j(bool, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    if (j()) {
      return;
    }
    this.a.writeLock().lock();
    try
    {
      i1 = this.c;
      if (i1 == 0) {
        return;
      }
      this.c = 0;
      this.a.writeLock().unlock();
      this.e.a();
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  void m(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    this.a.writeLock().lock();
    try
    {
      this.c = 2;
      localArrayList.addAll(this.b);
      this.b.clear();
      this.a.writeLock().unlock();
      this.d.post(new f(localArrayList, this.c, paramThrowable));
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  void n()
  {
    ArrayList localArrayList = new ArrayList();
    this.a.writeLock().lock();
    try
    {
      this.c = 1;
      localArrayList.addAll(this.b);
      this.b.clear();
      this.a.writeLock().unlock();
      this.d.post(new f(localArrayList, this.c));
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public CharSequence o(CharSequence paramCharSequence)
  {
    int i1;
    if (paramCharSequence == null) {
      i1 = 0;
    } else {
      i1 = paramCharSequence.length();
    }
    return p(paramCharSequence, 0, i1);
  }
  
  public CharSequence p(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return q(paramCharSequence, paramInt1, paramInt2, 2147483647);
  }
  
  public CharSequence q(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    return r(paramCharSequence, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public CharSequence r(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    x0.h.j(j(), "Not initialized yet");
    x0.h.e(paramInt1, "start cannot be negative");
    x0.h.e(paramInt2, "end cannot be negative");
    x0.h.e(paramInt3, "maxEmojiCount cannot be negative");
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 <= paramInt2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    x0.h.b(bool1, "start should be <= than end");
    if (paramCharSequence == null) {
      return null;
    }
    if (paramInt1 <= paramCharSequence.length()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    x0.h.b(bool1, "start should be < than charSequence length");
    if (paramInt2 <= paramCharSequence.length()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    x0.h.b(bool1, "end should be < than charSequence length");
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() != 0)
    {
      if (paramInt1 == paramInt2) {
        return paramCharSequence;
      }
      if (paramInt4 != 1)
      {
        bool1 = bool2;
        if (paramInt4 != 2) {
          bool1 = this.g;
        }
      }
      else
      {
        bool1 = true;
      }
      localCharSequence = this.e.b(paramCharSequence, paramInt1, paramInt2, paramInt3, bool1);
    }
    return localCharSequence;
  }
  
  public void s(e parame)
  {
    x0.h.h(parame, "initCallback cannot be null");
    this.a.writeLock().lock();
    try
    {
      if ((this.c != 1) && (this.c != 2)) {
        this.b.add(parame);
      } else {
        this.d.post(new f(parame, this.c));
      }
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public void t(e parame)
  {
    x0.h.h(parame, "initCallback cannot be null");
    this.a.writeLock().lock();
    try
    {
      this.b.remove(parame);
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public void u(EditorInfo paramEditorInfo)
  {
    if (j())
    {
      if (paramEditorInfo == null) {
        return;
      }
      if (paramEditorInfo.extras == null) {
        paramEditorInfo.extras = new Bundle();
      }
      this.e.c(paramEditorInfo);
    }
  }
  
  private static final class a
    extends d.b
  {
    private volatile g b;
    private volatile l c;
    
    a(d paramd)
    {
      super();
    }
    
    void a()
    {
      try
      {
        a locala = new a();
        this.a.f.a(locala);
        return;
      }
      finally
      {
        this.a.m(localThrowable);
      }
    }
    
    CharSequence b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      return this.b.h(paramCharSequence, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    
    void c(EditorInfo paramEditorInfo)
    {
      paramEditorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.c.e());
      paramEditorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.a.g);
    }
    
    void d(l paraml)
    {
      if (paraml == null)
      {
        this.a.m(new IllegalArgumentException("metadataRepo cannot be null"));
        return;
      }
      this.c = paraml;
      paraml = this.c;
      d.i locali = new d.i();
      d.d locald = d.a(this.a);
      d locald1 = this.a;
      this.b = new g(paraml, locali, locald, locald1.h, locald1.i);
      this.a.n();
    }
    
    class a
      extends d.h
    {
      a() {}
      
      public void a(Throwable paramThrowable)
      {
        d.a.this.a.m(paramThrowable);
      }
      
      public void b(l paraml)
      {
        d.a.this.d(paraml);
      }
    }
  }
  
  private static class b
  {
    final d a;
    
    b(d paramd)
    {
      this.a = paramd;
    }
    
    void a()
    {
      throw null;
    }
    
    CharSequence b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      throw null;
    }
    
    void c(EditorInfo paramEditorInfo)
    {
      throw null;
    }
  }
  
  public static abstract class c
  {
    final d.g a;
    boolean b;
    boolean c;
    int[] d;
    Set<d.e> e;
    boolean f;
    int g = -16711936;
    int h = 0;
    d.d i = new g.b();
    
    protected c(d.g paramg)
    {
      x0.h.h(paramg, "metadataLoader cannot be null.");
      this.a = paramg;
    }
    
    protected final d.g a()
    {
      return this.a;
    }
    
    public c b(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static abstract class e
  {
    public void a(Throwable paramThrowable) {}
    
    public void b() {}
  }
  
  private static class f
    implements Runnable
  {
    private final List<d.e> a;
    private final Throwable b;
    private final int c;
    
    f(d.e parame, int paramInt)
    {
      this(Arrays.asList(new d.e[] { (d.e)x0.h.h(parame, "initCallback cannot be null") }), paramInt, null);
    }
    
    f(Collection<d.e> paramCollection, int paramInt)
    {
      this(paramCollection, paramInt, null);
    }
    
    f(Collection<d.e> paramCollection, int paramInt, Throwable paramThrowable)
    {
      x0.h.h(paramCollection, "initCallbacks cannot be null");
      this.a = new ArrayList(paramCollection);
      this.c = paramInt;
      this.b = paramThrowable;
    }
    
    public void run()
    {
      int k = this.a.size();
      int m = this.c;
      int i = 0;
      int j = 0;
      if (m != 1)
      {
        i = j;
        while (i < k)
        {
          ((d.e)this.a.get(i)).a(this.b);
          i += 1;
        }
      }
      while (i < k)
      {
        ((d.e)this.a.get(i)).b();
        i += 1;
      }
    }
  }
  
  public static abstract interface g
  {
    public abstract void a(d.h paramh);
  }
  
  public static abstract class h
  {
    public abstract void a(Throwable paramThrowable);
    
    public abstract void b(l paraml);
  }
  
  static class i
  {
    h a(f paramf)
    {
      return new n(paramf);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.d
 * JD-Core Version:    0.7.0.1
 */