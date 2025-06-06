package com.acme.statusmgr.details;

import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class AvailableProcessorsDetail implements StatusDetail {

    private final StatusDetail inner;
    private static SystemStatusProvider provider;

    public AvailableProcessorsDetail(StatusDetail inner) {
        this.inner = inner;
    }
    public static void setProvider(SystemStatusProvider p) {
        provider = p;
    }
    @Override
    public String getStatusDesc() {
        int cores = provider.getAvailableProcessors();;
        return inner.getStatusDesc() + ", and there are " + cores + " processors available";
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + 3;
    }
}

