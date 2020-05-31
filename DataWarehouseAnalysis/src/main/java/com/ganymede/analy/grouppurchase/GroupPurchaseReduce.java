package com.ganymede.analy.grouppurchase;

import com.ganymede.analy.GroupPurchaseEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class GroupPurchaseReduce implements ReduceFunction<GroupPurchaseEntity> {
    @Override
    public GroupPurchaseEntity reduce(GroupPurchaseEntity value1, GroupPurchaseEntity value2) throws Exception {
        String userId = value1.getUserId();
        long times1 = value1.getTimes();
        long times2 = value2.getTimes();

        GroupPurchaseEntity groupPurchaseEntity = new GroupPurchaseEntity();
        groupPurchaseEntity.setUserId(userId);
        groupPurchaseEntity.setTimes(times1 + times2);
        return groupPurchaseEntity;
    }
}
