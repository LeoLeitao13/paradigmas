# Exercício 2 – Corrotinas em GoLang (primeiro contato)

As **corrotinas** permitem a execução concorrente de rotinas dentro de um programa. Em Go, isso é feito de forma muito simples com a palavra-chave `go`.

### 1. Tarefas

1.  Criar um arquivo chamado `main.go`.
2.  Implementar o programa abaixo.
3.  Compilar e executar o programa com o comando: `go run main.go`.

### 2. Código (`main.go`)

```go
package main

import (
	"fmt"
	"time"
)

// A função 'escrever' imprime um texto 5 vezes, com uma pausa entre cada impressão.
func escrever(texto string) {
	for i := 0; i < 5; i++ {
		fmt.Println(texto, i)
		time.Sleep(time.Millisecond * 500)
	}
}

func main() {
	// A palavra 'go' inicia a função em uma nova corrotina (goroutine).
	// O programa não espera ela terminar e continua a execução.
	go escrever("Corrotina")

	// Esta é uma chamada de função normal, síncrona.
	// O programa principal executa esta função até o fim.
	escrever("Função normal")
}
```

### 3. Resultado da Execução (Exemplo)

A ordem exata da saída pode variar a cada execução, pois essa é a natureza da concorrência.

```console
Corrotina 0
Função normal 0
Corrotina 1
Função normal 1
Corrotina 2
Função normal 2
Função normal 3
Corrotina 3
Função normal 4
Corrotina 4
```

---

### Questões (Respostas Resumidas)

**1. O que acontece com a ordem das mensagens exibidas?**
> As mensagens não seguem uma ordem fixa, aparecendo de forma **intercalada**. Isso ocorre porque as duas rotinas rodam ao mesmo tempo (de forma concorrente), disputando a vez de escrever no console.

**2. Por que as mensagens da corrotina e da função normal se intercalam?**
> A chamada com `go` inicia uma **corrotina** que roda em paralelo, sem travar o programa. A chamada normal é **síncrona** e bloqueia a execução principal. O Go alterna o processamento entre as duas, e a pausa (`time.Sleep`) em uma dá a chance para a outra rodar, causando a intercalação.

**3. Relacione esse comportamento com a definição de `corrotinas`.**
> O comportamento é a definição de corrotinas na prática: são rotinas que executam de forma **concorrente**. A palavra `go` cria essa concorrência, e o `time.Sleep` age como um ponto de pausa onde uma rotina "cede" sua vez à outra, caracterizando a **multitarefa cooperativa**.
