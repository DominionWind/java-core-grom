package gromcode.main.lesson5;

import java.util.Arrays;

public class HomeworkSort {
    public static void main(String[] args) {
        int[] random = {1,20,55,17,-10,-15,-10,95,27,999,-15,14};
        System.out.println(Arrays.toString(sortAscending(random)));
        System.out.println(Arrays.toString(sortDescending(random)));
    }

    public static int[] sortAscending(int[] array) {
        for (int index = 0; index < array.length; index++) {
            /* Предполагаем, что начальный элемент рассматриваемого
             * фрагмента и будет минимальным.
             */
            int min = array[index]; // Предполагаемый минимальный элемент
            int imin = index; // Индекс минимального элемента
            /* Просматриваем оставшийся фрагмент массива и ищем там
             * элемент, меньший предположенного минимума.
             */
            for (int j = index + 1; j < array.length; j++) {
                /* Если находим новый минимум, то запоминаем его индекс.
                 * И обновляем значение минимума.
                 */
                if (array[j] < min) {
                    min = array[j];
                    imin = j;
                }
            }
            /* Проверяем, нашёлся ли элемент меньше, чем стоит на
             * текущей позиции. Если нашёлся, то меняем элементы местами.
             */
            if (index != imin) {
                int temp = array[index];
                array[index] = array[imin];
                array[imin] = temp;
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        for (int index = 0; index < array.length; index++) {
            /* Предполагаем, что начальный элемент рассматриваемого
             * фрагмента и будет минимальным.
             */
            int min = array[index]; // Предполагаемый минимальный элемент
            int imin = index; // Индекс минимального элемента
            /* Просматриваем оставшийся фрагмент массива и ищем там
             * элемент, меньший предположенного минимума.
             */
            for (int j = index + 1; j < array.length; j++) {
                /* Если находим новый минимум, то запоминаем его индекс.
                 * И обновляем значение минимума.
                 */
                if (array[j] > min) {
                    min = array[j];
                    imin = j;
                }
            }
            /* Проверяем, нашёлся ли элемент меньше, чем стоит на
             * текущей позиции. Если нашёлся, то меняем элементы местами.
             */
            if (index != imin) {
                int temp = array[index];
                array[index] = array[imin];
                array[imin] = temp;
            }
        }
        return array;
    }
}
