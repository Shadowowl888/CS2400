package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * TestHeap class to create heaps using the sequential and optimal methods.
 */
public class testHeap {
    public static void main(String[] args) {
        // Create an array for data entries
        int[] entries = new int[100];

        // Read in integers from data.txt into entries array
        try {
            File data = new File("Assignment2/data.txt");
            Scanner scanner = new Scanner(data);
            int index = 0;
            while (scanner.hasNext()) {
                entries[index] = scanner.nextInt();
                index++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured when trying to read in input file.");
        }
        
        // Write the output to the output file, output.txt
        try {
            // Create output file, output.txt
            FileWriter output = new FileWriter("Assignment2/output.txt");
            
            // Sequential Heap Creation
            heap heap1 = new heap();
            for (int entry : entries) {
                heap1.add(entry);
            }

            // Optimal Heap Creation
            heap heap2 = new heap(entries);
            
            // Print sequential heap and number of swaps for creation
            output.write("=====================================================================\n");
            output.write("Heap built using sequential insertions: " + Arrays.toString(heap1.getFirstTen()) + "\n");
            output.write("Number of swaps in the heap creation: " + heap1.getSwapCount() + "\n");

            // Remove ten integers from sequential heap
            for (int i = 0; i < 10; i++) {
                heap1.removeMax();
            }

            // Print sequential heap after removal
            output.write("Heap after 10 removals: " + Arrays.toString(heap1.getFirstTen()) + "\n\n");

            // Print optimal heap and number of swaps for creation
            output.write("Heap built using optimal method: " + Arrays.toString(heap2.getFirstTen()) + "\n");
            output.write("Number of swaps in the heap creation: " + heap2.getSwapCount() + "\n");

            // Remove ten integers from optimal heap
            for (int i = 0; i < 10; i++) {
                heap2.removeMax();
            }
            
            // Print optimal heap after removal
            output.write("Heap after 10 removals: " + Arrays.toString(heap2.getFirstTen()) + "\n");
            output.write("=====================================================================\n");

            output.close();
        } catch (IOException e) {
            System.out.println("An error occured when trying to write to output file.");
            e.printStackTrace();
        }
    }
}
