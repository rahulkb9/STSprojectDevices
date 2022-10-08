package com.task.devices.service;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.task.devices.model.Devices;
import com.task.devices.model.Devices.DeviceConfig;
import com.task.devices.model.ResponseModel;

@Service
public class DeviceServiceImpl implements DeviceService {

	public List<Devices> readJsonData() {
		List<Devices> devices = new ArrayList<>();
		try {
			String json = Files.readString(Path.of("device.json"));
			devices = new Gson().fromJson(json, new TypeToken<List<Devices>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return devices;
	}

	@Override
	public List<Devices> fetchAllDevices() {
		ResponseModel responseModel = new ResponseModel();
		List<Devices> deviceData = readJsonData();
		List<Object> fetched = new ArrayList<>();
		fetched.add(deviceData);
		responseModel.setCount(fetched.size());
		responseModel.setData(fetched);
		return deviceData;
	}

	@Override
	public Map<String, Map> fetchDeviceCountWithDetails() {
		Integer count = 0;
		List<Devices> deviceData = readJsonData();
		return fetchDeviceCountWithDetails2(deviceData);
	}

	@Override
	public Map<String, Map> getByModelnDate(String model, String date) {
		List<Devices> deviceData = readJsonData();
		List<Devices> list = new ArrayList<>();
		Map<String, Devices> map1 = new HashMap<>();
		for (Devices dev : deviceData) {
			String devDate = dev.getFirmware_date().substring(0, 10);
			if (model.equals(dev.getModel()) && devDate.equals(date))
				list.add(dev);
		}
		return fetchDeviceCountWithDetails2(list);
	}

	@Override
	public Map<String, Map> findDevicewithConfig(String string) {
		List<Devices> deviceData = readJsonData();
		List<Devices> list = new ArrayList<>();
		Map<String, List> map = new HashMap<>();
		Devices.DeviceConfig config = new DeviceConfig();

		Map<String, Devices.DeviceConfig> configmap = new HashMap<>();

		try {
			Method getter = config.getClass().getMethod(string);
			getter.invoke(config);

			for (Devices dev : deviceData) {
				List<Devices> devloc = new ArrayList<>();

				Method getter2 = dev.getDeviceConfig().getClass().getMethod(string);
				if (getter.invoke(config).equals(getter2.invoke(dev.getDeviceConfig()))) {
				} else {
					list.add(dev);

				}
				fetchDeviceCountWithDetails2(list);
				for (Devices d : list) {
					if (d.getLocation().equals(dev.getLocation())) {
						devloc.add(d);
						map.put(dev.getLocation(), devloc);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return fetchDeviceCountWithDetails2(list);
	}

	public Map<String, Map> fetchDeviceCountWithDetails2(List<Devices> list) {
		Integer count = 0;
		Set<String> loc = new HashSet<>();
		Set<String> devi = new HashSet<>();
		Map<String, Map> overAll = new HashMap<>();
		for (Devices dev : list) {
			loc.add(dev.getLocation());
			devi.add(dev.getModel());
		}
		for (String tempLocation : loc) {
			Map<String, Object> addOn = new HashMap<>();
			Map<String, List> demo = new HashMap<>();
			List<Devices> fetched = new ArrayList<>();
			for (Devices dev : list) {
				if (dev.getLocation().equals(tempLocation)) {
					for (Devices data : list) {
						if (data.getModel().equals(dev.getModel()) && dev == data) {
							count += 1;
							fetched.add(dev);
						}
					}
					List<Object> devloc = new ArrayList<>();
					for (Devices d : fetched) {
						if (d.getModel().equals(dev.getModel()))
							devloc.add(d);
					}
					demo.put(dev.getModel(), devloc);
				}
			}
			addOn.put("devicesModel", demo);
			addOn.put("deviceCount", count);
			overAll.put(tempLocation, addOn);
			count = 0;
		}
		System.out.println(overAll);
		return overAll;
	}
}
