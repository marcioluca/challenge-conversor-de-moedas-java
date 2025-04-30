
# 💱 Currency Converter - Conversor de Moedas

Este é um projeto Java que permite converter valores entre diferentes moedas utilizando a [ExchangeRate-API](https://www.exchangerate-api.com/). Ele roda no terminal e utiliza a biblioteca `HttpClient` para fazer requisições HTTP e o `Gson` para processar os dados em JSON.

## 🚀 Funcionalidades

- Conversão de moedas entre:
  - Dólar ↔ Peso Argentino
  - Dólar ↔ Real Brasileiro
  - Dólar ↔ Peso Colombiano
  - Dólar ↔ Euro
- Menu interativo no console
- Tratamento de entradas inválidas
- Cálculo automático baseado na taxa de câmbio atual

## 🛠 Tecnologias utilizadas

- **Java 17+**
- **HttpClient (java.net.http)**
- **Gson (com.google.gson)**
- **ExchangeRate API** – Para obter as taxas de câmbio

## 🧪 Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/currency-converter-java.git
cd currency-converter-java
```

### 2. Adicione sua chave da API

Acesse [exchangerate-api.com](https://www.exchangerate-api.com/), crie uma conta gratuita e obtenha sua chave da API. Em seguida, substitua o valor da constante `API_KEY` no código:

```java
private static final String API_KEY = "sua_chave_aqui";
```

### 3. Compile e execute o projeto

```bash
javac -d out src/br/com/alura/chalenge/conversor/model/CurrencyApiClient.java
java -cp out br.com.alura.chalenge.conversor.model.CurrencyApiClient
```

Ou use a classe `Main` se ela estiver separada:

```bash
javac -d out src/br/com/alura/chalenge/conversor/main/Main.java
java -cp out br.com.alura.chalenge.conversor.main.Main
```

## 💡 Exemplo de uso

```
***********************************************
Seja bem-vindo(a) ao conversor de moedas =]
1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileiro
4) Real brasileiro => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Dólar => Euro
8) Euro => Dólar
9) Sair
Escolha uma opção: ***********************************************
Escolha uma opção: 3
Digite o valor a ser convertido: 100
Valor 100.0 [USD] Corresponde ao valor final de =>>> 510.25 [BRL]
```

## 📂 Estrutura do projeto

```
currency-converter-java/
├── src/
│   └── br/
│       └── com/
│           └── alura/
│               └── chalenge/
│                   └── conversor/
│                       ├── config                     
│                       │   └── ApiKeyLoader.java
│                       ├── model/
│                       │   └── CurrencyApiClient.java
│                       └── main/
│                           └── Main.java
├── README.md             
└── .gitignore
```

## 👨‍💻 Autor

**Márcio Lucas**  
[https://www.linkedin.com/in/marcio-lucas-dev/]

---

Este projeto faz parte de um estudo de estruturas de dados e APIs com Java proposto pela Alura.
