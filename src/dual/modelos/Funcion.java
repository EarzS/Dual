/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dual.modelos;

/**
 *
 * @author rexim de venezuela
 */
public class Funcion {
    
    protected static final int NEGATIVO = -1;
    
    Vector<Float> coeficientes;
    
    public Funcion(int cantidad){
        Float[] temporal = new Float[cantidad];
        
        for(int i = 0; i < cantidad; i++){
            temporal[i] = 0f;
        }
        
        this.coeficientes = new Vector(temporal);
    }
    
    public Funcion(Float[] coeficientes){
        this.coeficientes = new Vector(coeficientes);
    }
    
    public Funcion(float[] coeficientes){
        Float[] temporal = new Float[coeficientes.length];
        int tamano = coeficientes.length;
        for(int i = 0; i < tamano; i++){
            temporal[i] = coeficientes[i];
        }
            
        this.coeficientes = new Vector(temporal);
    }
    
    public Funcion negativo(){
        Float[] negativos = new Float[coeficientes.size()];
        int i = 0;
        for(Float coeficiente: coeficientes){
            negativos[i++] = (coeficiente * NEGATIVO);
        }
        
        return new Funcion(negativos);
    }
    
    public Vector<Float> getCoeficientes(){
        return coeficientes;
    }
    
    public Funcion dividir(Funcion divisor){
        int tamano = this.cantidad() > divisor.cantidad()? 
                this.cantidad() : divisor.cantidad();
        
        float[] temporal = new float[tamano];
        for(int i = 0; i < tamano; i++){
            temporal[i] = 0;
        }
        
        // Establecer el tamaño, asignar el array a cero, hacer la division,
        
        for(int i = 0; i < tamano; i++){
            if(this.cantidad() < i || divisor.cantidad() < i){
                temporal[i] = 0;
            }else if(divisor.getCoeficientes().get(i) == 0){
                temporal[i] = 0;
            }else{
                temporal[i] = this.coeficientes.get(i) / divisor.getCoeficientes().get(i);
            }
        }
        
        return new Funcion(temporal);
    }
    
    public boolean tieneNegativos(){
        for(Float f: coeficientes){
            if(f >= 0){
                return false;
            }
        }
        
        return true;
    }
    
    public Funcion absoluto(){
        float[] temporal = new float[this.cantidad()];
        for(int i = 0; i < cantidad(); i++){
            temporal[i] = coeficientes.get(i) < 0? 
                    coeficientes.get(i) * NEGATIVO : coeficientes.get(i);
        }
        
        return new Funcion(temporal);
    }
    
    public int menor(){
        int menor = 0;
        
        for(int i = 0; i < cantidad(); i++){
            if(coeficientes.get(menor) > coeficientes.get(i)){
                menor = i;
            }
        }
        
        return menor;
    }
    
    public int cantidad(){
        return coeficientes.size();
    }
    
    public void imprimir(){
        int x = 1; 
        for(Float coeficiente: coeficientes){
            System.out.print(coeficiente + "x" + x++ + " ");
        }
    }
}
