package vi.com.gdi.bgl.android.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import java.nio.IntBuffer;

public class EnvDrawText
{
  private static final String DEVICE_VIVOX3L = "vivo X3L";
  private static final int FONT_STYLE_BOLD = 1;
  private static final int FONT_STYLE_ITALIC = 2;
  private static final int FONT_STYLE_NORMAL = 0;
  public static int[] buffer;
  private static Bitmap defaultFontBmp;
  public static SparseArray<a> fontCache;
  private static Context mContext;
  
  private static int[] drawText(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    Object localObject1;
    int i;
    int j;
    int k;
    Object localObject2;
    for (;;)
    {
      Canvas localCanvas;
      TextPaint localTextPaint;
      label658:
      try
      {
        localCanvas = new Canvas();
        localTextPaint = new TextPaint();
        localObject1 = Build.MODEL;
        if ((localObject1 == null) || (!((String)localObject1).equals("vivo X3L"))) {
          break label1103;
        }
        paramInt2 = 0;
        localTextPaint.reset();
        localTextPaint.setSubpixelText(true);
        localTextPaint.setAntiAlias(true);
        localTextPaint.setTextSize(paramInt1);
        localTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        localTextPaint.setTypeface(getTypeface(paramInt2));
        if (paramInt6 != 0)
        {
          localTextPaint.setStrokeWidth(paramInt6);
          localTextPaint.setStrokeCap(Paint.Cap.ROUND);
          localTextPaint.setStrokeJoin(Paint.Join.ROUND);
          localTextPaint.setStyle(Paint.Style.STROKE);
        }
        paramInt1 = paramString.indexOf('\\', 0);
        if (paramInt1 == -1)
        {
          localObject1 = localTextPaint.getFontMetrics();
          i = (int)(Layout.getDesiredWidth(paramString, 0, paramString.length(), localTextPaint) + 0.5D);
          paramInt7 = (int)Math.ceil(((Paint.FontMetrics)localObject1).descent - ((Paint.FontMetrics)localObject1).ascent);
          paramArrayOfInt[0] = i;
          paramArrayOfInt[1] = paramInt7;
          paramInt1 = i;
          paramInt2 = paramInt7;
          if (paramArrayOfInt.length != 4) {
            break label1106;
          }
          paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(i) / Math.log(2.0D)));
          paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt7) / Math.log(2.0D)));
          break label1106;
          if (paramArrayOfInt.length == 4)
          {
            paramArrayOfInt[2] = paramInt7;
            paramArrayOfInt[3] = i;
          }
          if ((paramInt7 <= 0) || (i <= 0)) {
            break label1138;
          }
          paramArrayOfInt = Bitmap.createBitmap(paramInt7, i, Bitmap.Config.ARGB_8888);
          if (paramArrayOfInt == null) {
            return new int[0];
          }
          localCanvas.setBitmap(paramArrayOfInt);
          if ((paramInt5 & 0xFF000000) == 0) {
            localCanvas.drawColor(16777215);
          } else {
            localCanvas.drawColor(paramInt5);
          }
          if (paramInt6 != 0)
          {
            localTextPaint.setStrokeWidth(paramInt6);
            localTextPaint.setStrokeCap(Paint.Cap.ROUND);
            localTextPaint.setStrokeJoin(Paint.Join.ROUND);
            localTextPaint.setStyle(Paint.Style.STROKE);
            localTextPaint.setColor(paramInt4);
            localCanvas.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject1).ascent, localTextPaint);
          }
          localTextPaint.setStyle(Paint.Style.FILL);
          localTextPaint.setColor(paramInt3);
          localCanvas.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject1).ascent, localTextPaint);
          paramInt1 = i;
          break;
        }
        j = paramInt1 + 1;
        paramInt1 = (int)(Layout.getDesiredWidth(paramString.substring(0, paramInt1), localTextPaint) + 0.5D);
        i = 2;
        k = paramString.indexOf('\\', j);
        if (k > 0)
        {
          j = (int)(Layout.getDesiredWidth(paramString.substring(j, k), localTextPaint) + 0.5D);
          paramInt2 = paramInt1;
          if (j <= paramInt1) {
            break label1146;
          }
          paramInt2 = j;
          break label1146;
        }
        paramInt2 = paramInt1;
        if (j != paramString.length())
        {
          j = (int)(Layout.getDesiredWidth(paramString.substring(j, paramString.length()), localTextPaint) + 0.5D);
          paramInt2 = paramInt1;
          if (j > paramInt1) {
            paramInt2 = j;
          }
        }
        localObject2 = localTextPaint.getFontMetrics();
        j = (int)Math.ceil(((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent);
        paramInt1 = i * j;
        paramArrayOfInt[0] = paramInt2;
        paramArrayOfInt[1] = paramInt1;
        if (paramArrayOfInt.length != 4) {
          break label1163;
        }
        paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt2) / Math.log(2.0D)));
        paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
      }
      finally {}
      if (paramArrayOfInt.length == 4)
      {
        paramArrayOfInt[2] = paramInt2;
        paramArrayOfInt[3] = paramInt1;
      }
      if ((paramInt2 <= 0) || (paramInt1 <= 0)) {
        break label1184;
      }
      localObject1 = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
      if (localObject1 == null) {
        return new int[0];
      }
      localCanvas.setBitmap((Bitmap)localObject1);
      label712:
      if ((paramInt5 & 0xFF000000) == 0) {
        localCanvas.drawColor(16777215);
      } else {
        localCanvas.drawColor(paramInt5);
      }
      localTextPaint.setTextAlign(getTextAlignedType(paramInt7));
      if (paramInt7 != 1) {
        break label1190;
      }
      paramInt5 = 0;
      break label1201;
      label759:
      paramInt5 = paramArrayOfInt[0] / 2;
      break label1201;
      label769:
      k = paramString.indexOf('\\', i);
      if (k > 0)
      {
        localObject2 = paramString.substring(i, k);
        Layout.getDesiredWidth((CharSequence)localObject2, localTextPaint);
        if (paramInt6 == 0) {
          break label1213;
        }
        localTextPaint.setStrokeWidth(paramInt6);
        localTextPaint.setStrokeCap(Paint.Cap.ROUND);
        localTextPaint.setStrokeJoin(Paint.Join.ROUND);
        localTextPaint.setStyle(Paint.Style.STROKE);
        localTextPaint.setColor(paramInt4);
        localCanvas.drawText((String)localObject2, paramInt5, paramInt7 * j - paramArrayOfInt.ascent, localTextPaint);
        label872:
        localTextPaint.setStyle(Paint.Style.FILL);
        localTextPaint.setColor(paramInt3);
        localCanvas.drawText((String)localObject2, paramInt5, paramInt7 * j - paramArrayOfInt.ascent, localTextPaint);
        paramInt7 += 1;
        i = k + 1;
      }
      else
      {
        if (i == paramString.length()) {
          break label1216;
        }
        paramString = paramString.substring(i, paramString.length());
        Layout.getDesiredWidth(paramString, localTextPaint);
        if (paramInt6 != 0)
        {
          localTextPaint.setStrokeWidth(paramInt6);
          localTextPaint.setStrokeCap(Paint.Cap.ROUND);
          localTextPaint.setStrokeJoin(Paint.Join.ROUND);
          localTextPaint.setStyle(Paint.Style.STROKE);
          localTextPaint.setColor(paramInt4);
          localCanvas.drawText(paramString, paramInt5, paramInt7 * j - paramArrayOfInt.ascent, localTextPaint);
        }
        localTextPaint.setStyle(Paint.Style.FILL);
        localTextPaint.setColor(paramInt3);
        localCanvas.drawText(paramString, paramInt5, paramInt7 * j - paramArrayOfInt.ascent, localTextPaint);
        break label1216;
        label1058:
        paramString = new int[paramInt7 * paramInt1];
        if (paramArrayOfInt != null) {
          paramArrayOfInt.copyPixelsToBuffer(IntBuffer.wrap(paramString));
        }
        if ((paramArrayOfInt != null) && (!paramArrayOfInt.isRecycled())) {
          paramArrayOfInt.recycle();
        }
        return paramString;
        label1103:
        continue;
        label1106:
        paramInt7 = paramInt1;
        i = paramInt2;
        if (paramInt1 == 0) {
          if (paramInt2 != 0)
          {
            paramInt7 = paramInt1;
            i = paramInt2;
          }
          else
          {
            paramInt7 = 0;
            i = 0;
            continue;
            label1138:
            paramArrayOfInt = null;
          }
        }
      }
    }
    for (;;)
    {
      break label1058;
      label1146:
      j = k + 1;
      i += 1;
      paramInt1 = paramInt2;
      break;
      label1163:
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramInt2 = 0;
        paramInt1 = 0;
        break label658;
      }
      break label658;
      label1184:
      localObject1 = null;
      break label712;
      label1190:
      if (paramInt7 != 2) {
        break label759;
      }
      paramInt5 = paramArrayOfInt[0];
      label1201:
      paramInt7 = 0;
      i = 0;
      paramArrayOfInt = (int[])localObject2;
      break label769;
      label1213:
      break label872;
      label1216:
      paramInt7 = paramInt2;
      paramArrayOfInt = (int[])localObject1;
    }
  }
  
  private static Bitmap drawTextAlpha(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Canvas localCanvas = new Canvas();
    TextPaint localTextPaint = new TextPaint();
    Object localObject1 = Build.MODEL;
    int k = 0;
    if ((localObject1 != null) && (((String)localObject1).equals("vivo X3L"))) {
      paramInt2 = 0;
    }
    localTextPaint.reset();
    localTextPaint.setSubpixelText(false);
    localTextPaint.setAntiAlias(false);
    localTextPaint.setTextSize(paramInt1);
    localTextPaint.setTypeface(getTypeface(paramInt2));
    float f = paramInt3 * 1.3F + 0.5F;
    paramInt1 = paramString.indexOf('\\', 0);
    Object localObject2 = null;
    Paint.FontMetrics localFontMetrics = null;
    if (paramInt1 == -1)
    {
      localObject2 = localTextPaint.getFontMetrics();
      paramInt1 = (int)(Layout.getDesiredWidth(paramString, 0, paramString.length(), localTextPaint) + f);
      paramInt2 = (int)Math.ceil(((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent);
      localObject1 = localFontMetrics;
      if (paramInt1 > 0)
      {
        localObject1 = localFontMetrics;
        if (paramInt2 > 0)
        {
          localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
          if (localObject1 == null) {
            return localObject1;
          }
          ((Bitmap)localObject1).eraseColor(0);
          localCanvas.setBitmap((Bitmap)localObject1);
        }
      }
      localTextPaint.setStyle(Paint.Style.FILL);
      localCanvas.drawText(paramString, f * 0.5F, 0.0F - ((Paint.FontMetrics)localObject2).ascent, localTextPaint);
      return localObject1;
    }
    int i = paramInt1 + 1;
    paramInt2 = 2;
    paramInt1 = (int)(Layout.getDesiredWidth(paramString.substring(0, paramInt1), localTextPaint) + 0.5D);
    for (;;)
    {
      int m = paramString.indexOf('\\', i);
      if (m <= 0) {
        break;
      }
      j = (int)(Layout.getDesiredWidth(paramString.substring(i, m), localTextPaint) + 0.5D);
      i = paramInt1;
      if (j > paramInt1) {
        i = j;
      }
      j = m + 1;
      paramInt2 += 1;
      paramInt1 = i;
      i = j;
    }
    int j = paramInt1;
    if (i != paramString.length())
    {
      i = (int)(Layout.getDesiredWidth(paramString.substring(i, paramString.length()), localTextPaint) + 0.5D);
      j = paramInt1;
      if (i > paramInt1) {
        j = i;
      }
    }
    localFontMetrics = localTextPaint.getFontMetrics();
    i = (int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent);
    paramInt1 = j + paramInt3;
    paramInt2 *= i;
    localObject1 = localObject2;
    if (paramInt1 > 0)
    {
      localObject1 = localObject2;
      if (paramInt2 > 0)
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
        if (localObject1 == null) {
          return localObject1;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localCanvas.setBitmap((Bitmap)localObject1);
      }
    }
    localTextPaint.setTextAlign(getTextAlignedType(3));
    f = paramInt1 - f * 0.5F;
    paramInt1 = 0;
    for (paramInt2 = k;; paramInt2 = paramInt3 + 1)
    {
      paramInt3 = paramString.indexOf('\\', paramInt2);
      if (paramInt3 <= 0) {
        break;
      }
      localObject2 = paramString.substring(paramInt2, paramInt3);
      Layout.getDesiredWidth((CharSequence)localObject2, localTextPaint);
      localTextPaint.setStyle(Paint.Style.FILL);
      localCanvas.drawText((String)localObject2, f, paramInt1 * i - localFontMetrics.ascent, localTextPaint);
      paramInt1 += 1;
    }
    if (paramInt2 != paramString.length())
    {
      paramString = paramString.substring(paramInt2, paramString.length());
      Layout.getDesiredWidth(paramString, localTextPaint);
      localTextPaint.setStyle(Paint.Style.FILL);
      localCanvas.drawText(paramString, f, paramInt1 * i - localFontMetrics.ascent, localTextPaint);
    }
    return localObject1;
  }
  
  private static Bitmap drawTextExt(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    label1156:
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      int k;
      Object localObject2;
      try
      {
        Canvas localCanvas = new Canvas();
        TextPaint localTextPaint = new TextPaint();
        localObject1 = Build.MODEL;
        if ((localObject1 != null) && (((String)localObject1).equals("vivo X3L")))
        {
          paramInt2 = 0;
          localTextPaint.reset();
          localTextPaint.setSubpixelText(true);
          localTextPaint.setAntiAlias(true);
          localTextPaint.setTextSize(paramInt1);
          localTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          localTextPaint.setTypeface(getTypeface(paramInt2));
          if (paramInt6 != 0)
          {
            localTextPaint.setStrokeWidth(paramInt6);
            localTextPaint.setStrokeCap(Paint.Cap.ROUND);
            localTextPaint.setStrokeJoin(Paint.Join.ROUND);
            localTextPaint.setStyle(Paint.Style.STROKE);
          }
          paramInt1 = paramString.indexOf('\\', 0);
          if (paramInt1 == -1)
          {
            localObject1 = localTextPaint.getFontMetrics();
            i = (int)(Layout.getDesiredWidth(paramString, 0, paramString.length(), localTextPaint) + 0.5D);
            paramInt7 = (int)Math.ceil(((Paint.FontMetrics)localObject1).descent - ((Paint.FontMetrics)localObject1).ascent);
            paramArrayOfInt[0] = i;
            paramArrayOfInt[1] = paramInt7;
            paramInt2 = i;
            paramInt1 = paramInt7;
            if (paramArrayOfInt.length != 4) {
              break label1054;
            }
            paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(i) / Math.log(2.0D)));
            paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt7) / Math.log(2.0D)));
            break label1054;
            if (paramArrayOfInt.length == 4)
            {
              paramArrayOfInt[2] = paramInt2;
              paramArrayOfInt[3] = paramInt1;
            }
            if ((paramInt2 <= 0) || (paramInt1 <= 0)) {
              break label1075;
            }
            paramArrayOfInt = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
            if (paramArrayOfInt == null) {
              return paramArrayOfInt;
            }
            localCanvas.setBitmap(paramArrayOfInt);
            if ((paramInt5 & 0xFF000000) == 0) {
              localCanvas.drawColor(16777215);
            } else {
              localCanvas.drawColor(paramInt5);
            }
            if (paramInt6 != 0)
            {
              localTextPaint.setStrokeWidth(paramInt6);
              localTextPaint.setStrokeCap(Paint.Cap.ROUND);
              localTextPaint.setStrokeJoin(Paint.Join.ROUND);
              localTextPaint.setStyle(Paint.Style.STROKE);
              localTextPaint.setColor(paramInt4);
              localCanvas.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject1).ascent, localTextPaint);
            }
            localTextPaint.setStyle(Paint.Style.FILL);
            localTextPaint.setColor(paramInt3);
            localCanvas.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject1).ascent, localTextPaint);
          }
          else
          {
            j = paramInt1 + 1;
            paramInt1 = (int)(Layout.getDesiredWidth(paramString.substring(0, paramInt1), localTextPaint) + 0.5D);
            i = 2;
            k = paramString.indexOf('\\', j);
            if (k > 0)
            {
              j = (int)(Layout.getDesiredWidth(paramString.substring(j, k), localTextPaint) + 0.5D);
              paramInt2 = paramInt1;
              if (j <= paramInt1) {
                break label1080;
              }
              paramInt2 = j;
              break label1080;
            }
            paramInt2 = paramInt1;
            if (j != paramString.length())
            {
              j = (int)(Layout.getDesiredWidth(paramString.substring(j, paramString.length()), localTextPaint) + 0.5D);
              paramInt2 = paramInt1;
              if (j > paramInt1) {
                paramInt2 = j;
              }
            }
            localObject2 = localTextPaint.getFontMetrics();
            k = (int)Math.ceil(((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent);
            paramInt1 = i * k;
            paramArrayOfInt[0] = paramInt2;
            paramArrayOfInt[1] = paramInt1;
            if (paramArrayOfInt.length != 4) {
              break label1097;
            }
            paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt2) / Math.log(2.0D)));
            paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
            break label1097;
            if (paramArrayOfInt.length == 4)
            {
              paramArrayOfInt[2] = i;
              paramArrayOfInt[3] = j;
            }
            if ((i <= 0) || (j <= 0)) {
              break label1129;
            }
            localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
            if (localObject1 == null) {
              return localObject1;
            }
            localCanvas.setBitmap((Bitmap)localObject1);
            if ((paramInt5 & 0xFF000000) == 0) {
              localCanvas.drawColor(16777215);
            } else {
              localCanvas.drawColor(paramInt5);
            }
            localTextPaint.setTextAlign(getTextAlignedType(paramInt7));
            if (paramInt7 != 1) {
              break label1135;
            }
            paramInt1 = 0;
            break label1145;
            paramInt1 = paramArrayOfInt[0] / 2;
            break label1145;
            paramInt7 = paramString.indexOf('\\', paramInt5);
            if (paramInt7 > 0)
            {
              localObject2 = paramString.substring(paramInt5, paramInt7);
              Layout.getDesiredWidth((CharSequence)localObject2, localTextPaint);
              paramInt5 = paramInt7 + 1;
              if (paramInt6 == 0) {
                break label1156;
              }
              localTextPaint.setStrokeWidth(paramInt6);
              localTextPaint.setStrokeCap(Paint.Cap.ROUND);
              localTextPaint.setStrokeJoin(Paint.Join.ROUND);
              localTextPaint.setStyle(Paint.Style.STROKE);
              localTextPaint.setColor(paramInt4);
              localCanvas.drawText((String)localObject2, paramInt1, paramInt2 * k - paramArrayOfInt.ascent, localTextPaint);
              localTextPaint.setStyle(Paint.Style.FILL);
              localTextPaint.setColor(paramInt3);
              localCanvas.drawText((String)localObject2, paramInt1, paramInt2 * k - paramArrayOfInt.ascent, localTextPaint);
              paramInt2 += 1;
              continue;
            }
            if (paramInt5 != paramString.length())
            {
              paramString = paramString.substring(paramInt5, paramString.length());
              Layout.getDesiredWidth(paramString, localTextPaint);
              if (paramInt6 != 0)
              {
                localTextPaint.setStrokeWidth(paramInt6);
                localTextPaint.setStrokeCap(Paint.Cap.ROUND);
                localTextPaint.setStrokeJoin(Paint.Join.ROUND);
                localTextPaint.setStyle(Paint.Style.STROKE);
                localTextPaint.setColor(paramInt4);
                localCanvas.drawText(paramString, paramInt1, paramInt2 * k - paramArrayOfInt.ascent, localTextPaint);
              }
              localTextPaint.setStyle(Paint.Style.FILL);
              localTextPaint.setColor(paramInt3);
              localCanvas.drawText(paramString, paramInt1, paramInt2 * k - paramArrayOfInt.ascent, localTextPaint);
            }
            paramArrayOfInt = (int[])localObject1;
          }
          return paramArrayOfInt;
        }
      }
      finally {}
      continue;
      label1054:
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramInt2 = 0;
        paramInt1 = 0;
      }
      else
      {
        continue;
        label1075:
        paramArrayOfInt = null;
        continue;
        label1080:
        j = k + 1;
        i += 1;
        paramInt1 = paramInt2;
        continue;
        label1097:
        i = paramInt2;
        j = paramInt1;
        if (paramInt2 == 0) {
          if (paramInt1 != 0)
          {
            i = paramInt2;
            j = paramInt1;
          }
          else
          {
            i = 0;
            j = 0;
            continue;
            label1129:
            localObject1 = null;
            continue;
            label1135:
            if (paramInt7 == 2)
            {
              paramInt1 = paramArrayOfInt[0];
              label1145:
              paramInt2 = 0;
              paramInt5 = 0;
              paramArrayOfInt = (int[])localObject2;
            }
          }
        }
      }
    }
  }
  
  private static Paint.Align getTextAlignedType(int paramInt)
  {
    if (1 == paramInt) {
      return Paint.Align.LEFT;
    }
    if (2 == paramInt) {
      return Paint.Align.RIGHT;
    }
    return Paint.Align.CENTER;
  }
  
  private static Bitmap getTextBitmap()
  {
    Paint localPaint = new Paint();
    localPaint.setSubpixelText(true);
    localPaint.setAntiAlias(false);
    localPaint.setTextSize(12.0F);
    localPaint.setTypeface(Typeface.DEFAULT);
    float f1 = localPaint.measureText("!");
    float f2 = localPaint.descent();
    float f3 = localPaint.ascent();
    Bitmap localBitmap = Bitmap.createBitmap((int)Math.ceil(f1), (int)Math.ceil(f2 - f3), Bitmap.Config.ALPHA_8);
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas();
    localCanvas.setBitmap(localBitmap);
    localCanvas.drawText("!", 0.0F, 0.0F - localPaint.ascent(), localPaint);
    return localBitmap;
  }
  
  private static short[] getTextSize(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.length();
    if (i == 0) {
      return null;
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setSubpixelText(true);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(paramInt1);
    localTextPaint.setTypeface(getTypeface(paramInt2));
    short[] arrayOfShort = new short[i];
    for (paramInt1 = 0; paramInt1 < i; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1 + 1;
      arrayOfShort[paramInt1] = ((short)(int)(Layout.getDesiredWidth(paramString, 0, paramInt2, localTextPaint) + 0.5D));
    }
    return arrayOfShort;
  }
  
  private static float[] getTextSizeExt(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString.length() == 0) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setSubpixelText(true);
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(paramInt1);
    localPaint.setTypeface(getTypeface(paramInt2));
    return new float[] { localPaint.measureText(paramString), localPaint.descent() - localPaint.ascent() };
  }
  
  private static Typeface getTypeface(int paramInt)
  {
    Typeface localTypeface = Typeface.DEFAULT;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return localTypeface;
      }
      return Typeface.create(localTypeface, 2);
    }
    return Typeface.DEFAULT_BOLD;
  }
  
  private static boolean isSystemFontChanged()
  {
    try
    {
      if (defaultFontBmp == null)
      {
        defaultFontBmp = getTextBitmap();
        return false;
      }
      Bitmap localBitmap = getTextBitmap();
      if ((nativeIsBitmapSame(localBitmap, defaultFontBmp) ^ true))
      {
        defaultFontBmp.recycle();
        defaultFontBmp = Bitmap.createBitmap(localBitmap);
        localBitmap.recycle();
        return true;
      }
      localBitmap.recycle();
      return false;
    }
    finally {}
  }
  
  private static native boolean nativeIsBitmapSame(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static void registFontCache(int paramInt, Typeface paramTypeface)
  {
    if ((paramInt != 0) && (paramTypeface != null)) {
      try
      {
        if (fontCache == null) {
          fontCache = new SparseArray();
        }
        paramTypeface = (a)fontCache.get(paramInt);
        if (paramTypeface == null)
        {
          paramTypeface = new a();
          paramTypeface.a += 1;
          fontCache.put(paramInt, paramTypeface);
        }
        else
        {
          paramTypeface.a += 1;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void removeFontCache(int paramInt)
  {
    try
    {
      a locala = (a)fontCache.get(paramInt);
      if (locala == null) {
        return;
      }
      int i = locala.a - 1;
      locala.a = i;
      if (i == 0) {
        fontCache.remove(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     vi.com.gdi.bgl.android.java.EnvDrawText
 * JD-Core Version:    0.7.0.1
 */