package com.builders.utils;

import com.builders.domain.Cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Util {

    public static int CalculaIdade(Cliente cliente) {
        return(int) Period.between(cliente.getDataNascimento(), LocalDate.now()).getYears();
    }

}
