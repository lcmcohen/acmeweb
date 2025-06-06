package com.acme.statusmgr.details;


import com.acme.statusmgr.StatusDetail;

public class BaseServerStatus implements StatusDetail {

    @Override
    public String getStatusDesc() {
        return "Server is up";
    }

    @Override
    public int getRequestCost() {
        return 0;
    }
}
