package androidx.activity;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.j;
import java.lang.reflect.Field;

final class ImmLeaksCleaner
  implements j
{
  private static int b;
  private static Field c;
  private static Field d;
  private static Field e;
  private Activity a;
  
  ImmLeaksCleaner(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private static void a()
  {
    try
    {
      b = 2;
      Field localField = InputMethodManager.class.getDeclaredField("mServedView");
      d = localField;
      localField.setAccessible(true);
      localField = InputMethodManager.class.getDeclaredField("mNextServedView");
      e = localField;
      localField.setAccessible(true);
      localField = InputMethodManager.class.getDeclaredField("mH");
      c = localField;
      localField.setAccessible(true);
      b = 1;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  /* Error */
  public void d(androidx.lifecycle.l paraml, androidx.lifecycle.h.b paramb)
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 64	androidx/lifecycle/h$b:ON_DESTROY	Landroidx/lifecycle/h$b;
    //   4: if_acmpeq +4 -> 8
    //   7: return
    //   8: getstatic 27	androidx/activity/ImmLeaksCleaner:b	I
    //   11: ifne +6 -> 17
    //   14: invokestatic 66	androidx/activity/ImmLeaksCleaner:a	()V
    //   17: getstatic 27	androidx/activity/ImmLeaksCleaner:b	I
    //   20: iconst_1
    //   21: if_icmpne +88 -> 109
    //   24: aload_0
    //   25: getfield 23	androidx/activity/ImmLeaksCleaner:a	Landroid/app/Activity;
    //   28: ldc 68
    //   30: invokevirtual 74	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 29	android/view/inputmethod/InputMethodManager
    //   36: astore_2
    //   37: getstatic 53	androidx/activity/ImmLeaksCleaner:c	Ljava/lang/reflect/Field;
    //   40: aload_2
    //   41: invokevirtual 78	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnonnull +4 -> 50
    //   49: return
    //   50: aload_1
    //   51: monitorenter
    //   52: getstatic 39	androidx/activity/ImmLeaksCleaner:d	Ljava/lang/reflect/Field;
    //   55: aload_2
    //   56: invokevirtual 78	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 80	android/view/View
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull +6 -> 70
    //   67: aload_1
    //   68: monitorexit
    //   69: return
    //   70: aload_3
    //   71: invokevirtual 84	android/view/View:isAttachedToWindow	()Z
    //   74: ifeq +6 -> 80
    //   77: aload_1
    //   78: monitorexit
    //   79: return
    //   80: getstatic 49	androidx/activity/ImmLeaksCleaner:e	Ljava/lang/reflect/Field;
    //   83: aload_2
    //   84: aconst_null
    //   85: invokevirtual 88	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: aload_1
    //   89: monitorexit
    //   90: aload_2
    //   91: invokevirtual 91	android/view/inputmethod/InputMethodManager:isActive	()Z
    //   94: pop
    //   95: return
    //   96: aload_1
    //   97: monitorexit
    //   98: return
    //   99: aload_1
    //   100: monitorexit
    //   101: return
    //   102: aload_1
    //   103: monitorexit
    //   104: return
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    //   109: return
    //   110: astore_1
    //   111: return
    //   112: astore_2
    //   113: goto -11 -> 102
    //   116: astore_2
    //   117: goto -18 -> 99
    //   120: astore_2
    //   121: goto -25 -> 96
    //   124: astore_2
    //   125: goto -20 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ImmLeaksCleaner
    //   0	128	1	paraml	androidx.lifecycle.l
    //   0	128	2	paramb	androidx.lifecycle.h.b
    //   62	9	3	localView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   37	45	110	java/lang/IllegalAccessException
    //   52	63	112	java/lang/IllegalAccessException
    //   52	63	116	java/lang/ClassCastException
    //   80	88	120	java/lang/IllegalAccessException
    //   52	63	124	finally
    //   67	69	124	finally
    //   70	79	124	finally
    //   80	88	124	finally
    //   88	90	124	finally
    //   96	98	124	finally
    //   99	101	124	finally
    //   102	104	124	finally
    //   105	107	124	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.ImmLeaksCleaner
 * JD-Core Version:    0.7.0.1
 */