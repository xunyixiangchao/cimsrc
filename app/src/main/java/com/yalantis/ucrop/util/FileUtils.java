package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.Log;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  
  /* Error */
  public static void copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 21	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5: ifeq +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: new 23	java/io/FileInputStream
    //   17: dup
    //   18: new 25	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokevirtual 35	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   32: astore_2
    //   33: aload 4
    //   35: astore_0
    //   36: new 37	java/io/FileOutputStream
    //   39: dup
    //   40: new 25	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 38	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: invokevirtual 39	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: lconst_0
    //   59: aload_2
    //   60: invokevirtual 45	java/nio/channels/FileChannel:size	()J
    //   63: aload_1
    //   64: invokevirtual 49	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   67: pop2
    //   68: aload_1
    //   69: astore_0
    //   70: aload_2
    //   71: invokevirtual 52	java/nio/channels/FileChannel:close	()V
    //   74: aload_2
    //   75: invokevirtual 52	java/nio/channels/FileChannel:close	()V
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 52	java/nio/channels/FileChannel:close	()V
    //   86: return
    //   87: astore_3
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: astore_2
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: astore_2
    //   98: goto +8 -> 106
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: astore_0
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 52	java/nio/channels/FileChannel:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 52	java/nio/channels/FileChannel:close	()V
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString1	String
    //   0	124	1	paramString2	String
    //   32	66	2	localObject1	Object
    //   101	22	2	localObject2	Object
    //   10	1	3	localObject3	Object
    //   87	18	3	localObject4	Object
    //   12	22	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	55	87	finally
    //   57	68	87	finally
    //   70	74	87	finally
    //   14	33	101	finally
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 62	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 17	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 64
    //   16: aastore
    //   17: aload_2
    //   18: aload_3
    //   19: aconst_null
    //   20: invokevirtual 70	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull +43 -> 68
    //   28: aload_0
    //   29: astore_1
    //   30: aload_0
    //   31: invokeinterface 76 1 0
    //   36: ifeq +32 -> 68
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: aload_0
    //   43: ldc 64
    //   45: invokeinterface 80 2 0
    //   50: invokeinterface 84 2 0
    //   55: astore_2
    //   56: aload_0
    //   57: invokeinterface 85 1 0
    //   62: aload_2
    //   63: areturn
    //   64: astore_2
    //   65: goto +25 -> 90
    //   68: aload_0
    //   69: ifnull +55 -> 124
    //   72: aload_0
    //   73: invokeinterface 85 1 0
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aload 4
    //   83: astore_1
    //   84: goto +43 -> 127
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: ldc 8
    //   94: invokestatic 91	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   97: ldc 93
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_2
    //   106: invokevirtual 97	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   109: aastore
    //   110: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokestatic 107	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: aload_0
    //   118: ifnull +6 -> 124
    //   121: goto -49 -> 72
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: aload_1
    //   128: ifnull +9 -> 137
    //   131: aload_1
    //   132: invokeinterface 85 1 0
    //   137: aload_0
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramContext	Context
    //   0	139	1	paramUri	Uri
    //   0	139	2	paramString	String
    //   0	139	3	paramArrayOfString	String[]
    //   1	81	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	39	64	java/lang/IllegalArgumentException
    //   41	56	64	java/lang/IllegalArgumentException
    //   3	24	80	finally
    //   3	24	87	java/lang/IllegalArgumentException
    //   30	39	126	finally
    //   41	56	126	finally
    //   92	117	126	finally
  }
  
  @SuppressLint({"NewApi"})
  public static String getPath(Context paramContext, Uri paramUri)
  {
    boolean bool = DocumentsContract.isDocumentUri(paramContext, paramUri);
    Object localObject = null;
    if (bool)
    {
      if (isExternalStorageDocument(paramUri))
      {
        paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
        if ("primary".equalsIgnoreCase(paramContext[0]))
        {
          paramUri = new StringBuilder();
          paramUri.append(Environment.getExternalStorageDirectory());
          paramUri.append("/");
          paramUri.append(paramContext[1]);
          return paramUri.toString();
        }
      }
      else
      {
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          if (TextUtils.isEmpty(paramUri)) {
            break label274;
          }
          try
          {
            paramContext = getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
            return paramContext;
          }
          catch (NumberFormatException paramContext)
          {
            Log.i("FileUtils", paramContext.getMessage());
            return null;
          }
        }
        if (isMediaDocument(paramUri))
        {
          String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str = arrayOfString[0];
          if ("image".equals(str))
          {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          else if ("video".equals(str))
          {
            paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          }
          else
          {
            paramUri = localObject;
            if ("audio".equals(str)) {
              paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
          }
          return getDataColumn(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
        }
      }
    }
    else
    {
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if (isGooglePhotosUri(paramUri)) {
          return paramUri.getLastPathSegment();
        }
        return getDataColumn(paramContext, paramUri, null, null);
      }
      if ("file".equalsIgnoreCase(paramUri.getScheme())) {
        return paramUri.getPath();
      }
    }
    label274:
    return null;
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isGooglePhotosUri(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */