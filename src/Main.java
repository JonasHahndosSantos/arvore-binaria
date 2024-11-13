//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(4);
        arvore.inserir(5);
        arvore.inserir(8);
        arvore.inserir(90);
        arvore.imprimirEmOrdem();
        arvore.buscar(10);
        arvore.imprimirPreOrdem();
        arvore.buscar(20);
        arvore.imprimirPosOrdem();
        arvore.remover(20);
        arvore.altura();
        arvore.contarFolhas();
        arvore.contarNos();
        arvore.profundidadeNo(10);
    }
}