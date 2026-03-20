public class Main {
    public static void main(String[] args) {
        Elevador elevador = new Elevador(0, 5);

        System.out.println("=== Simulacao do Elevador ===");
        mostrarEstado("Estado inicial", elevador);

        elevador.abrirPorta();
        mostrarEstado("Porta aberta", elevador);

        executarAcao("Tentar subir com a porta aberta", elevador::subir);

        elevador.fecharPorta();
        mostrarEstado("Porta fechada", elevador);

        executarAcao("Subir para o primeiro andar", elevador::subir);
        executarAcao("Subir para o segundo andar", elevador::subir);
        mostrarEstado("Depois de subir duas vezes", elevador);

        elevador.abrirPorta();
        mostrarEstado("Porta aberta no segundo andar", elevador);

        executarAcao("Tentar descer com a porta aberta", elevador::descer);

        elevador.fecharPorta();
        executarAcao("Descer para o primeiro andar", elevador::descer);
        executarAcao("Descer para o terreo", elevador::descer);
        mostrarEstado("Depois de descer", elevador);

        executarAcao("Tentar descer abaixo do terreo", elevador::descer);

        executarAcao("Subir para o primeiro andar", elevador::subir);
        executarAcao("Subir para o segundo andar", elevador::subir);
        executarAcao("Subir para o terceiro andar", elevador::subir);
        executarAcao("Subir para o quarto andar", elevador::subir);
        executarAcao("Subir para o quinto andar", elevador::subir);
        mostrarEstado("No ultimo andar", elevador);

        executarAcao("Tentar subir acima do limite", elevador::subir);
    }

    private static void mostrarEstado(String contexto, Elevador elevador) {
        System.out.printf(
                "%s -> andar atual: %d | porta: %s%n",
                contexto,
                elevador.getAndarAtual(),
                elevador.getStatusPorta()
        );
    }

    private static void executarAcao(String descricao, Runnable acao) {
        try {
            acao.run();
            System.out.println(descricao + ": sucesso.");
        } catch (IllegalStateException exception) {
            System.out.println(descricao + ": " + exception.getMessage());
        }
    }
}
