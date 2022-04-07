# WalletStone

- Os arquivos estão segregados por responsabilidades nos packages:

activitys - atividades e conteudos a serem exibidos na tela
adapters - ponte para listViews e dados necessarios para visualização
data - arquivos requisição online/offline e entidades
util - metodos para ser usados como complem
viewmodel - aramazenando e gerenciando dados para ui

- Dados offline são armazenados em SecurityPreferences com (titulo, array)

- Arquitetura MVVM

- Bibliotecas
retrofit2, okhttp - requisiçoes online http
gson - configuracoes em json
security-crypto-ktx - trabalhar com SecurityPreference

