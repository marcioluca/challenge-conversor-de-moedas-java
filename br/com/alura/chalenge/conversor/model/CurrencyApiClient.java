package br.com.alura.chalenge.conversor.model;

import br.com.alura.chalenge.conversor.config.ApiKeyLoader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyApiClient {

    private static final String API_KEY = ApiKeyLoader.getApiKey();     // Coloque sua chave API aqui
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    // Metodo principal
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("***********************************************");
            System.out.println("Seja bem-vindo(a) ao conversor de moedas =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Dólar => Euro");
            System.out.println("8) Euro => Dólar");
            System.out.println("9) Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println("***********************************************");

            // tratando exceções caso usuario digite algum simbolo ou letra
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Por favor digite apenas números inteiros.");
            }
            String from = "";
            String to = "";

            switch (opcao) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "ARS"; to = "USD"; }
                case 3 -> { from = "USD"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
                case 7 -> { from = "USD"; to = "EUR"; }
                case 8 -> { from = "EUR"; to = "USD"; }
                case 9 -> {
                    System.out.println("Saindo... Obrigado por usar o conversor.");
                    break;
                }
                default -> {
                    System.out.println("Opção inválida!");
                    continue;
                }
            }

            if (opcao >= 1 && opcao <= 8) {
                double valor = 0;
                boolean entradaValida = false;
                while (!entradaValida) {
                    System.out.print("Digite o valor a ser convertido: ");
                    // tratando exceções caso usuario digite algum simbolo ou letra
                    try {
                        valor = Double.parseDouble(scanner.nextLine());
                        entradaValida = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Por favor digite um valor válido.");
                    }
                }
                double convertido = calculateConversion(from, to, valor);
                System.out.printf("Valor " + valor + " ["+ from +"] Corresponde ao valor final de =>>> %.2f %s%n", convertido, "[" + to + "]");
            }
        }
        scanner.close();
    }
    // metodo responsavel pelas requisições e respostas na API
    // Retorna o calculo de conversão.
    private double calculateConversion(String from, String to, double amount) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + from;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = json.getAsJsonObject("conversion_rates");
            double rate = rates.get(to).getAsDouble();

            return amount * rate;
        } catch (Exception e) {
            throw new RuntimeException("Erro na conversão: " + e.getMessage(), e);
        }
    }
}
