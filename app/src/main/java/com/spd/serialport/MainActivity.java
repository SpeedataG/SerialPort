package com.spd.serialport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.spd.hardware.ISerialPortListener;
import com.spd.hardware.SerialConfig;
import com.spd.hardware.SerialManager;
import com.spd.hardware.value.BaudRateValue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ISerialPortListener {
    private final SerialManager serialManager = new SerialManager();

    private final GpioPowerManager gpioPowerManager = new GpioPowerManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serialPortFunc();
    }


    /**
     * 异步方式读取串口数据
     * onDataReceived会被回调
     */
    private void serialPortFunc() {

        SerialConfig serialConfig = new SerialConfig();
        serialConfig.setDevice("dev/ttyS0")
                .setSpeed(BaudRateValue.B115200).setMaxTimeInterval(3)
//                .setDataBit(DataBitValue.CS8)
//                .setStopBit(StopBitValue.B2)
//                .setCrc(CrcBitValue.NONE)
//                .setMaxLength(4096)

        ;
        gpioPowerManager.setGpioPath("/sys/devices/platform/pinctrl/mt_gpio");
        gpioPowerManager.setGpioList(new ArrayList<Integer>() {
            {
                add(2);
                add(115);
            }
        });
        gpioPowerManager.powerOn();
        serialManager.open(serialConfig, this);
    }

    /**
     * 同步方式读取串口数据
     * onDataReceived不会被回调
     */
    @SuppressWarnings("unused")
    private void serialPortFuncSync() {
        SerialManager serialManager = new SerialManager();
        SerialConfig serialConfig = new SerialConfig();
        serialConfig.setDevice("dev/ttyS0").setReadSync(true).setSpeed(BaudRateValue.B9600);
        serialManager.open(serialConfig, this);
        //如果需要，可以先清除缓冲区
        serialManager.clearSerialBuffer();

        serialManager.sendHex("010101");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] serialBytes = serialManager.readSerialSync();

    }

    @Override
    public void onOpenSuccess(File device) {
        Log.i("SpdSerial", "onOpenSuccess "+device.getAbsolutePath());
    }

    @Override
    public void onOpenFailed(Exception e) {
        Log.i("SpdSerial", "onOpenFailed "+Log.getStackTraceString(e));
    }

    @Override
    public void onDataReceived(byte[] bytes) {
        runOnUiThread(() -> Log.i("SpdSerial", Arrays.toString(bytes)));
    }

    @Override
    public void onDataSend(byte[] bytes) {

    }

    @Override
    protected void onDestroy() {
        serialManager.close();
        gpioPowerManager.powerOff();
        super.onDestroy();
    }
}