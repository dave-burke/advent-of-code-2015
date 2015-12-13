import java.security.MessageDigest;
import java.time.*;

String md5(String s){
    MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString();
}

boolean test(String input, int difficulty){
    return md5(input).startsWith('0'.multiply(difficulty));
}

def proc(String input){
    int solution = 0;
    while(!test(input + solution, 5)){
        solution++;
    }
    println solution;
}

String input = 'yzbqklnj';
long start = System.nanoTime();
proc(input);
long end = System.nanoTime();
Duration.ofNanos(end - start);

//condensed
java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
int solution = 0;
while(!md5.digest((input + solution).bytes).encodeHex().toString().startsWith('0'.multiply(5))){
    solution++;
}
println solution;