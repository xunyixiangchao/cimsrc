package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.n1;
import androidx.camera.core.u2.g;
import x0.h;

final class f
{
  private static final PreviewView.f g = PreviewView.f.c;
  private Size a;
  private Rect b;
  private int c;
  private int d;
  private boolean e;
  private PreviewView.f f = g;
  
  private static RectF b(RectF paramRectF, float paramFloat)
  {
    paramFloat += paramFloat;
    return new RectF(paramFloat - paramRectF.right, paramRectF.top, paramFloat - paramRectF.left, paramRectF.bottom);
  }
  
  private Size e()
  {
    if (x.d(this.c)) {
      return new Size(this.b.height(), this.b.width());
    }
    return new Size(this.b.width(), this.b.height());
  }
  
  private RectF j(Size paramSize, int paramInt)
  {
    h.i(k());
    paramSize = h(paramSize, paramInt);
    RectF localRectF = new RectF(0.0F, 0.0F, this.a.getWidth(), this.a.getHeight());
    paramSize.mapRect(localRectF);
    return localRectF;
  }
  
  private boolean k()
  {
    return (this.b != null) && (this.a != null) && (this.d != -1);
  }
  
  private static void n(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2, PreviewView.f paramf)
  {
    Object localObject;
    switch (a.a[paramf.ordinal()])
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected crop rect: ");
      ((StringBuilder)localObject).append(paramf);
      n1.c("PreviewTransform", ((StringBuilder)localObject).toString());
      localObject = Matrix.ScaleToFit.FILL;
      break;
    case 5: 
    case 6: 
      localObject = Matrix.ScaleToFit.START;
      break;
    case 3: 
    case 4: 
      localObject = Matrix.ScaleToFit.END;
      break;
    case 1: 
    case 2: 
      localObject = Matrix.ScaleToFit.CENTER;
    }
    int i;
    if ((paramf != PreviewView.f.f) && (paramf != PreviewView.f.e) && (paramf != PreviewView.f.g)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramMatrix.setRectToRect(paramRectF1, paramRectF2, (Matrix.ScaleToFit)localObject);
      return;
    }
    paramMatrix.setRectToRect(paramRectF2, paramRectF1, (Matrix.ScaleToFit)localObject);
    paramMatrix.invert(paramMatrix);
  }
  
  Bitmap a(Bitmap paramBitmap, Size paramSize, int paramInt)
  {
    if (!k()) {
      return paramBitmap;
    }
    Matrix localMatrix1 = i();
    RectF localRectF = j(paramSize, paramInt);
    paramSize = Bitmap.createBitmap(paramSize.getWidth(), paramSize.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(paramSize);
    Matrix localMatrix2 = new Matrix();
    localMatrix2.postConcat(localMatrix1);
    localMatrix2.postScale(localRectF.width() / this.a.getWidth(), localRectF.height() / this.a.getHeight());
    localMatrix2.postTranslate(localRectF.left, localRectF.top);
    localCanvas.drawBitmap(paramBitmap, localMatrix2, new Paint(7));
    return paramSize;
  }
  
  Matrix c(Size paramSize, int paramInt)
  {
    if (!k()) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    h(paramSize, paramInt).invert(localMatrix);
    paramSize = new Matrix();
    paramSize.setRectToRect(new RectF(0.0F, 0.0F, this.a.getWidth(), this.a.getHeight()), new RectF(0.0F, 0.0F, 1.0F, 1.0F), Matrix.ScaleToFit.FILL);
    localMatrix.postConcat(paramSize);
    return localMatrix;
  }
  
  RectF d(Size paramSize, int paramInt)
  {
    RectF localRectF = new RectF(0.0F, 0.0F, paramSize.getWidth(), paramSize.getHeight());
    Object localObject = e();
    localObject = new RectF(0.0F, 0.0F, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
    Matrix localMatrix = new Matrix();
    n(localMatrix, (RectF)localObject, localRectF, this.f);
    localMatrix.mapRect((RectF)localObject);
    if (paramInt == 1) {
      return b((RectF)localObject, paramSize.getWidth() / 2.0F);
    }
    return localObject;
  }
  
  PreviewView.f f()
  {
    return this.f;
  }
  
  Rect g()
  {
    return this.b;
  }
  
  Matrix h(Size paramSize, int paramInt)
  {
    h.i(k());
    if (l(paramSize)) {
      paramSize = new RectF(0.0F, 0.0F, paramSize.getWidth(), paramSize.getHeight());
    } else {
      paramSize = d(paramSize, paramInt);
    }
    paramSize = x.c(new RectF(this.b), paramSize, this.c);
    if (this.e)
    {
      if (x.d(this.c))
      {
        paramSize.preScale(1.0F, -1.0F, this.b.centerX(), this.b.centerY());
        return paramSize;
      }
      paramSize.preScale(-1.0F, 1.0F, this.b.centerX(), this.b.centerY());
    }
    return paramSize;
  }
  
  Matrix i()
  {
    h.i(k());
    RectF localRectF = new RectF(0.0F, 0.0F, this.a.getWidth(), this.a.getHeight());
    return x.c(localRectF, localRectF, -x.f(this.d));
  }
  
  boolean l(Size paramSize)
  {
    return x.e(paramSize, true, e(), false);
  }
  
  void m(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  void o(PreviewView.f paramf)
  {
    this.f = paramf;
  }
  
  void p(u2.g paramg, Size paramSize, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Transformation info set: ");
    localStringBuilder.append(paramg);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramSize);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramBoolean);
    n1.a("PreviewTransform", localStringBuilder.toString());
    this.b = paramg.a();
    this.c = paramg.b();
    this.d = paramg.c();
    this.a = paramSize;
    this.e = paramBoolean;
  }
  
  void q(Size paramSize, int paramInt, View paramView)
  {
    if ((paramSize.getHeight() != 0) && (paramSize.getWidth() != 0))
    {
      if (!k()) {
        return;
      }
      if ((paramView instanceof TextureView))
      {
        ((TextureView)paramView).setTransform(i());
      }
      else
      {
        Display localDisplay = paramView.getDisplay();
        if ((localDisplay != null) && (localDisplay.getRotation() != this.d)) {
          n1.c("PreviewTransform", "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
        }
      }
      paramSize = j(paramSize, paramInt);
      paramView.setPivotX(0.0F);
      paramView.setPivotY(0.0F);
      paramView.setScaleX(paramSize.width() / this.a.getWidth());
      paramView.setScaleY(paramSize.height() / this.a.getHeight());
      paramView.setTranslationX(paramSize.left - paramView.getLeft());
      paramView.setTranslationY(paramSize.top - paramView.getTop());
      return;
    }
    paramView = new StringBuilder();
    paramView.append("Transform not applied due to PreviewView size: ");
    paramView.append(paramSize);
    n1.k("PreviewTransform", paramView.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.f
 * JD-Core Version:    0.7.0.1
 */