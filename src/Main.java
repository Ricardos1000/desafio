import br.com.connexaoinformatica.modelos.*;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu = 1;
        Cartao cartao;
        Scanner sc = new Scanner(System.in);

        System.out.println("***************************************************");

        System.out.println("Informe o limite do Cartão de Crédito");
        cartao = new Cartao(sc.nextDouble());

        System.out.println("Digite 1 para continuar a comprar ou 0 para sair");
        menu = sc.nextInt();

        while(menu != 0) {

            System.out.println("Informe o Produto :  ");
            String produto = sc.next();

            System.out.println("informe o valor do produto : ");
            double valor = sc.nextDouble();

            Compra compra = new Compra(produto, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Digite 1 para continuar a comprar ou 0 para sair");
                menu = sc.nextInt();
            }else {
                System.out.println("Limite de crédito insuficiente");
                menu = 0;
            }
        }
        System.out.println("*********-Compras Realizada-*******************");
        Collections.sort(cartao.getCompras());
        for (Compra item : cartao.getCompras()) {
            System.out.println(item.toString());
        }
        System.out.println("********- Limite de crédito disponível -*******");
        System.out.println(cartao.getSaldo());
        sc.close();
    }
}