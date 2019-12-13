import java.io.Serializable;

/**
 * @author Cian
 * The Customer class is an instantiable class which implements the serializable interface so customer objects can be saved to a file
 *
 * */
public class Customer implements Serializable {
    /**
     *
     */
    private String name;
    private String dob;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String phone;

    /**
     *  NO ARGUMENT CONSTRUCTOR
     *  */
    Customer(){
        this.name = "Unknown";
        this.dob = "Unknown DOB";
        this.address1 = "Unknown add1";
        this.address2 = "Unknown add2";
        this.town = "Unknown town";
        this.county = "Unknown county";
        this.phone="Unknown";
    }

    /**
     * MULTIPLE ARGUMENT CONSTRUCTOR
     * @param dob
     * @param name
     */
    public Customer(String dob, String name) {
        setDob(dob);
        setName(name);
    }

    /**ACCESSOR METHOD
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**ACCESSOR METHOD
     *
     * @return dob
     */

    public String getDob() {
        return dob;
    }

    /**ACCESSOR METHOD
     *
     * @return address1
     */

    public String getAddress1() {
        return address1;
    }

    /**ACCESSOR METHOD
     *
     * @return address2
     */

    public String getAddress2() {
        return address2;
    }

    /**ACCESSOR METHOD
     *
     * @return town
     */

    public String getTown() {
        return town;
    }

    /**ACCESSOR METHOD
     *
     * @return county
     */

    public String getCounty() {
        return county;
    }

    /**ACCESSOR METHOD
     *
     * @return phone
     */

    public String getPhone() {
        return phone;
    }

    /**
     * MUTATOR METHOD
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MUTATOR METHOD
     * @param dob
     */

    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * MUTATOR METHOD
     * @param address1
     */

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * MUTATOR METHOD
     * @param address2
     */

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * MUTATOR METHOD
     * @param town
     */

    public void setTown(String town) {
        this.town = town;
    }

    /**
     * MUTATOR METHOD
     * @param county
     */

    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * MUTATOR METHOD
     * @param phone
     */

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * MULTIPLE ARGUMENT CONSTRUCTOR
     * @param name
     * @param dob
     * @param address1
     * @param address2
     * @param town
     * @param county
     * @param phone
     */
    public Customer(String name, String dob, String address1, String address2, String town, String county, String phone){
        setName(name);
        setDob(dob);
        setAddress1(address1);
        setAddress2(address2);
        setTown(town);
        setCounty(county);
        setPhone(phone);
    }

    /**
     *
     * @return toString()
     */
    public String toString() {
        return "Name of Customer: " + getName() + "\n\nDate of Birth: " + getDob() + "\n\nAddress Line 1: " + getAddress1() + "\n\nAddress Line 2: " + getAddress2() + "\n\nTown: " + getTown() + "\n\nCounty: " + getCounty() + "\n\nPhone: " + getPhone();
    }
}
