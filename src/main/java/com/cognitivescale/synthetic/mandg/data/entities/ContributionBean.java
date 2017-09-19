package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code ContributionBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class ContributionBean extends ObjectBean {

    private static final long serialVersionUID = 2293696094066491858L;

    private volatile int csId;
    private volatile String firstContributionDate;
    private volatile int futureDirectDebitPayment;
    private volatile String pepLimitExceededDate;
    private volatile String taxYearEndDate;
    private volatile String taxYearStartDate;

    public ContributionBean() {
        this.csId = ObjectEnum.INITIALISATION.value();
        this.firstContributionDate = "";
        this.futureDirectDebitPayment = ObjectEnum.INITIALISATION.value();
        this.pepLimitExceededDate = "";
        this.taxYearEndDate = "";
        this.taxYearStartDate = "";
    }

    public ContributionBean(int identifier, int csId, String firstContributionDate, int futureDirectDebitPayment, String pepLimitExceededDate, int remainingISABalance, String taxYearEndDate, String taxYearStartDate, int totalCashContribution, int totalEquityContribution, int totalGrossContribution, String owner) {
        super(identifier, owner);
        this.csId = csId;
        this.firstContributionDate = firstContributionDate;
        this.futureDirectDebitPayment = futureDirectDebitPayment;
        this.pepLimitExceededDate = pepLimitExceededDate;
        this.taxYearEndDate = taxYearEndDate;
        this.taxYearStartDate = taxYearStartDate;
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

    public String getFirstContributionDate() {
        return firstContributionDate;
    }

    public int getFutureDirectDebitPayment() {
        return futureDirectDebitPayment;
    }

    public String getPepLimitExceededDate() {
        return pepLimitExceededDate;
    }

    public String getTaxYearEndDate() {
        return taxYearEndDate;
    }

    public String getTaxYearStartDate() {
        return taxYearStartDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.csId;
        hash = 23 * hash + Objects.hashCode(this.firstContributionDate);
        hash = 23 * hash + this.futureDirectDebitPayment;
        hash = 23 * hash + Objects.hashCode(this.pepLimitExceededDate);
        hash = 23 * hash + Objects.hashCode(this.taxYearEndDate);
        hash = 23 * hash + Objects.hashCode(this.taxYearStartDate);
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
        final ContributionBean other = (ContributionBean) obj;
        if(this.csId != other.csId) {
            return false;
        }
        if(this.futureDirectDebitPayment != other.futureDirectDebitPayment) {
            return false;
        }
        if(!Objects.equals(this.firstContributionDate, other.firstContributionDate)) {
            return false;
        }
        if(!Objects.equals(this.pepLimitExceededDate, other.pepLimitExceededDate)) {
            return false;
        }
        if(!Objects.equals(this.taxYearEndDate, other.taxYearEndDate)) {
            return false;
        }
        if(!Objects.equals(this.taxYearStartDate, other.taxYearStartDate)) {
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
        Element bean = new Element("ContributionBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("csId", Integer.toString(csId));
        bean.setAttribute("firstContributionDate", firstContributionDate);
        bean.setAttribute("futureDirectDebitPayment", Integer.toString(futureDirectDebitPayment));
        bean.setAttribute("pepLimitExceededDate", pepLimitExceededDate);
        bean.setAttribute("taxYearEndDate", taxYearEndDate);
        bean.setAttribute("taxYearStartDate", taxYearStartDate);

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
        Element bean = root.getChild("ContributionBean");
        // set up the data
        csId = Integer.parseInt(bean.getAttributeValue("csId", "-1"));
        firstContributionDate = bean.getAttributeValue("firstContributionDate", "");
        futureDirectDebitPayment = Integer.parseInt(bean.getAttributeValue("futureDirectDebitPayment", "-1"));
        pepLimitExceededDate = bean.getAttributeValue("pepLimitExceededDate", "");
        taxYearEndDate = bean.getAttributeValue("taxYearEndDate", "");
        taxYearStartDate = bean.getAttributeValue("taxYearStartDate", "");

    }

}
