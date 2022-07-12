package z5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import s3.p;

public class b
  extends PopupWindow
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private final p<Integer> a;
  private final RadioButton b;
  private final RadioButton c;
  private final RadioButton d;
  private final RadioButton e;
  
  public b(Context paramContext, p<Integer> paramp)
  {
    super(paramContext, null);
    this.a = paramp;
    setContentView(LayoutInflater.from(paramContext).inflate(2131427579, null));
    setWidth(-1);
    setHeight((int)(Resources.getSystem().getDisplayMetrics().density * 53.0F));
    setOutsideTouchable(true);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(0));
    paramContext = (RadioButton)getContentView().findViewById(2131231378);
    this.b = paramContext;
    paramp = (RadioButton)getContentView().findViewById(2131231379);
    this.c = paramp;
    RadioButton localRadioButton1 = (RadioButton)getContentView().findViewById(2131231380);
    this.d = localRadioButton1;
    RadioButton localRadioButton2 = (RadioButton)getContentView().findViewById(2131231381);
    this.e = localRadioButton2;
    paramContext.setOnCheckedChangeListener(this);
    paramp.setOnCheckedChangeListener(this);
    localRadioButton1.setOnCheckedChangeListener(this);
    localRadioButton2.setOnCheckedChangeListener(this);
    getContentView().findViewById(2131231104).setOnClickListener(this);
    getContentView().findViewById(2131231100).setOnClickListener(this);
    getContentView().findViewById(2131231109).setOnClickListener(this);
    getContentView().findViewById(2131231111).setOnClickListener(this);
    setAnimationStyle(2131756072);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramCompoundButton.getId() == this.b.getId()))
    {
      this.e.setChecked(false);
      this.d.setChecked(false);
      this.c.setChecked(false);
      this.a.C0(Integer.valueOf(80), null);
    }
    if ((paramBoolean) && (paramCompoundButton.getId() == this.c.getId()))
    {
      this.b.setChecked(false);
      this.d.setChecked(false);
      this.e.setChecked(false);
      this.a.C0(Integer.valueOf(100), null);
    }
    if ((paramBoolean) && (paramCompoundButton.getId() == this.d.getId()))
    {
      this.b.setChecked(false);
      this.e.setChecked(false);
      this.c.setChecked(false);
      this.a.C0(Integer.valueOf(120), null);
    }
    if ((paramBoolean) && (paramCompoundButton.getId() == this.e.getId()))
    {
      this.a.C0(Integer.valueOf(150), null);
      this.b.setChecked(false);
      this.d.setChecked(false);
      this.c.setChecked(false);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231104)
    {
      this.b.setChecked(false);
      this.d.setChecked(false);
      this.c.setChecked(false);
      this.e.setChecked(true);
    }
    if (paramView.getId() == 2131231100)
    {
      this.b.setChecked(false);
      this.d.setChecked(true);
      this.c.setChecked(false);
      this.e.setChecked(false);
    }
    if (paramView.getId() == 2131231109)
    {
      this.b.setChecked(false);
      this.d.setChecked(false);
      this.c.setChecked(true);
      this.e.setChecked(false);
    }
    if (paramView.getId() == 2131231111)
    {
      this.b.setChecked(true);
      this.d.setChecked(false);
      this.c.setChecked(false);
      this.e.setChecked(false);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z5.b
 * JD-Core Version:    0.7.0.1
 */