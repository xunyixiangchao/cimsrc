package r3;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;
import com.farsunset.hoxin.common.model.Bucket;
import java.util.List;
import s3.p;

public class a
  extends com.google.android.material.bottomsheet.a
{
  private final j3.a n;
  
  public a(Context paramContext, p paramp)
  {
    super(paramContext);
    paramContext = (RecyclerView)LayoutInflater.from(paramContext).inflate(2131427538, null);
    paramContext.setLayoutManager(new LinearLayoutManager(getContext()));
    paramContext.setItemAnimator(new e());
    j3.a locala = new j3.a();
    this.n = locala;
    paramContext.setAdapter(locala);
    locala.L(paramp);
    setContentView(paramContext);
  }
  
  public void o(List<Bucket> paramList)
  {
    this.n.I(paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r3.a
 * JD-Core Version:    0.7.0.1
 */