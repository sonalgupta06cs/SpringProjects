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
 * <p>Java class for getElementByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getElementByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mdElement" type="{http://www.ibm.com/xmlns/prod/ts/mdm/}MasterDataElement"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getElementByIdResponse", propOrder = {
    "mdElement"
})
public class GetElementByIdResponse {

    @XmlElement(required = true)
    protected MasterDataElement mdElement;

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

}
