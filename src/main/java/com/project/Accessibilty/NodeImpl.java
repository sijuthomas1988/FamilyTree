package com.project.Accessibilty;

import java.util.ArrayList;
import java.util.List;

/**
 * Node Implementation for converting Objects into a tree.
 * @author SKR
 */
public class NodeImpl<T> {

    /** data of the node */
    private T data = null;

    /** childrens of the node */
    private List<NodeImpl<T>> childern = new ArrayList<>();

    /** parent node reference */
    private NodeImpl<T> parent = null;

    /**
     * Constructor
     * @param data data for the node constructed.
     */
    public NodeImpl(T data) {
        this.data = data;
    }

    /**
     * get data of the node.
     * @return data of node
     */
    public T getData() {
        return data;
    }

    /**
     * set data of the node.
     * @param data data of node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * get child nodes of the node.
     * @return children of node
     */
    public List<NodeImpl<T>> getChildern() {
        return childern;
    }

    /**
     * set child nodes of the node.
     * @param childern children of the node
     */
    public void setChildern(List<NodeImpl<T>> childern) {
        this.childern = childern;
    }

    /**
     * get parent node of the node.
     * @return parent of the node
     */
    public NodeImpl<T> getParent() {
        return parent;
    }

    /**
     * set parent node of the node.
     * @param parent parent of the node
     */
    public void setParent(NodeImpl<T> parent) {
        this.parent = parent;
    }

    /**
     *adds the child to the parent node.
     * @param child
     * @return Node
     */
    public NodeImpl<T> addChild(NodeImpl<T> child){
        child.setParent(this);
        this.childern.add(child);
        return child;
    }

    /**
     * gets the root Node.
     * @return Node
     */
    public NodeImpl<T> getRoot(){
     if(parent == null){
         return  this;
     }
     return parent.getRoot();
    }
}
