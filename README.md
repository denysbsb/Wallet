# WalletStone

- Os arquivos estão segregados por responsabilidades nos packages:

activitys - atividades e conteúdos a serem exibidos na tela

adapters - ponte para listViews e dados necessários para visualização

data - arquivos requisição online/offline e entidades

util - metodos para ser usados como complemento	

viewmodel - armazenando e gerenciando dados para ui

- Dados offline são armazenados em SecurityPreferences com (titulo, array)

- Arquitetura MVVM

- Bibliotecas

retrofit2, okhttp - requisições online http

gson - configurações em json

security-crypto-ktx - trabalhar com SecurityPreference

- Layout em LinearLayout
