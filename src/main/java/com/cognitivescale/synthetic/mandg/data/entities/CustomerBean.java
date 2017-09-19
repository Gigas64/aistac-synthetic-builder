package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code CustomerBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 13-Sep-2017
 */
public class CustomerBean extends ObjectBean {

    private static final long serialVersionUID = -8081799363540544399L;

    private volatile int age;
    private volatile String status;
    private volatile String type;
    private volatile String date;
    private volatile boolean deceased;
    private volatile String gender;
    private volatile String maritalStatus;
    private volatile boolean overseasResident;
    private volatile String postcode;
    private volatile String staffTerms;
    private volatile String startDate;

    public CustomerBean() {
        this.age = ObjectEnum.INITIALISATION.value();
        this.status = "";
        this.type = "";
        this.date = "";
        this.deceased = false;
        this.gender = "";
        this.maritalStatus = "";
        this.overseasResident = false;
        this.postcode = "";
        this.staffTerms = "";
        this.startDate = "";
    }

    public CustomerBean(int identifier, int age, String status, String type, String date, boolean deceased, String gender, String maritalStatus, boolean overseasResident, String postcode, String staffTerms, String startDate, String owner) {
        super(identifier, owner);
        this.age = age;
        this.status = status;
        this.type = type;
        this.date = date;
        this.deceased = deceased;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.overseasResident = overseasResident;
        this.postcode = postcode;
        this.staffTerms = staffTerms;
        this.startDate = startDate;
    }


    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public boolean isOverseasResident() {
        return overseasResident;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStaffTerms() {
        return staffTerms;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.age;
        hash = 79 * hash + Objects.hashCode(this.status);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + (this.deceased ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.gender);
        hash = 79 * hash + Objects.hashCode(this.maritalStatus);
        hash = 79 * hash + (this.overseasResident ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.postcode);
        hash = 79 * hash + Objects.hashCode(this.staffTerms);
        hash = 79 * hash + Objects.hashCode(this.startDate);
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
        final CustomerBean other = (CustomerBean) obj;
        if(this.age != other.age) {
            return false;
        }
        if(this.deceased != other.deceased) {
            return false;
        }
        if(this.overseasResident != other.overseasResident) {
            return false;
        }
        if(!Objects.equals(this.status, other.status)) {
            return false;
        }
        if(!Objects.equals(this.type, other.type)) {
            return false;
        }
        if(!Objects.equals(this.date, other.date)) {
            return false;
        }
        if(!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if(!Objects.equals(this.maritalStatus, other.maritalStatus)) {
            return false;
        }
        if(!Objects.equals(this.postcode, other.postcode)) {
            return false;
        }
        if(!Objects.equals(this.staffTerms, other.staffTerms)) {
            return false;
        }
        if(!Objects.equals(this.startDate, other.startDate)) {
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
        Element bean = new Element("CustomerBean");
        rtnList.add(bean);
        // set the data

        bean.setAttribute("age", Integer.toString(age));
        bean.setAttribute("status", status);
        bean.setAttribute("type", type);
        bean.setAttribute("date", date);
        bean.setAttribute("deceased", Boolean.toString(deceased));
        bean.setAttribute("gender", gender);
        bean.setAttribute("maritalStatus", maritalStatus);
        bean.setAttribute("overseasResident", Boolean.toString(overseasResident));
        bean.setAttribute("postcode", postcode);
        bean.setAttribute("staffTerms", staffTerms);
        bean.setAttribute("startDate", startDate);

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
        Element bean = root.getChild("CustomerBean");
        // set up the data

        age = Integer.parseInt(bean.getAttributeValue("age", "-1"));
        status = bean.getAttributeValue("status", "");
        type = bean.getAttributeValue("type", "");
        date = bean.getAttributeValue("date", "");
        deceased = Boolean.parseBoolean(bean.getAttributeValue("deceased", "-1"));
        gender = bean.getAttributeValue("gender", "");
        maritalStatus = bean.getAttributeValue("maritalStatus", "");
        overseasResident = Boolean.parseBoolean(bean.getAttributeValue("overseasResident", "-1"));
        postcode = bean.getAttributeValue("postcode", "");
        staffTerms = bean.getAttributeValue("staffTerms", "");
        startDate = bean.getAttributeValue("startDate", "");

    }

}
