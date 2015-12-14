#!groovy

import groovy.json.*;

def sumNums(def object){
	return object.collect(new ArrayList()) {
		if(it instanceof Integer){
			return it;
		} else if (it instanceof String) {
			return 0;
		} else if (it instanceof Map){
			return sumNums(it.values());
		} else if (it instanceof List){
			return sumNums(it);
		}
	}.sum();
}

def sumNonRedNums(def object){
	return object.collect(new ArrayList()) {
		if(it instanceof Integer){
			return it;
		} else if (it instanceof String) {
			return 0;
		} else if (it instanceof Map){
			if(it.containsValue("red")){
				return 0;
			} else {
				return sumNonRedNums(it.values());
			}
		} else if (it instanceof List){
			return sumNonRedNums(it);
		}
	}.sum();
}

String json = new File("day12.txt").inject(String.&concat);

def object = new JsonSlurper().parseText(json);

println "Part 1: ${sumNums(object)}";
println "Part 2: ${sumNonRedNums(object)}";
