package com.acme.statusmgr;

import com.acme.statusmgr.beans.IServerStatusFacade;

/**
 * Mock implementation for testing.
 * Returns hardcoded strings as defined in the assignment table.
 */
public class MockServerStatusFacade implements IServerStatusFacade {
    @Override
    public String getAvailableProcessors() { return "4"; }

    @Override
    public String getFreeJVMMemory() { return "127268272"; }

    @Override
    public String getTotalJVMMemory() { return "159383552"; }

    @Override
    public String getJreVersion() { return "15.0.2+7-27"; }

    @Override
    public String getTempLocation() { return "M:\\\\AppData\\\\Local\\\\Temp"; }

    @Override
    public String getServerStatus() { return "up"; }
}
