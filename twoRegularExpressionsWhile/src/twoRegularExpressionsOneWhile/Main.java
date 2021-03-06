package twoRegularExpressionsOneWhile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parrafo = "(53) Anexo 32 \r\n" + //
				"Anexo 3 \r\n" + //
				"(53) Anexo 23. \r\n" + //
				"(53) Anexo 2. \r\n" + //
				"(53) Anexos 2 y 5 \r\n" + //
				"(53) Anexos 22 y 34 \r\n" + //
				"(53) Anexo 3434. Cuenta 7.\r\n" + //
				"(53) Anexo 3 , Cuenta 8.";

		Pattern pattern = Pattern.compile("(Anexo )(\\p{Digit}*\\p{Digit})");
		Matcher matcher = pattern.matcher(parrafo);

		Pattern pattern2 = Pattern.compile("(Anexos )(\\p{Digit}*\\p{Digit})( y )(\\p{Digit}*\\p{Digit})");
		Matcher matcher2 = pattern2.matcher(parrafo);
		
		int apuntador = 0;

		while (matcher.find(apuntador) || matcher2.find(apuntador)) {
			System.out.println("Apuntador1 1: " + apuntador );
			System.out.println("Start "+ matcher.start());
			System.out.println("End: "+ matcher.end());
			apuntador = matcher.end();
			System.out.println("Anexo: " + matcher.group());
			System.out.println(" Numero de Grupos " + matcher.groupCount());
			
			if (matcher.groupCount() == 2) {
				System.out.println(" GRUPO 1 " + matcher.group(0));
				System.out.println(" GRUPO 2 " + matcher.group(1));
				System.out.println(" GRUPO 3 " + matcher.group(2));
			}
			if (matcher.groupCount() == 4) {
				System.out.println(" GRUPO 1 " + matcher2.group(0));
				System.out.println(" GRUPO 2 " + matcher2.group(1));
				System.out.println(" GRUPO 3 " + matcher2.group(2));
				System.out.println(" GRUPO 4 " + matcher2.group(3));
				System.out.println(" GRUPO 5 " + matcher2.group(4));
			}
			System.out.println(" Apuntador1 2: " + apuntador );
		}
	}
}
