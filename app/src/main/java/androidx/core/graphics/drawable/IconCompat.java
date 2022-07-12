package androidx.core.graphics.drawable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat
  extends CustomVersionedParcelable
{
  static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
  public int a;
  Object b;
  public byte[] c;
  public Parcelable d;
  public int e;
  public int f;
  public ColorStateList g;
  PorterDuff.Mode h;
  public String i;
  public String j;
  
  public IconCompat()
  {
    this.a = -1;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = null;
    this.h = k;
    this.i = null;
  }
  
  private IconCompat(int paramInt)
  {
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = null;
    this.h = k;
    this.i = null;
    this.a = paramInt;
  }
  
  static Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int m = (int)(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.6666667F);
    Bitmap localBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f1 = m;
    float f2 = 0.5F * f1;
    float f3 = 0.9166667F * f2;
    if (paramBoolean)
    {
      float f4 = 0.01041667F * f1;
      localPaint.setColor(0);
      localPaint.setShadowLayer(f4, 0.0F, f1 * 0.02083333F, 1023410176);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.setShadowLayer(f4, 0.0F, 0.0F, 503316480);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.clearShadowLayer();
    }
    localPaint.setColor(-16777216);
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new BitmapShader(paramBitmap, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - m) / 2, -(paramBitmap.getHeight() - m) / 2);
    ((BitmapShader)localObject).setLocalMatrix(localMatrix);
    localPaint.setShader((Shader)localObject);
    localCanvas.drawCircle(f2, f2, f3, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  public static IconCompat b(Resources paramResources, String paramString, int paramInt)
  {
    IconCompat localIconCompat;
    if (paramString != null) {
      if (paramInt != 0)
      {
        localIconCompat = new IconCompat(2);
        localIconCompat.e = paramInt;
        if (paramResources == null) {}
      }
    }
    try
    {
      localIconCompat.b = paramResources.getResourceName(paramInt);
    }
    catch (Resources.NotFoundException paramResources)
    {
      label38:
      break label38;
    }
    throw new IllegalArgumentException("Icon resource cannot be found");
    localIconCompat.b = paramString;
    localIconCompat.j = paramString;
    return localIconCompat;
    throw new IllegalArgumentException("Drawable resource ID must not be 0");
    throw new IllegalArgumentException("Package must not be null.");
  }
  
  private static int d(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResId();
    }
    try
    {
      int m = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return m;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
      return 0;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
    }
    return 0;
  }
  
  private static String f(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResPackage();
    }
    try
    {
      paramIcon = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      return paramIcon;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
      return null;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
    }
    return null;
  }
  
  private static Uri h(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getUri();
    }
    try
    {
      paramIcon = (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
      return paramIcon;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
      return null;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
    }
    return null;
  }
  
  private static String n(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 6: 
      return "URI_MASKABLE";
    case 5: 
      return "BITMAP_MASKABLE";
    case 4: 
      return "URI";
    case 3: 
      return "DATA";
    case 2: 
      return "RESOURCE";
    }
    return "BITMAP";
  }
  
  public int c()
  {
    int m = this.a;
    if (m == -1) {
      return d((Icon)this.b);
    }
    if (m == 2) {
      return this.e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("called getResId() on ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String e()
  {
    int m = this.a;
    if (m == -1) {
      return f((Icon)this.b);
    }
    if (m == 2)
    {
      if (TextUtils.isEmpty(this.j)) {
        return ((String)this.b).split(":", -1)[0];
      }
      return this.j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("called getResPackage() on ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Uri g()
  {
    int m = this.a;
    if (m == -1) {
      return h((Icon)this.b);
    }
    if ((m != 4) && (m != 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("called getUri() on ");
      localStringBuilder.append(this);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return Uri.parse((String)this.b);
  }
  
  public InputStream i(Context paramContext)
  {
    Uri localUri = g();
    String str = localUri.getScheme();
    if ((!"content".equals(str)) && (!"file".equals(str))) {
      try
      {
        paramContext = new FileInputStream(new File((String)this.b));
        return paramContext;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramContext = new StringBuilder();
        str = "Unable to load image from path: ";
      }
    } else {
      try
      {
        paramContext = paramContext.getContentResolver().openInputStream(localUri);
        return paramContext;
      }
      catch (Exception localException)
      {
        paramContext = new StringBuilder();
        str = "Unable to load image from URI: ";
      }
    }
    paramContext.append(str);
    paramContext.append(localUri);
    Log.w("IconCompat", paramContext.toString(), localException);
    return null;
  }
  
  public void j()
  {
    this.h = PorterDuff.Mode.valueOf(this.i);
    Object localObject;
    switch (this.a)
    {
    case 0: 
    default: 
      return;
    case 3: 
      this.b = this.c;
      return;
    case 2: 
    case 4: 
    case 6: 
      localObject = new String(this.c, Charset.forName("UTF-16"));
      this.b = localObject;
      if ((this.a != 2) || (this.j != null)) {
        return;
      }
      this.j = localObject.split(":", -1)[0];
      return;
    case 1: 
    case 5: 
      localObject = this.d;
      if (localObject == null)
      {
        localObject = this.c;
        this.b = localObject;
        this.a = 3;
        this.e = 0;
        this.f = localObject.length;
        return;
      }
      break;
    case -1: 
      localObject = this.d;
      if (localObject == null) {
        break label177;
      }
    }
    this.b = localObject;
    return;
    label177:
    throw new IllegalArgumentException("Invalid icon");
  }
  
  public void k(boolean paramBoolean)
  {
    this.i = this.h.name();
    switch (this.a)
    {
    case 0: 
    default: 
      return;
    case 4: 
    case 6: 
      this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
      return;
    case 3: 
      this.c = ((byte[])this.b);
      return;
    case 2: 
      this.c = ((String)this.b).getBytes(Charset.forName("UTF-16"));
      return;
    case 1: 
    case 5: 
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)this.b;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        this.c = localByteArrayOutputStream.toByteArray();
        return;
      }
      break;
    case -1: 
      if (paramBoolean) {
        break label171;
      }
    }
    this.d = ((Parcelable)this.b);
    return;
    label171:
    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
  }
  
  @Deprecated
  public Icon l()
  {
    return m(null);
  }
  
  public Icon m(Context paramContext)
  {
    Object localObject;
    switch (this.a)
    {
    case 0: 
    default: 
      throw new IllegalArgumentException("Unknown type");
    case 6: 
      int m = Build.VERSION.SDK_INT;
      if (m >= 30)
      {
        paramContext = Icon.createWithAdaptiveBitmapContentUri(g());
      }
      else if (paramContext != null)
      {
        paramContext = i(paramContext);
        if (paramContext != null)
        {
          paramContext = BitmapFactory.decodeStream(paramContext);
          localObject = paramContext;
          if (m < 26) {
            break label220;
          }
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Cannot load adaptive icon from uri: ");
          paramContext.append(g());
          throw new IllegalStateException(paramContext.toString());
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("Context is required to resolve the file uri of the icon: ");
        paramContext.append(g());
        throw new IllegalArgumentException(paramContext.toString());
      }
    case 5: 
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext = (Bitmap)this.b;
        paramContext = Icon.createWithAdaptiveBitmap(paramContext);
      }
      else
      {
        localObject = (Bitmap)this.b;
        paramContext = a((Bitmap)localObject, false);
      }
      break;
    case 4: 
      paramContext = Icon.createWithContentUri((String)this.b);
      break;
    case 3: 
      paramContext = Icon.createWithData((byte[])this.b, this.e, this.f);
      break;
    case 2: 
      paramContext = Icon.createWithResource(e(), this.e);
      break;
    case 1: 
      label220:
      paramContext = (Bitmap)this.b;
      paramContext = Icon.createWithBitmap(paramContext);
      localObject = this.g;
      if (localObject != null) {
        paramContext.setTintList((ColorStateList)localObject);
      }
      localObject = this.h;
      if (localObject != k) {
        paramContext.setTintMode((PorterDuff.Mode)localObject);
      }
      return paramContext;
    }
    return (Icon)this.b;
  }
  
  public String toString()
  {
    if (this.a == -1) {
      return String.valueOf(this.b);
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=");
    localStringBuilder.append(n(this.a));
    int m;
    switch (this.a)
    {
    default: 
      break;
    case 4: 
    case 6: 
      localStringBuilder.append(" uri=");
      localStringBuilder.append(this.b);
      break;
    case 3: 
      localStringBuilder.append(" len=");
      localStringBuilder.append(this.e);
      if (this.f == 0) {
        break label244;
      }
      localStringBuilder.append(" off=");
      m = this.f;
      break;
    case 2: 
      localStringBuilder.append(" pkg=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" id=");
      localStringBuilder.append(String.format("0x%08x", new Object[] { Integer.valueOf(c()) }));
      break;
    case 1: 
    case 5: 
      localStringBuilder.append(" size=");
      localStringBuilder.append(((Bitmap)this.b).getWidth());
      localStringBuilder.append("x");
      m = ((Bitmap)this.b).getHeight();
    }
    localStringBuilder.append(m);
    label244:
    if (this.g != null)
    {
      localStringBuilder.append(" tint=");
      localStringBuilder.append(this.g);
    }
    if (this.h != k)
    {
      localStringBuilder.append(" mode=");
      localStringBuilder.append(this.h);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.graphics.drawable.IconCompat
 * JD-Core Version:    0.7.0.1
 */