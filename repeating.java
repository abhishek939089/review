import java.util.Scanner;

public class repeating {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 10, 10};
        int n = arr.length;
        boolean[] isVisited = new boolean[n];

        System.out.print("Repeating elements: ");
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
		continue;
	    }
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    isVisited[j] = true;
                }
            }

            if (count > 1) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println();
        System.out.print("non-repeating elements: ");
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]){
                System.out.print(arr[i]+" ");
	    }
        }
    }
}

