package provaA3.Beans;

public class Garcom {
    private int codigoGarcom;
    private String nomeGarcom;
    private String cpfGarcom;
    private String emailGarcom;
    private String sexoGarcom;
    private String dtNascimentoGarcom;
    private String telefoneGarcom;
    private float salarioGarcom;

    public Garcom(){
    }

    public Garcom(int codigoGarcom, String nomeGarcom, String cpfGarcom, String emailGarcom, String sexoGarcom, String dtNascimentoGarcom, String telefoneGarcom, float salarioGarcom){
        this.codigoGarcom = codigoGarcom;
        this.nomeGarcom = nomeGarcom;
        this.cpfGarcom = cpfGarcom;
        this.emailGarcom = emailGarcom;
        this.sexoGarcom = sexoGarcom;
        this.dtNascimentoGarcom =dtNascimentoGarcom;
        this.telefoneGarcom = telefoneGarcom;
        this.salarioGarcom = salarioGarcom;
    }

    public String getNomeGarcom() { return nomeGarcom;}
    public void setNomeGarcom(String nomeGarcom) { this.nomeGarcom = nomeGarcom;}

    public String getCpfGarcom() { return cpfGarcom;}
    public void setCpfGarcom(String cpfGarcom){ this.cpfGarcom = cpfGarcom;}

    public String getEmailGarcom() {return emailGarcom;}
    public void setEmailGarcom(String emailGarcom){ this.emailGarcom = emailGarcom;}

    public String getSexoGarcom() { return sexoGarcom;}
    public void setSexoGarcom(String sexoGarcom) { this.sexoGarcom = sexoGarcom;}

    public String getDtNascimentoGarcom() { return dtNascimentoGarcom;}
    public void setDtNascimentoGarcom(String dtNascimentoGarcom) { this.dtNascimentoGarcom = dtNascimentoGarcom;}

    public String getTelefoneGarcom() { return telefoneGarcom;}
    public void setTelefoneGarcom(String telefoneGarcom) { this.telefoneGarcom = telefoneGarcom;}


    public float getSalario() { return salarioGarcom;}
    public void setSalarioGarcom(float salarioGarcom) { this.salarioGarcom = salarioGarcom;}

    public int getCodigoGarcom() { return codigoGarcom;}
    public void setCodigoGarcom(int codigoGarcom) { this.codigoGarcom = codigoGarcom;}
}
