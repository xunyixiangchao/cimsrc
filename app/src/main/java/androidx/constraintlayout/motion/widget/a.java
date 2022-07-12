package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.nio.CharBuffer;

@SuppressLint({"LogConditional"})
public class a
{
  public static String a()
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(") ");
    localStringBuilder.append(localStackTraceElement.getMethodName());
    localStringBuilder.append("()");
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String c(Context paramContext, int paramInt)
  {
    if (paramInt != -1) {}
    try
    {
      return paramContext.getResources().getResourceEntryName(paramInt);
    }
    catch (Exception paramContext)
    {
      break label17;
    }
    return "UNKNOWN";
    label17:
    paramContext = new StringBuilder();
    paramContext.append("?");
    paramContext.append(paramInt);
    return paramContext.toString();
  }
  
  public static String d(View paramView)
  {
    try
    {
      paramView = paramView.getContext().getResources().getResourceEntryName(paramView.getId());
      return paramView;
    }
    catch (Exception paramView)
    {
      label17:
      break label17;
    }
    return "UNKNOWN";
  }
  
  public static String e(MotionLayout paramMotionLayout, int paramInt)
  {
    return f(paramMotionLayout, paramInt, -1);
  }
  
  public static String f(MotionLayout paramMotionLayout, int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      return "UNDEFINED";
    }
    String str = paramMotionLayout.getContext().getResources().getResourceEntryName(paramInt1);
    Object localObject = str;
    if (paramInt2 != -1)
    {
      paramMotionLayout = str;
      if (str.length() > paramInt2) {
        paramMotionLayout = str.replaceAll("([^_])[aeiou]+", "$1");
      }
      localObject = paramMotionLayout;
      if (paramMotionLayout.length() > paramInt2)
      {
        paramInt1 = paramMotionLayout.replaceAll("[^_]", "").length();
        localObject = paramMotionLayout;
        if (paramInt1 > 0)
        {
          paramInt1 = (paramMotionLayout.length() - paramInt2) / paramInt1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CharBuffer.allocate(paramInt1).toString().replace('\000', '.'));
          ((StringBuilder)localObject).append("_");
          localObject = paramMotionLayout.replaceAll(((StringBuilder)localObject).toString(), "_");
        }
      }
    }
    return localObject;
  }
  
  public static void g(String paramString1, String paramString2, int paramInt)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 1;
    j = Math.min(paramInt, j - 1);
    String str = " ";
    paramInt = i;
    while (paramInt <= j)
    {
      Object localObject = arrayOfStackTraceElement[paramInt];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(".(");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getFileName());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getLineNumber());
      ((StringBuilder)localObject).append(") ");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getMethodName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      Log.v(paramString1, localStringBuilder.toString());
      paramInt += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.a
 * JD-Core Version:    0.7.0.1
 */