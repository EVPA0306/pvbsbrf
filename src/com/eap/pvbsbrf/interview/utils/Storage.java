package com.eap.pvbsbrf.interview.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {
	private List params;

	public Storage() {
		params = new ArrayList();
	}
	
	public List get() {
		return params;
	}

	public void store(List params) {
		this.params = params;
	}
	
	public void store(String item) {
		params.add(item);
	}
	
	public void clearAll() {
		params.clear();
	}
	
	public void clear(int index) {
		params.remove(index);
	}
	
	public void clear(int sIndex, int eIndex) {
		for (int i = sIndex; i <= eIndex; i++) {
			params.remove(i);
		}
	}
	
	public int find(String value) {
		List pList = params;
		Collections.sort(pList);
		params = pList;
		return Collections.binarySearch(params, value);		
	}
	
	public int count() {
		return params.size();
	}
	
	public void setAtPosition(int index, String value) {
			params.set(index, value);
	}
	
	public Object getAtPosition(int index) {
		return params.get(index);
	}
	
	public void sort(String order) {
		if ("desc".equalsIgnoreCase(order)) {
			Collections.sort(params, Collections.reverseOrder());
		} else {
			Collections.sort(params);
		}
	}
	
	public void unique() {
		Set set = new HashSet(params);
		params = new ArrayList(set);
	}
	
	public boolean isEmpty() {
		return params.isEmpty();
	}
}
