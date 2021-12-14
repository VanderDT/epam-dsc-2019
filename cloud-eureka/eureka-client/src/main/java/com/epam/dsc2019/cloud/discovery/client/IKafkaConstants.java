package com.epam.dsc2019.cloud.discovery.client;

public interface IKafkaConstants {
    public static String KAFKA_BROKERS = "5.141.84.146:9092";

    public static Integer MESSAGE_COUNT=100;

    public static String CLIENT_ID="client1";

    public static String TOPIC_NAME="jmtopic2";

    public static String GROUP_ID_CONFIG="consumerGroup10";

    public static Integer MAX_NO_MESSAGE_FOUND_COUNT=100;

    public static String OFFSET_RESET_LATEST="latest";

    public static String OFFSET_RESET_EARLIER="earliest";

    public static Integer MAX_POLL_RECORDS=1;
}
