package com.acme.statusmgr.beans;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Service that provides cache-optimized status object construction
 */
@Service
public class ServerStatusCachable extends ServerStatus{

    /**
     * Get a server status object, either via a constructor or from cache
     * @param id this must stay constant between calls in order to leverage cache
     * @param contentHeader its content is the real key value for caching
     * @return new or cached server status object
     */
    @Cacheable("statusCache")
    public ServerStatus getCachedStatus(long id, String contentHeader) {
        // This logic runs ONLY if the result is not in the cache
        return new ServerStatus(id, contentHeader);
    }
}
