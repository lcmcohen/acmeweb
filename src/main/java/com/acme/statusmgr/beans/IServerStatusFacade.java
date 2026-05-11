package com.acme.statusmgr.beans;

public interface IServerStatusFacade {
    String getAvailableProcessors();
    String getFreeJVMMemory();
    String getTotalJVMMemory();
    String getJreVersion();
    String getTempLocation();
    String getServerStatus();
}
