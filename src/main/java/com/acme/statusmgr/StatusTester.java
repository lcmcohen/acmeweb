package com.acme.statusmgr;

import com.acme.statusmgr.details.AvailableProcessorsDetail;
import com.acme.statusmgr.details.BaseServerStatus;

public class StatusTester {
    public static void main(String[] args) throws InterruptedException {
        StatusDetail status = new AvailableProcessorsDetail(new BaseServerStatus());

        System.out.println(status.getStatusDesc());
        System.out.println("Cost: " + status.getRequestCost());

        Thread.sleep(1000); // wait a second

        System.out.println(status.getStatusDesc()); // should be same format, fresh value
        System.out.println("Cost: " + status.getRequestCost());
    }
}

