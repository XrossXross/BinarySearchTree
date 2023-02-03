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
        Person Günther = new Person("Günther");
        Person Robert = new Person("Robert");
        Person Lily = new Person("Lily");
        Person Uthe = new Person("Uthe");
        Person Gertrude = new Person("Gertrude");
        Person[] personen = {Geralt, Karl, Kevin, Inan, Caroline, Günther, Robert, Lily, Uthe, Gertrude};
        for (Person p : personen) {
            Baum.insert(p);
        }
        inorder(Baum);
    }

    public static void inorder(BinarySearchTree<Person> BST) {
        if (!BST.isEmpty()) {
            inorder(BST.getLeftTree());
        }
        System.out.println(BST.getContent().getName());
        if (!BST.isEmpty()) {
            inorder(BST.getRightTree());
        }
    }

}
