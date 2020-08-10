package projeto;


public class FonteEnergia {

    private long potenciaProduzida;
    private String tipoFonteEnergia;
    private String idPSS;
    private int idPS;
    private static int ACTUAL_ID = 99;

    public FonteEnergia(long potenciaProduzida, String tipoFonteEnergia) {
        this.potenciaProduzida = potenciaProduzida;
        this.setTipoFonteEnergia(tipoFonteEnergia);
        this.setIdPSS(("FE" + (++ACTUAL_ID)));
        this.setIdPS(ACTUAL_ID);
    }

    public FonteEnergia(long potenciaProduzida, String tipoFonteEnergia, int idPS) {
        this.potenciaProduzida = potenciaProduzida;
        this.setTipoFonteEnergia(tipoFonteEnergia);
        this.setIdPSS(("FE" + idPS));
        this.setIdPS(idPS);
    }


    public boolean isCapable() {

        return false;
    }

    public double getPotenciaProduzida() {

        return potenciaProduzida;

    }

    public void setPotenciaProduzida(long potenciaProduzida) {
        this.potenciaProduzida = potenciaProduzida;

    }

    public String getIdPSS() {
        return idPSS;
    }

    public void setIdPSS(String idPSS) {
        this.idPSS = idPSS;
    }

    public int getIdPS(){
        return idPS;
    }

    public void setIdPS(int idPS) {
        this.idPS = idPS;
    }


    public String getTipoFonteEnergia() {
        return tipoFonteEnergia;
    }

    public void setTipoFonteEnergia(String tipoFonteEnergia) {
        this.tipoFonteEnergia = tipoFonteEnergia;
    }

    @Override
    public String toString() {
        return  "ID Fonte: " + getIdPSS() + "\t|"  +
                "\tTipo de Energia: '" + tipoFonteEnergia + "'\t\t|" +
                "\tEnergia produzida: " + potenciaProduzida + "w";
    }

}