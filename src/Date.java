import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        return day <= daysInMonth[month - 1];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void updateDate(int d, int m, int y) {
        if (isValidDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Ошибка: Невалидная дата " + d + "/" + m + "/" + y);
        }
    }

    public String getDayOfWeek() {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int calculateDifference(Date otherDate) {
        LocalDate thisDate = LocalDate.of(this.year, this.month, this.day);
        LocalDate thatDate = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return (int) Math.abs(java.time.temporal.ChronoUnit.DAYS.between(thisDate, thatDate));
    }

    public void printDate() {
        System.out.println(getFormattedDate());
    }

    public String getFormattedDate() {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return String.format("%d %s %d", day, monthNames[month - 1], year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }
}
