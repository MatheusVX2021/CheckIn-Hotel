package com.example.checkinhotel;

public class Estandar extends Reserva
{
    public double costoDesayuno;

    public Estandar(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, double costoDesayuno)
    {
        super(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion);
        this.costoDesayuno = costoDesayuno;
    }

    public String mostrarDetalles()
    {
        return "Nombre: " + this.nombreHuesped + "\n" +
                "Fecha de ingreso: " + this.fechaIngreso + "\n" +
                "Noches: " + this.numeroNoches + "\n" +
                "Tarifa base: " + this.tarifaBase + "\n" +
                "Tipo: " + this.tipoHabitacion + "\n" +
                "Costo de desayuno: " + this.costoDesayuno + "\n\n" +
                "Costo total: " + calcularCostoTotal();
    }

    public double calcularCostoTotal()
    {
        return  this.tarifaBase * this.numeroNoches + this.costoDesayuno;
    }
}
