package com.farsunset.hoxin.account.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import u3.l;

public class MeteorWallpaperView
        extends View {
    private final Paint a;
    private final DisplayMetrics b;
    private final List<b> c = new ArrayList(7);
    private final int[] d = {8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final int[] e = {-1, -1593835521, 0};
    private final float[] f = {0.0F, 0.03F, 1.0F};
    private final Random g = new Random();
    private final Handler h = new a();

    public MeteorWallpaperView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = new Paint();
        this.a = paramContext;
        paramContext.setAntiAlias(true);
        paramContext.setStyle(Paint.Style.FILL);
        paramContext.setColor(-1);
        paramContext.setStrokeCap(Paint.Cap.ROUND);
        this.b = Resources.getSystem().getDisplayMetrics();
        d();
    }

    private void d() {
        int i = 0;
        while (i < 7) {
            this.c.add(e());
            i += 1;
        }
        this.h.sendEmptyMessageDelayed(0, 1L);
    }

    private b e() {
        b localb = new b(null);
        f(localb);
        return localb;
    }

    private void f(b paramb) {
        paramb.f = (this.g.nextInt(156) + 100);
        paramb.c = ((this.g.nextInt(8) + 10) * this.b.widthPixels / 100);
        paramb.d = l.p(this.g.nextInt(3) + 1);
        Object localObject = this.d;
        paramb.e = localObject[this.g.nextInt(localObject.length)];
        paramb.a = new Point();
        int i = paramb.c * this.g.nextInt(6);
        localObject = paramb.a;
        DisplayMetrics localDisplayMetrics = this.b;
        ((Point) localObject).x = (localDisplayMetrics.widthPixels + i);
        ((Point) localObject).y = ((int) (localDisplayMetrics.heightPixels * (this.g.nextInt(75) - 40) / 100.0F - i));
        paramb.b = paramb.a;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h.removeCallbacksAndMessages(null);
    }

    public void onDraw(Canvas paramCanvas) {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            Object localObject = (b) localIterator.next();
            int i = (int) (((b) localObject).b.x + Math.cos(0.7853981633974483D) * ((b) localObject).c);
            int j = (int) (((b) localObject).b.y - Math.sin(0.7853981633974483D) * ((b) localObject).c);
            this.a.setStrokeWidth(((b) localObject).d);
            Paint localPaint = this.a;
            int k = (int) (((b) localObject).f - 0.1D);
            ((b) localObject).f = k;
            localPaint.setAlpha(Math.max(0, k));
            localPaint = this.a;
            Point localPoint = ((b) localObject).b;
            float f1 = localPoint.x;
            float f2 = localPoint.y;
            float f3 = i;
            float f4 = j;
            localPaint.setShader(new LinearGradient(f1, f2, f3, f4, this.e, this.f, Shader.TileMode.MIRROR));
            localObject = ((b) localObject).b;
            paramCanvas.drawLine(((Point) localObject).x, ((Point) localObject).y, f3, f4, this.a);
        }
        this.h.sendEmptyMessageDelayed(0, 1L);
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(Message paramMessage) {
            paramMessage = MeteorWallpaperView.a(MeteorWallpaperView.this).iterator();
            while (paramMessage.hasNext()) {
                MeteorWallpaperView.b localb = (MeteorWallpaperView.b) paramMessage.next();
                int i = (int) (localb.b.x + Math.cos(0.7853981633974483D) * localb.c);
                int j = (int) (localb.b.y - Math.sin(0.7853981633974483D) * localb.c);
                if ((i > 0) && (j < MeteorWallpaperView.b(MeteorWallpaperView.this).heightPixels)) {
                    Point localPoint = localb.b;
                    i = localPoint.x;
                    j = localb.e;
                    localPoint.x = (i - j);
                    localPoint.y += j;
                } else {
                    MeteorWallpaperView.c(MeteorWallpaperView.this, localb);
                }
            }
            MeteorWallpaperView.this.invalidate();
        }
    }

    private static class b {
        Point a;
        Point b;
        int c;
        int d;
        int e;
        int f;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.widget.MeteorWallpaperView

 * JD-Core Version:    0.7.0.1

 */