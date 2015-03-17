public class countSort{
public static int[] countSort(int[] A, int k)
{
	int[] C = new int[k+1];
	int[] B = new int[A.length-1];
	for(int i = 0; i < k+1; i++){
		C[A[i]] += 1;
}
	for(int i = 1; i < k+1; i++){
		C[i] += C[i-1]; 
}
	for(int i = A.length-1; i >= 0; i--){
		B[C[A[i]]] = A[i];
		C[A[i]]--;
}
	return B;
}
public static void main(String[] args){
	int[] A = new int[]{2,5,3,0,2,3,0,3};
	int[] B = countSort(A,5);
	for(int i = 0; i < B.length; i++){
		System.out.println(B[i]);
}
}
}






