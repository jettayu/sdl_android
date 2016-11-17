package com.smartdevicelink.transport;

import com.smartdevicelink.transport.enums.TransportType;

import android.content.Context;
import android.hardware.usb.UsbAccessory;

public class USBTransportConfig extends BaseTransportConfig {
	
	private Context mainActivity = null;
	private UsbAccessory usbAccessory = null;
	
	public USBTransportConfig (Context mainActivity) {
		this.mainActivity = mainActivity;
	}
	
	public USBTransportConfig (Context mainActivity, UsbAccessory usbAccessory) {
		this.mainActivity = mainActivity;
		this.usbAccessory = usbAccessory;
	}
	
	public USBTransportConfig (Context mainActivity, boolean shareConnection) {
		this.mainActivity = mainActivity;
		super.shareConnection = shareConnection;
	}
	
	public USBTransportConfig (Context mainActivity, UsbAccessory usbAccessory, boolean shareConnection) {
		this.mainActivity = mainActivity;
		this.usbAccessory = usbAccessory;
		super.shareConnection = shareConnection;
	}
	
	public Context getUSBContext () {
		return mainActivity;
	}
	
	public UsbAccessory getUsbAccessory () {
		return usbAccessory;
	}
	
	public TransportType getTransportType() {
		return TransportType.USB;
	}
}