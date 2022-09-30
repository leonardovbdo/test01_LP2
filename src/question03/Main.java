package question03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_VACINAS = 3;
        Scanner input = new Scanner(System.in);

        //atributos para cada vacina
        String nomeVacina;
        String doencasImunizadas;
        int dosesInicial;
        int dosesReforco;
        int mesesAplicacao;

        //variavel para manipular quantas vacinas ja foram registradas
        int vacinasRegistradas = 0;

        //array de vacinas
        Vacina[] vacinas = new Vacina[TOTAL_VACINAS];

        System.out.println("***********************");
        System.out.println("* REGISTRO DE VACINAS *");
        System.out.println("***********************");

        do{
            System.out.println("\nVACINA #" + (vacinasRegistradas + 1));

            System.out.print("Nome: ");
            nomeVacina = input.nextLine();

            System.out.print("Doenças imunizadas: ");
            doencasImunizadas = input.nextLine();

            System.out.print("Doses iniciais: ");
            dosesInicial = input.nextInt();

            System.out.print("Doses reforço: ");
            dosesReforco = input.nextInt();

            System.out.print("Meses de aplicação: ");
            mesesAplicacao = input.nextInt();
            input.nextLine(); //limpando o scanner

            Vacina vacinaTemp;
            try{
                vacinaTemp = new Vacina(nomeVacina, doencasImunizadas, dosesInicial, dosesReforco, mesesAplicacao);
                vacinas[vacinasRegistradas] = vacinaTemp;
                vacinasRegistradas++;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while (vacinasRegistradas < TOTAL_VACINAS);

        int escolha = 0;
        System.out.println("\n*************");
        System.out.println("* OPERAÇÕES *");
        System.out.println("*************");
        boolean bloqueadoCase1 = false; //variável para admnistrar o case 1
        do{
            System.out.println("\n1 - Registrar nova conclusão de ciclo");
            System.out.println("2 - Exibir percentual de cobertura total");
            System.out.println("3 - Exibir vacina(s) com mais doses previstas");
            System.out.println("4 - Encerrar aplicação");
            System.out.print("Escolha: ");
            escolha = input.nextInt();

            switch (escolha){
                case 1:
                    if(bloqueadoCase1){
                        System.err.println("* Não é possível registrar novas conclusões *");
                    } else {
                        boolean deuCerto = false;

                        do{
                            System.out.print("\nInforme a vacina desejada (1-"+ TOTAL_VACINAS + "): ");
                            try{
                                int vacinaDesejada = input.nextInt();//trecho que pode ocasionar problema

                                if(vacinaDesejada < 0 || vacinaDesejada > TOTAL_VACINAS){
                                    System.err.println("* O valor informado está fora do limite *");
                                    bloqueadoCase1 = true;
                                    break;
                                } else {
                                    vacinas[(vacinaDesejada - 1)].adicionarAplicacao();
                                    System.out.print("Adição bem sucedida!\n");
                                    deuCerto = true;
                                }
                            } catch (InputMismatchException e){
                                System.err.println("* O valor informado não é um número *");
                                input.nextLine();
                            }
                        } while (!deuCerto);
                    }
                    break;

                case 2:
                    System.out.print("\nInforme o número de crianças estimado: ");
                    int criancasEstimadas = input.nextInt();

                    int criancasImunizadas = 0;
                    for (int i = 0; i < vacinas.length; i++){
                        criancasImunizadas += vacinas[i].getCriancasImunizadas();
                    }

                    double porcentagem = ((double) criancasImunizadas / criancasEstimadas) * 100;
                    System.out.print(porcentagem + "% das crianças foram imunizadas\n");
                    break;

                case 3:
                    String nomeVacinas = vacinas[0].getNome();
                    int maiorDose = vacinas[0].getTotalDoses();

                    for (int i = 0; i < vacinas.length; i++){
                        if(maiorDose < vacinas[i].getTotalDoses()){
                            nomeVacinas = vacinas[i].getNome();
                            maiorDose = vacinas[i].getTotalDoses();
                        } else if(maiorDose == vacinas[i].getTotalDoses()){
                            nomeVacinas +=", " + vacinas[i].getNome();
                        }
                    }
                    System.out.println("\nVacina(s) com maior quantidade de doses: " + nomeVacinas +"\n");
            }
        } while (escolha != 4);

        input.close();
        System.out.println("\n***********************");
        System.out.println("* APLICAÇÃO ENCERRADA *");
        System.out.println("***********************");
    }
}
