package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.a;
import java.util.HashMap;
import java.util.HashSet;

public abstract class d
{
  public static int f = -1;
  int a;
  int b;
  String c;
  protected int d;
  HashMap<String, a> e;
  
  public d()
  {
    int i = f;
    this.a = i;
    this.b = i;
    this.c = null;
  }
  
  public abstract void a(HashMap<String, n0.d> paramHashMap);
  
  public abstract d b();
  
  public d c(d paramd)
  {
    this.a = paramd.a;
    this.b = paramd.b;
    this.c = paramd.c;
    this.d = paramd.d;
    this.e = paramd.e;
    return this;
  }
  
  abstract void d(HashSet<String> paramHashSet);
  
  abstract void e(Context paramContext, AttributeSet paramAttributeSet);
  
  boolean f(String paramString)
  {
    String str = this.c;
    if ((str != null) && (paramString != null)) {
      return paramString.matches(str);
    }
    return false;
  }
  
  public void g(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void h(HashMap<String, Integer> paramHashMap) {}
  
  public d i(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  boolean j(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    return Boolean.parseBoolean(paramObject.toString());
  }
  
  float k(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    return Float.parseFloat(paramObject.toString());
  }
  
  int l(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    return Integer.parseInt(paramObject.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.d
 * JD-Core Version:    0.7.0.1
 */