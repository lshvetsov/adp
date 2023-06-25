package algorithms;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numeric {

    private static final Random random = new Random();
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {

        generateRandoms();
        linearCongruentialGenerators(0);
        calculateGCD(1512, 1988, false);
        calculateLCM(1512, 1988);
        primeFactorization(18952);
        findPrimes(IntStream.rangeClosed(1, 956).boxed().collect(Collectors.toCollection(ArrayList::new)));
        checkIfPrime(9857);
    }

    public static void generateRandoms() {

        System.out.println("------ Random generators -------");
        System.out.println(random.nextInt());
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());   // multithreaded environment
        System.out.println(secureRandom.nextInt());   // cryptographic algorithms
        System.out.println("------------------------------------------------------");

    }
    public static void linearCongruentialGenerators(int x) {

        int i = 0;
        int a = 13;
        int b = 23;
        int m = 11;
        int y = (x * a + b) % m;

        System.out.println("------- LCG -------");
        System.out.println("First iteration");

        while (i < 10) {
            System.out.println(y);
            if (y == 0) System.out.println("Next iteration");
            y = (y * a + b) % m;
            i++;
        }

        System.out.println("----------------------------------------------------------");

    }
    public static long calculateGCD(long a, long b, boolean util) {

        if (!util) System.out.printf("Calculating GCD with the Euclid's algorithms for %s and %s....%n", a, b);

        long reminder = 0;

        while (b !=0) {

            reminder = a % b;
            a = b;
            b = reminder;

        }

        if (!util) {
            System.out.println("GCD = " + a);
            System.out.println("---------------------------------------------");
        }
        return a;
    }
    public static void calculateLCM(long a, long b) {

        System.out.printf("Calculating LCM for %s and %s....%n", a, b);
        System.out.println(a / calculateGCD(a, b, true) * b);
        System.out.println("---------------------------------------------------------------");

    }
    public static void primeFactorization(int n) {

        System.out.printf("Factorizing the number %s .....%n", n);

        List<Integer> factors = new LinkedList<>();

        int stop = (int) Math.sqrt(n);
        int factor = 2;

        do {

            while (n % factor == 0) {
                factors.add(factor);
                n = n / factor;
            }

            ++factor;

        } while (factor < stop);

        if (n != 1) factors.add(n);

        System.out.print("Factors are: ");
        factors.forEach(f -> System.out.print(f + " "));
        System.out.println();
        System.out.println("---------------------------------------------------------------");
    }
    public static void findPrimes(List<Integer> numbers) {

        if (numbers == null) {
            System.out.println("Wrong input");
            return;
        }

        System.out.println("Finding primes ..... ");

        int stop = (int) Math.sqrt(numbers.get(numbers.size()-1));
        int factor = 2;
        List<Integer> primes = new LinkedList<>(List.of(1));

        while (factor < stop) {
            final int currentF = factor;
            if (numbers.contains(factor)) primes.add(factor);
            numbers.removeIf(x -> x % currentF == 0);
            factor++;
        }

        System.out.println("Primes are: ");
        primes.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("-----------------------------------------------");

    }
    /**
     * Is number prime? Based on the Fermat little theorem
     * @param number number to check its primeness
     */
    public static void checkIfPrime(int number) {

        System.out.printf("Checking if the number %s is prime ....%n", number);

        if (number % 2 == 0 && number != 2) {
            System.out.println("The answer is No");
        }

        if (number < 3) {
            System.out.println("The answer is Yes");
        }

        int numberOfChecks = 5;
        List<Boolean> checks = new LinkedList<>();

        for (int i = 0; i < numberOfChecks; i++) {
            int rand = secureRandom.nextInt(number);

            long a = Numeric.power(rand, number - 1, number);
            int i1 = 1 % number;

            checks.add(a == i1);
        }

        String result = checks.contains(false) ? "No" : "Yes";

        System.out.println("The answer is " + result);

    }
    private static long power(int number, int extend, int mod) {
        long result = 1;

        while (extend > 0) {
            if (extend % 2 == 1) {
                result = (result * number) % mod;
                extend--;
            } else {
                number = (number * number) % mod;
                extend /= 2;
            }
        }
        return result;
    }

}
