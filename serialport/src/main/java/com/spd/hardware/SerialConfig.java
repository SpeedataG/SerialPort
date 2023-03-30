package com.spd.hardware;

/**
 * @author :Reginer  2023/3/30 0030 10:54.
 * 联系方式:QQ:282921012
 * 功能描述:串口初始化参数
 */
public class SerialConfig {

    private String device;
    private int speed = 115200;
    private int dBit = 8;
    private int sBit = 2;
    private int crc = 0;
    private int flag = 0;
    private int controlFlag = 0;
    private boolean readSync = false;

    public String getDevice() {
        return device;
    }

    /**
     * 串口设备的绝对路径
     *
     * @param device 绝对路径
     * @return {@link  SerialConfig}
     */
    public SerialConfig setDevice(String device) {
        this.device = device;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * 设置波特率
     *
     * @param speed 波特率
     * @return {@link  SerialConfig}
     */
    public SerialConfig setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public int getDataBit() {
        return dBit;
    }

    /**
     * 设置数据位
     *
     * @param dBit 数据位
     * @return {@link  SerialConfig}
     */
    public SerialConfig setDataBit(int dBit) {
        this.dBit = dBit;
        return this;
    }

    public int getStopBit() {
        return sBit;
    }

    /**
     * 设置停止位
     *
     * @param sBit 停止位
     * @return {@link  SerialConfig}
     */
    public SerialConfig setStopBit(int sBit) {
        this.sBit = sBit;
        return this;
    }

    public int getCrc() {
        return crc;
    }

    /**
     * 设置校验位
     *
     * @param crc 校验位
     * @return {@link  SerialConfig}
     */
    public SerialConfig setCrc(int crc) {
        this.crc = crc;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    /**
     * 设置打开方式
     *
     * @param flag 打开方式
     * @return {@link  SerialConfig}
     */
    public SerialConfig setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public int getControlFlag() {
        return controlFlag;
    }

    /**
     * 设置流控
     *
     * @param controlFlag 流控
     * @return {@link  SerialConfig}
     */
    public SerialConfig setControlFlag(int controlFlag) {
        this.controlFlag = controlFlag;
        return this;
    }

    public boolean isReadSync() {
        return readSync;
    }

    /**
     * 设置是否需要同步返回
     *
     * @param readSync 是否手动读取数据
     * @return {@link  SerialConfig}
     */
    public SerialConfig setReadSync(boolean readSync) {
        this.readSync = readSync;
        return this;
    }

}
