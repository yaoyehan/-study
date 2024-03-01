import java.util.Scanner;
public class A4 {
    static String s;
    static int len;
    static int m=0;
    static int pos=0;
    static int f(){
        int tmp=0;
        int len=s.length();
        while(pos<len){
            if(s.charAt(pos)=='('){
                pos++;
                tmp+=f();
            } else if(s.charAt(pos)=='x'){
                pos++;
                tmp++;
            } else if(s.charAt(pos)=='|'){
                pos++;
                m=Math.max(m,tmp);
                tmp=0;
            }else if(s.charAt(pos)==')'){
                pos++;
                m=Math.max(m,tmp);
                return m;
            }
        }
        m=Math.max(m,tmp);
        return m;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s=scanner.nextLine();
        len=s.length();
        int ans=f();
        System.out.println(ans);
    }
}
