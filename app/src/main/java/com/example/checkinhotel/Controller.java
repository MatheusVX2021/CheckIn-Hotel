package com.example.checkinhotel;

import java.util.ArrayList;

public class Controller
{
    public ArrayList<Reserva> reservas = new ArrayList<>();

    public Controller()
    {
        reservas.add(new Estandar("Junior Villazon", "29/03/25", 1, 50, "Estandar", 5));
        reservas.add(new Estandar("Eli Villazon", "29/03/25", 2, 50, "Estandar", 5));
        reservas.add(new Deluxe("Franklin Villazon", "30/03/25", 3, 100, "Deluxe", true, 10));
        reservas.add(new Deluxe("Eliane Ximenes", "02/04/25", 2, 80, "Deluxe", false, 10));
        reservas.add(new Suite("Rosalinda Alvarez", "03/04/25", 5, 150, "Suite", 2, 20));
        reservas.add(new Suite("Matheus Villazon", "03/04/25", 5, 150, "Suite", 2, 20));
    }

    public void add_Estandar(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, double costoDesayuno)
    {
        reservas.add(new Estandar(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion, costoDesayuno));
    }

    public void add_Deluxe(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, boolean hasLounge, double servGourmet)
    {
        reservas.add(new Deluxe(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion, hasLounge, servGourmet));
    }

    public void add_Suite(String nombreHuesped, String fechaIngreso, int numeroNoches, double tarifaBase, String tipoHabitacion, int numSalas, double servPersonalizado)
    {
        reservas.add(new Suite(nombreHuesped, fechaIngreso, numeroNoches, tarifaBase, tipoHabitacion, numSalas, servPersonalizado));
    }

    public Reserva buscarReserva(String nombreHuesped)
    {
        for (Reserva reserva : reservas)
        {
            if (reserva.nombreHuesped.equals(nombreHuesped))
                return reserva;
        }
        return null;
    }
}
