package one.digitalinnovation;

import java.util.*;
import java.util.function.Function;

public class StreamAPIExemplo {
    public static void main(String[] args) {

        System.out.println("ORDEM ALEATÓRIA");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Jesus", 5555));
            put(4, new Contato("Maria", 1111));
            put(3, new Contato("José", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nORDEM INSERÇÃO");
        Map<Integer, Contato> agendaLinked = new LinkedHashMap<>() {{
            put(1, new Contato("Jesus", 5555));
            put(4, new Contato("Maria", 1111));
            put(3, new Contato("José", 2222));
        }};
        System.out.println(agendaLinked);
        for (Map.Entry<Integer, Contato> entry : agendaLinked.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nORDEM ID");
        Map<Integer, Contato> agendaTree = new TreeMap<>(agenda);
        System.out.println(agendaTree);
        for (Map.Entry<Integer, Contato> entry : agendaTree.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nORDEM NÚMERO DE TELEFONE");
        //REFATORANDO O CODIGO PARA A UTILIZAÇÃO DE CLASSE ANONIMA
        /*Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> contato1, Map.Entry<Integer, Contato> contato2) {
                return Integer.compare(contato1.getValue().getNumero(), contato2.getValue().getNumero());
            }
        });*/

        //REFATORANDO O CODIGO PARA A UTILIZAÇÃO DE FUNCIONAL INTERFACE
        /*Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> contatoTemp) {
                        return contatoTemp.getValue().getNumero();
                    }
                }));*/

        //REFATORANDO O CODIGO PARA A UTILIZAÇÃO DE LAMBDA
        Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(
                Comparator.comparing(contatoTemp -> contatoTemp.getValue().getNumero()));

        agendaSet.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " + entry.getValue().getNome());
        }

        System.out.println("\nORDEM NOME DO CONTATO");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> agendaSet2 = new TreeSet<>(
                Comparator.comparing(contatoTemp -> contatoTemp.getValue().getNome()));
        agendaSet2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet2) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}

//class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
//    @Override
//    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
//    }
//}

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}

