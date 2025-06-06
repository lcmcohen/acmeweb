package com.acme.statusmgr.details;

import com.acme.statusmgr.StatusDetail;

public class AvailableProcessorsDetail implements StatusDetail {

    private final StatusDetail inner;

    public AvailableProcessorsDetail(StatusDetail inner) {
        this.inner = inner;
    }

    @Override
    public String getStatusDesc() {
        int cores = Runtime.getRuntime().availableProcessors();
        return inner.getStatusDesc() + ", and there are " + cores + " processors available";
    }

    @Override
    public int getRequestCost() {
        return inner.getRequestCost() + 3;
    }
}

