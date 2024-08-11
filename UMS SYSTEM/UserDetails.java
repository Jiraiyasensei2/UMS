public class UserDetails {
    private String name;
    private String address;
    private String mobileNo;

    public UserDetails(String name, String address, String mobileNo) {
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    // Getters and setters (if needed)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}