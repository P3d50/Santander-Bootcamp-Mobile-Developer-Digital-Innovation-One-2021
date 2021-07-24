import cliente.Cliente;
import cliente.ClientePF;
import cliente.Endereco;
import cliente.Cliente;
import conta.ContaCorrente;

public class mainJava {

    public static void printJava(){
        System.out.println("Println em java");
    }

    public static void main(String args[]){
        Endereco endereco = new Endereco("anibal",19,"jardim","sala x");
        ContaCorrente conta = new ContaCorrente(13,"457-8");
        cliente.Cliente cliente = new ClientePF(endereco,conta,"Pedro",30,"45567388894");
        cliente.imprimirDados();
        conta.depositar(500.0);
        conta.sacar(40.00);

    }
}
