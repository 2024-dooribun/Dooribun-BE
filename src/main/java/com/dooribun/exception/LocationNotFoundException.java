package com.dooribun.exception;

import lombok.Getter;

import java.security.Principal;

@Getter
public class LocationNotFoundException extends RuntimeException{
    private final Object locationId;
    private Principal principal;

    public LocationNotFoundException(Object locationId) {
        this.locationId = locationId;
    }

    public LocationNotFoundException(Object locationId, Principal principal) {
        this.locationId = locationId;
        this.principal = principal;
    }
}
