package k2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import e2.d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class z
{
  private static final Paint a = new Paint(6);
  private static final Paint b = new Paint(7);
  private static final Paint c;
  private static final Set<String> d;
  private static final Lock e;
  
  static
  {
    Object localObject = new HashSet(Arrays.asList(new String[] { "XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079" }));
    d = (Set)localObject;
    if (((Set)localObject).contains(Build.MODEL)) {
      localObject = new ReentrantLock();
    } else {
      localObject = new a();
    }
    e = (Lock)localObject;
    localObject = new Paint(7);
    c = (Paint)localObject;
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  private static void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Matrix paramMatrix)
  {
    Lock localLock = e;
    localLock.lock();
    try
    {
      paramBitmap2 = new Canvas(paramBitmap2);
      paramBitmap2.drawBitmap(paramBitmap1, paramMatrix, a);
      d(paramBitmap2);
      localLock.unlock();
      return;
    }
    finally
    {
      e.unlock();
    }
  }
  
  public static Bitmap b(d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3 = 0.0F;
    float f1;
    float f2;
    if (i * paramInt2 > j * paramInt1)
    {
      f1 = paramInt2 / paramBitmap.getHeight();
      f3 = (paramInt1 - paramBitmap.getWidth() * f1) * 0.5F;
      f2 = 0.0F;
    }
    else
    {
      f1 = paramInt1 / paramBitmap.getWidth();
      f2 = (paramInt2 - paramBitmap.getHeight() * f1) * 0.5F;
    }
    localMatrix.setScale(f1, f1);
    localMatrix.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
    paramd = paramd.c(paramInt1, paramInt2, h(paramBitmap));
    l(paramBitmap, paramd);
    a(paramBitmap, paramd, localMatrix);
    return paramd;
  }
  
  public static Bitmap c(d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() <= paramInt1) && (paramBitmap.getHeight() <= paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
      }
      return paramBitmap;
    }
    if (Log.isLoggable("TransformationUtils", 2)) {
      Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
    }
    return e(paramd, paramBitmap, paramInt1, paramInt2);
  }
  
  private static void d(Canvas paramCanvas)
  {
    paramCanvas.setBitmap(null);
  }
  
  public static Bitmap e(d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size matches input, returning input");
      }
      return paramBitmap;
    }
    float f = Math.min(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    if ((paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "adjusted target size matches input, returning input");
      }
      return paramBitmap;
    }
    paramd = paramd.c((int)(paramBitmap.getWidth() * f), (int)(paramBitmap.getHeight() * f), h(paramBitmap));
    l(paramBitmap, paramd);
    if (Log.isLoggable("TransformationUtils", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toFit:   ");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramBitmap.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toReuse: ");
      ((StringBuilder)localObject).append(paramd.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramd.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minPct:   ");
      ((StringBuilder)localObject).append(f);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f, f);
    a(paramBitmap, paramd, (Matrix)localObject);
    return paramd;
  }
  
  public static Lock f()
  {
    return e;
  }
  
  public static int g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
    case 8: 
      return 270;
    case 5: 
    case 6: 
      return 90;
    }
    return 180;
  }
  
  private static Bitmap.Config h(Bitmap paramBitmap)
  {
    if (paramBitmap.getConfig() != null) {
      return paramBitmap.getConfig();
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  static void i(int paramInt, Matrix paramMatrix)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      paramMatrix.setRotate(-90.0F);
      return;
    case 7: 
      paramMatrix.setRotate(-90.0F);
      break;
    case 6: 
      paramMatrix.setRotate(90.0F);
      return;
    case 5: 
      paramMatrix.setRotate(90.0F);
      break;
    case 4: 
      paramMatrix.setRotate(180.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 3: 
      paramMatrix.setRotate(180.0F);
      return;
    }
    paramMatrix.setScale(-1.0F, 1.0F);
  }
  
  public static boolean j(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static Bitmap k(d paramd, Bitmap paramBitmap, int paramInt)
  {
    if (!j(paramInt)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    i(paramInt, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    localMatrix.mapRect(localRectF);
    paramd = paramd.c(Math.round(localRectF.width()), Math.round(localRectF.height()), h(paramBitmap));
    localMatrix.postTranslate(-localRectF.left, -localRectF.top);
    paramd.setHasAlpha(paramBitmap.hasAlpha());
    a(paramBitmap, paramd, localMatrix);
    return paramd;
  }
  
  public static void l(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
  }
  
  private static final class a
    implements Lock
  {
    public void lock() {}
    
    public void lockInterruptibly() {}
    
    public Condition newCondition()
    {
      throw new UnsupportedOperationException("Should not be called");
    }
    
    public boolean tryLock()
    {
      return true;
    }
    
    public boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
    {
      return true;
    }
    
    public void unlock() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.z
 * JD-Core Version:    0.7.0.1
 */