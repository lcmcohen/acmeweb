package com.acme.statusmgr.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FreeJVMMemoryDecorator extends ServerStatusDecorator {
    private final Logger logger = LoggerFactory.getLogger(FreeJVMMemoryDecorator.class);

    public FreeJVMMemoryDecorator(BaseServerStatus baseStatus) {
        super(baseStatus);
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and there are " +
                getFacade().getFreeJVMMemory() + " bytes of JVM memory free";
    }

    @Override
    public Integer getRequestCost() {
        return baseStatus.getRequestCost() + 7;
    }
}