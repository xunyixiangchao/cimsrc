package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] b = { "_display_name", "_size" };
  private static final File c = new File("/");
  private static HashMap<String, a> d = new HashMap();
  private a a;
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  private static Object[] b(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] c(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a d(Context paramContext, String paramString)
  {
    synchronized (d)
    {
      a locala2 = (a)d.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        try
        {
          locala1 = g(paramContext, paramString);
          d.put(paramString, locala1);
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        catch (IOException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
      }
      return locala1;
    }
  }
  
  public static Uri e(Context paramContext, String paramString, File paramFile)
  {
    return d(paramContext, paramString).b(paramFile);
  }
  
  private static int f(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mode: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 738197504;
  }
  
  private static a g(Context paramContext, String paramString)
  {
    b localb = new b(paramString);
    ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (localProviderInfo != null)
    {
      XmlResourceParser localXmlResourceParser = localProviderInfo.loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
      if (localXmlResourceParser != null)
      {
        for (;;)
        {
          int i = localXmlResourceParser.next();
          if (i == 1) {
            break;
          }
          if (i == 2)
          {
            Object localObject = localXmlResourceParser.getName();
            localProviderInfo = null;
            String str1 = localXmlResourceParser.getAttributeValue(null, "name");
            String str2 = localXmlResourceParser.getAttributeValue(null, "path");
            if ("root-path".equals(localObject))
            {
              paramString = c;
            }
            else if ("files-path".equals(localObject))
            {
              paramString = paramContext.getFilesDir();
            }
            else if ("cache-path".equals(localObject))
            {
              paramString = paramContext.getCacheDir();
            }
            else if ("external-path".equals(localObject))
            {
              paramString = Environment.getExternalStorageDirectory();
            }
            else if ("external-files-path".equals(localObject))
            {
              localObject = b.f(paramContext, null);
              paramString = localProviderInfo;
              if (localObject.length > 0) {
                paramString = localObject[0];
              }
            }
            else if ("external-cache-path".equals(localObject))
            {
              localObject = b.e(paramContext);
              paramString = localProviderInfo;
              if (localObject.length > 0) {
                paramString = localObject[0];
              }
            }
            else
            {
              paramString = localProviderInfo;
              if ("external-media-path".equals(localObject))
              {
                localObject = paramContext.getExternalMediaDirs();
                paramString = localProviderInfo;
                if (localObject.length > 0) {
                  paramString = localObject[0];
                }
              }
            }
            if (paramString != null) {
              localb.c(str1, a(paramString, new String[] { str2 }));
            }
          }
        }
        return localb;
      }
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    paramContext = new StringBuilder();
    paramContext.append("Couldn't find meta-data for provider with authority ");
    paramContext.append(paramString);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.a = d(paramContext, paramProviderInfo.authority.split(";")[0]);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.a.a(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  @SuppressLint({"UnknownNullness"})
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.a.a(paramUri), f(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramArrayOfString2 = this.a.a(paramUri);
    paramString1 = paramUri.getQueryParameter("displayName");
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = b;
    }
    String[] arrayOfString = new String[paramUri.length];
    paramString2 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      paramArrayOfString1 = paramUri[j];
      if ("_display_name".equals(paramArrayOfString1))
      {
        arrayOfString[i] = "_display_name";
        k = i + 1;
        if (paramString1 == null) {
          paramArrayOfString1 = paramArrayOfString2.getName();
        } else {
          paramArrayOfString1 = paramString1;
        }
        paramString2[i] = paramArrayOfString1;
        i = k;
      }
      else
      {
        k = i;
        if (!"_size".equals(paramArrayOfString1)) {
          break label163;
        }
        arrayOfString[i] = "_size";
        k = i + 1;
        paramString2[i] = Long.valueOf(paramArrayOfString2.length());
        i = k;
      }
      k = i;
      label163:
      j += 1;
    }
    paramUri = c(arrayOfString, i);
    paramArrayOfString1 = b(paramString2, i);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramArrayOfString1);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface a
  {
    public abstract File a(Uri paramUri);
    
    public abstract Uri b(File paramFile);
  }
  
  static class b
    implements FileProvider.a
  {
    private final String a;
    private final HashMap<String, File> b = new HashMap();
    
    b(String paramString)
    {
      this.a = paramString;
    }
    
    public File a(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)this.b.get(localObject1);
      if (localObject1 != null) {
        paramUri = new File((File)localObject1, (String)localObject2);
      }
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          return localObject2;
        }
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
      catch (IOException localIOException)
      {
        label100:
        break label100;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
      ((StringBuilder)localObject1).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unable to find configured root for ");
      ((StringBuilder)localObject1).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    
    public Uri b(File paramFile)
    {
      try
      {
        Object localObject2 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          String str = ((File)((Map.Entry)localObject1).getValue()).getPath();
          if ((((String)localObject2).startsWith(str)) && ((paramFile == null) || (str.length() > ((File)paramFile.getValue()).getPath().length()))) {
            paramFile = (File)localObject1;
          }
        }
        if (paramFile != null)
        {
          localObject1 = ((File)paramFile.getValue()).getPath();
          boolean bool = ((String)localObject1).endsWith("/");
          int i = ((String)localObject1).length();
          if (!bool) {
            i += 1;
          }
          localObject1 = ((String)localObject2).substring(i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Uri.encode((String)paramFile.getKey()));
          ((StringBuilder)localObject2).append('/');
          ((StringBuilder)localObject2).append(Uri.encode((String)localObject1, "/"));
          paramFile = ((StringBuilder)localObject2).toString();
          return new Uri.Builder().scheme("content").authority(this.a).encodedPath(paramFile).build();
        }
        paramFile = new StringBuilder();
        paramFile.append("Failed to find configured root that contains ");
        paramFile.append((String)localObject2);
        throw new IllegalArgumentException(paramFile.toString());
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        label268:
        break label268;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
      ((StringBuilder)localObject1).append(paramFile);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    
    void c(String paramString, File paramFile)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          localObject = paramFile.getCanonicalFile();
          this.b.put(paramString, localObject);
          return;
        }
        catch (IOException paramString)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to resolve canonical path for ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramString);
        }
      }
      throw new IllegalArgumentException("Name must not be empty");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */