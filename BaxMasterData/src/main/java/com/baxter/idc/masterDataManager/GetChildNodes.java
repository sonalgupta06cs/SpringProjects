//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.21 at 01:36:01 PM IST 
//


package com.baxter.idc.masterDataManager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getChildNodes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getChildNodes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hierarchyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="element" type="{http://www.ibm.com/xmlns/prod/ts/mdm/}MasterDataElement"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="filterString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ascending" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.ibm.com/xmlns/prod/ts/mdm/}ElementState" minOccurs="0"/>
 *         &lt;element name="entityDisplayAttr" type="{http://www.ibm.com/xmlns/prod/ts/mdm/}EntityDisplayAttr" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getChildNodes", propOrder = {
    "hierarchyName",
    "element",
    "start",
    "end",
    "filterString",
    "ascending",
    "state",
    "entityDisplayAttr"
})
public class GetChildNodes {

    @XmlElement(required = true)
    protected String hierarchyName;
    @XmlElement(required = true)
    protected MasterDataElement element;
    protected Integer start;
    protected Integer end;
    protected String filterString;
    protected Boolean ascending;
    @XmlSchemaType(name = "string")
    protected ElementState state;
    protected List<EntityDisplayAttr> entityDisplayAttr;

    /**
     * Gets the value of the hierarchyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchyName() {
        return hierarchyName;
    }

    /**
     * Sets the value of the hierarchyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchyName(String value) {
        this.hierarchyName = value;
    }

    /**
     * Gets the value of the element property.
     * 
     * @return
     *     possible object is
     *     {@link MasterDataElement }
     *     
     */
    public MasterDataElement getElement() {
        return element;
    }

    /**
     * Sets the value of the element property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterDataElement }
     *     
     */
    public void setElement(MasterDataElement value) {
        this.element = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStart(Integer value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnd(Integer value) {
        this.end = value;
    }

    /**
     * Gets the value of the filterString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterString() {
        return filterString;
    }

    /**
     * Sets the value of the filterString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterString(String value) {
        this.filterString = value;
    }

    /**
     * Gets the value of the ascending property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAscending() {
        return ascending;
    }

    /**
     * Sets the value of the ascending property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAscending(Boolean value) {
        this.ascending = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link ElementState }
     *     
     */
    public ElementState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementState }
     *     
     */
    public void setState(ElementState value) {
        this.state = value;
    }

    /**
     * Gets the value of the entityDisplayAttr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityDisplayAttr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityDisplayAttr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityDisplayAttr }
     * 
     * 
     */
    public List<EntityDisplayAttr> getEntityDisplayAttr() {
        if (entityDisplayAttr == null) {
            entityDisplayAttr = new ArrayList<EntityDisplayAttr>();
        }
        return this.entityDisplayAttr;
    }

}
