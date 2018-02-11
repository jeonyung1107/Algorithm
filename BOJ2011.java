/*문제: 암호코드
* 알고리즘: DP*/

import java.io.*;

public class BOJ2011 {
    static final int MOD = 1_000_000;
    static int[] tmp = new int[5001];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tmp[0]=1;
        tmp[1]=1;

        String crypto = br.readLine();

        if(Character.getNumericValue(crypto.charAt(0))==0){
            System.out.println(0);
            return;
        }

        for(int i=2;i<=crypto.length();++i){
           if(Character.getNumericValue(crypto.charAt(i-1))!=0){
               tmp[i]+=tmp[i-1];
           }
           if(crypto.charAt(i-2)>='1'&&Integer.parseInt(crypto.substring(i-2,i))<=26){
               tmp[i]+=tmp[i-2];
           }
           tmp[i] = tmp[i]%MOD;
        }
        System.out.println(tmp[crypto.length()]);
    }
}
