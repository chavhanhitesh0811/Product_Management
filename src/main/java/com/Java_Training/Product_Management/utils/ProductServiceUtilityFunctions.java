package com.Java_Training.Product_Management.utils;

import java.util.HashMap;
import java.util.LinkedList;

public class ProductServiceUtilityFunctions {

	public static HashMap<String, LinkedList<Integer>> leasetVisitedCache(HashMap<String, LinkedList<Integer>> map,
			String userId, int productId) {

		LinkedList<Integer> visitedProducts = new LinkedList<Integer>();
		if (map.containsKey(userId)) {
			visitedProducts = map.get(userId);
		}

		if (visitedProducts.size() == 10) {
			if (!visitedProducts.contains(productId)) {
				visitedProducts.removeLast();
			} else {
				for (int i = 0; i < visitedProducts.size(); i++) {
					if (visitedProducts.get(i) == productId) {
						visitedProducts.remove(i);
						break;
					}
				}
			}
			visitedProducts.addFirst(productId);

		} else {
			if (visitedProducts.contains(productId)) {
				for (int i = 0; i < visitedProducts.size(); i++) {
					if (visitedProducts.get(i) == productId) {
						visitedProducts.remove(i);
						break;
					}
				}
			}
			visitedProducts.addFirst(productId);
		}
		map.put(userId, visitedProducts);
		return map;
	}
}
