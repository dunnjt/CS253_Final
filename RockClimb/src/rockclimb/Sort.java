/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

/**
 * CS253
 * T/Th - 12:15-1:30
 * 
 * @author (John Dunn) 
 * @version (9/14/15)
 */

import java.util.ArrayList;

class Sort {

    private static int numberOfSwaps = 0;
    private static int numberOfComp = 0;
    private static String sortType = null;
//    
//    public static void bubbleSort(AnyType[] array)   {
//        AnyType temp;
//        int numberOfItems = array.length;
//        sortType = "Bubble Sort: ";
//        for (int pass=1; pass != numberOfItems; pass++) {
//           for (int index=0; index != numberOfItems-pass; index++)
//           {
//               numberOfComp++;
//               if (array[index].isBetterThan(array[index+1])) {
//                   temp = array[index];
//                   array[index] = array[index+1];
//                   array[index+1] = temp;
//  
//                   numberOfSwaps++;
//                }
//           }
//        }
//    }
    
    public static void selectionSort(ArrayList<Points> points) {
        int min;
        Points temp;
        sortType = "Selection Sort: ";
        
        for (int i = 0; i < points.size(); i++)
        {
            min = i;
            for (int scan = i+1; scan < points.size(); scan++)
            {
                if (points.get(scan).getY()>points.get(min).getY() == false)
                {
                    min = scan;
                }
                numberOfComp++;
            }
            temp = points.get(min);
            points.set(min, points.get(i));
            points.set(i, temp);
            numberOfSwaps++;
        }
    }
    
//    public static void insertionSort(AnyType[] array) {
//        sortType = "Insertion Sort: ";
//        
//        for (int i = 1; i<array.length; i++)
//        {
//            AnyType temp = array[i];
//            int position = i;
//            while (position > 0 && temp.isBetterThan(array[position-1]) == false)
//            {
//                array[position] = array[position-1];
//                position--;
//                numberOfSwaps++;
//                numberOfComp++;
//            }
//            array[position] = temp;
//            numberOfComp++;
//        }
//    }
//    
//    
//    
//    public static void shellSort(AnyType[] array) {
//        sortType = "Shell Sort: ";
//	int increment = array.length/2;
//	while (increment > 0) {
//		for (int i = increment; i < array.length; i++) {
//			int j = i;
//			AnyType temp = array[i];
//			while (j >= increment && temp.isBetterThan(array[j - increment]) == false) {
//				array[j] = array[j - increment];
//				j = j - increment;
//                                numberOfSwaps++;
//                                numberOfComp++;
//                                
//			}
//			array[j] = temp;
//                        numberOfComp++;
//                     
//		}
//		if (increment == 2) {
//			increment = 1;
//		} else {
//			increment *= (5.0 / 11);
//                        //increment = increment/3;
//                        //increment = increment/4;
//		}
//	}
//    }
//    
//    public static int partition(AnyType arr[], int lo, int high)
//    {
//        int i = lo, j = high;
//        AnyType temp;
//        //AnyType pivot = arr[(lo + high) / 2];
//        AnyType pivot = arr[i];
//        
//        while (i <= j) {
//            while (pivot.isBetterThan(arr[i])) {
//                i++;
//                numberOfComp++;
//            }
//            while (arr[j].isBetterThan(pivot)) {
//                j--;
//                numberOfComp++;
//            }
//            if (i <= j) {
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//                numberOfSwaps++;
//            }
//        }
//        return i;
//    }
// 
//    public static void quickSort(AnyType arr[], int lo, int high) {
//        sortType = "Quick Sort: ";
//        int pivot = partition(arr, lo, high);
//       
//        if (lo < pivot - 1)
//            quickSort(arr, lo, pivot - 1);
//        if (pivot < high)
//            quickSort(arr, pivot, high);
//    }
//    
//    
//    
//    public static void mergeSort(AnyType a[])
//    {
//	AnyType[] tmp = new AnyType[a.length];
//	mergeSort(a, tmp,  0,  a.length - 1);
//    }
//
//
//    private static void mergeSort(AnyType a[], AnyType tmp[], int left, int right)
//    {
//            if( left < right )
//            {
//                    int center = (left + right) / 2;
//                    mergeSort(a, tmp, left, center);
//                    mergeSort(a, tmp, center + 1, right);
//                    merge(a, tmp, left, center + 1, right);
//            }
//    }
//
//
//    private static void merge(AnyType a[], AnyType tmp[], int left, int right, int rightEnd )
//    {
//        int leftEnd = right - 1;
//        int k = left;
//        int num = rightEnd - left + 1;
//
//        while(left <= leftEnd && right <= rightEnd)
//            if(a[left].lessThanEqual(a[right]))
//                tmp[k++] = a[left++];
//            else
//                tmp[k++] = a[right++];
//        numberOfComp++;
//
//        while(left <= leftEnd)    // Copy rest of first half
//            tmp[k++] = a[left++];
//
//        while(right <= rightEnd)  // Copy rest of right half
//            tmp[k++] = a[right++];
//
//        // Copy tmp back
//        for(int i = 0; i < num; i++, rightEnd--)
//            a[rightEnd] = tmp[rightEnd];
//        numberOfSwaps++;
//    }
// 
//    
//    private static int total;
//
//    private static void swap(AnyType[] arr, int a, int b)
//    {
//        AnyType tmp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = tmp;
//        numberOfSwaps++;
//    }
//
//    private static void heapify(AnyType[] arr, int i)
//    {
//        int lft = i * 2;
//        int rgt = lft + 1;
//        int grt = i;
//
//        if (lft <= total && arr[lft].isBetterThan(arr[grt])) {
//            grt = lft;
//            numberOfComp++;
//        }
//        if (rgt <= total && arr[rgt].isBetterThan(arr[grt])) {
//            grt = rgt;
//            numberOfComp++;
//        }
//        if (grt != i) {
//            swap(arr, i, grt);
//            heapify(arr, grt);
//        }
//    }
//
//    public static void heapSort(AnyType[] arr)
//    {
//        sortType = "Heap Sort: ";
//        total = arr.length - 1;
//
//        for (int i = total / 2; i >= 0; i--)
//            heapify(arr, i);
//
//        for (int i = total; i > 0; i--) {
//            swap(arr, 0, i);
//            total--;
//            heapify(arr, 0);
//        }
//    }
//    
//    
//    public static int getSwap()
//    {
//        return numberOfSwaps;
//    }
//    
//    public static int getComp()
//    {
//        return numberOfComp;
//    }
//        
//    public static String getSortType()
//    {
//        return sortType;
//    }
}
