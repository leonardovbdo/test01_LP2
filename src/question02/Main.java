package question02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_VACINAS = 6;
        Scanner input = new Scanner(System.in);
        //Atributos para cada vacina
        String nomeVacina;
        String doencasImunizadas;
        int dosesInicial;
        int dosesReforco;
        int mesesAplicacao;

        //Variável para manipular quantas vacinas já foram registradas
        int vacinasRegistradas = 0;

        //Array de vacinas
        Vacina[] vacinas = new Vacina[TOTAL_VACINAS];

        System.out.println("***********************");
        System.out.println("* REGISTRO DE VACINAS *");
        System.out.println("***********************");

        do{
            System.out.println("\nVacina #" + ((vacinasRegistradas) + 1));

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
            input.nextLine(); //Limpando o Scanner

            Vacina vacinaTemp = new Vacina(nomeVacina, doencasImunizadas, dosesInicial, dosesReforco, mesesAplicacao);
            vacinas[vacinasRegistradas] = vacinaTemp;
            vacinasRegistradas++;
        } while (vacinasRegistradas < TOTAL_VACINAS);

        int escolha = 0;
        System.out.println("\n*************");
        System.out.println("* OPERAÇÕES *");
        System.out.println("***************");

        do{
            System.out.println("\n1 - Registrar nova conclusão de ciclo");
            System.out.println("2 - Exibir percentual de cobertura total");
            System.out.println("3 - Exibir vacina(s) com mais doses previstas");
            System.out.println("4 - Encerrar aplicação");
            System.out.print("Escolha: ");
            escolha = input.nextInt();

            switch (escolha){
                case 1:
                    System.out.print("\nInforme a vacina desejada (1-6): ");
                    int vacinaDesejada = input.nextInt();

                    vacinas[(vacinaDesejada - 1)].adicionarAplicacao();
                    System.out.print("Adição bem sucedida!\n");
                    break;

                case 2:
                    System.out.print("\nInforme o número de crianças estimado: ");
                    int criancasEstimadas = input.nextInt();

                    int criancasImunizadas = 0;
                    for(int i = 0; i < vacinas.length; i++){
                        criancasImunizadas += vacinas[i].getCriancasImunizadas();
                    }

                    double porcentagem = ((double) criancasImunizadas / criancasEstimadas) * 100;
                    System.out.print(porcentagem + "% das crianças foram imunizadas\n");
                    break;

                case 3:
                    String nomeVacinas = vacinas[0].getNome();
                    int maiorDose = vacinas[0].getTotalDoses();

                    for(int i = 1; i < vacinas.length; i++){
                        if(maiorDose < vacinas[i].getTotalDoses()){
                            nomeVacinas = vacinas[i].getNome();
                            maiorDose = vacinas[i].getTotalDoses();
                        } else if (maiorDose == vacinas[i].getTotalDoses()) {
                            nomeVacinas += ", " + vacinas[i].getNome();
                        }
                    }
                    System.out.print("\nVacinas(s) com maior quantidade de doses: " + nomeVacinas + "\n");
            }
        } while (escolha != 4);

        input.close();
        System.out.println("\n***********************");
        System.out.println("* APLICAÇÃO ENCERRADA *");
        System.out.println("***********************");

    }
}