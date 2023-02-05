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

    public BinarySearchTree(T pContent) {
        content = pContent;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public void insert(T pContent) {
        if (isEmpty()) {
            content = pContent;
            return;
        }
        if (pContent != null) {
            if (!isEmpty()) {
                if (pContent.isEqual(content)) {
                    return;
                } else if (pContent.isLess(content)) {
                    if (leftTree!=null&&!leftTree.isEmpty()) {
                        leftTree.insert(pContent);
                    } else {
                        leftTree = new BinarySearchTree<T>(pContent);
                    }
                } else if (pContent.isGreater(content)) {
                    if (rightTree!=null&&!rightTree.isEmpty()) {
                        rightTree.insert(pContent);
                    } else {
                        rightTree = new BinarySearchTree<T>(pContent);
                    }
                }
            }
        }
    }

    public T search(T pContent) {
        if (!isEmpty() && pContent != null) {
            if (pContent.isEqual(content)) {
                return content;
            } else if (leftTree!=null&&pContent.isLess(content)) {
                return leftTree.search(pContent);
            } else if (rightTree!=null&&pContent.isGreater(pContent)) {
                return rightTree.search(pContent);
            }
        }
        return null;
    }

    public void remove(T pContent) {
        BinarySearchTree<T> parent = new BinarySearchTree<T>();
        char direction='n';
        remove(pContent, parent, direction);
    }

    private void remove(T pContent, BinarySearchTree<T> parent, char direction) {
        BinarySearchTree<T> last;
        if (!isEmpty() && pContent != null) {
            if (pContent.isEqual(content)) {
                if (getLeftTree()==null&&getRightTree()==null) {
                     if(direction=='l')parent.setLeftTree(null);
                     if(direction=='r')parent.setRightTree(null);
                } else if (getLeftTree()==null) {
                    if(direction=='l')parent.setLeftTree(rightTree);
                    if(direction=='r')parent.setRightTree(rightTree);
                } else if (getRightTree()==null) {
                    if(direction=='l')parent.setLeftTree(leftTree);
                    if(direction=='r')parent.setRightTree(leftTree);
                } else {
                    BinarySearchTree<T> parentOfLast=this;
                    char directionOfLast='l';
                    last = getLeftTree();
                    if(last.getRightTree()!=null)directionOfLast='r';
                        while (last.getRightTree() != null) {
                            parentOfLast=last;
                            last = last.getRightTree();
                        }
                        if(direction=='l')parent.setLeftTree(last);
                        if(direction=='r')parent.setRightTree(last);
                        last.setLeftTree(leftTree);
                        last.setRightTree(rightTree);
                        if(directionOfLast=='l')parentOfLast.setLeftTree(null);
                        if(directionOfLast=='r')parentOfLast.setRightTree(null);
                }
            }
            else if (pContent.isLess(content)) {
                parent = this;
                direction = 'l';
                leftTree.remove(pContent, parent, direction);
            } else if (pContent.isGreater(pContent)) {
                parent = this;
                direction = 'r';
                rightTree.remove(pContent, parent, direction);
            }
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
