package b1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c
  extends a
{
  private int i;
  private int j;
  private LayoutInflater k;
  
  @Deprecated
  public c(Context paramContext, int paramInt, Cursor paramCursor, boolean paramBoolean)
  {
    super(paramContext, paramCursor, paramBoolean);
    this.j = paramInt;
    this.i = paramInt;
    this.k = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public View g(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.k.inflate(this.j, paramViewGroup, false);
  }
  
  public View h(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.k.inflate(this.i, paramViewGroup, false);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b1.c
 * JD-Core Version:    0.7.0.1
 */