# Atividade 1 – Reescrevendo código sem `goto`

## O Problema

Você recebeu o seguinte pseudocódigo que utiliza `goto` para controlar o fluxo de execução:

```text
i := 1
goto check

loop:
    print(i)
    i := i + 1

check:
    if (i <= 10) then
        goto loop
```

**Tarefas:**
1. Reescreva o código utilizando um laço de repetição `while`.
2. Reescreva novamente utilizando um laço de repetição `for`.
3. Compare os três códigos e discuta qual forma é mais legível e por quê.

---

## 1. Versão com `while` (Laço Pré-teste)

```python
i = 1

while i <= 10:
    print(i)
    i = i + 1
```

## 2. Versão com `for` (Laço de Contador)

```python
for i in range(1, 11):
    print(i)
```

## 3. Comparação de Legibilidade (Resumo)

A legibilidade melhora drasticamente ao abandonar o goto em favor de laços estruturados.

* **goto (Original):** **A pior legibilidade.** Cria um fluxo não linear, difícil de seguir e propenso a erros, conhecido como "código espaguete".
* **while:** **Legibilidade boa.** Utiliza programação estruturada, criando um bloco de código lógico e previsível. No entanto, ainda requer o controle manual do contador (inicialização, incremento).
* **for:** **A melhor legibilidade para este caso.** É a forma mais clara e segura, pois expressa a intenção exata ("iterar N vezes") e gerencia o contador automaticamente, reduzindo a complexidade e a chance de bugs.
