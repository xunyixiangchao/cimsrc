package o1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import m1.h;

public final class g
{
  public final String a;
  public final Map<String, a> b;
  public final Set<b> c;
  public final Set<d> d;
  
  public g(String paramString, Map<String, a> paramMap, Set<b> paramSet, Set<d> paramSet1)
  {
    this.a = paramString;
    this.b = Collections.unmodifiableMap(paramMap);
    this.c = Collections.unmodifiableSet(paramSet);
    if (paramSet1 == null) {
      paramString = null;
    } else {
      paramString = Collections.unmodifiableSet(paramSet1);
    }
    this.d = paramString;
  }
  
  public static g a(p1.g paramg, String paramString)
  {
    return new g(paramString, b(paramg, paramString), d(paramg, paramString), f(paramg, paramString));
  }
  
  private static Map<String, a> b(p1.g paramg, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA table_info(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramg = paramg.a0(((StringBuilder)localObject).toString());
    paramString = new HashMap();
    for (;;)
    {
      try
      {
        if (paramg.getColumnCount() > 0)
        {
          int i = paramg.getColumnIndex("name");
          int j = paramg.getColumnIndex("type");
          int k = paramg.getColumnIndex("notnull");
          int m = paramg.getColumnIndex("pk");
          int n = paramg.getColumnIndex("dflt_value");
          if (paramg.moveToNext())
          {
            localObject = paramg.getString(i);
            String str = paramg.getString(j);
            if (paramg.getInt(k) == 0) {
              break label212;
            }
            bool = true;
            paramString.put(localObject, new a((String)localObject, str, bool, paramg.getInt(m), paramg.getString(n), 2));
            continue;
          }
        }
        return paramString;
      }
      finally
      {
        paramg.close();
      }
      label212:
      boolean bool = false;
    }
  }
  
  private static List<c> c(Cursor paramCursor)
  {
    int j = paramCursor.getColumnIndex("id");
    int k = paramCursor.getColumnIndex("seq");
    int m = paramCursor.getColumnIndex("from");
    int n = paramCursor.getColumnIndex("to");
    int i1 = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < i1)
    {
      paramCursor.moveToPosition(i);
      localArrayList.add(new c(paramCursor.getInt(j), paramCursor.getInt(k), paramCursor.getString(m), paramCursor.getString(n)));
      i += 1;
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static Set<b> d(p1.g paramg, String paramString)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA foreign_key_list(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramg = paramg.a0(((StringBuilder)localObject).toString());
    try
    {
      int j = paramg.getColumnIndex("id");
      int k = paramg.getColumnIndex("seq");
      int m = paramg.getColumnIndex("table");
      int n = paramg.getColumnIndex("on_delete");
      int i1 = paramg.getColumnIndex("on_update");
      paramString = c(paramg);
      int i2 = paramg.getCount();
      int i = 0;
      while (i < i2)
      {
        paramg.moveToPosition(i);
        if (paramg.getInt(k) == 0)
        {
          int i3 = paramg.getInt(j);
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            if (localc.a == i3)
            {
              ((List)localObject).add(localc.c);
              localArrayList.add(localc.d);
            }
          }
          localHashSet.add(new b(paramg.getString(m), paramg.getString(n), paramg.getString(i1), (List)localObject, localArrayList));
        }
        i += 1;
      }
      return localHashSet;
    }
    finally
    {
      paramg.close();
    }
  }
  
  private static d e(p1.g paramg, String paramString, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PRAGMA index_xinfo(`");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("`)");
    localObject1 = paramg.a0(((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        int i = ((Cursor)localObject1).getColumnIndex("seqno");
        int j = ((Cursor)localObject1).getColumnIndex("cid");
        int k = ((Cursor)localObject1).getColumnIndex("name");
        int m = ((Cursor)localObject1).getColumnIndex("desc");
        if ((i != -1) && (j != -1) && (k != -1) && (m != -1))
        {
          Object localObject2 = new TreeMap();
          TreeMap localTreeMap = new TreeMap();
          if (((Cursor)localObject1).moveToNext())
          {
            if (((Cursor)localObject1).getInt(j) < 0) {
              continue;
            }
            int n = ((Cursor)localObject1).getInt(i);
            String str = ((Cursor)localObject1).getString(k);
            if (((Cursor)localObject1).getInt(m) > 0)
            {
              paramg = "DESC";
              ((TreeMap)localObject2).put(Integer.valueOf(n), str);
              localTreeMap.put(Integer.valueOf(n), paramg);
            }
          }
          else
          {
            paramg = new ArrayList(((TreeMap)localObject2).size());
            paramg.addAll(((TreeMap)localObject2).values());
            localObject2 = new ArrayList(localTreeMap.size());
            ((List)localObject2).addAll(localTreeMap.values());
            paramg = new d(paramString, paramBoolean, paramg, (List)localObject2);
            return paramg;
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      paramg = "ASC";
    }
  }
  
  private static Set<d> f(p1.g paramg, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PRAGMA index_list(`");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("`)");
    paramString = paramg.a0(((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        int i = paramString.getColumnIndex("name");
        int j = paramString.getColumnIndex("origin");
        int k = paramString.getColumnIndex("unique");
        if ((i != -1) && (j != -1) && (k != -1))
        {
          localObject1 = new HashSet();
          if (paramString.moveToNext())
          {
            if (!"c".equals(paramString.getString(j))) {
              continue;
            }
            Object localObject2 = paramString.getString(i);
            int m = paramString.getInt(k);
            bool = true;
            if (m == 1)
            {
              localObject2 = e(paramg, (String)localObject2, bool);
              if (localObject2 == null) {
                return null;
              }
              ((HashSet)localObject1).add(localObject2);
            }
          }
          else
          {
            return localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        paramString.close();
      }
      boolean bool = false;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!((String)localObject).equals(paramObject.a)) {
        return false;
      }
    }
    else if (paramObject.a != null) {
      return false;
    }
    localObject = this.b;
    if (localObject != null)
    {
      if (!((Map)localObject).equals(paramObject.b)) {
        return false;
      }
    }
    else if (paramObject.b != null) {
      return false;
    }
    localObject = this.c;
    if (localObject != null)
    {
      if (!((Set)localObject).equals(paramObject.c)) {
        return false;
      }
    }
    else if (paramObject.c != null) {
      return false;
    }
    localObject = this.d;
    if (localObject != null)
    {
      paramObject = paramObject.d;
      if (paramObject == null) {
        return true;
      }
      return ((Set)localObject).equals(paramObject);
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = ((Map)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = ((Set)localObject).hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TableInfo{name='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columns=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", foreignKeys=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", indices=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final int e;
    public final String f;
    private final int g;
    
    public a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.d = paramBoolean;
      this.e = paramInt1;
      this.c = c(paramString2);
      this.f = paramString3;
      this.g = paramInt2;
    }
    
    private static boolean a(String paramString)
    {
      int i = paramString.length();
      boolean bool = false;
      if (i == 0) {
        return false;
      }
      int j = 0;
      for (int k = j; j < paramString.length(); k = i)
      {
        int m = paramString.charAt(j);
        if ((j == 0) && (m != 40)) {
          return false;
        }
        if (m == 40)
        {
          i = k + 1;
        }
        else
        {
          i = k;
          if (m == 41)
          {
            k -= 1;
            i = k;
            if (k == 0)
            {
              i = k;
              if (j != paramString.length() - 1) {
                return false;
              }
            }
          }
        }
        j += 1;
      }
      if (k == 0) {
        bool = true;
      }
      return bool;
    }
    
    public static boolean b(String paramString1, String paramString2)
    {
      if (paramString2 == null) {
        return false;
      }
      if (paramString1.equals(paramString2)) {
        return true;
      }
      if (a(paramString1)) {
        return paramString1.substring(1, paramString1.length() - 1).trim().equals(paramString2);
      }
      return false;
    }
    
    private static int c(String paramString)
    {
      if (paramString == null) {
        return 5;
      }
      paramString = paramString.toUpperCase(Locale.US);
      if (paramString.contains("INT")) {
        return 3;
      }
      if ((!paramString.contains("CHAR")) && (!paramString.contains("CLOB")) && (!paramString.contains("TEXT")))
      {
        if (paramString.contains("BLOB")) {
          return 5;
        }
        if ((!paramString.contains("REAL")) && (!paramString.contains("FLOA")) && (!paramString.contains("DOUB"))) {
          return 1;
        }
        return 4;
      }
      return 2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.e != paramObject.e) {
        return false;
      }
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (this.d != paramObject.d) {
        return false;
      }
      String str;
      if ((this.g == 1) && (paramObject.g == 2))
      {
        str = this.f;
        if ((str != null) && (!b(str, paramObject.f))) {
          return false;
        }
      }
      if ((this.g == 2) && (paramObject.g == 1))
      {
        str = paramObject.f;
        if ((str != null) && (!b(str, this.f))) {
          return false;
        }
      }
      int i = this.g;
      if ((i != 0) && (i == paramObject.g))
      {
        str = this.f;
        if (str != null)
        {
          if (!b(str, paramObject.f)) {
            return false;
          }
        }
        else if (paramObject.f != null) {
          return false;
        }
      }
      return this.c == paramObject.c;
    }
    
    public int hashCode()
    {
      int j = this.a.hashCode();
      int k = this.c;
      int i;
      if (this.d) {
        i = 1231;
      } else {
        i = 1237;
      }
      return ((j * 31 + k) * 31 + i) * 31 + this.e;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Column{name='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", type='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", affinity='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", notNull=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", primaryKeyPosition=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", defaultValue='");
      localStringBuilder.append(this.f);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
  {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final List<String> e;
    
    public b(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = Collections.unmodifiableList(paramList1);
      this.e = Collections.unmodifiableList(paramList2);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      if (!this.c.equals(paramObject.c)) {
        return false;
      }
      if (!this.d.equals(paramObject.d)) {
        return false;
      }
      return this.e.equals(paramObject.e);
    }
    
    public int hashCode()
    {
      return (((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForeignKey{referenceTable='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", onDelete='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", onUpdate='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", columnNames=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", referenceColumnNames=");
      localStringBuilder.append(this.e);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  static class c
    implements Comparable<c>
  {
    final int a;
    final int b;
    final String c;
    final String d;
    
    c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
    }
    
    public int a(c paramc)
    {
      int j = this.a - paramc.a;
      int i = j;
      if (j == 0) {
        i = this.b - paramc.b;
      }
      return i;
    }
  }
  
  public static final class d
  {
    public final String a;
    public final boolean b;
    public final List<String> c;
    public final List<String> d;
    
    public d(String paramString, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    {
      this.a = paramString;
      this.b = paramBoolean;
      this.c = paramList1;
      if (paramList2 != null)
      {
        paramString = paramList2;
        if (paramList2.size() != 0) {}
      }
      else
      {
        paramString = Collections.nCopies(paramList1.size(), h.a.name());
      }
      this.d = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if (this.b != paramObject.b) {
        return false;
      }
      if (!this.c.equals(paramObject.c)) {
        return false;
      }
      if (!this.d.equals(paramObject.d)) {
        return false;
      }
      if (this.a.startsWith("index_")) {
        return paramObject.a.startsWith("index_");
      }
      return this.a.equals(paramObject.a);
    }
    
    public int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index{name='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", unique=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", columns=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", orders=");
      localStringBuilder.append(this.d);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o1.g
 * JD-Core Version:    0.7.0.1
 */