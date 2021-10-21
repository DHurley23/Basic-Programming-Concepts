public class SummativeSums {

    public static void main(String[] args){
        int[] values1 ={ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] values2 = { 999, -60, -77, 14, 160, 301 };
        int[] values3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 };
        System.out.println("Array Sum 1: " + addArrayValues(values1));
        System.out.println("Array Sum 2: " + addArrayValues(values2));
        System.out.println("Array Sum 3: " + addArrayValues(values3));
    }

    private static int addArrayValues(int[] inputArray){
        int total = 0;
        for (int value : inputArray) {
            total += value;     //adding each value to a total counter
        }
        return total;
    }
}
