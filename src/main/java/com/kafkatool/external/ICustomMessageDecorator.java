package com.kafkatool.external;

import java.util.Map;

public interface ICustomMessageDecorator {

    String getDisplayName();

    String decorate(final String zookeeperHost, final String brokerHost, final String topic, final long partitionId, final long offset, final byte[] msg, final Map<String, String> reserved);
}
