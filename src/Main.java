import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Tarjeta tarje = new Tarjeta();
        //Patron patron = new Patron();
        Pattern VISA = Pattern.compile("^4[0-9]{3}[0-9]{4}[0-9]{4}[0-9]{4}$");
        Pattern MASTERCARD = Pattern.compile("^5[1-5][0-9]{2}[0-9]{4}[0-9]{4}[0-9]{4}$");
        Pattern AMEX = Pattern.compile("^3[47][0-9]{13}$");
        Pattern CABAL = Pattern.compile("^(6042|6043|6044|6045|6046|5896)[0-9]{12}$");
        Pattern NARANJA = Pattern.compile("^(589562|402917|402918|527571|527572|0377798|0377799)[0-9]*$");


        StringBuilder numerosTarjeta = new StringBuilder();
        //este acumula los digitos, de aca va al bucle
        System.out.println("Bienvenido a Banelcop.");

        System.out.println("Ingrese el nombre del tipo de tarjeta");
        tarje.setTipoTarjeta(leer.nextLine().toLowerCase());
        verificarDominio(leer, tarje, numerosTarjeta);

        if (tarje.getTipoTarjeta().equals("visa") && !VISA.matcher(tarje.getNumeroTarjeta()).matches()) {
            System.out.println("Numero de tarjeta  invalido");
        } else if (tarje.getTipoTarjeta().equals("mastercard") && !MASTERCARD.matcher(tarje.getNumeroTarjeta()).matches()) {
            System.out.println("Numero de tarjeta  invalido");
        }else if (tarje.getTipoTarjeta().equals("amex") && !AMEX.matcher(tarje.getNumeroTarjeta()).matches()) {
            System.out.println("Numero de tarjeta  invalido");
        }else if (tarje.getTipoTarjeta().equals("cabal") && !CABAL.matcher(tarje.getNumeroTarjeta()).matches()) {
            System.out.println("Numero de tarjeta  invalido");
        }else if (tarje.getTipoTarjeta().equals("naranja") && !NARANJA.matcher(tarje.getNumeroTarjeta()).matches()) {
            System.out.println("Numero de tarjeta  invalido");
        }else{
            System.out.println("Validacion comprobada?");
        };
        //FALTA COMPARAR LOS PATTERNS CON LOS INGRESADOS.

    }

    public static void verificarDominio(Scanner leer, Tarjeta tarje, StringBuilder numerosTarjeta) {

        System.out.println("Ingrese su numero de tarjeta");

        while (numerosTarjeta.length() < 16) {
            try {
                System.out.println("Ingresa 4 digitos(espacios ni guiones");
                tarje.numeroTarjeta = leer.next();

                //valida que la entrada tenga 4 digitos y todos sean numeros;

                if (tarje.numeroTarjeta.matches("[0-9]{4}")) {
                    numerosTarjeta.append(tarje.numeroTarjeta);
                } else {
                    System.out.println("Por favor ingresa 4 digitos (0-9) sin espacio ni guiones");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Error de ingreso.. Solo se permiten numeros enteros.");
                leer.next();
            }

        }
        numerosTarjeta.reverse();
        //invirtio la cadena
        tarje.numeroTarjeta = numerosTarjeta.toString();
        System.out.println("--------");
        System.out.println("--------");
        System.out.println("numero de tarjeta ingresado: " + tarje.numeroTarjeta);
    }

    public static void comprobarPar(Tarjeta tarje) {
        //recorrer el numero dentro del String Builder
        //los numeros en posicion impar debo hacer la suma
        // los numeros estan guardados en Tarjeta tarje.nume...
        System.out.println(tarje.getNumeroTarjeta());

        //Esta linea nose si es necesaria. mantenerla x las dudas

        StringBuilder numerosSueltos = new StringBuilder();

        //tarje.numeroTarjeta.
        for (int i = 0; i < tarje.numeroTarjeta.length(); i++) {
            if (i % 2 == 1) { //busca posiciones impares
                numerosSueltos.append(tarje.numeroTarjeta.charAt(i));
                //Estamos recorriendo para colocar los numeros en posicion impar y luuego mostrarlos por terminal


            }
        }
        tarje.setNumImpar(numerosSueltos.toString());
        //en el for de abajo probar con -1 y sin el
        int valorTotalSumadoFinal = 0;
        for (int i = 0; i < tarje.getNumeroTarjeta().length(); i++) {
            int valorTotalSumado = Character.getNumericValue(tarje.getNumeroTarjeta().charAt(i));
            valorTotalSumado *=2;
            if (valorTotalSumado >9){
                valorTotalSumado-=9;
            }
            valorTotalSumadoFinal += valorTotalSumado;
            //Este valor final es el que llevara para contemplar los patrones
        }
        System.out.println("Los numeros en posiciones impares son: " + tarje.getNumImpar());
        System.out.println("valor total de suma: " + valorTotalSumadoFinal);


            }

}
                    //4066-6319-3168-3010
                    //0103-8613-9136-6604
                    //13 63 16 64