package com.core.employee;

import com.core.employee.queue.Fifo;
import com.core.employee.interfaces.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Escreva um programa que permita implementar uma lista Fifo duplamente encadeada.
 * Cada nodo da lista terá 4 campos:
 * - 1 Armazenar Matricula
 * - 1 Armazenar Idade
 * - 2 Armazenar endereço dos nodos vizinhos
 * <p>
 * O programa deve apresentar o seguinte Menu:
 * 1 - enqueue
 * 2 - dequeue
 * 3 - mostrar
 * 4 - mostrar invertido
 * 5 - procurar
 * 6 - cabeça
 * 7 - cauda
 * 8 - media
 * 9 - vazar
 * <p>
 * Se a opção 1 for selecionada, o programa pede os dados do funcionário e insere-o na lista e retorna para o menu
 * Se a opção 2 for selecionada, o programa retira um funcionário, mostra a matricula e retorna para o menu
 * Se a opção 3 for selecionada, o programa mostra as matriculas cadastradas e retorna para o menu
 * Se a opção 4 for selecionada, o programa mostra as matriculas na ordem inversa da Fifo e retorna para o menu
 * Se a opção 5 for selecionada, o programa pede um numero de matricula, mostra a idade do funcionário e retorna para o menu
 * Se a opção 6 for selecionada, o programa mostra a matricula do funcionário que esta na cabeça da fila e retorna para o menu
 * Se a opção 7 for selecionada, o programa mostra a matricula do funcionário que esta no fim da fila e retorna para o menu
 * Se a opção 8 for selecionada, o programa mostra a media de idade dos funcionários e retorna para o menu
 * Se a opção 9 for selecionada, fecha o programa
 * <p>
 * Observações:
 * - Para cada opção do menu construa um método especifico
 * - Somente os métodos correspondente as opções 3 e 4 do menu, além do método main, podem fazer I/O
 */

public class Main {
    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Adicionar novo funcionário");
        System.out.println("2. Remover funcionário da fila");
        System.out.println("3. Mostrar matrículas (FIFO)");
        System.out.println("4. Mostrar matrículas (Ordem Inversa)");
        System.out.println("5. Buscar idade por matrícula");
        System.out.println("6. Mostrar matrícula do primeiro da fila");
        System.out.println("7. Mostrar matrícula do último da fila");
        System.out.println("8. Mostrar média de idade");
        System.out.println("9. Sair");
    }

    public static void main(String[] args) {
        Queue<Employee> queue = new Fifo<Employee>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Employee employee = null;
        Queue<Employee> cloneQueue;

        System.out.println("--- Sistema de Gerenciamento de Funcionários (FIFO) ---");

        while (running) {
            exibirMenu();
            System.out.print("Digite sua opção: ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a matrícula: ");
                        String registration = scanner.nextLine();
                        System.out.print("Digite a idade: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        queue.enqueue(new Employee(age, registration));
                        System.out.println("Funcionário adicionado com sucesso!");
                        break;
                    case 2:
                        employee = queue.dequeue();
                        if (employee != null) {
                            System.out.println("Funcionário removido. Matrícula: " + employee.registration);
                        } else {
                            System.out.println("A fila está vazia. Nenhum funcionário para remover.");
                        }
                        break;
                    case 3:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia.");
                        } else {
                            System.out.println("--- Matrículas Cadastradas (FIFO) ---");
                            cloneQueue = new Fifo<Employee>();
                            while (!queue.isEmpty()) {
                                employee = queue.dequeue();
                                cloneQueue.enqueue(employee);
                                System.out.println("Matrícula: " + employee.registration);
                            }
                            queue = cloneQueue;
                        }
                        break;
                    case 4:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia.");
                        } else {
                            System.out.println("--- Matrículas na Ordem Inversa ---");
//                            Employee[] employees = new Employee[queue.size()];
                            ArrayList<Employee> employees = new ArrayList<>();
                            for (int i = 0; i <= (queue.size() - 1); i++) {
                                employees.add(queue.dequeue());
                            }
                            for (int i = employees.size() - 1; i >= 0; i--) {
                                System.out.println("Matrícula: " + employees.get(i).registration);
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Digite a matrícula a ser buscada: ");
                        String registrationToSearch = scanner.nextLine();
                        boolean isFinded = false;
                        int decounter = queue.size();
                        while (!isFinded && decounter > 0) {
                            employee = queue.dequeue();
                            isFinded = employee.registration.equals(registrationToSearch);
                            decounter--;
                        }
                        if (!isFinded) {
                            assert employee != null;
                            System.out.println("Idade do funcionário: " + employee.age);
                        } else {
                            System.out.println("Funcionário com a matrícula " + registrationToSearch + " não encontrado.");
                        }
                        break;
                    case 6:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia.");
                        } else {
                            System.out.println("Matrícula do funcionário na cabeça da fila: " + queue.head().registration);
                        }
                        break;
                    case 7:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia.");
                        } else {
                            System.out.println("Matrícula do funcionário no fim da fila: " + queue.tail().registration);
                        }
                        break;
                    case 8:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia. Não é possível calcular a média.");
                        } else {
                            cloneQueue = new Fifo<Employee>();
                            Integer totalAge = 0;
                            for (int i = 0; i <= queue.size(); i++) {
                                employee = queue.dequeue();
                                cloneQueue.enqueue(employee);
                                totalAge += employee.age;
                            }
                            queue = cloneQueue;
                            Double avarageAge = (double) totalAge / queue.size();
                            System.out.printf("A média de idade dos funcionários é: %.2f\n", avarageAge);
                        }
                        break;
                    case 9:
                        running = false;
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
            System.out.println();
        }
        scanner.close();
    }
}