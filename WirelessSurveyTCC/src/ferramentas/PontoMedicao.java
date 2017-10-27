/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

/**
 *
 * @author vinicius_023
 */
public class PontoMedicao {
    
    int x,y;
    String interfaceRedeWireless;
    String endereco;
    int canal;
    float frequencia;
    int qualidade, intencidade;
    boolean criptografia;
    String essid;
    String bitRates;
    String tipoCriptografia;

    public PontoMedicao() {
    }

    public PontoMedicao(int x, int y, String interfaceRedeWireless, String endereco, int canal, float frequencia, int qualidade, int intencidade, boolean criptografia, String essid, String bitRates, String tipoCriptografia) {
        this.x = x;
        this.y = y;
        this.interfaceRedeWireless = interfaceRedeWireless;
        this.endereco = endereco;
        this.canal = canal;
        this.frequencia = frequencia;
        this.qualidade = qualidade;
        this.intencidade = intencidade;
        this.criptografia = criptografia;
        this.essid = essid;
        this.bitRates = bitRates;
        this.tipoCriptografia = tipoCriptografia;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getInterfaceRedeWireless() {
        return interfaceRedeWireless;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getCanal() {
        return canal;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public int getQualidade() {
        return qualidade;
    }

    public int getIntencidade() {
        return intencidade;
    }

    public boolean isCriptografia() {
        return criptografia;
    }

    public String getEssid() {
        return essid;
    }

    public String getBitRates() {
        return bitRates;
    }

    public String getTipoCriptografia() {
        return tipoCriptografia;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInterfaceRedeWireless(String interfaceRedeWireless) {
        this.interfaceRedeWireless = interfaceRedeWireless;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public void setFrequencia(float frequencia) {
        this.frequencia = frequencia;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public void setIntencidade(int intencidade) {
        this.intencidade = intencidade;
    }

    public void setCriptografia(boolean criptografia) {
        this.criptografia = criptografia;
    }

    public void setEssid(String essid) {
        this.essid = essid;
    }

    public void setBitRates(String bitRates) {
        this.bitRates = bitRates;
    }

    public void setTipoCriptografia(String tipoCriptografia) {
        this.tipoCriptografia = tipoCriptografia;
    }
    
}
