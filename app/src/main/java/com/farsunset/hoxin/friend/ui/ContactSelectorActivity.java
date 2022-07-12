package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;

import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.CharSelectorBar;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.friend.entity.Friend;

import e4.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import s3.a0;
import s3.c0;
import s3.i;
import s3.p;
import u3.l;
import v3.h;

public class ContactSelectorActivity
        extends BaseActivity
        implements i, c0, p<MessageSource>, a0 {
    protected e4.a e;
    protected Button f;
    private LinearLayoutManager g;
    private RecyclerView h;
    private RecyclerView i;
    private c j;
    protected View k;
    private ToolbarSearchView l;

    public boolean B(MessageSource paramMessageSource) {
        this.j.I(paramMessageSource);
        this.f.setEnabled(true);
        this.i.s1(this.j.d());
        return true;
    }

    public void C(MessageSource paramMessageSource) {
    }

    public void E0(char paramChar) {
        int m = this.e.K(paramChar);
        if (m != -1) {
            this.g.z2(m, 0);
        }
    }

    public int H0() {
        return 2131427365;
    }

    public int I0() {
        return 2131690144;
    }

    protected void M0() {
        a1();
        Object localObject = (RecyclerView) findViewById(2131231430);
        this.i = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.i.h(new h(l.p(5.0F)));
        this.i.setItemAnimator(new e());
        localObject = this.i;
        c localc = new c();
        this.j = localc;
        ((RecyclerView) localObject).setAdapter(localc);
        this.j.M(this);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        this.l = ((ToolbarSearchView) localObject);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        this.l.setHint(2131689554);
    }

    public void U(MessageSource paramMessageSource) {
        this.j.L(paramMessageSource);
        if (this.e.M().isEmpty()) {
            this.f.setEnabled(false);
        }
    }

    protected void a1() {
        Object localObject = new e4.a();
        this.e = ((e4.a) localObject);
        ((e4.a) localObject).Q(b1());
        this.e.S(c1());
        this.e.R(this);
        this.e.P(d1(), null);
        localObject = (RecyclerView) findViewById(2131231391);
        this.h = ((RecyclerView) localObject);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
        this.g = localLinearLayoutManager;
        ((RecyclerView) localObject).setLayoutManager(localLinearLayoutManager);
        this.h.setItemAnimator(new e());
        this.h.setAdapter(this.e);
        localObject = findViewById(2131230981);
        this.k = ((View) localObject);
        ((View) localObject).setOnClickListener(this);
        localObject = (CharSelectorBar) findViewById(2131231441);
        ((CharSelectorBar) localObject).setTextView((TextView) findViewById(2131230944));
        ((CharSelectorBar) localObject).setOnTouchMoveCharListener(this);
    }

    boolean b1() {
        return true;
    }

    boolean c1() {
        return false;
    }

    protected List<Friend> d1() {
        Object localObject1 = getIntent();
        LinkedList localLinkedList = new LinkedList();
        Object localObject2 = ((Intent) localObject1).getLongArrayExtra("ATTR_EXCLUDED_UID_LIST");
        if ((localObject2 != null) && (localObject2.length == 0)) {
            localLinkedList.addAll(i4.a.j((long[]) localObject2, false));
        }
        localObject2 = ((Intent) localObject1).getLongArrayExtra("ATTR_OPTIONAL_UID_LIST");
        if ((localObject2 != null) && (localObject2.length == 0)) {
            localLinkedList.clear();
            localLinkedList.addAll(i4.a.j((long[]) localObject2, true));
        }
        if (localLinkedList.isEmpty()) {
            localLinkedList.addAll(i4.a.f());
        }
        localObject1 = ((Intent) localObject1).getLongArrayExtra("ATTR_SELECTED_UID_LIST");
        localObject2 = localLinkedList.iterator();
        while (((Iterator) localObject2).hasNext()) {
            Friend localFriend = (Friend) ((Iterator) localObject2).next();
            if (l.k((long[]) localObject1, localFriend.id)) {
                this.e.I(localFriend);
            }
        }
        return localLinkedList;
    }

    protected void e1() {
        Intent localIntent = new Intent();
        localIntent.putExtra("ATTR_LIST", this.e.M());
        setResult(-1, localIntent);
        finish();
    }

    protected void f1(Button paramButton) {
    }

    public void g1(MessageSource paramMessageSource, View paramView) {
        l.y0(this.h.findViewWithTag(paramMessageSource), false);
        this.e.M().remove(paramMessageSource);
        U(paramMessageSource);
    }

    public void h0(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            List localList = i4.a.g(paramString);
            if (localList.isEmpty()) {
                this.k.setVisibility(0);
                return;
            }
            this.k.setVisibility(8);
            this.e.P(localList, paramString);
            return;
        }
        this.k.setVisibility(8);
        this.e.P(i4.a.f(), paramString);
    }

    public void onClick(View paramView) {
        if (paramView == this.f) {
            e1();
        }
        View localView = this.k;
        if (paramView == localView) {
            localView.setVisibility(8);
            this.l.setText(null);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        this.f = localButton;
        localButton.getLayoutParams().width = l.p(64.0F);
        this.f.setOnClickListener(this);
        this.f.setText(2131689522);
        this.f.setEnabled(false);
        f1(this.f);
        return super.onCreateOptionsMenu(paramMenu);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.ContactSelectorActivity

 * JD-Core Version:    0.7.0.1

 */