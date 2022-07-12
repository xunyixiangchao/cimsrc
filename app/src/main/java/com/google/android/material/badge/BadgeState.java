package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.material.R.dimen;
import com.google.android.material.R.plurals;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import i7.a;
import java.util.Locale;
import java.util.Locale.Category;
import o7.c;
import o7.d;

public final class BadgeState
{
  private final State a;
  private final State b;
  final float c;
  final float d;
  final float e;
  
  BadgeState(Context paramContext, int paramInt1, int paramInt2, int paramInt3, State paramState)
  {
    State localState2 = new State();
    this.b = localState2;
    State localState1 = paramState;
    if (paramState == null) {
      localState1 = new State();
    }
    if (paramInt1 != 0) {
      State.h(localState1, paramInt1);
    }
    TypedArray localTypedArray = a(paramContext, State.g(localState1), paramInt2, paramInt3);
    paramState = paramContext.getResources();
    this.c = localTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeRadius, paramState.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
    this.e = localTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, paramState.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
    this.d = localTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, paramState.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
    if (State.i(localState1) == -2) {
      paramInt1 = 255;
    } else {
      paramInt1 = State.i(localState1);
    }
    State.o(localState2, paramInt1);
    if (State.D(localState1) == null) {
      paramState = paramContext.getString(R.string.mtrl_badge_numberless_content_description);
    } else {
      paramState = State.D(localState1);
    }
    State.E(localState2, paramState);
    if (State.F(localState1) == 0) {
      paramInt1 = R.plurals.mtrl_badge_content_description;
    } else {
      paramInt1 = State.F(localState1);
    }
    State.G(localState2, paramInt1);
    if (State.H(localState1) == 0) {
      paramInt1 = R.string.mtrl_exceed_max_badge_number_content_description;
    } else {
      paramInt1 = State.H(localState1);
    }
    State.I(localState2, paramInt1);
    paramState = State.J(localState1);
    paramInt2 = 0;
    boolean bool;
    if ((paramState != null) && (!State.J(localState1).booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    State.K(localState2, Boolean.valueOf(bool));
    if (State.L(localState1) == -2) {
      paramInt1 = localTypedArray.getInt(R.styleable.Badge_maxCharacterCount, 4);
    } else {
      paramInt1 = State.L(localState1);
    }
    State.M(localState2, paramInt1);
    if (State.N(localState1) != -2) {
      paramInt1 = State.N(localState1);
    }
    for (;;)
    {
      State.O(localState2, paramInt1);
      break;
      paramInt1 = R.styleable.Badge_number;
      if (localTypedArray.hasValue(paramInt1)) {
        paramInt1 = localTypedArray.getInt(paramInt1, 0);
      } else {
        paramInt1 = -1;
      }
    }
    if (State.P(localState1) == null) {
      paramInt1 = u(paramContext, localTypedArray, R.styleable.Badge_backgroundColor);
    } else {
      paramInt1 = State.P(localState1).intValue();
    }
    State.Q(localState2, Integer.valueOf(paramInt1));
    if (State.R(localState1) != null) {}
    for (paramContext = State.R(localState1);; paramContext = Integer.valueOf(paramInt1))
    {
      State.S(localState2, paramContext);
      break;
      paramInt1 = R.styleable.Badge_badgeTextColor;
      if (localTypedArray.hasValue(paramInt1)) {
        paramInt1 = u(paramContext, localTypedArray, paramInt1);
      } else {
        paramInt1 = new d(paramContext, R.style.TextAppearance_MaterialComponents_Badge).i().getDefaultColor();
      }
    }
    if (State.m(localState1) == null) {
      paramInt1 = localTypedArray.getInt(R.styleable.Badge_badgeGravity, 8388661);
    } else {
      paramInt1 = State.m(localState1).intValue();
    }
    State.n(localState2, Integer.valueOf(paramInt1));
    if (State.p(localState1) == null) {
      paramInt1 = localTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
    } else {
      paramInt1 = State.p(localState1).intValue();
    }
    State.q(localState2, Integer.valueOf(paramInt1));
    if (State.p(localState1) == null) {
      paramInt1 = localTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
    } else {
      paramInt1 = State.r(localState1).intValue();
    }
    State.s(localState2, Integer.valueOf(paramInt1));
    if (State.t(localState1) == null) {
      paramInt1 = localTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, State.p(localState2).intValue());
    } else {
      paramInt1 = State.t(localState1).intValue();
    }
    State.u(localState2, Integer.valueOf(paramInt1));
    if (State.v(localState1) == null) {
      paramInt1 = localTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, State.r(localState2).intValue());
    } else {
      paramInt1 = State.v(localState1).intValue();
    }
    State.w(localState2, Integer.valueOf(paramInt1));
    if (State.x(localState1) == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = State.x(localState1).intValue();
    }
    State.y(localState2, Integer.valueOf(paramInt1));
    if (State.z(localState1) == null) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = State.z(localState1).intValue();
    }
    State.A(localState2, Integer.valueOf(paramInt1));
    localTypedArray.recycle();
    if (State.B(localState1) == null)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = Locale.getDefault(Locale.Category.FORMAT);
      } else {
        paramContext = Locale.getDefault();
      }
    }
    else {
      paramContext = State.B(localState1);
    }
    State.C(localState2, paramContext);
    this.a = localState1;
  }
  
  private TypedArray a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AttributeSet localAttributeSet;
    if (paramInt1 != 0)
    {
      localAttributeSet = a.a(paramContext, paramInt1, "badge");
      paramInt1 = localAttributeSet.getStyleAttribute();
    }
    else
    {
      localAttributeSet = null;
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      paramInt1 = paramInt3;
    }
    return p.h(paramContext, localAttributeSet, R.styleable.Badge, paramInt2, paramInt1, new int[0]);
  }
  
  private static int u(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    return c.a(paramContext, paramTypedArray, paramInt).getDefaultColor();
  }
  
  void A(boolean paramBoolean)
  {
    State.K(this.a, Boolean.valueOf(paramBoolean));
    State.K(this.b, Boolean.valueOf(paramBoolean));
  }
  
  int b()
  {
    return State.x(this.b).intValue();
  }
  
  int c()
  {
    return State.z(this.b).intValue();
  }
  
  int d()
  {
    return State.i(this.b);
  }
  
  int e()
  {
    return State.P(this.b).intValue();
  }
  
  int f()
  {
    return State.m(this.b).intValue();
  }
  
  int g()
  {
    return State.R(this.b).intValue();
  }
  
  int h()
  {
    return State.H(this.b);
  }
  
  CharSequence i()
  {
    return State.D(this.b);
  }
  
  int j()
  {
    return State.F(this.b);
  }
  
  int k()
  {
    return State.t(this.b).intValue();
  }
  
  int l()
  {
    return State.p(this.b).intValue();
  }
  
  int m()
  {
    return State.L(this.b);
  }
  
  int n()
  {
    return State.N(this.b);
  }
  
  Locale o()
  {
    return State.B(this.b);
  }
  
  State p()
  {
    return this.a;
  }
  
  int q()
  {
    return State.v(this.b).intValue();
  }
  
  int r()
  {
    return State.r(this.b).intValue();
  }
  
  boolean s()
  {
    return State.N(this.b) != -1;
  }
  
  boolean t()
  {
    return State.J(this.b).booleanValue();
  }
  
  void v(int paramInt)
  {
    State.o(this.a, paramInt);
    State.o(this.b, paramInt);
  }
  
  void w(int paramInt)
  {
    State.Q(this.a, Integer.valueOf(paramInt));
    State.Q(this.b, Integer.valueOf(paramInt));
  }
  
  void x(int paramInt)
  {
    State.S(this.a, Integer.valueOf(paramInt));
    State.S(this.b, Integer.valueOf(paramInt));
  }
  
  void y(int paramInt)
  {
    State.M(this.a, paramInt);
    State.M(this.b, paramInt);
  }
  
  void z(int paramInt)
  {
    State.O(this.a, paramInt);
    State.O(this.b, paramInt);
  }
  
  public static final class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new a();
    private int a;
    private Integer b;
    private Integer c;
    private int d = 255;
    private int e = -2;
    private int f = -2;
    private Locale g;
    private CharSequence h;
    private int i;
    private int j;
    private Integer k;
    private Boolean l = Boolean.TRUE;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    private Integer r;
    
    public State() {}
    
    State(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = ((Integer)paramParcel.readSerializable());
      this.c = ((Integer)paramParcel.readSerializable());
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.h = paramParcel.readString();
      this.i = paramParcel.readInt();
      this.k = ((Integer)paramParcel.readSerializable());
      this.m = ((Integer)paramParcel.readSerializable());
      this.n = ((Integer)paramParcel.readSerializable());
      this.o = ((Integer)paramParcel.readSerializable());
      this.p = ((Integer)paramParcel.readSerializable());
      this.q = ((Integer)paramParcel.readSerializable());
      this.r = ((Integer)paramParcel.readSerializable());
      this.l = ((Boolean)paramParcel.readSerializable());
      this.g = ((Locale)paramParcel.readSerializable());
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeSerializable(this.b);
      paramParcel.writeSerializable(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      Object localObject = this.h;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((CharSequence)localObject).toString();
      }
      paramParcel.writeString((String)localObject);
      paramParcel.writeInt(this.i);
      paramParcel.writeSerializable(this.k);
      paramParcel.writeSerializable(this.m);
      paramParcel.writeSerializable(this.n);
      paramParcel.writeSerializable(this.o);
      paramParcel.writeSerializable(this.p);
      paramParcel.writeSerializable(this.q);
      paramParcel.writeSerializable(this.r);
      paramParcel.writeSerializable(this.l);
      paramParcel.writeSerializable(this.g);
    }
    
    class a
      implements Parcelable.Creator<BadgeState.State>
    {
      public BadgeState.State a(Parcel paramParcel)
      {
        return new BadgeState.State(paramParcel);
      }
      
      public BadgeState.State[] b(int paramInt)
      {
        return new BadgeState.State[paramInt];
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.badge.BadgeState
 * JD-Core Version:    0.7.0.1
 */