package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.a;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;

import j5.b;

import java.io.File;
import java.text.DecimalFormat;

import s3.f;
import u3.a0;
import u3.b0;
import u3.g0;
import u3.l;
import u3.z;

public class FileViewerActivity
        extends BaseActivity
        implements f {
    private ChatFile e;
    private File f;
    private final DecimalFormat g = new DecimalFormat("0.00");
    private Button h;
    private Button i;
    private Button j;
    private TextView k;
    private TextView l;
    private ProgressBar m;
    private String n;
    private Message o;

    public int H0() {
        return 2131427369;
    }

    public int I0() {
        return 2131689702;
    }

    public void M0() {
        Object localObject = b.o(getIntent().getLongExtra("ATTR_MESSAGE_ID", 0L));
        this.o = ((Message) localObject);
        this.e = ((ChatFile) l.s0(((Message) localObject).content, ChatFile.class));
        this.i = ((Button) findViewById(2131231334));
        this.h = ((Button) findViewById(2131230955));
        this.j = ((Button) findViewById(2131231481));
        this.k = ((TextView) findViewById(2131231367));
        this.l = ((TextView) findViewById(2131231368));
        this.m = ((ProgressBar) findViewById(2131230999));
        ((TextView) findViewById(2131231301)).setText(this.e.name);
        ((TextView) findViewById(2131231445)).setText(a.a(this.e.size));
        ((ImageView) findViewById(2131231053)).setImageResource(g0.e(this.e.name));
        localObject = a0.e(this.e.name);
        this.f = ((File) localObject);
        if ((((File) localObject).exists()) && (this.f.length() == this.e.size)) {
            this.i.setVisibility(0);
            ((TextView) findViewById(2131231350)).setText(getString(2131689703, new Object[]{this.f.getAbsolutePath()}));
        } else {
            findViewById(2131230955).setVisibility(0);
        }
        if ((this.f.length() > 0L) && (this.f.length() < this.e.size)) {
            findViewById(2131230956).setVisibility(0);
            this.h.setText(2131689551);
            localObject = this.k;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131689701, new Object[]{a.a(this.f.length())}));
            localStringBuilder.append("/");
            localStringBuilder.append(a.a(this.e.size));
            ((TextView) localObject).setText(localStringBuilder.toString());
            localObject = this.l;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.g.format(this.f.length() / this.e.size * 100.0D));
            localStringBuilder.append("%");
            ((TextView) localObject).setText(localStringBuilder.toString());
            this.m.setProgress((int) (this.f.length() * 100L / this.e.size));
        }
    }

    public void O(File paramFile, String paramString) {
        this.j.setVisibility(8);
        this.h.setText(2131689551);
        this.h.setVisibility(0);
        Y0(getString(2131690046));
    }

    public void o0(File paramFile, String paramString) {
        X0(2131690045);
        this.j.setVisibility(8);
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        findViewById(2131230956).setVisibility(8);
        ((TextView) findViewById(2131231350)).setText(getString(2131689703, new Object[]{paramFile.getAbsolutePath()}));
    }

    public void onDestroy() {
        z.s(this.n);
        super.onDestroy();
    }

    public void onDownloadButtonClicked(View paramView) {
        this.h.setVisibility(8);
        findViewById(2131230956).setVisibility(0);
        this.j.setVisibility(0);
        paramView = a0.e(this.e.name);
        this.f = paramView;
        l.n(paramView);
        this.f.setLastModified(this.o.createTime.longValue());
        paramView = b0.b(this.e.file);
        this.n = paramView;
        z.f(this.f, paramView, this);
    }

    public void onOpenButtonClicked(View paramView) {
        startActivity(g0.f(this.f.getAbsolutePath()));
    }

    public void onStopButtonClicked(View paramView) {
        z.s(this.n);
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setText(2131689551);
        this.h.setVisibility(0);
    }

    public void z0(String paramString, float paramFloat) {
        paramString = this.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131689701, new Object[]{a.a(((float) this.e.size * paramFloat) / 100L)}));
        localStringBuilder.append("/");
        localStringBuilder.append(a.a(this.e.size));
        paramString.setText(localStringBuilder.toString());
        paramString = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.g.format(paramFloat));
        localStringBuilder.append("%");
        paramString.setText(localStringBuilder.toString());
        this.m.setProgress((int) paramFloat);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.FileViewerActivity

 * JD-Core Version:    0.7.0.1

 */