package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.MapLocationActivity;
import com.farsunset.hoxin.common.ui.PhotoSelectorActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.model.MomentExtra;

import e6.f;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import s3.p;
import u3.a0;

public class MomentPublishActivity
        extends BaseActivity
        implements s3.l, p<Void> {
    private b6.e e;
    private EditText f;
    private User g;
    private r3.b h;
    private final Moment i = new Moment();
    private Link j;
    private CloudVideo k;
    private RecyclerView l;
    private MapAddress m;
    private TextView n;
    private EventReceiver o;

    private void c1() {
        Link localLink = (Link) getIntent().getSerializableExtra(Link.NAME);
        this.j = localLink;
        if (localLink != null) {
            this.l.setVisibility(8);
            findViewById(2131231138).setVisibility(0);
            findViewById(2131231556).setVisibility(8);
            ((TextView) findViewById(2131231139)).setText(this.j.title);
        }
    }

    private void d1() {
        Object localObject = this.i;
        ((Moment) localObject).type = 3;
        ((Moment) localObject).text = this.f.getText().toString().trim();
        this.i.uid = this.g.id;
        if (this.e.M() > 1) {
            this.i.content = u3.l.H0(this.e.N());
            this.i.type = 4;
        }
        if (this.e.M() == 1) {
            this.i.content = u3.l.H0(this.e.L());
            this.i.type = 0;
        }
        localObject = this.j;
        Moment localMoment;
        if (localObject != null) {
            localMoment = this.i;
            localMoment.type = 1;
            localMoment.content = u3.l.H0(localObject);
        }
        localObject = this.k;
        if (localObject != null) {
            localMoment = this.i;
            localMoment.type = 2;
            localMoment.content = u3.l.H0(localObject);
        }
        localObject = new MomentExtra();
        ((MomentExtra) localObject).location = this.m;
        ((MomentExtra) localObject).device = Build.MODEL;
        this.i.extra = u3.l.H0(localObject);
    }

    private void e1() {
        Object localObject = (CloudImage) getIntent().getSerializableExtra(CloudImage.class.getName());
        if (localObject != null) {
            this.e.J(Uri.parse(((CloudImage) localObject).uri));
        }
        this.l.setVisibility(0);
        this.l.setAdapter(this.e);
        registerForContextMenu(this.l);
        localObject = new r3.b(this);
        this.h = ((r3.b) localObject);
        ((r3.b) localObject).n(this);
        this.h.k(2131690145);
        this.h.j(getString(2131689518), getString(2131689515));
    }

    private void f1() {
        Object localObject = (CloudVideo) getIntent().getSerializableExtra(CloudVideo.class.getName());
        this.k = ((CloudVideo) localObject);
        if (localObject == null) {
            return;
        }
        if (((CloudVideo) localObject).size > 52428800L) {
            X0(2131690047);
            this.k = null;
            return;
        }
        localObject = (WebImageView) findViewById(2131231552);
        this.l.setVisibility(8);
        findViewById(2131231608).setVisibility(0);
        findViewById(2131231556).setVisibility(8);
        ((WebImageView) localObject).l(a0.g(this.k.image));
    }

    private void h1() {
        if ((this.e.O()) && (u3.l.Z(this.f.getText())) && (this.j == null) && (this.k == null)) {
            X0(2131690113);
            return;
        }
        d1();
        U0(getString(2131690077, new Object[]{getString(2131689777)}));
        f.a(this.i);
    }

    public int H0() {
        return 2131427395;
    }

    public int I0() {
        return 2131689777;
    }

    public void M0() {
        this.g = i3.e.g();
        Object localObject = (RecyclerView) findViewById(2131231073);
        this.l = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setHasFixedSize(true);
        localObject = new GridLayoutManager(this, 5, 1, false);
        this.l.setLayoutManager((RecyclerView.p) localObject);
        this.l.setItemAnimator(new androidx.recyclerview.widget.e());
        this.l.setEnabled(false);
        this.f = ((EditText) findViewById(2131230906));
        localObject = new b6.e();
        this.e = ((b6.e) localObject);
        ((b6.e) localObject).S(this);
        this.n = ((TextView) findViewById(2131230797));
        e1();
        c1();
        f1();
        localObject = new EventReceiver();
        this.o = ((EventReceiver) localObject);
        HoxinApplication.p((BroadcastReceiver) localObject, ((EventReceiver) localObject).a());
    }

    public void S() {
        this.h.dismiss();
        u3.l.C0(this);
    }

    public void g1(Void paramVoid, View paramView) {
        if (this.e.M() == 9) {
            X0(2131690079);
            return;
        }
        this.h.show();
    }

    public void m() {
        this.h.dismiss();
        Intent localIntent = new Intent(this, PhotoSelectorActivity.class);
        int i1 = this.e.d();
        boolean bool = true;
        if (i1 <= 1) {
            bool = false;
        }
        localIntent.putExtra("ATTR_IMAGE_ONLY", bool);
        localIntent.setAction("com.farsunset.hoxin.ACTION_MULTIPLE_PHOTO_SELECTOR");
        localIntent.putExtra("ATTR_MAX_COUNT", 9 - this.e.M());
        startActivityForResult(localIntent, 1587);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        Object localObject;
        if ((paramInt2 == -1) && (paramInt1 == 1587) && (u3.l.b0(paramIntent.getType()))) {
            localObject = (List) paramIntent.getSerializableExtra("ATTR_FILE_LIST");
            this.e.K((List) localObject);
        }
        if ((paramInt2 == -1) && (paramInt1 == 1587) && (u3.l.f0(paramIntent.getType()))) {
            localObject = u3.l.o0(paramIntent.getData(), o3.b.g);
            getIntent().putExtra(CloudVideo.class.getName(), (Serializable) localObject);
            f1();
        }
        if ((paramInt2 == -1) && (paramInt1 == 1920)) {
            this.e.J(i3.e.m());
        }
        if ((paramInt2 == -1) && (paramInt1 == 321)) {
            this.m = ((MapAddress) paramIntent.getSerializableExtra(MapAddress.class.getName()));
            this.n.setSelected(true);
            this.n.setText(this.m.name);
            findViewById(2131230852).setVisibility(0);
        }
    }

    public void onClearLocationClick(View paramView) {
        this.m = null;
        this.n.setSelected(false);
        this.n.setText(2131689843);
        findViewById(2131230852).setVisibility(4);
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2147483647) {
            this.e.R();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        paramContextMenu.add(1, 2147483647, 1, getString(2131689528));
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492888, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        HoxinApplication.D(this.o);
    }

    public void onLocationClick(View paramView) {
        paramView = new Intent(this, MapLocationActivity.class);
        paramView.setAction("com.farsunset.hoxin.ACTION_SELECT_ADDRESS");
        startActivityForResult(paramView, 321);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231241) {
            h1();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public class EventReceiver
            extends BroadcastReceiver {
        public EventReceiver() {
        }

        IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_MOMENT_CREATE_ERROR");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_MOMENT_CREATE_FINISH");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            MomentPublishActivity.this.J0();
            if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_MOMENT_CREATE_FINISH")) {
                MomentPublishActivity.this.X0(2131690109);
                paramIntent.putExtra(Moment.class.getName(), MomentPublishActivity.a1(MomentPublishActivity.this));
                MomentPublishActivity.this.setResult(-1, paramIntent);
                MomentPublishActivity.this.finish();
                MomentPublishActivity.b1(MomentPublishActivity.this).N().clear();
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.MomentPublishActivity

 * JD-Core Version:    0.7.0.1

 */