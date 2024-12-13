public class ChessBoard {
    ChessPiece[][] board; // Двумерный массив объектов шахматных фигур
    public String nowPlayer; // Переменная, показывающая, чей сейчас ход

    // Конструктор
    public ChessBoard() {
        board = new ChessPiece[8][8]; // Инициализация доски 8x8
        nowPlayer = "White"; // Начинает белый игрок
    }

    // Метод для получения цвета текущего игрока
    public String nowPlayerColor() {
        return nowPlayer;
    }

    // Метод для перемещения фигуры на указанную позицию
    public boolean moveToPosition(int line, int column, int toLine, int toColumn) {
        // Проверка, что начальная позиция и конечная позиция находятся в пределах доски
        if (line < 0 || line >= 8 || column < 0 || column >= 8 ||
                toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // Неверные координаты
        }

        ChessPiece piece = board[line][column]; // Получаем фигуру на начальной позиции

        // Проверка, что на начальной позиции есть фигура и она принадлежит текущему игроку
        if (piece == null || !piece.getColor().equals(nowPlayer)) {
            return false; // Нельзя двигать фигуру, если её нет или она не принадлежит текущему игроку
        }

        // Проверка, может ли фигура переместиться на новую позицию
        if (piece.canMoveToPosition(this, line, column, toLine, toColumn)) {
            // Перемещение фигуры
            board[toLine][toColumn] = piece; // Устанавливаем фигуру на новую позицию
            board[line][column] = null; // Убираем фигуру с начальной позиции

            // Устанавливаем check в false, если это король или ладья
            if (piece instanceof King || piece instanceof Rook) {
                piece.setCheck(false);
            }

            // Меняем текущего игрока
            nowPlayer = nowPlayer.equals("White") ? "Black" : "White";
            return true; // Перемещение успешно
        }

        return false; // Перемещение не удалось
    }

    // Метод для рокировки по 0 линии
    public boolean castling0() {
        // Логика рокировки для белого короля и ладьи
        // Проверка, что король и ладья не двигались и между ними нет фигур
        // Реализуйте логику здесь
        return false; // Заглушка, замените на вашу логику
    }

    // Метод для рокировки по 7 линии
    public boolean castling7() {
        // Логика рокировки для черного короля и ладьи
        // Проверка, что король и ладья не двигались и между ними нет фигур
        // Реализуйте логику здесь
        return false; // Заглушка, замените на вашу логику
    }

    // Метод для получения фигуры на заданной позиции
    public ChessPiece getPieceAt(int line, int column) {
        if (line < 0 || line >= 8 || column < 0 || column >= 8) {
            return null; // Неверные координаты
        }
        return board[line][column]; // Возвращаем фигуру на заданной позиции
    }

    // Метод для печати шахматной доски
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getSymbol() + " ");
                } else {
                    System.out.print(". "); // Печатаем точку для пустой клетки
                }
            }
            System.out.println(); // Переход на новую строку
        }
    }
}