package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class MessageLiteToString
{
  private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
  private static final String BYTES_SUFFIX = "Bytes";
  private static final String LIST_SUFFIX = "List";
  
  private static final String camelCaseToSnakeCase(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean isDefaultValue(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue() ^ true;
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue() == 0;
    }
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue() == 0.0F;
    }
    if ((paramObject instanceof Double)) {
      return ((Double)paramObject).doubleValue() == 0.0D;
    }
    if ((paramObject instanceof String)) {}
    for (Object localObject = "";; localObject = ByteString.EMPTY)
    {
      return paramObject.equals(localObject);
      if (!(paramObject instanceof ByteString)) {
        break;
      }
    }
    if ((paramObject instanceof MessageLite)) {
      return paramObject == ((MessageLite)paramObject).getDefaultInstanceForType();
    }
    if ((paramObject instanceof Enum)) {
      return ((Enum)paramObject).ordinal() == 0;
    }
    return false;
  }
  
  static final void printField(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        printField(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String)) {
      paramStringBuilder.append(": \"");
    }
    for (paramString = TextFormatEscaper.escapeText((String)paramObject);; paramString = TextFormatEscaper.escapeBytes((ByteString)paramObject))
    {
      paramStringBuilder.append(paramString);
      paramStringBuilder.append('"');
      return;
      if (!(paramObject instanceof ByteString)) {
        break;
      }
      paramStringBuilder.append(": \"");
    }
    if ((paramObject instanceof GeneratedMessageLite))
    {
      paramStringBuilder.append(" {");
      reflectivePrintWithIndent((GeneratedMessageLite)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramString = "}";
    }
    else
    {
      paramStringBuilder.append(": ");
      paramString = paramObject.toString();
    }
    paramStringBuilder.append(paramString);
  }
  
  private static void reflectivePrintWithIndent(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new HashMap();
    Object localObject3 = new TreeSet();
    Object localObject4 = paramMessageLite.getClass().getDeclaredMethods();
    int j = localObject4.length;
    int i = 0;
    Object localObject5;
    while (i < j)
    {
      localObject5 = localObject4[i];
      ((Map)localObject2).put(((Method)localObject5).getName(), localObject5);
      if (((Method)localObject5).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject5).getName(), localObject5);
        if (((Method)localObject5).getName().startsWith("get")) {
          ((Set)localObject3).add(((Method)localObject5).getName());
        }
      }
      i += 1;
    }
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((String)((Iterator)localObject3).next()).replaceFirst("get", "");
      boolean bool2 = ((String)localObject4).endsWith("List");
      boolean bool1 = true;
      Object localObject6;
      if ((bool2) && (!((String)localObject4).endsWith("OrBuilderList")))
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(((String)localObject4).substring(0, 1).toLowerCase());
        ((StringBuilder)localObject5).append(((String)localObject4).substring(1, ((String)localObject4).length() - 4));
        localObject5 = ((StringBuilder)localObject5).toString();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("get");
        ((StringBuilder)localObject6).append((String)localObject4);
        localObject6 = (Method)((Map)localObject1).get(((StringBuilder)localObject6).toString());
        if (localObject6 != null)
        {
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase((String)localObject5), GeneratedMessageLite.invokeOrDie((Method)localObject6, paramMessageLite, new Object[0]));
          continue;
        }
      }
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("set");
      ((StringBuilder)localObject5).append((String)localObject4);
      if ((Method)((Map)localObject2).get(((StringBuilder)localObject5).toString()) != null) {
        if (((String)localObject4).endsWith("Bytes"))
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("get");
          ((StringBuilder)localObject5).append(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((Map)localObject1).containsKey(((StringBuilder)localObject5).toString())) {}
        }
        else
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((String)localObject4).substring(0, 1).toLowerCase());
          ((StringBuilder)localObject5).append(((String)localObject4).substring(1));
          localObject5 = ((StringBuilder)localObject5).toString();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("get");
          ((StringBuilder)localObject6).append((String)localObject4);
          localObject6 = (Method)((Map)localObject1).get(((StringBuilder)localObject6).toString());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("has");
          localStringBuilder.append((String)localObject4);
          localObject4 = (Method)((Map)localObject1).get(localStringBuilder.toString());
          if (localObject6 != null)
          {
            localObject6 = GeneratedMessageLite.invokeOrDie((Method)localObject6, paramMessageLite, new Object[0]);
            if (localObject4 == null)
            {
              if (isDefaultValue(localObject6)) {
                bool1 = false;
              }
            }
            else {
              bool1 = ((Boolean)GeneratedMessageLite.invokeOrDie((Method)localObject4, paramMessageLite, new Object[0])).booleanValue();
            }
            if (bool1) {
              printField(paramStringBuilder, paramInt, camelCaseToSnakeCase((String)localObject5), localObject6);
            }
          }
        }
      }
    }
    if ((paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage))
    {
      localObject1 = ((GeneratedMessageLite.ExtendableMessage)paramMessageLite).extensions.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(((GeneratedMessageLite.ExtensionDescriptor)((Map.Entry)localObject2).getKey()).getNumber());
        ((StringBuilder)localObject3).append("]");
        printField(paramStringBuilder, paramInt, ((StringBuilder)localObject3).toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    paramMessageLite = ((GeneratedMessageLite)paramMessageLite).unknownFields;
    if (paramMessageLite != null) {
      paramMessageLite.printWithIndent(paramStringBuilder, paramInt);
    }
  }
  
  static String toString(MessageLite paramMessageLite, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    reflectivePrintWithIndent(paramMessageLite, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.MessageLiteToString
 * JD-Core Version:    0.7.0.1
 */