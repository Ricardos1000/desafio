package br.com.connexaoinformatica.modelos;

import java.util.ArrayList;
import java.util.List;

public class Cartao {

    private double limite;
    private double saldo;

    List<Compra> compras;

    public Cartao(double limite){
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();

    }

    public boolean lancaCompra(Compra compras){
        if(this.saldo > compras.getValor()){
            this.saldo -= compras.getValor();
            this.compras.add(compras);
            return true;
        }else{
            return false;
        }
    }

    public double getLimite() {

        return this.limite;
    }

    public double getSaldo() {

        return this.saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public String toString(){
        return "Limite "
                + this.limite
                +" Total de Compras "+ saldo;
    }

}
