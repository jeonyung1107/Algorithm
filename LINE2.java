import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LINE2 {

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
            int userX = Integer.parseInt(tokens.nextToken());
            int userY = Integer.parseInt(tokens.nextToken());
            int shopCount = Integer.parseInt(tokens.nextToken());

            List<shop> shops = new ArrayList<>();

            for (int i = 0; i < shopCount; i++) {
                tokens = new StringTokenizer(br.readLine().trim());
                int shopX = Integer.parseInt(tokens.nextToken());
                int shopY = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                int coupon = Integer.parseInt(tokens.nextToken());

                shops.add(new shop(shopX,shopY,name,coupon,getDistance(userX,userY,shopX,shopY)));
            }

            shops.sort(new Comparator<shop>() {
                @Override
                public int compare(shop o1, shop o2) {
                    if(o1.distance != o2.distance) {
                        return o1.distance - o2.distance;
                    }else if (o1.coupon != o2.coupon){
                        return o2.coupon - o2.coupon;
                    }else{
                        for(int i=0; i<6;++i){
                            if(o1.name.charAt(i) !=o2.name.charAt(i)){
                                return  o1.name.charAt(i) - o2.name.charAt(i);
                            }
                        }
                    }
                    return 0;
                }
            });

            for(int i=0;i<shopCount;++i){
                System.out.println(shops.get(i));
            }
        }
    }

    private static class shop{
        int x;
        int y;
        String name;
        int coupon;
        int distance;

        public shop(int x,int y,String name,int coupon,int distance){
            this.x = x;
            this.y = y;
            this.name = name;
            this.coupon = coupon;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "" + x + " " + y + " " + name + " " + coupon;
        }
    }
    public static int getDistance(int x1, int y1, int x2, int y2){
        int res = (int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))/100;

        return res*100;
    }
}

