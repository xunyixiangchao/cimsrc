package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class n
  extends l<InputStream>
{
  private static final UriMatcher d;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    d = localUriMatcher;
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
    localUriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
    localUriMatcher.addURI("com.android.contacts", "contacts/#", 3);
    localUriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    localUriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
  }
  
  public n(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  private InputStream i(Uri paramUri, ContentResolver paramContentResolver)
  {
    int i = d.match(paramUri);
    if (i != 1) {
      if (i != 3)
      {
        if (i != 5) {
          return paramContentResolver.openInputStream(paramUri);
        }
      }
      else {
        return j(paramContentResolver, paramUri);
      }
    }
    paramUri = ContactsContract.Contacts.lookupContact(paramContentResolver, paramUri);
    if (paramUri != null) {
      return j(paramContentResolver, paramUri);
    }
    throw new FileNotFoundException("Contact cannot be found");
  }
  
  private InputStream j(ContentResolver paramContentResolver, Uri paramUri)
  {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void g(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  protected InputStream h(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = i(paramUri, paramContentResolver);
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("InputStream is null for ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.n
 * JD-Core Version:    0.7.0.1
 */