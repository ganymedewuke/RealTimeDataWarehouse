package com.ganymede.analy;

import com.ganymede.analy.grouppurchase.GroupPurchaseMap;
import com.ganymede.analy.grouppurchase.GroupPurchaseReduce;
import com.ganymede.analy.grouppurchase.GroupPurchaseSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * 统计
 * 次数，团购人数最多的一次团购名称
 */
public class GroupPurchaseAnaly {
    private static final String sourceTopic = "orderinfo";

    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "bigdata1:9092,bigdata2:9092,bigdata3:9092");
        properties.setProperty("group.id", sourceTopic + "-gid");

        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<>(sourceTopic, new SimpleStringSchema(), properties);

        //指定消费偏移量
        myConsumer.setStartFromLatest();

        DataStream<String> stream = env.addSource(myConsumer);
        env.enableCheckpointing(5000);

        final DataStream<GroupPurchaseEntity> map = stream.flatMap(new GroupPurchaseMap());
        DataStream<GroupPurchaseEntity> reduce = map.keyBy("userId").timeWindowAll(Time.seconds(1)).reduce(new GroupPurchaseReduce());
        reduce.addSink(new GroupPurchaseSink());

        env.execute("GroupPurchaseAnaly");

    }

}
