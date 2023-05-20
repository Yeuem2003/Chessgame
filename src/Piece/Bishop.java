/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

/**
 *
 * @author 84942
 */
public class Bishop extends Piece {
    public Bishop(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public void move(int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            // Cập nhật vị trí hàng và cột mới
            this.row = newRow;
            this.col = newCol;
        } else {
            // Xử lý nước đi không hợp lệ
            System.out.println("Nước đi không hợp lệ cho quân tượng.");
        }
    }

    private boolean isValidMove(int newRow, int newCol) {
        int rowDiff = newRow - this.row;
        int colDiff = newCol - this.col;

        // Kiểm tra logic di chuyển cho quân tượng
        if (Math.abs(rowDiff) == Math.abs(colDiff)) {
            int rowStep = Integer.signum(rowDiff);
            int colStep = Integer.signum(colDiff);
            int currentRow = this.row + rowStep;
            int currentCol = this.col + colStep;

            while (currentRow != newRow && currentCol != newCol) {
                if (board[currentRow][currentCol] != null) {
                    // Có quân khác trên đường chéo
                    return false;
                }
                currentRow += rowStep;
                currentCol += colStep;
            }

            return true;
        }

        return false;
    }

    // Thêm các phương thức và thuộc tính cụ thể cho quân tượng
    // ...
}
