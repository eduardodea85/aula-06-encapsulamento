
package aula06encapsulamento;

public class ControleRemoto implements Controlador {
    private Integer volume;
    private boolean ligado;
    private boolean tocando;
    
    //MÉTODOS CONSTRUTOR
    public ControleRemoto(){
        // ATRIBUTOS
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }
    
    private Integer getVolume(){
        return volume;
    }
    private boolean getLigado(){
        return ligado;
    }
    private boolean getTocando(){
        return tocando;
    }
    private void setVolume(Integer v){
        this.volume = v;
    }
    private void setLigado(boolean l){
        this.ligado = l;
    }
    private void setTocando(boolean t){
        this.tocando = t;
    }
    

    //MÉTODOS ABSTRATOS
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("-----MENU-----");
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getVolume());
        System.out.println("Volume: " + this.getVolume()); 
        for (int i = 0; i <= this.getVolume(); i+=10){
            System.out.print("|");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Munu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
            this.setVolume(getVolume() +5);
        }else{
            System.out.println("Impossível aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(getVolume() -5);
        }else{
            System.out.println("Impossível diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }else{
            System.out.println("Não consegui reproduzir");
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            setTocando(true);
        }else{
            System.out.println("Não consegui pausar");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            setTocando(false);
        }
    }
    
    
    
}
