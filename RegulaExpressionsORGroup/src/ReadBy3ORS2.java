import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBy3ORS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String parrafo = "(53) Articulo 1 \r\n" + //
				"Artículo 2 \r\n" + //
				"Artículo 22 \r\n" + //
				"Artículo 1 Bis \r\n" + //
				"Artículo 2 Bis 1 \r\n" + //
				"Artículo 3 Bis 22 \r\n" + //
				"Artículo 4 Bis 22 a \r\n" + //
				"Artículo 5 Bis 2 a \r\n" + //
				"Artículo 66 Bis \r\n" + //
				"Artículo 77 Bis 1 \r\n" + //
				"Artículo 88 Bis 22 \r\n" + //
				"Artículo 99 Bis 33 a \r\n" + //
				"Artículo 11 Bis 4 a \r\n" + //
				"Artículo 22 Bis 2 z \r\n";

		Pattern pattern = Pattern.compile("(Artículo )(\\p{Digit}*\\p{Digit})( Bis )*(\\p{Digit}*\\p{Digit})*( \\p{Lower})*");
		Matcher matcher = pattern.matcher(parrafo);

		int apuntador = 0;

		while (matcher.find()) {
			//System.out.println("Apuntador 1: " + apuntador );
			//System.out.println("Start "+ matcher.start());
			//System.out.println("End: "+ matcher.end());
			System.out.println("Anexo: " + matcher.group());
			
			//for (int i = 0; i <= matcher.groupCount(); i++) {
			//	System.out.println(" Grupo " + i + " " + matcher.group(i));
			//}
			
			//apuntador = matcher.end();
			//System.out.println("Apuntador 2: " + apuntador );
		}
	}

}
