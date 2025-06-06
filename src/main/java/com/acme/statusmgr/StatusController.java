package com.acme.statusmgr;

import com.acme.statusmgr.beans.ServerStatus;
import com.acme.statusmgr.details.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requester
     * @return a ServerStatus object containing the info to be returned to the requestor
     * @apiNote TODO since Spring picks apart the object returned with Reflection and doesn't care what the return-object's type is, we can change the type of object we return if necessary, as long as the object returned contained the required fields and getter methods.
     */
    @RequestMapping("/status")
    public ServerStatus getStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));
    }


    /**
     * Process a request for detailed server status information
     *
     * @param name    optional param identifying the requester
     * @param details optional param with a list of server status details being requested
     * @return a ServerStatus object containing the info to be returned to the requestor
     *      * @apiNote TODO since Spring picks apart the object returned with Reflection and doesn't care what the return-object's type is, we can change the type of object we return if necessary
     */
    @RequestMapping("/status/detailed")
    public ServerStatus getDetailedStatus(
            @RequestParam(value = "name", defaultValue = "Anonymous") String name,
            @RequestParam List<String> details) {

        Logger logger = LoggerFactory.getLogger("StatusController");
        logger.info("Details were provided: " + Arrays.toString(details.toArray()));




        StatusDetail status = new BaseServerStatus();


        Set<String> addedDetails = new HashSet<>();
        for (String detail : details) {
            boolean isRepeated = !addedDetails.add(detail);
            switch (detail) {
                case "availableProcessors":
                    status = new AvailableProcessorsDetail(status, isRepeated);
                    break;
                case "freeJVMMemory":
                    status = new FreeJVMMemoryDetail(status, isRepeated);
                    break;
                case "totalJVMMemory":
                    status = new TotalJVMMemoryDetail(status, isRepeated);
                    break;
                case "jreVersion":
                    status = new JreVersionDetail(status, isRepeated);
                    break;
                case "tempLocation":
                    status = new TempLocationDetail(status, isRepeated);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid details option: " + detail);
            }
        }


        return new ServerStatus(
                counter.incrementAndGet(),
                String.format(template, name),
                status.getStatusDesc(),
                status.getRequestCost()
        );
    }
}
