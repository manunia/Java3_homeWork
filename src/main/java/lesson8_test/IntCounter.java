package lesson8_test;

public class IntCounter {
    public static void main(String[] args) {
        IntCounter intCounter = new IntCounter();
        //String s= "1 2 3 2 3 1 1 1 1 3";
        String s = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5 ";
        intCounter.out(intCounter.counter(intCounter.getMass(s)));
    }

    private static final int N = 20;
    private static int[] mass;

    public int[] getMass(String s) {
        String[] str = s.split(" ");
        mass = new int[str.length];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Integer.parseInt(str[i]);
        }
        return mass;
    }

    public int[] counter(int[] mass) {
        int[] count = new int[N];
        for (int i = 0; i < N; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < N; j++) {
                if (mass[i] == j) {
                    count[j]++;
                }
            }
        }

        return count;
    }

    public int[] out(int[] outMass) {
        for (int i = 0; i < outMass.length; i++) {
            if (outMass[i] !=0) {
                System.out.print(outMass[i] + " ");
            }
        }
        return outMass;
    }


}
