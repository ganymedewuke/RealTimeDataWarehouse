package com.ganymede.analy.grouppurchase;

import com.ganymede.analy.GroupPurchaseEntity;
import com.ganymede.business.OrderInfo;
import com.ganymede.constant.Constants;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class GroupPurchaseMap implements FlatMapFunction<String, GroupPurchaseEntity> {

    @Override
    public void flatMap(String value, Collector<GroupPurchaseEntity> out) throws Exception {
        OrderInfo orderInfo = new OrderInfo();
        String[] splitArrays = value.split(Constants.SPLIT_STRING);

        orderInfo.setId(splitArrays[0].equals("null") ?  -1 : Integer.valueOf(splitArrays[0]));
        orderInfo.setUserId(splitArrays[1].equals("null") ?  -1 : Integer.valueOf(splitArrays[1]));
        orderInfo.setProductid(splitArrays[2].equals("null") ?  -1 : Integer.valueOf(splitArrays[2]));
        orderInfo.setShopId(splitArrays[3].equals("null") ?  -1 : Integer.valueOf(splitArrays[3]));
        orderInfo.setMerchantId(splitArrays[4].equals("null") ?  -1 : Integer.valueOf(splitArrays[4]));
        orderInfo.setOrderAmount(splitArrays[5].equals("null") ? -1 : Double.valueOf(splitArrays[5]));
        orderInfo.setPayType(splitArrays[6].equals("null") ?  -1 : Integer.valueOf(splitArrays[6]));
        orderInfo.setPayAmount(splitArrays[7].equals("null") ? -1 : Double.valueOf(splitArrays[7]));
        orderInfo.setCreateTime(splitArrays[8].equals("null") ? "" : splitArrays[8]);

        orderInfo.setPayTime(splitArrays[9].equals("null") ? "" : splitArrays[9]);
        orderInfo.setStatus(splitArrays[10].equals("null") ?  -1 : Integer.valueOf(splitArrays[10]));
        orderInfo.setNumber(splitArrays[11].equals("null") ?  -1 : Integer.valueOf(splitArrays[11]));
        orderInfo.setRedEnvId(splitArrays[12].equals("null") ?  -1 : Integer.valueOf(splitArrays[12]));
        orderInfo.setRedEnvAmount(splitArrays[13].equals("null") ?  -1 : Double.valueOf(splitArrays[13]));
        orderInfo.setConpusId(splitArrays[14].equals("null") ?  -1 : Integer.valueOf(splitArrays[14]));
        orderInfo.setConpusAmount(splitArrays[15].equals("null") ?  -1 : Double.valueOf(splitArrays[15]));

        orderInfo.setActivityId(splitArrays[16].equals("null") ?  -1 : Integer.valueOf(splitArrays[16]));
        orderInfo.setSeckillId(splitArrays[17].equals("null") ?  -1 : Integer.valueOf(splitArrays[17]));
        orderInfo.setGroupPurId(splitArrays[18].equals("null") ? -1 : Integer.valueOf(splitArrays[18]));

        GroupPurchaseEntity groupPurchaseEntity = new GroupPurchaseEntity();

        groupPurchaseEntity.setUserId(orderInfo.getUserId() + "");

        if(orderInfo.getGroupPurId() >0){
            groupPurchaseEntity.setTimes(1l);
        }


        out.collect(groupPurchaseEntity);
    }
}
