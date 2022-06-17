package com.company;

public class Main {

    public static void main(String[] args) {

        String[][] testRightValues = {{"1", "3", "5", "7"}, {"2", "4", "6", "8"}, {"1", "3", "5", "7"}, {"1", "3", "5", "7"}};
        String[][] testWrongValues = {{"1", "3", "5", "7"}, {"2", "a", "6", "8"}, {"1", "3", "5", "7"}, {"1", "3", "5", "7"}};
        String[][] testWrongSize = {{"1", "3", "5", "7"}, {"1", "3", "5", "7"}};


        try {
            sumArray(testRightValues);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            sumArray(testWrongValues);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            sumArray(testWrongSize);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


    }

    static int arrLength = 4;

    public static void sumArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        checkSize(arr);
        System.out.println("Сумма элементов массива = " + sumArrayValues(arr));
    }

    public static void checkSize(String[][] arr) throws MyArraySizeException {
        if (arr.length != arrLength) {
            throw new MyArraySizeException("Длина массива не равно 4");
        }

        if (arr[0].length != arrLength) {
            throw new MyArraySizeException("Длина вложенного массива 0 не равно 4");
        }

        if (arr[1].length != arrLength) {
            throw new MyArraySizeException("Длина массива не равно 4");
        }

        if (arr[2].length != arrLength) {
            throw new MyArraySizeException("Длина массива не равно 4");
        }

        if (arr[3].length != arrLength) {
            throw new MyArraySizeException("Длина массива не равно 4");
        }

    }

    public static int sumArrayValues(String[][] arr) throws MyArrayDataException {
        int i = 0;
        int j = 0;
        int result = 0;
        try {
            for (; i < arr.length; i++) {
                j = 0;
                for (; j < arr.length; j++) {
                    result = result + Integer.parseInt(arr[i][j]);

                }
            }


        } catch (NumberFormatException e){
            throw new MyArrayDataException("Адрес ошибки:" + i + " " + j);
        }

        return result;
    }


}


//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
