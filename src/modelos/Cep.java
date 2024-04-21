package modelos;

public class Cep {
    private String cepNumber;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Cep(Viacep c){
        cepNumber = c.cep();
        logradouro = c.logradouro();
        complemento = c.complemento();
        bairro = c.bairro();
        localidade = c.localidade();
        uf = c.uf();
        ibge = c.ibge();
        gia = c.gia();
        ddd = c.ddd();
        siafi = c.siafi();
    }

    public String getCepNumber() {
        return cepNumber;
    }

    public void setCepNumber(String cepNumber) {
        this.cepNumber = cepNumber;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    @Override
    public String toString() {
        return "Número do CEP: "+ getCepNumber() + "\nLogradouro: " + getLogradouro() + "\nComplemento: "+
                getComplemento() + "\nBairro: "+ getBairro()+ "\nLocalidade: "+ getLocalidade() + "\nuf:"+
                getUf() + "\nibge: " + getIbge() + "\ngia: "+ getGia() + "\nDDD: " + getDdd() + "\nSiafi:" + getSiafi();
    }
}
