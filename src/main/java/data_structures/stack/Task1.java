package data_structures.stack;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    private Result() {}

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Deque<Integer> stack1 = Result.transformToCumulative(h1);
        Deque<Integer> stack2 = Result.transformToCumulative(h2);
        Deque<Integer> stack3 = Result.transformToCumulative(h3);

        int maxHeight = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {

            int stackHeight1 = stack1.peek();
            int stackHeight2 = stack2.peek();
            int stackHeight3 = stack3.peek();

            if (stackHeight1 == stackHeight2 && stackHeight2 == stackHeight3)
                return stackHeight1;

            if (stackHeight1 > stackHeight2 || stackHeight1 > stackHeight3)
                stack1.pop();
            else if (stackHeight2 > stackHeight1 || stackHeight2 > stackHeight3)
                stack2.pop();
            else stack3.pop();
        }

        return maxHeight;

    }

    private static Deque<Integer> transformToCumulative(final List<Integer> input) {

        final Deque<Integer> result = new ArrayDeque<>();

        if (input == null || input.isEmpty()) return result;

        int cumulative = 0;

        for (int i  = input.size()-1; i >= 0; i--) {
            cumulative += input.get(i);
            result.push(cumulative);
        }

        return result;

    }

}

public class Task1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "C:\\Projects\\PetProjects\\Algorithms_DataStructures\\src\\main\\resources\\output.txt"
        ));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        System.out.println(result);
    }
}

