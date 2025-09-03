package com.core.employee;

import com.core.employee.queue.Fifo;
import com.core.employee.interfaces.Queue;

import java.util.ArrayList;
import java.util.Scanner;

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
        Employee employee;
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
                            ArrayList<Employee> employees = new ArrayList<>();
                            while (!queue.isEmpty()) {
                                employees.add(queue.dequeue());
                            }
                            for (int i = employees.size() - 1; i >= 0; i--) {
                                employee = employees.get(i);
                                System.out.println("Matrícula: " + employee.registration);
                                queue.enqueue(employee);
                            }
                        }
                        break;
                    case 5:
                        if (queue.isEmpty()) {
                            System.out.println("A fila está vazia. Não é possível buscar funcionários.");
                        } else {
                            System.out.print("Digite a matrícula a ser buscada: ");
                            String registrationToSearch = scanner.nextLine();
                            cloneQueue = new Fifo<Employee>();
                            Employee foundEmployee = null;

                            while (!queue.isEmpty()) {
                                employee = queue.dequeue();
                                cloneQueue.enqueue(employee);
                                if (employee.registration.equals(registrationToSearch)) {
                                    foundEmployee = employee;
                                }
                            }
                            queue = cloneQueue;

                            if (foundEmployee != null) {
                                System.out.println("Idade do funcionário: " + foundEmployee.age);
                            } else {
                                System.out.println("Funcionário com a matrícula " + registrationToSearch + " não encontrado.");
                            }
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
                            int initialSize = queue.size();
                            while (!queue.isEmpty()) {
                                employee = queue.dequeue();
                                cloneQueue.enqueue(employee);
                                totalAge += employee.age;
                            }
                            queue = cloneQueue;
                            Double avarageAge = (double) totalAge / initialSize;
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