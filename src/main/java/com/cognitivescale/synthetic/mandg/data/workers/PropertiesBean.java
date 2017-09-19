/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)PropertiesBean.java
 *
 * Copyright:	Copyright (c) 2017
 * Company:		Oathouse.com Ltd
 */
package com.cognitivescale.synthetic.mandg.data.workers;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code PropertiesBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class PropertiesBean extends ObjectBean {

    private static final long serialVersionUID = 8459020901337994713L;

    private volatile String rootPath;

    public PropertiesBean() {
        this.rootPath = "";
    }

    public PropertiesBean(int identifier, String rootPath, String owner) {
        super(identifier, owner);
        this.rootPath = rootPath;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public String getRootPath() {
        return rootPath;
    }

    /* *********************
     * SETS
     * **********************/
    protected void setRootPath(String rootPath, String owner) {
        this.rootPath = rootPath;
        super.setOwner(owner);
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.rootPath);
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
        final PropertiesBean other = (PropertiesBean) obj;
        if(!Objects.equals(this.rootPath, other.rootPath)) {
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
        Element bean = new Element("PropertiesBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("rootPath", rootPath);

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
        Element bean = root.getChild("PropertiesBean");

        rootPath = bean.getAttributeValue("rootPath", "");

    }

}
