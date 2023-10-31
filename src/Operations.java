public class Operations {

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.getRowCount() != m2.getRowCount() && m1.getColCount() != m2.getColCount()) {
            System.out.println("ERROR - Matrix of different sizes");
            return null;
        }
        Matrix added = new Matrix(m1.getRowCount(), m1.getColCount());
        for (int i = 0; i < m1.getRowCount(); i++) {
            for (int j = 0; j < m1.getColCount(); j++) {
                added.getMatrix()[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
        System.out.println(added);
        return added;
    }
}
