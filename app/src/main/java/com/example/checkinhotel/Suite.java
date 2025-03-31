package com.example.checkinhotel;

public class Suite extends Reserva
{
    public int numSalas;
    public double servPersonalizado;

    public Suite(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, int numSalas, double servPersonalizado)
    {
        super(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion);
        this.numSalas = numSalas;
        this.servPersonalizado = servPersonalizado;
    }

    public String mostrarDetalles()
    {
        return "Nombre: " + this.nombreHuesped + "\n" +
                "Fecha de ingreso: " + this.fechaIngreso + "\n" +
                "Noches: " + this.numeroNoches + "\n" +
                "Tarifa base: " + this.tarifaBase + "\n" +
                "Tipo: " + this.tipoHabitacion + "\n" +
                "Num Salas: " + this.numSalas + "\n" +
                "Serv. Personalizado: " + this.servPersonalizado + "\n\n" +
                "Costo total: " + calcularTotal();
    }

    public double calcularTotal()
    {
        return this.tarifaBase * this.numeroNoches + (this.numSalas * 100) + this.servPersonalizado;
    }
}
