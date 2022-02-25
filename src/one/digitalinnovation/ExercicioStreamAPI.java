package one.digitalinnovation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExercicioStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList(
                "1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        //System.out.println("Imprima todos os elementos dessa lista de String: ");
        //numerosAleatorios.stream().forEach(s -> System.out.println(s)); LAMBDA
        //numerosAleatorios.forEach(System.out::println);//REFERENCE METHOD

        System.out.println("\nPegue os 5 primeiros numeros e coloque dentro de um Set: ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::print);
        //Lembrando que Set nao aceita valores repetidos, portanto só temos um valor 1.

        System.out.println("\nTransforme esta lista de String em uma lista de Inteiros: ");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer num : numerosAleatoriosInteger) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nPegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> listParesMaioresQueDois = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQueDois);

        System.out.println("\nMostrea média dos números. ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\nRemova os valores impares: ");
        //Stream não modifica a nossa fonte, portanto, não podemos remover.
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);

        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante:");
        List<Integer> numerosAleatoriosSkip = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .skip(3)
                .collect(Collectors.toList());
        for (Integer num : numerosAleatoriosSkip) {
            System.out.print(num + " ");
        }

        System.out.print("\n\nRetirando os números repetidos da lista, quantos numeros ficam? ");
        Set<String> numerosAleatoriosSetSize = numerosAleatorios.stream()
                .collect(Collectors.toSet());
        System.out.println(numerosAleatoriosSetSize.size());

        System.out.print("\nMostre o menor valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.print("\nMostre o maior valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.print("\nPegue apenas os números impares e some: ");
        int somaNumerosImpares = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(value -> (value % 2 != 0))
                .sum();
        System.out.println(somaNumerosImpares);

        System.out.println("\nmostre a lista na ordem numerica:");
        numerosAleatorios.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println("\nAgrupe os valores impares multiplos de 3 e de 5: ");
        List<Integer> numerosMultiplosTresCinco = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 3 == 0 || i % 5 == 0) && i % 2 != 0)
                .collect(Collectors.toList());
        for (Integer num : numerosMultiplosTresCinco) {
            System.out.println(num + " ");
        }
    }
}