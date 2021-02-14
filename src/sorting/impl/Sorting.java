/*
 * Copyright for Sorting.java by kumar since 29/11/20, 5:15 PM
 */

package sorting.impl;

import sorting.ISort;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kumar
 * @project java-8
 * @since 29-11-2020
 */
public class Sorting implements ISort {
	private static int[] numbers;
	private static int number;

	@Override
	public void sort(int[] values) {
		this.numbers = values;
		this.number = values.length;
		quicksort(0, number - 1);
	}

	private static void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[(low + high) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot elment then we exchange the
			// values.
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);

	}

	private static void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		/*int[] array = {23,34, 20, 28, 29};
		Sorting sorting = new Sorting();
		sorting.sort(array);
		for (int k = 0; k < numbers.length; k++) {
			System.out.print(numbers[k]+" ");
		}*/
		/*String str = "工粗糙和监管不力的困扰，危及航空安全u";
		System.out.println("isEnglish " + containsEnglishCharacters(str));
		boolean b = containsChineseCharacters(str);
		System.out.println("is chinese: " + b);*/
		getAllList();
		getList();
		List<String > strings = new CopyOnWriteArrayList<>();
		strings.add("sdsd");
		strings.add("fsdf");
		strings.add("sfsfww");
		strings.add("qeqqw");
		addListToCollection(strings);
		System.out.println(strings);


	}

	private static void addListToCollection(Collection<String> stringList) {
		for (String str: stringList) {
			if ("qeqqw".equals(str)) {
				stringList.add("Great");
			}
		}
		System.out.println(stringList);
	}

	public static boolean isProbablyArabic(String s) {
		if (s.matches("[\\u4E00-\\u9FA5]+")) {
			System.out.println("is Chinese");
			return true;
		}
		if (s.matches("[x0041-x007A]+")) {
			System.out.println("is Chinese");
			return true;
		}
		return false;
	}

	public static Boolean containsChineseCharacters(String InputString) {
		Pattern p = Pattern.compile("[\\u4e00-\\u9FFF]");
		Matcher m = p.matcher(InputString);
		return m.find();
	}

	public static Boolean containsEnglishCharacters(String InputString) {
		Pattern p = Pattern.compile("\\p{IsLatin}");
		Matcher m = p.matcher(InputString);
		return m.find();
	}

	public static CopyOnWriteArrayList getAllList() {
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		copyOnWriteArrayList.addAll(Arrays.asList("saurav", "suraj", "monu"));
		Iterator iterator = copyOnWriteArrayList.iterator();
		System.out.println("before modification ...");
		while (iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		System.out.println("After modification ...");
		copyOnWriteArrayList.add("Gaurav");
		System.out.println(copyOnWriteArrayList);
		return copyOnWriteArrayList;
	}

	public static List<String> getList() {
		List<String> stringList = new CopyOnWriteArrayList<String>();
		stringList.addAll(Arrays.asList("saurav","Ramu","sharat"));
		System.out.println(stringList);
		stringList.add("Happy new");
		System.out.println(stringList);
		return stringList;
	}

}
