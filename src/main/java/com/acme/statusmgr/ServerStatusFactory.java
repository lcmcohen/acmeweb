package com.acme.statusmgr;

import com.acme.statusmgr.details.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServerStatusFactory {

    private static final Set<String> VALID_DETAILS = Set.of(
            "availableProcessors",
            "freeJVMMemory",
            "totalJVMMemory",
            "jreVersion",
            "tempLocation"
    );

    public static StatusDetail buildStatusDetailChain(List<String> requestedDetails) {
        StatusDetail baseStatus = new BaseServerStatus();
        Set<String> seen = new HashSet<>();

        for (String detail : requestedDetails) {
            boolean isRepeated = !seen.add(detail); // returns false if already in the set

            switch (detail) {
                case "availableProcessors":
                    baseStatus = new AvailableProcessorsDetail(baseStatus, isRepeated);
                    break;
                case "freeJVMMemory":
                    baseStatus = new FreeJVMMemoryDetail(baseStatus, isRepeated);
                    break;
                case "totalJVMMemory":
                    baseStatus = new TotalJVMMemoryDetail(baseStatus, isRepeated);
                    break;
                case "jreVersion":
                    baseStatus = new JreVersionDetail(baseStatus, isRepeated);
                    break;
                case "tempLocation":
                    baseStatus = new TempLocationDetail(baseStatus, isRepeated);
                    break;
                default:
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Invalid details option: " + detail
                    );
            }
        }

        return baseStatus;
    }
}