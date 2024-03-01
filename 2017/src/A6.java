public class A6 {
    public static void main(String[] args) {
        char arr[]=new char [2014];
        int len=2014;
        int index=0;
        for (int j = 0; j < 106; j++) {
            for (int i = 0; i < 19; i++) {
                arr[index++]= (char) ('a'+i);
            }
        }
        while(len!=1){
            int k=0;
            for (int i = 1; i < len; i+=2) {
                arr[k++]=arr[i];
            }
            len=k;
        }
        System.out.println(arr[0]);
    }
}