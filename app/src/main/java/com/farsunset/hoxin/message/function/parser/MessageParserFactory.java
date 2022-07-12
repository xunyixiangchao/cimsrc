package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.res.AssetManager;
import android.util.ArrayMap;
import ca.c;
import com.farsunset.hoxin.HoxinApplication;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class MessageParserFactory
{
  private static final Map<String, MessageParser> PARSER_MAP;
  private static final Properties properties;
  
  static
  {
    Properties localProperties = new Properties();
    properties = localProperties;
    PARSER_MAP = new ArrayMap();
    try
    {
      InputStream localInputStream = HoxinApplication.h().getAssets().open("properties/parsers.properties");
      localProperties.load(localInputStream);
      c.b(localInputStream);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public static MessageParser getMessageParser(String paramString)
  {
    Map localMap = PARSER_MAP;
    MessageParser localMessageParser = (MessageParser)localMap.get(paramString);
    if (localMessageParser != null) {
      return localMessageParser;
    }
    try
    {
      localMessageParser = (MessageParser)Class.forName(properties.getProperty(paramString)).newInstance();
      localMap.put(paramString, localMessageParser);
      return localMessageParser;
    }
    catch (Exception paramString)
    {
      label49:
      break label49;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.MessageParserFactory
 * JD-Core Version:    0.7.0.1
 */