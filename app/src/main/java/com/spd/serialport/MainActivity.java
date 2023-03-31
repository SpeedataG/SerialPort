package com.spd.serialport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.spd.hardware.ISerialPortListener;
import com.spd.hardware.SerialConfig;
import com.spd.hardware.SerialManager;
import com.spd.hardware.value.BaudRateValue;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ISerialPortListener {

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
    @SuppressWarnings("unused")
    private void serialPortFunc() {
        SerialManager serialManager = new SerialManager();
        SerialConfig serialConfig = new SerialConfig();
        serialConfig.setDevice("dev/ttyS0").setSpeed(BaudRateValue.B115200);
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

    }

    @Override
    public void onOpenFailed(Exception e) {

    }

    @Override
    public void onDataReceived(byte[] bytes) {
        runOnUiThread(() -> Log.i("SpdSerial",Arrays.toString(bytes)));
    }

    @Override
    public void onDataSend(byte[] bytes) {

    }
}