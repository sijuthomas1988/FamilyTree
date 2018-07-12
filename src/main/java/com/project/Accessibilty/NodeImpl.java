package com.project.Accessibilty;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl<T> {

    private T data = null;

    private List<NodeImpl<T>> childern = new ArrayList<>();

    private NodeImpl<T> parent = null;

    public NodeImpl(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<NodeImpl<T>> getChildern() {
        return childern;
    }

    public void setChildern(List<NodeImpl<T>> childern) {
        this.childern = childern;
    }

    public NodeImpl<T> getParent() {
        return parent;
    }

    public void setParent(NodeImpl<T> parent) {
        this.parent = parent;
    }

    public NodeImpl<T> addChild(NodeImpl<T> child){
        child.setParent(this);
        this.childern.add(child);
        return child;
    }

    public void addChildren(List<NodeImpl<T>> childern){
        childern.forEach(each -> each.setParent(this));
        this.childern.addAll(childern);
    }

    public NodeImpl<T> getRoot(){
     if(parent == null){
         return  this;
     }
     return parent.getRoot();
    }
}
