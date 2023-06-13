import java.util.*;

public class Main {

        public static void main(String[] args) {
            int[][] matrix = {
                    {5, 3, 8, 2},
                    {9, 4, 1, 7},
                    {6, 2, 0, 3},
                    {1, 5, 4, 9}
            };

            sort(matrix);

            // Вывод измененной матрицы
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }

        public static int[][] sort(int[][] matrix) {
            int sum = 0;
            int count = 0;

            // Вычисление суммы и количества элементов в матрице
            for (int[] row : matrix) {
                for (int value : row) {
                    sum += value;
                    count++;
                }
            }
            double average = (double) sum / count;

            List<Integer> aboveAverage = new ArrayList<>();
            List<Integer> belowAverage = new ArrayList<>();

            // Заполнение списков значениями выше и ниже среднего
            for (int[] row : matrix) {
                for (int value : row) {
                    if (value > average) {
                        aboveAverage.add(value);
                    } else if (value < average) {
                        belowAverage.add(value);
                    }
                }
            }

            // Сортировка списков
            Collections.sort(aboveAverage, Collections.reverseOrder());
            Collections.sort(belowAverage);

            int aboveIndex = 0;
            int belowIndex = 0;

            // Замена значений в матрице
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int value = matrix[i][j];
                    if (value > average) {
                        matrix[i][j] = aboveAverage.get(aboveIndex);
                        aboveIndex++;
                    } else if (value < average) {
                        matrix[i][j] = belowAverage.get(belowIndex);
                        belowIndex++;
                    }
                }
            }
            return matrix;
        }

}
