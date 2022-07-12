package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;

import androidx.core.content.b;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import y0.d;

public class ViewPager
        extends ViewGroup {
    static final int[] i0 = {16842931};
    private static final Comparator<f> j0 = new a();
    private static final Interpolator k0 = new b();
    private static final l l0 = new l();
    private int A;
    private int B;
    private int C;
    private float E;
    private float F;
    private float G;
    private float H;
    private int I = -1;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private EdgeEffect P;
    private EdgeEffect Q;
    private boolean R = true;
    private boolean S = false;
    private boolean T;
    private int U;
    private List<i> V;
    private i W;
    private int a;
    private i a0;
    private final ArrayList<f> b = new ArrayList();
    private List<h> b0;
    private final f c = new f();
    private j c0;
    private final Rect d = new Rect();
    private int d0;
    a e;
    private int e0;
    int f;
    private ArrayList<View> f0;
    private int g = -1;
    private final Runnable g0 = new c();
    private Parcelable h = null;
    private int h0 = 0;
    private ClassLoader i = null;
    private Scroller j;
    private boolean k;
    private k l;
    private int m;
    private Drawable n;
    private int o;
    private int p;
    private float q = -3.402824E+038F;
    private float r = 3.4028235E+38F;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x = 1;
    private boolean y;
    private boolean z;

    public ViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        v();
    }

    private boolean C(int paramInt) {
        if (this.b.size() == 0) {
            if (this.R) {
                return false;
            }
            this.T = false;
            y(0, 0.0F, 0);
            if (this.T) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f localf = t();
        int i2 = getClientWidth();
        int i3 = this.m;
        float f2 = i3;
        float f1 = i2;
        f2 /= f1;
        int i1 = localf.b;
        f1 = (paramInt / f1 - localf.e) / (localf.d + f2);
        paramInt = (int) ((i2 + i3) * f1);
        this.T = false;
        y(i1, f1, paramInt);
        if (this.T) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean D(float paramFloat) {
        float f1 = this.E;
        this.E = paramFloat;
        float f2 = getScrollX() + (f1 - paramFloat);
        float f3 = getClientWidth();
        paramFloat = this.q * f3;
        f1 = this.r * f3;
        Object localObject1 = this.b;
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool1 = false;
        localObject1 = (f) ((ArrayList) localObject1).get(0);
        Object localObject2 = this.b;
        localObject2 = (f) ((ArrayList) localObject2).get(((ArrayList) localObject2).size() - 1);
        if (((f) localObject1).b != 0) {
            paramFloat = ((f) localObject1).e * f3;
            i1 = 0;
        } else {
            i1 = 1;
        }
        int i2;
        if (((f) localObject2).b != this.e.e() - 1) {
            f1 = ((f) localObject2).e * f3;
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (f2 < paramFloat) {
            if (i1 != 0) {
                this.P.onPull(Math.abs(paramFloat - f2) / f3);
                bool1 = true;
            }
        } else {
            bool1 = bool3;
            paramFloat = f2;
            if (f2 > f1) {
                bool1 = bool2;
                if (i2 != 0) {
                    this.Q.onPull(Math.abs(f2 - f1) / f3);
                    bool1 = true;
                }
                paramFloat = f1;
            }
        }
        f1 = this.E;
        int i1 = (int) paramFloat;
        this.E = (f1 + (paramFloat - i1));
        scrollTo(i1, getScrollY());
        C(i1);
        return bool1;
    }

    private void G(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((paramInt2 > 0) && (!this.b.isEmpty())) {
            if (!this.j.isFinished()) {
                this.j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            int i1 = getPaddingLeft();
            int i2 = getPaddingRight();
            int i3 = getPaddingLeft();
            int i4 = getPaddingRight();
            paramInt1 = (int) (getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3));
        }
        for (; ; ) {
            scrollTo(paramInt1, getScrollY());
            return;
            f localf = u(this.f);
            float f1;
            if (localf != null) {
                f1 = Math.min(localf.e, this.r);
            } else {
                f1 = 0.0F;
            }
            paramInt1 = (int) (f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
            if (paramInt1 == getScrollX()) {
                break;
            }
            g(false);
        }
    }

    private void H() {
        int i2;
        for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1) {
            i2 = i1;
            if (!((LayoutParams) getChildAt(i1).getLayoutParams()).a) {
                removeViewAt(i1);
                i2 = i1 - 1;
            }
        }
    }

    private void K(boolean paramBoolean) {
        ViewParent localViewParent = getParent();
        if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
        }
    }

    private boolean L() {
        this.I = -1;
        o();
        this.P.onRelease();
        this.Q.onRelease();
        return (this.P.isFinished()) || (this.Q.isFinished());
    }

    private void M(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
        f localf = u(paramInt1);
        int i1;
        if (localf != null) {
            i1 = (int) (getClientWidth() * Math.max(this.q, Math.min(localf.e, this.r)));
        } else {
            i1 = 0;
        }
        if (paramBoolean1) {
            R(i1, 0, paramInt2);
            if (paramBoolean2) {
                k(paramInt1);
            }
        } else {
            if (paramBoolean2) {
                k(paramInt1);
            }
            g(false);
            scrollTo(i1, 0);
            C(i1);
        }
    }

    private void S() {
        if (this.e0 != 0) {
            Object localObject = this.f0;
            if (localObject == null) {
                this.f0 = new ArrayList();
            } else {
                ((ArrayList) localObject).clear();
            }
            int i2 = getChildCount();
            int i1 = 0;
            while (i1 < i2) {
                localObject = getChildAt(i1);
                this.f0.add(localObject);
                i1 += 1;
            }
            Collections.sort(this.f0, l0);
        }
    }

    private void e(f paramf1, int paramInt, f paramf2) {
        int i4 = this.e.e();
        int i1 = getClientWidth();
        float f2;
        if (i1 > 0) {
            f2 = this.m / i1;
        } else {
            f2 = 0.0F;
        }
        float f3;
        if (paramf2 != null) {
            i1 = paramf2.b;
            i2 = paramf1.b;
            if (i1 < i2) {
                f1 = paramf2.e + paramf2.d + f2;
                i1 += 1;
                i2 = 0;
                while ((i1 <= paramf1.b) && (i2 < this.b.size())) {
                    for (; ; ) {
                        paramf2 = (f) this.b.get(i2);
                        i3 = i1;
                        f3 = f1;
                        if (i1 <= paramf2.b) {
                            break;
                        }
                        i3 = i1;
                        f3 = f1;
                        if (i2 >= this.b.size() - 1) {
                            break;
                        }
                        i2 += 1;
                    }
                    while (i3 < paramf2.b) {
                        f3 += this.e.h(i3) + f2;
                        i3 += 1;
                    }
                    paramf2.e = f3;
                    f1 = f3 + (paramf2.d + f2);
                    i1 = i3 + 1;
                }
            }
            if (i1 > i2) {
                i2 = this.b.size() - 1;
                f1 = paramf2.e;
                i1 -= 1;
                while ((i1 >= paramf1.b) && (i2 >= 0)) {
                    for (; ; ) {
                        paramf2 = (f) this.b.get(i2);
                        i3 = i1;
                        f3 = f1;
                        if (i1 >= paramf2.b) {
                            break;
                        }
                        i3 = i1;
                        f3 = f1;
                        if (i2 <= 0) {
                            break;
                        }
                        i2 -= 1;
                    }
                    while (i3 > paramf2.b) {
                        f3 -= this.e.h(i3) + f2;
                        i3 -= 1;
                    }
                    f1 = f3 - (paramf2.d + f2);
                    paramf2.e = f1;
                    i1 = i3 - 1;
                }
            }
        }
        int i3 = this.b.size();
        float f1 = paramf1.e;
        int i2 = paramf1.b;
        i1 = i2 - 1;
        if (i2 == 0) {
            f3 = f1;
        } else {
            f3 = -3.402824E+038F;
        }
        this.q = f3;
        i4 -= 1;
        if (i2 == i4) {
            f3 = paramf1.d + f1 - 1.0F;
        } else {
            f3 = 3.4028235E+38F;
        }
        this.r = f3;
        i2 = paramInt - 1;
        while (i2 >= 0) {
            paramf2 = (f) this.b.get(i2);
            int i5;
            for (; ; ) {
                i5 = paramf2.b;
                if (i1 <= i5) {
                    break;
                }
                f1 -= this.e.h(i1) + f2;
                i1 -= 1;
            }
            f1 -= paramf2.d + f2;
            paramf2.e = f1;
            if (i5 == 0) {
                this.q = f1;
            }
            i2 -= 1;
            i1 -= 1;
        }
        f1 = paramf1.e + paramf1.d + f2;
        i2 = paramf1.b + 1;
        i1 = paramInt + 1;
        paramInt = i2;
        while (i1 < i3) {
            paramf1 = (f) this.b.get(i1);
            for (; ; ) {
                i2 = paramf1.b;
                if (paramInt >= i2) {
                    break;
                }
                f1 += this.e.h(paramInt) + f2;
                paramInt += 1;
            }
            if (i2 == i4) {
                this.r = (paramf1.d + f1 - 1.0F);
            }
            paramf1.e = f1;
            f1 += paramf1.d + f2;
            i1 += 1;
            paramInt += 1;
        }
        this.S = false;
    }

    private void g(boolean paramBoolean) {
        int i1;
        if (this.h0 == 2) {
            i1 = 1;
        } else {
            i1 = 0;
        }
        if (i1 != 0) {
            setScrollingCacheEnabled(false);
            if ((this.j.isFinished() ^ true)) {
                this.j.abortAnimation();
                i2 = getScrollX();
                int i3 = getScrollY();
                int i4 = this.j.getCurrX();
                int i5 = this.j.getCurrY();
                if ((i2 != i4) || (i3 != i5)) {
                    scrollTo(i4, i5);
                    if (i4 != i2) {
                        C(i4);
                    }
                }
            }
        }
        this.w = false;
        int i2 = 0;
        while (i2 < this.b.size()) {
            f localf = (f) this.b.get(i2);
            if (localf.c) {
                localf.c = false;
                i1 = 1;
            }
            i2 += 1;
        }
        if (i1 != 0) {
            if (paramBoolean) {
                x.i0(this, this.g0);
                return;
            }
            this.g0.run();
        }
    }

    private int getClientWidth() {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private int i(int paramInt1, float paramFloat, int paramInt2, int paramInt3) {
        if ((Math.abs(paramInt3) > this.M) && (Math.abs(paramInt2) > this.K)) {
            if (paramInt2 <= 0) {
                paramInt1 += 1;
            }
        } else {
            float f1;
            if (paramInt1 >= this.f) {
                f1 = 0.4F;
            } else {
                f1 = 0.6F;
            }
            paramInt1 += (int) (paramFloat + f1);
        }
        paramInt2 = paramInt1;
        if (this.b.size() > 0) {
            f localf = (f) this.b.get(0);
            Object localObject = this.b;
            localObject = (f) ((ArrayList) localObject).get(((ArrayList) localObject).size() - 1);
            paramInt2 = Math.max(localf.b, Math.min(paramInt1, ((f) localObject).b));
        }
        return paramInt2;
    }

    private void j(int paramInt1, float paramFloat, int paramInt2) {
        Object localObject = this.W;
        if (localObject != null) {
            ((i) localObject).s(paramInt1, paramFloat, paramInt2);
        }
        localObject = this.V;
        if (localObject != null) {
            int i1 = 0;
            int i2 = ((List) localObject).size();
            while (i1 < i2) {
                localObject = (i) this.V.get(i1);
                if (localObject != null) {
                    ((i) localObject).s(paramInt1, paramFloat, paramInt2);
                }
                i1 += 1;
            }
        }
        localObject = this.a0;
        if (localObject != null) {
            ((i) localObject).s(paramInt1, paramFloat, paramInt2);
        }
    }

    private void k(int paramInt) {
        Object localObject = this.W;
        if (localObject != null) {
            ((i) localObject).J(paramInt);
        }
        localObject = this.V;
        if (localObject != null) {
            int i1 = 0;
            int i2 = ((List) localObject).size();
            while (i1 < i2) {
                localObject = (i) this.V.get(i1);
                if (localObject != null) {
                    ((i) localObject).J(paramInt);
                }
                i1 += 1;
            }
        }
        localObject = this.a0;
        if (localObject != null) {
            ((i) localObject).J(paramInt);
        }
    }

    private void l(int paramInt) {
        Object localObject = this.W;
        if (localObject != null) {
            ((i) localObject).D(paramInt);
        }
        localObject = this.V;
        if (localObject != null) {
            int i1 = 0;
            int i2 = ((List) localObject).size();
            while (i1 < i2) {
                localObject = (i) this.V.get(i1);
                if (localObject != null) {
                    ((i) localObject).D(paramInt);
                }
                i1 += 1;
            }
        }
        localObject = this.a0;
        if (localObject != null) {
            ((i) localObject).D(paramInt);
        }
    }

    private void n(boolean paramBoolean) {
        int i3 = getChildCount();
        int i1 = 0;
        while (i1 < i3) {
            int i2;
            if (paramBoolean) {
                i2 = this.d0;
            } else {
                i2 = 0;
            }
            getChildAt(i1).setLayerType(i2, null);
            i1 += 1;
        }
    }

    private void o() {
        this.y = false;
        this.z = false;
        VelocityTracker localVelocityTracker = this.J;
        if (localVelocityTracker != null) {
            localVelocityTracker.recycle();
            this.J = null;
        }
    }

    private Rect q(Rect paramRect, View paramView) {
        Rect localRect = paramRect;
        if (paramRect == null) {
            localRect = new Rect();
        }
        if (paramView == null) {
            localRect.set(0, 0, 0, 0);
            return localRect;
        }
        localRect.left = paramView.getLeft();
        localRect.right = paramView.getRight();
        localRect.top = paramView.getTop();
        localRect.bottom = paramView.getBottom();
        for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent()) {
            paramRect = (ViewGroup) paramRect;
            localRect.left += paramRect.getLeft();
            localRect.right += paramRect.getRight();
            localRect.top += paramRect.getTop();
            localRect.bottom += paramRect.getBottom();
        }
        return localRect;
    }

    private void setScrollingCacheEnabled(boolean paramBoolean) {
        if (this.v != paramBoolean) {
            this.v = paramBoolean;
        }
    }

    private f t() {
        int i1 = getClientWidth();
        float f3 = 0.0F;
        float f1;
        if (i1 > 0) {
            f1 = getScrollX() / i1;
        } else {
            f1 = 0.0F;
        }
        float f2;
        if (i1 > 0) {
            f2 = this.m / i1;
        } else {
            f2 = 0.0F;
        }
        Object localObject = null;
        i1 = 0;
        int i3 = -1;
        int i2 = 1;
        float f4 = 0.0F;
        while (i1 < this.b.size()) {
            f localf2 = (f) this.b.get(i1);
            int i4 = i1;
            f localf1 = localf2;
            if (i2 == 0) {
                int i5 = localf2.b;
                i3 += 1;
                i4 = i1;
                localf1 = localf2;
                if (i5 != i3) {
                    localf1 = this.c;
                    localf1.e = (f3 + f4 + f2);
                    localf1.b = i3;
                    localf1.d = this.e.h(i3);
                    i4 = i1 - 1;
                }
            }
            f3 = localf1.e;
            f4 = localf1.d;
            if ((i2 == 0) && (f1 < f3)) {
                return localObject;
            }
            if (f1 >= f4 + f3 + f2) {
                if (i4 == this.b.size() - 1) {
                    return localf1;
                }
                i3 = localf1.b;
                f4 = localf1.d;
                i1 = i4 + 1;
                i2 = 0;
                localObject = localf1;
            } else {
                return localf1;
            }
        }
        return localObject;
    }

    private static boolean w(View paramView) {
        return paramView.getClass().getAnnotation(e.class) != null;
    }

    private boolean x(float paramFloat1, float paramFloat2) {
        return ((paramFloat1 < this.B) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.B) && (paramFloat2 < 0.0F));
    }

    private void z(MotionEvent paramMotionEvent) {
        int i1 = paramMotionEvent.getActionIndex();
        if (paramMotionEvent.getPointerId(i1) == this.I) {
            if (i1 == 0) {
                i1 = 1;
            } else {
                i1 = 0;
            }
            this.E = paramMotionEvent.getX(i1);
            this.I = paramMotionEvent.getPointerId(i1);
            paramMotionEvent = this.J;
            if (paramMotionEvent != null) {
                paramMotionEvent.clear();
            }
        }
    }

    boolean A() {
        int i1 = this.f;
        if (i1 > 0) {
            N(i1 - 1, true);
            return true;
        }
        return false;
    }

    boolean B() {
        a locala = this.e;
        if ((locala != null) && (this.f < locala.e() - 1)) {
            N(this.f + 1, true);
            return true;
        }
        return false;
    }

    void E() {
        F(this.f);
    }

    void F(int paramInt) {
        int i1 = this.f;
        if (i1 != paramInt) {
            localObject2 = u(i1);
            this.f = paramInt;
        } else {
            localObject2 = null;
        }
        if (this.e == null) {
            S();
            return;
        }
        if (this.w) {
            S();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.e.s(this);
        paramInt = this.x;
        int i7 = Math.max(0, this.f - paramInt);
        int i5 = this.e.e();
        int i6 = Math.min(i5 - 1, this.f + paramInt);
        if (i5 == this.a) {
            paramInt = 0;
            int i2;
            while (paramInt < this.b.size()) {
                localObject1 = (f) this.b.get(paramInt);
                i1 = ((f) localObject1).b;
                i2 = this.f;
                if (i1 >= i2) {
                    if (i1 != i2) {
                        break;
                    }
                    break label187;
                }
                paramInt += 1;
            }
            localObject1 = null;
            label187:
            Object localObject3 = localObject1;
            if (localObject1 == null) {
                localObject3 = localObject1;
                if (i5 > 0) {
                    localObject3 = a(this.f, paramInt);
                }
            }
            if (localObject3 != null) {
                i1 = paramInt - 1;
                if (i1 >= 0) {
                    localObject1 = (f) this.b.get(i1);
                } else {
                    localObject1 = null;
                }
                int i8 = getClientWidth();
                float f3;
                if (i8 <= 0) {
                    f3 = 0.0F;
                } else {
                    f3 = 2.0F - ((f) localObject3).d + getPaddingLeft() / i8;
                }
                int i4 = this.f - 1;
                int i3;
                Object localObject4;
                float f1;
                for (float f2 = 0.0F; i4 >= 0; f2 = f1) {
                    if ((f2 >= f3) && (i4 < i7)) {
                        if (localObject1 == null) {
                            break;
                        }
                        i3 = paramInt;
                        i2 = i1;
                        localObject4 = localObject1;
                        f1 = f2;
                        if (i4 != ((f) localObject1).b) {
                            break label540;
                        }
                        i3 = paramInt;
                        i2 = i1;
                        localObject4 = localObject1;
                        f1 = f2;
                        if (((f) localObject1).c) {
                            break label540;
                        }
                        this.b.remove(i1);
                        this.e.b(this, i4, ((f) localObject1).a);
                        i1 -= 1;
                        paramInt -= 1;
                        i2 = paramInt;
                        i3 = i1;
                        f1 = f2;
                        if (i1 < 0) {
                            break label519;
                        }
                    } else if ((localObject1 != null) && (i4 == ((f) localObject1).b)) {
                        f2 += ((f) localObject1).d;
                        i1 -= 1;
                        i2 = paramInt;
                        i3 = i1;
                        f1 = f2;
                        if (i1 < 0) {
                            break label519;
                        }
                    } else {
                        f2 += a(i4, i1 + 1).d;
                        paramInt += 1;
                        i2 = paramInt;
                        i3 = i1;
                        f1 = f2;
                        if (i1 < 0) {
                            break label519;
                        }
                    }
                    localObject1 = (f) this.b.get(i1);
                    f1 = f2;
                    break label529;
                    label519:
                    localObject1 = null;
                    i1 = i3;
                    paramInt = i2;
                    label529:
                    localObject4 = localObject1;
                    i2 = i1;
                    i3 = paramInt;
                    label540:
                    i4 -= 1;
                    paramInt = i3;
                    i1 = i2;
                    localObject1 = localObject4;
                }
                f2 = ((f) localObject3).d;
                i1 = paramInt + 1;
                if (f2 < 2.0F) {
                    if (i1 < this.b.size()) {
                        localObject1 = (f) this.b.get(i1);
                    } else {
                        localObject1 = null;
                    }
                    if (i8 <= 0) {
                        f3 = 0.0F;
                    } else {
                        f3 = getPaddingRight() / i8 + 2.0F;
                    }
                    i2 = this.f;
                    localObject4 = localObject1;
                    for (; ; ) {
                        i3 = i2 + 1;
                        if (i3 >= i5) {
                            break;
                        }
                        if ((f2 >= f3) && (i3 > i6)) {
                            if (localObject4 == null) {
                                break;
                            }
                            f1 = f2;
                            i2 = i1;
                            localObject1 = localObject4;
                            if (i3 != localObject4.b) {
                                break label885;
                            }
                            f1 = f2;
                            i2 = i1;
                            localObject1 = localObject4;
                            if (localObject4.c) {
                                break label885;
                            }
                            this.b.remove(i1);
                            this.e.b(this, i3, localObject4.a);
                            f1 = f2;
                            i2 = i1;
                            if (i1 >= this.b.size()) {
                            }
                        }
                        for (; ; ) {
                            localObject1 = (f) this.b.get(i1);
                            f1 = f2;
                            i2 = i1;
                            break;
                            do {
                                do {
                                    localObject1 = null;
                                    break label885;
                                    if ((localObject4 == null) || (i3 != localObject4.b)) {
                                        break;
                                    }
                                    f2 += localObject4.d;
                                    i1 += 1;
                                    f1 = f2;
                                    i2 = i1;
                                } while (i1 >= this.b.size());
                                break;
                                localObject1 = a(i3, i1);
                                i1 += 1;
                                f2 += ((f) localObject1).d;
                                f1 = f2;
                                i2 = i1;
                            } while (i1 >= this.b.size());
                        }
                        label885:
                        f2 = f1;
                        i1 = i2;
                        localObject4 = localObject1;
                        i2 = i3;
                    }
                }
                e((f) localObject3, paramInt, (f) localObject2);
                this.e.p(this, this.f, ((f) localObject3).a);
            }
            this.e.d(this);
            i1 = getChildCount();
            paramInt = 0;
            while (paramInt < i1) {
                localObject2 = getChildAt(paramInt);
                localObject1 = (LayoutParams) ((View) localObject2).getLayoutParams();
                ((LayoutParams) localObject1).f = paramInt;
                if ((!((LayoutParams) localObject1).a) && (((LayoutParams) localObject1).c == 0.0F)) {
                    localObject2 = s((View) localObject2);
                    if (localObject2 != null) {
                        ((LayoutParams) localObject1).c = ((f) localObject2).d;
                        ((LayoutParams) localObject1).e = ((f) localObject2).b;
                    }
                }
                paramInt += 1;
            }
            S();
            if (hasFocus()) {
                localObject1 = findFocus();
                if (localObject1 != null) {
                    localObject1 = r((View) localObject1);
                } else {
                    localObject1 = null;
                }
                if ((localObject1 == null) || (((f) localObject1).b != this.f)) {
                    paramInt = 0;
                    while (paramInt < getChildCount()) {
                        localObject1 = getChildAt(paramInt);
                        localObject2 = s((View) localObject1);
                        if ((localObject2 != null) && (((f) localObject2).b == this.f) && (((View) localObject1).requestFocus(2))) {
                            return;
                        }
                        paramInt += 1;
                    }
                }
            }
            return;
        }
        try {
            localObject1 = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException localNotFoundException) {
            label1160:
            break label1160;
        }
        Object localObject1 = Integer.toHexString(getId());
        Object localObject2 = new StringBuilder();
        ((StringBuilder) localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        ((StringBuilder) localObject2).append(this.a);
        ((StringBuilder) localObject2).append(", found: ");
        ((StringBuilder) localObject2).append(i5);
        ((StringBuilder) localObject2).append(" Pager id: ");
        ((StringBuilder) localObject2).append((String) localObject1);
        ((StringBuilder) localObject2).append(" Pager class: ");
        ((StringBuilder) localObject2).append(getClass());
        ((StringBuilder) localObject2).append(" Problematic adapter: ");
        ((StringBuilder) localObject2).append(this.e.getClass());
        throw new IllegalStateException(((StringBuilder) localObject2).toString());
    }

    public void I(h paramh) {
        List localList = this.b0;
        if (localList != null) {
            localList.remove(paramh);
        }
    }

    public void J(i parami) {
        List localList = this.V;
        if (localList != null) {
            localList.remove(parami);
        }
    }

    public void N(int paramInt, boolean paramBoolean) {
        this.w = false;
        O(paramInt, paramBoolean, false);
    }

    void O(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        P(paramInt, paramBoolean1, paramBoolean2, 0);
    }

    void P(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
        a locala = this.e;
        boolean bool = false;
        if ((locala != null) && (locala.e() > 0)) {
            if ((!paramBoolean2) && (this.f == paramInt1) && (this.b.size() != 0)) {
                setScrollingCacheEnabled(false);
                return;
            }
            int i1;
            if (paramInt1 < 0) {
                i1 = 0;
            } else {
                i1 = paramInt1;
                if (paramInt1 >= this.e.e()) {
                    i1 = this.e.e() - 1;
                }
            }
            paramInt1 = this.x;
            int i2 = this.f;
            if ((i1 > i2 + paramInt1) || (i1 < i2 - paramInt1)) {
                paramInt1 = 0;
                while (paramInt1 < this.b.size()) {
                    ((f) this.b.get(paramInt1)).c = true;
                    paramInt1 += 1;
                }
            }
            paramBoolean2 = bool;
            if (this.f != i1) {
                paramBoolean2 = true;
            }
            if (this.R) {
                this.f = i1;
                if (paramBoolean2) {
                    k(i1);
                }
                requestLayout();
                return;
            }
            F(i1);
            M(i1, paramBoolean1, paramInt2, paramBoolean2);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    i Q(i parami) {
        i locali = this.a0;
        this.a0 = parami;
        return locali;
    }

    void R(int paramInt1, int paramInt2, int paramInt3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller localScroller = this.j;
        int i1;
        if ((localScroller != null) && (!localScroller.isFinished())) {
            i1 = 1;
        } else {
            i1 = 0;
        }
        if (i1 != 0) {
            if (this.k) {
                i1 = this.j.getCurrX();
            } else {
                i1 = this.j.getStartX();
            }
            this.j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i1 = getScrollX();
        }
        int i2 = getScrollY();
        int i3 = paramInt1 - i1;
        paramInt2 -= i2;
        if ((i3 == 0) && (paramInt2 == 0)) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        paramInt1 = getClientWidth();
        int i4 = paramInt1 / 2;
        float f2 = Math.abs(i3);
        float f1 = paramInt1;
        float f3 = Math.min(1.0F, f2 * 1.0F / f1);
        f2 = i4;
        f3 = m(f3);
        paramInt1 = Math.abs(paramInt3);
        if (paramInt1 > 0) {
            paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
        } else {
            f2 = this.e.h(this.f);
            paramInt1 = (int) ((Math.abs(i3) / (f1 * f2 + this.m) + 1.0F) * 100.0F);
        }
        paramInt1 = Math.min(paramInt1, 600);
        this.k = false;
        this.j.startScroll(i1, i2, i3, paramInt2, paramInt1);
        x.h0(this);
    }

    f a(int paramInt1, int paramInt2) {
        f localf = new f();
        localf.b = paramInt1;
        localf.a = this.e.j(this, paramInt1);
        localf.d = this.e.h(paramInt1);
        if ((paramInt2 >= 0) && (paramInt2 < this.b.size())) {
            this.b.add(paramInt2, localf);
            return localf;
        }
        this.b.add(localf);
        return localf;
    }

    public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
        int i2 = paramArrayList.size();
        int i3 = getDescendantFocusability();
        if (i3 != 393216) {
            int i1 = 0;
            while (i1 < getChildCount()) {
                View localView = getChildAt(i1);
                if (localView.getVisibility() == 0) {
                    f localf = s(localView);
                    if ((localf != null) && (localf.b == this.f)) {
                        localView.addFocusables(paramArrayList, paramInt1, paramInt2);
                    }
                }
                i1 += 1;
            }
        }
        if ((i3 != 262144) || (i2 == paramArrayList.size())) {
            if (!isFocusable()) {
                return;
            }
            if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
                return;
            }
            paramArrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> paramArrayList) {
        int i1 = 0;
        while (i1 < getChildCount()) {
            View localView = getChildAt(i1);
            if (localView.getVisibility() == 0) {
                f localf = s(localView);
                if ((localf != null) && (localf.b == this.f)) {
                    localView.addTouchables(paramArrayList);
                }
            }
            i1 += 1;
        }
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
        if (!checkLayoutParams(paramLayoutParams)) {
            localLayoutParams = generateLayoutParams(paramLayoutParams);
        }
        paramLayoutParams = (LayoutParams) localLayoutParams;
        boolean bool = paramLayoutParams.a | w(paramView);
        paramLayoutParams.a = bool;
        if (this.u) {
            if (!bool) {
                paramLayoutParams.d = true;
                addViewInLayout(paramView, paramInt, localLayoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(paramView, paramInt, localLayoutParams);
    }

    public void b(h paramh) {
        if (this.b0 == null) {
            this.b0 = new ArrayList();
        }
        this.b0.add(paramh);
    }

    public void c(i parami) {
        if (this.V == null) {
            this.V = new ArrayList();
        }
        this.V.add(parami);
    }

    public boolean canScrollHorizontally(int paramInt) {
        a locala = this.e;
        boolean bool2 = false;
        boolean bool1 = false;
        if (locala == null) {
            return false;
        }
        int i1 = getClientWidth();
        int i2 = getScrollX();
        if (paramInt < 0) {
            if (i2 > (int) (i1 * this.q)) {
                bool1 = true;
            }
            return bool1;
        }
        bool1 = bool2;
        if (paramInt > 0) {
            bool1 = bool2;
            if (i2 < (int) (i1 * this.r)) {
                bool1 = true;
            }
        }
        return bool1;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
    }

    public void computeScroll() {
        this.k = true;
        if ((!this.j.isFinished()) && (this.j.computeScrollOffset())) {
            int i1 = getScrollX();
            int i2 = getScrollY();
            int i3 = this.j.getCurrX();
            int i4 = this.j.getCurrY();
            if ((i1 != i3) || (i2 != i4)) {
                scrollTo(i3, i4);
                if (!C(i3)) {
                    this.j.abortAnimation();
                    scrollTo(0, i4);
                }
            }
            x.h0(this);
            return;
        }
        g(true);
    }

    public boolean d(int paramInt) {
        View localView = findFocus();
        boolean bool = false;
        if (localView == this) {
        }
        Object localObject;
        int i1;
        for (; ; ) {
            localObject = null;
            break;
            localObject = localView;
            if (localView == null) {
                break;
            }
            for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent) localObject).getParent()) {
                if (localObject == this) {
                    i1 = 1;
                    break label70;
                }
            }
            i1 = 0;
            label70:
            localObject = localView;
            if (i1 != 0) {
                break;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localView.getClass().getSimpleName());
            for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent) localObject).getParent()) {
                localStringBuilder.append(" => ");
                localStringBuilder.append(localObject.getClass().getSimpleName());
            }
            localObject = new StringBuilder();
            ((StringBuilder) localObject).append("arrowScroll tried to find focus based on non-child current focused view ");
            ((StringBuilder) localObject).append(localStringBuilder.toString());
            Log.e("ViewPager", ((StringBuilder) localObject).toString());
        }
        localView = FocusFinder.getInstance().findNextFocus(this, (View) localObject, paramInt);
        int i2;
        if ((localView != null) && (localView != localObject)) {
            if (paramInt == 17) {
                i1 = q(this.d, localView).left;
                i2 = q(this.d, (View) localObject).left;
                if ((localObject != null) && (i1 >= i2)) {
                    bool = A();
                } else {
                    bool = localView.requestFocus();
                }
            }
        }
        for (; ; ) {
            break label375;
            if (paramInt == 66) {
                i1 = q(this.d, localView).left;
                i2 = q(this.d, (View) localObject).left;
                if ((localObject == null) || (i1 > i2)) {
                    break;
                }
                bool = B();
                continue;
                if ((paramInt != 17) && (paramInt != 1)) {
                    if ((paramInt == 66) || (paramInt == 2)) {
                        bool = B();
                    }
                } else {
                    bool = A();
                }
            }
        }
        label375:
        if (bool) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        return (super.dispatchKeyEvent(paramKeyEvent)) || (p(paramKeyEvent));
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        if (paramAccessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
        }
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            if (localView.getVisibility() == 0) {
                f localf = s(localView);
                if ((localf != null) && (localf.b == this.f) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
                    return true;
                }
            }
            i1 += 1;
        }
        return false;
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        int i4 = getOverScrollMode();
        int i3 = 0;
        int i1 = 0;
        if (i4 != 0) {
            if (i4 == 1) {
                a locala = this.e;
                if ((locala != null) && (locala.e() > 1)) {
                }
            } else {
                this.P.finish();
                this.Q.finish();
                break label256;
            }
        }
        int i2;
        if (!this.P.isFinished()) {
            i3 = paramCanvas.save();
            i1 = getHeight() - getPaddingTop() - getPaddingBottom();
            i4 = getWidth();
            paramCanvas.rotate(270.0F);
            paramCanvas.translate(-i1 + getPaddingTop(), this.q * i4);
            this.P.setSize(i1, i4);
            i2 = false | this.P.draw(paramCanvas);
            paramCanvas.restoreToCount(i3);
        }
        i3 = i2;
        boolean bool;
        if (!this.Q.isFinished()) {
            i4 = paramCanvas.save();
            i3 = getWidth();
            int i5 = getHeight();
            int i6 = getPaddingTop();
            int i7 = getPaddingBottom();
            paramCanvas.rotate(90.0F);
            paramCanvas.translate(-getPaddingTop(), -(this.r + 1.0F) * i3);
            this.Q.setSize(i5 - i6 - i7, i3);
            bool = i2 | this.Q.draw(paramCanvas);
            paramCanvas.restoreToCount(i4);
        }
        label256:
        if (bool) {
            x.h0(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable localDrawable = this.n;
        if ((localDrawable != null) && (localDrawable.isStateful())) {
            localDrawable.setState(getDrawableState());
        }
    }

    protected boolean f(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
        if ((paramView instanceof ViewGroup)) {
            ViewGroup localViewGroup = (ViewGroup) paramView;
            int i2 = paramView.getScrollX();
            int i3 = paramView.getScrollY();
            int i1 = localViewGroup.getChildCount() - 1;
            while (i1 >= 0) {
                View localView = localViewGroup.getChildAt(i1);
                int i4 = paramInt2 + i2;
                if ((i4 >= localView.getLeft()) && (i4 < localView.getRight())) {
                    int i5 = paramInt3 + i3;
                    if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (f(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
                        return true;
                    }
                }
                i1 -= 1;
            }
        }
        return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new LayoutParams(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.e;
    }

    protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
        int i1 = paramInt2;
        if (this.e0 == 2) {
            i1 = paramInt1 - 1 - paramInt2;
        }
        return ((LayoutParams) ((View) this.f0.get(i1)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.m;
    }

    void h() {
        int i9 = this.e.e();
        this.a = i9;
        int i4;
        if ((this.b.size() < this.x * 2 + 1) && (this.b.size() < i9)) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i1 = this.f;
        int i3 = 0;
        Object localObject;
        int i6;
        for (int i2 = i3; i3 < this.b.size(); i2 = i6) {
            localObject = (f) this.b.get(i3);
            int i8 = this.e.f(((f) localObject).a);
            int i5;
            int i7;
            if (i8 == -1) {
                i5 = i1;
                i7 = i3;
                i6 = i2;
            } else {
                if (i8 == -2) {
                    this.b.remove(i3);
                    i5 = i3 - 1;
                    i4 = i2;
                    if (i2 == 0) {
                        this.e.s(this);
                        i4 = 1;
                    }
                    this.e.b(this, ((f) localObject).b, ((f) localObject).a);
                    i6 = this.f;
                    i3 = i5;
                    i2 = i4;
                    if (i6 == ((f) localObject).b) {
                        i1 = Math.max(0, Math.min(i6, i9 - 1));
                        i2 = i4;
                        i3 = i5;
                    }
                }
                for (; ; ) {
                    i4 = 1;
                    i5 = i1;
                    i7 = i3;
                    i6 = i2;
                    break;
                    int i10 = ((f) localObject).b;
                    i5 = i1;
                    i7 = i3;
                    i6 = i2;
                    if (i10 == i8) {
                        break;
                    }
                    if (i10 == this.f) {
                        i1 = i8;
                    }
                    ((f) localObject).b = i8;
                }
            }
            i3 = i7 + 1;
            i1 = i5;
        }
        if (i2 != 0) {
            this.e.d(this);
        }
        Collections.sort(this.b, j0);
        if (i4 != 0) {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3) {
                localObject = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!((LayoutParams) localObject).a) {
                    ((LayoutParams) localObject).c = 0.0F;
                }
                i2 += 1;
            }
            O(i1, false, true);
            requestLayout();
        }
    }

    float m(float paramFloat) {
        return (float) Math.sin((paramFloat - 0.5F) * 0.4712389F);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.g0);
        Scroller localScroller = this.j;
        if ((localScroller != null) && (!localScroller.isFinished())) {
            this.j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((this.m > 0) && (this.n != null) && (this.b.size() > 0) && (this.e != null)) {
            int i3 = getScrollX();
            int i4 = getWidth();
            float f1 = this.m;
            float f4 = i4;
            float f2 = f1 / f4;
            Object localObject = this.b;
            int i2 = 0;
            localObject = (f) ((ArrayList) localObject).get(0);
            f1 = ((f) localObject).e;
            int i5 = this.b.size();
            int i1 = ((f) localObject).b;
            int i6 = ((f) this.b.get(i5 - 1)).b;
            while (i1 < i6) {
                int i7;
                for (; ; ) {
                    i7 = ((f) localObject).b;
                    if ((i1 <= i7) || (i2 >= i5)) {
                        break;
                    }
                    localObject = this.b;
                    i2 += 1;
                    localObject = (f) ((ArrayList) localObject).get(i2);
                }
                float f5;
                float f3;
                if (i1 == i7) {
                    f1 = ((f) localObject).e;
                    f5 = ((f) localObject).d;
                    f3 = (f1 + f5) * f4;
                    f1 = f1 + f5 + f2;
                } else {
                    f5 = this.e.h(i1);
                    f3 = (f1 + f5) * f4;
                    f1 += f5 + f2;
                }
                if (this.m + f3 > i3) {
                    this.n.setBounds(Math.round(f3), this.o, Math.round(this.m + f3), this.p);
                    this.n.draw(paramCanvas);
                }
                if (f3 > i3 + i4) {
                    return;
                }
                i1 += 1;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        int i1 = paramMotionEvent.getAction() & 0xFF;
        if ((i1 != 3) && (i1 != 1)) {
            if (i1 != 0) {
                if (this.y) {
                    return true;
                }
                if (this.z) {
                    return false;
                }
            }
            float f1;
            if (i1 != 0) {
                if (i1 != 2) {
                    if (i1 == 6) {
                        z(paramMotionEvent);
                    }
                } else {
                    i1 = this.I;
                    if (i1 != -1) {
                        i1 = paramMotionEvent.findPointerIndex(i1);
                        float f2 = paramMotionEvent.getX(i1);
                        f1 = f2 - this.E;
                        float f4 = Math.abs(f1);
                        float f3 = paramMotionEvent.getY(i1);
                        float f5 = Math.abs(f3 - this.H);
                        boolean bool = f1 < 0.0F;
                        if ((bool) && (!x(this.E, f1)) && (f(this, false, (int) f1, (int) f2, (int) f3))) {
                            this.E = f2;
                            this.F = f3;
                            this.z = true;
                            return false;
                        }
                        int i2 = this.C;
                        if ((f4 > i2) && (f4 * 0.5F > f5)) {
                            this.y = true;
                            K(true);
                            setScrollState(1);
                            f1 = this.G;
                            f4 = this.C;
                            if (bool) {
                                f1 += f4;
                            } else {
                                f1 -= f4;
                            }
                            this.E = f1;
                            this.F = f3;
                            setScrollingCacheEnabled(true);
                        } else if (f5 > i2) {
                            this.z = true;
                        }
                        if ((this.y) && (D(f2))) {
                            x.h0(this);
                        }
                    }
                }
            } else {
                f1 = paramMotionEvent.getX();
                this.G = f1;
                this.E = f1;
                f1 = paramMotionEvent.getY();
                this.H = f1;
                this.F = f1;
                this.I = paramMotionEvent.getPointerId(0);
                this.z = false;
                this.k = true;
                this.j.computeScrollOffset();
                if ((this.h0 == 2) && (Math.abs(this.j.getFinalX() - this.j.getCurrX()) > this.N)) {
                    this.j.abortAnimation();
                    this.w = false;
                    E();
                    this.y = true;
                    K(true);
                    setScrollState(1);
                } else {
                    g(false);
                    this.y = false;
                }
            }
            if (this.J == null) {
                this.J = VelocityTracker.obtain();
            }
            this.J.addMovement(paramMotionEvent);
            return this.y;
        }
        L();
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i8 = getChildCount();
        int i9 = paramInt3 - paramInt1;
        int i10 = paramInt4 - paramInt2;
        paramInt2 = getPaddingLeft();
        paramInt1 = getPaddingTop();
        paramInt4 = getPaddingRight();
        paramInt3 = getPaddingBottom();
        int i11 = getScrollX();
        int i3 = 0;
        View localView;
        LayoutParams localLayoutParams;
        for (int i2 = 0; i3 < i8; i2 = i1) {
            localView = getChildAt(i3);
            int i7 = paramInt2;
            int i6 = paramInt1;
            int i5 = paramInt4;
            int i4 = paramInt3;
            i1 = i2;
            if (localView.getVisibility() != 8) {
                localLayoutParams = (LayoutParams) localView.getLayoutParams();
                i7 = paramInt2;
                i6 = paramInt1;
                i5 = paramInt4;
                i4 = paramInt3;
                i1 = i2;
                if (localLayoutParams.a) {
                    i4 = localLayoutParams.b;
                    i1 = i4 & 0x7;
                    i5 = i4 & 0x70;
                    if (i1 != 1) {
                        if (i1 != 3) {
                            if (i1 != 5) {
                                i1 = paramInt2;
                                i4 = paramInt2;
                                paramInt2 = i1;
                                break label246;
                            }
                            i1 = i9 - paramInt4 - localView.getMeasuredWidth();
                            paramInt4 += localView.getMeasuredWidth();
                        } else {
                            i1 = localView.getMeasuredWidth() + paramInt2;
                            i4 = paramInt2;
                            paramInt2 = i1;
                            break label246;
                        }
                    } else {
                        i1 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
                    }
                    i4 = i1;
                    label246:
                    if (i5 != 16) {
                        if (i5 != 48) {
                            if (i5 != 80) {
                                i5 = paramInt1;
                                i1 = paramInt1;
                                paramInt1 = i5;
                            } else {
                                i1 = i10 - paramInt3 - localView.getMeasuredHeight();
                                paramInt3 += localView.getMeasuredHeight();
                            }
                        } else {
                            i5 = localView.getMeasuredHeight() + paramInt1;
                            i1 = paramInt1;
                            paramInt1 = i5;
                        }
                    } else {
                        i1 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
                    }
                    i4 += i11;
                    localView.layout(i4, i1, localView.getMeasuredWidth() + i4, i1 + localView.getMeasuredHeight());
                    i1 = i2 + 1;
                    i4 = paramInt3;
                    i5 = paramInt4;
                    i6 = paramInt1;
                    i7 = paramInt2;
                }
            }
            i3 += 1;
            paramInt2 = i7;
            paramInt1 = i6;
            paramInt4 = i5;
            paramInt3 = i4;
        }
        int i1 = 0;
        while (i1 < i8) {
            localView = getChildAt(i1);
            if (localView.getVisibility() != 8) {
                localLayoutParams = (LayoutParams) localView.getLayoutParams();
                if (!localLayoutParams.a) {
                    f localf = s(localView);
                    if (localf != null) {
                        float f1 = i9 - paramInt2 - paramInt4;
                        i3 = (int) (localf.e * f1) + paramInt2;
                        if (localLayoutParams.d) {
                            localLayoutParams.d = false;
                            localView.measure(View.MeasureSpec.makeMeasureSpec((int) (f1 * localLayoutParams.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt3, 1073741824));
                        }
                        localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
                    }
                }
            }
            i1 += 1;
        }
        this.o = paramInt1;
        this.p = (i10 - paramInt3);
        this.U = i2;
        if (this.R) {
            M(this.f, false, 0, false);
        }
        this.R = false;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i9 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, paramInt1), ViewGroup.getDefaultSize(0, paramInt2));
        paramInt1 = getMeasuredWidth();
        this.B = Math.min(paramInt1 / 10, this.A);
        paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
        paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int i10 = getChildCount();
        int i3 = 0;
        View localView;
        LayoutParams localLayoutParams;
        for (; ; ) {
            int i6 = 1;
            int i8 = 1073741824;
            if (i3 >= i10) {
                break;
            }
            localView = getChildAt(i3);
            i1 = paramInt1;
            int i2 = paramInt2;
            if (localView.getVisibility() != 8) {
                localLayoutParams = (LayoutParams) localView.getLayoutParams();
                i1 = paramInt1;
                i2 = paramInt2;
                if (localLayoutParams != null) {
                    i1 = paramInt1;
                    i2 = paramInt2;
                    if (localLayoutParams.a) {
                        i2 = localLayoutParams.b;
                        i1 = i2 & 0x7;
                        i2 &= 0x70;
                        int i5;
                        if ((i2 != 48) && (i2 != 80)) {
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        int i4 = i6;
                        if (i1 != 3) {
                            if (i1 == 5) {
                                i4 = i6;
                            } else {
                                i4 = 0;
                            }
                        }
                        i2 = -2147483648;
                        if (i5 != 0) {
                            i1 = -2147483648;
                            i2 = 1073741824;
                        } else if (i4 != 0) {
                            i1 = 1073741824;
                        } else {
                            i1 = -2147483648;
                        }
                        i6 = localLayoutParams.width;
                        int i7;
                        if (i6 != -2) {
                            if (i6 != -1) {
                                i2 = i6;
                            } else {
                                i2 = paramInt1;
                            }
                            i6 = 1073741824;
                            i7 = i2;
                        } else {
                            i7 = paramInt1;
                            i6 = i2;
                        }
                        i2 = localLayoutParams.height;
                        if (i2 != -2) {
                            if (i2 != -1) {
                                i1 = i2;
                            } else {
                                i1 = paramInt2;
                            }
                        } else {
                            i2 = paramInt2;
                            i8 = i1;
                            i1 = i2;
                        }
                        localView.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), View.MeasureSpec.makeMeasureSpec(i1, i8));
                        if (i5 != 0) {
                            i2 = paramInt2 - localView.getMeasuredHeight();
                            i1 = paramInt1;
                        } else {
                            i1 = paramInt1;
                            i2 = paramInt2;
                            if (i4 != 0) {
                                i1 = paramInt1 - localView.getMeasuredWidth();
                                i2 = paramInt2;
                            }
                        }
                    }
                }
            }
            i3 += 1;
            paramInt1 = i1;
            paramInt2 = i2;
        }
        this.s = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.t = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.u = true;
        E();
        this.u = false;
        int i1 = getChildCount();
        paramInt2 = i9;
        while (paramInt2 < i1) {
            localView = getChildAt(paramInt2);
            if (localView.getVisibility() != 8) {
                localLayoutParams = (LayoutParams) localView.getLayoutParams();
                if ((localLayoutParams == null) || (!localLayoutParams.a)) {
                    localView.measure(View.MeasureSpec.makeMeasureSpec((int) (paramInt1 * localLayoutParams.c), 1073741824), this.t);
                }
            }
            paramInt2 += 1;
        }
    }

    protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
        int i1 = getChildCount();
        int i3 = -1;
        int i2;
        if ((paramInt & 0x2) != 0) {
            i3 = i1;
            i1 = 0;
            i2 = 1;
        } else {
            i1 -= 1;
            i2 = -1;
        }
        while (i1 != i3) {
            View localView = getChildAt(i1);
            if (localView.getVisibility() == 0) {
                f localf = s(localView);
                if ((localf != null) && (localf.b == this.f) && (localView.requestFocus(paramInt, paramRect))) {
                    return true;
                }
            }
            i1 += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        if (!(paramParcelable instanceof SavedState)) {
            super.onRestoreInstanceState(paramParcelable);
            return;
        }
        paramParcelable = (SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.g());
        a locala = this.e;
        if (locala != null) {
            locala.m(paramParcelable.d, paramParcelable.e);
            O(paramParcelable.c, false, true);
            return;
        }
        this.g = paramParcelable.c;
        this.h = paramParcelable.d;
        this.i = paramParcelable.e;
    }

    public Parcelable onSaveInstanceState() {
        SavedState localSavedState = new SavedState(super.onSaveInstanceState());
        localSavedState.c = this.f;
        a locala = this.e;
        if (locala != null) {
            localSavedState.d = locala.n();
        }
        return localSavedState;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramInt1 != paramInt3) {
            paramInt2 = this.m;
            G(paramInt1, paramInt3, paramInt2, paramInt2);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.O) {
            return true;
        }
        int i1 = paramMotionEvent.getAction();
        boolean bool = false;
        if ((i1 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
            return false;
        }
        Object localObject = this.e;
        if (localObject != null) {
            if (((a) localObject).e() == 0) {
                return false;
            }
            if (this.J == null) {
                this.J = VelocityTracker.obtain();
            }
            this.J.addMovement(paramMotionEvent);
            i1 = paramMotionEvent.getAction() & 0xFF;
            float f1;
            if (i1 != 0) {
                float f2;
                if (i1 != 1) {
                    if (i1 != 2) {
                        if (i1 != 3) {
                            if (i1 != 5) {
                                if (i1 != 6) {
                                    break label591;
                                }
                                z(paramMotionEvent);
                                this.E = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.I));
                                break label591;
                            }
                            i1 = paramMotionEvent.getActionIndex();
                            this.E = paramMotionEvent.getX(i1);
                            i1 = paramMotionEvent.getPointerId(i1);
                            break label585;
                        }
                        if (!this.y) {
                            break label591;
                        }
                        M(this.f, true, 0, false);
                    } else {
                        if (!this.y) {
                            i1 = paramMotionEvent.findPointerIndex(this.I);
                            if (i1 == -1) {
                                break label523;
                            }
                            f1 = paramMotionEvent.getX(i1);
                            float f3 = Math.abs(f1 - this.E);
                            f2 = paramMotionEvent.getY(i1);
                            float f4 = Math.abs(f2 - this.F);
                            if ((f3 > this.C) && (f3 > f4)) {
                                this.y = true;
                                K(true);
                                f3 = this.G;
                                if (f1 - f3 > 0.0F) {
                                    f1 = f3 + this.C;
                                } else {
                                    f1 = f3 - this.C;
                                }
                                this.E = f1;
                                this.F = f2;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                localObject = getParent();
                                if (localObject != null) {
                                    ((ViewParent) localObject).requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (!this.y) {
                            break label591;
                        }
                        bool = false | D(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.I)));
                        break label591;
                    }
                } else {
                    if (!this.y) {
                        break label591;
                    }
                    localObject = this.J;
                    ((VelocityTracker) localObject).computeCurrentVelocity(1000, this.L);
                    i1 = (int) ((VelocityTracker) localObject).getXVelocity(this.I);
                    this.w = true;
                    int i2 = getClientWidth();
                    int i3 = getScrollX();
                    localObject = t();
                    f2 = this.m;
                    f1 = i2;
                    f2 /= f1;
                    P(i(((f) localObject).b, (i3 / f1 - ((f) localObject).e) / (((f) localObject).d + f2), i1, (int) (paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.I)) - this.G)), true, true, i1);
                }
                label523:
                bool = L();
                break label591;
            } else {
                this.j.abortAnimation();
                this.w = false;
                E();
                f1 = paramMotionEvent.getX();
                this.G = f1;
                this.E = f1;
                f1 = paramMotionEvent.getY();
                this.H = f1;
                this.F = f1;
                i1 = paramMotionEvent.getPointerId(0);
            }
            label585:
            this.I = i1;
            label591:
            if (bool) {
                x.h0(this);
            }
            return true;
        }
        return false;
    }

    public boolean p(KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getAction() == 0) {
            int i1 = paramKeyEvent.getKeyCode();
            if (i1 != 21) {
                if (i1 != 22) {
                    if (i1 != 61) {
                        break label101;
                    }
                    if (paramKeyEvent.hasNoModifiers()) {
                        return d(2);
                    }
                    if (!paramKeyEvent.hasModifiers(1)) {
                        break label101;
                    }
                    return d(1);
                }
                if (paramKeyEvent.hasModifiers(2)) {
                    return B();
                }
                i1 = 66;
            } else {
                if (paramKeyEvent.hasModifiers(2)) {
                    return A();
                }
                i1 = 17;
            }
            return d(i1);
        }
        label101:
        return false;
    }

    f r(View paramView) {
        for (; ; ) {
            ViewParent localViewParent = paramView.getParent();
            if (localViewParent == this) {
                break label34;
            }
            if ((localViewParent == null) || (!(localViewParent instanceof View))) {
                break;
            }
            paramView = (View) localViewParent;
        }
        return null;
        label34:
        return s(paramView);
    }

    public void removeView(View paramView) {
        if (this.u) {
            removeViewInLayout(paramView);
            return;
        }
        super.removeView(paramView);
    }

    f s(View paramView) {
        int i1 = 0;
        while (i1 < this.b.size()) {
            f localf = (f) this.b.get(i1);
            if (this.e.k(paramView, localf.a)) {
                return localf;
            }
            i1 += 1;
        }
        return null;
    }

    public void setAdapter(a parama) {
        Object localObject = this.e;
        int i2 = 0;
        int i1;
        if (localObject != null) {
            ((a) localObject).q(null);
            this.e.s(this);
            i1 = 0;
            while (i1 < this.b.size()) {
                localObject = (f) this.b.get(i1);
                this.e.b(this, ((f) localObject).b, ((f) localObject).a);
                i1 += 1;
            }
            this.e.d(this);
            this.b.clear();
            H();
            this.f = 0;
            scrollTo(0, 0);
        }
        localObject = this.e;
        this.e = parama;
        this.a = 0;
        if (parama != null) {
            if (this.l == null) {
                this.l = new k();
            }
            this.e.q(this.l);
            this.w = false;
            boolean bool = this.R;
            this.R = true;
            this.a = this.e.e();
            if (this.g >= 0) {
                this.e.m(this.h, this.i);
                O(this.g, false, true);
                this.g = -1;
                this.h = null;
                this.i = null;
            } else if (!bool) {
                E();
            } else {
                requestLayout();
            }
        }
        List localList = this.b0;
        if ((localList != null) && (!localList.isEmpty())) {
            int i3 = this.b0.size();
            i1 = i2;
            while (i1 < i3) {
                ((h) this.b0.get(i1)).a(this, (a) localObject, parama);
                i1 += 1;
            }
        }
    }

    public void setCurrentItem(int paramInt) {
        this.w = false;
        O(paramInt, this.R ^ true, false);
    }

    public void setOffscreenPageLimit(int paramInt) {
        int i1 = paramInt;
        if (paramInt < 1) {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Requested offscreen page limit ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" too small; defaulting to ");
            localStringBuilder.append(1);
            Log.w("ViewPager", localStringBuilder.toString());
            i1 = 1;
        }
        if (i1 != this.x) {
            this.x = i1;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i parami) {
        this.W = parami;
    }

    public void setPageMargin(int paramInt) {
        int i1 = this.m;
        this.m = paramInt;
        int i2 = getWidth();
        G(i2, i2, paramInt, i1);
        requestLayout();
    }

    public void setPageMarginDrawable(int paramInt) {
        setPageMarginDrawable(b.d(getContext(), paramInt));
    }

    public void setPageMarginDrawable(Drawable paramDrawable) {
        this.n = paramDrawable;
        if (paramDrawable != null) {
            refreshDrawableState();
        }
        boolean bool;
        if (paramDrawable == null) {
            bool = true;
        } else {
            bool = false;
        }
        setWillNotDraw(bool);
        invalidate();
    }

    void setScrollState(int paramInt) {
        if (this.h0 == paramInt) {
            return;
        }
        this.h0 = paramInt;
        if (this.c0 != null) {
            boolean bool;
            if (paramInt != 0) {
                bool = true;
            } else {
                bool = false;
            }
            n(bool);
        }
        l(paramInt);
    }

    f u(int paramInt) {
        int i1 = 0;
        while (i1 < this.b.size()) {
            f localf = (f) this.b.get(i1);
            if (localf.b == paramInt) {
                return localf;
            }
            i1 += 1;
        }
        return null;
    }

    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context localContext = getContext();
        this.j = new Scroller(localContext, k0);
        ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
        float f1 = localContext.getResources().getDisplayMetrics().density;
        this.C = localViewConfiguration.getScaledPagingTouchSlop();
        this.K = ((int) (400.0F * f1));
        this.L = localViewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(localContext);
        this.Q = new EdgeEffect(localContext);
        this.M = ((int) (25.0F * f1));
        this.N = ((int) (2.0F * f1));
        this.A = ((int) (f1 * 16.0F));
        x.q0(this, new g());
        if (x.z(this) == 0) {
            x.B0(this, 1);
        }
        x.E0(this, new d());
    }

    protected boolean verifyDrawable(Drawable paramDrawable) {
        return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.n);
    }

    protected void y(int paramInt1, float paramFloat, int paramInt2) {
        int i1 = this.U;
        int i6 = 0;
        View localView;
        if (i1 > 0) {
            int i7 = getScrollX();
            i1 = getPaddingLeft();
            int i2 = getPaddingRight();
            int i8 = getWidth();
            int i9 = getChildCount();
            int i4 = 0;
            while (i4 < i9) {
                localView = getChildAt(i4);
                LayoutParams localLayoutParams = (LayoutParams) localView.getLayoutParams();
                if (localLayoutParams.a) {
                    int i3 = localLayoutParams.b & 0x7;
                    if (i3 != 1) {
                        int i5;
                        if (i3 != 3) {
                            if (i3 != 5) {
                                i5 = i1;
                                i3 = i1;
                                i1 = i5;
                            } else {
                                i3 = i8 - i2 - localView.getMeasuredWidth();
                                i2 += localView.getMeasuredWidth();
                            }
                        } else {
                            i5 = localView.getWidth() + i1;
                            i3 = i1;
                            i1 = i5;
                        }
                    } else {
                        i3 = Math.max((i8 - localView.getMeasuredWidth()) / 2, i1);
                    }
                    i3 = i3 + i7 - localView.getLeft();
                    if (i3 != 0) {
                        localView.offsetLeftAndRight(i3);
                    }
                }
                i4 += 1;
            }
        }
        j(paramInt1, paramFloat, paramInt2);
        if (this.c0 != null) {
            paramInt2 = getScrollX();
            i1 = getChildCount();
            paramInt1 = i6;
            while (paramInt1 < i1) {
                localView = getChildAt(paramInt1);
                if (!((LayoutParams) localView.getLayoutParams()).a) {
                    paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
                    this.c0.a(localView, paramFloat);
                }
                paramInt1 += 1;
            }
        }
        this.T = true;
    }

    public static class LayoutParams
            extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0F;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1);
        }

        public LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.i0);
            this.b = paramContext.getInteger(0, 48);
            paramContext.recycle();
        }
    }

    public static class SavedState
            extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int c;
        Parcelable d;
        ClassLoader e;

        SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
            super(paramClassLoader);
            ClassLoader localClassLoader = paramClassLoader;
            if (paramClassLoader == null) {
                localClassLoader = getClass().getClassLoader();
            }
            this.c = paramParcel.readInt();
            this.d = paramParcel.readParcelable(localClassLoader);
            this.e = localClassLoader;
        }

        public SavedState(Parcelable paramParcelable) {
            super();
        }

        public String toString() {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("FragmentPager.SavedState{");
            localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            localStringBuilder.append(" position=");
            localStringBuilder.append(this.c);
            localStringBuilder.append("}");
            return localStringBuilder.toString();
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeInt(this.c);
            paramParcel.writeParcelable(this.d, paramInt);
        }

        static final class a
                implements Parcelable.ClassLoaderCreator<ViewPager.SavedState> {
            public ViewPager.SavedState a(Parcel paramParcel) {
                return new ViewPager.SavedState(paramParcel, null);
            }

            public ViewPager.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader) {
                return new ViewPager.SavedState(paramParcel, paramClassLoader);
            }

            public ViewPager.SavedState[] c(int paramInt) {
                return new ViewPager.SavedState[paramInt];
            }
        }
    }

    static final class a
            implements Comparator<ViewPager.f> {
        public int a(ViewPager.f paramf1, ViewPager.f paramf2) {
            return paramf1.b - paramf2.b;
        }
    }

    static final class b
            implements Interpolator {
        public float getInterpolation(float paramFloat) {
            paramFloat -= 1.0F;
            return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
        }
    }

    class c
            implements Runnable {
        c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    class d
            implements r {
        private final Rect a = new Rect();

        d() {
        }

        public h0 a(View paramView, h0 paramh0) {
            paramView = x.c0(paramView, paramh0);
            if (paramView.p()) {
                return paramView;
            }
            paramh0 = this.a;
            paramh0.left = paramView.j();
            paramh0.top = paramView.l();
            paramh0.right = paramView.k();
            paramh0.bottom = paramView.i();
            int i = 0;
            int j = ViewPager.this.getChildCount();
            while (i < j) {
                h0 localh0 = x.g(ViewPager.this.getChildAt(i), paramView);
                paramh0.left = Math.min(localh0.j(), paramh0.left);
                paramh0.top = Math.min(localh0.l(), paramh0.top);
                paramh0.right = Math.min(localh0.k(), paramh0.right);
                paramh0.bottom = Math.min(localh0.i(), paramh0.bottom);
                i += 1;
            }
            return paramView.q(paramh0.left, paramh0.top, paramh0.right, paramh0.bottom);
        }
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({java.lang.annotation.ElementType.TYPE})
    public static @interface e {
    }

    static class f {
        Object a;
        int b;
        boolean c;
        float d;
        float e;
    }

    class g
            extends androidx.core.view.a {
        g() {
        }

        private boolean n() {
            a locala = ViewPager.this.e;
            return (locala != null) && (locala.e() > 1);
        }

        public void f(View paramView, AccessibilityEvent paramAccessibilityEvent) {
            super.f(paramView, paramAccessibilityEvent);
            paramAccessibilityEvent.setClassName(ViewPager.class.getName());
            paramAccessibilityEvent.setScrollable(n());
            if (paramAccessibilityEvent.getEventType() == 4096) {
                paramView = ViewPager.this.e;
                if (paramView != null) {
                    paramAccessibilityEvent.setItemCount(paramView.e());
                    paramAccessibilityEvent.setFromIndex(ViewPager.this.f);
                    paramAccessibilityEvent.setToIndex(ViewPager.this.f);
                }
            }
        }

        public void g(View paramView, d paramd) {
            super.g(paramView, paramd);
            paramd.c0(ViewPager.class.getName());
            paramd.z0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                paramd.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                paramd.a(8192);
            }
        }

        public boolean j(View paramView, int paramInt, Bundle paramBundle) {
            if (super.j(paramView, paramInt, paramBundle)) {
                return true;
            }
            if (paramInt != 4096) {
                if (paramInt != 8192) {
                    return false;
                }
                if (ViewPager.this.canScrollHorizontally(-1)) {
                    paramView = ViewPager.this;
                }
            }
            for (paramInt = paramView.f - 1; ; paramInt = paramView.f + 1) {
                paramView.setCurrentItem(paramInt);
                return true;
                return false;
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    break;
                }
                paramView = ViewPager.this;
            }
            return false;
        }
    }

    public static abstract interface h {
        public abstract void a(ViewPager paramViewPager, a parama1, a parama2);
    }

    public static abstract interface i {
        public abstract void D(int paramInt);

        public abstract void J(int paramInt);

        public abstract void s(int paramInt1, float paramFloat, int paramInt2);
    }

    public static abstract interface j {
        public abstract void a(View paramView, float paramFloat);
    }

    private class k
            extends DataSetObserver {
        k() {
        }

        public void onChanged() {
            ViewPager.this.h();
        }

        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    static class l
            implements Comparator<View> {
        public int a(View paramView1, View paramView2) {
            paramView1 = (ViewPager.LayoutParams) paramView1.getLayoutParams();
            paramView2 = (ViewPager.LayoutParams) paramView2.getLayoutParams();
            boolean bool = paramView1.a;
            if (bool != paramView2.a) {
                if (bool) {
                    return 1;
                }
                return -1;
            }
            return paramView1.e - paramView2.e;
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     androidx.viewpager.widget.ViewPager

 * JD-Core Version:    0.7.0.1

 */