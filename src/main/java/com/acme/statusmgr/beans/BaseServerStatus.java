package com.acme.statusmgr.beans;

public abstract class BaseServerStatus {
    public abstract String getStatusDesc();

    public abstract Integer getRequestCost();

    public abstract long getId();
    public abstract String getContentHeader();
}
