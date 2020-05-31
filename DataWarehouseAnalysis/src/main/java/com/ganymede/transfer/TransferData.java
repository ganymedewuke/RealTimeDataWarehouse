package com.ganymede.transfer;

import com.ganymede.transfer.filter.TranferFilter;
import com.ganymede.transfer.map.TransferMap;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import com.ganymede.constant.Constants;

import java.util.Properties;

public class TransferData {

    public static void main(String[] args) throws Exception {
        String targetTopic;
        int flag;

        if (args.length > 0 && !args[0].equals("")) {
            flag = Integer.parseInt(args[0]);
        } else {
            flag = 2;
        }

        targetTopic = getTopicName(flag);

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "bigdata1:9092,bigdata2:9092,bigdata3:9092");
        properties.setProperty("group.id", targetTopic + "-gid");

        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<>(Constants.DB_DATA, new SimpleStringSchema(), properties);

        //指定消费偏移量
        myConsumer.setStartFromLatest();

        DataStream<String> stream = env.addSource(myConsumer);
        env.enableCheckpointing(5000);

        final DataStream<String> map = stream.map(new TransferMap(targetTopic));

        DataStream<String> filter = map.filter(new TranferFilter());

        FlinkKafkaProducer<String> myProducer = new FlinkKafkaProducer<String>("bigdata1:9092,bigdata2:9092,bigdata3:9092", targetTopic, new SimpleStringSchema());
        myProducer.setWriteTimestampToKafka(true);

        filter.addSink(myProducer);
        env.execute(targetTopic + "-TransferData");

    }

    private static String getTopicName(int flag) {
        String topicName;
        switch (flag) {
            case 1:
                topicName = Constants.RED_ENVELOPE_NAME_INFO;
                break;
            case 2:
                topicName = Constants.ORDERINFO;
                break;
            default:
                topicName = Constants.REALTIME;
                break;
        }
        return topicName;
    }

}
