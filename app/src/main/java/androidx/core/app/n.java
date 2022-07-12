package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class n
{
  private Matrix a;
  
  private static Bitmap a(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i > 0) && (j > 0))
    {
      float f = Math.min(1.0F, 1048576.0F / (i * j));
      if (((paramDrawable instanceof BitmapDrawable)) && (f == 1.0F)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = (int)(i * f);
      j = (int)(j * f);
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Rect localRect = paramDrawable.getBounds();
      int k = localRect.left;
      int m = localRect.top;
      int n = localRect.right;
      int i1 = localRect.bottom;
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      paramDrawable.setBounds(k, m, n, i1);
      return localBitmap;
    }
    return null;
  }
  
  public Parcelable b(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      Drawable localDrawable = ((ImageView)localObject1).getBackground();
      if ((localObject2 != null) && (localDrawable == null))
      {
        localObject2 = a((Drawable)localObject2);
        if (localObject2 != null)
        {
          paramView = new Bundle();
          paramView.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
          paramView.putString("sharedElement:snapshot:imageScaleType", ((ImageView)localObject1).getScaleType().toString());
          if (((ImageView)localObject1).getScaleType() == ImageView.ScaleType.MATRIX)
          {
            paramMatrix = ((ImageView)localObject1).getImageMatrix();
            paramRectF = new float[9];
            paramMatrix.getValues(paramRectF);
            paramView.putFloatArray("sharedElement:snapshot:imageMatrix", paramRectF);
          }
          return paramView;
        }
      }
    }
    int j = Math.round(paramRectF.width());
    int i = Math.round(paramRectF.height());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (j > 0)
    {
      localObject1 = localObject2;
      if (i > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (j * i));
        j = (int)(j * f);
        i = (int)(i * f);
        if (this.a == null) {
          this.a = new Matrix();
        }
        this.a.set(paramMatrix);
        this.a.postTranslate(-paramRectF.left, -paramRectF.top);
        this.a.postScale(f, f);
        localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        paramMatrix.concat(this.a);
        paramView.draw(paramMatrix);
      }
    }
    return localObject1;
  }
  
  public View c(Context paramContext, Parcelable paramParcelable)
  {
    boolean bool = paramParcelable instanceof Bundle;
    Object localObject = null;
    if (bool)
    {
      paramParcelable = (Bundle)paramParcelable;
      localObject = (Bitmap)paramParcelable.getParcelable("sharedElement:snapshot:bitmap");
      if (localObject == null) {
        return null;
      }
      paramContext = new ImageView(paramContext);
      paramContext.setImageBitmap((Bitmap)localObject);
      paramContext.setScaleType(ImageView.ScaleType.valueOf(paramParcelable.getString("sharedElement:snapshot:imageScaleType")));
      localObject = paramContext;
      if (paramContext.getScaleType() == ImageView.ScaleType.MATRIX)
      {
        paramParcelable = paramParcelable.getFloatArray("sharedElement:snapshot:imageMatrix");
        localObject = new Matrix();
        ((Matrix)localObject).setValues(paramParcelable);
        paramContext.setImageMatrix((Matrix)localObject);
        return paramContext;
      }
    }
    else if ((paramParcelable instanceof Bitmap))
    {
      paramParcelable = (Bitmap)paramParcelable;
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setImageBitmap(paramParcelable);
    }
    return localObject;
  }
  
  public abstract void d(List<String> paramList, Map<String, View> paramMap);
  
  public void e(List<View> paramList) {}
  
  public void f(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void g(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void h(List<String> paramList, List<View> paramList1, a parama)
  {
    parama.a();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.n
 * JD-Core Version:    0.7.0.1
 */