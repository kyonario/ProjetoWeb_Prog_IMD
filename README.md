# ProjetoWeb_Prog_IMD

EndPoint: PessoaFisica

{ 
	"nome": "Milton", 
	"email":"teste@email.com", 
	"cpf": "234234234345345", 
	"rg": "23423234", 
	"dataNascimento": "2020-03-01", 
	"nomeMae": "rasdrsd", 
	"nomePai": "rerasdasd", 
	"deficienciaPessoaFisicaList": [
		{
			"tipoDeficiencia":"amputado",
			"laudoMedico":"nao pode trabalhar com atividades manuais"
		}
		],
	"enderecoPessoaFisicaList": [
		{ 
			"logradouro": "rua dos canindes", 
			"numero": "123123", 
			"comlemento": "garagem", 
			"bairro": "alto do ceu", 
			"cidade": "mossoro", 
			"cep": "4564564546",
			"uf": "rn" }], 
	"vinculoPessoaFisica": [
		{ 
			"matricula": "2123123423423",
			"dataNomeacao": "22-08-1988",
			"dataPosse": "22-08-1988",
			"salarioBase": "19876",
			"totalHorasTrabalhadas": "36"
			
		}]

}

#Json teste para pessoa jurídica

{
  "nome":"SEAD",
  "email":"sead@rn.gov.br",  
  "cnpj": "01002123000187",
  "situacaoFuncionamento":"true",
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
	  "dataNomeacao":"",
	  "dataPosse":"",
	  "salarioBase":"",
	  "totalHorasTrabalhadas":""
    }]

}
