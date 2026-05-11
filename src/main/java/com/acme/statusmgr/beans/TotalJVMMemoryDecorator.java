package com.acme.statusmgr.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotalJVMMemoryDecorator extends ServerStatusDecorator {
    private final Logger logger = LoggerFactory.getLogger(TotalJVMMemoryDecorator.class);

    public TotalJVMMemoryDecorator(BaseServerStatus baseStatus) {
        super(baseStatus);
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and there is a total of " +
                getFacade().getTotalJVMMemory() + " bytes of JVM memory";
    }

    @Override
    public Integer getRequestCost() {
        return baseStatus.getRequestCost() + 13;
    }
}