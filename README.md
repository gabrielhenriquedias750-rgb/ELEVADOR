# Atividade Elevador

Projeto em Java que representa o funcionamento basico de um elevador, atendendo as restricoes solicitadas na atividade:

- nao sobe acima do ultimo andar disponivel;
- nao desce abaixo do andar minimo disponivel;
- nao sobe nem desce com a porta aberta.

## Estrutura

- `src/Elevador.java`: classe principal com regras e estados do elevador.
- `src/Main.java`: cria um objeto `Elevador` e demonstra o uso dos metodos.
- `docs/uml/elevador-classe.png`: diagrama de classe da UML em formato PNG.

## Como executar

```powershell
javac -d out src/*.java
java -cp out Main
```

## Diagrama UML

O diagrama esta disponivel em:

- `docs/uml/elevador-classe.png`
