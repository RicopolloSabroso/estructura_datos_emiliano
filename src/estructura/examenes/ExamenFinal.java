package estructura.examenes;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import estructura.cola.CircularQueue;
import estructura.lista.ArrayList;
import estructura.lista.LinkedList;

public class ExamenFinal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		LinkedList lista= new LinkedList();
		
		//preguntaFarmaceutica();
		//preguntaLibro();
		//penultima pregunta
		//penultimaPregunta();
		
		
	}
	public static void preguntaLibro() {
		LinkedList lista= new LinkedList();
		Scanner leer = new Scanner(System.in);
		int i=0;
		while(i<3) {
			String libro="ISBN-";
			String fecha;
			while(true) {
				System.out.println("Deme la fecha del libro");
				fecha=leer.nextLine();
				if(validarEntero(fecha)) {
					if(Integer.parseInt(fecha)>=1990&&Integer.parseInt(fecha)<=2007) {
						libro=libro+fecha;
						break;
					}else {
						System.out.println("No cumple con la fecha, vuelve a intentarlo");
					}
				}else {
					System.out.println("No valida, vuelve a intentarlo");
				}
				
			}
			String numero=String.valueOf((1+(int)(Math.random()*1000)));
			if(numero.length()==4) {
				libro=libro+"-"+numero;
			}else {
				while(numero.length()<4) {
					numero="0"+numero;
				}
				libro=libro+"-"+numero;
			}
			lista.add(libro);
		i++;
		}
		System.out.println(lista);
	}
	public static void preguntaFarmaceutica() {
		Scanner leer = new Scanner(System.in);
		String[][]inventario= {{"KETOROLACO","1023125697","100","21/11/2017"},{"PARACETAMOL","1536849301","50","02/09/2017"}
		,{"ATROVENT","1208793001","1000","12/01/2017"},{"FENITOINA","4689430150","500","30/07/2017"},{"KETOROLACO","1023125697","100","25/08/2018"},
		{"ATROVENT","1208793001","1000","12/08/2017"},{"ATROVENT","1208793001","1000","01/08/2017"},{"KETOROLACO","1023125697","100","02/08/2019"},{"KETOROLACO","1023125697","100","21/10/2019"}};
		mostrar(inventario) ;
		ordenar(inventario);
		mostrar(inventario) ;
		System.out.println("Cuantos medicamentos desea agregar?");
		int tam=Integer.parseInt(leer.nextLine());
		inventario=incrementaArray(inventario,tam);

		mostrar(inventario); 
		
	}
	private static String[][] incrementaArray(String[][]inventario, int tam) {
		String[][] aux= new String[inventario.length+tam][inventario[0].length];
		Scanner leer = new Scanner(System.in);
		for(int i=0;i<inventario.length;i++) {
			for(int j=0;j<inventario[0].length;j++) {
				aux[i][j]=inventario[i][j];
			}
		}
		for(int i=0;i<tam;i++) {
			for(int j=0;j<aux[0].length;j++) {
				System.out.println(j==0?"Nombre del medicamento":j==1?"Nombre del codigo de barras":j==2?"precio":"fecha");
				if(j==1) {
					while(true) {
						String dato=leer.nextLine();
						if(dato.length()==10) {
							aux[inventario.length+i][j]=dato;
							break;
						}else {
							System.out.println("No es valido, vuelva a intentarlo");
						}
					}
					
				}else if(j==2){
					while(true) {
						String dato=leer.nextLine();
						if(validarEntero(dato)) {
							aux[inventario.length+i][j]=dato;
							break;
						}else {
							System.out.println("No es valido, vuelva a intentarlo");
						}
					}
				}else {
					String dato=leer.nextLine();
					aux[inventario.length+i][j]=dato;
				}
	
			}
			
		}
		
		return aux;
	}
	public static void mostrar(String[][]inventario) {
		for(int i=0;i<inventario.length;i++) {
			for(int j=0;j<inventario[0].length;j++) {
				if(inventario[i][j]!=null) {
					System.out.print(inventario[i][j]+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void ordenar(String[][]inventario) {
		for(int i=0;i<inventario.length;i++) {
			int rep=1;
			String[] fecha=inventario[i][3].split("/");
			for(int j=0;j<inventario.length;j++) {
				String[] fecha2=inventario[j][3].split("/");
					if(Integer.parseInt(fecha[2])<Integer.parseInt(fecha2[2])&&rep!=1) {
						
						rep++;
					}else if(Integer.parseInt(fecha[2])==Integer.parseInt(fecha2[2])&&rep!=1){
						if(Integer.parseInt(fecha[1])<Integer.parseInt(fecha2[1])&&rep!=1) {
							
						}
					}else {
						
					}
			}
		}

	}
	public static void penultimaPregunta()throws Exception  { 
		Scanner leer = new Scanner(System.in);
		System.out.println("de que tamano quiere la primer lista?");
		String tam=leer.nextLine();
		ArrayList lista1= new ArrayList(Integer.parseInt(tam),1);
		for(int i=0;i<Integer.parseInt(tam);i++) {
			lista1.add((1+(int)(Math.random()*100)));
		}
		shellSort(lista1);
		System.out.println(lista1);
		System.out.println("de que tamano quiere la segunda lista?");
		tam=leer.nextLine();
		ArrayList lista2= new ArrayList(Integer.parseInt(tam),10);
		for(int i=0;i<Integer.parseInt(tam);i++) {
			lista2.add((1+(int)(Math.random()*100)));
		}
		shellSort(lista2);
		System.out.println(lista2);
		LinkedList listaRepetidos= new LinkedList();
		for(int i=0;i<lista1.size();i++) {
			int numero= (int)lista1.get(i);
			for(int j=0;j<lista2.size();j++) {
				if(numero==(int)lista2.get(j)) {
					listaRepetidos.add(numero);
					break;
				}
			}
		}
		for(int i=0;i<lista1.size();i++) {
			int rep=1;
			int numero= (int)lista1.get(i);
			for(int j=0;j<lista1.size();j++) {
				if(numero==(int)lista1.get(j)&&rep!=1) {
					listaRepetidos.add(numero);
				}
			}
		}
		for(int i=0;i<lista2.size();i++) {
			int rep=1;
			int numero= (int)lista2.get(i);
			for(int j=0;j<lista1.size();j++) {
				if(numero==(int)lista2.get(j)&&rep!=1) {
					listaRepetidos.add(numero);
				}
			}
		}
		System.out.println(listaRepetidos);
		
		for(int i=0;i<listaRepetidos.size();i++) {
			int rep=1;
			int numero= (int)listaRepetidos.get(i);
			for(int j=0;j<listaRepetidos.size();j++) {
				if(numero==(int)listaRepetidos.get(j)&&rep!=1) {
					listaRepetidos.remove(j);
				}
			}
		}
		System.out.println(listaRepetidos);	
	}
	public static void shellSort(ArrayList lista) throws Exception {
        int incremento = lista.size() / 2;
        while (incremento > 0) {
            for (int i = incremento; i < lista.size(); i++) {
                int j = i;
                int temporal = (int)lista.get(i);
                while (j >= incremento && (int)lista.get(j - incremento) > temporal) {
                    lista.set(j, lista.get(j - incremento));
                    j = j - incremento;
                }
                lista.set(j, temporal);
            }
            if (incremento == 2) {
                incremento = 1;
            } else {
                incremento = (int) (incremento / 2.2);
            }
        }
    }
	public static boolean validarEntero(String valor) {
		boolean respuesta;
		try {
			Integer.parseInt(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}
	
}
