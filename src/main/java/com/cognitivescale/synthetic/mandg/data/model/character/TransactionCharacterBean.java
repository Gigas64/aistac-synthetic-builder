/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)TransactionCharacterBean.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:    
 * Schema:          
 */
package com.cognitivescale.synthetic.mandg.data.model.character;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import java.util.LinkedList;
import java.util.List;
import org.jdom2.Element;

/**
 * The {@code TransactionCharacterBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class TransactionCharacterBean extends ObjectBean {

    private static final long serialVersionUID = 100L;

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
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
        Element bean = new Element("TransactionCharacterBean");
        rtnList.add(bean);
        // set the data

        // TODO Add code here - For example:
        // bean.setAttribute("myInt", Integer.toString(myInt));
        // bean.setAttribute("myString", myString);
        // Element allElements = new Element("myRef_set");
        // bean.addContent(allElements);
        // if(myRef != null) {
        //     for(int i : myRef) {
        //         Element eachElement = new Element("myRef");
        //         eachElement.setAttribute("myRef", Integer.toString(i));
        //         allElements.addContent(eachElement);
        //     }
        // }

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
        Element bean = root.getChild("TransactionCharacterBean");
        // set up the data

        // TODO Add code here - For example:
        // myInt = Integer.parseInt(bean.getAttributeValue("myInt", "-1"));
        // myString = bean.getAttributeValue("myString", "");
        // List allElements = bean.getChild("myRef_set").getChildren("myRef");
        // myRefs.clear();
        // for(Object o : allElements) {
        //     Element eachElement = (Element) o;
        //     myRefs.add(Integer.parseInt(eachElement.getAttributeValue("myRef", "-1")));
        // }

    }

}
