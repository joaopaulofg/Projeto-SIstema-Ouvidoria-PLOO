package ouvidoria;

public class Manifestacao {

    private int idManifestacao;
    private String tipoManifestacao;
    private String nomeManifestante;
    private String textoManifestacao;

    Manifestacao(String tipoManifestacao, String nomeManifestante, String textoManifestacao) {
        this.tipoManifestacao = tipoManifestacao;
        this.nomeManifestante = nomeManifestante;
        this.textoManifestacao = textoManifestacao;
    }

    Manifestacao(int idManifestacao, String tipoManifestacao, String nomeManifestante, String textoManifestacao) {
        this.idManifestacao = idManifestacao;
        this.tipoManifestacao = tipoManifestacao;
        this.nomeManifestante = nomeManifestante;
        this.textoManifestacao = textoManifestacao;
    }

    public int getIdManifestacao() {
        return idManifestacao;
    }

    public String getTipoManifestacao() {
        return tipoManifestacao;
    }

    public String getNomeManifestante() {
        return nomeManifestante;
    }

    public String getTextoManifestacao() {
        return textoManifestacao;
    }

    public void setTextoManifestacao(String textoManifestacao) {
        this.textoManifestacao = textoManifestacao;
    }

}
