import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static ArrayList<SV> sv = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        inputStudent();
        System.out.println("Danh sach nhung sinh vien ten Tuan, ho Nguyen va ten lot My");
        BTTrongSilde();
        // showProfile();
    }

    public static void inputStudent() {
        int i = 0;
        do {
            System.out.print("Nhap ho ten sv " + (i+1) + ": ");
            String fullName = sc.nextLine();
            SV student = new SV(fullName);
            sv.add(student);
            System.out.print("Ban muon nhap tiep(Y/N): ");
            String choose = sc.nextLine();
            if(choose.equalsIgnoreCase("n"))
                break;
            
            System.out.println("");
            i++;
        } while(true);
    }

    public static void showProfile() {
        System.out.println("Danh sach sv: ");
        int i = 0;
        for (SV s : sv) {
            System.out.println((i+1) + ". " + s.getFullName().toUpperCase().trim());
            i++;
        }
    }

    public static void BTTrongSilde() {
        int flag = 0;
        int i = 0;
        for (SV s : sv) {
            if  (   s.getFullName().trim().startsWith("Nguyen ".toLowerCase()) || 
                    s.getFullName().trim().endsWith(" Tuan".toLowerCase()) || 
                    s.getFullName().substring   (   s.getFullName().indexOf(" "), 
                                                    s.getFullName().lastIndexOf(" ") + 1
                                                ).contains(" My ".toLowerCase())
                ) 
            {
                System.out.println((i + 1) + ". " + s.getFullName().trim().toUpperCase());
                flag++;
                i++;
            }
            System.out.println("");    
        }
        if(flag == 0) {
            System.out.println("Khong co ai thoa dieu kien danh sach!\n\n");
        }
    }
}

// D??ng 41 g??n cho c??i flag = 0 ????? n???u n?? kh??ng t??ng l??n
// th?? kh??ng cho n?? tho??? ??i???u ki???n

// D??ng 44 
// s.getFullName().trim() ????? c???t kho???ng tr???ng ?????u ????? tr??nh tr?????ng h???p n?? ko nh???n
// VD kh??ng nh???n: [n??t space*4](tr??n b??n ph??m) Nguyen Thanh Vinh [n??t space*4] ==> kh??ng nh???n

// s.startsWith("Nguyen ") : b???t ?????u v???i ch??? Nguyen, n???u ko d??ng trim() tr?????c ????
// th?? s??? sai

//"Nguyen ".toLowerCase(): chuy??n v??? ch??? th?????ng ????? b??n kia n?? nh???n
//" Tuan".toLowerCase()
//" My ".toLowerCase()

// D??ng 45 ho???t ?????ng t????ng t??? 44

// D??ng 46
// s.getFullName().substring(begin, end): l???y k?? t??? t??? v??? tri b???t ?????u cho t???i v??? tr?? k???t th??c
// s.getFullName().substring(begin): l???y v??? tr?? b???t ?????u t???i cu???i lu??n
// s.getFullName().indexOf(" "): v??? tr?? b???t ?????u c???a k?? t??? ????
// s.getFullName().lastIndexOf(" ") +1: v??? tr?? k???t th??c c???a k?? t??? ????
// LastIndexOf(" ") l?? v??? tr?? cu???i c???a d???u " " 
// => lastIndexOf(" ") +1 l?? v??? tr?? k?? t??? ?????ng sau d???u " " ????
// VD: String s = "Nguyen Do Hanh My Huyen Tran" 
// th?? indexOf l?? v??? tr?? d???u c??ch c???a Nguyen Do
// con lastIndexOf l?? v??? tr?? d???u c??ch c???a Huyen Tran


// D??ng 46 Kh??ng c???n s??i trim v?? g???p c??i ??i???u ki???n ?????u n?? failed lu??n

// D??ng 48: .contains(" My ") ????? t??m t??n l??t c?? t??? My
// N??n d??ng contains(" My ") thay v?? contains("My")
// v?? contain l?? ch???a chu???i n??y ch??? kh??ng ph???i t??m chu??i n??y
// n???u d??ng contains v??? sau th?? r???t c?? th??? n?? s??? nh???n Nguyen DoMy Hanh Linh
                                                    // My trong DoMy khong phai ten lot

// C??n C??ch Kh??c ????? loc ra Nguyen va Tuan
// s.getFullName().substring(0, s.getFullName().indexOf(" ")).trim().equalsIgnoreCase("Nguyen");
// s.getFullName().substring(s.getFullName().lastIndexOf(" ")).trim().equalsIgnoreCase("Tuan")
// M???i ng?????i c??? th??? thay v??o ki???m tra
// V?? khi l???y ?????u v?? cu???i ???? trim() 2 b??n r???i 
//n??n l??c so s??nh kh??ng c???n ph???i ????a ("Nguyen ") hay (" Tuan") ????u
//.equalsIgnoreCase l?? ????? so s??nh c??c chu???i gi???ng nhau m?? kh??ng ph??n bi???t hoa hay th?????ng

// D??ng 51 ????? xu???t d??ng trim() ????? b??? kho???ng tr??ng 2 b??n,
// trim() b??n tr??n ch??? ????? x??t ??i???u ki???n th??i n??n chu???i ch??nh n?? v???n c??n kho???ng tr???ng 2 b??n
// r???i in hoa ====> Xong
// Ch??c mn h???u nh???ng j mk n??i
