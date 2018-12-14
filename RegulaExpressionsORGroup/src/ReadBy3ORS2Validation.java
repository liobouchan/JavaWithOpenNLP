import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBy3ORS2Validation {

	private final static String LINE_IDENTIFIER = "\\r?\\n";
	
	public static void main(String[] args) {

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
				"Artículo 99 Bis 33 y \r\n" + //
				"Artículo 11 Bis 4 a \r\n" + //
				"Artículo 11 Bis 4 o Bla bla bla basura \r\n" + //
				"Artículo 11 Bis 4 o Anexo 34-p \r\n" + //
				"Artículo 22 Bis 2 z \r\n";

		Pattern pattern = Pattern.compile("(Artículo )(\\p{Digit}*\\p{Digit})( Bis )*(\\p{Digit}*\\p{Digit})*( [a-x] )*");
		String lines[] = parrafo.split(LINE_IDENTIFIER);

		//Pattern pattern2 = Pattern.compile("(Artículo )(\\p{Digit}*\\p{Digit})( Bis )*(\\p{Digit}*\\p{Digit})*( o )");

		int apuntador = 0;
		
		for (int i = 0; i < lines.length; i++) {
			//System.out.println("Linea: " + lines[i]);
			Matcher matcher = pattern.matcher(lines[i]);
			//int apuntador = 0;
 			if (matcher.find()) {
				//System.out.println("Apuntador 1: " + apuntador );
				//System.out.println("Start "+ matcher.start());
				//System.out.println("End: "+ matcher.end());
				//apuntador = matcher.end();
 				String articulo = matcher.group();
 				String contenido = lines[i].substring(matcher.end()).trim();
				System.out.println("Anexo: " + matcher.group());
				System.out.println("Contenido: "+ contenido);
				if (articulo.contains(" o ")) {
					System.out.println("sI TIENE UNA 0");
					if (contenido.contains("Bis")|| contenido.contains("Anexo")) {
						System.out.println("Esto es un o de verdad");
					}else {
						System.out.println("Entonces si tiene inciso");
					}
				}
				//System.out.println("Apuntador 2: " + apuntador );
			}
		}

//		while (matcher.find()) {
//			//System.out.println("Apuntador 1: " + apuntador );
//			//System.out.println("Start "+ matcher.start());
//			//System.out.println("End: "+ matcher.end());
//			System.out.println("Artículo: " + matcher.group());
//			//String contenido = parrafo.substring(matcher.end());
//			//System.out.println("Contenido: " + contenido );
//			//String articulito = matcher.group();
//			//Matcher matcher2 = pattern2.matcher(articulito);
//			//if (matcher2.find()) {
//			//	System.out.println("	Este es el que trae el pedo");
//			//}
//			//for (int i = 0; i <= matcher.groupCount(); i++) {
//			//	System.out.println(" Grupo " + i + " " + matcher.group(i));
//			//}
//			
//			//apuntador = matcher.end();
//			//System.out.println("Apuntador 2: " + apuntador );
//		}
	}
}