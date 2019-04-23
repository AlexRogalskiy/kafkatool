package com.kafkatool.external.impl;

import com.kafkatool.external.ICustomMessageDecorator;

import java.util.Map;
import java.util.zip.CRC32;

public class ChecksumMessageDecorator implements ICustomMessageDecorator {

    private CRC32 crc32;

    public ChecksumMessageDecorator() {
        this.crc32 = new CRC32();
    }

    public String getDisplayName() {
        return "Checksum";
    }

    public String decorate(final String zookeeperHost, final String brokerHost, final String topic, final long partitionId, final long offset, final byte[] msg, final Map<String, String> reserved) {
        try {
            this.crc32.reset();
            this.crc32.update(msg);
            return String.format("Checksum: {%s}", this.crc32.getValue());
        } catch (Throwable t) {
            return String.format("Error: {%s}", t.getMessage());
        }
    }
}
