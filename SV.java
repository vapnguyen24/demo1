public class SV {
    private String fullName;
    
    public SV(String fullName) {
        this.fullName = fullName;
    }

    public SV() {

    }

    public String getFullName() {
        return fullName.toLowerCase();
        // chuyển xuống thành chữ thường để dễ so sánh với bên kia
        
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
