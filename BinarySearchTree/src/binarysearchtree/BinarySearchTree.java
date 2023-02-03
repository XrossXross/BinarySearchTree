/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author Q1.11Wiesenthal
 */
public class BinarySearchTree<T extends ComperableContent<T>> {

    private BinarySearchTree<T> leftTree;
    private BinarySearchTree<T> rightTree;
    private T content;

    public BinarySearchTree() {
    }

    public boolean isEmpty() {
        return content != null;
    }

    public void insert(T pContent) {
        if (pContent != null) {
            if (!isEmpty()) {
                if (pContent.isEqual(content)) {
                    return;
                } else if (pContent.isLess(content)) {
                    leftTree.insert(pContent);
                } else if (pContent.isGreater(content)) {
                    rightTree.insert(pContent);
                }
            }
            content = pContent;
        }
    }

    public T search(T pContent) {
        if (!isEmpty() && pContent != null) {
            if (pContent.isEqual(content)) {
                return content;
            } else if (pContent.isLess(content)) {
                leftTree.search(pContent);
            } else if (pContent.isGreater(pContent)) {
                rightTree.search(pContent);
            }
        }
        return null;
    }

    public void remove(T pContent) {
        BinarySearchTree<T> parent = null;
        remove(pContent, parent);
    }

    private void remove(T pContent, BinarySearchTree<T> parent) {
        int c;
        char direction = ' ';
        BinarySearchTree<T> last;
        if (!isEmpty() && pContent != null) {
            if (pContent.isEqual(content)) {
                if (getLeftTree().isEmpty() && getRightTree().isEmpty()) {
                    c = 1;
                } else if (getLeftTree().isEmpty()) {
                    c = 2;
                    direction = 'l';
                } else if (getRightTree().isEmpty()) {
                    c = 2;
                    direction = 'r';
                } else {
                    c = 3;
                }
                switch (c) {
                    case 1:
                        content = null;
                    case 2:
                        if (direction == 'l') {
                            parent.setLeftTree(this);
                        }
                        if (direction == 'r') {
                            parent.setRightTree(this);
                        }
                    case 3:
                        last = getLeftTree();
                        while (last.getRightTree() != null) {
                            last = last.getRightTree();
                        }
                        parent.setLeftTree(last);
                        last.setLeftTree(leftTree);
                        last.setRightTree(rightTree);
                        remove(last.getContent());
                }
            }
        } else if (pContent.isLess(content)) {
            parent = this;
            leftTree.remove(pContent, parent);
        } else if (pContent.isGreater(pContent)) {
            parent = this;
            rightTree.remove(pContent, parent);
        }
    }

    public T getContent() {
        return content;
    }

    public BinarySearchTree<T> getLeftTree() {
        return leftTree;
    }

    public BinarySearchTree<T> getRightTree() {
        return rightTree;
    }

    public void setLeftTree(BinarySearchTree<T> leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightTree(BinarySearchTree<T> rightTree) {
        this.rightTree = rightTree;
    }

}
