import java.util.concurrent.*;

public class MaxValueParallel {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] vetor = {12, 25, 32, 45, 21, 29, 36, 87, 45, 63, 29, 55, 59, 10, 15};

        int[][] vetores = new int[4][];
        vetores[0] = new int[4];
        vetores[1] = new int[4];
        vetores[2] = new int[4];
        vetores[3] = new int[3];

        for (int i = 0; i < vetor.length; i++) {
            vetores[i / 4][i % 4] = vetor[i];
        }

        ExecutorService service = Executors.newFixedThreadPool(4);

        Future<Integer> f1 = service.submit(() -> {
            int max = findMax(vetores[0]);
            printSliceAndMax(vetores[0], max);
            return max;
        });

        Future<Integer> f2 = service.submit(() -> {
            int max = findMax(vetores[1]);
            printSliceAndMax(vetores[1], max);
            return max;
        });

        Future<Integer> f3 = service.submit(() -> {
            int max = findMax(vetores[2]);
            printSliceAndMax(vetores[2], max);
            return max;
        });

        Future<Integer> f4 = service.submit(() -> {
            int max = findMax(vetores[3]);
            printSliceAndMax(vetores[3], max);
            return max;
        });

        int maxGeral = Math.max(Math.max(f1.get(), f2.get()), Math.max(f3.get(), f4.get()));
        System.out.println("O valor máximo é " + maxGeral);

        service.shutdown();
    }

    public static int findMax(int[] slice) {
        int max = slice[0];
        for (int value : slice) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void printSliceAndMax(int[] slice, int max) {
        System.out.print("Slice: [");
        for (int i = 0; i < slice.length; i++) {
            System.out.print(slice[i] + (i == slice.length - 1 ? "" : ", "));
        }
        System.out.println("], Thread: " + Thread.currentThread().getName() + ", Máximo: " + max);
    }
}
