
package Core_Java;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static void main(String[] args) {

        LocalDate finalMatchDate = LocalDate.of(2026, 7, 19);
        LocalDate today = LocalDate.of(2026, 11, 21);

        // Calculate the period between two dates
        Period daysUntilFinal = Period.between(today, finalMatchDate);
        System.out.println(daysUntilFinal);

        // Calculate match duration
        LocalDateTime kickOff = LocalDateTime.of(2026, 7, 19, 18, 0);
        LocalDateTime fullTime = LocalDateTime.of(2026, 7, 19, 19, 13);

        Duration matchLength = Duration.between(kickOff, fullTime);
        System.out.println(matchLength);

        // Format date and time
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm a");

        System.out.println(kickOff.format(formatter));
        System.out.println(fullTime.format(formatter));
        System.out.println(
                matchLength.toHours() + " hours " +
                        (matchLength.toMinutes() % 60) + " minutes"
        );
    }
}
