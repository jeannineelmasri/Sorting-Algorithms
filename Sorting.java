import java.util.Arrays;
import java.util.Random;
public class Sorting
{
    private static int selectionCount;
    private static int mergeCount;
    public static int[] generateRandom(int sizeOfArray){
        int[] arr = new int[sizeOfArray];
        Random random = new Random();
        
        for (int i = 0; i < sizeOfArray; i++){
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
    
    public static int[] selectionSort(int[] arr){  
      int a = arr.length;
      for (int i = 0; i < a - 1; i++)
      {  
        int minimum = i;
        for (int j = i + 1; j < a; j++){
            selectionCount ++;
            if (arr[j] < arr[minimum]){
                minimum = j;
            }
        }
         int temp = arr[minimum];
         arr[minimum] = arr[i];
         arr[i] = temp;
      }
      return arr;
   }
   private static void merge(int arr[], int left, int middle, int right){
       int num1 = middle - left + 1;
       int num2 = right - middle;
       
       int[] leftSide = new int[num1];
       int[] rightSide = new int[num2];
       
       for (int i = 0; i < num1; ++i){
           leftSide[i] = arr[left + i];
       }
       for (int j = 0; j < num2; ++j){
           rightSide[j] = arr[middle + 1 + j];
       }
       
       int i =0;
       int j = 0;
       int k = left;
       
       while (i < num1 && j < num2){
           mergeCount++;
           if (leftSide[i] <= rightSide[j]){
               arr[k] = leftSide[i];
               i++;
           }
           else{
               arr[k] = rightSide[j];
               j++;
           }
           k++;
       }
       while (i < num1){
           arr[k] = leftSide[i];
           i++;
           k++;
       }
       while (j < num2){
           arr[k] = rightSide[j];
           j++;
           k++;
       }
   }
   
   private static void mergeSort(int arr[], int left, int right){
       if (left < right){
           int middle = left + (right - left)/2;
           mergeSort(arr, left, middle);
           mergeSort(arr, middle + 1, right);
           merge(arr, left, middle, right);
       }
   }
   
   public static int[] mergeSort(int[] arr){
       mergeCount = 0;
       mergeSort(arr, 0, arr.length - 1);
       return arr;
   }
   
   public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
   }

    public static int getSelectionCount() {
        return selectionCount;
   }

    public static int getMergeCount() {
        return mergeCount;
   }
}

