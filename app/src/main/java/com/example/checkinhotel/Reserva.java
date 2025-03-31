package com.example.checkinhotel;

public class Reserva
{
    public String nombreHuesped;
    public String fechaIngreso;
    public int numeroNoches;
    public double tarifaBase;
    public String tipoHabitacion;

    public Reserva(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion)
    {
        this.nombreHuesped = nombreHuesped;
        this.fechaIngreso = fechaIngreso;
        this.numeroNoches = numeroNoches;
        this.tarifaBase = tarifaBase;
        this.tipoHabitacion = tipoHabitacion;
    }

}
