package com.example.guilhermehayashi.maonamassabasico1.modelos

/*
*
* class NomeDaClasse {
*   var atributos: Tipo = valor
* }
*
* Definimos a classe Pessoa que vai ter um atributo nome.
*
* Sobrescrevemos o método toString() que representa o objeto quando ele é printado.
*
* */

class Pessoa(var nome: String) {

    override fun toString(): String {
        return nome
    }
}