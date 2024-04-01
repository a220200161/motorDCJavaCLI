package motorDCJavaCLI;

import java.util.Scanner;

public class motorDCJavaCLI {
    
    public static void main(String [] args){
        app();
    }

    private static void app(){
        Scanner scan =new Scanner(System.in);
        engine motor = new engine(false,"Reloj");
        String comando;
        while(true){
            System.out.println("\n---------------------------------------------------\n");
            if(motor.getState()){
                System.out.print(String.format("El motor esta encendido, en la direccion %s. Puede \"Apagar\" o \"Cambiar\" direccion, o \"Cerrar\" la aplicacion: ", motor.getDirection()));
                comando = scan.nextLine();
                if(comando.equals("Apagar")){
                    motor.setState(false);
                    System.out.println("El motor ha sido apagado.");
                }else if (comando.equals("Cambiar")){
                    if(motor.getDirection().equals("Reloj")){
                        motor.setDirection("Contra Reloj");
                    }else if(motor.getDirection().equals("Contra Reloj")){
                        motor.setDirection("Reloj");
                    }
                    System.out.println("La direccion ha sido cambiada.");
                }
            }else{
                System.out.print("El motor esta apagado. Puede \"Encender\" el motor, o \"Cerrar\" la aplicacion: ");
                comando = scan.nextLine();
                if(comando.equals("Encender")){
                    motor.setState(true);
                    System.out.println("El motor ha sido encendido.");
                }
            }
            
            if (comando.equals("Cerrar")){
                System.out.println("Cerrando aplicacion...");
                break;
            }
            
        }
        
    }
    
}
