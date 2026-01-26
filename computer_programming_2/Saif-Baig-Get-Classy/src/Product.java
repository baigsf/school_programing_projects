import java.util.Objects;

public class Product {
    private String prodName;
    private String prodDesc;
    private String idString;
    private double prodCost;

    /**
     * Constructor
     * @param idString Unique ID
     * @param prodName Product Name
     * @param prodDesc Description
     * @param prodCost Cost
     */
    public Product(String idString, String prodName, String prodDesc, double prodCost) {
        this.idString = idString;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCost = prodCost;
    }

    public String getProdName() { return prodName; }
    public void setProdName(String prodName) { this.prodName = prodName; }
    public String getProdDesc() { return prodDesc; }
    public void setProdDesc(String prodDesc) { this.prodDesc = prodDesc; }
    public String getIdString() { return idString; }
    public double getProdCost() { return prodCost; }
    public void setProdCost(double prodCost) { this.prodCost = prodCost; }

    /**
     * @return CSV formatted string
     */
    public String toCSV() { return idString + "," + prodName + "," + prodDesc + "," + prodCost; }

    /**
     * @return JSON formatted string
     */
    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"desc\":\"%s\",\"cost\":%.2f}", idString, prodName, prodDesc, prodCost);
    }

    /**
     * @return XML formatted string
     */
    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Desc>%s</Desc><Cost>%.2f</Cost></Product>", idString, prodName, prodDesc, prodCost);
    }

    @Override
    public String toString() { return toCSV(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.prodCost, prodCost) == 0 && idString.equals(product.idString);
    }
}