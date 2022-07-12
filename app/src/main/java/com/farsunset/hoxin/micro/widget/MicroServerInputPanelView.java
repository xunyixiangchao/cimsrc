package com.farsunset.hoxin.micro.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelLinearLayout;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.message.widget.EmoticonPanelView;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import r5.d;
import s3.n;
import s3.u;
import s5.e;
import u3.l;
import x1.a.c;
import x1.a.d;
import x1.c;
import x1.c.b;

public class MicroServerInputPanelView
  extends FrameLayout
  implements View.OnClickListener, TextWatcher, c.b, a.d, d
{
  private List<MicroServerMenu> a;
  private View b;
  private EditText c;
  private EmoticonPanelView d;
  private n e;
  private InputMethodManager f;
  private RecyclerView g;
  private final z5.a h;
  private u<MicroServerMenu> i;
  private View j;
  private View k;
  private KPSwitchPanelLinearLayout l;
  
  public MicroServerInputPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = new z5.a(paramContext);
  }
  
  private List<MicroServerMenu> f(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MicroServerMenu localMicroServerMenu = (MicroServerMenu)localIterator.next();
      if (Objects.equals(Long.valueOf(paramLong), localMicroServerMenu.parentId)) {
        localArrayList.add(localMicroServerMenu);
      }
    }
    Collections.sort(localArrayList, new t5.a());
    return localArrayList;
  }
  
  private List<MicroServerMenu> getRootMenuList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MicroServerMenu localMicroServerMenu = (MicroServerMenu)localIterator.next();
      if (localMicroServerMenu.isRootMenu()) {
        localArrayList.add(localMicroServerMenu);
      }
    }
    Collections.sort(localArrayList, new t5.a());
    return localArrayList;
  }
  
  private void h()
  {
    if (this.b.isSelected())
    {
      this.b.setSelected(false);
      c.j(this.c);
      return;
    }
    this.b.setSelected(true);
    x1.a.d(this.l);
  }
  
  private void k()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772005);
    localAnimation.setAnimationListener(new a());
    this.k.setVisibility(0);
    startAnimation(localAnimation);
    this.j.setVisibility(8);
    this.c.requestFocus();
  }
  
  private void l()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772005);
    localAnimation.setAnimationListener(new b());
    this.b.setSelected(false);
    x1.a.d(this.l);
    this.j.setVisibility(0);
    startAnimation(localAnimation);
    this.k.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setSelected(false);
      this.e.q(true);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void b()
  {
    KeyEvent localKeyEvent = new KeyEvent(0, 67);
    this.c.onKeyDown(67, localKeyEvent);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(View paramView, boolean paramBoolean)
  {
    this.b.setSelected(paramBoolean);
    this.e.q(paramBoolean);
  }
  
  public void e(List<MicroServerMenu> paramList)
  {
    this.a = paramList;
    paramList = getRootMenuList();
    if (paramList.isEmpty()) {
      return;
    }
    this.g.setAdapter(new e(paramList, new a6.a(this)));
  }
  
  public void i()
  {
    x1.a.d(this.l);
    this.b.setSelected(false);
  }
  
  public void j(EmoticonItem paramEmoticonItem)
  {
    this.c.setCursorVisible(true);
    Drawable localDrawable = d4.b.d().e(paramEmoticonItem.name);
    if (localDrawable == null) {
      return;
    }
    SpannableString localSpannableString = new SpannableString(paramEmoticonItem.name);
    int m = l.p(22.0F);
    localDrawable.setBounds(0, 0, m, m);
    localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, paramEmoticonItem.name.length(), 33);
    this.c.getEditableText().insert(this.c.getSelectionStart(), localSpannableString);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c.b((Activity)getContext(), this.l, this);
    x1.a.b(this.l, this.c, this, new a.c[] { new a.c(this.d, this.b) });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131231432: 
      if (l.c0(this.c.getText()))
      {
        this.e.n0(this.c.getText().toString());
        ((EditText)findViewById(2131231090)).getText().clear();
        return;
      }
      break;
    case 2131231183: 
      l();
      return;
    case 2131231118: 
      k();
      return;
    case 2131230873: 
      h();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject = (RecyclerView)findViewById(2131231182);
    this.g = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.g.h(new f(getContext(), 0));
    this.c = ((EditText)findViewById(2131231090));
    localObject = (EmoticonPanelView)findViewById(2131230979);
    this.d = ((EmoticonPanelView)localObject);
    ((EmoticonPanelView)localObject).setOnEmoticonEventListener(this);
    this.c.addTextChangedListener(this);
    this.f = ((InputMethodManager)androidx.core.content.b.h(getContext(), InputMethodManager.class));
    localObject = findViewById(2131230873);
    this.b = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    int m = Resources.getSystem().getDisplayMetrics().widthPixels / 6;
    localObject = findViewById(2131231183);
    ((View)localObject).setOnClickListener(this);
    ((View)localObject).getLayoutParams().width = m;
    localObject = findViewById(2131231118);
    ((View)localObject).setOnClickListener(this);
    ((View)localObject).getLayoutParams().width = m;
    findViewById(2131231432).setOnClickListener(this);
    this.j = findViewById(2131231184);
    this.k = findViewById(2131231119);
    this.l = ((KPSwitchPanelLinearLayout)findViewById(2131230733));
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setContent(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void setOnInputPanelEventListener(n paramn)
  {
    this.e = paramn;
  }
  
  public void setOnMenuClickListener(u<MicroServerMenu> paramu)
  {
    this.i = paramu;
    this.h.b(paramu);
  }
  
  class a
    extends s3.a
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      MicroServerInputPanelView.this.clearAnimation();
    }
  }
  
  class b
    extends s3.a
  {
    b() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      MicroServerInputPanelView.this.clearAnimation();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.MicroServerInputPanelView
 * JD-Core Version:    0.7.0.1
 */