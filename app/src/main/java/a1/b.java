package a1;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.c.a;
import androidx.core.view.x;
import x0.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class b
{
  private static d a(View paramView)
  {
    h.g(paramView);
    return new c();
  }
  
  public static InputConnection b(View paramView, InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    return c(paramInputConnection, paramEditorInfo, a(paramView));
  }
  
  @Deprecated
  public static InputConnection c(InputConnection paramInputConnection, EditorInfo paramEditorInfo, final d paramd)
  {
    x0.c.c(paramInputConnection, "inputConnection must be non-null");
    x0.c.c(paramEditorInfo, "editorInfo must be non-null");
    x0.c.c(paramd, "onCommitContentListener must be non-null");
    if (Build.VERSION.SDK_INT >= 25) {
      return new a(false, paramd);
    }
    if (a.a(paramEditorInfo).length == 0) {
      return paramInputConnection;
    }
    return new b(false, paramd);
  }
  
  static boolean d(String paramString, Bundle paramBundle, d paramd)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  class a
    extends InputConnectionWrapper
  {
    a(boolean paramBoolean, b.d paramd)
    {
      super(paramBoolean);
    }
    
    public boolean commitContent(InputContentInfo paramInputContentInfo, int paramInt, Bundle paramBundle)
    {
      if (paramd.a(c.f(paramInputContentInfo), paramInt, paramBundle)) {
        return true;
      }
      return super.commitContent(paramInputContentInfo, paramInt, paramBundle);
    }
  }
  
  class b
    extends InputConnectionWrapper
  {
    b(boolean paramBoolean, b.d paramd)
    {
      super(paramBoolean);
    }
    
    public boolean performPrivateCommand(String paramString, Bundle paramBundle)
    {
      if (b.d(paramString, paramBundle, paramd)) {
        return true;
      }
      return super.performPrivateCommand(paramString, paramBundle);
    }
  }
  
  class c
    implements b.d
  {
    c() {}
    
    public boolean a(c paramc, int paramInt, Bundle paramBundle)
    {
      int i = Build.VERSION.SDK_INT;
      boolean bool = false;
      Object localObject = paramBundle;
      if (i >= 25)
      {
        localObject = paramBundle;
        if ((paramInt & 0x1) != 0) {
          try
          {
            paramc.d();
            localObject = (InputContentInfo)paramc.e();
            if (paramBundle == null) {
              paramBundle = new Bundle();
            } else {
              paramBundle = new Bundle(paramBundle);
            }
            paramBundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", (Parcelable)localObject);
            localObject = paramBundle;
          }
          catch (Exception paramc)
          {
            Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", paramc);
            return false;
          }
        }
      }
      paramc = new c.a(new ClipData(paramc.b(), new ClipData.Item(paramc.a())), 2).d(paramc.c()).b((Bundle)localObject).a();
      if (x.g0(b.this, paramc) == null) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean a(c paramc, int paramInt, Bundle paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a1.b
 * JD-Core Version:    0.7.0.1
 */