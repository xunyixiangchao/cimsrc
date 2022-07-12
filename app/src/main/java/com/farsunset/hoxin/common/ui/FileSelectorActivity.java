package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.e;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.model.SharedFile;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.message.model.ChatFile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationBarView.c;

import j3.d;
import r3.b;
import s3.p;

public class FileSelectorActivity
        extends BaseActivity
        implements s3.l, p<SharedFile>, NavigationBarView.c {
    private SharedFile e;
    private b f;
    private Button g;
    private d h;
    private GlobalEmptyView i;
    private BottomNavigationView j;

    private void a1() {
        Intent localIntent = new Intent();
        ChatFile localChatFile = new ChatFile();
        SharedFile localSharedFile = this.e;
        localChatFile.size = localSharedFile.size;
        localChatFile.name = localSharedFile.name;
        localChatFile.file = u3.l.K();
        localChatFile.uri = this.e.uri.toString();
        localIntent.putExtra(ChatFile.class.getName(), localChatFile);
        setResult(-1, localIntent);
        finish();
    }

    public int H0() {
        return 2131427368;
    }

    public int I0() {
        return 2131689649;
    }

    public void M0() {
        Object localObject = (BottomNavigationView) findViewById(2131231302);
        this.j = ((BottomNavigationView) localObject);
        ((NavigationBarView) localObject).setOnItemSelectedListener(this);
        localObject = (RecyclerView) findViewById(2131230997);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        d locald = new d();
        this.h = locald;
        ((RecyclerView) localObject).setAdapter(locald);
        this.h.O(this);
        localObject = new b(this);
        this.f = ((b) localObject);
        ((b) localObject).n(this);
        this.f.k(2131690047);
        this.f.f();
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.i = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131690041);
        this.i.a(this.h);
    }

    public void S() {
        this.f.dismiss();
    }

    public void b1(SharedFile paramSharedFile, View paramView) {
        this.e = paramSharedFile;
        this.g.setEnabled(true);
    }

    public boolean c(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231505) {
            paramMenuItem = new Intent("android.intent.action.OPEN_DOCUMENT");
            paramMenuItem.addFlags(1);
            paramMenuItem.addCategory("android.intent.category.OPENABLE");
            paramMenuItem.setType("*/*");
            startActivityForResult(paramMenuItem, 0);
            setTitle(2131689835);
        } else {
            setTitle(2131689649);
            this.h.M();
        }
        this.e = null;
        this.g.setEnabled(false);
        this.i.a(this.h);
        return true;
    }

    public void m() {
        this.f.dismiss();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt2 == -1) {
            paramIntent = u3.l.z(paramIntent.getData());
            this.h.N(paramIntent);
            b1(paramIntent, null);
            this.i.a(this.h);
            return;
        }
        this.j.setSelectedItemId(2131231503);
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131230850) {
            if (this.e.size >= 52428800L) {
                this.f.show();
                return;
            }
            a1();
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        this.g = localButton;
        localButton.setOnClickListener(this);
        this.g.setText(2131689555);
        this.g.setEnabled(false);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.FileSelectorActivity

 * JD-Core Version:    0.7.0.1

 */