# MovieBuddy

Aplicativo Android para explorar filmes usando a API TMDB, com interface moderna e recursos como listagem, detalhes, favoritos e busca.

---

## Sobre o Aplicativo

O **MovieBuddy** permite que o usuário navegue por filmes populares e top avaliados, veja detalhes completos, pesquise filmes e gerencie uma lista de favoritos, tudo com uma interface construída em Jetpack Compose e Material Design.

---

## Requisitos do Projeto (Checklist)

### R1: Identidade visual e layout bem definidos
- [x] Interface com Material Design 3 e Jetpack Compose
- [x] Uso consistente de paleta de cores e tipografia
- [x] Layout responsivo e organizado

### R2: Múltiplas telas
- [x] LoginScreen (login)
- [x] HomeScreen (lista de filmes)
- [x] DetailsScreen (detalhes do filme)
- [x] SearchScreen (busca dinâmica)

### R3: Acesso à rede
- [x] Integração com API TMDB para carregar dados reais de filmes
- [x] Requisições via Retrofit (ou similar) e coroutines

### R4: Armazenamento local
- [x] Favoritos armazenados localmente (Room ou SQLite))

### R5: Suporte básico a internacionalização (i18n)
- [x] Strings definidas em arquivos `strings.xml`
- [x] Suporte a pelo menos dois idiomas (português e inglês)
- [ ] Remover strings hardcoded da UI

### R6: Boas práticas e qualidade do projeto
- [x] Uso de ViewModel para lógica e estado
- [x] Padrão Repository para acesso a dados
- [ ] Testes automatizados para APIs e persistência local *(pendente)*

---

## Tecnologias Utilizadas

- Kotlin
- Jetpack Compose (Material 3)
- Coroutines + Flow
- Navigation Compose
- Coil (para carregamento de imagens)
- Retrofit / TMDB API
- Android Room (persistência local)
- ViewModel + Repository pattern

---

## Como Rodar

1. Clone o repositório
2. Configure sua chave de API TMDB (arquivo local ou BuildConfig)
3. Compile e execute no Android Studio (API 21+)
4. Explore as funcionalidades: navegação, busca, favoritos

---

## Próximos passos e melhorias

- Implementar suporte completo à internacionalização (R5)
- Criar testes automatizados unitários e instrumentados (R6)
- Melhorar tratamento de erros e mensagens ao usuário
