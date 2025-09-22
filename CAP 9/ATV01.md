# Exercícios – Capítulo 9: Subprogramas

## Exercício 1 – Passagem de Parâmetros por Valor e por Referência

Considere o seguinte pseudocódigo de uma função que tenta dobrar o valor de um número:

```text
procedure dobrar(x)
    x := x * 2
end
```

### 1. Implementação em C

Implementação do subprograma em **C** de duas maneiras: a primeira recebendo o parâmetro **por valor** e a segunda **por referência** (usando ponteiros).

### 2. Programa Principal

O código abaixo contém as duas versões da função e o programa principal que as executa para demonstrar a diferença.

#### Código Completo (`main.c`)
```c
#include <stdio.h>

// Versão 1: Recebendo o parâmetro POR VALOR
void dobrarPorValor(int x) {
    printf("    [Dentro de dobrarPorValor] Valor recebido (cópia): %d\n", x);
    x = x * 2;
    printf("    [Dentro de dobrarPorValor] Valor alterado (cópia): %d\n", x);
}

// Versão 2: Recebendo o parâmetro POR REFERÊNCIA (usando ponteiro)
void dobrarPorReferencia(int *x) {
    printf("    [Dentro de dobrarPorReferencia] Valor no endereço recebido: %d\n", *x);
    *x = *x * 2; // Altera o valor original diretamente na memória
    printf("    [Dentro de dobrarPorReferencia] Valor alterado (original): %d\n", *x);
}

// Programa Principal
int main() {
    int numero = 10;
    printf("Valor inicial da variável 'numero': %d\n\n", numero);
    
    printf("----------------------------------------\n");
    printf("Chamando dobrarPorValor...\n");
    dobrarPorValor(numero);
    printf("Valor de 'numero' APÓS chamar por VALOR: %d\n", numero);
    printf("----------------------------------------\n\n");

    printf("----------------------------------------\n");
    printf("Chamando dobrarPorReferencia...\n");
    // O '&' antes de 'numero' obtém o endereço de memória da variável
    dobrarPorReferencia(&numero);
    printf("Valor de 'numero' APÓS chamar por REFERÊNCIA: %d\n", numero);
    printf("----------------------------------------\n");

    return 0;
}
```

#### Saída Esperada
```console
Valor inicial da variável 'numero': 10

----------------------------------------
Chamando dobrarPorValor...
    [Dentro de dobrarPorValor] Valor recebido (cópia): 10
    [Dentro de dobrarPorValor] Valor alterado (cópia): 20
Valor de 'numero' APÓS chamar por VALOR: 10
----------------------------------------

----------------------------------------
Chamando dobrarPorReferencia...
    [Dentro de dobrarPorReferencia] Valor no endereço recebido: 10
    [Dentro de dobrarPorReferencia] Valor alterado (original): 20
Valor de 'numero' APÓS chamar por REFERÊNCIA: 20
----------------------------------------
```

---

### Questões

**1. Qual a diferença observada entre as duas versões?**
> A diferença principal observada na saída é que, após a chamada da função `dobrarPorValor`, a variável `numero` no programa principal não tem seu valor alterado, permanecendo `10`. Em contraste, após a chamada da função `dobrarPorReferencia`, o valor da variável `numero` no programa principal é permanentemente alterado para `20`.

**2. Por que o valor da variável só se altera na versão por referência?**
> O valor só se altera na versão por referência por causa da forma como os dados são passados para a função em cada caso.
> - **Por Valor:** Eu te dou uma **fotocópia** de um documento. Você pode riscar e alterar a fotocópia à vontade, mas o meu documento original continua perfeito.
> - **Por Referência:** Eu te dou o **endereço** da minha casa. Você vai até a minha casa e pinta a parede. A parede original foi alterada.

**3. Relacione essa diferença com as estratégias de passagem de parâmetros discutidas no Capítulo 9.**
> A escolha entre passagem por valor e por referência é uma decisão de design que equilibra segurança, eficiência e a necessidade de a função modificar ou não os dados de quem a chamou.
