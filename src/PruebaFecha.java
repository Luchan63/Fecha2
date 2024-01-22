public class PruebaFecha
{
    public static void main(String[] args)
    {
        try {
            Fecha2 fecha = new Fecha2(1,21,2024);
            System.out.println("MM/DD/AAAA " + fecha);

            Fecha2 fecha2 = new Fecha2("enero",21,2024);
            System.out.println("Mes/DD/AAAA " + fecha2.toString2());

            Fecha2 fecha3 = new Fecha2(21,2024);
            System.out.println("DDD AAAA " + fecha3.toString3());

            System.out.println(fecha.toString().equals(fecha2.toString()));
            System.out.println(fecha2.toString().equals(fecha3.toString()));
            System.out.println(fecha3.toString().equals(fecha.toString()));

        }
            catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
