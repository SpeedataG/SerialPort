package com.spd.hardware.value;

import android.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Reginer  2023/3/30 0030 13:44.
 * 联系方式:QQ:282921012
 * 功能描述:校验位列表
 */
public class CrcBitValue {
    /**
     * 无奇偶校验
     */
    public static final int NONE = 0;
    /**
     * 奇校验
     */
    public static final int ODD = 1;
    /**
     * 偶校验
     */
    public static final int EVEN = 2;

    @IntDef(value = {NONE, ODD, EVEN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CrcBit {
    }
}
