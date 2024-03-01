import java.util.ArrayList;

public class A4 {
    public static void main(String[] args) {
        ArrayList<Price> a1=new ArrayList<>();
        ArrayList<Price> a2=new ArrayList<>();
        for (int i = 1000; i < 10000; i++) {
            String s=""+i;
            if(s.contains("3")||s.contains("4")||s.contains("7"))
                continue;
            String re_s=  reverse(s);
            int i1 = Integer.parseInt(re_s);
            int plus=i1-i;
            if(i1-i<-200&&i1-i>-300){
                a1.add(new Price(i,plus));
            }
            if(i1-i<900&&i1-i>800){
                a2.add(new Price(i,plus));
            }
        }
        for (Price p1 : a1) {
            for (Price p2 : a2) {
                if(p1.plus+p2.plus==558){
                    System.out.println(p1.p+" "+"plus"+ p1.plus);
                    System.out.println(p2.p+" "+"plus"+ p2.plus);
                }
            }
        }
    }

    private static String reverse(String s) {
        char[] ans=new char[s.length()];
        for (int i = s.length()-1,j=0; i >=0; j++,i--) {
            char c=s.charAt(i);
            if(c=='6'){
                ans[j]='9';
            }else if(c=='9'){
                ans[j]='6';
            }else ans[j]=c;
        }
        return new String(ans);
    }

    private static class Price {
        int p;//原价
        int plus;//颠倒价-原价

        public Price(int p, int plus) {
            this.p = p;
            this.plus = plus;
        }

    }
}
