package u2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class f
{
  public <Z> i<ImageView, Z> a(ImageView paramImageView, Class<Z> paramClass)
  {
    if (Bitmap.class.equals(paramClass)) {
      return new b(paramImageView);
    }
    if (Drawable.class.isAssignableFrom(paramClass)) {
      return new d(paramImageView);
    }
    paramImageView = new StringBuilder();
    paramImageView.append("Unhandled class: ");
    paramImageView.append(paramClass);
    paramImageView.append(", try .as*(Class).transcode(ResourceTranscoder)");
    throw new IllegalArgumentException(paramImageView.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u2.f
 * JD-Core Version:    0.7.0.1
 */