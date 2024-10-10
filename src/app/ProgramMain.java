package app;

public class ProgramMain {

    // Метод для сортування масиву методом вставки
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Метод для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Метод для підрахунку кількості разів, коли число зустрічається в масиві
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    // Метод для заповнення масиву випадковими числами
    public static void fillArrayWithRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }
    }

    // Метод для виведення масиву на екран
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws java.io.IOException {
        int[] array = new int[15];

        fillArrayWithRandomNumbers(array);

        System.out.println("Початковий вигляд масиву:");
        printArray(array);

        insertionSort(array);

        System.out.println("Відсортований масив:");
        printArray(array);

        System.out.print("Введіть число для пошуку: ");
        StringBuilder input = new StringBuilder();
        int character;
        while ((character = System.in.read()) != '\n') {
            input.append((char) character);
        }
        int target = Integer.parseInt(input.toString().trim());

        int index = binarySearch(array, target);

        if (index != -1) {
            int occurrences = countOccurrences(array, target);
            System.out.println("Індекс числа " + target + " у відсортованому масиві: " + index);
            System.out.println("Число " + target + " зустрічається " + occurrences + " раз(ів) у масиві.");
        } else {
            System.out.println("Число " + target + " не знайдено.");
        }
    }
}