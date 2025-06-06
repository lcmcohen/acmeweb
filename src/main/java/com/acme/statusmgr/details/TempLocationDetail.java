package com.acme.statusmgr.details;

import com.acme.statusmgr.RealSystemStatusProvider;
import com.acme.statusmgr.StatusDetail;
import com.acme.statusmgr.SystemStatusProvider;

public class TempLocationDetail implements StatusDetail {
    private final boolean isRepeated;
    private final StatusDetail inner;
    private static SystemStatusProvider provider = new RealSystemStatusProvider();

    public TempLocationDetail(StatusDetail inner, boolean isRepeated) {
        this.inner = inner;
        this.isRepeated = isRepeated;
    }

    public static void setProvider(SystemStatusProvider p) {
        provider = p;
    }

    @Override
    public String getStatusDesc() {

        String location = provider.getTempLocation();
        return inner.getStatusDesc() + ", and the server's temp file location is " + location;
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + (isRepeated ? 28 : 29);
    }
}
