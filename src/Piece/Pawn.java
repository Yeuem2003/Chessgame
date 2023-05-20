/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

/**
 *
 * @author 84942
 */
public class Pawn extends Piece {
    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public void move(int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            // Kiểm tra nếu nước đi hợp lệ
            // Cập nhật giá trị hàng và cột
            this.row = newRow;
            this.col = newCol;
        } else {
            // Xử lý nước đi không hợp lệ
            System.out.println("Nước đi không hợp lệ cho quân Tốt.");
        }
    }

    private boolean isValidMove(int newRow, int newCol) {
        int rowDiff = newRow - this.row;
        int colDiff = newCol - this.col;

        if (isWhite) {
            // Quân Tốt trắng di chuyển lên trên bàn cờ
            if (rowDiff == -1 && colDiff == 0) {
                return true; // Di chuyển một ô về phía trước
            } else if (rowDiff == -2 && colDiff == 0 && this.row == 6) {
                return true; // Di chuyển hai ô về phía trước trong nước đi đầu tiên
            } else if (rowDiff == -1 && Math.abs(colDiff) == 1) {
                return true; // Bắt quân chéo
            }
        } else {
            // Quân Tốt đen di chuyển xuống dưới bàn cờ
            if (rowDiff == 1 && colDiff == 0) {
                return true; // Di chuyển một ô về phía trước
            } else if (rowDiff == 2 && colDiff == 0 && this.row == 1) {
                return true; // Di chuyển hai ô về phía trước trong nước đi đầu tiên
            } else if (rowDiff == 1 && Math.abs(colDiff) == 1) {
                return true; // Bắt quân chéo
            }
        }

        return false;
    }

    // Thêm các phương thức và thuộc tính cụ thể cho quân Tốt
}
