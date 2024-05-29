package provaA3.Beans;

import provaA3.Beans.Garcom;

public class Mesa {
    private int numeroMesa;
    private int capacidadeClientes;
    private String statusMesa;
    private Garcom garcomResponsavelMesa;

    public Mesa(){
    }

    public Mesa(int numeroMesa, int capacidadeClientes, String statusMesa, Garcom garcomResponsavelMesa){
        this.numeroMesa = numeroMesa;
        this.capacidadeClientes = capacidadeClientes;
        this.statusMesa = statusMesa;
        this.garcomResponsavelMesa = garcomResponsavelMesa;

    }

    public int getCapacidadeClientes(){ return capacidadeClientes;}
    public void setCapacidadeClientes(int capacidadeClientes){ this.capacidadeClientes = capacidadeClientes;}

    public String getStatusMesa() { return statusMesa;}
    public void setStatusMesa(String  statusMesa){ this.statusMesa = statusMesa;}

    public Garcom getGarcomResponsavelMesa(){ return garcomResponsavelMesa;}
    public void setGarcomResponsavelMesa(Garcom garcomResponsavelMesa) { this.garcomResponsavelMesa = garcomResponsavelMesa;}

    public int getNumeroMesa(){ return numeroMesa;}
    public void setNumeroMesa(int numeroMesa){ this.numeroMesa = numeroMesa;}
}
