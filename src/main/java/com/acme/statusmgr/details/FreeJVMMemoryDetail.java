package com.acme.statusmgr.details;

import com.acme.statusmgr.RealSystemStatusProvider;
import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class FreeJVMMemoryDetail implements StatusDetail {

    private final StatusDetail inner;
    private static SystemStatusProvider provider = new RealSystemStatusProvider();
    private final boolean isRepeated;
    public FreeJVMMemoryDetail(StatusDetail inner, boolean isRepeated) {
        this.inner = inner;
        this.isRepeated = isRepeated;
    }

    public static void setProvider(SystemStatusProvider p) {
        provider = p;
    }

    @Override
    public String getStatusDesc() {

        long mem = provider.getFreeJVMMemory();
        return inner.getStatusDesc() + ", and there are " + mem + " bytes of JVM memory free";
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + 7;
    }
}
