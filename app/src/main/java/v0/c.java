package v0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p0.e;

class c
{
  private static final Comparator<byte[]> a = new a();
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean b(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static List<List<byte[]>> c(d paramd, Resources paramResources)
  {
    if (paramd.b() != null) {
      return paramd.b();
    }
    return e.c(paramResources, paramd.c());
  }
  
  static f.a d(Context paramContext, d paramd, CancellationSignal paramCancellationSignal)
  {
    ProviderInfo localProviderInfo = e(paramContext.getPackageManager(), paramd, paramContext.getResources());
    if (localProviderInfo == null) {
      return f.a.a(1, null);
    }
    return f.a.a(0, f(paramContext, paramd, localProviderInfo.authority, paramCancellationSignal));
  }
  
  static ProviderInfo e(PackageManager paramPackageManager, d paramd, Resources paramResources)
  {
    String str = paramd.e();
    int i = 0;
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo != null)
    {
      if (localProviderInfo.packageName.equals(paramd.f()))
      {
        paramPackageManager = a(paramPackageManager.getPackageInfo(localProviderInfo.packageName, 64).signatures);
        Collections.sort(paramPackageManager, a);
        paramd = c(paramd, paramResources);
        while (i < paramd.size())
        {
          paramResources = new ArrayList((Collection)paramd.get(i));
          Collections.sort(paramResources, a);
          if (b(paramPackageManager, paramResources)) {
            return localProviderInfo;
          }
          i += 1;
        }
        return null;
      }
      paramPackageManager = new StringBuilder();
      paramPackageManager.append("Found content provider ");
      paramPackageManager.append(str);
      paramPackageManager.append(", but package was not ");
      paramPackageManager.append(paramd.f());
      throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
    }
    paramPackageManager = new StringBuilder();
    paramPackageManager.append("No package found for authority: ");
    paramPackageManager.append(str);
    throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
  }
  
  static f.b[] f(Context paramContext, d paramd, String paramString, CancellationSignal paramCancellationSignal)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    Object localObject = null;
    paramString = localObject;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getContentResolver();
        paramString = localObject;
        paramd = paramd.g();
        paramString = localObject;
        paramd = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramd }, null, paramCancellationSignal);
        paramContext = localArrayList;
        if (paramd != null)
        {
          paramContext = localArrayList;
          paramString = paramd;
          if (paramd.getCount() > 0)
          {
            paramString = paramd;
            int m = paramd.getColumnIndex("result_code");
            paramString = paramd;
            paramCancellationSignal = new ArrayList();
            paramString = paramd;
            int n = paramd.getColumnIndex("_id");
            paramString = paramd;
            int i1 = paramd.getColumnIndex("file_id");
            paramString = paramd;
            int i2 = paramd.getColumnIndex("font_ttc_index");
            paramString = paramd;
            int i3 = paramd.getColumnIndex("font_weight");
            paramString = paramd;
            int i4 = paramd.getColumnIndex("font_italic");
            paramString = paramd;
            if (paramd.moveToNext())
            {
              if (m == -1) {
                break label441;
              }
              paramString = paramd;
              i = paramd.getInt(m);
              if (i2 == -1) {
                break label447;
              }
              paramString = paramd;
              j = paramd.getInt(i2);
              if (i1 == -1)
              {
                paramString = paramd;
                paramContext = ContentUris.withAppendedId(localUri1, paramd.getLong(n));
              }
              else
              {
                paramString = paramd;
                paramContext = ContentUris.withAppendedId(localUri2, paramd.getLong(i1));
              }
              if (i3 == -1) {
                break label453;
              }
              paramString = paramd;
              k = paramd.getInt(i3);
              if (i4 == -1) {
                break label461;
              }
              paramString = paramd;
              if (paramd.getInt(i4) != 1) {
                break label461;
              }
              bool = true;
              paramString = paramd;
              paramCancellationSignal.add(f.b.a(paramContext, j, k, bool, i));
              continue;
            }
            paramContext = paramCancellationSignal;
          }
        }
        return (f.b[])paramContext.toArray(new f.b[0]);
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
      label441:
      int i = 0;
      continue;
      label447:
      int j = 0;
      continue;
      label453:
      int k = 400;
      continue;
      label461:
      boolean bool = false;
    }
  }
  
  class a
    implements Comparator<byte[]>
  {
    public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      int j;
      if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      {
        i = paramArrayOfByte1.length;
        j = paramArrayOfByte2.length;
        return i - j;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfByte1.length) {
          break label63;
        }
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
        {
          j = paramArrayOfByte1[i];
          int k = paramArrayOfByte2[i];
          i = j;
          j = k;
          break;
        }
        i += 1;
      }
      label63:
      return 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.c
 * JD-Core Version:    0.7.0.1
 */