(ns atividade.exercicio.clj)

(defn classificar-aluno
  "Lê a nota, determina o conceito e se o aluno foi aprovado."
  [nota]
  (let [conceito (cond
                   (>= nota 90) "A"
                   (>= nota 80) "B"
                   (>= nota 70) "C"
                   (>= nota 60) "D"
                   :else "F")
        aprovado? (>= nota 60)]
    ;; Retorna um mapa com ambos os resultados
    {:conceito conceito :aprovado? aprovado?}))

(defn -main []
  (println "Informe o total de alunos:")
  (let [total-alunos (Integer/parseInt (read-line))]
    (loop [aluno-atual 1
           soma-geral 0.0
           num-aprovados 0]
      (if (> aluno-atual total-alunos)

        ;; Parte final: exibe os resultados quando o loop termina
        (let [media (if (pos? total-alunos) (/ soma-geral total-alunos) 0)]
          (println "\n----- Resumo da Turma -----")
          (printf "Média geral: %.1f\n" media)
          (printf "Quantidade de aprovados: %d\n" num-aprovados)
          (println
           (str "Desempenho geral: "
                (if (>= media 80)
                  "Turma excelente!"
                  (if (>= media 60) "Bom desempenho!" "É necessário melhorar!")))))

        ;; Parte principal: executa para cada aluno
        (do
          (println (format "\n--- Aluno %d de %d ---" aluno-atual total-alunos))
          (print "Nome: ") (flush)
          (let [nome (read-line)]
            (print "Nota (0-100): ") (flush)
            (let [nota (Double/parseDouble (read-line))
                  {:keys [conceito aprovado?]} (classificar-aluno nota)]
              (println (format ">> %s | Conceito: %s" nome conceito))
              (recur (inc aluno-atual)
                     (+ soma-geral nota)
                     (if aprovado? (inc num-aprovados) num-aprovados)))))))))