import java.io.File;
import java.lang.reflect.Type;

class A {}
class B extends A {}
class C extends B {
    public C(){}
    public int x, y;
    public void Foo() {}
}

public class App {

    public static void main(String[] args) {
        PrintBaseTypes("Ola");
        PrintBaseTypes(19);
        PrintBaseTypes(new C());
        PrintBaseTypes(new File("."));

        PrintMembers(new C());
        PrintMethods(new C());
        PrintFields(new C());
    }

    public static void PrintMembers(Object obj) {
        System.out.print("Members: ");
        for(var m : obj.getClass().getMethods()) System.out.print(m.getName() + " ");
        for(var m : obj.getClass().getConstructors()) System.out.print(m.getName() + " ");
        for(var m : obj.getClass().getFields()) System.out.print(m.getName() + " ");
        System.out.println();;
    }
    public static void PrintMethods(Object obj) {
        System.out.print("Methods: ");
        for(var m : obj.getClass().getMethods()) System.out.print(m.getName() + " ");
        System.out.println();
    }
    public static void PrintFields(Object obj) {
        System.out.print("Fields: ");
        for(var m : obj.getClass().getFields()) System.out.print(m.getName() + " ");
        System.out.println();
    }

    // Não Fazer => Avaliação em Tempo de Execução
    // static readonly Type typeOfObject = (new Object()).GetType();

    public static void PrintBaseTypes(Object obj)
    {
        Class t = obj.getClass();
        do {
            System.out.print(t.getSimpleName() + " ");
            PrintInterfaces(t);
            t = t.getSuperclass();
            // } while( t != typeOfObject);
        } while( t != Object.class);
        System.out.println();
    }
    public static void PrintInterfaces(Class t) {
        System.out.print("(");
        for(var i : t.getInterfaces()) System.out.print(i.getSimpleName() + " ");
        System.out.print(") ");
    }
}
