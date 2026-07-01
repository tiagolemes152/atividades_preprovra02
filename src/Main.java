import java.util.Scanner;

class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class ListaEncadeada {

    private No head;

    public void inserir(int valor) {

        No novo = new No(valor);

        if (head == null) {
            head = novo;
            return;
        }

        No atual = head;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = novo;
    }

    public int pesquisa(int valor) {

        No atual = head;

        while (atual != null) {

            if (atual.dado == valor) {
                return 1;
            }

            atual = atual.proximo;
        }

        return 0;
    }

    public boolean estaOrdenada() {

        if (head == null || head.proximo == null) {
            return true;
        }

        No atual = head;

        while (atual.proximo != null) {

            if (atual.dado > atual.proximo.dado) {
                return false;
            }

            atual = atual.proximo;
        }

        return true;
    }

    public void removerPares() {

        while (head != null && head.dado % 2 == 0) {
            head = head.proximo;
        }

        No atual = head;

        while (atual != null && atual.proximo != null) {

            if (atual.proximo.dado % 2 == 0) {
                atual.proximo = atual.proximo.proximo;
            } else {
                atual = atual.proximo;
            }
        }
    }

    public void mostrar() {

        No atual = head;

        while (atual != null) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        }

        System.out.println("null");
    }
}

public class Main {

    public static int somaVetor(int[] vetor, int indice) {

        if (indice == vetor.length) {
            return 0;
        }

        return vetor[indice] + somaVetor(vetor, indice + 1);
    }

    public static void decimalParaBinario(int numero) {

        if (numero == 0) {
            return;
        }

        decimalParaBinario(numero / 2);

        System.out.print(numero % 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaEncadeada lista = new ListaEncadeada();

        System.out.print("Quantos elementos deseja inserir na lista? ");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            lista.inserir(sc.nextInt());
        }

        System.out.println("\nLista:");
        lista.mostrar();

        System.out.print("\nDigite um valor para pesquisar: ");
        int valor = sc.nextInt();

        System.out.println("Resultado da pesquisa: " + lista.pesquisa(valor));

        System.out.println("\nLista em ordem crescente? " + lista.estaOrdenada());

        lista.removerPares();

        System.out.println("\nLista após remover os números pares:");
        lista.mostrar();

        System.out.print("\nQuantidade de elementos do vetor: ");
        int n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i + 1) + "º elemento: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("\nSoma do vetor: " + somaVetor(vetor, 0));

        System.out.print("\nDigite um número decimal para converter em binário: ");
        int numero = sc.nextInt();

        if (numero == 0) {
            System.out.println("Binário: 0");
        } else {
            System.out.print("Binário: ");
            decimalParaBinario(numero);
            System.out.println();
        }

        sc.close();
    }
}

