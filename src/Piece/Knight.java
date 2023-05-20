/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

/**
 *
 * @author 84942
 */
public class Knight extends Piece {
    public Knight(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public void move(int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            if (isMoveValidForKnight(newRow, newCol)) {
                if (isCaptureMove(newRow, newCol)) {
                    capturePiece(newRow, newCol);
                }
                updatePiecePosition(newRow, newCol);
                // Thực hiện các thao tác cần thiết sau khi di chuyển
                // ...
            } else {
                System.out.println("Nước đi không hợp lệ cho quân mã.");
            }
        } else {
            System.out.println("Vị trí đích không hợp lệ.");
        }
    }

    private boolean isValidMove(int newRow, int newCol) {
        // Kiểm tra xem vị trí đích nằm trên bàn cờ hay không
        return newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8;
    }

    private boolean isMoveValidForKnight(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - this.row);
        int colDiff = Math.abs(newCol - this.col);
        // Kiểm tra xem quân mã di chuyển theo quy tắc "2 ô ngang, 1 ô dọc" hoặc "2 ô dọc, 1 ô ngang"
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    private boolean isCaptureMove(int newRow, int newCol) {
        // Kiểm tra xem có phải nước đi ăn quân không
        return board[newRow][newCol] != null && board[newRow][newCol].isWhite() != isWhite();
    }

    private void capturePiece(int newRow, int newCol) {
        // Tiến hành ăn quân tại vị trí đích
        Piece capturedPiece = board[newRow][newCol];
        capturedPiece.setCaptured(true);
        // Thực hiện các thao tác khác liên quan đến việc ăn quân
        // ...
    }

    private void updatePiecePosition(int newRow, int newCol) {
        // Cập nhật vị trí mới của quân mã
        board[this.row][this.col] = null;
        this.row = newRow;
        this.col = newCol;
        board[newRow][newCol] = this;
        // Thực hiện các thao tác khác liên quan đến cập nhật vị trí
        // ...
    }

    // Thêm các phương thức và thuộc tính cụ thể cho quân mã
    // ...
}
