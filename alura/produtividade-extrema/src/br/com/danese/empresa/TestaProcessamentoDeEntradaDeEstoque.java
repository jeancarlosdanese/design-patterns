package br.com.danese.empresa;

import static java.util.Arrays.asList;

import java.util.List;

import br.com.danese.empresa.model.produto.Estoque;
import br.com.danese.empresa.model.produto.Produto;
import br.com.danese.empresa.model.produto.TipoDeProduto;

public class TestaProcessamentoDeEntradaDeEstoque {

    public static void main(String[] args) {
        Produto p1 = new Produto("chocolate", TipoDeProduto.COMIDA, 2.40);
        Produto p2 = new Produto("vinho", TipoDeProduto.COMIDA, 35.70);
        Produto p3 = new Produto("manteiga", TipoDeProduto.COMIDA, 6.80);
        Produto p4 = new Produto("água com gás", TipoDeProduto.COMIDA, 2.70);
        Produto p5 = new Produto("frutas", TipoDeProduto.COMIDA, 30.00);

        List<Produto> novosProdutos = asList(p1,p2,p3,p4,p5);

        new Estoque().getDisponiveis().addAll(novosProdutos);
    }
}