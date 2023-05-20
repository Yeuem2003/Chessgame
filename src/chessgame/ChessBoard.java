package chessgame;

import Piece.Bishop;
import Piece.Coordinate;
import Piece.Knight;
import Piece.Piece;
import Piece.Rook;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class ChessBoard implements  Serializable{

    public static Piece[][] chessBoard = new Piece[8][8];
    public static Piece[][] chessBoardReverse = new Piece[8][8];
    public final static int WIDEBOARD = 600;
    public final static int HEIGHTBOARD = 600;
    public final static int WIDEBOX = 600;
    public final static int HEIGTHBOX = 600;
    public static boolean checkInit = false;
    
    public static void initBoard(Piece [][] board){        
        // chess Black
        board[0][0] = new Rook(Piece.Black, new Coordinate(0, 0));
        board[0][7] = new Rook(Piece.Black, new Coordinate(0, 7));
        board[0][1] = new Knight(Piece.Black, new Coordinate(0, 1));
        board[0][6] = new Knight(Piece.Black, new Coordinate(0, 6));
        board[0][2] = new Bishop(Piece.Black, new Coordinate(0, 2));
        board[0][5] = new Bishop(Piece.Black, new Coordinate(0, 5));
        board[0][3] = new Queen(Piece.Black, new Coordinate(0, 3));
        board[0][4] = new King(Piece.Black, new Coordinate(0, 4));
        for(int i=0; i<8; i++){
            board[1][i] = new Pawn(Piece.Black, new Coordinate(1, i));
        }
        
        // chess White
        board[7][0] = new Rook(Piece.White, new Coordinate(7, 0));
        board[7][7] = new Rook(Piece.White, new Coordinate(7, 7));
        board[7][1] = new Knight(Piece.White, new Coordinate(7, 1));
        board[7][6] = new Knight(Piece.White, new Coordinate(7, 6));
        board[7][2] = new Bishop(Piece.White, new Coordinate(7, 2));
        board[7][5] = new Bishop(Piece.White, new Coordinate(7, 5));
        board[7][3] = new Queen(Piece.White, new Coordinate(7, 3));
        board[7][4] = new King(Piece.White, new Coordinate(7, 4));
        for(int i=0; i<8; i++){
            board[6][i] = new Pawn(Piece.White, new Coordinate(6, i));
        }
        
        
        // Cell empty
        for(int iRow = 2; iRow <= 5; iRow ++){
            for(int iCol = 0; iCol <= 7; iCol++){
                board[iRow][iCol] = new EmptyCell(-1, new Coordinate(iRow,iCol));
            }
        }  
        
    }