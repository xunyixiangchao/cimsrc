package b1;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class b
  extends Filter
{
  a a;
  
  b(a parama)
  {
    this.a = parama;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.a.c((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.a.d(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
    }
    else
    {
      localFilterResults.count = 0;
      paramCharSequence = null;
    }
    localFilterResults.values = paramCharSequence;
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.a.b();
    paramFilterResults = paramFilterResults.values;
    if ((paramFilterResults != null) && (paramFilterResults != paramCharSequence)) {
      this.a.a((Cursor)paramFilterResults);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(Cursor paramCursor);
    
    public abstract Cursor b();
    
    public abstract CharSequence c(Cursor paramCursor);
    
    public abstract Cursor d(CharSequence paramCharSequence);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b1.b
 * JD-Core Version:    0.7.0.1
 */