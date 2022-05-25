# ProjetoWeb_Prog_IMD

Doc Json para Testar os EndPonts


{
    "nome": "",
    "email":"teste@email.com",
    "cpf": "234234234345345",
    "rg": "23423234",
    "dataNascimento": "2020-03-01",
    "nomeMae": "rasdrsd",
    "nomePai": "rerasdasd",
    "deficiencia": [{"tipo_deficiencia":"tiringa"}],
    "enderecoPessoaList": [{
                    "logradouro": "rua dos canindes",
                    "numero": "123123",
                    "comlemento": "garagem",
                    "bairro": "alto do ceu",
                    "cidade": "mossoro",
                    "cep": "4564564546",
                    "uf": "rn"
                    }],
    "vinculoPessoaFisica": [{
                    "matricula": "2123123423423"
    }]


}

#Json teste para pessoa jurídica

{
  "nome":"SEAD",
  "email":"sead@rn.gov.br",  
  "cnpj": "01002123000187",
  "situacao_funcionamento":"true",
  "endereco": [
    {
      "logradouro": "rua dos canindes",
      "numero": "123123",
      "comlemento": "garagem",
      "bairro": "alto do ceu",
      "cidade": "mossoro",
      "cep": "4564564546",
      "uf": "rn"
    }
  ],
  "vinculoPessoaJuridica": [
    {
      "matricula": "2123123423423",
	  "data_nomeacao":"",
	  "data_posse":"",
	  "salario_base":"",
	  "total_horas_trabalhadas":""
    }]

}
