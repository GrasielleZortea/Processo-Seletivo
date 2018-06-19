# Automação/Bugs/ Melhorias


Esse projeto faz parte do processo seletivo da empresa SambaTech e tem como objetivo cadastrar e automatizar os bugs e melhorias da plataforma SambaTech, facilitando o teste de regressão do mesmo.

A sambaTech é uma startup mineira que tem como objetivo gerenciar e distribuir vídeos online com segurança e escalabilidade, para instituições de ensino, grupos de mídia, comunicação interna e produtores de conteúdo em geral. É para oferecer o melhor produto é necessários testes.

A automação dos testes é voltada para os bugs mais críticos, relacionados a criterios de aceitação e  usado pelos usuários a fim de evitar o retrabalho.

# O que foi usado

Foi utilizado nesse projeto a linguagem Java, Selenium WebDrive, o eclipse oxygen e como padrão de código foi utilizado o Pages Object.

O Pages Object é um padrão de código usado na automatização de testes que tem como objetivo uma maior independência dos testes e reaproveitamento do código obtendo menor necessidade de refatoramento.

Para maiores informações sobre Pages Object: http://www.codeatest.com/page-object-testes-aceitacao-organizados/

# Como Utilizar

Para utilizar o projeto é necessário ter instalado o Eclipse ou outro software com suporte a linguagem java e baixar o projeto do Git. Para executa-lo é necessário configurar o maven e possuir o Selenium WebDrive.
O projeto foi divido, dentro da pasta SRC>Teste em:


Pages Objects
-	LoginPage
-	Enviar VideoPage
-	ConteudoPage 
-	CampanhaPage

Teste
-	Login
-	Enviar Video
-	Conteudo 
-	Campanha