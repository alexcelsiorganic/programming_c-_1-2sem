import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;



public class Main {

    static class Top implements Comparator<Top> {

        public Top() {
            this.num = 0;
            this.distance = 0;
        }

        public Top(int num_2, int distance) {
            this.num = num_2;
            this.distance = distance;
        }

        public int compare(Top top_1, Top top_2) {
            return Integer.compare(top_1.distance, top_2.distance);
        }

        public int getDistance() {
            return this.distance;
        }

        public int getNum() {
            return this.num;
        }


        private final int num;
        private final int distance;
    }


    public static void Deikstr(ArrayList<ArrayList<Top>> list, int source, int end, int n) {
        Set<Integer> set = new HashSet<Integer>();
        PriorityQueue<Top> queue = new PriorityQueue<Top>(n, new Top());
        ArrayList<Integer> way = new ArrayList<>();
        int[] tops = new int[n];
        int[] prevs = new int[n];
        Arrays.fill(tops, 22222);
        Arrays.fill(prevs, -1);
        tops[source] = 0;
        queue.add(new Top(source, 0));
        while (!queue.isEmpty()) {
            Top top_min = queue.remove();
            int min = top_min.getNum();
            int cur_d = top_min.getDistance();
            if (cur_d > tops[min])
                continue;
            int newDistance = -1;
            for (int i = 0; i < list.get(min).size(); i++) {
                Top a = list.get(min).get(i);
                int num = a.getNum();
                int distance = a.getDistance();
                if (!set.contains(a.getNum())) {
                    newDistance = tops[min] + distance;
                    if (tops[a.getNum()] > newDistance) {
                        tops[a.getNum()] = newDistance;
                        prevs[a.getNum()] = min;
                    }
                    queue.add(new Top(a.getNum(), tops[a.getNum()]));
                }
                set.add(min);
            }
        }
        int cur = end;
        way.add(cur + 1);
        while (prevs[cur] != -1) {
            cur = prevs[cur];
            way.add(cur + 1);
        }
        int a = way.get(way.size() - 1);
        if (way.size() != 0 && a == source + 1) {
            for (int i = way.size() - 1; i >= 0; i--) {
                System.out.print(way.get(i) + " ");
            }
        }
        else {
            System.out.println(-1);
        }
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader sc = new BufferedReader(new FileReader("input.txt"))) {
            String[] array = sc.readLine().split(" ");
            int N = Integer.parseInt(array[0]);
            int S = Integer.parseInt(array[1]) - 1;
            int F = Integer.parseInt(array[2]) - 1;
            ArrayList<ArrayList<Main.Top>> top = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                top.add(new ArrayList<Main.Top>());
                String[] line = sc.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(line[j]) != -1 && j != i) {
                        top.get(i).add(new Top(j, Integer.parseInt(line[j])));
                    }
                }
            }
            Deikstr(top, S, F, N);
        }
    }
}

