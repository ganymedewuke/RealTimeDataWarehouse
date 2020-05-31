package com.ganymede.analy.grouppurchase;

import com.ganymede.analy.GroupPurchaseEntity;
import com.ganymede.utils.HbaseUtil;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create 'user_theme',{NAME=>'info',COMPRESSION=>'snappy',VERSIONS=>"3"}
 */
public class GroupPurchaseSink implements SinkFunction<GroupPurchaseEntity> {
    @Override
    public void invoke(GroupPurchaseEntity value, Context context) throws Exception {
        String tableName = "user_theme";
        String columnFamily = "info";

        String userId = value.getUserId();
        long times = value.getTimes();

        String timesVal = HbaseUtil.getdata(tableName, userId, columnFamily, "times");
        timesVal = timesVal == null ? "0" : timesVal;

        long preTiems = Long.valueOf(timesVal);
        times += preTiems;

        HbaseUtil.putdata(tableName, userId, columnFamily, "times", times + "");

    }
}
