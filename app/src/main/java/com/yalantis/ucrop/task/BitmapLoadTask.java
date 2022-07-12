package com.yalantis.ucrop.task;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadTask
  extends AsyncTask<Void, Void, BitmapWorkerResult>
{
  private static final int MAX_BITMAP_SIZE = 104857600;
  private static final String TAG = "BitmapWorkerTask";
  private final BitmapLoadCallback mBitmapLoadCallback;
  private final Context mContext;
  private Uri mInputUri;
  private Uri mOutputUri;
  private final int mRequiredHeight;
  private final int mRequiredWidth;
  
  public BitmapLoadTask(Context paramContext, Uri paramUri1, Uri paramUri2, int paramInt1, int paramInt2, BitmapLoadCallback paramBitmapLoadCallback)
  {
    this.mContext = paramContext;
    this.mInputUri = paramUri1;
    this.mOutputUri = paramUri2;
    this.mRequiredWidth = paramInt1;
    this.mRequiredHeight = paramInt2;
    this.mBitmapLoadCallback = paramBitmapLoadCallback;
  }
  
  private boolean checkSize(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i;
    if (paramBitmap != null) {
      i = paramBitmap.getByteCount();
    } else {
      i = 0;
    }
    if (i > 104857600)
    {
      paramOptions.inSampleSize *= 2;
      return true;
    }
    return false;
  }
  
  /* Error */
  private void copyFile(Uri paramUri1, Uri paramUri2)
  {
    // Byte code:
    //   0: ldc 15
    //   2: ldc 58
    //   4: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_2
    //   9: ldc 66
    //   11: invokestatic 72	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   14: pop
    //   15: aconst_null
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 31	com/yalantis/ucrop/task/BitmapLoadTask:mContext	Landroid/content/Context;
    //   22: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: aload_1
    //   26: invokevirtual 84	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: new 86	java/io/FileOutputStream
    //   34: dup
    //   35: new 88	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: invokevirtual 94	android/net/Uri:getPath	()Ljava/lang/String;
    //   43: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore_2
    //   50: aload 4
    //   52: ifnull +52 -> 104
    //   55: sipush 1024
    //   58: newarray byte
    //   60: astore_1
    //   61: aload 4
    //   63: aload_1
    //   64: invokevirtual 106	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: ifle +13 -> 82
    //   72: aload_2
    //   73: aload_1
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 112	java/io/OutputStream:write	([BII)V
    //   79: goto -18 -> 61
    //   82: aload_2
    //   83: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   86: aload 4
    //   88: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 35	com/yalantis/ucrop/task/BitmapLoadTask:mOutputUri	Landroid/net/Uri;
    //   96: putfield 33	com/yalantis/ucrop/task/BitmapLoadTask:mInputUri	Landroid/net/Uri;
    //   99: return
    //   100: astore_1
    //   101: goto +27 -> 128
    //   104: new 120	java/lang/NullPointerException
    //   107: dup
    //   108: ldc 122
    //   110: invokespecial 123	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_1
    //   115: aload 5
    //   117: astore_2
    //   118: goto +10 -> 128
    //   121: astore_1
    //   122: aconst_null
    //   123: astore 4
    //   125: aload 5
    //   127: astore_2
    //   128: aload_2
    //   129: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   132: aload 4
    //   134: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 35	com/yalantis/ucrop/task/BitmapLoadTask:mOutputUri	Landroid/net/Uri;
    //   142: putfield 33	com/yalantis/ucrop/task/BitmapLoadTask:mInputUri	Landroid/net/Uri;
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	BitmapLoadTask
    //   0	147	1	paramUri1	Uri
    //   0	147	2	paramUri2	Uri
    //   67	9	3	i	int
    //   29	104	4	localInputStream	InputStream
    //   16	110	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	61	100	finally
    //   61	68	100	finally
    //   72	79	100	finally
    //   104	114	100	finally
    //   31	50	114	finally
    //   18	31	121	finally
  }
  
  /* Error */
  private void downloadFile(Uri paramUri1, Uri paramUri2)
  {
    // Byte code:
    //   0: ldc 15
    //   2: ldc 125
    //   4: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_2
    //   9: ldc 127
    //   11: invokestatic 72	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   14: pop
    //   15: getstatic 133	com/yalantis/ucrop/UCropHttpClientStore:INSTANCE	Lcom/yalantis/ucrop/UCropHttpClientStore;
    //   18: invokevirtual 137	com/yalantis/ucrop/UCropHttpClientStore:getClient	()Ll9/b0;
    //   21: astore 7
    //   23: aconst_null
    //   24: astore 4
    //   26: aconst_null
    //   27: astore 6
    //   29: aload 7
    //   31: new 139	l9/d0$a
    //   34: dup
    //   35: invokespecial 140	l9/d0$a:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 143	android/net/Uri:toString	()Ljava/lang/String;
    //   42: invokevirtual 147	l9/d0$a:o	(Ljava/lang/String;)Ll9/d0$a;
    //   45: invokevirtual 151	l9/d0$a:b	()Ll9/d0;
    //   48: invokevirtual 157	l9/b0:a	(Ll9/d0;)Ll9/e;
    //   51: invokeinterface 163 1 0
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual 168	l9/f0:a	()Ll9/g0;
    //   61: invokevirtual 174	l9/g0:e0	()Laa/d;
    //   64: astore 5
    //   66: aload 6
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 31	com/yalantis/ucrop/task/BitmapLoadTask:mContext	Landroid/content/Context;
    //   73: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   76: aload_2
    //   77: invokevirtual 178	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +55 -> 137
    //   85: aload 6
    //   87: astore_1
    //   88: aload_2
    //   89: invokestatic 183	aa/l:d	(Ljava/io/OutputStream;)Laa/v;
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: aload 5
    //   97: aload_2
    //   98: invokeinterface 189 2 0
    //   103: pop2
    //   104: aload 5
    //   106: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   109: aload_2
    //   110: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   113: aload_3
    //   114: invokevirtual 168	l9/f0:a	()Ll9/g0;
    //   117: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   120: aload 7
    //   122: invokevirtual 192	l9/b0:o	()Ll9/r;
    //   125: invokevirtual 196	l9/r:a	()V
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 35	com/yalantis/ucrop/task/BitmapLoadTask:mOutputUri	Landroid/net/Uri;
    //   133: putfield 33	com/yalantis/ucrop/task/BitmapLoadTask:mInputUri	Landroid/net/Uri;
    //   136: return
    //   137: aload 6
    //   139: astore_1
    //   140: new 120	java/lang/NullPointerException
    //   143: dup
    //   144: ldc 198
    //   146: invokespecial 123	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   149: athrow
    //   150: astore 6
    //   152: aload_1
    //   153: astore_2
    //   154: aload 5
    //   156: astore 4
    //   158: aload_3
    //   159: astore_1
    //   160: aload 6
    //   162: astore_3
    //   163: goto +20 -> 183
    //   166: astore 5
    //   168: aload_3
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 5
    //   174: astore_3
    //   175: goto +8 -> 183
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: astore_1
    //   183: aload 4
    //   185: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   188: aload_2
    //   189: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   192: aload_1
    //   193: ifnull +10 -> 203
    //   196: aload_1
    //   197: invokevirtual 168	l9/f0:a	()Ll9/g0;
    //   200: invokestatic 118	com/yalantis/ucrop/util/BitmapLoadUtils:close	(Ljava/io/Closeable;)V
    //   203: aload 7
    //   205: invokevirtual 192	l9/b0:o	()Ll9/r;
    //   208: invokevirtual 196	l9/r:a	()V
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 35	com/yalantis/ucrop/task/BitmapLoadTask:mOutputUri	Landroid/net/Uri;
    //   216: putfield 33	com/yalantis/ucrop/task/BitmapLoadTask:mInputUri	Landroid/net/Uri;
    //   219: aload_3
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	BitmapLoadTask
    //   0	221	1	paramUri1	Uri
    //   0	221	2	paramUri2	Uri
    //   56	119	3	localObject1	Object
    //   178	42	3	localObject2	Object
    //   24	160	4	localObject3	Object
    //   64	91	5	locald	aa.d
    //   166	7	5	localObject4	Object
    //   27	111	6	localObject5	Object
    //   150	11	6	localObject6	Object
    //   21	183	7	localb0	l9.b0
    // Exception table:
    //   from	to	target	type
    //   69	81	150	finally
    //   88	93	150	finally
    //   95	104	150	finally
    //   140	150	150	finally
    //   57	66	166	finally
    //   29	57	178	finally
  }
  
  private void processInputUri()
  {
    String str = this.mInputUri.getScheme();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Uri scheme: ");
    localStringBuilder.append(str);
    Log.d("BitmapWorkerTask", localStringBuilder.toString());
    if ((!"http".equals(str)) && (!"https".equals(str)))
    {
      if ("content".equals(str))
      {
        try
        {
          copyFile(this.mInputUri, this.mOutputUri);
          return;
        }
        catch (IOException localIOException1) {}catch (NullPointerException localNullPointerException1) {}
        Log.e("BitmapWorkerTask", "Copying failed", localNullPointerException1);
        throw localNullPointerException1;
      }
      if ("file".equals(localNullPointerException1)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid Uri scheme ");
      localStringBuilder.append(localNullPointerException1);
      Log.e("BitmapWorkerTask", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid Uri scheme");
      localStringBuilder.append(localNullPointerException1);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    try
    {
      downloadFile(this.mInputUri, this.mOutputUri);
      return;
    }
    catch (IOException localIOException2) {}catch (NullPointerException localNullPointerException2) {}
    Log.e("BitmapWorkerTask", "Downloading failed", localNullPointerException2);
    throw localNullPointerException2;
  }
  
  protected BitmapWorkerResult doInBackground(Void... paramVarArgs)
  {
    if (this.mInputUri == null) {
      return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
    }
    try
    {
      processInputUri();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = BitmapLoadUtils.calculateInSampleSize(localOptions, this.mRequiredWidth, this.mRequiredHeight);
      int i = 0;
      localOptions.inJustDecodeBounds = false;
      paramVarArgs = null;
      for (;;)
      {
        if (i == 0)
        {
          localObject1 = paramVarArgs;
          try
          {
            InputStream localInputStream = this.mContext.getContentResolver().openInputStream(this.mInputUri);
            try
            {
              Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, localOptions);
              paramVarArgs = localBitmap;
              if (localOptions.outWidth != -1)
              {
                paramVarArgs = localBitmap;
                j = localOptions.outHeight;
                if (j != -1)
                {
                  localObject1 = localBitmap;
                  BitmapLoadUtils.close(localInputStream);
                  localObject1 = localBitmap;
                  boolean bool = checkSize(localBitmap, localOptions);
                  if (bool)
                  {
                    paramVarArgs = localBitmap;
                    continue;
                  }
                  i = 1;
                  paramVarArgs = localBitmap;
                  continue;
                }
              }
              paramVarArgs = localBitmap;
              localObject1 = new StringBuilder();
              paramVarArgs = localBitmap;
              ((StringBuilder)localObject1).append("Bounds for bitmap could not be retrieved from the Uri: [");
              paramVarArgs = localBitmap;
              ((StringBuilder)localObject1).append(this.mInputUri);
              paramVarArgs = localBitmap;
              ((StringBuilder)localObject1).append("]");
              paramVarArgs = localBitmap;
              BitmapWorkerResult localBitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException(((StringBuilder)localObject1).toString()));
              localObject1 = localBitmap;
              BitmapLoadUtils.close(localInputStream);
              return localBitmapWorkerResult;
            }
            finally
            {
              localObject1 = paramVarArgs;
              BitmapLoadUtils.close(localInputStream);
              localObject1 = paramVarArgs;
            }
          }
          catch (IOException paramVarArgs)
          {
            Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", paramVarArgs);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Bitmap could not be decoded from the Uri: [");
            ((StringBuilder)localObject1).append(this.mInputUri);
            ((StringBuilder)localObject1).append("]");
            return new BitmapWorkerResult(new IllegalArgumentException(((StringBuilder)localObject1).toString(), paramVarArgs));
          }
          catch (OutOfMemoryError paramVarArgs)
          {
            Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", paramVarArgs);
            localOptions.inSampleSize *= 2;
            paramVarArgs = (Void[])localObject1;
          }
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Bitmap could not be decoded from the Uri: [");
        paramVarArgs.append(this.mInputUri);
        paramVarArgs.append("]");
        return new BitmapWorkerResult(new IllegalArgumentException(paramVarArgs.toString()));
      }
      i = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
      int j = BitmapLoadUtils.exifToDegrees(i);
      int k = BitmapLoadUtils.exifToTranslation(i);
      Object localObject1 = new ExifInfo(i, j, k);
      Matrix localMatrix = new Matrix();
      if (j != 0) {
        localMatrix.preRotate(j);
      }
      if (k != 1) {
        localMatrix.postScale(k, 1.0F);
      }
      if (!localMatrix.isIdentity()) {
        return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(paramVarArgs, localMatrix), (ExifInfo)localObject1);
      }
      return new BitmapWorkerResult(paramVarArgs, (ExifInfo)localObject1);
    }
    catch (IOException paramVarArgs) {}catch (NullPointerException paramVarArgs) {}
    return new BitmapWorkerResult(paramVarArgs);
  }
  
  protected void onPostExecute(BitmapWorkerResult paramBitmapWorkerResult)
  {
    Object localObject = paramBitmapWorkerResult.mBitmapWorkerException;
    if (localObject == null)
    {
      localObject = this.mBitmapLoadCallback;
      Bitmap localBitmap = paramBitmapWorkerResult.mBitmapResult;
      ExifInfo localExifInfo = paramBitmapWorkerResult.mExifInfo;
      String str = this.mInputUri.getPath();
      paramBitmapWorkerResult = this.mOutputUri;
      if (paramBitmapWorkerResult == null) {
        paramBitmapWorkerResult = null;
      } else {
        paramBitmapWorkerResult = paramBitmapWorkerResult.getPath();
      }
      ((BitmapLoadCallback)localObject).onBitmapLoaded(localBitmap, localExifInfo, str, paramBitmapWorkerResult);
      return;
    }
    this.mBitmapLoadCallback.onFailure((Exception)localObject);
  }
  
  public static class BitmapWorkerResult
  {
    Bitmap mBitmapResult;
    Exception mBitmapWorkerException;
    ExifInfo mExifInfo;
    
    public BitmapWorkerResult(Bitmap paramBitmap, ExifInfo paramExifInfo)
    {
      this.mBitmapResult = paramBitmap;
      this.mExifInfo = paramExifInfo;
    }
    
    public BitmapWorkerResult(Exception paramException)
    {
      this.mBitmapWorkerException = paramException;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.task.BitmapLoadTask
 * JD-Core Version:    0.7.0.1
 */