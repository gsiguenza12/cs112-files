public class SelectionSort
{
    public static void main(String[] args)
    {
        double[] scores = {9.5, 7.0, 8.5, 1.0, 3.0, 10.0};

        System.out.print("SCORES BEFORE SORTING: ");
        printArray(scores, scores.length);

        selectionSort(scores, scores.length);

        System.out.print("SCORES AFTER SORTING: ");
        printArray(scores, scores.length);

        double[] temperatures;
        int numTemps;
        temperatures = new double[10];

        numTemps = 5;
        for(int i = 0; i < numTemps; i++)
        {
            temperatures[i] = (int)((Math.random() * 50 + 50) * 100) / 100.0;
        }

        System.out.print("TEMPERATURES BEFORE SORTING: ");
        printArray(temperatures, temperatures.length);

        selectionSort(temperatures, numTemps);

        System.out.print("TEMPERATURES AFTER SORTING: ");
        printArray(temperatures, temperatures.length);

    }


    //DESCRIPTION:  returns index of smallest value from marker to end of partially filled array
    //PRECONDITION: numUsed is number of spots filled in array (not greater than length of array)
    //              marker is between 0 and a.length - 1
    //POSTCONDITION:returns index of smallest value, no changes to array
    public static int indexOfSmallest(int marker, double[] a, int numUsed)
    {
        double smallest;
        int smallestIndex;

        smallestIndex = marker;
        smallest = a[marker];

        for(int current = marker+1; current < numUsed; current++)
        {
            if(a[current] < smallest)
            {
                smallest = a[current];
                smallestIndex = current;
            }
        }

        return smallestIndex;
    }

    //DESCRIPTION:  swaps a[i] and a[j]
    //PRECONDITION: i and j are valid indices in a
    //POSTCONDITION:swaps i and j index values in original array
    public static void swap(int i, int j, double[] a)
    {
        double temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //DESCRIPTION:  sorts partially filled array using selection sort algorithm
    //PRECONDITION: numUsed is number of spots filled in array (not greater than length of array)
    //POSTCONDITION:sorts array values from smallest to largest in original array
    public static void selectionSort(double[] a, int numUsed)
    {
        int smallestIndex;
        //for every element in partially filled array
        for(int marker = 0; marker < numUsed-1; marker++)
        {
            //find index of smallest value
            smallestIndex = indexOfSmallest(marker, a, numUsed);
            //swap current index with smallest value index
            swap(marker, smallestIndex, a);
        }
    }

    //HOPEFULLY YOU UPDATED YOUR CS111 TO HAVE THIS METHOD!!
    //Upgraded it to look a little nicer for arrays (take up less space on screen)
    public static void printArray(double[] a, int numUsed)
    {
        System.out.print("[ " + a[0]);
        for(int i = 1; i < numUsed; i++)
        {
            System.out.print(" , " + a[i]);
        }
        System.out.println(" ]");
    }


}
