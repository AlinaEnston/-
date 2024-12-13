public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что конечная позиция находится в пределах доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка, что пешка не пытается переместиться на ту же позицию
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Логика движения пешки
        if (color.equals("White")) {
            if (line == 1) {
                // Первый ход: может двигаться на 2 клетки вперед
                if (toLine == line + 2 && column == toColumn && chessBoard.getPieceAt(line + 1, column) == null) {
                    return true; // Движение на 2 клетки вперед
                }
                if (toLine == line + 1 && column == toColumn) {
                    return chessBoard.getPieceAt(toLine, toColumn) == null; // Движение на 1 клетку вперед
                }
                if (toLine == line + 1 && Math.abs(column - toColumn) == 1) {
                    return chessBoard.getPieceAt(toLine, toColumn) != null && !chessBoard.getPieceAt(toLine, toColumn).getColor().equals(color); // Удар по диагонали
                }
            } else {
                if (toLine == line + 1 && column == toColumn) {
                    return chessBoard.getPieceAt(toLine, toColumn) == null; // Движение на 1 клетку вперед
                }
                if (toLine == line + 1 && Math.abs(column - toColumn) == 1) {
                    return chessBoard.getPieceAt(toLine, toColumn) != null && !chessBoard.getPieceAt(toLine, toColumn).getColor().equals(color); // Удар по диагонали
                }
            }
        } else { // Черная пешка
            if (line == 6) {
                // Первый ход: может двигаться на 2 клетки вперед
                if (toLine == line - 2 && column == toColumn && chessBoard.getPieceAt(line - 1, column) == null) {
                    return true; // Движение на 2 клетки вперед
                }
                if (toLine == line - 1 && column == toColumn) {
                    return chessBoard.getPieceAt(toLine, toColumn) == null; // Движение на 1 клетку вперед
                }
                if (toLine == line - 1 && Math.abs(column - toColumn) == 1) {
                    return chessBoard.getPieceAt(toLine, toColumn) != null && !chessBoard.getPieceAt(toLine, toColumn).getColor().equals(color); // Удар по диагонали
                }
            } else {
                if (toLine == line - 1 && column == toColumn) {
                    return chessBoard.getPieceAt(toLine, toColumn) == null; // Движение на 1 клетку вперед
                }
                if (toLine == line - 1 && Math.abs(column - toColumn) == 1) {
                    return chessBoard.getPieceAt(toLine, toColumn) != null && !chessBoard.getPieceAt(toLine, toColumn).getColor().equals(color); // Удар по диагонали
                }
            }
        }
        return false; // Если ни одно из условий не выполнено, движение невозможно
    }

    @Override
    public String getSymbol() {
        return "P"; // Символ для пешки
    }
}