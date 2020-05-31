package com.ganymede.transfer.map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ganymede.utils.TransferUtil;
import org.apache.flink.api.common.functions.MapFunction;

public class TransferMap implements MapFunction<String, String> {

    private String targetTopic;

    public TransferMap(String targetTopic) {
        this.targetTopic = targetTopic;
    }

    @Override
    public String map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject data = jsonArray.getJSONObject(0);
        String type = jsonObject.getString("type");
        String table = jsonObject.getString("table");

        String result = "";

        if (("INSERT".equalsIgnoreCase(type) || "UPDATE".equalsIgnoreCase(type)) && table.equals(targetTopic)) {
            result = TransferUtil.transferData(table, data);

            if ("orderinfo".equals(targetTopic)) {
                /**
                 * GroupPurchaseInfo
                 * create 'GroupPurchaseInfo',{NAME=>'info',COMPRESSION=>'snappy',VERSIONS=>"3"}
                 */
            }

        }

        return result;
    }
}
