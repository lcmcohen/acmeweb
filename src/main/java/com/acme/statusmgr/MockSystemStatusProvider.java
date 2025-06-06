package com.acme.statusmgr;

public class MockSystemStatusProvider implements SystemStatusProvider {
    @Override
    public int getAvailableProcessors() {
        return 4;
    }

    @Override
    public long getFreeJVMMemory() {
        return 127268272L;
    }

    @Override
    public long getTotalJVMMemory() {
        return 159383552L;
    }

    @Override
    public String getJreVersion() {
        return "15.0.2+7-27";
    }

    @Override
    public String getTempLocation() {
        return "M:\\\\AppData\\\\Local\\\\Temp";
    }
}
