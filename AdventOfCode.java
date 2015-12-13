import java.io.*;
import java.util.*;

public class AdventOfCode {
   
    public static void main(String...args) throws IOException {
        FileReader text = new FileReader("input2.txt");
        System.out.println(AdventOfCode.dayTwo(text));
    }

    private static int dayOne(FileReader text) throws IOException {
        int floor = 0;
        int open = 1;
        int closed = -1;
        
        BufferedReader br = new BufferedReader(text);
        String curr = br.readLine();
        boolean temp = true;
        int position = 1;
        while (curr != null) {
            for (int i = 0; i < curr.length() && temp; i++) {
                if (curr.charAt(i) == '(') {
                    floor += open;
                } else {
                    floor += closed;
                }
                if (floor < 0) {
                    System.out.println(position);
                    temp = false;
                }
                position++;
            }

            curr = br.readLine();
        }
        return floor;
    }

    private static int dayTwo(FileReader text) throws IOException {
        int surfaceArea = 0;

        BufferedReader br = new BufferedReader(text);
        String curr = br.readLine();
        while (curr != null) {
            String[] nums = curr.split("x");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);
            surfaceArea += ((a * b) + (b * c) + (a * c)); 
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            surfaceArea += arr[0] * arr[1];
            System.out.println(surfaceArea);
            curr = br.readLine();
        }
        return surfaceArea;
    }
}
