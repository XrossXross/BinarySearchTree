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
        content = null;
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
                    if (leftTree != null && !leftTree.isEmpty()) {
                        leftTree.insert(pContent);
                    } else {
                        leftTree = new BinarySearchTree<T>(pContent);
                    }
                } else if (pContent.isGreater(content)) {
                    if (rightTree != null && !rightTree.isEmpty()) {
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
            } else if (pContent.isLess(content)) {
                return leftTree.search(pContent);
            } else if (pContent.isGreater(pContent)) {
                return rightTree.search(pContent);
            }
        }
        return null;
    }

    /*
public void remove(T pContent) {
        BinarySearchTree<T> parent=null;
        char direction='n';
        remove(pContent, parent, direction);
    }

    private void remove(T pContent, BinarySearchTree<T> parent, char direction) {
        BinarySearchTree<T> last=null;
        if (!isEmpty() && pContent != null) {
            if (pContent.isEqual(content)) {
                if (getLeftTree()==null && getRightTree()==null) {
                     if(direction=='l')parent.setLeftTree(null);
                     if(direction=='r')parent.setRightTree(null);
                     if(direction=='n')content=null;
                } else if (getLeftTree()==null) {
                    if(direction=='l')parent.setLeftTree(rightTree);
                    if(direction=='r')parent.setRightTree(rightTree);
                    if(direction=='n'){
                        content=rightTree.getContent();
                        if(rightTree.getRightTree()!=null)rightTree=leftTree.getRightTree();
                        if(rightTree.getLeftTree()!=null)leftTree=leftTree.getLeftTree();
                    }
                } else if (getRightTree()==null) {
                    if(direction=='l')parent.setLeftTree(leftTree);
                    if(direction=='r')parent.setRightTree(leftTree);
                    if(direction=='n'){
                        content=leftTree.getContent();
                        if(rightTree.getLeftTree()!=null)leftTree=rightTree.getLeftTree();
                        if(rightTree.getRightTree()!=null)rightTree=rightTree.getRightTree();
                    }
                } else {
                    last = getLeftTree();
                    while (last.getRightTree() != null) {
                        last = last.getRightTree();
                    }
                    if(direction!='n'){
                        if(direction=='l')parent.setLeftTree(last);
                        if(direction=='r')parent.setRightTree(last);
                        last.setLeftTree(leftTree);
                        last.setRightTree(rightTree);
                    }else{
                       content=last.getContent();
                    }
                    leftTree.remove(last.getContent());
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
     */
public void remove(T pContent){
remove(pContent,null,'n');
}
    private void remove(T pContent, BinarySearchTree<T> parent, char direction) {
        if (isEmpty() || pContent == null) {
            return;
        }
        if (content == pContent) {
            if (leftTree == null) {
                if (rightTree == null) {
                    if (direction == 'l') {
                        parent.setLeftTree(null);
                    }
                    if (direction == 'r') {
                        parent.setRightTree(null);
                    }
                } else {
                    if (direction == 'l') {
                        parent.setLeftTree(rightTree);
                    }
                    if (direction == 'r') {
                        parent.setRightTree(rightTree);
                    }
                }
            } else if (rightTree == null) {
                if (direction == 'l') {
                    parent.setLeftTree(leftTree);
                }
                if (direction == 'r') {
                    parent.setRightTree(leftTree);
                }
            } else {
                BinarySearchTree<T> parentOfLast = this;
                BinarySearchTree<T> last = leftTree;
                while (last.getRightTree() != null) {
                    parentOfLast = last;
                    last = last.getRightTree();
                }
                if (direction == 'l') {
                    parent.setLeftTree(last);
                }
                if (direction == 'r') {
                    parent.setRightTree(last);
                }
                if (last.getLeftTree() != null) {
                    parentOfLast.setRightTree(last.getLeftTree());
                }
                last.setLeftTree(leftTree);
                last.setRightTree(rightTree);
            }
        } else if (leftTree!=null&&content.isLess(pContent)) {
            parent = this;
            direction = 'l';
            leftTree.remove(pContent, parent, direction);
        } else if (rightTree!=null&&content.isGreater(pContent)) {
            parent = this;
            direction = 'r';
            rightTree.remove(pContent, parent, direction);
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
