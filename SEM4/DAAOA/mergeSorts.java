import java.util.Scanner;
import java.util.Random;

public class mergeSorts {
	mergeSorts(int arr[], int start, int end) {
		divide(arr, start, end);
	}

	void divide(int arr[], int start, int end) {
		if (start < end) {
			int mid = ((start + end) / 2);
			divide(arr, start, mid);
			divide(arr, mid + 1, end);
			conquer(arr, start, mid, end);
		}
	}

	void conquer(int[] arr, int start, int mid, int end) {
		int[] arr2 = new int[arr.length];
		int i = start;
		int j = mid + 1;
		int k = start;

		while (i <= mid & j <= end) {
			if (arr[i] < arr[j]) {
				arr2[k] = arr[i];
				i++;
			} else {
				arr2[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			arr2[k] = arr[i];
			k++;
			i++;
		}
		while (j <= end) {
			arr2[k] = arr[j];
			k++;
			j++;
		}
		for (i = start; i <= end; i++) {
			arr[i] = arr2[i];
		}
	}

	public static void main(String[] args) {

		Random rd = new Random();
		System.out.println("Enter Size of Array");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();

		int arr[] = new int[n];

		// generating random array

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(50);
		}
		System.out.println("Before Sorting:");

		for (int items : arr) {
			System.out.print(items + ",");
		}
		
		new mergeSorts(arr, 0, arr.length - 1);

		System.out.println("\nAfter Sorting:");
		for (int items : arr) {
			System.out.print(items + ",");
		}

	}
}
