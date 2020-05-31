package com.ganymede.control;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataCollectController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "collectAppData", method = RequestMethod.POST)
    public String collectAppData(@RequestBody String data) {
        System.out.println("测试效果 : " + data);

        JSONObject jsonObject = JSONObject.parseObject(data);
        String logType = jsonObject.getString("logType");

        String topicName = "realtime";

        if (logType.startsWith("APP")) { //appinfo
            topicName = "appinfo";
        } else if (logType.startsWith("WECHAT")) { //wechatinfo
            topicName = "wechatinfo";
        } else if (logType.startsWith("PC")) { // pcinfo
            topicName = "pcinfo";
        }

        kafkaTemplate.send(topicName, data);
        return "success";
    }
}
