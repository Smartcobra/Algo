public class BruteForce {

    public static int[][] getMatrixMultiplicationResult(int [][]A,int [][] B,int[][] result){
        int size=A[0].length;
        int sum=0;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    result[i][j]=result[i][j]+(A[i][k]*B[k][j]);

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
         int a[][]={
                {1,1,1,1},
                {2,2,2,2},
                {3,3,3,3},
                {4,4,4,4},
        };

        int b[][]={
                {1,1,1,1},
                {2,2,2,2},
                {3,3,3,3},
                {4,4,4,4},
        };

        int result[][]= new int [4][4];
        getMatrixMultiplicationResult(a,b,result);

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
