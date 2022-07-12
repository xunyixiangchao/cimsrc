package com.farsunset.hoxin.account.service;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.util.Objects;

public class HoxinAccountService
        extends Service {
    private a a;

    public IBinder onBind(Intent paramIntent) {
        if (Objects.equals(paramIntent.getAction(), "android.accounts.AccountAuthenticator")) {
            return this.a.getIBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.a = new a(this);
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        return 1;
    }

    static class a
            extends AbstractAccountAuthenticator {
        a(Context paramContext) {
            super();
        }

        public Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle) {
            return null;
        }

        public Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle) {
            return null;
        }

        public Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString) {
            return null;
        }

        public Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle) {
            return null;
        }

        public String getAuthTokenLabel(String paramString) {
            return null;
        }

        public Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString) {
            return null;
        }

        public Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle) {
            return null;
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.service.HoxinAccountService

 * JD-Core Version:    0.7.0.1

 */