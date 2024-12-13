public class King extends ChessPiece {

    // Конструктор, принимающий цвет фигуры
    public King(String color) {
        super(color); // Вызов конструктора родительского класса
    }

    // Метод для получения цвета фигуры
    @Override
    public String getColor() {
        return color; // Возвращаем цвет фигуры
    }

    // Метод для проверки возможности перемещения
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что конечная позиция находится в пределах доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // Неверные координаты
        }

        // Проверка, что король не пытается переместиться на ту же позицию
        if (line == toLine && column == toColumn) {
            return false; // Нельзя переместиться на ту же позицию
        }

        // Проверка, что король движется на одну клетку в любом направлении
        int rowDiff = Math.abs(toLine - line);
        int colDiff = Math.abs(toColumn - column);
        return (rowDiff <= 1 && colDiff <= 1);
    }

    // Метод для получения символа фигуры
    @Override
    public String getSymbol() {
        return "K"; // Символ для короля
    }
}