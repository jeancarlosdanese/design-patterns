import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
//		LocalDate olimpiadasRio = LocalDate.of(2099, Month.JANUARY, 25);
		LocalDate olimpiadasRio = LocalDate.of(2099, 1, 25);
		System.out.println(olimpiadasRio);
		
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);
		
		Period periodo = Period.between(hoje, olimpiadasRio);
		System.out.println(periodo);
		
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String proximasOlimpiadasFormat = proximasOlimpiadas.format(formatter);
		System.out.println(proximasOlimpiadasFormat); 

		DateTimeFormatter formatterComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatterComHora));
		
		MonthDay diaMes = MonthDay.now();
		System.out.println(diaMes.compareTo(diaMes));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		ZonedDateTime dataComZone = ZonedDateTime.now();
		System.out.println(dataComZone);
	}
}
