# Atividade 2 – Seleção múltipla em diferentes linguagens

## O Problema

Implementar um menu interativo com três opções em C e Python:
1.  Calcular o quadrado de um número.
2.  Calcular o fatorial de um número.
3.  Sair do programa.

## 1. Implementação em C com `switch/case`

```c
#include <stdio.h>

int main() {
    int opcao;
    
    do {
        printf("\n--- MENU ---\n");
        printf("1. Calcular Quadrado\n");
        printf("2. Calcular Fatorial\n");
        printf("3. Sair\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1: {
                int num;
                printf("Digite um numero: ");
                scanf("%d", &num);
                printf("Resultado: %d\n", num * num);
                break;
            }
            case 2: {
                int num;
                long long fatorial = 1;
                printf("Digite um numero: ");
                scanf("%d", &num);
                
                if (num < 0) {
                    printf("Erro: Fatorial nao definido para negativos.\n");
                } else {
                    for (int i = 1; i <= num; ++i) {
                        fatorial *= i;
                    }
                    printf("Resultado: %lld\n", fatorial);
                }
                break;
            }
            case 3:
                printf("Saindo do programa...\n");
                break;
            default:
                printf("Opcao invalida! Tente novamente.\n");
                break;
        }
    } while (opcao != 3);

    return 0;
}
```

## 2. Implementação em Python com `if/elif/else`

```python
import math

while True:
    print("\n--- MENU ---")
    print("1. Calcular Quadrado")
    print("2. Calcular Fatorial")
    print("3. Sair")
    
    opcao = int(input("Escolha uma opcao: "))

    if opcao == 1:
        num = int(input("Digite um numero: "))
        print(f"Resultado: {num ** 2}")
    elif opcao == 2:
        num = int(input("Digite um numero: "))
        if num < 0:
            print("Erro: Fatorial nao definido para negativos.")
        else:
            print(f"Resultado: {math.factorial(num)}")
    elif opcao == 3:
        print("Saindo do programa...")
        break
    else:
        print("Opcao invalida! Tente novamente.")
```

## 3. Execute os dois programas e compare as soluções em relação à clareza e quantidade de código.

* **Quantidade de Código e Clareza:** A versão em **Python** é visivelmente mais curta e direta. A sintaxe para ler dados do usuário, calcular e imprimir é mais enxuta. A estrutura `if/elif/else` é muito intuitiva e se assemelha à linguagem natural. A versão em **C** é mais verbosa, exigindo declaração explícita de tipos, gerenciamento de ponteiros para `scanf`, e a sintaxe `switch/case` com seus `break`s obrigatórios torna o código mais longo e um pouco menos fluído.
## 4. Escreva um comentário final destacando em qual linguagem foi mais simples de implementar e justificar o motivo.
* **Qual foi mais simples?** A implementação em **Python foi indiscutivelmente mais simples**. O motivo é a sua natureza de alto nível, que abstrai muitas complexidades. Funções prontas como `math.factorial` e a simplicidade de ler e converter tipos com `int(input())` reduzem drasticamente o esforço e a quantidade de código necessário, tornando o desenvolvimento mais rápido e menos suscetível a erros para uma tarefa como esta.
