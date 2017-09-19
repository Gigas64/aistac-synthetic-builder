package com.cognitivescale.synthetic.mandg.data.lookups;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code PostcodeBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class PostcodeBean extends ObjectBean {

    private static final long serialVersionUID = 4024433402295183793L;

    private volatile String postcode;
    private volatile int population;
    private volatile int households;

    public PostcodeBean() {
        this.postcode = "";
        this.population = ObjectEnum.INITIALISATION.value();
        this.households = ObjectEnum.INITIALISATION.value();
    }

    public PostcodeBean(int identifier, String postcode, int population, int households, String owner) {
        super(identifier, owner);
        this.postcode = postcode;
        this.population = population;
        this.households = households;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public String getPostcode() {
        return postcode;
    }

    public int getPopulation() {
        return population;
    }

    public int getHouseholds() {
        return households;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.postcode);
        hash = 73 * hash + this.population;
        hash = 73 * hash + this.households;
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
        final PostcodeBean other = (PostcodeBean) obj;
        if(this.population != other.population) {
            return false;
        }
        if(this.households != other.households) {
            return false;
        }
        if(!Objects.equals(this.postcode, other.postcode)) {
            return false;
        }
        return super.equals(obj);
    }

    /**
     * crates all the elements that represent this bean at this level.
     *
     * @return List of elements in order
     */
    @Override
    public List<Element> getXMLElement() {
        List<Element> rtnList = new LinkedList<>();
        // create and add the content Element
        for(Element e : super.getXMLElement()) {
            rtnList.add(e);
        }
        Element bean = new Element("PostcodeBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("postcode", postcode);
        bean.setAttribute("population", Integer.toString(population));
        bean.setAttribute("households", Integer.toString(households));

        bean.setAttribute("serialVersionUID", Long.toString(serialVersionUID));
        return (rtnList);
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
        Element bean = root.getChild("PostcodeBean");
        // set up the data

        postcode = bean.getAttributeValue("postcode", "");
        population = Integer.parseInt(bean.getAttributeValue("population", "-1"));
        households = Integer.parseInt(bean.getAttributeValue("households", "-1"));

    }

}
