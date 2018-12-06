package regularExpressionsGetWordAndSaveTrash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	private final static String LINE_IDENTIFIER = "\\r?\\n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parrafo = "(53) Anexo 1 Esto es una pequeña pruebita \r\n" + //
				"(53) Anexo 3 , Cuenta 8.";
		Pattern pattern = Pattern.compile("(Anexo )(\\p{Digit}*\\p{Digit})");
		int apuntador = 0;
		
		String lines[] = parrafo.split(LINE_IDENTIFIER);

		for (int i = 0; i < lines.length; i++) {
			System.out.println("Linea: " + lines[i]);
			Matcher matcher = pattern.matcher(lines[i]);
			//int apuntador = 0;
 			if (matcher.find()) {
				//System.out.println("Apuntador 1: " + apuntador );
				System.out.println("Start "+ matcher.start());
				System.out.println("End: "+ matcher.end());
				//apuntador = matcher.end();
				System.out.println("Anexo: " + matcher.group());
				System.out.println("Contenido:"+ lines[i].substring(matcher.end()).trim());
				//System.out.println("Apuntador 2: " + apuntador );
			}
		}
		
	}

}
