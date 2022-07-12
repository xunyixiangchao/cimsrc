package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.fragment.R.styleable;

class i
  implements LayoutInflater.Factory2
{
  final FragmentManager a;
  
  i(FragmentManager paramFragmentManager)
  {
    this.a = paramFragmentManager;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, final AttributeSet paramAttributeSet)
  {
    if (FragmentContainerView.class.getName().equals(paramString)) {
      return new FragmentContainerView(paramContext, paramAttributeSet, this.a);
    }
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool) {
      return null;
    }
    Object localObject1 = paramAttributeSet.getAttributeValue(null, "class");
    Object localObject3 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Fragment);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ((TypedArray)localObject3).getString(R.styleable.Fragment_android_name);
    }
    int k = ((TypedArray)localObject3).getResourceId(R.styleable.Fragment_android_id, -1);
    String str = ((TypedArray)localObject3).getString(R.styleable.Fragment_android_tag);
    ((TypedArray)localObject3).recycle();
    if (localObject2 != null)
    {
      if (!g.b(paramContext.getClassLoader(), (String)localObject2)) {
        return null;
      }
      int i;
      if (paramView != null) {
        i = paramView.getId();
      } else {
        i = 0;
      }
      if ((i == -1) && (k == -1) && (str == null))
      {
        paramView = new StringBuilder();
        paramView.append(paramAttributeSet.getPositionDescription());
        paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
        paramView.append((String)localObject2);
        throw new IllegalArgumentException(paramView.toString());
      }
      if (k != -1) {
        paramString = this.a.i0(k);
      }
      localObject1 = paramString;
      if (paramString == null)
      {
        localObject1 = paramString;
        if (str != null) {
          localObject1 = this.a.j0(str);
        }
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = (String)localObject1;
        if (i != -1) {
          paramString = this.a.i0(i);
        }
      }
      if (paramString == null)
      {
        localObject1 = this.a.r0().a(paramContext.getClassLoader(), (String)localObject2);
        ((Fragment)localObject1).mFromLayout = true;
        int j;
        if (k != 0) {
          j = k;
        } else {
          j = i;
        }
        ((Fragment)localObject1).mFragmentId = j;
        ((Fragment)localObject1).mContainerId = i;
        ((Fragment)localObject1).mTag = str;
        ((Fragment)localObject1).mInLayout = true;
        paramString = this.a;
        ((Fragment)localObject1).mFragmentManager = paramString;
        ((Fragment)localObject1).mHost = paramString.u0();
        ((Fragment)localObject1).onInflate(this.a.u0().f(), paramAttributeSet, ((Fragment)localObject1).mSavedFragmentState);
        paramString = this.a.g((Fragment)localObject1);
        paramContext = (Context)localObject1;
        paramAttributeSet = paramString;
        if (FragmentManager.G0(2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Fragment ");
          ((StringBuilder)localObject3).append(localObject1);
          paramAttributeSet = " has been inflated via the <fragment> tag: id=0x";
          paramContext = (Context)localObject1;
        }
      }
      else
      {
        for (;;)
        {
          ((StringBuilder)localObject3).append(paramAttributeSet);
          ((StringBuilder)localObject3).append(Integer.toHexString(k));
          Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
          paramAttributeSet = paramString;
          break;
          if (paramString.mInLayout) {
            break label715;
          }
          paramString.mInLayout = true;
          paramContext = this.a;
          paramString.mFragmentManager = paramContext;
          paramString.mHost = paramContext.u0();
          paramString.onInflate(this.a.u0().f(), paramAttributeSet, paramString.mSavedFragmentState);
          localObject1 = this.a.w(paramString);
          paramContext = paramString;
          paramAttributeSet = (AttributeSet)localObject1;
          if (!FragmentManager.G0(2)) {
            break;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Retained Fragment ");
          ((StringBuilder)localObject3).append(paramString);
          paramAttributeSet = " has been re-attached via the <fragment> tag: id=0x";
          paramContext = paramString;
          paramString = (String)localObject1;
        }
      }
      paramContext.mContainer = ((ViewGroup)paramView);
      paramAttributeSet.m();
      paramAttributeSet.j();
      paramView = paramContext.mView;
      if (paramView != null)
      {
        if (k != 0) {
          paramView.setId(k);
        }
        if (paramContext.mView.getTag() == null) {
          paramContext.mView.setTag(str);
        }
        paramContext.mView.addOnAttachStateChangeListener(new a(paramAttributeSet));
        return paramContext.mView;
      }
      paramView = new StringBuilder();
      paramView.append("Fragment ");
      paramView.append((String)localObject2);
      paramView.append(" did not create a view.");
      throw new IllegalStateException(paramView.toString());
      label715:
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Duplicate id 0x");
      paramView.append(Integer.toHexString(k));
      paramView.append(", tag ");
      paramView.append(str);
      paramView.append(", or parent id 0x");
      paramView.append(Integer.toHexString(i));
      paramView.append(" with another fragment for ");
      paramView.append((String)localObject2);
      throw new IllegalArgumentException(paramView.toString());
    }
    return null;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  class a
    implements View.OnAttachStateChangeListener
  {
    a(o paramo) {}
    
    public void onViewAttachedToWindow(View paramView)
    {
      paramView = paramAttributeSet.k();
      paramAttributeSet.m();
      w.n((ViewGroup)paramView.mView.getParent(), i.this.a).j();
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.i
 * JD-Core Version:    0.7.0.1
 */