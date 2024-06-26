package LR7_demo;

// Использовать предметную область по варианту из задания к лабораторной работе №4.
// В каждом из заданий необходимо выполнить следующие действия:
// организацию соединения с базой данных вынести в отдельный класс, метод которого возвращает соединение;
// создать БД. Привести таблицы к одной из нормальных форм;
// создать класс для выполнения запросов на извлечение информации из БД с использованием компилированных запросов;
// создать класс на модификацию информации.
// 9. Прокси. Программа должна принимать сообщения от любого клиента, работающего на протоколе TCP,
// и отсылать их на соответствующий сервер. При передаче изменять сообщение.

public class LR7 {
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.startConnection("127.0.0.1", 8080);
            String response = client.sendMessage("hello server");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
