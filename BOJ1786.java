import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1786 {
    public static void main(String[] args) throws IOException {
        char[] text, pattern;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        text = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();

        ArrayList<Integer> ans = KMP(text, pattern);

        System.out.println(ans.size());
        for(int i = 0; i<ans.size();++i){
            System.out.print(ans.get(i) + " ");
        }
    }

    static int[] getPi(char[] pattern){
        int[] pi = new int[pattern.length];
        int j = 0;

        for(int i=1; i<pattern.length; ++i){
            while(j >0 && pattern[i] != pattern[j]){
                j = pi[j-1];
            }
            if(pattern[i] == pattern[j]){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static ArrayList<Integer> KMP(char[] text, char[] pattern){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] pi = getPi(pattern);
        int j = 0;

        for(int i = 0; i<text.length; ++i){
            while(j > 0 && text[i] != pattern[j]){
                j = pi[j-1];
            }
            if(text[i] == pattern[j]){
                if(j == pattern.length-1){
                    ans.add(i - pattern.length + 2);
                    j = pi[j];
                }else{
                    ++j;
                }
            }
        }

        return ans;
    }
}
