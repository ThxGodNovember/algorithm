package array3;

public class MainClass {

    public static void main(String args[]) {
        int[][] array = new int[3][5];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[0][3] = 4;
        array[0][4] = 4;

        array[1][0] = 4;
        array[1][1] = 3;
        array[1][2] = 2;
        array[1][3] = 1;
        array[1][4] = 2;

        array[2][0] = 1;
        array[2][1] = 2;
        array[2][2] = 3;
        array[2][3] = 4;
        array[2][4] = 3;

        int M = array[0].length;
        int N = array.length;
        int min = M > N ? N : M;
        int max = M > N ? M : N;
        /*
        1,2,3,4,4
        4,3,2,1,2
        1,2,3,4,3

        1,2,3,
        4,3,2,
        1,2,3,
        1,2,3,
        */
        int repeatNum = max - min + 1;
        //repeatNum min
        if (M >= N) {
            for (int i = 1; i <= M + (M - N); i++) {
                // 0,0   ,0,1 1,0   0,2 1,1 2,0  0,3 ,1,2 ,2,1 3,0  0,4 1,3 2,2 3,1 4,0
                if (i % 2 != 0) {
                    int m = i;
                    int n = 0;
                    int num = i;
                    //0,0
                    while (n < num) {
                        System.out.println(array[n++][--m]);
                    }
                } else {
                    int m = i;
                    int n = 0;
                    int num = i;
                    //01 10
                    while (n < num) {
                        System.out.println(array[--m][n++]);
                    }
                }
            }
        }

    }
}
