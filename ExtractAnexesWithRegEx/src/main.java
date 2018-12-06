import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	private final static String LINE_IDENTIFIER = "\\r?\\n";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		boolean contex = false;
		String parrafo = "(53) Anexo 1 Esto es una pequeña pruebita \r\n" + //
				"(53) Esto es una pequeña linea 1 \r\n" + //
				"(53) Esto es una pequeña linea 2 \r\n" + //
				"(53) Anexo 3 , Cuenta 8.";
		String posibleAnexo = "";
		String descripcion = "";
		String lines[] = parrafo.split(LINE_IDENTIFIER);
		Pattern pattern = Pattern.compile("(Anexo )(\\p{Digit}*\\p{Digit})");
		String nombreAnexo = "";
		StringBuilder descripcionAnexo = new StringBuilder();
		
		for (int i = 0; i < lines.length; i++) {
			System.out.println("Linea: " + lines[i]);
			Matcher matcher = pattern.matcher(lines[i]);

			if(!contex) {
				if (lines[i].contains("Anexo")) {
					if (matcher.find()) {
						nombreAnexo = matcher.group();
						contex = true;
						//descripcionAnexo.append(lines[i].substring(matcher.end()).trim().toString().replaceAll("'", "`") + '\n');
						//if (i < lines.length-1) {
						//	i++;
						//}
						
						//System.out.println("Anexo: " + nombreAnexo);
					}
				}
			}
			if (contex) {
				//Validación de Footers
				if (lines[i].contains("Anexo")) {
					if (matcher.find()) {
						posibleAnexo = matcher.group();
						contex = true;
						//System.out.println("Posible Proximo Anexo: " + posibleAnexo);
					}
					if (!posibleAnexo.equals(nombreAnexo) && posibleAnexo.contains("Anexo")){
						//System.out.println("ENTONCES GUARDAR DATOS");
						descripcion = descripcionAnexo.toString();
						System.out.println("Nombre de Anexo: " + nombreAnexo);
						System.out.println("Descripcion de Anexo: " + descripcionAnexo);
						
						//neo4j.crearArticulo(nombreArticulo.replaceAll(" ", ""), nombreArticulo, descripcion,
						//		contenidoArticulo.toString());
						descripcionAnexo.setLength(0);
						contex = false;
						i--;
					}
					else {
						descripcionAnexo.append(lines[i].replaceAll("'", "`") + '\n');
					}
				}else {
					descripcionAnexo.append(lines[i].replaceAll("'", "`") + '\n');
				}
			}
		}
	}
	}
