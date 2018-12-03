package twoRegularExpressionsOneWhile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		while (matcher.find(apuntador)) {
			System.out.println("Apuntador 1: " + apuntador );
			System.out.println("Start "+ matcher.start());
			System.out.println("End: "+ matcher.end());
			apuntador = matcher.end();
			System.out.println("Anexo: " + matcher.group());
			//System.out.println("Contenido:"+ parrafo.substring(matcher.end()).trim());
			System.out.println(" Numero de Grupos " + matcher.groupCount());
			System.out.println(" GRUPO 1 " + matcher.group(0));
			System.out.println(" GRUPO 2 " + matcher.group(1));
			System.out.println(" GRUPO 2 " + matcher.group(2));
			System.out.println(" Apuntador 2: " + apuntador );
		}

		

		int apuntador2 = 0;

		while (matcher2.find(apuntador2)) {
			System.out.println("Apuntador 1: " + apuntador2 );
			System.out.println("Start "+ matcher2.start());
			System.out.println("End: "+ matcher2.end());
			apuntador2 = matcher2.end();
			System.out.println("Anexos: " + matcher2.group());
			//System.out.println("Contenido:"+ parrafo.substring(matcher.end()).trim());
			System.out.println("Numero de Grupos " + matcher2.groupCount());
			System.out.println("GRUPO 1 " + matcher2.group(0));
			System.out.println("GRUPO 2 " + matcher2.group(1));
			System.out.println("GRUPO 2 " + matcher2.group(2));
			System.out.println("Apuntador 2: " + apuntador2 );
		}
	}
	}

}
