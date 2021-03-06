package by.it.seledtsova.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {


    private final double[][] arrayValues;
    private double[][] value;


    public Matrix(double[][] value) {
        this.arrayValues = copyMatrix(value);
    }

    public Matrix(String strValue) {
        this(new double[][]{{1, 2}, {3, 4}}); //stub
    }

    public double[][] getArrayValues() {
        return arrayValues;
    }

    @Override
    protected double[] getValues() {
        return new double[0];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(arrayValues).replace("[", "{").replace("]", "}");
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(arrayValues);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] second = ((Matrix) other).arrayValues;
            double[][] res = copyMatrix(arrayValues);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + second[i][j];
                }
            }
            return new Matrix(res);
        }

        return super.add(other);
    }

    private double[][] copyMatrix(double[][] value) {
        double[][] resust = new double[value.length][0];
        for (int i = 0; i < resust.length; i++) {
            resust[i] = Arrays.copyOf(value[i], value[i].length);
        }
        return resust;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[arrayValues.length][0];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue(); // к каждому элементу этого массива - скаляр и добавили геттер для велью
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] second = ((Matrix) this).arrayValues;
            double[][] res = copyMatrix(arrayValues);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] -= second[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[arrayValues.length][0];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue(); // к каждому элементу этого массива * скаляр и добавили геттер для велью
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] second = ((Matrix) this).arrayValues;
            double[][] res = copyMatrix(arrayValues); // если к матрице прибавляется тоже матрицу
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < second[0].length; j++) {
                    for (int k = 0; k < second.length; k++) {
                        res[i][j] += res[i][k] * second[k][j];
                    }
                }
            }

            return new Matrix(res);
        }
        return super.mul(other);
    }


}

