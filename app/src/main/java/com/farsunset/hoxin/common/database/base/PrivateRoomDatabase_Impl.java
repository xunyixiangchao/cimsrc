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

public final class PrivateRoomDatabase_Impl
  extends PrivateRoomDatabase
{
  private volatile b4.c A;
  private volatile y6.a B;
  private volatile k5.a C;
  private volatile q6.e D;
  private volatile q6.c E;
  private volatile q6.a F;
  private volatile h6.a p;
  private volatile j4.a q;
  private volatile q4.c r;
  private volatile q4.a s;
  private volatile h6.c t;
  private volatile h6.e u;
  private volatile k5.c v;
  private volatile y5.c w;
  private volatile y5.a x;
  private volatile x4.a y;
  private volatile b4.a z;
  
  k5.a D()
  {
    if (this.C != null) {
      return this.C;
    }
    try
    {
      if (this.C == null) {
        this.C = new k5.b(this);
      }
      k5.a locala = this.C;
      return locala;
    }
    finally {}
  }
  
  h6.a E()
  {
    if (this.p != null) {
      return this.p;
    }
    try
    {
      if (this.p == null) {
        this.p = new h6.b(this);
      }
      h6.a locala = this.p;
      return locala;
    }
    finally {}
  }
  
  q6.a F()
  {
    if (this.F != null) {
      return this.F;
    }
    try
    {
      if (this.F == null) {
        this.F = new q6.b(this);
      }
      q6.a locala = this.F;
      return locala;
    }
    finally {}
  }
  
  q6.c G()
  {
    if (this.E != null) {
      return this.E;
    }
    try
    {
      if (this.E == null) {
        this.E = new q6.d(this);
      }
      q6.c localc = this.E;
      return localc;
    }
    finally {}
  }
  
  b4.a H()
  {
    if (this.z != null) {
      return this.z;
    }
    try
    {
      if (this.z == null) {
        this.z = new b4.b(this);
      }
      b4.a locala = this.z;
      return locala;
    }
    finally {}
  }
  
  b4.c I()
  {
    if (this.A != null) {
      return this.A;
    }
    try
    {
      if (this.A == null) {
        this.A = new b4.d(this);
      }
      b4.c localc = this.A;
      return localc;
    }
    finally {}
  }
  
  j4.a J()
  {
    if (this.q != null) {
      return this.q;
    }
    try
    {
      if (this.q == null) {
        this.q = new j4.b(this);
      }
      j4.a locala = this.q;
      return locala;
    }
    finally {}
  }
  
  y6.a K()
  {
    if (this.B != null) {
      return this.B;
    }
    try
    {
      if (this.B == null) {
        this.B = new y6.b(this);
      }
      y6.a locala = this.B;
      return locala;
    }
    finally {}
  }
  
  q4.a L()
  {
    if (this.s != null) {
      return this.s;
    }
    try
    {
      if (this.s == null) {
        this.s = new q4.b(this);
      }
      q4.a locala = this.s;
      return locala;
    }
    finally {}
  }
  
  q4.c M()
  {
    if (this.r != null) {
      return this.r;
    }
    try
    {
      if (this.r == null) {
        this.r = new q4.d(this);
      }
      q4.c localc = this.r;
      return localc;
    }
    finally {}
  }
  
  k5.c O()
  {
    if (this.v != null) {
      return this.v;
    }
    try
    {
      if (this.v == null) {
        this.v = new k5.d(this);
      }
      k5.c localc = this.v;
      return localc;
    }
    finally {}
  }
  
  y5.a P()
  {
    if (this.x != null) {
      return this.x;
    }
    try
    {
      if (this.x == null) {
        this.x = new y5.b(this);
      }
      y5.a locala = this.x;
      return locala;
    }
    finally {}
  }
  
  y5.c Q()
  {
    if (this.w != null) {
      return this.w;
    }
    try
    {
      if (this.w == null) {
        this.w = new y5.d(this);
      }
      y5.c localc = this.w;
      return localc;
    }
    finally {}
  }
  
  h6.c R()
  {
    if (this.t != null) {
      return this.t;
    }
    try
    {
      if (this.t == null) {
        this.t = new h6.d(this);
      }
      h6.c localc = this.t;
      return localc;
    }
    finally {}
  }
  
  h6.e S()
  {
    if (this.u != null) {
      return this.u;
    }
    try
    {
      if (this.u == null) {
        this.u = new h6.f(this);
      }
      h6.e locale = this.u;
      return locale;
    }
    finally {}
  }
  
  q6.e T()
  {
    if (this.D != null) {
      return this.D;
    }
    try
    {
      if (this.D == null) {
        this.D = new q6.f(this);
      }
      q6.e locale = this.D;
      return locale;
    }
    finally {}
  }
  
  x4.a U()
  {
    if (this.y != null) {
      return this.y;
    }
    try
    {
      if (this.y == null) {
        this.y = new x4.b(this);
      }
      x4.a locala = this.y;
      return locala;
    }
    finally {}
  }
  
  protected n h()
  {
    return new n(this, new HashMap(0), new HashMap(0), new String[] { "t_hoxin_moment_comment", "t_hoxin_friend", "t_hoxin_group", "t_hoxin_group_member", "t_hoxin_message", "t_hoxin_micro_server", "t_hoxin_micro_server_menu", "t_hoxin_star_mark", "t_hoxin_moment", "t_hoxin_moment_rule", "t_hoxin_emoticon", "t_hoxin_emoticon_item", "t_hoxin_group_call_log", "t_hoxin_chat_session", "t_hoxin_group_robot", "t_hoxin_organization", "t_hoxin_department", "t_hoxin_department_member" });
  }
  
  protected p1.h i(androidx.room.h paramh)
  {
    Object localObject = new g0(paramh, new a(330), "3a1235256523d51800791e8a4aeb5a40", "2297055e72686ac0a48fec715d29cff7");
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
    localHashMap.put(h6.a.class, h6.b.g());
    localHashMap.put(j4.a.class, j4.b.a());
    localHashMap.put(q4.c.class, q4.d.p());
    localHashMap.put(q4.a.class, q4.b.p());
    localHashMap.put(h6.c.class, h6.d.m());
    localHashMap.put(h6.e.class, h6.f.f());
    localHashMap.put(k5.c.class, k5.d.C());
    localHashMap.put(y5.c.class, y5.d.g());
    localHashMap.put(y5.a.class, y5.b.c());
    localHashMap.put(x4.a.class, x4.b.d());
    localHashMap.put(b4.a.class, b4.b.a());
    localHashMap.put(b4.c.class, b4.d.b());
    localHashMap.put(y6.a.class, y6.b.c());
    localHashMap.put(k5.a.class, k5.b.b());
    localHashMap.put(q4.e.class, q4.f.a());
    localHashMap.put(q6.e.class, q6.f.e());
    localHashMap.put(q6.c.class, q6.d.j());
    localHashMap.put(q6.a.class, q6.b.h());
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
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_moment_comment` (`id` INTEGER NOT NULL, `moment_id` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `content` TEXT, `parent_id` INTEGER, `type` TEXT, `is_deleted` INTEGER NOT NULL, `create_time` INTEGER, PRIMARY KEY(`id`))");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_moment_id` ON `t_hoxin_moment_comment` (`moment_id`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_friend` (`id` INTEGER NOT NULL, `name` TEXT, `motto` TEXT, `gender` INTEGER, `telephone` TEXT, `email` TEXT, `type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_group` (`id` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `name` TEXT, `notice` TEXT, `state` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_group_member` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `group_id` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `type` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `name` TEXT)");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_group_id` ON `t_hoxin_group_member` (`group_id`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_message` (`id` INTEGER NOT NULL, `session_id` INTEGER, `sender` INTEGER NOT NULL, `receiver` INTEGER NOT NULL, `action` TEXT NOT NULL, `content` TEXT, `title` TEXT, `extra` TEXT, `format` INTEGER NOT NULL, `state` INTEGER NOT NULL, `direction` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_session_id` ON `t_hoxin_message` (`session_id`)");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_action` ON `t_hoxin_message` (`action`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_micro_server` (`id` INTEGER NOT NULL, `account` TEXT, `description` TEXT, `name` TEXT, `website` TEXT, `greet` TEXT, `url` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_micro_server_menu` (`id` INTEGER NOT NULL, `parent_id` INTEGER, `server_id` INTEGER NOT NULL, `name` TEXT, `code` TEXT, `type` INTEGER, `content` TEXT, `sort` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_star_mark` (`uid` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_moment` (`id` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `text` TEXT, `content` TEXT, `extra` TEXT, `type` INTEGER NOT NULL, `create_time` INTEGER, PRIMARY KEY(`id`))");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_uid` ON `t_hoxin_moment` (`uid`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_moment_rule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `target_id` INTEGER NOT NULL, `type` INTEGER NOT NULL)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_emoticon` (`id` INTEGER, `name` TEXT, `state` INTEGER NOT NULL, `index` INTEGER NOT NULL, `type` INTEGER NOT NULL, `description` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_emoticon_item` (`id` INTEGER, `emoticon_id` INTEGER, `name` TEXT, `type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_emoticon_id` ON `t_hoxin_emoticon_item` (`emoticon_id`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_group_call_log` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tag` TEXT, `uid` INTEGER NOT NULL, `type` INTEGER NOT NULL, `state` INTEGER NOT NULL, `content` TEXT, `duration` INTEGER, `timestamp` INTEGER)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_chat_session` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `source_id` INTEGER NOT NULL, `source_type` INTEGER NOT NULL, `message` TEXT, `state` INTEGER NOT NULL, `visible` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `badge` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_source_id` ON `t_hoxin_chat_session` (`source_id`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_group_robot` (`id` INTEGER NOT NULL, `group_id` INTEGER NOT NULL, `name` TEXT, `type` INTEGER NOT NULL, `extra` TEXT, `state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
      paramg.p("CREATE INDEX IF NOT EXISTS `idx_robot_group_id` ON `t_hoxin_group_robot` (`group_id`)");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_organization` (`id` INTEGER, `name` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_department` (`id` INTEGER, `parent_id` INTEGER, `organization_id` INTEGER, `name` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS `t_hoxin_department_member` (`id` INTEGER, `department_id` INTEGER, `organization_id` INTEGER, `uid` INTEGER, `title` TEXT, PRIMARY KEY(`id`))");
      paramg.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
      paramg.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3a1235256523d51800791e8a4aeb5a40')");
    }
    
    public void b(p1.g paramg)
    {
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_moment_comment`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_friend`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_group`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_group_member`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_message`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_micro_server`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_micro_server_menu`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_star_mark`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_moment`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_moment_rule`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_emoticon`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_emoticon_item`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_group_call_log`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_chat_session`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_group_robot`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_organization`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_department`");
      paramg.p("DROP TABLE IF EXISTS `t_hoxin_department_member`");
      if (PrivateRoomDatabase_Impl.V(PrivateRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PrivateRoomDatabase_Impl.W(PrivateRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PrivateRoomDatabase_Impl.Y(PrivateRoomDatabase_Impl.this).get(i)).b(paramg);
          i += 1;
        }
      }
    }
    
    protected void c(p1.g paramg)
    {
      if (PrivateRoomDatabase_Impl.Z(PrivateRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PrivateRoomDatabase_Impl.a0(PrivateRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PrivateRoomDatabase_Impl.b0(PrivateRoomDatabase_Impl.this).get(i)).a(paramg);
          i += 1;
        }
      }
    }
    
    public void d(p1.g paramg)
    {
      PrivateRoomDatabase_Impl.c0(PrivateRoomDatabase_Impl.this, paramg);
      PrivateRoomDatabase_Impl.d0(PrivateRoomDatabase_Impl.this, paramg);
      if (PrivateRoomDatabase_Impl.e0(PrivateRoomDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = PrivateRoomDatabase_Impl.f0(PrivateRoomDatabase_Impl.this).size();
        while (i < j)
        {
          ((f0.b)PrivateRoomDatabase_Impl.X(PrivateRoomDatabase_Impl.this).get(i)).c(paramg);
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
      Object localObject1 = new HashMap(8);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("moment_id", new g.a("moment_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("content", new g.a("content", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("parent_id", new g.a("parent_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("is_deleted", new g.a("is_deleted", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("create_time", new g.a("create_time", "INTEGER", false, 0, null, 1));
      Object localObject2 = new HashSet(0);
      HashSet localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_moment_id", false, Arrays.asList(new String[] { "moment_id" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_moment_comment", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_moment_comment");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_moment_comment(com.farsunset.hoxin.moment.entity.Comment).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(7);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("motto", new g.a("motto", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("gender", new g.a("gender", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("telephone", new g.a("telephone", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("email", new g.a("email", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_friend", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_friend");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_friend(com.farsunset.hoxin.friend.entity.Friend).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(6);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("notice", new g.a("notice", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("is_deleted", new g.a("is_deleted", "INTEGER", true, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_group", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_group");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_group(com.farsunset.hoxin.group.entity.Group).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(6);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("group_id", new g.a("group_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("is_deleted", new g.a("is_deleted", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_group_id", false, Arrays.asList(new String[] { "group_id" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_group_member", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_group_member");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_group_member(com.farsunset.hoxin.group.entity.GroupMember).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(12);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("session_id", new g.a("session_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("sender", new g.a("sender", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("receiver", new g.a("receiver", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("action", new g.a("action", "TEXT", true, 0, null, 1));
      ((HashMap)localObject1).put("content", new g.a("content", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("title", new g.a("title", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("extra", new g.a("extra", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("format", new g.a("format", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("direction", new g.a("direction", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("create_time", new g.a("create_time", "INTEGER", true, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(2);
      localHashSet.add(new g.d("idx_session_id", false, Arrays.asList(new String[] { "session_id" }), Arrays.asList(new String[] { "ASC" })));
      localHashSet.add(new g.d("idx_action", false, Arrays.asList(new String[] { "action" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_message", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_message");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_message(com.farsunset.hoxin.message.entity.Message).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(7);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("account", new g.a("account", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("description", new g.a("description", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("website", new g.a("website", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("greet", new g.a("greet", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("url", new g.a("url", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_micro_server", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_micro_server");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_micro_server(com.farsunset.hoxin.micro.entity.MicroServer).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(8);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("parent_id", new g.a("parent_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("server_id", new g.a("server_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("code", new g.a("code", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("content", new g.a("content", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("sort", new g.a("sort", "INTEGER", true, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_micro_server_menu", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_micro_server_menu");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_micro_server_menu(com.farsunset.hoxin.micro.entity.MicroServerMenu).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(1);
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 1, null, 1));
      localObject1 = new o1.g("t_hoxin_star_mark", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_star_mark");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_star_mark(com.farsunset.hoxin.home.entity.StarMark).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(7);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("text", new g.a("text", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("content", new g.a("content", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("extra", new g.a("extra", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("create_time", new g.a("create_time", "INTEGER", false, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_uid", false, Arrays.asList(new String[] { "uid" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_moment", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_moment");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_moment(com.farsunset.hoxin.moment.entity.Moment).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(3);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("target_id", new g.a("target_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_moment_rule", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_moment_rule");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_moment_rule(com.farsunset.hoxin.moment.entity.MomentRule).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(6);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", false, 1, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("index", new g.a("index", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("description", new g.a("description", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_emoticon", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_emoticon");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_emoticon(com.farsunset.hoxin.emoticon.entity.Emoticon).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(4);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", false, 1, null, 1));
      ((HashMap)localObject1).put("emoticon_id", new g.a("emoticon_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_emoticon_id", false, Arrays.asList(new String[] { "emoticon_id" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_emoticon_item", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_emoticon_item");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_emoticon_item(com.farsunset.hoxin.emoticon.entity.EmoticonItem).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(8);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("tag", new g.a("tag", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("content", new g.a("content", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("duration", new g.a("duration", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("timestamp", new g.a("timestamp", "INTEGER", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_group_call_log", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_group_call_log");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_group_call_log(com.farsunset.hoxin.webrtc.entity.GroupCallLog).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(10);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("source_id", new g.a("source_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("source_type", new g.a("source_type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("message", new g.a("message", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("visible", new g.a("visible", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("priority", new g.a("priority", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("badge", new g.a("badge", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("timestamp", new g.a("timestamp", "INTEGER", true, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_source_id", false, Arrays.asList(new String[] { "source_id" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_chat_session", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_chat_session");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_chat_session(com.farsunset.hoxin.message.entity.ChatSession).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(6);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", true, 1, null, 1));
      ((HashMap)localObject1).put("group_id", new g.a("group_id", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("type", new g.a("type", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("extra", new g.a("extra", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("state", new g.a("state", "INTEGER", true, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(1);
      localHashSet.add(new g.d("idx_robot_group_id", false, Arrays.asList(new String[] { "group_id" }), Arrays.asList(new String[] { "ASC" })));
      localObject1 = new o1.g("t_hoxin_group_robot", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = o1.g.a(paramg, "t_hoxin_group_robot");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_group_robot(com.farsunset.hoxin.group.entity.GroupRobot).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", false, 1, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_organization", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_organization");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_organization(com.farsunset.hoxin.organization.entity.Organization).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(4);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", false, 1, null, 1));
      ((HashMap)localObject1).put("parent_id", new g.a("parent_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("organization_id", new g.a("organization_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("name", new g.a("name", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_department", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject2 = o1.g.a(paramg, "t_hoxin_department");
      if (!((o1.g)localObject1).equals(localObject2))
      {
        paramg = new StringBuilder();
        paramg.append("t_hoxin_department(com.farsunset.hoxin.organization.entity.Department).\n Expected:\n");
        paramg.append(localObject1);
        paramg.append("\n Found:\n");
        paramg.append(localObject2);
        return new g0.b(false, paramg.toString());
      }
      localObject1 = new HashMap(5);
      ((HashMap)localObject1).put("id", new g.a("id", "INTEGER", false, 1, null, 1));
      ((HashMap)localObject1).put("department_id", new g.a("department_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("organization_id", new g.a("organization_id", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("uid", new g.a("uid", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("title", new g.a("title", "TEXT", false, 0, null, 1));
      localObject1 = new o1.g("t_hoxin_department_member", (Map)localObject1, new HashSet(0), new HashSet(0));
      paramg = o1.g.a(paramg, "t_hoxin_department_member");
      if (!((o1.g)localObject1).equals(paramg))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("t_hoxin_department_member(com.farsunset.hoxin.organization.entity.DepartmentMember).\n Expected:\n");
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
 * Qualified Name:     com.farsunset.hoxin.common.database.base.PrivateRoomDatabase_Impl
 * JD-Core Version:    0.7.0.1
 */