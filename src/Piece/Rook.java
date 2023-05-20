/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

/**
 *
 * @author 84942
 */
public class Rook extends Piece {

    public Rook(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public void move(int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            // Kiểm tra xem nước đi có hợp lệ không
            // Cập nhật giá trị hàng và cột mới
            this.row = newRow;
            this.col = newCol;
        } else {
            // Xử lý nước đi không hợp lệ
            System.out.println("Nước đi không hợp lệ cho quân xe.");
        }
    }

    private boolean isValidMove(int newRow, int newCol) {
        int rowDiff = newRow - this.row;
        int colDiff = newCol - this.col;

        // Quân xe có thể di chuyển theo chiều ngang hoặc dọc
        if (rowDiff == 0 && colDiff != 0) {
            // Kiểm tra các chướng ngại trên đường đi ngang
            int step = Integer.signum(colDiff); // Lấy hướng di chuyển (1 hoặc -1)
            int currentCol = this.col + step;
            while (currentCol != newCol) {
                if (board[this.row][currentCol] != null) {
                    // Có chướng ngại trên đường đi
                    return false;
                }
                currentCol += step;
            }
            return true;
        } else if (rowDiff != 0 && colDiff == 0) {
            // Kiểm tra các chướng ngại trên đường đi dọc
            int step = Integer.signum(rowDiff); // Lấy hướng di chuyển (1 hoặc -1)
            int currentRow = this.row + step;
            while (currentRow != newRow) {
                if (board[currentRow][this.col] != null) {
                    // Có chướng ngại trên đường đi
                    return false;
                }
                currentRow += step;
            }
            return true;
        }

        return false;
    }

    // Thêm các phương thức và thuộc tính cụ thể cho quân xe
}
