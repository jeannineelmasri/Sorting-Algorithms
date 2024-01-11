public class SortingTest {

    public static void main(String[] args) {
        testSorting(10);      // array of size 10
        testSorting(10000);   // array of size 10,000
    }

    private static void testSorting(int sizeOfArray) {
        System.out.println("Testing with array of size " + sizeOfArray);

        int[] testArray = Sorting.generateRandom(sizeOfArray);

        // Selection Sort
        int[] selectionSortedArray = Sorting.selectionSort(testArray.clone());
        System.out.println("Selection Sort Result: ");
        Sorting.printArray(selectionSortedArray);
        System.out.println("Selection Sort Iterations: " + Sorting.getSelectionCount());

        // Merge Sort
        int[] mergeSortedArray = Sorting.mergeSort(testArray.clone());
        System.out.println("Merge Sort Result: ");
        Sorting.printArray(mergeSortedArray);
        System.out.println("Merge Sort Iterations: " + Sorting.getMergeCount());

        System.out.println();
    }
}
