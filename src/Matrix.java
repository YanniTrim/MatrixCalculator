import java.util.Scanner;
public class Matrix {

    private int rowCount;
    private int colCount;
    private int[][] matrix;

    public Matrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        matrix = new int[rowCount][colCount];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void matrixFiller() {

        Scanner inputer = new Scanner(System.in);
        for (int i = 0; i < this.rowCount; i++) {
            System.out.println("Row " + (i+1) + " values (separate with spaces):");
            String rowVals = inputer.nextLine();
            String[] rowStrings = rowVals.split(" ");
            if(rowStrings.length != colCount) {
                System.out.println("Value mismatch");
                break;
            }
            for (int j = 0; j < rowStrings.length; j++) {
                matrix[i][j] = Integer.parseInt(rowStrings[j]);
            }
        }
    }

    public void display() {
        for (int i = 0; i < rowCount; i++) {
            System.out.print("[");
            for (int j = 0; j < colCount; j++) {
                System.out.print("["+this.matrix[i][j]+"]");
            }
            System.out.println("]");
        }
    }

    public void transpose() {
        Matrix tranposed = new Matrix(colCount, rowCount);
        for (int i = 0; i < rowCount; i++) {        //iterate through rows
            for (int j = 0; j < colCount; j++) {    //iterate through columns
                tranposed.matrix[j][i] = this.matrix[i][j]; // put values in new matrix that have flipped row and column indices
            }
        }
        tranposed.display();
    }

    public static Matrix builder() {             // Creates new matrix
        Scanner inputer = new Scanner(System.in);
        System.out.println("How many rows: ");
        int rowInput = inputer.nextInt();
        System.out.println("How many columns: ");
        int columnInput = inputer.nextInt();
        Matrix m = new Matrix(rowInput, columnInput); // Makes an empty matrix based on row and column inputs
        m.matrixFiller(); // calls method to fill in values of matrix
        m.display();
        return m;

    }

    public Matrix add(Matrix m2) {
        if (this.getRowCount() != m2.getRowCount() && this.getColCount() != m2.getColCount()) { // if not same size
            System.out.println("ERROR - Matrix of different sizes");
            return null;
        }
        Matrix added = new Matrix(this.getRowCount(), this.getColCount()); // builds new matrix
        for (int i = 0; i < this.getRowCount(); i++) {
            for (int j = 0; j < this.getColCount(); j++) {
                added.getMatrix()[i][j] = this.getMatrix()[i][j] + m2.getMatrix()[i][j]; //adding
            }
        }
        added.display();
        return added;
    }

    public Matrix multiply(Matrix m2) {
        if (this.getColCount()!=m2.getRowCount()) {
            System.out.println("ERROR - Matrices not compatible");
            return null;
        }
        Matrix multiplied = new Matrix(this.getRowCount(), m2.getColCount()); // builds new matrix
        for (int i = 0; i < this.getRowCount(); i++) { // for each row in m1
            for (int j = 0; j < m2.getColCount(); j++) { // for each column in m2 -> iterate through each column to get row of products
                int dProd = 0;
                for (int k = 0; k < this.getColCount(); k++) { // for each column in m1 -> iterate for one dot product
                    dProd += this.matrix[i][k]*m2.matrix[k][j];
                }
                //once done adding dot products
                multiplied.matrix[i][j] = dProd;
            }
        }
        multiplied.display();
        return multiplied;

    }

    public Matrix subtract(Matrix m2) {
        if (this.getRowCount() != m2.getRowCount() && this.getColCount() != m2.getColCount()) {
            System.out.println("ERROR - Matrix of different sizes");
            return null;
        }
        Matrix subbed = new Matrix(this.getRowCount(), this.getColCount());
        for (int i = 0; i < this.getRowCount(); i++) {
            for (int j = 0; j < this.getColCount(); j++) {
                subbed.getMatrix()[i][j] = this.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
        subbed.display();
        return subbed;
    }
}
