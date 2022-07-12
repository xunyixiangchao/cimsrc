package l5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.e;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b5.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import s3.h;
import s3.u;
import u3.l;

public class a<T>
  extends PopupWindow
  implements u<Integer>
{
  private final RecyclerView a;
  private final MenuInflater b;
  private final b c;
  private final LinkedList<Integer> d = new LinkedList();
  private h<T> e;
  private T f;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 2130903862);
    this.b = new MenuInflater(paramContext);
    RecyclerView localRecyclerView = (RecyclerView)LayoutInflater.from(paramContext).inflate(2131427552, null);
    this.a = localRecyclerView;
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 1, false));
    paramContext = new b();
    this.c = paramContext;
    localRecyclerView.setAdapter(paramContext);
    paramContext.L(this);
    setContentView(localRecyclerView);
    setOutsideTouchable(true);
    setFocusable(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.d.clear();
    this.d.add(Integer.valueOf(2131231200));
    if (paramBoolean2) {
      this.d.add(Integer.valueOf(2131231209));
    }
    if (paramBoolean5) {
      this.d.add(Integer.valueOf(2131231234));
    }
    if (paramBoolean1) {
      this.d.add(Integer.valueOf(2131231197));
    }
    if (paramBoolean3) {
      this.d.add(Integer.valueOf(2131231237));
    }
    if (paramBoolean4) {
      this.d.add(Integer.valueOf(2131231252));
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d.clear();
    int i;
    if (!paramBoolean1)
    {
      localLinkedList = this.d;
      i = 2131231196;
    }
    else
    {
      localLinkedList = this.d;
      i = 2131231195;
    }
    localLinkedList.add(Integer.valueOf(i));
    LinkedList localLinkedList = this.d;
    if (!paramBoolean2) {
      i = 2131231218;
    } else {
      i = 2131231217;
    }
    localLinkedList.add(Integer.valueOf(i));
    this.d.add(Integer.valueOf(2131231201));
  }
  
  public void c(Integer paramInteger)
  {
    dismiss();
    this.e.c(paramInteger.intValue(), this.f);
  }
  
  public void d(h<T> paramh)
  {
    this.e = paramh;
  }
  
  @SuppressLint({"RestrictedApi"})
  public void e(T paramT, View paramView)
  {
    this.f = paramT;
    paramT = new int[2];
    paramView.getLocationInWindow(paramT);
    float f1 = ((Float)paramView.getTag(2131231638)).floatValue();
    float f2 = ((Float)paramView.getTag(2131231641)).floatValue();
    int i = (int)(paramT[0] + f1);
    int j = (int)(paramT[1] + f2);
    paramT = new e(getContentView().getContext());
    this.b.inflate(2131492865, paramT);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(paramT.findItem(((Integer)localIterator.next()).intValue()));
    }
    this.c.I(localLinkedList);
    l.p0(this.a);
    setHeight(this.a.getMeasuredHeight() + l.p(16.0F));
    super.showAtLocation(paramView, 0, i, j);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l5.a
 * JD-Core Version:    0.7.0.1
 */