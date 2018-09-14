package zero;

import java.util.Scanner;

public class StackCups {

    static class Stacks {
        private final int[] height;
        private final int[] count;
        private int size = 0;

        public Stacks(int maxN) {
            height = new int[maxN];
            count = new int[maxN];
        }
        public int countStacks() {
            return size;
        }
        public void makeNew() {
            if (size > 0 && height[size - 1] == 1) {
                ++count[size - 1];
            } else {
                height[size] = 1;
                count[size] = 1;
                ++size;
            }
        }
        public void addToSmallest() {
            if (size == 0) {
                makeNew();
            } else {
                if (count[size - 1] == 1) {
                    ++height[size - 1];
                    if (size > 1 && height[size - 2] == height[size - 1]) {
                        --size;
                        count[size - 1] += count[size];
                        count[size] = 0;
                        height[size] = 0;
                    }
                } else {
                    if (size > 1 && height[size - 2] == height[size - 1] + 1) {
                        ++count[size - 2];
                        --count[size - 1];
                    } else {
                        count[size] = count[size - 1] - 1;
                        height[size] = height[size - 1];
                        count[size - 1] = 1;
                        ++height[size - 1];
                        ++size;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        try (EdxIO io = EdxIO.create()) {
//            int n = io.nextInt();
//            Stacks ds = new Stacks(n);
//            for (int i = 0; i < n; ++i) {
//                if (io.nextInt() == 0) {
//                    ds.addToSmallest();
//                } else {
//                    ds.makeNew();
//                }
//            }
//            io.println(ds.size);
//            for (int i = 0; i < ds.size; ++i) {
//                io.print(ds.height[i]).print(' ').println(ds.count[i]);
//            }
//        }

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Stacks ds = new Stacks(n);
        for (int i = 0; i < n; ++i) {
            int k = s.nextInt();
                if (k == 0) {
                    ds.addToSmallest();
                } else {
                    ds.makeNew();
                }
            }
        System.out.println(ds.size);
            for (int i = 0; i < ds.size; ++i) {
                System.out.println(ds.height[i]+" "+ds.count[i]);
            }

    }
}
