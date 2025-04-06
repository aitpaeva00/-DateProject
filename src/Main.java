import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();

        // Тест 1: Создание валидных дат
        try {
            System.out.println("Создание валидных дат:");
            Date date1 = new Date(1, 1, 2023);
            Date date2 = new Date(29, 2, 2024); // високосный год
            Date date3 = new Date(31, 12, 2022);
            dates.add(date1);
            dates.add(date2);
            dates.add(date3);
            date1.printDate();
            date2.printDate();
            date3.printDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        printSeparator();

        // Тест 2: Попытка создать невалидную дату
        try {
            System.out.println("Создание невалидной даты:");
            Date invalidDate = new Date(31, 4, 2023); // апреля 31 нет
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        printSeparator();

        // Тест 3: Обновление даты
        Date d = new Date(15, 8, 2023);
        System.out.println("Текущая дата:");
        d.printDate();
        System.out.println("Обновление на 29/2/2024 (валидная):");
        d.updateDate(29, 2, 2024);
        d.printDate();

        System.out.println("Попытка обновления на 31/4/2024 (невалидная):");
        d.updateDate(31, 4, 2024); // ошибка

        printSeparator();

        // Тест 4: День недели
        System.out.println("День недели:");
        Date date4 = new Date(6, 4, 2025); // сегодня
        date4.printDate();
        System.out.println("Это: " + date4.getDayOfWeek());

        printSeparator();

        // Тест 5: Разница между датами
        Date today = new Date(6, 4, 2025);
        Date newYear = new Date(1, 1, 2026);
        int diff = today.calculateDifference(newYear);
        System.out.println("Разница между");
        today.printDate();
        System.out.print("и ");
        newYear.printDate();
        System.out.println(": " + diff + " дней");

        printSeparator();

        // Тест 6: Сортировка
        System.out.println("Даты до сортировки:");
        dates.add(today);
        dates.add(newYear);
        printDatesTable(dates);

        Collections.sort(dates);

        System.out.println("\nДаты после сортировки:");
        printDatesTable(dates);
    }

    // Метод для красивого вывода таблицы
    public static void printDatesTable(ArrayList<Date> dates) {
        System.out.printf("%-20s | %-10s\n", "Дата", "День недели");
        System.out.println("---------------------|------------");
        for (Date date : dates) {
            String formattedDate = date.getFormattedDate();
            String dayOfWeek = date.getDayOfWeek();
            System.out.printf("%-20s | %-10s\n", formattedDate, dayOfWeek);
        }
    }

    // Метод для разделения тестов
    public static void printSeparator() {
        System.out.println("\n--------------------------------------\n");
    }
}
