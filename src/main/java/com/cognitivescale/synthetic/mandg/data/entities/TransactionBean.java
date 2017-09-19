package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code TransactionBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class TransactionBean extends ObjectBean {

    private static final long serialVersionUID = 2280375205682582750L;

    private volatile int csId;
    private volatile int fundId;
    private volatile int cashGrossAmount;
    private volatile boolean cancelled;
    private volatile String ifdsMnemonic;
    private volatile String fundName;
    private volatile String fundShortName;
    private volatile String fundTypeDesc;
    private volatile int netMovementAmount;
    private volatile int netMovementUnits;
    private volatile int proactiveDirectDebitAmount;
    private volatile String proactiveDirectDebitDesc;
    private volatile String businessSource;
    private volatile String typeDate;
    private volatile String typeDesc;
    private volatile String typeOrigDesc;

    public TransactionBean() {
        this.csId = ObjectEnum.INITIALISATION.value();
        this.fundId = ObjectEnum.INITIALISATION.value();
        this.cashGrossAmount = ObjectEnum.INITIALISATION.value();
        this.cancelled = false;
        this.ifdsMnemonic = "";
        this.fundName = "";
        this.fundShortName = "";
        this.fundTypeDesc = "";
        this.netMovementAmount = ObjectEnum.INITIALISATION.value();
        this.netMovementUnits = ObjectEnum.INITIALISATION.value();
        this.proactiveDirectDebitAmount = ObjectEnum.INITIALISATION.value();
        this.proactiveDirectDebitDesc = "";
        this.businessSource = "";
        this.typeDate = "";
        this.typeDesc = "";
        this.typeOrigDesc = "";
    }

    public TransactionBean(int identifier, int csId, int fundId, int cashGrossAmount, boolean cancelled, String ifdsMnemonic, String fundName, String fundShortName, String fundTypeDesc, int netMovementAmount, int netMovementUnits, int proactiveDirectDebitAmount, String proactiveDirectDebitDesc, String businessSource, String typeDate, String typeDesc, String typeOrigDesc, String owner) {
        super(identifier, owner);
        this.csId = csId;
        this.fundId = fundId;
        this.cashGrossAmount = cashGrossAmount;
        this.cancelled = cancelled;
        this.ifdsMnemonic = ifdsMnemonic;
        this.fundName = fundName;
        this.fundShortName = fundShortName;
        this.fundTypeDesc = fundTypeDesc;
        this.netMovementAmount = netMovementAmount;
        this.netMovementUnits = netMovementUnits;
        this.proactiveDirectDebitAmount = proactiveDirectDebitAmount;
        this.proactiveDirectDebitDesc = proactiveDirectDebitDesc;
        this.businessSource = businessSource;
        this.typeDate = typeDate;
        this.typeDesc = typeDesc;
        this.typeOrigDesc = typeOrigDesc;
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

    public int getFundId() {
        return fundId;
    }

    public int getCashGrossAmount() {
        return cashGrossAmount;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public String getIfdsMnemonic() {
        return ifdsMnemonic;
    }

    public String getFundName() {
        return fundName;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public String getFundTypeDesc() {
        return fundTypeDesc;
    }

    public int getNetMovementAmount() {
        return netMovementAmount;
    }

    public int getNetMovementUnits() {
        return netMovementUnits;
    }

    public int getProactiveDirectDebitAmount() {
        return proactiveDirectDebitAmount;
    }

    public String getProactiveDirectDebitDesc() {
        return proactiveDirectDebitDesc;
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public String getTypeDate() {
        return typeDate;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public String getTypeOrigDesc() {
        return typeOrigDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.csId;
        hash = 59 * hash + this.fundId;
        hash = 59 * hash + this.cashGrossAmount;
        hash = 59 * hash + (this.cancelled ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.ifdsMnemonic);
        hash = 59 * hash + Objects.hashCode(this.fundName);
        hash = 59 * hash + Objects.hashCode(this.fundShortName);
        hash = 59 * hash + Objects.hashCode(this.fundTypeDesc);
        hash = 59 * hash + this.netMovementAmount;
        hash = 59 * hash + this.netMovementUnits;
        hash = 59 * hash + this.proactiveDirectDebitAmount;
        hash = 59 * hash + Objects.hashCode(this.proactiveDirectDebitDesc);
        hash = 59 * hash + Objects.hashCode(this.businessSource);
        hash = 59 * hash + Objects.hashCode(this.typeDate);
        hash = 59 * hash + Objects.hashCode(this.typeDesc);
        hash = 59 * hash + Objects.hashCode(this.typeOrigDesc);
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
        final TransactionBean other = (TransactionBean) obj;
        if(this.csId != other.csId) {
            return false;
        }
        if(this.fundId != other.fundId) {
            return false;
        }
        if(this.cashGrossAmount != other.cashGrossAmount) {
            return false;
        }
        if(this.cancelled != other.cancelled) {
            return false;
        }
        if(this.netMovementAmount != other.netMovementAmount) {
            return false;
        }
        if(this.netMovementUnits != other.netMovementUnits) {
            return false;
        }
        if(this.proactiveDirectDebitAmount != other.proactiveDirectDebitAmount) {
            return false;
        }
        if(!Objects.equals(this.ifdsMnemonic, other.ifdsMnemonic)) {
            return false;
        }
        if(!Objects.equals(this.fundName, other.fundName)) {
            return false;
        }
        if(!Objects.equals(this.fundShortName, other.fundShortName)) {
            return false;
        }
        if(!Objects.equals(this.fundTypeDesc, other.fundTypeDesc)) {
            return false;
        }
        if(!Objects.equals(this.proactiveDirectDebitDesc, other.proactiveDirectDebitDesc)) {
            return false;
        }
        if(!Objects.equals(this.businessSource, other.businessSource)) {
            return false;
        }
        if(!Objects.equals(this.typeDate, other.typeDate)) {
            return false;
        }
        if(!Objects.equals(this.typeDesc, other.typeDesc)) {
            return false;
        }
        if(!Objects.equals(this.typeOrigDesc, other.typeOrigDesc)) {
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
        Element bean = new Element("TransactionBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("csId", Integer.toString(csId));
        bean.setAttribute("fundId", Integer.toString(fundId));
        bean.setAttribute("cashGrossAmount", Integer.toString(cashGrossAmount));
        bean.setAttribute("cancelled", Boolean.toString(cancelled));
        bean.setAttribute("ifdsMnemonic", ifdsMnemonic);
        bean.setAttribute("fundName", fundName);
        bean.setAttribute("fundShortName", fundShortName);
        bean.setAttribute("fundTypeDesc", fundTypeDesc);
        bean.setAttribute("netMovementAmount", Integer.toString(netMovementAmount));
        bean.setAttribute("netMovementUnits", Integer.toString(netMovementUnits));
        bean.setAttribute("proactiveDirectDebitAmount", Integer.toString(proactiveDirectDebitAmount));
        bean.setAttribute("proactiveDirectDebitDesc", proactiveDirectDebitDesc);
        bean.setAttribute("businessSource", businessSource);
        bean.setAttribute("typeDate", typeDate);
        bean.setAttribute("typeDesc", typeDesc);
        bean.setAttribute("typeOrigDesc", typeOrigDesc);

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
        Element bean = root.getChild("TransactionBean");
        // set up the data
        csId = Integer.parseInt(bean.getAttributeValue("csId", "-1"));
        fundId = Integer.parseInt(bean.getAttributeValue("fundId", "-1"));
        cashGrossAmount = Integer.parseInt(bean.getAttributeValue("cashGrossAmount", "-1"));
        cancelled = Boolean.parseBoolean(bean.getAttributeValue("cancelled", "-1"));
        ifdsMnemonic = bean.getAttributeValue("ifdsMnemonic", "");
        fundName = bean.getAttributeValue("fundName", "");
        fundShortName = bean.getAttributeValue("fundShortName", "");
        fundTypeDesc = bean.getAttributeValue("fundTypeDesc", "");
        netMovementAmount = Integer.parseInt(bean.getAttributeValue("netMovementAmount", "-1"));
        netMovementUnits = Integer.parseInt(bean.getAttributeValue("netMovementUnits", "-1"));
        proactiveDirectDebitAmount = Integer.parseInt(bean.getAttributeValue("proactiveDirectDebitAmount", "-1"));
        proactiveDirectDebitDesc = bean.getAttributeValue("proactiveDirectDebitDesc", "");
        businessSource = bean.getAttributeValue("businessSource", "");
        typeDate = bean.getAttributeValue("typeDate", "");
        typeDesc = bean.getAttributeValue("typeDesc", "");
        typeOrigDesc = bean.getAttributeValue("typeOrigDesc", "");
    }

}
