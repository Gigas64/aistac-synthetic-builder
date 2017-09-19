/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)TransactionTypeBean.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:
 * Schema:
 */
package com.cognitivescale.synthetic.mandg.data.lookups;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code TransactionTypeBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class TransactionTypeBean extends ObjectBean {

    private static final long serialVersionUID = 921789625604632902L;

    private volatile int typeId;
    private volatile String typeName;

    public TransactionTypeBean() {
        this.typeId = ObjectEnum.INITIALISATION.value();
        this.typeName = "";
    }

    public TransactionTypeBean(int identifier, int typeId, String typeName, String owner) {
        super(identifier, owner);
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.typeId;
        hash = 23 * hash + Objects.hashCode(this.typeName);
        return hash + super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final TransactionTypeBean other = (TransactionTypeBean) obj;
        if(this.typeId != other.typeId) {
            return false;
        }
        if(!Objects.equals(this.typeName, other.typeName)) {
            return false;
        }
        return super.equals(obj);
    }

    /**
     * crates all the elements that represent this bean at this level.
     * @return List of elements in order
     */
    @Override
    public List<Element> getXMLElement() {
        List<Element> rtnList = new LinkedList<>();
        // create and add the content Element
        for(Element e : super.getXMLElement()) {
             rtnList.add(e);
        }
        Element bean = new Element("TransactionTypeBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("typeId", Integer.toString(typeId));
        bean.setAttribute("typeName", typeName);

        bean.setAttribute("serialVersionUID", Long.toString(serialVersionUID));
        return(rtnList);
    }

    /**
     * sets all the values in the bean from the XML. Remember to
     * put default values in getAttribute() and check the content
     * of getText() if you are parsing to a value.
     *
     * @param root element of the DOM
     */
    @Override
    public void setXMLDOM(Element root) {
        // extract the super meta data
        super.setXMLDOM(root);
        // extract the bean data
        Element bean = root.getChild("TransactionTypeBean");
        // set up the data
        typeId = Integer.parseInt(bean.getAttributeValue("typeId", "-1"));
        typeName = bean.getAttributeValue("typeName", "");

    }

}
