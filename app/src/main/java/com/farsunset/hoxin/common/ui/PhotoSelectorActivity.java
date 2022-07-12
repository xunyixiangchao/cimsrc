package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;

import com.farsunset.hoxin.common.model.AlbumMedia;
import com.farsunset.hoxin.common.model.Bucket;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import s3.j;
import s3.o;
import s3.p;
import u3.c;
import u3.l;
import v3.d;

public class PhotoSelectorActivity
        extends BaseActivity
        implements o, p<Object>, j<List<Bucket>> {
    private j3.b e;
    private MaterialButton f;
    private int g;
    private r3.a h;
    private boolean i;
    private u3.b j;

    private void a1() {
        this.j.e();
        b1(null);
    }

    private void b1(String paramString) {
        paramString = c.M(this, paramString, this.i).N();
        this.e.J();
        this.e.I(paramString);
        this.e.j();
    }

    private void c1() {
        Intent localIntent = new Intent();
        localIntent.setType("image/jpeg");
        localIntent.putExtra("ATTR_FILE_LIST", this.e.K());
        setResult(-1, localIntent);
        finish();
    }

    private void d1(Uri paramUri, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setDataAndType(paramUri, paramString);
        setResult(-1, localIntent);
        finish();
    }

    public void C0(Object paramObject, View paramView) {
        if ((paramObject instanceof AlbumMedia)) {
            paramView = (AlbumMedia) paramObject;
            d1(paramView.uri, paramView.mimeType);
        }
        if ((paramObject instanceof Bucket)) {
            this.h.dismiss();
            paramObject = (Bucket) paramObject;
            S0(paramObject.name);
            b1(paramObject.id);
        }
    }

    public int H0() {
        return 2131427399;
    }

    public void M0() {
        this.i = getIntent().getBooleanExtra("ATTR_IMAGE_ONLY", false);
        Object localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setHasFixedSize(true);
        ((RecyclerView) localObject).setLayoutManager(new GridLayoutManager(this, 4, 1, false));
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        ((RecyclerView) localObject).h(new d());
        this.g = getIntent().getIntExtra("ATTR_MAX_COUNT", 1);
        j3.b localb = new j3.b(getIntent().getAction(), this.g);
        this.e = localb;
        ((RecyclerView) localObject).setAdapter(localb);
        this.e.O(this);
        this.e.P(this);
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        this.h = new r3.a(this, this);
        this.j = u3.b.d(this, this.i, this);
        if (androidx.core.content.b.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            a1();
            return;
        }
        androidx.core.app.a.o(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
    }

    public void S0(String paramString) {
        ((TextView) this.a.findViewById(2131231557)).setText(paramString);
    }

    public void e1(List<Bucket> paramList) {
        this.h.o(paramList);
        S0(((Bucket) paramList.get(0)).name);
    }

    public void i0(Object paramObject, View paramView, boolean paramBoolean) {
        if (this.e.L() > 0) {
            this.f.setEnabled(true);
            this.f.setText(getString(2131689646, new Object[]{Integer.valueOf(this.e.L()), Integer.valueOf(this.g)}));
            return;
        }
        this.f.setEnabled(false);
        this.f.setText(2131689522);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 1920)) {
            d1(i3.e.m(), "image/jpeg");
        }
        if ((paramInt1 == 6604) && (l.T(this))) {
            a1();
        }
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131230850) {
            c1();
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if ("com.farsunset.hoxin.ACTION_MULTIPLE_PHOTO_SELECTOR".equals(getIntent().getAction())) {
            getMenuInflater().inflate(2131492878, paramMenu);
            MaterialButton localMaterialButton = (MaterialButton) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
            this.f = localMaterialButton;
            localMaterialButton.setOnClickListener(this);
            this.f.setText(2131689522);
            this.f.setEnabled(false);
            this.f.getLayoutParams().width = l.p(84.0F);
        } else {
            getMenuInflater().inflate(2131492877, paramMenu);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.j.f();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231194) {
            l.C0(this);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0)) {
            a1();
        }
    }

    public void onToolbarBucketClicked(View paramView) {
        this.h.show();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.PhotoSelectorActivity

 * JD-Core Version:    0.7.0.1

 */