package core;

import java.util.Scanner;
//В квадратной матрице определить максимальный и минимальные
//элементы. Если таких элементов несколько, то максимальный определяется
//по наибольшей сумме своих индексов, минимальный – по наименьшей.
public class Part3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array = new int[2][2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.println("Введите ячейку " + i + " " + j);
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int Max = array[0][0];
        int Min = array[0][0];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j <2; j++)
            {
                if(Min > array[i][j])
                {
                    Min = array[i][j];
                }
                if( Max< array[i][j])
                {
                    Max = array[i][j];

                }
            }
        }
        System.out.println("Минимальное значение в массиве " +Min);
        System.out.println("Максимальное значение в массиве " + Max);
    }
}
