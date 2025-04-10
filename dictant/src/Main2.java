import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.nanoTime;

public static int[] createSortedArray(int size) {
    int[] massive = new int[size];
    for (int i = 0; i < size; i++) {
        massive[i] = i + 1;
    }
    System.out.println("По возрастанию: " + Arrays.toString(massive));
    return massive;
}

public static int[] createReverseSortedArray(int size) {
    int[] massive = new int[size];
    for (int i = 0; i < size; i++) {
        massive[i] = size - i;
    }
    System.out.println("По убыванию: " + Arrays.toString(massive));
    return massive;
}

public static int[] createPartiallySortedArray(int size, double sortedPercentage) {
    int[] massive = new int[size];
    int sortedPart = (int) (size * sortedPercentage);
    for (int i = 0; i < sortedPart; i++) {
        massive[i] = i + 1;
    }
    for (int i = sortedPart; i < size; i++) {
        massive[i] = (int) (Math.random() * 100);
    }
    System.out.println("Отсортированный "+ (int) (sortedPercentage*100) + "% : " + Arrays.toString(massive));
    return massive;
}
public static void print(int[] mass){
    System.out.println(Arrays.toString(mass));
}
public static Param search(int[] mass,int num){
    int compare = 0;
    long start = nanoTime();
    int find = -1;
    for(int i = 0; i < mass.length; i++){
        compare ++;
        if(mass[i] == num){
            find = i;
            break;
        }
    }
    long end = nanoTime();
    long time = end - start;
    if(find == -1){
        System.out.println("Линейный: Данного числа нет в массиве");
    }
    else{
        System.out.println("Линейный: Первое число " + num + " найдено на позции " + find);
    }
    return new Param(time, compare);
}
public static Param binarySearch(int[] mass, int num) {
    int repeat = 0;
    int left = 0, right = mass.length - 1;
    int find = -1;
    long start = nanoTime();

    while (left <= right) {
        repeat++;
        int middle = left + (right - left) / 2;
        if (mass[middle] == num) {
            find = middle;
            break;
        } else if (mass[middle] < num) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    long end = nanoTime();
    long time = end - start;
    if(find == -1){
        System.out.println("Бинарный: Данного числа нет в массиве");
    }
    else{
        System.out.println("Бинарный: Первое число " + num + " найдено на позции " + find);
    }
    return new Param(time, 0, repeat);
}

public static void printResultsTable(int[] mass1, int[] mass2, int[] mass3, int[] mass4, int[] mass5, int num) {
    int[] massive1 = Arrays.copyOf(mass1, mass1.length);
    int[] massive2 = Arrays.copyOf(mass2, mass2.length);
    int[] massive3 = Arrays.copyOf(mass3, mass3.length);
    int[] massive4 = Arrays.copyOf(mass4, mass4.length);
    int[] massive5 = Arrays.copyOf(mass5, mass5.length);

    Param resultS1 = search(massive1,num);
    Param resultS2 = search(massive2,num);
    Param resultS3 = search(massive3,num);
    Param resultS4 = search(massive4,num);
    Param resultS5 = search(massive5,num);

    System.out.println("\nРезультаты поиска:");
    System.out.println("-----------------------------------------------------------------------------");
    System.out.println("| Линейный             | Время (нс)  | Сравнение (шт)   |");
    System.out.printf("| %-20s | %-11d | %-16d |\n", "По возрастанию", resultS1.time, resultS1.compare);
    System.out.printf("| %-20s | %-11d | %-16d |\n", "По убыванию", resultS2.time, resultS2.compare);
    System.out.printf("| %-20s | %-11d | %-16d |\n", "25%", resultS3.time, resultS3.compare);
    System.out.printf("| %-20s | %-11d | %-16d |\n", "50%", resultS4.time, resultS4.compare);
    System.out.printf("| %-20s | %-11d | %-16d |\n", "75%", resultS5.time, resultS5.compare);
    System.out.println("-----------------------------------------------------------------------------\n");

    resultS1 = binarySearch(massive1,num);
    resultS2 = binarySearch(massive2,num);
    resultS3 = binarySearch(massive3,num);
    resultS4 = binarySearch(massive4,num);
    resultS5 = binarySearch(massive5,num);

    System.out.println("\nРезультаты поиска:");
    System.out.println("-----------------------------------------------------------------------------");
    System.out.println("| Бинарный             | Время (нс)  | Повторение цикла |");
    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("| %-20s | %-10d | %-16d |\n", "По возрастании", resultS1.time, resultS1.repeat);
    System.out.printf("| %-20s | %-10d | %-16d |\n", "По убыванию", resultS2.time, resultS2.repeat);
    System.out.printf("| %-20s | %-10d | %-16d |\n", "25%", resultS3.time, resultS3.repeat);
    System.out.printf("| %-20s | %-10d | %-16d |\n", "50%", resultS4.time, resultS4.repeat);
    System.out.printf("| %-20s | %-10d | %-16d |\n", "75%", resultS5.time, resultS5.repeat);
    System.out.println("-----------------------------------------------------------------------------\n");
}
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите размер массива: ");
    int size = scanner.nextInt();
    if(size>0) {
        int[] sortMass = createSortedArray(size);
        int[] reverseMass = createReverseSortedArray(size);
        int[] partMass25 = createPartiallySortedArray(size, 0.25);
        int[] partMass50 = createPartiallySortedArray(size, 0.5);
        int[] partMass75 = createPartiallySortedArray(size, 0.75);

        System.out.print("Введите какое число нужно найти: ");
        int num = scanner.nextInt();

        printResultsTable(sortMass, reverseMass,partMass25, partMass50, partMass75, num);
    }
    else{
        System.out.println("Размер массива 0");
    }
}
