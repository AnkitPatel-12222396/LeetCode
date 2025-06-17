class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<m;i++){
            reverse(matrix[i]);
        }
    }
    public void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int temp1 = arr[start];
            arr[start] = arr[end];
            arr[end] = temp1;
            start++;
            end--;
        }
    }
}