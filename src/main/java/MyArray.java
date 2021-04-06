import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyArray {
    public static void main(String[] args) {
        final MyArray myArray = new MyArray();
        myArray.method1();
        myArray.method2();


    }

    public void method1() {

        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1); //заполнить массив value (1)
        //System.out.println(Arrays.toString(arr));
        SimpleDateFormat sdf = null; //дата
        sdf = new SimpleDateFormat("HH:mm:ss.S"); //формат даты
        String text = sdf.format(new Date()); //дата
        System.out.println(text); //дата
        long a = System.currentTimeMillis(); // время
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        //System.out.println(Arrays.toString(arr));
        String text2 = sdf.format(new Date());
        System.out.println(text2);
        System.out.println("Время работы метода 1 - " + Thread.currentThread().getName() + ": "+ (System.currentTimeMillis() - a));
    }

    public void method2() {


        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        //(массив-источник, откуда начинаем брать данные из массива-источника,
        //массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек
        //копируем
        SimpleDateFormat sdf = null;
        sdf = new SimpleDateFormat("HH:mm:ss.S");
        long a = System.currentTimeMillis();
        String text = sdf.format(new Date());
        System.out.println(text);

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);


        MyClass myClass1 = new MyClass("1-й вспомогательный", arr1);
        MyClass myClass2 = new MyClass("2-й вспомогательный", arr2);


        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        String text2 = sdf.format(new Date());
        System.out.println(text2);
        System.out.println("Время работы метода 2 - " + Thread.currentThread().getName() + ": "+ (System.currentTimeMillis() - a));

        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(arr));

         */



    }


}
