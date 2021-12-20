// Time Complexity : O(n2)
// Space Complexity : O(n)

class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
        if(i == j)
            return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j]; 
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        int p = l-1;
        int i = l;
        int pivot = arr[h];
        while(i < h) {
            if(arr[i] < pivot) {
                p++;
                swap(arr, i, p);
            }
            i++;
        }
        swap(arr, h, p+1);
        return p+1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        int[] stack = new int[h - l + 1];
 
        int top = -1;
 
        stack[++top] = l;
        stack[++top] = h;
 
        while (top >= 0) {
      
            h = stack[top--];
            l = stack[top--];
 
            int p = partition(arr, l, h);
 
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
 
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 