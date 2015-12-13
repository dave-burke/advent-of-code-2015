#!groovy

import java.util.function.*;

class NumberSystem {
	List<Integer> value;
	List<Character> digits;

	NumberSystem(String initialValue, List<Character> digits){
		value = initialValue.collect { digits.indexOf(it) };
		this.digits = digits;
	}

	String getValue(){
		return value.collect { digits[it] }.join();
	}

	String inc(){
		for(int i = value.size() - 1; i >= 0; i--){
			value[i]++;
			if(value[i] >= digits.size()){
				value[i] = 0;
			} else {
				break;
			}
		}
		return getValue();
	}

}

Predicate<String> straight = { 
	for(int i = 2; i < it.size(); i++){
		//this won't find a wrapping straight like yza...do those count?
		if((it.charAt(i-2) == it.charAt(i) - 2) &&
		   (it.charAt(i-1) == it.charAt(i) - 1)){
			return true;
		}

	}
	return false;
}
Predicate<String> invalidLetters = { it ==~ /.*[iol].*/ }
Predicate<String> doubleDoubles = { it ==~ /.*([a-z])\1.*([a-z])\2.*/ }

//def alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
def alpha = ['a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z'];

input = "cqjxjnds"; //part 1
input = "cqjxxyzz"; //part 2

def alphabetical = new NumberSystem(input, alpha);

while(true){
	def val = alphabetical.inc();
	if(invalidLetters.test(val)){
		println "${val} contains one of [i,o,l]";
		continue;
	}
	if(!doubleDoubles.test(val)){
		println "${val} doesn't contain two doubles";
		continue;
	}
	if(!straight.test(val)){
		println "${val} doesn't contain a straight";
		continue;
	}
	println "The next password is ${val}";
	break;
}

