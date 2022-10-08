package com.task.devices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.devices.model.Devices;
import com.task.devices.service.DeviceService;

@RestController
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	@GetMapping("/devices/all")
	public List<Devices> fetchAllDevices() {
		return deviceService.fetchAllDevices();
	}

	@GetMapping("/devices/")
	public Map<String, Map> fetchDeviceCounts() {
		return deviceService.fetchDeviceCountWithDetails();
	}

	@GetMapping("/findDevices/")
	public Map<String, Map> getdeatilsByInput(@RequestBody Devices device) {
		return deviceService.getByModelnDate(device.getModel(), device.getFirmware_date());
	}

	@GetMapping("/deviceConfig/{string}")
	public Map<String, Map> findWithDeviceConfig(@PathVariable("string") String string) {
		System.out.println(string);
		return deviceService.findDevicewithConfig(string);
	}

}
