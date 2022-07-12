package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.widget.SimpleInputPanelView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import s3.l;
import s3.p;

public class MomentDetailedActivity
        extends CIMMonitorActivity
        implements s3.n, l, p<Comment>, s3.e {
    private b6.b e;
    private RecyclerView f;
    private Moment g;
    private SimpleInputPanelView h;
    private User i;
    private r3.b j;
    private Comment k;
    private String l = "0";
    private String m;
    private final androidx.core.app.n n = new a();

    private void c1() {
        this.l = "0";
        this.k = null;
        this.h.setContent(null);
        this.h.setHint(null);
    }

    private void d1() {
        g6.b.c(this.g.id);
        Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_DELETE_MOMENT");
        localIntent.putExtra(Moment.class.getName(), this.g);
        HoxinApplication.t(localIntent);
        finish();
    }

    private void e1(CommentResult paramCommentResult) {
        g6.a.a(paramCommentResult.data);
        this.g.add(paramCommentResult.data);
        this.e.J(paramCommentResult.data);
        this.f.s1(this.e.d());
        c1();
    }

    private void g1(String paramString) {
        Comment localComment = new Comment();
        if ("1".equals(this.l)) {
            localComment.parentId = Long.valueOf(this.k.id);
        }
        localComment.content = paramString;
        localComment.momentId = this.g.id;
        localComment.type = this.l;
        d6.a.e(localComment, this);
    }

    public int H0() {
        return 2131427394;
    }

    public int I0() {
        return 2131689529;
    }

    public void M0() {
        this.i = i3.e.g();
        this.g = ((Moment) getIntent().getSerializableExtra(Moment.class.getName()));
        this.h = ((SimpleInputPanelView) findViewById(2131231088));
        Object localObject = (RecyclerView) findViewById(2131231391);
        this.f = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        this.f.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f.h(new f(this, 1));
        if ((!i4.a.o(this.g.uid)) && (this.i.id != this.g.uid)) {
            this.h.setVisibility(8);
            this.g.setCommentList(new ArrayList());
            this.f.setAdapter(new b6.b(this.g));
            return;
        }
        if (this.g.getAllCount() == 0) {
            localObject = this.g;
            ((Moment) localObject).setCommentList(g6.a.f(((Moment) localObject).id));
        }
        localObject = new b6.b(this.g);
        this.e = ((b6.b) localObject);
        ((b6.b) localObject).L(this);
        this.f.setAdapter(this.e);
        setExitSharedElementCallback(this.n);
        this.h.setOnInputPanelEventListener(this);
    }

    public void S() {
        this.j.dismiss();
    }

    public void f1(Comment paramComment, View paramView) {
        if (paramView.getId() == 2131230827) {
        }
        for (; ; ) {
            this.h.n();
            return;
            if (paramComment == null) {
                break;
            }
            long l1 = paramComment.uid;
            if (l1 == this.i.id) {
                break;
            }
            this.k = paramComment;
            this.l = "1";
            paramComment = i3.e.k(l1);
            this.h.setHint(getString(2131689590, new Object[]{paramComment}));
        }
        c1();
    }

    public void j0() {
    }

    public void m() {
        this.j.dismiss();
        d6.b.c(this.g.id, this);
    }

    public void n0(String paramString) {
        g1(paramString);
        this.h.m();
    }

    public void onActivityReenter(int paramInt, Intent paramIntent) {
        super.onActivityReenter(paramInt, paramIntent);
        this.m = paramIntent.getStringExtra("ATTR_URL");
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (this.i.id == this.g.uid) {
            getMenuInflater().inflate(2131492891, paramMenu);
            paramMenu.findItem(2131231210).setIcon(2131165662);
            r3.b localb = new r3.b(this);
            this.j = localb;
            localb.n(this);
            this.j.k(2131690037);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_REFRESH_MOMENT");
        localIntent.putExtra(Moment.class.getName(), this.g);
        HoxinApplication.t(localIntent);
    }

    public void onHttpException(Exception paramException) {
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        if ((paramBaseResult instanceof CommentResult)) {
            e1((CommentResult) paramBaseResult);
            return;
        }
        d1();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            this.j.show();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void q(boolean paramBoolean) {
    }

    public void q0(String paramString) {
    }

    class a
            extends androidx.core.app.n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            if (MomentDetailedActivity.a1(MomentDetailedActivity.this) != null) {
                paramMap.put(MomentDetailedActivity.a1(MomentDetailedActivity.this), MomentDetailedActivity.b1(MomentDetailedActivity.this).findViewWithTag(MomentDetailedActivity.a1(MomentDetailedActivity.this)));
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.MomentDetailedActivity

 * JD-Core Version:    0.7.0.1

 */