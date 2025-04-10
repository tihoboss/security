import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.nanoTime;

public class Main3 {
    static final int SIZE20 = 20;
    static final int SIZE500 = 500;
    static final int SIZE1000 = 1000;
    static final int SIZE3000 = 3000;
    static final int SIZE5000 = 5000;
    static final int SIZE10000 = 10000;

    public static int[] createMassive(int size) {
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        return mass;
    }

    public static void print(int[] mass) {
        System.out.println(Arrays.toString(mass));
    }

    public static Param barierSearch(int[] mass, int num) {
        int compare = 0;
        long start = nanoTime();
        int find = -1;
        int last = mass[mass.length - 1];
        mass[mass.length - 1] = num;
        int i = 0;
        while (mass[i] != num) {
            compare++;
            i++;
        }
        mass[mass.length - 1] = last;
        if (i < mass.length - 1 || last == num) {
            find = i;
        }
        long end = nanoTime();
        long time = end - start;
        if (find == -1) {
            System.out.println("Данного числа нет в массиве");
        } else {
            System.out.println("Первое число " + num + " найдено на позиции " + find);
        }
        return new Param(time, compare);
    }

    public static void printResultsTable(int[] mass1, int[] mass2, int[] mass3, int[] mass4, int[] mass5, int[] mass6, int num) {
        int[] massive1 = Arrays.copyOf(mass1, mass1.length);
        int[] massive2 = Arrays.copyOf(mass2, mass2.length);
        int[] massive3 = Arrays.copyOf(mass3, mass3.length);
        int[] massive4 = Arrays.copyOf(mass4, mass4.length);
        int[] massive5 = Arrays.copyOf(mass5, mass5.length);
        int[] massive6 = Arrays.copyOf(mass6, mass6.length);

        Param result1 = barierSearch(massive1, num);
        Param result2 = barierSearch(massive2, num);
        Param result3 = barierSearch(massive3, num);
        Param result4 = barierSearch(massive4, num);
        Param result5 = barierSearch(massive5, num);
        Param result6 = barierSearch(massive6, num);

        System.out.println("\nРезультаты поиска:");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| Кол-во элементов     | Время (нс)  | Сравнения |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass1.length, result1.time, result1.compare);
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass2.length, result2.time, result2.compare);
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass3.length, result3.time, result3.compare);
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass4.length, result4.time, result4.compare);
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass5.length, result5.time, result5.compare);
        System.out.printf("| %-20d | %-10d | %-10d |\n", mass6.length, result6.time, result6.compare);
    }

    public static void main(String[] args) {
        int[] mass1 = createMassive(SIZE20);
        print(mass1);
        int[] mass2 = createMassive(SIZE500);
        int[] mass3 = createMassive(SIZE1000);
        int[] mass4 = createMassive(SIZE3000);
        int[] mass5 = createMassive(SIZE5000);
        int[] mass6 = createMassive(SIZE10000);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите какое число нужно найти: ");
        int num = scanner.nextInt();
        printResultsTable(mass1, mass2, mass3, mass4, mass5, mass6, num);
    }
}
