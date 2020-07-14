package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Digite as informações da conta");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			
			sc.nextLine();
			System.out.print("Titular: ");
			String titular = sc.nextLine();
			
			System.out.print("Deposito inicial: ");
			double depositoInicial = sc.nextDouble();
			
			System.out.print("Limite de saque: ");
			double limiteSaque = sc.nextDouble();
			Account conta = new Account(numero, titular, depositoInicial, limiteSaque);
			
			System.out.println();
			
			System.out.print("Digite a quantidade do saque: ");
			double quantidadeSaque = sc.nextDouble();
			conta.saque(quantidadeSaque);
			
			System.out.println("Novo saldo: " + String.format("%.2f", conta.getSaldo()));
			
		} catch (DomainException e) {
			System.out.println("Erro no saque: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
