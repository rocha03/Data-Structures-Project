import java.util.Scanner;

import game.Game;
import game.Enums.GameStatus;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = Game.getInstance();
        
        System.out.print("Informe o nome do Jogador 1: ");
        String nomeJogador1 = scanner.nextLine();

        System.out.print("Informe o nome do Jogador 2: ");
        String nomeJogador2 = scanner.nextLine();

        do{
            int opcao;
            if(game.getStatus() == GameStatus.MAP_DEF){
                System.out.println("\nSeleção do Mapa:");
                System.out.println("1 - Carregar Mapa");
                System.out.println("2 - Criar Mapa");
                System.out.print("Escolha uma opção: ");
                
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        //Fazer verificação o input aqui tb
                        System.out.println("\nNúmero de Localizações:");
                        int locations_qty = scanner.nextInt();

                        boolean direction;
                        do{
                            opcao = scanner.nextInt();
                            System.out.println("\nBidirecionais:");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                        }while (opcao != 1 || opcao != 2);
                        if (opcao == 1) {
                            direction = true;
                        }else{
                            direction = false;
                        }

                        //Fazer verificação o input aqui tb
                        System.out.println("\nDensidade das Arestas:");
                        float density = scanner.nextFloat();

                        game.mapDefinitions(locations_qty, direction, density);
                        break;
                    case 2:
                        
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

            if(game.getStatus() == GameStatus.PLAYER_DEF){
                System.out.println("\nLocalização da Bandeira do jogador" + nomeJogador1 + ":");
                String bandeiraJogador1 = scanner.nextLine();

                System.out.println("\nLocalização da Bandeira do jogador" + nomeJogador2 + ":");
                String bandeiraJogador2 = scanner.nextLine();

                game.playerDefinitions(nomeJogador1, bandeiraJogador1, nomeJogador2, bandeiraJogador2);

                int numOfBots;
                do{
                    System.out.println("\nNúmero de BOTS por jogador:");
                    numOfBots = scanner.nextInt();
                    if(numOfBots < 3){
                        System.out.println("\nNúmero de BOTS inválido. (Mínimo de 3 BOTS por jogador)");
                    }
                }while(numOfBots < 3);
                //game.setNumBots(numOfBots)

                
            }

            if(game.getStatus() == GameStatus.NEW_GAME){

            }

            if(game.getStatus() == GameStatus.ONGOING){

            }

        }while(game.getStatus() != GameStatus.END_GAME);
        
        scanner.close();
    }
}
