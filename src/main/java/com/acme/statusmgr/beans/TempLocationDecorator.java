package com.acme.statusmgr.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempLocationDecorator extends ServerStatusDecorator {
    private final Logger logger = LoggerFactory.getLogger(TempLocationDecorator.class);

    public TempLocationDecorator(BaseServerStatus baseStatus) {
        super(baseStatus);
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and the server's temp file location is " +
                getFacade().getTempLocation();
    }

    @Override
    public Integer getRequestCost() {
        return baseStatus.getRequestCost() + 29;
    }
}