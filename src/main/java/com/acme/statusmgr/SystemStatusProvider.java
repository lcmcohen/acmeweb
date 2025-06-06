package com.acme.statusmgr;

public interface SystemStatusProvider {
    int getAvailableProcessors();
    long getFreeJVMMemory();
    long getTotalJVMMemory();
    String getJreVersion();
    String getTempLocation();

}
