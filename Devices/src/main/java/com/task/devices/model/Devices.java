package com.task.devices.model;

public class Devices {
	String model;
	String firmware;
	String firmware_date;
	String name;
	String floorLocation;
	boolean isFotaEnabled;

	DeviceConfig deviceConfig;

	public static class DeviceConfig {
		boolean wifiEnabled;
		boolean gpsEnabled;
		boolean bluetoothEnabled;

		public DeviceConfig() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DeviceConfig(boolean wifiEnabled, boolean gpsEnabled, boolean bluetoothEnabled) {
			super();
			this.wifiEnabled = wifiEnabled;
			this.gpsEnabled = gpsEnabled;
			this.bluetoothEnabled = bluetoothEnabled;
		}

		public boolean isWifiEnabled() {
			return wifiEnabled;
		}

		public void setWifiEnabled(boolean wifiEnabled) {
			this.wifiEnabled = wifiEnabled;
		}

		public boolean isGpsEnabled() {
			return gpsEnabled;
		}

		public void setGpsEnabled(boolean gpsEnabled) {
			this.gpsEnabled = gpsEnabled;
		}

		public boolean isBluetoothEnabled() {
			return bluetoothEnabled;
		}

		public void setBluetoothEnabled(boolean bluetoothEnabled) {
			this.bluetoothEnabled = bluetoothEnabled;
		}

		@Override
		public String toString() {
			return "DeviceConfig [wifiEnabled=" + wifiEnabled + ", gpsEnabled=" + gpsEnabled + ", bluetoothEnabled="
					+ bluetoothEnabled + "]";
		}
	}

	String location;

	public Devices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Devices(String model, String firmware, String firmware_date, String name, String floorLocation,
			boolean isFotaEnabled, DeviceConfig deviceConfig, String location) {
		super();
		this.model = model;
		this.firmware = firmware;
		this.firmware_date = firmware_date;
		this.name = name;
		this.floorLocation = floorLocation;
		this.isFotaEnabled = isFotaEnabled;
		this.deviceConfig = deviceConfig;
		this.location = location;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getFirmware_date() {
		return firmware_date;
	}

	public void setFirmware_date(String firmware_date) {
		this.firmware_date = firmware_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloorLocation() {
		return floorLocation;
	}

	public void setFloorLocation(String floorLocation) {
		this.floorLocation = floorLocation;
	}

	public boolean isFotaEnabled() {
		return isFotaEnabled;
	}

	public void setFotaEnabled(boolean isFotaEnabled) {
		this.isFotaEnabled = isFotaEnabled;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DeviceConfig getDeviceConfig() {
		return deviceConfig;
	}

	public void setDeviceConfig(DeviceConfig deviceConfig) {
		this.deviceConfig = deviceConfig;
	}

	@Override
	public String toString() {
		return "Devices [model=" + model + ", firmware=" + firmware + ", firmware_date=" + firmware_date + ", name="
				+ name + ", floorLocation=" + floorLocation + ", isFotaEnabled=" + isFotaEnabled + ", deviceConfig="
				+ deviceConfig + ", location=" + location + "]";
	}

}
