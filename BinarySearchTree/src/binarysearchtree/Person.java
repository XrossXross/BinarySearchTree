/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author Q1.11Wiesenthal
 */
public class Person implements ComperableContent<Person> {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public boolean isGreater(Person pContent) {
        if (pContent != null) {
            if (name.compareTo(pContent.name) < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isLess(Person pContent) {
        if (pContent != null) {
            if (name.compareTo(pContent.name) > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqual(Person pContent) {
        if (pContent != null) {
            if (name.compareTo(pContent.name) == 0) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
