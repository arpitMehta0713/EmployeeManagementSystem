package com.cg.apps.dao;

import com.cg.apps.beans.*;
import java.util.*;

import org.springframework.stereotype.Component;
@Component
public class StoreHolder {
	public static Map<Integer, Employee> store = new HashMap<>();

	public Map<Integer, Employee> getStore() {
		return store;
	}
}