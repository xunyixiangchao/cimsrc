package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.c;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import b5.k;
import b6.f;
import b6.g;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.ui.VideoRecorderActivity;
import com.farsunset.hoxin.common.widget.CustomSwipeRefreshLayout;
import com.farsunset.hoxin.common.widget.LoadMoreRecyclerView;
import com.farsunset.hoxin.common.widget.SimpleInputPanelView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.api.response.MomentListResult;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.widget.CommentListView;
import com.farsunset.hoxin.moment.widget.TimelineMomentView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import s3.r;
import s3.s;
import u3.d;

public class TimelineMomentActivity
        extends CIMMonitorActivity
        implements r, s, j6.a, s3.n, s3.e {
    private CustomSwipeRefreshLayout e;
    private g f;
    private f g;
    private LoadMoreRecyclerView h;
    private int i = 0;
    private SimpleInputPanelView j;
    private InnerMomentReceiver k;
    private CommentListView l;
    private Comment m;
    private String n;
    private final androidx.core.app.n o = new a();

    private void f1() {
        this.j.setHint(null);
        this.j.setContent(null);
    }

    private void g1(CommentResult paramCommentResult) {
        g6.a.a(paramCommentResult.data);
        this.l.c(paramCommentResult.data);
        f1();
    }

    private void h1(MomentListResult paramMomentListResult) {
        this.e.x();
        d.B();
        if ((paramMomentListResult.isNotEmpty()) && (this.i == 0) && (!this.f.O(paramMomentListResult.data))) {
            this.f.R(paramMomentListResult.data);
            g6.b.b(paramMomentListResult.data);
        }
        for (; ; ) {
            this.h.I1(paramMomentListResult.page);
            return;
            if ((paramMomentListResult.isNotEmpty()) && (this.i > 0)) {
                this.f.J(paramMomentListResult.data);
            } else {
                if (paramMomentListResult.isEmpty()) {
                    int i1 = this.i;
                    if (i1 > 0) {
                        this.i = (i1 - 1);
                        continue;
                    }
                }
                if ((paramMomentListResult.isEmpty()) && (this.i == 0)) {
                    this.f.K();
                    g6.b.d();
                }
            }
        }
    }

    private void i1(String paramString) {
        Comment localComment = this.m;
        localComment.content = paramString;
        d6.a.e(localComment, this);
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (Arrays.asList(i5.a.a).contains(paramMessage.action)) {
            paramChatSession = g6.a.h(Long.parseLong(paramMessage.content));
            paramMessage = (TimelineMomentView) this.h.findViewWithTag(Long.valueOf(paramChatSession.momentId));
            if ((paramMessage != null) && (paramChatSession.type.equals("2"))) {
                paramMessage.f(paramChatSession);
            }
            if ((paramMessage != null) && (paramChatSession.type.equals("1"))) {
                paramMessage.e(paramChatSession);
            }
            this.g.K();
        }
    }

    public int H0() {
        return 2131427407;
    }

    public int I0() {
        return 2131689708;
    }

    public void M0() {
        Object localObject = (CustomSwipeRefreshLayout) findViewById(2131231489);
        this.e = ((CustomSwipeRefreshLayout) localObject);
        ((CustomSwipeRefreshLayout) localObject).setOnRefreshListener(this);
        this.e.setLimited(true);
        localObject = (LoadMoreRecyclerView) findViewById(2131231261);
        this.h = ((LoadMoreRecyclerView) localObject);
        ((LoadMoreRecyclerView) localObject).setOnLoadEventListener(this);
        localObject = (SimpleInputPanelView) findViewById(2131231088);
        this.j = ((SimpleInputPanelView) localObject);
        ((SimpleInputPanelView) localObject).setOnInputPanelEventListener(this);
        localObject = new g();
        this.f = ((g) localObject);
        ((g) localObject).S(this);
        this.f.J(g6.b.k());
        this.g = new f();
        localObject = new k(this);
        c localc = new c(new RecyclerView.h[]{this.g, this.f, localObject});
        this.h.setAdapter(localc);
        this.h.setFooterView(((k) localObject).I());
        localObject = new InnerMomentReceiver();
        this.k = ((InnerMomentReceiver) localObject);
        HoxinApplication.p((BroadcastReceiver) localObject, ((InnerMomentReceiver) localObject).a());
        if ((!d.t()) || (g6.b.i())) {
            this.e.y();
        }
        j5.b.g("500");
        this.a.setOnClickListener(this);
        setExitSharedElementCallback(this.o);
    }

    public void e() {
        if (this.e.h()) {
            this.h.I1(null);
            return;
        }
        int i1 = this.i + 1;
        this.i = i1;
        d6.b.j(i1, this);
    }

    public void j0() {
    }

    public void n0(String paramString) {
        i1(paramString);
        this.j.g();
    }

    public void onActivityReenter(int paramInt, Intent paramIntent) {
        super.onActivityReenter(paramInt, paramIntent);
        this.n = paramIntent.getStringExtra("ATTR_URL");
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 7452)) {
            this.f.I((Moment) paramIntent.getSerializableExtra(Moment.class.getName()));
            this.h.s1(0);
        }
        if ((paramInt2 == -1) && (paramInt1 == 3685)) {
            paramIntent.setClass(this, MomentPublishActivity.class);
            startActivityForResult(paramIntent, 7452);
        }
    }

    public void onClick(View paramView) {
        if (paramView == this.a) {
            this.h.k1(0);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492881, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        HoxinApplication.D(this.k);
        super.onDestroy();
    }

    public void onHttpException(Exception paramException) {
        this.h.I1(null);
        this.e.x();
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        if ((paramBaseResult instanceof CommentResult)) {
            g1((CommentResult) paramBaseResult);
        }
        if ((paramBaseResult instanceof MomentListResult)) {
            h1((MomentListResult) paramBaseResult);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231232) {
            startActivityForResult(new Intent(this, MomentPublishActivity.class), 7452);
        }
        if (paramMenuItem.getItemId() == 2131231194) {
            Intent localIntent = new Intent(this, VideoRecorderActivity.class);
            localIntent.setAction("com.farsunset.hoxin.ACTION_FROM_MOMENT");
            startActivityForResult(localIntent, 3685);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void q(boolean paramBoolean) {
    }

    public void q0(String paramString) {
    }

    public void s0() {
        this.i = 0;
        d6.b.j(0, this);
    }

    public void w0(CommentListView paramCommentListView, Moment paramMoment, Comment paramComment) {
        this.m = paramComment;
        if (paramComment.parentId == null) {
            long l1 = i3.e.o().longValue();
            long l2 = paramMoment.uid;
            if (l1 != l2) {
                this.j.setHint(getString(2131689590, new Object[]{i3.e.k(l2)}));
            }
        }
        Long localLong = paramComment.parentId;
        if (localLong != null) {
            paramMoment = paramMoment.findOne(localLong);
            this.j.setHint(getString(2131689590, new Object[]{i3.e.k(paramMoment.uid)}));
        }
        this.l = paramCommentListView;
        int i2 = this.j.getPanelHeight();
        int i3 = Resources.getSystem().getDisplayMetrics().heightPixels;
        int i1;
        if (paramComment.parentId == null) {
            paramCommentListView = this.h;
            i1 = this.l.getOnScreenY();
        } else {
            paramCommentListView = this.h;
            i1 = this.l.getLastTouchY();
        }
        paramCommentListView.o1(0, i2 - (i3 - i1));
        this.j.n();
    }

    public void y() {
        if (this.j.getVisibility() == 0) {
            this.j.g();
            f1();
        }
    }

    public class InnerMomentReceiver
            extends BroadcastReceiver {
        public InnerMomentReceiver() {
        }

        IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_DELETE_MOMENT");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_REFRESH_MOMENT");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_MOMENT_WALLPAPER_CHANGED");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            paramContext = (Moment) paramIntent.getSerializableExtra(Moment.class.getName());
            if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_DELETE_MOMENT")) {
                TimelineMomentActivity.a1(TimelineMomentActivity.this).Q(paramContext);
            }
            if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_REFRESH_MOMENT")) {
                TimelineMomentActivity.a1(TimelineMomentActivity.this).T(paramContext);
            }
            if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_MOMENT_WALLPAPER_CHANGED")) {
                TimelineMomentActivity.b1(TimelineMomentActivity.this).L();
            }
        }
    }

    class a
            extends androidx.core.app.n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            if (TimelineMomentActivity.c1(TimelineMomentActivity.this) != null) {
                paramMap.put(TimelineMomentActivity.c1(TimelineMomentActivity.this), TimelineMomentActivity.e1(TimelineMomentActivity.this).findViewWithTag(TimelineMomentActivity.c1(TimelineMomentActivity.this)));
                TimelineMomentActivity.d1(TimelineMomentActivity.this, null);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.TimelineMomentActivity

 * JD-Core Version:    0.7.0.1

 */