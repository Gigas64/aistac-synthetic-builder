package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code AccountBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class AccountBean extends ObjectBean {

    private static final long serialVersionUID = -4639675317550229680L;

    private volatile int customerId;
    private volatile int annualPremiumAmmount;
    private volatile String jointProduct;
    private volatile String firstDirectDebit;
    private volatile String nextDirectDebit;
    private volatile int lastLumpSumAmount;
    private volatile String lastLumpSumDate;
    private volatile int openFundCount;
    private volatile String productDesc;
    private volatile String servicingAgent;
    private volatile String sourceOfBusiness;
    private volatile String StaffTermsApplied;
    private volatile String status;
    private volatile int totalValue;

    public AccountBean() {
        this.customerId = ObjectEnum.INITIALISATION.value();
        this.annualPremiumAmmount = ObjectEnum.INITIALISATION.value();
        this.jointProduct = "";
        this.firstDirectDebit = "";
        this.nextDirectDebit = "";
        this.lastLumpSumAmount = ObjectEnum.INITIALISATION.value();
        this.lastLumpSumDate = "";
        this.openFundCount = ObjectEnum.INITIALISATION.value();
        this.productDesc = "";
        this.servicingAgent = "";
        this.sourceOfBusiness = "";
        this.StaffTermsApplied = "";
        this.status = "";
        this.totalValue = ObjectEnum.INITIALISATION.value();
    }

    public AccountBean(int identifier, int customerId, int annualPremiumAmmount, String jointProduct, String firstDirectDebit, String nextDirectDebit, int lastLumpSumAmount, String lastLumpSumDate, int openFundCount, String productDesc, String servicingAgent, String sourceOfBusiness, String StaffTermsApplied, String status, int totalValue, String owner) {
        super(identifier, owner);
        this.customerId = customerId;
        this.annualPremiumAmmount = annualPremiumAmmount;
        this.jointProduct = jointProduct;
        this.firstDirectDebit = firstDirectDebit;
        this.nextDirectDebit = nextDirectDebit;
        this.lastLumpSumAmount = lastLumpSumAmount;
        this.lastLumpSumDate = lastLumpSumDate;
        this.openFundCount = openFundCount;
        this.productDesc = productDesc;
        this.servicingAgent = servicingAgent;
        this.sourceOfBusiness = sourceOfBusiness;
        this.StaffTermsApplied = StaffTermsApplied;
        this.status = status;
        this.totalValue = totalValue;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getAnnualPremiumAmmount() {
        return annualPremiumAmmount;
    }

    public String getJointProduct() {
        return jointProduct;
    }

    public String getFirstDirectDebit() {
        return firstDirectDebit;
    }

    public String getNextDirectDebit() {
        return nextDirectDebit;
    }

    public int getLastLumpSumAmount() {
        return lastLumpSumAmount;
    }

    public String getLastLumpSumDate() {
        return lastLumpSumDate;
    }

    public int getOpenFundCount() {
        return openFundCount;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public String getServicingAgent() {
        return servicingAgent;
    }

    public String getSourceOfBusiness() {
        return sourceOfBusiness;
    }

    public String getStaffTermsApplied() {
        return StaffTermsApplied;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.customerId;
        hash = 43 * hash + this.annualPremiumAmmount;
        hash = 43 * hash + Objects.hashCode(this.jointProduct);
        hash = 43 * hash + Objects.hashCode(this.firstDirectDebit);
        hash = 43 * hash + Objects.hashCode(this.nextDirectDebit);
        hash = 43 * hash + this.lastLumpSumAmount;
        hash = 43 * hash + Objects.hashCode(this.lastLumpSumDate);
        hash = 43 * hash + this.openFundCount;
        hash = 43 * hash + Objects.hashCode(this.productDesc);
        hash = 43 * hash + Objects.hashCode(this.servicingAgent);
        hash = 43 * hash + Objects.hashCode(this.sourceOfBusiness);
        hash = 43 * hash + Objects.hashCode(this.StaffTermsApplied);
        hash = 43 * hash + Objects.hashCode(this.status);
        hash = 43 * hash + this.totalValue;
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
        final AccountBean other = (AccountBean) obj;
        if(this.customerId != other.customerId) {
            return false;
        }
        if(this.annualPremiumAmmount != other.annualPremiumAmmount) {
            return false;
        }
        if(this.lastLumpSumAmount != other.lastLumpSumAmount) {
            return false;
        }
        if(this.openFundCount != other.openFundCount) {
            return false;
        }
        if(this.totalValue != other.totalValue) {
            return false;
        }
        if(!Objects.equals(this.jointProduct, other.jointProduct)) {
            return false;
        }
        if(!Objects.equals(this.firstDirectDebit, other.firstDirectDebit)) {
            return false;
        }
        if(!Objects.equals(this.nextDirectDebit, other.nextDirectDebit)) {
            return false;
        }
        if(!Objects.equals(this.lastLumpSumDate, other.lastLumpSumDate)) {
            return false;
        }
        if(!Objects.equals(this.productDesc, other.productDesc)) {
            return false;
        }
        if(!Objects.equals(this.servicingAgent, other.servicingAgent)) {
            return false;
        }
        if(!Objects.equals(this.sourceOfBusiness, other.sourceOfBusiness)) {
            return false;
        }
        if(!Objects.equals(this.StaffTermsApplied, other.StaffTermsApplied)) {
            return false;
        }
        if(!Objects.equals(this.status, other.status)) {
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
        Element bean = new Element("AccountBean");
        rtnList.add(bean);
        bean.setAttribute("customerId", Integer.toString(customerId));
        bean.setAttribute("annualPremiumAmmount", Integer.toString(annualPremiumAmmount));
        bean.setAttribute("jointProduct", jointProduct);
        bean.setAttribute("firstDirectDebit", firstDirectDebit);
        bean.setAttribute("nextDirectDebit", nextDirectDebit);
        bean.setAttribute("lastLumpSumAmount", Integer.toString(lastLumpSumAmount));
        bean.setAttribute("lastLumpSumDate", lastLumpSumDate);
        bean.setAttribute("openFundCount", Integer.toString(openFundCount));
        bean.setAttribute("productDesc", productDesc);
        bean.setAttribute("servicingAgent", servicingAgent);
        bean.setAttribute("sourceOfBusiness", sourceOfBusiness);
        bean.setAttribute("StaffTermsApplied", StaffTermsApplied);
        bean.setAttribute("status", status);
        bean.setAttribute("totalValue", Integer.toString(totalValue));

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
        Element bean = root.getChild("AccountBean");

        customerId = Integer.parseInt(bean.getAttributeValue("customerId", "-1"));
        annualPremiumAmmount = Integer.parseInt(bean.getAttributeValue("annualPremiumAmmount", "-1"));
        jointProduct = bean.getAttributeValue("jointProduct", "");
        firstDirectDebit = bean.getAttributeValue("firstDirectDebit", "");
        nextDirectDebit = bean.getAttributeValue("nextDirectDebit", "");
        lastLumpSumAmount = Integer.parseInt(bean.getAttributeValue("lastLumpSumAmount", "-1"));
        lastLumpSumDate = bean.getAttributeValue("lastLumpSumDate", "");
        openFundCount = Integer.parseInt(bean.getAttributeValue("openFundCount", "-1"));
        productDesc = bean.getAttributeValue("productDesc", "");
        servicingAgent = bean.getAttributeValue("servicingAgent", "");
        sourceOfBusiness = bean.getAttributeValue("sourceOfBusiness", "");
        StaffTermsApplied = bean.getAttributeValue("StaffTermsApplied", "");
        status = bean.getAttributeValue("status", "");
        totalValue = Integer.parseInt(bean.getAttributeValue("totalValue", "-1"));

    }

}
