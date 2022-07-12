package b1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public abstract class a
  extends BaseAdapter
  implements Filterable, b.a
{
  protected boolean a;
  protected boolean b;
  protected Cursor c;
  protected Context d;
  protected int e;
  protected a f;
  protected DataSetObserver g;
  protected b h;
  
  public a(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    f(paramContext, paramCursor, i);
  }
  
  public void a(Cursor paramCursor)
  {
    paramCursor = j(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public Cursor b()
  {
    return this.c;
  }
  
  public abstract CharSequence c(Cursor paramCursor);
  
  public abstract void e(View paramView, Context paramContext, Cursor paramCursor);
  
  void f(Context paramContext, Cursor paramCursor, int paramInt)
  {
    boolean bool = false;
    if ((paramInt & 0x1) == 1)
    {
      paramInt |= 0x2;
      this.b = true;
    }
    else
    {
      this.b = false;
    }
    if (paramCursor != null) {
      bool = true;
    }
    this.c = paramCursor;
    this.a = bool;
    this.d = paramContext;
    int i;
    if (bool) {
      i = paramCursor.getColumnIndexOrThrow("_id");
    } else {
      i = -1;
    }
    this.e = i;
    if ((paramInt & 0x2) == 2)
    {
      this.f = new a();
      paramContext = new b();
    }
    else
    {
      paramContext = null;
      this.f = null;
    }
    this.g = paramContext;
    if (bool)
    {
      paramContext = this.f;
      if (paramContext != null) {
        paramCursor.registerContentObserver(paramContext);
      }
      paramContext = this.g;
      if (paramContext != null) {
        paramCursor.registerDataSetObserver(paramContext);
      }
    }
  }
  
  public abstract View g(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public int getCount()
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a)
    {
      this.c.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = g(this.d, this.c, paramViewGroup);
      }
      e(localView, this.d, this.c);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.h == null) {
      this.h = new b(this);
    }
    return this.h;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return this.c;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if ((localCursor != null) && (localCursor.moveToPosition(paramInt))) {
        return this.c.getLong(this.e);
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a)
    {
      if (this.c.moveToPosition(paramInt))
      {
        View localView = paramView;
        if (paramView == null) {
          localView = h(this.d, this.c, paramViewGroup);
        }
        e(localView, this.d, this.c);
        return localView;
      }
      paramView = new StringBuilder();
      paramView.append("couldn't move cursor to position ");
      paramView.append(paramInt);
      throw new IllegalStateException(paramView.toString());
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public abstract View h(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected void i()
  {
    if (this.b)
    {
      Cursor localCursor = this.c;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        this.a = this.c.requery();
      }
    }
  }
  
  public Cursor j(Cursor paramCursor)
  {
    Cursor localCursor = this.c;
    if (paramCursor == localCursor) {
      return null;
    }
    Object localObject;
    if (localCursor != null)
    {
      localObject = this.f;
      if (localObject != null) {
        localCursor.unregisterContentObserver((ContentObserver)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
      }
    }
    this.c = paramCursor;
    if (paramCursor != null)
    {
      localObject = this.f;
      if (localObject != null) {
        paramCursor.registerContentObserver((ContentObserver)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        paramCursor.registerDataSetObserver((DataSetObserver)localObject);
      }
      this.e = paramCursor.getColumnIndexOrThrow("_id");
      this.a = true;
      notifyDataSetChanged();
      return localCursor;
    }
    this.e = -1;
    this.a = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
  
  private class a
    extends ContentObserver
  {
    a()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      a.this.i();
    }
  }
  
  private class b
    extends DataSetObserver
  {
    b() {}
    
    public void onChanged()
    {
      a locala = a.this;
      locala.a = true;
      locala.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      a locala = a.this;
      locala.a = false;
      locala.notifyDataSetInvalidated();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b1.a
 * JD-Core Version:    0.7.0.1
 */