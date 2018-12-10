import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBy3ORsAndIfWithMoreRegexs {
	public static void main(String[] args) {

		String parrafo = "(53) Anexo 32 \r\n" + //
				"Anexo 3 \r\n" + //
				"Anexo 1-A \r\n" + //
				"(53) Anexo 1-B \r\n" + //
				"(53) Anexo 1-C Bis. \r\n" + //
				"(53) Anexo 1-D Bis 1. \r\n" + //
				"(53) Anexos 2 y 5 \r\n" + //
				"(53) Anexos 22 y 34 \r\n" + //
				"(53) Anexo 3434. Cuenta 7.\r\n" + //
				"(53) Anexos 1-R y 2 \r\n" + //
				"(53) Anexos 1-R y 2-T \r\n" + //
				"(53) Anexos 1-R Bis y 2-T Bis 2 \r\n" + //
				"(53) Anexos 1-R o 2-T \r\n" + //
				"(53) Anexos 1-R Bis o 2-T Bis 5 \r\n" + //
				"(53) Anexo 4 , Cuenta 8.";

		Pattern pattern = Pattern.compile("(Anexo )((\\p{Digit}*\\p{Digit}\\-[A-Z])( Bis)( \\p{Digit})*|\\p{Digit}*\\p{Digit}\\-\\p{Upper}|\\p{Digit}*\\p{Digit})");
		Pattern pattern2 = Pattern.compile("(Anexos )((\\p{Digit}*\\p{Digit}\\-[A-Z])( Bis)( \\p{Digit})*|\\p{Digit}*\\p{Digit}\\-\\p{Upper}|\\p{Digit}*\\p{Digit})( y )((\\p{Digit}*\\p{Digit}\\-[A-Z])( Bis)( \\p{Digit})*|\\p{Digit}*\\p{Digit}\\-\\p{Upper}|\\p{Digit}*\\p{Digit})");
		Pattern pattern3 = Pattern.compile("(Anexos )((\\p{Digit}*\\p{Digit}\\-[A-Z])( Bis)( \\p{Digit})*|\\p{Digit}*\\p{Digit}\\-\\p{Upper}|\\p{Digit}*\\p{Digit})( o )((\\p{Digit}*\\p{Digit}\\-[A-Z])( Bis)( \\p{Digit})*|\\p{Digit}*\\p{Digit}\\-\\p{Upper}|\\p{Digit}*\\p{Digit})");

		Matcher matcher = pattern.matcher(parrafo);
		Matcher matcher2 = pattern2.matcher(parrafo);
		Matcher matcher3 = pattern3.matcher(parrafo);

		while (matcher.find()) {
			System.out.println("Anexo: " + matcher.group());
			//Relacionar
		}

		while (matcher2.find()) {
			System.out.println("Anexo: " + matcher2.group());
			//Relacionar
		}
		
		while (matcher3.find()) {
			System.out.println("Anexo: " + matcher3.group());
			//Relacionar
		}
	}

}
