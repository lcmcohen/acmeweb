package com.acme.statusmgr.details;

import com.acme.statusmgr.RealSystemStatusProvider;
import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class AvailableProcessorsDetail implements StatusDetail {
    private final boolean isRepeated;
    private final StatusDetail inner;
    private static SystemStatusProvider provider = new RealSystemStatusProvider();

    public AvailableProcessorsDetail(StatusDetail inner, boolean isRepeated) {
        this.inner = inner;
        this.isRepeated = isRepeated;
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
        return inner.getRequestCost() + (isRepeated ? 2 : 3);
    }
}

