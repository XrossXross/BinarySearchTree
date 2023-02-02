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

public static void main(String[] args){

}

public void inorder(BinarySearchTree<Person> BST){
inorder(BST.getLeftTree());
System.out.println(BST.getContent().getName());
inorder(BST.getRightTree());
}
    
}
