package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class z
{
  private StringBuilder a;
  private int b;
  
  public z(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  public static long a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      y.d("File name is null.", new Object[0]);
      return -1L;
    }
    try
    {
      if ((paramString1.startsWith(paramString2)) && (paramString1.endsWith(paramString3)))
      {
        long l = Long.parseLong(paramString1.substring(paramString2.length(), paramString1.indexOf(paramString3)));
        return l;
      }
    }
    finally
    {
      y.a(paramString1);
    }
    return -1L;
  }
  
  private static List<File> a(String paramString1, String paramString2, final String paramString3, long paramLong, boolean paramBoolean, Comparator<File> paramComparator)
  {
    paramComparator = new ArrayList();
    if ((paramString2 != null) && (paramString3 != null))
    {
      long l = System.currentTimeMillis();
      paramString1 = new File(paramString1);
      if ((paramString1.exists()) && (paramString1.isDirectory())) {
        try
        {
          paramString1 = paramString1.listFiles(new a(paramString2, paramString3));
          if (paramString1 != null)
          {
            if (paramString1.length == 0) {
              return paramComparator;
            }
            paramString1 = a(paramString1, paramString2, paramString3, 0L, l - paramLong);
            return paramString1;
          }
          return paramComparator;
        }
        finally
        {
          y.a(paramString1);
        }
      }
      return paramComparator;
    }
    y.d("prefix %s and/or postfix %s is null.", new Object[] { paramString2, paramString3 });
    return paramComparator;
  }
  
  private static List<File> a(File[] paramArrayOfFile, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      long l = a(localFile.getName(), paramString1, paramString2);
      if ((l >= 0L) && (paramLong1 <= l) && (l <= paramLong2)) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null)
    {
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = a(paramString1, paramString2, paramString3, paramLong, false, null);
    try
    {
      paramString1 = paramString1.iterator();
      int i = 0;
      while (paramString1.hasNext())
      {
        paramString2 = (File)paramString1.next();
        y.c("File %s is to be deleted.", new Object[] { paramString2.getName() });
        if (paramString2.delete()) {
          i += 1;
        }
      }
      paramString1 = new StringBuilder("Number of overdue trace files that has deleted: ");
      paramString1.append(i);
      return;
    }
    finally
    {
      y.a(paramString1);
    }
  }
  
  public static boolean a(File paramFile, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(paramFile, paramBoolean));
      long l = paramFile.length();
      paramBoolean = a(localBufferedWriter, paramString.toCharArray(), paramString.length(), l, paramLong);
      localBufferedWriter.close();
      return paramBoolean;
    }
    finally
    {
      y.a(paramFile);
    }
    return false;
  }
  
  private static boolean a(Writer paramWriter, char[] paramArrayOfChar, int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong1 >= paramLong2) {
      return false;
    }
    if ((paramInt << 1) + paramLong1 <= paramLong2) {}
    try
    {
      paramWriter.write(paramArrayOfChar, 0, paramInt);
      break label46;
      paramWriter.write(paramArrayOfChar, 0, (int)((paramLong2 - paramLong1) / 2L));
      label46:
      paramWriter.flush();
      return true;
    }
    catch (IOException paramWriter)
    {
      y.a(paramWriter);
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    y.c("rqdp{  sv sd start} %s", new Object[] { paramString1 });
    if (paramString2 != null)
    {
      if (paramString2.trim().length() <= 0) {
        return false;
      }
      paramString1 = new File(paramString1);
    }
    for (;;)
    {
      try
      {
        if (!paramString1.exists())
        {
          if (paramString1.getParentFile() != null) {
            paramString1.getParentFile().mkdirs();
          }
          paramString1.createNewFile();
        }
        long l = paramInt;
        if (paramString1.length() >= l) {
          break label110;
        }
        bool = a(paramString1, paramString2, l, bool);
        return bool;
      }
      finally
      {
        if (!y.a(paramString1)) {
          paramString1.printStackTrace();
        }
      }
      return false;
      label110:
      bool = false;
    }
  }
  
  public z a(byte paramByte, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramByte);
    paramString.append('\n');
    return this;
  }
  
  public z a(char paramChar, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramChar);
    paramString.append('\n');
    return this;
  }
  
  public z a(double paramDouble, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramDouble);
    paramString.append('\n');
    return this;
  }
  
  public z a(float paramFloat, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramFloat);
    paramString.append('\n');
    return this;
  }
  
  public z a(int paramInt, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramInt);
    paramString.append('\n');
    return this;
  }
  
  public z a(long paramLong, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramLong);
    paramString.append('\n');
    return this;
  }
  
  public z a(j paramj, String paramString)
  {
    a('{', paramString);
    if (paramj == null)
    {
      paramj = this.a;
      paramj.append('\t');
      paramj.append("null");
    }
    else
    {
      paramj.a(this.a, this.b + 1);
    }
    a('}', null);
    return this;
  }
  
  public <T> z a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof j))
    {
      a((j)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new b("write object error: unsupport type.");
  }
  
  public z a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    paramString2 = this.a;
    paramString2.append(paramString1);
    paramString2.append('\n');
    return this;
  }
  
  public <T> z a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public <K, V> z a(Map<K, V> paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      paramString = this.a;
      paramString.append(paramMap.size());
      paramString.append(", {}\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramMap.size());
    paramString.append(", {\n");
    paramString = new z(this.a, this.b + 1);
    z localz = new z(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localz.a(localEntry.getKey(), null);
      localz.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public z a(short paramShort, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramShort);
    paramString.append('\n');
    return this;
  }
  
  public z a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    char c;
    if (paramBoolean) {
      c = 'T';
    } else {
      c = 'F';
    }
    paramString.append(c);
    paramString.append('\n');
    return this;
  }
  
  public z a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfByte.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfByte.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public z a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfDouble.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfDouble.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public z a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfFloat.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfFloat.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public z a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfInt.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfInt.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public z a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfLong.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfLong.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public <T> z a(T[] paramArrayOfT, String paramString)
  {
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfT.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfT.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public z a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfShort.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfShort.length);
    paramString.append(", [\n");
    paramString = new z(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  static final class a
    implements FilenameFilter
  {
    a(String paramString1, String paramString2) {}
    
    public final boolean accept(File paramFile, String paramString)
    {
      boolean bool2 = false;
      if (paramString == null) {
        return false;
      }
      boolean bool1 = bool2;
      if (paramString.startsWith(this.a))
      {
        bool1 = bool2;
        if (paramString.endsWith(paramString3)) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.z
 * JD-Core Version:    0.7.0.1
 */