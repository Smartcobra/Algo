import java.util.Arrays;
import java.util.Scanner;

public class BruteForce {

    public static int findMaxValue(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int i,k=0;
        int j,l=0;
        for(i=0;i<arr.length;i++){
            int sum=0;
            for(j=i;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum>maxSum){
                    k=i;  //to print from index
                    l=j;  //to print to index
                    maxSum=sum;
                }
            }
        }
        System.out.println(k+"--"+l);
        return  maxSum;
    }

    public static int[] findMaxSubArray(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int k=0,l=0,m=0;

        for(i=0;i<arr.length;i++){
            int sum=0;
            for(j=i;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum>maxSum){
                    k=i;  //to print from index
                    l=j;  //to print to index
                    maxSum=sum;

                }
            }
        }
        int ans[]=new int[l-k+1];
        while(k<=l){
            ans[m]=arr[k];
            k++;
            m++;
        }
       // System.out.println(k+"--"+l);
        return  ans;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr= new int[size];
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println(findMaxValue(arr)); //-2 -3 4 -1 -2 1 5 -3
        int ans[]=findMaxSubArray(arr);
        Arrays.stream(ans).forEach(x->System.out.print(x+","));

    }
}
