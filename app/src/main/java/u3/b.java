package u3;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.a.a;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Bucket;
import g0.g;
import j1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import s3.j;

public class b
  implements a.a<Cursor>
{
  private androidx.loader.app.a a;
  private j<List<Bucket>> b;
  private boolean c;
  private final g0.a<String, Long> d = new g0.a();
  private final g0.a<String, String> e = new g0.a();
  private final g0.a<String, Uri> f = new g0.a();
  private final List<String> g = new LinkedList();
  private final AtomicInteger h = new AtomicInteger();
  private final AtomicInteger i = new AtomicInteger();
  
  public static b d(AppCompatActivity paramAppCompatActivity, boolean paramBoolean, j<List<Bucket>> paramj)
  {
    b localb = new b();
    localb.a = androidx.loader.app.a.c(paramAppCompatActivity);
    localb.b = paramj;
    localb.c = paramBoolean;
    return localb;
  }
  
  public c<Cursor> b(int paramInt, Bundle paramBundle)
  {
    return a.N(HoxinApplication.h(), this.c);
  }
  
  public void c(c<Cursor> paramc) {}
  
  public void e()
  {
    this.a.d(0, null, this);
  }
  
  public void f()
  {
    androidx.loader.app.a locala = this.a;
    if (locala != null) {
      locala.a(0);
    }
    this.b = null;
  }
  
  public void g(c<Cursor> paramc, Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    Object localObject2;
    while (paramCursor.moveToNext())
    {
      paramc = paramCursor.getString(paramCursor.getColumnIndex("bucket_id"));
      localObject1 = paramCursor.getString(paramCursor.getColumnIndex("bucket_display_name"));
      localObject2 = paramCursor.getString(paramCursor.getColumnIndex("mime_type"));
      g0.a locala = this.d;
      locala.put(paramc, Long.valueOf(((Long)locala.getOrDefault(paramc, Long.valueOf(0L))).longValue() + 1L));
      if (!this.g.contains(paramc)) {
        this.g.add(paramc);
      }
      if (!this.e.containsKey(paramc)) {
        this.e.put(paramc, localObject1);
      }
      if (localObject2 != null)
      {
        if (((String)localObject2).startsWith("image/")) {
          this.h.addAndGet(1);
        }
        if (((String)localObject2).startsWith("video/")) {
          this.i.addAndGet(1);
        }
        if (!this.f.containsKey("ALL_MEDIA_7458293244741369741")) {
          this.f.put("ALL_MEDIA_7458293244741369741", l.D(paramCursor));
        }
        if ((((String)localObject2).startsWith("image/")) && (!this.f.containsKey("IMAGE_ONLY_7458293244741369741"))) {
          this.f.put("IMAGE_ONLY_7458293244741369741", l.D(paramCursor));
        }
        if ((((String)localObject2).startsWith("video/")) && (!this.f.containsKey("VIDEO_ONLY_7458293244741369741"))) {
          this.f.put("VIDEO_ONLY_7458293244741369741", l.D(paramCursor));
        }
        if (!this.f.containsKey(paramc)) {
          this.f.put(paramc, l.D(paramCursor));
        }
      }
    }
    paramCursor = new ArrayList();
    Object localObject1 = this.g.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramc = (String)((Iterator)localObject1).next();
      localObject2 = new Bucket();
      ((Bucket)localObject2).id = paramc;
      ((Bucket)localObject2).name = ((String)this.e.get(paramc));
      ((Bucket)localObject2).cover = ((Uri)this.f.get(paramc));
      int j;
      if (Objects.equals(paramc, "ALL_MEDIA_7458293244741369741")) {
        j = this.h.get() + this.i.get();
      }
      label477:
      for (long l = j;; l = ((Long)this.d.getOrDefault(paramc, Long.valueOf(1L))).longValue())
      {
        ((Bucket)localObject2).size = l;
        break label500;
        if (Objects.equals(paramc, "IMAGE_ONLY_7458293244741369741")) {}
        for (paramc = this.h;; paramc = this.i)
        {
          j = paramc.get();
          break;
          if (!Objects.equals(paramc, "VIDEO_ONLY_7458293244741369741")) {
            break label477;
          }
        }
      }
      label500:
      paramCursor.add(localObject2);
    }
    this.b.A0(paramCursor);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.b
 * JD-Core Version:    0.7.0.1
 */