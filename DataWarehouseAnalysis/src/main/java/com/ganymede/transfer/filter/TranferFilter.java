package com.ganymede.transfer.filter;

import com.ganymede.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FilterFunction;

public class TranferFilter implements FilterFunction<String> {

    @Override
    public boolean filter(String value) {
        boolean isFilter = false;
        String[] resultArray = value.split(Constants.SPLIT_STRING);

        if (resultArray != null && resultArray.length > 1) {
            String data = resultArray[1];
            if (!StringUtils.isBlank(data)) {
                isFilter = true;
            }
        }
        return isFilter;
    }

}
