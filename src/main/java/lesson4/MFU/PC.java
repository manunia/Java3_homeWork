package lesson4.MFU;

public class PC {
// 3. Написать класс МФУ, на котором возможно одновременно выполнять печать и сканирование
// документов, но нельзя одновременно печатать или сканировать два документа. При печати в
// консоль выводится сообщения «Отпечатано 1, 2, 3,... страницы», при сканировании –
// аналогично «Отсканировано...». Вывод в консоль с периодом в 50 мс.
    public static void main(String[] args) {
        Q q = new Q();
        new Printer(q);
        new Scanner(q);
    }
}
