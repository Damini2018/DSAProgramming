public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
   int A[]={1,-2,3,-4,-5,6,7,-8,9,10 };
int B= 3;
for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"  ");
        }
    System.out.println(solve(A,B));
  }
  public static int solve(int[] A, int B) {
  
  int a[]=new int[A.length];
        a[0]=A[0];
        for(int i=1;i<A.length;i++){
            a[i]=A[i]+a[i-1];
        }
           for(int i=0;i<A.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        int sum=a[B-1];
        System.out.println(" initial sum = "+sum);
        for(int i=B-2;i>=0;i--){
            int index=A.length- (B-1-i);
            
            int sum1= a[i]+(a[A.length-1]-a[index-1]);
            System.out.println("B-i = "+i+"   index = "+index+"    sum = "+sum1+"  a[i] = "+a[i]+"  a[index-1] = " + (a[A.length-1]-a[index-1]));
            if(sum<sum1) sum=sum1;
        }
        return sum;

    }
}



//Given an integer array A of size N.

//You can pick B elements from either left or right end of the array A to get maximum sum.

//Find and return this maximum possible sum.

//NOTE: Suppose B = 4 and array A contains 10 elements then:

//You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.
