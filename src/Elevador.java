public class Elevador {
    private final int andarMinimo;
    private final int andarMaximo;
    private int andarAtual;
    private boolean portaAberta;

    public Elevador(int andarMinimo, int andarMaximo) {
        if (andarMinimo >= andarMaximo) {
            throw new IllegalArgumentException("O andar minimo deve ser menor que o andar maximo.");
        }

        this.andarMinimo = andarMinimo;
        this.andarMaximo = andarMaximo;
        this.andarAtual = andarMinimo;
        this.portaAberta = false;
    }

    public void subir() {
        validarPortaFechada("subir");

        if (andarAtual >= andarMaximo) {
            throw new IllegalStateException("O elevador ja esta no ultimo andar disponivel.");
        }

        andarAtual++;
    }

    public void descer() {
        validarPortaFechada("descer");

        if (andarAtual <= andarMinimo) {
            throw new IllegalStateException("O elevador ja esta no andar mais baixo disponivel.");
        }

        andarAtual--;
    }

    public void abrirPorta() {
        portaAberta = true;
    }

    public void fecharPorta() {
        portaAberta = false;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public String getStatusPorta() {
        return portaAberta ? "aberta" : "fechada";
    }

    public int getAndarMinimo() {
        return andarMinimo;
    }

    public int getAndarMaximo() {
        return andarMaximo;
    }

    private void validarPortaFechada(String acao) {
        if (portaAberta) {
            throw new IllegalStateException("Nao e possivel " + acao + " com a porta aberta.");
        }
    }

    @Override
    public String toString() {
        return "Elevador{" +
                "andarAtual=" + andarAtual +
                ", porta=" + getStatusPorta() +
                ", intervalo=[" + andarMinimo + ", " + andarMaximo + "]" +
                '}';
    }
}
