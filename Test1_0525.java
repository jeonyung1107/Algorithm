import java.util.ArrayList;
import java.util.List;

public class Test1_0525 {
    public static void main(String[] args) {
        List<Integer> tl = new ArrayList<>();

        for(int i=0; i<100_000; ++i){
            tl.add(i+(int)Math.random()*100);
        }

        long r = tl.stream().reduce(0,(a,b) -> a+b );

        System.out.println(r);
    }
}
