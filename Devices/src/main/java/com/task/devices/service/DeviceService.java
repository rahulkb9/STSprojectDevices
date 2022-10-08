package com.task.devices.service;

import java.util.List;
import java.util.Map;

import com.task.devices.model.Devices;

public interface DeviceService {

	List<Devices> fetchAllDevices();

	Map<String, Map> fetchDeviceCountWithDetails();

	Map<String, Map> getByModelnDate(String model, String date);

	Map<String, Map> findDevicewithConfig(String string);
}
