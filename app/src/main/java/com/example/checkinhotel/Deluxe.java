package com.example.checkinhotel;

public class Deluxe extends Reserva
{
    public boolean hasLounge;
    public double servGourmet;

    public Deluxe(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, boolean hasLounge, double servGourmet)
    {
        super(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion);
        this.hasLounge = hasLounge;
        this.servGourmet = servGourmet;
    }

    public String mostrarDetalles()
    {
        return "Nombre: " + this.nombreHuesped + "\n" +
                "Fecha de ingreso: " + this.fechaIngreso + "\n" +
                "Noches: " + this.numeroNoches + "\n" +
                "Tarifa base: " + this.tarifaBase + "\n" +
                "Tipo: " + this.tipoHabitacion + "\n" +
                "Incluye Lounge: " + this.hasLounge + "\n" +
                "Costo Serv. Gourmet: " + this.servGourmet + "\n\n"  +
                "Costo total: " + calcularTotal();
    }

    public double calcularTotal()
    {
        return this.tarifaBase * this.numeroNoches + (this.hasLounge ? 50 : 0) + this.servGourmet;

    }
}
