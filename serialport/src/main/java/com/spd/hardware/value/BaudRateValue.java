package com.spd.hardware.value;

import android.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Reginer  2023/3/30 0030 13:23.
 * 联系方式:QQ:282921012
 * 功能描述:波特率列表
 */
public class BaudRateValue {
    public static final int B0 = 0;

    public static final int B50 = 50;

    public static final int B75 = 75;

    public static final int B110 = 110;

    public static final int B134 = 134;

    public static final int B150 = 150;

    public static final int B200 = 200;

    public static final int B300 = 300;

    public static final int B600 = 600;

    public static final int B1200 = 1200;

    public static final int B1800 = 1800;

    public static final int B2400 = 2400;

    public static final int B4800 = 4800;

    public static final int B9600 = 9600;

    public static final int B19200 = 19200;

    public static final int B38400 = 38400;

    public static final int B57600 = 57600;

    public static final int B115200 = 115200;

    public static final int B230400 = 230400;

    public static final int B460800 = 460800;

    public static final int B500000 = 500000;

    public static final int B576000 = 576000;

    public static final int B921600 = 921600;

    public static final int B1000000 = 1000000;

    public static final int B1152000 = 1152000;

    public static final int B1500000 = 1500000;

    public static final int B2000000 = 2000000;

    public static final int B2500000 = 2500000;

    public static final int B3000000 = 3000000;

    public static final int B3500000 = 3500000;

    public static final int B4000000 = 4000000;

    @IntDef(value = {
            B0, B50, B75, B110, B134, B150, B200, B300, B600, B1200, B1800, B2400,
            B4800, B9600, B19200, B38400, B57600, B115200, B230400, B460800, B500000,
            B576000, B921600, B1000000, B1152000, B1500000, B2000000, B2500000,
            B3000000, B3500000, B4000000
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface BaudRate {
    }
}
