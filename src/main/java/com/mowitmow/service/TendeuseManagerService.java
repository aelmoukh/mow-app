package com.mowitmow.service;

import org.apache.commons.lang3.StringUtils;

import com.mowitmow.model.tendeuse.TendeusePosition;

public class TendeuseManagerService {
    public TendeusePosition piloterTendeuse(String instructions) {
        if (!StringUtils.isEmpty(instructions)) {
            String lines[] = instructions.split("\\r?\\n");
        }
        return null;
    }
}
