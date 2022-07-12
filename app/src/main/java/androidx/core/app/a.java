package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class a
  extends b
{
  private static b c;
  
  public static void k(Activity paramActivity)
  {
    paramActivity.finishAffinity();
  }
  
  public static void l(Activity paramActivity)
  {
    paramActivity.finishAfterTransition();
  }
  
  public static void m(Activity paramActivity)
  {
    paramActivity.postponeEnterTransition();
  }
  
  public static void n(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {}
    do
    {
      paramActivity.recreate();
      return;
      if (i <= 23)
      {
        new Handler(paramActivity.getMainLooper()).post(new a());
        return;
      }
    } while (!c.i(paramActivity));
  }
  
  public static void o(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    b localb = c;
    if ((localb != null) && (localb.a(paramActivity, paramArrayOfString, paramInt))) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j) {
      if (!TextUtils.isEmpty(paramArrayOfString[i]))
      {
        i += 1;
      }
      else
      {
        paramActivity = new StringBuilder();
        paramActivity.append("Permission request for permissions ");
        paramActivity.append(Arrays.toString(paramArrayOfString));
        paramActivity.append(" must not contain null or empty values");
        throw new IllegalArgumentException(paramActivity.toString());
      }
    }
    if ((paramActivity instanceof c)) {
      ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
    }
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public static void p(Activity paramActivity, n paramn)
  {
    if (paramn != null) {
      paramn = new d(paramn);
    } else {
      paramn = null;
    }
    paramActivity.setEnterSharedElementCallback(paramn);
  }
  
  public static void q(Activity paramActivity, n paramn)
  {
    if (paramn != null) {
      paramn = new d(paramn);
    } else {
      paramn = null;
    }
    paramActivity.setExitSharedElementCallback(paramn);
  }
  
  public static boolean r(Activity paramActivity, String paramString)
  {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
  
  public static void s(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public static void t(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public static void u(Activity paramActivity)
  {
    paramActivity.startPostponedEnterTransition();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if ((!a.this.isFinishing()) && (!c.i(a.this))) {
        a.this.recreate();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(Activity paramActivity, String[] paramArrayOfString, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  private static class d
    extends SharedElementCallback
  {
    private final n a;
    
    d(n paramn)
    {
      this.a = paramn;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.a.b(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.a.c(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.a.d(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      this.a.e(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.a.f(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.a.g(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      this.a.h(paramList, paramList1, new a(paramOnSharedElementsReadyListener));
    }
    
    class a
      implements n.a
    {
      a(SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener) {}
      
      public void a()
      {
        paramOnSharedElementsReadyListener.onSharedElementsReady();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.a
 * JD-Core Version:    0.7.0.1
 */