import java.util.HashSet;
    public class A5 {
        static char[] color={'r','w','y'};
        static int[] co={3,4,5};
        static int len=12;
        static HashSet<String> set=new HashSet<String>();
        //static int [] a=new int[]{1,1,1,1};

        static boolean pd(String s){
            String ds=s+s;;//把字符串拼接成两段，取长度为len的子串，模拟随意转动的效果
            for(int i=0;i<len;i++){
                String tmp=ds.substring(i,i+len);
                if(set.contains(tmp))
                    return false;
                StringBuilder bs=new StringBuilder(tmp);//翻转
                tmp=bs.reverse().toString();
                if(set.contains(tmp))
                    return false;
            }

      /* StringBuilder bs=new StringBuilder(s);
        String tmp=bs.reverse().toString();
        if(set.contains(tmp))
           return false;*/
            return true;
        }

        static void dfs(String x){
            if(x.length()==12){
                // System.out.println(x);
                if(pd(x)){
                    set.add(x);
                }
                return;
            }
            String tx=x;
            for(int i=0;i<3;i++){
                tx=x;
                if(co[i]!=0){
                    tx+=color[i];
                    co[i]--;
                    dfs(tx);
                    co[i]++;
                }
            }

        }

        public static void main(String[] args) {
            dfs("");
            System.out.println(set.size());
        }
    }

