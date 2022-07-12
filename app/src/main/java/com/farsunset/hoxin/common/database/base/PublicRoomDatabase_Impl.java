package com.farsunset.hoxin.common.database.base;

import androidx.room.f0.b;
import androidx.room.g0;
import androidx.room.g0.a;
import androidx.room.g0.b;
import androidx.room.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o1.g.a;
import o1.g.d;
import p1.h.a;
import p1.h.b;
import p1.h.b.a;
import p1.h.c;
import q3.d;

public final class PublicRoomDatabase_Impl
  extends PublicRoomDatabase
{
  private volatile q3.a p;
  private volatile q3.c q;
  
  q3.a D()
  {
    if (this.p != null) {
      return this.p;
    }
    try
    {
      if (this.p == null) {
        this.p = new q3.b(this);
      }
      q3.a locala = this.p;
      return locala;
    }
    finally {}
  }
  
  q3.c G()
  {
    if (this.q != null) {
      return this.q;
    }
    try
    {
      if (this.q == null) {
        this.q = new d(this);
      }
      q3.c localc = this.q;
      return localc;
    }
    finally {}
  }
  
  protected n h()
  {
    return new n(this, new HashMap(0), new HashMap(0), new String[] { "t_hoxin_config", "t_hoxin_glide_version" });
  }
  
  protected p1.h i(androidx.room.h paramh)
  {
    Object localObject = new g0(paramh, new a(330), "be4cf59266ccb90b4047737b1b4d9d7a", "a3839702bf1f463b04fe98066a099822");
    localObject = h.b.a(paramh.b).c(paramh.c).b((h.a)localObject).a();
    return paramh.a.a((h.b)localObject);
  }
  
  public List<n1.b> k(Map<Class<? extends n1.a>, n1.a> paramMap)
  {
    return Arrays.asList(new n1.b[0]);
  }
  
  public Set<Class<? extends n1.a>> o()
  {
    return new HashSet();
  }
  
  protected Map<Class<?>, List<Class<?>>> p()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(q3.a.class, q3.b.c());
    localHashMap.put(q3.c.class, d.c());
    return localHashMap;
  }
  
  class a
    extends g0.a
  {
    a(int paramInt)
    {
      super();
    }
    
    public void a(p1.g paramg)
    {
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_config` (`id` INTEGER NOT NULL, `name` TEXT, `value` TEXT, `domain` TEXT, `description` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_glide_version` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `version` TEXT)");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_url` ON `t_hoxin_glide_version` (`url`)");
      paramg.p("CREATE INDEX IF NOT EXISTS `index_t_hoxin_glide_version_url` ON `t_hoxin_glide_version` (`url`)");
      paramg.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
      paramg.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'be4cf59266ccb90b4047737b1b4d9d7a')");
    }
    
    public void b(p1.g paramg)
    {
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_config`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_glide_version`");
      if (PublicRoomDatabase_Impl.H(PublicRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PublicRoomDatabase_Impl.I(PublicRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PublicRoomDatabase_Impl.K(PublicRoomDatabase_Impl.this).get(i)).b(paramg);
          i += 1;
        }
      }
    }
    
    protected void c(p1.g paramg)
    {
      if (PublicRoomDatabase_Impl.L(PublicRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PublicRoomDatabase_Impl.M(PublicRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PublicRoomDatabase_Impl.N(PublicRoomDatabase_Impl.this).get(i)).a(paramg);
          i += 1;
        }
      }
    }
    
    public void d(p1.g paramg)
    {
      PublicRoomDatabase_Impl.O(PublicRoomDatabase_Impl.this, paramg);
      PublicRoomDatabase_Impl.P(PublicRoomDatabase_Impl.this, paramg);
      if (PublicRoomDatabase_Impl.Q(PublicRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PublicRoomDatabase_Impl.R(PublicRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PublicRoomDatabase_Impl.J(PublicRoomDatabase_Impl.this).get(i)).c(paramg);
          i += 1;
        }
      }
    }
    
    public void e(p1.g paramg) {}
    
    public void f(p1.g paramg)
    {
      o1.c.a(paramg);
    }
    
    protected g0.b g(p1.g paramg)
    {
      Object localObject1 = new HashMap(5);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("value", new g.a("value", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("domain", new g.a("domain", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("description", new g.a("description", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_config", (Map)localObject1, new HashSet(0), new HashSet(0));
      Object localObject2 = o1.g.a(paramg, "t_hoxin_config");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_config(com.farsunset.hoxin.common.entity.Config).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(3);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("url", new g.a("url", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("version", new g.a("version", "TEXT", false, 0, null, 1));
      localObject2 = new HashSet(0);
      HashSet localHashSet = new HashSet(2);
      localHashSet.add(new g.d("idx_url", false, Arrays.asList(new String[] { "url" }), Arrays.asList(new String[] { "ASC" })));
      localHashSet.add(new g.d("index_t_hoxin_glide_version_url", false, Arrays.asList(new String[] { "url" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_glide_version", (Map)localObject1, (Set)localObject2, localHashSet);
      paramg = o1.g.a(paramg, "t_hoxin_glide_version");
      if (!((o1.g)localObject1).equals(paramg))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("t_hoxin_glide_version(com.farsunset.hoxin.common.entity.GlideVersion).\n Expected:\n");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("\n Found:\n");
        ((StringBuilder)localObject2).append(paramg);
        return new g0.b(false, ((StringBuilder)localObject2).toString());
      }
      return new g0.b(true, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.database.base.PublicRoomDatabase_Impl
 * JD-Core Version:    0.7.0.1
 */