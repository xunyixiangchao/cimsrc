package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.o;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.LinearBadgeMenuView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import e5.a;
import e5.c;
import e5.f;
import e5.g;
import e5.i;

import java.util.Calendar;

import s3.a0;
import s3.p;
import v3.d;

public class MessageSearchActivity
        extends BaseActivity
        implements a0, r5.b, DatePickerDialog.OnDateSetListener, p<Object> {
    protected ChatSession e;
    private RecyclerView f;
    private ToolbarSearchView g;
    private GlobalEmptyView h;
    private final b5.e i = new b5.e();
    private final RecyclerView.o j = new d();
    private final GridLayoutManager k;
    private final LinearLayoutManager l;
    private final g m;
    private final c n;
    private final i o;
    private final a p;
    private final e5.e q;
    private DatePickerDialog r;
    private LinearBadgeMenuView s;
    private final Object t;
    private final Object u;
    private final Object v;
    private final Object w;
    private final Object x;

    public MessageSearchActivity() {
        GridLayoutManager localGridLayoutManager = new GridLayoutManager(this, 2, 1, false);
        this.k = localGridLayoutManager;
        this.l = new LinearLayoutManager(this);
        this.m = new g(this);
        this.n = new c(localGridLayoutManager, this);
        this.o = new i(localGridLayoutManager, this);
        this.p = new a(this);
        this.q = new e5.e(localGridLayoutManager, this);
        this.t = Integer.valueOf(0);
        this.u = Integer.valueOf(1);
        this.v = Integer.valueOf(2);
        this.w = Integer.valueOf(3);
        this.x = Integer.valueOf(4);
    }

    private void a1() {
        if (this.r != null) {
            return;
        }
        Calendar localCalendar = Calendar.getInstance();
        this.r = new DatePickerDialog(this, 2131756074, this, localCalendar.get(1), localCalendar.get(2), localCalendar.get(5));
    }

    private void b1(byte paramByte, f<?> paramf, boolean paramBoolean) {
        String str = this.g.getText();
        if (paramBoolean) {
            this.g.e();
            paramf.J(j5.b.y(Long.valueOf(this.e.id), paramByte, str), str);
        } else {
            this.g.c();
            paramf.I(j5.b.x(Long.valueOf(this.e.id), paramByte));
        }
        this.f.setLayoutManager(this.k);
        this.f.Z0(this.j);
        this.f.h(this.j);
        this.f.setAdapter(paramf);
        this.h.a(paramf);
    }

    private void c1(byte paramByte, f<?> paramf, boolean paramBoolean) {
        Object localObject = this.g.getText();
        this.g.e();
        this.f.setLayoutManager(this.l);
        this.f.Z0(this.j);
        if ((!paramBoolean) && (TextUtils.isEmpty((CharSequence) localObject))) {
            this.f.setAdapter(this.i);
            localObject = this.h;
            paramf = this.i;
        }
        for (; ; ) {
            ((GlobalEmptyView) localObject).a(paramf);
            return;
            paramf.J(j5.b.y(Long.valueOf(this.e.id), paramByte, (String) localObject), (String) localObject);
            this.f.setAdapter(paramf);
            localObject = this.h;
        }
    }

    public void C0(Object paramObject, View paramView) {
        if (paramObject == this.t) {
            this.g.setHint(2131689632);
            c1((byte) 0, this.m, false);
        }
        if (paramObject == this.u) {
            b1((byte) 1, this.n, false);
        }
        if (paramObject == this.v) {
            b1((byte) 3, this.o, false);
        }
        if (paramObject == this.w) {
            this.g.setHint(2131689593);
            c1((byte) 4, this.p, true);
        }
        if (paramObject == this.x) {
            this.g.setHint(2131689607);
            b1((byte) 5, this.q, true);
        }
    }

    public int H0() {
        return 2131427387;
    }

    public int I0() {
        return 2131690164;
    }

    public void L(Message paramMessage) {
        Intent localIntent = new Intent(this, FriendMessageTargetActivity.class);
        localIntent.putExtra("MESSAGE", paramMessage);
        localIntent.putExtra("ATTR_CHAT_SESSION", this.e);
        startActivity(localIntent);
    }

    public void M0() {
        this.e = ((ChatSession) getIntent().getSerializableExtra("ATTR_CHAT_SESSION"));
        Object localObject = (GlobalEmptyView) findViewById(2131230981);
        this.h = ((GlobalEmptyView) localObject);
        ((FrameLayout) localObject).setVisibility(0);
        localObject = (RecyclerView) findViewById(2131231391);
        this.f = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(this.l);
        this.f.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f.setHasFixedSize(true);
        localObject = (LinearBadgeMenuView) findViewById(2131230821);
        this.s = ((LinearBadgeMenuView) localObject);
        ((LinearBadgeMenuView) localObject).setOnItemClickedListener(this);
        this.s.b(this.t, 2131689558, Integer.valueOf(2131165642));
        this.s.b(this.u, 2131689537, Integer.valueOf(2131165640));
        this.s.b(this.v, 2131689563, Integer.valueOf(2131165643));
        this.s.b(this.w, 2131689533, Integer.valueOf(2131165639));
        this.s.b(this.x, 2131689540, Integer.valueOf(2131165641));
        this.s.setSelected(this.t);
        this.s.d(this.t, 0.8F);
        this.s.d(this.u, 0.8F);
        this.s.d(this.v, 0.8F);
        this.s.d(this.w, 1.0F);
        this.s.d(this.x, 1.0F);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        this.g = ((ToolbarSearchView) localObject);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        this.g.setHint(2131689632);
        this.g.setText(getIntent().getStringExtra("ATTR_KEYWORD"));
        this.g.d();
    }

    public void h0(String paramString) {
        if (this.s.c(this.w)) {
            c1((byte) 4, this.p, true);
        }
        if (this.s.c(this.t)) {
            c1((byte) 0, this.m, false);
        }
        if (this.s.c(this.x)) {
            b1((byte) 5, this.q, true);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492884, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
        this.r.dismiss();
        paramDatePicker = Calendar.getInstance();
        paramDatePicker.set(1, paramInt1);
        paramDatePicker.set(2, paramInt2);
        paramDatePicker.set(5, paramInt3);
        paramDatePicker.set(11, 0);
        paramDatePicker.set(12, 0);
        paramDatePicker.set(13, 0);
        paramDatePicker.set(14, 0);
        L(j5.b.k(Long.valueOf(this.e.id), paramDatePicker.getTimeInMillis()));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231249) {
            a1();
            this.r.show();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.MessageSearchActivity

 * JD-Core Version:    0.7.0.1

 */