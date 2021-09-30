## Prerequisitos

- Terraform

## Inicializar directorio de trabajo
```sh
terraform init
```

## Validación de scripts Terraform

```sh
terraform validate
```

## Crear plan de ejecución y visualizar cambios a aplicar

```sh
terraform plan -out "planfile"
```

## Aplicar los cambios a la infraestructura

```sh
terraform apply -input=false "planfile"
```

## Autores

👤 **Rubén Villar Escudero**

🏢 **PARADIGMA DIGITAL**

## Licencia

[Creative Commons Attribution-ShareAlike 4.0 International](LICENSE.md) <img alt="License CC BY-SA" src="https://img.shields.io/badge/license-CC%20BY--SA-blue" />