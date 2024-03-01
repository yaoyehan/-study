import java.util.TreeMap;

class MedianFinder {
    TreeMap<Integer,Integer> treeMap;
    int[] left;
    int[] right;
    int n=0;
    public MedianFinder() {
        treeMap=new TreeMap<Integer,Integer>();
        left=new int[2];
        right=new int[2];
    }

    public void addNum(int num) {
        treeMap.put(num,treeMap.getOrDefault(num,0)+1);
        if(n==0){
            left[0]=num;
            left[1]=1;
            right[0]=num;
            right[1]=1;
        }else if(n%2==0){
            if(left[0]<=num&&right[0]>num){
                decrease(right);
                increase(left);
            }else if(right[0]<=num){
                increase(left);

            }else {
                decrease(right);
            }
        }else{
            if(left[0]>num){
                decrease(left);
            }else{
                increase(right);
            }
        }
        n++;
    }
    public void decrease(int[] node){
        node[1]--;
        if(node[1]==0){
            node[0]=treeMap.lowerKey(node[0]);
            node[1]=1;
        }
    }
    public void increase(int[] node){
        node[1]++;
        if(treeMap.get(node[0])<node[1]){
            node[0]=treeMap.higherKey(node[0]);
            node[1]=1;
        }
    }

    public double findMedian() {
        return (double)(left[0]+right[0])/2;
    }


}

