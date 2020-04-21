package com.nando;

import java.util.Scanner;

abstract class Carro
{   
    private int pasajeros;
    private String Matricula;
    private Boolean PicoyPlaca;

    public int getPasajeros(){
        return pasajeros;
    }
    public String getMatricula(){
        return Matricula;
    }
    public Boolean getPicoyPaca(){
        return PicoyPlaca;
    }
    public void setPasajeros(int cantidad){
        pasajeros=cantidad;
    }
    public void setMatricula(String matricula){
        Matricula=matricula;
    }
    public void SetPicoyPlaca(Boolean picoyplaca){
        PicoyPlaca=picoyplaca;
    }
}

class CarroGasolina extends Carro
{
    public int Cilindraje;

    public CarroGasolina(int cil){
        super();
        Cilindraje=cil;
    };

    public int getCilindraje(){
        return Cilindraje;
    }
    public void setCilindraje(int cilindrada){
        Cilindraje=cilindrada;
    }
}

class CarroElectrico extends Carro
{
    public float Potencia;

    public CarroElectrico(float pow){
        super();
        Potencia=pow;
    };

    public float getPotencia(){
        return Potencia;
    }
    public void setPotencia(float potencia){
        Potencia=potencia;
    }
}

enum tipoMotor{
    CUATROT,DOST,ELECTRICO
}

abstract class Moto
{
    private tipoMotor motor;
    private String Matricula;
    private Boolean PicoyPlaca;

    public Moto(){};

    public void setTipoMotor(tipoMotor tipo){
        motor=tipo;
    }
    public void setMatricula(String matricula){
        Matricula=matricula;
    }
    public void setPicoyPlaca(Boolean picoyplaca){
        PicoyPlaca=picoyplaca;
    }
    
    public tipoMotor getTipoMotor(){
        return motor;
    }
    public String getMatricula(){
        return Matricula;
    }
    public Boolean getPicoyPlaca(){
        return PicoyPlaca;
    }
}

class MotoGasolina extends Moto
{
    public int Cilindraje;

    public MotoGasolina(int cil){
        super();
        Cilindraje=cil;
    };

    public int getCilindraje(){
        return Cilindraje;
    }
    public void setCilindraje(int cilindrada){
        Cilindraje=cilindrada;
    }
}

class MotoElectrica extends Moto
{
    public float Potencia;

    public MotoElectrica(float pow){
        super();
        Potencia=pow;
    };

    public float getPotencia(){
        return Potencia;
    }
    public void setPotencia(float pow){
        Potencia=pow;
    }
}

class FabricaElectricos extends Fabrica
{
    @Override
    public Carro crearCarro(){
        String entrada;
        System.out.println("Crear un carro electrico.");
        System.out.println("Ingrese la potencia del motor: ");
        entrada=entradaTeclado.nextLine();
        Carro carroelectrico=new CarroElectrico(Float.parseFloat(entrada));
        System.out.println("Ingrese el numero de pasajeros: ");
        entrada=entradaTeclado.nextLine();
        carroelectrico.setPasajeros(Integer.parseInt(entrada));
        System.out.println("Ingrese la matricula: ");
        entrada=entradaTeclado.nextLine();
        carroelectrico.setMatricula(entrada);
        carroelectrico.SetPicoyPlaca(false);

        return carroelectrico;
    }

    @Override
    public Moto crearMoto(){
        System.out.println("Crear una moto electrica.");
        System.out.println("Ingrese la potencia del motor: ");
        Moto motoelectrica=new MotoElectrica(entradaTeclado.nextFloat());
        entradaTeclado.nextLine();
        System.out.println("Ingrese la matricula: ");
        motoelectrica.setMatricula(entradaTeclado.nextLine());
        motoelectrica.setPicoyPlaca(false);
        motoelectrica.setTipoMotor(tipoMotor.ELECTRICO);

        return motoelectrica;
    }
}

class FabricaGasolina extends Fabrica
{
    @Override
    public Carro crearCarro(){
        System.out.println("Crear un carro a gasolina.");
        System.out.println("Ingrese el cilindraje del motor: ");
        Carro carrogasolina=new CarroGasolina(entradaTeclado.nextInt());  
        System.out.println("Ingrese el numero de pasajeros: ");
        carrogasolina.setPasajeros(entradaTeclado.nextInt());
        System.out.println("Ingrese la matricula: ");
        carrogasolina.setMatricula(entradaTeclado.nextLine());
        carrogasolina.SetPicoyPlaca(false);

        return carrogasolina;
    }

    @Override
    public Moto crearMoto(){
        System.out.println("Crear una moto a gasolina.");
        System.out.println("Ingrese el cilindraje del motor: ");
        Moto motogasolina=new MotoGasolina(entradaTeclado.nextInt());
        entradaTeclado.nextLine();
        System.out.println("Ingrese la matricula: ");
        motogasolina.setMatricula(entradaTeclado.nextLine());
        int opcion=0;
        do{
            System.out.println("Elija una opcion: ");
            System.out.println("1. Motor cuatro tiempos.");
            System.out.println("2. Motor dos tiempos.");
            opcion=entradaTeclado.nextInt();
        }while(opcion!=1 && opcion!=2);
        if(opcion==1){
            motogasolina.setTipoMotor(tipoMotor.CUATROT);
            motogasolina.setPicoyPlaca(false);
        }
        else{
            motogasolina.setTipoMotor(tipoMotor.DOST);
            motogasolina.setPicoyPlaca(true);
        }

        return motogasolina;
    }
}

enum Artefacto{
    GASOLINA,ELECTRICO
}

abstract class Fabrica 
{   
    Scanner entradaTeclado=new Scanner(System.in);
    private static final FabricaGasolina Objetos_gasolina= new FabricaGasolina();
    private static final FabricaElectricos Objetos_electricos= new FabricaElectricos();

    static Fabrica obtenerTipoFabricacion(Artefacto tipoFabricacion){
        Fabrica fabrica=null;
        switch(tipoFabricacion){
            case GASOLINA:
                fabrica=Objetos_gasolina;
                break;
            case ELECTRICO:
                fabrica=Objetos_electricos;
                break;
        }
        return fabrica;
    }

    public abstract Carro crearCarro();
    public abstract Moto crearMoto();

}


public class App
{
    public static void main( String[] args )
    {
        Fabrica fabrica=Fabrica.obtenerTipoFabricacion(Artefacto.GASOLINA);
        Moto honda=fabrica.crearMoto();
        System.out.println("Los datos de la moto son: ");
        System.out.println("Tipo motor: " + honda.getTipoMotor());
        System.out.println("Matricula: "+ honda.getMatricula());
        if(!honda.getPicoyPlaca()){
            System.out.println("No tiene pico y placa");
        }
        else{
            System.out.println("Tiene pico y placa");
        }
        fabrica=Fabrica.obtenerTipoFabricacion(Artefacto.ELECTRICO);
        honda=fabrica.crearMoto();
    }
}
