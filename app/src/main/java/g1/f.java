package g1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

public final class f
{
  private final b a;
  
  public f(TextView paramTextView, boolean paramBoolean)
  {
    x0.h.h(paramTextView, "textView cannot be null");
    if (!paramBoolean) {
      paramTextView = new c(paramTextView);
    } else {
      paramTextView = new a(paramTextView);
    }
    this.a = paramTextView;
  }
  
  public InputFilter[] a(InputFilter[] paramArrayOfInputFilter)
  {
    return this.a.a(paramArrayOfInputFilter);
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.d(paramBoolean);
  }
  
  public TransformationMethod e(TransformationMethod paramTransformationMethod)
  {
    return this.a.e(paramTransformationMethod);
  }
  
  private static class a
    extends f.b
  {
    private final TextView a;
    private final d b;
    private boolean c;
    
    a(TextView paramTextView)
    {
      this.a = paramTextView;
      this.c = true;
      this.b = new d(paramTextView);
    }
    
    private InputFilter[] f(InputFilter[] paramArrayOfInputFilter)
    {
      int j = paramArrayOfInputFilter.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInputFilter[i] == this.b) {
          return paramArrayOfInputFilter;
        }
        i += 1;
      }
      InputFilter[] arrayOfInputFilter = new InputFilter[paramArrayOfInputFilter.length + 1];
      System.arraycopy(paramArrayOfInputFilter, 0, arrayOfInputFilter, 0, j);
      arrayOfInputFilter[j] = this.b;
      return arrayOfInputFilter;
    }
    
    private SparseArray<InputFilter> g(InputFilter[] paramArrayOfInputFilter)
    {
      SparseArray localSparseArray = new SparseArray(1);
      int i = 0;
      while (i < paramArrayOfInputFilter.length)
      {
        if ((paramArrayOfInputFilter[i] instanceof d)) {
          localSparseArray.put(i, paramArrayOfInputFilter[i]);
        }
        i += 1;
      }
      return localSparseArray;
    }
    
    private InputFilter[] h(InputFilter[] paramArrayOfInputFilter)
    {
      SparseArray localSparseArray = g(paramArrayOfInputFilter);
      if (localSparseArray.size() == 0) {
        return paramArrayOfInputFilter;
      }
      int m = paramArrayOfInputFilter.length;
      InputFilter[] arrayOfInputFilter = new InputFilter[paramArrayOfInputFilter.length - localSparseArray.size()];
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (localSparseArray.indexOfKey(i) < 0)
        {
          arrayOfInputFilter[j] = paramArrayOfInputFilter[i];
          k = j + 1;
        }
        i += 1;
      }
      return arrayOfInputFilter;
    }
    
    private TransformationMethod j(TransformationMethod paramTransformationMethod)
    {
      TransformationMethod localTransformationMethod = paramTransformationMethod;
      if ((paramTransformationMethod instanceof h)) {
        localTransformationMethod = ((h)paramTransformationMethod).a();
      }
      return localTransformationMethod;
    }
    
    private void k()
    {
      InputFilter[] arrayOfInputFilter = this.a.getFilters();
      this.a.setFilters(a(arrayOfInputFilter));
    }
    
    private TransformationMethod m(TransformationMethod paramTransformationMethod)
    {
      if ((paramTransformationMethod instanceof h)) {
        return paramTransformationMethod;
      }
      if ((paramTransformationMethod instanceof PasswordTransformationMethod)) {
        return paramTransformationMethod;
      }
      return new h(paramTransformationMethod);
    }
    
    InputFilter[] a(InputFilter[] paramArrayOfInputFilter)
    {
      if (!this.c) {
        return h(paramArrayOfInputFilter);
      }
      return f(paramArrayOfInputFilter);
    }
    
    public boolean b()
    {
      return this.c;
    }
    
    void c(boolean paramBoolean)
    {
      if (paramBoolean) {
        l();
      }
    }
    
    void d(boolean paramBoolean)
    {
      this.c = paramBoolean;
      l();
      k();
    }
    
    TransformationMethod e(TransformationMethod paramTransformationMethod)
    {
      if (this.c) {
        return m(paramTransformationMethod);
      }
      return j(paramTransformationMethod);
    }
    
    void i(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    void l()
    {
      TransformationMethod localTransformationMethod = e(this.a.getTransformationMethod());
      this.a.setTransformationMethod(localTransformationMethod);
    }
  }
  
  static class b
  {
    InputFilter[] a(InputFilter[] paramArrayOfInputFilter)
    {
      throw null;
    }
    
    public boolean b()
    {
      throw null;
    }
    
    void c(boolean paramBoolean)
    {
      throw null;
    }
    
    void d(boolean paramBoolean)
    {
      throw null;
    }
    
    TransformationMethod e(TransformationMethod paramTransformationMethod)
    {
      throw null;
    }
  }
  
  private static class c
    extends f.b
  {
    private final f.a a;
    
    c(TextView paramTextView)
    {
      this.a = new f.a(paramTextView);
    }
    
    private boolean f()
    {
      return androidx.emoji2.text.d.h() ^ true;
    }
    
    InputFilter[] a(InputFilter[] paramArrayOfInputFilter)
    {
      if (f()) {
        return paramArrayOfInputFilter;
      }
      return this.a.a(paramArrayOfInputFilter);
    }
    
    public boolean b()
    {
      return this.a.b();
    }
    
    void c(boolean paramBoolean)
    {
      if (f()) {
        return;
      }
      this.a.c(paramBoolean);
    }
    
    void d(boolean paramBoolean)
    {
      if (f())
      {
        this.a.i(paramBoolean);
        return;
      }
      this.a.d(paramBoolean);
    }
    
    TransformationMethod e(TransformationMethod paramTransformationMethod)
    {
      if (f()) {
        return paramTransformationMethod;
      }
      return this.a.e(paramTransformationMethod);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.f
 * JD-Core Version:    0.7.0.1
 */