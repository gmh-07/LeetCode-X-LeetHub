class Spreadsheet {
    private int[][] data; // rows x 26

    public Spreadsheet(int rows) {
        data = new int[rows][26]; // All 0 by default
    }

    public void setCell(String cell, int value) {
        int[] pos = getPosition(cell);
        data[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = getPosition(cell);
        data[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // Formula always in the form "=X+Y" where X,Y are cell or number
        if (formula.charAt(0) == '=') {
            String expr = formula.substring(1); // remove '='
            String[] parts = expr.split("\\+"); // split at '+'
            int val1 = getOperandValue(parts[0]);
            int val2 = getOperandValue(parts[1]);
            return val1 + val2;
        } else {
            // Should not happen per problem, but safe:
            return Integer.parseInt(formula);
        }
    }

    // --- Helper to decode "A1" -> [rowIndex, colIndex]
    private int[] getPosition(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A'; // 0–25
        int row = Integer.parseInt(cell.substring(1)) - 1; // 1-indexed to 0-indexed
        return new int[]{row, col};
    }

    // --- Helper to get value for operand (cell ref or integer)
    private int getOperandValue(String op) {
        // If starts with digit → integer literal
        if (Character.isDigit(op.charAt(0))) {
            return Integer.parseInt(op);
        } else {
            // It's a cell reference like A1
            int[] pos = getPosition(op);
            return data[pos[0]][pos[1]];
        }
    }
}
