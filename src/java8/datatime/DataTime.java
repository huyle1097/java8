package java8.datatime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataTime {
	public static void main(String[] args) {
		ZoneId london = ZoneId.of("Europe/London");
		LocalDate july4 = LocalDate.of(2019, Month.JULY, 28);
		LocalTime early = LocalTime.parse("08:45");
		ZonedDateTime flightDeparture = ZonedDateTime.of(july4, early, london);
		System.out.println(flightDeparture);
		LocalTime from = LocalTime.from(flightDeparture);
		System.out.println(from);
		ZonedDateTime touchDown = ZonedDateTime.of(july4, LocalTime.of(11, 35), ZoneId.of("Europe/Stockholm"));
		Duration flightLength = Duration.between(flightDeparture, touchDown);
		System.out.println(flightLength);
		ZonedDateTime now = ZonedDateTime.now();
		Duration timeHere = Duration.between(touchDown, now);
		System.out.println(timeHere);
	}
}
