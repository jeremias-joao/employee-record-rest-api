# employee-record-rest-api



## Ferramentas e Tecnologias
- Java 11 
- ORM JPA/Hibernate
- Spring Boot
- Spring Rest
- Spring Data JPA
- Maven
- PostgreSQL dDatabase
- Spring Fox/Doc
- Swagger

#### Paths (Employee)

| Função | Caminho |
| ------ | ------ |
| Listar todos | /employee/find-all |
| Listar por id | /employee/{id} |
| Criar | /employee/save |
| Atualizar | /employee/update/{id} |
| Deletar | /employee/{id} |

## BODY PARA SALVAR
```
{
  "id": 0,
  "name": "Gustavo Marcos Luan Gomes",
  "email": "gustavo@gmail.com",
  "age": 45,
  "sex": "M",
  "company": {
    "id": 0,
    "name": "C&T Inc",
    "cnpj": "70112300000148",
    "foundationDate": "11/02/1980",
    "status": {
      "id": 0,
      "status": "Ativo"
    }
  },
  "address": {
    "id": 0,
    "road": "Rua Canutama 123",
    "district": "Vila Barros",
    "city": "Guarulhos",
    "state": "SP",
    "cep": "07192150"
  },
  "department": {
    "id": 0,
    "name": "TI"
  }
}
```
DIAGRAMA MODELO LOGICO RELACINAMENTO ENTRE ENTIDADES
https://drive.google.com/file/d/1BU9ihpbUeSR-70wnzjxbKj7Xw1SaGpO4/view?usp=sharing

SWAGGER
https://drive.google.com/file/d/1j6PUaVyGkPNTgHQxu49Sljj0Fb_aS7Ho/view?usp=sharing

PARA TESTAR OS END POINT SWAGGER
http://localhost:8080/swagger-ui/index.html
