package e7;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class f
  extends Property<ImageView, Matrix>
{
  private final Matrix a = new Matrix();
  
  public f()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  public Matrix a(ImageView paramImageView)
  {
    this.a.set(paramImageView.getImageMatrix());
    return this.a;
  }
  
  public void b(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.f
 * JD-Core Version:    0.7.0.1
 */