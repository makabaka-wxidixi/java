/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-31 20:57
 */
public class sparseArr {

    private static int ROW = 9;
    private static int LIN = 9;

    public static void main(String[] args) {
        //将普通数组转化为稀疏数组
        //1.先生成一个普通数组，并输入数据
        System.out.println("原始数组：");
        int[][] arr = new int[ROW][LIN];
        arr[3][5] = 1;
        arr[2][7] = 12;
        arr[4][1] = 32;
        for (int[] row : arr) {
            for (int lin : row) {
                System.out.print(lin + "\t");
            }
            System.out.println();
        }
        //遍历数组，看有几个非0数据
        int sum = 0;
        for (int[] row : arr) {
            for (int lin : row) {
                if (lin != 0)
                    sum++;
            }
        }
        System.out.println("非零数据个数：" + sum);
        //创建稀疏数组，并且录入第一行数据
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = ROW;
        sparseArr[0][1] = LIN;
        sparseArr[0][2] = sum;
        //遍历数组，录入非零数
        int count = 0;
        for (int row = 0; row < ROW; row++) {
            for (int lin = 0; lin < LIN; lin++) {
                if (arr[row][lin] != 0) {
                    count++;
                    sparseArr[count][0] = row;
                    sparseArr[count][1] = lin;
                    sparseArr[count][2] = arr[row][lin];
                }
            }
        }
        System.out.println("-----------------");
        //遍历稀疏数组
        System.out.println("稀疏数组");
        for (int[] row : sparseArr) {
            for (int lin : row) {
                System.out.print(lin + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------");
        System.out.println("展开的数组");
        //将稀疏数组展开为普通数组
        int[][] Arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            Arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] row : Arr) {
            for (int lin : row) {
                System.out.print(lin + "\t");
            }
            System.out.println();
        }

    }
}
