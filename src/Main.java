import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String arr[][] = new String[][]{{"1","1","3","b"},{"1","1","3","8"},{"1","1","3","8"},{"1","1","3","8"}};
        try{
            int sum = sumMatrix(arr);
            System.out.println(sum);
        } catch (MyArraySizeException e){
            System.out.println("Неправильный размер матрицы");
        } catch (MyArrayDataException e){
            System.out.println("Ошибка в элементе матрицы.");
            System.out.println("Неправильный символ: " + arr[e.i][e.j]);
        }



    }

    private static int sumMatrix(String[][] arr) throws MyArraySizeException,MyArrayDataException{
        int sum = 0;
        int size = 4;
        if (arr.length != size){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < size; i++){
            if (arr[i].length != size){
                throw new MyArraySizeException();
            }
            for (int j = 0; j < size; j++){
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;

    }
}
