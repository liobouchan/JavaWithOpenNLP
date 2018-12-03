package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String parrafo = "(53) Anexo 1 \r\n" + //
				"Anexo 1-A \r\n" + //
				"(53) Anexo 1-B \r\n" + //
				"(53) Anexo 2. \r\n" + //
				"(53) Anexos 2 y 5 \r\n" + //
				"(53) Anexos 22 y 34 \r\n" + //
				"(53) Anexo 3434. Cuenta 7.\r\n" + //
				"(53) Anexo 3 , Cuenta 8.";

		Pattern pattern = Pattern.compile("(Anexo )(\\p{Digit}*\\p{Digit}\\-\\p{Upper})");
		Matcher matcher = pattern.matcher(parrafo);

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
	}

}
