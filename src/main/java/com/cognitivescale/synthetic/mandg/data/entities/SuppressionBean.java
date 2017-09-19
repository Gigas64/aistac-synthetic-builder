package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code SuppressionBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class SuppressionBean extends ObjectBean {

    private static final long serialVersionUID = -2432072367431771057L;

    private volatile int csId;
    private volatile String type;
    private volatile String subType;

    public SuppressionBean() {
        this.csId = ObjectEnum.INITIALISATION.value();
        this.type = "";
        this.subType = "";
    }

    public SuppressionBean(int identifier, int csId, String type, String subType, String owner) {
        super(identifier, owner);
        this.csId = csId;
        this.type = type;
        this.subType = subType;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public int getCsId() {
        return csId;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.csId;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.subType);
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
        final SuppressionBean other = (SuppressionBean) obj;
        if(this.csId != other.csId) {
            return false;
        }
        if(!Objects.equals(this.type, other.type)) {
            return false;
        }
        if(!Objects.equals(this.subType, other.subType)) {
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
        Element bean = new Element("SuppressionBean");
        rtnList.add(bean);
        // set the data
         bean.setAttribute("csId", Integer.toString(csId));
         bean.setAttribute("type", type);
         bean.setAttribute("subType", subType);

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
        Element bean = root.getChild("SuppressionBean");
        // set up the data
        csId = Integer.parseInt(bean.getAttributeValue("csId", "-1"));
        type = bean.getAttributeValue("type", "");
        subType = bean.getAttributeValue("subType", "");

    }

}
