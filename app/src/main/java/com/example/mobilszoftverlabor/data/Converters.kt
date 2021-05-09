package com.example.mobilszoftverlabor.data

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun bigDecimalToLong(value: BigDecimal?): Long? {
        if (value != null) {
            return value.toLong()
        }
        return 0;
    }

    @TypeConverter
    fun longToBigDecimal(value: Long?): BigDecimal {
        if (value != null) {
            return value.toBigDecimal()
        }
        return BigDecimal(0);
    }
}