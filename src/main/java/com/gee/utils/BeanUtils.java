package com.gee.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.StopWatch;

import com.gee.entity.Role;



public class BeanUtils {
	
	/**
	 * @author huangzhaoji
	 * 用于将结果map转化成javaBean
	 */
	public static <T> List transform(List<Map<String, Object>> data, Class<T> classObject){
		if(data == null || data.isEmpty()) {
			return null;
		}
		Set<String> columnNames = data.get(0).keySet();
		Method[] methodArrays = classObject.getMethods();
		if (methodArrays == null) return null;
		List<Method> methodList = Arrays.asList(methodArrays);
		List<T> tList = new ArrayList<T>();
		data.forEach(mapItem -> {
			T t = null;
			try {
				t = classObject.newInstance();
				tList.add(t);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			for(String column : columnNames) {
				String methodName = "set" + column.substring(0, 1).toUpperCase() + column.substring(1);
				System.out.println(methodName);
				Optional<Method> optional = methodList.stream().filter(s -> methodName.equals(s.getName())).findAny();
				if(optional.isPresent()) {
					try {
						optional.get().invoke(t, mapItem.get(column));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		return tList;
	}
	
	
	public static void main(String args[]) {
		List<Map<String, Object>> mapList = new ArrayList();
		for(int i = 0; i < 1000; i ++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", "1");
			map.put("roleName", "admin");
			mapList.add(map);
		}
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		List<Role> roles = BeanUtils.transform(mapList, Role.class);
		stopWatch.stop();
		System.out.println(roles.get(0).getRoleName());
		System.out.println(roles.size());

		System.out.println(stopWatch.getTotalTimeMillis());
	}
}
