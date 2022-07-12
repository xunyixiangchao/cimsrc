package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import q.j;

public class x1
{
  private static final Size d = new Size(1920, 1080);
  private static final Object e = new Object();
  private static volatile x1 f;
  private final DisplayManager a;
  private volatile Size b = null;
  private final j c = new j();
  
  private x1(Context paramContext)
  {
    this.a = ((DisplayManager)paramContext.getSystemService("display"));
  }
  
  private Size a()
  {
    Object localObject = new Point();
    c().getRealSize((Point)localObject);
    if (((Point)localObject).x > ((Point)localObject).y) {
      localObject = new Size(((Point)localObject).x, ((Point)localObject).y);
    } else {
      localObject = new Size(((Point)localObject).y, ((Point)localObject).x);
    }
    int i = ((Size)localObject).getWidth();
    int j = ((Size)localObject).getHeight();
    Size localSize = d;
    if (i * j > localSize.getWidth() * localSize.getHeight()) {
      localObject = localSize;
    }
    return this.c.a((Size)localObject);
  }
  
  public static x1 b(Context paramContext)
  {
    if (f == null) {
      synchronized (e)
      {
        if (f == null) {
          f = new x1(paramContext);
        }
      }
    }
    return f;
  }
  
  public Display c()
  {
    Display[] arrayOfDisplay = this.a.getDisplays();
    int j = arrayOfDisplay.length;
    int i = 0;
    if (j == 1) {
      return arrayOfDisplay[0];
    }
    Object localObject1 = null;
    j = -1;
    int m = arrayOfDisplay.length;
    while (i < m)
    {
      Display localDisplay = arrayOfDisplay[i];
      Object localObject2 = localObject1;
      int k = j;
      if (localDisplay.getState() != 1)
      {
        localObject2 = new Point();
        localDisplay.getRealSize((Point)localObject2);
        int n = ((Point)localObject2).x;
        int i1 = ((Point)localObject2).y;
        localObject2 = localObject1;
        k = j;
        if (n * i1 > j)
        {
          localObject2 = localDisplay;
          k = n * i1;
        }
      }
      i += 1;
      localObject1 = localObject2;
      j = k;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    throw new IllegalArgumentException("No display can be found from the input display manager!");
  }
  
  Size d()
  {
    if (this.b != null) {
      return this.b;
    }
    this.b = a();
    return this.b;
  }
  
  void e()
  {
    this.b = a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.x1
 * JD-Core Version:    0.7.0.1
 */