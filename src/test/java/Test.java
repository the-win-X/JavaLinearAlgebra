import net.win_x.javalinearalgebra.matrix.Matrix;

public class Test {
    public static void main(String[] args) {
        Matrix matrix1 = Matrix.of(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix matrix2 = Matrix.identity(3);
        System.out.println(matrix1.dot(matrix2));
    }
}
