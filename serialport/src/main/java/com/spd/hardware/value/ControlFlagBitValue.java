package com.spd.hardware.value;

import android.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Reginer  2023/3/30 0030 13:53.
 * 联系方式:QQ:282921012
 * 功能描述:流控列表
 */
public class ControlFlagBitValue {
    /**
     * 不使用流控
     */
    public static final int NONE = 0;

    /**
     * 硬件流控
     */
    public static final int HARDWARE = 1;

    /**
     * 软件流控
     */
    public static final int SOFTWARE = 2;

    @IntDef(value = {NONE, HARDWARE, SOFTWARE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlFlagBit {
    }
}
