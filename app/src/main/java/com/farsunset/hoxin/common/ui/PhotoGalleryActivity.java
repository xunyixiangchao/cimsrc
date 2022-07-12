package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.n;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.i;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.GalleryViewPager;
import com.farsunset.hoxin.common.widget.ProgressbarPhotoView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;

import d7.f;
import j3.e;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import r3.d;
import s3.c;
import s3.u;
import u3.l;

public class PhotoGalleryActivity
        extends BaseActivity
        implements ViewPager.i, c, u<Integer>, View.OnLongClickListener, f {
    private GalleryViewPager e;
    private e f;
    private LinearLayout g;
    private int h = 0;
    private boolean i = false;
    private List<CloudImage> j;
    private d k;
    private final n l = new a();

    private void d1() {
        int m = 0;
        while (m < this.j.size()) {
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (m != 0) {
                localLayoutParams.leftMargin = l.p(5.0F);
            }
            ImageView localImageView = new ImageView(this);
            localImageView.setLayoutParams(localLayoutParams);
            boolean bool;
            if (this.h == m) {
                bool = true;
            } else {
                bool = false;
            }
            localImageView.setSelected(bool);
            localImageView.setImageResource(2131165627);
            this.g.addView(localImageView);
            m += 1;
        }
    }

    private void e1() {
        Object localObject1 = this.e;
        Object localObject2 = (ProgressbarPhotoView) ((ViewGroup) localObject1).findViewWithTag(Integer.valueOf(((ViewPager) localObject1).getCurrentItem()));
        if (((ProgressbarPhotoView) localObject2).getBitmap() == null) {
            return;
        }
        Y0(getString(2131690106));
        localObject1 = getContentResolver();
        localObject2 = ((ProgressbarPhotoView) localObject2).getBitmap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l.K());
        localStringBuilder.append(".jpg");
        MediaStore.Images.Media.insertImage((ContentResolver) localObject1, (Bitmap) localObject2, localStringBuilder.toString(), null);
        HoxinApplication.s(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE"));
    }

    private void g1() {
        Object localObject = this.e;
        if (((ProgressbarPhotoView) ((ViewGroup) localObject).findViewWithTag(Integer.valueOf(((ViewPager) localObject).getCurrentItem()))).getBitmap() == null) {
            return;
        }
        localObject = new Message();
        ((Message) localObject).format = 1;
        ((Message) localObject).content = l.H0(this.j.get(this.e.getCurrentItem()));
        Intent localIntent = new Intent(this, MessageForwardActivity.class);
        localIntent.putExtra(Message.NAME, (Serializable) localObject);
        startActivity(localIntent);
    }

    public void D(int paramInt) {
    }

    public void G(ImageView paramImageView, float paramFloat1, float paramFloat2) {
        onBackPressed();
    }

    public int H0() {
        return 2131427375;
    }

    public void J(int paramInt) {
        this.g.getChildAt(this.h).setSelected(false);
        this.g.getChildAt(paramInt).setSelected(true);
        this.h = paramInt;
    }

    public void M0() {
        supportPostponeEnterTransition();
        setStatusBarColor(17170444);
        this.e = ((GalleryViewPager) findViewById(2131231611));
        this.g = ((LinearLayout) findViewById(2131230737));
        this.h = getIntent().getIntExtra("ATTR_INDEX", 0);
        this.j = ((List) getIntent().getSerializableExtra(CloudImage.class.getName()));
        getWindow().setBackgroundDrawableResource(17170444);
        d1();
        Object localObject = new e(this.j);
        this.f = ((e) localObject);
        ((e) localObject).w(this);
        this.f.x(this);
        this.f.y(this);
        this.e.setAdapter(this.f);
        this.e.c(this);
        this.e.setOffscreenPageLimit(3);
        this.e.setCurrentItem(this.h);
        setEnterSharedElementCallback(this.l);
        P0(false);
        localObject = new d(this);
        this.k = ((d) localObject);
        ((d) localObject).o(this);
    }

    public void f1(Integer paramInteger) {
        if (paramInteger.intValue() == 2131231238) {
            e1();
        }
        if (paramInteger.intValue() == 2131231245) {
            g1();
        }
    }

    public void finishAfterTransition() {
        Intent localIntent = new Intent();
        localIntent.putExtra("ATTR_URL", l.w(this.f.u(this.h)));
        setResult(-1, localIntent);
        super.finishAfterTransition();
    }

    public void l0(Object paramObject, ImageView paramImageView) {
        p(paramObject, paramImageView, null);
    }

    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    public boolean onLongClick(View paramView) {
        this.k.show();
        return false;
    }

    public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable) {
        if (!this.i) {
            this.i = true;
            supportStartPostponedEnterTransition();
        }
    }

    public void s(int paramInt1, float paramFloat, int paramInt2) {
    }

    class a
            extends n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            Object localObject = l.w(PhotoGalleryActivity.b1(PhotoGalleryActivity.this).u(PhotoGalleryActivity.a1(PhotoGalleryActivity.this)));
            localObject = (ImageView) PhotoGalleryActivity.c1(PhotoGalleryActivity.this).findViewWithTag(localObject);
            paramList.clear();
            paramList.add(((ImageView) localObject).getTransitionName());
            paramMap.clear();
            paramMap.put(((ImageView) localObject).getTransitionName(), localObject);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.PhotoGalleryActivity

 * JD-Core Version:    0.7.0.1

 */