package net.win_x.javalinearalgebra.matrix;

import java.util.Arrays;

public class Matrix {
    private final double[][] values;

    private Matrix(double[][] values) {
        this.values = values;
    }

    public static Matrix of(double[][] values) {
        return new Matrix(values);
    }

    public static Matrix identity(int size) {
        double[][] values = new double[size][size];
        for (int i = 0; i < size; i++) {
            values[i][i] = 1;
        }
        return new Matrix(values);
    }

    public static Matrix zeroes(int rows, int cols) {
        double[][] values = new double[rows][cols];
        return new Matrix(values);
    }

    public int rows() {
        return values.length;
    }

    public int cols() {
        return values[0].length;
    }

    public void set(int row, int col, int value) {
        values[row][col] = value;
    }

    public double get(int row, int col) {
        return values[row][col];
    }

    public Matrix dot(Matrix other) {
        if (cols() != other.rows()) {
            throw new IllegalArgumentException("Matrices do not have compatible dimensions");
        }
        double[][] result = new double[rows()][other.cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < other.cols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols(); k++) {
                    sum += values[i][k] * other.get(k, j);
                }
                result[i][j] = sum;
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices do not have compatible dimensions");
        }

        double[][] result = new double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = values[i][j] * other.get(i, j);
            }
        }

        return new Matrix(result);
    }

    public Matrix add(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices do not have compatible dimensions");
        }

        double[][] result = new double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = values[i][j] + other.get(i, j);
            }
        }

        return new Matrix(result);
    }

    public Matrix sub(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices do not have compatible dimensions");
        }

        double[][] result = new double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = values[i][j] - other.get(i, j);
            }
        }

        return new Matrix(result);
    }

    public Matrix div(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices do not have compatible dimensions");
        }

        double[][] result = new double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = values[i][j] / other.get(i, j);
            }
        }

        return new Matrix(result);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Matrix of size " + rows() + "x" + cols() + "\nContents:\n");
        for (double[] row : values) {
            str.append(Arrays.toString(row)).append("\n");
        }

        return str.toString();
    }
}
