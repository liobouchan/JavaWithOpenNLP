import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBy3ORS2Validation {

	private final static String LINE_IDENTIFIER = "\\r?\\n";
	
	public static void main(String[] args) {

		String parrafo = "(53) Articulo 1 \r\n" + //
				"Art�culo 2 \r\n" + //
				"Art�culo 22 \r\n" + //
				"Art�culo 1 Bis \r\n" + //
				"Art�culo 2 Bis 1 \r\n" + //
				"Art�culo 3 Bis 22 \r\n" + //
				"Art�culo 4 Bis 22 a \r\n" + //
				"Art�culo 5 Bis 2 a \r\n" + //
				"Art�culo 66 Bis \r\n" + //
				"Art�culo 77 Bis 1 \r\n" + //
				"Art�culo 88 Bis 22 \r\n" + //
				"Art�culo 99 Bis 33 a \r\n" + //
				"Art�culo 99 Bis 33 y \r\n" + //
				"Art�culo 11 Bis 4 a \r\n" + //
				"Art�culo 11 Bis 4 o Bla bla bla basura \r\n" + //
				"Art�culo 11 Bis 4 o Anexo 34-p \r\n" + //
				"Art�culo 11 Bis 4 o Anexo 33 \r\n" + //
				"Art�culo 11 Bis 4 o Aqui programando bien perro \r\n" + //
				"(88) Art�culo 2 Bis 18.- En el grupo VII-A se clasificar�n: \r\n" + //
				"(130) Art�culo 2 Bis 19.- En el grupo VII-B se clasificar�n las Operaciones sujetas a \r\n" + //
				"Art�culo 11 Bis 4 o Pues aqui estamos haciendo unas pruebitas chulas \r\n" + //
				"Art�culo 22 Bis 2 z \r\n";

		Pattern pattern = Pattern.compile("(Art�culo )(\\p{Digit}*\\p{Digit})( Bis )*(\\p{Digit}*\\p{Digit})*( [a-x] )*");
		String lines[] = parrafo.split(LINE_IDENTIFIER);

		int apuntador = 0;
		
		for (int i = 0; i < lines.length; i++) {
			Matcher matcher = pattern.matcher(lines[i]);
 			if (matcher.find()) {
 				String articulo = matcher.group();
 				String contenido = lines[i].substring(matcher.end()).trim();
				System.out.println("Anexo: " + matcher.group());
				System.out.println("Contenido: "+ contenido);
				if (articulo.contains(" o ")) {
					if (contenido.contains("Bis")|| contenido.contains("Anexo")) {
						String x = articulo.replaceAll(" o ", "");
						System.out.println("  Nuevo: " + x);
					}else {
						System.out.println("  Nuevo 2 : " + articulo);
					}
				}
			}
		}
	}
}