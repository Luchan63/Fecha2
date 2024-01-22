//ejercicio 8.14
public class Fecha2
{
    private int dia;
    private int mes;
    private int anio;
    private static final int[] diaPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] nombreMeses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public Fecha2(int mes,int dia, int anio)
    {
        int numeroMes = getAnInt(mes);
        this.dia = dia;
        this.mes = numeroMes;
        this.anio = anio;
    }


    public Fecha2(String nombreMes,int dia, int anio) {
        int mes = getNumeroMes(nombreMes);
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;

    }

    public Fecha2(int dia,int anio)
    {
        //103 Días. Voy a iterar en qué mes estoy: 103 - 31 (enero): 72, 72 - 28 (febrero)= 44, 44 - 31 (marzo): 13, 13 - 30 (abril): -17 (Esto ya es el día en el que estoy)
        int mesActual = 0; // inicializamos 0
        int diasContados = dia; //representa una varia auxiliar

        for (int dias : diaPorMes) { // recorremos el array
            //
            int prueba = 1;
            diasContados -= dias; // en la variable auxiliar vamos restando los dias de cada mes que estan en el array
            mesActual++; // incrementamos el mes actual despues que restamos los dias

            if(diasContados < 0){ // evalua si la resta da un numero negativo quiere decir que el me que estamos restando no termino de consumir los dias
                diasContados += dias; // no quedo un numero negativo restamos de mas, entonces le asignmos los dias de ese mes y la diferencia que haya son los dias recorridos
                break;
            }
            if(diasContados == 0){ // no nos sobra ningun dia. y los dias contados quedan 0 quiere decir que quedan los dias enteros
                break;
            }
        }

        int numeroMes = getAnInt(mesActual);

        this.dia = diasContados; //Aquí va el resto después de calcular el mes.;
        this.mes = numeroMes; // sumar 1 porque los meses son de 1 a 12
        this.anio = anio;
    }

    // metodo para obtener el numero del mes
    private static int getAnInt(int mes) {
        int numeroMes = 0;
        String numeroNombreMes = nombreMeses[mes - 1];

        for (String nombreMes : nombreMeses) {
            numeroMes++;
            if (nombreMes.equalsIgnoreCase(numeroNombreMes))
            {
                numeroMes--;
                break;
            }
        }
        return numeroMes;
    }
    private int getNumeroMes(String nombreMes)
    {
        int numeroMes = 0;
        for (String mes : nombreMeses) {
            numeroMes++;
            if (mes.equalsIgnoreCase(nombreMes))
            {
                return numeroMes - 1;
            }
        }
        throw new IllegalArgumentException("Nombre de Mes no Valido");
    }

    // metodo ToString
    public String toString()
    {
       return String.format("%d/%d/%d",this.mes + 1,this.dia,this.anio);
    }

    public String toString2()
    {
        return String.format("%s/%02d/%02d" ,nombreMeses[mes],this.dia,this.anio);
    }

    public String toString3()
    {
        return String.format("%03d/%d",this.dia,this.anio);
    }
}





