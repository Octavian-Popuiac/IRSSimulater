public class Sujeito {
    private final String nome;
    private final int nif;
    private int grauDef = 0;
    private boolean defArmadas = false;
    private int salario;
    private int iban;
    private boolean solteiro = true;

    public Sujeito(String nome, int nif) {
        this.nome = nome;
        this.nif = nif;
        System.out.println("Sujeito\nNome : " + this.nome + " | nif : " + this.nif);
    }

    public void setSolteiro(boolean solteiro) {
        this.solteiro = solteiro;
    }

    public void setGrauDef(int grauDef) {
        this.grauDef = grauDef;
    }

    public void setDefArmadas(boolean defArmadas) {
        this.defArmadas = defArmadas;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public String getNome() {
        return nome;
    }

    public int getNif() {
        return nif;
    }

    public boolean isSolteiro() {
        return solteiro;
    }

    public int getGrauDef() {
        return grauDef;
    }

    public boolean isDefArmadas() {
        return defArmadas;
    }

    public int getSalario() {
        return salario;
    }

    public int getIban() {
        return iban;
    }
}
