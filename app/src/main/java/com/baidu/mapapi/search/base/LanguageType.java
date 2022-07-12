package com.baidu.mapapi.search.base;

public enum LanguageType
{
  static
  {
    LanguageType localLanguageType1 = new LanguageType("LanguageTypeChinese", 0);
    LanguageTypeChinese = localLanguageType1;
    LanguageType localLanguageType2 = new LanguageType("LanguageTypeEnglish", 1);
    LanguageTypeEnglish = localLanguageType2;
    $VALUES = new LanguageType[] { localLanguageType1, localLanguageType2 };
  }
  
  private LanguageType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.base.LanguageType
 * JD-Core Version:    0.7.0.1
 */