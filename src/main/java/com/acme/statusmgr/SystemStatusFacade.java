package com.acme.statusmgr;

import com.acme.servermgr.ServerManager;

    public class SystemStatusFacade implements SystemStatusProvider  {

            @Override
            public int getAvailableProcessors() {
                return Runtime.getRuntime().availableProcessors();
            }

            @Override
            public long getFreeJVMMemory() {
                return Runtime.getRuntime().freeMemory();
            }

            @Override
            public long getTotalJVMMemory() {
                return Runtime.getRuntime().totalMemory();
            }

            @Override
            public String getJreVersion() {
                return System.getProperty("java.version");
            }

            @Override
            public String getTempLocation() {
                return System.getenv("TEMP");
            }
        };



