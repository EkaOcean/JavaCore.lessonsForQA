package lesson2;

public class Main {

        private static final int array_size = 4;

        public static void main(String[] args) {
            String[][] correctArray = new String[][] {{"9", "0", "10", "0"}, {"0", "0", "0", "10"}, {"0", "10", "0", "0"}, {"10", "0", "0", "0"}};
            String[][] wrongSizeArray = new String[][] {{"56", "32", "1", "3"}, {"6", "14", "19", "58"}, {"1", "2", "15", "1"}};
            String[][] wrongDataArray = new String[][] {{"7", "21", "1", "2"}, {"12", "7", "абв", "8"}, {"14", "7", "8", "18"}, {"15", "6", "5", "1"}};

            try {
                System.out.println(sum(correctArray));
                System.out.println(sum(wrongSizeArray));

            }  catch (MyArraySizeException | MyArrayDataException ex){
                System.out.println(ex.getMessage());
            }
            try {
                System.out.println(sum(wrongDataArray));
            }  catch (MyArraySizeException | MyArrayDataException ex){
                System.out.println(ex.getMessage());
            }
        }

        private static String sum(String[][] _array) throws MyArraySizeException, MyArrayDataException {
            checkSizeArray(_array);
            checkIntsArray(_array);
            return "Сумма элементов: " + _sum(_array);
        }

        private static int _sum(String[][] _array) {
            int result = 0;
            for (String[] strings : _array) {
                for (String string : strings) {
                    result += (int) Integer.parseInt(string);
                }
            }
            return result;
        }

        private static void checkIntsArray(String[][] _array) throws MyArrayDataException {
            int row;
            int col;
            for (row = 0; row < _array.length; row++) {
                for (col = 0; col < _array[row].length; col++) {
                    try {
                        Integer.parseInt(_array[row][col]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("\nОшибка данных массива в позиции: " + row+","+ col + ".");
                    }
                }
            }
        }

        private static void checkSizeArray(String[][] _array) throws MyArraySizeException {
            if (_array.length != array_size) {
                throw new MyArraySizeException("\nОшибка размера массива. Нужный размер: 4x4.");
            }
            for (String[] strings : _array) {
                if (strings.length != array_size) {
                    throw new MyArraySizeException("\nОшибка размера массива. Нужный размер: 4x4.");
                }
            }
        }
}
