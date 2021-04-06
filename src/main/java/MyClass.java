
public class MyClass extends  Thread {
    private float[] arr;



    public MyClass(String name, float[] arr) {
        super();
        setName(name);
        this.arr = arr;
        //System.out.println("Создан поток: " + getName());
        start();
    }


    @Override
    public void run() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
            //System.out.println(Arrays.toString(arr));
        }
        System.out.println("Время работы потока - " + getName() + ": "+ (System.currentTimeMillis() - a));
    }

}
