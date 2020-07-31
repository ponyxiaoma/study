package com.mjq.common.web.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-30 17:54
 */
public class BigDecimalJsonSerialize extends JsonSerializer<BigDecimal> {

    private DecimalFormat df = new DecimalFormat("#0.00");


    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException {
        jgen.writeString(df.format(value.setScale(2,BigDecimal.ROUND_HALF_UP)));
    }
}
