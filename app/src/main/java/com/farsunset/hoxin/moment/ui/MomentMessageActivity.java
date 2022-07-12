package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import b6.c;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.api.response.MomentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;

import i5.a;
import s3.p;

public class MomentMessageActivity
        extends BaseActivity
        implements p<Comment>, s3.e<MomentResult> {
    private c e;
    private GlobalEmptyView f;

    private void c1(long paramLong) {
        U0(getString(2131690077, new Object[]{getString(2131689535)}));
        d6.b.f(paramLong, this);
    }

    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131689776;
    }

    public void M0() {
        this.e = new c();
        Object localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        registerForContextMenu((View) localObject);
        ((RecyclerView) localObject).setAdapter(this.e);
        this.e.I(j5.b.s());
        this.e.N(this);
        j5.b.w(a.a);
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.f = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).a(this.e);
    }

    public void a1(MomentResult paramMomentResult) {
        J0();
        if ((paramMomentResult.isSuccess()) && (paramMomentResult.data == null)) {
            X0(2131690011);
            return;
        }
        Intent localIntent = new Intent(this, MomentDetailedActivity.class);
        localIntent.putExtra(Moment.class.getName(), paramMomentResult.data);
        startActivity(localIntent);
    }

    public void b1(Comment paramComment, View paramView) {
        paramView = g6.b.g(paramComment.momentId);
        if (paramView != null) {
            paramComment = new Intent(this, MomentDetailedActivity.class);
            paramComment.putExtra(Moment.class.getName(), paramView);
            startActivity(paramComment);
            return;
        }
        c1(paramComment.momentId);
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131230934) {
            paramMenuItem = this.e.J();
            this.e.K(paramMenuItem);
            j5.b.d(paramMenuItem.id);
            this.f.a(this.e);
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        paramContextMenu.add(1, 2131230934, 1, getString(2131689528));
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.MomentMessageActivity

 * JD-Core Version:    0.7.0.1

 */