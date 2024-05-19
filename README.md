## Funcionalidades

## Cadastro de Notas
Permite aos usuários criar novas notas com um título e conteúdo.
Validação de entrada para garantir que o título e o conteúdo não estejam vazios.
Interface de usuário intuitiva para facilitar o cadastro rápido de notas.

## Alteração de Notas
Os usuários podem editar notas existentes, atualizando o título e o conteúdo conforme necessário.
Interface de edição com preenchimento automático dos dados atuais da nota para facilitar a modificação.

## Remoção de Notas
Permite que os usuários removam notas indesejadas ou obsoletas.
Confirmação de exclusão para evitar remoções acidentais.
Persistência Local com Room
Utiliza o Room para armazenar notas localmente no dispositivo.
Implementação de DAO (Data Access Objects) para operações de banco de dados, como inserção, atualização e exclusão de notas.
Sincronização automática entre a interface do usuário e o banco de dados local.

## Sincronização Remota com Retrofit
Consome uma API REST para salvar notas remotamente, permitindo sincronização entre diferentes dispositivos.
Retrofit é usado para realizar chamadas de rede de forma eficiente e gerenciar as respostas da API.
Implementação de endpoints para operações de CRUD (Create, Read, Update, Delete) na API remota.
Tecnologias Utilizadas

## Room
Facilita a persistência de dados no dispositivo, oferecendo uma camada de abstração sobre o SQLite.
Permite consultas SQL diretamente nos objetos de dados.
Garante operações de banco de dados seguras e eficientes com suporte a transações.

## Retrofit
Biblioteca para simplificar a comunicação com serviços web.
Geração de implementações de API com base em interfaces Java.
Suporte a chamadas síncronas e assíncronas para operações de rede.

## Outros Conceitos Android
--*LiveData*--: Para observar mudanças nos dados e atualizar a interface do usuário em tempo real.
--*Lifecycle*--: Para utilizar coroutines em suspend functions.
--*ViewModel*--: Para gerenciar dados relacionados à interface do usuário de forma eficiente e sobreviver a mudanças de configuração.
--*DataBinding*--: Para ligar componentes de interface do usuário diretamente a propriedades de dados, reduzindo o código boilerplate.
--*Material Design*--: Para criar uma interface de usuário atraente e consistente.
--*MVVM*--: Arquitetura utilizada no projeto.

## Estrutura do Projeto
--*data*--: Contém as classes de entidade, DAO e banco de dados do Room.
--*webclient*--: Contém as classes de serviço e modelo do Retrofit.
--*extensions*--: Contém os metódos de conversão de dados.
--*ui*--: Contém as atividades e fragmentos para a interface do usuário.

## Como Executar

## Clone este repositório:
git clone https://github.com/seu-usuario/NotasApp.git

Abra o projeto no Android Studio.
Configure as dependências do Gradle e sincronize o projeto.
Compile e execute o aplicativo em um dispositivo ou emulador Android.

## Configuração da API
A API utilizada pelo Retrofit deve ser configurada no arquivo ApiService.java dentro do pacote network.
As URLs base e os endpoints devem ser definidos conforme a documentação da API remota.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e novas funcionalidades.

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais detalhes.

## Contato
Para dúvidas ou sugestões, entre em contato com seu-email@example.com.
