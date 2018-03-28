//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.21 at 01:36:01 PM IST 
//


package com.baxter.idc.masterDataManager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ElementState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ElementState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="enabledOnly"/>
 *     &lt;enumeration value="disabledOnly"/>
 *     &lt;enumeration value="all"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ElementState")
@XmlEnum
public enum ElementState {

    @XmlEnumValue("enabledOnly")
    ENABLED_ONLY("enabledOnly"),
    @XmlEnumValue("disabledOnly")
    DISABLED_ONLY("disabledOnly"),
    @XmlEnumValue("all")
    ALL("all");
    private final String value;

    ElementState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ElementState fromValue(String v) {
        for (ElementState c: ElementState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}