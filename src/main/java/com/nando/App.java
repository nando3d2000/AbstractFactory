package com.nando;

import java.util.Scanner;

enum tipoMotor{
  ELECTRICO,GASOLINA
}
abstract class Motor{
  private tipoMotor tipo;
  private String serie;

  public Motor(){};

  public Motor(String s,tipoMotor clase){
      this.tipo=clase;
      this.serie=s;
  }

  public tipoMotor getTipo(){
      return tipo;
  }
  public String getSerie(){
      return serie;
  }
}
class MotorElectrico extends Motor{
  int Potencia;

  public MotorElectrico(String serie,int Power){
    super(serie,tipoMotor.ELECTRICO);
    this.Potencia=Power;
  }
  public int getPotencia(){
      return Potencia;
  }
}
class MotorGasolina extends Motor{
  int Cilindraje;
  
  public MotorGasolina(String serie,int cilindrada){
      super(serie,tipoMotor.GASOLINA);
      this.Cilindraje=cilindrada;
  }
  public int getCilindraje(){
      return Cilindraje;
  }
}

abstract class Carro
{
    private int pasajeros;
    private String Matricula;
    private Boolean PicoyPlaca;

    public Carro(int pas,String mat,Boolean picoyplaca){
        this.pasajeros=pas;
        this.Matricula=mat;
        this.PicoyPlaca=picoyplaca;
    }

    public int getPasajeros(){
        return pasajeros;
    }
    public String getMatricula(){
        return Matricula;
    }
    public Boolean getPicoyPlaca(){
        return PicoyPlaca;
    }
    public abstract tipoMotor getTipoMotor();
    public abstract String getSerialMotor();
    public abstract int getCaracteristicaMotor();
}

class CarroGasolina extends Carro
{
    private MotorGasolina motor;
    
    public CarroGasolina(int pas,String mat,Boolean picoyplaca,String serie,int cilindrada){
        super(pas, mat, picoyplaca);
        motor=new MotorGasolina(serie,cilindrada);
    }
    @Override
    public int getCaracteristicaMotor(){
        return this.motor.getCilindraje();
    }
    @Override
    public tipoMotor getTipoMotor(){
        return motor.getTipo();
    }
    @Override
    public String getSerialMotor(){
        return motor.getSerie();
    }
}

class CarroElectrico extends Carro
{
    private MotorElectrico motor;

    public CarroElectrico(int pas,String mat,Boolean picoyplaca,String serie,int potencia){
        super(pas, mat, picoyplaca);
        motor=new MotorElectrico(serie,potencia);
    }
    @Override
    public int getCaracteristicaMotor(){
        return this.motor.getPotencia();
    }
    @Override
    public tipoMotor getTipoMotor(){
        return motor.getTipo();
    }
    @Override
    public String getSerialMotor(){
        return motor.getSerie();
    }
}

abstract class Moto
{
    private String Matricula;
    private Boolean PicoyPlaca;

    public Moto(String mat,Boolean picoyplaca){
        this.Matricula=mat;
        this.PicoyPlaca=picoyplaca;
    }

    public String getMatricula(){
        return Matricula;
    }
    public Boolean getPicoyPlaca(){
        return PicoyPlaca;
    }
    public abstract tipoMotor getTipoMotor();
    public abstract int getCaracteristicaMotor();
    public abstract String getSerialMotor();
}

class MotoGasolina extends Moto
{
    MotorGasolina motor;

    public MotoGasolina(String mat,Boolean picoyplaca,String serie,int cilindrada){
        super(mat, picoyplaca);
        motor=new MotorGasolina(serie,cilindrada);
    }
    @Override
    public int getCaracteristicaMotor(){
        return this.motor.getCilindraje();
    }
    @Override
    public tipoMotor getTipoMotor(){
        return motor.getTipo();
    }
    @Override
    public String getSerialMotor(){
        return motor.getSerie();
    }
}

class MotoElectrica extends Moto
{
    MotorElectrico motor;

    public MotoElectrica(String mat,Boolean picoyplaca,String serie,int cilindrada){
        super(mat, picoyplaca);
        motor=new MotorElectrico(serie,cilindrada);
    }
    @Override
    public int getCaracteristicaMotor(){
        return this.motor.getPotencia();
    }
    @Override
    public tipoMotor getTipoMotor(){
        return motor.getTipo();
    }
    @Override
    public String getSerialMotor(){
        return motor.getSerie();
    }
}

class FabricaElectricos extends Fabrica
{
    @Override
    public Carro crearCarro(){
        String matricula,serial;
        int pasajeros,cilindraje;
        System.out.println("Crear carro electrico.");
        System.out.println("Ingrese la cantidad de pasajeros: ");
        pasajeros=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        System.out.println("Ingrese la matricula: ");
        matricula=entradaTeclado.nextLine();
        System.out.println("Ingrese el serial del motor: ");
        serial=entradaTeclado.nextLine();
        System.out.println("Ingrese la potencia: ");
        cilindraje=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        Carro carroelectrico=new CarroElectrico(pasajeros,matricula,false,serial,cilindraje);

        return carroelectrico;
    }
    @Override
    public Moto crearMoto(){
        String matricula,serial;
        int cilindraje;
        System.out.println("Crear moto electrica.");
        System.out.println("Ingrese la matricula: ");
        matricula=entradaTeclado.nextLine();
        System.out.println("Ingrese el serial del motor: ");
        serial=entradaTeclado.nextLine();
        System.out.println("Ingrese la potencia: ");
        cilindraje=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        Moto motoelectrica=new MotoElectrica(matricula,false,serial,cilindraje);

        return motoelectrica;
    }
}

class FabricaGasolina extends Fabrica
{
    @Override
    public Carro crearCarro(){
        String matricula,serial;
        int pasajeros,cilindraje;
        System.out.println("Crear carro gasolina.");
        System.out.println("Ingrese la cantidad de pasajeros: ");
        pasajeros=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        System.out.println("Ingrese la matricula: ");
        matricula=entradaTeclado.nextLine();
        System.out.println("Ingrese el serial del motor: ");
        serial=entradaTeclado.nextLine();
        System.out.println("Ingrese el cilindraje: ");
        cilindraje=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        Carro carrogasolina=new CarroGasolina(pasajeros,matricula,false,serial,cilindraje);

        return carrogasolina;
    }
    @Override
    public Moto crearMoto(){
        String matricula,serial;
        int cilindraje;
        System.out.println("Crear moto gasolina.");
        System.out.println("Ingrese la matricula: ");
        matricula=entradaTeclado.nextLine();
        System.out.println("Ingrese el serial del motor: ");
        serial=entradaTeclado.nextLine();
        System.out.println("Ingrese el cilindraje: ");
        cilindraje=entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        Moto motogasolina=new MotoGasolina(matricula,false,serial,cilindraje);

        return motogasolina;
    }
}

enum ModoFabrica{
    GASOLINA,ELECTRICO
}

abstract class Fabrica
{
    Scanner entradaTeclado=new Scanner(System.in);
    private static final FabricaGasolina Objetos_gasolina= new FabricaGasolina();
    private static final FabricaElectricos Objetos_electricos= new FabricaElectricos();

    static Fabrica obtenerTipoFabricacion(ModoFabrica tipoFabricacion){
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
        Fabrica fabrica=Fabrica.obtenerTipoFabricacion(ModoFabrica.ELECTRICO);
        Moto honda=fabrica.crearMoto();
        System.out.println("Los datos de la moto son: ");
        System.out.println("Tipo motor: " + honda.getTipoMotor());
        System.out.println("Serial motor: "+ honda.getSerialMotor());
        System.out.println("Matricula: "+ honda.getMatricula());
        if(!honda.getPicoyPlaca()){
            System.out.println("No tiene pico y placa");
        }
        else{
            System.out.println("Tiene pico y placa");
        }
        System.out.println("Matricula: "+ honda.getMatricula());
    }
}
