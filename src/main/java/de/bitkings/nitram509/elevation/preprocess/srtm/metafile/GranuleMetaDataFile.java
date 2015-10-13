//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.09.26 um 11:38:58 PM CEST 
//


package de.bitkings.nitram509.elevation.preprocess.srtm.metafile;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * <p/>
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DTDVersion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DataCenterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GranuleURMetaData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GranuleUR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DbID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="InsertTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="LastUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="CollectionMetaData">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="VersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DataFiles">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DataFileContainer">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DistributedFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ChecksumType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ChecksumOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ECSDataGranule">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SizeMBECSDataGranule" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="LocalGranuleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ProductionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="LocalVersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="RangeDateTime">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="RangeEndingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="RangeEndingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="RangeBeginningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="RangeBeginningDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SpatialDomainContainer">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="HorizontalSpatialDomainContainer">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BoundingRectangle">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="WestBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="NorthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="EastBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="SouthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="BrowseProduct">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="BrowseGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="PSAs">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PSA" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PSAName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PSAValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="QAProduct">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="QAGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dtdVersion",
    "dataCenterId",
    "granuleURMetaData"
})
@XmlRootElement(name = "GranuleMetaDataFile")
public class GranuleMetaDataFile {

  @XmlElement(name = "DTDVersion", required = true)
  protected BigDecimal dtdVersion;
  @XmlElement(name = "DataCenterId", required = true)
  protected String dataCenterId;
  @XmlElement(name = "GranuleURMetaData", required = true)
  protected GranuleMetaDataFile.GranuleURMetaData granuleURMetaData;

  /**
   * Ruft den Wert der dtdVersion-Eigenschaft ab.
   *
   * @return possible object is
   * {@link BigDecimal }
   */
  public BigDecimal getDTDVersion() {
    return dtdVersion;
  }

  /**
   * Legt den Wert der dtdVersion-Eigenschaft fest.
   *
   * @param value allowed object is
   *              {@link BigDecimal }
   */
  public void setDTDVersion(BigDecimal value) {
    this.dtdVersion = value;
  }

  /**
   * Ruft den Wert der dataCenterId-Eigenschaft ab.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDataCenterId() {
    return dataCenterId;
  }

  /**
   * Legt den Wert der dataCenterId-Eigenschaft fest.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDataCenterId(String value) {
    this.dataCenterId = value;
  }

  /**
   * Ruft den Wert der granuleURMetaData-Eigenschaft ab.
   *
   * @return possible object is
   * {@link GranuleMetaDataFile.GranuleURMetaData }
   */
  public GranuleMetaDataFile.GranuleURMetaData getGranuleURMetaData() {
    return granuleURMetaData;
  }

  /**
   * Legt den Wert der granuleURMetaData-Eigenschaft fest.
   *
   * @param value allowed object is
   *              {@link GranuleMetaDataFile.GranuleURMetaData }
   */
  public void setGranuleURMetaData(GranuleMetaDataFile.GranuleURMetaData value) {
    this.granuleURMetaData = value;
  }


  /**
   * <p>Java-Klasse f�r anonymous complex type.
   * <p/>
   * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
   * <p/>
   * <pre>
   * &lt;complexType>
   *   &lt;complexContent>
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *       &lt;sequence>
   *         &lt;element name="GranuleUR" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *         &lt;element name="DbID" type="{http://www.w3.org/2001/XMLSchema}int"/>
   *         &lt;element name="InsertTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *         &lt;element name="LastUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *         &lt;element name="CollectionMetaData">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                   &lt;element name="VersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="DataFiles">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="DataFileContainer">
   *                     &lt;complexType>
   *                       &lt;complexContent>
   *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                           &lt;sequence>
   *                             &lt;element name="DistributedFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                             &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
   *                             &lt;element name="ChecksumType" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                             &lt;element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}int"/>
   *                             &lt;element name="ChecksumOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                           &lt;/sequence>
   *                         &lt;/restriction>
   *                       &lt;/complexContent>
   *                     &lt;/complexType>
   *                   &lt;/element>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="ECSDataGranule">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="SizeMBECSDataGranule" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
   *                   &lt;element name="LocalGranuleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                   &lt;element name="ProductionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *                   &lt;element name="LocalVersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="RangeDateTime">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="RangeEndingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *                   &lt;element name="RangeEndingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *                   &lt;element name="RangeBeginningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *                   &lt;element name="RangeBeginningDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="SpatialDomainContainer">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="HorizontalSpatialDomainContainer">
   *                     &lt;complexType>
   *                       &lt;complexContent>
   *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                           &lt;sequence>
   *                             &lt;element name="BoundingRectangle">
   *                               &lt;complexType>
   *                                 &lt;complexContent>
   *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                                     &lt;sequence>
   *                                       &lt;element name="WestBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
   *                                       &lt;element name="NorthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
   *                                       &lt;element name="EastBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
   *                                       &lt;element name="SouthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
   *                                     &lt;/sequence>
   *                                   &lt;/restriction>
   *                                 &lt;/complexContent>
   *                               &lt;/complexType>
   *                             &lt;/element>
   *                           &lt;/sequence>
   *                         &lt;/restriction>
   *                       &lt;/complexContent>
   *                     &lt;/complexType>
   *                   &lt;/element>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="BrowseProduct">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="BrowseGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="PSAs">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="PSA" maxOccurs="unbounded">
   *                     &lt;complexType>
   *                       &lt;complexContent>
   *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                           &lt;sequence>
   *                             &lt;element name="PSAName" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                             &lt;element name="PSAValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                           &lt;/sequence>
   *                         &lt;/restriction>
   *                       &lt;/complexContent>
   *                     &lt;/complexType>
   *                   &lt;/element>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *         &lt;element name="QAProduct">
   *           &lt;complexType>
   *             &lt;complexContent>
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *                 &lt;sequence>
   *                   &lt;element name="QAGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
   *                 &lt;/sequence>
   *               &lt;/restriction>
   *             &lt;/complexContent>
   *           &lt;/complexType>
   *         &lt;/element>
   *       &lt;/sequence>
   *     &lt;/restriction>
   *   &lt;/complexContent>
   * &lt;/complexType>
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
      "granuleUR",
      "dbID",
      "insertTime",
      "lastUpdate",
      "collectionMetaData",
      "dataFiles",
      "ecsDataGranule",
      "rangeDateTime",
      "spatialDomainContainer",
      "browseProduct",
      "psAs",
      "qaProduct"
  })
  public static class GranuleURMetaData {

    @XmlElement(name = "GranuleUR", required = true)
    protected String granuleUR;
    @XmlElement(name = "DbID")
    protected int dbID;
    @XmlElement(name = "InsertTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar insertTime;
    @XmlElement(name = "LastUpdate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdate;
    @XmlElement(name = "CollectionMetaData", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.CollectionMetaData collectionMetaData;
    @XmlElement(name = "DataFiles", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.DataFiles dataFiles;
    @XmlElement(name = "ECSDataGranule", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.ECSDataGranule ecsDataGranule;
    @XmlElement(name = "RangeDateTime", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.RangeDateTime rangeDateTime;
    @XmlElement(name = "SpatialDomainContainer", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer spatialDomainContainer;
    @XmlElement(name = "BrowseProduct", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.BrowseProduct browseProduct;
    @XmlElement(name = "PSAs", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.PSAs psAs;
    @XmlElement(name = "QAProduct", required = true)
    protected GranuleMetaDataFile.GranuleURMetaData.QAProduct qaProduct;

    /**
     * Ruft den Wert der granuleUR-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGranuleUR() {
      return granuleUR;
    }

    /**
     * Legt den Wert der granuleUR-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGranuleUR(String value) {
      this.granuleUR = value;
    }

    /**
     * Ruft den Wert der dbID-Eigenschaft ab.
     */
    public int getDbID() {
      return dbID;
    }

    /**
     * Legt den Wert der dbID-Eigenschaft fest.
     */
    public void setDbID(int value) {
      this.dbID = value;
    }

    /**
     * Ruft den Wert der insertTime-Eigenschaft ab.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getInsertTime() {
      return insertTime;
    }

    /**
     * Legt den Wert der insertTime-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setInsertTime(XMLGregorianCalendar value) {
      this.insertTime = value;
    }

    /**
     * Ruft den Wert der lastUpdate-Eigenschaft ab.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLastUpdate() {
      return lastUpdate;
    }

    /**
     * Legt den Wert der lastUpdate-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLastUpdate(XMLGregorianCalendar value) {
      this.lastUpdate = value;
    }

    /**
     * Ruft den Wert der collectionMetaData-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.CollectionMetaData }
     */
    public GranuleMetaDataFile.GranuleURMetaData.CollectionMetaData getCollectionMetaData() {
      return collectionMetaData;
    }

    /**
     * Legt den Wert der collectionMetaData-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.CollectionMetaData }
     */
    public void setCollectionMetaData(GranuleMetaDataFile.GranuleURMetaData.CollectionMetaData value) {
      this.collectionMetaData = value;
    }

    /**
     * Ruft den Wert der dataFiles-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.DataFiles }
     */
    public GranuleMetaDataFile.GranuleURMetaData.DataFiles getDataFiles() {
      return dataFiles;
    }

    /**
     * Legt den Wert der dataFiles-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.DataFiles }
     */
    public void setDataFiles(GranuleMetaDataFile.GranuleURMetaData.DataFiles value) {
      this.dataFiles = value;
    }

    /**
     * Ruft den Wert der ecsDataGranule-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.ECSDataGranule }
     */
    public GranuleMetaDataFile.GranuleURMetaData.ECSDataGranule getECSDataGranule() {
      return ecsDataGranule;
    }

    /**
     * Legt den Wert der ecsDataGranule-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.ECSDataGranule }
     */
    public void setECSDataGranule(GranuleMetaDataFile.GranuleURMetaData.ECSDataGranule value) {
      this.ecsDataGranule = value;
    }

    /**
     * Ruft den Wert der rangeDateTime-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.RangeDateTime }
     */
    public GranuleMetaDataFile.GranuleURMetaData.RangeDateTime getRangeDateTime() {
      return rangeDateTime;
    }

    /**
     * Legt den Wert der rangeDateTime-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.RangeDateTime }
     */
    public void setRangeDateTime(GranuleMetaDataFile.GranuleURMetaData.RangeDateTime value) {
      this.rangeDateTime = value;
    }

    /**
     * Ruft den Wert der spatialDomainContainer-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer }
     */
    public GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer getSpatialDomainContainer() {
      return spatialDomainContainer;
    }

    /**
     * Legt den Wert der spatialDomainContainer-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer }
     */
    public void setSpatialDomainContainer(GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer value) {
      this.spatialDomainContainer = value;
    }

    /**
     * Ruft den Wert der browseProduct-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.BrowseProduct }
     */
    public GranuleMetaDataFile.GranuleURMetaData.BrowseProduct getBrowseProduct() {
      return browseProduct;
    }

    /**
     * Legt den Wert der browseProduct-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.BrowseProduct }
     */
    public void setBrowseProduct(GranuleMetaDataFile.GranuleURMetaData.BrowseProduct value) {
      this.browseProduct = value;
    }

    /**
     * Ruft den Wert der psAs-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.PSAs }
     */
    public GranuleMetaDataFile.GranuleURMetaData.PSAs getPSAs() {
      return psAs;
    }

    /**
     * Legt den Wert der psAs-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.PSAs }
     */
    public void setPSAs(GranuleMetaDataFile.GranuleURMetaData.PSAs value) {
      this.psAs = value;
    }

    /**
     * Ruft den Wert der qaProduct-Eigenschaft ab.
     *
     * @return possible object is
     * {@link GranuleMetaDataFile.GranuleURMetaData.QAProduct }
     */
    public GranuleMetaDataFile.GranuleURMetaData.QAProduct getQAProduct() {
      return qaProduct;
    }

    /**
     * Legt den Wert der qaProduct-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link GranuleMetaDataFile.GranuleURMetaData.QAProduct }
     */
    public void setQAProduct(GranuleMetaDataFile.GranuleURMetaData.QAProduct value) {
      this.qaProduct = value;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BrowseGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "browseGranuleId"
    })
    public static class BrowseProduct {

      @XmlElement(name = "BrowseGranuleId", required = true)
      protected String browseGranuleId;

      /**
       * Ruft den Wert der browseGranuleId-Eigenschaft ab.
       *
       * @return possible object is
       * {@link String }
       */
      public String getBrowseGranuleId() {
        return browseGranuleId;
      }

      /**
       * Legt den Wert der browseGranuleId-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link String }
       */
      public void setBrowseGranuleId(String value) {
        this.browseGranuleId = value;
      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="VersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "shortName",
        "versionID"
    })
    public static class CollectionMetaData {

      @XmlElement(name = "ShortName", required = true)
      protected String shortName;
      @XmlElement(name = "VersionID")
      protected int versionID;

      /**
       * Ruft den Wert der shortName-Eigenschaft ab.
       *
       * @return possible object is
       * {@link String }
       */
      public String getShortName() {
        return shortName;
      }

      /**
       * Legt den Wert der shortName-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link String }
       */
      public void setShortName(String value) {
        this.shortName = value;
      }

      /**
       * Ruft den Wert der versionID-Eigenschaft ab.
       */
      public int getVersionID() {
        return versionID;
      }

      /**
       * Legt den Wert der versionID-Eigenschaft fest.
       */
      public void setVersionID(int value) {
        this.versionID = value;
      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DataFileContainer">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DistributedFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="ChecksumType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="ChecksumOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dataFileContainer"
    })
    public static class DataFiles {

      @XmlElement(name = "DataFileContainer", required = true)
      protected GranuleMetaDataFile.GranuleURMetaData.DataFiles.DataFileContainer dataFileContainer;

      /**
       * Ruft den Wert der dataFileContainer-Eigenschaft ab.
       *
       * @return possible object is
       * {@link GranuleMetaDataFile.GranuleURMetaData.DataFiles.DataFileContainer }
       */
      public GranuleMetaDataFile.GranuleURMetaData.DataFiles.DataFileContainer getDataFileContainer() {
        return dataFileContainer;
      }

      /**
       * Legt den Wert der dataFileContainer-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link GranuleMetaDataFile.GranuleURMetaData.DataFiles.DataFileContainer }
       */
      public void setDataFileContainer(GranuleMetaDataFile.GranuleURMetaData.DataFiles.DataFileContainer value) {
        this.dataFileContainer = value;
      }


      /**
       * <p>Java-Klasse f�r anonymous complex type.
       * <p/>
       * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
       * <p/>
       * <pre>
       * &lt;complexType>
       *   &lt;complexContent>
       *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
       *       &lt;sequence>
       *         &lt;element name="DistributedFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
       *         &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
       *         &lt;element name="ChecksumType" type="{http://www.w3.org/2001/XMLSchema}string"/>
       *         &lt;element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}int"/>
       *         &lt;element name="ChecksumOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
       *       &lt;/sequence>
       *     &lt;/restriction>
       *   &lt;/complexContent>
       * &lt;/complexType>
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {
          "distributedFileName",
          "fileSize",
          "checksumType",
          "checksum",
          "checksumOrigin"
      })
      public static class DataFileContainer {

        @XmlElement(name = "DistributedFileName", required = true)
        protected String distributedFileName;
        @XmlElement(name = "FileSize")
        protected int fileSize;
        @XmlElement(name = "ChecksumType", required = true)
        protected String checksumType;
        @XmlElement(name = "Checksum")
        protected int checksum;
        @XmlElement(name = "ChecksumOrigin", required = true)
        protected String checksumOrigin;

        /**
         * Ruft den Wert der distributedFileName-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDistributedFileName() {
          return distributedFileName;
        }

        /**
         * Legt den Wert der distributedFileName-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDistributedFileName(String value) {
          this.distributedFileName = value;
        }

        /**
         * Ruft den Wert der fileSize-Eigenschaft ab.
         */
        public int getFileSize() {
          return fileSize;
        }

        /**
         * Legt den Wert der fileSize-Eigenschaft fest.
         */
        public void setFileSize(int value) {
          this.fileSize = value;
        }

        /**
         * Ruft den Wert der checksumType-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        public String getChecksumType() {
          return checksumType;
        }

        /**
         * Legt den Wert der checksumType-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setChecksumType(String value) {
          this.checksumType = value;
        }

        /**
         * Ruft den Wert der checksum-Eigenschaft ab.
         */
        public int getChecksum() {
          return checksum;
        }

        /**
         * Legt den Wert der checksum-Eigenschaft fest.
         */
        public void setChecksum(int value) {
          this.checksum = value;
        }

        /**
         * Ruft den Wert der checksumOrigin-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        public String getChecksumOrigin() {
          return checksumOrigin;
        }

        /**
         * Legt den Wert der checksumOrigin-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setChecksumOrigin(String value) {
          this.checksumOrigin = value;
        }

      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SizeMBECSDataGranule" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="LocalGranuleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ProductionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="LocalVersionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sizeMBECSDataGranule",
        "localGranuleID",
        "productionDateTime",
        "localVersionID"
    })
    public static class ECSDataGranule {

      @XmlElement(name = "SizeMBECSDataGranule", required = true)
      protected BigDecimal sizeMBECSDataGranule;
      @XmlElement(name = "LocalGranuleID", required = true)
      protected String localGranuleID;
      @XmlElement(name = "ProductionDateTime", required = true)
      @XmlSchemaType(name = "dateTime")
      protected XMLGregorianCalendar productionDateTime;
      @XmlElement(name = "LocalVersionID")
      protected int localVersionID;

      /**
       * Ruft den Wert der sizeMBECSDataGranule-Eigenschaft ab.
       *
       * @return possible object is
       * {@link BigDecimal }
       */
      public BigDecimal getSizeMBECSDataGranule() {
        return sizeMBECSDataGranule;
      }

      /**
       * Legt den Wert der sizeMBECSDataGranule-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link BigDecimal }
       */
      public void setSizeMBECSDataGranule(BigDecimal value) {
        this.sizeMBECSDataGranule = value;
      }

      /**
       * Ruft den Wert der localGranuleID-Eigenschaft ab.
       *
       * @return possible object is
       * {@link String }
       */
      public String getLocalGranuleID() {
        return localGranuleID;
      }

      /**
       * Legt den Wert der localGranuleID-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link String }
       */
      public void setLocalGranuleID(String value) {
        this.localGranuleID = value;
      }

      /**
       * Ruft den Wert der productionDateTime-Eigenschaft ab.
       *
       * @return possible object is
       * {@link XMLGregorianCalendar }
       */
      public XMLGregorianCalendar getProductionDateTime() {
        return productionDateTime;
      }

      /**
       * Legt den Wert der productionDateTime-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link XMLGregorianCalendar }
       */
      public void setProductionDateTime(XMLGregorianCalendar value) {
        this.productionDateTime = value;
      }

      /**
       * Ruft den Wert der localVersionID-Eigenschaft ab.
       */
      public int getLocalVersionID() {
        return localVersionID;
      }

      /**
       * Legt den Wert der localVersionID-Eigenschaft fest.
       */
      public void setLocalVersionID(int value) {
        this.localVersionID = value;
      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PSA" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PSAName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="PSAValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "psa"
    })
    public static class PSAs {

      @XmlElement(name = "PSA", required = true)
      protected List<GranuleMetaDataFile.GranuleURMetaData.PSAs.PSA> psa;

      /**
       * Gets the value of the psa property.
       * <p/>
       * <p/>
       * This accessor method returns a reference to the live list,
       * not a snapshot. Therefore any modification you make to the
       * returned list will be present inside the JAXB object.
       * This is why there is not a <CODE>set</CODE> method for the psa property.
       * <p/>
       * <p/>
       * For example, to add a new item, do as follows:
       * <pre>
       *    getPSA().add(newItem);
       * </pre>
       * <p/>
       * <p/>
       * <p/>
       * Objects of the following type(s) are allowed in the list
       * {@link GranuleMetaDataFile.GranuleURMetaData.PSAs.PSA }
       */
      public List<GranuleMetaDataFile.GranuleURMetaData.PSAs.PSA> getPSA() {
        if (psa == null) {
          psa = new ArrayList<GranuleMetaDataFile.GranuleURMetaData.PSAs.PSA>();
        }
        return this.psa;
      }


      /**
       * <p>Java-Klasse f�r anonymous complex type.
       * <p/>
       * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
       * <p/>
       * <pre>
       * &lt;complexType>
       *   &lt;complexContent>
       *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
       *       &lt;sequence>
       *         &lt;element name="PSAName" type="{http://www.w3.org/2001/XMLSchema}string"/>
       *         &lt;element name="PSAValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
       *       &lt;/sequence>
       *     &lt;/restriction>
       *   &lt;/complexContent>
       * &lt;/complexType>
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {
          "psaName",
          "psaValue"
      })
      public static class PSA {

        @XmlElement(name = "PSAName", required = true)
        protected String psaName;
        @XmlElement(name = "PSAValue", required = true)
        protected String psaValue;

        /**
         * Ruft den Wert der psaName-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPSAName() {
          return psaName;
        }

        /**
         * Legt den Wert der psaName-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPSAName(String value) {
          this.psaName = value;
        }

        /**
         * Ruft den Wert der psaValue-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPSAValue() {
          return psaValue;
        }

        /**
         * Legt den Wert der psaValue-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPSAValue(String value) {
          this.psaValue = value;
        }

      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="QAGranuleId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "qaGranuleId"
    })
    public static class QAProduct {

      @XmlElement(name = "QAGranuleId", required = true)
      protected String qaGranuleId;

      /**
       * Ruft den Wert der qaGranuleId-Eigenschaft ab.
       *
       * @return possible object is
       * {@link String }
       */
      public String getQAGranuleId() {
        return qaGranuleId;
      }

      /**
       * Legt den Wert der qaGranuleId-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link String }
       */
      public void setQAGranuleId(String value) {
        this.qaGranuleId = value;
      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RangeEndingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="RangeEndingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="RangeBeginningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="RangeBeginningDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rangeEndingTime",
        "rangeEndingDate",
        "rangeBeginningTime",
        "rangeBeginningDate"
    })
    public static class RangeDateTime {

      @XmlElement(name = "RangeEndingTime", required = true)
      @XmlSchemaType(name = "dateTime")
      protected XMLGregorianCalendar rangeEndingTime;
      @XmlElement(name = "RangeEndingDate", required = true)
      @XmlSchemaType(name = "dateTime")
      protected XMLGregorianCalendar rangeEndingDate;
      @XmlElement(name = "RangeBeginningTime", required = true)
      @XmlSchemaType(name = "dateTime")
      protected XMLGregorianCalendar rangeBeginningTime;
      @XmlElement(name = "RangeBeginningDate", required = true)
      @XmlSchemaType(name = "dateTime")
      protected XMLGregorianCalendar rangeBeginningDate;

      /**
       * Ruft den Wert der rangeEndingTime-Eigenschaft ab.
       *
       * @return possible object is
       * {@link XMLGregorianCalendar }
       */
      public XMLGregorianCalendar getRangeEndingTime() {
        return rangeEndingTime;
      }

      /**
       * Legt den Wert der rangeEndingTime-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link XMLGregorianCalendar }
       */
      public void setRangeEndingTime(XMLGregorianCalendar value) {
        this.rangeEndingTime = value;
      }

      /**
       * Ruft den Wert der rangeEndingDate-Eigenschaft ab.
       *
       * @return possible object is
       * {@link XMLGregorianCalendar }
       */
      public XMLGregorianCalendar getRangeEndingDate() {
        return rangeEndingDate;
      }

      /**
       * Legt den Wert der rangeEndingDate-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link XMLGregorianCalendar }
       */
      public void setRangeEndingDate(XMLGregorianCalendar value) {
        this.rangeEndingDate = value;
      }

      /**
       * Ruft den Wert der rangeBeginningTime-Eigenschaft ab.
       *
       * @return possible object is
       * {@link XMLGregorianCalendar }
       */
      public XMLGregorianCalendar getRangeBeginningTime() {
        return rangeBeginningTime;
      }

      /**
       * Legt den Wert der rangeBeginningTime-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link XMLGregorianCalendar }
       */
      public void setRangeBeginningTime(XMLGregorianCalendar value) {
        this.rangeBeginningTime = value;
      }

      /**
       * Ruft den Wert der rangeBeginningDate-Eigenschaft ab.
       *
       * @return possible object is
       * {@link XMLGregorianCalendar }
       */
      public XMLGregorianCalendar getRangeBeginningDate() {
        return rangeBeginningDate;
      }

      /**
       * Legt den Wert der rangeBeginningDate-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link XMLGregorianCalendar }
       */
      public void setRangeBeginningDate(XMLGregorianCalendar value) {
        this.rangeBeginningDate = value;
      }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * <p/>
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="HorizontalSpatialDomainContainer">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="BoundingRectangle">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="WestBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="NorthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="EastBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="SouthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "horizontalSpatialDomainContainer"
    })
    public static class SpatialDomainContainer {

      @XmlElement(name = "HorizontalSpatialDomainContainer", required = true)
      protected GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer horizontalSpatialDomainContainer;

      /**
       * Ruft den Wert der horizontalSpatialDomainContainer-Eigenschaft ab.
       *
       * @return possible object is
       * {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer }
       */
      public GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer getHorizontalSpatialDomainContainer() {
        return horizontalSpatialDomainContainer;
      }

      /**
       * Legt den Wert der horizontalSpatialDomainContainer-Eigenschaft fest.
       *
       * @param value allowed object is
       *              {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer }
       */
      public void setHorizontalSpatialDomainContainer(GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer value) {
        this.horizontalSpatialDomainContainer = value;
      }


      /**
       * <p>Java-Klasse f�r anonymous complex type.
       * <p/>
       * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
       * <p/>
       * <pre>
       * &lt;complexType>
       *   &lt;complexContent>
       *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
       *       &lt;sequence>
       *         &lt;element name="BoundingRectangle">
       *           &lt;complexType>
       *             &lt;complexContent>
       *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
       *                 &lt;sequence>
       *                   &lt;element name="WestBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
       *                   &lt;element name="NorthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
       *                   &lt;element name="EastBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
       *                   &lt;element name="SouthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
       *                 &lt;/sequence>
       *               &lt;/restriction>
       *             &lt;/complexContent>
       *           &lt;/complexType>
       *         &lt;/element>
       *       &lt;/sequence>
       *     &lt;/restriction>
       *   &lt;/complexContent>
       * &lt;/complexType>
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {
          "boundingRectangle"
      })
      public static class HorizontalSpatialDomainContainer {

        @XmlElement(name = "BoundingRectangle", required = true)
        protected GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle boundingRectangle;

        /**
         * Ruft den Wert der boundingRectangle-Eigenschaft ab.
         *
         * @return possible object is
         * {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle }
         */
        public GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle getBoundingRectangle() {
          return boundingRectangle;
        }

        /**
         * Legt den Wert der boundingRectangle-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle }
         */
        public void setBoundingRectangle(GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle value) {
          this.boundingRectangle = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * <p/>
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * <p/>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="WestBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="NorthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="EastBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="SouthBoundingCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "westBoundingCoordinate",
            "northBoundingCoordinate",
            "eastBoundingCoordinate",
            "southBoundingCoordinate"
        })
        public static class BoundingRectangle {

          @XmlElement(name = "WestBoundingCoordinate", required = true)
          protected BigDecimal westBoundingCoordinate;
          @XmlElement(name = "NorthBoundingCoordinate", required = true)
          protected BigDecimal northBoundingCoordinate;
          @XmlElement(name = "EastBoundingCoordinate", required = true)
          protected BigDecimal eastBoundingCoordinate;
          @XmlElement(name = "SouthBoundingCoordinate", required = true)
          protected BigDecimal southBoundingCoordinate;

          /**
           * Ruft den Wert der westBoundingCoordinate-Eigenschaft ab.
           *
           * @return possible object is
           * {@link BigDecimal }
           */
          public BigDecimal getWestBoundingCoordinate() {
            return westBoundingCoordinate;
          }

          /**
           * Legt den Wert der westBoundingCoordinate-Eigenschaft fest.
           *
           * @param value allowed object is
           *              {@link BigDecimal }
           */
          public void setWestBoundingCoordinate(BigDecimal value) {
            this.westBoundingCoordinate = value;
          }

          /**
           * Ruft den Wert der northBoundingCoordinate-Eigenschaft ab.
           *
           * @return possible object is
           * {@link BigDecimal }
           */
          public BigDecimal getNorthBoundingCoordinate() {
            return northBoundingCoordinate;
          }

          /**
           * Legt den Wert der northBoundingCoordinate-Eigenschaft fest.
           *
           * @param value allowed object is
           *              {@link BigDecimal }
           */
          public void setNorthBoundingCoordinate(BigDecimal value) {
            this.northBoundingCoordinate = value;
          }

          /**
           * Ruft den Wert der eastBoundingCoordinate-Eigenschaft ab.
           *
           * @return possible object is
           * {@link BigDecimal }
           */
          public BigDecimal getEastBoundingCoordinate() {
            return eastBoundingCoordinate;
          }

          /**
           * Legt den Wert der eastBoundingCoordinate-Eigenschaft fest.
           *
           * @param value allowed object is
           *              {@link BigDecimal }
           */
          public void setEastBoundingCoordinate(BigDecimal value) {
            this.eastBoundingCoordinate = value;
          }

          /**
           * Ruft den Wert der southBoundingCoordinate-Eigenschaft ab.
           *
           * @return possible object is
           * {@link BigDecimal }
           */
          public BigDecimal getSouthBoundingCoordinate() {
            return southBoundingCoordinate;
          }

          /**
           * Legt den Wert der southBoundingCoordinate-Eigenschaft fest.
           *
           * @param value allowed object is
           *              {@link BigDecimal }
           */
          public void setSouthBoundingCoordinate(BigDecimal value) {
            this.southBoundingCoordinate = value;
          }

        }

      }

    }

  }

}
