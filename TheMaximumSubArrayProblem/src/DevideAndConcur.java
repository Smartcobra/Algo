import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

public class DevideAndConcur {

    public static int[] getMaxSumSubArray(int[] arr, int low, int high) {
        int ans[] = new int[3];
        if (low == high) {
            ans[0] = low;
            ans[1] = high;
            ans[2] = arr[low];
            return ans;
        }
        int mid = (high + low) / 2;
        int[] maxSumSubArrayLeft = getMaxSumSubArray(arr, low, mid);
        int[] maxSumSubArrayRight = getMaxSumSubArray(arr, mid + 1, high);
        int[] maxSumSubArrayMiddle = getMaxSumSubArrayCrossing(arr, low, mid, high);

        if ((maxSumSubArrayLeft[2] > maxSumSubArrayRight[2]) && (maxSumSubArrayLeft[2] > maxSumSubArrayMiddle[2])) {
            return maxSumSubArrayLeft;
        } else if((maxSumSubArrayRight[2] > maxSumSubArrayLeft[2]) && (maxSumSubArrayRight[2] > maxSumSubArrayMiddle[2])){
            return maxSumSubArrayRight;
        }else{
            return maxSumSubArrayMiddle;
        }
    }

    public static int[] getMaxSumSubArrayCrossing(int[] arr, int low, int mid, int high) {

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int minIndex = 0;

        for (int i = mid; i >=low; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                minIndex = i;
            }
        }
            //right half
            int rightSum = Integer.MIN_VALUE;
            sum = 0;
            int maxIndex = 0;

            for (int j = mid+1; j <= high; j++) {
                sum = sum + arr[j];
                if (sum > rightSum) {
                    rightSum = sum;
                    maxIndex = j;
                }
            }
            int ans[] = new int[3];
            ans[0] = minIndex;
            ans[1] = maxIndex;
            ans[2] = leftSum + rightSum;

         return ans;
    }
        public static void main (String[]args){
            int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
            int[] maxSumSubArray = getMaxSumSubArray(arr, 0, arr.length - 1);
            Arrays.stream(maxSumSubArray).forEach(t -> System.out.print(t+" "));
        }

    }
