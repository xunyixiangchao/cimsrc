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
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebPhotoView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.github.chrisbanes.photoview.PhotoView;

import d7.f;

import java.util.Objects;

import r3.d;
import s3.u;
import t3.b;
import u3.l;

public class PhotoScreenActivity
        extends BaseActivity
        implements f, s3.c, View.OnLongClickListener, u<Integer> {
    private CloudImage e;
    private ProgressBar f;
    private WebPhotoView g;
    private Bitmap h;
    private d i;

    private void c1() {
        if (this.h == null) {
            return;
        }
        ContentResolver localContentResolver = getContentResolver();
        Bitmap localBitmap = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l.K());
        localStringBuilder.append(".jpg");
        MediaStore.Images.Media.insertImage(localContentResolver, localBitmap, localStringBuilder.toString(), null);
        HoxinApplication.s(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE"));
        Y0(getString(2131690106));
    }

    private void g1() {
        Message localMessage = new Message();
        localMessage.format = 1;
        localMessage.content = l.H0(this.e);
        Intent localIntent = new Intent(this, MessageForwardActivity.class);
        localIntent.putExtra(Message.NAME, localMessage);
        startActivity(localIntent);
    }

    public void G(ImageView paramImageView, float paramFloat1, float paramFloat2) {
        onBackPressed();
    }

    public int H0() {
        return 2131427403;
    }

    public void M0() {
        P0(false);
        setStatusBarColor(17170444);
        supportPostponeEnterTransition();
        getWindow().setBackgroundDrawableResource(17170444);
        this.g = ((WebPhotoView) findViewById(2131231355));
        this.f = ((ProgressBar) findViewById(2131231366));
        this.g.setOnPhotoTapListener(this);
        Object localObject = (CloudImage) getIntent().getSerializableExtra(CloudImage.class.getName());
        this.e = ((CloudImage) localObject);
        String str = ((CloudImage) localObject).uri;
        if (str == null) {
            this.g.b(l.w((CloudImage) localObject), this);
        } else {
            this.g.b(str, this);
        }
        localObject = new d(this);
        this.i = ((d) localObject);
        ((d) localObject).o(this);
        this.g.setOnLongClickListener(this);
    }

    public void f1(Integer paramInteger) {
        if (paramInteger.intValue() == 2131231238) {
            c1();
        }
        if (paramInteger.intValue() == 2131231245) {
            g1();
        }
    }

    public void l0(Object paramObject, ImageView paramImageView) {
        if (isDestroyed()) {
            return;
        }
        supportStartPostponedEnterTransition();
        if ((!l.e0(this.e)) && (!Objects.equals(paramObject, l.v(this.e)))) {
            this.g.postDelayed(new b(this), 500L);
            return;
        }
        this.f.setVisibility(8);
        this.g.setImageResource(2131165738);
    }

    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    public boolean onLongClick(View paramView) {
        this.i.show();
        return false;
    }

    public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable) {
        if (isDestroyed()) {
            return;
        }
        supportStartPostponedEnterTransition();
        if ((!l.e0(this.e)) && (!Objects.equals(paramObject, l.v(this.e)))) {
            this.g.postDelayed(new t3.c(this, paramBitmapDrawable), 500L);
            return;
        }
        this.h = paramBitmapDrawable.getBitmap();
        this.f.setVisibility(8);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.PhotoScreenActivity

 * JD-Core Version:    0.7.0.1

 */