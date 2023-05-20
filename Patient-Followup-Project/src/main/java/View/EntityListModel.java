/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;


public class EntityListModel<T> extends AbstractListModel {
    //ds package view, class= ss class d'abstractlistmodel -> 2meth get et setsize
    //se comporte comme une liste mais peut prendre different type d'objet
    //liste T = template, pê remplacer par nptq class, utilise elem de cette liste pr remplir le Jlist
    //method to string pr representer par une chaine de charactere ds l'interface 
    private List<T> entities;
    
    public EntityListModel(List<T> entities){ 
        if( entities == null ){
            entities = new ArrayList();
        }
        this.entities = entities;
    }
    
    public void setList(List<T> entities){
        this.entities = entities;
    }
    
    public List<T> getList(){
        return entities;
    }
    
    @Override
    public int getSize() {
        return entities.size();
    }

    @Override
    public Object getElementAt(int index) {
        return entities.get(index);
    }
    
}
