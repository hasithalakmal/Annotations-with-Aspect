package com.smile24es.sample.beans.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * The bean class for ERROR
 *
 * @author hasithag
 * Date: 11/29/18.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomErrorBean implements Serializable {

    private static final long serialVersionUID = 2329892369893234295L;

    private String code;
    private String description;
    private String additionalInfo;

    /**
     * Constructor for CustomErrorBean.
     */
    public CustomErrorBean() {
    }

    /**
     * Constructor for CustomErrorBean.
     *
     * @param code        a {@link String} object.
     * @param description a {@link String} object.
     */
    public CustomErrorBean(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Constructor for CustomErrorBean.
     *
     * @param code           a {@link String} object.
     * @param description    a {@link String} object.
     * @param additionalInfo a {@link String} object.
     */
    public CustomErrorBean(String code, String description, String additionalInfo) {
        this.code = code;
        this.description = description;
        this.additionalInfo = additionalInfo;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String}
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String}
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     *
     * @return possible object is
     * {@link String}
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     *
     * @param value allowed object is
     *              {@link String}
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    @Override
    public String toString() {
        return "CustomErrorBean{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
