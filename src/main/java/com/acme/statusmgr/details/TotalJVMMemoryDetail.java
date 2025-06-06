package com.acme.statusmgr.details;

import com.acme.statusmgr.RealSystemStatusProvider;
import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class TotalJVMMemoryDetail implements StatusDetail {
    private final boolean isRepeated;
    private final StatusDetail inner;
    private static SystemStatusProvider provider = new RealSystemStatusProvider();

    public TotalJVMMemoryDetail(StatusDetail inner, boolean isRepeated) {
        this.inner = inner;
        this.isRepeated = isRepeated;
    }

    public static void setProvider(SystemStatusProvider p) {
        provider = p;
    }

    @Override
    public String getStatusDesc() {

        long total = provider.getTotalJVMMemory();
        return inner.getStatusDesc() + ", and there is a total of " + total + " bytes of JVM memory";
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + (isRepeated ? 12 : 13);
    }
}
