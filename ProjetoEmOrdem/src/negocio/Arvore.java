package negocio;

import javax.swing.JOptionPane;

import modelagem.Numero;

public class Arvore {
    private Numero num = null;
    private Arvore dir = null;
    private Arvore esq = null;
    private Numero[] subArvores = new Numero[11];
    private int contador = 0;
    
    public void adicionar(Numero n) {
        if(num == null) {
            num = n;
            subArvores[contador] = n;
            contador++;
        } else if(n.getDado() < num.getDado()) { // Corrigido aqui
            if(esq == null) {
                esq = new Arvore();
            }
            
            esq.adicionar(n);
            subArvores[contador] = n;
            contador++;
        } else if(n.getDado() > num.getDado()) {
            if(dir == null) {
                dir = new Arvore();
            }
            
            dir.adicionar(n);
            subArvores[contador] = n;
            contador++;
        }
    }
    
    public void exibirOrdem(Arvore arv) {
        if(arv != null) {
            JOptionPane.showMessageDialog(null, arv.num);
            exibirOrdem(arv.esq);
            exibirOrdem(arv.dir);
        }
    }
    
    public String toString() {
        return java.util.Arrays.toString(subArvores);
    }
}
