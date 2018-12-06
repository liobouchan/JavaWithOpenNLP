import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		boolean contex = false;
		String parrafo = "(53) Anexo 1 Esto es una pequeña pruebita \r\n" + //
				"(53) Esto es una pequeña linea 1 \r\n" + //
				"(53) Esto es una pequeña linea 2 \r\n" + //
				"(53) Anexo 3 , Cuenta 8.";
		String posibleAnexo = "";
		
		String lines[] = parrafo.split(LINE_IDENTIFIER);
		Pattern pattern = Pattern.compile("(Anexo )(\\p{Digit}*\\p{Digit})");
		String nombreAnexo = "";
		StringBuilder contenidoAnexo = new StringBuilder();
		
		for (int i = 0; i < lines.length; i++) {
			System.out.println("Linea: " + lines[i]);
			Matcher matcher = pattern.matcher(lines[i]);
			//int apuntador = 0;

			if(!contex) {
				if (lines[i].contains("Anexo")) {
					if (matcher.find()) {
						nombreAnexo = matcher.group();
						contex = true;
						System.out.println("Anexo: " + nombreAnexo);
					}
				}
			}
			if (contex) {
				//Validación de Footers
				if (lines[i].contains("Anexo")) {
					if (matcher.find()) {
						posibleAnexo = matcher.group();
						contex = true;
						System.out.println("Posible Proximo Anexo: " + posibleAnexo);
					}
					if (!posibleAnexo.equals(nombreAnexo) && posibleAnexo.contains("Anexo")){
						System.out.println("ENTONCES GUARDAR DATOS");
						//descripcion = obtenerDescripcionDeArticulo(contenidoArticulo);

						//neo4j.crearArticulo(nombreArticulo.replaceAll(" ", ""), nombreArticulo, descripcion,
						//		contenidoArticulo.toString());
						contenidoAnexo.setLength(0);
						contex = false;
						i--;
					}else {
						System.out.println("Hacer un append");
					}
				}else {
					System.out.println("Hacer un append");
				}
			}
			
			//System.out.println("MATCHER . FIND = " + matcher.find());
			//if (matcher.find()) {
				//System.out.println("Apuntador 1: " + apuntador );
				//System.out.println("Start "+ matcher.start());
				//System.out.println("End: "+ matcher.end());
				//apuntador = matcher.end();
				//System.out.println("Anexo: " + matcher.group());
				//System.out.println("Contenido:"+ lines[i].substring(matcher.end()).trim());
				//System.out.println(" ");
				//System.out.println("Apuntador 2: " + apuntador );
			//}
		}
	}
	}

}
