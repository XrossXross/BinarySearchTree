/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author Q1.11Wiesenthal
 */
public class Test {

    public static void main(String[] args) {
        BinarySearchTree<Person> Baum = new BinarySearchTree<Person>();
        Person Geralt = new Person("Geralt");
        Person Karl = new Person("Karl");
        Person Kevin = new Person("Kevin");
        Person Inan = new Person("Inan");
        Person Caroline = new Person("Caroline");
        Person Guenther = new Person("Guenther");
        Person Robert = new Person("Robert");
        Person Lily = new Person("Lily");
        Person Uthe = new Person("Uthe");
        Person Gertrude = new Person("Gertrude");
        Person[] personen = {Geralt, Karl, Kevin, Inan, Caroline, Guenther, Robert, Lily, Uthe, Gertrude};
        for (Person p : personen) {
            Baum.insert(p);
        }
        inorder(Baum);
        System.out.println();
        System.out.println(Baum.search(Kevin).getName());
        System.out.println();
<<<<<<< HEAD
        inOrderAusgeben(Baum,0);
        System.out.println();
        Baum.remove(Günther);
=======
        inOrderAusgeben(Baum, 0);
        System.out.println();
        Baum.remove(Gertrude);
>>>>>>> a95b43b5433c3317972b9df8fe90fb6c2af7ed8d
        inOrderAusgeben(Baum, 0);
        //inorder(Baum);
        //System.out.println();
        //Baum.remove(Gertrude);
        //inorder(Baum);
        //System.out.println();
        //Baum.remove(Lily);
        //inorder(Baum);
        //System.out.println();
    }

    public static void inorder(BinarySearchTree<Person> BST) {
        if (BST.getLeftTree() != null) {
            inorder(BST.getLeftTree());
        }
        if (BST != null && !BST.isEmpty()) {
            System.out.println(BST.getContent().getName());
        }
        if (BST.getRightTree() != null) {
            inorder(BST.getRightTree());
        }
    }
    private static void inOrderAusgeben(BinarySearchTree<Person> teilbaum, int indent)
    {
        
        if(teilbaum.getLeftTree()!=null)inOrderAusgeben(teilbaum.getLeftTree(), indent + 1);
        for(int i = 0; i < indent; i++) System.out.print("  ");
        System.out.println(teilbaum.getContent().getName());
        if(teilbaum.getRightTree()!=null)inOrderAusgeben(teilbaum.getRightTree(), indent + 1);
    }

    private static void inOrderAusgeben(BinarySearchTree<Person> teilbaum, int indent) {
        if (teilbaum.getLeftTree() != null) {
            inOrderAusgeben(teilbaum.getLeftTree(), indent + 1);
        }
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(teilbaum.getContent().getName());
        if (teilbaum.getRightTree() != null) {
            inOrderAusgeben(teilbaum.getRightTree(), indent + 1);
        }
    }

}
