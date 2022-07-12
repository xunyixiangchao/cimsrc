package j3;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import ca.a;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.AlbumMedia;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import s3.o;
import s3.p;
import u3.l;

public class b
  extends RecyclerView.h<k3.b>
  implements CompoundButton.OnCheckedChangeListener, View.OnClickListener
{
  private final List<AlbumMedia> d = new ArrayList();
  private final ArrayList<AlbumMedia> e = new ArrayList();
  private final String f;
  private final int g;
  private final int h;
  private o i;
  private p<Object> j;
  
  public b(String paramString, int paramInt)
  {
    this.f = paramString;
    this.g = paramInt;
    this.h = ((Resources.getSystem().getDisplayMetrics().widthPixels - l.p(9.0F)) / 4);
  }
  
  public void I(List<AlbumMedia> paramList)
  {
    this.d.addAll(paramList);
  }
  
  public void J()
  {
    this.d.clear();
  }
  
  public ArrayList<Uri> K()
  {
    ArrayList localArrayList = new ArrayList(this.e.size());
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((AlbumMedia)localIterator.next()).uri);
    }
    return localArrayList;
  }
  
  public int L()
  {
    return this.e.size();
  }
  
  public void M(k3.b paramb, int paramInt)
  {
    AlbumMedia localAlbumMedia = (AlbumMedia)this.d.get(paramInt);
    paramb.a.setTag(localAlbumMedia);
    paramb.a.setTag(2131231047, paramb);
    paramb.v.setOnCheckedChangeListener(null);
    paramb.v.setChecked(this.e.contains(localAlbumMedia));
    paramb.v.setTag(localAlbumMedia);
    paramb.v.setVisibility(0);
    paramb.v.setOnCheckedChangeListener(this);
    paramb.v.setTag(2131231047, paramb);
    paramb.a.setOnClickListener(this);
    View localView = paramb.y;
    if (paramb.v.isChecked()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    if ((Objects.equals(this.f, "com.farsunset.hoxin.ACTION_MULTIPLE_PHOTO_SELECTOR")) && (!localAlbumMedia.isVideo())) {
      paramb.v.setVisibility(0);
    } else {
      paramb.v.setVisibility(8);
    }
    if (localAlbumMedia.isVideo())
    {
      paramb.w.setVisibility(0);
      paramb.x.setVisibility(0);
      paramb.w.setText(l.I0(localAlbumMedia.duration));
      paramb.w.setText(paramb.a.getContext().getString(2131689896, new Object[] { Long.valueOf(localAlbumMedia.duration / 1000L) }));
      paramb.x.setText(a.a(localAlbumMedia.size));
    }
    else
    {
      paramb.w.setVisibility(8);
      paramb.x.setVisibility(8);
    }
    paramb.u.k(localAlbumMedia.uri, 2131034649);
  }
  
  public k3.b N(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427446, paramViewGroup, false);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, this.h));
    return new k3.b(paramViewGroup);
  }
  
  public void O(o paramo)
  {
    this.i = paramo;
  }
  
  public void P(p<Object> paramp)
  {
    this.j = paramp;
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.e.add((AlbumMedia)paramCompoundButton.getTag());
    }
    int k = 0;
    if ((!paramBoolean) || (this.e.size() > this.g))
    {
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(false);
      this.e.remove(paramCompoundButton.getTag());
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    View localView = ((k3.b)paramCompoundButton.getTag(2131231047)).y;
    if (!paramCompoundButton.isChecked()) {
      k = 8;
    }
    localView.setVisibility(k);
    this.i.i0(paramCompoundButton.getTag(), paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    AlbumMedia localAlbumMedia = (AlbumMedia)paramView.getTag();
    k3.b localb = (k3.b)paramView.getTag(2131231047);
    if ((localAlbumMedia.isImage()) && (Objects.equals(this.f, "com.farsunset.hoxin.ACTION_MULTIPLE_PHOTO_SELECTOR")))
    {
      CloudImage localCloudImage = new CloudImage();
      localCloudImage.uri = localAlbumMedia.uri.toString();
      HoxinApplication.h().z(paramView.getContext(), localCloudImage, localb.u);
      return;
    }
    this.j.C0(localAlbumMedia, paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.b
 * JD-Core Version:    0.7.0.1
 */