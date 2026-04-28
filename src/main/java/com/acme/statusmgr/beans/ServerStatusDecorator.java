package com.acme.statusmgr.beans;

public abstract class ServerStatusDecorator extends BaseServerStatus {
    protected BaseServerStatus baseStatus;

    private static IServerStatusFacade facade = new ServerStatusFacade();

    public static void setFacade(IServerStatusFacade newFacade) {
        facade = newFacade;
    }

    public static IServerStatusFacade getFacade() {
        return facade;
    }

    public ServerStatusDecorator(BaseServerStatus baseStatus) {
        this.baseStatus = baseStatus;
    }

    @Override
    public long getId() {
        return baseStatus.getId();
    }

    @Override
    public String getContentHeader() {
        return baseStatus.getContentHeader();
    }

    @Override
    public abstract String getStatusDesc();

    @Override
    public abstract Integer getRequestCost();
}
