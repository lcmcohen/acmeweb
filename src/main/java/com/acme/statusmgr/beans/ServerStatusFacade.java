package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class ServerStatusFacade implements IServerStatusFacade {

    @Override
    public String getAvailableProcessors() {
        return Integer.toString(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public String getFreeJVMMemory() {
        return Long.toString(Runtime.getRuntime().freeMemory());
    }

    @Override
    public String getTotalJVMMemory() {
        return Long.toString(Runtime.getRuntime().totalMemory());
    }

    @Override
    public String getJreVersion() {
        return Runtime.version().toString();
    }

    @Override
    public String getTempLocation() {
        return System.getenv("TEMP");
    }

    @Override
    public String getServerStatus() {
        return ServerManager.getCurrentServerStatus();
    }
}
