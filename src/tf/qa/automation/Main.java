package tf.qa.automation;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] x = new int[]{8,1,4,2,20,9,-5};

        System.out.println("До сортировки");
        for (int i = 0; i < x.length; i++) {

            System.out.print(x[i] + " ");
        }

        tanosSort(x,x[0], x.length);

        System.out.println("\nПосле");
        for (int i = 0; i < x.length; i++) {

            System.out.print(x[i] + " ");
        }

    }

    public static void tanosSort (int[] array, int low, int high) {
        low = 0;
        high = array.length-1;

        if(array.length==0)
            return;

        if (low >=high)
            return;

        int sum = 0;
        int count=0;

        int i = low, j = high;
        // for (i=0; i< array.length-1; i++) {
        boolean isSorted = false;


            for (i = 0; i < array.length - 1; i++) {
                sum += array[i];
                i++;
                count++;
            }
            int average = sum / count;

            // while(i<=j)        {

            for (i = 0; i < array.length - 1; i++) {
                while (array[i] < average) {
                    i++;
                }


                while (array[j] > average) {
                    j--;
                }

                if (i <= j) {

                    int buffer = array[i];
                    array[i] = array[j];
                    array[j] = buffer;
                    i++;
                    j--;
                }
            }

            if (low < j)
                tanosSort(array, low, j);

            if (high > i)
                tanosSort(array, i, high);

        }

}