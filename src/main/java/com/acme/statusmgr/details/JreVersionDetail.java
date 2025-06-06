package com.acme.statusmgr.details;

import com.acme.statusmgr.RealSystemStatusProvider;
import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class JreVersionDetail implements StatusDetail {
    private final boolean isRepeated;
    private final StatusDetail inner;
    private static SystemStatusProvider provider = new RealSystemStatusProvider();

    public JreVersionDetail(StatusDetail inner, boolean isRepeated) {
        this.inner = inner;
        this.isRepeated = isRepeated;
    }

    public static void setProvider(SystemStatusProvider p) {
        provider = p;
    }

    @Override
    public String getStatusDesc() {

        String version = provider.getJreVersion();
        return inner.getStatusDesc() + ", and the JRE version is " + version;
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + (isRepeated ? 10 : 20);
    }
}
