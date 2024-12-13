public abstract class ChessPiece {
    protected String color; // Цвет фигуры
    protected boolean check; // Переменная для отслеживания, двигалась ли фигура

    // Конструктор
    public ChessPiece(String color) {
        this.color = color;
        this.check = true; // Изначально фигура не двигалась
    }

    public abstract String getColor(); // Метод для получения цвета фигуры
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn); // Метод для проверки возможности перемещения
    public abstract String getSymbol(); // Метод для получения символа фигуры

    // Метод для установки состояния check
    public void setCheck(boolean check) {
        this.check = check;
    }

    // Метод для получения состояния check
    public boolean hasMoved() {
        return !check; // Если check false, значит фигура двигалась
    }
}