package com.acme.statusmgr.beans;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AvailableProcessorsDecorator extends ServerStatusDecorator {
    private final Logger logger = LoggerFactory.getLogger(AvailableProcessorsDecorator.class);

    public AvailableProcessorsDecorator(BaseServerStatus baseStatus) {
        super(baseStatus);
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and there are " +
                getFacade().getAvailableProcessors() + " processors available";
    }

    @Override
    public Integer getRequestCost() {
        return baseStatus.getRequestCost() + 3;
    }
}