//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.21 at 01:36:01 PM IST 
//


package com.baxter.idc.masterDataManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNodeToHierarchy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNodeToHierarchy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hierarchyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mdElement" type="{http://www.ibm.com/xmlns/prod/ts/mdm/}MasterDataElement"/>
 *         &lt;element name="elementId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vocabularyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNodeToHierarchy", propOrder = {
    "hierarchyName",
    "mdElement",
    "elementId",
    "vocabularyName"
})
public class AddNodeToHierarchy {

    @XmlElement(required = true)
    protected String hierarchyName;
    @XmlElement(required = true)
    protected MasterDataElement mdElement;
    @XmlElement(required = true)
    protected String elementId;
    @XmlElement(required = true)
    protected String vocabularyName;

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
     * Gets the value of the mdElement property.
     * 
     * @return
     *     possible object is
     *     {@link MasterDataElement }
     *     
     */
    public MasterDataElement getMdElement() {
        return mdElement;
    }

    /**
     * Sets the value of the mdElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterDataElement }
     *     
     */
    public void setMdElement(MasterDataElement value) {
        this.mdElement = value;
    }

    /**
     * Gets the value of the elementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementId() {
        return elementId;
    }

    /**
     * Sets the value of the elementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementId(String value) {
        this.elementId = value;
    }

    /**
     * Gets the value of the vocabularyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVocabularyName() {
        return vocabularyName;
    }

    /**
     * Sets the value of the vocabularyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVocabularyName(String value) {
        this.vocabularyName = value;
    }

}
