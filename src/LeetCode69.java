public class LeetCode69 { //Sqrt(x)
/*Dado um inteiro não negativo x, retorna a raiz quadrada de x arredondada para baixo para o inteiro mais próximo. O inteiro retornado também deve ser não negativo.*/    public static int mySqrt(int x) {
        double guess = (x / 2);

        return newtonRaphsonIteration(guess, x, 0);

    }

    private static int newtonRaphsonIteration(double guess, int goal, int iterationCounter) {
        double y = guess * guess;
        iterationCounter++;

        if (goal < 1)
            return 0;
        else if (goal < 4)
            return 1;



      /*  if ((y >= goal && (y - 2 * guess + 1) < goal)) {
            System.out.println(iterationCounter);
            return (int) Math.floor(guess);
        }*/

        if (Math.abs(y - goal) < 1) {
            System.out.println(iterationCounter);
            return (int) Math.floor(guess);

        } else
            return newtonRaphsonIteration((guess + goal / guess) / 2, goal, iterationCounter);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(mySqrt(i));
        }
    }

}
