package com.spd.hardware.value;

import android.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Reginer  2023/3/30 0030 13:35.
 * 联系方式:QQ:282921012
 * 功能描述:数据位列表
 */
public class DataBitValue {
    /**
     * 5位数据位
     */
    public static final int CS5 = 5;
    /**
     * 6位数据位
     */
    public static final int CS6 = 6;
    /**
     * 7位数据位
     */
    public static final int CS7 = 7;
    /**
     * 8位数据位
     */
    public static final int CS8 = 8;

    @IntDef(value = {CS5, CS6, CS7, CS8})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataBit {
    }
}
