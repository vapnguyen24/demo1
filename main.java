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

// Dòng 41 gán cho cái flag = 0 để nếu nó không tăng lên
// thì không cho nó thoả điều kiện

// Dòng 44 
// s.getFullName().trim() để cắt khoảng trống đầu để tránh trường hợp nó ko nhận
// VD không nhận: [nút space*4](trên bàn phím) Nguyen Thanh Vinh [nút space*4] ==> không nhận

// s.startsWith("Nguyen ") : bắt đầu với chữ Nguyen, nếu ko dùng trim() trước đó
// thì sẽ sai

//"Nguyen ".toLowerCase(): chuyên về chữ thường để bên kia nó nhận
//" Tuan".toLowerCase()
//" My ".toLowerCase()

// Dòng 45 hoạt động tương tự 44

// Dòng 46
// s.getFullName().substring(begin, end): lấy kí tự từ vị tri bắt đầu cho tới vị trí kết thúc
// s.getFullName().substring(begin): lấy vị trí bắt đầu tới cuối luôn
// s.getFullName().indexOf(" "): vị trí bắt đầu của kí tự đó
// s.getFullName().lastIndexOf(" ") +1: vị trí kết thúc của kí tự đó
// LastIndexOf(" ") là vị trí cuối của dấu " " 
// => lastIndexOf(" ") +1 là vị trí kí tự đứng sau dấu " " đó
// VD: String s = "Nguyen Do Hanh My Huyen Tran" 
// thì indexOf là vị trí dấu cách của Nguyen Do
// con lastIndexOf là vị trí dấu cách của Huyen Tran


// Dòng 46 Không cần sài trim vì gặp cái điều kiện đầu nó failed luôn

// Dòng 48: .contains(" My ") để tìm tên lót có từ My
// Nên dùng contains(" My ") thay vì contains("My")
// vì contain là chứa chuỗi này chữ không phải tìm chuôi nãy
// nếu dùng contains vế sau thì rất có thể nó sẽ nhận Nguyen DoMy Hanh Linh
                                                    // My trong DoMy khong phai ten lot

// Còn Cách Khác để loc ra Nguyen va Tuan
// s.getFullName().substring(0, s.getFullName().indexOf(" ")).trim().equalsIgnoreCase("Nguyen");
// s.getFullName().substring(s.getFullName().lastIndexOf(" ")).trim().equalsIgnoreCase("Tuan")
// Mọi người cứ thử thay vào kiểm tra
// Vì khi lấy đầu và cuối đã trim() 2 bên rồi 
//nên lúc so sánh không cần phải đưa ("Nguyen ") hay (" Tuan") đâu
//.equalsIgnoreCase là để so sánh các chuỗi giống nhau mà không phân biệt hoa hay thường

// Dòng 51 để xuất dùng trim() để bỏ khoảng trông 2 bên,
// trim() bên trên chỉ để xét điều kiện thôi nên chuỗi chính nó vẫn còn khoảng trắng 2 bên
// rồi in hoa ====> Xong
// Chúc mn hỉu những j mk nói
