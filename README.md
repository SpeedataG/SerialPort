# SerialPort

[![](https://jitpack.io/v/SpeedataG/SerialPort.svg)](https://jitpack.io/#SpeedataG/SerialPort)
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    
implementation 'com.github.SpeedataG:SerialPort:Tag'    
```

```
private val mSerialManager = SerialManager()
mSerialManager.open(serialPort, braut, this)

override fun onDataReceived(bytes: ByteArray) {
        
    }
mSerialManager.sendHex("000001")
```
