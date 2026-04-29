package com.acme.statusmgr.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JreVersionDecorator extends ServerStatusDecorator {
    private final Logger logger = LoggerFactory.getLogger(JreVersionDecorator.class);

    public JreVersionDecorator(BaseServerStatus baseStatus) {
        super(baseStatus);
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and the JRE version is " +
                getFacade().getJreVersion();
    }

    @Override
    public Integer getRequestCost() {
        return baseStatus.getRequestCost() + 19;
    }
}