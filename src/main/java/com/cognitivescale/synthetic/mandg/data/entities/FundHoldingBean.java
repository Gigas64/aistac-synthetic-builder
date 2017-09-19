package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jdom2.Element;

/**
 * The {@code FundHoldingBean} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class FundHoldingBean extends ObjectBean {

    private static final long serialVersionUID = 63185084238996134L;

    private volatile int accountId;
    private volatile String fundTypeDesc;
    private volatile String shortName;
    private volatile String ISIN;
    private volatile String mandgMnemonic;
    private volatile String ifdsMnemonic;
    private volatile String payFreqDesc;
    private volatile int regPremiumAmt;
    private volatile boolean reinvestDiv;
    private volatile String startDate;
    private volatile int totalSetUnits;
    private volatile int totalContributions;
    private volatile int totalFundValue;
    private volatile int lastValuationDate;

    public FundHoldingBean() {
        this.accountId = ObjectEnum.INITIALISATION.value();
        this.fundTypeDesc = "";
        this.shortName = "";
        this.ISIN = "";
        this.mandgMnemonic = "";
        this.ifdsMnemonic = "";
        this.payFreqDesc = "";
        this.regPremiumAmt = ObjectEnum.INITIALISATION.value();
        this.reinvestDiv = false;
        this.startDate = "";
        this.totalSetUnits = ObjectEnum.INITIALISATION.value();
        this.totalContributions = ObjectEnum.INITIALISATION.value();
        this.totalFundValue = ObjectEnum.INITIALISATION.value();
        this.lastValuationDate = ObjectEnum.INITIALISATION.value();
    }

    public FundHoldingBean(int identifier, int accountId, String fundTypeDesc, String shortName, String ISIN, String mandgMnemonic, String ifdsMnemonic, String payFreqDesc, int regPremiumAmt, boolean reinvestDiv, String startDate, int totalSetUnits, int totalContributions, int totalFundValue, int lastValuationDate, String owner) {
        super(identifier, owner);
        this.accountId = accountId;
        this.fundTypeDesc = fundTypeDesc;
        this.shortName = shortName;
        this.ISIN = ISIN;
        this.mandgMnemonic = mandgMnemonic;
        this.ifdsMnemonic = ifdsMnemonic;
        this.payFreqDesc = payFreqDesc;
        this.regPremiumAmt = regPremiumAmt;
        this.reinvestDiv = reinvestDiv;
        this.startDate = startDate;
        this.totalSetUnits = totalSetUnits;
        this.totalContributions = totalContributions;
        this.totalFundValue = totalFundValue;
        this.lastValuationDate = lastValuationDate;
    }

    public int getId() {
        return super.getIdentifier();
    }

    public int getKey() {
        return super.getGroupKey();
    }

    public int getAccountId() {
        return accountId;
    }

    public String getFundTypeDesc() {
        return fundTypeDesc;
    }

    public String getShortName() {
        return shortName;
    }

    public String getISIN() {
        return ISIN;
    }

    public String getMandgMnemonic() {
        return mandgMnemonic;
    }

    public String getIfdsMnemonic() {
        return ifdsMnemonic;
    }

    public String getPayFreqDesc() {
        return payFreqDesc;
    }

    public int getRegPremiumAmt() {
        return regPremiumAmt;
    }

    public boolean isReinvestDiv() {
        return reinvestDiv;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getTotalSetUnits() {
        return totalSetUnits;
    }

    public int getTotalContributions() {
        return totalContributions;
    }

    public int getTotalFundValue() {
        return totalFundValue;
    }

    public int getLastValuationDate() {
        return lastValuationDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.accountId;
        hash = 89 * hash + Objects.hashCode(this.fundTypeDesc);
        hash = 89 * hash + Objects.hashCode(this.shortName);
        hash = 89 * hash + Objects.hashCode(this.ISIN);
        hash = 89 * hash + Objects.hashCode(this.mandgMnemonic);
        hash = 89 * hash + Objects.hashCode(this.ifdsMnemonic);
        hash = 89 * hash + Objects.hashCode(this.payFreqDesc);
        hash = 89 * hash + this.regPremiumAmt;
        hash = 89 * hash + (this.reinvestDiv ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.startDate);
        hash = 89 * hash + this.totalSetUnits;
        hash = 89 * hash + this.totalContributions;
        hash = 89 * hash + this.totalFundValue;
        hash = 89 * hash + this.lastValuationDate;
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
        final FundHoldingBean other = (FundHoldingBean) obj;
        if(this.accountId != other.accountId) {
            return false;
        }
        if(this.regPremiumAmt != other.regPremiumAmt) {
            return false;
        }
        if(this.reinvestDiv != other.reinvestDiv) {
            return false;
        }
        if(this.totalSetUnits != other.totalSetUnits) {
            return false;
        }
        if(this.totalContributions != other.totalContributions) {
            return false;
        }
        if(this.totalFundValue != other.totalFundValue) {
            return false;
        }
        if(this.lastValuationDate != other.lastValuationDate) {
            return false;
        }
        if(!Objects.equals(this.fundTypeDesc, other.fundTypeDesc)) {
            return false;
        }
        if(!Objects.equals(this.shortName, other.shortName)) {
            return false;
        }
        if(!Objects.equals(this.ISIN, other.ISIN)) {
            return false;
        }
        if(!Objects.equals(this.mandgMnemonic, other.mandgMnemonic)) {
            return false;
        }
        if(!Objects.equals(this.ifdsMnemonic, other.ifdsMnemonic)) {
            return false;
        }
        if(!Objects.equals(this.payFreqDesc, other.payFreqDesc)) {
            return false;
        }
        if(!Objects.equals(this.startDate, other.startDate)) {
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
        Element bean = new Element("FundHoldingBean");
        rtnList.add(bean);
        // set the data
        bean.setAttribute("accountId", Integer.toString(accountId));
        bean.setAttribute("fundTypeDesc", fundTypeDesc);
        bean.setAttribute("shortName", shortName);
        bean.setAttribute("ISIN", ISIN);
        bean.setAttribute("mandgMnemonic", mandgMnemonic);
        bean.setAttribute("ifdsMnemonic", ifdsMnemonic);
        bean.setAttribute("payFreqDesc", payFreqDesc);
        bean.setAttribute("regPremiumAmt", Integer.toString(regPremiumAmt));
        bean.setAttribute("reinvestDiv", Boolean.toString(reinvestDiv));
        bean.setAttribute("startDate", startDate);
        bean.setAttribute("totalSetUnits", Integer.toString(totalSetUnits));
        bean.setAttribute("totalContributions", Integer.toString(totalContributions));
        bean.setAttribute("totalFundValue", Integer.toString(totalFundValue));
        bean.setAttribute("lastValuationDate", Integer.toString(lastValuationDate));

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
        Element bean = root.getChild("FundHoldingBean");

        accountId = Integer.parseInt(bean.getAttributeValue("accountId", "-1"));
        fundTypeDesc = bean.getAttributeValue("fundTypeDesc", "");
        shortName = bean.getAttributeValue("shortName", "");
        ISIN = bean.getAttributeValue("ISIN", "");
        mandgMnemonic = bean.getAttributeValue("mandgMnemonic", "");
        ifdsMnemonic = bean.getAttributeValue("ifdsMnemonic", "");
        payFreqDesc = bean.getAttributeValue("payFreqDesc", "");
        regPremiumAmt = Integer.parseInt(bean.getAttributeValue("regPremiumAmt", "-1"));
        reinvestDiv = Boolean.parseBoolean(bean.getAttributeValue("reinvestDiv", "-1"));
        startDate = bean.getAttributeValue("startDate", "");
        totalSetUnits = Integer.parseInt(bean.getAttributeValue("totalSetUnits", "-1"));
        totalContributions = Integer.parseInt(bean.getAttributeValue("totalContributions", "-1"));
        totalFundValue = Integer.parseInt(bean.getAttributeValue("totalFundValue", "-1"));
        lastValuationDate = Integer.parseInt(bean.getAttributeValue("lastValuationDate", "-1"));
    }

}
