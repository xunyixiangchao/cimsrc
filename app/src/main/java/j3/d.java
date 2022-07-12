package j3;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import ca.a;
import com.farsunset.hoxin.common.model.SharedFile;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import s3.p;
import u3.a0;
import u3.g0;
import u3.l;

public class d
  extends RecyclerView.h<k3.d>
  implements View.OnClickListener, Comparator<SharedFile>, Serializable
{
  private p<SharedFile> d;
  private final List<SharedFile> e = new LinkedList();
  private SharedFile f;
  private ViewGroup g;
  
  public d()
  {
    J();
  }
  
  private void J()
  {
    File[] arrayOfFile = a0.d().listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      SharedFile localSharedFile = new SharedFile();
      localSharedFile.name = localFile.getName();
      localSharedFile.size = localFile.length();
      localSharedFile.lastModified = localFile.lastModified();
      localSharedFile.uri = Uri.fromFile(localFile);
      this.e.add(localSharedFile);
      i += 1;
    }
    Collections.sort(this.e, this);
  }
  
  public int I(SharedFile paramSharedFile1, SharedFile paramSharedFile2)
  {
    return Long.compare(paramSharedFile2.lastModified, paramSharedFile1.lastModified);
  }
  
  public void K(k3.d paramd, int paramInt)
  {
    SharedFile localSharedFile = (SharedFile)this.e.get(paramInt);
    paramd.w.setText(localSharedFile.name);
    String str1 = a.a(localSharedFile.size);
    String str2 = l.x(localSharedFile.lastModified);
    paramd.x.setText(l.J(2131689700, new Object[] { str1, str2 }));
    paramd.v.setVisibility(0);
    paramd.v.setChecked(localSharedFile.equals(this.f));
    paramd.u.setImageResource(g0.e(localSharedFile.name));
    paramd.a.setTag(2131231047, paramd);
    paramd.a.setTag(localSharedFile);
    paramd.a.setOnClickListener(this);
  }
  
  public k3.d L(ViewGroup paramViewGroup, int paramInt)
  {
    this.g = paramViewGroup;
    return new k3.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427491, paramViewGroup, false));
  }
  
  public void M()
  {
    this.e.clear();
    this.f = null;
    J();
    super.j();
  }
  
  public void N(SharedFile paramSharedFile)
  {
    this.e.clear();
    this.e.add(paramSharedFile);
    this.f = paramSharedFile;
    super.j();
  }
  
  public void O(p<SharedFile> paramp)
  {
    this.d = paramp;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    SharedFile localSharedFile = (SharedFile)paramView.getTag();
    k3.d locald = (k3.d)paramView.getTag(2131231047);
    View localView = this.g.findViewWithTag(this.f);
    if (localView != null) {
      ((k3.d)localView.getTag(2131231047)).v.setChecked(false);
    }
    locald.v.setChecked(true);
    this.f = localSharedFile;
    this.d.C0(localSharedFile, paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.d
 * JD-Core Version:    0.7.0.1
 */