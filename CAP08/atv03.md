# Atividades para Casa – Capítulo 8

## Atividade 3 – Explorando alternativas ao `goto`

Historicamente, o `goto` foi usado para resolver diferentes tipos de desvio. Hoje, a maioria das linguagens fornece alternativas como `break`, `continue` e `return`.

**Tarefas:**
1. Escreva um programa que percorra uma lista de números inteiros e:
   - Pare imediatamente a execução ao encontrar o número 0 (`break`).
   - Pule os números negativos sem processá-los (`continue`).
   - Retorne o dobro do primeiro número par encontrado (`return`).
```c
#include <stdio.h>

int processa_lista(int numeros[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        if (numeros[i] == 0) {
            break; 
        }
        if (numeros[i] < 0) {
            continue; 
        }
        if (numeros[i] % 2 == 0) {
            return numeros[i] * 2; 
        }
    }
    return -1; 
}
int main() {
    int lista[] = {3, -2, 5, 7, -8, 4, 9, 0, 6};
    int tamanho = sizeof(lista) / sizeof(lista[0]);

    int resultado = processa_lista(lista, tamanho);

    if (resultado != -1) {
        printf("Resultado: %d\n");
    } else {
        printf("Nenhum par.\n");
    }

    return 0;
}
```
2. Comente sobre como seria a implementação desse mesmo programa utilizando apenas `goto` e rótulos, destacando as vantagens da abordagem moderna.

- **Resposta:** Se esse programa fosse escrito só com goto, seria preciso criar vários rótulos para controlar quando parar, quando pular e quando sair da função. Isso deixaria o código bem mais confuso, porque os saltos quebram o fluxo natural da leitura. Usando break, continue e return, o código fica mais simples, direto e fácil de entender, mostrando claramente a intenção de cada comando.
